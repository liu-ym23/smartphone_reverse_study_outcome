package com.bytedance.ee.drive.render;

import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> {
        public final ArrayList<T> a;
        public final int b;
        public final boolean c;

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
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "FilterResult(items=" + this.a + ", index=" + this.b + ", multiFileEnabled=" + this.c + ')';
        }

        public a(ArrayList<T> r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "items");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public static a a(List r9, String r10, Function1 r11, Function1 r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r9, "fileList");
        Intrinsics.checkNotNullParameter(r10, "currentToken");
        Intrinsics.checkNotNullParameter(r11, "tokenResolver");
        Intrinsics.checkNotNullParameter(r12, "categoryResolver");
        Intrinsics.checkNotNullParameter(r13, "fallbackItem");
        Iterator r0 = r9.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(r11.invoke(r1), r10) == false) goto L4;
    L9:
        int r2 = 0;
        if (r1 != null) goto L13;
        tt5.a.k("DrivePreviewMediaListPolicy", "filterSupportedMediaItems, can't find current item, just add token to open");
        return new a(CollectionsKt.arrayListOf(new Object[]{r13.invoke()}), 0, false);
    L13:
        boolean r14 = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.doubao_drive_media_preview_enable", false);
        MimeTypeCategory r4 = (MimeTypeCategory) r12.invoke(r1);
        if (r4 != MimeTypeCategory.IMAGE) goto L16;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == true) goto L24;
        tt5.a.h("DrivePreviewMediaListPolicy", "filterSupportedMediaItems, isMultiFile is false, category=" + r4);
        return new a(CollectionsKt.arrayListOf(new Object[]{r1}), 0, false);
    L24:
        ArrayList r16 = (ArrayList) r9;
        int r3 = Math.min(r16.size(), UploadResult.UPLOAD_CACELL);
        ArrayList r6 = new ArrayList();
        Iterator r17 = r16.iterator();
        int r7 = -1;
    L26:
        if (r17.hasNext() == false) goto L43;
        Object r8 = r17.next();
        MimeTypeCategory r18 = (MimeTypeCategory) r12.invoke(r8);
        if (r18 != MimeTypeCategory.IMAGE) goto L30;
    L34:
        boolean r19 = true;
    L35:
        if (r19 == false) goto L26;
        r6.add(r8);
        if (Intrinsics.areEqual(r11.invoke(r8), r10) == false) goto L41;
        r7 = r6.size() - 1;
    L41:
        if (r6.size() < r3) goto L26;
    L30:
        if (r18 != MimeTypeCategory.VIDEO) goto L33;
        if (r14 == true) goto L34;
    L33:
        r19 = false;
    L43:
        if (r6.isEmpty() == false) goto L45;
        r6.add(r1);
    L49:
        return new a(r6, r2, true);
    L45:
        if (r7 >= 0) goto L47;
        ListProtector.set(r6, CollectionsKt.getLastIndex(r6), r1);
        r2 = CollectionsKt.getLastIndex(r6);
        goto L49
    L47:
        r2 = r7;
        goto L49
    L16:
        if (r4 != MimeTypeCategory.VIDEO) goto L19;
        if (r14 == true) goto L20;
    L19:
        r5 = false;
        goto L21
    L8:
        r1 = null;
        goto L9
    }
}
