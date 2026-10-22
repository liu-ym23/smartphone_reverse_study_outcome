package com.bytedance.pia.core.api.services;

import r27.a;
import s47.k;
import s47.q;

/* JADX INFO: loaded from: classes21.dex */
public interface IPiaLifeCycleService {

    public static final enum WarmupStage extends Enum<WarmupStage> {
        public static final WarmupStage Activate = null;
        public static final WarmupStage Load = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WarmupStage[] f266163a = null;

        static {
            WarmupStage r100 = new WarmupStage("Load", 0);
            Load = r100;
            WarmupStage r101 = new WarmupStage("Activate", 1);
            Activate = r101;
            f266163a = new WarmupStage[]{r100, r101};
        }

        public static WarmupStage[] values() {
            return (WarmupStage[]) f266163a.clone();
        }

        public static WarmupStage valueOf(String r100) {
            return (WarmupStage) a.a(WarmupStage.class, r100);
        }

        public WarmupStage(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean a(String r100);

    k b(String r100, String r101, Object r102);

    q c(String r100, String r101, Object r102);
}
