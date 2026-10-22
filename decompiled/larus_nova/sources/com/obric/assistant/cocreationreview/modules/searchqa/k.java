package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.capabilitykit.EntityProvider;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class k {
    public static final ContentValues a(c0 r110) {
        ContentValues r100 = new ContentValues();
        r100.put("record_id", r110.f387534a);
        r100.put("created_at", Long.valueOf(r110.f387536c));
        r100.put("user_question", r110.f387540g);
        r100.put("answer_text", r110.f387542i);
        r100.put("answer_summary", r110.f387541h);
        List<s> r101 = r110.f387543j;
        JSONArray r102 = new JSONArray();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        s r104 = (s) r103.next();
        JSONObject r105 = new JSONObject().put("title", r104.f387580a).put("description", r104.f387581b).put("source_type", r104.f387582c).put(EntityProvider.KEY_ENTITY_TYPE, r104.f387583d).put(PickerReporterConstants.KEY.ENTITY_ID, r104.f387584e).put("entity_package_name", r104.f387585f).put("index", r104.f387586g).put("image_uris", new JSONArray(r104.f387587h));
        List<r> r106 = r104.f387588i;
        JSONArray r111 = new JSONArray();
        Iterator<T> r107 = r106.iterator();
    L7:
        if (r107.hasNext() == false) goto L9;
        r r112 = (r) r107.next();
        r111.put(new JSONObject().put("res_uri", r112.f387574a).put(EntityProvider.KEY_ENTITY_TYPE, r112.f387575b).put(PickerReporterConstants.KEY.ENTITY_ID, r112.f387576c).put("entity_package_name", r112.f387577d).put("index", r112.f387578e).put("is_video", r112.f387579f));
        goto L7
    L9:
        r102.put(r105.put("images", r111).put("url", r104.f387589j));
        goto L4
    L10:
        r100.put("local_references", r102.toString());
        r100.put("log_id", r110.f387544k);
        return r100;
    }

    public static final c0 b(Cursor r410) {
        long r100 = r410.getLong(r410.getColumnIndexOrThrow("created_at"));
        String r101 = r410.getString(r410.getColumnIndexOrThrow("record_id"));
        ModuleKey r102 = h.f387551a.f387358a;
        String r103 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(r100));
        String r104 = r410.getString(r410.getColumnIndexOrThrow("user_question"));
        String r105 = r410.getString(r410.getColumnIndexOrThrow("answer_summary"));
        String r110 = r410.getString(r410.getColumnIndexOrThrow("answer_text"));
        JSONArray r111 = new JSONArray(r410.getString(r410.getColumnIndexOrThrow("local_references")));
        ArrayList r112 = new ArrayList();
        int r106 = r111.length();
        int r113 = 0;
    L3:
        if (r113 >= r106) goto L89;
        JSONObject r114 = r111.optJSONObject(r113);
        if (r114 == null) goto L12;
        String r115 = r114.optString("title");
        Intrinsics.checkNotNull(r115);
        if ((!StringsKt.isBlank(r115)) == false) goto L10;
        String r210 = r115;
    L11:
        if (r210 == null) goto L12;
        String r211 = r114.optString("description");
        String r212 = r114.optString("source_type");
        String r116 = r114.optString(EntityProvider.KEY_ENTITY_TYPE);
        Intrinsics.checkNotNull(r116);
        if ((!StringsKt.isBlank(r116)) == false) goto L16;
        String r213 = r116;
    L17:
        String r117 = r114.optString(PickerReporterConstants.KEY.ENTITY_ID);
        Intrinsics.checkNotNull(r117);
        if ((!StringsKt.isBlank(r117)) == false) goto L20;
        String r214 = r117;
    L21:
        String r118 = r114.optString("entity_package_name");
        Intrinsics.checkNotNull(r118);
        if ((!StringsKt.isBlank(r118)) == false) goto L24;
        String r215 = r118;
    L25:
        Integer r119 = Integer.valueOf(r114.optInt("index"));
        if (r119.intValue() <= 0) goto L28;
        boolean r216 = true;
    L30:
        if (r216 == false) goto L32;
        Integer r217 = r119;
    L33:
        JSONArray r107 = r114.optJSONArray("image_uris");
        if (r107 != null) goto L36;
        List r218 = CollectionsKt.emptyList();
    L46:
        JSONArray r108 = r114.optJSONArray("images");
        if (r108 != null) goto L49;
        List r219 = CollectionsKt.emptyList();
    L82:
        String r109 = r114.optString("url");
        Intrinsics.checkNotNull(r109);
        if ((!StringsKt.isBlank(r109)) == false) goto L85;
        String r220 = r109;
    L86:
        r112.add(new s(r210, r211, r212, r213, r214, r215, r217, r218, r219, r220));
    L87:
        r113 = r113 + 1;
        r106 = r106;
        r111 = r111;
        r110 = r110;
        r105 = r105;
        r104 = r104;
        r103 = r103;
        r100 = r100;
        goto L3
    L85:
        r220 = null;
        goto L86
    L49:
        ArrayList r120 = new ArrayList();
        int r121 = r108.length();
        int r122 = 0;
    L50:
        if (r122 >= r121) goto L81;
        JSONObject r123 = r108.optJSONObject(r122);
        JSONArray r124 = r108;
        if (r123 == null) goto L80;
        String r125 = r123.optString("res_uri");
        Intrinsics.checkNotNull(r125);
        if ((!StringsKt.isBlank(r125)) == false) goto L57;
        String r310 = r125;
    L58:
        if (r310 == null) goto L80;
        String r126 = r123.optString(EntityProvider.KEY_ENTITY_TYPE);
        Intrinsics.checkNotNull(r126);
        if ((!StringsKt.isBlank(r126)) == false) goto L63;
        String r311 = r126;
    L64:
        String r127 = r123.optString(PickerReporterConstants.KEY.ENTITY_ID);
        Intrinsics.checkNotNull(r127);
        if ((!StringsKt.isBlank(r127)) == false) goto L67;
        String r411 = r127;
    L68:
        String r128 = r123.optString("entity_package_name");
        Intrinsics.checkNotNull(r128);
        if ((!StringsKt.isBlank(r128)) == false) goto L71;
        String r412 = r128;
    L72:
        Integer r129 = Integer.valueOf(r123.optInt("index"));
        if (r129.intValue() <= 0) goto L75;
        boolean r221 = true;
    L76:
        if (r221 == false) goto L78;
        Integer r413 = r129;
    L79:
        r120.add(new r(r310, r311, r411, r412, r413, r123.optBoolean("is_video")));
        goto L80
    L78:
        r413 = null;
        goto L79
    L75:
        r221 = false;
        goto L76
    L71:
        r412 = null;
        goto L72
    L67:
        r411 = null;
        goto L68
    L63:
        r311 = null;
        goto L64
    L57:
        r310 = null;
    L80:
        r122 = r122 + 1;
        r108 = r124;
        goto L50
    L81:
        r219 = r120;
        goto L82
    L36:
        List r130 = CollectionsKt.createListBuilder();
        int r131 = r107.length();
        int r132 = 0;
    L37:
        if (r132 >= r131) goto L45;
        String r133 = r107.optString(r132);
        Intrinsics.checkNotNull(r133);
        if ((!StringsKt.isBlank(r133)) == true) goto L42;
        r133 = null;
    L42:
        if (r133 == null) goto L44;
        r130.add(r133);
    L44:
        r132 = r132 + 1;
        goto L37
    L45:
        r218 = CollectionsKt.build(r130);
        goto L46
    L32:
        r217 = null;
        goto L33
    L28:
        r216 = false;
        goto L30
    L24:
        r215 = null;
        goto L25
    L20:
        r214 = null;
        goto L21
    L16:
        r213 = null;
        goto L17
    L10:
        r210 = null;
    L12:
        r106 = r106;
        r100 = r100;
        r103 = r103;
        r104 = r104;
        goto L87
    L89:
        return new c0(r101, r102, r100, r103, r104, r105, r110, r112, r410.getString(r410.getColumnIndexOrThrow("log_id")), null, BmLocated.HALF_LEFT_BOTTOM);
    }
}
