package com.bytedance.ee.android.file.picker.lib.v2.util.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f206166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f206167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f206168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f206169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f206170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f206171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Token f206172g;

    /* JADX INFO: renamed from: com.bytedance.ee.android.file.picker.lib.v2.util.content.a$a, reason: collision with other inner class name */
    public static final class C2968a {
    }

    static {
    }

    @Override // com.bytedance.ee.android.file.picker.lib.v2.util.content.c
    public final Cursor run() {
        Log.i("ContentResolverQuery", "execute query uri:" + this.f206167b.getPath() + ", isForeground:" + b.a());
        return sf7.a.f541727a.query(this.f206166a, this.f206167b, this.f206168c, this.f206169d, this.f206170e, this.f206171f, this.f206172g);
    L5:
        e = move-exception;
        Log.e("ContentResolverQuery", e);
        return null;
    L14:
        e = move-exception;
        Log.e("ContentResolverQuery", e);
        throw e;
    L8:
        e = move-exception;
        Log.e("ContentResolverQuery", e);
        throw e;
    L11:
        e = move-exception;
        Log.e("ContentResolverQuery", e);
        throw e;
    }

    public a(ContentResolver r100, Uri r101, String[] r102, String r103, String[] r104, String r105, Token r106) {
        Intrinsics.checkNotNullParameter(r100, "contentResolver");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r106, "token");
        this.f206166a = r100;
        this.f206167b = r101;
        this.f206168c = r102;
        this.f206169d = r103;
        this.f206170e = r104;
        this.f206171f = r105;
        this.f206172g = r106;
    }
}
