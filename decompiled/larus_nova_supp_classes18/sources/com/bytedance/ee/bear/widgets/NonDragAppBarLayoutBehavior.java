package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NonDragAppBarLayoutBehavior extends AppBarLayout.Behavior {

    public class a extends AppBarLayout.Behavior.DragCallback {
        public final boolean canDrag(AppBarLayout r1) {
            return false;
        }

        public a() {
        }
    }

    public NonDragAppBarLayoutBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        setDragCallback(new a());
    }
}
