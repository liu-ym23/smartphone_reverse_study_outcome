package omb;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lark.base.open.pkm.PkmBizType;
import com.bytedance.lark.base.open.pkm.PkmError;
import com.bytedance.lark.base.open.pkm.h;
import com.bytedance.lark.base.open.pkm.j;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PkmBizType f524315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile j f524316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f524317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f524318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f524319e = null;

    /* JADX INFO: renamed from: omb.a$a, reason: collision with other inner class name */
    public static final class C7072a implements com.bytedance.lark.base.open.pkm.c {
        public C7072a() {
        }

        @Override // com.bytedance.lark.base.open.pkm.c
        public final void onEvent(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
            Log.i("CardTemplatePkmManager", "applyJssdkUpdate event=" + r100 + " payload=" + r101);
        }
    }

    static {
        f524315a = PkmBizType.JssdkMsgCard;
        f524319e = new Object();
    }

    public static void a() {
        j r100 = f524316b;     // Catch: PkmError -> L13
        if (r100 == null) goto L6;
        boolean r101 = r100.e(f524315a);     // Catch: PkmError -> L13
    L7:
        Log.i("CardTemplatePkmManager", "checkAndApplyUpdate hasUpdate=" + r101);     // Catch: PkmError -> L13
        if (r101 == false) goto L18;
        j r102 = f524316b;     // Catch: PkmError -> L13
        if (r102 == null) goto L19;
        r102.b(f524315a, new C7072a());     // Catch: PkmError -> L13
        return;
    L19:
        return;
    L18:
        return;
    L6:
        r101 = false;
    L13:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "checkAndApplyUpdate failed: " + e);
    }

    public static j b(Context r100) {
        j r101 = f524316b;
        if (r101 == null) goto L5;
        return r101;
    L5:
        e(r100);
        j r102 = f524316b;
        if (r102 != null) goto L8;
        Log.w("CardTemplatePkmManager", "ensureManager: pkmManager still null");
    L8:
        return r102;
    }

    public static void c(Context r100) {
        PolarisFileWrapper r101 = d(r100);     // Catch: PkmError -> L25
        FileUtils.b(r100, "msg_card_template.7z", r101.getAbsolutePath());     // Catch: PkmError -> L25
        Log.i("CardTemplatePkmManager", "extractBuiltinTemplateIfNeeded,start path=" + r101.getAbsolutePath());     // Catch: PkmError -> L25
        j r102 = f524316b;     // Catch: PkmError -> L25
        boolean r103 = false;
        if (r102 == null) goto L6;
        boolean r104 = r102.c(f524315a, r101.getAbsolutePath());     // Catch: PkmError -> L25
    L7:
        Log.i("CardTemplatePkmManager", "extractBuiltinTemplateIfNeeded: result=" + r104 + ", path=" + r101.getAbsolutePath());     // Catch: PkmError -> L25
        if (r104 == false) goto L42;
        String r105 = f(r100);     // Catch: PkmError -> L25
        if (r105 == null) goto L12;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);     // Catch: PkmError -> L25
    L13:
        if (r106 != null) goto L15;
    L17:
        Log.i("CardTemplatePkmManager", "extractBuiltinTemplateIfNeeded: installed templatePath=" + r105 + ", exists=" + r103);     // Catch: PkmError -> L25
        j r107 = f524316b;     // Catch: PkmError -> L22
        if (r107 == null) goto L43;
        r107.d(f524315a, new b());     // Catch: PkmError -> L22
    L44:
        return;
    L43:
        return;
    L22:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "getJssdkInstallationVersion failed: " + e);     // Catch: PkmError -> L25
        return;
    L15:
        if (r106.exists() != true) goto L17;
        r103 = true;
        goto L17
    L12:
        r106 = null;
        goto L13
    L42:
        return;
    L6:
        r104 = false;
    L25:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "extractBuiltinTemplateIfNeeded failed, msg=" + e.getMessage() + ", cause=" + e.getCause(), e);
        Iterator r108 = ArrayIteratorKt.iterator(e.getClass().getDeclaredFields());     // Catch: Exception -> L32
    L29:
        if (r108.hasNext() == false) goto L46;
        Field r109 = (Field) r108.next();     // Catch: Exception -> L32
        r109.setAccessible(true);     // Catch: Exception -> L32
        Log.e("CardTemplatePkmManager", "PkmError field: " + r109.getName() + " = " + r109.get(e));     // Catch: Exception -> L32
        goto L29
    L46:
        return;
    L32:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "Failed to inspect PkmError fields", e);
    }

    public static PolarisFileWrapper d(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(new PolarisFileWrapper(r100.getFilesDir(), "lynx_message_card").getAbsolutePath(), "buildin_bundle");
        if (r101.exists() == true) goto L6;
        r101.mkdir();
    L6:
        if (r101.exists() == true) goto L8;
        r101.mkdirs();
    L8:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "msg_card_template.7z");
        if (r102.exists() == false) goto L15;
    L14:
        return r102;
    L15:
        r102.createNewFile();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "create temp bundle zip file failed", e);
        goto L14
    }

    @JvmStatic
    public static final void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f524317c == false) goto L5;
        return;
    L5:
        Object r101 = f524319e;
        monitor-enter(r101);
    L31:
        th = move-exception;
        throw th;
    L8:
        if (f524317c == false) goto L11;
        monitor-exit(r101);
        return;
    L11:
        String r102 = com.ss.android.lark.message.card.b.a().getLoginUserId();     // Catch: Throwable -> L31
        if (r102 != null) goto L14;
    L17:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L35;
        Log.w("CardTemplatePkmManager", "init: userId is empty, skip pkm init");     // Catch: Throwable -> L31
        monitor-exit(r101);
        return;
    L35:
        f524316b = h.a(r102);     // Catch: Throwable -> L24 PkmError -> L26
        f524317c = true;     // Catch: Throwable -> L24 PkmError -> L26
        c(r100);     // Catch: Throwable -> L24 PkmError -> L26
        a();     // Catch: Throwable -> L24 PkmError -> L26
    L28:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r101);
        return;
    L24:
        th = move-exception;
        Log.e("CardTemplatePkmManager", "init unexpected error", th);     // Catch: Throwable -> L31
    L26:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "init: buildPkmManager failed: " + e);     // Catch: Throwable -> L31
        goto L28
    L14:
        if (r102.length() == 0) goto L17;
        r103 = false;
        goto L18
    }

    @JvmStatic
    public static final String f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        j r101 = b(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = "template.js";
        if (StringsKt.startsWith$default("template.js", "local://open_card/", false, 2, null) == false) goto L9;
        r102 = "template.js".substring(18);
    L9:
        if (StringsKt.startsWith$default(r102, HTTP.URL_DEFAULT, false, 2, null) == false) goto L11;
        r102 = r102.substring(1);
        goto L9
    L11:
        Log.i("CardTemplatePkmManager", "path normalized = " + r102);
        return r101.f(r102, f524315a);
    L14:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "installationPath failed. path=" + r102, e);
        return null;
    }
}
