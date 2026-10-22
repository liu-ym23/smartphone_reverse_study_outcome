package com.bytedance.ee.drive.render;

import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f242734a = 0;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<T> f242735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f242736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f242737c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f242735a, r101.f242735a) == true) goto L12;
            return false;
        L12:
            if (this.f242736b == r101.f242736b) goto L15;
            return false;
        L15:
            if (this.f242737c == r101.f242737c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f242735a.hashCode() * 31) + this.f242736b) * 31;
            if (this.f242737c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "FilterResult(items=" + this.f242735a + ", index=" + this.f242736b + ", multiFileEnabled=" + this.f242737c + ')';
        }

        public a(ArrayList<T> r100, int r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f242735a = r100;
            this.f242736b = r101;
            this.f242737c = r102;
        }
    }

    static {
    }

    public static a a(List r100, String r110, Function1 r111, Function1 r112, Function0 r113) {
        Intrinsics.checkNotNullParameter(r100, "fileList");
        Intrinsics.checkNotNullParameter(r110, "currentToken");
        Intrinsics.checkNotNullParameter(r111, "tokenResolver");
        Intrinsics.checkNotNullParameter(r112, "categoryResolver");
        Intrinsics.checkNotNullParameter(r113, "fallbackItem");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(r111.invoke(r102), r110) == false) goto L4;
    L9:
        int r103 = 0;
        if (r102 != null) goto L13;
        tt5.a.k("DrivePreviewMediaListPolicy", "filterSupportedMediaItems, can't find current item, just add token to open");
        return new a(CollectionsKt.arrayListOf(new Object[]{r113.invoke()}), 0, false);
    L13:
        boolean r114 = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.doubao_drive_media_preview_enable", false);
        MimeTypeCategory r104 = (MimeTypeCategory) r112.invoke(r102);
        if (r104 != MimeTypeCategory.IMAGE) goto L16;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L24;
        tt5.a.h("DrivePreviewMediaListPolicy", "filterSupportedMediaItems, isMultiFile is false, category=" + r104);
        return new a(CollectionsKt.arrayListOf(new Object[]{r102}), 0, false);
    L24:
        ArrayList r106 = (ArrayList) r100;
        int r107 = Math.min(r106.size(), 1000);
        ArrayList r108 = new ArrayList();
        Iterator r109 = r106.iterator();
        int r115 = -1;
    L26:
        if (r109.hasNext() == false) goto L43;
        Object r116 = r109.next();
        MimeTypeCategory r117 = (MimeTypeCategory) r112.invoke(r116);
        if (r117 != MimeTypeCategory.IMAGE) goto L30;
    L34:
        boolean r118 = true;
    L35:
        if (r118 == false) goto L26;
        r108.add(r116);
        if (Intrinsics.areEqual(r111.invoke(r116), r110) == false) goto L41;
        r115 = r108.size() - 1;
    L41:
        if (r108.size() < r107) goto L26;
    L30:
        if (r117 != MimeTypeCategory.VIDEO) goto L33;
        if (r114 == true) goto L34;
    L33:
        r118 = false;
    L43:
        if (r108.isEmpty() == false) goto L45;
        r108.add(r102);
    L49:
        return new a(r108, r103, true);
    L45:
        if (r115 >= 0) goto L47;
        ListProtector.set(r108, CollectionsKt.getLastIndex(r108), r102);
        r103 = CollectionsKt.getLastIndex(r108);
        goto L49
    L47:
        r103 = r115;
        goto L49
    L16:
        if (r104 != MimeTypeCategory.VIDEO) goto L19;
        if (r114 == true) goto L20;
    L19:
        r105 = false;
        goto L21
    L8:
        r102 = null;
        goto L9
    }
}
