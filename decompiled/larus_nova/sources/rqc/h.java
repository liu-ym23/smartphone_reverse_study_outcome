package rqc;

import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropFragment f538967a;

    public h(UCropFragment r100) {
        this.f538967a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        GestureCropImageView r101 = this.f538967a.f464403l;
        AspectRatioTextView r102 = (AspectRatioTextView) ((ViewGroup) r100).getChildAt(0);
        if (r100.isSelected() == true) goto L5;
    L8:
        r101.setTargetAspectRatio(r102.f464521d);
        this.f538967a.f464403l.setImageToWrapCropBounds(true);
        if (r100.isSelected() == true) goto L18;
        Iterator r103 = ((ArrayList) this.f538967a.f464411t).iterator();
    L12:
        if (r103.hasNext() == false) goto L22;
        ViewGroup r104 = (ViewGroup) r103.next();
        if (r104 != r100) goto L16;
        boolean r105 = true;
    L17:
        r104.setSelected(r105);
        goto L12
    L16:
        r105 = false;
        goto L17
    L22:
        return;
    L18:
        return;
    L5:
        if (r102.f464521d == 0.0f) goto L7;
        float r106 = r102.f464523f;
        float r107 = r102.f464524g;
        r102.f464523f = r107;
        r102.f464524g = r106;
        r102.f464521d = r107 / r106;
    L7:
        r102.y();
        goto L8
    }
}
