package na2;

import com.bytedance.android.livesdk.interactivity.publicscreen.stylesetting.ui.PublicScreenStyleSettingDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements PublicScreenConfigSliderView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicScreenStyleSettingDialog f518436a;

    public b(PublicScreenStyleSettingDialog r100) {
        this.f518436a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void a(int r100) {
        this.f518436a.f139670t.i(d52.b.class, r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void b(float r100) {
        int r101 = this.f518436a.f139670t.d(r100);
        this.f518436a.T90(r101);
    }
}
