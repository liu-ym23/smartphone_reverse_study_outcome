package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class j0 {
    public static final String d(com.larus.bmhome.actionbar.model.w r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.f295529t;
        if (r101 != null) goto L5;
    L11:
        String r102 = r100.f295511b;
        if (r102 != null) goto L14;
        return null;
    L14:
        if ((!StringsKt.isBlank(r102)) == true) goto L16;
        return null;
    L16:
        return r102;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101;
    }

    public static final boolean e(com.larus.bmhome.actionbar.model.c2 r100) {
        Integer r101 = r100.getType();
        if (r101 != null) goto L6;
    L7:
        Integer r102 = r100.getType();
        if (r102 != null) goto L11;
    L13:
        return false;
    L11:
        if (r102.intValue() != 4) goto L13;
    L14:
        return true;
    L6:
        if (r101.intValue() == 5) goto L14;
        goto L7
    }

    public static final boolean g(com.larus.bmhome.actionbar.model.w r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.larus.bmhome.actionbar.model.z1 r101 = r100.f295532w;
        if (r101 == null) goto L10;
        String r102 = r101.f295634a;
        if (r102 != null) goto L7;
        return false;
    L7:
        if ((!StringsKt.isBlank(r102)) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static final m0 b(com.larus.bmhome.actionbar.model.j r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r102 = null;
        if (r101 == null) goto L91;
        int r103 = r101.intValue();
        Integer r104 = r100.f295217m;
        if (r104 == null) goto L7;
        int r105 = r104.intValue();
    L8:
        if (r103 >= r105) goto L10;
        return null;
    L10:
        List<com.larus.bmhome.actionbar.model.c2> r106 = r100.f295218n;
        if (r106 != null) goto L13;
        r106 = CollectionsKt.emptyList();
    L13:
        Iterator<T> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L19;
        Object r108 = r107.next();
        if (e((com.larus.bmhome.actionbar.model.c2) r108) == false) goto L15;
    L20:
        com.larus.bmhome.actionbar.model.c2 r109 = (com.larus.bmhome.actionbar.model.c2) r108;
        if (r109 != null) goto L28;
        r109 = r100.f295216l;
        if (r109 != null) goto L25;
    L27:
        r109 = null;
        goto L28
    L25:
        if (e(r109) == false) goto L27;
    L28:
        if (r109 == null) goto L92;
        boolean r110 = v19.h.f552477a;
        boolean r111 = false;
        if (v19.h.a(null) == false) goto L46;
        com.larus.bmhome.actionbar.model.g1 r112 = r109.f295048d;
        if (r112 == null) goto L45;
        String r113 = r112.f295156b;
        if (r113 != null) goto L36;
    L39:
        boolean r114 = true;
    L41:
        if ((!r114) == true) goto L44;
        r112 = null;
    L44:
        if (r112 == null) goto L45;
    L47:
        if (r112 == null) goto L93;
        String r115 = r112.f295156b;
        if (r115 != null) goto L51;
        return null;
    L51:
        if ((!StringsKt.isBlank(r115)) == true) goto L54;
        r115 = null;
    L54:
        if (r115 == null) goto L95;
        Integer r116 = r112.f295157c;
        int r117 = 12;
        if (r116 != null) goto L59;
    L67:
        int r118 = 12;
    L68:
        Integer r119 = r112.f295158d;
        if (r119 != null) goto L71;
    L79:
        Integer r120 = r112.f295159e;
        if (r120 == null) goto L87;
        if (r120.intValue() < 0) goto L84;
        r111 = true;
    L84:
        if (r111 == false) goto L87;
        r102 = r120;
    L87:
        return new m0(r115, r118, r117, r102);
    L71:
        if (r119.intValue() <= 0) goto L73;
        boolean r121 = true;
    L74:
        if (r121 == true) goto L77;
        r119 = null;
    L77:
        if (r119 == null) goto L79;
        r117 = r119.intValue();
        goto L79
    L73:
        r121 = false;
        goto L74
    L59:
        if (r116.intValue() <= 0) goto L61;
        boolean r122 = true;
    L62:
        if (r122 == true) goto L65;
        r116 = null;
    L65:
        if (r116 == null) goto L67;
        r118 = r116.intValue();
        goto L68
    L61:
        r122 = false;
        goto L62
    L95:
        return null;
    L93:
        return null;
    L36:
        if (StringsKt.isBlank(r113) == true) goto L39;
        r114 = false;
    L45:
        r112 = r109.f295047c;
        goto L47
    L46:
        r112 = r109.f295047c;
        goto L47
    L92:
        return null;
    L19:
        r108 = null;
        goto L20
    L7:
        r105 = Integer.MAX_VALUE;
        goto L8
    L91:
        return null;
    }

    public static final String c(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r102 = null;
        if (r101 != null) goto L5;
    L25:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(r100.getString(R.string.larus_aiCreation_paraBottomSheet_btn_upgrad_cn));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == false) goto L16;
        r104 = null;
    L16:
        String r105 = (String) r104;
        if (r105 != null) goto L19;
    L21:
        if (r102 != null) goto L24;
        return r100.getString(R.string.larus_aiCreation_paraBottomSheet_btn_confirm);
    L24:
        return r102;
    L19:
        if ((!StringsKt.isBlank(r105)) == false) goto L21;
        r102 = r105;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L25;
        return r101;
    }

    public static final boolean f(com.larus.bmhome.actionbar.model.j r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L20;
        int r102 = r101.intValue();
        com.larus.bmhome.actionbar.model.z1 r103 = r100.f295219o;
        if (r103 == null) goto L11;
        String r104 = r103.f295634a;
        if (r104 == null) goto L11;
        if ((!StringsKt.isBlank(r104)) != true) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L21;
        Integer r106 = r100.f295217m;
        if (r106 == null) goto L16;
        int r107 = r106.intValue();
    L17:
        if (r102 < r107) goto L22;
        return true;
    L22:
        return false;
    L16:
        r107 = Integer.MAX_VALUE;
        goto L17
    L21:
        return false;
    L11:
        r105 = false;
        goto L12
    L20:
        return false;
    }

    public static final k0 a(com.larus.bmhome.actionbar.model.w r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        String r102 = null;
        if (g(r100) == true) goto L5;
        return null;
    L5:
        com.larus.bmhome.actionbar.model.z1 r103 = r100.f295532w;
        if (r103 == null) goto L8;
        Map<String, String> r104 = r103.f295637d;
    L9:
        int r105 = uz8.b.C7949b.f552206c;
        if (r104 == null) goto L12;
        String r106 = r104.get("feature_detail_key");
    L13:
        if (r104 == null) goto L15;
        String r107 = r104.get("feature_detail_value");
    L16:
        List r108 = CollectionsKt.listOfNotNull(uz8.b.C7949b.a.a(r106, r107, null));
        List r109 = CollectionsKt.listOf(new l0(r101, r100.f295510a, null, 4));
        com.larus.bmhome.actionbar.model.z1 r111 = r100.f295532w;
        int r112 = uz8.b.f552201e;
        if (r104 == null) goto L19;
        String r113 = r104.get("trigger_scene");
    L20:
        if (r104 == null) goto L22;
        r102 = r104.get("feature_key");
    L22:
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        Intrinsics.checkNotNullParameter(r108, "featureDetails");
        return new k0(r109, r111, new uz8.b(r110, r113, r102, uz8.b.a.a(r108)), r108);
    L19:
        r113 = null;
        goto L20
    L15:
        r107 = null;
        goto L16
    L12:
        r106 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }
}
