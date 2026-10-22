package com.ss.android.lark.statistics.perf;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f440768a = null;

    static {
        f440768a = new CopyOnWriteArrayList();
    }

    @JvmStatic
    public static final void a(String r100, MessageInfo r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "messageInfo");
        Iterator<a> r103 = f440768a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().b(r100, r101, r102);
        goto L4
    }
}
