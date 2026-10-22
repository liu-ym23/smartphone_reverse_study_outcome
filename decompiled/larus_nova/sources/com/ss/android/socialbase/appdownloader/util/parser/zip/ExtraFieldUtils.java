package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public class ExtraFieldUtils {
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = null;

    public static final class UnparseableExtraField {
        public static final UnparseableExtraField READ = null;
        public static final int READ_KEY = 2;
        public static final UnparseableExtraField SKIP = null;
        public static final int SKIP_KEY = 1;
        public static final UnparseableExtraField THROW = null;
        public static final int THROW_KEY = 0;
        private final int key;

        static {
            THROW = new UnparseableExtraField(0);
            SKIP = new UnparseableExtraField(1);
            READ = new UnparseableExtraField(2);
        }

        public int getKey() {
            return this.key;
        }

        private UnparseableExtraField(int r100) {
            this.key = r100;
        }
    }

    public ExtraFieldUtils() {
    }

    static {
        implementations = new ConcurrentHashMap();
        register(AsiExtraField.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
    }

    public static ZipExtraField createExtraField(ZipShort r100) throws InstantiationException, IllegalAccessException {
        Class<?> r101 = implementations.get(r100);
        if (r101 != null) goto L15;
        UnrecognizedExtraField r102 = new UnrecognizedExtraField();
        r102.setHeaderId(r100);
        return r102;
    L15:
        return (ZipExtraField) r101.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L7:
        e = move-exception;
        throw ((InstantiationException) new InstantiationException().initCause(e));
    L10:
        e = move-exception;
        throw ((InstantiationException) new InstantiationException().initCause(e.getTargetException()));
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] r110) {
        if (r110.length > 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        int r101 = r110.length;
        if (r100 == false) goto L11;
        r101 = r101 - 1;
    L11:
        int r102 = r101 * 4;
        int r103 = r110.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L14;
        r102 = r102 + r110[r104].getCentralDirectoryLength().getValue();
        r104 = r104 + 1;
        goto L12
    L14:
        byte[] r105 = new byte[r102];
        int r106 = 0;
        int r107 = 0;
    L15:
        if (r106 >= r101) goto L17;
        System.arraycopy(r110[r106].getHeaderId().getBytes(), 0, r105, r107, 2);
        System.arraycopy(r110[r106].getCentralDirectoryLength().getBytes(), 0, r105, r107 + 2, 2);
        byte[] r108 = r110[r106].getCentralDirectoryData();
        System.arraycopy(r108, 0, r105, r107 + 4, r108.length);
        r107 = r107 + (r108.length + 4);
        r106 = r106 + 1;
        goto L15
    L17:
        if (r100 == false) goto L19;
        byte[] r111 = r110[r110.length - 1].getCentralDirectoryData();
        System.arraycopy(r111, 0, r105, r107, r111.length);
    L19:
        return r105;
    L5:
        if ((r110[r110.length - 1] instanceof UnparseableExtraFieldData) == false) goto L7;
        r100 = true;
        goto L8
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] r110) {
        if (r110.length > 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        int r101 = r110.length;
        if (r100 == false) goto L11;
        r101 = r101 - 1;
    L11:
        int r102 = r101 * 4;
        int r103 = r110.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L14;
        r102 = r102 + r110[r104].getLocalFileDataLength().getValue();
        r104 = r104 + 1;
        goto L12
    L14:
        byte[] r105 = new byte[r102];
        int r106 = 0;
        int r107 = 0;
    L15:
        if (r106 >= r101) goto L17;
        System.arraycopy(r110[r106].getHeaderId().getBytes(), 0, r105, r107, 2);
        System.arraycopy(r110[r106].getLocalFileDataLength().getBytes(), 0, r105, r107 + 2, 2);
        byte[] r108 = r110[r106].getLocalFileDataData();
        System.arraycopy(r108, 0, r105, r107 + 4, r108.length);
        r107 = r107 + (r108.length + 4);
        r106 = r106 + 1;
        goto L15
    L17:
        if (r100 == false) goto L19;
        byte[] r111 = r110[r110.length - 1].getLocalFileDataData();
        System.arraycopy(r111, 0, r105, r107, r111.length);
    L19:
        return r105;
    L5:
        if ((r110[r110.length - 1] instanceof UnparseableExtraFieldData) == false) goto L7;
        r100 = true;
        goto L8
    }

    public static ZipExtraField[] parse(byte[] r100) throws ZipException {
        return parse(r100, true, UnparseableExtraField.THROW);
    }

    public static void register(Class<?> r100) {
        implementations.put(((ZipExtraField) r100.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).getHeaderId(), r100);     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L8 IllegalAccessException -> L10 InstantiationException -> L12 ClassCastException -> L14
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(r100 + "'s no-arg constructor threw an exception:" + e.getMessage());
    L15:
        throw new RuntimeException(r100 + " doesn't implement ZipExtraField");
    L11:
        throw new RuntimeException(r100 + "'s no-arg constructor is not public");
    L13:
        throw new RuntimeException(r100 + " is not a concrete class");
    L9:
        throw new RuntimeException(r100 + "'s no-arg constructor not found");
    }

    public static ZipExtraField[] parse(byte[] r100, boolean r101) throws ZipException {
        return parse(r100, r101, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] r100, boolean r101, UnparseableExtraField r102) throws ZipException {
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L4:
        if (r104 > (r100.length - 4)) goto L37;
        ZipShort r105 = new ZipShort(r100, r104);
        int r106 = new ZipShort(r100, r104 + 2).getValue();
        int r107 = r104 + 4;
        if ((r107 + r106) > r100.length) goto L7;
        ZipExtraField r108 = createExtraField(r105);     // Catch: IllegalAccessException -> L31 Throwable -> L33
        if (r101 == false) goto L25;
    L28:
        r108.parseFromLocalFileData(r100, r107, r106);     // Catch: IllegalAccessException -> L31 Throwable -> L33
    L29:
        r103.add(r108);     // Catch: IllegalAccessException -> L31 Throwable -> L33
        r104 = r104 + (r106 + 4);
        goto L4
    L25:
        if ((r108 instanceof CentralDirectoryParsingZipExtraField) == false) goto L28;
        ((CentralDirectoryParsingZipExtraField) r108).parseFromCentralDirectoryData(r100, r107, r106);     // Catch: IllegalAccessException -> L31 Throwable -> L33
    L33:
        e = move-exception;
        throw new ZipException(e.getMessage());
    L7:
        int r109 = r102.getKey();
        if (r109 != 0) goto L10;
        StringBuilder r110 = new StringBuilder("bad extra field starting at ");
        r110.append(r104);
        r110.append(".  Block length of ");
        r110.append(r106);
        r110.append(" bytes exceeds remaining data of ");
        r110.append((r100.length - r104) - 4);
        r110.append(" bytes.");
        throw new ZipException(r110.toString());
    L10:
        if (r109 == 1) goto L37;
        if (r109 != 2) goto L19;
        UnparseableExtraFieldData r111 = new UnparseableExtraFieldData();
        if (r101 == false) goto L16;
        r111.parseFromLocalFileData(r100, r104, r100.length - r104);
    L17:
        r103.add(r111);
        goto L37
    L16:
        r111.parseFromCentralDirectoryData(r100, r104, r100.length - r104);
        goto L17
    L19:
        throw new ZipException("unknown UnparseableExtraField key: " + r102.getKey());
    L37:
        return (ZipExtraField[]) r103.toArray(new ZipExtraField[r103.size()]);
    }
}
