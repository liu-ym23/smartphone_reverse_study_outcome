package smb;

import androidx.autofill.HintConstants;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements dza.a {
    public c() {
    }

    @Override // dza.a
    public final void r1(String r100, FragmentManager r101) {
        Intrinsics.checkNotNullParameter(r100, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Log.e("FlowPhoneNumberDependencyModule", "no FlowPhoneNumberDependency impl");
    }
}
