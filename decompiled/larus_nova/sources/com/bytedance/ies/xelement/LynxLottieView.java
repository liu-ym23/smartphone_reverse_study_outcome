package com.bytedance.ies.xelement;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.JsonReader;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.xelement.api.XResourceType;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxTrailService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u000256J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0017H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0017H\u0007J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0017H\u0007J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0017H\u0007J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0017H\u0007J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0017H\u0007J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0017H\u0007J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0017H\u0007J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\bH\u0007J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0007J\u0018\u0010/\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0007J\u0018\u00100\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0007J\u0018\u00101\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0007J\u0018\u00102\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0007J\u0018\u00103\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0007J\u0018\u00104\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0007¨\u00067"}, d2 = {"Lcom/bytedance/ies/xelement/LynxLottieView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/d;", "", "status", "", "setPlayStatus", "", "enable", "setAutoPlay", "", "speed", "setSpeed", "progress", "setProgress", "objectFit", "setObjectFit", "setKeepLastFrame", "json", "setJson", "loop", "setLoop", "", "setRepeat", "setRepeatCount", "src", "setSrc", "setSrcFormat", GXTemplateKey.GAIAX_PLACEHOLDER, "setSrcPolyfill", "rate", "setUpdateRate", "setUpdateRate2", "startFrame", "setStartFrame", "endFrame", "setEndFrame", "setStartFrame2", "setEndFrame2", "isAutoReverse", "setReverseMode", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "play", "pause", "resume", "stop", "getDuration", "isAnimating", "listenAnimationUpdate", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "x-element-lottie_release"}, k = 1, mv = {1, 6, 0})
public final class LynxLottieView extends LynxUI<LottieAnimationView> implements com.airbnb.lottie.d {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f249609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f249610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f249611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<String> f249612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f249613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f249614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f249615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f249616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f249617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f249618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f249619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f249620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public XResourceType f249621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f249622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f249623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f249624p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f249625q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f249626r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f249627s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f249628t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f249629u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f249630v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f249631w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public File f249632x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<String> f249633y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f249634z;

    public interface a {
        void onFailed();

        void onSuccess(Bitmap r100);
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f249635a = null;

        static {
            int[] r100 = new int[XResourceType.values().length];
            r100[XResourceType.ASSET.ordinal()] = 1;
            r100[XResourceType.DISK.ordinal()] = 2;
            f249635a = r100;
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Bitmap> f249636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxLottieView f249637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f249638c;

        @Override // com.bytedance.ies.xelement.LynxLottieView.a
        public final void onFailed() {
            LLog.e("x-lottie", "fetchBitmap mSrcUrl=`" + this.f249637b.f249620l + "`, url=`" + this.f249638c + "` not exists.");
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, android.graphics.Bitmap] */
        @Override // com.bytedance.ies.xelement.LynxLottieView.a
        public final void onSuccess(Bitmap r100) {
            Ref.ObjectRef<Bitmap> r101 = this.f249636a;
            Intrinsics.checkNotNull(r100);
            r101.element = Bitmap.createBitmap(r100);
        }

        public d(Ref.ObjectRef<Bitmap> r100, LynxLottieView r101, String r102) {
            this.f249636a = r100;
            this.f249637b = r101;
            this.f249638c = r102;
        }
    }

    public static final class e extends com.lynx.tasm.event.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f249639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f249640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f249641d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f249642e;

        @Override // com.lynx.tasm.event.a
        public final Map<String, Object> b() {
            LinkedHashMap r100 = new LinkedHashMap();
            int r101 = this.f249639b;
            int r102 = this.f249640c;
            int r103 = this.f249641d;
            String r104 = this.f249642e;
            r100.put("current", Integer.valueOf(r101));
            r100.put("total", Integer.valueOf(r102));
            r100.put("loopIndex", Integer.valueOf(r103));
            r100.put("animationID", r104);
            return r100;
        }

        public e(String r100, int r101, int r102, int r103, String r104, int r105) {
            this.f249639b = r101;
            this.f249640c = r102;
            this.f249641d = r103;
            this.f249642e = r104;
            super(r105, r100);
        }
    }

