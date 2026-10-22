package cl9;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import ita.i;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a extends j27.a {

    /* JADX INFO: renamed from: cl9.a$a, reason: collision with other inner class name */
    public static final class C0003a {
    }

    static {
    }

    @Override // j27.a
    public final void c() {
    }

    @Override // j27.a
    public final Application b() {
        Context r0 = Mira.getAppContext();
        if ((r0 instanceof Application) == true) goto L7;
        return null;
    L7:
        return (Application) r0;
    }

    public a() {
    }

    @Override // j27.a
    public final String a(byte[] r9) {
        Intrinsics.checkNotNullParameter("https://security.snssdk.com/api/plugin/config/v2/", "pluginConfigServerUrl");
        Intrinsics.checkNotNullParameter(r9, "localPluginInfoBytes");
        Intrinsics.checkNotNullParameter("application/json; charset=utf-8", "contentType");
        String r2 = null;
        ISecPrivacyService.a.getClass();     // Catch: Throwable -> L31
        ISecPrivacyService r5 = ISecPrivacyService.a.a();     // Catch: Throwable -> L31
        boolean r6 = false;
        if (r5 != null) goto L6;
    L8:
        boolean r7 = false;
    L9:
        if (r7 == true) goto L11;
    L34:
        return r2;
    L11:
        if (TextUtils.isEmpty(o.a.getDeviceId()) == true) goto L34;
        if (r9.length != 0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L19;
        return null;
    L19:
        if (TextUtils.isEmpty("https://security.snssdk.com/api/plugin/config/v2/") == false) goto L21;
    L30:
        return null;
    L21:
        if ("application/json; charset=utf-8".length() != 0) goto L23;
        r6 = true;
    L23:
        if (r6 == true) goto L30;
        Uri.Builder r3 = UriProtector.parse("https://security.snssdk.com/api/plugin/config/v2/").buildUpon();     // Catch: Throwable -> L31
        r3.appendQueryParameter("host_abi", Mira.getHostAbi());     // Catch: Throwable -> L31
        String r10 = i.b(33554432, r3.build().toString(), r9, NetworkUtils.CompressType.GZIP, "application/json; charset=utf-8");     // Catch: Throwable -> L31
        FLogger.a.i("FlowMorpheusAdapter", "plugin config request return result:" + r10);     // Catch: Throwable -> L28
        return r10;
    L28:
        Throwable th = th;
        r2 = r10;
    L33:
        FLogger.a.e("FlowMorpheusAdapter", XmlPullParser.NO_NAMESPACE, th);
        goto L34
    L15:
        r8 = false;
        goto L16
    L6:
        if (r5.h() != true) goto L8;
        r7 = true;
    L31:
        th = move-exception;
        th = th;
        goto L33
    }

    @Override // j27.a
    public final void d(Map r4) {
        FLogger.a.i("FlowMorpheusAdapter", "plugin download event:morpheus_download_process:" + r4);
    }

    @Override // j27.a
    public final void e(l27.b r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginConfig");
        if (r2.m != 0) goto L6;
        r2.m = 1;
        return;
    }
}
