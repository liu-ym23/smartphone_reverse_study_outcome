package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.entity.message.AIRecommendQuestions;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class n0 implements z, com.ss.android.lark.passportc.api.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.m f414630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Long, a> f414631b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AIRecommendQuestions f414632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<a0> f414633b;

        public a(AIRecommendQuestions r100, ArrayList<a0> r101) {
            Intrinsics.checkNotNullParameter(r101, "pushListener");
            this.f414632a = r100;
            this.f414633b = r101;
        }
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final com.ss.android.lark.passportc.api.m getPassport() {
        return this.f414630a;
    }

    @Inject
    public n0(com.ss.android.lark.passportc.api.m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.f414630a = r100;
        this.f414631b = new ConcurrentHashMap();
        r100.d(this);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.z
    public final AIRecommendQuestions kf(long r100) {
        a r101 = this.f414631b.get(Long.valueOf(r100));
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f414632a;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.z
    public void update(long r100, AIRecommendQuestions r101) {
        Intrinsics.checkNotNullParameter(r101, "aIRecommendQuestions");
        ConcurrentHashMap<Long, a> r102 = this.f414631b;
        Long r103 = Long.valueOf(r100);
        a r104 = r102.get(r103);
        if (r104 != null) goto L8;
        r104 = new a(r101, new ArrayList());
        a r105 = r102.putIfAbsent(r103, r104);
        if (r105 == null) goto L8;
        r104 = r105;
    L8:
        a r106 = r104;
        r106.f414632a = r101;
        Iterator<T> r107 = r106.f414633b.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        ((a0) r107.next()).a();
        goto L10
    }
}
