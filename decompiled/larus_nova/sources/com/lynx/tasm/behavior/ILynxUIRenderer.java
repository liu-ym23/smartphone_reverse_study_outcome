package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxUIRenderer {

    public static final enum RenderType extends Enum<RenderType> {
        public static final RenderType CLAY = null;
        public static final RenderType LYNX_UI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RenderType[] f381875a = null;

        static {
            RenderType r100 = new RenderType("LYNX_UI", 0);
            LYNX_UI = r100;
            RenderType r101 = new RenderType("CLAY", 1);
            CLAY = r101;
            f381875a = new RenderType[]{r100, r101};
        }

        public static RenderType[] values() {
            return (RenderType[]) f381875a.clone();
        }

        public static RenderType valueOf(String r100) {
            return (RenderType) r27.a.a(RenderType.class, r100);
        }

        public RenderType(String r100, int r101) {
            super(r100, r101);
        }
    }
}
