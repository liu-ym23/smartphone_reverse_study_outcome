package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0007¢\u0006\u0002\u0010\nJë\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000eH\u0007¢\u0006\u0004\b$\u0010%Jë\u0001\u0010&\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000eH\u0007¢\u0006\u0004\b+\u0010%¨\u0006,"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "<init>", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "textFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "textFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "outlinedTextFieldColors-DlUQjxs", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = null;

    static {
        INSTANCE = new ExposedDropdownMenuDefaults();
    }

    private ExposedDropdownMenuDefaults() {
    }

    private static final Unit TrailingIcon$lambda$4(ExposedDropdownMenuDefaults r6, boolean r7, Function0 r8, int r9, int r10, Composer r11, int r12) {
        r6.TrailingIcon(r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return TrailingIcon$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit b(ExposedDropdownMenuDefaults r0, boolean r1, Function0 r2, int r3, int r4, Composer r5, int r6) {
        return TrailingIcon$lambda$4(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit c() {
        return TrailingIcon$lambda$1$lambda$0();
    }

    private static final Unit TrailingIcon$lambda$1$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit TrailingIcon$lambda$3$lambda$2(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    public final void TrailingIcon(final boolean r10, Function0<Unit> r11, Composer r12, final int r13, final int r14) {
        Composer r15 = r12.startRestartGroup(876077373);
        if ((r14 & 1) == 0) goto L6;
        int r1 = r13 | 6;
    L13:
        int r2 = r14 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r1 & 19) == 18) goto L26;
        boolean r3 = true;
    L28:
        if (r15.shouldExecute(r3, r1 & 1) == false) goto L43;
        if (r2 == 0) goto L35;
        Object r16 = r15.rememberedValue();
        if (r16 != Composer.Companion.getEmpty()) goto L33;
        r16 = new v4();
        r15.updateRememberedValue(r16);
    L33:
        r11 = (Function0) r16;
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventStart(876077373, r1, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:235)");
    L37:
        Modifier.Companion r0 = Modifier.Companion;
        Object r4 = r15.rememberedValue();
        if (r4 != Composer.Companion.getEmpty()) goto L40;
        r4 = new w4();
        r15.updateRememberedValue(r4);
    L40:
        Modifier r5 = SemanticsModifierKt.clearAndSetSemantics(r0, (Function1) r4);
        ComposableLambda r6 = ComposableLambdaKt.rememberComposableLambda(726122713, true, new AnonymousClass3(r10), r15, 54);
        int r7 = ((r1 >> 3) & 14) | 24576;
        IconButtonKt.IconButton(r11, r5, false, null, r6, r15, r7, 12);
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventEnd();
    L44:
        final Function0<Unit> r8 = r11;
        ScopeUpdateScope r17 = r15.endRestartGroup();
        if (r17 == null) goto L48;
        r17.updateScope(new x4(this, r10, r8, r13, r14));
        return;
    L48:
        return;
    L43:
        r15.skipToGroupEnd();
        goto L44
    L26:
        r3 = false;
        goto L28
    L17:
        if ((r13 & 48) != 0) goto L24;
        if (r15.changedInstance(r11) == false) goto L21;
        int r9 = 32;
    L22:
        r1 = r1 | r9;
        goto L24
    L21:
        r9 = 16;
        goto L22
    L6:
        if ((r13 & 6) == 0) goto L8;
        r1 = r13;
        goto L13
    L8:
        if (r15.changed(r10) == false) goto L10;
        int r18 = 4;
    L11:
        r1 = r18 | r13;
        goto L13
    L10:
        r18 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m2059outlinedTextFieldColorsDlUQjxs(long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, Composer r83, int r84, int r85, int r86, int r87) {
        if ((r87 & 1) == 0) goto L5;
        long r2 = Color.copy-wmQWz5c$default(((Color) r83.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), ((Number) r83.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L7:
        if ((r87 & 2) == 0) goto L9;
        float r6 = ContentAlpha.INSTANCE.getDisabled(r83, 6);
        long r4 = Color.copy-wmQWz5c$default(r2, r6, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r87 & 4) == 0) goto L13;
        long r7 = Color.Companion.getTransparent-0d7_KjU();
    L15:
        if ((r87 & 8) == 0) goto L17;
        long r8 = MaterialTheme.INSTANCE.getColors(r83, 6).m1999getPrimary0d7_KjU();
    L19:
        if ((r87 & 16) == 0) goto L21;
        long r10 = MaterialTheme.INSTANCE.getColors(r83, 6).m1993getError0d7_KjU();
    L23:
        if ((r87 & 32) == 0) goto L25;
        long r13 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r87 & 64) == 0) goto L29;
        long r9 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L31:
        if ((r87 & 128) == 0) goto L33;
        long r310 = r9;
        long r15 = Color.copy-wmQWz5c$default(r310, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L35:
        if ((r87 & 256) == 0) goto L37;
        int r16 = 6;
        long r21 = MaterialTheme.INSTANCE.getColors(r83, 6).m1993getError0d7_KjU();
    L39:
        if ((r87 & 512) == 0) goto L41;
        long r17 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, r16).m1998getOnSurface0d7_KjU(), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L43:
        if ((r87 & 1024) == 0) goto L45;
        long r40 = r17;
        long r11 = Color.copy-wmQWz5c$default(r40, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L47:
        if ((r87 & 2048) == 0) goto L49;
        long r23 = r17;
    L51:
        if ((r87 & 4096) == 0) goto L53;
        long r12 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1998getOnSurface0d7_KjU(), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L55:
        if ((r87 & 8192) == 0) goto L57;
        long r18 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L59:
        if ((r87 & 16384) == 0) goto L61;
        long r42 = r12;
        long r19 = Color.copy-wmQWz5c$default(r42, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L63:
        if ((32768 & r87) == 0) goto L65;
        int r110 = 6;
        long r25 = MaterialTheme.INSTANCE.getColors(r83, 6).m1993getError0d7_KjU();
    L67:
        if ((65536 & r87) == 0) goto L69;
        long r111 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, r110).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r83, r110), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L71:
        if ((131072 & r87) == 0) goto L73;
        long r112 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L75:
        if ((262144 & r87) == 0) goto L77;
        long r44 = r112;
        long r14 = Color.copy-wmQWz5c$default(r44, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L79:
        if ((524288 & r87) == 0) goto L81;
        int r20 = 6;
        long r31 = MaterialTheme.INSTANCE.getColors(r83, 6).m1993getError0d7_KjU();
    L83:
        if ((1048576 & r87) == 0) goto L85;
        long r22 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, r20).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(r83, r20), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L87:
        if ((r87 & 2097152) == 0) goto L89;
        long r46 = r22;
        long r0 = Color.copy-wmQWz5c$default(r46, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L91:
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventStart(1162641182, r84, r85, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:417)");
    L94:
        DefaultTextFieldForExposedDropdownMenusColors r1 = new DefaultTextFieldForExposedDropdownMenusColors(r2, r4, r8, r10, r13, r9, r21, r15, r17, r11, r23, r12, r18, r19, r25, r7, r111, r112, r14, r31, r22, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        return r1;
    L89:
        r0 = r81;
        goto L91
    L85:
        r22 = r79;
        goto L87
    L81:
        r20 = 6;
        r31 = r77;
        goto L83
    L77:
        r14 = r75;
        goto L79
    L73:
        r112 = r73;
        goto L75
    L69:
        r111 = r71;
        goto L71
    L65:
        r110 = 6;
        r25 = r69;
        goto L67
    L61:
        r19 = r67;
        goto L63
    L57:
        r18 = r65;
        goto L59
    L53:
        r12 = r63;
        goto L55
    L49:
        r23 = r61;
        goto L51
    L45:
        r11 = r59;
        goto L47
    L41:
        r17 = r57;
        goto L43
    L37:
        r16 = 6;
        r21 = r55;
        goto L39
    L33:
        r15 = r53;
        goto L35
    L29:
        r9 = r51;
        goto L31
    L25:
        r13 = r49;
        goto L27
    L21:
        r10 = r47;
        goto L23
    L17:
        r8 = r45;
        goto L19
    L13:
        r7 = r43;
        goto L15
    L9:
        r4 = r41;
        goto L11
    L5:
        r2 = r39;
        goto L7
    }

    /* JADX INFO: renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m2060textFieldColorsDlUQjxs(long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, Composer r83, int r84, int r85, int r86, int r87) {
        if ((r87 & 1) == 0) goto L5;
        long r2 = Color.copy-wmQWz5c$default(((Color) r83.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), ((Number) r83.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L7:
        if ((r87 & 2) == 0) goto L9;
        float r6 = ContentAlpha.INSTANCE.getDisabled(r83, 6);
        long r4 = Color.copy-wmQWz5c$default(r2, r6, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r87 & 4) == 0) goto L13;
        long r7 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r87 & 8) == 0) goto L17;
        long r8 = MaterialTheme.INSTANCE.getColors(r83, 6).m1999getPrimary0d7_KjU();
    L19:
        if ((r87 & 16) == 0) goto L21;
        long r10 = MaterialTheme.INSTANCE.getColors(r83, 6).m1993getError0d7_KjU();
    L23:
        if ((r87 & 32) == 0) goto L25;
        long r13 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r87 & 64) == 0) goto L29;
        long r15 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1998getOnSurface0d7_KjU(), 0.42f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L31:
        if ((r87 & 128) == 0) goto L33;
        long r310 = r15;
        long r9 = Color.copy-wmQWz5c$default(r310, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L35:
        if ((r87 & 256) == 0) goto L37;
        int r11 = 6;
        long r21 = MaterialTheme.INSTANCE.getColors(r83, 6).m1993getError0d7_KjU();
    L39:
        if ((r87 & 512) == 0) goto L41;
        long r12 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, r11).m1998getOnSurface0d7_KjU(), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L43:
        if ((r87 & 1024) == 0) goto L45;
        long r311 = r12;
        long r16 = Color.copy-wmQWz5c$default(r311, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L47:
        if ((r87 & 2048) == 0) goto L49;
        long r23 = r12;
    L51:
        if ((r87 & 4096) == 0) goto L53;
        long r17 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1998getOnSurface0d7_KjU(), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L55:
        if ((r87 & 8192) == 0) goto L57;
        long r14 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L59:
        if ((r87 & 16384) == 0) goto L61;
        long r312 = r17;
        long r18 = Color.copy-wmQWz5c$default(r312, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L63:
        if ((32768 & r87) == 0) goto L65;
        int r19 = 6;
        long r25 = MaterialTheme.INSTANCE.getColors(r83, 6).m1993getError0d7_KjU();
    L67:
        if ((65536 & r87) == 0) goto L69;
        long r20 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, r19).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r83, r19), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L71:
        if ((131072 & r87) == 0) goto L73;
        long r22 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L75:
        if ((262144 & r87) == 0) goto L77;
        long r313 = r22;
        long r110 = Color.copy-wmQWz5c$default(r313, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L79:
        if ((524288 & r87) == 0) goto L81;
        int r111 = 6;
        long r31 = MaterialTheme.INSTANCE.getColors(r83, 6).m1993getError0d7_KjU();
    L83:
        if ((1048576 & r87) == 0) goto L85;
        long r112 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r83, r111).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(r83, r111), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L87:
        if ((r87 & 2097152) == 0) goto L89;
        long r314 = r112;
        long r0 = Color.copy-wmQWz5c$default(r314, ContentAlpha.INSTANCE.getDisabled(r83, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L91:
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventStart(1208167904, r84, r85, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:322)");
    L94:
        DefaultTextFieldForExposedDropdownMenusColors r1 = new DefaultTextFieldForExposedDropdownMenusColors(r2, r4, r8, r10, r13, r15, r21, r9, r12, r16, r23, r17, r14, r18, r25, r7, r20, r22, r110, r31, r112, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        return r1;
    L89:
        r0 = r81;
        goto L91
    L85:
        r112 = r79;
        goto L87
    L81:
        r111 = 6;
        r31 = r77;
        goto L83
    L77:
        r110 = r75;
        goto L79
    L73:
        r22 = r73;
        goto L75
    L69:
        r20 = r71;
        goto L71
    L65:
        r19 = 6;
        r25 = r69;
        goto L67
    L61:
        r18 = r67;
        goto L63
    L57:
        r14 = r65;
        goto L59
    L53:
        r17 = r63;
        goto L55
    L49:
        r23 = r61;
        goto L51
    L45:
        r16 = r59;
        goto L47
    L41:
        r12 = r57;
        goto L43
    L37:
        r11 = 6;
        r21 = r55;
        goto L39
    L33:
        r9 = r53;
        goto L35
    L29:
        r15 = r51;
        goto L31
    L25:
        r13 = r49;
        goto L27
    L21:
        r10 = r47;
        goto L23
    L17:
        r8 = r45;
        goto L19
    L13:
        r7 = r43;
        goto L15
    L9:
        r4 = r41;
        goto L11
    L5:
        r2 = r39;
        goto L7
    }
}
