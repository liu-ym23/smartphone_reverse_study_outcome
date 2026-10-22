package z0b;

import android.app.Application;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.versionedparcelable.VersionedParcel;
import com.alibaba.fastjson.JSON;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.LKAPIWebviewPlugin;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Internal$Paths;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Property;
import com.ss.android.lark.chameleonv2.lkapi.domain.IDomain$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.env.IEnv$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.env.IEnv$Property;
import com.ss.android.lark.chameleonv2.lkapi.featuregating.IFeatureGating$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$AllManifest;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$GlobalInternalProperty;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$GlobalManifest;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$InternalBaseProperty;
import com.ss.android.lark.chameleonv2.lkapi.passport.IPassport$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Internal$KaConfig;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$DeviceType;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Internal$Paths;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Property;
import com.ss.android.lark.chameleonv2.lkapi.transport.ITransport$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$VisibilityState;
import com.ss.android.lark.chameleonv2.lkapi.window.IWindow$Internal$Property;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.utils.di.m;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ntb.l;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements l {
    public d() {
    }

    @Override // ntb.l
    public final f R() {
        return new f();
    }

    @Override // ntb.l
    public final LKAPIWebviewPlugin f0() {
        return new LKAPIWebviewPlugin();
    }

    @Override // ntb.l
    public final i m() {
        return new i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ntb.l
    public final String z(boolean r410, Boolean r510) {
        if (TextUtils.isEmpty(g.f569650a) == false) goto L41;
        Application r100 = LarkContext.getApplication();
        int r101 = swb.j.f543775a;
        InputStream r102 = r100.getAssets().open("lark-api-injected@7.53.0.js");     // Catch: Throwable -> L22 Exception -> L24
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102));     // Catch: Throwable -> L18 Exception -> L20
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L18 Exception -> L20
    L7:
        String r105 = r103.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r105 == null) goto L12;
        if (r105.matches("^\\s*\\/\\/.*") == true) goto L12;
        r104.append(r105);     // Catch: Throwable -> L18 Exception -> L20
    L12:
        if (r105 != null) goto L7;
        r103.close();     // Catch: Throwable -> L18 Exception -> L20
        r102.close();     // Catch: Throwable -> L18 Exception -> L20
        String r106 = r104.toString();     // Catch: Throwable -> L18 Exception -> L20
        r102.close();     // Catch: IOException -> L16
    L33:
        g.f569650a = r106;
    L16:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());
    L20:
        e = e;
    L26:
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());     // Catch: Throwable -> L18
        if (r102 != null) goto L99;
    L32:
        r106 = null;
        goto L33
    L99:
        r102.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());
        goto L32
    L18:
        th = move-exception;
        Throwable r107 = th;
        VersionedParcel.AnonymousClass1 r108 = "lark-api-injected@7.53.0.js";
    L35:
        if (r108 == 0) goto L107;
        r108.close();     // Catch: IOException -> L38
        throw r107;
    L38:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());
        throw r107;
    L107:
        throw r107;
    L24:
        e = e;
        r102 = null;
    L22:
        th = move-exception;
        r107 = th;
        r108 = 0;
    L41:
        int r109 = a1b.a.f1403a;
        IApp$Property r110 = new IApp$Property(AudioStats.AUDIO_AMPLITUDE_NONE);
        int r111 = d1b.a.f466493a;
        Application r112 = LarkContext.getApplication();
        boolean r210 = PackageChannelManager.isKABuildPackage(r112);
        if (r210 == false) goto L44;
        String r113 = PackageChannelManager.getBuildPackageChannel(r112);
    L45:
        String r211 = r113;
        int r114 = PackageChannelManager.getDeployMode(r112);
        if (r114 != 1) goto L48;
        String r115 = "saas";
    L56:
        String r116 = r115;
        String r117 = PackageChannelManager.getBuildPackageChannel(r112);
        LarkAppContext.Companion.getClass();
        int r118 = LarkAppContext.access$getInstance$cp().appIdInfo().f18218a;
        int r119 = m.f437228a;
        boolean r310 = m.a.a().isBoe();
        ArrayList r120 = new ArrayList();
        boolean r212 = DevEnvUtil.isDevelopPackage(r112);
        yob.e.a().getClass();
        int r121 = com.ss.android.lark.language.service.impl.a.f431092f;
        apb.b r311 = com.ss.android.lark.language.service.impl.a.b.f431098a;
        boolean r213 = r311.isGooglePlay();
        Intrinsics.checkNotNull(r211);
        IEnv$Property r122 = new IEnv$Property(r117, r118, false, "", "", "", "", r310, false, "", r120, r116, false, false, r212, r210, false, true, r213, r211, "", "", "release", r112.getPackageName(), "", ApkUtil.getUpdateVersionCode(r112));
        yob.e.a().getClass();
        Locale r123 = r311.getLanguageSetting();
        String r124 = swb.l.a(r123.getCountry(), r123.getLanguage());
        Intrinsics.checkNotNull(r124);
        String r125 = "";
        IApp$Internal$Property r126 = new IApp$Internal$Property(r124, "", new IApp$Internal$Paths("", "", "", "", "", ""), ApkUtil.getAppVersionName(LarkContext.getApplication()));
        IManifest$InternalBaseProperty r127 = new IManifest$InternalBaseProperty((ArrayList) CollectionsKt.toCollection(LKAPIModules.INSTANCE.getAllValue(), new ArrayList()), new HashMap());
        int r128 = c1b.a.f22109c;
        IDomain$Internal$Property r312 = c1b.a.C0390a.a();
        IEnv$Internal$Property r129 = new IEnv$Internal$Property(true, 5000);
        int r130 = e1b.a.f470755c;
        IFeatureGating$Internal$Property r411 = e1b.a.C5730a.a();
        int r131 = i1b.a.f488018a;
        String r132 = m.a.a().getDeviceId();
        if (r132 != null) goto L59;
        r132 = "";
    L59:
        String r133 = m.a.a().getUserId();
        if (r133 != null) goto L62;
        r133 = "";
    L62:
        IPassport$Internal$Property r134 = new IPassport$Internal$Property(r132, r133);
        int r135 = j1b.b.f496886c;
        IResource$Internal$Property r136 = new IResource$Internal$Property(new IResource$Internal$KaConfig("", new HashMap(), new HashMap()));
        int r137 = m1b.a.f511620c;
        ISystem$Internal$Property r138 = new ISystem$Internal$Property(new ISystem$Internal$Paths("", "", "", ""));
        int r139 = com.ss.android.lark.chameleonv2.lkapi.transport.c.f411457c;
        ITransport$Internal$Property r140 = new ITransport$Internal$Property(y9c.d.h(R.string.Lark_Legacy_ErrorMessageTip));
        int r141 = r1b.a.f535683a;
        if (r410 == false) goto L65;
        IWebview$VisibilityState r142 = IWebview$VisibilityState.Visible;
    L66:
        IWebview$Internal$Property r143 = new IWebview$Internal$Property(r142);
        int r144 = t1b.a.f544218a;
        IManifest$GlobalInternalProperty r145 = new IManifest$GlobalInternalProperty(r126, r127, r312, r129, r411, r134, r136, r138, r140, r143, new IWindow$Internal$Property(""));
        if (Intrinsics.areEqual(r510, Boolean.TRUE) == false) goto L69;
        float r146 = 18.0f;
    L70:
        boolean r147 = false;
        String r148 = JSON.toJSONString(new IManifest$AllManifest(new IManifest$GlobalManifest(r110, r122, r145, new ISystem$Property("Android", ISystem$DeviceType.Phone, r146, 0))));
        if (TextUtils.isEmpty(g.f569650a) == false) goto L73;
        return "";
    L73:
        if (TextUtils.isEmpty(r148) == true) goto L110;
        StringBuilder r149 = new StringBuilder();
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication().getApplicationContext()) == false) goto L90;
        vzb.a r150 = (vzb.a) ClaymoreServiceLoader.loadFirst(vzb.a.class);
        if (r150 == null) goto L81;
        String r151 = r150.a();
    L82:
        if (r151 != null) goto L84;
    L85:
        r147 = true;
    L87:
        if (r147 == false) goto L89;
        com.ss.android.lark.officesdk.utils.di.j.e("LKAPILoader", "ttFeatureEnv empty, refuse x-tt-env Inject");
        goto L90
    L89:
        com.ss.android.lark.officesdk.utils.di.j.e("LKAPILoader", "x-tt-env injected: " + r151);
        r125 = "(function () {\n                      var originalOpen = XMLHttpRequest.prototype.open;\n                      var originalSetRequestHeader = XMLHttpRequest.prototype.setRequestHeader;\n                      var originalSend = XMLHttpRequest.prototype.send;\n                      XMLHttpRequest.prototype.open = function (method, url) {\n                        // 记录是否已有 x-tt-env\n                        this._hasXttEnv = false;\n                    \n                        // 包一层 setRequestHeader，用来侦测用户是否设置了 x-tt-env\n                        var xhr = this;\n                        this.setRequestHeader = function (name, value) {\n                          if (String(name).toLowerCase() === 'x-tt-env') {\n                            xhr._hasXttEnv = true;\n                          }\n                          return originalSetRequestHeader.apply(this, arguments);\n                        };\n                    \n                        return originalOpen.apply(this, arguments);\n                      };\n                      XMLHttpRequest.prototype.send = function () {\n                        // 最终注入点：只有当用户没设置过时才补\n                        if (!this._hasXttEnv) {\n                          originalSetRequestHeader.call(this, 'x-tt-env', '" + r151 + "');\n                        }\n                        return originalSend.apply(this, arguments);\n                      };\n                      var originalFetch = window.fetch;\n                    \n                      window.fetch = function (input, init) {\n                        init = init || {};\n                        init.headers = init.headers || {};\n                        if (globalThis.Headers && init.headers instanceof globalThis.Headers) {\n                          if (!init.headers.has('x-tt-env')) {\n                            init.headers.append('x-tt-env', '" + r151 + "');\n                          }\n                        } else {\n                          var hasXttEnv = Object.keys(init.headers)\n                            .some(k => k.toLowerCase() === 'x-tt-env');\n                          if (!hasXttEnv) {\n                            init.headers['x-tt-env'] = '" + r151 + "';\n                          }\n                        }\n                        return originalFetch(input, init);\n                      };\n                    })();\n            ";
        goto L90
    L84:
        if (r151.length() != 0) goto L87;
    L81:
        r151 = null;
    L90:
        r149.append(r125);
        r149.append("; globalThis.LarkAPIInternalManifest=");
        r149.append(r148);
        r149.append("; ");
        r149.append(g.f569650a);
        return r149.toString();
    L110:
        return "";
    L69:
        r146 = UIUtils.px2dp(LarkContext.getApplication(), DeviceUtils.getStatusHeight(LarkContext.getApplication()));
        goto L70
    L65:
        r142 = IWebview$VisibilityState.Hidden;
        goto L66
    L48:
        if (r114 != 2) goto L50;
        r115 = "hosted";
        goto L56
    L50:
        if (r114 != 3) goto L53;
        r115 = "on_premise";
        goto L56
    L53:
        throw new IllegalArgumentException("Unknown deploy mode");
    L44:
        r113 = "sass";
        goto L45
    }
}
