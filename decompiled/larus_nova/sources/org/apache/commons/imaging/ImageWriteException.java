package org.apache.commons.imaging;

/* JADX INFO: loaded from: classes42.dex */
public class ImageWriteException extends ImagingException {
    private static final long serialVersionUID = -1;

    public ImageWriteException(String r100) {
        super(r100);
    }

    private static String getType(Object r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        if ((r100 instanceof Object[]) == false) goto L10;
        return "[Object[]: " + ((Object[]) r100).length + "]";
    L10:
        if ((r100 instanceof char[]) == false) goto L14;
        return "[char[]: " + ((char[]) r100).length + "]";
    L14:
        if ((r100 instanceof byte[]) == false) goto L18;
        return "[byte[]: " + ((byte[]) r100).length + "]";
    L18:
        if ((r100 instanceof short[]) == false) goto L22;
        return "[short[]: " + ((short[]) r100).length + "]";
    L22:
        if ((r100 instanceof int[]) == false) goto L26;
        return "[int[]: " + ((int[]) r100).length + "]";
    L26:
        if ((r100 instanceof long[]) == false) goto L30;
        return "[long[]: " + ((long[]) r100).length + "]";
    L30:
        if ((r100 instanceof float[]) == false) goto L34;
        return "[float[]: " + ((float[]) r100).length + "]";
    L34:
        if ((r100 instanceof double[]) == false) goto L38;
        return "[double[]: " + ((double[]) r100).length + "]";
    L38:
        if ((r100 instanceof boolean[]) == false) goto L42;
        return "[boolean[]: " + ((boolean[]) r100).length + "]";
    L42:
        return r100.getClass().getName();
    }

    public ImageWriteException(String r100, Object r101) {
        super(r100 + ": " + r101 + " (" + getType(r101) + ")");
    }

    public ImageWriteException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
