package com.bytedance.ee.bear.bitable.itemview.recordpages;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.ButtonCellValue;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010N\u001a\u00020\u0005J\u0006\u0010O\u001a\u00020\u0005J\u0006\u0010P\u001a\u00020\u0005J\u0006\u0010Q\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001a\u00101\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR*\u00104\u001a\u0012\u0012\u0004\u0012\u00020605j\b\u0012\u0004\u0012\u000206`7X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020)05j\b\u0012\u0004\u0012\u00020)`7X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001e\u0010?\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010E\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\tR\u001a\u0010H\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\tR\u001a\u0010K\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\t¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/recordpages/ItemViewRecordFooterData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "canScrollLeft", "", "getCanScrollLeft", "()Z", "setCanScrollLeft", "(Z)V", "canScrollRight", "getCanScrollRight", "setCanScrollRight", "switchLeftToastMsg", "", "getSwitchLeftToastMsg", "()Ljava/lang/String;", "setSwitchLeftToastMsg", "(Ljava/lang/String;)V", "switchRightToastMsg", "getSwitchRightToastMsg", "setSwitchRightToastMsg", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "indexText", "getIndexText", "setIndexText", "commentIds", "", "getCommentIds", "()Ljava/util/List;", "setCommentIds", "(Ljava/util/List;)V", "shouldShowSubmitView", "getShouldShowSubmitView", "setShouldShowSubmitView", "clickSubmitAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickSubmitAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickSubmitAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "submitStatus", "getSubmitStatus", "setSubmitStatus", "shouldShowBottomSwitchView", "getShouldShowBottomSwitchView", "setShouldShowBottomSwitchView", "buttonList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ButtonCellValue;", "Lkotlin/collections/ArrayList;", "getButtonList", "()Ljava/util/ArrayList;", "setButtonList", "(Ljava/util/ArrayList;)V", "buttonActionList", "getButtonActionList", "setButtonActionList", "shouldShowCommentView", "getShouldShowCommentView", "()Ljava/lang/Boolean;", "setShouldShowCommentView", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showAvatar", "getShowAvatar", "setShowAvatar", "visible", "getVisible", "setVisible", "fromCache", "getFromCache", "setFromCache", "enableScrollLeft", "enableScrollRight", "isSubmitSuccess", "isSubmitNormal", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordFooterData implements NonProguard {
    private ArrayList<ActionPayload> buttonActionList;
    private ArrayList<ButtonCellValue> buttonList;
    private boolean canScrollLeft;
    private boolean canScrollRight;
    private ActionPayload clickSubmitAction;
    private int commentCount;
    private List<String> commentIds;
    private boolean fromCache;
    private String indexText;
    private boolean shouldShowBottomSwitchView;
    private Boolean shouldShowCommentView;
    private boolean shouldShowSubmitView;
    private boolean showAvatar;
    private String submitStatus;
    private String switchLeftToastMsg;
    private String switchRightToastMsg;
    private boolean visible;

    public final boolean enableScrollLeft() {
        if (this.canScrollLeft == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.switchLeftToastMsg) == false) goto L8;
        return false;
    }

    public final boolean enableScrollRight() {
        if (this.canScrollRight == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.switchRightToastMsg) == false) goto L8;
        return false;
    }

    public final boolean isSubmitNormal() {
        return Intrinsics.areEqual(this.submitStatus, "normal");
    }

    public final boolean isSubmitSuccess() {
        return Intrinsics.areEqual(this.submitStatus, "success");
    }

    public ItemViewRecordFooterData() {
        this.buttonList = new ArrayList();
        this.buttonActionList = new ArrayList();
        this.visible = true;
    }

    public final ArrayList<ActionPayload> getButtonActionList() {
        return this.buttonActionList;
    }

    public final ArrayList<ButtonCellValue> getButtonList() {
        return this.buttonList;
    }

    public final boolean getCanScrollLeft() {
        return this.canScrollLeft;
    }

    public final boolean getCanScrollRight() {
        return this.canScrollRight;
    }

    public final ActionPayload getClickSubmitAction() {
        return this.clickSubmitAction;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final List<String> getCommentIds() {
        return this.commentIds;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final String getIndexText() {
        return this.indexText;
    }

    public final boolean getShouldShowBottomSwitchView() {
        return this.shouldShowBottomSwitchView;
    }

    public final Boolean getShouldShowCommentView() {
        return this.shouldShowCommentView;
    }

    public final boolean getShouldShowSubmitView() {
        return this.shouldShowSubmitView;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final String getSubmitStatus() {
        return this.submitStatus;
    }

    public final String getSwitchLeftToastMsg() {
        return this.switchLeftToastMsg;
    }

    public final String getSwitchRightToastMsg() {
        return this.switchRightToastMsg;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setButtonActionList(ArrayList<ActionPayload> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buttonActionList = r100;
    }

    public final void setButtonList(ArrayList<ButtonCellValue> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.buttonList = r100;
    }

    public final void setCanScrollLeft(boolean r100) {
        this.canScrollLeft = r100;
    }

    public final void setCanScrollRight(boolean r100) {
        this.canScrollRight = r100;
    }

    public final void setClickSubmitAction(ActionPayload r100) {
        this.clickSubmitAction = r100;
    }

    public final void setCommentCount(int r100) {
        this.commentCount = r100;
    }

    public final void setCommentIds(List<String> r100) {
        this.commentIds = r100;
    }

    public final void setFromCache(boolean r100) {
        this.fromCache = r100;
    }

    public final void setIndexText(String r100) {
        this.indexText = r100;
    }

    public final void setShouldShowBottomSwitchView(boolean r100) {
        this.shouldShowBottomSwitchView = r100;
    }

    public final void setShouldShowCommentView(Boolean r100) {
        this.shouldShowCommentView = r100;
    }

    public final void setShouldShowSubmitView(boolean r100) {
        this.shouldShowSubmitView = r100;
    }

    public final void setShowAvatar(boolean r100) {
        this.showAvatar = r100;
    }

    public final void setSubmitStatus(String r100) {
        this.submitStatus = r100;
    }

    public final void setSwitchLeftToastMsg(String r100) {
        this.switchLeftToastMsg = r100;
    }

    public final void setSwitchRightToastMsg(String r100) {
        this.switchRightToastMsg = r100;
    }

    public final void setVisible(boolean r100) {
        this.visible = r100;
    }
}
