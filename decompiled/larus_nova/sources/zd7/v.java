package zd7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.saveDataURL")
public final class v extends yd7.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f571440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f571441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f571442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f571443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f571444h;

    public static final class a {
    }

    static {
    }

    public v() {
        this.f571440d = "jpg";
        this.f571441e = LoadParams.ImageFormat.PNG;
        this.f571442f = "nonsupportType";
        this.f571443g = "image/jpeg";
        this.f571444h = "image/png";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r210, XBaseParamModel r211, CompletionBlock r212) {
        yd7.h.b r100 = (yd7.h.b) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        Activity r101 = r210.getOwnerActivity();
        if (r101 != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "Context not provided in host", null, 4, null);
        return;
    L6:
        if (com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r101) != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "context can not convert to activity", null, 4, null);
        return;
    L8:
        boolean r102 = true;
        if (r100.getDataURL().length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "The dataURL key is required.", null, 4, null);
        return;
    L15:
        if (r100.getExtension().length() != 0) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "The extension key is required.", null, 4, null);
        return;
    L21:
        if (r100.getFilename().length() != 0) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == false) goto L26;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "The filename key is required.", null, 4, null);
        return;
    L26:
        String r110 = null;
        if (StringsKt.startsWith$default(r100.getDataURL(), fyb.a.KEY_DATA, false, 2, null) == true) goto L29;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "dataURL invalid", null, 4, null);
        return;
    L29:
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        String r111 = r100.getDataURL();
        if (StringsKt.contains$default(r111, ",", false, 2, null) == false) goto L59;
        String r106 = (String) ListProtector.get(StringsKt.split$default(r111, new String[]{","}, false, 0, 6, null), 1);
        if (r106.length() == 0) goto L35;
        r102 = false;
    L35:
        if (r102 == false) goto L37;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, null, null, 6, null);
        return;
    L37:
        String r107 = r100.getExtension();
        String r108 = r100.getFilename() + '.' + r107;
        File r109 = r101.getExternalCacheDir();
        if (r109 != null) goto L40;
        r109 = r101.getCacheDir();
    L40:
        if (r109 == null) goto L42;
        r110 = r109.getAbsolutePath();
    L42:
        if (r110 != null) goto L44;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "cacheDir is null", null, 4, null);
        return;
    L44:
        PolarisFileWrapper r112 = new PolarisFileWrapper(r110, r108);
        String r113 = r112.getAbsolutePath();
        if (r112.exists() == false) goto L48;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "file path already exist", null, 4, null);
        return;
    L48:
        if (Intrinsics.areEqual(r107, this.f571440d) == false) goto L52;
        String r114 = this.f571443g;
    L50:
        String r115 = r114;
        if (Intrinsics.areEqual(r115, this.f571442f) == false) goto L58;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, null, null, 6, null);
        return;
    L58:
        com.bytedance.sdk.xbridge.cn.utils.g.a().execute(new w(this, r106, r212, r115, r113, r100, r210, r101));
        return;
    L52:
        if (Intrinsics.areEqual(r107, this.f571441e) == false) goto L54;
        r114 = this.f571444h;
        goto L50
    L54:
        r114 = this.f571442f;
        goto L50
    L59:
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, null, null, 6, null);
        return;
    L23:
        r105 = false;
        goto L24
    L17:
        r104 = false;
        goto L18
    L11:
        r103 = false;
        goto L12
    }

    public static final void a(v r100, Activity r101, IBDXBridgeContext r102, yd7.h.b r110, String r111, String r112, CompletionBlock r113) {
        r100.getClass();
        Map<String, Map<Class<?>, Object>> r103 = x26.a.f562251a;
        w26.g r104 = (w26.g) x26.a.a(w26.g.class);
        if (r104 == null) goto L7;
        w26.e r105 = (w26.e) r104.n0(w26.e.class);
        if (r105 == null) goto L7;
        boolean r106 = r105.y2();
    L9:
        if (r106 == false) goto L23;
        int r107 = ae7.f.f3112a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "path");
        Intrinsics.checkNotNullParameter(r112, DBDefinition.MIME_TYPE);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r111);
        String r109 = ae7.c.f3110a + '/' + r108.getName();
        if (ae7.f.b() == false) goto L13;
        Uri r114 = ae7.c.d(r101, r108.getName(), r112);
    L14:
        if (r114 != null) goto L55;
    L28:
        r114 = null;
    L36:
        StringBuilder r115 = new StringBuilder("copyToAlbum, filePath=");
        r115.append(r111);
        r115.append(", mimeType=");
        r115.append(r112);
        r115.append(", broadcastWithFilePath=");
        r115.append(r106);
        r115.append(", uri=");
        if (r114 == null) goto L40;
        String r116 = r114.toString();
        if (r116 == null) goto L40;
    L41:
        r115.append(r116);
        com.bytedance.sdk.xbridge.cn.utils.i.b("x.saveDataURL", r115.toString(), "BridgeProcessing", r102.getContainerID());
        if (r114 == null) goto L51;
        CompletionBlock.DefaultImpls.onSuccess$default(r113, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.h.c.class)), null, 2, null);
        Boolean r117 = r110.isCached();
        if (r117 == null) goto L46;
        boolean r118 = r117.booleanValue();
    L47:
        int r119 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        XBaseRuntime.f270095a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.d r120 = XBaseRuntime.f270115u;
        if (r120 != null) goto L50;
        com.bytedance.sdk.xbridge.cn.utils.i.b("x.saveDataURL", "cacheDepend is null", "BridgeProcessing", r102.getContainerID());
        return;
    L50:
        r120.b();
        com.bytedance.sdk.xbridge.cn.utils.i.b("x.saveDataURL", "trigger cacheDepend.onSaveImage with isCached=" + r118 + ", filePath=" + r111, "BridgeProcessing", r102.getContainerID());
        return;
    L46:
        r118 = false;
        goto L47
    L51:
        ae7.c.g(r111);
        CompletionBlock.DefaultImpls.onFailure$default(r113, 0, "saveToAlbum error", null, 4, null);
        return;
    L40:
        r116 = "null";
        goto L41
    L55:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L18
        ae7.c.b(new PolarisFileInputStreamWrapper(r111), ContentResolverWrapper.openOutputStream(r101.getContentResolver(), r114));     // Catch: Throwable -> L18
        Result.m9449constructorimpl(Boolean.valueOf(ae7.c.g(r111)));     // Catch: Throwable -> L18
    L21:
        if (ae7.c.e(r101, r114) == false) goto L36;
        r101.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new PolarisFileWrapper(r109))));
    L18:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L13:
        r114 = ae7.c.c(r101, r108.getName(), r112);
        goto L14
    L23:
        int r123 = ae7.f.f3112a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "path");
        Intrinsics.checkNotNullParameter(r112, DBDefinition.MIME_TYPE);
        PolarisFileWrapper r124 = new PolarisFileWrapper(r111);
        if (ae7.f.b() == false) goto L26;
        r114 = ae7.c.d(r101, r124.getName(), r112);
    L27:
        if (r114 == null) goto L28;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L31
        ae7.c.b(new PolarisFileInputStreamWrapper(r111), ContentResolverWrapper.openOutputStream(r101.getContentResolver(), r114));     // Catch: Throwable -> L31
        Result.m9449constructorimpl(Boolean.valueOf(ae7.c.g(r111)));     // Catch: Throwable -> L31
    L34:
        if (ae7.c.e(r101, r114) == false) goto L36;
        r101.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r114));
    L31:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L26:
        r114 = ae7.c.c(r101, r124.getName(), r112);
    L7:
        r106 = true;
        goto L9
    }
}
