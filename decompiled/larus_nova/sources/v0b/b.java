package v0b;

import android.util.Base64;
import com.ss.android.lark.chameleonv2.debug.CmlDebugSettingUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f552342a = 0;

    static {
    }

    public static Map a(boolean r100) {
        HashMap r101 = new HashMap();
        if (Intrinsics.areEqual(CmlDebugSettingUtil.a("chameleon_app_name", "doubao"), "doubao") == false) goto L17;
        if (r100 == true) goto L17;
        String r102 = CmlDebugSettingUtil.a("chameleon_header_username", "");
        String r103 = CmlDebugSettingUtil.a("chameleon_header_pwd", "");
        boolean r104 = true;
        if (r102.length() != 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L17;
        if (r103.length() == 0) goto L14;
        r104 = false;
    L14:
        if (r104 == true) goto L17;
        String r106 = Base64.encodeToString((r102 + ':' + r103).getBytes(Charsets.UTF_8), 2);
        StringBuilder r107 = new StringBuilder("Basic ");
        r107.append(r106);
        r101.put("Authorization", r107.toString());
        goto L17
    L8:
        r105 = false;
    L17:
        return r101;
    }
}
