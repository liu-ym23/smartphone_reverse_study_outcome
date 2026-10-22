package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;

/* JADX INFO: loaded from: classes16.dex */
public final class b1<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTPdfReader f225327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DrivePreviewAiResourceContextVM f225328b;

    public b1(TTPdfReader r100, DrivePreviewAiResourceContextVM r101) {
        this.f225327a = r100;
        this.f225328b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((com.bytedance.ee.bear.drive.biz.bubblemenu.d) r100) != null) goto L6;
        this.f225327a.clearSelection();
        this.f225328b.clearSelections();
        return;
    }
}
