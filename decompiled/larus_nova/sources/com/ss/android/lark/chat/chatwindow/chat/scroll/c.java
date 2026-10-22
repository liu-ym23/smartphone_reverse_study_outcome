package com.ss.android.lark.chat.chatwindow.chat.scroll;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static final boolean a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.computeVerticalScrollExtent() + r100.computeVerticalScrollOffset()) >= r100.computeVerticalScrollRange()) goto L6;
        return false;
    L6:
        return true;
    L11:
        return false;
    }
}
