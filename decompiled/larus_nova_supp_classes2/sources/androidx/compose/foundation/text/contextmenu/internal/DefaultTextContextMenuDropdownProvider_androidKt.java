package androidx.compose.foundation.text.contextmenu.internal;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProvider;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b\u001a+\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010\u0019\u001a!\u0010\u001a\u001a\u00020\u00012\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0004\b\u001f\u0010 \"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"ProvideDefaultTextContextMenuDropdown", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "defaultTextContextMenuDropdown", "Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "OpenContextMenu", "session", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "dataProvider", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DefaultTextContextMenuDropdown", "data", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "(Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;Landroidx/compose/runtime/Composer;I)V", "IconBox", "resId", "", "tint", "Landroidx/compose/ui/graphics/Color;", "IconBox-RPmYEkk", "(IJLandroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DefaultTextContextMenuDropdownProvider_androidKt {
    private static final PopupProperties DefaultPopupProperties = null;

    private static final Unit DefaultTextContextMenuDropdown$lambda$11(TextContextMenuSession r0, TextContextMenuData r1, int r2, Composer r3, int r4) {
        DefaultTextContextMenuDropdown(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit IconBox_RPmYEkk$lambda$13(int r0, long r1, int r3, Composer r4, int r5) {
        m1493IconBoxRPmYEkk(r0, r1, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit IconBox_RPmYEkk$lambda$15(int r0, long r1, int r3, Composer r4, int r5) {
        m1493IconBoxRPmYEkk(r0, r1, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit OpenContextMenu$lambda$6(TextContextMenuSession r0, TextContextMenuDataProvider r1, Function0 r2, int r3, Composer r4, int r5) {
        OpenContextMenu(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ProvideDefaultTextContextMenuDropdown$lambda$0(Function2 r0, int r1, Composer r2, int r3) {
        ProvideDefaultTextContextMenuDropdown(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ProvideDefaultTextContextMenuDropdown$lambda$1(Modifier r0, Function2 r1, int r2, Composer r3, int r4) {
        ProvideDefaultTextContextMenuDropdown(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextContextMenuComponent r0, TextContextMenuSession r1) {
        return DefaultTextContextMenuDropdown$lambda$10$lambda$9$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit b(Function2 r0, int r1, Composer r2, int r3) {
        return ProvideDefaultTextContextMenuDropdown$lambda$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit c(TextContextMenuSession r0, TextContextMenuDataProvider r1, Function0 r2, int r3, Composer r4, int r5) {
        return OpenContextMenu$lambda$6(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit d(int r0, long r1, int r3, Composer r4, int r5) {
        return IconBox_RPmYEkk$lambda$15(r0, r1, r3, r4, r5);
    }

    public static /* synthetic */ Unit e(TextContextMenuData r0, Context r1, TextContextMenuSession r2, ContextMenuScope r3) {
        return DefaultTextContextMenuDropdown$lambda$10$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit f(TextContextMenuSession r0, TextContextMenuData r1, int r2, Composer r3, int r4) {
        return DefaultTextContextMenuDropdown$lambda$11(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit g(TextContextMenuSession r0) {
        return OpenContextMenu$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Unit h(int r0, long r1, int r3, Composer r4, int r5) {
        return IconBox_RPmYEkk$lambda$13(r0, r1, r3, r4, r5);
    }

    public static /* synthetic */ Unit i(Modifier r0, Function2 r1, int r2, Composer r3, int r4) {
        return ProvideDefaultTextContextMenuDropdown$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ IntOffset j(TextContextMenuDataProvider r0, Function0 r1) {
        return OpenContextMenu$lambda$3$lambda$2(r0, r1);
    }

    static {
        DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, null);
    }

    private static final Unit OpenContextMenu$lambda$5$lambda$4(TextContextMenuSession r0) {
        r0.close();
        return Unit.INSTANCE;
    }

    private static final Unit DefaultTextContextMenuDropdown$lambda$10$lambda$9$lambda$8$lambda$7(TextContextMenuComponent r0, TextContextMenuSession r1) {
        ((TextContextMenuItem) r0).getOnClick().invoke(r1);
        return Unit.INSTANCE;
    }

    private static final IntOffset OpenContextMenu$lambda$3$lambda$2(TextContextMenuDataProvider r0, Function0 r1) {
        return IntOffset.box-impl(IntOffsetKt.round-k-4lQ0M(r0.mo1513positiontuRUvjQ((LayoutCoordinates) r1.invoke())));
    }

    public static final BasicTextContextMenuProvider defaultTextContextMenuDropdown(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1197778906, r4, -1, "androidx.compose.foundation.text.contextmenu.internal.defaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:98)");
    L5:
        BasicTextContextMenuProvider r5 = BasicTextContextMenuProviderKt.basicTextContextMenuProvider(ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.m1492getLambda$1357803046$foundation_release(), r3, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static final void ProvideDefaultTextContextMenuDropdown(final Function2<? super Composer, ? super Integer, Unit> r4, Composer r5, final int r6) {
        Composer r7 = r5.startRestartGroup(422095256);
        if ((r6 & 6) == 0) goto L5;
        int r1 = r6;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r7.shouldExecute(r2, r1 & 1) == true) goto L17;
        r7.skipToGroupEnd();
    L23:
        ScopeUpdateScope r8 = r7.endRestartGroup();
        if (r8 == null) goto L27;
        r8.updateScope(new q(r4, r6));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(422095256, r1, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideDefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:71)");
    L19:
        BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider(), ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.getLambda$129995601$foundation_release(), r4, r7, ((r1 << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r7.changedInstance(r4) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r6;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }

    private static final void DefaultTextContextMenuDropdown(final TextContextMenuSession r9, final TextContextMenuData r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(1904307118);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L14:
        if ((r12 & 48) == 0) goto L16;
    L20:
        boolean r5 = false;
        if ((r1 & 19) == 18) goto L23;
        boolean r3 = true;
    L25:
        if (r13.shouldExecute(r3, r1 & 1) == true) goto L27;
        r13.skipToGroupEnd();
    L49:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L53;
        r14.updateScope(new x(r9, r10, r12));
        return;
    L53:
        return;
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventStart(1904307118, r1, -1, "androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:133)");
    L30:
        if (Build.VERSION.SDK_INT < 28) goto L32;
        r13.startReplaceGroup(-1009462744);
        final Context r0 = (Context) r13.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        r13.endReplaceGroup();
    L33:
        boolean r7 = r13.changedInstance(r10);
        if ((r1 & 14) != 4) goto L36;
    L39:
        r5 = true;
    L40:
        boolean r2 = (r7 | r5) | r13.changedInstance(r0);
        Object r4 = r13.rememberedValue();
        if (r2 == false) goto L43;
    L44:
        r4 = new w(r10, r0, r9);
        r13.updateRememberedValue(r4);
    L45:
        ContextMenuUi_androidKt.ContextMenuColumnBuilder(null, null, (Function1) r4, r13, 0, 3);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
        goto L49
    L43:
        if (r4 != Composer.Companion.getEmpty()) goto L45;
    L36:
        if ((r1 & 8) == 0) goto L40;
        if (r13.changedInstance(r9) == false) goto L40;
    L32:
        r13.startReplaceGroup(-1009413640);
        r13.endReplaceGroup();
        r0 = null;
        goto L33
    L23:
        r3 = false;
        goto L25
    L16:
        if (r13.changedInstance(r10) == false) goto L18;
        int r6 = 32;
    L19:
        r1 = r1 | r6;
        goto L20
    L18:
        r6 = 16;
        goto L19
    L5:
        if ((r12 & 8) != 0) goto L7;
        boolean r8 = r13.changed(r9);
    L8:
        if (r8 == false) goto L10;
        int r15 = 4;
    L11:
        r1 = r15 | r12;
        goto L14
    L10:
        r15 = 2;
        goto L11
    L7:
        r8 = r13.changedInstance(r9);
        goto L8
    }

    private static final Unit DefaultTextContextMenuDropdown$lambda$10$lambda$9(TextContextMenuData r12, Context r13, final TextContextMenuSession r14, ContextMenuScope r15) {
        List<TextContextMenuComponent> r16 = r12.getComponents();
        int r0 = r16.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        final TextContextMenuComponent r2 = (TextContextMenuComponent) ListProtector.get(r16, r1);
        if ((r2 instanceof TextContextMenuItem) == false) goto L12;
        Function2<Composer, Integer, String> r5 = new DefaultTextContextMenuDropdownProvider_androidKt$DefaultTextContextMenuDropdown$1$1$1$1(r2);
        if (((TextContextMenuItem) r2).getLeadingIcon() != 0) goto L9;
        ComposableLambda r3 = null;
    L10:
        ContextMenuScope.item$default(r15, r5, null, false, r3, new z(r2, r14), 6, null);
    L19:
        r1 = r1 + 1;
        goto L3
    L9:
        r3 = ComposableLambdaKt.composableLambdaInstance(-1930700965, true, new DefaultTextContextMenuDropdownProvider_androidKt$DefaultTextContextMenuDropdown$1$1$1$2(r2));
        goto L10
    L12:
        if ((r2 instanceof TextContextMenuTextClassificationItem) == false) goto L17;
        if (Build.VERSION.SDK_INT < 28) goto L19;
        TextContextMenuHelperApi28.INSTANCE.textClassificationItem(r15, r13, (TextContextMenuTextClassificationItem) r2);
        goto L19
    L17:
        if ((r2 instanceof TextContextMenuSeparator) == false) goto L19;
        r15.separator();
        goto L19
    L21:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: IconBox-RPmYEkk, reason: not valid java name */
    private static final void m1493IconBoxRPmYEkk(final int r22, final long r23, Composer r25, final int r26) {
        Composer r10 = r25.startRestartGroup(-1240244237);
        if ((r26 & 6) == 0) goto L5;
        int r2 = r26;
    L11:
        if ((r26 & 48) == 0) goto L13;
    L17:
        boolean r11 = true;
        if ((r2 & 19) == 18) goto L20;
        boolean r4 = true;
    L22:
        if (r10.shouldExecute(r4, r2 & 1) == true) goto L24;
        r10.skipToGroupEnd();
    L64:
        ScopeUpdateScope r1 = r10.endRestartGroup();
        if (r1 == null) goto L69;
        r1.updateScope(new v(r22, r23, r26));
        return;
    L69:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1240244237, r2, -1, "androidx.compose.foundation.text.contextmenu.internal.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:166)");
    L26:
        Context r3 = (Context) r10.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        boolean r5 = r10.changed(r3);
        if ((r2 & 14) != 4) goto L29;
        boolean r6 = true;
    L30:
        boolean r7 = r6 | r5;
        Object r8 = r10.rememberedValue();
        if (r7 == false) goto L33;
    L34:
        r8 = Integer.valueOf(r3.obtainStyledAttributes(new int[]{r22}).getResourceId(0, -1));
        r10.updateRememberedValue(r8);
    L35:
        int r9 = ((Number) r8).intValue();
        if (r9 == (-1)) goto L38;
        Painter r14 = PainterResources_androidKt.painterResource(r9, r10, 0);
        if ((r2 & 112) != 32) goto L47;
        boolean r12 = true;
    L48:
        Object r13 = r10.rememberedValue();
        if (r12 == true) goto L53;
        if (r13 == Composer.Companion.getEmpty()) goto L53;
    L60:
        BoxKt.Box(PainterModifierKt.paint$default(SizeKt.m1014size3ABfNKs(Modifier.Companion, ContextMenuSpec.INSTANCE.m481getIconSizeD9Ej5fM()), r14, false, null, ContentScale.Companion.getFit(), MenuKt.ClosedAlphaTarget, (ColorFilter) r13, 22, null), r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L64;
        ComposerKt.traceEventEnd();
    L53:
        if (r23 == 16) goto L56;
        r11 = false;
    L56:
        if (r11 == false) goto L58;
        ColorFilter r15 = null;
    L59:
        r13 = r15;
        r10.updateRememberedValue(r13);
        goto L60
    L58:
        r15 = ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, r23, 0, 2, null);
        goto L59
    L47:
        r12 = false;
        goto L48
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventEnd();
    L40:
        ScopeUpdateScope r16 = r10.endRestartGroup();
        if (r16 == null) goto L68;
        r16.updateScope(new u(r22, r23, r26));
        return;
    L68:
        return;
    L33:
        if (r8 != Composer.Companion.getEmpty()) goto L35;
    L29:
        r6 = false;
        goto L30
    L20:
        r4 = false;
        goto L22
    L13:
        if (r10.changed(r23) == false) goto L15;
        int r17 = 32;
    L16:
        r2 = r2 | r17;
        goto L17
    L15:
        r17 = 16;
        goto L16
    L5:
        if (r10.changed(r22) == false) goto L7;
        int r18 = 4;
    L8:
        r2 = r18 | r26;
        goto L11
    L7:
        r18 = 2;
        goto L8
    }

    public static final void ProvideDefaultTextContextMenuDropdown(final Modifier r7, final Function2<? super Composer, ? super Integer, Unit> r8, Composer r9, final int r10) {
        Composer r11 = r9.startRestartGroup(1392105195);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L11:
        if ((r10 & 48) != 0) goto L18;
        if (r11.changedInstance(r8) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r11.shouldExecute(r3, r1 & 1) == true) goto L24;
        r11.skipToGroupEnd();
    L30:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L34;
        r12.updateScope(new y(r7, r8, r10));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1392105195, r1, -1, "androidx.compose.foundation.text.contextmenu.internal.ProvideDefaultTextContextMenuDropdown (DefaultTextContextMenuDropdownProvider.android.kt:85)");
    L26:
        BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu(r7, TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider(), ComposableSingletons$DefaultTextContextMenuDropdownProvider_androidKt.INSTANCE.getLambda$636288403$foundation_release(), r8, r11, ((r1 & 14) | 432) | ((r1 << 6) & 7168));
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L5:
        if (r11.changed(r7) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r10;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$DefaultTextContextMenuDropdown(TextContextMenuSession r0, TextContextMenuData r1, Composer r2, int r3) {
        DefaultTextContextMenuDropdown(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: access$IconBox-RPmYEkk, reason: not valid java name */
    public static final /* synthetic */ void m1494access$IconBoxRPmYEkk(int r0, long r1, Composer r3, int r4) {
        m1493IconBoxRPmYEkk(r0, r1, r3, r4);
    }

    private static final void OpenContextMenu(final TextContextMenuSession r9, final TextContextMenuDataProvider r10, final Function0<? extends LayoutCoordinates> r11, Composer r12, final int r13) {
        Composer r14 = r12.startRestartGroup(-2040393164);
        if ((r13 & 6) == 0) goto L5;
        int r1 = r13;
    L14:
        if ((r13 & 48) != 0) goto L24;
        if ((r13 & 64) != 0) goto L18;
        boolean r4 = r14.changed(r10);
    L19:
        if (r4 == false) goto L21;
        int r5 = 32;
    L22:
        r1 = r1 | r5;
        goto L24
    L21:
        r5 = 16;
        goto L22
    L18:
        r4 = r14.changedInstance(r10);
    L24:
        if ((r13 & 384) == 0) goto L26;
    L30:
        boolean r7 = false;
        if ((r1 & 147) == 146) goto L33;
        boolean r6 = true;
    L35:
        if (r14.shouldExecute(r6, r1 & 1) == true) goto L37;
        r14.skipToGroupEnd();
    L69:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L73;
        r15.updateScope(new t(r9, r10, r11, r13));
        return;
    L73:
        return;
    L37:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-2040393164, r1, -1, "androidx.compose.foundation.text.contextmenu.internal.OpenContextMenu (DefaultTextContextMenuDropdownProvider.android.kt:109)");
    L40:
        if ((r1 & 112) != 32) goto L42;
    L47:
        boolean r0 = true;
    L48:
        Object r8 = r14.rememberedValue();
        if (r0 == false) goto L51;
    L52:
        r8 = new MaintainWindowPositionPopupPositionProvider(new ContextMenuPopupPositionProvider(new r(r10, r11), null, 2, null));
        r14.updateRememberedValue(r8);
    L53:
        MaintainWindowPositionPopupPositionProvider r2 = (MaintainWindowPositionPopupPositionProvider) r8;
        if ((r1 & 14) != 4) goto L56;
    L59:
        r7 = true;
    L60:
        Object r3 = r14.rememberedValue();
        if (r7 == false) goto L63;
    L64:
        r3 = new s(r9);
        r14.updateRememberedValue(r3);
    L65:
        AndroidPopup_androidKt.Popup(r2, (Function0) r3, DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(1315155414, true, new AnonymousClass2(r10, r9), r14, 54), r14, 3456, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventEnd();
        goto L69
    L63:
        if (r3 != Composer.Companion.getEmpty()) goto L65;
    L56:
        if ((r1 & 8) == 0) goto L60;
        if (r14.changedInstance(r9) == false) goto L60;
    L51:
        if (r8 != Composer.Companion.getEmpty()) goto L53;
    L42:
        if ((r1 & 64) != 0) goto L44;
    L46:
        r0 = false;
        goto L48
    L44:
        if (r14.changed(r10) == false) goto L46;
    L33:
        r6 = false;
        goto L35
    L26:
        if (r14.changedInstance(r11) == false) goto L28;
        int r16 = 256;
    L29:
        r1 = r1 | r16;
        goto L30
    L28:
        r16 = 128;
        goto L29
    L5:
        if ((r13 & 8) != 0) goto L7;
        boolean r17 = r14.changed(r9);
    L8:
        if (r17 == false) goto L10;
        int r18 = 4;
    L11:
        r1 = r18 | r13;
        goto L14
    L10:
        r18 = 2;
        goto L11
    L7:
        r17 = r14.changedInstance(r9);
        goto L8
    }

    public static final /* synthetic */ void access$OpenContextMenu(TextContextMenuSession r0, TextContextMenuDataProvider r1, Function0 r2, Composer r3, int r4) {
        OpenContextMenu(r0, r1, r2, r3, r4);
    }
}
