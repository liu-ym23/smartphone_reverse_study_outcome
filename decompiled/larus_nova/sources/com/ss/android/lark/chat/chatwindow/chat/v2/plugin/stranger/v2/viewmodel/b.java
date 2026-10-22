package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel;

import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerTagType;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f414509a = 0;

    static {
    }

    @JvmStatic
    public static final StrangerTagType a(Boolean r100, boolean r101, int r102) {
        if (r100 != null) goto L6;
        Log.e("ChatStrangerRelationVM", "canSetStranger value is null, show no tag!");
        return StrangerTagType.NONE;
    L6:
        if (r100.booleanValue() == true) goto L10;
        if (r101 == false) goto L18;
        return StrangerTagType.BLOCK;
    L18:
        return StrangerTagType.NONE;
    L10:
        if (r101 == false) goto L13;
        return StrangerTagType.TOTAL_BLOCK;
    L13:
        if (r102 != 2) goto L16;
        return StrangerTagType.STRANGER;
    L16:
        return StrangerTagType.NONE;
    }
}
