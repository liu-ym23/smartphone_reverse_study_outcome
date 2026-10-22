package com.bytedance.ee.bear.clip;

import ay4.c;
import ay4.d;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f216668a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f216669b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f216670c = null;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.clip.a$a, reason: collision with other inner class name */
    public static final class C3090a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f216671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f216672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f216673c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3090a) == true) goto L8;
            return false;
        L8:
            C3090a r101 = (C3090a) r100;
            if (this.f216671a == r101.f216671a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f216672b, r101.f216672b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f216673c, r101.f216673c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f216671a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f216672b.hashCode()) * 31) + this.f216673c.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "ContentResult(success=" + this.f216671a + ", content=" + this.f216672b + ", failReason=" + this.f216673c + ')';
        }

        public C3090a(boolean r100, String r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = "";
        L8:
            Intrinsics.checkNotNullParameter(r101, "content");
            Intrinsics.checkNotNullParameter(r102, "failReason");
            this.f216671a = r100;
            this.f216672b = r101;
            this.f216673c = r102;
        }
    }

    static {
        StringBuilder r100 = new StringBuilder("jsfile");
        String r101 = File.separator;
        r100.append(r101);
        r100.append("2.0.3");
        String r102 = r100.toString();
        f216668a = r102;
        f216669b = r102 + r101 + "clip.7z";
        f216670c = r102 + r101 + "clip.js";
    }

    public static VFSFile b() {
        return d.a().v(a(null).getRealPath(), f216669b);
    }

    public static VFSFile c() {
        return d.a().v(a(null).getRealPath(), f216670c);
    }

    public static VFSFile d() {
        return d.a().v(a(null).getRealPath(), f216668a);
    }

    public static VFSFile e() {
        return d.a().v(a(null).getRealPath(), "temp");
    }

    public static VFSPath a(String r100) {
        if (r100 != null) goto L5;
        int r101 = c.f16749a;
        return c.a.f(Biz.DOCS, "clip", false, false, 12);
    L5:
        int r102 = c.f16749a;
        return c.a.g(Biz.DOCS, "clip", r100);
    }
}
