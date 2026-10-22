package com.obric.matrix.platform.sdk.ones.ws;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.alipay.sdk.m.p.e;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import gka.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJQ\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J3\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J=\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "", "", "projection", "Landroid/os/Bundle;", "queryArgs", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class WsMsgProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UriMatcher f397012a;

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
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        bka.a r100 = bka.a.f19387a;
        UriMatcher r101 = this.f397012a;
        StringBuilder r102 = new StringBuilder("com.obric.matrix.platform.sdk.ones.provider.");
        Context r103 = getContext();
        if (r103 == null) goto L5;
        String r104 = r103.getPackageName();
    L6:
        r102.append(r104);
        r101.addURI(r102.toString(), "ws_msg", 1);
        return true;
    L5:
        r104 = null;
        goto L6
    }

    public WsMsgProvider() {
        this.f397012a = new UriMatcher(-1);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r110, String[] r111, Bundle r112, CancellationSignal r113) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        Objects.toString(r112);
        Objects.toString(r110);
        Objects.toString(r113);
        getCallingPackage();
        bka.a r114 = bka.a.f19387a;
        String r115 = getCallingPackage();
        if (r115 != null) goto L5;
    L8:
        boolean r116 = true;
    L9:
        byte[] r100 = null;
        if (r116 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(getCallingPackage(), "com.obric.matrix") == true) goto L15;
        return null;
    L15:
        if (this.f397012a.match(r110) != 1) goto L56;
        if (r112 == null) goto L18;
        Integer r117 = Integer.valueOf(r112.getInt("channel_id", 0));
    L20:
        if (r112 == null) goto L22;
        Long r118 = Long.valueOf(r112.getLong("seq_id", 0));
    L23:
        if (r112 == null) goto L25;
        Long r119 = Long.valueOf(r112.getLong("log_id", 0));
    L26:
        if (r112 == null) goto L28;
        Integer r101 = Integer.valueOf(r112.getInt("service", 0));
    L29:
        if (r112 == null) goto L31;
        Integer r102 = Integer.valueOf(r112.getInt(e.f25671s, 0));
    L33:
        if (r112 == null) goto L35;
        Serializable r103 = r112.getSerializable("ws_headers");
    L36:
        if (r103 == null) goto L44;
        if (r112 == null) goto L39;
        Serializable r104 = r112.getSerializable("ws_headers");
    L40:
        if (r104 == null) goto L43;
        HashMap r105 = (HashMap) r104;
    L45:
        if (r112 == null) goto L47;
        String r106 = r112.getString("payload_type");
    L48:
        if (r112 == null) goto L50;
        String r107 = r112.getString("payload_encoding");
    L51:
        if (r112 == null) goto L53;
        r100 = r112.getByteArray(WsConstants.KEY_PAYLOAD);
    L53:
        List<Function4<Integer, Integer, Integer, Boolean, Unit>> r120 = MatrixWsHelper.f397011a;
        Intrinsics.checkNotNull(r117);
        int r121 = r117.intValue();
        Intrinsics.checkNotNull(r118);
        long r122 = r118.longValue();
        Intrinsics.checkNotNull(r119);
        long r108 = r119.longValue();
        Intrinsics.checkNotNull(r101);
        int r123 = r101.intValue();
        Intrinsics.checkNotNull(r102);
        b.a("MatrixWsHelper", "onWsMsgReceivedByProvider() called with: channelId = " + r121 + ", seqId = " + r122 + ", logId = " + r108 + ", service = " + r123 + ", method = " + r102.intValue() + ", encoding = " + r107 + ", type = " + r106 + ", payload = " + r100 + ", headers = " + r105 + ", wsBridge is null");
        MatrixCursor r109 = new MatrixCursor(new String[]{MessageIndication.STATUS_RECEIVED});
        r109.addRow(new String[]{"true"});
        return r109;
    L50:
        r107 = null;
        goto L51
    L47:
        r106 = null;
        goto L48
    L43:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L39:
        r104 = null;
        goto L40
    L44:
        r105 = null;
        goto L45
    L35:
        r103 = null;
        goto L36
    L31:
        r102 = null;
        goto L33
    L28:
        r101 = null;
        goto L29
    L25:
        r119 = null;
        goto L26
    L22:
        r118 = null;
        goto L23
    L18:
        r117 = null;
        goto L20
    L56:
        return null;
    L5:
        if (r115.length() == 0) goto L8;
        r116 = false;
        goto L9
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Objects.toString(r100);
        bka.a r105 = bka.a.f19387a;
        return null;
    }
}
