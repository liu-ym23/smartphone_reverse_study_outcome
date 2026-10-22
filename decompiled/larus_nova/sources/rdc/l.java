package rdc;

import com.ss.android.lark.widget.photopickernew.PhotoPickerFrameFragment2;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f537363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoPickerFrameFragment2 f537364b;

    public final void a(String r100) {
        PhotoPickerFrameFragment2 r101 = this.f537364b;
        if (r101.f447877f.A == true) goto L6;
        return;
    L6:
        if (r101.Z90(false, this.f537363a.a(), Boolean.valueOf(this.f537363a.f537382d), Boolean.valueOf(this.f537363a.f537383e), r100, true) == false) goto L9;
        this.f537364b.X90();
        return;
    }

    public l(PhotoPickerFrameFragment2 r100, s r101) {
        this.f537364b = r100;
        this.f537363a = r101;
    }
}
