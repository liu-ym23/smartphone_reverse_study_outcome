package com.bytedance.mira.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes21.dex */
public class Courier extends ContentProvider implements ICourier {
    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    public void onTransact(int r100, Parcel r101, Parcel r102) throws Exception {
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    public Courier() {
    }

    public static Bundle readFromParcel(Parcel r100) {
        if (r100 == null) goto L4;
        Bundle r101 = new Bundle();
        r100.setDataPosition(0);
        Parcel r102 = Parcel.obtain();
        int r103 = r100.dataSize();
        r102.writeInt(r103);
        r102.writeInt(1279544898);
        r102.appendFrom(r100, 0, r103);
        r102.setDataPosition(0);
        r101.readFromParcel(r102);
        r100.recycle();
        return r101;
    L4:
        return Bundle.EMPTY;
    }

    public static Parcel writeToParcel(Bundle r100) {
        if (r100 == null) goto L4;
        Parcel r101 = Parcel.obtain();
        r100.writeToParcel(r101, 0);
        r101.setDataPosition(0);
        r101.readInt();
        r101.readInt();
        int r102 = r101.dataPosition();
        int r103 = r101.dataSize() - r102;
        Parcel r104 = Parcel.obtain();
        r104.appendFrom(r101, r102, r103);
        r104.setDataPosition(0);
        r101.recycle();
        return r104;
    L4:
        return Parcel.obtain();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (ICourier.METHOD_EXEC_TRANSACTION.equals(r100) == false) goto L10;
        Parcel r103 = writeToParcel(r102);
        Parcel r104 = Parcel.obtain();
        execTransact(r103.readInt(), r103, r104);
        return readFromParcel(r104);
    L10:
        return Bundle.EMPTY;
    }

    @Override // com.bytedance.mira.core.ICourier
    public void execTransact(int r100, Parcel r101, Parcel r102) {
        onTransact(r100, r101, r102);     // Catch: Exception -> L4
    L6:
        r101.recycle();
        return;
    L4:
        e = move-exception;
        r102.setDataPosition(0);
        r102.writeException(e);
        goto L6
    }
}
