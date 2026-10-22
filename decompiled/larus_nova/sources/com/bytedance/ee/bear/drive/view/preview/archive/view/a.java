package com.bytedance.ee.bear.drive.view.preview.archive.view;

import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import f95.c;
import f95.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileTreeRvView.a f224741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileDirNavigationView.a f224742b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FileDirNavigationView.b r101 = this.f224742b.f224713a.f224712c;
        if (r101 == null) goto L20;
        FileTreeRvView.a r102 = this.f224741a;
        FileTreeRvView r103 = (FileTreeRvView) r101;
        c r104 = r103.f224736h;
        if (r104 == null) goto L9;
        e r105 = r102.f224738a;
        ArchivePreviewView.a r106 = ((d95.a) r104).f467620a;
        if (ArchivePreviewView.access$700(r106.f224703a) == null) goto L9;
        ArchivePreviewView.access$800(r106.f224703a).liveInnerReportMsg().a(new a0(31));
    L9:
        FileDirNavigationView r107 = r103.f224729a;
        int r108 = ((ArrayList) r107.f224711b).indexOf(r102);
        if (r108 >= 0) goto L12;
    L14:
        boolean r109 = false;
    L15:
        if (r109 == false) goto L17;
        ArrayList r110 = new ArrayList(((ArrayList) r107.f224711b).subList(0, r108));
    L18:
        r103.c(r110, r102);
        return;
    L17:
        r110 = new ArrayList();
        goto L18
    L12:
        if (r108 >= ((ArrayList) r107.f224711b).size()) goto L14;
        r109 = true;
        goto L15
    }

    public a(FileDirNavigationView.a r100, FileTreeRvView.a r101) {
        this.f224742b = r100;
        this.f224741a = r101;
    }
}
