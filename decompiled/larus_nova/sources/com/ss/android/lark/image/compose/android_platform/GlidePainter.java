package com.ss.android.lark.image.compose.android_platform;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.compose.common.CachePolicy;
import com.ss.android.lark.image.compose.common.avatar.c;
import com.ss.android.lark.image.compose.common.avatar.d;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u0012\u0010?\u001a\u00020>2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\f\u0010@\u001a\u00020A*\u00020BH\u0014J\b\u0010C\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020AH\u0016J\b\u0010E\u001a\u00020AH\u0016J\u000e\u0010F\u001a\u00020A2\u0006\u00100\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\b\u0012\u0004\u0012\u00020\b0&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020/01¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006G"}, d2 = {"Lcom/ss/android/lark/image/compose/android_platform/GlidePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageSource", "Lcom/ss/android/lark/image/compose/android_platform/ImageSource;", "imageOption", "Lcom/ss/android/lark/image/compose/common/ImageOptions;", "diskCachePolicy", "Lcom/ss/android/lark/image/compose/common/CachePolicy;", "memoryCachePolicy", GXTemplateKey.GAIAX_PLACEHOLDER, "error", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/image/compose/android_platform/ImageSource;Lcom/ss/android/lark/image/compose/common/ImageOptions;Lcom/ss/android/lark/image/compose/common/CachePolicy;Lcom/ss/android/lark/image/compose/common/CachePolicy;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)V", "<set-?>", "painter", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "painter$delegate", "Landroidx/compose/runtime/MutableState;", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getImageSource", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setImageSource", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "imageOptions", "getImageOptions", "setImageOptions", "_state", "Lcom/ss/android/lark/image/compose/common/avatar/State;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", PickerReporterConstants.KEY.TARGET, "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/drawable/Drawable;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "applyAlpha", "", "applyColorFilter", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "updateState", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlidePainter extends Painter implements RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f426232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CachePolicy f426233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CachePolicy f426234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Painter f426235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Painter f426236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableState f426237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableState f426238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableState f426239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final StateFlowImpl f426240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StateFlowImpl f426241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final StateFlowImpl f426242k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b1 f426243l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f426244m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RequestManager f426245n;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f426246a = null;

        static {
            int[] r100 = new int[CachePolicy.values().length];
            r100[CachePolicy.Enabled.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CachePolicy.Disabled.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f426246a = r100;
        }
    }

    public static final class b extends CustomTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GlidePainter f426247a;

        public b(GlidePainter r100) {
            this.f426247a = r100;
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onLoadCleared(Drawable r100) {
            this.f426247a.a(c.a.f426266a);
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public final void onLoadFailed(Drawable r100) {
            GlidePainter r101 = this.f426247a;
            Painter r102 = r101.f426236e;
            if (r102 != null) goto L7;
            if (r100 == null) goto L6;
            r102 = new DrawablePainter(r100);
            goto L7
        L6:
            r102 = null;
        L7:
            com.ss.android.lark.image.compose.common.avatar.b r103 = com.ss.android.lark.image.compose.common.avatar.b.f426265a;
            r101.a(new c.b(r102));
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public final void onLoadStarted(Drawable r100) {
            GlidePainter r101 = this.f426247a;
            Painter r102 = r101.f426235d;
            if (r102 != null) goto L7;
            if (r100 == null) goto L6;
            r102 = new DrawablePainter(r100);
            goto L7
        L6:
            r102 = null;
        L7:
            r101.a(new c.C5043c(r102));
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onResourceReady(Object r100, Transition r101) {
            Drawable r102 = (Drawable) r100;
            Intrinsics.checkNotNullParameter(r102, "resource");
            GlidePainter r103 = this.f426247a;
            DrawablePainter r104 = new DrawablePainter(r102);
            d r105 = d.f426272a;
            r103.a(new c.d(r104));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo5530getIntrinsicSizeNHjbRc() {
        Painter r100 = (Painter) this.f426237f.getValue();
        if (r100 == null) goto L6;
        return r100.mo5530getIntrinsicSizeNHjbRc();
    L6:
        return Size.Companion.m4659getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        Object r100 = (Painter) this.f426237f.getValue();
        if ((r100 instanceof RememberObserver) == false) goto L5;
        RememberObserver r101 = (RememberObserver) r100;
    L6:
        if (r101 == null) goto L8;
        r101.onAbandoned();
    L8:
        RequestManager r102 = this.f426245n;
        if (r102 == null) goto L11;
        r102.clear(this.f426244m);
    L11:
        this.f426244m = null;
        this.f426245n = null;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        Object r100 = (Painter) this.f426237f.getValue();
        if ((r100 instanceof RememberObserver) == false) goto L5;
        RememberObserver r101 = (RememberObserver) r100;
    L6:
        if (r101 == null) goto L8;
        r101.onForgotten();
    L8:
        RequestManager r102 = this.f426245n;
        if (r102 == null) goto L11;
        r102.clear(this.f426244m);
    L11:
        this.f426244m = null;
        this.f426245n = null;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        Object r100 = (Painter) this.f426237f.getValue();
        if ((r100 instanceof RememberObserver) == false) goto L5;
        RememberObserver r101 = (RememberObserver) r100;
    L6:
        if (r101 == null) goto L8;
        r101.onRemembered();
    L8:
        RequestManager r102 = this.f426245n;
        if (r102 != null) goto L11;
        r102 = Glide.with(this.f426232a);
        this.f426245n = r102;
    L11:
        b r103 = new b(this);
        RequestBuilder<Drawable> r104 = r102.asDrawable();
        com.ss.android.lark.image.compose.android_platform.a r105 = (com.ss.android.lark.image.compose.android_platform.a) this.f426240i.getValue();
        Handler r106 = BaseImageComponentKt.f426224a;
        if ((r105 instanceof com.ss.android.lark.image.compose.android_platform.a.d) == false) goto L15;
        Object r107 = ((com.ss.android.lark.image.compose.android_platform.a.d) r105).f426249a;
    L23:
        RequestBuilder<Drawable> r108 = r104.load(r107);
        CachePolicy r109 = this.f426234c;
        int[] r110 = a.f426246a;
        int r111 = r110[r109.ordinal()];
        if (r111 == 1) goto L29;
        if (r111 != 2) goto L28;
        RequestBuilder r112 = r108.skipMemoryCache(true);
    L30:
        int r113 = r110[this.f426233b.ordinal()];
        if (r113 == 1) goto L36;
        if (r113 != 2) goto L35;
        RequestBuilder r114 = r108.diskCacheStrategy(DiskCacheStrategy.NONE);
    L37:
        long r115 = ((tkb.b) this.f426241j.getValue()).f546599a;
        if (Size.m4647equalsimpl0(r115, Size.Companion.m4659getUnspecifiedNHjbRc()) == true) goto L40;
        r108.override(MathKt.roundToInt(Float.intBitsToFloat((int) (r115 >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (r115 & BodyPartID.bodyIdMax))));
    L40:
        r108.into(r103);
        this.f426244m = r103;
        return;
    L35:
        throw new IllegalStateException(("Glide does not support an equivalent disk cache policy: " + this.f426233b + " (only Enabled/Disabled are supported).").toString());
    L36:
        RequestBuilder r116 = r108.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        goto L37
    L28:
        throw new IllegalStateException(("Glide does not support an equivalent memory cache policy: " + this.f426234c + " (only Enabled/Disabled are supported).").toString());
    L29:
        RequestBuilder r117 = r108.skipMemoryCache(false);
        goto L30
    L15:
        if ((r105 instanceof com.ss.android.lark.image.compose.android_platform.a.b) == false) goto L18;
        ((com.ss.android.lark.image.compose.android_platform.a.b) r105).getClass();
        r107 = new PolarisFileWrapper(null);
        goto L23
    L18:
        if ((r105 instanceof com.ss.android.lark.image.compose.android_platform.a.c) == false) goto L21;
        ((com.ss.android.lark.image.compose.android_platform.a.c) r105).getClass();
        r107 = 0;
        goto L23
    L21:
        if ((r105 instanceof com.ss.android.lark.image.compose.android_platform.a.C5042a) == false) goto L43;
        r107 = ((com.ss.android.lark.image.compose.android_platform.a.C5042a) r105).f426248a;
        goto L23
    L43:
        throw new NoWhenBranchMatchedException();
    L5:
        r101 = null;
        goto L6
    }

    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f426242k.setValue(r100);
        Painter r101 = r100.a();
        this.f426237f.setValue(r101);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float r100) {
        this.f426238g.setValue(Float.valueOf(r100));
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(ColorFilter r100) {
        this.f426239h.setValue(r100);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(DrawScope r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Painter r101 = (Painter) this.f426237f.getValue();
        if (r101 == null) goto L6;
        r101.m5536drawx_KDEd0(r100, r100.mo5322getSizeNHjbRc(), ((Number) this.f426238g.getValue()).floatValue(), (ColorFilter) this.f426239h.getValue());
        return;
    }

    public GlidePainter(Context r100, com.ss.android.lark.image.compose.android_platform.a r101, tkb.b r102, CachePolicy r103, CachePolicy r104, Painter r105, Painter r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageSource");
        Intrinsics.checkNotNullParameter(r102, "imageOption");
        Intrinsics.checkNotNullParameter(r103, "diskCachePolicy");
        Intrinsics.checkNotNullParameter(r104, "memoryCachePolicy");
        this.f426232a = r100;
        this.f426233b = r103;
        this.f426234c = r104;
        this.f426235d = r105;
        this.f426236e = r106;
        this.f426237f = SnapshotStateKt.mutableStateOf$default(r105, null, 2, null);
        this.f426238g = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        this.f426239h = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.f426240i = j1.a(r101);
        this.f426241j = j1.a(r102);
        StateFlowImpl r107 = j1.a(new c.C5043c(r105));
        this.f426242k = r107;
        this.f426243l = e.b(r107);
    }
}
