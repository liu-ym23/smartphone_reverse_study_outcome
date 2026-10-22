package com.larus.bmhome.taskskill;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.utils.logger.FLogger;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2 f314285a = null;

    static {
        f314285a = new e2();
    }

    public e2() {
    }

    public static List a(String r100, Integer r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L32;
        FLogger.f375446a.i("SkillTrialSchemaParser", "[parse] payload is blank");
        return CollectionsKt.emptyList();
    L32:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(b(r100, r101));     // Catch: Throwable -> L14
    L17:
        if (Result.m9452exceptionOrNullimpl(r104) != null) goto L34;
    L24:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L27;
        FLogger.f375446a.w("SkillTrialSchemaParser", "[parse] parse selected_skills failed, msg=" + r105.getMessage());
    L27:
        List r106 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r104) == false) goto L31;
        r104 = r106;
    L31:
        return (List) r104;
    L34:
        e2 r107 = f314285a;     // Catch: Throwable -> L21
        String r108 = URLDecoder.decode(r100, "UTF-8");     // Catch: Throwable -> L21
        r107.getClass();     // Catch: Throwable -> L21
        Object r109 = Result.m9449constructorimpl(b(r108, r101));     // Catch: Throwable -> L21
    L23:
        r104 = r109;
    L21:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r102 = false;
        goto L9
    }

    public static List b(String r110, Integer r210) {
        JSONArray r100 = new JSONArray(r110);
        LinkedHashSet r101 = new LinkedHashSet();
        ArrayList r102 = new ArrayList();
        int r103 = r100.length();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L38;
        JSONObject r105 = r100.optJSONObject(r104);
        if (r105 == null) goto L37;
        String r106 = StringsKt.trim(r105.optString("name")).toString();
        if (StringsKt.isBlank(r106) == true) goto L37;
        if (r101.add(r106) == false) goto L37;
        String r107 = r105.optString("skill_id");
        Intrinsics.checkNotNull(r107);
        boolean r111 = true;
        Integer r112 = null;
        if ((!StringsKt.isBlank(r107)) == true) goto L16;
        r107 = null;
    L16:
        Integer r108 = Integer.valueOf(r105.optInt("skill_type"));
        if (r108.intValue() <= 0) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == true) goto L23;
        r108 = null;
    L23:
        if (r108 == null) goto L25;
        int r109 = r108.intValue();
    L34:
        int r114 = r109;
    L36:
        r102.add(new TaskSkill(r106, r107, null, r105.optString(IGoogleService.ResponseKey.DISPLAY_NAME), false, r114, false, null, null, 16308));
        goto L37
    L25:
        if (r210 != null) goto L27;
    L32:
        if (r112 == null) goto L35;
        r109 = r112.intValue();
        goto L34
    L35:
        r114 = 0;
        goto L36
    L27:
        if (r210.intValue() > 0) goto L30;
        r111 = false;
    L30:
        if (r111 == false) goto L32;
        r112 = r210;
        goto L32
    L19:
        r113 = false;
    L37:
        r104 = r104 + 1;
        goto L3
    L38:
        FLogger.f375446a.i("SkillTrialSchemaParser", "[parseJsonArray] selectedCount=" + r102.size());
        return r102;
    }
}
