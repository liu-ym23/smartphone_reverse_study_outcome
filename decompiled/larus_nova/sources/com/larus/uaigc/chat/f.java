package com.larus.uaigc.chat;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements qd8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f370815a;

    public f() {
        this.f370815a = new LinkedHashSet();
    }

    @Override // qd8.a
    public final void u(String r110, String r111, String r112, Boolean r113, String r210, String r211, String r212, Integer r213, String r214, String r215, JSONObject r216, by7.e r217, Boolean r218, Boolean r219) {
        Intrinsics.checkNotNullParameter(r216, "params");
        if (this.f370815a.contains(r110) == false) goto L5;
        return;
    L5:
        this.f370815a.add(r110);
        a4.f(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r218, r219, 16762880);
    }
}
