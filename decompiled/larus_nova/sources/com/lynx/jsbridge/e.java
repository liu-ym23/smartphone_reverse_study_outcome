package com.lynx.jsbridge;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Class<?>> f381357d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Class<?>> f381358e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class[] f381359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f381360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f381361c;

    static {
        f381357d = b(JavaOnlyMap.class);
        f381358e = b(JavaOnlyArray.class);
    }

    public e(Method r100) {
        this.f381360b = false;
        r100.setAccessible(true);
        this.f381359a = r100.getParameterTypes();
    }

    public static char a(Class r100) {
        if (r100.equals(Byte.TYPE) == false) goto L7;
        return BlockDevice.UNIX_ID;
    L7:
        if (r100.equals(Byte.class) == false) goto L11;
        return 'B';
    L11:
        if (r100.equals(Short.TYPE) == false) goto L15;
        return 's';
    L15:
        if (r100.equals(Short.class) == false) goto L19;
        return 'S';
    L19:
        if (r100.equals(Long.TYPE) == false) goto L23;
        return Symlink.UNIX_ID;
    L23:
        if (r100.equals(Long.class) == false) goto L27;
        return Matrix.MATRIX_TYPE_RANDOM_LT;
    L27:
        if (r100.equals(Character.TYPE) == false) goto L31;
        return CharacterDevice.UNIX_ID;
    L31:
        if (r100.equals(Character.class) == false) goto L35;
        return 'C';
    L35:
        if (r100.equals(Boolean.TYPE) == false) goto L39;
        return 'z';
    L39:
        if (r100.equals(Boolean.class) == false) goto L43;
        return Matrix.MATRIX_TYPE_ZERO;
    L43:
        if (r100.equals(Integer.TYPE) == false) goto L47;
        return 'i';
    L47:
        if (r100.equals(Integer.class) == false) goto L51;
        return 'I';
    L51:
        if (r100.equals(Double.TYPE) == false) goto L55;
        return Directory.UNIX_ID;
    L55:
        if (r100.equals(Double.class) == false) goto L59;
        return 'D';
    L59:
        if (r100.equals(Float.TYPE) == false) goto L63;
        return 'f';
    L63:
        if (r100.equals(Float.class) == false) goto L67;
        return 'F';
    L67:
        if (r100.equals(String.class) == false) goto L70;
        return OthersPermission.STICKY;
    L70:
        return 0;
    }

    public static Set<Class<?>> b(Class<?> r100) {
        HashSet r101 = new HashSet();
        r101.add(r100);
        Class<? super Object> r102 = r100.getSuperclass();
        if (r102 == null) goto L5;
        r101.add(r102);
    L5:
        Class<?>[] r103 = r100.getInterfaces();
        if (r103.length <= 0) goto L8;
        r101.addAll(Arrays.asList(r103));
    L8:
        return r101;
    }
}
