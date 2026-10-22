package com.larus.dora.o.impl.simul;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!Bm\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/larus/dora/o/impl/simul/OSimulDeviceForm;", "", "topIconRes", "", "bottomIconRes", "topTranslatingIconRes", "bottomTranslatingIconRes", "introRes", "exitHintRes", "supportConference", "", "adjustAreaSize", "topSideLabelRes", "bottomSideLabelRes", "<init>", "(Ljava/lang/String;IIIIIIIZZLjava/lang/Integer;Ljava/lang/Integer;)V", "getTopIconRes", "()I", "getBottomIconRes", "getTopTranslatingIconRes", "getBottomTranslatingIconRes", "getIntroRes", "getExitHintRes", "getSupportConference", "()Z", "getAdjustAreaSize", "getTopSideLabelRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomSideLabelRes", "EARPHONE", "GLASSES", "UNKNOWN", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OSimulDeviceForm extends Enum<OSimulDeviceForm> {
    public static final String ARG_PRODUCT_ID = "product_id";
    public static final a Companion = null;
    public static final OSimulDeviceForm EARPHONE = null;
    public static final OSimulDeviceForm GLASSES = null;
    public static final OSimulDeviceForm UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OSimulDeviceForm[] f338864a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f338865b = null;
    private final boolean adjustAreaSize;
    private final int bottomIconRes;
    private final Integer bottomSideLabelRes;
    private final int bottomTranslatingIconRes;
    private final int exitHintRes;
    private final int introRes;
    private final boolean supportConference;
    private final int topIconRes;
    private final Integer topSideLabelRes;
    private final int topTranslatingIconRes;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OSimulDeviceForm> getEntries() {
        return f338865b;
    }

    static {
        OSimulDeviceForm r110 = new OSimulDeviceForm("EARPHONE", 0, R.drawable.dora_o_left_earphone_si, R.drawable.dora_o_right_earphone_si, R.drawable.dora_o_left_earphone_translating_si, R.drawable.dora_o_right_earphone_translating_si, R.string.larus_dora_lite_translate_intro_cn, R.string.larus_dora_lite_translate_btn_exit_cn, false, false, Integer.valueOf(R.string.larus_dora_o_simul_side_earphone_left), Integer.valueOf(R.string.larus_dora_o_simul_side_earphone_right));
        EARPHONE = r110;
        OSimulDeviceForm r100 = new OSimulDeviceForm("GLASSES", 1, R.drawable.dora_o_ic_phone_rectangle_horizontal_line, R.drawable.dora_o_ic_glasses, R.drawable.dora_o_phone_translating_si, R.drawable.dora_o_glass_translating_si, R.string.larus_dora_g_translate_intro_cn, R.string.larus_dora_g_translate_end_cn, true, true, null, null);
        GLASSES = r100;
        OSimulDeviceForm r101 = new OSimulDeviceForm("UNKNOWN", 2, 0, 0, 0, 0, 0, 0, false, false, null, null);
        UNKNOWN = r101;
        OSimulDeviceForm[] r102 = {r110, r100, r101};
        f338864a = r102;
        f338865b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static OSimulDeviceForm[] values() {
        return (OSimulDeviceForm[]) f338864a.clone();
    }

    public final boolean getAdjustAreaSize() {
        return this.adjustAreaSize;
    }

    public final int getBottomIconRes() {
        return this.bottomIconRes;
    }

    public final Integer getBottomSideLabelRes() {
        return this.bottomSideLabelRes;
    }

    public final int getBottomTranslatingIconRes() {
        return this.bottomTranslatingIconRes;
    }

    public final int getExitHintRes() {
        return this.exitHintRes;
    }

    public final int getIntroRes() {
        return this.introRes;
    }

    public final boolean getSupportConference() {
        return this.supportConference;
    }

    public final int getTopIconRes() {
        return this.topIconRes;
    }

    public final Integer getTopSideLabelRes() {
        return this.topSideLabelRes;
    }

    public final int getTopTranslatingIconRes() {
        return this.topTranslatingIconRes;
    }

    public static OSimulDeviceForm valueOf(String r100) {
        return (OSimulDeviceForm) r27.a.a(OSimulDeviceForm.class, r100);
    }

    public OSimulDeviceForm(String r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, boolean r108, boolean r110, Integer r111, Integer r112) {
        super(r100, r101);
        this.topIconRes = r102;
        this.bottomIconRes = r103;
        this.topTranslatingIconRes = r104;
        this.bottomTranslatingIconRes = r105;
        this.introRes = r106;
        this.exitHintRes = r107;
        this.supportConference = r108;
        this.adjustAreaSize = r110;
        this.topSideLabelRes = r111;
        this.bottomSideLabelRes = r112;
    }
}
