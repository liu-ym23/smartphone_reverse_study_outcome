package com.bytedance.bpea.entry.api.content.provider;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes8.dex */
public interface c {
    Cursor query(String[] r100, Bundle r101, CancellationSignal r102);

    Cursor query(String[] r100, String r101, String[] r102, String r103);

    Cursor query(String[] r100, String r101, String[] r102, String r103, CancellationSignal r104);
}
