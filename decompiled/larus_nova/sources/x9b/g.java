package x9b;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.ext.m;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f563008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563009b;

    public final void a(TextPaint r100) {
        HeadingThemeData r101 = k.f419543b.e(this.f563008a);
        m r102 = r101.f419564e;
        KProperty<Object>[] r103 = HeadingThemeData.f419561g;
        if (((Typeface) r102.getValue(r101, r103[1])) == null) goto L5;
        r100.setTypeface((Typeface) r101.f419564e.getValue(r101, r103[1]));
    L5:
        r100.setFakeBoldText(true);
        List<Float> r104 = r101.h();
        if (r104.size() < this.f563009b) goto L9;
        r100.setTextSize(r100.getTextSize() * ((Number) ListProtector.get(r104, this.f563009b - 1)).floatValue());
        return;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "tp");
        a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        a(r100);
    }

    public g(j r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        this.f563008a = r100;
        this.f563009b = r101;
    }
}
