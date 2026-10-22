package com.bytedance.ee.bear.document.ai.inlineai.bean;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/inlineai/bean/JSTips;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", CustomHeaderConfig.Menu.Style.ICON_STYLE, "getIcon", "setIcon", "url", "getUrl", "setUrl", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSTips implements NonProguard {
    private String icon;
    private boolean show;
    private String text;
    private String url;

    public JSTips() {
    }

    public String toString() {
        return "Tips(show=" + this.show + ", text=" + this.text + ", icon=" + this.icon + ", url=" + this.url + ')';
    }

    public final String getIcon() {
        return this.icon;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getText() {
        return this.text;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }
}
