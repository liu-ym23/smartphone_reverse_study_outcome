package eo1;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.i;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends i {
    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void h() {
        Fragment r100 = getContext().f112906q;
        if ((r100 instanceof DialogFragment) == true) goto L5;
        r100 = null;
    L5:
        DialogFragment r101 = (DialogFragment) r100;
        if (r101 == null) goto L9;
        r101.setStyle(1, R.style.ttlive_full_screen_dialog);
        r101.setCancelable(false);
        return;
    }

    public c() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void r(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setFitsSystemWindows(true);
        Fragment r102 = getContext().f112906q;
        if ((r102 instanceof DialogFragment) == true) goto L5;
        r102 = null;
    L5:
        DialogFragment r103 = (DialogFragment) r102;
        if (r103 == null) goto L13;
        Dialog r104 = r103.getDialog();
        if (r104 == null) goto L14;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L15;
        r105.setStatusBarColor(-16777216);
        return;
    L15:
        return;
    L14:
        return;
    }
}
