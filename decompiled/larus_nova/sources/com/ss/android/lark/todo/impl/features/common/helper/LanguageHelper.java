package com.ss.android.lark.todo.impl.features.common.helper;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import g7c.l;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class LanguageHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f442435a = null;

    static {
        f442435a = LazyKt.lazy(LanguageHelper$languageDependency$2.INSTANCE);
    }

    public static l a() {
        return (l) f442435a.getValue();
    }

    public static String b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        String r101 = (String) c(r100);
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        return r101;
    L12:
        if ((!r100.isEmpty()) == false) goto L14;
        String r104 = (String) ListProtector.get(new ArrayList(r100.keySet()), 0);
    L15:
        CharSequence r105 = (CharSequence) r100.get("en_us");
        if (r105 != null) goto L18;
    L19:
        r102 = true;
    L20:
        if (r102 == false) goto L22;
        Object r106 = r100.get(r104);
    L23:
        String r107 = (String) r106;
        if (r107 != null) goto L27;
        return "";
    L27:
        return r107;
    L22:
        r106 = r100.get("en_us");
        goto L23
    L18:
        if (r105.length() != 0) goto L20;
    L14:
        r104 = "en_us";
        goto L15
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static Object c(Map r100) {
        if (a().isZh() == false) goto L6;
        return r100.get("zh_cn");
    L6:
        if (a().isEn() == false) goto L9;
        return r100.get("en_us");
    L9:
        if (a().a() == false) goto L12;
        return r100.get("ja_jp");
    L12:
        if (a().c() == false) goto L15;
        return r100.get("es_es");
    L15:
        if (a().d() == false) goto L18;
        return r100.get("it_it");
    L18:
        if (a().i() == false) goto L21;
        return r100.get("de_de");
    L21:
        if (a().o() == false) goto L24;
        return r100.get("fr_fr");
    L24:
        if (a().l() == false) goto L27;
        return r100.get("pt_br");
    L27:
        if (a().isId() == false) goto L30;
        return r100.get("id_id");
    L30:
        if (a().f() == false) goto L33;
        return r100.get("id_id");
    L33:
        if (a().g() == false) goto L36;
        return r100.get("vi_vn");
    L36:
        if (a().n() == false) goto L39;
        return r100.get("th_th");
    L39:
        if (a().m() == false) goto L42;
        return r100.get("ko_kr");
    L42:
        if (a().b() == false) goto L45;
        return r100.get("ru_ru");
    L45:
        if (a().j() == false) goto L48;
        return r100.get("hi_in");
    L48:
        if (a().e() == false) goto L51;
        return r100.get("zh_hk");
    L51:
        if (a().k() == false) goto L54;
        return r100.get("zh_tw");
    L54:
        return r100.get("en_us");
    }
}
