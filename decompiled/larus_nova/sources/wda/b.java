package wda;

import android.bluetooth.BluetoothDevice;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tha.c;

/* JADX INFO: loaded from: classes33.dex */
public final class b {
    static {
    }

    public static String a() {
        IBluetoothHeadSetAPI r100 = c.a();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L11;
        return null;
    L11:
        IBluetoothHeadSetAPI r103 = c.a();
        if (r103 == null) goto L32;
        BluetoothDevice r104 = r103.g();
        if (r104 == null) goto L33;
        String r105 = r104.getAddress();
        if (r105 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r105)) == true) goto L21;
        r105 = null;
    L21:
        if (r105 != null) goto L23;
        return null;
    L23:
        if (r105.length() != 0) goto L25;
        r101 = true;
    L25:
        if (r101 == true) goto L36;
        byte[] r106 = MessageDigest.getInstance("SHA-256").digest(r105.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L29
        return ArraysKt.joinToString$default(r106, "", null, null, 0, null, new a(), 30, null);
    L37:
        return null;
    L36:
        return null;
    L33:
        return null;
    L32:
        return null;
    L5:
        if (r100.a() != true) goto L7;
        r102 = true;
        goto L9
    }
}
