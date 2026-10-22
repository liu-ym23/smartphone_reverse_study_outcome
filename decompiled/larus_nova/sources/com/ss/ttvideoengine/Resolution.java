package com.ss.ttvideoengine;

import android.text.TextUtils;
import com.lynx.canvas.KryptonCamera;
import com.ss.ttvideoengine.model.VideoRef;

/* JADX INFO: loaded from: classes34.dex */
public final enum Resolution extends Enum<Resolution> {
    private static final /* synthetic */ Resolution[] $VALUES = null;
    public static final Resolution Auto = null;
    public static final Resolution EightK = null;
    public static final Resolution ExtremelyHigh = null;
    public static final Resolution ExtremelyHighPlus = null;
    public static final Resolution ExtremelyHigh_120F = null;
    public static final Resolution ExtremelyHigh_50F = null;
    public static final Resolution ExtremelyHigh_60F = null;
    public static final Resolution ExtremelyHigh_HDR = null;
    public static final Resolution FourK = null;
    public static final Resolution FourK_120F = null;
    public static final Resolution FourK_50F = null;
    public static final Resolution FourK_60F = null;
    public static final Resolution FourK_HDR = null;
    public static final Resolution HDR = null;
    public static final Resolution H_High = null;
    public static final Resolution H_High_HDR = null;
    public static final Resolution High = null;
    public static final Resolution High_HDR = null;
    public static final Resolution L_Standard = null;
    public static final Resolution L_Standard_HDR = null;
    public static final int RESOLUTION_AUDIO = 1;
    public static final int RESOLUTION_VIDEO = 0;
    public static final Resolution Standard = null;
    public static final Resolution Standard_HDR = null;
    public static final Resolution SuperHigh = null;
    public static final Resolution SuperHigh_HDR = null;
    public static final Resolution TwoK = null;
    public static final Resolution TwoK_120F = null;
    public static final Resolution TwoK_50F = null;
    public static final Resolution TwoK_60F = null;
    public static final Resolution TwoK_HDR = null;
    public static final Resolution Undefine = null;
    private final String audioquality;
    private final String resolution;

    static {
        Resolution r100 = new Resolution("Undefine", 0, "", "");
        Undefine = r100;
        Resolution r101 = new Resolution("Standard", 1, "360p", KryptonCamera.Config.RESOLUTION_MEDIUM);
        Standard = r101;
        Resolution r102 = new Resolution("High", 2, "480p", "higher");
        High = r102;
        Resolution r103 = new Resolution("SuperHigh", 3, "720p", "highest");
        SuperHigh = r103;
        Resolution r104 = new Resolution("ExtremelyHigh", 4, "1080p", "original");
        ExtremelyHigh = r104;
        Resolution r105 = new Resolution("FourK", 5, "4k", "lossless");
        FourK = r105;
        Resolution r110 = new Resolution("HDR", 6, "hdr", "");
        HDR = r110;
        Resolution r111 = new Resolution("Auto", 7, "auto", "");
        Auto = r111;
        Resolution r112 = new Resolution("L_Standard", 8, "240p", "");
        L_Standard = r112;
        Resolution r113 = new Resolution("H_High", 9, "540p", "");
        H_High = r113;
        Resolution r114 = new Resolution("TwoK", 10, "2k", "");
        TwoK = r114;
        Resolution r106 = new Resolution("ExtremelyHigh_50F", 11, "1080p 50fps", "");
        ExtremelyHigh_50F = r106;
        Resolution r107 = new Resolution("TwoK_50F", 12, "2k 50fps", "");
        TwoK_50F = r107;
        Resolution r108 = new Resolution("FourK_50F", 13, "4k 50fps", "");
        FourK_50F = r108;
        Resolution r109 = new Resolution("ExtremelyHigh_60F", 14, "1080p 60fps", "");
        ExtremelyHigh_60F = r109;
        Resolution r115 = new Resolution("TwoK_60F", 15, "2k 60fps", "");
        TwoK_60F = r115;
        Resolution r116 = new Resolution("FourK_60F", 16, "4k 60fps", "");
        FourK_60F = r116;
        Resolution r117 = new Resolution("ExtremelyHigh_120F", 17, "1080p 120fps", "");
        ExtremelyHigh_120F = r117;
        Resolution r118 = new Resolution("TwoK_120F", 18, "2k 120fps", "");
        TwoK_120F = r118;
        Resolution r119 = new Resolution("FourK_120F", 19, "4k 120fps", "");
        FourK_120F = r119;
        Resolution r120 = new Resolution("L_Standard_HDR", 20, "240p HDR", "");
        L_Standard_HDR = r120;
        Resolution r121 = new Resolution("Standard_HDR", 21, "360p HDR", "");
        Standard_HDR = r121;
        Resolution r122 = new Resolution("High_HDR", 22, "480p HDR", "");
        High_HDR = r122;
        Resolution r123 = new Resolution("H_High_HDR", 23, "540p HDR", "");
        H_High_HDR = r123;
        Resolution r124 = new Resolution("SuperHigh_HDR", 24, "720p HDR", "");
        SuperHigh_HDR = r124;
        Resolution r125 = new Resolution("ExtremelyHigh_HDR", 25, "1080p HDR", "");
        ExtremelyHigh_HDR = r125;
        Resolution r126 = new Resolution("TwoK_HDR", 26, "2k HDR", "");
        TwoK_HDR = r126;
        Resolution r127 = new Resolution("FourK_HDR", 27, "4k HDR", "");
        FourK_HDR = r127;
        Resolution r128 = new Resolution("EightK", 28, "8k", "");
        EightK = r128;
        Resolution r129 = new Resolution("ExtremelyHighPlus", 29, "1080p+", "");
        ExtremelyHighPlus = r129;
        $VALUES = new Resolution[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129};
    }

