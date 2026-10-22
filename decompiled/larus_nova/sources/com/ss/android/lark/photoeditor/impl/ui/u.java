package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class u implements pfc.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f438630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f438631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f438632c;

    @Override // pfc.j.a
    public final void a(Bitmap r100, ArrayList<pfc.f.a> r101) {
        if (r100 != null) goto L5;
        ((PhotoEditorFragment.a) this.f438632c.f438616g).f438570a.finish();
        return;
    L5:
        if (r100 != this.f438630a) goto L7;
        this.f438632c.f438615f.F6(this.f438631b.getAbsolutePath(), this.f438630a);
        return;
    L7:
        this.f438632c.f438615f.L7(r100, r101);
    }

    public u(r r100, Bitmap r101, File r102) {
        this.f438632c = r100;
        this.f438630a = r101;
        this.f438631b = r102;
    }
}
