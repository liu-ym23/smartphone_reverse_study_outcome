package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "hasFlag", "", "bits", "", "flag", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: update-pLxbY9I, reason: not valid java name */
    public static final void m1579updatepLxbY9I(EditorInfo r8, CharSequence r9, long r10, ImeOptions r12, String[] r13) {
        int r0 = r12.getImeAction-eUduSuo();
        ImeAction.Companion r1 = ImeAction.Companion;
        int r3 = 3;
        int r5 = 6;
        if (ImeAction.equals-impl0(r0, r1.getDefault-eUduSuo()) == false) goto L9;
        if (r12.getSingleLine() == true) goto L28;
        r5 = 0;
    L28:
        r8.imeOptions = r5;
        PlatformImeOptions r2 = r12.getPlatformImeOptions();
        if (r2 == null) goto L34;
        String r4 = r2.getPrivateImeOptions();
        if (r4 == null) goto L34;
        r8.privateImeOptions = r4;
    L34:
        if (Build.VERSION.SDK_INT < 24) goto L36;
        LocaleListHelper.INSTANCE.setHintLocales(r8, r12.getHintLocales());
    L36:
        int r6 = r12.getKeyboardType-PjHm6EE();
        KeyboardType.Companion r7 = KeyboardType.Companion;
        if (KeyboardType.equals-impl0(r6, r7.getText-PjHm6EE()) == false) goto L40;
    L38:
        r3 = 1;
    L63:
        r8.inputType = r3;
        if (r12.getSingleLine() == true) goto L71;
        if (hasFlag(r8.inputType, 1) == false) goto L71;
        r8.inputType |= 131072;
        if (ImeAction.equals-impl0(r12.getImeAction-eUduSuo(), r1.getDefault-eUduSuo()) == false) goto L71;
        r8.imeOptions |= 1073741824;
    L71:
        if (hasFlag(r8.inputType, 1) == false) goto L84;
        int r11 = r12.getCapitalization-IUNYP9k();
        KeyboardCapitalization.Companion r14 = KeyboardCapitalization.Companion;
        if (KeyboardCapitalization.equals-impl0(r11, r14.getCharacters-IUNYP9k()) == false) goto L76;
        r8.inputType |= 4096;
    L82:
        if (r12.getAutoCorrect() == false) goto L84;
        r8.inputType |= BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        goto L84
    L76:
        if (KeyboardCapitalization.equals-impl0(r11, r14.getWords-IUNYP9k()) == false) goto L79;
        r8.inputType |= 8192;
        goto L82
    L79:
        if (KeyboardCapitalization.equals-impl0(r11, r14.getSentences-IUNYP9k()) == false) goto L82;
        r8.inputType |= 16384;
    L84:
        r8.initialSelStart = TextRange.getStart-impl(r10);
        r8.initialSelEnd = TextRange.getEnd-impl(r10);
        EditorInfoCompat.setInitialSurroundingText(r8, r9);
        if (r13 == null) goto L87;
        EditorInfoCompat.setContentMimeTypes(r8, r13);
    L87:
        r8.imeOptions |= 33554432;
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() == true) goto L90;
    L94:
        EditorInfoCompat.setStylusHandwritingEnabled(r8, false);
        return;
    L90:
        if (KeyboardType.equals-impl0(r12.getKeyboardType-PjHm6EE(), r7.getPassword-PjHm6EE()) == true) goto L94;
        if (KeyboardType.equals-impl0(r12.getKeyboardType-PjHm6EE(), r7.getNumberPassword-PjHm6EE()) == true) goto L94;
        EditorInfoCompat.setStylusHandwritingEnabled(r8, true);
        EditorInfoApi34.INSTANCE.setHandwritingGestures(r8);
        return;
    L40:
        if (KeyboardType.equals-impl0(r6, r7.getAscii-PjHm6EE()) == false) goto L43;
        r8.imeOptions |= RtlSpacingHelper.UNDEFINED;
        goto L38
    L43:
        if (KeyboardType.equals-impl0(r6, r7.getNumber-PjHm6EE()) == false) goto L46;
        r3 = 2;
        goto L63
    L46:
        if (KeyboardType.equals-impl0(r6, r7.getPhone-PjHm6EE()) == true) goto L63;
        if (KeyboardType.equals-impl0(r6, r7.getUri-PjHm6EE()) == false) goto L52;
        r3 = 17;
        goto L63
    L52:
        if (KeyboardType.equals-impl0(r6, r7.getEmail-PjHm6EE()) == false) goto L55;
        r3 = 33;
        goto L63
    L55:
        if (KeyboardType.equals-impl0(r6, r7.getPassword-PjHm6EE()) == false) goto L58;
        r3 = 129;
        goto L63
    L58:
        if (KeyboardType.equals-impl0(r6, r7.getNumberPassword-PjHm6EE()) == false) goto L61;
        r3 = 18;
        goto L63
    L61:
        if (KeyboardType.equals-impl0(r6, r7.getDecimal-PjHm6EE()) == false) goto L97;
        r3 = 8194;
        goto L63
    L97:
        throw new IllegalStateException("Invalid Keyboard Type".toString());
    L9:
        if (ImeAction.equals-impl0(r0, r1.getNone-eUduSuo()) == false) goto L12;
        r5 = 1;
        goto L28
    L12:
        if (ImeAction.equals-impl0(r0, r1.getGo-eUduSuo()) == false) goto L15;
        r5 = 2;
        goto L28
    L15:
        if (ImeAction.equals-impl0(r0, r1.getNext-eUduSuo()) == false) goto L18;
        r5 = 5;
        goto L28
    L18:
        if (ImeAction.equals-impl0(r0, r1.getPrevious-eUduSuo()) == false) goto L21;
        r5 = 7;
        goto L28
    L21:
        if (ImeAction.equals-impl0(r0, r1.getSearch-eUduSuo()) == false) goto L24;
        r5 = 3;
        goto L28
    L24:
        if (ImeAction.equals-impl0(r0, r1.getSend-eUduSuo()) == false) goto L27;
        r5 = 4;
        goto L28
    L27:
        if (ImeAction.equals-impl0(r0, r1.getDone-eUduSuo()) == true) goto L28;
        throw new IllegalStateException("invalid ImeAction".toString());
    }

    /* JADX INFO: renamed from: update-pLxbY9I$default, reason: not valid java name */
    public static /* synthetic */ void m1580updatepLxbY9I$default(EditorInfo r6, CharSequence r7, long r8, ImeOptions r10, String[] r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        m1579updatepLxbY9I(r6, r7, r8, r10, r11);
    }
}
