package sc5;

import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends c {
    @Override // sc5.c
    public final String b() {
        return null;
    }

    @Override // sc5.c
    public final void e() {
    }

    @Override // sc5.c
    public final String a() {
        return getActivity().getResources().getString(R.string.LarkCCM_NewCM_Onboarding_Drive_Description);
    }

    @Override // sc5.c
    public final String c() {
        return getActivity().getResources().getString(R.string.LarkCCM_CM_Drive_Onbd_GotIt_Mob);
    }

    @Override // sc5.c
    public final String d() {
        return getActivity().getResources().getString(R.string.LarkCCM_NewCM_Onboarding_Drive_Title);
    }

    public i(ce5.a r100, FragmentActivity r101) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter("mobile_space_newbie_home_drive", "key");
        super(r100, r101);
    }
}
