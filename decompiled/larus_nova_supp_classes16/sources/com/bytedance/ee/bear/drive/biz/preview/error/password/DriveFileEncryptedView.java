package com.bytedance.ee.bear.drive.biz.preview.error.password;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveFileEncryptedView extends FrameLayout {
    public SpaceEmptyState a;
    public boolean b;

    public DriveFileEncryptedView(Context r2) {
        super(r2);
        View.inflate(r2, 2131560191, this);
        SpaceEmptyState r3 = findViewById(2131372405);
        this.a = r3;
        r3.showPrimaryAction(false);
    }

    public void setOnOpenExternalClickListener(View.OnClickListener r2) {
        this.a.setPrimaryClickListener(r2);
    }

    public DriveFileEncryptedView(Context r1, AttributeSet r2) {
        super(r1, r2);
        View.inflate(r1, 2131560191, this);
        SpaceEmptyState r3 = findViewById(2131372405);
        this.a = r3;
        r3.showPrimaryAction(false);
    }
}
