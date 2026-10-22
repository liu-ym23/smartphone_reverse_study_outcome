package com.larus.larkfeed.impl.gallery;

import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355207a = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f355207a = r100;
        }
    }

    public static final String a(kza.m r100) {
        String r101 = null;
        if (r100 == null) goto L77;
        kza.o r102 = r100.f506783g;
        if (r102 == null) goto L77;
        kza.t r103 = r102.f506796g;
        if (r103 == null) goto L77;
        kza.r r104 = r103.f506822a;
        kza.q r105 = r103.f506823b;
        if (r105 == null) goto L18;
        String r106 = r105.f506809a;
        if (r106 == null) goto L18;
        if ((!StringsKt.isBlank(r106)) == true) goto L17;
        r106 = null;
    L17:
        if (r106 == null) goto L18;
    L49:
        if (r104 == null) goto L55;
        String r107 = r104.f506816c;
        if (r107 == null) goto L55;
        if ((!StringsKt.isBlank(r107)) == false) goto L55;
    L56:
        String r108 = "";
        if (r107 != null) goto L59;
        r107 = "";
    L59:
        if (r104 == null) goto L65;
        String r109 = r104.f506815b;
        if (r109 == null) goto L65;
        if ((!StringsKt.isBlank(r109)) == false) goto L65;
    L66:
        if (r109 != null) goto L68;
        r109 = "";
    L68:
        if (r104 == null) goto L72;
        GalleryType r110 = r104.f506814a;
        if (r110 == null) goto L72;
        r101 = r110.name();
    L72:
        if (r101 == null) goto L76;
        r108 = r101;
    L76:
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{r107, r109, r108, r106}), ":", null, null, 0, null, null, 62, null);
    L65:
        r109 = null;
    L55:
        r107 = null;
    L18:
        if (r105 == null) goto L26;
        String r111 = r105.f506810b;
        if (r111 == null) goto L26;
        if ((!StringsKt.isBlank(r111)) == true) goto L25;
        r111 = null;
    L25:
        r106 = r111;
    L27:
        if (r106 != null) goto L49;
        if (r104 == null) goto L36;
        String r112 = r104.f506817d;
        if (r112 == null) goto L36;
        if ((!StringsKt.isBlank(r112)) == true) goto L35;
        r112 = null;
    L35:
        r106 = r112;
    L37:
        if (r106 != null) goto L49;
        if (r104 == null) goto L46;
        String r113 = r104.f506818e;
        if (r113 == null) goto L46;
        if ((!StringsKt.isBlank(r113)) == true) goto L45;
        r113 = null;
    L45:
        r106 = r113;
    L47:
        if (r106 != null) goto L49;
        return null;
    L46:
        r106 = null;
    L36:
        r106 = null;
    L26:
        r106 = null;
    L77:
        return null;
    }

    public static final String b(kza.m r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f355207a[r100.getType().ordinal()];
        String r102 = null;
        if (r101 == 1) goto L15;
        if (r101 != 2) goto L14;
        kza.p r103 = r100.f506779c;
        if (r103 == null) goto L11;
        String r104 = r103.f506798b;
        if (r104 == null) goto L11;
    L10:
        r102 = r104;
    L24:
        if (r102 != null) goto L27;
        r102 = "";
    L27:
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{r100.getType().name(), r100.f506781e.name(), r100.f506780d, r102}), ":", null, null, 0, null, null, 62, null);
    L11:
        if (r103 == null) goto L24;
        r102 = r103.f506804h;
        goto L24
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        kza.l r105 = r100.f506778b;
        if (r105 == null) goto L20;
        r104 = r105.f506771c;
        if (r104 != null) goto L10;
    L20:
        if (r105 == null) goto L24;
        String r106 = r105.f506772d;
        if (r106 == null) goto L24;
        r102 = r106;
        goto L24
    }
}
