package androidx.compose.foundation.text.contextmenu.internal;

import android.app.RemoteAction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.view.textclassifier.TextClassification;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/TextContextMenuHelperApi28;", "", "<init>", "()V", "textClassificationItem", "", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "context", "Landroid/content/Context;", "component", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuTextClassificationItem;", "IconBox", "icon", "Landroid/graphics/drawable/Icon;", "(Landroid/graphics/drawable/Icon;Landroidx/compose/runtime/Composer;I)V", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextContextMenuHelperApi28 {
    public static final TextContextMenuHelperApi28 INSTANCE = null;

    static {
        INSTANCE = new TextContextMenuHelperApi28();
    }

    private TextContextMenuHelperApi28() {
    }

    private static final Unit IconBox$lambda$4(TextContextMenuHelperApi28 r0, Icon r1, int r2, Composer r3, int r4) {
        r0.IconBox(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit IconBox$lambda$5(TextContextMenuHelperApi28 r0, Icon r1, int r2, Composer r3, int r4) {
        r0.IconBox(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit IconBox$lambda$9(TextContextMenuHelperApi28 r0, Drawable r1, int r2, Composer r3, int r4) {
        r0.IconBox(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextContextMenuHelperApi28 r0, Icon r1, int r2, Composer r3, int r4) {
        return IconBox$lambda$5(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(Drawable r0, DrawScope r1) {
        return IconBox$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit c(RemoteAction r0) {
        return textClassificationItem$lambda$2(r0);
    }

    public static /* synthetic */ Unit d(Context r0, TextClassification r1) {
        return textClassificationItem$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit e(TextContextMenuHelperApi28 r0, Icon r1, int r2, Composer r3, int r4) {
        return IconBox$lambda$4(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit f(TextContextMenuHelperApi28 r0, Drawable r1, int r2, Composer r3, int r4) {
        return IconBox$lambda$9(r0, r1, r2, r3, r4);
    }

    private static final Unit textClassificationItem$lambda$2(RemoteAction r1) {
        TextClassificationHelperApi28.INSTANCE.sendPendingIntent(r1.getActionIntent());
        return Unit.INSTANCE;
    }

    private static final Unit IconBox$lambda$8$lambda$7(Drawable r6, DrawScope r7) {
        Canvas r0 = r7.getDrawContext().getCanvas();
        r6.setBounds(0, 0, (int) Float.intBitsToFloat((int) (r7.getSize-NH-jbRc() >> 32)), (int) Float.intBitsToFloat((int) (r7.getSize-NH-jbRc() & 4294967295L)));
        r6.draw(AndroidCanvas_androidKt.getNativeCanvas(r0));
        return Unit.INSTANCE;
    }

    private static final Unit textClassificationItem$lambda$1(Context r1, TextClassification r2) {
        TextClassificationHelperApi28.INSTANCE.sendLegacyIntent(r1, r2);
        return Unit.INSTANCE;
    }

    private final void IconBox(final Icon r5, Composer r6, final int r7) {
        Composer r8 = r6.startRestartGroup(2116504409);
        if ((r7 & 6) == 0) goto L5;
        int r1 = r7;
    L11:
        if ((r7 & 48) != 0) goto L18;
        if (r8.changed(this) == false) goto L15;
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
        if (r8.shouldExecute(r3, r1 & 1) == true) goto L24;
        r8.skipToGroupEnd();
    L44:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L49;
        r9.updateScope(new j0(this, r5, r7));
        return;
    L49:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(2116504409, r1, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:267)");
    L26:
        Context r0 = (Context) r8.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        boolean r4 = r8.changed(r5) | r8.changed(r0);
        Object r10 = r8.rememberedValue();
        if (r4 == false) goto L29;
    L30:
        r10 = r5.loadDrawable(r0);
        r8.updateRememberedValue(r10);
    L31:
        Drawable r11 = (Drawable) r10;
        if (r11 == null) goto L34;
        IconBox(r11, r8, r1 & 112);
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventEnd();
        goto L44
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventEnd();
    L36:
        ScopeUpdateScope r12 = r8.endRestartGroup();
        if (r12 == null) goto L48;
        r12.updateScope(new i0(this, r5, r7));
        return;
    L48:
        return;
    L29:
        if (r10 != Composer.Companion.getEmpty()) goto L31;
    L20:
        r3 = false;
        goto L22
    L5:
        if (r8.changedInstance(r5) == false) goto L7;
        int r13 = 4;
    L8:
        r1 = r13 | r7;
        goto L11
    L7:
        r13 = 2;
        goto L8
    }

    public final void textClassificationItem(ContextMenuScope r12, final Context r13, TextContextMenuTextClassificationItem r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        int r0 = r14.getIndex();
        final TextClassification r15 = r14.getTextClassification();
        ComposableLambda r1 = null;
        if (r0 >= 0) goto L10;
        Function2<Composer, Integer, String> r4 = new AnonymousClass1(r15);
        final Drawable r2 = r15.getIcon();
        if (r2 == null) goto L9;
        r1 = ComposableLambdaKt.composableLambdaInstance(-1123224187, true, new TextContextMenuHelperApi28$textClassificationItem$2$1(r2));
    L9:
        ContextMenuScope.item$default(r12, r4, null, false, r1, new e0(r13, r15), 6, null);
        return;
    L10:
        final RemoteAction r16 = (RemoteAction) ListProtector.get(r15.getActions(), r0);
        if (r0 != 0) goto L13;
        boolean r17 = true;
    L14:
        Function2<Composer, Integer, String> r5 = new AnonymousClass4(r16);
        if (r17 == false) goto L17;
    L18:
        r1 = ComposableLambdaKt.composableLambdaInstance(-1261173016, true, new AnonymousClass5(r16));
    L19:
        ContextMenuScope.item$default(r12, r5, null, false, r1, new f0(r16), 6, null);
        return;
    L17:
        if (r16.shouldShowIcon() == false) goto L19;
    L13:
        r17 = false;
        goto L14
    }

    private final void IconBox(final Drawable r6, Composer r7, final int r8) {
        Composer r9 = r7.startRestartGroup(257732500);
        if ((r8 & 6) == 0) goto L5;
        int r1 = r8;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r9.shouldExecute(r2, r1 & 1) == true) goto L17;
        r9.skipToGroupEnd();
    L28:
        ScopeUpdateScope r10 = r9.endRestartGroup();
        if (r10 == null) goto L32;
        r10.updateScope(new h0(this, r6, r8));
        return;
    L32:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(257732500, r1, -1, "androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28.IconBox (DefaultTextContextMenuDropdownProvider.android.kt:274)");
    L19:
        Modifier r0 = SizeKt.m1014size3ABfNKs(Modifier.Companion, ContextMenuSpec.INSTANCE.m481getIconSizeD9Ej5fM());
        boolean r3 = r9.changedInstance(r6);
        Object r4 = r9.rememberedValue();
        if (r3 == false) goto L22;
    L23:
        r4 = new g0(r6);
        r9.updateRememberedValue(r4);
    L24:
        BoxKt.Box(DrawModifierKt.drawBehind(r0, (Function1) r4), r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
        goto L28
    L22:
        if (r4 != Composer.Companion.getEmpty()) goto L24;
    L13:
        r2 = false;
        goto L15
    L5:
        if (r9.changedInstance(r6) == false) goto L7;
        int r5 = 4;
    L8:
        r1 = r5 | r8;
        goto L11
    L7:
        r5 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$IconBox(TextContextMenuHelperApi28 r0, Drawable r1, Composer r2, int r3) {
        r0.IconBox(r1, r2, r3);
    }

    public static final /* synthetic */ void access$IconBox(TextContextMenuHelperApi28 r0, Icon r1, Composer r2, int r3) {
        r0.IconBox(r1, r2, r3);
    }
}
