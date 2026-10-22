package com.bytedance.ee.docsdk.impl.document.plugins;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/JsBridgeConstants;", "", "()V", "BIZ_CLIPBOARD_GET_CONTENT", "", "BIZ_CLIPBOARD_SET_CONTENT", "BIZ_CLIPBOARD_SET_ENCRYPT_ID", "BIZ_NAVIGATION_BASE", "BIZ_NOTIFY_PRELOADREADY", "BIZ_NOTIFY_READY", "BIZ_SELECTION_TRIGGER_TRANSLATE", "BIZ_SELECT_BASE", "BIZ_SELECT_CLOSE_ACTION_MODE", "BIZ_SELECT_CLOSE_HANDLER", "BIZ_SELECT_COPY", "BIZ_SELECT_CUT", "BIZ_SELECT_HANDLESEARCHWEBMENUCLICK", "BIZ_SELECT_HANDLESHAREMENUCLICK", "BIZ_SELECT_HIDE_HANDLER", "BIZ_SELECT_IS_ENABLE_CUSTOM_SELECTION", "BIZ_SELECT_ON_SELECTION_CHANGED", "BIZ_SELECT_ON_SELECTION_CHANGED_V2", "BIZ_SELECT_PASTE", "BIZ_SELECT_SHOW_ACTION_MODE", "BIZ_SET_DOC_TOOLBAR_V2", "BIZ_SET_INSERT_NEW_BLOCK_PANEL", "BIZ_UTIL_FETCH", "BIZ_UTIL_GET_DATA", "BIZ_UTIL_HIDELOADING", "BIZ_UTIL_HIDE_KEY_BOARD", "BIZ_UTIL_SET_DATA", "BIZ_UTIL_SHOW_KEY_BOARD", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JsBridgeConstants {
    public static final String BIZ_CLIPBOARD_GET_CONTENT = "biz.clipboard.getContent";
    public static final String BIZ_CLIPBOARD_SET_CONTENT = "biz.clipboard.setContent";
    public static final String BIZ_CLIPBOARD_SET_ENCRYPT_ID = "biz.clipboard.setEncryptId";
    public static final String BIZ_NAVIGATION_BASE = "biz.navigation.";
    public static final String BIZ_NOTIFY_PRELOADREADY = "biz.notify.preloadReady";
    public static final String BIZ_NOTIFY_READY = "biz.notify.ready";
    public static final String BIZ_SELECTION_TRIGGER_TRANSLATE = "biz.selection.triggerTranslate";
    public static final String BIZ_SELECT_BASE = "biz.selection.";
    public static final String BIZ_SELECT_CLOSE_ACTION_MODE = "biz.navigation.closeCustomContextMenu";
    public static final String BIZ_SELECT_CLOSE_HANDLER = "window.lark.biz.util.onContextMenuClose";
    public static final String BIZ_SELECT_COPY = "biz.navigation.handleCopyMenuClick";
    public static final String BIZ_SELECT_CUT = "biz.navigation.handleCutMenuClick";
    public static final String BIZ_SELECT_HANDLESEARCHWEBMENUCLICK = "biz.navigation.handleSearchWebMenuClick";
    public static final String BIZ_SELECT_HANDLESHAREMENUCLICK = "biz.navigation.handleShareMenuClick";
    public static final String BIZ_SELECT_HIDE_HANDLER = "biz.selection.hideSelectionHandler";
    public static final String BIZ_SELECT_IS_ENABLE_CUSTOM_SELECTION = "biz.selection.isEnableCustomSelection";
    public static final String BIZ_SELECT_ON_SELECTION_CHANGED = "biz.selection.onSelectionChanged";
    public static final String BIZ_SELECT_ON_SELECTION_CHANGED_V2 = "biz.selection.onSelectionChangedV2";
    public static final String BIZ_SELECT_PASTE = "biz.navigation.handlePasteMenuClick";
    public static final String BIZ_SELECT_SHOW_ACTION_MODE = "biz.navigation.showCustomContextMenu";
    public static final String BIZ_SET_DOC_TOOLBAR_V2 = "biz.navigation.setDocToolbarV2";
    public static final String BIZ_SET_INSERT_NEW_BLOCK_PANEL = "biz.navigation.setInsertNewBlockPanel";
    public static final String BIZ_UTIL_FETCH = "biz.util.fetch";
    public static final String BIZ_UTIL_GET_DATA = "biz.util.getData";
    public static final String BIZ_UTIL_HIDELOADING = "biz.util.hideLoading";
    public static final String BIZ_UTIL_HIDE_KEY_BOARD = "biz.util.hideKeyBoard";
    public static final String BIZ_UTIL_SET_DATA = "biz.util.setData";
    public static final String BIZ_UTIL_SHOW_KEY_BOARD = "biz.util.showKeyBoard";
    public static final JsBridgeConstants INSTANCE = null;

    static {
        INSTANCE = new JsBridgeConstants();
    }

    private JsBridgeConstants() {
    }
}
