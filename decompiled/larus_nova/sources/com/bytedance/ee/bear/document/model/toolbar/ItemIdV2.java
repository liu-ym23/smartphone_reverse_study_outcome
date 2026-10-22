package com.bytedance.ee.bear.document.model.toolbar;

import com.obric.trace.ObricActionBarTrackType;

/* JADX INFO: loaded from: classes16.dex */
public interface ItemIdV2 {

    public static final enum ConstId extends Enum<ConstId> implements ItemIdV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ConstId[] f220258a = null;
        public static final ConstId keyboard = null;
        public static final ConstId separator = null;
        public static final ConstId unknown = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            ConstId r100 = new ConstId("unknown", 0);
            unknown = r100;
            ConstId r101 = new ConstId(ObricActionBarTrackType.KEY_BOARD, 1);
            keyboard = r101;
            ConstId r102 = new ConstId("separator", 2);
            separator = r102;
            f220258a = new ConstId[]{r100, r101, r102};
        }

        public static ConstId[] values() {
            return (ConstId[]) f220258a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public DisplayMode displayMode() {
            return DisplayMode.NoDisplay;
        }

        public static ConstId valueOf(String r100) {
            return (ConstId) r27.a.a(ConstId.class, r100);
        }

        public ConstId(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum DisplayMode extends Enum<DisplayMode> {
        public static final DisplayMode FunctionPanel = null;
        public static final DisplayMode NoDisplay = null;
        public static final DisplayMode SubToolBarV2 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DisplayMode[] f220259a = null;

        static {
            DisplayMode r100 = new DisplayMode("SubToolBarV2", 0);
            SubToolBarV2 = r100;
            DisplayMode r101 = new DisplayMode("FunctionPanel", 1);
            FunctionPanel = r101;
            DisplayMode r102 = new DisplayMode("NoDisplay", 2);
            NoDisplay = r102;
            f220259a = new DisplayMode[]{r100, r101, r102};
        }

        public static DisplayMode[] values() {
            return (DisplayMode[]) f220259a.clone();
        }

        public static DisplayMode valueOf(String r100) {
            return (DisplayMode) r27.a.a(DisplayMode.class, r100);
        }

        public DisplayMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a extends ItemIdV2 {
    }

    ItemIdV2[] children();

    DisplayMode displayMode();

    String name();
}
