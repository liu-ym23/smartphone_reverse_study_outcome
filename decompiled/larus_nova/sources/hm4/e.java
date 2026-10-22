package hm4;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Deprecated;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Deprecated(message = "推荐使用方根据具体业务自己计算栅格")
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f485938d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f485940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f485941c;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f485939a == r101.f485939a) goto L12;
        return false;
    L12:
        if (this.f485940b == r101.f485940b) goto L15;
        return false;
    L15:
        if (this.f485941c == r101.f485941c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f485939a * 31) + this.f485940b) * 31) + this.f485941c;
    }

    public final String toString() {
        return "PageGridConfig(columnNum=" + this.f485939a + ", gutterInPx=" + this.f485940b + ", marginInPx=" + this.f485941c + ')';
    }

    static {
        Resources r100 = Resources.getSystem();
        int r101 = MathKt.roundToInt(TypedValue.applyDimension(1, 11, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
        Resources r102 = Resources.getSystem();
        f485938d = new e(12, r101, MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()))));
    }

    public e(int r100, int r101, int r102) {
        this.f485939a = r100;
        this.f485940b = r101;
        this.f485941c = r102;
    }
}
