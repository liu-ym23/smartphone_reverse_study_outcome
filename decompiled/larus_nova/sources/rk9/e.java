package rk9;

import android.media.AudioManager;
import com.larus.im.internal.delegate.c0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {
    public static final boolean b(AudioManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reason");
        r100.startBluetoothSco();     // Catch: Throwable -> L6
        return a(r100, true, r101);
    L6:
        th = move-exception;
        c0.f348199b.w("AudioRoutePolicyController", r101 + ": startBluetoothSco failed: " + th.getMessage());
        return false;
    }

    public static final boolean c(AudioManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reason");
        r100.stopBluetoothSco();     // Catch: Throwable -> L6
        return a(r100, false, r101);
    L6:
        th = move-exception;
        c0.f348199b.w("AudioRoutePolicyController", r101 + ": stopBluetoothSco failed: " + th.getMessage());
        return false;
    }

    public static final boolean a(AudioManager r100, boolean r101, String r102) {
        r100.setBluetoothScoOn(r101);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        c0.f348199b.w("AudioRoutePolicyController", r102 + ": set isBluetoothScoOn=" + r101 + " failed: " + th.getMessage());
        return false;
    }
}
