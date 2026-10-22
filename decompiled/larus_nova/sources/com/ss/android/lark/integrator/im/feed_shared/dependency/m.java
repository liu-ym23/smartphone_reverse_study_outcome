package com.ss.android.lark.integrator.im.feed_shared.dependency;

import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.BadgeStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements peb.b.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<peb.b.h, zob.b> f427946a;

    @Override // peb.b.k
    public final void a() {
    }

    @Override // peb.b.k
    public final void d() {
    }

    @Override // peb.b.k
    public final boolean b() {
        com.ss.android.lark.usersetting.service.e.a.f444639a.getClass();
        Object r100 = com.ss.android.lark.usersetting.service.badgestyle.a.f444630c;
        com.ss.android.lark.usersetting.service.badgestyle.a.b.f444634a.getClass();
        UserSetting r101 = aac.g.d.f2395a.f2389a.a();
        if (r101 != null) goto L5;
        BadgeStyle r102 = BadgeStyle.STRONG_REMIND;
    L7:
        if (r102 != BadgeStyle.STRONG_REMIND) goto L9;
        return true;
    L9:
        return false;
    L5:
        r102 = r101.getBadgeStyle();
        goto L7
    }

    public m() {
        this.f427946a = new HashMap();
    }

    @Override // peb.b.k
    public final Locale getCacheLanguageSetting() {
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        return com.ss.android.lark.language.service.impl.a.b.f431098a.getCacheLanguageSetting();
    }

    @Override // peb.b.k
    public final void c(final peb.b.h r100) {
        zob.b r101 = new l(r100);
        ((HashMap) this.f427946a).put(r100, r101);
        yob.e.a().getClass();
        int r102 = com.ss.android.lark.language.service.impl.a.f431092f;
        com.ss.android.lark.language.service.impl.a.b.f431098a.c(r101);
    }

    @Override // peb.b.k
    public final boolean isInZenMode(long r100) {
        nmb.a.a().getCoreDependency().p();
        return false;
    }
}
