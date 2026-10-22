package qfc;

import android.view.View;
import com.ss.android.photoeditor.crop_rotate.ClipPhotoEditorPlugin;
import com.ss.android.photoeditor.crop_rotate.PhotoClipView;
import java.util.Stack;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClipPhotoEditorPlugin f532791a;

    public i(ClipPhotoEditorPlugin r100) {
        this.f532791a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ClipPhotoEditorPlugin r101 = this.f532791a;
        pfc.f.i().a(new PhotoClipView.b(r101.f449164a.getPhotoImitationRect(), r101.f449164a.getClipImitationRect(), r101.f449164a.getTotalRotateAngle()));
        sfc.a.f541747a.getClass();
        sfc.a.f541751e = true;
        if (((pfc.u) this.f532791a.f449170g).f529098a.f529102d.size() != 1) goto L5;
        ((pfc.u) this.f532791a.f449170g).f529098a.f529109k.callOnClick();
        return;
    L5:
        pfc.u r102 = (pfc.u) this.f532791a.f449170g;
        Stack<Class<? extends pfc.k>> r103 = r102.f529098a.f529103e;
        r102.a(r103.get(r103.size() - 2));
    }
}
