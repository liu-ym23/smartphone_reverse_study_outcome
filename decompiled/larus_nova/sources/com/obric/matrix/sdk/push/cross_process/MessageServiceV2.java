package com.obric.matrix.sdk.push.cross_process;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import jka.b;
import jka.c;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Deprecated(message = "待移除")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/MessageServiceV2;", "Lcom/obric/matrix/sdk/push/cross_process/CrossProcessService;", "Lcom/obric/matrix/sdk/push/a;", "<init>", "()V", "sdk_push_release"}, k = 1, mv = {1, 6, 0})
public abstract class MessageServiceV2 extends CrossProcessService implements com.obric.matrix.sdk.push.a {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageServiceV2 f397030a;

        public a(MessageServiceV2 r100) {
            this.f397030a = r100;
        }

        @Override // jka.b
        public final void a(String r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "originPkgName");
            if (r101 != null) goto L5;
        L21:
            kka.b.b("message service v2 args is null or size < 2");
            return;
        L5:
            if (r101.size() < 2) goto L21;
            Object r102 = ListProtector.get(r101, 0);     // Catch: Throwable -> L18
            if (r102 == null) goto L17;
            String r103 = (String) r102;     // Catch: Throwable -> L18
            Object r104 = ListProtector.get(r101, 1);     // Catch: Throwable -> L18
            if (r104 == null) goto L15;
            MessageServiceV2 r105 = this.f397030a;     // Catch: Throwable -> L18
            Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.MSGID);     // Catch: Throwable -> L18
            Intrinsics.checkNotNullParameter((String) r104, "data");     // Catch: Throwable -> L18
            r105.b();     // Catch: Throwable -> L18
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L18
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            kka.b.b("message service v2 error: " + th);
        }
    }

    @Override // com.obric.matrix.sdk.push.cross_process.CrossProcessService
    public final void c() {
        c r100 = ika.a.f490286a.a(this);
        com.obric.matrix.push.common.cross_process.CrossProcessService r101 = (com.obric.matrix.push.common.cross_process.CrossProcessService) r100;
        r101.d(new a(this));
    }

    public MessageServiceV2() {
    }
}
