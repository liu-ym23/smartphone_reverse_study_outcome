package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import androidx.compose.ui.text.style.TextDirection;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"resolveTextDirectionForKeyboardTypePhone", "Landroidx/compose/ui/text/style/TextDirection;", "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "(Ljava/util/Locale;)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldLayoutStateCache_androidKt {
    public static final int resolveTextDirectionForKeyboardTypePhone(Locale r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L6;
        byte r3 = DigitDirectionalityApi28.INSTANCE.resolve(r2);
    L10:
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L16;
        return TextDirection.Companion.getLtr-s_7X-co();
    L16:
        return TextDirection.Companion.getRtl-s_7X-co();
    L6:
        if (r0 < 24) goto L8;
        r3 = DigitDirectionalityApi24.INSTANCE.resolve(r2);
        goto L10
    L8:
        r3 = DigitDirectionalityApi21.INSTANCE.resolve(r2);
        goto L10
    }
}
