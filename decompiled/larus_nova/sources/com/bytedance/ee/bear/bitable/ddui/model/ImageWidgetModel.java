package com.bytedance.ee.bear.bitable.ddui.model;

import android.content.Context;
import com.bytedance.ee.bear.bitable.panel.EPanelItemIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "udToken", "", "getUdToken", "()Ljava/lang/String;", "setUdToken", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "getIconRes", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageWidgetModel extends BaseWidgetModel {
    private String udToken;
    private String url;

    public ImageWidgetModel() {
    }

    public final String getUdToken() {
        return this.udToken;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getIconRes(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        String r101 = this.udToken;
        if (r101 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(EPanelItemIcon.getDrawableId(r100, r101));
    }

    public final void setUdToken(String r100) {
        this.udToken = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
