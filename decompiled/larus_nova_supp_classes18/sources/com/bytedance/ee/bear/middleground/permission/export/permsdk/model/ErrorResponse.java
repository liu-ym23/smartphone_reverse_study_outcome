package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ph5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/ErrorResponse;", "", "hasHandledUiAction", "", "callback", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/PermissionErrorCallback;", "<init>", "(ZLcom/bytedance/ee/bear/middleground/permission/export/permsdk/PermissionErrorCallback;)V", "getHasHandledUiAction", "()Z", "setHasHandledUiAction", "(Z)V", "getCallback", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/PermissionErrorCallback;", "setCallback", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/PermissionErrorCallback;)V", "uiStyle", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiStyle;", "getUiStyle", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiStyle;", "setUiStyle", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiStyle;)V", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ErrorResponse {
    private a callback;
    private boolean hasHandledUiAction;
    private UiStyle uiStyle;

    public final a getCallback() {
        return this.callback;
    }

    public final boolean getHasHandledUiAction() {
        return this.hasHandledUiAction;
    }

    public final UiStyle getUiStyle() {
        return this.uiStyle;
    }

    public final void setCallback(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.callback = r2;
    }

    public final void setHasHandledUiAction(boolean r1) {
        this.hasHandledUiAction = r1;
    }

    public final void setUiStyle(UiStyle r1) {
        this.uiStyle = r1;
    }

    public ErrorResponse(boolean r2, a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.hasHandledUiAction = r2;
        this.callback = r3;
    }
}
