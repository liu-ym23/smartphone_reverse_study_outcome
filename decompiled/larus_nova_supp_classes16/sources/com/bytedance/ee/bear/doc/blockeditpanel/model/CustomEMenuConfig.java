package com.bytedance.ee.bear.doc.blockeditpanel.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/model/CustomEMenuConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "udIcon", "", "getUdIcon", "()Ljava/lang/String;", "setUdIcon", "(Ljava/lang/String;)V", "iconStateColorList", "Lcom/bytedance/ee/bear/doc/blockeditpanel/model/CustomColorStates;", "getIconStateColorList", "()Lcom/bytedance/ee/bear/doc/blockeditpanel/model/CustomColorStates;", "setIconStateColorList", "(Lcom/bytedance/ee/bear/doc/blockeditpanel/model/CustomColorStates;)V", "textStateColorList", "getTextStateColorList", "setTextStateColorList", "backgroundStateColorList", "getBackgroundStateColorList", "setBackgroundStateColorList", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomEMenuConfig implements NonProguard {
    private CustomColorStates backgroundStateColorList;
    private CustomColorStates iconStateColorList;
    private CustomColorStates textStateColorList;
    private String udIcon;

    public CustomEMenuConfig() {
    }

    public final CustomColorStates getBackgroundStateColorList() {
        return this.backgroundStateColorList;
    }

    public final CustomColorStates getIconStateColorList() {
        return this.iconStateColorList;
    }

    public final CustomColorStates getTextStateColorList() {
        return this.textStateColorList;
    }

    public final String getUdIcon() {
        return this.udIcon;
    }

    public final void setBackgroundStateColorList(CustomColorStates r1) {
        this.backgroundStateColorList = r1;
    }

    public final void setIconStateColorList(CustomColorStates r1) {
        this.iconStateColorList = r1;
    }

    public final void setTextStateColorList(CustomColorStates r1) {
        this.textStateColorList = r1;
    }

    public final void setUdIcon(String r1) {
        this.udIcon = r1;
    }
}
