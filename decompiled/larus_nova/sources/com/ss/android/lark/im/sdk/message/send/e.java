package com.ss.android.lark.im.sdk.message.send;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.t0;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements jkb.d<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f425977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f425978b;

    public static final class a {
    }

    public interface b {
        File a(File r100);

        PolarisFileWrapper b(Context r100, Uri r101);

        Uri c(Context r100, Uri r101);

        PolarisFileWrapper d(String r100);
    }

    public interface c {
        boolean a();
    }

    static {
    }

    @Override // jkb.d
    public final String getName() {
        return "DecryptFileStep";
    }

    public e() {
        com.ss.android.lark.im.sdk.message.c r100 = com.ss.android.lark.im.sdk.message.c.f425934a;
        d r101 = new d();
        Intrinsics.checkNotNullParameter(r100, "fileDescriptorFeature");
        Intrinsics.checkNotNullParameter(r101, "decryptFileDependency");
        this.f425977a = r100;
        this.f425978b = r101;
    }

    @Override // jkb.d
    public final void a(jkb.b r110, final jkb.c r111) {
        k r100 = (k) r110;
        Intrinsics.checkNotNullParameter(r100, "pipelineContext");
        Intrinsics.checkNotNullParameter(r111, "pipelineControl");
        MessageParams<?, ?> r101 = r100.f425987a;
        boolean r102 = r101 instanceof com.ss.android.lark.biz.im.api.l;
        if (r102 == true) goto L5;
    L7:
        IGetDataCallback<Boolean> r103 = new DecryptFileStep$process$callback$1(r111);
        Log.i("DecryptFileStep", "decrypt file");
        c r104 = this.f425977a;
        b r105 = this.f425978b;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r104, "fileDescriptorFeature");
        Intrinsics.checkNotNullParameter(r105, "decryptFileDependency");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Log.i("DecryptFileStep", "decryptMessageFile");
        if (r102 == false) goto L44;
        com.ss.android.lark.biz.im.api.l r106 = (com.ss.android.lark.biz.im.api.l) r101;
        if (r106.K == null) goto L13;
        Log.i("DecryptFileStep", "[DoubaoFile] skip decrypt for remote resource");
        r103.onSuccess(Boolean.TRUE);
        return;
    L13:
        if (TextUtils.isEmpty(r106.A) == true) goto L15;
        String r107 = r106.A;
    L16:
        if (r107 != null) goto L34;
        Uri r108 = r106.I;
        if (r108 == null) goto L33;
        Application r112 = LarkContext.getApplication();
        Log.i("DecryptFileStep", "decryptMessageUri");
        Uri r113 = r105.c(r112, r108);     // Catch: SecurityException -> L29 DecryptException -> L31
        Log.i("DecryptFileStep", "[cipher] file decrypt success, origin uri = " + r108.getPath() + ", new uri = " + r108.getPath());     // Catch: SecurityException -> L29 DecryptException -> L31
        if (r104.a() == false) goto L23;
        r106.I = r113;     // Catch: SecurityException -> L29 DecryptException -> L31
    L27:
        r103.onSuccess(Boolean.TRUE);     // Catch: SecurityException -> L29 DecryptException -> L31
    L64:
        return;
    L23:
        PolarisFileWrapper r109 = r105.b(r112, r113);     // Catch: SecurityException -> L29 DecryptException -> L31
        if (r109 == null) goto L26;
        r106.B = r109.getAbsolutePath();     // Catch: SecurityException -> L29 DecryptException -> L31
        goto L27
    L26:
        r106.I = r113;     // Catch: SecurityException -> L29 DecryptException -> L31
    L31:
        e = move-exception;
        Log.e("DecryptFileStep", "[cipher] file decrypt failed, original uri = " + r108.getPath());
        r103.onError(new ErrorResult(e));
        return;
    L29:
        e = move-exception;
        Log.e("DecryptFileStep", "[cipher] file decrypt failed, original uri = " + r108.getPath() + ", exception message is " + e.getMessage());
        new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ErrorResult r114 = new ErrorResult(0);
        ErrorResult.access$002(r114, -1);
        ErrorResult.access$102(r114, -9999);
        ErrorResult.access$202(r114, 0);
        ErrorResult.access$302(r114, e);
        ErrorResult.access$402(r114, "");
        ErrorResult.access$502(r114, "");
        ErrorResult.access$602(r114, "");
        ErrorResult.access$702(r114, "");
        ErrorResult.access$802(r114, 0);
        ErrorResult.access$902(r114, null);
        ErrorResult.access$1002(r114, null);
        ErrorResult.access$1102(r114, null);
        r103.onError(r114);
        return;
    L33:
        Log.e("DecryptFileStep", "File uri is null");
        Exception r115 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ErrorResult r116 = new ErrorResult(0);
        ErrorResult.access$002(r116, -1);
        ErrorResult.access$102(r116, -9999);
        ErrorResult.access$202(r116, 0);
        ErrorResult.access$302(r116, r115);
        ErrorResult.access$402(r116, "");
        ErrorResult.access$502(r116, "File uri is null");
        ErrorResult.access$602(r116, "");
        ErrorResult.access$702(r116, "");
        ErrorResult.access$802(r116, 0);
        ErrorResult.access$902(r116, null);
        ErrorResult.access$1002(r116, null);
        ErrorResult.access$1102(r116, null);
        r103.onError(r116);
        return;
    L34:
        Log.i("DecryptFileStep", "decryptMessageFile for FileMessage");
        PolarisFileWrapper r117 = r105.d(r107);     // Catch: DecryptException -> L41
        Log.i("DecryptFileStep", "[cipher] file decrypt success, original path = " + r107 + ", new path = " + r117.getAbsolutePath());     // Catch: DecryptException -> L41
        if (r104.a() == false) goto L38;
        r106.I = Uri.fromFile(r117);     // Catch: DecryptException -> L41
    L39:
        r103.onSuccess(Boolean.TRUE);     // Catch: DecryptException -> L41
        return;
    L38:
        r106.B = r117.getAbsolutePath();     // Catch: DecryptException -> L41
    L41:
        e = move-exception;
        Log.e("DecryptFileStep", "[cipher] file decrypt failed, original path = ".concat(r107));
        r103.onError(new ErrorResult(e));
        return;
    L15:
        r107 = null;
        goto L16
    L44:
        if ((r101 instanceof t0) == true) goto L51;
        r103.onSuccess(Boolean.TRUE);
        return;
    L51:
        File r118 = ((t0) r101).D;     // Catch: Exception -> L47
        Intrinsics.checkNotNull(r118);     // Catch: Exception -> L47
        File r119 = r105.a(r118);     // Catch: Exception -> L47
        Log.i("DecryptFileStep", "[cipher] file decrypt success, original path = " + r118.getAbsolutePath() + ", new path = " + r119.getAbsolutePath());     // Catch: Exception -> L47
        ((t0) r101).E = r119;     // Catch: Exception -> L47
        r103.onSuccess(Boolean.TRUE);     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        Log.e("DecryptFileStep", "[cipher] file decrypt failed, original path = " + ((t0) r101).D.getAbsolutePath());
        r103.onError(new ErrorResult(e));
        return;
    L5:
        if (((com.ss.android.lark.biz.im.api.l) r101).K == null) goto L7;
        Log.i("DecryptFileStep", "skip decrypt for doubao remote file");
        r111.a();
    }
}
