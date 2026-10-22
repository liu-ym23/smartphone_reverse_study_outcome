package io.michaelrocks.libphonenumber.android;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.vivo.libra.CallBack;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f492238d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f492239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Phonemetadata$PhoneMetadata> f492240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Integer> f492241c;

    static {
        f492238d = Logger.getLogger(d.class.getName());
    }

    public d(a r100) {
        this.f492240b = new ConcurrentHashMap();
        new ConcurrentHashMap();
        HashSet r101 = new HashSet(62);
        r101.add(7);
        r101.add(27);
        r101.add(30);
        r101.add(31);
        r101.add(34);
        r101.add(36);
        r101.add(39);
        r101.add(43);
        r101.add(44);
        r101.add(49);
        r101.add(52);
        r101.add(54);
        r101.add(55);
        r101.add(58);
        r101.add(61);
        r101.add(62);
        r101.add(63);
        r101.add(64);
        r101.add(66);
        r101.add(81);
        r101.add(84);
        r101.add(90);
        r101.add(91);
        r101.add(94);
        r101.add(95);
        r101.add(255);
        r101.add(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG));
        r101.add(351);
        r101.add(352);
        r101.add(358);
        r101.add(359);
        r101.add(372);
        r101.add(373);
        r101.add(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER));
        r101.add(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200));
        r101.add(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500));
        r101.add(505);
        r101.add(506);
        r101.add(595);
        r101.add(675);
        r101.add(676);
        r101.add(679);
        r101.add(855);
        r101.add(856);
        r101.add(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_GSKEY_CPU_REFRESH_FIX));
        r101.add(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_GSKEY_CPU_NATIVE_REFRESH));
        r101.add(995);
        this.f492241c = r101;
        HashSet r102 = new HashSet(320);
        r102.add("AC");
        r102.add("AD");
        r102.add("AE");
        r102.add("AF");
        r102.add("AG");
        r102.add("AI");
        r102.add("AL");
        r102.add("AM");
        r102.add("AO");
        r102.add("AR");
        r102.add("AS");
        r102.add("AT");
        r102.add("AU");
        r102.add("AW");
        r102.add("AX");
        r102.add("AZ");
        r102.add("BA");
        r102.add("BB");
        r102.add("BD");
        r102.add("BE");
        r102.add("BF");
        r102.add("BG");
        r102.add("BH");
        r102.add("BI");
        r102.add("BJ");
        r102.add("BL");
        r102.add("BM");
        r102.add("BN");
        r102.add("BO");
        r102.add("BQ");
        r102.add("BR");
        r102.add("BS");
        r102.add("BT");
        r102.add("BW");
        r102.add("BY");
        r102.add("BZ");
        r102.add("CA");
        r102.add(PromotionCrossBorderStruct.CLEAR_CC_TYPE);
        r102.add("CD");
        r102.add("CF");
        r102.add("CG");
        r102.add("CH");
        r102.add("CI");
        r102.add("CK");
        r102.add("CL");
        r102.add("CM");
        r102.add("CN");
        r102.add("CO");
        r102.add("CR");
        r102.add("CU");
        r102.add("CV");
        r102.add("CW");
        r102.add("CX");
        r102.add("CY");
        r102.add("CZ");
        r102.add("DE");
        r102.add("DJ");
        r102.add("DK");
        r102.add("DM");
        r102.add("DO");
        r102.add("DZ");
        r102.add(CryptoConst.ALGORITHM_EC);
        r102.add("EE");
        r102.add("EG");
        r102.add("EH");
        r102.add("ER");
        r102.add("ES");
        r102.add("ET");
        r102.add("FI");
        r102.add("FJ");
        r102.add("FK");
        r102.add("FM");
        r102.add("FO");
        r102.add("FR");
        r102.add("GA");
        r102.add("GB");
        r102.add("GD");
        r102.add("GE");
        r102.add("GF");
        r102.add("GG");
        r102.add("GH");
        r102.add("GI");
        r102.add("GL");
        r102.add("GM");
        r102.add("GN");
        r102.add("GP");
        r102.add("GR");
        r102.add("GT");
        r102.add("GU");
        r102.add("GW");
        r102.add("GY");
        r102.add("HK");
        r102.add("HN");
        r102.add("HR");
        r102.add("HT");
        r102.add("HU");
        r102.add("ID");
        r102.add("IE");
        r102.add("IL");
        r102.add("IM");
        r102.add("IN");
        r102.add("IQ");
        r102.add("IR");
        r102.add("IS");
        r102.add("IT");
        r102.add("JE");
        r102.add("JM");
        r102.add("JO");
        r102.add("JP");
        r102.add("KE");
        r102.add("KG");
        r102.add("KH");
        r102.add("KI");
        r102.add("KM");
        r102.add("KN");
        r102.add("KP");
        r102.add("KR");
        r102.add("KW");
        r102.add("KY");
        r102.add("KZ");
        r102.add("LA");
        r102.add("LB");
        r102.add("LC");
        r102.add("LI");
        r102.add("LK");
        r102.add("LR");
        r102.add("LS");
        r102.add("LT");
        r102.add("LU");
        r102.add("LV");
        r102.add("LY");
        r102.add("MA");
        r102.add("MC");
        r102.add("MD");
        r102.add("ME");
        r102.add("MF");
        r102.add("MG");
        r102.add("MH");
        r102.add("MK");
        r102.add("ML");
        r102.add("MM");
        r102.add("MN");
        r102.add("MO");
        r102.add("MP");
        r102.add("MQ");
        r102.add("MR");
        r102.add("MS");
        r102.add("MT");
        r102.add("MU");
        r102.add("MV");
        r102.add("MW");
        r102.add(HTTP.MX);
        r102.add("MY");
        r102.add("MZ");
        r102.add("NA");
        r102.add("NC");
        r102.add("NE");
        r102.add("NF");
        r102.add("NG");
        r102.add("NI");
        r102.add("NL");
        r102.add("NO");
        r102.add("NP");
        r102.add("NR");
        r102.add("NU");
        r102.add("NZ");
        r102.add("OM");
        r102.add("PA");
        r102.add("PE");
        r102.add("PF");
        r102.add("PG");
        r102.add("PH");
        r102.add("PK");
        r102.add("PL");
        r102.add(CallBack.EVENT_POWER_MODE);
        r102.add("PR");
        r102.add("PS");
        r102.add("PT");
        r102.add("PW");
        r102.add("PY");
        r102.add("QA");
        r102.add("RE");
        r102.add("RO");
        r102.add("RS");
        r102.add("RU");
        r102.add("RW");
        r102.add("SA");
        r102.add("SB");
        r102.add("SC");
        r102.add("SD");
        r102.add("SE");
        r102.add("SG");
        r102.add("SH");
        r102.add("SI");
        r102.add("SJ");
        r102.add("SK");
        r102.add("SL");
        r102.add(CallBack.EVENT_SLEEP_MODE);
        r102.add("SN");
        r102.add("SO");
        r102.add("SR");
        r102.add("ST");
        r102.add("SV");
        r102.add("SX");
        r102.add("SY");
        r102.add("SZ");
        r102.add("TC");
        r102.add("TD");
        r102.add("TG");
        r102.add("TH");
        r102.add("TJ");
        r102.add("TL");
        r102.add("TM");
        r102.add("TN");
        r102.add("TO");
        r102.add("TR");
        r102.add("TT");
        r102.add("TV");
        r102.add("TW");
        r102.add("TZ");
        r102.add("UA");
        r102.add("UG");
        r102.add("US");
        r102.add("UY");
        r102.add("UZ");
        r102.add("VA");
        r102.add("VC");
        r102.add("VE");
        r102.add("VG");
        r102.add("VI");
        r102.add("VN");
        r102.add("VU");
        r102.add("WF");
        r102.add("WS");
        r102.add("XK");
        r102.add("YE");
        r102.add("YT");
        r102.add("ZA");
        r102.add("ZM");
        r102.add("ZW");
        this.f492239a = r100;
    }

    public final <T> Phonemetadata$PhoneMetadata a(T r100, ConcurrentHashMap<T, Phonemetadata$PhoneMetadata> r101, String r102) {
        Phonemetadata$PhoneMetadata r103 = r101.get(r100);
        if (r103 == null) goto L5;
        return r103;
    L5:
        String r104 = r102 + "_" + r100;
        a r105 = (a) this.f492239a;
        r105.getClass();
        ObjectInputStream r106 = null;
        InputStream r107 = r105.f492237a.open(r104.substring(1));     // Catch: IOException -> L8
    L9:
        if (r107 == null) goto L47;
        ObjectInputStream r108 = new ObjectInputStream(r107);     // Catch: Throwable -> L34 IOException -> L36
        Phonemetadata$PhoneMetadataCollection r109 = new Phonemetadata$PhoneMetadataCollection();     // Catch: Throwable -> L32
        r109.readExternal(r108);     // Catch: IOException -> L29 Throwable -> L32
        r108.close();     // Catch: IOException -> L16
    L18:
        List<Phonemetadata$PhoneMetadata> r110 = r109.getMetadataList();
        if (r110.size() == 0) goto L28;
        if (r110.size() <= 1) goto L23;
        f492238d.log(Level.WARNING, "more than one metadata in file ".concat(r104));
    L23:
        Phonemetadata$PhoneMetadata r111 = (Phonemetadata$PhoneMetadata) ListProtector.get(r110, 0);
        Phonemetadata$PhoneMetadata r112 = r101.putIfAbsent(r100, r111);
        if (r112 != null) goto L26;
        return r111;
    L26:
        return r112;
    L28:
        throw new IllegalStateException("empty metadata: ".concat(r104));
    L16:
        e = move-exception;
        f492238d.log(Level.WARNING, "error closing input stream (ignored)", e);
        goto L18
    L29:
        e = move-exception;
        throw new RuntimeException("cannot load/parse metadata", e);     // Catch: Throwable -> L32
    L32:
        th = th;
        r106 = r108;
    L57:
        if (r106 == null) goto L41;
        r106.close();     // Catch: IOException -> L43
    L56:
    L45:
        throw th;
    L41:
        r107.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        f492238d.log(Level.WARNING, "error closing input stream (ignored)", e);
        goto L45
    L34:
        th = th;
    L36:
        e = move-exception;
        throw new RuntimeException("cannot load/parse metadata", e);     // Catch: Throwable -> L34
    L47:
        throw new IllegalStateException("missing metadata: ".concat(r104));
    L8:
        r107 = null;
        goto L9
    }
}