    public static Resolution[] getAllResolutions() {
        return new Resolution[]{Undefine, L_Standard, Standard, High, H_High, SuperHigh, ExtremelyHigh, ExtremelyHighPlus, ExtremelyHigh_50F, ExtremelyHigh_60F, ExtremelyHigh_120F, HDR, TwoK, TwoK_50F, TwoK_60F, TwoK_120F, FourK, FourK_50F, FourK_60F, FourK_120F, L_Standard_HDR, Standard_HDR, High_HDR, H_High_HDR, SuperHigh_HDR, ExtremelyHigh_HDR, TwoK_HDR, FourK_HDR, EightK};
    L6:
        return new Resolution[0];
    }

    public static Resolution[] values() {
        return (Resolution[]) $VALUES.clone();
    }

    public int getIndex() {
        return ordinal();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.resolution;
    }

    public static Resolution forString(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return Undefine;
    L7:
        if (r100.equals("Undefine") == false) goto L11;
        return Undefine;
    L11:
        if (r100.equals("Standard") == false) goto L15;
        return Standard;
    L15:
        if (r100.equals("High") == false) goto L19;
        return High;
    L19:
        if (r100.equals("SuperHigh") == false) goto L23;
        return SuperHigh;
    L23:
        if (r100.equals("FourK") == false) goto L27;
        return FourK;
    L27:
        if (r100.equals("HDR") == false) goto L31;
        return HDR;
    L31:
        if (r100.equals("Auto") == false) goto L35;
        return Auto;
    L35:
        if (r100.equals("L_Standard") == false) goto L39;
        return L_Standard;
    L39:
        if (r100.equals("H_High") == false) goto L43;
        return H_High;
    L43:
        if (r100.equals("TwoK") == false) goto L47;
        return TwoK;
    L47:
        if (r100.equals("ExtremelyHigh_50F") == false) goto L51;
        return ExtremelyHigh_50F;
    L51:
        if (r100.equals("TwoK_50F") == false) goto L55;
        return TwoK_50F;
    L55:
        if (r100.equals("FourK_50F") == false) goto L59;
        return FourK_50F;
    L59:
        if (r100.equals("ExtremelyHigh_60F") == false) goto L63;
        return ExtremelyHigh_60F;
    L63:
        if (r100.equals("TwoK_60F") == false) goto L67;
        return TwoK_60F;
    L67:
        if (r100.equals("FourK_60F") == false) goto L71;
        return FourK_60F;
    L71:
        if (r100.equals("ExtremelyHigh_120F") == false) goto L75;
        return ExtremelyHigh_120F;
    L75:
        if (r100.equals("TwoK_120F") == false) goto L79;
        return TwoK_120F;
    L79:
        if (r100.equals("FourK_120F") == false) goto L83;
        return FourK_120F;
    L83:
        if (r100.equals("L_Standard_HDR") == false) goto L87;
        return L_Standard_HDR;
    L87:
        if (r100.equals("Standard_HDR") == false) goto L91;
        return Standard_HDR;
    L91:
        if (r100.equals("High_HDR") == false) goto L95;
        return High_HDR;
    L95:
        if (r100.equals("H_High_HDR") == false) goto L99;
        return H_High_HDR;
    L99:
        if (r100.equals("SuperHigh_HDR") == false) goto L103;
        return SuperHigh_HDR;
    L103:
        if (r100.equals("ExtremelyHigh_HDR") == false) goto L107;
        return ExtremelyHigh_HDR;
    L107:
        if (r100.equals("TwoK_HDR") == false) goto L111;
        return TwoK_HDR;
    L111:
        if (r100.equals("FourK_HDR") == false) goto L115;
        return FourK_HDR;
    L115:
        if (r100.equals("EightK") == false) goto L119;
        return EightK;
    L119:
        if (r100.equals("1080p+") == false) goto L123;
        return ExtremelyHighPlus;
    L123:
        return Undefine;
    }

