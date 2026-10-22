package com.larus.bmhome.bigimg;

import android.content.Context;
import android.view.View;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.search.api.event.HybridEventParams;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {
    public static final View a(List<? extends Pair<Integer, ? extends View>> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "imageViews");
        List<? extends Pair<Integer, ? extends View>> r102 = r100;
        Iterator<T> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((Number) ((Pair) r104).getFirst()).intValue() != r101) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
    L12:
        Pair r106 = (Pair) r104;
        if (r106 == null) goto L15;
        View r107 = (View) r106.getSecond();
    L16:
        if (r107 == null) goto L18;
        return r107;
    L18:
        Iterator<T> r108 = r102.iterator();
        if (r108.hasNext() == true) goto L21;
        Object r109 = null;
    L30:
        Pair r110 = (Pair) r109;
        Iterator<T> r111 = r102.iterator();
        if (r111.hasNext() == true) goto L33;
        Object r112 = null;
    L42:
        Pair r113 = (Pair) r112;
        if (r110 == null) goto L51;
        if (r113 == null) goto L51;
        if (Math.abs(r101 - ((Number) r110.getFirst()).intValue()) > Math.abs(r101 - ((Number) r113.getFirst()).intValue())) goto L50;
        return (View) r110.getSecond();
    L50:
        return (View) r113.getSecond();
    L51:
        return null;
    L33:
        r112 = r111.next();
        if (r111.hasNext() == false) goto L42;
        int r114 = ((Number) ((Pair) r112).getFirst()).intValue();
    L37:
        Object r115 = r111.next();
        int r116 = ((Number) ((Pair) r115).getFirst()).intValue();
        if (r114 <= r116) goto L41;
        r112 = r115;
        r114 = r116;
    L41:
        if (r111.hasNext() == true) goto L37;
    L21:
        r109 = r108.next();
        if (r108.hasNext() == false) goto L30;
        int r117 = ((Number) ((Pair) r109).getFirst()).intValue();
    L25:
        Object r118 = r108.next();
        int r119 = ((Number) ((Pair) r118).getFirst()).intValue();
        if (r117 >= r119) goto L29;
        r109 = r118;
        r117 = r119;
    L29:
        if (r108.hasNext() == true) goto L25;
    L15:
        r107 = null;
        goto L16
    L8:
        r105 = false;
        goto L9
    L11:
        r104 = null;
        goto L12
    }

    public static void e(BigImagePhotoViewerDialog r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("BigImagePhotoViewerDialog", "tag");
        r100.e(r101, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.d("BigImagePhotoViewerDialog", "rect showAnimated error: " + e);
    }

    public static void f(BigImagePhotoViewerDialog r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("BigImagePhotoViewerDialog", "tag");
    L7:
        e = move-exception;
        FLogger.f375446a.d("BigImagePhotoViewerDialog", "view show error: " + e);
        return;
    L4:
        if (r100.isShowing() == true) goto L12;
        r100.f327627b.scrollToPosition(r101);     // Catch: Exception -> L7
        r100.d(r101, false);     // Catch: Exception -> L7
        PhotoViewerDialog.c(r100);     // Catch: Exception -> L7
        return;
    }

    public static BigImageLocalPhotoViewerDialog d(Context r110, List r111, List r112, int r113, uo8.k r114, l1 r210, com.larus.avlink.gallery.view.p1 r211, int r212) {
        if ((r212 & 32) == 0) goto L5;
        boolean r115 = !r112.isEmpty();
    L7:
        if ((r212 & 64) == 0) goto L9;
        l1 r116 = null;
    L11:
        if ((r212 & 128) == 0) goto L13;
        com.larus.avlink.gallery.view.p1 r100 = null;
    L14:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "imageViews");
        Intrinsics.checkNotNullParameter(r112, "imageList");
        Intrinsics.checkNotNullParameter(r114, "reportParams");
        if (r113 >= 0) goto L17;
        return null;
    L17:
        if (r113 >= r112.size()) goto L62;
        List r101 = r112;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L21:
        if (r103.hasNext() == false) goto L23;
        t1 r104 = (t1) r103.next();
        r102.add(new n1(r104.getPath(), r104));
        goto L21
    L23:
        BigImageLocalPhotoViewerDialog r105 = new BigImageLocalPhotoViewerDialog(r110, r102, r114, r115, r116);
        j r106 = new j(r100, r111);
        r105.f327638m = r106;
        TransitionPagerAdapter<?> r107 = r105.f327626a;
        r107.f327751d = r106;
        r107.f327752e = 1;
        Iterator r108 = r111.iterator();
    L25:
        if (r108.hasNext() == false) goto L32;
        Object r109 = r108.next();
        if (((Number) ((Pair) r109).getFirst()).intValue() != r113) goto L29;
        boolean r117 = true;
    L30:
        if (r117 == false) goto L25;
    L33:
        Pair r118 = (Pair) r109;
        if (r118 == null) goto L36;
        View r119 = (View) r118.getSecond();
    L38:
        if (r119 == null) goto L44;
        Intrinsics.checkNotNullParameter(r119, "view");
        Intrinsics.checkNotNullParameter("BigImageLocalPhotoViewerDialog", "tag");
        r105.f(r113, r119);     // Catch: Exception -> L42
    L50:
        return r105;
    L42:
        e = move-exception;
        FLogger.f375446a.d("BigImageLocalPhotoViewerDialog", "view showAnimated error: " + e);
        goto L50
    L44:
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Intrinsics.checkNotNullParameter("BigImagePhotoViewerDialog", "tag");
        r105.e(r113, null);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        FLogger.f375446a.d("BigImagePhotoViewerDialog", "rect showAnimated error: " + e);
        goto L50
    L36:
        r119 = null;
        goto L38
    L29:
        r117 = false;
        goto L30
    L32:
        r109 = null;
        goto L33
    L62:
        return null;
    L13:
        r100 = r211;
        goto L14
    L9:
        r116 = r210;
        goto L11
    L5:
        r115 = false;
        goto L7
    }

    public static void b(Context r210, List r211, int r212, uo8.k r213, boolean r214, List r215, List r216, List r217, int r218) {
        int r100 = 0;
        if ((r218 & 128) != 0) goto L5;
        boolean r101 = r214;
    L11:
        if ((r218 & 256) == 0) goto L13;
        List r110 = null;
    L15:
        if ((r218 & 512) == 0) goto L17;
        List r111 = null;
    L19:
        if ((r218 & 1024) == 0) goto L21;
        List r112 = null;
    L22:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "imageUrls");
        Intrinsics.checkNotNullParameter(r213, "reportParams");
        if (r212 >= 0) goto L25;
        return;
    L25:
        if (r212 >= r211.size()) goto L40;
        List r102 = r211;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L29:
        if (r104.hasNext() == false) goto L34;
        Object r105 = r104.next();
        int r106 = r100 + 1;
        if (r100 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        String r107 = (String) r105;
        r103.add(new n1(r107, r107));
        r100 = r106;
        goto L29
    L34:
        BigImagePhotoViewerDialog r108 = new BigImagePhotoViewerDialog(r210, r103, null, r213, r101, null, null, r110, r111, r112, null, false, false, false, 30752);
        r108.f327626a.f327752e = 1;
        e(r108, r212);
        return;
    L40:
        return;
    L21:
        r112 = r217;
        goto L22
    L17:
        r111 = r216;
        goto L19
    L13:
        r110 = r215;
        goto L15
    L5:
        if (r211.size() <= 1) goto L7;
        boolean r109 = true;
    L8:
        r101 = r109;
        goto L11
    L7:
        r109 = false;
        goto L8
    }

    public static void c(Context r210, List r211, List r212, int r213, uo8.k r214, boolean r215, HybridEventParams r310, String r311, boolean r312, Function1 r313, Function1 r314, Function1 r315, qh8.j r316, int r317) {
        if ((r317 & 32) != 0) goto L5;
        boolean r110 = r215;
    L10:
        View r216 = null;
        if ((r317 & 64) == 0) goto L13;
        HybridEventParams r111 = null;
    L15:
        if ((r317 & 128) == 0) goto L17;
        String r112 = null;
    L19:
        if ((r317 & 512) == 0) goto L21;
        boolean r217 = true;
    L23:
        if ((r317 & 1024) == 0) goto L25;
        Function1 r100 = null;
    L27:
        if ((r317 & 2048) == 0) goto L29;
        Function1 r113 = null;
    L31:
        if ((r317 & 4096) == 0) goto L33;
        Function1 r114 = null;
    L35:
        if ((r317 & 8192) == 0) goto L37;
        qh8.j r101 = null;
    L38:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "imageViews");
        Intrinsics.checkNotNullParameter(r212, "imageList");
        Intrinsics.checkNotNullParameter(r214, "reportParams");
        if (r213 >= 0) goto L41;
        return;
    L41:
        if (r213 >= r212.size()) goto L90;
        List r102 = r212;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L45:
        if (r104.hasNext() == false) goto L52;
        l r105 = (l) r104.next();
        Iterator r318 = r104;
        if (r101 == null) goto L50;
        String r106 = (String) r101.invoke(r105.f296007b);
        if (r106 == null) goto L50;
    L51:
        r103.add(new n1(r106));
        r104 = r318;
    L50:
        r106 = r105.f296007b;
        goto L51
    L52:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r108 = r102.iterator();
    L54:
        if (r108.hasNext() == false) goto L56;
        r107.add(((l) r108.next()).f296009d);
        goto L54
    L56:
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r115 = r102.iterator();
    L58:
        if (r115.hasNext() == false) goto L60;
        r109.add(((l) r115.next()).f296015j);
        goto L58
    L60:
        BigImagePhotoViewerDialog r116 = new BigImagePhotoViewerDialog(r210, r103, r107, r214, r110, r111, r112, null, null, null, r109, false, r217, false, 22272);
        r116.L0 = r114;
        h r117 = new h(r100, r211, r113);
        r116.f327638m = r117;
        r116.f327626a.f327751d = r117;
        r116.f295914k0 = new i(r212);
        Iterator r118 = r211.iterator();
    L62:
        if (r118.hasNext() == false) goto L69;
        Object r119 = r118.next();
        int r120 = r213;
        if (((Number) ((Pair) r119).getFirst()).intValue() != r120) goto L66;
        boolean r121 = true;
    L67:
        if (r121 == false) goto L62;
    L70:
        Pair r122 = (Pair) r119;
        if (r122 == null) goto L73;
        r216 = (View) r122.getSecond();
    L73:
        View r123 = r216;
        if (r123 == null) goto L76;
        r116.v(r120, r123, "BigImagePhotoViewerDialog");
        return;
    L76:
        f(r116, r120);
        return;
    L66:
        r121 = false;
        goto L67
    L69:
        r120 = r213;
        r119 = null;
        goto L70
    L90:
        return;
    L37:
        r101 = r316;
        goto L38
    L33:
        r114 = r315;
        goto L35
    L29:
        r113 = r314;
        goto L31
    L25:
        r100 = r313;
        goto L27
    L21:
        r217 = r312;
        goto L23
    L17:
        r112 = r311;
        goto L19
    L13:
        r111 = r310;
        goto L15
    L5:
        if (r212.size() <= 1) goto L7;
        boolean r124 = true;
    L8:
        r110 = r124;
        goto L10
    L7:
        r124 = false;
        goto L8
    }
}
