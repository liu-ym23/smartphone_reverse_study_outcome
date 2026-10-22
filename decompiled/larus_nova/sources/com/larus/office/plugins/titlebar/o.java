package com.larus.office.plugins.titlebar;

import com.bytedance.ee.bear.document.y3;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.ee.bear.more.protocol3.panel.x f363552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f363553b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f363554c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f363555d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f363556e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f363557f = 0;

    static {
        f363553b = new LinkedHashMap();
        f363554c = R.string.larus_LarkIM_Feed_InteractiveMsg_Title;
        f363555d = R.string.larus_aiDoc_tts;
        f363556e = R.string.larus_aiDoc_podcast;
        f363557f = R.string.larus_appEntry_3rdPartyApp_menuOption_report;
    }

    public static Integer a(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        y3 r101 = (y3) r100.getHostAbilityOrNull(y3.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r101.getDocumentTypeValue());
    }
}
