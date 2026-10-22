package com.bytedance.awemeopen.infra.base.anim.lottie;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.amap.api.col.s.ce;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.plugs.lotties.i;
import com.bytedance.awemeopen.infra.plugs.lotties.j;
import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import com.bytedance.awemeopen.servicesapi.ui.AoAnimationService;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EB\u0011\b\u0016\u0012\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?B\u0019\b\u0016\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\b>\u0010BB!\b\u0016\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u00020\u000e¢\u0006\u0004\b>\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR*\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010)\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R*\u0010\t\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00105\u001a\u0004\u0018\u0001002\b\u0010\u001e\u001a\u0004\u0018\u0001008\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b1\u00102\"\u0004\b3\u00104R(\u0010;\u001a\u0004\u0018\u0001062\b\u0010\u001e\u001a\u0004\u0018\u0001068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006F"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimationLottieView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "", "getScale", "scale", "", "setScale", "Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig;", "config", "setAnimationConfigAndStartLoad", "", "str", "setImagesAssetsFolder", "", "frame", "setFrame", "c", "Ljava/lang/Object;", "getFallbackRes", "()Ljava/lang/Object;", "setFallbackRes", "(Ljava/lang/Object;)V", "fallbackRes", "Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationService;", "d", "Lkotlin/Lazy;", "getAnimService", "()Lcom/bytedance/awemeopen/servicesapi/ui/AoAnimationService;", "animService", "value", "e", "I", "getRepeatMode", "()I", "setRepeatMode", "(I)V", "repeatMode", "f", "getRepeatCount", "setRepeatCount", "repeatCount", ce.f26391f, "Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig;", "getConfig", "()Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig;", "setConfig", "(Lcom/bytedance/awemeopen/infra/base/anim/lottie/AoAnimConfig;)V", "Lcom/bytedance/awemeopen/servicesapi/ui/c;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/awemeopen/servicesapi/ui/c;", "setCompositionTask", "(Lcom/bytedance/awemeopen/servicesapi/ui/c;)V", "compositionTask", "Lcom/bytedance/awemeopen/servicesapi/ui/a;", "l", "Lcom/bytedance/awemeopen/servicesapi/ui/a;", "setComposition", "(Lcom/bytedance/awemeopen/servicesapi/ui/a;)V", "composition", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public class AoAnimationLottieView extends AppCompatImageView implements Animatable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f198568m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<Runnable> f198569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f198570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f198571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f198572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f198573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f198574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AoAnimConfig f198575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.awemeopen.servicesapi.ui.d f198576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.awemeopen.servicesapi.ui.c f198577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f198578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f198579k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.awemeopen.servicesapi.ui.a f198580l;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f198581a = null;

        static {
            int[] r100 = new int[AoAnimConfig.ResMode.values().length];
            r100[AoAnimConfig.ResMode.URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[AoAnimConfig.ResMode.ASSET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[AoAnimConfig.ResMode.JSON_STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[AoAnimConfig.ResMode.RAW_RES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[AoAnimConfig.ResMode.JSON_STREAM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[AoAnimConfig.ResMode.ZIP_STREAM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[AoAnimConfig.ResMode.EMPTY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f198581a = r100;
        }
    }

    public static final class c implements l64.a {
        public c() {
        }

        @Override // l64.a
        public final void onFail(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
        }

        @Override // l64.a
        public final void onSuccess() {
        }
    }

    public static final class d extends com.bytedance.awemeopen.servicesapi.ui.b<Throwable> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AoAnimationLottieView f198582b;

        public d(AoAnimationLottieView r100) {
            this.f198582b = r100;
        }

        @Override // com.bytedance.awemeopen.servicesapi.ui.b
        public final /* bridge */ /* synthetic */ void a(Throwable r100) {
            b(r100);
        }

        public final void b(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            AoAnimationLottieView r101 = this.f198582b;
            int r102 = AoAnimationLottieView.f198568m;
            r101.m();
            this.f198582b.getConfig().f198563f.invoke(r100);
        }
    }

    public static final class e extends com.bytedance.awemeopen.servicesapi.ui.b<com.bytedance.awemeopen.servicesapi.ui.a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AoAnimationLottieView f198583b;

        public e(AoAnimationLottieView r100) {
            this.f198583b = r100;
        }

        @Override // com.bytedance.awemeopen.servicesapi.ui.b
        public final void a(com.bytedance.awemeopen.servicesapi.ui.a r100) {
            com.bytedance.awemeopen.servicesapi.ui.a r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            AoAnimationLottieView.j(this.f198583b, r101);
            this.f198583b.f198570b = true;
            Iterator<Runnable> r102 = this.f198583b.f198569a.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().run();
            goto L4
        }
    }

    static {
    }

    private final float getScale() {
        return this.f198576h.getScale();
    }

    public final AoAnimationService getAnimService() {
        return (AoAnimationService) this.f198572d.getValue();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f198576h.isRunning();
    }

    public final void m() {
        Object r100 = this.f198571c;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof Integer) == false) goto L8;
        setImageResource(((Number) r100).intValue());
        return;
    L8:
        if ((r100 instanceof String) == true) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty((CharSequence) r100) == true) goto L16;
        l64.b r101 = new l64.b();
        r101.f507666a = (String) r100;
        r101.f507670e = new c();
        r101.f507669d = this;
        IBdpService r102 = j64.a.a(AoImageService.class);
        Intrinsics.checkNotNull(r102);
        ((AoImageService) r102).Q0(getContext(), r101);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        setImageDrawable(this.f198576h.getDrawable());
        this.f198576h.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f198576h.stop();
    }

    public final AoAnimConfig getConfig() {
        return this.f198575g;
    }

    public final Object getFallbackRes() {
        return this.f198571c;
    }

    public final int getRepeatCount() {
        return this.f198574f;
    }

    public final int getRepeatMode() {
        return this.f198573e;
    }

    public AoAnimationLottieView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f198569a = new CopyOnWriteArraySet();
        this.f198572d = LazyKt.lazy(AoAnimationLottieView$animService$2.INSTANCE);
        this.f198573e = 1;
        this.f198575g = AoAnimConfig.f198557g;
        j r101 = getAnimService().p0();
        setImageDrawable(r101.f198873a);
        this.f198576h = r101;
        this.f198578j = new e(this);
        this.f198579k = new d(this);
    }

    private final void setComposition(com.bytedance.awemeopen.servicesapi.ui.a r100) {
        this.f198580l = r100;
        if (r100 == null) goto L5;
        this.f198576h.d(this);
        this.f198576h.h(r100);
        this.f198575g.getClass();
        Unit r101 = Unit.INSTANCE;
    L6:
        if (r101 != null) goto L9;
        this.f198576h.b();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final void setCompositionTask(com.bytedance.awemeopen.servicesapi.ui.c r100) {
        i r101 = null;
        setComposition(null);
        com.bytedance.awemeopen.servicesapi.ui.c r102 = this.f198577i;
        if (r102 == null) goto L5;
        r102.b(this.f198578j);
        r102.a(this.f198579k);
    L5:
        if (r100 == null) goto L9;
        i r103 = r100.c(this.f198578j);
        if (r103 == null) goto L9;
        r103.d(this.f198579k);
        r101 = r103;
    L9:
        this.f198577i = r101;
    }

    private final void setScale(float r100) {
        this.f198576h.setScale(r100);
    }

    public final void l(AoAnimConfig r100) {
        AoAnimConfig.ResMode r101 = r100.f198558a;
        switch(b.f198581a[r101.ordinal()]) {
            case 1: goto L41;
            case 2: goto L34;
            case 3: goto L27;
            case 4: goto L20;
            case 5: goto L13;
            case 6: goto L6;
            default: goto L71;
        };
    L71:
        return;
    L6:
        if (r100.f198561d == true) goto L58;
        AoAnimationService r102 = getAnimService();
        Object r103 = r100.f198559b;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.zip.ZipInputStream");
        setCompositionTask(r102.K((ZipInputStream) r103, r100.f198559b.toString()));
        return;
    L58:
        AoAnimationService r104 = getAnimService();     // Catch: Exception -> L9
        Object r105 = r100.f198559b;     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.util.zip.ZipInputStream");     // Catch: Exception -> L9
        setComposition(r104.j0((ZipInputStream) r105, r100.f198559b.toString()));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        this.f198579k.b(e);
        return;
    L13:
        if (r100.f198561d == true) goto L56;
        AoAnimationService r106 = getAnimService();
        Object r107 = r100.f198559b;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.io.InputStream");
        setCompositionTask(r106.A2((InputStream) r107, r100.f198559b.toString()));
        return;
    L56:
        AoAnimationService r108 = getAnimService();     // Catch: Exception -> L16
        Object r109 = r100.f198559b;     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type java.io.InputStream");     // Catch: Exception -> L16
        setComposition(r108.w0((InputStream) r109, r100.f198559b.toString()));     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        this.f198579k.b(e);
        return;
    L20:
        if (r100.f198561d == true) goto L52;
        AoAnimationService r110 = getAnimService();
        Context r111 = getContext();
        Object r112 = r100.f198559b;
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.Int");
        setCompositionTask(r110.F1(r111, ((Integer) r112).intValue()));
        return;
    L52:
        AoAnimationService r113 = getAnimService();     // Catch: Exception -> L23
        Context r114 = getContext();     // Catch: Exception -> L23
        Object r115 = r100.f198559b;     // Catch: Exception -> L23
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L23
        setComposition(r113.c1(r114, ((Integer) r115).intValue()));     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        this.f198579k.b(e);
        return;
    L27:
        if (r100.f198561d == true) goto L50;
        AoAnimationService r116 = getAnimService();
        Object r117 = r100.f198559b;
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type kotlin.String");
        setCompositionTask(r116.i1((String) r117, r100.f198559b.toString()));
        return;
    L50:
        AoAnimationService r118 = getAnimService();     // Catch: Exception -> L30
        Object r119 = r100.f198559b;     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L30
        setComposition(r118.b2((String) r119, r100.f198559b.toString()));     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        this.f198579k.b(e);
        return;
    L34:
        if (r100.f198561d == true) goto L54;
        AoAnimationService r120 = getAnimService();
        Context r121 = getContext();
        Object r122 = r100.f198559b;
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type kotlin.String");
        setCompositionTask(r120.W(r121, (String) r122));
        return;
    L54:
        AoAnimationService r123 = getAnimService();     // Catch: Exception -> L37
        Context r124 = getContext();     // Catch: Exception -> L37
        Object r125 = r100.f198559b;     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L37
        setComposition(r123.D2(r124, (String) r125));     // Catch: Exception -> L37
        return;
    L37:
        e = move-exception;
        this.f198579k.b(e);
        return;
    L41:
        if (r100.f198561d == true) goto L48;
        AoAnimationService r126 = getAnimService();
        Context r127 = getContext();
        Object r128 = r100.f198559b;
        Intrinsics.checkNotNull(r128, "null cannot be cast to non-null type kotlin.String");
        setCompositionTask(r126.X1(r127, (String) r128));
        return;
    L48:
        AoAnimationService r129 = getAnimService();     // Catch: Exception -> L44
        Context r130 = getContext();     // Catch: Exception -> L44
        Object r131 = r100.f198559b;     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L44
        setComposition(r129.R(r130, (String) r131));     // Catch: Exception -> L44
        return;
    L44:
        e = move-exception;
        this.f198579k.b(e);
    }

    public final void setAnimationConfigAndStartLoad(AoAnimConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        setConfig(r100);
    }

    public final void setConfig(AoAnimConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f198571c = r100.f198560c;
        com.bytedance.awemeopen.servicesapi.ui.d r101 = this.f198576h;
        r101.e();
        r101.a(r100.f198562e);
        AoAnimConfig.ResMode r102 = r100.f198558a;
        if (r102 == this.f198575g.f198558a) goto L5;
        l(r100);
    L18:
        this.f198575g = r100;
        return;
    L5:
        switch(b.f198581a[r102.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L18;
        };
    L7:
        m();
        goto L18
    L11:
        Object r103 = r100.f198559b;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");
        int r104 = ((Integer) r103).intValue();
        Object r105 = this.f198575g.f198559b;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");
        if (r104 == ((Integer) r105).intValue()) goto L18;
        l(r100);
        goto L18
    L14:
        Object r106 = r100.f198559b;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.String");
        Object r107 = this.f198575g.f198559b;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.String");
        if (Intrinsics.areEqual((String) r106, (String) r107) == true) goto L18;
        l(r100);
        goto L18
    L9:
        if (Intrinsics.areEqual(r100.f198559b, this.f198575g.f198559b) == true) goto L18;
        l(r100);
        goto L18
    }

    public final void setFallbackRes(Object r100) {
        this.f198571c = r100;
    }

    public final void setFrame(final int r100) {
        if (getAnimService().f() == false) goto L14;
        if (r100 != 0) goto L6;
        this.f198576h.setFrame(1);
    L6:
        final Function0<Unit> r101 = new AnonymousClass1(this, r100);
        if (this.f198575g.f198561d == false) goto L10;
        AoPool.d(new com.bytedance.awemeopen.infra.base.anim.lottie.a(r101), 10);
        return;
    L10:
        if (this.f198570b == false) goto L12;
        AoPool.d(new com.bytedance.awemeopen.infra.base.anim.lottie.b(r101), 10);
        return;
    L12:
        this.f198569a.add(new com.bytedance.awemeopen.infra.base.anim.lottie.c(r101));
        return;
    L14:
        this.f198576h.setFrame(r100);
    }

    public final void setImagesAssetsFolder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        this.f198576h.c(r100);
    }

    public final void setRepeatCount(int r100) {
        this.f198574f = r100;
        this.f198576h.setRepeatCount(r100);
    }

    public final void setRepeatMode(int r100) {
        this.f198573e = r100;
        this.f198576h.g(r100);
    }

    public AoAnimationLottieView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        new LinkedHashMap();
        super(r100, r101);
        this.f198569a = new CopyOnWriteArraySet();
        this.f198572d = LazyKt.lazy(AoAnimationLottieView$animService$2.INSTANCE);
        this.f198573e = 1;
        this.f198575g = AoAnimConfig.f198557g;
        j r102 = getAnimService().p0();
        setImageDrawable(r102.f198873a);
        this.f198576h = r102;
        this.f198578j = new e(this);
        this.f198579k = new d(this);
    }

    public static final /* synthetic */ void j(AoAnimationLottieView r100, com.bytedance.awemeopen.servicesapi.ui.a r101) {
        r100.setComposition(r101);
    }

    public final void setMinAndMaxFrame(int r100, int r101) {
        this.f198576h.f(r100, r101);
    }

    public AoAnimationLottieView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f198569a = new CopyOnWriteArraySet();
        this.f198572d = LazyKt.lazy(AoAnimationLottieView$animService$2.INSTANCE);
        this.f198573e = 1;
        this.f198575g = AoAnimConfig.f198557g;
        j r103 = getAnimService().p0();
        setImageDrawable(r103.f198873a);
        this.f198576h = r103;
        this.f198578j = new e(this);
        this.f198579k = new d(this);
    }
}
