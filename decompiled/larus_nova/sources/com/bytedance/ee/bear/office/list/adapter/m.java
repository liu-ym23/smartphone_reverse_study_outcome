package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import com.larus.nova.R;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f235806a = null;

    static {
        f235806a = new m();
    }

    public m() {
    }

    public static int a(Document r100) {
        int r101 = r100.getType();
        if (r101 != sbb.e.f541295f.f541317b) goto L5;
    L45:
        Intrinsics.checkNotNullParameter(r100, "document");
        if (h0.b(r100) == true) goto L55;
        boolean r102 = mbb.c.f512807a;
        return kac.a.b(R.drawable.ud_icon_file_folder_colorful);
    L55:
        return rbb.b.g();
    L5:
        if (r101 == 111) goto L45;
        if (r101 != sbb.e.f541301l.f541317b) goto L11;
        return rbb.b.e(r100.F);
    L11:
        if (r101 == sbb.e.f541303n.f541317b) goto L53;
        int r103 = r100.getType();
        String r104 = r100.F2;
        if (r104 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        Long r106 = null;
        Object r107 = null;
        if (r105 == true) goto L54;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L37
        JSONObject r109 = new JSONObject(r104);     // Catch: Throwable -> L37
        if (r109.has("obj_sub_type") == true) goto L26;
    L34:
        Long r110 = null;
    L35:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L37
    L40:
        if (Result.m9455isFailureimpl(r111) == true) goto L43;
        r107 = r111;
    L43:
        r106 = (Long) r107;
        goto L54
    L26:
        if (r109.isNull("obj_sub_type") == true) goto L34;
        Object r112 = r109.opt("obj_sub_type");     // Catch: Throwable -> L37
        if ((r112 instanceof Number) == false) goto L32;
        r110 = Long.valueOf(((Number) r112).longValue());     // Catch: Throwable -> L37
        goto L35
    L32:
        if ((r112 instanceof String) == false) goto L34;
        r110 = StringsKt.toLongOrNull((String) r112);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L54:
        return rbb.b.c(r103, r106);
    L16:
        if (StringsKt.isBlank(r104) == true) goto L19;
        r105 = false;
        goto L20
    L53:
        return ua5.a.l(r100.f227908y1, r100.f227868a);
    }
}
