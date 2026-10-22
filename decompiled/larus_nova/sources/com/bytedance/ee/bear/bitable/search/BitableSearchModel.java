package com.bytedance.ee.bear.bitable.search;

import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/search/BitableSearchModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isOpen", "", "()Z", "setOpen", "(Z)V", "rightIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getRightIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setRightIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "onboardingText", "", "getOnboardingText", "()Ljava/lang/String;", "setOnboardingText", "(Ljava/lang/String;)V", "searchKeywordLengthLimit", "", "getSearchKeywordLengthLimit", "()Ljava/lang/Integer;", "setSearchKeywordLengthLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cancelItem", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getCancelItem", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setCancelItem", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "tipsItem", "getTipsItem", "setTipsItem", "searchAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getSearchAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setSearchAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSearchModel implements NonProguard {
    private SimpleItemModel cancelItem;
    private boolean isOpen;
    private String onboardingText;
    private Icon rightIcon;
    private ActionPayload searchAction;
    private Integer searchKeywordLengthLimit;
    private SimpleItemModel tipsItem;

    public BitableSearchModel() {
    }

    public final SimpleItemModel getCancelItem() {
        return this.cancelItem;
    }

    public final String getOnboardingText() {
        return this.onboardingText;
    }

    public final Icon getRightIcon() {
        return this.rightIcon;
    }

    public final ActionPayload getSearchAction() {
        return this.searchAction;
    }

    public final Integer getSearchKeywordLengthLimit() {
        return this.searchKeywordLengthLimit;
    }

    public final SimpleItemModel getTipsItem() {
        return this.tipsItem;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setCancelItem(SimpleItemModel r100) {
        this.cancelItem = r100;
    }

    public final void setOnboardingText(String r100) {
        this.onboardingText = r100;
    }

    public final void setOpen(boolean r100) {
        this.isOpen = r100;
    }

    public final void setRightIcon(Icon r100) {
        this.rightIcon = r100;
    }

    public final void setSearchAction(ActionPayload r100) {
        this.searchAction = r100;
    }

    public final void setSearchKeywordLengthLimit(Integer r100) {
        this.searchKeywordLengthLimit = r100;
    }

    public final void setTipsItem(SimpleItemModel r100) {
        this.tipsItem = r100;
    }
}
