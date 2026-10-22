package nk0;

import android.content.Context;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import lb6.b;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends b implements rb6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bc6.a f519475b;

    /* JADX INFO: renamed from: nk0.a$a, reason: collision with other inner class name */
    public static final class C6937a implements bc6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb6.a.InterfaceC7456a f519476a;

        public C6937a(rb6.a.InterfaceC7456a r100) {
            this.f519476a = r100;
        }

        @Override // bc6.b
        public final void W(long r100, OperateType r101) {
            Intrinsics.checkNotNullParameter(r101, "operationType");
            rb6.a.InterfaceC7456a r102 = this.f519476a;
            if (r102 == null) goto L6;
            r102.W(r100, r101);
            return;
        }

        @Override // bc6.b
        public final void c1(long r100, OperateType r101, BaseCheckException r102) {
            Intrinsics.checkNotNullParameter(r101, "operationType");
            Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            rb6.a.InterfaceC7456a r103 = this.f519476a;
            if (r103 == null) goto L6;
            r103.c1(r100, r101, r102);
            return;
        }
    }

    public a(fc6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "hostService");
        this.f519475b = r100.n();
    }

    @Override // rb6.a
    public final void x(Context r100, OperateType r101, int r102, rb6.a.InterfaceC7456a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "operateType");
        this.f519475b.E(r100, r101, r102, new C6937a(r103));
    }
}
