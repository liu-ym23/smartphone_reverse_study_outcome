package com.bytedance.ee.bear.bitable.uikit;

import com.bytedance.android.livesdk.action.instance.ShareAction;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/Action;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", "", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getAction", "setAction", "nativeAction", "getNativeAction", "setNativeAction", "toString", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Action implements NonProguard {
    public static final a Companion = null;
    private static final String TYEP_NATIVE_PROXY_ACTION = null;
    private static final String TYPE_ADD_COMMENT = null;
    private static final String TYPE_ADD_LINK_RECORD = null;
    private static final String TYPE_AFTER_POP = null;
    private static final String TYPE_AFTER_POP_ALL = null;
    private static final String TYPE_AFTER_PUSH = null;
    private static final String TYPE_AFTER_SCROLL = null;
    private static final String TYPE_BACK = null;
    private static final String TYPE_BLOCK_TREE_SORT = null;
    private static final String TYPE_CELL_CLICK = null;
    private static final String TYPE_CLEAR_STACK = null;
    private static final String TYPE_CONFIRM_CLOSE = null;
    private static final String TYPE_FORM_GRID_ADD_ROW = null;
    private static final String TYPE_OPEN_COMMENT = null;
    private static final String TYPE_PULL_DATA = null;
    private static final String TYPE_REBUILD = null;
    private static final String TYPE_SCROLL_LEFT = null;
    private static final String TYPE_SCROLL_RIGHT = null;
    private static final String TYPE_SEARCH = null;
    private static final String TYPE_SHARE_MENU = null;
    private static final String TYPE_SORT = null;
    private static final String TYPE_SUBMIT = null;
    private static final String TYPE_TOGGLE_FOLDER = null;
    private String action;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f216052id;
    private String nativeAction;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Action() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    static {
        Companion = new a();
        TYPE_SEARCH = "Search";
        TYPE_SORT = "Sort";
        TYPE_BLOCK_TREE_SORT = "BlockTreeSort";
        TYPE_TOGGLE_FOLDER = "ToggleFolder";
        TYPE_FORM_GRID_ADD_ROW = "FormGridAddRow";
        TYEP_NATIVE_PROXY_ACTION = "NativeProxyAction";
        TYPE_ADD_LINK_RECORD = "AddLinkRecord";
        TYPE_CLEAR_STACK = "ClearStackAction";
        TYPE_AFTER_POP = "ItemViewAfterPopAction";
        TYPE_AFTER_POP_ALL = "ItemViewAfterPopAllAction";
        TYPE_AFTER_PUSH = "ItemViewAfterPushAction";
        TYPE_AFTER_SCROLL = "ItemViewUpdateCurrentRecordAction";
        TYPE_REBUILD = "ItemViewRebuild";
        TYPE_PULL_DATA = "ItemViewPullData";
        TYPE_CONFIRM_CLOSE = "ItemViewConfirmBeforeCloseAction";
        TYPE_SCROLL_LEFT = "ScrollLeft";
        TYPE_SCROLL_RIGHT = "ScrollRight";
        TYPE_ADD_COMMENT = "AddCommentAction";
        TYPE_OPEN_COMMENT = "OpenCommentAction";
        TYPE_BACK = "BackAction";
        TYPE_SHARE_MENU = ShareAction.TAG;
        TYPE_SUBMIT = "ItemViewSubmitClickAction";
        TYPE_CELL_CLICK = "ItemViewCellClickAction";
    }

    public String toString() {
        return "Action(id=" + this.f216052id + ", action=" + this.action + ')';
    }

    public static final /* synthetic */ String access$getTYEP_NATIVE_PROXY_ACTION$cp() {
        return TYEP_NATIVE_PROXY_ACTION;
    }

    public static final /* synthetic */ String access$getTYPE_ADD_COMMENT$cp() {
        return TYPE_ADD_COMMENT;
    }

    public static final /* synthetic */ String access$getTYPE_ADD_LINK_RECORD$cp() {
        return TYPE_ADD_LINK_RECORD;
    }

    public static final /* synthetic */ String access$getTYPE_AFTER_POP$cp() {
        return TYPE_AFTER_POP;
    }

    public static final /* synthetic */ String access$getTYPE_AFTER_POP_ALL$cp() {
        return TYPE_AFTER_POP_ALL;
    }

    public static final /* synthetic */ String access$getTYPE_AFTER_PUSH$cp() {
        return TYPE_AFTER_PUSH;
    }

    public static final /* synthetic */ String access$getTYPE_AFTER_SCROLL$cp() {
        return TYPE_AFTER_SCROLL;
    }

    public static final /* synthetic */ String access$getTYPE_BACK$cp() {
        return TYPE_BACK;
    }

    public static final /* synthetic */ String access$getTYPE_BLOCK_TREE_SORT$cp() {
        return TYPE_BLOCK_TREE_SORT;
    }

    public static final /* synthetic */ String access$getTYPE_CELL_CLICK$cp() {
        return TYPE_CELL_CLICK;
    }

    public static final /* synthetic */ String access$getTYPE_CLEAR_STACK$cp() {
        return TYPE_CLEAR_STACK;
    }

    public static final /* synthetic */ String access$getTYPE_CONFIRM_CLOSE$cp() {
        return TYPE_CONFIRM_CLOSE;
    }

    public static final /* synthetic */ String access$getTYPE_FORM_GRID_ADD_ROW$cp() {
        return TYPE_FORM_GRID_ADD_ROW;
    }

    public static final /* synthetic */ String access$getTYPE_OPEN_COMMENT$cp() {
        return TYPE_OPEN_COMMENT;
    }

    public static final /* synthetic */ String access$getTYPE_PULL_DATA$cp() {
        return TYPE_PULL_DATA;
    }

    public static final /* synthetic */ String access$getTYPE_REBUILD$cp() {
        return TYPE_REBUILD;
    }

    public static final /* synthetic */ String access$getTYPE_SCROLL_LEFT$cp() {
        return TYPE_SCROLL_LEFT;
    }

    public static final /* synthetic */ String access$getTYPE_SCROLL_RIGHT$cp() {
        return TYPE_SCROLL_RIGHT;
    }

    public static final /* synthetic */ String access$getTYPE_SEARCH$cp() {
        return TYPE_SEARCH;
    }

    public static final /* synthetic */ String access$getTYPE_SHARE_MENU$cp() {
        return TYPE_SHARE_MENU;
    }

    public static final /* synthetic */ String access$getTYPE_SORT$cp() {
        return TYPE_SORT;
    }

    public static final /* synthetic */ String access$getTYPE_SUBMIT$cp() {
        return TYPE_SUBMIT;
    }

    public static final /* synthetic */ String access$getTYPE_TOGGLE_FOLDER$cp() {
        return TYPE_TOGGLE_FOLDER;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getId() {
        return this.f216052id;
    }

    public String getNativeAction() {
        return this.nativeAction;
    }

    public final void setAction(String r100) {
        this.action = r100;
    }

    public final void setId(String r100) {
        this.f216052id = r100;
    }

    public void setNativeAction(String r100) {
        this.nativeAction = r100;
    }

    public Action(String r100, String r101) {
        this.f216052id = r100;
        this.action = r101;
    }

    public /* synthetic */ Action(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
