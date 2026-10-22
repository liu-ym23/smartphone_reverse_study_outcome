package com.ss.android.lark.picker.base.calendar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/base/calendar/EmailAvatarUtil;", "", "<init>", "()V", "getEmailAvatarBitmapByName", "Landroid/graphics/Bitmap;", "localizedDisplayName", "", "avatarSize", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmailAvatarUtil {
    public static final EmailAvatarUtil INSTANCE = null;

    static {
        INSTANCE = new EmailAvatarUtil();
    }

    private EmailAvatarUtil() {
    }

    @JvmStatic
    public static final Bitmap getEmailAvatarBitmapByName(String r100, float r101, Context r110) {
        Intrinsics.checkNotNullParameter(r100, "localizedDisplayName");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = UIUtils.dp2px(LarkContext.getApplication(), r101);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        String r103 = "";
    L10:
        Bitmap r104 = Bitmap.createBitmap(r102, r102, Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        RectF r106 = new RectF(0.0f, 0.0f, r105.getWidth(), r105.getHeight());
        Paint r107 = new Paint(257);
        r107.setTypeface(e.a(r110));
        r107.setColor(-1);
        r105.drawOval(r106, r107);
        r107.setColor(UIHelper.getColor(R.color.lkui_B500));
        float r108 = r102;
        r105.drawRect(new RectF(r108, r108, r106.width() - r108, r106.height() - r108), r107);
        r107.setColor(-1);
        r107.setTextSize(r108 * 0.4f);
        r107.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt r109 = r107.getFontMetricsInt();
        r105.drawText(r103, r106.centerX(), (((r106.bottom + r106.top) - r109.bottom) - r109.top) / 2, r107);
        return r104;
    L6:
        if (r100.length() >= 2) goto L8;
        int r111 = r100.length();
    L9:
        r103 = r100.substring(0, r111).toUpperCase(Locale.ENGLISH);
        goto L10
    L8:
        r111 = 2;
        goto L9
    }
}
