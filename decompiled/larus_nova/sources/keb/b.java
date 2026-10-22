package keb;

import com.dtf.face.api.IDTFacade;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b5\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR \u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR \u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\t¨\u0006:"}, d2 = {"Lcom/ss/android/lark/feed/shared/data/expired_fold/LocaleWord;", "", "<init>", "()V", "deDE", "", "getDeDE", "()Ljava/lang/String;", "setDeDE", "(Ljava/lang/String;)V", "enUS", "getEnUS", "setEnUS", "esES", "getEsES", "setEsES", "frFR", "getFrFR", "setFrFR", "idID", "getIdID", "setIdID", "itIT", "getItIT", "setItIT", "jaJP", "getJaJP", "setJaJP", "koKR", "getKoKR", "setKoKR", "msMY", "getMsMY", "setMsMY", "ptBR", "getPtBR", "setPtBR", "ruRU", "getRuRU", "setRuRU", "stJO", "getStJO", "setStJO", "thTH", "getThTH", "setThTH", "viVN", "getViVN", "setViVN", "zhCN", "getZhCN", "setZhCN", "zhHK", "getZhHK", "setZhHK", "zhTW", "getZhTW", "setZhTW", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("de-DE")
    private String deDE;

    @SerializedName("en-US")
    private String enUS;

    @SerializedName("es-ES")
    private String esES;

    @SerializedName("fr-FR")
    private String frFR;

    @SerializedName("id-ID")
    private String idID;

    @SerializedName("it-IT")
    private String itIT;

    @SerializedName("ja-JP")
    private String jaJP;

    @SerializedName("ko-KR")
    private String koKR;

    @SerializedName("ms-MY")
    private String msMY;

    @SerializedName("pt-BR")
    private String ptBR;

    @SerializedName("ru-RU")
    private String ruRU;

    @SerializedName("st-JO")
    private String stJO;

    @SerializedName("th-TH")
    private String thTH;

    @SerializedName("vi-VN")
    private String viVN;

    @SerializedName("zh-CN")
    private String zhCN;

    @SerializedName(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK)
    private String zhHK;

    @SerializedName(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW)
    private String zhTW;

    public b() {
    }

    public final String a() {
        return this.deDE;
    }

    public final String b() {
        return this.enUS;
    }

    public final String c() {
        return this.esES;
    }

    public final String d() {
        return this.frFR;
    }

    public final String e() {
        return this.idID;
    }

    public final String f() {
        return this.itIT;
    }

    public final String g() {
        return this.jaJP;
    }

    public final String h() {
        return this.koKR;
    }

    public final String i() {
        return this.msMY;
    }

    public final String j() {
        return this.ptBR;
    }

    public final String k() {
        return this.ruRU;
    }

    public final String l() {
        return this.stJO;
    }

    public final String m() {
        return this.thTH;
    }

    public final String n() {
        return this.viVN;
    }

    public final String o() {
        return this.zhCN;
    }

    public final String p() {
        return this.zhHK;
    }

    public final String q() {
        return this.zhTW;
    }
}
