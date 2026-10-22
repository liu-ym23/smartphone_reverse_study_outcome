package com.obric.assistant.cocreationreview.modules.omni;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.obric.assistant.cocreationreview.ModuleKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lda.b0;
import lda.c;
import lda.e;
import lda.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static final ContentValues a(b0 r100) {
        ContentValues r101 = new ContentValues();
        r101.put("record_id", r100.f508788a);
        r101.put("task_id", r100.f508790c);
        r101.put("created_at", Long.valueOf(r100.f508791d));
        r101.put("user_query", r100.f508792e);
        r101.put("dobao_answer", r100.f508793f);
        r101.put("status", r100.f508794g.getRaw());
        r101.put("task_trigger_type", r100.f508795h.getRaw());
        List<c> r102 = r100.f508796i;
        JSONArray r103 = new JSONArray();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        String r105 = v.a(((c) r104.next()).f508800a);
        if ((!StringsKt.isBlank(r105)) == false) goto L4;
        r103.put(new JSONObject().put("description", r105));
        goto L4
    L8:
        r101.put("steps", r103.toString());
        r101.put("time", r100.f508797j);
        return r101;
    }

    public static final b0 b(Cursor r110) {
        String r100 = r110.getString(r110.getColumnIndexOrThrow("record_id"));
        ModuleKey r101 = e.f508808a.f387358a;
        String r102 = r110.getString(r110.getColumnIndexOrThrow("task_id"));
        long r103 = r110.getLong(r110.getColumnIndexOrThrow("created_at"));
        String r104 = r110.getString(r110.getColumnIndexOrThrow("user_query"));
        String r105 = r110.getString(r110.getColumnIndexOrThrow("dobao_answer"));
        OmniTaskStatus.a r106 = OmniTaskStatus.Companion;
        String r107 = r110.getString(r110.getColumnIndexOrThrow("status"));
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, TemplateNodeType.RAW);
        OmniTaskStatus[] r108 = OmniTaskStatus.values();
        int r111 = r108.length;
        int r112 = 0;
    L4:
        if (r112 >= r111) goto L15;
        OmniTaskStatus r113 = r108[r112];
        if (Intrinsics.areEqual(r113.getRaw(), r107) == false) goto L8;
    L11:
        boolean r114 = true;
    L12:
        if (r114 == true) goto L16;
        r112 = r112 + 1;
    L16:
        if (r113 != null) goto L18;
        OmniTaskStatus r109 = OmniTaskStatus.SUCCESS;
    L19:
        OmniTaskTriggerType.a r115 = OmniTaskTriggerType.Companion;
        String r116 = r110.getString(r110.getColumnIndexOrThrow("task_trigger_type"));
        r115.getClass();
        OmniTaskTriggerType r117 = OmniTaskTriggerType.a.a(r116);
        JSONArray r118 = new JSONArray(r110.getString(r110.getColumnIndexOrThrow("steps")));
        ArrayList r119 = new ArrayList();
        int r120 = r118.length();
        int r121 = 0;
    L20:
        if (r121 >= r120) goto L30;
        Object r122 = r118.get(r121);
        JSONArray r123 = r118;
        if ((r122 instanceof JSONObject) == false) goto L24;
        String r124 = ((JSONObject) r122).optString("description");
    L25:
        Intrinsics.checkNotNull(r124);
        String r125 = v.a(r124);
        if ((!StringsKt.isBlank(r125)) == false) goto L28;
        r119.add(new c(r125));
    L28:
        r121 = r121 + 1;
        r118 = r123;
        goto L20
    L24:
        r124 = r122.toString();
        goto L25
    L30:
        return new b0(r100, r101, r102, r103, r104, r105, r109, r117, r119, r110.getString(r110.getColumnIndexOrThrow("time")));
    L18:
        r109 = r113;
        goto L19
    L8:
        if (StringsKt.equals(r113.name(), r107, true) == true) goto L11;
        r114 = false;
        goto L12
    L15:
        r113 = null;
        goto L16
    }

    public static final String c(String r100, int r101) {
        String r102 = StringsKt.replace$default(r100, "\n", "\\n", false, 4, null);
        if (r102.length() > r101) goto L6;
        return r102;
    L6:
        return StringsKt.take(r102, r101) + "...";
    }
}
