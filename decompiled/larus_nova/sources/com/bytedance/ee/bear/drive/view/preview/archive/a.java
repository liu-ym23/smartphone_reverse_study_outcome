package com.bytedance.ee.bear.drive.view.preview.archive;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import f95.b;
import f95.d;
import java.util.ArrayList;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArchiveTree f224708a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.archive.a$a, reason: collision with other inner class name */
    public static class C3228a extends d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArchiveTree f224709e;

        public C3228a(ArchiveTree r100) {
            String r101 = r100.getName();
            String r102 = com.bytedance.ee.util.io.a.c(r100.getName());
            if (r100.isDir() == false) goto L5;
            int r103 = ua5.a.i(e.f541295f.f541317b);
        L6:
            super(r101, r103, r100.getSize(), r100.getPath());
            this.f224709e = r100;
            return;
        L5:
            r103 = ua5.a.h(r102);
            goto L6
        }
    }

    public a(ArchiveTree r100) {
        this.f224708a = r100;
    }

    @Override // f95.b
    public final C3228a a(f95.e r100) {
        return new C3228a(d(this.f224708a, r100));
    }

    @Override // f95.b
    public final int b(f95.e r100) {
        ArchiveTree r101 = d(this.f224708a, r100);
        if (r101.getChildren() != null) goto L6;
        return 0;
    L6:
        return r101.getChildren().size();
    }

    @Override // f95.b
    public final boolean c(f95.e r100) {
        return d(this.f224708a, r100).isDir();
    }

    public static ArchiveTree d(ArchiveTree r100, f95.e r101) {
        if (r101.a() == false) goto L5;
        return r100;
    L5:
        ArrayList r102 = new ArrayList(r101.f475969a);
        int r103 = 1;
    L7:
        if (r103 >= r102.size()) goto L9;
        int r104 = ((Integer) ListProtector.get(r102, r103)).intValue();
        r100 = (ArchiveTree) ListProtector.get(r100.getChildren(), r104);
        r103 = r103 + 1;
        goto L7
    L9:
        return r100;
    }
}
