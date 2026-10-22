package fmb;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f477890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f477891b;

    /* JADX INFO: renamed from: fmb.a$a, reason: collision with other inner class name */
    public static class C5930a extends fn4.a {
        @Override // com.bytedance.ee.bear.appsetting.m
        public final void c() {
        }

        public C5930a() {
        }

        @Override // com.bytedance.ee.bear.appsetting.m
        public final boolean b(String r100, boolean r101, boolean r102) {
            if (r102 == false) goto L4;
            boolean r103 = FeatureGatingModule.getFeatureGatingService().isEnable(r100);
        L5:
            tt5.a.h("LarkFGRepository", "getBoolean, key = " + r100 + ", value = " + r103 + ", consistent = " + r102);
            return r103;
        L4:
            r103 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r100);
            goto L5
        }
    }

    static {
        f477890a = new Object();
    }
}
