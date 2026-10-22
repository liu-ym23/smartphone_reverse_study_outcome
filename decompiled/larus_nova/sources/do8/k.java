package do8;

import com.larus.chat.gallery.api.PreviewScene;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VLMMixerSearchResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f469459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f469460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f469461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VLMMixerSearchResult f469462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f469463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f469464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f469465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f469466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f469467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f469468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PreviewScene f469469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f469470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<Integer, Unit> f469471m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f469472n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f469459a == r101.f469459a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f469460b, r101.f469460b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f469461c, r101.f469461c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f469462d, r101.f469462d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f469463e, r101.f469463e) == true) goto L24;
        return false;
    L24:
        if (this.f469464f == r101.f469464f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f469465g, r101.f469465g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f469466h, r101.f469466h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f469467i, r101.f469467i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f469468j, r101.f469468j) == true) goto L39;
        return false;
    L39:
        if (this.f469469k == r101.f469469k) goto L42;
        return false;
    L42:
        if (this.f469470l == r101.f469470l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f469471m, r101.f469471m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f469472n, r101.f469472n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f469459a * 31;
        String r101 = this.f469460b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Message r105 = this.f469461c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f469462d.hashCode()) * 31;
        Integer r108 = this.f469463e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f469464f == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (r110 + r112) * 31;
        JSONObject r114 = this.f469465g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((((r113 + r115) * 31) + this.f469466h.hashCode()) * 31) + this.f469467i.hashCode()) * 31;
        Boolean r117 = this.f469468j;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (((r116 + r118) * 31) + this.f469469k.hashCode()) * 31;
        if (this.f469470l == true) goto L30;
        r111 = 1237;
    L30:
        int r120 = (r119 + r111) * 31;
        Function1<Integer, Unit> r121 = this.f469471m;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Boolean r124 = this.f469472n;
        if (r124 == null) goto L39;
        r102 = r124.hashCode();
    L39:
        return r123 + r102;
    L33:
        r122 = r121.hashCode();
        goto L34
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VLMContainerVMData(maxWidth=" + this.f469459a + ", toolName=" + this.f469460b + ", message=" + this.f469461c + ", model=" + this.f469462d + ", cardPosition=" + this.f469463e + ", enableCrossGroupPreview=" + this.f469464f + ", eventParams=" + this.f469465g + ", uiConfig=" + this.f469466h + ", preloadAndRecommendConfig=" + this.f469467i + ", disableNewImagePreview=" + this.f469468j + ", previewScene=" + this.f469469k + ", isVLM=" + this.f469470l + ", customClickListener=" + this.f469471m + ", enableShimmer=" + this.f469472n + ')';
    }

    public /* synthetic */ k(int r110, String r210, Message r211, VLMMixerSearchResult r212, Integer r213, boolean r214, JSONObject r215, j r216, i r217, Boolean r218, PreviewScene r219, Function1 r310, Boolean r311, int r312) {
        if ((r312 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r312 & 4) == 0) goto L9;
        Message r101 = null;
    L11:
        if ((r312 & 16) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r312 & 32) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r312 & 64) == 0) goto L21;
        JSONObject r111 = null;
    L23:
        if ((r312 & 128) == 0) goto L25;
        j r112 = new j(false, false, false, false, null, 63);
    L27:
        if ((r312 & 256) == 0) goto L29;
        i r113 = new i(0);
    L31:
        if ((r312 & 512) == 0) goto L33;
        Boolean r114 = null;
    L35:
        if ((r312 & 1024) == 0) goto L37;
        PreviewScene r115 = PreviewScene.MESSAGE;
    L39:
        if ((r312 & 2048) == 0) goto L41;
        boolean r116 = true;
    L43:
        if ((r312 & 4096) == 0) goto L45;
        Function1 r117 = null;
    L47:
        if ((r312 & 8192) == 0) goto L49;
        Boolean r118 = Boolean.FALSE;
    L50:
        this(r110, r100, r101, r212, r102, r103, r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L49:
        r118 = r311;
        goto L50
    L45:
        r117 = r310;
        goto L47
    L41:
        r116 = false;
        goto L43
    L37:
        r115 = r219;
        goto L39
    L33:
        r114 = r218;
        goto L35
    L29:
        r113 = r217;
        goto L31
    L25:
        r112 = r216;
        goto L27
    L21:
        r111 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(int r100, String r101, Message r102, VLMMixerSearchResult r103, Integer r104, boolean r105, JSONObject r106, j r107, i r110, Boolean r111, PreviewScene r112, boolean r113, Function1<? super Integer, Unit> r114, Boolean r115) {
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r107, "uiConfig");
        Intrinsics.checkNotNullParameter(r110, "preloadAndRecommendConfig");
        Intrinsics.checkNotNullParameter(r112, "previewScene");
        this.f469459a = r100;
        this.f469460b = r101;
        this.f469461c = r102;
        this.f469462d = r103;
        this.f469463e = r104;
        this.f469464f = r105;
        this.f469465g = r106;
        this.f469466h = r107;
        this.f469467i = r110;
        this.f469468j = r111;
        this.f469469k = r112;
        this.f469470l = r113;
        this.f469471m = r114;
        this.f469472n = r115;
    }
}
