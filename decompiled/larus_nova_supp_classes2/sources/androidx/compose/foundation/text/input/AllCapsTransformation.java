package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.StringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.intl.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/input/AllCapsTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "locale", "Landroidx/compose/ui/text/intl/Locale;", "<init>", "(Landroidx/compose/ui/text/intl/Locale;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AllCapsTransformation implements InputTransformation {
    private final KeyboardOptions keyboardOptions;
    private final Locale locale;

    private final Locale component1() {
        return this.locale;
    }

    public static /* synthetic */ AllCapsTransformation copy$default(AllCapsTransformation r0, Locale r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.locale;
    L6:
        return r0.copy(r1);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public final /* synthetic */ void applySemantics(SemanticsPropertyReceiver r1) {
        InputTransformation.CC.$default$applySemantics(this, r1);
    }

    public final AllCapsTransformation copy(Locale r2) {
        return new AllCapsTransformation(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof AllCapsTransformation) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.locale, ((AllCapsTransformation) r4).locale) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.locale.hashCode();
    }

    public String toString() {
        return "InputTransformation.allCaps(locale=" + this.locale + ')';
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public AllCapsTransformation(Locale r11) {
        this.locale = r11;
        this.keyboardOptions = new KeyboardOptions(KeyboardCapitalization.Companion.getCharacters-IUNYP9k(), null, 0, 0, null, null, null, 126, null);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(TextFieldBuffer r8) {
        TextFieldBuffer.ChangeList r0 = r8.getChanges();
        int r1 = 0;
    L4:
        if (r1 >= r0.getChangeCount()) goto L9;
        long r2 = r0.mo1532getRangejx7JFs(r1);
        r0.mo1531getOriginalRangejx7JFs(r1);
        if (TextRange.getCollapsed-impl(r2) == true) goto L8;
        r8.replace(TextRange.getMin-impl(r2), TextRange.getMax-impl(r2), StringKt.toUpperCase(TextRangeKt.substring-FDrldGo(r8.asCharSequence(), r2), this.locale));
    L8:
        r1 = r1 + 1;
        goto L4
    }
}
