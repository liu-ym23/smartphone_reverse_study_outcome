package com.bytedance.bpea.entry.api.content.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.bpea.basics.BPEAException;

/* JADX INFO: loaded from: classes8.dex */
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver implements c, b, d, a {
    public final qc4.c getContext() {
        return null;
    }

    public static void a() {
        throw new BPEAException(-1, "contentResolver handler state illegal: can not be reused");
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.a
    public int delete(Bundle r100) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.b
    public Uri insert(ContentValues r100) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.a
    public int delete(String r100, String[] r101) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.b
    public Uri insert(ContentValues r100, Bundle r101) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.d
    public int update(ContentValues r100, Bundle r101) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.c
    public Cursor query(String[] r100, Bundle r101, CancellationSignal r102) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.d
    public int update(ContentValues r100, String r101, String[] r102) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.c
    public Cursor query(String[] r100, String r101, String[] r102, String r103) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.c
    public Cursor query(String[] r100, String r101, String[] r102, String r103, CancellationSignal r104) {
        a();
        throw null;
    }
}
