package d99;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public final class a {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r100;
    L6:
        if (r100.length() > 24) goto L9;
        return "***";
    L9:
        return r100.substring(0, 12) + "***" + r100.substring(r100.length() - 12);
    }
}
