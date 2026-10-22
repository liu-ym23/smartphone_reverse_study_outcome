package pv2;

import android.graphics.Paint;
import com.bytedance.android.livesdk.widget.rollingTextView.Direction;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f530796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char f530797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f530798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f530799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f530800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f530801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f530802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f530803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Direction f530804i;

    public final void a() {
        b r100 = this.f530802g;
        char r101 = this.f530798c;
        Paint r102 = this.f530803h;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "textPaint");
        if (r101 != 0) goto L5;
        float r103 = 0.0f;
    L9:
        this.f530799d = r103;
        if (r103 != 0.0f) goto L12;
    L15:
        this.f530796a = r103;
        return;
    L12:
        if (this.f530798c == '.') goto L15;
        r103 = RangesKt.coerceAtLeast(this.f530796a, r103);
        goto L15
    L5:
        Float r104 = r100.f530805a.get(Character.valueOf(r101));
        if (r104 == null) goto L8;
        r103 = r104.floatValue();
        goto L9
    L8:
        float r105 = r102.measureText(String.valueOf(r101));
        r100.f530805a.put(Character.valueOf(r101), Float.valueOf(r105));
        r103 = r105;
        goto L9
    }

    public a(b r100, Paint r101, Direction r102) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "textPaint");
        Intrinsics.checkNotNullParameter(r102, "direction");
        this.f530802g = r100;
        this.f530803h = r101;
        this.f530804i = r102;
        a();
    }
}
