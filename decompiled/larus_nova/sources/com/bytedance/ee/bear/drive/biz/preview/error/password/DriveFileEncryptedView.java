package com.bytedance.ee.bear.drive.biz.preview.error.password;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class DriveFileEncryptedView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpaceEmptyState f223345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f223346b;

    public DriveFileEncryptedView(Context r100) {
        super(r100);
        View.inflate(r100, R.layout.drive_file_encrypted_layout, this);
        SpaceEmptyState r101 = (SpaceEmptyState) findViewById(R.id.file_encrypted_state);
        this.f223345a = r101;
        r101.showPrimaryAction(false);
    }

    public void setOnOpenExternalClickListener(View.OnClickListener r100) {
        this.f223345a.setPrimaryClickListener(r100);
    }

    public DriveFileEncryptedView(Context r100, AttributeSet r101) {
        super(r100, r101);
        View.inflate(r100, R.layout.drive_file_encrypted_layout, this);
        SpaceEmptyState r102 = (SpaceEmptyState) findViewById(R.id.file_encrypted_state);
        this.f223345a = r102;
        r102.showPrimaryAction(false);
    }
}
