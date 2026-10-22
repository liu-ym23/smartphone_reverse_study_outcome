package com.dtf.face.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.dtf.face.api.IDTLoadingFragment;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.IConstValues;
import com.dtf.face.config.NavigatePage;
import com.dtf.face.config.Protocol;
import com.dtf.face.config.ProtocolContent;
import com.dtf.face.config.SolutionConfig;
import com.dtf.face.log.MemoryService;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.ui.toyger.FaceLoadingFragment;
import com.dtf.face.ui.widget.ToygerWebView;
import com.dtf.face.utils.EnvCheck$EnvErrorType;
import com.dtf.face.verify.IOcrResultCallback;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import us7.f;
import us7.g;
import ws7.h;
import ws7.j;
import ws7.o;
import ws7.p;
import ws7.r;
import ws7.s;

/* JADX INFO: loaded from: classes22.dex */
public class FaceLoadingActivity extends FaceBaseActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f273649k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f273650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ToygerWebView f273651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IDTLoadingFragment f273652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f273653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f273654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f273655j;

    public class a implements IDTLoadingFragment.IMessageBoxCB {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f273656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f273657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FaceLoadingActivity f273658c;

        @Override // com.dtf.face.api.IDTLoadingFragment.IMessageBoxCB
        public final void onCancel() {
        }

        @Override // com.dtf.face.api.IDTLoadingFragment.IMessageBoxCB
        public final void onOK() {
            RecordService.getInstance().recordEvent(2, "userBack", new String[]{"type", this.f273656a});
            this.f273658c.q(this.f273657b);
        }

        public a(FaceLoadingActivity r100, String r101, String r102) {
            this.f273658c = r100;
            this.f273656a = r101;
            this.f273657b = r102;
        }
    }

    public class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f273659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f273660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f273661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FaceLoadingActivity f273662d;

        public final void a() {
            if (this.f273659a == false) goto L57;
            if (this.f273660b == false) goto L57;
            if (this.f273661c == false) goto L55;
            FaceLoadingActivity r100 = this.f273662d;
            int r101 = FaceLoadingActivity.f273649k;
            r100.getClass();
            hs7.a.h().f487007s = new us7.b();
            ProtocolContent r102 = hs7.a.h().d();
            boolean r103 = false;
            if (r102 == null) goto L11;
            boolean r104 = r102.hasMultiProtocol();
        L13:
            if (r104 == true) goto L15;
        L22:
            if (r104 == false) goto L24;
        L54:
            r100.finish();
            return;
        L24:
            if (hs7.a.h().m() == true) goto L26;
            FaceLoadingActivity.g();     // Catch: Throwable -> L31
            boolean r105 = true;
        L33:
            if (r105 == true) goto L36;
            r100.q("Z5115_4");
            return;
        L36:
            if (hs7.a.h().o() == false) goto L52;
            Map<String, Object> r106 = r100.n();
            Context r107 = hs7.a.h().j();     // Catch: Throwable -> L50
            if (r107 != null) goto L41;
        L43:
            r107 = r100;
        L44:
            Class r108 = FaceLoadingActivity.h();     // Catch: Throwable -> L50
            Method r109 = r108.getDeclaredMethod("updateOcrCallback", new Class[]{IOcrResultCallback.class});     // Catch: Throwable -> L50
            r109.setAccessible(true);     // Catch: Throwable -> L50
            r109.invoke(null, new Object[]{hs7.a.h().f487005q});     // Catch: Throwable -> L50
            Method r110 = r108.getDeclaredMethod("startOcr", new Class[]{Context.class, Map.class});     // Catch: Throwable -> L50
            r110.setAccessible(true);     // Catch: Throwable -> L50
            r110.invoke(null, new Object[]{r107, r106});     // Catch: Throwable -> L50
            r103 = true;
            goto L52
        L41:
            if ((r107 instanceof Activity) == false) goto L43;
        L50:
            th = move-exception;
            RecordService.getInstance().recordEvent(4, "ocrError", new String[]{"status", RecordService.getStackTraceString(th)});
        L52:
            if (r103 == true) goto L54;
            baseverify.d.a(r100, r100.n());
        L31:
            th = move-exception;
            RecordService.getInstance().recordException(th);
            r105 = false;
            goto L33
        L26:
            if (r100.getPackageManager().hasSystemFeature("android.hardware.nfc") == true) goto L28;
            r100.q("Z3003");
            return;
        L28:
            baseverify.d.b(r100, r100.n());
            goto L54
        L15:
            if ((r102.getCurrentProtocol() instanceof AndroidClientConfig) == false) goto L17;
            baseverify.d.a(r100, r100.n());
            goto L22
        L17:
            RecordService r111 = RecordService.getInstance();
            String[] r112 = new String[2];
            r112[0] = "protocol";
            String r113 = JSON.toJSONString(r102);     // Catch: Throwable -> L20
        L21:
            r112[1] = r113;
            r111.recordEvent(2, "checkMultiProtocol", r112);
            r100.q("Z1025");
            r104 = true;
        L20:
            r113 = "";
            goto L21
        L11:
            r104 = false;
            goto L13
        L55:
            this.f273662d.q("Z1040");
            return;
        L57:
            if (this.f273660b == false) goto L75;
            ToygerWebView r114 = this.f273662d.f273651f;
            if (r114 == null) goto L61;
            r114.setVisibility(8);
        L61:
            IDTLoadingFragment r115 = this.f273662d.f273652g;
            if (r115 == null) goto L76;
            r115.showLoadingView();
            return;
        L76:
            return;
        }

        public b(FaceLoadingActivity r100) {
            this.f273662d = r100;
            this.f273659a = false;
            this.f273660b = false;
            this.f273661c = false;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 903) goto L5;
            String r102 = (String) r100.obj;
            FaceLoadingActivity r103 = this.f273662d;
            int r104 = FaceLoadingActivity.f273649k;
            r103.getClass();
            if (TextUtils.isEmpty(r102) == false) goto L68;
            r102 = "Z1000";
        L68:
            if (hs7.a.h().f487000l == true) goto L70;
            r103.r(r102);
        L73:
            return false;
        L70:
            if (r103.s(r102, new us7.c(r103, r102)) == true) goto L73;
            r103.r(r102);
            goto L73
        L5:
            if (r101 == 915) goto L63;
            boolean r105 = true;
            if (r101 != 916) goto L9;
            this.f273659a = true;
            if (r100.arg1 == 0) goto L62;
            r105 = false;
        L62:
            this.f273661c = r105;
            a();
            goto L73
        L9:
            if (r101 == 920) goto L40;
            if (r101 != 921) goto L13;
            int r106 = r100.arg1;
            ProgressBar r107 = (ProgressBar) this.f273662d.findViewById(R.id.web_progress_bar);
            if (r107 == null) goto L73;
            if (r106 != 100) goto L36;
            r107.setVisibility(8);
            goto L73
        L36:
            if (r107.getVisibility() != 8) goto L38;
            r107.setVisibility(0);
        L38:
            r107.setProgress(r106);
            goto L73
        L13:
            switch(r101) {
                case 905: goto L27;
                case 906: goto L25;
                case 907: goto L24;
                case 908: goto L16;
                case 909: goto L15;
                default: goto L73;
            };
        L15:
            this.f273660b = true;
            a();
            goto L73
        L16:
            Object r108 = r100.obj;
            String r109 = "NULL";
            if (r108 == null) goto L19;
            String r110 = r108.toString();
        L20:
            ToygerWebView r111 = this.f273662d.f273651f;
            if (r111 == null) goto L23;
            r109 = r111.getUrl();
        L23:
            RecordService.getInstance().recordEvent(4, "naviLoadError", new String[]{"url", r109, "msg", r110});
            goto L73
        L19:
            r110 = "NULL";
            goto L20
        L24:
            FaceLoadingActivity r112 = this.f273662d;
            String r113 = (String) r100.obj;
            int r114 = FaceLoadingActivity.f273649k;
            r112.getClass();
            RecordService.getInstance().recordEvent(2, "guidPageLog", new String[]{"guid_log", r113});
            goto L73
        L25:
            this.f273662d.m(0);
            goto L73
        L27:
            if (TextUtils.equals(hs7.a.h().k(), "2") == false) goto L29;
            hs7.a.h().r("0");
        L29:
            this.f273662d.o();
            this.f273662d.a();
            goto L73
        L40:
            if (this.f273662d.f273651f == null) goto L73;
            String r115 = String.valueOf(r100.obj);
            IDTLoadingFragment r116 = this.f273662d.f273652g;
            Protocol r117 = hs7.a.h().f486994f;
            NavigatePage r118 = null;
            if (r117 == null) goto L52;
            ProtocolContent r119 = r117.protocolContent;
            if (r119 == null) goto L52;
            SolutionConfig r120 = r119.solutionConfig;
            if (r120 == null) goto L48;
            r118 = r120.navi;
        L48:
            if (r118 != null) goto L52;
            AndroidClientConfig r121 = r119.androidClientConfig;
            if (r121 == null) goto L52;
            r118 = r121.getNavi();
        L52:
            if (r118 != null) goto L54;
        L56:
            r105 = false;
        L57:
            r116.initTitleBar(r105);
            goto L73
        L54:
            if (r115.startsWith(r118.getUrl()) == true) goto L56;
        L63:
            hs7.a.h().r("1");
            this.f273662d.o();
            this.f273662d.a();
            goto L73
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FaceLoadingActivity f273663a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (FaceLoadingActivity.j(this.f273663a) == false) goto L9;
            this.f273663a.p();     // Catch: Throwable -> L6
            return;
        }

        public c(FaceLoadingActivity r100) {
            this.f273663a = r100;
        }
    }

    public class d implements IDTLoadingFragment.IMessageBoxCB {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f273664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FaceLoadingActivity f273665b;

        @Override // com.dtf.face.api.IDTLoadingFragment.IMessageBoxCB
        public final void onCancel() {
            FaceLoadingActivity r100 = this.f273665b;
            String r101 = this.f273664a;
            int r102 = FaceLoadingActivity.f273649k;
            r100.r(r101);
        }

        @Override // com.dtf.face.api.IDTLoadingFragment.IMessageBoxCB
        public final void onOK() {
            FaceLoadingActivity r100 = this.f273665b;
            r100.f273654i = true;
            r100.getClass();
            Intent r101 = new Intent();
            r101.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            r101.setData(Uri.fromParts("package", r100.getApplicationContext().getPackageName(), null));
            r100.startActivity(r101);
        }

        public d(FaceLoadingActivity r100, String r101) {
            this.f273665b = r100;
            this.f273664a = r101;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FaceLoadingActivity f273666a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f273666a.l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(FaceLoadingActivity r100) {
            this.f273666a = r100;
        }
    }

    @JvmStatic
    public static void g() {
        Intrinsics.checkNotNullParameter("toyger", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> toyger");
        com.bytedance.librarian.a.c("toyger");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> toyger");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class h() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.dtf.face.ocr.verify.DTFOcrFacade");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.dtf.face.ocr.verify.DTFOcrFacade");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.dtf.face.ocr.verify.DTFOcrFacade");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.dtf.face.ocr.verify.DTFOcrFacade");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.dtf.face.ocr.verify.DTFOcrFacade");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.dtf.face.ocr.verify.DTFOcrFacade");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.dtf.face.ocr.verify.DTFOcrFacade");
    }

    public final void l() {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        this.f273655j.post(new e(this));
        return;
    L6:
        AndroidClientConfig r100 = hs7.a.h().c();
        if (r100 == null) goto L134;
        HashMap<String, String> r101 = r100.suitable;
        if (r101 != null) goto L11;
        String r102 = "0";
    L33:
        Protocol r103 = hs7.a.h().f486994f;
        if (r103 == null) goto L45;
        ProtocolContent r104 = r103.protocolContent;
        if (r104 == null) goto L45;
        SolutionConfig r105 = r104.solutionConfig;
        if (r105 == null) goto L40;
        NavigatePage r106 = r105.navi;
    L41:
        if (r106 != null) goto L46;
        AndroidClientConfig r107 = r104.androidClientConfig;
        if (r107 == null) goto L46;
        r106 = r107.getNavi();
    L46:
        if (r106 == null) goto L135;
        if (r106.isEnable() == false) goto L50;
    L51:
        String r110 = r106.getUrl();
        if (TextUtils.isEmpty(r110) == true) goto L135;
        IDTLoadingFragment r108 = this.f273652g;
        if (r108 != null) goto L56;
    L91:
        this.f273652g.showAuthorizationView();
        this.f273652g.hideLoadingView();
        boolean r109 = true;
    L92:
        if (r109 == true) goto L94;
        return;
    L94:
        IDTLoadingFragment r111 = this.f273652g;
        if (r111 == null) goto L106;
        FrameLayout r112 = r111.getAuthorizationViewContainer();
        if (r112 != null) goto L99;
    L104:
        this.f273652g.hideAuthorizationView();
        this.f273652g.showLoadingView();
        goto L106
    L99:
        if (this.f273651f == null) goto L104;
        r112.removeAllViews();
        r112.addView(this.f273651f);
        if (this.f273648c == false) goto L103;
        this.f273646a = hs7.a.h().G;
        this.f273647b = true;
        this.f273648c = false;
        js7.b.b(getWindow(), this.f273646a, this.f273647b, this.f273648c);
    L103:
        this.f273652g.showAuthorizationView();
        this.f273652g.hideLoadingView();
    L106:
        if (this.f273651f == null) goto L135;
        if (r106.isNeedRareCharUi() == false) goto L110;
        g.f551540c = true;
    L110:
        this.f273651f.setHandler(this.f273655j);
        Uri.Builder r113 = UriProtector.parse(r110).buildUpon();
        r113.appendQueryParameter(IConstValues.DEVICE_TYPE, "android").appendQueryParameter(IConstValues.SUITABLE_TYPE_KEY, r102);
        String r114 = j.b().toLowerCase(Locale.ENGLISH);
        boolean r115 = p.f561092e.startsWith("zh");
        boolean r116 = r114.startsWith("zh");
        if (r115 == false) goto L113;
    L121:
        boolean r117 = true;
    L122:
        if (r117 == false) goto L124;
        String r118 = "zh-CN";
    L125:
        r113.appendQueryParameter(IConstValues.LANGUAGE, r118);
        Uri.Builder r119 = r113.appendQueryParameter("version", "2.3.43");
        String r120 = "YES";
        if (r106.isNeedRareCharUi() == false) goto L128;
        String r121 = "YES";
    L129:
        Uri.Builder r122 = r119.appendQueryParameter(IConstValues.RARECHARACTER, r121);
        if (r106.isEnable() == false) goto L132;
        r120 = "NO";
    L132:
        r122.appendQueryParameter(IConstValues.HIDEAGREEMENT, r120);
        String r123 = r113.toString();
        this.f273651f.loadUrl(r123);
        this.f273651f.setVisibility(0);
        RecordService.getInstance().recordEvent(2, "initToygerUI", new String[]{"startGuid", String.valueOf(r106.isEnable()), "url", r123});
        boolean r124 = true;
    L136:
        if (r124 == true) goto L147;
        RecordService.getInstance().recordEvent(2, "initToygerUI", new String[]{"startGuid", "false"});
        a();
        if (TextUtils.equals("2", r102) == false) goto L148;
        hs7.a.h().r("0");
        return;
    L148:
        return;
    L147:
        return;
    L128:
        r121 = "NO";
        goto L129
    L124:
        r118 = "en";
        goto L125
    L113:
        if (TextUtils.isEmpty(p.f561092e) == false) goto L116;
        if (r116 == true) goto L121;
    L116:
        if (TextUtils.isEmpty(p.f561092e) == true) goto L118;
    L120:
        r117 = false;
        goto L122
    L118:
        if (TextUtils.isEmpty(r114) == false) goto L120;
    L56:
        if (this.f273651f != null) goto L91;
        FrameLayout r125 = r108.getAuthorizationViewContainer();
        ToygerWebView r126 = new ToygerWebView(this, null);     // Catch: Exception -> L66
        this.f273651f = r126;     // Catch: Exception -> L66
        if (r125 == null) goto L91;
        r125.addView(r126);     // Catch: Exception -> L66
        if (g.f551540c == false) goto L91;
        ToygerWebView r127 = this.f273651f;     // Catch: Exception -> L66
        if (r127 == null) goto L91;
        r127.resumeTimers();     // Catch: Exception -> L66
    L66:
        e = move-exception;
        AndroidClientConfig r128 = hs7.a.h().c();
        if (r128 == null) goto L76;
        JSONObject r129 = r128.clientExtParams;
        if (r129 == null) goto L76;
        String r130 = r129.getString("ENABLE_ENV_PRIORITY");
        if (TextUtils.isEmpty(r130) == true) goto L76;
        boolean r131 = !"0".equals(r130);
    L77:
        RecordService r132 = RecordService.getInstance();
        String[] r133 = new String[4];
        r133[0] = "errMsg";
        r133[1] = RecordService.getStackTraceString(e);
        r133[2] = "ENABLE_ENV_PRIORITY";
        if (r128 == null) goto L82;
        String r134 = r128.clientExtParamStr;
        if (r134 == null) goto L82;
    L83:
        r133[3] = r134;
        r132.recordEvent(4, "initAuthWebviewError", r133);
        if (r131 == true) goto L86;
        r("Z1039");
    L90:
        r109 = false;
        goto L92
    L86:
        o();
        IDTLoadingFragment r135 = this.f273652g;
        if (r135 == null) goto L89;
        r135.hideLoadingView();
    L89:
        a();
    L82:
        r134 = "";
    L76:
        r131 = true;
        goto L77
    L50:
        if (r106.isNeedRareCharUi() == true) goto L51;
    L135:
        r124 = false;
        goto L136
    L40:
        r106 = null;
    L45:
        r106 = null;
        goto L46
    L11:
        if (r101.containsKey(IConstValues.SUITABLE_TYPE_KEY) == false) goto L28;
        TextUtils.SimpleStringSplitter r136 = new TextUtils.SimpleStringSplitter(':');
        ContentResolver r137 = getApplicationContext().getContentResolver();
        f06.c r138 = new f06.c();
        Object[] r139 = {r137, "enabled_accessibility_services"};
        f06.b r210 = new f06.b();
        f06.d r140 = r138.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r139, "java.lang.String", r210);
        if (r140.f474982a == false) goto L15;
        r138.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r139, null, r210, false);
        String r141 = (String) r140.f474983b;
    L16:
        if (r141 == null) goto L25;
        r136.setString(r141);
    L19:
        if (r136.hasNext() == false) goto L25;
        String r142 = r136.next();
        if (r142.contains("TalkBackService") == true) goto L24;
        if (r142.contains("ScreenReaderService") == false) goto L19;
    L24:
        boolean r143 = true;
    L26:
        if (r143 == true) goto L28;
        r102 = r100.suitable.get(IConstValues.SUITABLE_TYPE_KEY);
    L29:
        hs7.a.h().r(r102);
        if (TextUtils.equals(r102, "0") == true) goto L33;
        r100.suitable = (HashMap) JSON.parseObject(JSON.toJSON(r100.suitable).toString().replace("voiceUrl", "dtf").replace("voiceSig", "sigdtf"), HashMap.class);
    L25:
        r143 = false;
        goto L26
    L15:
        r141 = Settings.Secure.getString(r137, "enabled_accessibility_services");
        r138.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r139, r141, r210, true);
    L28:
        r102 = "0";
        goto L29
    L134:
        r102 = "0";
        goto L135
    }

    public final void o() {
        if (this.f273651f == null) goto L8;
        if (((ArrayList) b()).size() <= 0) goto L8;
        this.f273651f.setVisibility(8);
    L8:
        if (TextUtils.equals(hs7.a.h().k(), "1") == false) goto L10;
        RecordService.getInstance().recordEvent(2, "guidPage", new String[]{"action", "click auth", "suitable", "true"});
        return;
    L10:
        RecordService.getInstance().recordEvent(2, "guidPage", new String[]{"action", "click auth"});
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        ToygerWebView r100 = this.f273651f;
        boolean r101 = false;
        if (r100 == null) goto L24;
        String r102 = r100.getUrl();
        Protocol r103 = hs7.a.h().f486994f;
        NavigatePage r104 = null;
        if (r103 == null) goto L16;
        ProtocolContent r105 = r103.protocolContent;
        if (r105 == null) goto L16;
        SolutionConfig r106 = r105.solutionConfig;
        if (r106 == null) goto L11;
        r104 = r106.navi;
    L11:
        if (r104 != null) goto L16;
        AndroidClientConfig r107 = r105.androidClientConfig;
        if (r107 == null) goto L16;
        r104 = r107.getNavi();
    L16:
        if (r102 == null) goto L21;
        if (r104 == null) goto L21;
        if (r102.startsWith(r104.getUrl()) == true) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == false) goto L24;
        this.f273651f.goBack();
        r101 = true;
    L21:
        r108 = false;
    L24:
        if (r101 == false) goto L26;
        return;
    L26:
        m(2);
    }

    @Override // com.dtf.face.ui.FaceBaseActivity, android.app.Activity
    public final void onDestroy() {
        ToygerWebView r100 = this.f273651f;
        if (r100 == null) goto L5;
        r100.clearHistory();
        this.f273651f.destroy();
    L5:
        RecordService.getInstance().recordEvent(2, "lifeCycle", new String[]{"FaceLoadingActivity", LiveCommonConstants.REASON_ON_DEDTROY});
        super.onDestroy();
    }

    public FaceLoadingActivity() {
        this.f273653h = false;
        this.f273654i = false;
        this.f273655j = new Handler(new b(this));
    }

    @Override // com.dtf.face.ui.FaceBaseActivity
    public final boolean a() {
        boolean r100 = super.a();
        if (r100 == false) goto L5;
        p();
    L5:
        return r100;
    }

    @Override // com.dtf.face.ui.FaceBaseActivity
    public final boolean d() {
        if (hs7.a.h().f486997i == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.dtf.face.ui.FaceBaseActivity
    public final boolean e() {
        boolean r100 = false;
        if (hs7.a.h().m() == false) goto L6;
        return false;
    L6:
        if (hs7.a.h().o() == false) goto L10;
        h();     // Catch: Throwable -> L11
        r100 = true;
    L10:
        return !r100;
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0114 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dtf.face.ui.FaceBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L51;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public final Map<String, Object> n() {
        Intent r100 = getIntent();
        HashMap r101 = new HashMap();
        if (r100 == null) goto L10;
        String r102 = r100.getStringExtra("ext_params_key_screen_orientation");
        if (TextUtils.isEmpty(r102) == true) goto L7;
        r101.put("ext_params_key_screen_orientation", r102);
    L7:
        String r103 = r100.getStringExtra("comeFrom");
        if (TextUtils.isEmpty(r103) == true) goto L10;
        r101.put("comeFrom", r103);
    L10:
        AndroidClientConfig r104 = hs7.a.h().c();
        if (r104 != null) goto L13;
    L17:
        return r101;
    L13:
        if (r104.getAlgorithm() == null) goto L17;
        String r105 = r104.getAlgorithm().getString("liveness_combinations");
        if (r105 == null) goto L17;
        r101.put("isEquipmentCheck", String.valueOf(r105.contains(ToygerFaceAlgorithmConfig.ZFACE_EQUIPMENT_LIVENESS)));
        goto L17
    }

    @Override // com.dtf.face.ui.FaceBaseActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (g.f551540c == false) goto L8;
        ToygerWebView r100 = this.f273651f;
        if (r100 == null) goto L8;
        r100.resumeTimers();
    L8:
        if (this.f273653h == true) goto L56;
        this.f273653h = true;
        s.a(1);
        IDTLoadingFragment r101 = this.f273652g;
        if (r101 == null) goto L57;
        r101.setCloseCallBack(new us7.d(this));
        this.f273652g.showLoadingView();
        if ("arm64-v8a,armeabi-v7a,".contains(Build.CPU_ABI) == true) goto L14;
        EnvCheck$EnvErrorType r102 = EnvCheck$EnvErrorType.ENV_ERROR_UNSUPPORTED_CPU;
    L27:
        if (EnvCheck$EnvErrorType.ENV_SUCCESS != r102) goto L29;
        RecordService.getInstance().recordEvent(2, "enviromentCheck", new String[]{"result", "success"});
        String r103 = hs7.a.h().f486989a;
        if (r103 != null) goto L42;
        finish();
        return;
    L42:
        Intent r104 = getIntent();
        if (r104 != null) goto L45;
    L47:
        String r105 = "";
    L48:
        IDTLoadingFragment r106 = this.f273652g;
        if (r106 == null) goto L51;
        r106.showLoadingView();
    L51:
        RecordService.getInstance().recordEvent(2, "startNetInit", new String[]{"zimId", r103, "meta", r105});
        Map<String, Object> r107 = baseverify.d.a(r103, r105, new us7.e(this, r103));
        String r108 = hs7.a.h().g();
        if (TextUtils.isEmpty(r108) == true) goto L54;
        ((HashMap) r107).put("deviceToken", r108);
    L54:
        RecordService.getInstance().flush(false);
        hs7.a.h().O = "init";
        ls7.a.f().a(r107, (APICallback) ((HashMap) r107).get("callback"));
        return;
    L45:
        if (r104.hasExtra("toyger_meta_info") == false) goto L47;
        r105 = r104.getStringExtra("toyger_meta_info");
        goto L48
    L29:
        if (EnvCheck$EnvErrorType.ENV_ERROR_LOW_OS != r102) goto L32;
        q("Z1004");
    L38:
        RecordService.getInstance().recordEvent(2, "enviromentCheck", new String[]{"result", "false"});
        return;
    L32:
        if (EnvCheck$EnvErrorType.ENV_ERROR_NO_FRONT_CAMERA != r102) goto L35;
        q("Z1018");
        goto L38
    L35:
        if (EnvCheck$EnvErrorType.ENV_ERROR_UNSUPPORTED_CPU != r102) goto L37;
        q("Z1003");
        goto L38
    L37:
        q("Z1000");
        goto L38
    L14:
        String r109 = Build.VERSION.SDK;
        if (r109 != null) goto L17;
    L19:
        boolean r110 = false;
    L20:
        if (r110 == false) goto L23;
        r102 = EnvCheck$EnvErrorType.ENV_ERROR_LOW_OS;
        goto L27
    L23:
        if (baseverify.c.a(1) != (-1)) goto L25;
        r102 = EnvCheck$EnvErrorType.ENV_ERROR_NO_FRONT_CAMERA;
        goto L27
    L25:
        r102 = EnvCheck$EnvErrorType.ENV_SUCCESS;
        goto L27
    L17:
        if (CastIntegerProtector.parseInt(r109) >= 18) goto L19;
        r110 = true;
        goto L20
    L57:
        return;
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        RecordService.getInstance().recordEvent(2, "lifeCircle", new String[]{"FaceLoadingActivity", WidgetCostModule.TYPE_ON_START});
    }

    public final void p() {
        RecordService.getInstance().recordEvent(2, "androidPermssion", new String[]{"status", "permissions already granted, enter sdk", MapController.ANDROID_SDK_LAYER_TAG, String.valueOf(Build.VERSION.SDK_INT)});
        this.f273655j.sendEmptyMessage(909);
    }

    public static void i(FaceLoadingActivity r100) {
        r100.getClass();
        Message r101 = Message.obtain();
        r101.arg1 = 0;
        r101.what = 916;
        if (hs7.a.h().m() == false) goto L5;
        r100.f273655j.sendMessage(r101);
        return;
    L5:
        AndroidClientConfig r102 = hs7.a.h().c();
        List r103 = null;
        if (r102 == null) goto L15;
        JSONObject r104 = r102.clientExtParams;
        if (r104 == null) goto L15;
        String r105 = r104.getString("FORCE_MODEL_DOWNLOAD");
        if (r105 == null) goto L15;
        if (r105.equals(h.a("FORCE_MODEL_DOWNLOAD", null)) == true) goto L15;
        h.c("FORCE_MODEL_DOWNLOAD", r105);
        boolean r106 = true;
    L16:
        if (r106 == false) goto L18;
        o.e(r100);
    L18:
        AndroidClientConfig r107 = hs7.a.h().c();
        if (r107 == null) goto L28;
        JSONObject r108 = r107.clientExtParams;
        if (r108 == null) goto L28;
        String r109 = r108.getString("MODEL_FILES");
        if (TextUtils.isEmpty(r109) == true) goto L28;
        List r110 = (List) JSON.parseObject(r109, ArrayList.class);     // Catch: Throwable -> L27
    L29:
        AndroidClientConfig r111 = hs7.a.h().c();
        if (r111 == null) goto L38;
        JSONObject r112 = r111.clientExtParams;
        if (r112 == null) goto L38;
        String r113 = r112.getString("QUALITY_MODEL_FILES");
        if (TextUtils.isEmpty(r113) == true) goto L38;
        r103 = (List) JSON.parseObject(r113, ArrayList.class);     // Catch: Throwable -> L40
    L38:
        o.c(r100, r110, r103, false, new f(r100, r101));
        return;
    L28:
        r110 = null;
    L15:
        r106 = false;
        goto L16
    }

    public static /* synthetic */ boolean j(FaceLoadingActivity r100) {
        return super.a();
    }

    public static boolean k(FaceLoadingActivity r100) {
        r100.getClass();
        String r101 = "";
        if (hs7.a.h().o() == true) goto L5;
    L7:
        String r102 = "Z1056";
        String r103 = "";
    L9:
        if (TextUtils.isEmpty(r103) == false) goto L21;
        if (hs7.a.h().f486997i == null) goto L21;
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L15
        r104.append("com.dtf");     // Catch: Throwable -> L15
        r104.append(".wish");     // Catch: Throwable -> L15
        r104.append(".api");     // Catch: Throwable -> L15
        r104.append(".WishResponse");     // Catch: Throwable -> L15
        r.a(r104.toString());     // Catch: Throwable -> L15
        r104.setLength(0);     // Catch: Throwable -> L15
        r104.append("com.dtf");     // Catch: Throwable -> L15
        r104.append(".wish");     // Catch: Throwable -> L15
        r104.append(".ui");     // Catch: Throwable -> L15
        r104.append(".WishFragment");     // Catch: Throwable -> L15
        r.a(r104.toString());     // Catch: Throwable -> L15
        r104.setLength(0);     // Catch: Throwable -> L15
        r104.append("com.dtf");     // Catch: Throwable -> L15
        r104.append(".voice");     // Catch: Throwable -> L15
        r104.append(".api");     // Catch: Throwable -> L15
        r104.append(".IVoiceCallBack");     // Catch: Throwable -> L15
        r.a(r104.toString());     // Catch: Throwable -> L15
        String r105 = "";
    L18:
        if (TextUtils.isEmpty(r105) == true) goto L21;
        r103 = r103 + r105;
        r102 = "A4005";
    L15:
        th = move-exception;
        r105 = th.getMessage();
    L21:
        if (hs7.a.h().m() == false) goto L30;
        StringBuilder r106 = new StringBuilder();
        r.a("com.eidlink.idocr.sdk.EidLinkSE");     // Catch: ClassNotFoundException -> L25
        r.a("org.jmrtd.cbeff.BiometricDataBlock");     // Catch: ClassNotFoundException -> L25
        r.a("org.ejbca.cvc.PublicKeyEC");     // Catch: ClassNotFoundException -> L25
    L27:
        String r107 = r106.toString();
        if (TextUtils.isEmpty(r107) == true) goto L39;
        r103 = r103 + r107;
        r102 = "A4004";
    L39:
        if (TextUtils.isEmpty(r103) == true) goto L48;
        RecordService.getInstance().recordEvent(2, "proguardCheck", new String[]{"classNotFoundException", r103});
        r100.r(r102);
        return true;
    L48:
        return false;
    L25:
        e = move-exception;
        r106.append(e.getMessage());
        goto L27
    L30:
        StringBuilder r108 = new StringBuilder();
        r108.append("com.dtf.toyger.");     // Catch: ClassNotFoundException -> L33
        r108.append("base.");     // Catch: ClassNotFoundException -> L33
        r108.append("algorithm.");     // Catch: ClassNotFoundException -> L33
        r108.append("IToygerDelegate");     // Catch: ClassNotFoundException -> L33
        r.a(r108.toString());     // Catch: ClassNotFoundException -> L33
        r108.setLength(0);     // Catch: ClassNotFoundException -> L33
        r108.append("com.dtf.toyger.");     // Catch: ClassNotFoundException -> L33
        r108.append("base.");     // Catch: ClassNotFoundException -> L33
        r108.append("doc.");     // Catch: ClassNotFoundException -> L33
        r108.append("ToygerDocAlgorithmConfig");     // Catch: ClassNotFoundException -> L33
        r.a(r108.toString());     // Catch: ClassNotFoundException -> L33
        r108.setLength(0);     // Catch: ClassNotFoundException -> L33
        r108.append("com.dtf.toyger.");     // Catch: ClassNotFoundException -> L33
        r108.append("base.");     // Catch: ClassNotFoundException -> L33
        r108.append("ToygerLogger");     // Catch: ClassNotFoundException -> L33
        r.a(r108.toString());     // Catch: ClassNotFoundException -> L33
        r108.setLength(0);     // Catch: ClassNotFoundException -> L33
        r108.append("com.dtf.toyger.");     // Catch: ClassNotFoundException -> L33
        r108.append("base.");     // Catch: ClassNotFoundException -> L33
        r108.append("ToygerLog");     // Catch: ClassNotFoundException -> L33
        r.a(r108.toString());     // Catch: ClassNotFoundException -> L33
        r108.setLength(0);     // Catch: ClassNotFoundException -> L33
        r108.append("com.dtf.toyger.");     // Catch: ClassNotFoundException -> L33
        r108.append("base.");     // Catch: ClassNotFoundException -> L33
        r108.append("face.");     // Catch: ClassNotFoundException -> L33
        r108.append("FaceBlobManager");     // Catch: ClassNotFoundException -> L33
        r.a(r108.toString());     // Catch: ClassNotFoundException -> L33
    L36:
        if (TextUtils.isEmpty(r101) == true) goto L39;
        r103 = r103 + r101;
        r102 = "A4001";
    L33:
        e = move-exception;
        r101 = e.getMessage();
        goto L36
    L5:
        if (TextUtils.isEmpty(r.b()) == true) goto L7;
        r103 = "" + r.b();
        r102 = "A4003";
        goto L9
    }

    @Override // com.dtf.face.ui.FaceBaseActivity
    public final void f(List<String> r100) {
        if (((ArrayList) r100).size() > 0) goto L5;
        this.f273655j.sendEmptyMessage(909);
        return;
    L5:
        if ("android.permission.RECORD_AUDIO".equals(ListProtector.get(r100, 0)) == false) goto L7;
        String r101 = "Z1030";
    L8:
        s(r101, new d(this, r101));
        return;
    L7:
        r101 = "Z1019";
        goto L8
    }

    public final void m(int r110) {
        if (hs7.a.h().f486997i == null) goto L5;
        boolean r100 = true;
    L6:
        String r101 = "homeBack";
        String r102 = "Z1008";
        if (this.f273652g != null) goto L11;
        RecordService.getInstance().recordEvent(2, "userBack", new String[]{"type", "homeBack", "msg", "mLoadingFragment is null"});
        q("Z1008");
        return;
    L11:
        if (r100 == false) goto L13;
        String r103 = p.k(this, "wishExitAsk", R.string.dtf_wish_dlg_exit_title);
        String r104 = p.k(this, "wishExitMsgAsk", R.string.dtf_wish_dlg_exit_msg);
    L14:
        String r105 = r103;
        String r106 = r104;
        if (r100 == false) goto L17;
        String r107 = p.k(this, "msgBoxExit", R.string.dtf_wish_dlg_exit);
    L18:
        String r111 = r107;
        if (r100 == false) goto L21;
        String r108 = p.k(this, "wishExitAsk", R.string.dtf_wish_dlg_exit_cancel);
    L22:
        String r112 = r108;
        if (r110 == 0) goto L26;
        if (r110 == 2) goto L27;
        r101 = "uiBack";
    L27:
        MemoryService.getInstance().trigger(r102);
        this.f273652g.showMessageBox(r105, r106, r111, r112, "Z1008", new a(this, r101, r102));
        return;
    L26:
        r101 = "guidPageClose";
        r102 = "Z1009";
        goto L27
    L21:
        r108 = p.h(this, R.string.dtf_message_box_btn_cancel_tip, "dialogExitCancel");
        goto L22
    L17:
        r107 = p.h(this, R.string.dtf_message_box_btn_ok_tip, "dialogExitConfirm");
        goto L18
    L13:
        r103 = p.h(this, R.string.dtf_message_box_title_exit_tip, "dialogExitTitle");
        r104 = p.h(this, R.string.dtf_message_box_message_exit_tip, "dialogExitMsg");
        goto L14
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.dtf.face.ui.FaceBaseActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        boolean r101 = ws7.c.f561063b.needTransparentLoading(this);
        this.f273648c = ws7.c.f561063b.hasLoadingPageColor();
        this.f273647b = ws7.c.f561063b.isLightStatusBar();
        if (r101 == true) goto L13;
    L15:
        setTheme(R.style.DtfToygerLoadingAppTheme);
        RecordService.getInstance().recordEvent(2, "loadingTheme", new String[]{"isTransparent", String.valueOf(false)});
    L16:
        super.onCreate(r100);
        if (r101 == true) goto L65;
    L67:
        String r102 = Locale.getDefault().toLanguageTag();     // Catch: Throwable -> L25
    L26:
        FaceBaseActivity.f273645d = r102;
        RecordService.getInstance().recordEvent(2, "lifeCycle", new String[]{"FaceLoadingActivity", WidgetCostModule.TYPE_ON_CREATE});
        IDTLoadingFragment r103 = null;
        SgomInfoManager.updateSgomInfo(-940345500, null);
        this.f273650e = new FrameLayout(this);
        this.f273650e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f273650e.setId(android.R.id.primary);
        this.f273650e.setBackgroundColor(ws7.c.f561063b.getLoadingPageColor(this, R.color.dtf_guide_loading_page_default));
        setContentView(this.f273650e);
        setContentView(this.f273650e);
        if (this.f273650e == null) goto L57;
        Class r104 = hs7.a.h().f487004p;
        int r105 = this.f273650e.getId();
        if (r104 != null) goto L75;
        r104 = FaceLoadingFragment.class;
    L75:
        String r106 = getClass().getSimpleName() + ":" + r105;     // Catch: Exception -> L50
        FragmentManager r107 = getFragmentManager();     // Catch: Exception -> L50
        FragmentTransaction r108 = r107.beginTransaction();     // Catch: Exception -> L50
        Fragment r109 = r107.findFragmentByTag(r106);     // Catch: Exception -> L50
        if (r109 != null) goto L34;
        Fragment r110 = (Fragment) r104.newInstance();     // Catch: Exception -> L48
        r110.setArguments(FaceBaseActivity.c(getIntent()));     // Catch: Exception -> L46
        r108.replace(r105, r110, r106);     // Catch: Exception -> L46
        r109 = r110;
    L44:
        r108.commitAllowingStateLoss();     // Catch: Exception -> L48
    L54:
        if ((r109 instanceof IDTLoadingFragment) == false) goto L56;
        r103 = (IDTLoadingFragment) r109;
    L58:
        this.f273652g = r103;
        if (r103 == null) goto L61;
        r103.onUILoadSuccess();
        return;
    L61:
        r("Z7001");
        return;
    L56:
        RecordService.getInstance().recordEvent(2, "ToygerLoadingInit", new String[]{"msg", "Invalid Clz"});
    L46:
        Exception e100 = e;
    L52:
        RecordService.getInstance().recordException(e100);
        r109 = r110;
        goto L54
    L34:
        if (r109.getArguments() == null) goto L71;
        r109.getArguments().putAll(FaceBaseActivity.c(getIntent()));     // Catch: Exception -> L48
    L40:
        r108.attach(r109);     // Catch: Exception -> L48
        goto L44
    L71:
        r109.setArguments(FaceBaseActivity.c(getIntent()));     // Catch: Exception -> L37
    L37:
        e = move-exception;
        RecordService.getInstance().recordException(e);     // Catch: Exception -> L48
    L48:
        e = move-exception;
        e100 = e;
        r110 = r109;
    L50:
        e = move-exception;
        e100 = e;
        r110 = null;
        goto L52
    L57:
        RecordService.getInstance().recordEvent(2, "ToygerLoadingInit", new String[]{"msg", "Container Null"});
    L25:
        r102 = "";
        goto L26
    L65:
        overridePendingTransition(R.anim.dtf_fade_in, R.anim.dtf_fade_out);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L67
    L13:
        if (Build.VERSION.SDK_INT == 26) goto L15;
        this.f273646a = true;
        setTheme(R.style.DtfToygerTransLoadingAppTheme);
        RecordService.getInstance().recordEvent(2, "loadingTheme", new String[]{"isTransparent", String.valueOf(true)});
        goto L16
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (this.f273654i == false) goto L7;
        if (r100 == false) goto L8;
        this.f273655j.post(new c(this));
        this.f273654i = false;
        return;
    L8:
        return;
    }

    public final void q(String r100) {
        Message r101 = Message.obtain();
        r101.what = 903;
        r101.obj = r100;
        this.f273655j.sendMessage(r101);
    }

    public final void r(String r100) {
        RecordService.getInstance().recordEvent(2, "LoadingActivityFinish", new String[]{"status", "exit"});
        finish();
        hs7.a.h().a(r100, null);
    }

    public final boolean s(String r110, IDTLoadingFragment.IMessageBoxCB r111) {
        if (this.f273652g != null) goto L6;
        return false;
    L6:
        if ("Z1025".equals(r110) == false) goto L8;
    L53:
        this.f273652g.showMessageBox(p.h(this, R.string.dtf_message_box_title_network, "dialogNetworkFailedTitle"), p.h(this, R.string.dtf_message_box_message_network, "dialogNetworkFailedMsg"), p.h(this, R.string.dtf_message_box_btn_ok_tip, "dialogNetworkFailedConfirm"), null, r110, r111);
        return true;
    L8:
        if ("Z1011".equals(r110) == true) goto L53;
        if ("Z1012".equals(r110) == true) goto L53;
        if ("Z1028".equals(r110) == true) goto L53;
        if ("Z1040".equals(r110) == true) goto L53;
        if ("Z1002".equals(r110) == true) goto L47;
        if ("Z1021".equals(r110) == true) goto L47;
        if ("Z1018".equals(r110) == true) goto L47;
        if ("Z1004".equals(r110) == true) goto L47;
        if ("Z1003".equals(r110) == true) goto L47;
        if ("Z1029".equals(r110) == false) goto L32;
        this.f273652g.showMessageBox(p.k(this, "wishSysNotSupport", R.string.dtf_wish_message_box_title_sys_not_support), p.k(this, "wishSysVersionNotSupport", R.string.dtf_wish_message_box_message_screen_not_support), p.k(this, "oKTip", R.string.dtf_message_box_btn_ok_tip), null, r110, r111);
        return true;
    L32:
        if ("Z1019".equals(r110) == true) goto L42;
        if ("Z1030".equals(r110) == true) goto L42;
        if ("Z1034".equals(r110) == false) goto L40;
        this.f273652g.showMessageBox(p.k(this, "wishFailedTitle", R.string.dtf_wish_message_box_title_failed), p.k(this, "wishMemFailedMsg", R.string.dtf_wish_message_box_message_space_not_enough), p.k(this, "msgBoxExit", R.string.dtf_message_box_btn_exit), null, r110, r111);
        return true;
    L40:
        return false;
    L42:
        if (hs7.a.h().f486997i == null) goto L44;
        this.f273652g.showMessageBox(p.k(this, "wishFailedTitle", R.string.dtf_permission_warm_tip), p.k(this, "wishPermFailedMsg", R.string.dtf_wish_message_box_message_permission_not_granted), p.k(this, "oKTip", R.string.dtf_permission_setting), p.k(this, "", R.string.dtf_permission_setting_refuse), r110, r111);
    L45:
        return true;
    L44:
        this.f273652g.showMessageBox(p.h(this, R.string.dtf_permission_warm_tip, "dialogPermissionFailedTitle"), p.h(this, R.string.dtf_camera_permission_open_hint, "dialogPermissionFailedMsg"), p.h(this, R.string.dtf_permission_setting, "dialogPermissionFailedConfirm"), p.k(this, "", R.string.dtf_permission_setting_refuse), r110, r111);
    L47:
        if (hs7.a.h().f486997i != null) goto L49;
    L51:
        this.f273652g.showMessageBox(p.h(this, R.string.dtf_message_box_title_not_support, "dialogSupportFailedTitle"), p.h(this, R.string.dtf_message_box_message_not_support, "dialogSupportFailedMsg"), p.h(this, R.string.dtf_message_box_btn_ok_tip, "dialogSupportFailedConfirm"), null, r110, r111);
    L52:
        return true;
    L49:
        if ("Z1004".equals(r110) == false) goto L51;
        this.f273652g.showMessageBox(p.k(this, "wishSysFailedTitle", R.string.dtf_wish_message_box_title_sys_not_support), p.k(this, "wishSysFailedMsg", R.string.dtf_wish_message_box_message_system_not_support), p.k(this, "oKTip", R.string.dtf_message_box_btn_ok_tip), null, r110, r111);
        goto L52
    }
}
