package h88;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484294e;

    public f() {
        this.f484294e = "TakePhotoButtonState";
    }

    @Override // h88.d
    public String getType() {
        return this.f484294e;
    }

    @Override // h88.d
    public final void d(boolean r100) {
        AppCompatImageView r101 = null;
        if (r100 == false) goto L9;
        View r102 = this.f484289a;
        if ((r102 instanceof AppCompatImageView) == false) goto L7;
        r101 = (AppCompatImageView) r102;
    L7:
        if (r101 == null) goto L27;
        r101.setImageResource(R.drawable.larus_realtime_camera_dark);
        return;
    L27:
        return;
    L9:
        IRealtimeCallConfigDependency r103 = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        if (r103 == null) goto L14;
        boolean r104 = true;
        if (r103.enableAudioBgSimpleColor() != true) goto L14;
    L15:
        if (r104 == false) goto L21;
        View r105 = this.f484289a;
        if ((r105 instanceof AppCompatImageView) == false) goto L19;
        r101 = (AppCompatImageView) r105;
    L19:
        if (r101 == null) goto L29;
        r101.setImageResource(R.drawable.larus_realtime_camera_white_bg);
        return;
    L29:
        return;
    L21:
        View r106 = this.f484289a;
        if ((r106 instanceof AppCompatImageView) == false) goto L24;
        r101 = (AppCompatImageView) r106;
    L24:
        if (r101 == null) goto L31;
        r101.setImageResource(R.drawable.larus_realtime_camera);
        return;
    L31:
        return;
    L14:
        r104 = false;
        goto L15
    }
}
