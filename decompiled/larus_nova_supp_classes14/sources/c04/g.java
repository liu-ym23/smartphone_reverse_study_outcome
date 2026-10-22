package c04;

import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(r14.c r4) {
        JSONObject r0 = AoSettings.a("ao_feed_long_press_config");
        if (r0 == null) goto L5;
        boolean r1 = r0.optBoolean("enable_side_long_press", true);
    L7:
        if (r1 == true) goto L9;
        return false;
    L9:
        if (r4 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L36;
        if (r4 != null) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == true) goto L36;
        if (r4 != null) goto L23;
    L25:
        boolean r5 = false;
    L26:
        if (r5 == true) goto L36;
        if (r4 != null) goto L30;
    L32:
        boolean r6 = false;
    L33:
        if (r6 == false) goto L35;
        return false;
    L35:
        return true;
    L30:
        if (r4.Y() != true) goto L32;
        r6 = true;
        goto L33
    L23:
        if (r4.i() != 2) goto L25;
        r5 = true;
        goto L26
    L17:
        if (r4.i() != 68) goto L19;
        r3 = true;
    L36:
        return false;
    L11:
        if (r4.i() != 108) goto L13;
        r2 = true;
        goto L14
    L5:
        r1 = true;
        goto L7
    }
}
