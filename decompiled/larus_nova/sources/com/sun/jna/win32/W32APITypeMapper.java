package com.sun.jna.win32;

import com.sun.jna.DefaultTypeMapper;
import com.sun.jna.TypeConverter;
import com.sun.jna.TypeMapper;

/* JADX INFO: loaded from: classes40.dex */
public class W32APITypeMapper extends DefaultTypeMapper {
    public static final TypeMapper ASCII = null;
    public static final TypeMapper DEFAULT = null;
    public static final TypeMapper UNICODE = null;

    static {
        W32APITypeMapper r100 = new W32APITypeMapper(true);
        UNICODE = r100;
        W32APITypeMapper r101 = new W32APITypeMapper(false);
        ASCII = r101;
        if (Boolean.getBoolean("w32.ascii") == false) goto L5;
        r100 = r101;
    L5:
        DEFAULT = r100;
    }

    public W32APITypeMapper(boolean r100) {
        if (r100 == false) goto L5;
        TypeConverter r101 = new AnonymousClass1(this);
        addTypeConverter(String.class, r101);
        addToNativeConverter(String[].class, r101);
    L5:
        addTypeConverter(Boolean.class, new AnonymousClass2(this));
    }
}
