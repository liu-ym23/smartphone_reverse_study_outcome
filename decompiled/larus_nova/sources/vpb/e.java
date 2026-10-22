package vpb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.larkicon.transform.ImgForegroundTransform;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.functions.Function;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f556744a;

    public e(d r100) {
        this.f556744a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        Bitmap r111 = (Bitmap) r110;
        Intrinsics.checkNotNullParameter(r111, "mainBody");
        int r100 = this.f556744a.f556743g;
        Bitmap r101 = Bitmap.createBitmap(r100, r100, Bitmap.Config.ARGB_8888);
        Canvas r102 = new Canvas(r101);
        Iterator<xpb.b> r103 = this.f556744a.f556737a.iterator();
    L3:
        int r104 = 0;
        if (r103.hasNext() == false) goto L11;
        xpb.a r105 = (xpb.a) r103.next();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "canvas");
        Paint r106 = new Paint();
        Integer r107 = r105.f564780a;
        if (r107 == null) goto L8;
        r104 = r107.intValue();
    L8:
        r106.setColor(r104);
        r106.setStyle(Paint.Style.FILL);
        r106.setAntiAlias(true);
        RectF r108 = new RectF(0.0f, 0.0f, r102.getWidth(), r102.getHeight());
        float r109 = r105.f564781b;
        r102.drawRoundRect(r108, r109, r109, r106);
        if (r105.f564782c == null) goto L3;
        Paint r112 = new Paint();
        r112.setColor(UDColorUtils.getColor(LarkContext.getApplication(), r105.f564782c.intValue()));
        r112.setStyle(Paint.Style.STROKE);
        r112.setStrokeWidth(r105.f564783d);
        r112.setAntiAlias(true);
        float r113 = r105.f564783d;
        RectF r114 = new RectF(r113, r113, r102.getWidth() - r105.f564783d, r102.getHeight() - r105.f564783d);
        float r115 = r105.f564781b;
        r102.drawRoundRect(r114, r115, r115, r112);
        goto L3
    L11:
        Matrix r116 = new Matrix();
        r116.postTranslate((r101.getWidth() / 2.0f) - (r111.getWidth() / 2.0f), (r101.getHeight() / 2.0f) - (r111.getHeight() / 2.0f));
        r102.drawBitmap(r111, r116, new Paint());
        Iterator<xpb.c> r117 = this.f556744a.f556738b.iterator();
    L13:
        if (r117.hasNext() == false) goto L44;
        ImgForegroundTransform r118 = (ImgForegroundTransform) r117.next();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r102, "canvas");
        if (r118.f431156a == null) goto L31;
        Integer r119 = r118.f431159d;
        if (r119 == null) goto L19;
        int r120 = r119.intValue();
    L20:
        Integer r121 = r118.f431160e;
        if (r121 == null) goto L23;
        int r122 = r121.intValue();
    L24:
        Bitmap r123 = Bitmap.createBitmap(r120, r122, Bitmap.Config.ARGB_8888);
        Canvas r124 = new Canvas(r123);
        Drawable r125 = r118.f431156a;
        if (r125 == null) goto L27;
        r125.setBounds(0, 0, r123.getWidth(), r123.getHeight());
    L27:
        Drawable r126 = r118.f431156a;
        if (r126 == null) goto L30;
        r126.draw(r124);
    L30:
        r118.f431157b = r123;
        goto L31
    L23:
        r122 = r102.getHeight();
        goto L24
    L19:
        r120 = r102.getWidth();
    L31:
        Bitmap r127 = r118.f431157b;
        if (r127 == null) goto L13;
        Matrix r128 = new Matrix();
        int r129 = ImgForegroundTransform.a.f431163a[r118.f431158c.ordinal()];
        if (r129 != 1) goto L36;
        r128.postTranslate(0.0f, r102.getHeight() - r127.getHeight());
    L43:
        r102.drawBitmap(r127, r128, new Paint());
        goto L13
    L36:
        if (r129 != 2) goto L38;
        r128.postTranslate(r102.getWidth() - r127.getWidth(), 0.0f);
        goto L43
    L38:
        if (r129 == 3) goto L40;
        r128.postTranslate(0.0f, 0.0f);
        goto L43
    L40:
        r128.postTranslate(r102.getWidth() - r127.getWidth(), r102.getHeight() - r127.getHeight());
        goto L43
    L44:
        return r101;
    }
}
