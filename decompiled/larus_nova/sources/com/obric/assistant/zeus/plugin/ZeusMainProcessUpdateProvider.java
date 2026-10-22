package com.obric.assistant.zeus.plugin;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\tH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0002JO\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J1\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010%J;\u0010&\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/assistant/zeus/plugin/ZeusMainProcessUpdateProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "mainHandler", "Landroid/os/Handler;", "pendingFetchReason", "", "fetchScheduled", "", "triggerFetchRunnable", "Ljava/lang/Runnable;", WidgetCostModule.TYPE_ON_CREATE, NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", com.alipay.sdk.m.p.e.f25671s, "arg", "extras", "schedulePluginFetch", "", "reason", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZeusMainProcessUpdateProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f395013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f395014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f395015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f395016d;

    public static final class a {
    }

    static {
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.zeus.plugin.l] */
    public ZeusMainProcessUpdateProvider() {
        this.f395013a = new Handler(Looper.getMainLooper());
        this.f395014b = "";
        this.f395016d = new l(this);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        if (Intrinsics.areEqual(r100, "request_fetch_plugin") == false) goto L20;
        if (r102 == null) goto L6;
        final String r103 = r102.getString("reason");
    L7:
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r104 = ISecPrivacyService.a.a();
        if (r104 != null) goto L12;
    L14:
        boolean r105 = false;
    L16:
        if (r105 == true) goto L18;
        FLogger.f375446a.i("ZeusMainProcessUpdateProvider", "request fetch plugin skipped: privacy not agreed, reason=".concat(r103));
        Bundle r106 = new Bundle();
        r106.putBoolean("result", false);
        return r106;
    L18:
        FLogger.f375446a.i("ZeusMainProcessUpdateProvider", "request fetch plugin from sub process, reason=".concat(r103));
        this.f395013a.post(new k(this, r103));
        Bundle r107 = new Bundle();
        r107.putBoolean("result", true);
        return r107;
    L12:
        if (r104.h() != true) goto L14;
        r105 = true;
        goto L16
    L6:
        r103 = null;
        goto L7
    L20:
        return super.call(r100, r101, r102);
    }
}
