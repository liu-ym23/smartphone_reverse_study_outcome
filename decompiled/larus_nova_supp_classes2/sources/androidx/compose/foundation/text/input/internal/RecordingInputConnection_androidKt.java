package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DEBUG", "", "TAG", "", "DEBUG_CLASS", "toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/ui/text/input/TextFieldValue;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RecordingInputConnection_androidKt {
    public static final boolean DEBUG = false;
    private static final String DEBUG_CLASS = "RecordingInputConnection";
    public static final String TAG = "RecordingIC";

    public static final /* synthetic */ ExtractedText access$toExtractedText(TextFieldValue r0) {
        return toExtractedText(r0);
    }

    private static final ExtractedText toExtractedText(TextFieldValue r5) {
        ExtractedText r0 = new ExtractedText();
        r0.text = r5.getText();
        r0.startOffset = 0;
        r0.partialEndOffset = r5.getText().length();
        r0.partialStartOffset = -1;
        r0.selectionStart = TextRange.getMin-impl(r5.getSelection-d9O1mEE());
        r0.selectionEnd = TextRange.getMax-impl(r5.getSelection-d9O1mEE());
        r0.flags = !StringsKt.contains$default(r5.getText(), '\n', false, 2, null) ? 1 : 0;
        return r0;
    }
}
