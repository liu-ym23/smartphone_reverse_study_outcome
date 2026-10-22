package com.bytedance.keva.ext.fast;

import android.database.MatrixCursor;
import android.os.Bundle;

/* JADX INFO: loaded from: classes19.dex */
public class KevaBinderCursor extends MatrixCursor {
    final Bundle mBundle;

    @Override // android.database.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        return this.mBundle;
    }

    public KevaBinderCursor(String r100, StubParcelable r101) {
        super(new String[]{"service"});
        Bundle r102 = new Bundle();
        this.mBundle = r102;
        r102.putParcelable(r100, r101);
    }
}
