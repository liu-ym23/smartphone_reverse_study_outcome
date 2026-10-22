package com.obric.feedback.sdk;

import aka.b;
import aka.c;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.p.e;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJQ\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u001e"}, d2 = {"Lcom/obric/feedback/sdk/FeedbackSdkProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", e.f25671s, "arg", "Landroid/os/Bundle;", "extras", NotificationCompat.CATEGORY_CALL, "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "feedbacksdk_release"}, k = 1, mv = {1, 8, 0})
public final class FeedbackSdkProvider extends ContentProvider {

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

    public FeedbackSdkProvider() {
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        String r103 = getCallingPackage();
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        if (Intrinsics.areEqual(r103, "com.obric.feedback") == true) goto L13;
        c r104 = aka.a.f4099c;
        if (r104 == null) goto L10;
        r104.e("FeedbackSdkProvider", "call ERROR, " + r103 + " not in white list, extras: " + r102);
    L10:
        Bundle r105 = new Bundle();
        r105.putBoolean("success", false);
        r105.putString("error_msg", r103.concat(" not in white list"));
        return r105;
    L13:
        if (Intrinsics.areEqual(r100, "get_app_info") == false) goto L26;
        Bundle r106 = new Bundle();
        b r107 = aka.a.f4098b;
        if (r107 == null) goto L17;
        r107.getDid();
    L17:
        String r108 = null;
        r106.putString("device_id", null);
        b r109 = aka.a.f4098b;
        if (r109 == null) goto L20;
        r108 = r109.getUid();
    L20:
        r106.putString("user_id", r108);
        b r110 = aka.a.f4098b;
        if (r110 == null) goto L23;
        r110.a();
        long r111 = 86400;
    L24:
        r106.putLong("trace_time_window", r111);
        return r106;
    L23:
        r111 = 0;
        goto L24
    L26:
        return super.call(r100, r101, r102);
    }
}
