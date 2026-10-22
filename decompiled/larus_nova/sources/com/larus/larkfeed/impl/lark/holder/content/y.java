package com.larus.larkfeed.impl.lark.holder.content;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class y implements rd8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kh8.a f355422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f355423b;

    @Override // rd8.b
    public final kh8.a q3() {
        return this.f355422a;
    }

    public y(kh8.a r100, Fragment r101) {
        this.f355422a = r100;
        this.f355423b = r101;
    }

    @Override // rd8.b
    public final void u(String r110, String r111, String r112, Boolean r113, String r210, String r211, String r212, Integer r213, String r214, String r215, JSONObject r216, by7.e r217, Boolean r218, Boolean r219) {
        Intrinsics.checkNotNullParameter(r216, "params");
        Fragment r100 = this.f355423b;
        if (r100 == null) goto L10;
        t1a.b r101 = s1a.a.g(r100);
        if (r101 == null) goto L11;
        u99.a r102 = (u99.a) r101.getAbility(u99.a.class);
        if (r102 == null) goto L12;
        r102.jh(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r218, r219);
        return;
    L12:
        return;
    L11:
        return;
    }
}
