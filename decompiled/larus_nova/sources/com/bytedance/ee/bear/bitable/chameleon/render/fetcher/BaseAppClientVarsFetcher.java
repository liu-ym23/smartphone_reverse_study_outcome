package com.bytedance.ee.bear.bitable.chameleon.render.fetcher;

import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class BaseAppClientVarsFetcher extends com.bytedance.ee.bear.bitable.chameleon.render.a<Payload, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f209739c;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/chameleon/render/fetcher/BaseAppClientVarsFetcher$Payload;", "Lcom/bytedance/ee/util/io/NonProguard;", "data", "Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableAppData;", "message", "Lcom/bytedance/ee/bear/bitable/chameleon/render/fetcher/BaseAppClientVarsFetcher$Message;", "error", "", "<init>", "(Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableAppData;Lcom/bytedance/ee/bear/bitable/chameleon/render/fetcher/BaseAppClientVarsFetcher$Message;Ljava/lang/Throwable;)V", "getData", "()Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableAppData;", "getMessage", "()Lcom/bytedance/ee/bear/bitable/chameleon/render/fetcher/BaseAppClientVarsFetcher$Message;", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Payload implements NonProguard {
        private final BitableAppData data;
        private final Throwable error;
        private final b message;

        public static /* synthetic */ Payload copy$default(Payload r100, BitableAppData r101, b r102, Throwable r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.message;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.error;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final BitableAppData component1() {
            return this.data;
        }

        public final b component2() {
            return this.message;
        }

        public final Throwable component3() {
            return this.error;
        }

        public final Payload copy(BitableAppData r100, b r101, Throwable r102) {
            return new Payload(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Payload) == true) goto L8;
            return false;
        L8:
            Payload r101 = (Payload) r100;
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.error, r101.error) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            BitableAppData r100 = this.data;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            b r104 = this.message;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Throwable r107 = this.error;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Payload(data=" + this.data + ", message=" + this.message + ", error=" + this.error + ')';
        }

        public final BitableAppData getData() {
            return this.data;
        }

        public final Throwable getError() {
            return this.error;
        }

        public final b getMessage() {
            return this.message;
        }

        public Payload(BitableAppData r100, b r101, Throwable r102) {
            this.data = r100;
            this.message = r101;
            this.error = r102;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f209740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f209741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f209742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f209743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f209744e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f209745f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f209746g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f209740a == r101.f209740a) goto L12;
            return false;
        L12:
            if (this.f209741b == r101.f209741b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f209742c, r101.f209742c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f209743d, r101.f209743d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f209744e, r101.f209744e) == true) goto L24;
            return false;
        L24:
            if (this.f209745f == r101.f209745f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f209746g, r101.f209746g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f209740a;
            int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f209741b) * 31) + this.f209742c.hashCode()) * 31) + this.f209743d.hashCode()) * 31) + this.f209744e.hashCode()) * 31;
            long r102 = this.f209745f;
            return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f209746g.hashCode();
        }

        public final String toString() {
            return "Message(requestStart=" + this.f209740a + ", apiCode=" + this.f209741b + ", errorMsg=" + this.f209742c + ", xttLogId=" + this.f209743d + ", source=" + this.f209744e + ", cacheElapsedTime=" + this.f209745f + ", preloadQueryResult=" + this.f209746g + ')';
        }

        public b(long r100, int r101, String r102, String r103, String r104, long r105, String r110) {
            Intrinsics.checkNotNullParameter(r102, "errorMsg");
            Intrinsics.checkNotNullParameter(r103, "xttLogId");
            Intrinsics.checkNotNullParameter(r104, "source");
            Intrinsics.checkNotNullParameter(r110, "preloadQueryResult");
            this.f209740a = r100;
            this.f209741b = r101;
            this.f209742c = r102;
            this.f209743d = r103;
            this.f209744e = r104;
            this.f209745f = r105;
            this.f209746g = r110;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f209747a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f209747a, ((c) r100).f209747a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f209747a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Request(token=" + this.f209747a + ')';
        }

        public c(String r100) {
            this.f209747a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final String c() {
        return "biz.bitable.app.getClientVars";
    }

    public BaseAppClientVarsFetcher() {
        this.f209739c = "";
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final boolean b(DocumentLoaderV3 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (com.bytedance.ee.bear.bitable.c.e() == false) goto L7;
        com.bytedance.ee.bear.bitable.chameleon.i r101 = com.bytedance.ee.bear.bitable.chameleon.i.f209652a;
        ChameleonPluginHost r102 = r100.f221315d;
        r101.getClass();
        if (com.bytedance.ee.bear.bitable.chameleon.i.a(r102) != BitableSubType.BaseApp) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final c e(JSONObject r100) {
        if (r100 == null) goto L5;
        String r101 = r100.optString("token");
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        return new c(r101);
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final Disposable g(DocumentLoaderV3 r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onResult");
        y3 r102 = (y3) r100.f221315d.getHostAbility(y3.class);
        String r103 = r102.getBearUrl().f222561b;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        boolean r104 = false;
        if (r103.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        r103 = r102.getToken();
    L11:
        this.f209739c = r103;
        if (r103.length() != 0) goto L14;
        r104 = true;
    L14:
        if (r104 == false) goto L17;
        r101.invoke(new com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a(new Payload(null, null, new IllegalStateException("Token is empty")), null));
        return Disposables.empty();
    L17:
        long r106 = System.currentTimeMillis();
        tt5.a.h("AppClientVarsFetcher", "startFetch");
        return Single.fromCallable(new jr4.a(this)).subscribeOn(fo5.d.c()).timeout(150, TimeUnit.MILLISECONDS).subscribe(new com.bytedance.ee.bear.bitable.chameleon.render.fetcher.c(r101, this, r106), new d(r101, this, r106));
    L8:
        r105 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bitable.chameleon.render.a
    public final void a(com.bytedance.ee.bear.document.render.node.e r100, com.bytedance.ee.bear.bitable.chameleon.render.a.C3020a<Payload> r101, List<com.bytedance.ee.bear.bitable.chameleon.render.a.b<c>> r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r110, "callbacks");
        Iterator<T> r102 = r110.iterator();
    L4:
        if (r102.hasNext() == false) goto L30;
        com.bytedance.ee.bear.bitable.chameleon.render.a.b r111 = (com.bytedance.ee.bear.bitable.chameleon.render.a.b) r102.next();
        Payload r103 = r101.f209673a;
        Throwable r104 = r101.f209674b;
        if (r104 != null) goto L10;
        if (r103 == null) goto L9;
        r104 = r103.getError();
        goto L10
    L9:
        r104 = null;
    L10:
        if (r103 == null) goto L12;
        BitableAppData r105 = r103.getData();
    L14:
        if (r105 == null) goto L19;
        if (r104 != null) goto L19;
        if (Intrinsics.areEqual(((c) r111.f209675a).f209747a, r105.getToken()) == true) goto L19;
        String r106 = e.a(r103.getMessage(), "Token not match", false);
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, r106, null), r111.f209676b);
    L19:
        if (r105 == null) goto L22;
        if (r104 != null) goto L22;
        String r107 = e.a(r103.getMessage(), null, true);
        String r108 = r105.getDataJSON();
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(true, false, r107, r108), r111.f209676b);
    L22:
        if (r103 == null) goto L24;
        b r109 = r103.getMessage();
    L25:
        if (r104 == null) goto L28;
        String r112 = r104.getMessage();
        if (r112 == null) goto L28;
    L29:
        String r113 = e.a(r109, r112, false);
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(false, false, r113, null), r111.f209676b);
    L28:
        r112 = "No cached data available";
        goto L29
    L24:
        r109 = null;
        goto L25
    L12:
        r105 = null;
        goto L14
    }
}
