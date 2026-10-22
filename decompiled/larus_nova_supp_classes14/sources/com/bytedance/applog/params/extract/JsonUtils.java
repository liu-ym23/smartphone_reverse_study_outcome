package com.bytedance.applog.params.extract;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class JsonUtils {
    static {
    }

    public static List a(JSONObject r7) {
        if (r7 == null) goto L4;
        Object r8 = r7.opt("__applog_cp_ids");
        if (r8 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if ((r8 instanceof String) == false) goto L19;
        if (((CharSequence) r8).length() <= 0) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == false) goto L19;
        return CollectionsKt.listOf(r8);
    L14:
        r0 = false;
    L19:
        if ((r8 instanceof JSONArray) == false) goto L21;
        JSONArray r9 = (JSONArray) r8;
    L22:
        if (r9 == null) goto L24;
        ArrayList r1 = new ArrayList(r9.length());
        int r3 = r9.length();
        int r4 = 0;
    L26:
        if (r4 >= r3) goto L36;
        Object r5 = r9.opt(r4);
        if ((r5 instanceof String) == false) goto L35;
        if (((CharSequence) r5).length() <= 0) goto L32;
        boolean r6 = true;
    L33:
        if (r6 == false) goto L35;
        r1.add(r5);
        goto L35
    L32:
        r6 = false;
    L35:
        r4 = r4 + 1;
        goto L26
    L36:
        return r1;
    L24:
        return CollectionsKt.emptyList();
    L21:
        r9 = null;
        goto L22
    L4:
        return CollectionsKt.emptyList();
    }

    public static Sequence b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "obj");
        return SequencesKt.sequence(new JsonUtils$keysOf$1(r2, null));
    }
}
