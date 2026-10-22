package rm2;

import com.bytedance.android.livesdk.microom.dialog.OChannelGrabMicShowDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f538533a = null;

    static {
        f538533a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = x8.a.f562881a;
        int r102 = OChannelGrabMicShowDialog.f153815d;
        x8.a.b("OChannelGrabMicShowDialog", "modifyGrabMicSwitchRequest " + ((Throwable) r100), false);
    }
}
