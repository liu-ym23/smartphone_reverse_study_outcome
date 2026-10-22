package com.ss.android.lark.chat.entity.image;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(ImageSet r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getResourceCleanScene() == null) goto L6;
        return true;
    L6:
        return r100.resourceIsCleaned;
    }
}
