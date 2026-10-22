package com.sun.jna.win32;

import com.sun.jna.FunctionMapper;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class StdCallFunctionMapper implements FunctionMapper {
    public StdCallFunctionMapper() {
    }

    public int getArgumentNativeStackSize(Class<?> r100) {
        if (NativeMapped.class.isAssignableFrom(r100) == false) goto L6;
        r100 = NativeMappedConverter.getInstance(r100).nativeType();
    L6:
        if (r100.isArray() == true) goto L8;
        return Native.getNativeSize(r100);
    L12:
        throw new IllegalArgumentException("Unknown native stack allocation size for " + r100);
    L8:
        return Native.POINTER_SIZE;
    }

    @Override // com.sun.jna.FunctionMapper
    public String getFunctionName(NativeLibrary r100, Method r101) {
        String r102 = r101.getName();
        Class<?>[] r103 = r101.getParameterTypes();
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r106 = r106 + getArgumentNativeStackSize(r103[r105]);
        r105 = r105 + 1;
        goto L3
    L5:
        String r107 = r102 + "@" + r106;
        return r100.getFunction(r107, 63).getName();
    L8:
        return r100.getFunction("_" + r107, 63).getName();
    L16:
        return r102;
    }
}
