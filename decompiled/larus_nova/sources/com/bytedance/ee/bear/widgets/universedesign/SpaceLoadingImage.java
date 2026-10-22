package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceLoadingImage extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UDLoadingDrawable f240350a;

    public final void stop() {
        UDLoadingDrawable r100 = this.f240350a;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public SpaceLoadingImage(Context r100) {
        this(r100, null);
    }

    public void setColorSchemeColors(int... r100) {
        this.f240350a.setColorSchemeColors(r100);
    }

    public SpaceLoadingImage(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SpaceLoadingImage(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240350a = new UDLoadingDrawable(r100);
        int r103 = R.color.ud_N400;
        if (r101 == null) goto L5;
        r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.loading_circle_color}, 0, 0).getResourceId(0, R.color.ud_N400);
    L5:
        this.f240350a.setColorSchemeColors(new int[]{UDColorUtils.getColor(r100, r103)});
        setImageDrawable(this.f240350a);
        this.f240350a.start();
    }
}
