package com.bytedance.ee.bear.list.thumbnail;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f229783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f229784b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f229785c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f229786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f229787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f229788c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f229786a, r101.f229786a) == true) goto L12;
            return false;
        L12:
            if (this.f229787b == r101.f229787b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f229788c, r101.f229788c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f229786a.hashCode() * 31) + this.f229787b) * 31) + this.f229788c.hashCode();
        }

        public final String toString() {
            return "DriveMediaIdentity(token=" + this.f229786a + ", type=" + this.f229787b + ", subType=" + this.f229788c + ')';
        }

        public final int getType() {
            return this.f229787b;
        }

        public a(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r102, "subType");
            this.f229786a = r100;
            this.f229787b = r101;
            this.f229788c = r102;
        }
    }

    static {
        f229783a = SetsKt.setOf(new String[]{"photo", "image", "bmp", "gif", "ico", LoadParams.ImageFormat.JPEG, "jpg", LoadParams.ImageFormat.PNG, TemplateNodeType.RAW, "svg", "tif", "tiff", "webp", "sketch", "heic", "heif", "3fr", "arw", "cr2", "crw", "dcr", "dcs", "dng", "dwg", "erf", "kdc", "mef", "mos", "mrw", "nef", "nrw", "orf", "pef", "raf", "rw2", "rwl", "sr2", "srf", "x3f"});
        f229784b = SetsKt.setOf(new String[]{"video", "3gp", "3gpp", "3gpp2", "asf", "avi", "dv", "f4v", "flv", "m2t", "m4v", "mkv", "mov", "mp4", "mpe", "mpeg", "mpg", "mts", "mxf", "ogv", "rm", "rmvb", "vob", "webm", "wmv", "ts"});
        f229785c = SetsKt.setOf(new String[]{"tar.gz", "tar.bz2", "tar.lzma"});
    }

    @JvmStatic
    public static final boolean a(Document r100) {
        Intrinsics.checkNotNullParameter(r100, "document");
        if (b(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final a b(Document r100) {
        Intrinsics.checkNotNullParameter(r100, "document");
        int r101 = r100.getType();
        sbb.e r102 = sbb.e.f541303n;
        if (r101 != r102.f541317b) goto L5;
        int r103 = r100.f227908y1;
    L7:
        if (r103 == sbb.e.f541301l.f541317b) goto L9;
        return null;
    L9:
        String r104 = "";
        if (r100.getType() != r102.f541317b) goto L14;
        String r105 = r100.G1;
        if (r105 == null) goto L19;
    L17:
        r104 = r105;
    L19:
        if (StringsKt.isBlank(r104) == false) goto L21;
        return null;
    L21:
        String r106 = c(r100);
        if (StringsKt.isBlank(r106) == false) goto L25;
        return null;
    L25:
        if (f229783a.contains(r106) == true) goto L30;
        if (f229784b.contains(r106) == true) goto L30;
        return null;
    L30:
        return new a(r104, r103, r106);
    L14:
        r105 = r100.f227873d;
        if (r105 != null) goto L17;
    L5:
        r103 = r100.getType();
        goto L7
    }

    @JvmStatic
    public static final String c(Document r110) {
        Intrinsics.checkNotNullParameter(r110, "document");
        String r100 = r110.F;
        if (r100 == null) goto L5;
        String r101 = r100.toLowerCase(Locale.ROOT);
    L6:
        String r102 = "";
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        if ((!StringsKt.isBlank(r101)) == false) goto L13;
        return r101;
    L13:
        if (r110.getType() == sbb.e.f541303n.f541317b) goto L15;
    L40:
        return "";
    L15:
        if (r110.f227908y1 != sbb.e.f541301l.f541317b) goto L40;
        String r111 = r110.f227868a;
        if (r111 != null) goto L20;
    L23:
        boolean r103 = true;
    L24:
        if (r103 == true) goto L39;
        Iterator<String> r104 = f229785c.iterator();
    L28:
        if (r104.hasNext() == false) goto L32;
        String r105 = r104.next();
        if (StringsKt.endsWith$default(r111, "." + r105, false, 2, null) == false) goto L28;
        r102 = r105;
        goto L39
    L32:
        int r106 = StringsKt.lastIndexOf$default(r111, '.', 0, false, 6, null);
        if (r106 < 0) goto L39;
        if (r106 == (r111.length() - 1)) goto L39;
        r102 = r111.substring(r106 + 1);
    L39:
        return r102.toLowerCase(Locale.ROOT);
    L20:
        if (StringsKt.isBlank(r111) == true) goto L23;
        r103 = false;
        goto L24
    L5:
        r101 = null;
        goto L6
    }
}
