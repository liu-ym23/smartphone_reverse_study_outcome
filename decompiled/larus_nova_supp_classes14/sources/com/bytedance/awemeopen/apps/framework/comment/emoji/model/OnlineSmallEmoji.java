package com.bytedance.awemeopen.apps.framework.comment.emoji.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR>\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/emoji/model/OnlineSmallEmoji;", "Ljava/io/Serializable;", "()V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "displayNameLang", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getDisplayNameLang", "()Ljava/util/HashMap;", "setDisplayNameLang", "(Ljava/util/HashMap;)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "hide", "getHide", "setHide", "uri", "getUri", "setUri", "width", "getWidth", "setWidth", "showInPanel", "", "toString", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OnlineSmallEmoji implements Serializable {

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("display_name_lang")
    private HashMap<String, String> displayNameLang;

    @SerializedName("height")
    private int height;

    @SerializedName("hide")
    private int hide;

    @SerializedName("uri")
    private String uri;

    @SerializedName("width")
    private int width;

    public final boolean showInPanel() {
        if (this.hide != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "OnlineSmallEmoji={uri=" + this.uri + ", displayName=" + this.displayName + ", displayNameLang=" + this.displayName + ", hide=" + this.hide + '}';
    }

    public OnlineSmallEmoji() {
        this.uri = "";
        this.displayName = "";
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final HashMap<String, String> getDisplayNameLang() {
        return this.displayNameLang;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getHide() {
        return this.hide;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setDisplayName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.displayName = r2;
    }

    public final void setDisplayNameLang(HashMap<String, String> r1) {
        this.displayNameLang = r1;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setHide(int r1) {
        this.hide = r1;
    }

    public final void setUri(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uri = r2;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }
}
