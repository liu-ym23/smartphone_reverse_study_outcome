package com.ss.android.lark.chatwindow.view.tip;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class NewMessageTipUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f417087a = 0;

    static {
    }

    public static String a(List r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, NewMessageTipUtils$logMessageIds$1.INSTANCE, 30, null);
    }
}
