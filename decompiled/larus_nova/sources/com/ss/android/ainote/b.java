package com.ss.android.ainote;

import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f406680a = null;

    static {
        f406680a = new b();
    }

    public b() {
    }

    public static String g(String r110) {
        return StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, ';', ',', false, 4, null), '\n', ' ', false, 4, null), '\r', ' ', false, 4, null), '\t', ' ', false, 4, null)).toString();
    }

    public final void d(View r100) {
        c(this, r100, "vc-personal-notes-create-entry", "Personal Notes Create Entry", "Tap to create a personal note", "vc-personal-notes-note-item");
    }

    public static void e(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "uploadState");
        b(r100, "vc-personal-notes-image", "Personal Notes Image", "Tap to preview image or long press to open note actions", "platform-photo-pager", MapsKt.mapOf(TuplesKt.to("upload_state", r101)));
    }

    public static void a(StringBuilder r100, String r101, String r102) {
        r100.append(com.alipay.sdk.m.u.i.f25853b);
        r100.append(g(r101));
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(g(r102));
    }

    public static void b(View r100, String r101, String r102, String r103, String r104, Map r105) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100.getContext().getApplicationInfo().flags & 2) == 0) goto L6;
        boolean r106 = true;
    L7:
        if (r106 == false) goto L27;
        StringBuilder r107 = new StringBuilder();
        r107.append("vc-auto:id=");
        r107.append(g(r101));
        a(r107, "label", r102);
        a(r107, "hint", r103);
        a(r107, "expected", r104);
        Iterator r108 = r105.entrySet().iterator();
    L11:
        if (r108.hasNext() == false) goto L17;
        Map.Entry r109 = (Map.Entry) r108.next();
        String r110 = (String) r109.getKey();
        String r111 = (String) r109.getValue();
        if ((!StringsKt.isBlank(r110)) == false) goto L11;
        if ((!StringsKt.isBlank(r111)) == false) goto L11;
        a(r107, r110, r111);
        goto L11
    L17:
        r100.setContentDescription(r107.toString());
        return;
    L27:
        return;
    L6:
        r106 = false;
        goto L7
    }

    public static /* synthetic */ void c(b r100, View r101, String r102, String r103, String r110, String r111) {
        Map r104 = MapsKt.emptyMap();
        r100.getClass();
        b(r101, r102, r103, r110, r111, r104);
    }

    public static Map f(long r100, Integer r101, String r102, String r103, int r104, boolean r105) {
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("stable_ui_id", String.valueOf(r100));
        if (r101 == null) goto L5;
        r106.put("position", String.valueOf(r101.intValue()));
    L5:
        r106.put("note_type", r102);
        r106.put("content_state", r103);
        r106.put("gallery_count", String.valueOf(r104));
        r106.put("has_text", String.valueOf(r105));
        return r106;
    }
}
