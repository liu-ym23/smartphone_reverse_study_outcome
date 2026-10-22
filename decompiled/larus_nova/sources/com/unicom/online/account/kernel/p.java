package com.unicom.online.account.kernel;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f462067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f462068b = null;

    static {
        f462067a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        f462068b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static byte[] a(String r100) {
        if ((r100.length() % 2) != 0) goto L9;
        char[] r101 = r100.toCharArray();
        byte[] r102 = new byte[r100.length() / 2];
        int r103 = r100.length();
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r104 >= r103) goto L7;
        StringBuilder r106 = new StringBuilder();
        int r107 = r104 + 1;
        r106.append(r101[r104]);
        r106.append(r101[r107]);
        r102[r105] = Integer.valueOf(CastIntegerProtector.parseInt(r106.toString(), 16) & 255).byteValue();
        r104 = r107 + 1;
        r105 = r105 + 1;
        goto L5
    L7:
        return r102;
    L9:
        throw new IllegalArgumentException();
    }
}
