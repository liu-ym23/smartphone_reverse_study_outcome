package com.bytedance.ee.bear.bitable.jsapi.common;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f214383a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.jsapi.common.a$a, reason: collision with other inner class name */
    public static final class C3062a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f214384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f214385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f214386c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3062a) == true) goto L8;
            return false;
        L8:
            C3062a r101 = (C3062a) r100;
            if (this.f214384a == r101.f214384a) goto L12;
            return false;
        L12:
            if (this.f214385b == r101.f214385b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f214386c, r101.f214386c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f214384a * 31) + this.f214385b) * 31;
            String r101 = this.f214386c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ImageInfo(width=" + this.f214384a + ", height=" + this.f214385b + ", base64Image=" + this.f214386c + ')';
        }

        public C3062a(int r100, int r101, String r102) {
            this.f214384a = r100;
            this.f214385b = r101;
            this.f214386c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f214387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f214388b;

        public b() {
            this(0, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f214387a, r101.f214387a) == true) goto L12;
            return false;
        L12:
            if (this.f214388b == r101.f214388b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f214387a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f214388b;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "UriMetadata(name=" + this.f214387a + ", size=" + this.f214388b + ')';
        }

        public /* synthetic */ b(long r100, int r101) {
            if ((r101 & 2) == 0) goto L5;
            r100 = 0;
        L5:
            this(null, r100);
        }

        public b(String r100, long r101) {
            this.f214387a = r100;
            this.f214388b = r101;
        }
    }

    static {
    }

    public static String d(String r100) {
        if (r100 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r100)) == false) goto L6;
        return r100;
    }

    public static String c(String r100, String r101, String r102, String r103, boolean r104, Function1 r105) {
        Intrinsics.checkNotNullParameter(r105, "mimeTypeResolver");
        String[] r106 = new String[4];
        r106[0] = r100;
        r106[1] = r101;
        String r107 = d(r102);
        Object r108 = null;
        if (r107 == null) goto L5;
        String r109 = (String) r105.invoke(r107);
    L6:
        r106[2] = r109;
        String r110 = d(r103);
        if (r110 == null) goto L9;
        String r111 = (String) r105.invoke(r110);
    L10:
        r106[3] = r111;
        Iterator r112 = CollectionsKt.listOf(r106).iterator();
    L12:
        if (r112.hasNext() == false) goto L27;
        Object r113 = r112.next();
        String r114 = (String) r113;
        if (r114 != null) goto L16;
    L19:
        boolean r115 = true;
    L20:
        if (r115 == false) goto L22;
    L24:
        boolean r116 = false;
    L25:
        if (r116 == false) goto L12;
        r108 = r113;
        goto L27
    L22:
        if (Intrinsics.areEqual(r114, "*/*") == true) goto L24;
        r116 = true;
        goto L25
    L16:
        if (r114.length() == 0) goto L19;
        r115 = false;
    L27:
        String r117 = (String) r108;
        if (r117 != null) goto L32;
        if (r104 == false) goto L38;
        return "image/jpeg";
    L38:
        return "*/*";
    L32:
        return r117;
    L9:
        r111 = null;
        goto L10
    L5:
        r109 = null;
        goto L6
    }

    public static CommonAttachmentPanel.AttachmentInfo b(String r110, String r111, String r112, String r113, b r114, String r210, C3062a r211, Function1 r212, Function1 r213) {
        Intrinsics.checkNotNullParameter(r110, "attachmentId");
        Intrinsics.checkNotNullParameter(r114, "metadata");
        Intrinsics.checkNotNullParameter(r212, "fileNameResolver");
        Intrinsics.checkNotNullParameter(r213, "mimeTypeResolver");
        String r115 = d(r111);
        if (r115 != null) goto L5;
        return null;
    L5:
        String r100 = r114.f214387a;
        Intrinsics.checkNotNullParameter(r110, "attachmentId");
        Intrinsics.checkNotNullParameter(r212, "fileNameResolver");
        String r101 = d(r112);
        if (r101 == null) goto L10;
        String r102 = d((String) r212.invoke(r101));
        if (r102 != null) goto L11;
        r102 = d(StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(r101, '/', null, 2, null), '\\', null, 2, null));
    L11:
        String[] r103 = {r100, r102, r113, "attachment-" + r110};
        int r104 = 0;
    L12:
        if (r104 >= 4) goto L17;
        String r105 = d(r103[r104]);
        if (r105 != null) goto L19;
        r104 = r104 + 1;
    L19:
        if (r211 == null) goto L21;
        boolean r116 = true;
    L22:
        String r106 = c(null, r210, r105, r112, r116, r213);
        long r107 = r114.f214388b;
        if (r211 == null) goto L25;
        String r108 = r211.f214386c;
    L26:
        if (r211 == null) goto L28;
        Integer r117 = Integer.valueOf(r211.f214384a);
    L29:
        if (r211 == null) goto L31;
        Integer r118 = Integer.valueOf(r211.f214385b);
    L32:
        CommonAttachmentPanel.AttachmentInfo r119 = new CommonAttachmentPanel.AttachmentInfo(r110, r106, r107, r105, r108, r117, r118);
        r119.setUri(r115);
        r119.setPath(r112);
        return r119;
    L31:
        r118 = null;
        goto L32
    L28:
        r117 = null;
        goto L29
    L25:
        r108 = null;
        goto L26
    L21:
        r116 = false;
        goto L22
    L17:
        r105 = "";
        goto L19
    L10:
        r102 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CommonAttachmentPanel.AttachmentInfo a(String r110, String r111, String r112, long r113, int r114, int r115, C3062a r210, Function1 r211, Function1 r212, Function1 r213) {
        Intrinsics.checkNotNullParameter(r110, "attachmentId");
        Intrinsics.checkNotNullParameter(r211, "fileNameResolver");
        Intrinsics.checkNotNullParameter(r212, "fileSizeResolver");
        Intrinsics.checkNotNullParameter(r213, "mimeTypeResolver");
        String r100 = d(r111);
        Integer r116 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        boolean r101 = true;
        String[] r102 = {r211.invoke(r100), d(StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(r100, '/', null, 2, null), '\\', null, 2, null)), "attachment-" + r110};
        int r103 = 0;
    L6:
        if (r103 >= 3) goto L11;
        String r104 = d(r102[r103]);
        if (r104 != null) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        String r105 = r104;
    L13:
        if (r210 != null) goto L16;
        r101 = false;
    L16:
        String r106 = c(r112, null, r105, r100, r101, r213);
        if (r113 <= 0) goto L19;
        long r107 = r113;
    L20:
        if (r210 == null) goto L22;
        String r108 = r210.f214386c;
    L23:
        if (r210 == null) goto L25;
        Integer r109 = Integer.valueOf(r210.f214384a);
    L26:
        if (r114 <= 0) goto L28;
        r109 = Integer.valueOf(r114);
    L28:
        if (r210 == null) goto L30;
        r116 = Integer.valueOf(r210.f214385b);
    L30:
        if (r115 <= 0) goto L32;
        r116 = Integer.valueOf(r115);
    L32:
        CommonAttachmentPanel.AttachmentInfo r117 = new CommonAttachmentPanel.AttachmentInfo(r110, r106, r107, r105, r108, r109, r116);
        r117.setPath(r100);
        return r117;
    L25:
        r109 = null;
        goto L26
    L22:
        r108 = null;
        goto L23
    L19:
        r107 = ((Number) r212.invoke(r100)).longValue();
        goto L20
    L11:
        r105 = "";
        goto L13
    }
}
