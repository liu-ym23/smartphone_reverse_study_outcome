package androidx.compose.material.internal;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1 implements MeasurePolicy {
    public static final ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1 INSTANCE = null;

    static {
        INSTANCE = new ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1();
    }

    public ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1() {
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2243measure3p2s80s(MeasureScope r11, List<? extends Measurable> r12, long r13) {
        int r0 = r12.size();
        if (r0 == 0) goto L20;
        int r2 = 0;
        if (r0 == 1) goto L18;
        final ArrayList r1 = new ArrayList(r12.size());
        int r3 = r12.size();
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L9;
        r1.add(((Measurable) ListProtector.get(r12, r4)).measure-BRTryo0(r13));
        r4 = r4 + 1;
        goto L7
    L9:
        int r14 = CollectionsKt.getLastIndex(r1);
        if (r14 < 0) goto L16;
        int r15 = 0;
        int r16 = 0;
    L12:
        Placeable r5 = (Placeable) ListProtector.get(r1, r2);
        r15 = Math.max(r15, r5.getWidth());
        r16 = Math.max(r16, r5.getHeight());
        if (r2 == r14) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        int r6 = r15;
        int r7 = r16;
    L23:
        return MeasureScope.-CC.layout$default(r11, r6, r7, null, new AnonymousClass3(r1), 4, null);
    L16:
        r6 = 0;
        r7 = 0;
        goto L23
    L18:
        final Placeable r17 = ((Measurable) ListProtector.get(r12, 0)).measure-BRTryo0(r13);
        return MeasureScope.-CC.layout$default(r11, r17.getWidth(), r17.getHeight(), null, new AnonymousClass2(r17), 4, null);
    L20:
        return MeasureScope.-CC.layout$default(r11, 0, 0, null, AnonymousClass1.INSTANCE, 4, null);
    }
}
