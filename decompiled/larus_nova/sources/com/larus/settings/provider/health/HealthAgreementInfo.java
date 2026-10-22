package com.larus.settings.provider.health;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/larus/settings/provider/health/HealthAgreementInfo;", "Ljava/io/Serializable;", "url", "", "startIndex", "", "length", "trackName", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getStartIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLength", "getTrackName", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HealthAgreementInfo implements Serializable {

    @SerializedName("length")
    private final Integer length;

    @SerializedName("start_index")
    private final Integer startIndex;

    @SerializedName("track_name")
    private final String trackName;

    @SerializedName("url")
    private final String url;

    public HealthAgreementInfo() {
        this(null, null, null, null, 15, null);
    }

    public final Integer getLength() {
        return this.length;
    }

    public final Integer getStartIndex() {
        return this.startIndex;
    }

    public final String getTrackName() {
        return this.trackName;
    }

    public final String getUrl() {
        return this.url;
    }

    public HealthAgreementInfo(String r100, Integer r101, Integer r102, String r103) {
        this.url = r100;
        this.startIndex = r101;
        this.length = r102;
        this.trackName = r103;
    }

    public /* synthetic */ HealthAgreementInfo(String r100, Integer r101, Integer r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
