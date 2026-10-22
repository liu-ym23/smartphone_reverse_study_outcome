package androidx.compose.foundation.text;

import android.os.Build;
import android.os.Trace;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u001a%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a;\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010H\u0001¢\u0006\u0002\u0010\u0013\u001a\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0015H\u0000\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001a\"\u001a\u0010\u001b\u001a\u00020\u00198@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"LocalBackgroundTextMeasurementExecutor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Ljava/util/concurrent/Executor;", "getLocalBackgroundTextMeasurementExecutor", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "BackgroundTextMeasurement", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/text/AnnotatedString;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "PrefetchTextMinimumCoreCount", "", "MinTextLengthThreshold", "MaxTextLengthThreshold", "backingCoreCountSatisfactory", "", "Ljava/lang/Boolean;", "coreCountSatisfactory", "getCoreCountSatisfactory$annotations", "()V", "getCoreCountSatisfactory", "()Z", "shouldPrefetch", "textLength", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicText_androidKt {
    private static final ProvidableCompositionLocal<Executor> LocalBackgroundTextMeasurementExecutor = null;
    private static final int MaxTextLengthThreshold = 1000;
    private static final int MinTextLengthThreshold = 8;
    private static final int PrefetchTextMinimumCoreCount = 4;
    private static Boolean backingCoreCountSatisfactory;

    private static final Executor LocalBackgroundTextMeasurementExecutor$lambda$0() {
        return null;
    }

    public static /* synthetic */ void a(TextStyle r0, LayoutDirection r1, String r2, Density r3, FontFamily.Resolver r4) {
        BackgroundTextMeasurement$lambda$4$lambda$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void b(TextStyle r0, LayoutDirection r1, List r2, AnnotatedString r3, Density r4, FontFamily.Resolver r5) {
        BackgroundTextMeasurement$lambda$8$lambda$7(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Executor c() {
        return LocalBackgroundTextMeasurementExecutor$lambda$0();
    }

    public static /* synthetic */ void getCoreCountSatisfactory$annotations() {
    }

    static {
        LocalBackgroundTextMeasurementExecutor = CompositionLocalKt.staticCompositionLocalOf(new h1());
    }

    public static final boolean getCoreCountSatisfactory() {
        if (backingCoreCountSatisfactory == null) goto L5;
    L9:
        Boolean r0 = backingCoreCountSatisfactory;
        Intrinsics.checkNotNull(r0);
        return r0.booleanValue();
    L5:
        if (Runtime.getRuntime().availableProcessors() < 4) goto L7;
        boolean r1 = true;
    L8:
        backingCoreCountSatisfactory = Boolean.valueOf(r1);
        goto L9
    L7:
        r1 = false;
        goto L8
    }

    public static final ProvidableCompositionLocal<Executor> getLocalBackgroundTextMeasurementExecutor() {
        return LocalBackgroundTextMeasurementExecutor;
    }

    public static final boolean shouldPrefetch(int r2) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
    L11:
        return false;
    L5:
        if (r2 < 8) goto L11;
        if (r2 >= 1000) goto L11;
        if (getCoreCountSatisfactory() == false) goto L11;
        return true;
    }

    public static final void BackgroundTextMeasurement(final String r8, final TextStyle r9, final FontFamily.Resolver r10, Composer r11, int r12) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1589371739, r12, -1, "androidx.compose.foundation.text.BackgroundTextMeasurement (BasicText.android.kt:68)");
    L5:
        Executor r0 = (Executor) r11.consume(LocalBackgroundTextMeasurementExecutor);
        if (r0 != null) goto L8;
    L31:
        r11.startReplaceGroup(1255196839);
        r11.endReplaceGroup();
    L33:
        if (ComposerKt.isTraceInProgress() == false) goto L39;
        ComposerKt.traceEventEnd();
        return;
    L39:
        return;
    L8:
        if (shouldPrefetch(r8.length()) == false) goto L31;
        r11.startReplaceGroup(1254328095);
        final LayoutDirection r4 = (LayoutDirection) r11.consume(CompositionLocalsKt.getLocalLayoutDirection());
        final Density r6 = (Density) r11.consume(CompositionLocalsKt.getLocalDensity());
        boolean r2 = false;
        if (((r12 & 112) ^ 48) <= 32) goto L14;
    L30:
        r11.endReplaceGroup();
        goto L33
    L12:
        if (r11.changed(r9) == false) goto L14;
    L15:
        boolean r1 = true;
    L17:
        boolean r3 = r1 | r11.changed(r4.ordinal());     // Catch: RejectedExecutionException -> L36
        if (((r12 & 14) ^ 6) <= 4) goto L22;
        if (r11.changed(r8) == false) goto L22;
    L23:
        r2 = true;
    L24:
        boolean r13 = ((r3 | r2) | r11.changed(r6)) | r11.changedInstance(r10);     // Catch: RejectedExecutionException -> L36
        Object r5 = r11.rememberedValue();     // Catch: RejectedExecutionException -> L36
        if (r13 == false) goto L27;
    L28:
        r5 = new g1(r9, r4, r8, r6, r10);     // Catch: RejectedExecutionException -> L36
        r11.updateRememberedValue(r5);     // Catch: RejectedExecutionException -> L36
    L29:
        r0.execute((Runnable) r5);     // Catch: RejectedExecutionException -> L36
        goto L30
    L27:
        if (r5 != Composer.Companion.getEmpty()) goto L29;
    L22:
        if ((r12 & 6) != 4) goto L24;
    L14:
        if ((r12 & 48) == 32) goto L15;
        r1 = false;
        goto L17
    }

    private static final void BackgroundTextMeasurement$lambda$4$lambda$3(TextStyle r10, LayoutDirection r11, String r12, Density r13, FontFamily.Resolver r14) {
        Trace.beginSection("BackgroundTextMeasurement");
        MutableSnapshot r0 = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.Companion, null, null, 3, null);     // Catch: Throwable -> L18
        Snapshot r1 = r0.makeCurrent();     // Catch: Throwable -> L13
        ParagraphIntrinsicsKt.ParagraphIntrinsics$default(r12, TextStyleKt.resolveDefaults(r10, r11), CollectionsKt.emptyList(), r13, r14, null, 32, null).getMaxIntrinsicWidth();     // Catch: Throwable -> L10
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r0.restoreCurrent(r1);     // Catch: Throwable -> L13
        r0.apply().check();     // Catch: Throwable -> L18
        r0.dispose();     // Catch: Throwable -> L18
        Trace.endSection();
        return;
    L10:
        th = move-exception;
        r0.restoreCurrent(r1);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.dispose();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static final void BackgroundTextMeasurement(final AnnotatedString r9, final TextStyle r10, final FontFamily.Resolver r11, final List<AnnotatedString.Range<Placeholder>> r12, Composer r13, int r14) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-650368117, r14, -1, "androidx.compose.foundation.text.BackgroundTextMeasurement (BasicText.android.kt:102)");
    L5:
        Executor r0 = (Executor) r13.consume(LocalBackgroundTextMeasurementExecutor);
        if (r0 != null) goto L8;
    L31:
        r13.startReplaceGroup(-517807721);
        r13.endReplaceGroup();
    L33:
        if (ComposerKt.isTraceInProgress() == false) goto L39;
        ComposerKt.traceEventEnd();
        return;
    L39:
        return;
    L8:
        if (shouldPrefetch(r9.length()) == false) goto L31;
        r13.startReplaceGroup(-518708178);
        final LayoutDirection r4 = (LayoutDirection) r13.consume(CompositionLocalsKt.getLocalLayoutDirection());
        final Density r7 = (Density) r13.consume(CompositionLocalsKt.getLocalDensity());
        boolean r2 = false;
        if (((r14 & 112) ^ 48) <= 32) goto L14;
    L30:
        r13.endReplaceGroup();
        goto L33
    L12:
        if (r13.changed(r10) == false) goto L14;
    L15:
        boolean r1 = true;
    L17:
        boolean r3 = (r1 | r13.changed(r4.ordinal())) | r13.changedInstance(r12);     // Catch: RejectedExecutionException -> L36
        if (((r14 & 14) ^ 6) <= 4) goto L22;
        if (r13.changed(r9) == false) goto L22;
    L23:
        r2 = true;
    L24:
        boolean r15 = ((r3 | r2) | r13.changed(r7)) | r13.changedInstance(r11);     // Catch: RejectedExecutionException -> L36
        Object r5 = r13.rememberedValue();     // Catch: RejectedExecutionException -> L36
        if (r15 == false) goto L27;
    L28:
        r5 = new i1(r10, r4, r12, r9, r7, r11);     // Catch: RejectedExecutionException -> L36
        r13.updateRememberedValue(r5);     // Catch: RejectedExecutionException -> L36
    L29:
        r0.execute((Runnable) r5);     // Catch: RejectedExecutionException -> L36
        goto L30
    L27:
        if (r5 != Composer.Companion.getEmpty()) goto L29;
    L22:
        if ((r14 & 6) != 4) goto L24;
    L14:
        if ((r14 & 48) == 32) goto L15;
        r1 = false;
        goto L17
    }

    private static final void BackgroundTextMeasurement$lambda$8$lambda$7(TextStyle r8, LayoutDirection r9, List r10, AnnotatedString r11, Density r12, FontFamily.Resolver r13) {
        Trace.beginSection("BackgroundTextMeasurement");
        MutableSnapshot r0 = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.Companion, null, null, 3, null);     // Catch: Throwable -> L21
        Snapshot r1 = r0.makeCurrent();     // Catch: Throwable -> L16
        TextStyle r4 = TextStyleKt.resolveDefaults(r8, r9);     // Catch: Throwable -> L13
        if (r10 != null) goto L8;
        r10 = CollectionsKt.emptyList();     // Catch: Throwable -> L13
    L8:
        new MultiParagraphIntrinsics(r11, r4, r10, r12, r13).getMaxIntrinsicWidth();     // Catch: Throwable -> L13
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r0.restoreCurrent(r1);     // Catch: Throwable -> L16
        r0.apply().check();     // Catch: Throwable -> L21
        r0.dispose();     // Catch: Throwable -> L21
        Trace.endSection();
        return;
    L13:
        th = move-exception;
        r0.restoreCurrent(r1);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r0.dispose();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Trace.endSection();
        throw th;
    }
}
