package rm2;

import com.bytedance.android.livesdk.microom.dialog.OChannelGrabMicShowDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OChannelGrabMicShowDialog f538532a;

    public e(OChannelGrabMicShowDialog r100) {
        this.f538532a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        int r102 = x8.a.f562881a;
        int r103 = OChannelGrabMicShowDialog.f153815d;
        x8.a.d("OChannelGrabMicShowDialog", this.f538532a.f153816a.toString(), false);
    }
}
