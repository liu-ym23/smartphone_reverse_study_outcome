package com.obric.matrix.sdk.push.cross_process;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.p.e;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kka.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J3\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016JQ\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\n\u001a\u00020\t2\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/MessageProvider;", "Landroid/content/ContentProvider;", "Lcom/obric/matrix/sdk/push/a;", "", e.f25671s, "arg", "Landroid/os/Bundle;", "extras", NotificationCompat.CATEGORY_CALL, "Landroid/net/Uri;", "uri", "selection", "", "selectionArgs", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "Landroid/content/ContentValues;", "values", "insert", "projection", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "sdk_push_release"}, k = 1, mv = {1, 6, 0})
public abstract class MessageProvider extends ContentProvider implements com.obric.matrix.sdk.push.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f397028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f397029c;

    public final void c() {
        AtomicBoolean r100 = this.f397028b;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f397028b.get() == true) goto L7;
        d();     // Catch: Throwable -> L10
        this.f397028b.set(true);     // Catch: Throwable -> L10
    L7:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
    }

    public final void d() {
        long r100 = System.currentTimeMillis();
        this.f397029c.await();     // Catch: Throwable -> L9 InterruptedException -> L11
        if (getContext() == null) goto L8;
        b.a(this.f397027a, "wait for app init cost " + (System.currentTimeMillis() - r100) + " ms");
        return;
    L8:
        throw new IllegalArgumentException("context is null!".toString());     // Catch: Throwable -> L9 InterruptedException -> L11
    L11:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        b.a(this.f397027a, "wait for app init cost " + (System.currentTimeMillis() - r100) + " ms");
        throw th;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        b.a(this.f397027a, WidgetCostModule.TYPE_ON_CREATE);
        return true;
    }

    public MessageProvider() {
        this.f397027a = "MessageProvider";
        this.f397028b = new AtomicBoolean();
        this.f397029c = new CountDownLatch(1);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        c();
        return null;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r100, ProviderInfo r101) {
        String r102 = this.f397027a;
        int r103 = b.f503830a;
        Intrinsics.checkNotNullParameter(r102, "tag");
        Intrinsics.checkNotNullParameter("attachInfo", "msg");
        String r104 = b.c(r102, "attachInfo");
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", "tag");
        Intrinsics.checkNotNullParameter(r104, "msg");
        super.attachInfo(r100, r101);
        this.f397029c.countDown();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        c();
        return null;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        b.a(this.f397027a, "message provider call: " + r100 + ", " + r101 + ", " + r102);
        c();
        if (Intrinsics.areEqual(getCallingPackage(), "com.obric.matrix") == false) goto L20;
    L17:
        th = move-exception;
        b.b("message provider error: " + th);
        goto L20
    L5:
        if (Intrinsics.areEqual(r100, ".action.MESSAGE_EVENT") == false) goto L20;
        if (r102 == null) goto L20;
        Object r103 = r102.get("msg_id");     // Catch: Throwable -> L17
        if (r103 == null) goto L16;
        String r104 = (String) r103;     // Catch: Throwable -> L17
        Object r105 = r102.get("pass_though_data");     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        Intrinsics.checkNotNullParameter(r104, RemoteMessageConst.MSGID);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter((String) r105, "data");     // Catch: Throwable -> L17
        b();     // Catch: Throwable -> L17
        goto L20
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L17
    L20:
        return super.call(r100, r101, r102);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        c();
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        c();
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        c();
        return null;
    }
}
