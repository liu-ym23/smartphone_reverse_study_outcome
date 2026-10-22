package com.ss.android.lark.officesdk.applink;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ova.f;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class OfficeSDKAppLinkServiceImpl implements com.ss.android.lark.officesdk.applink.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f433096a;

    public static final class a {
    }

    static {
    }

    @Inject
    public OfficeSDKAppLinkServiceImpl() {
        this.f433096a = LazyKt.lazy(OfficeSDKAppLinkServiceImpl$appLinkService$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.applink.a
    public final boolean d9(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        return ((f) this.f433096a.getValue()).h(r100, UriProtector.parse(r101));
    }

    @Override // com.ss.android.lark.officesdk.applink.a
    public final void q6(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        f r102 = (f) this.f433096a.getValue();
        Uri r103 = UriProtector.parse(r101);
        monitor-enter(r102);
        r102.x(r100, r103);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.officesdk.applink.a
    public final boolean u7(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Set<String> r102 = b.f433098a;
        Intrinsics.checkNotNullParameter(r101, "url");
        boolean r103 = true;
        Uri r104 = b.a(r101);     // Catch: Exception -> L17
        if (r104 == null) goto L18;
        String r105 = UriProtector.getQueryParameter(r104, "link_token");     // Catch: Exception -> L17
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L18;
        Uri r107 = r104.buildUpon().scheme("lark").authority("applink").path("/client/chat/chatter/add_by_link").build();     // Catch: Exception -> L17
    L19:
        if (r107 != null) goto L34;
        return false;
    L34:
    L32:
        Log.w("OfficeSDKAppLinkService", "open group invite appLink failed");
        return false;
    L22:
        if (((f) this.f433096a.getValue()).h(r100, r107) == true) goto L24;
        Log.w("OfficeSDKAppLinkService", "group invite appLink cannot open");     // Catch: Exception -> L32
        r103 = false;
    L39:
        return r103;
    L24:
        f r108 = (f) this.f433096a.getValue();     // Catch: Exception -> L32
        monitor-enter(r108);     // Catch: Exception -> L32
        r108.x(r100, r107);     // Catch: Throwable -> L29
        monitor-exit(r108);     // Catch: Exception -> L32
        goto L39
    L29:
        th = move-exception;
        throw th;     // Catch: Exception -> L32
    L9:
        if (StringsKt.isBlank(r105) == true) goto L12;
        r106 = false;
    L18:
        r107 = null;
    L17:
        Log.w("OfficeSDKGroupInviteLink", "normalize group invite link failed");
        goto L18
    }
}
