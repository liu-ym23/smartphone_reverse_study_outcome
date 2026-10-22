package com.larus.office.base.plugins.toolbar.model;

import com.obric.trace.ObricActionBarTrackType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
public interface ItemId {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0015\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/ItemId$ConstId;", "Lcom/larus/office/base/plugins/toolbar/model/ItemId;", "", "<init>", "(Ljava/lang/String;I)V", "unknown", ObricActionBarTrackType.KEY_BOARD, "separator", "itemName", "", "children", "", "()[Lcom/larus/office/base/plugins/toolbar/model/ItemId;", "displayMode", "Lcom/larus/office/base/plugins/toolbar/model/ItemId$DisplayMode;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ConstId extends Enum<ConstId> implements ItemId {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ConstId[] f360908a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f360909b = null;
        public static final ConstId keyboard = null;
        public static final ConstId separator = null;
        public static final ConstId unknown = null;

        public static EnumEntries<ConstId> getEntries() {
            return f360909b;
        }

        public ItemId[] children() {
            return null;
        }

        static {
            ConstId r100 = new ConstId("unknown", 0);
            unknown = r100;
            ConstId r101 = new ConstId(ObricActionBarTrackType.KEY_BOARD, 1);
            keyboard = r101;
            ConstId r102 = new ConstId("separator", 2);
            separator = r102;
            ConstId[] r103 = {r100, r101, r102};
            f360908a = r103;
            f360909b = EnumEntriesKt.enumEntries(r103);
        }

        public static ConstId[] values() {
            return (ConstId[]) f360908a.clone();
        }

        @Override // com.larus.office.base.plugins.toolbar.model.ItemId
        public String itemName() {
            return name();
        }

        @Override // com.larus.office.base.plugins.toolbar.model.ItemId
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/ItemId$DisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "SubToolBarV2", "FunctionPanel", "NoDisplay", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DisplayMode extends Enum<DisplayMode> {
        public static final DisplayMode FunctionPanel = null;
        public static final DisplayMode NoDisplay = null;
        public static final DisplayMode SubToolBarV2 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DisplayMode[] f360910a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f360911b = null;

        public static EnumEntries<DisplayMode> getEntries() {
            return f360911b;
        }

        static {
            DisplayMode r100 = new DisplayMode("SubToolBarV2", 0);
            SubToolBarV2 = r100;
            DisplayMode r101 = new DisplayMode("FunctionPanel", 1);
            FunctionPanel = r101;
            DisplayMode r102 = new DisplayMode("NoDisplay", 2);
            NoDisplay = r102;
            DisplayMode[] r103 = {r100, r101, r102};
            f360910a = r103;
            f360911b = EnumEntriesKt.enumEntries(r103);
        }

        public static DisplayMode[] values() {
            return (DisplayMode[]) f360910a.clone();
        }

        public static DisplayMode valueOf(String r100) {
            return (DisplayMode) r27.a.a(DisplayMode.class, r100);
        }

        public DisplayMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    DisplayMode displayMode();

    String itemName();
}
