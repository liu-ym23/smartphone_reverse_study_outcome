package com.bytedance.locallife.live.view;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes21.dex */
public class ShelfAppBarBehavior extends AppBarLayout.Behavior {

    public class a extends AppBarLayout.Behavior.DragCallback {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
        public final boolean canDrag(AppBarLayout r100) {
            return false;
        }

        public a() {
        }
    }

    public ShelfAppBarBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        setDragCallback(new a());
    }
}
