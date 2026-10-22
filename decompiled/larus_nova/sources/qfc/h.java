package qfc;

import android.view.View;
import com.ss.android.photoeditor.crop_rotate.ClipPhotoEditorPlugin;
import java.util.Stack;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClipPhotoEditorPlugin f532790a;

    public h(ClipPhotoEditorPlugin r100) {
        this.f532790a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (((pfc.u) this.f532790a.f449170g).f529098a.f529102d.size() != 1) goto L5;
        ((pfc.u) this.f532790a.f449170g).f529098a.f529108j.callOnClick();
        return;
    L5:
        pfc.u r101 = (pfc.u) this.f532790a.f449170g;
        Stack<Class<? extends pfc.k>> r102 = r101.f529098a.f529103e;
        r101.a(r102.get(r102.size() - 2));
    }
}
