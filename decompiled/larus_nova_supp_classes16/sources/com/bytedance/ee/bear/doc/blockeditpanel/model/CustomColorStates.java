package com.bytedance.ee.bear.doc.blockeditpanel.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/model/CustomColorStates;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "pressedColor", "", "getPressedColor", "()Ljava/lang/String;", "setPressedColor", "(Ljava/lang/String;)V", "disabledColor", "getDisabledColor", "setDisabledColor", "selectedColor", "getSelectedColor", "setSelectedColor", "pressedInSelectedColor", "getPressedInSelectedColor", "setPressedInSelectedColor", "defaultColor", "getDefaultColor", "setDefaultColor", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomColorStates implements NonProguard {
    private String defaultColor;
    private String disabledColor;
    private String pressedColor;
    private String pressedInSelectedColor;
    private String selectedColor;

    public CustomColorStates() {
    }

    public final String getDefaultColor() {
        return this.defaultColor;
    }

    public final String getDisabledColor() {
        return this.disabledColor;
    }

    public final String getPressedColor() {
        return this.pressedColor;
    }

    public final String getPressedInSelectedColor() {
        return this.pressedInSelectedColor;
    }

    public final String getSelectedColor() {
        return this.selectedColor;
    }

    public final void setDefaultColor(String r1) {
        this.defaultColor = r1;
    }

    public final void setDisabledColor(String r1) {
        this.disabledColor = r1;
    }

    public final void setPressedColor(String r1) {
        this.pressedColor = r1;
    }

    public final void setPressedInSelectedColor(String r1) {
        this.pressedInSelectedColor = r1;
    }

    public final void setSelectedColor(String r1) {
        this.selectedColor = r1;
    }
}
