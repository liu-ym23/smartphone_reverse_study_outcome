package com.bytedance.ee.bear.drive.view.preview.archive.view;

import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import f95.c;
import f95.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FileTreeRvView.a a;
    public final /* synthetic */ FileDirNavigationView.a b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        FileDirNavigationView.b r7 = this.b.a.c;
        if (r7 == null) goto L20;
        FileTreeRvView.a r0 = this.a;
        FileTreeRvView r8 = (FileTreeRvView) r7;
        c r1 = r8.h;
        if (r1 == null) goto L9;
        e r2 = r0.a;
        ArchivePreviewView.a r3 = ((d95.a) r1).a;
        if (ArchivePreviewView.access$700(r3.a) == null) goto L9;
        ArchivePreviewView.access$800(r3.a).liveInnerReportMsg().a(new a0(31));
    L9:
        FileDirNavigationView r4 = r8.a;
        int r5 = ((ArrayList) r4.b).indexOf(r0);
        if (r5 >= 0) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L17;
        ArrayList r10 = new ArrayList(((ArrayList) r4.b).subList(0, r5));
    L18:
        r8.c(r10, r0);
        return;
    L17:
        r10 = new ArrayList();
        goto L18
    L12:
        if (r5 >= ((ArrayList) r4.b).size()) goto L14;
        r9 = true;
        goto L15
    }

    public a(FileDirNavigationView.a r1, FileTreeRvView.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
