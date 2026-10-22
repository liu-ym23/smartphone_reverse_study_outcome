package com.obric.assistant.cocreationreview.modules.memory;

import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.android.cert.manager.constants.EventConstant;
import hda.q0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f387426a = 0;

    static {
    }

    public static String a(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L15:
        return null;
    L5:
        if (r100.isNull(r101) == true) goto L15;
        String r102 = r100.optString(r101);
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
    L12:
        r103 = false;
    L13:
        if (r103 == false) goto L15;
        return r102;
    L10:
        if (Intrinsics.areEqual(r102, "null") == true) goto L12;
        goto L12
    }

    public static List b(JSONArray r210, MemoryDataReviewModuleKey r211) {
        if (r210 == null) goto L5;
        ArrayList r100 = new ArrayList();
        int r101 = r210.length();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L39;
        JSONObject r103 = r210.optJSONObject(r102);
        if (r103 == null) goto L38;
        MemoryDataReviewModuleKey.a r104 = MemoryDataReviewModuleKey.Companion;
        String r105 = a(r103, EventConstant.Key.MODULE);
        r104.getClass();
        MemoryDataReviewModuleKey[] r106 = MemoryDataReviewModuleKey.values();
        int r107 = r106.length;
        int r108 = 0;
    L12:
        String r110 = null;
        if (r108 >= r107) goto L18;
        MemoryDataReviewModuleKey r111 = r106[r108];
        if (Intrinsics.areEqual(r111.getRaw(), r105) == true) goto L19;
        r108 = r108 + 1;
    L19:
        if (r111 != null) goto L21;
        MemoryDataReviewModuleKey r112 = r211;
    L22:
        String r109 = a(r103, "cardPayloadJson");
        if (r109 != null) goto L30;
        Object r113 = r103.opt("cardPayload");
        if (r113 == null) goto L27;
        r109 = r113.toString();
    L28:
        if (r109 != null) goto L30;
        r109 = SliceInitService.DEFAULT_SWITCH;
        goto L30
    L27:
        r109 = null;
    L30:
        String r114 = r109;
        String r115 = r103.optString("recordId");
        String r116 = a(r103, "title");
        String r117 = a(r103, "summary");
        MemoryReviewFeedbackState.a r118 = MemoryReviewFeedbackState.Companion;
        String r119 = a(r103, "feedbackState");
        r118.getClass();
        MemoryReviewFeedbackState r120 = MemoryReviewFeedbackState.a.a(r119);
        String r121 = a(r103, "traceJson");
        if (r121 != null) goto L36;
        Object r122 = r103.opt("trace");
        if (r122 == null) goto L35;
        r110 = r122.toString();
    L35:
        String r123 = r110;
    L37:
        r100.add(new q0(r115, r112, r116, r117, r114, r120, r123, r103.optLong("updateTimeMillis", 0)));
        goto L38
    L36:
        r123 = r121;
        goto L37
    L21:
        r112 = r111;
        goto L22
    L18:
        r111 = null;
    L38:
        r102 = r102 + 1;
        goto L7
    L39:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }
}
