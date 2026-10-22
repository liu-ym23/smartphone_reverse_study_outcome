package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import android.text.TextUtils;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010/\u001a\u00020\u000eJ\b\u00100\u001a\u0004\u0018\u00010%J\u0006\u00101\u001a\u00020\u000eJ\u0006\u00102\u001a\u00020\u000eJ\u0006\u00103\u001a\u00020\u000eJ\b\u00104\u001a\u00020\u0005H\u0016J\u0006\u00105\u001a\u00020\u000eJ\u0006\u00106\u001a\u00020\u000eJ\u0006\u00107\u001a\u00020\u000eJ\u0006\u00108\u001a\u00020\u000eJ\u0006\u00109\u001a\u00020\u000eJ\u0006\u0010:\u001a\u00020\u000eJ\u0006\u0010;\u001a\u00020\u000eJ\u0006\u0010<\u001a\u00020\u000eJ\u0006\u0010=\u001a\u00020\u000eJ\u0006\u0010>\u001a\u00020\u000eJ\u0006\u0010?\u001a\u00020\u000eJ\u0006\u0010@\u001a\u00020\u000eJ\u0006\u0010A\u001a\u00020\u000eJ\u0006\u0010B\u001a\u00020\u000eJ\u0006\u0010C\u001a\u00020\u000eJ\u0006\u0010D\u001a\u00020\u000eJ\u0006\u0010E\u001a\u00020\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006G"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/SceneModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "blockType", "", "getBlockType", "()Ljava/lang/String;", "setBlockType", "(Ljava/lang/String;)V", "viewType", "getViewType", "setViewType", "embeddedInSheet", "", "getEmbeddedInSheet", "()Z", "setEmbeddedInSheet", "(Z)V", "dashboardFullScreen", "getDashboardFullScreen", "setDashboardFullScreen", "showAIConfigForm", "getShowAIConfigForm", "setShowAIConfigForm", "nativeViewType", "getNativeViewType", "setNativeViewType", "isFormV2", "setFormV2", WikiFolderPushPlugin.BLOCK_ID, "getBlockId", "setBlockId", "viewId", "getViewId", "setViewId", "bitableTheme", "Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeModel;", "getBitableTheme", "()Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeModel;", "setBitableTheme", "(Lcom/bytedance/ee/bear/bitable/core/infoarch/arch/ThemeModel;)V", "isSoloBaseSuite", "()Ljava/lang/Boolean;", "setSoloBaseSuite", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hasDashboardTheme", "getDashboardTheme", "isSheetActive", "hideToolbar", "isDashBoard", "toString", "isLinkedDocx", "isForm", "isFormV1", "isBitable", "isWorkFlow", "isGrid", "isKanban", "isGallery", "isGantt", "isCalendar", "isViewEnableNestedScroll", "isInvalid", "isNativeView", "isNativeCard", "isNativeGallery", "isNativeGrid", "isNativeCalendar", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SceneModel implements NonProguard {
    public static final a Companion = null;
    public static final String NativeCard = "native_card";
    public static final String NativeGallery = "native_gallery";
    public static final String NativeGrid = "native_grid";
    private ThemeModel bitableTheme;
    private String blockId;
    private String blockType;
    private boolean dashboardFullScreen;
    private boolean embeddedInSheet;
    private boolean isFormV2;
    private Boolean isSoloBaseSuite;
    private String nativeViewType;
    private boolean showAIConfigForm;
    private String viewId;
    private String viewType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SceneModel() {
    }

    public final boolean isBitable() {
        return TextUtils.equals(this.blockType, "BITABLE_TABLE");
    }

    public final boolean isCalendar() {
        return TextUtils.equals(this.viewType, "7");
    }

    public final boolean isDashBoard() {
        return TextUtils.equals(this.blockType, "DASHBOARD");
    }

    public final boolean isGallery() {
        return TextUtils.equals(this.viewType, "4");
    }

    public final boolean isGantt() {
        return TextUtils.equals(this.viewType, "5");
    }

    public final boolean isGrid() {
        return TextUtils.equals(this.viewType, "1");
    }

    public final boolean isInvalid() {
        if (TextUtils.isEmpty(this.blockType) == false) goto L5;
    L10:
        return true;
    L5:
        if (TextUtils.equals(this.blockType, "BITABLE_TABLE") == true) goto L7;
    L9:
        return false;
    L7:
        if (TextUtils.isEmpty(this.viewType) == false) goto L9;
        goto L9
    }

    public final boolean isKanban() {
        return TextUtils.equals(this.viewType, "2");
    }

    public final boolean isLinkedDocx() {
        return TextUtils.equals(this.blockType, "LINKED_DOCX");
    }

    public final boolean isSheetActive() {
        if (this.embeddedInSheet == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.viewType) == true) goto L7;
        return true;
    }

    public final boolean isWorkFlow() {
        return TextUtils.equals(this.blockType, "WORKFLOW");
    }

    public String toString() {
        return "BitableContainerState(blockType=" + this.blockType + ", viewType=" + this.viewType + ", nativeViewType = " + this.nativeViewType + " embeddedInSheet=" + this.embeddedInSheet + ", dashboardFullScreen=" + this.dashboardFullScreen + ", showAIConfigForm=" + this.showAIConfigForm + ')';
    }

    public final ThemeModel getDashboardTheme() {
        if (hasDashboardTheme() == true) goto L7;
        return null;
    L7:
        return this.bitableTheme;
    }

    public final boolean hasDashboardTheme() {
        if (isDashBoard() == true) goto L5;
        return false;
    L5:
        ThemeModel r100 = this.bitableTheme;
        if (r100 != null) goto L9;
        return false;
    L9:
        return !r100.isDefaultTheme();
    }

    public final boolean hideToolbar() {
        if (isForm() == false) goto L5;
    L8:
        return true;
    L5:
        if (isNativeCalendar() == true) goto L8;
        return false;
    }

    public final boolean isForm() {
        if (isBitable() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.viewType, "3") == false) goto L7;
        return true;
    }

    public final boolean isFormV1() {
        if (isForm() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isFormV2 == true) goto L7;
        return true;
    }

    public final boolean isNativeCalendar() {
        if (isCalendar() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.nativeViewType, "calendar") == false) goto L7;
        return true;
    }

    public final boolean isNativeCard() {
        if (isGrid() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.nativeViewType, BrowserDependency.UrlClickType.CARD) == false) goto L7;
        return true;
    }

    public final boolean isNativeGallery() {
        if (isGallery() == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.nativeViewType, "gallery") == false) goto L7;
        return true;
    }

    public final boolean isNativeGrid() {
        if (isGrid() == true) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.equals(this.nativeViewType, GXViewKey.VIEW_TYPE_CONTAINER_GRID) == false) goto L9;
        if (this.showAIConfigForm == true) goto L9;
        return true;
    }

    public final boolean isNativeView() {
        if (isNativeCard() == false) goto L5;
    L10:
        return true;
    L5:
        if (isNativeGallery() == true) goto L10;
        if (isNativeGrid() == true) goto L10;
        return false;
    }

    public final boolean isViewEnableNestedScroll() {
        if (isGrid() == false) goto L5;
    L12:
        return true;
    L5:
        if (isForm() == true) goto L12;
        if (isGallery() == true) goto L12;
        if (isGantt() == true) goto L12;
        return false;
    }

    public final ThemeModel getBitableTheme() {
        return this.bitableTheme;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final String getBlockType() {
        return this.blockType;
    }

    public final boolean getDashboardFullScreen() {
        return this.dashboardFullScreen;
    }

    public final boolean getEmbeddedInSheet() {
        return this.embeddedInSheet;
    }

    public final String getNativeViewType() {
        return this.nativeViewType;
    }

    public final boolean getShowAIConfigForm() {
        return this.showAIConfigForm;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public final boolean isFormV2() {
        return this.isFormV2;
    }

    public final Boolean isSoloBaseSuite() {
        return this.isSoloBaseSuite;
    }

    public final void setBitableTheme(ThemeModel r100) {
        this.bitableTheme = r100;
    }

    public final void setBlockId(String r100) {
        this.blockId = r100;
    }

    public final void setBlockType(String r100) {
        this.blockType = r100;
    }

    public final void setDashboardFullScreen(boolean r100) {
        this.dashboardFullScreen = r100;
    }

    public final void setEmbeddedInSheet(boolean r100) {
        this.embeddedInSheet = r100;
    }

    public final void setFormV2(boolean r100) {
        this.isFormV2 = r100;
    }

    public final void setNativeViewType(String r100) {
        this.nativeViewType = r100;
    }

    public final void setShowAIConfigForm(boolean r100) {
        this.showAIConfigForm = r100;
    }

    public final void setSoloBaseSuite(Boolean r100) {
        this.isSoloBaseSuite = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }

    public final void setViewType(String r100) {
        this.viewType = r100;
    }
}
