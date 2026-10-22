package com.bytedance.ee.bear.bizwidget.deletepage;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OwnerDeleteFileView extends FrameLayout {
    public BaseTitleBar a;
    public SpaceEmptyState b;

    public class a extends t {
        public final /* synthetic */ Context c;

        public a(Context r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            Context r3 = this.c;
            if ((r3 instanceof Activity) == false) goto L6;
            ((Activity) r3).onBackPressed();
            return;
        }
    }

    public OwnerDeleteFileView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r3) {
        LayoutInflater.from(r3).inflate(2131560190, this);
        BaseTitleBar r0 = findViewById(2131388775);
        this.a = r0;
        r0.setLeftClickListener(new a(r3));
        this.b = findViewById(2131371597);
    }

    public OwnerDeleteFileView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public OwnerDeleteFileView(Context r1, AttributeSet r2, int r3) {
        super(r1);
        a(r1);
    }
}
