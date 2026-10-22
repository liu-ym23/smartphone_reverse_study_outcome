package x59;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.dora.impl.noti_v3.special_contacts.dialog.NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment f562551a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public c(NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment r100) {
        this.f562551a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment r101 = this.f562551a;
        int r102 = NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment.f336495g;
        r101.S90();
    }
}
