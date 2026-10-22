package com.obric.memorydata.sdk.awareness;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0014J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002JO\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\u0010 \u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0010\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001c\u0010'\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J1\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0010\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!H\u0016¢\u0006\u0002\u0010,J;\u0010-\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0010\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010!H\u0016¢\u0006\u0002\u0010.¨\u00060"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/BaseAwarenessCallbackProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", com.alipay.sdk.m.p.e.f25671s, "", "arg", "extras", "validateAwarenessProviderCaller", "onFeatureEvent", "", "subscriptionId", "featureName", "oldValue", "", "newValue", "onContextEvent", "eventName", "dispatchCallback", "callback", "Lcom/obric/memorydata/sdk/awareness/PersistentAwarenessCallback;", "hasSameSignature", "packageName", "trustedPackage", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseAwarenessCallbackProvider extends ContentProvider {

    public static final class a {
    }

    static {
    }

    public abstract void c();

    public abstract void d();

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
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        tka.c.c("AwarenessCallbackProvider", "callback provider onCreate");
        return true;
    }

    public BaseAwarenessCallbackProvider() {
    }

    public final Bundle a(PersistentAwarenessCallback r100) {
        r100.f397099c.setClassLoader(getClass().getClassLoader());
        String r101 = r100.f397098b.f397089a;
        if (Intrinsics.areEqual(r101, "feature") == false) goto L9;
        Bundle r102 = r100.f397099c.getBundle("extras");
        if (r102 == null) goto L7;
        r102.setClassLoader(r102.getClass().getClassLoader());
        r102.keySet();
    L7:
        String r103 = r100.f397098b.f397090b;
        r100.f397099c.get("old_value");
        r100.f397099c.get("new_value");
        d();
        return l.a(0, "success");
    L9:
        if (Intrinsics.areEqual(r101, "event") == false) goto L14;
        Bundle r104 = r100.f397099c.getBundle("extras");
        if (r104 == null) goto L13;
        r104.setClassLoader(r104.getClass().getClassLoader());
        r104.keySet();
    L13:
        String r105 = r100.f397098b.f397090b;
        c();
        return l.a(0, "success");
    L14:
        tka.b r106 = tka.c.f546598a;
        tka.c.d("AwarenessCallbackProvider", "unknown callback targetType=" + r100.f397098b.f397089a);
        int r107 = l.f397131a;
        return l.a(405, "unknown targetType=" + r100.f397098b.f397089a);
    }

    public final boolean b(String r100, String r101) {
        Context r102 = getContext();
        boolean r103 = false;
        if (r102 != null) goto L17;
        return false;
    L17:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        if (r102.getPackageManager().checkSignatures(r100, r101) != 0) goto L8;
        r103 = true;
    L8:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L10
    L12:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L16;
        r105 = r106;
    L16:
        return ((Boolean) r105).booleanValue();
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r110, String r111, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, com.alipay.sdk.m.p.e.f25671s);
        tka.b r100 = tka.c.f546598a;
        tka.c.c("AwarenessCallbackProvider", "callback provider call method=" + r110);
        if (Intrinsics.areEqual(r110, "persistent_awareness_callback") == true) goto L6;
        tka.c.d("AwarenessCallbackProvider", "callback provider unknown method=" + r110);
        int r101 = l.f397131a;
        return l.a(405, "unknown method=" + r110);
    L6:
        Context r102 = getContext();
        boolean r103 = false;
        if (r102 == null) goto L29;
        int r104 = Binder.getCallingUid();
        String[] r105 = r102.getPackageManager().getPackagesForUid(r104);
        if (r105 != null) goto L12;
        r105 = new String[0];
    L12:
        String[] r106 = r105;
        int r107 = r106.length;
        int r108 = 0;
    L13:
        if (r108 >= r107) goto L28;
        String r112 = r106[r108];
        if (Intrinsics.areEqual(r112, r102.getPackageName()) == false) goto L17;
    L24:
        boolean r113 = true;
    L25:
        if (r113 == true) goto L26;
        r108 = r108 + 1;
        goto L13
    L26:
        r103 = true;
        goto L28
    L17:
        if (Intrinsics.areEqual(r112, "com.larus.nova") == true) goto L24;
        Intrinsics.checkNotNull(r112);
        if (b(r112, "com.larus.nova") == true) goto L24;
        if (b(r112, r102.getPackageName()) == true) goto L24;
        r113 = false;
    L28:
        tka.b r109 = tka.c.f546598a;
        tka.c.c("AwarenessCallbackProvider", "validate callback caller uid=" + r104 + " allowed=" + r103 + " packages=" + ArraysKt.joinToString$default(r106, null, null, null, 0, null, null, 63, null));
    L29:
        if (r103 == true) goto L32;
        tka.c.d("AwarenessCallbackProvider", "callback provider caller is not allowed");
        return l.a(402, "caller is not allowed");
    L32:
        int r114 = l.f397131a;
        PersistentAwarenessCallback r115 = null;
        Parcelable r116 = null;
        r116 = null;
        if (r210 == null) goto L43;
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter("callback", "key");
        Intrinsics.checkNotNullParameter(PersistentAwarenessCallback.class, "clazz");
        r210.setClassLoader(PersistentAwarenessCallback.class.getClassLoader());
        if (Build.VERSION.SDK_INT < 33) goto L39;
        Parcelable r117 = (Parcelable) r210.getParcelable("callback", PersistentAwarenessCallback.class);     // Catch: RuntimeException -> L56
    L38:
        r116 = r117;
        goto L42
    L39:
        r117 = r210.getParcelable("callback");     // Catch: RuntimeException -> L56
        if ((r117 instanceof Parcelable) == true) goto L38;
    L42:
        r115 = (PersistentAwarenessCallback) r116;
    L43:
        if (r115 != null) goto L57;
        tka.c.d("AwarenessCallbackProvider", "callback provider callback is missing");
        return l.a(405, "callback is missing");
    L57:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L48
        tka.b r119 = tka.c.f546598a;     // Catch: Throwable -> L48
        tka.c.c("AwarenessCallbackProvider", "dispatch callback subscriptionId=" + r115.f397097a + " target=" + r115.f397098b.f397089a + '/' + r115.f397098b.f397090b);     // Catch: Throwable -> L48
        Object r120 = Result.m9449constructorimpl(a(r115));     // Catch: Throwable -> L48
    L50:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L55;
        tka.c.b("AwarenessCallbackProvider", "callback provider dispatch failed", r121);
        int r122 = l.f397131a;
        r120 = l.a(400, r121.getMessage());
    L55:
        return (Bundle) r120;
    L48:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    }
}
