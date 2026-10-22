package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import java.util.Arrays;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceShadowLayout extends UDShadowLayout {
    public SpaceShadowLayout(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void childDrawableStateChanged(View r3) {
        super/*android.view.ViewGroup*/.childDrawableStateChanged(r3);
        a.b("SpaceShadowLayout", "childDrawableStateChanged: " + Arrays.toString(r3.getDrawableState()));
    }

    public SpaceShadowLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SpaceShadowLayout(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4, 2131953448);
    }
}