    static {
    }

    public final void Q() {
        boolean r100 = this.f249629u;
        boolean r101 = this.f249631w;
        boolean r102 = this.f249630v;
        if (r100 == false) goto L26;
        if (r101 == false) goto L26;
        StringBuilder r103 = new StringBuilder();
        File r104 = this.f249632x;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPlaceholderFile");
        r104 = null;
    L8:
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(r104));
    L34:
        String r106 = r105.readLine();     // Catch: Throwable -> L21
        if (r106 == null) goto L12;
        r103.append(r106);     // Catch: Throwable -> L21
        r103.append("\n");     // Catch: Throwable -> L21
        goto L34
    L12:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r105, null);
        this.f249628t = r103.toString();
        if ((!this.f249633y.isEmpty()) == false) goto L20;
        StringCompanionObject r108 = StringCompanionObject.INSTANCE;
        Locale r109 = Locale.ENGLISH;
        String r110 = this.f249628t;
        Object[] r111 = this.f249633y.toArray(new String[0]);
        if (r111 == null) goto L19;
        String[] r112 = (String[]) r111;
        Object[] r113 = Arrays.copyOf(r112, r112.length);
        ((LottieAnimationView) this.mView).setAnimation(new JsonReader(new StringReader(String.format(r109, r110, Arrays.copyOf(r113, r113.length)))), this.f249627s);
        this.f249626r = UUID.randomUUID().toString();
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L20:
        LLog.e("x-lottie", "The content comes from 'src-polyfill' is empty, please check your usage");
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L26:
        if (r102 == false) goto L40;
        if (r101 == false) goto L41;
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        Locale r115 = Locale.ENGLISH;
        String r116 = this.f249628t;
        Object[] r117 = this.f249633y.toArray(new String[0]);
        if (r117 == null) goto L32;
        String[] r118 = (String[]) r117;
        Object[] r119 = Arrays.copyOf(r118, r118.length);
        ((LottieAnimationView) this.mView).setAnimation(new JsonReader(new StringReader(String.format(r115, r116, Arrays.copyOf(r119, r119.length)))), this.f249627s);
        this.f249626r = UUID.randomUUID().toString();
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L41:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        ((LottieAnimationView) this.mView).removeAllAnimatorListeners();
        ((LottieAnimationView) this.mView).removeAllUpdateListeners();
        ((LottieAnimationView) this.mView).cancelAnimation();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.f249610b == true) goto L5;
    L9:
        this.f249617i = false;
        return;
    L5:
        if (this.f249611c == true) goto L9;
        if (this.f249617i == true) goto L9;
        ((LottieAnimationView) this.mView).playAnimation();
        goto L9
    }

    public LynxLottieView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        this.f249609a = true;
        this.f249610b = true;
        this.f249613e = 6;
        this.f249615g = -1;
        this.f249618j = -1;
        this.f249619k = -1;
        this.f249623o = true;
        this.f249625q = "";
        this.f249626r = "";
        this.f249627s = "";
        this.f249628t = "";
        this.f249633y = new ArrayList();
    }

    public static final /* synthetic */ View O(LynxLottieView r100) {
        return r100.mView;
    }

    public final void P(final String r100) {
        this.f249622n = false;     // Catch: Exception -> L58
        final String r101 = d7a.a.b(getLynxContext(), r100, false);     // Catch: Exception -> L58
        if (r101 == null) goto L56;
        Uri r102 = UriProtector.parse(r101);     // Catch: Exception -> L58
        String r103 = r102.getScheme();     // Catch: Exception -> L58
        if (r103 != null) goto L8;
        return;
    L8:
        z76.d r104 = null;
        switch(r103.hashCode()) {
            case -1408207997: goto L40;
            case 3143036: goto L32;
            case 3213448: goto L18;
            case 93121264: goto L15;
            case 99617003: goto L12;
            default: goto L69;
        };
    L69:
        return;
    L12:
        if (r103.equals("https") == true) goto L21;
        return;
    L21:
        if (r102.getLastPathSegment() == null) goto L61;
        String r105 = r102.getLastPathSegment();     // Catch: Exception -> L58
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L58
        if (StringsKt.endsWith$default(r105, InvRouter.FLOW_SUFFIX, false, 2, null) == false) goto L61;
        T(r101);     // Catch: Exception -> L58
    L61:
        r104 = new z76.d(new z76.a(new z76.b(getLynxContext(), r101)));     // Catch: Exception -> L28
    L30:
        r104.c(new com.bytedance.ies.xelement.e(this, r100));     // Catch: Exception -> L58
        r104.b(new f(this, r101));     // Catch: Exception -> L58
        return;
    L28:
        e = move-exception;
        e.toString();     // Catch: Exception -> L58
        goto L30
    L15:
        if (r103.equals(UriUtil.LOCAL_ASSET_SCHEME) == false) goto L65;
    L42:
        String r106 = r102.getPath();     // Catch: Exception -> L58
        if (r106 != null) goto L46;
        return;
    L46:
        if (StringsKt.startsWith$default(r106, HTTP.URL_DEFAULT, false, 2, null) != true) goto L48;
        boolean r107 = true;
    L49:
        if (r107 == false) goto L51;
        r106 = r106.substring(1);     // Catch: Exception -> L58
    L51:
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L58
        if (StringsKt.endsWith$default(r106, InvRouter.FLOW_SUFFIX, false, 2, null) == false) goto L54;
        ((LottieAnimationView) this.mView).setImageAssetsFolder(r106.substring(0, StringsKt.lastIndexOf$default(r106, '/', 0, false, 6, null)) + "/images/");     // Catch: Exception -> L58
    L54:
        ((LottieAnimationView) this.mView).setAnimation(r106);     // Catch: Exception -> L58
        this.f249626r = UUID.randomUUID().toString();     // Catch: Exception -> L58
        return;
    L48:
        r107 = false;
        goto L49
    L65:
        return;
    L18:
        if (r103.equals("http") == true) goto L21;
        return;
    L32:
        if (r103.equals("file") == true) goto L35;
        return;
    L35:
        if (StringsKt.contains$default(r101, DownloadConstants.VULNERABILITY_PATH, false, 2, null) == false) goto L38;
        getLynxContext().reportResourceError(r101, "lottie", "x-lottie setSrc Failed: path traversal detected");     // Catch: Exception -> L58
        return;
    L38:
        T(r101);     // Catch: Exception -> L58
        ((LottieAnimationView) this.mView).setAnimation(new JsonReader(new PolarisFileReaderWrapper(r102.getPath())), r101);     // Catch: Exception -> L58
        this.f249626r = UUID.randomUUID().toString();     // Catch: Exception -> L58
        return;
    L40:
        if (r103.equals(ChameleonAssertResManager.ASSET_FOLDER) == true) goto L42;
        return;
    L56:
        ((LottieAnimationView) this.mView).setAnimationFromUrl(r100);     // Catch: Exception -> L58
        return;
    L58:
        e = move-exception;
        e.printStackTrace();
        LLog.e("x-lottie", e.toString());
    }

    public final void R(final String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        if (this.mContext != null) goto L13;
        return;
    L13:
        if (this.f249634z == true) goto L25;
        ILynxTrailService r102 = (ILynxTrailService) i8a.n.c().a(ILynxTrailService.class);
        if (r102 == null) goto L17;
        String r103 = r102.stringValueForTrailKey("enable_motion_ui_report");
    L19:
        if (Intrinsics.areEqual(r103, "true") == false) goto L26;
        this.f249634z = true;
        LynxEventReporter.onEvent("lynxsdk_motion_ui_event", this.mContext.getInstanceId(), new g(r100));
        return;
    L26:
        return;
    L17:
        r103 = null;
        goto L19
    L25:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void T(String r100) {
        int r101 = StringsKt.lastIndexOf$default(r100, '/', 0, false, 6, null);
        if (r101 <= 0) goto L5;
        this.f249620l = r100.substring(0, r101);
        ((LottieAnimationView) this.mView).setImageAssetDelegate(this);
        return;
    L5:
        LLog.e("x-lottie", "uri is error:" + r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        LynxLottieAnimationView r101 = new LynxLottieAnimationView(r100);
        r101.useHardwareAcceleration(true);
        r101.enableMergePathsForKitKatAndAbove(true);
        r101.addAnimatorListener(new i(this));
        r101.addAnimatorUpdateListener(new h(this));
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v20, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r4v32, types: [T, android.graphics.Bitmap] */
    @Override // com.airbnb.lottie.d
    public final Bitmap q(com.airbnb.lottie.h r110) {
        if (TextUtils.isEmpty(this.f249620l) == true) goto L57;
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        String r101 = HTTP.URL_DEFAULT + r110.f24782e + r110.f24781d;
        if (this.f249622n == false) goto L23;
        XResourceType r102 = this.f249621m;
        if (r102 != null) goto L9;
        int r103 = -1;
    L10:
        if (r103 == 1) goto L18;
        if (r103 != 2) goto L43;
        Objects.toString(XResourceType.DISK);
        String r104 = this.f249620l + r101;
        if (new PolarisFileWrapper(r104).exists() == true) goto L17;
        LLog.e("x-lottie", "fetchBitmap from Disk Error. mSrcUrl=`" + this.f249620l + "`, filePath=`" + r104 + "` file not exists.");
        return null;
    L17:
        r100.element = BitmapFactory.decodeFile(r104);
    L43:
        T r105 = r100.element;
        if (r105 != 0) goto L63;
        LLog.e("x-lottie", "bm is empty!");
        return null;
    L63:
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L54
        if (((Bitmap) r105).getWidth() != r110.f24778a) goto L52;
        T r106 = r100.element;     // Catch: Exception -> L54
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L54
        if (((Bitmap) r106).getHeight() != r110.f24779b) goto L52;
        return (Bitmap) r100.element;
    L52:
        T r107 = r100.element;     // Catch: Exception -> L54
        Intrinsics.checkNotNull(r107);     // Catch: Exception -> L54
        Bitmap r111 = Bitmap.createScaledBitmap((Bitmap) r107, r110.f24778a, r110.f24779b, false);     // Catch: Exception -> L54
        T r108 = r100.element;     // Catch: Exception -> L54
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L54
        ((Bitmap) r108).recycle();     // Catch: Exception -> L54
        return r111;
    L54:
        e = move-exception;
        e.printStackTrace();
        LLog.e("x-lottie", e.toString());
        return null;
    L18:
        Objects.toString(XResourceType.ASSET);
        String r109 = this.f249620l + r101;
        r100.element = BitmapFactory.decodeStream(getLynxContext().getAssets().open(r109));     // Catch: IOException -> L21
    L21:
        LLog.e("x-lottie", "fetchBitmap from Assets Error. mSrcUrl=`" + this.f249620l + "`, filePath=`" + r109 + "` file not exists.");
        return null;
    L9:
        r103 = c.f249635a[r102.ordinal()];
        goto L10
    L23:
        String r112 = this.f249620l;
        Intrinsics.checkNotNull(r112);
        if (StringsKt.startsWith$default(r112, "file:/", false, 2, null) == false) goto L30;
        StringBuilder r113 = new StringBuilder();
        String r114 = this.f249620l;
        Intrinsics.checkNotNull(r114);
        String r115 = this.f249620l;
        Intrinsics.checkNotNull(r115);
        r113.append(r114.substring(6, r115.length()));
        r113.append(r101);
        String r116 = r113.toString();
        if (new PolarisFileWrapper(r116).exists() == true) goto L29;
        LLog.e("x-lottie", "fetchBitmap from Disk Error. mSrcUrl=`" + this.f249620l + "`, filePath=`" + r116 + "` file not exists.");
        return null;
    L29:
        r100.element = BitmapFactory.decodeFile(r116);
        goto L43
    L30:
        String r117 = this.f249620l;
        Intrinsics.checkNotNull(r117);
        if (StringsKt.startsWith$default(r117, "http://", false, 2, null) == true) goto L34;
        String r118 = this.f249620l;
        Intrinsics.checkNotNull(r118);
        if (StringsKt.startsWith$default(r118, "https://", false, 2, null) == false) goto L43;
    L34:
        String r119 = this.f249620l + r101;
        d r120 = new d(r100, this, r119);
        Intrinsics.checkNotNullParameter(r119, "url");
        Intrinsics.checkNotNullParameter(r120, "callback");
        ImageRequestBuilder r121 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(d7a.a.b(getLynxContext(), r119, false)));
        m8a.e.a(r121);
        DataSource<CloseableReference<CloseableImage>> r122 = Fresco.getImagePipeline().fetchDecodedImage(r121.build(), "x-lottie");
        if (r122 != null) goto L37;
        r120.onFailed();
        goto L43
    L37:
        CountDownLatch r123 = new CountDownLatch(1);
        j r124 = new j(r120, r123, r122);
        r122.subscribe(r124, CallerThreadExecutor.getInstance());
    L42:
        r124.onFailure(r122);
        goto L43
    L39:
        if (r123.await(3, TimeUnit.SECONDS) == true) goto L43;
        r124.onFailure(r122);     // Catch: InterruptedException -> L42
        goto L43
    L57:
        LLog.e("x-lottie", "fetchBitmap error mSrcUrl=`" + this.f249620l + "`, or asset is null");
        return null;
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public final void setAutoPlay(boolean r100) {
        this.f249610b = r100;
        T r101 = this.mView;
        if (r101 == 0) goto L7;
        ((LynxLottieAnimationView) r101).setMAutoPlay(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xelement.LynxLottieAnimationView");
    }

    @LynxProp(defaultInt = -1, name = "endframe")
    public final void setEndFrame(int r100) {
        if (r100 >= 0) goto L5;
        ((LottieAnimationView) this.mView).setMaxFrame(Integer.MAX_VALUE);
        return;
    L5:
        ((LottieAnimationView) this.mView).setMaxFrame(r100);
    }

    @LynxProp(defaultInt = -1, name = "end-frame")
    public final void setEndFrame2(int r100) {
        setEndFrame(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 == null) goto L5;
        Set<String> r101 = r100.keySet();
    L6:
        this.f249612d = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @LynxProp(name = "json")
    public final void setJson(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L25;
        ((LottieAnimationView) this.mView).setAnimationFromJson(r100, null);     // Catch: Exception -> L12
        R("json");     // Catch: Exception -> L12
    L15:
        if (this.f249611c == false) goto L17;
    L20:
        ((LottieAnimationView) this.mView).cancelAnimation();
    L21:
        this.f249611c = false;
        this.f249610b = true;
        return;
    L17:
        if (this.f249610b == false) goto L20;
        ((LottieAnimationView) this.mView).playAnimation();
    L12:
        e = move-exception;
        LLog.e("x-lottie", "error");
        e.printStackTrace();
        goto L15
    L25:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @LynxProp(defaultBoolean = true, name = "keeplastframe")
    public final void setKeepLastFrame(boolean r100) {
        this.f249609a = r100;
    }

    @LynxProp(defaultBoolean = false, name = "loop")
    public final void setLoop(boolean r100) {
        if (r100 == false) goto L4;
        ((LottieAnimationView) this.mView).setRepeatCount(-1);
        return;
    L4:
        ((LottieAnimationView) this.mView).setRepeatCount(0);
    }

    @LynxProp(name = "objectfit")
    public final void setObjectFit(String r100) {
        Intrinsics.checkNotNullParameter(r100, "objectFit");
        if (Intrinsics.areEqual(r100, "cover") == false) goto L6;
        ImageView.ScaleType r101 = ImageView.ScaleType.CENTER_CROP;
    L9:
        ((LottieAnimationView) this.mView).setScaleType(r101);
        return;
    L6:
        if (Intrinsics.areEqual(r100, LynxVideoManagerLite.CONTAIN) == false) goto L8;
        r101 = ImageView.ScaleType.FIT_CENTER;
        goto L9
    L8:
        r101 = ImageView.ScaleType.CENTER;
        goto L9
    }

    @LynxProp(name = "playstatus")
    public final void setPlayStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        if (Intrinsics.areEqual("play", r100) == false) goto L6;
        ((LottieAnimationView) this.mView).playAnimation();
        this.f249617i = true;
        this.f249611c = false;
        return;
    L6:
        if (Intrinsics.areEqual("pause", r100) == false) goto L10;
        ((LottieAnimationView) this.mView).cancelAnimation();
        this.f249611c = true;
        return;
    }

    @LynxProp(name = "progress")
    public final void setProgress(float r100) {
        ((LottieAnimationView) this.mView).setProgress(r100);
    }

    @LynxProp(defaultInt = -1, name = "repetcount")
    public final void setRepeat(int r100) {
        if (r100 >= 0) goto L4;
        r100 = -1;
    L4:
        ((LottieAnimationView) this.mView).setRepeatCount(r100);
    }

    @LynxProp(defaultInt = 0, name = "repeat-count")
    public final void setRepeatCount(int r100) {
        setRepeat(r100);
    }

    @LynxProp(name = "auto-reverse")
    public final void setReverseMode(boolean r100) {
        if (r100 == false) goto L4;
        ((LottieAnimationView) this.mView).setRepeatMode(2);
        return;
    L4:
        ((LottieAnimationView) this.mView).setRepeatMode(1);
    }

    @LynxProp(name = "speed")
    public final void setSpeed(float r100) {
        ((LottieAnimationView) this.mView).setSpeed(r100);
    }

    @LynxProp(name = "src")
    public final void setSrc(String r100) {
        this.f249620l = null;
        ((LottieAnimationView) this.mView).setImageAssetDelegate(null);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        P(r100);
        R(r100);
    }

    @LynxProp(name = "src-format")
    public final void setSrcFormat(String r110) {
        z76.d r100 = null;
        this.f249620l = null;
        this.f249628t = "";
        this.f249629u = false;
        ((LottieAnimationView) this.mView).setImageAssetDelegate(null);
        if (TextUtils.isEmpty(r110) == false) goto L60;
        return;
    L60:
        final String r101 = URLDecoder.decode(d7a.a.b(getLynxContext(), r110, false), "UTF-8");     // Catch: Exception -> L50
        if (r101 == null) goto L48;
        Uri r102 = UriProtector.parse(r101);     // Catch: Exception -> L50
        String r103 = r102.getScheme();     // Catch: Exception -> L50
        if (r103 == null) goto L47;
        int r104 = r103.hashCode();     // Catch: Exception -> L50
        if (r104 == 3143036) goto L33;
        if (r104 == 3213448) goto L21;
        if (r104 != 99617003) goto L47;
        if (r103.equals("https") == false) goto L47;
    L24:
        if (StringsKt.endsWith$default(r101, InvRouter.FLOW_SUFFIX, false, 2, null) == false) goto L26;
        T(r101);     // Catch: Exception -> L50
    L26:
        this.f249625q = "https";     // Catch: Exception -> L50
        this.f249627s = r101;     // Catch: Exception -> L50
        T(r101);     // Catch: Exception -> L50
        r100 = new z76.d(new z76.a(new z76.b(getLynxContext(), r101)));     // Catch: Exception -> L29
    L31:
        r100.c(new com.bytedance.ies.xelement.c(this));     // Catch: Exception -> L50
        r100.b(new com.bytedance.ies.xelement.d(this, r101));     // Catch: Exception -> L50
    L52:
        R(r110);
        return;
    L29:
        e = move-exception;
        e.toString();     // Catch: Exception -> L50
        goto L31
    L21:
        if (r103.equals("http") == true) goto L24;
    L33:
        if (r103.equals("file") == false) goto L47;
        this.f249625q = "file";     // Catch: Exception -> L50
        this.f249627s = r101;     // Catch: Exception -> L50
        T(r101);     // Catch: Exception -> L50
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L50
        BufferedReader r106 = new BufferedReader(new PolarisFileReaderWrapper(r102.getPath()));     // Catch: Exception -> L50
    L54:
        String r107 = r106.readLine();     // Catch: Throwable -> L42
        if (r107 == null) goto L39;
        r105.append(r107);     // Catch: Throwable -> L42
        r105.append("\n");     // Catch: Throwable -> L42
        goto L54
    L39:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r106, null);     // Catch: Exception -> L50
        this.f249628t = r105.toString();     // Catch: Exception -> L50
        this.f249630v = true;     // Catch: Exception -> L50
        Q();     // Catch: Exception -> L50
        goto L52
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Exception -> L50
        throw th;     // Catch: Exception -> L50
    L47:
        LLog.e("x-lottie", "asset for src-format must be in one of 'http','https' 'file'");     // Catch: Exception -> L50
        goto L52
    L48:
        ((LottieAnimationView) this.mView).setAnimationFromUrl(r110);     // Catch: Exception -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
        LLog.e("x-lottie", e.getMessage());
        goto L52
    }

    @LynxProp(name = "src-polyfill")
    public final void setSrcPolyfill(String r110) {
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_PLACEHOLDER);
        ((ArrayList) this.f249633y).clear();
        int r100 = 0;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.f249624p, r110) == true) goto L41;
        this.f249624p = r110;
        Pattern r102 = PatternProtector.compile("^'.*'$");
        Object[] r111 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
        if (r111 == null) goto L36;
        int r103 = r111.length;
    L12:
        if (r100 >= r103) goto L17;
        String r104 = (String) r111[r100];
        if (r102.matcher(r104).matches() == false) goto L16;
        r104 = StringsKt.replace$default(r104, '\'', Typography.quote, false, 4, null);
    L16:
        ((ArrayList) this.f249633y).add(r104);
        r100 = r100 + 1;
        goto L12
    L17:
        this.f249631w = true;
        String r112 = this.f249625q;
        int r105 = r112.hashCode();
        if (r105 == 3143036) goto L32;
        if (r105 == 3213448) goto L28;
        if (r105 == 99617003) goto L25;
    L33:
        LLog.e("x-lottie", "lynx-lottie: src-polyfill only valid when schema of srcWithPlaceHolder 'file'(come from Gecko), 'https', 'http' ");
        return;
    L25:
        if (r112.equals("https") == false) goto L33;
    L30:
        this.f249631w = true;
        Q();
        return;
    L28:
        if (r112.equals("http") == true) goto L30;
    L32:
        if (r112.equals("file") == false) goto L33;
        Q();
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L41:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @LynxProp(defaultInt = 0, name = "startframe")
    public final void setStartFrame(int r100) {
        ((LottieAnimationView) this.mView).setMinFrame(r100);
    }

    @LynxProp(defaultInt = 0, name = "start-frame")
    public final void setStartFrame2(int r100) {
        setStartFrame(r100);
    }

    @LynxProp(defaultInt = 6, name = "rate")
    public final void setUpdateRate(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f249613e = r100;
    }

    @LynxProp(defaultInt = 6, name = "update-rate")
    public final void setUpdateRate2(int r100) {
        setUpdateRate(r100);
    }

    public static void N(LynxLottieView r100, ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        LottieComposition r102 = ((LottieAnimationView) r100.mView).getComposition();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101.getAnimatedValue() != null) goto L7;
        return;
    L7:
        if (r100.f249623o == false) goto L26;
        float r103 = r102.getDurationFrames();     // Catch: Exception -> L20
        Object r104 = r101.getAnimatedValue();     // Catch: Exception -> L20
        if (r104 == null) goto L19;
        r100.f249614f = (int) (r103 * ((Float) r104).floatValue());     // Catch: Exception -> L20
        int r105 = (int) r102.getDurationFrames();     // Catch: Exception -> L20
        r100.f249615g = r105;     // Catch: Exception -> L20
        int r106 = r100.f249614f;     // Catch: Exception -> L20
        int r107 = (int) ((r106 / r105) * 100);     // Catch: Exception -> L20
        if (r106 == 0) goto L17;
        if (r106 == r105) goto L17;
        if (r100.f249618j != r107) goto L16;
        return;
    L16:
        if ((SystemClock.uptimeMillis() - r100.f249619k) >= (1000 / r100.f249613e)) goto L17;
        return;
    L17:
        r100.S("update", r100.f249614f, r100.f249615g, r100.f249616h, r100.f249626r);     // Catch: Exception -> L20
        r100.f249618j = r107;     // Catch: Exception -> L20
        r100.f249619k = SystemClock.uptimeMillis();     // Catch: Exception -> L20
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        LLog.e("x-lottie", e.toString());
        return;
    }

    @LynxUIMethod
    public final void getDuration(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        T r103 = this.mView;
        if (r103 == 0) goto L5;
        Intrinsics.checkNotNull(r103);
        r102.putInt("data", (int) ((LottieAnimationView) r103).getDuration());
        r101.invoke(new Object[]{0, r102});
        return;
    L5:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void isAnimating(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        T r103 = this.mView;
        if (r103 == 0) goto L5;
        r102.putBoolean("data", ((LottieAnimationView) r103).isAnimating());
        r101.invoke(new Object[]{0, r102});
        return;
    L5:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void listenAnimationUpdate(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView == 0) goto L5;
        r102.putBoolean("data", true);
        this.f249623o = r100.getBoolean("isListen");
        r101.invoke(new Object[]{0, r102});
        return;
    L5:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void pause(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        T r103 = this.mView;
        if (r103 != 0) goto L10;
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
        return;
    L10:
        ((LottieAnimationView) r103).pauseAnimation();     // Catch: Exception -> L6
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void play(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f249626r = UUID.randomUUID().toString();
        JavaOnlyMap r102 = new JavaOnlyMap();
        T r103 = this.mView;
        if (r103 != 0) goto L10;
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
        return;
    L10:
        ((LottieAnimationView) r103).playAnimation();     // Catch: Exception -> L6
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void resume(ReadableMap r100, Callback r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        this.f249626r = UUID.randomUUID().toString();
        JavaOnlyMap r101 = new JavaOnlyMap();
        T r102 = this.mView;
        if (r102 != 0) goto L13;
        r101.putString("message", "view is not exist");
        r110.invoke(new Object[]{1, r101});
    L10:
        if (this.mView != 0) goto L15;
        r101.putString("message", "view is not exist");
        r110.invoke(new Object[]{1, r101});
        return;
    L15:
        return;
    L13:
        ((LottieAnimationView) r102).resumeAnimation();     // Catch: Exception -> L6
        r110.invoke(new Object[]{0, r101});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        r101.putString("message:", e.getMessage());
        r110.invoke(new Object[]{1, r101});
        goto L10
    }

    @LynxUIMethod
    public final void stop(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        T r103 = this.mView;
        if (r103 != 0) goto L10;
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
        return;
    L10:
        ((LottieAnimationView) r103).cancelAnimation();     // Catch: Exception -> L6
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
    }

    public static void M(LynxLottieView r100, String r101, File r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        r100.f249626r = UUID.randomUUID().toString();
        ((LottieAnimationView) r100.mView).setAnimation(new JsonReader(new PolarisFileReaderWrapper(r102)), r101);
    }

    public final void S(String r110, int r111, int r112, int r113, String r114) {
        Set<String> r100 = this.f249612d;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.contains(r110) != true) goto L7;
    L8:
        if (r101 == true) goto L10;
        return;
    L10:
        LynxContext r102 = getLynxContext();
        if (r102 == null) goto L16;
        EventEmitter r103 = r102.getEventEmitter();
        if (r103 == null) goto L17;
        r103.sendCustomEvent(new e(r110, r111, r112, r113, r114, getSign()));
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r101 = false;
        goto L8
    }
}
