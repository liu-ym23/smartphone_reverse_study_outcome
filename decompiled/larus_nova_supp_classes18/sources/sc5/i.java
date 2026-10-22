package sc5;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        return getActivity().getResources().getString(2131889624);
    }

    @Override // sc5.c
    public final String c() {
        return getActivity().getResources().getString(2131888778);
    }

    @Override // sc5.c
    public final String d() {
        return getActivity().getResources().getString(2131889625);
    }

    public i(ce5.a r3, FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter("mobile_space_newbie_home_drive", "key");
        super(r3, r4);
    }
}
