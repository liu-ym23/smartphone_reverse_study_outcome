package com.bytedance.ee.bear.document.model.toolbar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface ItemIdV2 {

    public static final enum ConstId extends Enum<ConstId> implements ItemIdV2 {
        public static final /* synthetic */ ConstId[] a = null;
        public static final ConstId keyboard = null;
        public static final ConstId separator = null;
        public static final ConstId unknown = null;

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public ItemIdV2[] children() {
            return null;
        }

        static {
            ConstId r0 = new ConstId("unknown", 0);
            unknown = r0;
            ConstId r1 = new ConstId("keyboard", 1);
            keyboard = r1;
            ConstId r3 = new ConstId("separator", 2);
            separator = r3;
            a = new ConstId[]{r0, r1, r3};
        }

        public static ConstId[] values() {
            return (ConstId[]) a.clone();
        }

        @Override // com.bytedance.ee.bear.document.model.toolbar.ItemIdV2
        public DisplayMode displayMode() {
            return DisplayMode.NoDisplay;
        }

        public static ConstId valueOf(String r1) {
            return (ConstId) r27.a.a(ConstId.class, r1);
        }

        public ConstId(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum DisplayMode extends Enum<DisplayMode> {
        public static final DisplayMode FunctionPanel = null;
        public static final DisplayMode NoDisplay = null;
        public static final DisplayMode SubToolBarV2 = null;
        public static final /* synthetic */ DisplayMode[] a = null;

        static {
            DisplayMode r0 = new DisplayMode("SubToolBarV2", 0);
            SubToolBarV2 = r0;
            DisplayMode r1 = new DisplayMode("FunctionPanel", 1);
            FunctionPanel = r1;
            DisplayMode r3 = new DisplayMode("NoDisplay", 2);
            NoDisplay = r3;
            a = new DisplayMode[]{r0, r1, r3};
        }

        public static DisplayMode[] values() {
            return (DisplayMode[]) a.clone();
        }

        public static DisplayMode valueOf(String r1) {
            return (DisplayMode) r27.a.a(DisplayMode.class, r1);
        }

        public DisplayMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a extends ItemIdV2 {
    }

    ItemIdV2[] children();

    DisplayMode displayMode();

    String name();
}
