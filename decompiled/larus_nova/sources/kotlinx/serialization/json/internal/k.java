package kotlinx.serialization.json.internal;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f505431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f505432b = null;

    public k() {
    }

    static {
        f505431a = new char[117];
        f505432b = new byte[126];
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= 32) goto L6;
        a(r101, 'u');
        r101 = r101 + 1;
        goto L4
    L6:
        a(8, BlockDevice.UNIX_ID);
        a(9, OthersPermission.STICKY_E);
        a(10, 'n');
        a(12, 'f');
        a(13, Permission.READ);
        a(47, '/');
        a(34, Typography.quote);
        a(92, '\\');
    L8:
        if (r100 >= 33) goto L10;
        f505432b[r100] = ByteCompanionObject.MAX_VALUE;
        r100 = r100 + 1;
        goto L8
    L10:
        byte[] r102 = f505432b;
        r102[9] = 3;
        r102[10] = 3;
        r102[13] = 3;
        r102[32] = 3;
        r102[44] = 4;
        r102[58] = 5;
        r102[123(0x7b, float:1.72E-43)] = 6;
        r102[125(0x7d, float:1.75E-43)] = 7;
        r102[91] = 8;
        r102[93] = 9;
        r102[34] = 1;
        r102[92] = 2;
    }

    public static void a(int r100, char r101) {
        if (r101 == 'u') goto L6;
        f505431a[r101] = (char) r100;
        return;
    }
}
