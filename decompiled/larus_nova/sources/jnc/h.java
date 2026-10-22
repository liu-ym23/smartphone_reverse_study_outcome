package jnc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f499818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f499819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f499820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f499821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f499822f;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return (int) ((r100.measureText(this.f499817a) + (2 * this.f499821e)) + this.f499822f);
    }

    public h(String r100, int r101, int r102, float r103, float r104, float r105) {
        Intrinsics.checkNotNullParameter(r100, "customText");
        this.f499817a = r100;
        this.f499818b = r101;
        this.f499819c = r102;
        this.f499820d = r103;
        this.f499821e = r104;
        this.f499822f = r105;
        new Paint();
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r118) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r118, "paint");
        r118.setColor(this.f499819c);
        r118.setTextSize(this.f499820d);
        r118.setStyle(Paint.Style.FILL);
        r118.setTypeface(Typeface.DEFAULT_BOLD);
        int r100 = getSize(r118, r111, r112, r113, r118.getFontMetricsInt());
        FLogger.f375446a.d("TextTagSpan", "getSize: " + r100);
        RectF r101 = new RectF(this.f499822f + r114, (float) r115, ((float) r100) + r114, (float) r117);
        Paint r102 = new Paint();
        r102.setColor(this.f499818b);
        float r103 = this.f499821e;
        r110.drawRoundRect(r101, r103, r103, r102);
        String r104 = this.f499817a;
        float r105 = (this.f499822f + r114) + this.f499821e;
        int r106 = CircleProgressBarView.f328410k;
        r110.drawText(r104, r105, r116 - CircleProgressBarView.a.a(AppHost.f326268a.getApplication().getApplicationContext(), 1.0f), r118);
    }
}
