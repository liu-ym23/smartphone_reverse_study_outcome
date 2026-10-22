package com.ss.android.lark.chat.cot.detail;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f414980b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Boolean> f414981a;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public j() {
        this.f414981a = new HashMap();
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Boolean r101 = this.f414981a.get(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.booleanValue();
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        return a(r100 + "#group");
    }
}
