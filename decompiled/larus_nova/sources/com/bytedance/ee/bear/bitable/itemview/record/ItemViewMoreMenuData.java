package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewMoreMenuData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "showDeleteButton", "", "getShowDeleteButton", "()Z", "setShowDeleteButton", "(Z)V", "clickDeleteAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickDeleteAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickDeleteAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "showChangeCoverButton", "getShowChangeCoverButton", "setShowChangeCoverButton", "clickChangeCoverAction", "getClickChangeCoverAction", "setClickChangeCoverAction", "showContinueAddButton", "getShowContinueAddButton", "setShowContinueAddButton", "clickContinueAddAction", "getClickContinueAddAction", "setClickContinueAddAction", "showOpenTableButton", "getShowOpenTableButton", "setShowOpenTableButton", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewMoreMenuData implements NonProguard {
    private ActionPayload clickChangeCoverAction;
    private ActionPayload clickContinueAddAction;
    private ActionPayload clickDeleteAction;
    private boolean showChangeCoverButton;
    private boolean showContinueAddButton;
    private boolean showDeleteButton;
    private boolean showOpenTableButton;

    public ItemViewMoreMenuData() {
        this.showDeleteButton = true;
    }

    public final ActionPayload getClickChangeCoverAction() {
        return this.clickChangeCoverAction;
    }

    public final ActionPayload getClickContinueAddAction() {
        return this.clickContinueAddAction;
    }

    public final ActionPayload getClickDeleteAction() {
        return this.clickDeleteAction;
    }

    public final boolean getShowChangeCoverButton() {
        return this.showChangeCoverButton;
    }

    public final boolean getShowContinueAddButton() {
        return this.showContinueAddButton;
    }

    public final boolean getShowDeleteButton() {
        return this.showDeleteButton;
    }

    public final boolean getShowOpenTableButton() {
        return this.showOpenTableButton;
    }

    public final void setClickChangeCoverAction(ActionPayload r100) {
        this.clickChangeCoverAction = r100;
    }

    public final void setClickContinueAddAction(ActionPayload r100) {
        this.clickContinueAddAction = r100;
    }

    public final void setClickDeleteAction(ActionPayload r100) {
        this.clickDeleteAction = r100;
    }

    public final void setShowChangeCoverButton(boolean r100) {
        this.showChangeCoverButton = r100;
    }

    public final void setShowContinueAddButton(boolean r100) {
        this.showContinueAddButton = r100;
    }

    public final void setShowDeleteButton(boolean r100) {
        this.showDeleteButton = r100;
    }

    public final void setShowOpenTableButton(boolean r100) {
        this.showOpenTableButton = r100;
    }
}
