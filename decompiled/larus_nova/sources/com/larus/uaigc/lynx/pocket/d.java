package com.larus.uaigc.lynx.pocket;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public static final Boolean a(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Boolean) == false) goto L9;
        return (Boolean) r100;
    L9:
        if ((r100 instanceof String) == false) goto L17;
        String r101 = ((String) r100).toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r101, "true") == false) goto L14;
        return Boolean.TRUE;
    L14:
        if (Intrinsics.areEqual(r101, "false") == true) goto L27;
        return null;
    L27:
        return Boolean.FALSE;
    L17:
        if ((r100 instanceof Number) == false) goto L28;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Number");
        if (((Number) r100).intValue() == 0) goto L21;
        boolean r102 = true;
    L23:
        return Boolean.valueOf(r102);
    L21:
        r102 = false;
        goto L23
    L28:
        return null;
    }

    public static final Integer b(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        return (Integer) r100;
    L9:
        if ((r100 instanceof Number) == false) goto L12;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Number");
        return Integer.valueOf(((Number) r100).intValue());
    L12:
        if ((r100 instanceof String) == true) goto L14;
        return null;
    L14:
        return StringsKt.toIntOrNull((String) r100);
    }

    public static final Map<String, Object> c(Object r100) {
        if ((r100 instanceof Map) == false) goto L5;
        Map r101 = (Map) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L17;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getKey();
        Object r106 = r104.getValue();
        if (r105 == null) goto L10;
        String r107 = r105.toString();
        if (r107 == null) goto L10;
        r102.put(r107, r106);
        goto L10
    L17:
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    public static final String d(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == false) goto L9;
        return (String) r100;
    L9:
        if ((r100 instanceof Number) == false) goto L12;
        return ((Number) r100).toString();
    L12:
        if ((r100 instanceof Boolean) == true) goto L14;
        return null;
    L14:
        return String.valueOf(((Boolean) r100).booleanValue());
    }

    public static final Pocket e(Map<String, ? extends Object> r310) {
        Intrinsics.checkNotNullParameter(r310, "<this>");
        Map<String, Object> r100 = c(r310.get("send_msg_pocket"));
        ArrayList r101 = null;
        if (r100 == null) goto L5;
        LinkedHashMap r102 = (LinkedHashMap) r100;
        SendMsgPocket r110 = new SendMsgPocket(a(r102.get("allow_photos")), b(r102.get("selected_photos_count")), d(r102.get("selected_model")), d(r102.get("preset_image_url")), d(r102.get("preset_image_uri")));
    L6:
        Map<String, Object> r103 = c(r310.get("keyboard_input_pocket"));
        if (r103 == null) goto L9;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        KeyboardInputPocket r111 = new KeyboardInputPocket(d(r104.get("input_box_title")), d(r104.get("input_placeholder")), d(r104.get("input_placeholder_prompt")), d(r104.get("input_placeholder_prompt_for_model")), d(r104.get("selected_model")));
    L10:
        Map<String, Object> r105 = c(r310.get("upload_input_pocket"));
        if (r105 == null) goto L13;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        UploadInputPocket r210 = new UploadInputPocket(d(r106.get("input_box_title")), d(r106.get("input_placeholder")), d(r106.get("input_placeholder_prompt")), a(r106.get("must_photos")), b(r106.get("selected_photos_count")), d(r106.get("pre_set_photo_url")), d(r106.get("pre_set_photo_uri")), d(r106.get("selected_model")));
    L14:
        Map<String, Object> r107 = c(r310.get("jump_somewhere_pocket"));
        if (r107 == null) goto L30;
        LinkedHashMap r108 = (LinkedHashMap) r107;
        String r109 = d(r108.get("jump_schema_url"));
        String r112 = "";
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        String r113 = d(r108.get("jump_instruction_id"));
        if (r113 != null) goto L22;
        r113 = "";
    L22:
        String r114 = d(r108.get("insert_prompt"));
        if (r114 != null) goto L25;
        r114 = "";
    L25:
        String r115 = d(r108.get("selected_model"));
        if (r115 == null) goto L29;
        r112 = r115;
    L29:
        JumpSomewherePocket r211 = new JumpSomewherePocket(r109, r113, r114, r112);
    L31:
        Map<String, Object> r116 = c(r310.get("supported_systems_and_versions"));
        if (r116 == null) goto L52;
        Object r117 = ((LinkedHashMap) r116).get("os_version");
        if ((r117 instanceof List) == false) goto L36;
        List r118 = (List) r117;
    L37:
        if (r118 != null) goto L39;
        ArrayList r119 = null;
    L46:
        if (r119 == null) goto L51;
        r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r120 = r119.iterator();
    L49:
        if (r120.hasNext() == false) goto L51;
        Map r121 = (Map) r120.next();
        r101.add(new OSVersion(b(r121.get("sys_type")), a(r121.get("is_support")), d(r121.get("lowest_version_code")), d(r121.get("highest_version_code"))));
    L51:
        SupportedOSAndVersion r212 = new SupportedOSAndVersion(r101);
    L54:
        return new Pocket(d(r310.get("pocket_id")), d(r310.get("config_name")), d(r310.get("icon_url")), d(r310.get(EventConstant.Key.RETAIN_PROMPT)), b(r310.get("pocket_type")), r110, r111, r210, r211, b(r310.get("intention_type")), b(r310.get("status")), r212, d(r310.get("ext")), null, null, null, 57344, null);
    L39:
        r119 = new ArrayList();
        Iterator r122 = r118.iterator();
    L41:
        if (r122.hasNext() == false) goto L46;
        Map<String, Object> r123 = c(r122.next());
        if (r123 == null) goto L41;
        r119.add(r123);
        goto L41
    L36:
        r118 = null;
        goto L37
    L52:
        r212 = null;
        goto L54
    L30:
        r211 = null;
        goto L31
    L13:
        r210 = null;
        goto L14
    L9:
        r111 = null;
        goto L10
    L5:
        r110 = null;
        goto L6
    }
}
