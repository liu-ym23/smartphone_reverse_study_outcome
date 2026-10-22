package com.bytedance.ee.android.file.picker.lib.v2.ui;

import android.view.View;
import com.bytedance.ee.android.file.picker.lib.databinding.FilePickerMainActivityBinding;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes15.dex */
public final class l extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilePickerMainActivityBinding f206107a;

    public l(FilePickerMainActivityBinding r100) {
        this.f206107a = r100;
        super(500);
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        this.f206107a.f205993c.S5();
    }
}
