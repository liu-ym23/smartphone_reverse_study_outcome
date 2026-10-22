package com.bytedance.ee.bear.list.thumbnail;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final Set<String> a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;

    public static final class a {
        public final String a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "DriveMediaIdentity(token=" + this.a + ", type=" + this.b + ", subType=" + this.c + ')';
        }

        public final int getType() {
            return this.b;
        }

        public a(String r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r4, "subType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"photo", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE, "bmp", "gif", "ico", "jpeg", "jpg", "png", "raw", "svg", "tif", "tiff", "webp", "sketch", "heic", "heif", "3fr", "arw", "cr2", "crw", "dcr", "dcs", "dng", "dwg", "erf", "kdc", "mef", "mos", "mrw", "nef", "nrw", "orf", "pef", "raf", "rw2", "rwl", "sr2", "srf", "x3f"});
        b = SetsKt.setOf(new String[]{"video", "3gp", "3gpp", "3gpp2", "asf", "avi", "dv", "f4v", "flv", "m2t", "m4v", "mkv", "mov", "mp4", "mpe", "mpeg", "mpg", "mts", "mxf", "ogv", "rm", "rmvb", "vob", "webm", "wmv", "ts"});
        c = SetsKt.setOf(new String[]{"tar.gz", "tar.bz2", "tar.lzma"});
    }

    @JvmStatic
    public static final boolean a(Document r1) {
        Intrinsics.checkNotNullParameter(r1, "document");
        if (b(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final a b(Document r5) {
        Intrinsics.checkNotNullParameter(r5, "document");
        int r0 = r5.getType();
        sbb.e r1 = sbb.e.n;
        if (r0 != r1.b) goto L5;
        int r2 = r5.y1;
    L7:
        if (r2 == sbb.e.l.b) goto L9;
        return null;
    L9:
        String r4 = "";
        if (r5.getType() != r1.b) goto L14;
        String r3 = r5.G1;
        if (r3 == null) goto L19;
    L17:
        r4 = r3;
    L19:
        if (StringsKt.isBlank(r4) == false) goto L21;
        return null;
    L21:
        String r6 = c(r5);
        if (StringsKt.isBlank(r6) == false) goto L25;
        return null;
    L25:
        if (a.contains(r6) == true) goto L30;
        if (b.contains(r6) == true) goto L30;
        return null;
    L30:
        return new a(r4, r2, r6);
    L14:
        r3 = r5.d;
        if (r3 != null) goto L17;
    L5:
        r2 = r5.getType();
        goto L7
    }

    @JvmStatic
    public static final String c(Document r11) {
        Intrinsics.checkNotNullParameter(r11, "document");
        String r0 = r11.F;
        if (r0 == null) goto L5;
        String r1 = r0.toLowerCase(Locale.ROOT);
    L6:
        String r2 = "";
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if ((!StringsKt.isBlank(r1)) == false) goto L13;
        return r1;
    L13:
        if (r11.getType() == sbb.e.n.b) goto L15;
    L40:
        return "";
    L15:
        if (r11.y1 != sbb.e.l.b) goto L40;
        String r12 = r11.a;
        if (r12 != null) goto L20;
    L23:
        boolean r3 = true;
    L24:
        if (r3 == true) goto L39;
        Iterator<String> r4 = c.iterator();
    L28:
        if (r4.hasNext() == false) goto L32;
        String r5 = r4.next();
        if (StringsKt.endsWith$default(r12, "." + r5, false, 2, null) == false) goto L28;
        r2 = r5;
        goto L39
    L32:
        int r6 = StringsKt.lastIndexOf$default(r12, '.', 0, false, 6, null);
        if (r6 < 0) goto L39;
        if (r6 == (r12.length() - 1)) goto L39;
        r2 = r12.substring(r6 + 1);
    L39:
        return r2.toLowerCase(Locale.ROOT);
    L20:
        if (StringsKt.isBlank(r12) == true) goto L23;
        r3 = false;
        goto L24
    L5:
        r1 = null;
        goto L6
    }
}
