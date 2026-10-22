package com.obric.assistant.privacy;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JO\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J1\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0017J;\u0010\u0018\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0003¨\u0006 "}, d2 = {"Lcom/obric/assistant/privacy/ObricPrivacyProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "getSHA256", "data", "", "getAppSignatureMD5", "packageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f391064a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f391065b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Set<String>> f391066c = null;

    public static final class a {
        public static void a(Context r100) {
            if (r100 != null) goto L9;
            return;
        L9:
            r100.getContentResolver().notifyChange(ObricPrivacyProvider.f391064a, null);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            FLogger.f375446a.w("ObricPrivacyProvider", "notifyStatusChange, errgor: " + e.getMessage());
        }
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
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return 0;
    }

    static {
        f391064a = UriProtector.parse("content://com.larus.nova.privacy.provider/status");
        f391065b = "com.obric.assistant.privacy.PERMISSION_ACCESS_PRIVACY_PROVIDER";
        f391066c = MapsKt.mapOf(new Pair[]{TuplesKt.to("com.obric.assistantaiagent", SetsKt.setOf(new String[]{"c8a2e9bccf597c2fb6dc66bee293fc13f2fc47ec77bc6b2b0d52c11f51192ab8", "b5557731885a53f4306abe67067ea07076200946dbf172770e930744b6bfcd68", "144258ce6dce3a5375d7b2077d8727bee863c8f6b9172c2e016ac73ca6f07095"})), TuplesKt.to("com.larus.nova", SetsKt.setOf("ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a"))});
    }

    public ObricPrivacyProvider() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [boolean, int] */
    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (f391064a.equals(r100) == true) goto L6;
        FLogger.f375446a.w("ObricPrivacyProvider", "query unknown URI: " + r100);
        return null;
    L6:
        Context r105 = getContext();
        if (r105 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == false) goto L19;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r107 = ISecPrivacyService.a.a();
        if (r107 == null) goto L16;
        ?? r108 = r107.h();
    L17:
        FLogger.f375446a.w("ObricPrivacyProvider", "query privacy hasAgreed: " + r108);
        MatrixCursor r109 = new MatrixCursor(new String[]{"value"}, 1);
        r109.addRow(new Object[]{Integer.valueOf(r108)});
        return r109;
    L16:
        r108 = 0;
        goto L17
    L19:
        FLogger.f375446a.e("ObricPrivacyProvider", "调用方无权限，拒绝访问");
        throw new SecurityException("无访问权限：需要 " + f391065b);
    L9:
        if (r105.checkCallingOrSelfPermission(f391065b) != 0) goto L11;
        r106 = true;
        goto L12
    }
}
