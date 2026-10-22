package rdc;

import com.ss.android.lark.widget.photopickernew.PhotoPickerFrameFragment2;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f537361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoPickerFrameFragment2 f537362b;

    public final void a(String r100) {
        PhotoPickerFrameFragment2 r101 = this.f537362b;
        List<t> r102 = this.f537361a.a();
        Boolean r103 = Boolean.valueOf(this.f537361a.f537382d);
        Boolean r104 = Boolean.valueOf(this.f537361a.f537383e);
        int r105 = PhotoPickerFrameFragment2.f447874h;
        if (r101.Z90(true, r102, r103, r104, r100, false) == false) goto L6;
        this.f537362b.X90();
        return;
    }

    public k(PhotoPickerFrameFragment2 r100, s r101) {
        this.f537362b = r100;
        this.f537361a = r101;
    }
}
