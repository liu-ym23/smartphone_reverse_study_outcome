package com.bytedance.awemeopen.apps.framework.comment.emoji.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/emoji/model/OnlineSmallEmojiRes;", "Ljava/io/Serializable;", "resourceUrl", "", "md5", "(Ljava/lang/String;Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "getResourceUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OnlineSmallEmojiRes implements Serializable {

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    private final String f194163md5;

    @SerializedName("resource_url")
    private final String resourceUrl;

    public static /* synthetic */ OnlineSmallEmojiRes copy$default(OnlineSmallEmojiRes r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.resourceUrl;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f194163md5;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.resourceUrl;
    }

    public final String component2() {
        return this.f194163md5;
    }

    public final OnlineSmallEmojiRes copy(String r100, String r101) {
        return new OnlineSmallEmojiRes(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OnlineSmallEmojiRes) == true) goto L8;
        return false;
    L8:
        OnlineSmallEmojiRes r101 = (OnlineSmallEmojiRes) r100;
        if (Intrinsics.areEqual(this.resourceUrl, r101.resourceUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f194163md5, r101.f194163md5) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.resourceUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f194163md5;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OnlineSmallEmojiRes(resourceUrl=" + this.resourceUrl + ", md5=" + this.f194163md5 + ')';
    }

    public final String getMd5() {
        return this.f194163md5;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public OnlineSmallEmojiRes(String r100, String r101) {
        this.resourceUrl = r100;
        this.f194163md5 = r101;
    }
}
