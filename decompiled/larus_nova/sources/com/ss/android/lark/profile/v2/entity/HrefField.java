package com.ss.android.lark.profile.v2.entity;

import com.alipay.sdk.m.x.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/HrefField;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Ljava/io/Serializable;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "link", "getLink", "setLink", "type", "getType", "setType", "textStyle", "Lcom/ss/android/lark/profile/v2/entity/TextStyle;", "getTextStyle", "()Lcom/ss/android/lark/profile/v2/entity/TextStyle;", "setTextStyle", "(Lcom/ss/android/lark/profile/v2/entity/TextStyle;)V", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HrefField extends BaseField {
    private String link;
    private TextStyle textStyle;
    private String title;
    private String type;

    public HrefField() {
    }

    public final String getLink() {
        return this.link;
    }

    public final TextStyle getTextStyle() {
        return this.textStyle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final void setLink(String r100) {
        this.link = r100;
    }

    public final void setTextStyle(TextStyle r100) {
        this.textStyle = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
