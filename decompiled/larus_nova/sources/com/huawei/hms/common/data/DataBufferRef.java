package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class DataBufferRef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f277057a;
    protected final DataHolder mDataHolder;
    protected int mDataRow;

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.mDataRow), Integer.valueOf(this.f277057a), this.mDataHolder});
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    public int getDataRow() {
        return this.mDataRow;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DataBufferRef) == false) goto L12;
        DataBufferRef r101 = (DataBufferRef) r100;
        if (r101.mDataRow == this.mDataRow) goto L7;
        return false;
    L7:
        if (r101.f277057a == this.f277057a) goto L9;
        return false;
    L9:
        if (r101.mDataHolder != this.mDataHolder) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public boolean getBoolean(String r100) {
        Object r101 = this.mDataHolder.getValue(r100, this.mDataRow, this.f277057a, DataHolder.TYPE_BOOLEAN);
        if (r101 != null) goto L5;
        return false;
    L5:
        return ((Boolean) r101).booleanValue();
    }

    public byte[] getByteArray(String r100) {
        Object r101 = this.mDataHolder.getValue(r100, this.mDataRow, this.f277057a, DataHolder.TYPE_BYTE_ARRAY);
        if (r101 != null) goto L5;
        return null;
    L5:
        return (byte[]) r101;
    }

    public double getDouble(String r100) {
        Object r101 = this.mDataHolder.getValue(r100, this.mDataRow, this.f277057a, DataHolder.TYPE_DOUBLE);
        if (r101 != null) goto L5;
        return -1.0d;
    L5:
        return ((Double) r101).doubleValue();
    }

    public float getFloat(String r100) {
        Object r101 = this.mDataHolder.getValue(r100, this.mDataRow, this.f277057a, DataHolder.TYPE_FLOAT);
        if (r101 != null) goto L5;
        return -1.0f;
    L5:
        return ((Float) r101).floatValue();
    }

    public int getInteger(String r100) {
        Object r101 = this.mDataHolder.getValue(r100, this.mDataRow, this.f277057a, DataHolder.TYPE_INT);
        if (r101 != null) goto L5;
        return -1;
    L5:
        return ((Integer) r101).intValue();
    }

    public long getLong(String r100) {
        Object r101 = this.mDataHolder.getValue(r100, this.mDataRow, this.f277057a, DataHolder.TYPE_LONG);
        if (r101 != null) goto L5;
        return -1;
    L5:
        return ((Long) r101).longValue();
    }

    public String getString(String r100) {
        Object r101 = this.mDataHolder.getValue(r100, this.mDataRow, this.f277057a, DataHolder.TYPE_STRING);
        if (r101 != null) goto L5;
        return "";
    L5:
        return (String) r101;
    }

    public final void getWindowIndex(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r101 = false;
    L7:
        Preconditions.checkArgument(r101, "rowNum is out of index");
        this.mDataRow = r100;
        this.f277057a = this.mDataHolder.getWindowIndex(r100);
        return;
    L4:
        if (r100 >= this.mDataHolder.getCount()) goto L6;
        r101 = true;
        goto L7
    }

    public boolean hasColumn(String r100) {
        return this.mDataHolder.hasColumn(r100);
    }

    public boolean hasNull(String r100) {
        return this.mDataHolder.hasNull(r100, this.mDataRow, this.f277057a);
    }

    public Uri parseUri(String r100) {
        String r101 = (String) this.mDataHolder.getValue(r100, this.mDataRow, this.f277057a, DataHolder.TYPE_STRING);
        if (r101 != null) goto L7;
        return null;
    L7:
        return UriProtector.parse(r101);
    }

    public DataBufferRef(DataHolder r100, int r101) {
        Preconditions.checkNotNull(r100, "dataHolder cannot be null");
        this.mDataHolder = r100;
        getWindowIndex(r101);
    }

    public void copyToBuffer(String r100, CharArrayBuffer r101) {
        this.mDataHolder.copyToBuffer(r100, this.mDataRow, this.f277057a, r101);
    }
}
