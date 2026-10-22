package com.larus.avlink.gallery.model;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.model.MediaInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/gallery/model/MediaList;", "Ljava/io/Serializable;", "<init>", "()V", "mediaList", "", "Lcom/larus/dora/api/model/MediaInfo;", "getMediaList", "()Ljava/util/List;", "setMediaList", "(Ljava/util/List;)V", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaList implements Serializable {
    public static final int $stable = 8;

    @SerializedName("list")
    private List<MediaInfo> mediaList;

    public MediaList() {
    }

    public final List<MediaInfo> getMediaList() {
        return this.mediaList;
    }

    public final void setMediaList(List<MediaInfo> r100) {
        this.mediaList = r100;
    }
}
