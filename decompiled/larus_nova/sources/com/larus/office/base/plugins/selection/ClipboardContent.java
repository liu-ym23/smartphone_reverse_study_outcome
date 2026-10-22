package com.larus.office.base.plugins.selection;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.util.EncriptUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/larus/office/base/plugins/selection/ClipboardContent;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "html", "getHtml", "setHtml", "encryptId", "getEncryptId", "setEncryptId", "isProtect", "", "()Z", "setProtect", "(Z)V", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClipboardContent implements NonProguard {

    @SerializedName("encryptId")
    private String encryptId;

    @SerializedName("html")
    private String html;

    @SerializedName("protect")
    private boolean isProtect;

    @SerializedName("text")
    private String text;

    public String toString() {
        StringBuilder r100 = new StringBuilder("ClipboardContent{text length=");
        String r101 = this.text;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.length();
    L6:
        r100.append(r102);
        r100.append(", encryptId='");
        r100.append(EncriptUtils.handleEncription(this.encryptId));
        r100.append("', protect=");
        r100.append(this.isProtect);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = 0;
        goto L6
    }

    public ClipboardContent() {
        this.isProtect = true;
    }

    public final String getEncryptId() {
        return this.encryptId;
    }

    public final String getHtml() {
        return this.html;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isProtect() {
        return this.isProtect;
    }

    public final void setEncryptId(String r100) {
        this.encryptId = r100;
    }

    public final void setHtml(String r100) {
        this.html = r100;
    }

    public final void setProtect(boolean r100) {
        this.isProtect = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
