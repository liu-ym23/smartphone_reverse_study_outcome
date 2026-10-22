package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class dv extends dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private PendingIntent f457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f463415b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Bitmap f458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f463416c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private CharSequence f459c;

    @Override // com.xiaomi.push.dw
    /* JADX INFO: renamed from: a */
    public String mo9035a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.dw
    public String b() {
        return "notification_colorful_copy";
    }

    @Override // com.xiaomi.push.dw, com.xiaomi.push.du
    /* JADX INFO: renamed from: a */
    public void mo9028a() {
        if (m9038b() == false) goto L50;
        super.mo9028a();
        Resources r100 = a().getResources();
        String r101 = a().getPackageName();
        int r102 = a(r100, "icon", "id", r101);
        if (this.f460a != null) goto L7;
        a(r102);
    L8:
        int r103 = a(r100, "title", "id", r101);
        int r104 = a(r100, "content", "id", r101);
        m9034a().setTextViewText(r103, this.f462a);
        m9034a().setTextViewText(r104, this.f467b);
        if (TextUtils.isEmpty(this.f459c) == true) goto L17;
        int r105 = a(r100, "buttonContainer", "id", r101);
        int r106 = a(r100, "button", "id", r101);
        int r110 = a(r100, "buttonBg", "id", r101);
        m9034a().setViewVisibility(r105, 0);
        m9034a().setTextViewText(r106, this.f459c);
        m9034a().setOnClickPendingIntent(r105, this.f457a);
        if (this.f463415b == 16777216) goto L17;
        int r107 = a(70.0f);
        int r111 = a(29.0f);
        m9034a().setImageViewBitmap(r110, com.xiaomi.push.service.x.a(a(this.f463415b, r107, r111, r111 / 2.0f)));
        RemoteViews r108 = m9034a();
        if (m9036a(this.f463415b) == false) goto L15;
        int r112 = -1;
    L16:
        r108.setTextColor(r106, r112);
        goto L17
    L15:
        r112 = -16777216;
    L17:
        int r109 = a(r100, "bg", "id", r101);
        int r113 = a(r100, KtvSubElement.CONTAINER, "id", r101);
        if (this.f463414a == 16777216) goto L25;
        if (j.a(a()) < 10) goto L22;
        m9034a().setImageViewBitmap(r109, com.xiaomi.push.service.x.a(a(this.f463414a, 984, 192, 30.0f)));
    L23:
        a(m9034a(), r113, r103, r104, m9036a(this.f463414a));
    L49:
        Bundle r114 = new Bundle();
        r114.putBoolean("miui.customHeight", true);
        a(r114);
        a(m9034a());
        return;
    L22:
        m9034a().setImageViewBitmap(r109, com.xiaomi.push.service.x.a(a(this.f463414a, 984, 192, 0.0f)));
        goto L23
    L25:
        if (this.f458b == null) goto L44;
        if (j.a(a()) < 10) goto L29;
        m9034a().setImageViewBitmap(r109, a(this.f458b, 30.0f));
    L30:
        Map<String, String> r115 = this.f465a;
        if (r115 != null) goto L33;
    L35:
        int r116 = this.f463416c;
        if (r116 != 16777216) goto L38;
    L41:
        boolean r117 = true;
    L42:
        a(m9034a(), r113, r103, r104, r117);
        goto L49
    L38:
        if (m9036a(r116) == false) goto L41;
        r117 = false;
        goto L42
    L33:
        if (this.f463416c != 16777216) goto L35;
        c(r115.get("notification_image_text_color"));
        goto L35
    L29:
        m9034a().setImageViewBitmap(r109, this.f458b);
        goto L30
    L44:
        if (Build.VERSION.SDK_INT < 24) goto L49;
        m9034a().setViewVisibility(r102, 8);
        m9034a().setViewVisibility(r109, 8);
        av.a(this, "setStyle", new Object[]{q.a(a(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0])});     // Catch: Exception -> L48
    L48:
        com.xiaomi.channel.commonutils.logger.b.m8718a("load class DecoratedCustomViewStyle failed");
        goto L49
    L7:
        m9034a().setImageViewBitmap(r102, this.f460a);
        goto L8
    L50:
        m9037b();
    }

    @Override // com.xiaomi.push.dw
    /* JADX INFO: renamed from: a */
    public boolean mo9029a() {
        if (j.m9294a() == true) goto L5;
        return false;
    L5:
        Resources r100 = a().getResources();
        String r101 = a().getPackageName();
        int r102 = a(r100, "icon", "id", r101);
        int r103 = a(r100, "title", "id", r101);
        int r104 = a(r100, "content", "id", r101);
        if (r102 == 0) goto L11;
        if (r103 == 0) goto L12;
        if (r104 == 0) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L11:
        return false;
    }

    @Override // com.xiaomi.push.dw
    public dv a(Bitmap r100) {
        if (m9038b() == false) goto L13;
        if (r100 == null) goto L13;
        if (r100.getWidth() == 984) goto L8;
    L12:
        com.xiaomi.channel.commonutils.logger.b.m8718a("colorful notification bg image resolution error, must [984*177, 984*207]");
        goto L13
    L8:
        if (r100.getHeight() < 177) goto L12;
        if (r100.getHeight() > 207) goto L12;
        this.f458b = r100;
    L13:
        return this;
    }

    public dv b(String r100) {
        if (m9038b() == true) goto L5;
    L9:
        return this;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        this.f463414a = Color.parseColor(r100);     // Catch: Exception -> L8
    L8:
        com.xiaomi.channel.commonutils.logger.b.m8718a("parse colorful notification bg color error");
        goto L9
    }

    public dv c(String r100) {
        if (m9038b() == true) goto L5;
    L9:
        return this;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        this.f463416c = Color.parseColor(r100);     // Catch: Exception -> L8
    L8:
        com.xiaomi.channel.commonutils.logger.b.m8718a("parse colorful notification image text color error");
        goto L9
    }

    @Override // com.xiaomi.push.du
    /* JADX INFO: renamed from: a */
    public dv mo9030a(String r100) {
        if (m9038b() == true) goto L5;
    L9:
        return this;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        this.f463415b = Color.parseColor(r100);     // Catch: Exception -> L8
    L8:
        com.xiaomi.channel.commonutils.logger.b.m8718a("parse colorful notification button bg color error");
        goto L9
    }

    public dv a(CharSequence r100, PendingIntent r101) {
        if (m9038b() == false) goto L5;
        super.a(0, r100, r101);
        this.f459c = r100;
        this.f457a = r101;
    L5:
        return this;
    }

    public dv(Context r100, int r101, String r102) {
        super(r100, r101, r102);
        this.f463414a = 16777216;
        this.f463415b = 16777216;
        this.f463416c = 16777216;
    }

    private Drawable a(int r100, int r101, int r102, float r103) {
        ShapeDrawable r104 = new ShapeDrawable();
        r104.setShape(new RoundRectShape(new float[]{r103, r103, r103, r103, r103, r103, r103, r103}, null, null));
        r104.getPaint().setColor(r100);
        r104.getPaint().setStyle(Paint.Style.FILL);
        r104.setIntrinsicWidth(r101);
        r104.setIntrinsicHeight(r102);
        return r104;
    }

    private void a(RemoteViews r100, int r101, int r110, int r111, boolean r112) {
        int r102 = a(6.0f);
        r100.setViewPadding(r101, r102, 0, r102, 0);
        if (r112 == false) goto L5;
        r100.setTextColor(r110, -1);
        r100.setTextColor(r111, -1);
        return;
    L5:
        r100.setTextColor(r110, -16777216);
        r100.setTextColor(r111, -16777216);
    }
}
