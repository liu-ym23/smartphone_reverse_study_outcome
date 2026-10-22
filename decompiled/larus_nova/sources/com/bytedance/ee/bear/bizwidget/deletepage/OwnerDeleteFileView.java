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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class OwnerDeleteFileView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseTitleBar f216372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpaceEmptyState f216373b;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f216374c;

        public a(Context r100) {
            this.f216374c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Context r101 = this.f216374c;
            if ((r101 instanceof Activity) == false) goto L6;
            ((Activity) r101).onBackPressed();
            return;
        }
    }

    public OwnerDeleteFileView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.drive_file_delete_by_owner_view, this);
        BaseTitleBar r101 = (BaseTitleBar) findViewById(R.id.titleBar);
        this.f216372a = r101;
        r101.setLeftClickListener(new a(r100));
        this.f216373b = (SpaceEmptyState) findViewById(R.id.empty_state);
    }

    public OwnerDeleteFileView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public OwnerDeleteFileView(Context r100, AttributeSet r101, int r102) {
        super(r100);
        a(r100);
    }
}
