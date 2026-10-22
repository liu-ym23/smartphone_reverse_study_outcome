package androidx.compose.foundation.text;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a_\u0010\b\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u000b0\n\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\n0\t*\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\rH\u0000\u001a>\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2'\u0010\u0015\u001a#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\nH\u0001¢\u0006\u0002\u0010\u0016\"K\u0010\u0017\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u000b0\n\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001j\u0002`\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001*:\b\u0000\u0010\u0003\"\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u00012\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0001¨\u0006\u0018"}, d2 = {"PlaceholderRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "InlineContentRange", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "resolveInlineContent", "Lkotlin/Pair;", "", "Landroidx/compose/foundation/text/PlaceholderRange;", "Landroidx/compose/foundation/text/InlineContentRange;", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "hasInlineContent", "", "InlineChildren", "text", "inlineContents", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "EmptyInlineContent", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnnotatedStringResolveInlineContentKt {
    private static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> EmptyInlineContent = null;

    private static final Unit InlineChildren$lambda$5(AnnotatedString r0, List r1, int r2, Composer r3, int r4) {
        InlineChildren(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(AnnotatedString r0, List r1, int r2, Composer r3, int r4) {
        return InlineChildren$lambda$5(r0, r1, r2, r3, r4);
    }

    static {
        EmptyInlineContent = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public static final boolean hasInlineContent(AnnotatedString r3) {
        return r3.hasStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, r3.getText().length());
    }

    public static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent(AnnotatedString r10, Map<String, InlineTextContent> r11) {
        int r0 = 0;
        if (r11 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        List r12 = r10.getStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, r10.getText().length());
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        int r4 = r12.size();
    L13:
        if (r0 >= r4) goto L19;
        AnnotatedString.Range r5 = (AnnotatedString.Range) ListProtector.get(r12, r0);
        InlineTextContent r6 = r11.get(r5.getItem());
        if (r6 == null) goto L17;
        r2.add(new AnnotatedString.Range(r6.getPlaceholder(), r5.getStart(), r5.getEnd()));
        r3.add(new AnnotatedString.Range(r6.getChildren(), r5.getStart(), r5.getEnd()));
    L17:
        r0 = r0 + 1;
        goto L13
    L19:
        return new Pair(r2, r3);
    L11:
        return EmptyInlineContent;
    L5:
        if (r11.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final void InlineChildren(final AnnotatedString r17, final List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> r18, Composer r19, final int r20) {
        Composer r4 = r19.startRestartGroup(-1794596951);
        if ((r20 & 6) == 0) goto L5;
        int r5 = r20;
    L10:
        char r7 = ' ';
        if ((r20 & 48) == 0) goto L13;
    L17:
        int r9 = 0;
        if ((r5 & 19) == 18) goto L20;
        boolean r6 = true;
    L22:
        if (r4.shouldExecute(r6, r5 & 1) == true) goto L24;
        r4.skipToGroupEnd();
    L48:
        ScopeUpdateScope r3 = r4.endRestartGroup();
        if (r3 == null) goto L55;
        r3.updateScope(new f(r17, r18, r20));
        return;
    L55:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1794596951, r5, -1, "androidx.compose.foundation.text.InlineChildren (AnnotatedStringResolveInlineContent.kt:67)");
    L26:
        int r8 = r18.size();
        int r10 = 0;
    L27:
        if (r10 >= r8) goto L45;
        AnnotatedString.Range r11 = (AnnotatedString.Range) ListProtector.get(r18, r10);
        Function3 r12 = (Function3) r11.component1();
        int r13 = r11.component2();
        int r14 = r11.component3();
        Object r15 = r4.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L31;
        r15 = AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1.INSTANCE;
        r4.updateRememberedValue(r15);
    L31:
        MeasurePolicy r16 = (MeasurePolicy) r15;
        Modifier.Companion r110 = Modifier.Companion;
        long r111 = ComposablesKt.getCurrentCompositeKeyHashCode(r4, r9);
        int r112 = (int) (r111 ^ (r111 >>> r7));
        CompositionLocalMap r113 = r4.getCurrentCompositionLocalMap();
        Modifier r114 = ComposedModifierKt.materializeModifier(r4, r110);
        ComposeUiNode.Companion r115 = ComposeUiNode.Companion;
        Function0 r21 = r115.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L34;
        ComposablesKt.invalidApplier();
    L34:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L37;
        r4.createNode(r21);
    L38:
        Composer r22 = Updater.constructor-impl(r4);
        Updater.set-impl(r22, r16, r115.getSetMeasurePolicy());
        Updater.set-impl(r22, r113, r115.getSetResolvedCompositionLocals());
        Function2 r23 = r115.getSetCompositeKeyHash();
        if (r22.getInserting() == false) goto L41;
    L42:
        r22.updateRememberedValue(Integer.valueOf(r112));
        r22.apply(Integer.valueOf(r112), r23);
    L43:
        Updater.set-impl(r22, r114, r115.getSetModifier());
        r12.invoke(r17.subSequence(r13, r14).getText(), r4, 0);
        r4.endNode();
        r10 = r10 + 1;
        r7 = ' ';
        r9 = 0;
        goto L27
    L41:
        if (Intrinsics.areEqual(r22.rememberedValue(), Integer.valueOf(r112)) == true) goto L43;
    L37:
        r4.useNode();
        goto L38
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventEnd();
        goto L48
    L20:
        r6 = false;
        goto L22
    L13:
        if (r4.changedInstance(r18) == false) goto L15;
        int r24 = 32;
    L16:
        r5 = r5 | r24;
        goto L17
    L15:
        r24 = 16;
        goto L16
    L5:
        if (r4.changed(r17) == false) goto L7;
        int r25 = 4;
    L8:
        r5 = r25 | r20;
        goto L10
    L7:
        r25 = 2;
        goto L8
    }
}
