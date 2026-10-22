package com.ss.android.lark.integrator.ccm.dependency.di;

import androidx.fragment.app.FragmentActivity;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class d1 implements sk5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f427847a;

    public static final class a {
    }

    public static final class b implements sk5.c {
        public b() {
        }

        @Override // sk5.a
        public final boolean f(String r100) {
            return true;
        }

        @Override // sk5.a
        public final boolean isDebugMode() {
            return false;
        }

        @Override // sk5.a
        public final void b() {
            tt5.a.h("OfficeOnBoarding", "clearNativePreferenceCache ignored for office host");
        }

        @Override // sk5.c
        public final Flowable<sk5.a> e() {
            return Flowable.empty();
        }

        @Override // sk5.a
        public final Map<String, Boolean> h() {
            return Collections.emptyMap();
        }

        @Override // sk5.a
        public final void c(String r100) {
            tt5.a.h("OfficeOnBoarding", "setMissionFinished ignored for office host, missionId=" + r100);
        }

        @Override // sk5.a
        public final void d(com.bytedance.ee.bear.document.onboarding.b r100) {
            StringBuilder r101 = new StringBuilder("dismiss ignored for office host, mission=");
            if (r100 == null) goto L5;
            String r102 = r100.getId();
        L6:
            r101.append(r102);
            tt5.a.h("OfficeOnBoarding", r101.toString());
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // sk5.a
        public final void i(List<String> r100) {
            tt5.a.h("OfficeOnBoarding", "setMissionFinished(list) ignored for office host, size=" + Integer.valueOf(((ArrayList) r100).size()));
        }

        @Override // sk5.a
        public final void a(tk5.d r100, com.bytedance.ee.bear.document.onboarding.c r101) {
            StringBuilder r102 = new StringBuilder("post(ui) ignored for office host, mission=");
            if (r100 == null) goto L5;
            String r103 = r100.getId();
        L6:
            r102.append(r103);
            tt5.a.h("OfficeOnBoarding", r102.toString());
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // sk5.a
        public final void g(tk5.d<vk5.a> r100, FragmentActivity r101) {
            StringBuilder r102 = new StringBuilder("post(activity) ignored for office host, mission=");
            if (r100 == null) goto L5;
            String r103 = r100.getId();
        L6:
            r102.append(r103);
            tt5.a.h("OfficeOnBoarding", r102.toString());
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    @Override // sk5.b
    public final void a() {
        tt5.a.h("OfficeOnBoarding", "onDocInit ignored for office host");
    }

    @Inject
    public d1() {
        this.f427847a = new b();
    }

    @Override // sk5.b
    public final sk5.c b() {
        return this.f427847a;
    }

    @Override // sk5.b
    public final void init(Map r100) {
        StringBuilder r101 = new StringBuilder("init ignored for office host, colorStyleSize=");
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.size());
    L6:
        r101.append(r102);
        tt5.a.h("OfficeOnBoarding", r101.toString());
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // sk5.b
    public final void c(String r100, String r101) {
        tt5.a.h("OfficeOnBoarding", "changeUserAccount ignored for office host, uid=" + r101);
    }
}
