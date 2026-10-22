package com.bytedance.ee.bear.templates;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final boolean a(String r100) {
        if (Intrinsics.areEqual("lark_survey", r100) == false) goto L5;
    L14:
        return true;
    L5:
        if (Intrinsics.areEqual("base_hp_create_form", r100) == true) goto L14;
        if (Intrinsics.areEqual("base_im_plus_create_template_show", r100) == true) goto L14;
        if (Intrinsics.areEqual("space_home_create_form", r100) == true) goto L14;
        if (Intrinsics.areEqual("wiki_home_create_form", r100) == true) goto L14;
        return false;
    }
}
