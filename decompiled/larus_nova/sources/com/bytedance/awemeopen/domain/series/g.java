package com.bytedance.awemeopen.domain.series;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bB\u0010CR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R$\u00103\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012R\"\u00106\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010+\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\"\u00109\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010+\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R$\u0010<\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000e\u001a\u0004\b=\u0010\u0010\"\u0004\b>\u0010\u0012R$\u0010?\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000e\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012¨\u0006D"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/g;", "", "", "episodeId", "J", "getEpisodeId", "()J", "setEpisodeId", "(J)V", "albumId", "getAlbumId", "setAlbumId", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "intro", "getIntro", "setIntro", "", "duration", "D", "getDuration", "()D", "setDuration", "(D)V", "", "Lcom/bytedance/awemeopen/domain/series/m;", "coverInfoList", "Ljava/util/List;", "getCoverInfoList", "()Ljava/util/List;", "setCoverInfoList", "(Ljava/util/List;)V", "Lcom/bytedance/awemeopen/domain/series/f;", "encodedVideoInfoList", "getEncodedVideoInfoList", "setEncodedVideoInfoList", "", "displayForbidden", "I", "getDisplayForbidden", "()I", "setDisplayForbidden", "(I)V", "seqsCount", "getSeqsCount", "setSeqsCount", "definition", "getDefinition", "setDefinition", "videoStatus", "getVideoStatus", "setVideoStatus", OnekeyLoginConstants.CU_KEY_SEQ, "getSeq", "setSeq", "url", "getUrl", "setUrl", "appUrl", "getAppUrl", "setAppUrl", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class g implements Cloneable {

    @SerializedName("AlbumId")
    private long albumId;

    @SerializedName("AppUrl")
    private String appUrl;

    @SerializedName("CoverInfoList")
    private List<m> coverInfoList;

    @SerializedName("Definition")
    private String definition;

    @SerializedName("DisplayForbidden")
    private int displayForbidden;

    @SerializedName("Duration")
    private double duration;

    @SerializedName("EncodedVideoInfoList")
    private List<f> encodedVideoInfoList;

    @SerializedName("EpisodeId")
    private long episodeId;

    @SerializedName("Intro")
    private String intro;

    @SerializedName("Seq")
    private int seq;

    @SerializedName("SeqsCount")
    private int seqsCount;

    @SerializedName("Title")
    private String title;

    @SerializedName("Url")
    private String url;

    @SerializedName("VideoStatus")
    private int videoStatus;

    public g() {
        this.title = "";
        this.intro = "";
        this.definition = "";
        this.url = "";
        this.appUrl = "";
    }

    public final Object clone() {
        return super.clone();
    }
}
