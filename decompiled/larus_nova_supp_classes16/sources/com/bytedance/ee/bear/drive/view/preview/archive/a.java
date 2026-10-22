package com.bytedance.ee.bear.drive.view.preview.archive;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import f95.b;
import f95.d;
import java.util.ArrayList;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements b {
    public final ArchiveTree a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.archive.a$a, reason: collision with other inner class name */
    public static class C0172a extends d {
        public final ArchiveTree e;

        public C0172a(ArchiveTree r7) {
            String r1 = r7.getName();
            String r0 = com.bytedance.ee.util.io.a.c(r7.getName());
            if (r7.isDir() == false) goto L5;
            int r2 = ua5.a.i(e.f.b);
        L6:
            super(r1, r2, r7.getSize(), r7.getPath());
            this.e = r7;
            return;
        L5:
            r2 = ua5.a.h(r0);
            goto L6
        }
    }

    public a(ArchiveTree r1) {
        this.a = r1;
    }

    @Override // f95.b
    public final C0172a a(f95.e r2) {
        return new C0172a(d(this.a, r2));
    }

    @Override // f95.b
    public final int b(f95.e r2) {
        ArchiveTree r3 = d(this.a, r2);
        if (r3.getChildren() != null) goto L6;
        return 0;
    L6:
        return r3.getChildren().size();
    }

    @Override // f95.b
    public final boolean c(f95.e r2) {
        return d(this.a, r2).isDir();
    }

    public static ArchiveTree d(ArchiveTree r2, f95.e r3) {
        if (r3.a() == false) goto L5;
        return r2;
    L5:
        ArrayList r0 = new ArrayList(r3.a);
        int r4 = 1;
    L7:
        if (r4 >= r0.size()) goto L9;
        int r1 = ((Integer) ListProtector.get(r0, r4)).intValue();
        r2 = (ArchiveTree) ListProtector.get(r2.getChildren(), r1);
        r4 = r4 + 1;
        goto L7
    L9:
        return r2;
    }
}
