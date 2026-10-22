package com.larus.avlink.simulInterpret.page.model;

import com.larus.nova.R;
import com.larus.utils.j0;
import ha8.d;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BO\b\u0002\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "", "topIconRes", "", "bottomIconRes", "topTranslatingIconRes", "bottomTranslatingIconRes", "isShowMuteIcon", "", "onboardingDescription", "", "endSubtitle", "<init>", "(Ljava/lang/String;IIIIIZLjava/lang/String;Ljava/lang/String;)V", "getTopIconRes", "()I", "getBottomIconRes", "getTopTranslatingIconRes", "getBottomTranslatingIconRes", "()Z", "getOnboardingDescription", "()Ljava/lang/String;", "getEndSubtitle", "DEVICE_LITE", "DEVICE_G", "DEVICE_E", "DEVICE_LORY", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraDeviceType extends Enum<DoraDeviceType> {
    public static final DoraDeviceType DEVICE_E = null;
    public static final DoraDeviceType DEVICE_G = null;
    public static final DoraDeviceType DEVICE_LITE = null;
    public static final DoraDeviceType DEVICE_LORY = null;
    public static final DoraDeviceType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraDeviceType[] f294484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294485b = null;
    private final int bottomIconRes;
    private final int bottomTranslatingIconRes;
    private final String endSubtitle;
    private final boolean isShowMuteIcon;
    private final String onboardingDescription;
    private final int topIconRes;
    private final int topTranslatingIconRes;

    public static EnumEntries<DoraDeviceType> getEntries() {
        return f294485b;
    }

    static {
        int r100 = j0.f375426a;
        DoraDeviceType r110 = new DoraDeviceType("DEVICE_LITE", 0, R.drawable.icon_left_earphone_si, R.drawable.icon_right_earphone_si, R.drawable.icon_left_earphone_translating_si, R.drawable.icon_right_earphone_translating_si, false, j0.d(R.string.larus_dora_lite_translate_intro_cn), j0.d(R.string.larus_dora_lite_translate_btn_exit_cn));
        DEVICE_LITE = r110;
        boolean r101 = d.f484397a;
        DoraDeviceType r102 = new DoraDeviceType("DEVICE_G", 1, R.drawable.icon_phone_si, R.drawable.icon_glass_si, R.drawable.icon_phone_translating_si, R.drawable.icon_glass_translating_si, false, j0.d(R.string.larus_dora_g_translate_intro_cn), j0.d(R.string.larus_dora_g_translate_end_cn));
        DEVICE_G = r102;
        DoraDeviceType r103 = new DoraDeviceType("DEVICE_E", 2, 0, 0, 0, 0, false, null, null, 127, null);
        DEVICE_E = r103;
        DoraDeviceType r104 = new DoraDeviceType("DEVICE_LORY", 3, 0, 0, 0, 0, false, null, null, 127, null);
        DEVICE_LORY = r104;
        DoraDeviceType r105 = new DoraDeviceType("UNKNOWN", 4, 0, 0, 0, 0, false, null, null, 127, null);
        UNKNOWN = r105;
        DoraDeviceType[] r106 = {r110, r102, r103, r104, r105};
        f294484a = r106;
        f294485b = EnumEntriesKt.enumEntries(r106);
    }

    public static DoraDeviceType[] values() {
        return (DoraDeviceType[]) f294484a.clone();
    }

    public final int getBottomIconRes() {
        return this.bottomIconRes;
    }

    public final int getBottomTranslatingIconRes() {
        return this.bottomTranslatingIconRes;
    }

    public final String getEndSubtitle() {
        return this.endSubtitle;
    }

    public final String getOnboardingDescription() {
        return this.onboardingDescription;
    }

    public final int getTopIconRes() {
        return this.topIconRes;
    }

    public final int getTopTranslatingIconRes() {
        return this.topTranslatingIconRes;
    }

    public final boolean isShowMuteIcon() {
        return this.isShowMuteIcon;
    }

    public static DoraDeviceType valueOf(String r100) {
        return (DoraDeviceType) r27.a.a(DoraDeviceType.class, r100);
    }

    public DoraDeviceType(String r100, int r101, int r102, int r103, int r104, int r105, boolean r106, String r107, String r108) {
        super(r100, r101);
        this.topIconRes = r102;
        this.bottomIconRes = r103;
        this.topTranslatingIconRes = r104;
        this.bottomTranslatingIconRes = r105;
        this.isShowMuteIcon = r106;
        this.onboardingDescription = r107;
        this.endSubtitle = r108;
    }

    public /* synthetic */ DoraDeviceType(String r110, int r111, int r112, int r113, int r114, int r115, boolean r116, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r212 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r117 = "";
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r118 = "";
    L30:
        this(r110, r111, r100, r101, r102, r103, r104, r117, r118);
        return;
    L29:
        r118 = r211;
        goto L30
    L25:
        r117 = r210;
        goto L27
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
