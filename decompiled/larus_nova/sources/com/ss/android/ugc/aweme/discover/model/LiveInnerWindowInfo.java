package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/LiveInnerWindowInfo;", "Ljava/io/Serializable;", "()V", "authorId", "", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "authorName", "getAuthorName", "setAuthorName", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "jumpSchema", "getJumpSchema", "setJumpSchema", "level", "", "getLevel", "()I", "setLevel", "(I)V", a.KEY_SCORE, "getScore", "setScore", "text", "getText", "setText", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerWindowInfo implements Serializable {

    @SerializedName("author_id")
    private String authorId;

    @SerializedName("author_name")
    private String authorName;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("jump_schema")
    private String jumpSchema;

    @SerializedName("level")
    private int level;

    @SerializedName(a.KEY_SCORE)
    private String score;

    @SerializedName("text")
    private String text;

    public LiveInnerWindowInfo() {
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getScore() {
        return this.score;
    }

    public final String getText() {
        return this.text;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setAuthorName(String r100) {
        this.authorName = r100;
    }

    public final void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public final void setJumpSchema(String r100) {
        this.jumpSchema = r100;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public final void setScore(String r100) {
        this.score = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
