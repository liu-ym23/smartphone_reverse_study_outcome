package com.bytedance.ee.bear.appsetting;

import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<Boolean> f206261a;

    public static final class a implements jdb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f206262a;

        public a(j r100) {
            this.f206262a = r100;
        }

        @Override // jdb.c
        public final void a(boolean r100) {
            this.f206262a.a(r100);
        }
    }

    public static final class b {
    }

    static {
    }

    public j(jdb.g r100) {
        Intrinsics.checkNotNullParameter(r100, "userFg");
        this.f206261a = BehaviorSubject.create();
        a(r100.isCurrentEnable(EmergencyFixConfig.SETTING_FG));
        r100.addFeatureGatingUpdateListener(EmergencyFixConfig.SETTING_FG, new a(this), "_normal_fg");
    }

    public final void a(boolean r100) {
        tt5.a.h("EmergencyFixConfigHandler", "handleConfigRelatedFG: " + r100);
        this.f206261a.onNext(Boolean.valueOf(r100));
    }
}
