package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceTagTextView extends AppCompatTextView {
    public UDTagsDrawable.d x() {
        return null;
    }

    public SpaceTagTextView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(UDTagsDrawable.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        UDTagsDrawable.a r0 = new UDTagsDrawable.a(getContext());
        r0.a(r3);
        UDTagsDrawable r4 = r0.b();
        if (r4 == null) goto L8;
        r4.c(this);
        return;
    }

    public SpaceTagTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 2131953449);
    }

    public SpaceTagTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        y(x());
    }
}
