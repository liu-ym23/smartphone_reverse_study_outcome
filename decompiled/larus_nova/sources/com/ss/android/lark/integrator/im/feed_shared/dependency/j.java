package com.ss.android.lark.integrator.im.feed_shared.dependency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements peb.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<peb.c, com.ss.android.lark.usersetting.service.badgestyle.c> f427943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<peb.c, com.ss.android.lark.usersetting.service.badgestyle.d> f427944b;

    @Override // peb.b.i
    public final void a() {
    }

    public j() {
        this.f427943a = new ConcurrentHashMap();
        this.f427944b = new ConcurrentHashMap();
    }

    @Override // peb.b.i
    public final void b(final afb.b.a r100) {
        com.ss.android.lark.usersetting.service.badgestyle.c r101 = new h(r100);
        com.ss.android.lark.usersetting.service.badgestyle.d r102 = new i(r100);
        ((ConcurrentHashMap) this.f427943a).put(r100, r101);
        ((ConcurrentHashMap) this.f427944b).put(r100, r102);
        com.ss.android.lark.usersetting.service.e.a.f444639a.getClass();
        Object r103 = com.ss.android.lark.usersetting.service.badgestyle.a.f444630c;
        com.ss.android.lark.usersetting.service.badgestyle.a r104 = com.ss.android.lark.usersetting.service.badgestyle.a.b.f444634a;
        Map<com.ss.android.lark.usersetting.service.badgestyle.c, Object> r105 = r104.f444631a;
        Object r106 = com.ss.android.lark.usersetting.service.badgestyle.a.f444630c;
        ((ConcurrentHashMap) r105).put(r101, r106);
        ((ConcurrentHashMap) r104.f444632b).put(r102, r106);
    }
}
