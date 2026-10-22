package y81;

import com.bytedance.android.livesdkapi.business.OnLiveDouPlusDialogListener;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes47.dex */
public final class q implements OnLiveDouPlusDialogListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f566822a;

    @Override // com.bytedance.android.livesdkapi.business.OnLiveDouPlusDialogListener
    public final void onLiveDouPlusDialogDismiss() {
        DataCenter r100 = this.f566822a.f566668f;
        if (r100 == null) goto L6;
        r100.put("data_dou_plus_dialog_showing", Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.business.OnLiveDouPlusDialogListener
    public final void onLiveDouPlusDialogShow() {
        DataCenter r100 = this.f566822a.f566668f;
        if (r100 == null) goto L6;
        r100.put("data_dou_plus_dialog_showing", Boolean.TRUE);
        return;
    }

    public q(l r100) {
        this.f566822a = r100;
    }
}
