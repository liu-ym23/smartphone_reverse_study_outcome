package com.bytedance.vmsdk.jsbridge;

import androidx.collection.ArrayMap;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayMap<Class, Character> f272497a;

    public static char a(Class r100) {
        if (f272497a != null) goto L6;
        ArrayMap<Class, Character> r101 = new ArrayMap();
        f272497a = r101;
        r101.put(Byte.TYPE, Character.valueOf(BlockDevice.UNIX_ID));
        f272497a.put(Byte.class, 'B');
        f272497a.put(Short.TYPE, 's');
        f272497a.put(Short.class, 'S');
        f272497a.put(Long.TYPE, Character.valueOf(Symlink.UNIX_ID));
        f272497a.put(Long.class, Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_LT));
        f272497a.put(Character.TYPE, Character.valueOf(CharacterDevice.UNIX_ID));
        f272497a.put(Character.class, 'C');
        f272497a.put(Boolean.TYPE, 'z');
        f272497a.put(Boolean.class, Character.valueOf(Matrix.MATRIX_TYPE_ZERO));
        f272497a.put(Integer.TYPE, 'i');
        f272497a.put(Integer.class, 'I');
        f272497a.put(Double.TYPE, Character.valueOf(Directory.UNIX_ID));
        f272497a.put(Double.class, 'D');
        f272497a.put(Float.TYPE, 'f');
        f272497a.put(Float.class, 'F');
        f272497a.put(String.class, Character.valueOf(OthersPermission.STICKY));
    L6:
        if (f272497a.containsKey(r100) == true) goto L8;
        return 0;
    L8:
        return f272497a.get(r100).charValue();
    }
}
