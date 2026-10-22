package kr8;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.e2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001fJª\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u000f\u0010\u001f¨\u00067"}, d2 = {"Lcom/larus/bmhome/music/mob/CompleteCreateMusicMobEvent;", "Lcom/larus/trace/MobEvent;", "mobKey", "", "currentPage", "previousPage", "enterMethod", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "botId", "chatType", "createWay", "lyricCreateType", "isLyric", "success", "errorInfo", "isCreationActionBar", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getMobKey", "()Ljava/lang/String;", "getCurrentPage", "getPreviousPage", "getEnterMethod", "getModel", "getBotId", "getChatType", "getCreateWay", "getLyricCreateType", "getSuccess", "getErrorInfo", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/music/mob/CompleteCreateMusicMobEvent;", "equals", "other", "", "hashCode", "", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e implements e2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f505855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f505856c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f505857a;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName("create_way")
    private final String createWay;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName(MapMonitorConst.ERROR_INFO)
    private final String errorInfo;

    @SerializedName("is_creation_action_bar")
    private final Boolean isCreationActionBar;

    @SerializedName("is_lyric")
    private final String isLyric;

    @SerializedName("lyric_create_type")
    private final String lyricCreateType;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final String model;

    @SerializedName("previous_page")
    private final String previousPage;

    @SerializedName("success")
    private final String success;

    public static final class a {
        public static long a() {
            if (e.f505855b != 0) goto L6;
            return 0;
        L6:
            return System.currentTimeMillis() - e.f505855b;
        }
    }

    static {
    }

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f505857a, r101.f505857a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.chatType, r101.chatType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createWay, r101.createWay) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.lyricCreateType, r101.lyricCreateType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isLyric, r101.isLyric) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.success, r101.success) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.errorInfo, r101.errorInfo) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.isCreationActionBar, r101.isCreationActionBar) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f505857a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.currentPage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.previousPage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.enterMethod;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.model;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.botId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.chatType;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.createWay;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.lyricCreateType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.isLyric;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.success;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.errorInfo;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.isCreationActionBar;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CompleteCreateMusicMobEvent(mobKey=" + this.f505857a + ", currentPage=" + this.currentPage + ", previousPage=" + this.previousPage + ", enterMethod=" + this.enterMethod + ", model=" + this.model + ", botId=" + this.botId + ", chatType=" + this.chatType + ", createWay=" + this.createWay + ", lyricCreateType=" + this.lyricCreateType + ", isLyric=" + this.isLyric + ", success=" + this.success + ", errorInfo=" + this.errorInfo + ", isCreationActionBar=" + this.isCreationActionBar + ')';
    }

    @Override // tx9.e2
    public final String a() {
        return this.f505857a;
    }

    @Override // tx9.e2
    public final void b(by7.e r100, JSONObject r101) {
        e2.a.a(this, r100, r101);
    }

    public e(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, Boolean r217, int r218) {
        Boolean r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = "complete_create_music";
    L6:
        String r102 = "";
        if ((r218 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r107 = "";
    L27:
        if ((r218 & 64) == 0) goto L29;
        String r113 = "";
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r114 = "chat_action_bar";
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r115 = "";
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r116 = "1";
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r117 = "";
    L47:
        if ((r218 & 2048) != 0) goto L51;
        r102 = r216;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r100 = r217;
    L54:
        this.f505857a = r101;
        this.currentPage = r103;
        this.previousPage = r104;
        this.enterMethod = r105;
        this.model = r106;
        this.botId = r107;
        this.chatType = r113;
        this.createWay = r114;
        this.lyricCreateType = r115;
        this.isLyric = r116;
        this.success = r117;
        this.errorInfo = r102;
        this.isCreationActionBar = r100;
        f505855b = System.currentTimeMillis();
        return;
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r114 = null;
        goto L35
    L29:
        r113 = r212;
        goto L31
    L25:
        r107 = r211;
        goto L27
    L21:
        r106 = r210;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r101 = null;
        goto L6
    }
}
