package com.google.archivepatcher.shared;

import iv7.c;
import iv7.f;
import iv7.i;
import iv7.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public final class PartiallyUncompressingPipe implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f274680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f274681b;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode COPY = null;
        public static final Mode UNCOMPRESS_NOWRAP = null;
        public static final Mode UNCOMPRESS_WRAPPED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f274682a = null;

        static {
            Mode r100 = new Mode("COPY", 0);
            COPY = r100;
            Mode r101 = new Mode("UNCOMPRESS_WRAPPED", 1);
            UNCOMPRESS_WRAPPED = r101;
            Mode r102 = new Mode("UNCOMPRESS_NOWRAP", 2);
            UNCOMPRESS_NOWRAP = r102;
            f274682a = new Mode[]{r100, r101, r102};
        }

        public static Mode[] values() {
            return (Mode[]) f274682a.clone();
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        f r100 = this.f274680a;
        i r101 = r100.f495952b;
        if (r101 == null) goto L5;
        r101.a();
        r100.f495952b = null;
    L5:
        this.f274681b.close();
    }

    public PartiallyUncompressingPipe(l r100) {
        this.f274681b = new c(r100);
        f r101 = new f();
        this.f274680a = r101;
        r101.f495953c = true;
    }

    public final void a(InputStream r100, Mode r101) throws IOException {
        c r102 = this.f274681b;
        long r103 = r102.f495948a;
        if (r101 != Mode.COPY) goto L5;
        jv7.c.a(r100, r102);
    L16:
        this.f274681b.flush();
        long r104 = this.f274681b.f495948a;
        return;
    L5:
        f r105 = this.f274680a;
        if (r101 != Mode.UNCOMPRESS_NOWRAP) goto L8;
        boolean r106 = true;
    L10:
        if (r106 == r105.f495951a) goto L15;
        i r107 = r105.f495952b;
        if (r107 == null) goto L14;
        r107.a();
        r105.f495952b = null;
    L14:
        r105.f495951a = r106;
    L15:
        this.f274680a.a(r100, this.f274681b);
        goto L16
    L8:
        r106 = false;
        goto L10
    }
}
