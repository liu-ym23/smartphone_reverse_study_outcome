package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"times", "Landroidx/compose/ui/unit/TextUnit;", "other", "times-NB67dxo", "(JJ)J", "DefaultFontSize", "J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MultiParagraphLayoutCacheKt {
    private static final long DefaultFontSize = 0;

    static {
        DefaultFontSize = TextUnitKt.getSp(14);
    }

    /* JADX INFO: renamed from: access$times-NB67dxo, reason: not valid java name */
    public static final /* synthetic */ long m1791access$timesNB67dxo(long r0, long r2) {
        return m1792timesNB67dxo(r0, r2);
    }

    /* JADX INFO: renamed from: times-NB67dxo, reason: not valid java name */
    private static final long m1792timesNB67dxo(long r5, long r7) {
        if (TextUnit.isEm-impl(r7) == false) goto L18;
        if (TextUnit.isEm-impl(r5) == true) goto L16;
        if (TextUnit.getRawType-impl(r5) != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        long r6 = DefaultFontSize;
        float r8 = TextUnit.getValue-impl(r7);
        TextUnitKt.checkArithmetic--R2X_6o(r6);
        return TextUnitKt.pack(TextUnit.getRawType-impl(r6), TextUnit.getValue-impl(r6) * r8);
    L13:
        float r9 = TextUnit.getValue-impl(r7);
        TextUnitKt.checkArithmetic--R2X_6o(r5);
        return TextUnitKt.pack(TextUnit.getRawType-impl(r5), TextUnit.getValue-impl(r5) * r9);
    L9:
        r0 = false;
        goto L10
    L16:
        throw new IllegalStateException("Cannot convert Em to Px when style.fontSize is Em (" + TextUnit.toString-impl(r7) + "). Please declare the style.fontSize with Sp units instead.");
    L18:
        throw new IllegalArgumentException("The multiplier must be in em, but was " + TextUnit.toString-impl(r7) + '.');
    }
}
