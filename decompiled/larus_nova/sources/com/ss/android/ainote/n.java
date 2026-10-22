package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteScene;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class n {
    public static final AINoteCreateSource b(xra.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AINoteCreateSource r101 = r100.f564898c;
        if (r101 == null) goto L6;
        return r101;
    L6:
        if (r100.f564904i.isMark() == false) goto L12;
        AINoteCreateSource r102 = r100.f564904i.defaultCreateSource();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return AINoteCreateSource.HIGHLIGHT;
    L12:
        if ((!r100.f564903h.isEmpty()) == false) goto L18;
        if (StringsKt.isBlank(r100.d()) == false) goto L18;
        return AINoteCreateSource.PHOTO;
    L18:
        if ((!StringsKt.isBlank(r100.d())) == true) goto L20;
        return null;
    L20:
        return AINoteCreateSource.INPUT;
    }

    public static final xra.a d(xra.a r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        if (r210.f564898c == null) goto L5;
        return r210;
    L5:
        AINoteCreateSource r100 = b(r210);
        if (r100 != null) goto L9;
        return r210;
    L9:
        return xra.a.b(r210, r100, null, null, null, null, null, null, 0, 0, 0, null, false, false, 0, 0, null, 0, false, null, false, 4194299);
    }

    public static final xra.a c(xra.a r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, "inputText");
        if (r210.f564898c == null) goto L5;
        return r210;
    L5:
        if (StringsKt.isBlank(r211) == false) goto L7;
        return r210;
    L7:
        if (r210.f564904i.isMark() == false) goto L10;
        return r210;
    L10:
        return xra.a.b(r210, AINoteCreateSource.INPUT, null, null, null, null, null, null, 0, 0, 0, null, false, false, 0, 0, null, 0, false, null, false, 4194299);
    }

    public static final JSONObject a(AINoteScene r100, String r101, xra.a r102, AINoteCreateSource r103) {
        String r104 = null;
        l r105 = new l("click", null);
        r105.c(r100);
        Intrinsics.checkNotNullParameter(r101, "click");
        r105.b("click", r101);
        r105.a(r102);
        if (r103 != null) goto L7;
        r103 = b(r102);
        if (r103 != null) goto L7;
        r103 = r102.f564898c;
    L7:
        if (r103 == null) goto L9;
        r104 = r103.toEventValue();
    L9:
        r105.b("note_source", r104);
        return new JSONObject(r105.f406839c.toString());
    }
}
