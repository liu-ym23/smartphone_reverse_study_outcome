package com.bytedance.dux.api;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006'"}, d2 = {"Lcom/bytedance/dux/api/DuxComponent;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "DIALOG", "BUTTON", "SWITCH", "ACTION_SHEET", "BADGE", "TOAST", "TITLE_BAR", "POPOVER_MENU", "TAB_BAR", "SEARCH_BAR", "FORM_ITEMS", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "RADIO", "CHECK_BOX", "INFO_PANEL", "BOTTOM_NOTIFICATION", "TOOLTIPS", "TAG", "STEPPERS", "AVATAR", "TIPS", "BASIC_PANEL", "PICKER", "SELECTION", "FILTER_PANEL", "PROGRESS_INDICATOR", "CAROUSEL_INDICATOR", "UPLOADER", "FEEDBACK", "SLIDER", "VACANT_VIEW", "PLACEHOLDER", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum DuxComponent extends Enum<DuxComponent> {
    public static final DuxComponent ACTION_SHEET = null;
    public static final DuxComponent AVATAR = null;
    public static final DuxComponent BADGE = null;
    public static final DuxComponent BASIC_PANEL = null;
    public static final DuxComponent BOTTOM_NOTIFICATION = null;
    public static final DuxComponent BUTTON = null;
    public static final DuxComponent CAROUSEL_INDICATOR = null;
    public static final DuxComponent CHECK_BOX = null;
    public static final DuxComponent DIALOG = null;
    public static final DuxComponent FEEDBACK = null;
    public static final DuxComponent FILTER = null;
    public static final DuxComponent FILTER_PANEL = null;
    public static final DuxComponent FORM_ITEMS = null;
    public static final DuxComponent INFO_PANEL = null;
    public static final DuxComponent PICKER = null;
    public static final DuxComponent PLACEHOLDER = null;
    public static final DuxComponent POPOVER_MENU = null;
    public static final DuxComponent PROGRESS_INDICATOR = null;
    public static final DuxComponent RADIO = null;
    public static final DuxComponent SEARCH_BAR = null;
    public static final DuxComponent SELECTION = null;
    public static final DuxComponent SLIDER = null;
    public static final DuxComponent STEPPERS = null;
    public static final DuxComponent SWITCH = null;
    public static final DuxComponent TAB_BAR = null;
    public static final DuxComponent TAG = null;
    public static final DuxComponent TIPS = null;
    public static final DuxComponent TITLE_BAR = null;
    public static final DuxComponent TOAST = null;
    public static final DuxComponent TOOLTIPS = null;
    public static final DuxComponent UPLOADER = null;
    public static final DuxComponent VACANT_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DuxComponent[] f204805a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f204806id;

    public static DuxComponent valueOf(String r100) {
        return (DuxComponent) a.a(DuxComponent.class, r100);
    }

    public static DuxComponent[] values() {
        return (DuxComponent[]) f204805a.clone();
    }

    static {
        DuxComponent r100 = new DuxComponent("DIALOG", 0, "DuxDialog");
        DIALOG = r100;
        DuxComponent r101 = new DuxComponent("BUTTON", 1, "DuxButton");
        BUTTON = r101;
        DuxComponent r102 = new DuxComponent("SWITCH", 2, "DuxSwitch");
        SWITCH = r102;
        DuxComponent r103 = new DuxComponent("ACTION_SHEET", 3, "DuxActionSheet");
        ACTION_SHEET = r103;
        DuxComponent r104 = new DuxComponent("BADGE", 4, "DuxBadge");
        BADGE = r104;
        DuxComponent r105 = new DuxComponent("TOAST", 5, "DuxToast");
        TOAST = r105;
        DuxComponent r110 = new DuxComponent("TITLE_BAR", 6, "DuxTitleBar");
        TITLE_BAR = r110;
        DuxComponent r111 = new DuxComponent("POPOVER_MENU", 7, "DuxPopoverMenu");
        POPOVER_MENU = r111;
        DuxComponent r112 = new DuxComponent("TAB_BAR", 8, "DuxTabLayout");
        TAB_BAR = r112;
        DuxComponent r113 = new DuxComponent("SEARCH_BAR", 9, "DuxSearchBar");
        SEARCH_BAR = r113;
        DuxComponent r114 = new DuxComponent("FORM_ITEMS", 10, "DuxForms");
        FORM_ITEMS = r114;
        DuxComponent r106 = new DuxComponent(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 11, "DuxFilter");
        FILTER = r106;
        DuxComponent r107 = new DuxComponent("RADIO", 12, "DuxRadio");
        RADIO = r107;
        DuxComponent r108 = new DuxComponent("CHECK_BOX", 13, "DuxCheckBox");
        CHECK_BOX = r108;
        DuxComponent r109 = new DuxComponent("INFO_PANEL", 14, "DuxInfoPanel");
        INFO_PANEL = r109;
        DuxComponent r115 = new DuxComponent("BOTTOM_NOTIFICATION", 15, "DuxPopupNotice");
        BOTTOM_NOTIFICATION = r115;
        DuxComponent r116 = new DuxComponent("TOOLTIPS", 16, "DuxPopover");
        TOOLTIPS = r116;
        DuxComponent r117 = new DuxComponent("TAG", 17, "DuxTag");
        TAG = r117;
        DuxComponent r118 = new DuxComponent("STEPPERS", 18, "DuxSteppers");
        STEPPERS = r118;
        DuxComponent r119 = new DuxComponent("AVATAR", 19, "DuxAvatar");
        AVATAR = r119;
        DuxComponent r120 = new DuxComponent("TIPS", 20, "DuxTips");
        TIPS = r120;
        DuxComponent r121 = new DuxComponent("BASIC_PANEL", 21, "DuxBasicPanel");
        BASIC_PANEL = r121;
        DuxComponent r122 = new DuxComponent("PICKER", 22, "DuxPicker");
        PICKER = r122;
        DuxComponent r123 = new DuxComponent("SELECTION", 23, "DuxSelection");
        SELECTION = r123;
        DuxComponent r124 = new DuxComponent("FILTER_PANEL", 24, "DuxFilterPanel");
        FILTER_PANEL = r124;
        DuxComponent r125 = new DuxComponent("PROGRESS_INDICATOR", 25, "DuxProgressIndicator");
        PROGRESS_INDICATOR = r125;
        DuxComponent r126 = new DuxComponent("CAROUSEL_INDICATOR", 26, "DuxCarouselIndicator");
        CAROUSEL_INDICATOR = r126;
        DuxComponent r127 = new DuxComponent("UPLOADER", 27, "DuxUploader");
        UPLOADER = r127;
        DuxComponent r128 = new DuxComponent("FEEDBACK", 28, "DuxFeedback");
        FEEDBACK = r128;
        DuxComponent r129 = new DuxComponent("SLIDER", 29, "DuxSlider");
        SLIDER = r129;
        DuxComponent r130 = new DuxComponent("VACANT_VIEW", 30, "DuxVacantView");
        VACANT_VIEW = r130;
        DuxComponent r131 = new DuxComponent("PLACEHOLDER", 31, GXTemplateKey.GAIAX_PLACEHOLDER);
        PLACEHOLDER = r131;
        f204805a = new DuxComponent[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131};
    }

    public final String getId() {
        return this.f204806id;
    }

    public DuxComponent(String r100, int r101, String r102) {
        super(r100, r101);
        this.f204806id = r102;
    }
}
