package com.ss.android.lark.message.card.utils;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.content.CardContent;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f431928a = 0;

    static {
    }

    public static boolean a(CardContent.CardHeader r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r100.getMainTitle()) == true) goto L8;
    L10:
        return false;
    L8:
        if (TextUtils.isEmpty(r100.getTitle()) == false) goto L10;
        return true;
    }
}
