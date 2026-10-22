package ev4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f474243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f474245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f474246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f474247e;

    public a(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f474243a = r101;
        this.f474244b = r100.getString(R.string.Bitable_Forms_VoiceQuickFill_Listening_Toast);
        this.f474245c = ContextCompat.getColor(r100, R.color.text_placeholder);
        this.f474246d = n.e(r100, 8.0f);
        b r102 = new b(r100);
        r102.setBounds(0, 0, r102.getIntrinsicWidth(), r102.getIntrinsicHeight());
        this.f474247e = r102;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (r104 == null) goto L6;
        Paint.FontMetricsInt r105 = r100.getFontMetricsInt();
        r104.ascent = r105.ascent;
        r104.top = r105.top;
        r104.descent = r105.descent;
        r104.bottom = r105.bottom;
    L6:
        if (this.f474243a == false) goto L8;
        float r106 = r100.measureText(this.f474244b);
    L10:
        return (int) ((r106 + this.f474246d) + this.f474247e.getIntrinsicWidth());
    L8:
        r106 = 0.0f;
        goto L10
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        if (this.f474243a == false) goto L5;
        int r109 = r108.getColor();
        r108.setColor(this.f474245c);
        r100.drawText(this.f474244b, r104, r106, r108);
        r108.setColor(r109);
        r104 = r104 + r108.measureText(this.f474244b);
    L5:
        float r110 = r104 + this.f474246d;
        float r111 = ((r105 + r107) - this.f474247e.getIntrinsicHeight()) / 2.0f;
        r100.save();
        r100.translate(r110, r111);
        this.f474247e.draw(r100);
        r100.restore();
    }
}
