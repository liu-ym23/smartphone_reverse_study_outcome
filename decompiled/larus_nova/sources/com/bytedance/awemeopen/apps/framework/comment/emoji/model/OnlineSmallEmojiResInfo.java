package com.bytedance.awemeopen.apps.framework.comment.emoji.model;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR&\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/emoji/model/OnlineSmallEmojiResInfo;", "Ljava/io/Serializable;", "()V", CommonConstant.KEY_DISPLAY_NAME, "", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "md5", "getMd5", "setMd5", "miniCover", "getMiniCover", "setMiniCover", "picFileDirPath", "getPicFileDirPath", "setPicFileDirPath", "resDirPath", "getResDirPath", "setResDirPath", "stickers", "", "Lcom/bytedance/awemeopen/apps/framework/comment/emoji/model/OnlineSmallEmoji;", "getStickers", "()Ljava/util/List;", "setStickers", "(Ljava/util/List;)V", "version", "getVersion", "setVersion", "isValid", "", "toString", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OnlineSmallEmojiResInfo implements Serializable {

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private String displayName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f194164id;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f194165md5;

    @SerializedName("mini_cover")
    private String miniCover;
    private String picFileDirPath;
    private String resDirPath;

    @SerializedName("stickers")
    private List<OnlineSmallEmoji> stickers;

    @SerializedName("version")
    private long version;

    public final boolean isValid() {
        List<OnlineSmallEmoji> r100 = this.stickers;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        if (this.f194165md5.length() <= 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L16;
        return false;
    L16:
        if (this.resDirPath.length() <= 0) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == true) goto L21;
        return false;
    L21:
        if (this.picFileDirPath.length() <= 0) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        r104 = false;
        goto L24
    L18:
        r103 = false;
        goto L19
    L13:
        r102 = false;
        goto L14
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("OnlineSmallEmojiResInfo{md5=");
        r100.append(this.f194165md5);
        r100.append(", resDirPath=");
        r100.append(this.resDirPath);
        r100.append(", picFilePath=");
        r100.append(this.picFileDirPath);
        r100.append(", stickers=");
        List<OnlineSmallEmoji> r101 = this.stickers;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public OnlineSmallEmojiResInfo() {
        this.displayName = "";
        this.miniCover = "";
        this.f194165md5 = "";
        this.resDirPath = "";
        this.picFileDirPath = "";
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getId() {
        return this.f194164id;
    }

    public final String getMd5() {
        return this.f194165md5;
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

    public final void setDisplayName(String r100) {
        this.displayName = r100;
    }

    public final void setId(long r100) {
        this.f194164id = r100;
    }

    public final void setMd5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f194165md5 = r100;
    }

    public final void setMiniCover(String r100) {
        this.miniCover = r100;
    }

    public final void setPicFileDirPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.picFileDirPath = r100;
    }

    public final void setResDirPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resDirPath = r100;
    }

    public final void setStickers(List<OnlineSmallEmoji> r100) {
        this.stickers = r100;
    }

    public final void setVersion(long r100) {
        this.version = r100;
    }
}
