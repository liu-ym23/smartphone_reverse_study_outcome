package com.bytedance.ee.bear.clip;

import ay4.c;
import ay4.d;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.clip.a$a, reason: collision with other inner class name */
    public static final class C0034a {
        public final boolean a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0034a) == true) goto L8;
            return false;
        L8:
            C0034a r6 = (C0034a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "ContentResult(success=" + this.a + ", content=" + this.b + ", failReason=" + this.c + ')';
        }

        public C0034a(boolean r3, String r4, String r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = "";
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = "";
        L8:
            Intrinsics.checkNotNullParameter(r4, "content");
            Intrinsics.checkNotNullParameter(r5, "failReason");
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }
    }

    static {
        StringBuilder r0 = new StringBuilder("jsfile");
        String r1 = File.separator;
        r0.append(r1);
        r0.append("2.0.3");
        String r2 = r0.toString();
        a = r2;
        b = r2 + r1 + "clip.7z";
        c = r2 + r1 + "clip.js";
    }

    public static VFSFile b() {
        return d.a().v(a(null).getRealPath(), b);
    }

    public static VFSFile c() {
        return d.a().v(a(null).getRealPath(), c);
    }

    public static VFSFile d() {
        return d.a().v(a(null).getRealPath(), a);
    }

    public static VFSFile e() {
        return d.a().v(a(null).getRealPath(), "temp");
    }

    public static VFSPath a(String r3) {
        if (r3 != null) goto L5;
        int r4 = c.a;
        return c.a.f(Biz.DOCS, "clip", false, false, 12);
    L5:
        int r1 = c.a;
        return c.a.g(Biz.DOCS, "clip", r3);
    }
}
