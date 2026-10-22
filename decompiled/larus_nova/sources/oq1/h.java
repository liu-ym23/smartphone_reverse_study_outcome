package oq1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Loq1/h;", "", "", "sizeFor360p", "I", "getSizeFor360p", "()I", "setSizeFor360p", "(I)V", "sizeFor480p", "getSizeFor480p", "setSizeFor480p", "sizeFor720p", "getSizeFor720p", "setSizeFor720p", "sizeFor1080p", "getSizeFor1080p", "setSizeFor1080p", "<init>", "()V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("video_preload_size_config_1080p")
    private int sizeFor1080p;

    @SerializedName("video_preload_size_config_360p")
    private int sizeFor360p;

    @SerializedName("video_preload_size_config_480p")
    private int sizeFor480p;

    @SerializedName("video_preload_size_config_720p")
    private int sizeFor720p;

    public h() {
        this.sizeFor360p = 650;
        this.sizeFor480p = 800;
        this.sizeFor720p = 1000;
        this.sizeFor1080p = 1500;
    }
}
