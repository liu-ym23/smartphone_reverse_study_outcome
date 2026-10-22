package l19;

import android.view.View;
import android.view.ViewGroup;
import com.larus.common_ui.photoviewer.transition.TransitionPhotoDraweeView;

/* JADX INFO: loaded from: classes27.dex */
public final class j {
    public static final TransitionPhotoDraweeView a(View r100) {
        if ((r100 instanceof TransitionPhotoDraweeView) == false) goto L7;
        return (TransitionPhotoDraweeView) r100;
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        TransitionPhotoDraweeView r104 = a(r101.getChildAt(r103));
        if (r104 != null) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r104;
    L14:
        return null;
    }
}
