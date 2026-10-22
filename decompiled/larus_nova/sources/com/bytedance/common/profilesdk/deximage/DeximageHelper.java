package com.bytedance.common.profilesdk.deximage;

import com.bytedance.common.profilesdk.util.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import dalvik.system.DexFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes15.dex */
public class DeximageHelper {
    static Constructor<?> sDexFileConstructor;

    private static DexFile createDexFile(byte[] r100) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (sDexFileConstructor != null) goto L6;
        sDexFileConstructor = findConstructor(DexFile.class, ByteBuffer.class);
    L6:
        return (DexFile) sDexFileConstructor.newInstance(new Object[]{ByteBuffer.wrap(r100)});
    }

    private static List<DexFile> loadDexFileFromZip(String r100) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ArrayList r101 = new ArrayList();
        ZipInputStream r102 = new ZipInputStream(new PolarisFileInputStreamWrapper(r100));
        ZipEntry r103 = r102.getNextEntry();     // Catch: Throwable -> L22
        byte[] r104 = new byte[1024];     // Catch: Throwable -> L22
    L4:
        if (r103 == null) goto L20;
        if (r103.isDirectory() == true) goto L18;
        if (r103.getName().startsWith("classes") == false) goto L18;
        if (r103.getName().endsWith("dex") == false) goto L18;
        ByteArrayOutputStream r105 = new ByteArrayOutputStream(4096);     // Catch: Throwable -> L22
    L12:
        int r106 = r102.read(r104, 0, 1024);     // Catch: Throwable -> L22
        if (r106 <= 0) goto L15;
        r105.write(r104, 0, r106);     // Catch: Throwable -> L22
        goto L12
    L15:
        DexFile r107 = createDexFile(r105.toByteArray());     // Catch: Throwable -> L22
        if (r107 == null) goto L18;
        r101.add(r107);     // Catch: Throwable -> L22
    L18:
        r103 = r102.getNextEntry();     // Catch: Throwable -> L22
        goto L4
    L20:
        r102.close();
        return r101;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L27
    L29:
        throw th;
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    }

    public static List<DexFile> loadDexFileInMemory(String r100) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        if (FileUtils.isArchiveFile(new PolarisFileWrapper(r100)) == true) goto L5;
        ArrayList r101 = new ArrayList();
        r101.add(createDexFile(FileUtils.readAllBytes(new PolarisFileWrapper(r100))));
        return r101;
    L5:
        return loadDexFileFromZip(r100);
    }

    public static Constructor<?> findConstructor(Class<?> r100, Class<?> r101) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method r102 = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});
        r102.setAccessible(true);
        Constructor<?> r103 = (Constructor) r102.invoke(r100, new Object[]{new Class[]{r101}});
        if (r103 != null) goto L5;
    L7:
        return r103;
    L5:
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);
        goto L7
    }
}
