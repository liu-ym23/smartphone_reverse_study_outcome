package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.platform.model.SlashMentionConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f314300a = null;

    static {
        f314300a = SetsKt.setOf(new String[]{"task_skill_local_temp_runtime_type", "task_skill_local_temp_selected_skills", "task_skill_local_temp_local_selected_skills"});
    }

    public static String a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedSkills");
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L26;
        Object r104 = r102.next();
        TaskSkill r105 = (TaskSkill) r104;
        String r106 = r105.getName();
        if (r106 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == false) goto L23;
        String r108 = r105.e();
        if (r108 != null) goto L16;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L23;
        r103 = false;
        goto L23
    L16:
        if (StringsKt.isBlank(r108) == true) goto L19;
        r109 = false;
    L23:
        if (r103 == false) goto L3;
        r101.add(r104);
        goto L3
    L8:
        if (StringsKt.isBlank(r106) == true) goto L11;
        r107 = false;
        goto L12
    L26:
        if (r101.isEmpty() == false) goto L28;
        return null;
    L28:
        JSONArray r110 = new JSONArray();
        Iterator r111 = r101.iterator();
    L30:
        if (r111.hasNext() == false) goto L57;
        TaskSkill r112 = (TaskSkill) r111.next();
        JSONObject r113 = new JSONObject();
        String r114 = r112.getName();
        if (r114 != null) goto L34;
    L39:
        String r115 = r112.d();
        if (r115 != null) goto L42;
    L47:
        r113.put("skill_type", r112.getType());
        String r116 = r112.e();
        if (r116 == null) goto L55;
        if ((!StringsKt.isBlank(r116)) == true) goto L53;
        r116 = null;
    L53:
        if (r116 == null) goto L55;
        r113.put("path", r116);
    L55:
        r110.put(r113);
        goto L30
    L42:
        if ((!StringsKt.isBlank(r115)) == true) goto L45;
        r115 = null;
    L45:
        if (r115 == null) goto L47;
        r113.put("skill_id", r115);
        goto L47
    L34:
        if ((!StringsKt.isBlank(r114)) == true) goto L37;
        r114 = null;
    L37:
        if (r114 == null) goto L39;
        r113.put("name", r114);
        goto L39
    L57:
        return r110.toString();
    }

    public static String b(TaskSkill r100) {
        Intrinsics.checkNotNullParameter(r100, SlashMentionConfig.SLASH_CONTENT_SKILL);
        Set<Integer> r101 = com.larus.bmhome.chat.markdown.richtext.s.f307240a;
        String r102 = r100.getName();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return com.larus.bmhome.chat.markdown.richtext.s.a(r102, Integer.valueOf(r100.getType()), r100.d(), r100.e());
    }

    public static String c(List r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        TaskSkill r103 = (TaskSkill) r102.next();
        String r104 = b(r103);
        if (r104 != null) goto L8;
        String r105 = null;
    L9:
        if (r105 == null) goto L4;
        r101.add(r105);
        goto L4
    L8:
        r105 = "[" + r103.c() + "](" + r104 + ") ";
        goto L9
    L12:
        return CollectionsKt.joinToString$default(r101, "", null, null, 0, null, null, 62, null);
    }

    public static boolean d(Map r100) {
        Set<String> r101 = f314300a;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L25;
        String r103 = (String) r102.next();
        if (r100 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L9;
        return false;
    L13:
        if (r100.containsKey(r103) != true) goto L15;
        r104 = true;
        goto L16
    L25:
        return true;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return true;
    }
}
