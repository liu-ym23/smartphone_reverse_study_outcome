package com.ss.android.lark.picker.base.widget.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.a0;
import h18.e;
import java.util.Random;

/* JADX INFO: loaded from: classes37.dex */
public class FakePickerAvatarCreator {
    public static final int BLACK = -16777216;
    public static final int BLUE = -16776961;
    public static final int CYAN = -16711681;
    public static final int DKGRAY = -12303292;
    public static final int GRAY = -7829368;
    public static final int GREEN = -16711936;
    public static final int LTGRAY = -3355444;
    public static final int MAGENTA = -65281;
    public static final int RED = -65536;
    public static final int YELLOW = -256;
    private static Integer[] colorSet;

    public FakePickerAvatarCreator() {
    }

    static {
        colorSet = new Integer[]{-16777216, Integer.valueOf(DKGRAY), Integer.valueOf(GRAY), Integer.valueOf(LTGRAY), -65536, Integer.valueOf(GREEN), Integer.valueOf(BLUE), -256, Integer.valueOf(CYAN), Integer.valueOf(MAGENTA)};
    }

    private static int getRandomColor() {
        return colorSet[new Random().nextInt(10)].intValue();
    }

    public static Bitmap createFakeAvatar(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(a0.a(r100, r101)) == false) goto L5;
        int r103 = UIUtils.dp2px(r100, 100.0f);
        return createNameAvatarBitmap(r103, r103, r102);
    L5:
        return null;
    }

    public static Bitmap createFakeAvatarForGroupChat(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L7;
        return null;
    L7:
        return createFakeAvatar(r100, r101, UIUtils.getString(r100, R.string.Lark_Legacy_GroupLabelTip));
    }

    public static Bitmap createNameAvatarBitmap(int r100, int r101, String r102) {
        return createNameAvatarBitmap(r100, r101, r102, getRandomColor());
    }

    public static Bitmap createNameAvatarBitmap(int r100, int r101, String r102, int r110) {
        Bitmap r103 = Bitmap.createBitmap(r100, r100, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        RectF r105 = new RectF(0.0f, 0.0f, r104.getWidth(), r104.getHeight());
        Paint r106 = new Paint(257);
        r106.setColor(-1);
        r104.drawOval(r105, r106);
        r106.setColor(r110);
        float r107 = r101;
        r104.drawRect(new RectF(r107, r107, r105.width() - r107, r105.height() - r107), r106);
        r106.setColor(-1);
        r106.setStrokeWidth(3.0f);
        r106.setTextSize(r100 * 0.5f);
        r106.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt r108 = r106.getFontMetricsInt();
        r104.drawText(r102, r105.centerX(), (((r105.bottom + r105.top) - r108.bottom) - r108.top) / 2.0f, r106);
        return r103;
    }

    public static Bitmap createNameAvatarBitmap(int r100, float r101, String r102, int r103, Context r110) {
        Bitmap r104 = Bitmap.createBitmap(r100, r100, Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        RectF r106 = new RectF(0.0f, 0.0f, r105.getWidth(), r105.getHeight());
        Paint r107 = new Paint(257);
        r107.setTypeface(e.a(r110));
        r107.setColor(-1);
        r105.drawOval(r106, r107);
        r107.setColor(r103);
        float r108 = r100;
        r105.drawRect(new RectF(r108, r108, r106.width() - r108, r106.height() - r108), r107);
        r107.setColor(-1);
        r107.setStrokeWidth(3.0f);
        r107.setTextSize(r101);
        r107.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt r109 = r107.getFontMetricsInt();
        r105.drawText(r102, r106.centerX(), (((r106.bottom + r106.top) - r109.bottom) - r109.top) / 2.0f, r107);
        return r104;
    }

    public static Bitmap createFakeAvatarForChatter(Context r100, String r101, String r102, boolean r103, String r104, int r105) {
        if (TextUtils.isEmpty(r104) == true) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(a0.a(r100, r101 + ".jpg")) == false) goto L15;
        if (r103 == false) goto L13;
        int r106 = UIUtils.dp2px(r100, 0.0f);
        if (TextUtils.isEmpty(r102) == true) goto L16;
        r102 = r102.substring(r102.length() - 1);
    L16:
        return createNameAvatarBitmap(UIUtils.dp2px(r100, r105), r106, r102);
    L13:
        int r107 = UIUtils.dp2px(r100, 100.0f);
        return createNameAvatarBitmap(r107, r107, r102);
    L15:
        return null;
    }
}
