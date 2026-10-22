package gi5;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.DocReportPubParam;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends c0c.b implements hm5.a {
    public final /* synthetic */ hm5.a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<hm5.a> d;

    public static final class a {
    }

    static {
    }

    @Override // hm5.a
    public final ArrayList<Class<? extends XBridgeMethod>> Id() {
        return this.b.Id();
    }

    @Override // hm5.a
    public final void Sb(FragmentManager r8, Context r9, int r10, String r11, DocReportPubParam r12) {
        Intrinsics.checkNotNullParameter(r8, "fm");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "blockUrl");
        Intrinsics.checkNotNullParameter(r12, "pubParam");
        this.b.Sb(r8, r9, r10, r11, r12);
    }

    @Override // hm5.a
    public final void onDestroy() {
        this.b.onDestroy();
    }

    public final void lf(f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        tt5.a.h("LarkPermissionServiceProxy", "destroy");
        Intrinsics.checkNotNullParameter(r4, "toState");
        ((hm5.a) this.d.c()).onDestroy();
    }

    public b(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<hm5.a> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), hm5.a.class), hm5.a.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (hm5.a) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        tt5.a.h("LarkPermissionServiceProxy", "preparing");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        hm5.a r6 = (hm5.a) k.b(r4.c(r5), hm5.a.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
