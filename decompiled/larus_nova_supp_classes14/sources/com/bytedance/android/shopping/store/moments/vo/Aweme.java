package com.bytedance.android.shopping.store.moments.vo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/vo/Aweme;", "Ljava/io/Serializable;", "()V", "author", "Lcom/bytedance/android/shopping/store/moments/vo/Author;", "getAuthor", "()Lcom/bytedance/android/shopping/store/moments/vo/Author;", "awemeId", "", "getAwemeId", "()Ljava/lang/String;", "video", "Lcom/bytedance/android/shopping/store/moments/vo/Video;", "getVideo", "()Lcom/bytedance/android/shopping/store/moments/vo/Video;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Aweme implements Serializable {

    @SerializedName("author")
    private final Author author;

    @SerializedName("aweme_id")
    private final String awemeId;

    @SerializedName("video")
    private final Video video;

    public Aweme() {
    }

    public final Author getAuthor() {
        return this.author;
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final Video getVideo() {
        return this.video;
    }
}
