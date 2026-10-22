package com.bytedance.ee.bear.bitable.msgcenter.view;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010O\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J!\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020\u00112\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010TR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u001a\u0010#\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR&\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010)\"\u0004\b>\u0010+R\u001c\u0010?\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010)\"\u0004\bA\u0010+R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR:\u0010H\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010Ij\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u0001`JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006U"}, d2 = {"Lcom/bytedance/ee/bear/bitable/msgcenter/view/BitableMsgCenterContainerModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "action", "", "getAction", "()Ljava/lang/Integer;", "setAction", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "unreadCount", "getUnreadCount", "()I", "setUnreadCount", "(I)V", "isMuted", "", "()Z", "setMuted", "(Z)V", "tabs", "", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "currentTab", "", "getCurrentTab", "()Ljava/lang/String;", "setCurrentTab", "(Ljava/lang/String;)V", "currentTabIndex", "hasError", "getHasError", "setHasError", "retryAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getRetryAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setRetryAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "renderList", "getRenderList", "setRenderList", "messageDataMap", "", "Lcom/bytedance/ee/bear/bitable/msgcenter/view/BitableMsgCardModel;", "getMessageDataMap", "()Ljava/util/Map;", "setMessageDataMap", "(Ljava/util/Map;)V", ContainerPosition.FOOTER, "Lcom/bytedance/ee/bear/bitable/msgcenter/view/FooterModel;", "getFooter", "()Lcom/bytedance/ee/bear/bitable/msgcenter/view/FooterModel;", "setFooter", "(Lcom/bytedance/ee/bear/bitable/msgcenter/view/FooterModel;)V", "clickReadAll", "getClickReadAll", "setClickReadAll", "toggleMuted", "getToggleMuted", "setToggleMuted", "oldMentionData", "Lcom/bytedance/ee/bear/bitable/msgcenter/view/OldMentionModel;", "getOldMentionData", "()Lcom/bytedance/ee/bear/bitable/msgcenter/view/OldMentionModel;", "setOldMentionData", "(Lcom/bytedance/ee/bear/bitable/msgcenter/view/OldMentionModel;)V", "commonTeaParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getCommonTeaParams", "()Ljava/util/HashMap;", "setCommonTeaParams", "(Ljava/util/HashMap;)V", "getCurrentTabIndex", "changeToLoading", "", "forceLoading", "switchTabIndex", "(ZLjava/lang/Integer;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableMsgCenterContainerModel implements NonProguard {
    private Integer action;
    private ActionPayload clickReadAll;
    private HashMap<String, String> commonTeaParams;
    private String currentTab;
    private Integer currentTabIndex;
    private FooterModel footer;
    private boolean hasError;
    private boolean isMuted;
    private Map<String, BitableMsgCardModel> messageDataMap;
    private OldMentionModel oldMentionData;
    private List<String> renderList;
    private ActionPayload retryAction;
    private List<SimpleItemModel> tabs;
    private ActionPayload toggleMuted;
    private int unreadCount;

    public final Integer getCurrentTabIndex() {
        Integer r100 = this.currentTabIndex;
        if (r100 != null) goto L27;
        String r101 = this.currentTab;
        if (r101 == null) goto L25;
        int r102 = r101.hashCode();
        if (r102 == (-840272977)) goto L22;
        if (r102 == (-690646003)) goto L18;
        if (r102 != 96673) goto L25;
        if (r101.equals("all") == false) goto L25;
        return 0;
    L18:
        if (r101.equals("mention_me") == false) goto L25;
        return 2;
    L22:
        if (r101.equals("unread") == false) goto L25;
        return 1;
    L25:
        return null;
    L27:
        return r100;
    }

    public BitableMsgCenterContainerModel() {
        this.tabs = new ArrayList();
        this.messageDataMap = new HashMap();
    }

    public final Integer getAction() {
        return this.action;
    }

    public final ActionPayload getClickReadAll() {
        return this.clickReadAll;
    }

    public final HashMap<String, String> getCommonTeaParams() {
        return this.commonTeaParams;
    }

    public final String getCurrentTab() {
        return this.currentTab;
    }

    public final FooterModel getFooter() {
        return this.footer;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final Map<String, BitableMsgCardModel> getMessageDataMap() {
        return this.messageDataMap;
    }

    public final OldMentionModel getOldMentionData() {
        return this.oldMentionData;
    }

    public final List<String> getRenderList() {
        return this.renderList;
    }

    public final ActionPayload getRetryAction() {
        return this.retryAction;
    }

    public final List<SimpleItemModel> getTabs() {
        return this.tabs;
    }

    public final ActionPayload getToggleMuted() {
        return this.toggleMuted;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final void setAction(Integer r100) {
        this.action = r100;
    }

    public final void setClickReadAll(ActionPayload r100) {
        this.clickReadAll = r100;
    }

    public final void setCommonTeaParams(HashMap<String, String> r100) {
        this.commonTeaParams = r100;
    }

    public final void setCurrentTab(String r100) {
        this.currentTab = r100;
    }

    public final void setFooter(FooterModel r100) {
        this.footer = r100;
    }

    public final void setHasError(boolean r100) {
        this.hasError = r100;
    }

    public final void setMessageDataMap(Map<String, BitableMsgCardModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.messageDataMap = r100;
    }

    public final void setMuted(boolean r100) {
        this.isMuted = r100;
    }

    public final void setOldMentionData(OldMentionModel r100) {
        this.oldMentionData = r100;
    }

    public final void setRenderList(List<String> r100) {
        this.renderList = r100;
    }

    public final void setRetryAction(ActionPayload r100) {
        this.retryAction = r100;
    }

    public final void setTabs(List<SimpleItemModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabs = r100;
    }

    public final void setToggleMuted(ActionPayload r100) {
        this.toggleMuted = r100;
    }

    public final void setUnreadCount(int r100) {
        this.unreadCount = r100;
    }

    public final void changeToLoading(boolean r100, Integer r101) {
        if (r100 == true) goto L10;
        Integer r102 = this.action;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.intValue() == 1) goto L9;
        return;
    L9:
        if (this.renderList == null) goto L10;
        return;
    L10:
        if (r101 != null) goto L12;
        r101 = this.currentTabIndex;
    L12:
        this.currentTabIndex = r101;
        ArrayList r103 = new ArrayList(10);
        int r104 = 0;
    L13:
        if (r104 >= 10) goto L15;
        r103.add("loading");
        r104 = r104 + 1;
        goto L13
    L15:
        this.renderList = r103;
    }

    public static /* synthetic */ void changeToLoading$default(BitableMsgCenterContainerModel r100, boolean r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.changeToLoading(r101, r102);
    }
}
