package sc5;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements tk5.d<vk5.a> {
    public final /* synthetic */ c a;
    public final /* synthetic */ View b;

    @Override // tk5.d
    public final String getBiz() {
        return "space";
    }

    @Override // tk5.d
    public final /* synthetic */ String getDependency() {
        return null;
    }

    @Override // tk5.d
    public final String getId() {
        return this.a.c;
    }

    @Override // tk5.d
    public final boolean b(vk5.c r6) {
        vk5.a r7 = (vk5.a) r6;
        Intrinsics.checkNotNullParameter(r7, "ui");
        tt5.a.h("HomeDriveOnBoarding", "show home drive onBoarding");
        FragmentActivity r0 = r7.getActivity();
        uk5.c r1 = new uk5.c(this.a.d(), this.b);
        String r2 = this.a.b();
        if (r2 == null) goto L5;
        r1.l = r2;
    L5:
        String r3 = this.a.c();
        if (r3 == null) goto L8;
        r1.m = r3;
    L8:
        r1.i = FlowStyleHollowShape.None;
        String r4 = this.a.a();
        if (r4 == null) goto L11;
        r1.c = r4;
    L11:
        c r5 = this.a;
        Window r8 = r0.getWindow();
        c r9 = this.a;
        r9.getClass();
        r5.d = r7.c(r8, r1, new g(r9));
        return true;
    }

    public f(c r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
