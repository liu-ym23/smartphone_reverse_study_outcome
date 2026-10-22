package com.ss.android.lark.chameleonv2.lkapi.manifest;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.domain.IDomain$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.env.IEnv$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.featuregating.IFeatureGating$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.passport.IPassport$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.transport.ITransport$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.window.IWindow$Internal$Property;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J\t\u00108\u001a\u00020\u0013HÆ\u0003J\t\u00109\u001a\u00020\u0015HÆ\u0003J\t\u0010:\u001a\u00020\u0017HÆ\u0003Jw\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020CHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006D"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalInternalProperty;", "Lcom/bytedance/ee/util/io/NonProguard;", "app", "Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Property;", "base", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$InternalBaseProperty;", "domain", "Lcom/ss/android/lark/chameleonv2/lkapi/domain/IDomain$Internal$Property;", "env", "Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Internal$Property;", "featureGating", "Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$Property;", "passport", "Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$Internal$Property;", "resource", "Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$Property;", CameraParam.TYPE_SYSTEM_CAMERA, "Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Internal$Property;", NotificationCompat.CATEGORY_TRANSPORT, "Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Property;", "webview", "Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Internal$Property;", LiveEndPageData.TAG_WINDOW, "Lcom/ss/android/lark/chameleonv2/lkapi/window/IWindow$Internal$Property;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$InternalBaseProperty;Lcom/ss/android/lark/chameleonv2/lkapi/domain/IDomain$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/window/IWindow$Internal$Property;)V", "getApp", "()Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Property;", "getBase", "()Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$InternalBaseProperty;", "getDomain", "()Lcom/ss/android/lark/chameleonv2/lkapi/domain/IDomain$Internal$Property;", "getEnv", "()Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Internal$Property;", "getFeatureGating", "()Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$Property;", "getPassport", "()Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$Internal$Property;", "getResource", "()Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$Property;", "getSystem", "()Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Internal$Property;", "getTransport", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Property;", "getWebview", "()Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Internal$Property;", "getWindow", "()Lcom/ss/android/lark/chameleonv2/lkapi/window/IWindow$Internal$Property;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$GlobalInternalProperty implements NonProguard {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private final IApp$Internal$Property f411436app;
    private final IManifest$InternalBaseProperty base;
    private final IDomain$Internal$Property domain;
    private final IEnv$Internal$Property env;
    private final IFeatureGating$Internal$Property featureGating;
    private final IPassport$Internal$Property passport;
    private final IResource$Internal$Property resource;
    private final ISystem$Internal$Property system;
    private final ITransport$Internal$Property transport;
    private final IWebview$Internal$Property webview;
    private final IWindow$Internal$Property window;

    public static /* synthetic */ IManifest$GlobalInternalProperty copy$default(IManifest$GlobalInternalProperty r110, IApp$Internal$Property r111, IManifest$InternalBaseProperty r112, IDomain$Internal$Property r113, IEnv$Internal$Property r114, IFeatureGating$Internal$Property r115, IPassport$Internal$Property r116, IResource$Internal$Property r117, ISystem$Internal$Property r210, ITransport$Internal$Property r211, IWebview$Internal$Property r212, IWindow$Internal$Property r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        IApp$Internal$Property r100 = r110.f411436app;
    L7:
        if ((r214 & 2) == 0) goto L9;
        IManifest$InternalBaseProperty r101 = r110.base;
    L11:
        if ((r214 & 4) == 0) goto L13;
        IDomain$Internal$Property r102 = r110.domain;
    L15:
        if ((r214 & 8) == 0) goto L17;
        IEnv$Internal$Property r103 = r110.env;
    L19:
        if ((r214 & 16) == 0) goto L21;
        IFeatureGating$Internal$Property r104 = r110.featureGating;
    L23:
        if ((r214 & 32) == 0) goto L25;
        IPassport$Internal$Property r105 = r110.passport;
    L27:
        if ((r214 & 64) == 0) goto L29;
        IResource$Internal$Property r106 = r110.resource;
    L31:
        if ((r214 & 128) == 0) goto L33;
        ISystem$Internal$Property r107 = r110.system;
    L35:
        if ((r214 & 256) == 0) goto L37;
        ITransport$Internal$Property r118 = r110.transport;
    L39:
        if ((r214 & 512) == 0) goto L41;
        IWebview$Internal$Property r119 = r110.webview;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        IWindow$Internal$Property r108 = r110.window;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final IApp$Internal$Property component1() {
        return this.f411436app;
    }

    public final IWebview$Internal$Property component10() {
        return this.webview;
    }

    public final IWindow$Internal$Property component11() {
        return this.window;
    }

    public final IManifest$InternalBaseProperty component2() {
        return this.base;
    }

    public final IDomain$Internal$Property component3() {
        return this.domain;
    }

    public final IEnv$Internal$Property component4() {
        return this.env;
    }

    public final IFeatureGating$Internal$Property component5() {
        return this.featureGating;
    }

    public final IPassport$Internal$Property component6() {
        return this.passport;
    }

    public final IResource$Internal$Property component7() {
        return this.resource;
    }

    public final ISystem$Internal$Property component8() {
        return this.system;
    }

    public final ITransport$Internal$Property component9() {
        return this.transport;
    }

    public final IManifest$GlobalInternalProperty copy(IApp$Internal$Property r110, IManifest$InternalBaseProperty r111, IDomain$Internal$Property r112, IEnv$Internal$Property r113, IFeatureGating$Internal$Property r114, IPassport$Internal$Property r115, IResource$Internal$Property r210, ISystem$Internal$Property r211, ITransport$Internal$Property r212, IWebview$Internal$Property r213, IWindow$Internal$Property r214) {
        Intrinsics.checkNotNullParameter(r110, "app");
        Intrinsics.checkNotNullParameter(r111, "base");
        Intrinsics.checkNotNullParameter(r112, "domain");
        Intrinsics.checkNotNullParameter(r113, "env");
        Intrinsics.checkNotNullParameter(r114, "featureGating");
        Intrinsics.checkNotNullParameter(r115, "passport");
        Intrinsics.checkNotNullParameter(r210, "resource");
        Intrinsics.checkNotNullParameter(r211, CameraParam.TYPE_SYSTEM_CAMERA);
        Intrinsics.checkNotNullParameter(r212, NotificationCompat.CATEGORY_TRANSPORT);
        Intrinsics.checkNotNullParameter(r213, "webview");
        Intrinsics.checkNotNullParameter(r214, LiveEndPageData.TAG_WINDOW);
        return new IManifest$GlobalInternalProperty(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IManifest$GlobalInternalProperty) == true) goto L8;
        return false;
    L8:
        IManifest$GlobalInternalProperty r101 = (IManifest$GlobalInternalProperty) r100;
        if (Intrinsics.areEqual(this.f411436app, r101.f411436app) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.base, r101.base) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.domain, r101.domain) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.env, r101.env) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.featureGating, r101.featureGating) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.passport, r101.passport) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.resource, r101.resource) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.system, r101.system) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.transport, r101.transport) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.webview, r101.webview) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.window, r101.window) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((this.f411436app.hashCode() * 31) + this.base.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.env.hashCode()) * 31) + this.featureGating.hashCode()) * 31) + this.passport.hashCode()) * 31) + this.resource.hashCode()) * 31) + this.system.hashCode()) * 31) + this.transport.hashCode()) * 31) + this.webview.hashCode()) * 31) + this.window.hashCode();
    }

    public String toString() {
        return "GlobalInternalProperty(app=" + this.f411436app + ", base=" + this.base + ", domain=" + this.domain + ", env=" + this.env + ", featureGating=" + this.featureGating + ", passport=" + this.passport + ", resource=" + this.resource + ", system=" + this.system + ", transport=" + this.transport + ", webview=" + this.webview + ", window=" + this.window + ')';
    }

    public final IApp$Internal$Property getApp() {
        return this.f411436app;
    }

    public final IManifest$InternalBaseProperty getBase() {
        return this.base;
    }

    public final IDomain$Internal$Property getDomain() {
        return this.domain;
    }

    public final IEnv$Internal$Property getEnv() {
        return this.env;
    }

    public final IFeatureGating$Internal$Property getFeatureGating() {
        return this.featureGating;
    }

    public final IPassport$Internal$Property getPassport() {
        return this.passport;
    }

    public final IResource$Internal$Property getResource() {
        return this.resource;
    }

    public final ISystem$Internal$Property getSystem() {
        return this.system;
    }

    public final ITransport$Internal$Property getTransport() {
        return this.transport;
    }

    public final IWebview$Internal$Property getWebview() {
        return this.webview;
    }

    public final IWindow$Internal$Property getWindow() {
        return this.window;
    }

    public IManifest$GlobalInternalProperty(IApp$Internal$Property r100, IManifest$InternalBaseProperty r101, IDomain$Internal$Property r102, IEnv$Internal$Property r103, IFeatureGating$Internal$Property r104, IPassport$Internal$Property r105, IResource$Internal$Property r106, ISystem$Internal$Property r107, ITransport$Internal$Property r110, IWebview$Internal$Property r111, IWindow$Internal$Property r112) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "base");
        Intrinsics.checkNotNullParameter(r102, "domain");
        Intrinsics.checkNotNullParameter(r103, "env");
        Intrinsics.checkNotNullParameter(r104, "featureGating");
        Intrinsics.checkNotNullParameter(r105, "passport");
        Intrinsics.checkNotNullParameter(r106, "resource");
        Intrinsics.checkNotNullParameter(r107, CameraParam.TYPE_SYSTEM_CAMERA);
        Intrinsics.checkNotNullParameter(r110, NotificationCompat.CATEGORY_TRANSPORT);
        Intrinsics.checkNotNullParameter(r111, "webview");
        Intrinsics.checkNotNullParameter(r112, LiveEndPageData.TAG_WINDOW);
        this.f411436app = r100;
        this.base = r101;
        this.domain = r102;
        this.env = r103;
        this.featureGating = r104;
        this.passport = r105;
        this.resource = r106;
        this.system = r107;
        this.transport = r110;
        this.webview = r111;
        this.window = r112;
    }
}
