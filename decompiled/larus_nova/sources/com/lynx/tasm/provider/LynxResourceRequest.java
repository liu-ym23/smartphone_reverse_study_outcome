package com.lynx.tasm.provider;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxResourceRequest<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f383547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f383548b;

    public static final enum LynxResourceType extends Enum<LynxResourceType> {
        public static final LynxResourceType LynxResourceTypeDynamicComponent = null;
        public static final LynxResourceType LynxResourceTypeExternalJSSource = null;
        public static final LynxResourceType LynxResourceTypeFont = null;
        public static final LynxResourceType LynxResourceTypeI18NText = null;
        public static final LynxResourceType LynxResourceTypeImage = null;
        public static final LynxResourceType LynxResourceTypeLottie = null;
        public static final LynxResourceType LynxResourceTypeLynxCoreJS = null;
        public static final LynxResourceType LynxResourceTypeSVG = null;
        public static final LynxResourceType LynxResourceTypeTemplate = null;
        public static final LynxResourceType LynxResourceTypeTheme = null;
        public static final LynxResourceType LynxResourceTypeVideo = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxResourceType[] f383549a = null;

        static {
            LynxResourceType r100 = new LynxResourceType("LynxResourceTypeImage", 0);
            LynxResourceTypeImage = r100;
            LynxResourceType r101 = new LynxResourceType("LynxResourceTypeFont", 1);
            LynxResourceTypeFont = r101;
            LynxResourceType r102 = new LynxResourceType("LynxResourceTypeLottie", 2);
            LynxResourceTypeLottie = r102;
            LynxResourceType r103 = new LynxResourceType("LynxResourceTypeVideo", 3);
            LynxResourceTypeVideo = r103;
            LynxResourceType r104 = new LynxResourceType("LynxResourceTypeSVG", 4);
            LynxResourceTypeSVG = r104;
            LynxResourceType r105 = new LynxResourceType("LynxResourceTypeTemplate", 5);
            LynxResourceTypeTemplate = r105;
            LynxResourceType r110 = new LynxResourceType("LynxResourceTypeLynxCoreJS", 6);
            LynxResourceTypeLynxCoreJS = r110;
            LynxResourceType r111 = new LynxResourceType("LynxResourceTypeDynamicComponent", 7);
            LynxResourceTypeDynamicComponent = r111;
            LynxResourceType r112 = new LynxResourceType("LynxResourceTypeI18NText", 8);
            LynxResourceTypeI18NText = r112;
            LynxResourceType r113 = new LynxResourceType("LynxResourceTypeTheme", 9);
            LynxResourceTypeTheme = r113;
            LynxResourceType r114 = new LynxResourceType("LynxResourceTypeExternalJSSource", 10);
            LynxResourceTypeExternalJSSource = r114;
            f383549a = new LynxResourceType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static LynxResourceType[] values() {
            return (LynxResourceType[]) f383549a.clone();
        }

        public static LynxResourceType valueOf(String r100) {
            return (LynxResourceType) a.a(LynxResourceType.class, r100);
        }

        public LynxResourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LynxResourceRequest(String r100) {
        this.f383547a = r100;
    }

    public LynxResourceRequest(String r100, T r101) {
        this.f383547a = r100;
        this.f383548b = r101;
    }
}
