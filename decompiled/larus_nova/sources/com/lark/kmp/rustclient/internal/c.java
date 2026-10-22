package com.lark.kmp.rustclient.internal;

import com.bytedance.larksuite.wire.CommandScope;
import com.lark.kmp.pb.basic.v1.Command;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f282549a = null;

        static {
            int[] r100 = new int[CommandScope.values().length];
            r100[CommandScope.GlobalScope.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CommandScope.UserScope.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f282549a = r100;
        }
    }

    public static final CommandScope a(Command r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<Command, CommandScope> r101 = be6.a.f18742a;
        Intrinsics.checkNotNullParameter(r100, "command");
        CommandScope r102 = be6.a.f18742a.get(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IllegalStateException("Command scope not found for: $command".toString());
    }
}
