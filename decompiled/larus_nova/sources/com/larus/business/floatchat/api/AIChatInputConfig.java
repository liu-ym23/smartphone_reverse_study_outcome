package com.larus.business.floatchat.api;

import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class AIChatInputConfig {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final List<PlusAction> f320085m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f320086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f320087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f320088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f320089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f320090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f320091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<PlusAction> f320092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f320093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f320094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f320095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f320096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f320097l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/business/floatchat/api/AIChatInputConfig$PlusAction;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", FlowDoraWifiScene.ALBUM, "FILE", "VOICE_CALL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PlusAction extends Enum<PlusAction> {
        public static final PlusAction ALBUM = null;
        public static final PlusAction CAMERA = null;
        public static final PlusAction FILE = null;
        public static final PlusAction VOICE_CALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlusAction[] f320098a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f320099b = null;

        public static EnumEntries<PlusAction> getEntries() {
            return f320099b;
        }

        static {
            PlusAction r100 = new PlusAction("CAMERA", 0);
            CAMERA = r100;
            PlusAction r101 = new PlusAction(FlowDoraWifiScene.ALBUM, 1);
            ALBUM = r101;
            PlusAction r102 = new PlusAction("FILE", 2);
            FILE = r102;
            PlusAction r103 = new PlusAction("VOICE_CALL", 3);
            VOICE_CALL = r103;
            PlusAction[] r104 = {r100, r101, r102, r103};
            f320098a = r104;
            f320099b = EnumEntriesKt.enumEntries(r104);
        }

        public static PlusAction[] values() {
            return (PlusAction[]) f320098a.clone();
        }

        public static PlusAction valueOf(String r100) {
            return (PlusAction) r27.a.a(PlusAction.class, r100);
        }

        public PlusAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public AIChatInputConfig() {
        this(0, null, 0, false, null, 0, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIChatInputConfig) == true) goto L8;
        return false;
    L8:
        AIChatInputConfig r101 = (AIChatInputConfig) r100;
        if (this.f320086a == r101.f320086a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f320087b, r101.f320087b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f320088c, r101.f320088c) == true) goto L18;
        return false;
    L18:
        if (this.f320089d == r101.f320089d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f320090e, r101.f320090e) == true) goto L24;
        return false;
    L24:
        if (this.f320091f == r101.f320091f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f320092g, r101.f320092g) == true) goto L30;
        return false;
    L30:
        if (this.f320093h == r101.f320093h) goto L33;
        return false;
    L33:
        if (this.f320094i == r101.f320094i) goto L36;
        return false;
    L36:
        if (this.f320095j == r101.f320095j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f320096k, r101.f320096k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f320097l, r101.f320097l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f320086a * 31;
        String r101 = this.f320087b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f320088c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f320089d) * 31;
        Map<String, String> r108 = this.f320090e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f320091f == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f320092g.hashCode()) * 31;
        if (this.f320093h == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        if (this.f320094i == true) goto L26;
        r111 = 1237;
    L26:
        int r116 = (((r115 + r111) * 31) + this.f320095j) * 31;
        Integer r117 = this.f320096k;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        Boolean r120 = this.f320097l;
        if (r120 == null) goto L35;
        r102 = r120.hashCode();
    L35:
        return r119 + r102;
    L29:
        r118 = r117.hashCode();
        goto L30
    L21:
        r114 = 1237;
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
        return "AIChatInputConfig(defaultInputMode=" + this.f320086a + ", hint=" + this.f320087b + ", speakHint=" + this.f320088c + ", indicateActionEntrance=" + this.f320089d + ", actionEntranceConfig=" + this.f320090e + ", showPlusMenu=" + this.f320091f + ", plusActions=" + this.f320092g + ", enableActionBar=" + this.f320093h + ", useAlphaStyle=" + this.f320094i + ", colorMode=" + this.f320095j + ", answerIntentLogic=" + this.f320096k + ", userPromptHoverEverytimeOverride=" + this.f320097l + ')';
    }

    static {
        f320085m = CollectionsKt.listOf(new PlusAction[]{PlusAction.CAMERA, PlusAction.ALBUM, PlusAction.FILE, PlusAction.VOICE_CALL});
    }

    public static AIChatInputConfig a(AIChatInputConfig r110, String r111, String r112, int r210, boolean r211, List r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        int r100 = r110.f320086a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r101 = r110.f320087b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r102 = r110.f320088c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        int r103 = r110.f320089d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        Map<String, String> r104 = r110.f320090e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        boolean r113 = r110.f320091f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        List r114 = r110.f320092g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        boolean r115 = r110.f320093h;
    L35:
        if ((r213 & 256) == 0) goto L37;
        boolean r116 = r110.f320094i;
    L39:
        if ((r213 & 512) == 0) goto L41;
        int r117 = r110.f320095j;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        Integer r118 = r110.f320096k;
    L47:
        if ((r213 & 2048) == 0) goto L49;
        Boolean r119 = r110.f320097l;
    L50:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r114, "plusActions");
        return new AIChatInputConfig(r100, r101, r102, r103, r104, r113, r114, r115, r116, r117, r118, r119);
    L49:
        r119 = null;
        goto L50
    L45:
        r118 = null;
        goto L47
    L41:
        r117 = 0;
        goto L43
    L37:
        r116 = false;
        goto L39
    L33:
        r115 = false;
        goto L35
    L29:
        r114 = r212;
        goto L31
    L25:
        r113 = r211;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = 0;
        goto L7
    }

    public /* synthetic */ AIChatInputConfig(int r110, String r111, int r112, boolean r210, List r211, int r212, Boolean r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r214 & 8) == 0) goto L13;
        int r102 = 1;
    L15:
        if ((r214 & 32) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r214 & 64) == 0) goto L21;
        List r113 = f320085m;
    L23:
        if ((r214 & 512) == 0) goto L25;
        int r114 = 0;
    L27:
        if ((r214 & 2048) == 0) goto L29;
        Boolean r115 = null;
    L30:
        this(r100, r101, null, r102, null, r103, r113, false, false, r114, null, r115);
        return;
    L29:
        r115 = r213;
        goto L30
    L25:
        r114 = r212;
        goto L27
    L21:
        r113 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIChatInputConfig(int r100, String r101, String r102, int r103, Map<String, String> r104, boolean r105, List<? extends PlusAction> r106, boolean r107, boolean r110, int r111, Integer r112, Boolean r113) {
        Intrinsics.checkNotNullParameter(r106, "plusActions");
        this.f320086a = r100;
        this.f320087b = r101;
        this.f320088c = r102;
        this.f320089d = r103;
        this.f320090e = r104;
        this.f320091f = r105;
        this.f320092g = r106;
        this.f320093h = r107;
        this.f320094i = r110;
        this.f320095j = r111;
        this.f320096k = r112;
        this.f320097l = r113;
    }
}