    public static String toString(Resolution r100) {
        if (r100 != null) goto L6;
        return "Undefine";
    L6:
        if (r100 != Undefine) goto L9;
        return "Undefine";
    L9:
        if (r100 != Standard) goto L13;
        return "Standard";
    L13:
        if (r100 != High) goto L17;
        return "High";
    L17:
        if (r100 != SuperHigh) goto L21;
        return "SuperHigh";
    L21:
        if (r100 != FourK) goto L25;
        return "FourK";
    L25:
        if (r100 != HDR) goto L29;
        return "HDR";
    L29:
        if (r100 != Auto) goto L33;
        return "Auto";
    L33:
        if (r100 != L_Standard) goto L37;
        return "L_Standard";
    L37:
        if (r100 != H_High) goto L41;
        return "H_High";
    L41:
        if (r100 != TwoK) goto L45;
        return "TwoK";
    L45:
        if (r100 != ExtremelyHigh_50F) goto L49;
        return "ExtremelyHigh_50F";
    L49:
        if (r100 != TwoK_50F) goto L53;
        return "TwoK_50F";
    L53:
        if (r100 != FourK_50F) goto L57;
        return "FourK_50F";
    L57:
        if (r100 != ExtremelyHigh_60F) goto L61;
        return "ExtremelyHigh_60F";
    L61:
        if (r100 != TwoK_60F) goto L65;
        return "TwoK_60F";
    L65:
        if (r100 != FourK_60F) goto L69;
        return "FourK_60F";
    L69:
        if (r100 != ExtremelyHigh_120F) goto L73;
        return "ExtremelyHigh_120F";
    L73:
        if (r100 != TwoK_120F) goto L77;
        return "TwoK_120F";
    L77:
        if (r100 != FourK_120F) goto L81;
        return "FourK_120F";
    L81:
        if (r100 != L_Standard_HDR) goto L85;
        return "L_Standard_HDR";
    L85:
        if (r100 != Standard_HDR) goto L89;
        return "Standard_HDR";
    L89:
        if (r100 != High_HDR) goto L93;
        return "High_HDR";
    L93:
        if (r100 != H_High_HDR) goto L97;
        return "H_High_HDR";
    L97:
        if (r100 != SuperHigh_HDR) goto L101;
        return "SuperHigh_HDR";
    L101:
        if (r100 != ExtremelyHigh_HDR) goto L105;
        return "ExtremelyHigh_HDR";
    L105:
        if (r100 != TwoK_HDR) goto L109;
        return "TwoK_HDR";
    L109:
        if (r100 != FourK_HDR) goto L113;
        return "FourK_HDR";
    L113:
        if (r100 != EightK) goto L117;
        return "EightK";
    L117:
        if (r100 != ExtremelyHighPlus) goto L120;
        return "1080p+";
    L120:
        return "Undefine";
    }

    public static Resolution valueOf(int r100) {
        Resolution r101 = Undefine;
        if (r100 >= r101.ordinal()) goto L5;
    L8:
        return r101;
    L5:
        if (r100 > FourK_HDR.ordinal()) goto L8;
        return values()[r100];
    }

    public static Resolution valueOf(String r100) {
        return (Resolution) r27.a.a(Resolution.class, r100);
    }

    public String toString(int r100) {
        if (r100 != VideoRef.TYPE_AUDIO) goto L7;
        return this.audioquality;
    L7:
        if (r100 == VideoRef.TYPE_VIDEO) goto L9;
        return "";
    L9:
        return this.resolution;
    }

    private Resolution(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.resolution = r102;
        this.audioquality = r103;
    }
}
