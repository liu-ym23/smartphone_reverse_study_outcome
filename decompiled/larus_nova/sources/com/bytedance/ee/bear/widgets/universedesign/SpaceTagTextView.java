package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceTagTextView extends AppCompatTextView {
    public UDTagsDrawable.d x() {
        return null;
    }

    public SpaceTagTextView(Context r100) {
        this(r100, null);
    }

    public final void y(UDTagsDrawable.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        UDTagsDrawable.a r101 = new UDTagsDrawable.a(getContext());
        r101.a(r100);
        UDTagsDrawable r102 = r101.b();
        if (r102 == null) goto L8;
        r102.c(this);
        return;
    }

    public SpaceTagTextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.style.SpaceTagTextView);
    }

    public SpaceTagTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        y(x());
    }
}
