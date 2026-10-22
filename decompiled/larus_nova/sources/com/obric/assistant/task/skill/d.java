package com.obric.assistant.task.skill;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f393407a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r100, "obric_phone_operation_skill_", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
