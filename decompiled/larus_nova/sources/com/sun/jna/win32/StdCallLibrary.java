package com.sun.jna.win32;

import com.sun.jna.Callback;
import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;

/* JADX INFO: loaded from: classes40.dex */
public interface StdCallLibrary extends Library, StdCall {
    public static final FunctionMapper FUNCTION_MAPPER = null;
    public static final int STDCALL_CONVENTION = 63;

    public interface StdCallCallback extends Callback, StdCall {
    }

    static {
        FUNCTION_MAPPER = new StdCallFunctionMapper();
    }
}
