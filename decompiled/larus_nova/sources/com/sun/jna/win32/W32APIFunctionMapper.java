package com.sun.jna.win32;

import androidx.exifinterface.media.ExifInterface;
import com.sun.jna.FunctionMapper;
import com.sun.jna.NativeLibrary;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class W32APIFunctionMapper implements FunctionMapper {
    public static final FunctionMapper ASCII = null;
    public static final FunctionMapper UNICODE = null;
    private final String suffix;

    static {
        UNICODE = new W32APIFunctionMapper(true);
        ASCII = new W32APIFunctionMapper(false);
    }

    public W32APIFunctionMapper(boolean r100) {
        if (r100 == false) goto L5;
        String r101 = ExifInterface.LONGITUDE_WEST;
    L6:
        this.suffix = r101;
        return;
    L5:
        r101 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        goto L6
    }

    @Override // com.sun.jna.FunctionMapper
    public String getFunctionName(NativeLibrary r100, Method r101) {
        String r102 = r101.getName();
        if (r102.endsWith(ExifInterface.LONGITUDE_WEST) == false) goto L5;
        return r102;
    L5:
        if (r102.endsWith(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) == true) goto L12;
        return r100.getFunction(r102 + this.suffix, 63).getName();
    L13:
        return r102;
    L12:
        return r102;
    }
}
