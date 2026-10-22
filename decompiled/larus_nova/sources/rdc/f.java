package rdc;

import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import com.ss.android.lark.widget.photopickernew.PhotoPickerFrameFragment2;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements odc.b<t, com.ss.android.lark.widget.photopickerimpl.view.large.e<t>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoPickerFrameFragment2 f537352a;

    @Override // odc.b
    public final int getColumnCount() {
        return this.f537352a.f447877f.f447571p;
    }

    public f(PhotoPickerFrameFragment2 r100) {
        this.f537352a = r100;
    }

    @Override // odc.b
    public final ldc.e a(int r100) {
        if (r100 != 0) goto L5;
        return new sdc.f(PhotoPickerFrameFragment2.S90(this.f537352a));
    L5:
        return new sdc.c(this.f537352a.f447877f.f447572q);
    }

    public int getType(int r100, t r101) {
        if (r101.a() == false) goto L6;
        return 0;
    L6:
        return 1;
    }

    @Override // odc.b
    public /* bridge */ /* synthetic */ int getType(int r100, Photo r101) {
        return getType(r100, (t) r101);
    }
}
