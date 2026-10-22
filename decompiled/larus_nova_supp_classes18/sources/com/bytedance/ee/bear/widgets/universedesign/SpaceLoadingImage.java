package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceLoadingImage extends AppCompatImageView {
    public UDLoadingDrawable a;

    public final void stop() {
        UDLoadingDrawable r0 = this.a;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public SpaceLoadingImage(Context r2) {
        this(r2, null);
    }

    public void setColorSchemeColors(int... r2) {
        this.a.setColorSchemeColors(r2);
    }

    public SpaceLoadingImage(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SpaceLoadingImage(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.a = new UDLoadingDrawable(r5);
        int r1 = 2131108721;
        if (r6 == null) goto L5;
        r1 = r5.obtainStyledAttributes(r6, new int[]{2130972599}, 0, 0).getResourceId(0, 2131108721);
    L5:
        this.a.setColorSchemeColors(new int[]{UDColorUtils.getColor(r5, r1)});
        setImageDrawable(this.a);
        this.a.start();
    }
}
