package com.bytedance.ies.xelement.defaultimpl.player.impl.entity;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import t76.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/impl/entity/XAudioList;", "", "Lcom/bytedance/ies/xelement/defaultimpl/player/engine/api/queue/h;", "toPlaylist", "", NativeDownloadModel.JsonKey.ID, "Ljava/lang/String;", "", "mPosition", "Ljava/lang/Integer;", "", "Lcom/bytedance/ies/xelement/defaultimpl/player/impl/entity/XAudioSrc;", "mDataSet", "Ljava/util/List;", "<init>", "()V", "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
public final class XAudioList {

    @SerializedName("list")
    private List<XAudioSrc> mDataSet;

    @SerializedName("id")
    private String mId;

    @SerializedName("position")
    private Integer mPosition;

    public final h toPlaylist() {
        String r100 = this.mId;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        List<XAudioSrc> r101 = this.mDataSet;
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        Integer r102 = this.mPosition;
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
    L13:
        return new a(r100, r101, r103);
    L11:
        r103 = 0;
        goto L13
    }

    public XAudioList() {
        this.mId = "";
        this.mPosition = 0;
    }
}
