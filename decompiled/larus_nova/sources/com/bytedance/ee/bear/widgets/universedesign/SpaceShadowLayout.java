package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import java.util.Arrays;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceShadowLayout extends UDShadowLayout {
    public SpaceShadowLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void childDrawableStateChanged(View r100) {
        super.childDrawableStateChanged(r100);
        a.b("SpaceShadowLayout", "childDrawableStateChanged: " + Arrays.toString(r100.getDrawableState()));
    }

    public SpaceShadowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SpaceShadowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, R.style.SpaceShadowLayoutStyle);
    }
}
