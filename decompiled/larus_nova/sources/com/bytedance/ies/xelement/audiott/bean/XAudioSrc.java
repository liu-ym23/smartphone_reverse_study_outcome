package com.bytedance.ies.xelement.audiott.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/xelement/audiott/bean/XAudioSrc;", "", "songId", "", "playUrl", "playModel", "Lcom/bytedance/ies/xelement/audiott/bean/PlayModel;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/xelement/audiott/bean/PlayModel;)V", "getPlayModel", "()Lcom/bytedance/ies/xelement/audiott/bean/PlayModel;", "getPlayUrl", "()Ljava/lang/String;", "getSongId", "x-element-audio-tt_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class XAudioSrc {

    @SerializedName("play_model")
    private final PlayModel playModel;

    @SerializedName("play_url")
    private final String playUrl;

    @SerializedName("id")
    private final String songId;

    public XAudioSrc() {
        this(null, null, null, 7, null);
    }

    public final PlayModel getPlayModel() {
        return this.playModel;
    }

    public final String getPlayUrl() {
        return this.playUrl;
    }

    public final String getSongId() {
        return this.songId;
    }

    public XAudioSrc(String r100, String r101, PlayModel r102) {
        this.songId = r100;
        this.playUrl = r101;
        this.playModel = r102;
    }

    public /* synthetic */ XAudioSrc(String r100, String r101, PlayModel r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
