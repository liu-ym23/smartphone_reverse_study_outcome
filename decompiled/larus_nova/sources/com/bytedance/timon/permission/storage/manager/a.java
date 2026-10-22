package com.bytedance.timon.permission.storage.manager;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.bytedance.timon.permission.storage.TimonMedia;
import com.bytedance.timon.permission.storage.constant.ResultCode;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import yg7.e;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements xg7.a<Cursor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f270662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TimonMedia.ExtraInfo f270663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TimonMediaInternal.a<List<Uri>> f270664c;

    public a(int r100, TimonMedia.ExtraInfo r101, TimonMediaInternal.a<List<Uri>> r102) {
        this.f270662a = r100;
        this.f270663b = r101;
        this.f270664c = r102;
    }

    @Override // xg7.a
    public final void a(int r100, Cursor r101, String r102) {
        Cursor r103 = r101;
        if (r100 != ResultCode.RESULT_OK.getValue()) goto L20;
        int r104 = e.f567511a;
        int r105 = this.f270662a;
        ArrayList r106 = new ArrayList();
        if (r103 == null) goto L19;
        Cursor r107 = r103;
        Cursor r108 = r107;     // Catch: Throwable -> L14
        int r109 = 0;
    L8:
        if (r109 >= r105) goto L12;
        if (r108.moveToNext() == false) goto L12;
        long r110 = r108.getLong(r108.getColumnIndexOrThrow(DBDefinition.ID));     // Catch: Throwable -> L14
        r106.add(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r110));     // Catch: Throwable -> L14
        r109 = r109 + 1;     // Catch: Throwable -> L14
    L12:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r107, null);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r107, th);
        throw th;
    L19:
        this.f270663b.f270649k.put("result_count", String.valueOf(r106.size()));
        xg7.a.C8237a.a(this.f270664c, ResultCode.RESULT_OK.getValue(), r106);
        return;
    L20:
        this.f270664c.a(ResultCode.Unknown.getValue(), null, r102);
    }
}
