package keb;

import com.dtf.face.api.IDTFacade;
import java.util.Locale;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f503130a = null;

    static {
        f503130a = new a();
    }

    public a() {
    }

    public static String a(Locale r100, b r101) {
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r100.getLanguage() + '-' + r100.getCountry();
        switch(r102.hashCode()) {
            case 95406413: goto L73;
            case 96598594: goto L69;
            case 96747053: goto L65;
            case 97640813: goto L61;
            case 99994381: goto L57;
            case 100471053: goto L53;
            case 100828572: goto L49;
            case 102169200: goto L45;
            case 104135475: goto L41;
            case 106935481: goto L37;
            case 108812813: goto L33;
            case 109706289: goto L29;
            case 110272621: goto L25;
            case 112149522: goto L21;
            case 115813226: goto L17;
            case 115813378: goto L13;
            case 115813762: goto L9;
            default: goto L93;
        };
    L93:
        return null;
    L9:
        if (r102.equals(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_TW) == true) goto L77;
        return null;
    L77:
        return r101.q();
    L13:
        if (r102.equals(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_ZH_HK) == true) goto L78;
        return null;
    L78:
        return r101.p();
    L17:
        if (r102.equals("zh-CN") == true) goto L79;
        return null;
    L79:
        return r101.o();
    L21:
        if (r102.equals("vi-VN") == true) goto L80;
        return null;
    L80:
        return r101.n();
    L25:
        if (r102.equals("th-TH") == true) goto L81;
        return null;
    L81:
        return r101.m();
    L29:
        if (r102.equals("st-JO") == true) goto L82;
        return null;
    L82:
        return r101.l();
    L33:
        if (r102.equals("ru-RU") == true) goto L83;
        return null;
    L83:
        return r101.k();
    L37:
        if (r102.equals("pt-BR") == true) goto L84;
        return null;
    L84:
        return r101.j();
    L41:
        if (r102.equals("ms-MY") == true) goto L85;
        return null;
    L85:
        return r101.i();
    L45:
        if (r102.equals("ko-KR") == true) goto L86;
        return null;
    L86:
        return r101.h();
    L49:
        if (r102.equals("ja-JP") == true) goto L87;
        return null;
    L87:
        return r101.g();
    L53:
        if (r102.equals("it-IT") == true) goto L88;
        return null;
    L88:
        return r101.f();
    L57:
        if (r102.equals("id-ID") == true) goto L89;
        return null;
    L89:
        return r101.e();
    L61:
        if (r102.equals("fr-FR") == true) goto L90;
        return null;
    L90:
        return r101.d();
    L65:
        if (r102.equals("es-ES") == true) goto L91;
        return null;
    L91:
        return r101.c();
    L69:
        if (r102.equals("en-US") == true) goto L92;
        return null;
    L92:
        return r101.b();
    L73:
        if (r102.equals("de-DE") == true) goto L76;
        return null;
    L76:
        return r101.a();
    }
}
