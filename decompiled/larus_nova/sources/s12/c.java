package s12;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.format.panel.view.FormatGiftDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormatGiftDialog f540147a;

    public c(FormatGiftDialog r100) {
        this.f540147a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        FormatGiftDialog r101 = this.f540147a;
        FormatGiftDialog.S90(r101, (GiftStateMachineConfig.g) r100);
    }
}
