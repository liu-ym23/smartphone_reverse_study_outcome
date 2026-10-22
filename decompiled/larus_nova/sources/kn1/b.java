package kn1;

import com.bytedance.android.livesdk.utils.n2;
import com.bytedance.android.logsdk.format.Spm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f504153a = false;

    static {
        Function0<Boolean> r100 = n2.f159083a;
        if (r100 == null) goto L7;
        Boolean r101 = r100.invoke();
        if (r101 == null) goto L7;
        boolean r102 = r101.booleanValue();
    L8:
        f504153a = r102;
        return;
    L7:
        r102 = false;
        goto L8
    }

    @JvmStatic
    public static final void a(int r100, tw2.b r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("endMic", Integer.valueOf(r100));
        e(r101, "endMicRoom", "room_end_mic", r102);
    }

    @JvmStatic
    public static final void b(Map<String, Object> r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.put("endRoom", Integer.valueOf(r101));
    }

    @JvmStatic
    public static final void d(Map<String, Object> r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.put("roomError", Integer.valueOf(r101));
    }

    @JvmStatic
    public static final void c(Map<String, Object> r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        switch(r102) {
            case 1: goto L82;
            case 2: goto L67;
            case 3: goto L52;
            case 4: goto L37;
            case 5: goto L22;
            case 6: goto L7;
            default: goto L145;
        };
    L7:
        if (r101 == 6) goto L21;
        if (r101 == 9) goto L20;
        if (r101 == 14) goto L19;
        if (r101 == 21) goto L18;
        if (r101 == 22) goto L17;
        switch(r101) {
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            default: goto L146;
        };
    L14:
        r100.put("endRoom", 46);
        return;
    L15:
        r100.put("endRoom", 40);
        return;
    L16:
        r100.put("endRoom", 34);
        return;
    L146:
        return;
    L17:
        r100.put("endRoom", 70);
        return;
    L18:
        r100.put("endRoom", 52);
        return;
    L19:
        r100.put("endRoom", 28);
        return;
    L20:
        r100.put("endRoom", 64);
        return;
    L21:
        r100.put("endRoom", 58);
        return;
    L22:
        if (r101 == 6) goto L36;
        if (r101 == 9) goto L35;
        if (r101 == 14) goto L34;
        if (r101 == 21) goto L33;
        if (r101 == 22) goto L32;
        switch(r101) {
            case 16: goto L31;
            case 17: goto L30;
            case 18: goto L29;
            default: goto L147;
        };
    L29:
        r100.put("endRoom", 45);
        return;
    L30:
        r100.put("endRoom", 39);
        return;
    L31:
        r100.put("endRoom", 33);
        return;
    L147:
        return;
    L32:
        r100.put("endRoom", 69);
        return;
    L33:
        r100.put("endRoom", 51);
        return;
    L34:
        r100.put("endRoom", 27);
        return;
    L35:
        r100.put("endRoom", 63);
        return;
    L36:
        r100.put("endRoom", 57);
        return;
    L37:
        if (r101 == 6) goto L51;
        if (r101 == 9) goto L50;
        if (r101 == 14) goto L49;
        if (r101 == 21) goto L48;
        if (r101 == 22) goto L47;
        switch(r101) {
            case 16: goto L46;
            case 17: goto L45;
            case 18: goto L44;
            default: goto L148;
        };
    L44:
        r100.put("endRoom", 44);
        return;
    L45:
        r100.put("endRoom", 38);
        return;
    L46:
        r100.put("endRoom", 32);
        return;
    L148:
        return;
    L47:
        r100.put("endRoom", 68);
        return;
    L48:
        r100.put("endRoom", 50);
        return;
    L49:
        r100.put("endRoom", 26);
        return;
    L50:
        r100.put("endRoom", 62);
        return;
    L51:
        r100.put("endRoom", 56);
        return;
    L52:
        if (r101 == 6) goto L66;
        if (r101 == 9) goto L65;
        if (r101 == 14) goto L64;
        if (r101 == 21) goto L63;
        if (r101 == 22) goto L62;
        switch(r101) {
            case 16: goto L61;
            case 17: goto L60;
            case 18: goto L59;
            default: goto L149;
        };
    L59:
        r100.put("endRoom", 43);
        return;
    L60:
        r100.put("endRoom", 37);
        return;
    L61:
        r100.put("endRoom", 31);
        return;
    L149:
        return;
    L62:
        r100.put("endRoom", 67);
        return;
    L63:
        r100.put("endRoom", 49);
        return;
    L64:
        r100.put("endRoom", 25);
        return;
    L65:
        r100.put("endRoom", 61);
        return;
    L66:
        r100.put("endRoom", 55);
        return;
    L67:
        if (r101 == 6) goto L81;
        if (r101 == 9) goto L80;
        if (r101 == 14) goto L79;
        if (r101 == 21) goto L78;
        if (r101 == 22) goto L77;
        switch(r101) {
            case 16: goto L76;
            case 17: goto L75;
            case 18: goto L74;
            default: goto L150;
        };
    L74:
        r100.put("endRoom", 42);
        return;
    L75:
        r100.put("endRoom", 36);
        return;
    L76:
        r100.put("endRoom", 30);
        return;
    L150:
        return;
    L77:
        r100.put("endRoom", 66);
        return;
    L78:
        r100.put("endRoom", 48);
        return;
    L79:
        r100.put("endRoom", 24);
        return;
    L80:
        r100.put("endRoom", 60);
        return;
    L81:
        r100.put("endRoom", 54);
        return;
    L82:
        if (r101 == 6) goto L96;
        if (r101 == 9) goto L95;
        if (r101 == 14) goto L94;
        if (r101 == 21) goto L93;
        if (r101 == 22) goto L92;
        switch(r101) {
            case 16: goto L91;
            case 17: goto L90;
            case 18: goto L89;
            default: goto L151;
        };
    L89:
        r100.put("endRoom", 41);
        return;
    L90:
        r100.put("endRoom", 35);
        return;
    L91:
        r100.put("endRoom", 29);
        return;
    L151:
        return;
    L92:
        r100.put("endRoom", 65);
        return;
    L93:
        r100.put("endRoom", 47);
        return;
    L94:
        r100.put("endRoom", 23);
        return;
    L95:
        r100.put("endRoom", 59);
        return;
    L96:
        r100.put("endRoom", 53);
        return;
    }

    @JvmStatic
    public static final void e(tw2.b r100, String r101, String r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "prefixTag");
        if (f504153a == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isIgnored() == true) goto L18;
        String r104 = r100.getSpm();
        if (r104 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r104, "") == false) goto L14;
        return;
    L14:
        Spm.Companion.getClass();
        Spm r105 = Spm.a.a(r104);
        HashMap r106 = new HashMap();
        r106.putAll(r103);
        r105.args(r106);
        r105.addArg("eventName", r101);
        vw2.a.a(r105.addArg("name", r100.getClass().getSimpleName()), r102);
        return;
    }
}
