package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.larksuite.wire.CommandScope;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253973a = null;

        static {
            int[] r100 = new int[CommandScope.values().length];
            r100[CommandScope.GlobalScope.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CommandScope.UserScope.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f253973a = r100;
        }
    }

    public static final CommandScope a(Command r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getName();
        CommandScope r102 = (CommandScope) ((HashMap) je6.a.f498830a).get(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return CommandScope.UserScope;
    }
}
