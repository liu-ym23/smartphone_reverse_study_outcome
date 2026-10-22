package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSOperate;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", CustomHeaderConfig.Menu.Style.ICON_STYLE, "getIcon", "setIcon", "text", "getText", "setText", "btnType", "getBtnType", "setBtnType", "disabled", "", "getDisabled", "()Z", "setDisabled", "(Z)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSOperate implements NonProguard {
    private String btnType;
    private boolean disabled;
    private String icon;
    private String text;
    private String type;

    public JSOperate() {
    }

    public String toString() {
        return "Operate(type=" + this.type + ", icon=" + this.icon + ", text=" + this.text + ", btnType=" + this.btnType + ", disabled=" + this.disabled + ')';
    }

    public final String getBtnType() {
        return this.btnType;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final void setBtnType(String r1) {
        this.btnType = r1;
    }

    public final void setDisabled(boolean r1) {
        this.disabled = r1;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }
}
