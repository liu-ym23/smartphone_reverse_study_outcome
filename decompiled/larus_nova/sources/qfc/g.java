package qfc;

import android.view.View;
import com.ss.android.photoeditor.crop_rotate.ClipPhotoEditorPlugin;
import com.ss.android.photoeditor.crop_rotate.PhotoClipView;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClipPhotoEditorPlugin f532789a;

    public g(ClipPhotoEditorPlugin r100) {
        this.f532789a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PhotoClipView r101 = this.f532789a.f449164a;
        r101.getClass();
        com.ss.android.photoeditor.util.c.a(r101, new x(r101));
        r101.invalidate();
    }
}
