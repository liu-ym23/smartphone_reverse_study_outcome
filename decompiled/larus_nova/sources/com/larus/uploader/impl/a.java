package com.larus.uploader.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bduploader.BDMediaDataReader;
import java.io.BufferedInputStream;
import java.io.InputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements BDMediaDataReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f375304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f375305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f375306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStream f375307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BufferedInputStream f375308e;

    /* JADX INFO: renamed from: com.larus.uploader.impl.a$a, reason: collision with other inner class name */
    public static final class C4518a {
    }

    static {
    }

    public final Context getContext() {
        return this.f375304a;
    }

    @Override // com.ss.bduploader.BDMediaDataReader
    public final int close(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        BufferedInputStream r102 = this.f375308e;     // Catch: Throwable -> L8
        if (r102 == null) goto L5;
        r102.close();     // Catch: Throwable -> L8
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
        return 0;
    L5:
        r103 = null;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return 0;
    }

    @Override // com.ss.bduploader.BDMediaDataReader
    public final int open(int r110) {
        Context r100 = this.f375304a;
        InputStream r101 = null;
        if (r100 == null) goto L18;
        Uri r102 = UriProtector.parse(this.f375305b);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "uri");
        ContentResolver r103 = r100.getContentResolver();
        f06.c r104 = new f06.c();
        Object[] r111 = {r102, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r105 = r104.b(240004, "android/content/ContentResolver", "query", r103, r111, "android.database.Cursor", r112);
        if (r105.f474982a == false) goto L7;
        r104.a(240004, "android/content/ContentResolver", "query", r103, r111, null, r112, false);
        Cursor r106 = (Cursor) r105.f474983b;
    L8:
        if (r106 == null) goto L18;
        Cursor r107 = r106;
        Cursor r108 = r107;     // Catch: Throwable -> L12
        int r109 = r108.getColumnIndex("_size");     // Catch: Throwable -> L12
        r108.moveToFirst();     // Catch: Throwable -> L12
        long r113 = r108.getLong(r109);     // Catch: Throwable -> L12
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r107, null);
    L19:
        this.f375306c = r113;
        Context r115 = this.f375304a;
        if (r115 == null) goto L24;
        ContentResolver r116 = r115.getContentResolver();
        if (r116 == null) goto L24;
        r101 = ContentResolverWrapper.openInputStream(r116, UriProtector.parse(this.f375305b));
    L24:
        this.f375307d = r101;
        if (r101 != null) goto L33;
        return -1;
    L33:
        return 1;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r107, th);
        throw th;
    L7:
        Cursor r117 = r103.query(r102, null, null, null, null);
        r104.a(240004, "android/content/ContentResolver", "query", r103, r111, r117, r112, true);
        r106 = r117;
    L18:
        r113 = 0;
        goto L19
    }

    public a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "fileUri");
        this.f375304a = r100;
        this.f375305b = r101;
    }

    @Override // com.ss.bduploader.BDMediaDataReader
    public final long getValue(int r100, int r101) {
        if (r101 == 0) goto L4;
        return 0;
    L4:
        return this.f375306c;
    }

    @Override // com.ss.bduploader.BDMediaDataReader
    public final int read(int r100, long r101, byte[] r102, int r103) {
        if (this.f375307d != null) goto L7;
        return -1;
    L7:
        if (r101 <= this.f375306c) goto L10;
        return 0;
    L10:
        BufferedInputStream r104 = new BufferedInputStream(this.f375307d);
        this.f375308e = r104;
        return r104.read(r102);
    }
}
