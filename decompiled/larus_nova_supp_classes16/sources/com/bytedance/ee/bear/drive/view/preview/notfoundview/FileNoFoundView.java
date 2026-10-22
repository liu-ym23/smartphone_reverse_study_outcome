package com.bytedance.ee.bear.drive.view.preview.notfoundview;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileNoFoundView extends SpaceEmptyState {
    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        setImageRes(2131232542);
        setImageSizeResource(2131165486);
        setDesc(getContext().getString(2131888383));
        setBackgroundColor(getResources().getColor(2131100548));
    }

    public FileNoFoundView(Context r1) {
        super(r1);
        a();
    }

    public FileNoFoundView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public FileNoFoundView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
