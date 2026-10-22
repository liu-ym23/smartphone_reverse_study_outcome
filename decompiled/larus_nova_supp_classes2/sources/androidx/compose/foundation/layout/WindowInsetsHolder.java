package androidx.compose.foundation.layout;

import android.view.View;
import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000 H2\u00020\u0001:\u0001HB\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010@\u001a\u00020A2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010B\u001a\u00020A2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020=J\u000e\u0010F\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0003J\u000e\u0010G\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0003R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010&\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010(\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010*\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010,\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010.\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u00100\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u00102\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u00104\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0017\u00106\u001a\u000207¢\u0006\u000e\n\u0000\u0012\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder;", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "view", "Landroid/view/View;", "<init>", "(Landroidx/core/view/WindowInsetsCompat;Landroid/view/View;)V", "captionBar", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getCaptionBar", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "displayCutout", "getDisplayCutout", "ime", "getIme", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "statusBars", "getStatusBars", "systemBars", "getSystemBars", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "waterfall", "Landroidx/compose/foundation/layout/ValueInsets;", "getWaterfall", "()Landroidx/compose/foundation/layout/ValueInsets;", "safeDrawing", "Landroidx/compose/foundation/layout/WindowInsets;", "getSafeDrawing", "()Landroidx/compose/foundation/layout/WindowInsets;", "safeGestures", "getSafeGestures", "safeContent", "getSafeContent", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility", "imeAnimationTarget", "getImeAnimationTarget", "imeAnimationSource", "getImeAnimationSource", "consumes", "", "getConsumes$annotations", "()V", "getConsumes", "()Z", "accessCount", "", "insetsListener", "Landroidx/compose/foundation/layout/InsetsListener;", "incrementAccessors", "", "decrementAccessors", "update", "windowInsets", "types", "updateImeAnimationSource", "updateImeAnimationTarget", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsHolder {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static boolean testInsets;
    private static final WeakHashMap<View, WindowInsetsHolder> viewMap = null;
    private int accessCount;
    private final AndroidWindowInsets captionBar;
    private final ValueInsets captionBarIgnoringVisibility;
    private final boolean consumes;
    private final AndroidWindowInsets displayCutout;
    private final AndroidWindowInsets ime;
    private final ValueInsets imeAnimationSource;
    private final ValueInsets imeAnimationTarget;
    private final InsetsListener insetsListener;
    private final AndroidWindowInsets mandatorySystemGestures;
    private final AndroidWindowInsets navigationBars;
    private final ValueInsets navigationBarsIgnoringVisibility;
    private final WindowInsets safeContent;
    private final WindowInsets safeDrawing;
    private final WindowInsets safeGestures;
    private final AndroidWindowInsets statusBars;
    private final ValueInsets statusBarsIgnoringVisibility;
    private final AndroidWindowInsets systemBars;
    private final ValueInsets systemBarsIgnoringVisibility;
    private final AndroidWindowInsets systemGestures;
    private final AndroidWindowInsets tappableElement;
    private final ValueInsets tappableElementIgnoringVisibility;
    private final ValueInsets waterfall;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\r\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsHolder$Companion;", "", "<init>", "()V", "viewMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "testInsets", "", "setUseTestInsets", "", "current", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsetsHolder;", "getOrCreateFor", "view", "systemInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "type", "", HintConstants.AUTOFILL_HINT_NAME, "", "valueInsetsIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ DisposableEffectResult a(WindowInsetsHolder r0, View r1, DisposableEffectScope r2) {
            return current$lambda$2$lambda$1(r0, r1, r2);
        }

        private final WindowInsetsHolder getOrCreateFor(View r5) {
            WeakHashMap r0 = WindowInsetsHolder.access$getViewMap$cp();
            monitor-enter(r0);
            WeakHashMap r1 = WindowInsetsHolder.access$getViewMap$cp();     // Catch: Throwable -> L10
            Object r2 = r1.get(r5);     // Catch: Throwable -> L10
            if (r2 != null) goto L7;
            WindowInsetsCompat r3 = null;
            r2 = new WindowInsetsHolder(r3, r5, r3);     // Catch: Throwable -> L10
            r1.put(r5, r2);     // Catch: Throwable -> L10
        L7:
            WindowInsetsHolder r4 = (WindowInsetsHolder) r2;     // Catch: Throwable -> L10
            monitor-exit(r0);
            return r4;
        L10:
            th = move-exception;
            throw th;
        }

        public final void setUseTestInsets(boolean r1) {
            WindowInsetsHolder.access$setTestInsets$cp(r1);
        }

        public final WindowInsetsHolder current(Composer r4, int r5) {
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-1366542614, r5, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:549)");
        L5:
            final View r6 = (View) r4.consume(AndroidCompositionLocals_androidKt.getLocalView());
            final WindowInsetsHolder r0 = getOrCreateFor(r6);
            boolean r1 = r4.changedInstance(r0) | r4.changedInstance(r6);
            Object r2 = r4.rememberedValue();
            if (r1 == false) goto L8;
        L9:
            r2 = new h2(r0, r6);
            r4.updateRememberedValue(r2);
        L10:
            EffectsKt.DisposableEffect(r0, (Function1) r2, r4, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L13;
            ComposerKt.traceEventEnd();
        L13:
            return r0;
        L8:
            if (r2 != Composer.Companion.getEmpty()) goto L10;
            goto L9
        }

        private static final DisposableEffectResult current$lambda$2$lambda$1(final WindowInsetsHolder r0, final View r1, DisposableEffectScope r2) {
            r0.incrementAccessors(r1);
            return new WindowInsetsHolder$Companion$current$lambda$2$lambda$1$$inlined$onDispose$1(r0, r1);
        }

        private final AndroidWindowInsets systemInsets(WindowInsetsCompat r2, int r3, String r4) {
            AndroidWindowInsets r0 = new AndroidWindowInsets(r3, r4);
            if (r2 == null) goto L5;
            r0.update$foundation_layout(r2, r3);
        L5:
            return r0;
        }

        private final ValueInsets valueInsetsIgnoringVisibility(WindowInsetsCompat r1, int r2, String r3) {
            if (r1 == null) goto L5;
            Insets r4 = r1.getInsetsIgnoringVisibility(r2);
            if (r4 == null) goto L5;
        L7:
            return WindowInsets_androidKt.ValueInsets(r4, r3);
        L5:
            r4 = Insets.NONE;
            goto L7
        }

        public static final /* synthetic */ AndroidWindowInsets access$systemInsets(Companion r0, WindowInsetsCompat r1, int r2, String r3) {
            return r0.systemInsets(r1, r2, r3);
        }

        public static final /* synthetic */ ValueInsets access$valueInsetsIgnoringVisibility(Companion r0, WindowInsetsCompat r1, int r2, String r3) {
            return r0.valueInsetsIgnoringVisibility(r1, r2, r3);
        }
    }

    public /* synthetic */ WindowInsetsHolder(WindowInsetsCompat r1, View r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public static /* synthetic */ void getConsumes$annotations() {
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        viewMap = new WeakHashMap();
    }

    public static final /* synthetic */ WeakHashMap access$getViewMap$cp() {
        return viewMap;
    }

    public final AndroidWindowInsets getCaptionBar() {
        return this.captionBar;
    }

    public final ValueInsets getCaptionBarIgnoringVisibility() {
        return this.captionBarIgnoringVisibility;
    }

    public final boolean getConsumes() {
        return this.consumes;
    }

    public final AndroidWindowInsets getDisplayCutout() {
        return this.displayCutout;
    }

    public final AndroidWindowInsets getIme() {
        return this.ime;
    }

    public final ValueInsets getImeAnimationSource() {
        return this.imeAnimationSource;
    }

    public final ValueInsets getImeAnimationTarget() {
        return this.imeAnimationTarget;
    }

    public final AndroidWindowInsets getMandatorySystemGestures() {
        return this.mandatorySystemGestures;
    }

    public final AndroidWindowInsets getNavigationBars() {
        return this.navigationBars;
    }

    public final ValueInsets getNavigationBarsIgnoringVisibility() {
        return this.navigationBarsIgnoringVisibility;
    }

    public final WindowInsets getSafeContent() {
        return this.safeContent;
    }

    public final WindowInsets getSafeDrawing() {
        return this.safeDrawing;
    }

    public final WindowInsets getSafeGestures() {
        return this.safeGestures;
    }

    public final AndroidWindowInsets getStatusBars() {
        return this.statusBars;
    }

    public final ValueInsets getStatusBarsIgnoringVisibility() {
        return this.statusBarsIgnoringVisibility;
    }

    public final AndroidWindowInsets getSystemBars() {
        return this.systemBars;
    }

    public final ValueInsets getSystemBarsIgnoringVisibility() {
        return this.systemBarsIgnoringVisibility;
    }

    public final AndroidWindowInsets getSystemGestures() {
        return this.systemGestures;
    }

    public final AndroidWindowInsets getTappableElement() {
        return this.tappableElement;
    }

    public final ValueInsets getTappableElementIgnoringVisibility() {
        return this.tappableElementIgnoringVisibility;
    }

    public final ValueInsets getWaterfall() {
        return this.waterfall;
    }

    public static final /* synthetic */ void access$setTestInsets$cp(boolean r0) {
        testInsets = r0;
    }

    public final void decrementAccessors(View r2) {
        int r0 = this.accessCount - 1;
        this.accessCount = r0;
        if (r0 != 0) goto L6;
        ViewCompat.setOnApplyWindowInsetsListener(r2, null);
        ViewCompat.setWindowInsetsAnimationCallback(r2, null);
        r2.removeOnAttachStateChangeListener(this.insetsListener);
        return;
    }

    public final void incrementAccessors(View r2) {
        if (this.accessCount != 0) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(r2, this.insetsListener);
        if (r2.isAttachedToWindow() == false) goto L7;
        r2.requestApplyInsets();
    L7:
        r2.addOnAttachStateChangeListener(this.insetsListener);
        ViewCompat.setWindowInsetsAnimationCallback(r2, this.insetsListener);
    L8:
        this.accessCount++;
    }

    public final void updateImeAnimationSource(WindowInsetsCompat r3) {
        this.imeAnimationSource.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r3.getInsets(WindowInsetsCompat.Type.ime())));
    }

    public final void updateImeAnimationTarget(WindowInsetsCompat r3) {
        this.imeAnimationTarget.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r3.getInsets(WindowInsetsCompat.Type.ime())));
    }

    private WindowInsetsHolder(WindowInsetsCompat r10, View r11) {
        Companion r0 = Companion;
        this.captionBar = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.captionBar(), "captionBar");
        AndroidWindowInsets r1 = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.displayCutout(), "displayCutout");
        this.displayCutout = r1;
        AndroidWindowInsets r2 = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.ime(), "ime");
        this.ime = r2;
        AndroidWindowInsets r3 = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.mandatorySystemGestures(), "mandatorySystemGestures");
        this.mandatorySystemGestures = r3;
        this.navigationBars = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.navigationBars(), "navigationBars");
        this.statusBars = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.statusBars(), "statusBars");
        AndroidWindowInsets r4 = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.systemBars(), "systemBars");
        this.systemBars = r4;
        AndroidWindowInsets r5 = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.systemGestures(), "systemGestures");
        this.systemGestures = r5;
        AndroidWindowInsets r6 = Companion.access$systemInsets(r0, r10, WindowInsetsCompat.Type.tappableElement(), "tappableElement");
        this.tappableElement = r6;
        if (r10 == null) goto L8;
        DisplayCutoutCompat r7 = r10.getDisplayCutout();
        if (r7 == null) goto L8;
        Insets r8 = r7.getWaterfallInsets();
        if (r8 == null) goto L8;
    L9:
        ValueInsets r9 = WindowInsets_androidKt.ValueInsets(r8, "waterfall");
        this.waterfall = r9;
        WindowInsets r12 = WindowInsetsKt.union(WindowInsetsKt.union(r4, r2), r1);
        this.safeDrawing = r12;
        WindowInsets r13 = WindowInsetsKt.union(WindowInsetsKt.union(WindowInsetsKt.union(r6, r3), r5), r9);
        this.safeGestures = r13;
        this.safeContent = WindowInsetsKt.union(r12, r13);
        this.captionBarIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r0, r10, WindowInsetsCompat.Type.captionBar(), "captionBarIgnoringVisibility");
        this.navigationBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r0, r10, WindowInsetsCompat.Type.navigationBars(), "navigationBarsIgnoringVisibility");
        this.statusBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r0, r10, WindowInsetsCompat.Type.statusBars(), "statusBarsIgnoringVisibility");
        this.systemBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r0, r10, WindowInsetsCompat.Type.systemBars(), "systemBarsIgnoringVisibility");
        this.tappableElementIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(r0, r10, WindowInsetsCompat.Type.tappableElement(), "tappableElementIgnoringVisibility");
        this.imeAnimationTarget = Companion.access$valueInsetsIgnoringVisibility(r0, r10, WindowInsetsCompat.Type.ime(), "imeAnimationTarget");
        this.imeAnimationSource = Companion.access$valueInsetsIgnoringVisibility(r0, r10, WindowInsetsCompat.Type.ime(), "imeAnimationSource");
        Object r14 = r11.getParent();
        Boolean r15 = null;
        if ((r14 instanceof View) == false) goto L12;
        View r16 = (View) r14;
    L13:
        if (r16 == null) goto L15;
        Object r17 = r16.getTag(2131367706);
    L17:
        if ((r17 instanceof Boolean) == false) goto L19;
        r15 = (Boolean) r17;
    L19:
        if (r15 == null) goto L22;
        boolean r18 = r15.booleanValue();
    L25:
        this.consumes = r18;
        this.insetsListener = new InsetsListener(this);
        return;
    L22:
        if (ComposeFoundationLayoutFlags.isWindowInsetsDefaultPassThroughEnabled == true) goto L24;
        r18 = true;
        goto L25
    L24:
        r18 = false;
        goto L25
    L15:
        r17 = null;
        goto L17
    L12:
        r16 = null;
    L8:
        r8 = Insets.NONE;
        goto L9
    }

    public final void update(WindowInsetsCompat r2, int r3) {
        if (testInsets == false) goto L5;
        android.view.WindowInsets r4 = r2.toWindowInsets();
        Intrinsics.checkNotNull(r4);
        r2 = WindowInsetsCompat.toWindowInsetsCompat(r4);
    L5:
        this.captionBar.update$foundation_layout(r2, r3);
        this.ime.update$foundation_layout(r2, r3);
        this.displayCutout.update$foundation_layout(r2, r3);
        this.navigationBars.update$foundation_layout(r2, r3);
        this.statusBars.update$foundation_layout(r2, r3);
        this.systemBars.update$foundation_layout(r2, r3);
        this.systemGestures.update$foundation_layout(r2, r3);
        this.tappableElement.update$foundation_layout(r2, r3);
        this.mandatorySystemGestures.update$foundation_layout(r2, r3);
        if (r3 != 0) goto L10;
        this.captionBarIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r2.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.captionBar())));
        this.navigationBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r2.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars())));
        this.statusBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r2.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.statusBars())));
        this.systemBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r2.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars())));
        this.tappableElementIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r2.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement())));
        DisplayCutoutCompat r5 = r2.getDisplayCutout();
        if (r5 == null) goto L10;
        Insets r6 = r5.getWaterfallInsets();
        this.waterfall.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(r6));
    L10:
        Snapshot.Companion.sendApplyNotifications();
    }

    public static /* synthetic */ void update$default(WindowInsetsHolder r0, WindowInsetsCompat r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.update(r1, r2);
    }
}
