package com.lynx.tasm.resourceprovider;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxResourceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f383704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxResourceType f383705b;

    public static final enum AsyncMode extends Enum<AsyncMode> {
        public static final AsyncMode EXACTLY_ASYNC = null;
        public static final AsyncMode EXACTLY_SYNC = null;
        public static final AsyncMode MOST_SYNC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AsyncMode[] f383706a = null;

        static {
            AsyncMode r100 = new AsyncMode("EXACTLY_ASYNC", 0);
            EXACTLY_ASYNC = r100;
            AsyncMode r101 = new AsyncMode("EXACTLY_SYNC", 1);
            EXACTLY_SYNC = r101;
            AsyncMode r102 = new AsyncMode("MOST_SYNC", 2);
            MOST_SYNC = r102;
            f383706a = new AsyncMode[]{r100, r101, r102};
        }

        public static AsyncMode[] values() {
            return (AsyncMode[]) f383706a.clone();
        }

        public static AsyncMode valueOf(String r100) {
            return (AsyncMode) a.a(AsyncMode.class, r100);
        }

        public AsyncMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum LynxResourceType extends Enum<LynxResourceType> {
        public static final LynxResourceType LynxResourceTypeDynamicComponent = null;
        public static final LynxResourceType LynxResourceTypeExternalByteCode = null;
        public static final LynxResourceType LynxResourceTypeExternalJSSource = null;
        public static final LynxResourceType LynxResourceTypeFont = null;
        public static final LynxResourceType LynxResourceTypeGeneric = null;
        public static final LynxResourceType LynxResourceTypeI18NText = null;
        public static final LynxResourceType LynxResourceTypeImage = null;
        public static final LynxResourceType LynxResourceTypeLottie = null;
        public static final LynxResourceType LynxResourceTypeLynxCoreJS = null;
        public static final LynxResourceType LynxResourceTypeSVG = null;
        public static final LynxResourceType LynxResourceTypeTemplate = null;
        public static final LynxResourceType LynxResourceTypeTheme = null;
        public static final LynxResourceType LynxResourceTypeVideo = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxResourceType[] f383707a = null;

        static {
            LynxResourceType r100 = new LynxResourceType("LynxResourceTypeGeneric", 0);
            LynxResourceTypeGeneric = r100;
            LynxResourceType r101 = new LynxResourceType("LynxResourceTypeImage", 1);
            LynxResourceTypeImage = r101;
            LynxResourceType r102 = new LynxResourceType("LynxResourceTypeFont", 2);
            LynxResourceTypeFont = r102;
            LynxResourceType r103 = new LynxResourceType("LynxResourceTypeLottie", 3);
            LynxResourceTypeLottie = r103;
            LynxResourceType r104 = new LynxResourceType("LynxResourceTypeVideo", 4);
            LynxResourceTypeVideo = r104;
            LynxResourceType r105 = new LynxResourceType("LynxResourceTypeSVG", 5);
            LynxResourceTypeSVG = r105;
            LynxResourceType r110 = new LynxResourceType("LynxResourceTypeTemplate", 6);
            LynxResourceTypeTemplate = r110;
            LynxResourceType r111 = new LynxResourceType("LynxResourceTypeLynxCoreJS", 7);
            LynxResourceTypeLynxCoreJS = r111;
            LynxResourceType r112 = new LynxResourceType("LynxResourceTypeDynamicComponent", 8);
            LynxResourceTypeDynamicComponent = r112;
            LynxResourceType r113 = new LynxResourceType("LynxResourceTypeI18NText", 9);
            LynxResourceTypeI18NText = r113;
            LynxResourceType r114 = new LynxResourceType("LynxResourceTypeTheme", 10);
            LynxResourceTypeTheme = r114;
            LynxResourceType r115 = new LynxResourceType("LynxResourceTypeExternalJSSource", 11);
            LynxResourceTypeExternalJSSource = r115;
            LynxResourceType r106 = new LynxResourceType("LynxResourceTypeExternalByteCode", 12);
            LynxResourceTypeExternalByteCode = r106;
            f383707a = new LynxResourceType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        }

        public static LynxResourceType[] values() {
            return (LynxResourceType[]) f383707a.clone();
        }

        public static LynxResourceType valueOf(String r100) {
            return (LynxResourceType) a.a(LynxResourceType.class, r100);
        }

        public LynxResourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LynxResourceRequest(String r100, LynxResourceType r101) {
        this.f383704a = r100;
        this.f383705b = r101;
    }
}
