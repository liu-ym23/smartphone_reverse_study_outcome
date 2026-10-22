package com.relax.uirender;

import java.util.HashMap;
import r27.a;
import rpa.b;

/* JADX INFO: loaded from: classes34.dex */
public final class UIRenderRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<RenderType, b> f405703a = null;

    public static final enum RenderType extends Enum<RenderType> {
        public static final RenderType CLAY = null;
        public static final RenderType LYNX_UI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RenderType[] f405704a = null;

        static {
            RenderType r100 = new RenderType("CLAY", 0);
            CLAY = r100;
            RenderType r101 = new RenderType("LYNX_UI", 1);
            LYNX_UI = r101;
            f405704a = new RenderType[]{r100, r101};
        }

        public static RenderType[] values() {
            return (RenderType[]) f405704a.clone();
        }

        public static RenderType valueOf(String r100) {
            return (RenderType) a.a(RenderType.class, r100);
        }

        public RenderType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f405703a = new HashMap();
    }
}
