package sc5;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.util.ui.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class c {
    public final ce5.a a;
    public final FragmentActivity b;
    public final String c;
    public Dialog d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public String a() {
        return null;
    }

    public String b() {
        return this.b.getResources().getString(2131888778);
    }

    public String c() {
        return this.b.getResources().getString(2131888780);
    }

    public String d() {
        return this.b.getResources().getString(2131888779);
    }

    public void e() {
        this.a.e.w2("/list/space/activity").j("extra_destination", NavigationEnum.MY_DRIVE.id).e();
    }

    public final FragmentActivity getActivity() {
        return this.b;
    }

    public final void f(View r5) {
        tt5.a.h("HomeDriveOnBoarding", "start onBoarding Mission");
        if (this.e == false) goto L6;
        tt5.a.h("HomeDriveOnBoarding", "has show onBoarding in this page" + this);
        return;
    L6:
        this.e = true;
        if (((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().f(this.c) == false) goto L10;
        tt5.a.h("HomeDriveOnBoarding", "home drive onboarding has already shown, return");
        return;
    L10:
        j.d(new h(this, r5), 0);
    }

    public c(ce5.a r3, FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter("mobile_space_newbie_home_drive", "key");
        this.a = r3;
        this.b = r4;
        this.c = "mobile_space_newbie_home_drive";
    }
}
