package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bRB\u0010/\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020-\u0018\u00010,j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020-\u0018\u0001`.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/b;", "", "", "seqsCount", "I", "getSeqsCount", "()I", "setSeqsCount", "(I)V", "", "albumId", "J", "getAlbumId", "()J", "setAlbumId", "(J)V", "", "Lcom/bytedance/awemeopen/domain/series/c;", "albumTagList", "Ljava/util/List;", "getAlbumTagList", "()Ljava/util/List;", "setAlbumTagList", "(Ljava/util/List;)V", "Lcom/bytedance/awemeopen/domain/series/m;", "coverInfoList", "getCoverInfoList", "setCoverInfoList", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "platformRecordNumber", "getPlatformRecordNumber", "setPlatformRecordNumber", "displayForbidden", "getDisplayForbidden", "setDisplayForbidden", "latestSeqsCount", "getLatestSeqsCount", "setLatestSeqsCount", "Ljava/util/HashMap;", "Lcom/bytedance/awemeopen/domain/series/a;", "Lkotlin/collections/HashMap;", "albumControlMap", "Ljava/util/HashMap;", "getAlbumControlMap", "()Ljava/util/HashMap;", "setAlbumControlMap", "(Ljava/util/HashMap;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class b implements Cloneable {

    @SerializedName("AlbumControlMap")
    private HashMap<Long, a> albumControlMap;

    @SerializedName("AlbumId")
    private long albumId;

    @SerializedName("AlbumTagList")
    private List<c> albumTagList;

    @SerializedName("CoverInfoList")
    private List<m> coverInfoList;

    @SerializedName("DisplayForbidden")
    private int displayForbidden;

    @SerializedName("LatestSeqsCount")
    private int latestSeqsCount;

    @SerializedName("PlatformRecordNumber")
    private String platformRecordNumber;

    @SerializedName("SeqsCount")
    private int seqsCount;

    @SerializedName("Title")
    private String title;

    public b() {
        this.title = "";
        this.platformRecordNumber = "";
    }

    public final Object clone() {
        return super.clone();
    }
}
