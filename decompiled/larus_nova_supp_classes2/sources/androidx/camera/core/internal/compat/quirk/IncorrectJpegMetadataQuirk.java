package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class IncorrectJpegMetadataQuirk implements Quirk {
    private static final Set<String> SAMSUNG_DEVICES = null;

    public IncorrectJpegMetadataQuirk() {
    }

    static {
        SAMSUNG_DEVICES = new HashSet(Arrays.asList(new String[]{"A24"}));
    }

    private static boolean isSamsungProblematicDevice() {
        if ("Samsung".equalsIgnoreCase(Build.BRAND) == true) goto L5;
    L7:
        return false;
    L5:
        if (SAMSUNG_DEVICES.contains(Build.DEVICE.toUpperCase(Locale.US)) == false) goto L7;
        return true;
    }

    public static boolean load() {
        return isSamsungProblematicDevice();
    }

    private boolean canParseSosMarker(byte[] r5) {
        int r1 = 2;
    L4:
        if ((r1 + 4) > r5.length) goto L14;
        byte r2 = r5[r1];
        if (r2 != (-1)) goto L21;
        if (r2 != (-1)) goto L13;
        if (r5[r1 + 1] != (-38)) goto L13;
        return true;
    L13:
        r1 = r1 + ((((r5[r1 + 2] & 255) << 8) | (r5[r1 + 3] & 255)) + 2);
        goto L4
    L21:
        return false;
    L14:
        return false;
    }

    private int findSecondFfd8Position(byte[] r5) {
        int r0 = 2;
    L3:
        int r1 = r0 + 1;
        if (r1 > r5.length) goto L5;
        if (r5[r0] != (-1)) goto L11;
        if (r5[r1] != (-40)) goto L11;
        return r0;
    L11:
        r0 = r1;
        goto L3
    L5:
        return -1;
    }

    public byte[] jpegImageToJpegByteArray(ImageProxy r4) {
        int r0 = 0;
        ByteBuffer r5 = r4.getPlanes()[0].getBuffer();
        byte[] r1 = new byte[r5.capacity()];
        r5.rewind();
        r5.get(r1);
        if (canParseSosMarker(r1) == true) goto L9;
        r0 = findSecondFfd8Position(r1);
        if (r0 != (-1)) goto L9;
        return r1;
    L9:
        return Arrays.copyOfRange(r1, r0, r5.limit());
    }
}
