package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes18.dex */
public class NonDragAppBarLayoutBehavior extends AppBarLayout.Behavior {

    public class a extends AppBarLayout.Behavior.DragCallback {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
        public final boolean canDrag(AppBarLayout r100) {
            return false;
        }

        public a() {
        }
    }

    public NonDragAppBarLayoutBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        setDragCallback(new a());
    }
}
