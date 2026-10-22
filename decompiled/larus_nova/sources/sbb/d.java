package sbb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer[] f541292a = null;

    static {
        f541292a = new Integer[]{Integer.valueOf(R.color.ud_O400), Integer.valueOf(R.color.ud_R400), Integer.valueOf(R.color.ud_C400), Integer.valueOf(R.color.ud_V400), Integer.valueOf(R.color.ud_P400), Integer.valueOf(R.color.ud_B400), Integer.valueOf(R.color.ud_I400), Integer.valueOf(R.color.ud_W400), Integer.valueOf(R.color.ud_T400), Integer.valueOf(R.color.ud_G400)};
    }

    public static Bitmap a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "unicode");
        int r100 = rbb.a.f537002a;
        Intrinsics.checkNotNullParameter(r110, "unicode");
        List r101 = StringsKt.split$default(r110, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L20
        if (r101.size() <= 1) goto L15;
        StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L20
        Iterator r102 = r101.iterator();     // Catch: Exception -> L20
    L8:
        if (r102.hasNext() == false) goto L14;
        int r103 = CastIntegerProtector.parseInt((String) r102.next(), 16);     // Catch: Exception -> L20
        if (ypb.b.b(r103) == false) goto L13;
        r111.append(new String(Character.toChars(r103)));     // Catch: Exception -> L20
        goto L8
    L13:
        throw new Exception("codePoint " + r103 + " is not emoji");     // Catch: Exception -> L20
    L14:
        String r112 = r111.toString();     // Catch: Exception -> L20
    L22:
        if (r112 == null) goto L44;
        Context r104 = rbb.a.f();
        int r105 = UIUtils.dp2px(r104, 44.0f);     // Catch: Exception -> L35
        TextView r106 = new TextView(r104);     // Catch: Exception -> L35
        r106.setIncludeFontPadding(false);     // Catch: Exception -> L35
        r106.setGravity(17);     // Catch: Exception -> L35
        r106.setLayoutParams(new ViewGroup.LayoutParams(r105, r105));     // Catch: Exception -> L35
        r106.setText(r112);     // Catch: Exception -> L35
        r106.measure(View.MeasureSpec.makeMeasureSpec(r105, 0), View.MeasureSpec.makeMeasureSpec(r105, 0));     // Catch: Exception -> L35
        r106.layout(0, 0, r106.getMeasuredWidth(), r106.getMeasuredHeight());     // Catch: Exception -> L35
        Bitmap r113 = Bitmap.createBitmap(r106.getMeasuredWidth(), r106.getMeasuredHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L35
        Canvas r107 = new Canvas(r113);     // Catch: Exception -> L35
        r106.draw(r107);     // Catch: Exception -> L35
        r107.save();     // Catch: Exception -> L35
        Bitmap r108 = Bitmap.createBitmap(r105, r105, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L35
        Canvas r109 = new Canvas(r108);     // Catch: Exception -> L35
        if (r113.getWidth() <= r113.getHeight()) goto L28;
        float r114 = r105;
    L30:
        if (r113.getWidth() <= r113.getHeight()) goto L32;
        float r115 = (r113.getHeight() / r113.getWidth()) * r105;     // Catch: Exception -> L35
    L33:
        float r116 = r105;
        float r117 = 2;
        float r118 = (r116 - r114) / r117;     // Catch: Exception -> L35
        float r119 = (r116 - r115) / r117;     // Catch: Exception -> L35
        r109.drawBitmap(r113, null, new RectF(r118, r119, r116 - r118, r116 - r119), new Paint());     // Catch: Exception -> L35
        return r108;
    L32:
        r115 = r105;
        goto L33
    L28:
        r114 = (r113.getWidth() / r113.getHeight()) * r105;     // Catch: Exception -> L35
    L35:
        e = move-exception;
        Log.e("DOCS_ICON_BitmapHelper", "getUnicodeBitmap unicode error " + e.getMessage());
        return null;
    L44:
        return null;
    L15:
        int r120 = CastIntegerProtector.parseInt(r110, 16);     // Catch: Exception -> L20
        if (ypb.b.b(r120) == false) goto L19;
        r112 = new String(Character.toChars(r120));     // Catch: Exception -> L20
        goto L22
    L19:
        throw new Exception("codePoint " + r120 + " is not emoji");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Log.e("DOCS_ICON_BitmapHelper", "getUnicodeBitmap unicode error " + e.getMessage());
        r112 = null;
        goto L22
    }
}
