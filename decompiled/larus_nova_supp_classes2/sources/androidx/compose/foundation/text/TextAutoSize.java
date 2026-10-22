package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J#\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H¦\u0002J\b\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/TextAutoSize;", "", "getFontSize", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "equals", "", "other", "hashCode", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TextAutoSize {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/text/TextAutoSize$Companion;", "", "<init>", "()V", "StepBased", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "StepBased-vU-0ePk", "(JJJ)Landroidx/compose/foundation/text/TextAutoSize;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: StepBased-vU-0ePk, reason: not valid java name */
        public final TextAutoSize m1440StepBasedvU0ePk(long r10, long r12, long r14) {
            return new AutoSizeStepBased(r10, r12, r14, null);
        }

        /* JADX INFO: renamed from: StepBased-vU-0ePk$default, reason: not valid java name */
        public static /* synthetic */ TextAutoSize m1439StepBasedvU0ePk$default(Companion r7, long r8, long r10, long r12, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L5;
            r8 = TextAutoSizeDefaults.INSTANCE.m1442getMinFontSizeXSAIIZE();
        L5:
            long r1 = r8;
            if ((r14 & 2) == 0) goto L8;
            r10 = TextAutoSizeDefaults.INSTANCE.m1441getMaxFontSizeXSAIIZE();
        L8:
            long r3 = r10;
            if ((r14 & 4) == 0) goto L12;
            r12 = TextUnitKt.getSp(0.25d);
        L12:
            return r7.m1440StepBasedvU0ePk(r1, r3, r12);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean equals(Object r1);

    /* JADX INFO: renamed from: getFontSize-Ci0_558 */
    long mo1339getFontSizeCi0_558(TextAutoSizeLayoutScope r1, long r2, AnnotatedString r4);

    int hashCode();
}
