package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006("}, d2 = {"Lcom/larus/platform/model/AppLaunchOptV4;", "", "enable", "", "enableNewUserPreload", "enableMainContainer", "enablePreAttachContainer", "enableFirstFeedDelayLoad", "enableNitaLoad", "enableMainTabDelayLoad", "optSoloader", "optNetClient", "<init>", "(ZZZZZZZZZ)V", "getEnable", "()Z", "getEnableNewUserPreload", "getEnableMainContainer", "getEnablePreAttachContainer", "getEnableFirstFeedDelayLoad", "getEnableNitaLoad", "getEnableMainTabDelayLoad", "getOptSoloader", "getOptNetClient", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_first_feed_delay_load")
    private final boolean enableFirstFeedDelayLoad;

    @SerializedName("enable_main_container")
    private final boolean enableMainContainer;

    @SerializedName("enable_main_tab_delay_load")
    private final boolean enableMainTabDelayLoad;

    @SerializedName("enable_new_user_preload")
    private final boolean enableNewUserPreload;

    @SerializedName("enable_nita_load")
    private final boolean enableNitaLoad;

    @SerializedName("enable_pre_attach_container")
    private final boolean enablePreAttachContainer;

    @SerializedName("opt_net_client")
    private final boolean optNetClient;

    @SerializedName("opt_soloader")
    private final boolean optSoloader;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.enableNewUserPreload == r101.enableNewUserPreload) goto L15;
        return false;
    L15:
        if (this.enableMainContainer == r101.enableMainContainer) goto L18;
        return false;
    L18:
        if (this.enablePreAttachContainer == r101.enablePreAttachContainer) goto L21;
        return false;
    L21:
        if (this.enableFirstFeedDelayLoad == r101.enableFirstFeedDelayLoad) goto L24;
        return false;
    L24:
        if (this.enableNitaLoad == r101.enableNitaLoad) goto L27;
        return false;
    L27:
        if (this.enableMainTabDelayLoad == r101.enableMainTabDelayLoad) goto L30;
        return false;
    L30:
        if (this.optSoloader == r101.optSoloader) goto L33;
        return false;
    L33:
        if (this.optNetClient == r101.optNetClient) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableNewUserPreload == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableMainContainer == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enablePreAttachContainer == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enableFirstFeedDelayLoad == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.enableNitaLoad == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.enableMainTabDelayLoad == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.optSoloader == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.optNetClient == true) goto L39;
        r100 = 1237;
    L39:
        return r116 + r100;
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppLaunchOptV4(enable=" + this.enable + ", enableNewUserPreload=" + this.enableNewUserPreload + ", enableMainContainer=" + this.enableMainContainer + ", enablePreAttachContainer=" + this.enablePreAttachContainer + ", enableFirstFeedDelayLoad=" + this.enableFirstFeedDelayLoad + ", enableNitaLoad=" + this.enableNitaLoad + ", enableMainTabDelayLoad=" + this.enableMainTabDelayLoad + ", optSoloader=" + this.optSoloader + ", optNetClient=" + this.optNetClient + ')';
    }

    public final boolean a() {
        if (this.enable == true) goto L5;
    L9:
        return false;
    L5:
        if (this.enableMainContainer == false) goto L9;
        if (this.enableFirstFeedDelayLoad == false) goto L9;
        return true;
    }

    public final boolean b() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableMainContainer == false) goto L7;
        return true;
    }

    public final boolean c() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableMainTabDelayLoad == false) goto L7;
        return true;
    }

    public final boolean d() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableNewUserPreload == false) goto L7;
        return true;
    }

    public final boolean e() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enableNitaLoad == false) goto L7;
        return true;
    }

    public final boolean f() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enablePreAttachContainer == false) goto L7;
        return true;
    }

    public final boolean g() {
        return this.enable;
    }

    public final boolean h() {
        return this.optNetClient;
    }

    public /* synthetic */ j(int r110) {
        this(false, false, false, false, false, false, false, false, false);
    }

    public j(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r108) {
        this.enable = r100;
        this.enableNewUserPreload = r101;
        this.enableMainContainer = r102;
        this.enablePreAttachContainer = r103;
        this.enableFirstFeedDelayLoad = r104;
        this.enableNitaLoad = r105;
        this.enableMainTabDelayLoad = r106;
        this.optSoloader = r107;
        this.optNetClient = r108;
    }
}
