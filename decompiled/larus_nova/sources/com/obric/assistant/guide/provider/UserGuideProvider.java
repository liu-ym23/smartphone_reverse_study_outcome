package com.obric.assistant.guide.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.p.e;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JO\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J1\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0017J;\u0010\u0018\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016¨\u0006 "}, d2 = {"Lcom/obric/assistant/guide/provider/UserGuideProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", e.f25671s, "arg", "extras", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserGuideProvider extends ContentProvider {

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
        FLogger r100 = FLogger.f375446a;
        r100.i("UserGuideProvider", WidgetCostModule.TYPE_ON_CREATE);
        Context r101 = getContext();
        if (r101 == null) goto L9;
        Uri r102 = UriProtector.parse("content://com.obric.assistant.guide.provider.UserGuideProvider");
        r101.grantUriPermission("com.android.systemui", r102, 1);     // Catch: Throwable -> L7
        r100.i("UserGuideProvider", "grantUriPermission to com.android.systemui for " + r102);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        FLogger.f375446a.w("UserGuideProvider", "grantUriPermission failed: " + th.getMessage());
    L9:
        return true;
    }

    public UserGuideProvider() {
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        if (Intrinsics.areEqual(r100, "is_doubao_login") == false) goto L13;
        ILoginService r103 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        boolean r104 = false;
        if (r103 == null) goto L11;
        q38.a r105 = r103.getAccountInfo();
        if (r105 == null) goto L11;
        if (r105.f531528a != true) goto L11;
        r104 = true;
    L11:
        FLogger.f375446a.i("UserGuideProvider", "isLogin=" + r104);
        Bundle r106 = new Bundle();
        r106.putBoolean("is_doubao_login", r104);
        return r106;
    L13:
        return null;
    }
}
