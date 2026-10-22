package com.google.common.base;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.common.base.b f274727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f274728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f274729c;

    public static abstract class a extends AbstractIterator<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f274730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.google.common.base.b f274731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f274732e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f274733f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f274734g;

        public abstract int b(int r100);

        public abstract int c(int r100);

        @Override // com.google.common.base.AbstractIterator
        @CheckForNull
        public final String a() {
            int r100 = this.f274733f;
        L3:
            int r101 = this.f274733f;
            if (r101 == (-1)) goto L35;
            int r102 = c(r101);
            if (r102 != (-1)) goto L8;
            r102 = this.f274730c.length();
            this.f274733f = -1;
        L9:
            int r103 = this.f274733f;
            if (r103 == r100) goto L11;
        L14:
            if (r100 >= r102) goto L18;
            if (this.f274731d.c(this.f274730c.charAt(r100)) == false) goto L18;
            r100 = r100 + 1;
        L18:
            if (r102 <= r100) goto L23;
            int r104 = r102 - 1;
            if (this.f274731d.c(this.f274730c.charAt(r104)) == false) goto L23;
            r102 = r104;
        L23:
            if (this.f274732e == false) goto L26;
            if (r100 != r102) goto L26;
            r100 = this.f274733f;
        L26:
            int r105 = this.f274734g;
            if (r105 != 1) goto L33;
            r102 = this.f274730c.length();
            this.f274733f = -1;
        L29:
            if (r102 <= r100) goto L54;
            int r106 = r102 - 1;
            if (this.f274731d.c(this.f274730c.charAt(r106)) == false) goto L54;
            r102 = r106;
        L54:
            return this.f274730c.subSequence(r100, r102).toString();
        L33:
            this.f274734g = r105 - 1;
            goto L54
        L11:
            int r107 = r103 + 1;
            this.f274733f = r107;
            if (r107 <= this.f274730c.length()) goto L3;
            this.f274733f = -1;
            goto L3
        L8:
            this.f274733f = b(r102);
            goto L9
        L35:
            this.f274686a = AbstractIterator.State.DONE;
            return null;
        }

        public a(q r100, CharSequence r101) {
            this.f274733f = 0;
            this.f274731d = r100.f274727a;
            this.f274732e = false;
            this.f274734g = r100.f274729c;
            this.f274730c = r101;
        }
    }

    public interface b {
        Iterator<String> a(q r100, CharSequence r101);
    }

    public q(b r100) {
        com.google.common.base.b.f r101 = com.google.common.base.b.f.f274713b;
        this.f274728b = r100;
        this.f274727a = r101;
        this.f274729c = Integer.MAX_VALUE;
    }
}
