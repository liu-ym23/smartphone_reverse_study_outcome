package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class dt extends dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f463411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f463412c;

    @Override // com.xiaomi.push.dw
    public dw a(Bitmap r100) {
        return this;
    }

    @Override // com.xiaomi.push.dw
    /* JADX INFO: renamed from: a */
    public String mo9035a() {
        return "notification_banner";
    }

    @Override // com.xiaomi.push.dw
    public String b() {
        return null;
    }

    @Override // com.xiaomi.push.dw, com.xiaomi.push.du
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo9028a() {
        if (m9038b() == true) goto L5;
    L26:
        m9037b();
        return;
    L5:
        if (this.f463411b == null) goto L26;
        super.mo9028a();
        Resources r100 = a().getResources();
        String r101 = a().getPackageName();
        int r102 = a(r100, "bg", "id", r101);
        if (j.a(a()) < 10) goto L9;
        m9034a().setImageViewBitmap(r102, a(this.f463411b, 30.0f));
    L10:
        int r103 = a(r100, "icon", "id", r101);
        if (this.f463412c == null) goto L13;
        m9034a().setImageViewBitmap(r103, this.f463412c);
    L14:
        int r104 = a(r100, "title", "id", r101);
        m9034a().setTextViewText(r104, this.f462a);
        Map<String, String> r105 = this.f465a;
        if (r105 != null) goto L17;
    L19:
        RemoteViews r106 = m9034a();
        int r107 = this.f463410a;
        if (r107 != 16777216) goto L22;
    L24:
        int r108 = -1;
    L25:
        r106.setTextColor(r104, r108);
        a(m9034a());
        Bundle r109 = new Bundle();
        r109.putBoolean("miui.customHeight", true);
        a(r109);
        return;
    L22:
        if (m9036a(r107) == false) goto L24;
        r108 = -16777216;
        goto L25
    L17:
        if (this.f463410a != 16777216) goto L19;
        mo9030a(r105.get("notification_image_text_color"));
        goto L19
    L13:
        a(r103);
        goto L14
    L9:
        m9034a().setImageViewBitmap(r102, this.f463411b);
        goto L10
    }

    @Override // com.xiaomi.push.dw
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo9029a() {
        if (j.m9294a() == true) goto L5;
        return false;
    L5:
        Resources r100 = a().getResources();
        String r101 = a().getPackageName();
        int r102 = a(a().getResources(), "bg", "id", a().getPackageName());
        int r103 = a(r100, "icon", "id", r101);
        int r104 = a(r100, "title", "id", r101);
        if (r102 == 0) goto L13;
        if (r103 == 0) goto L14;
        if (r104 != 0) goto L10;
        return false;
    L10:
        if (j.a(a()) < 9) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    L13:
        return false;
    }

    @Override // com.xiaomi.push.dw
    public dt a(Bitmap r100) {
        if (m9038b() == false) goto L13;
        if (r100 == null) goto L13;
        if (r100.getWidth() == 984) goto L8;
    L12:
        com.xiaomi.channel.commonutils.logger.b.m8718a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
        goto L13
    L8:
        if (184 > r100.getHeight()) goto L12;
        if (r100.getHeight() > 1678) goto L12;
        this.f463411b = r100;
    L13:
        return this;
    }

    public dt b(Bitmap r100) {
        if (m9038b() == false) goto L6;
        if (r100 == null) goto L6;
        this.f463412c = r100;
    L6:
        return this;
    }

    @Override // com.xiaomi.push.dw, android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setLargeIcon(Bitmap r100) {
        return a(r100);
    }

    @Override // com.xiaomi.push.du
    /* JADX INFO: renamed from: a */
    public dt mo9030a(String r100) {
        if (m9038b() == true) goto L5;
    L9:
        return this;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        this.f463410a = Color.parseColor(r100);     // Catch: Exception -> L8
    L8:
        com.xiaomi.channel.commonutils.logger.b.m8718a("parse banner notification image text color error");
        goto L9
    }

    public dt(Context r100, String r101) {
        super(r100, r101);
        this.f463410a = 16777216;
    }
}
