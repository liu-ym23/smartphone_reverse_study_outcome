package com.bytedance.ee.bear.bitable.msgcenter.view;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/bitable/msgcenter/view/FooterModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "renderEndMessage", "getRenderEndMessage", "setRenderEndMessage", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "loadMoreAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getLoadMoreAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setLoadMoreAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "onOpenHistory", "Lkotlin/Function0;", "", "getOnOpenHistory", "()Lkotlin/jvm/functions/Function0;", "setOnOpenHistory", "(Lkotlin/jvm/functions/Function0;)V", "onFooterRetry", "getOnFooterRetry", "setOnFooterRetry", "isSuccess", "isError", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FooterModel implements NonProguard {
    private boolean hasMore;
    private ActionPayload loadMoreAction;
    private Function0<Unit> onFooterRetry;
    private Function0<Unit> onOpenHistory;
    private boolean renderEndMessage;
    private String status;

    public FooterModel() {
    }

    public final boolean isError() {
        return Intrinsics.areEqual("failed", this.status);
    }

    public final boolean isSuccess() {
        return Intrinsics.areEqual("success", this.status);
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ActionPayload getLoadMoreAction() {
        return this.loadMoreAction;
    }

    public final Function0<Unit> getOnFooterRetry() {
        return this.onFooterRetry;
    }

    public final Function0<Unit> getOnOpenHistory() {
        return this.onOpenHistory;
    }

    public final boolean getRenderEndMessage() {
        return this.renderEndMessage;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setLoadMoreAction(ActionPayload r100) {
        this.loadMoreAction = r100;
    }

    public final void setOnFooterRetry(Function0<Unit> r100) {
        this.onFooterRetry = r100;
    }

    public final void setOnOpenHistory(Function0<Unit> r100) {
        this.onOpenHistory = r100;
    }

    public final void setRenderEndMessage(boolean r100) {
        this.renderEndMessage = r100;
    }

    public final void setStatus(String r100) {
        this.status = r100;
    }
}
