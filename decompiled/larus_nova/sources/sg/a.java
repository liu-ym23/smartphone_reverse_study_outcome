package sg;

import cl.d;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f541759a = 0;

    static {
    }

    public static Object a(String r100, Object r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        Intrinsics.checkNotNullParameter(r102, PlayerResolution.SDKKEY.ORIGIN);
        d r103 = k.a();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
    L6:
        return r102.invoke();
    }
}
