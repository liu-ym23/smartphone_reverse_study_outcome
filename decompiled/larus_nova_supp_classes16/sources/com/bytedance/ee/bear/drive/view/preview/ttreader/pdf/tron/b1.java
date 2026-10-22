package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b1<T> implements Observer {
    public final /* synthetic */ TTPdfReader a;
    public final /* synthetic */ DrivePreviewAiResourceContextVM b;

    public b1(TTPdfReader r1, DrivePreviewAiResourceContextVM r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r1) {
        if (((com.bytedance.ee.bear.drive.biz.bubblemenu.d) r1) != null) goto L6;
        this.a.clearSelection();
        this.b.clearSelections();
        return;
    }
}
