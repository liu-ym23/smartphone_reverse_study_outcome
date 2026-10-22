package r14;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001a¨\u0006)"}, d2 = {"Lr14/h0;", "", "", "allowDownload", "Ljava/lang/Boolean;", "getAllowDownload", "()Ljava/lang/Boolean;", "setAllowDownload", "(Ljava/lang/Boolean;)V", "", "shareType", "I", "getShareType", "()I", "setShareType", "(I)V", "showProgressBar", "getShowProgressBar", "setShowProgressBar", "draftProgressBar", "getDraftProgressBar", "setDraftProgressBar", "isAllowDuet", "Z", "()Z", "setAllowDuet", "(Z)V", "isAllowReact", "setAllowReact", "isAllowDynamicWallpaper", "setAllowDynamicWallpaper", "preventDownloadType", "getPreventDownloadType", "setPreventDownloadType", "timerStatus", "getTimerStatus", "setTimerStatus", "isAllowMusic", "setAllowMusic", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class h0 {

    @SerializedName("allow_download")
    private Boolean allowDownload;

    @SerializedName("draft_progress_bar")
    private int draftProgressBar;

    @SerializedName("allow_duet")
    private boolean isAllowDuet;

    @SerializedName("allow_dynamic_wallpaper")
    private boolean isAllowDynamicWallpaper;

    @SerializedName("allow_music")
    private boolean isAllowMusic;

    @SerializedName("allow_react")
    private boolean isAllowReact;

    @SerializedName("prevent_download_type")
    private int preventDownloadType;

    @SerializedName("share_type")
    private int shareType;

    @SerializedName("show_progress_bar")
    private int showProgressBar;

    @SerializedName("timer_status")
    private int timerStatus;

    public h0() {
        this.timerStatus = 1;
        this.isAllowMusic = true;
    }
}
