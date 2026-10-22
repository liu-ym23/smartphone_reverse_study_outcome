package com.ss.android.lark.language.assemble;

import android.content.Context;
import apb.b;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.language.service.impl.a;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yob.e;

/* JADX INFO: loaded from: classes36.dex */
public class ReportLanguageSettingTask extends AsyncLaunchTask {
    public ReportLanguageSettingTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        e.a().getClass();
        int r101 = a.f431092f;
        b r102 = a.b.f431098a;
        Locale r103 = r102.getLanguageSetting();
        Locale r104 = r102.e();
        bpb.a r105 = bpb.a.f20002a;
        Intrinsics.checkNotNullParameter(r104, "systemLocale");
        JSONObject r106 = new JSONObject();
        r106.put("os_language", r104.toString());
        if (r103 != null) goto L15;
    L8:
        bpb.a.f20002a.getClass();     // Catch: Exception -> L10
        r106.put(EffectConfiguration.KEY_APP_LANGUAGE, bpb.a.a(r104));     // Catch: Exception -> L10
        r106.put("is_default", true);     // Catch: Exception -> L10
    L14:
    L12:
        r106.put("upload_type", "open");
        Statistics.sendEvent("setting_app_language_view", r106);
        Log.i("CoolBootGetLanguageHitPoint", r106.toString());
        return;
    L10:
        e = move-exception;
        Log.e(e.getMessage());
        goto L12
    L15:
        if (Intrinsics.areEqual(r103, r104) == true) goto L8;
        bpb.a.f20002a.getClass();     // Catch: Exception -> L10
        r106.put(EffectConfiguration.KEY_APP_LANGUAGE, bpb.a.a(r103));     // Catch: Exception -> L10
        r106.put("is_default", false);     // Catch: Exception -> L10
        goto L14
    }
}
