package i74;

import com.bytedance.bd_sec_tee.core.TeeProvider;
import com.bytedance.bd_sec_tee.core.model.TeeResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, ArrayList<TeeResult<?>>> f488460a;

    /* JADX INFO: renamed from: i74.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C6235a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f488461a = null;

        static {
            int[] r100 = new int[TeeProvider.TeeStage.values().length];
            f488461a = r100;
            r100[TeeProvider.TeeStage.LOAD_KEYPAIR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f488461a[TeeProvider.TeeStage.PUBLIC_COMPARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f488461a[TeeProvider.TeeStage.SIGN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f488461a[TeeProvider.TeeStage.SIGN_COMPARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f488461a[TeeProvider.TeeStage.DERIVE_LOAD_SECRET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f488461a[TeeProvider.TeeStage.DERIVE_SIGN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public a() {
        this.f488460a = new ConcurrentHashMap();
    }

    public final JSONObject a(String r210, String r211) {
        JSONObject r100 = new JSONObject();
        r100.putOpt("tag", "sec_tee_key_v1");     // Catch: Exception -> L99
        r100.putOpt("scene", r210);     // Catch: Exception -> L99
        ArrayList<TeeResult<?>> r101 = this.f488460a.get(r211);     // Catch: Exception -> L99
        if (r101 != null) goto L6;
        return r100;
    L6:
        String r102 = "";
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L99
        monitor-enter(r101);     // Catch: Exception -> L99
        Iterator<TeeResult<?>> r104 = r101.iterator();     // Catch: Throwable -> L95
        String r110 = null;
        int r105 = 0;
        long r106 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        long r114 = 0;
        boolean r115 = true;
        long r116 = 0;
        int r117 = 0;
        int r212 = 0;
        int r213 = -1;
    L10:
        if (r104.hasNext() == false) goto L51;
        TeeResult<?> r107 = r104.next();     // Catch: Throwable -> L95
        if (r107 == null) goto L49;
        Iterator<TeeResult<?>> r214 = r104;
        TeeProvider.TeeStage r108 = r107.f199577a;     // Catch: Throwable -> L95
        if (r108 != null) goto L17;
        r103 = r103;
    L50:
        r103 = r103;
        r104 = r214;
        goto L10
    L17:
        if (r107.f199579c != 0) goto L19;
        boolean r109 = true;
    L20:
        r115 = r115 & r109;     // Catch: Throwable -> L95
        String r118 = r108.value;     // Catch: Throwable -> L95
        if (r118 == null) goto L28;
        int r119 = r103.size();     // Catch: Throwable -> L95
        if (r119 != 0) goto L26;
    L27:
        r103.add(r118);     // Catch: Throwable -> L95
        goto L28
    L26:
        if (r118.equals(ListProtector.get(r103, r119 - 1)) == false) goto L27;
    L28:
        int r120 = r107.f199579c;     // Catch: Throwable -> L95
        if (r120 == 0) goto L32;
        r102 = r107.f199580d;     // Catch: Throwable -> L95
        r213 = r120;
    L32:
        switch(C6235a.f488461a[r107.f199577a.ordinal()]) {
            case 1: goto L43;
            case 2: goto L40;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L34;
            default: goto L33;
        };     // Catch: Throwable -> L95
    L33:
        r102 = r102;
        r103 = r103;
    L48:
        r102 = r102;
        goto L50
    L34:
        long r121 = Math.max(r106, r107.f199581e);     // Catch: Throwable -> L95
        int r122 = Math.max(r112, r107.f199584h);     // Catch: Throwable -> L95
    L36:
        r212 = r212 + 1;     // Catch: Throwable -> L95
        r112 = r122;
        r106 = r121;
        goto L48
    L35:
        r121 = Math.max(r106, r107.f199581e);     // Catch: Throwable -> L95
        r122 = Math.max(r112, r107.f199584h);     // Catch: Throwable -> L95
        goto L36
    L37:
        r116 = r116 + r107.f199581e;     // Catch: Throwable -> L95
        int r123 = Math.max(r111, r107.f199584h);     // Catch: Throwable -> L95
    L39:
        r117 = r117 + 1;     // Catch: Throwable -> L95
        r111 = r123;
        goto L48
    L38:
        r116 = r116 + r107.f199581e;     // Catch: Throwable -> L95
        r123 = Math.max(r111, r107.f199584h);     // Catch: Throwable -> L95
        goto L39
    L40:
        r102 = r102;
        r103 = r103;
        r114 = r114 + r107.f199581e;     // Catch: Throwable -> L95
        int r124 = Math.max(r105, r107.f199584h);     // Catch: Throwable -> L95
        r113 = r113 + 1;     // Catch: Throwable -> L95
        TeeResult.KeySource r125 = r107.f199585i;     // Catch: Throwable -> L95
        if (r125 == null) goto L47;
        String r126 = r125.source;     // Catch: Throwable -> L95
    L46:
        r110 = r126;
    L47:
        r105 = r124;
        goto L48
    L43:
        r102 = r102;
        r103 = r103;
        r114 = r114 + r107.f199581e;     // Catch: Throwable -> L95
        r124 = Math.max(r105, r107.f199584h);     // Catch: Throwable -> L95
        r113 = r113 + 1;     // Catch: Throwable -> L95
        TeeResult.KeySource r127 = r107.f199585i;     // Catch: Throwable -> L95
        if (r127 == null) goto L47;
        r126 = r127.source;     // Catch: Throwable -> L95
        goto L46
    L19:
        r109 = false;
        goto L20
    L49:
        r103 = r103;
        r214 = r104;
        goto L50
    L51:
        ArrayList r128 = r103;
        monitor-exit(r101);     // Catch: Throwable -> L95
        goto L98
    L54:
        if (r113 <= 0) goto L56;
        long r215 = r114;
    L57:
        r100.putOpt("load_duration", Long.valueOf(r215));     // Catch: Exception -> L99
        if (r113 <= 0) goto L60;
        long r216 = r114;
    L61:
        r100.putOpt("create_duration", Long.valueOf(r216));     // Catch: Exception -> L99
        r100.putOpt("create_attempt_count", Integer.valueOf(r105));     // Catch: Exception -> L99
        r100.putOpt("load_attempt_count", Integer.valueOf(r105));     // Catch: Exception -> L99
        r100.putOpt("source", r110);     // Catch: Exception -> L99
        if (r117 <= 0) goto L64;
        long r129 = r116;
    L65:
        r100.putOpt("sign_duration", Long.valueOf(r129));     // Catch: Exception -> L99
        r100.putOpt("sign_attempt_count", Integer.valueOf(r111));     // Catch: Exception -> L99
        if (r212 <= 0) goto L68;
        long r130 = r106;
    L69:
        r100.putOpt("exchange_duration", Long.valueOf(r130));     // Catch: Exception -> L99
        r100.putOpt("exchange_attempt_count", Integer.valueOf(r112));     // Catch: Exception -> L99
        r100.putOpt("verify_sign_duration", -1L);     // Catch: Exception -> L99
        r100.putOpt("verify_sign_attempt_count", 0);     // Catch: Exception -> L99
        if (r115 == false) goto L72;
        int r131 = 1;
    L73:
        r100.putOpt("result", Integer.valueOf(r131));     // Catch: Exception -> L99
        r100.putOpt("total_duration", Long.valueOf(((r114 + r116) + r106) + 0));     // Catch: Exception -> L99
        r100.putOpt("error_code", Integer.valueOf(r213));     // Catch: Exception -> L99
        r100.putOpt("error_msg", r102);     // Catch: Exception -> L99
        StringBuilder r132 = new StringBuilder();     // Catch: Exception -> L99
        int r133 = 0;
    L75:
        if (r133 >= r128.size()) goto L79;
        if (r133 <= 0) goto L78;
        r132.append(',');     // Catch: Exception -> L99
    L78:
        r132.append((String) ListProtector.get(r128, r133));     // Catch: Exception -> L99
        r133 = r133 + 1;     // Catch: Exception -> L99
        goto L75
    L79:
        r100.putOpt("history_stages", r132.toString());     // Catch: Exception -> L99
        if (r128.isEmpty() == false) goto L82;
        String r134 = "";
    L83:
        r100.putOpt("stage", r134);     // Catch: Exception -> L99
        if ("comparePublicKeyWithLocal".equals(r211) == false) goto L87;
        int r135 = 0;
    L93:
        r100.putOpt("tee_type", Integer.valueOf(r135));     // Catch: Exception -> L99
        r100.putOpt("params_for_special", "uc_login");     // Catch: Exception -> L99
        goto L98
    L87:
        if ("secretDerivationAndSign".equals(r211) == false) goto L90;
        r135 = 1;
        goto L93
    L90:
        if ("compareSignWithLocal".equals(r211) == false) goto L92;
        r135 = 2;
        goto L93
    L92:
        r135 = -1;
        goto L93
    L82:
        r134 = (String) ListProtector.get(r128, r128.size() - 1);     // Catch: Exception -> L99
        goto L83
    L72:
        r131 = 0;
        goto L73
    L68:
        r130 = -1;
        goto L69
    L64:
        r129 = -1;
        goto L65
    L60:
        r216 = -1;
        goto L61
    L56:
        r215 = -1;
    L95:
        th = move-exception;
        throw th;     // Catch: Exception -> L99
    L98:
        return r100;
    }
}
