package com.bytedance.android.shopping.yata.frontier;

import cl.d;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.protocol.data.c;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Completable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@GenProtoDecoders
public final class YataFrontierManager {
    public static final Map<String, YataFrontierManager> d = null;
    public final Lazy a;
    public volatile ConnectionState b;
    public final com.bytedance.android.shopping.yata.frontier.a c;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/yata/frontier/YataFrontierManager$b;", "", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "content", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "a", "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("content")
        private final c content;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.content, ((b) r2).content) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            c r0 = this.content;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "LongLinkProtocolData(content=" + this.content + ")";
        }

        public b() {
            this.content = null;
        }

        public final c a() {
            return this.content;
        }
    }

    static {
        d = new LinkedHashMap();
    }

    public final void b() {
        if (this.b != ConnectionState.CONNECTING) goto L5;
    L9:
        String r0 = YaTaLog.a;
        YaTaLog.c("YataFrontierManager", new YataFrontierManager$connect$1(this));
        return;
    L5:
        if (this.b == ConnectionState.CONNECTED) goto L9;
        com.bytedance.android.ec.core.async.a.b(Completable.fromAction(new YataFrontierManager$createConnectAction$1(this)).subscribe());
    }

    public YataFrontierManager(com.bytedance.android.shopping.yata.frontier.a r2) {
        Intrinsics.checkNotNullParameter(r2, "wsInfo");
        this.c = r2;
        this.a = LazyKt.lazy(YataFrontierManager$yataMessageDispatcher$2.INSTANCE);
    }

    public static final void a(YataFrontierManager r1, ConnectionState r2) {
        r1.getClass();
        if (r2 != ConnectionState.CONNECTED) goto L7;
        d r0 = k.a();
        if (r0 == null) goto L10;
        r0.b();
    L10:
        r1.b = r2;
        return;
    L7:
        d r3 = k.a();
        if (r3 == null) goto L10;
        r3.b();
        goto L10
    }
}
