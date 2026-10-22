package sc5;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.util.ui.j;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ce5.a f541347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f541348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f541349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Dialog f541350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f541351e;

    public static final class a {
    }

    static {
    }

    public String a() {
        return null;
    }

    public String b() {
        return this.f541348b.getResources().getString(R.string.LarkCCM_CM_Drive_Onbd_GotIt_Mob);
    }

    public String c() {
        return this.f541348b.getResources().getString(R.string.LarkCCM_CM_Drive_Onbd_ViewNow_Mob);
    }

    public String d() {
        return this.f541348b.getResources().getString(R.string.LarkCCM_CM_Drive_Onbd_Mob);
    }

    public void e() {
        this.f541347a.f23450e.w2("/list/space/activity").j("extra_destination", NavigationEnum.MY_DRIVE.f228307id).e();
    }

    public final FragmentActivity getActivity() {
        return this.f541348b;
    }

    public final void f(View r100) {
        tt5.a.h("HomeDriveOnBoarding", "start onBoarding Mission");
        if (this.f541351e == false) goto L6;
        tt5.a.h("HomeDriveOnBoarding", "has show onBoarding in this page" + this);
        return;
    L6:
        this.f541351e = true;
        if (((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().f(this.f541349c) == false) goto L10;
        tt5.a.h("HomeDriveOnBoarding", "home drive onboarding has already shown, return");
        return;
    L10:
        j.d(new h(this, r100), 0);
    }

    public c(ce5.a r100, FragmentActivity r101) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter("mobile_space_newbie_home_drive", "key");
        this.f541347a = r100;
        this.f541348b = r101;
        this.f541349c = "mobile_space_newbie_home_drive";
    }
}
