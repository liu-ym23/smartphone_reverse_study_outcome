package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.text.contextmenu.ProcessText_androidKt;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0002\u0010\u0017\u001a#\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 \u001aX\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010&\u001a\u0004\u0018\u00010\r2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\"0(¢\u0006\u0002\b)H\u0000¢\u0006\u0002\b*\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"F\u0010\b\u001a$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006+"}, d2 = {"LocalTextClassifierCoroutineContext", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlin/coroutines/CoroutineContext;", "getLocalTextClassifierCoroutineContext", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "TEXT_CLASSIFIER_INITIALIZATION_TIMEOUT_MILLIS", "", "TEXT_CLASSIFICATION_TIMEOUT_MILLIS", "PlatformSelectionBehaviorsFactory", "Lkotlin/Function4;", "Landroid/content/Context;", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "Landroidx/compose/ui/text/intl/LocaleList;", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviorsFactory$annotations", "()V", "getPlatformSelectionBehaviorsFactory", "()Lkotlin/jvm/functions/Function4;", "setPlatformSelectionBehaviorsFactory", "(Lkotlin/jvm/functions/Function4;)V", "rememberPlatformSelectionBehaviors", "selectedTextType", "localeList", "(Landroidx/compose/foundation/text/selection/SelectedTextType;Landroidx/compose/ui/text/intl/LocaleList;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "canReuse", "", "Landroidx/compose/foundation/text/selection/TextClassificationResult;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "canReuse-h5sm0ck", "(Landroidx/compose/foundation/text/selection/TextClassificationResult;Ljava/lang/CharSequence;J)Z", "addPlatformTextContextMenuItems", "", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "context", "editable", "platformSelectionBehaviors", "child", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "addPlatformTextContextMenuItems-71BSaZU", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlatformSelectionBehaviors_androidKt {
    private static final ProvidableCompositionLocal<CoroutineContext> LocalTextClassifierCoroutineContext = null;
    private static Function4<? super CoroutineContext, ? super Context, ? super SelectedTextType, ? super LocaleList, ? extends PlatformSelectionBehaviors> PlatformSelectionBehaviorsFactory = null;
    private static final long TEXT_CLASSIFICATION_TIMEOUT_MILLIS = 200;
    private static final long TEXT_CLASSIFIER_INITIALIZATION_TIMEOUT_MILLIS = 300;

    public static /* synthetic */ PlatformSelectionBehaviorsImpl a(CoroutineContext r0, Context r1, SelectedTextType r2, LocaleList r3) {
        return PlatformSelectionBehaviorsFactory$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ CoroutineContext b() {
        return LocalTextClassifierCoroutineContext$lambda$0();
    }

    public static /* synthetic */ void getPlatformSelectionBehaviorsFactory$annotations() {
    }

    static {
        LocalTextClassifierCoroutineContext = CompositionLocalKt.staticCompositionLocalOf(new j());
        PlatformSelectionBehaviorsFactory = new k();
    }

    private static final CoroutineContext LocalTextClassifierCoroutineContext$lambda$0() {
        return Dispatchers.getIO();
    }

    public static final ProvidableCompositionLocal<CoroutineContext> getLocalTextClassifierCoroutineContext() {
        return LocalTextClassifierCoroutineContext;
    }

    public static final Function4<CoroutineContext, Context, SelectedTextType, LocaleList, PlatformSelectionBehaviors> getPlatformSelectionBehaviorsFactory() {
        return PlatformSelectionBehaviorsFactory;
    }

    public static final void setPlatformSelectionBehaviorsFactory(Function4<? super CoroutineContext, ? super Context, ? super SelectedTextType, ? super LocaleList, ? extends PlatformSelectionBehaviors> r0) {
        PlatformSelectionBehaviorsFactory = r0;
    }

    /* JADX INFO: renamed from: access$canReuse-h5sm0ck, reason: not valid java name */
    public static final /* synthetic */ boolean m1842access$canReuseh5sm0ck(TextClassificationResult r0, CharSequence r1, long r2) {
        return m1844canReuseh5sm0ck(r0, r1, r2);
    }

    /* JADX INFO: renamed from: canReuse-h5sm0ck, reason: not valid java name */
    private static final boolean m1844canReuseh5sm0ck(TextClassificationResult r2, CharSequence r3, long r4) {
        if (TextRange.equals-impl0(r4, r2.m1890getSelectiond9O1mEE()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r3, r2.getText()) == false) goto L7;
        return true;
    }

    private static final PlatformSelectionBehaviorsImpl PlatformSelectionBehaviorsFactory$lambda$1(CoroutineContext r1, Context r2, SelectedTextType r3, LocaleList r4) {
        return new PlatformSelectionBehaviorsImpl(r1, r2, r3, r4);
    }

    public static final PlatformSelectionBehaviors rememberPlatformSelectionBehaviors(SelectedTextType r7, LocaleList r8, Composer r9, int r10) {
        r9.startReplaceGroup(430530635);
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(430530635, r10, -1, "androidx.compose.foundation.text.selection.rememberPlatformSelectionBehaviors (PlatformSelectionBehaviors.android.kt:94)");
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        Context r0 = (Context) r9.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        CoroutineContext r1 = (CoroutineContext) r9.consume(LocalTextClassifierCoroutineContext);
        boolean r2 = r9.changed(r1) | r9.changed(r0);
        boolean r4 = false;
        if (((r10 & 14) ^ 6) <= 4) goto L17;
        if (r9.changed(r7.ordinal()) == false) goto L17;
    L18:
        boolean r3 = true;
    L20:
        boolean r5 = r2 | r3;
        if (((r10 & 112) ^ 48) <= 32) goto L25;
        if (r9.changed(r8) == false) goto L25;
    L26:
        r4 = true;
    L27:
        boolean r11 = r5 | r4;
        Object r6 = r9.rememberedValue();
        if (r11 == false) goto L30;
    L31:
        r6 = (PlatformSelectionBehaviors) PlatformSelectionBehaviorsFactory.invoke(r1, r0, r7, r8);
        r9.updateRememberedValue(r6);
    L32:
        PlatformSelectionBehaviors r12 = (PlatformSelectionBehaviors) r6;
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
    L35:
        r9.endReplaceGroup();
        return r12;
    L30:
        if (r6 != Composer.Companion.getEmpty()) goto L32;
    L25:
        if ((r10 & 48) != 32) goto L27;
    L17:
        if ((r10 & 6) == 4) goto L18;
        r3 = false;
        goto L20
    L8:
        if (ComposerKt.isTraceInProgress() == false) goto L10;
        ComposerKt.traceEventEnd();
    L10:
        r9.endReplaceGroup();
        return null;
    }

    /* JADX INFO: renamed from: addPlatformTextContextMenuItems-71BSaZU, reason: not valid java name */
    public static final void m1843addPlatformTextContextMenuItems71BSaZU(TextContextMenuBuilderScope r6, Context r7, boolean r8, CharSequence r9, TextRange r10, PlatformSelectionBehaviors r11, Function1<? super TextContextMenuBuilderScope, Unit> r12) {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        if (r9 == null) goto L12;
        if (r10 == null) goto L12;
        if (r11 == null) goto L12;
        if ((r11 instanceof PlatformSelectionBehaviorsImpl) == false) goto L12;
        ((PlatformSelectionBehaviorsImpl) r11).m1840addSmartSelectionTextContextMenuItemsYmzfRxQ$foundation_release(r6, r9, r10.unbox-impl(), r12);
        ProcessText_androidKt.m1491addProcessedTextContextMenuItemsUAq72N0(r6, r7, r8, r9, r10.unbox-impl());
        return;
    L12:
        r12.invoke(r6);
        if (r9 == null) goto L17;
        if (r10 == null) goto L18;
        ProcessText_androidKt.m1491addProcessedTextContextMenuItemsUAq72N0(r6, r7, r8, r9, r10.unbox-impl());
        return;
    L18:
        return;
    }
}
