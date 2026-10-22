package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiStyle;", "", "toastMsg", "", "<init>", "(Ljava/lang/String;)V", "style", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/Style;", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/Style;)V", "getToastMsg", "()Ljava/lang/String;", "setToastMsg", "getStyle", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/Style;", "setStyle", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UiStyle {
    private Style style;
    private String toastMsg;

    public final Style getStyle() {
        return this.style;
    }

    public final String getToastMsg() {
        return this.toastMsg;
    }

    public UiStyle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toastMsg");
        this.toastMsg = "";
        this.style = Style.UNKNOWN;
        this.toastMsg = r2;
        this.style = Style.TOAST;
    }

    public final void setStyle(Style r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.style = r2;
    }

    public final void setToastMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.toastMsg = r2;
    }

    public UiStyle(Style r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        this.toastMsg = "";
        Style r0 = Style.TOAST;
        this.style = r2;
    }
}
