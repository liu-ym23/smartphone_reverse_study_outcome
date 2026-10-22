package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

/* JADX INFO: loaded from: classes23.dex */
public class HMSCursorWrapper extends CursorWrapper implements CrossProcessCursor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractWindowedCursor f277129a;

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.f277129a.getWindow();
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.f277129a;
    }

    public HMSCursorWrapper(Cursor r100) {
        super(r100);
        if (r100 == null) goto L19;
        if ((r100 instanceof CursorWrapper) == false) goto L17;
        Cursor r101 = ((CursorWrapper) r100).getWrappedCursor();
        if (r101 == null) goto L15;
        if ((r101 instanceof AbstractWindowedCursor) == false) goto L13;
        this.f277129a = (AbstractWindowedCursor) r101;
        return;
    L13:
        throw new IllegalArgumentException("getWrappedCursor:" + r101 + " is not a subclass for CursorWrapper");
    L15:
        throw new IllegalArgumentException("getWrappedCursor cannot be null");
    L17:
        throw new IllegalArgumentException("cursor:" + r100 + " is not a subclass for CursorWrapper");
    L19:
        throw new IllegalArgumentException("cursor cannot be null");
    }

    public void setWindow(CursorWindow r100) {
        this.f277129a.setWindow(r100);
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int r100, CursorWindow r101) {
        this.f277129a.fillWindow(r100, r101);
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int r100, int r101) {
        return this.f277129a.onMove(r100, r101);
    }
}
