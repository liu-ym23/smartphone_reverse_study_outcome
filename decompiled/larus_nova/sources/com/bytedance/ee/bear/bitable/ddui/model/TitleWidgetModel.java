package com.bytedance.ee.bear.bitable.ddui.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "leftIcon", "Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "getLeftIcon", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "setLeftIcon", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;)V", "leftText", "Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "getLeftText", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "setLeftText", "(Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;)V", "centerText", "getCenterText", "setCenterText", "rightIcon", "getRightIcon", "setRightIcon", "rightText", "getRightText", "setRightText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleWidgetModel implements NonProguard {
    private TextWidgetModel centerText;
    private ImageWidgetModel leftIcon;
    private TextWidgetModel leftText;
    private ImageWidgetModel rightIcon;
    private TextWidgetModel rightText;

    public TitleWidgetModel() {
    }

    public final TextWidgetModel getCenterText() {
        return this.centerText;
    }

    public final ImageWidgetModel getLeftIcon() {
        return this.leftIcon;
    }

    public final TextWidgetModel getLeftText() {
        return this.leftText;
    }

    public final ImageWidgetModel getRightIcon() {
        return this.rightIcon;
    }

    public final TextWidgetModel getRightText() {
        return this.rightText;
    }

    public final void setCenterText(TextWidgetModel r100) {
        this.centerText = r100;
    }

    public final void setLeftIcon(ImageWidgetModel r100) {
        this.leftIcon = r100;
    }

    public final void setLeftText(TextWidgetModel r100) {
        this.leftText = r100;
    }

    public final void setRightIcon(ImageWidgetModel r100) {
        this.rightIcon = r100;
    }

    public final void setRightText(TextWidgetModel r100) {
        this.rightText = r100;
    }
}
