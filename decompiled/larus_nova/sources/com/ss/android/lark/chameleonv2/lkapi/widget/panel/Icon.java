package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Icon;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "udKey", "", "getUdKey", "()Ljava/lang/String;", "setUdKey", "(Ljava/lang/String;)V", "udColor", "getUdColor", "setUdColor", "iconStyle", "", "getIconStyle", "()Ljava/lang/Integer;", "setIconStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Icon implements NonProguard {
    private Integer iconStyle;
    private String udColor;
    private String udKey;

    public Icon() {
    }

    public final Integer getIconStyle() {
        return this.iconStyle;
    }

    public final String getUdColor() {
        return this.udColor;
    }

    public final String getUdKey() {
        return this.udKey;
    }

    public final void setIconStyle(Integer r100) {
        this.iconStyle = r100;
    }

    public final void setUdColor(String r100) {
        this.udColor = r100;
    }

    public final void setUdKey(String r100) {
        this.udKey = r100;
    }
}
