package com.bytedance.awemeopen.apps.framework.comment.emoji.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR&\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/emoji/model/OnlineSmallEmojiResInfo;", "Ljava/io/Serializable;", "()V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "md5", "getMd5", "setMd5", "miniCover", "getMiniCover", "setMiniCover", "picFileDirPath", "getPicFileDirPath", "setPicFileDirPath", "resDirPath", "getResDirPath", "setResDirPath", "stickers", "", "Lcom/bytedance/awemeopen/apps/framework/comment/emoji/model/OnlineSmallEmoji;", "getStickers", "()Ljava/util/List;", "setStickers", "(Ljava/util/List;)V", "version", "getVersion", "setVersion", "isValid", "", "toString", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OnlineSmallEmojiResInfo implements Serializable {

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("id")
    private long id;
    private String md5;

    @SerializedName("mini_cover")
    private String miniCover;
    private String picFileDirPath;
    private String resDirPath;

    @SerializedName("stickers")
    private List<OnlineSmallEmoji> stickers;

    @SerializedName("version")
    private long version;

    public final boolean isValid() {
        List<OnlineSmallEmoji> r0 = this.stickers;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        if (this.md5.length() <= 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L16;
        return false;
    L16:
        if (this.resDirPath.length() <= 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == true) goto L21;
        return false;
    L21:
        if (this.picFileDirPath.length() <= 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        r4 = false;
        goto L24
    L18:
        r3 = false;
        goto L19
    L13:
        r2 = false;
        goto L14
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("OnlineSmallEmojiResInfo{md5=");
        r0.append(this.md5);
        r0.append(", resDirPath=");
        r0.append(this.resDirPath);
        r0.append(", picFilePath=");
        r0.append(this.picFileDirPath);
        r0.append(", stickers=");
        List<OnlineSmallEmoji> r1 = this.stickers;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.size());
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public OnlineSmallEmojiResInfo() {
        this.displayName = "";
        this.miniCover = "";
        this.md5 = "";
        this.resDirPath = "";
        this.picFileDirPath = "";
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getId() {
        return this.id;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getMiniCover() {
        return this.miniCover;
    }

    public final String getPicFileDirPath() {
        return this.picFileDirPath;
    }

    public final String getResDirPath() {
        return this.resDirPath;
    }

    public final List<OnlineSmallEmoji> getStickers() {
        return this.stickers;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setDisplayName(String r1) {
        this.displayName = r1;
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public final void setMd5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.md5 = r2;
    }

    public final void setMiniCover(String r1) {
        this.miniCover = r1;
    }

    public final void setPicFileDirPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.picFileDirPath = r2;
    }

    public final void setResDirPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resDirPath = r2;
    }

    public final void setStickers(List<OnlineSmallEmoji> r1) {
        this.stickers = r1;
    }

    public final void setVersion(long r1) {
        this.version = r1;
    }
}
