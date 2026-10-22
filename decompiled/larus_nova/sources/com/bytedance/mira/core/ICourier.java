package com.bytedance.mira.core;

import android.os.Parcel;

/* JADX INFO: loaded from: classes21.dex */
public interface ICourier {
    public static final int FIRST_CALL_TRANSACTION = 1;
    public static final String METHOD_EXEC_TRANSACTION = "execTransact";

    void execTransact(int r100, Parcel r101, Parcel r102);
}
