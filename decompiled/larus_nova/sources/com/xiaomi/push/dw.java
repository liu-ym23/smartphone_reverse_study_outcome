package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public abstract class dw extends du {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Bitmap f460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private RemoteViews f461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected CharSequence f462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<Notification.Action> f464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected Map<String, String> f465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f463418b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected CharSequence f467b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f468b;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract String mo9035a();

    public void a(int r100, Notification.Action r101) {
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo9029a();

    public abstract String b();

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final void m9037b() {
        super.setContentTitle(this.f462a);
        super.setContentText(this.f467b);
        Bitmap r100 = this.f460a;
        if (r100 == null) goto L6;
        super.setLargeIcon(r100);
        return;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private void m9031c() {
        int r100 = a(a().getResources(), c(), "layout", a().getPackageName());
        if (r100 == 0) goto L5;
        this.f461a = new RemoteViews(a().getPackageName(), r100);
        this.f466a = mo9029a();
        return;
    L5:
        com.xiaomi.channel.commonutils.logger.b.m8718a("create RemoteViews failed, no such layout resource was found");
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    private boolean m9033d() {
        if (TextUtils.isEmpty(b()) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f463a) == true) goto L7;
        return true;
    }

    private boolean e() {
        if (m9033d() == true) goto L5;
    L7:
        return false;
    L5:
        if (f() == false) goto L7;
        return true;
    }

    private boolean f() {
        List<StatusBarNotification> r100 = com.xiaomi.push.service.af.a(a(), this.f463a).m9355b();
        if (r100 != null) goto L5;
    L17:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L17;
        Iterator<StatusBarNotification> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L17;
        StatusBarNotification r102 = r101.next();
        if (r102.getId() != this.f463417a) goto L9;
        Notification r103 = r102.getNotification();
        if (r103 != null) goto L16;
        return false;
    L16:
        return !r103.extras.getBoolean("mipush.customCopyLayout", true);
    }

    @Override // com.xiaomi.push.du
    /* JADX INFO: renamed from: a */
    public void mo9028a() {
        super.mo9028a();
        Bundle r100 = new Bundle();
        if (m9033d() == false) goto L5;
        r100.putBoolean("mipush.customCopyLayout", this.f468b);
    L6:
        r100.putBoolean("miui.customHeight", false);
        r100.putBoolean("mipush.customNotification", true);
        r100.putInt("mipush.customLargeIconId", a("large_icon"));
        if (this.f464a.size() <= 0) goto L10;
        Notification.Action[] r101 = new Notification.Action[this.f464a.size()];
        this.f464a.toArray(r101);
        r100.putParcelableArray("mipush.customActions", r101);
    L10:
        if (m9032c() == false) goto L12;
    L15:
        d();
    L16:
        a(r100);
        return;
    L12:
        if (com.xiaomi.push.service.ag.m9357a(a().getContentResolver()) == false) goto L15;
        r100.putCharSequence("mipush.customTitle", this.f462a);
        r100.putCharSequence("mipush.customContent", this.f467b);
        goto L16
    L5:
        r100.putBoolean("mipush.customCopyLayout", false);
        goto L6
    }

    private Bitmap a() {
        return com.xiaomi.push.service.x.a(g.m9119a(a(), this.f463a));
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private boolean m9032c() {
        Map<String, String> r100 = this.f465a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (Boolean.parseBoolean(r100.get("custom_builder_set_title")) == false) goto L7;
        return true;
    }

    private void d() {
        super.setContentTitle(this.f462a);
        super.setContentText(this.f467b);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final boolean m9038b() {
        return this.f466a;
    }

    private String c() {
        boolean r100 = e();
        this.f468b = r100;
        if (r100 == false) goto L6;
        return b();
    L6:
        return mo9035a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final RemoteViews m9034a() {
        return this.f461a;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_xiaomi_push_dw_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final boolean m9036a(int r100) {
        if ((((((double) Color.red(r100)) * 0.299d) + (((double) Color.green(r100)) * 0.587d)) + (((double) Color.blue(r100)) * 0.114d)) >= 192.0d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder addAction(Notification.Action r100) {
        return a(r100);
    }

    public dw b(CharSequence r100) {
        this.f467b = r100;
        return this;
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setContentText(CharSequence r100) {
        return b(r100);
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setContentTitle(CharSequence r100) {
        return a(r100);
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setLargeIcon(Bitmap r100) {
        return a(r100);
    }

    public void a(int r100) {
        Bitmap r101 = a();
        if (r101 == null) goto L5;
        m9034a().setImageViewBitmap(r100, r101);
        return;
    L5:
        int r102 = g.b(a(), this.f463a);
        if (r102 == 0) goto L10;
        m9034a().setImageViewResource(r100, r102);
        return;
    }

    public int a(float r100) {
        return (int) ((r100 * INVOKEVIRTUAL_com_xiaomi_push_dw_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(a().getResources()).density) + 0.5f);
    }

    public dw a(Notification.Action r100) {
        if (r100 == null) goto L4;
        this.f464a.add(r100);
    L4:
        int r101 = this.f463418b;
        this.f463418b = r101 + 1;
        a(r101, r100);
        return this;
    }

    @Override // com.xiaomi.push.du
    public du a(Map<String, String> r100) {
        this.f465a = r100;
        return this;
    }

    public dw a(Bitmap r100) {
        this.f460a = r100;
        return this;
    }

    public dw a(CharSequence r100) {
        this.f462a = r100;
        return this;
    }

    public dw(Context r100, String r101) {
        this(r100, 0, r101);
    }

    public Bitmap a(Bitmap r100, float r101) {
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        Rect r105 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
        r103.drawRoundRect(new RectF(r105), r101, r101, r104);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r103.drawBitmap(r100, r105, r105, r104);
        if (r100.isRecycled() == true) goto L5;
        r100.recycle();
    L5:
        return r102;
    }

    public dw(Context r100, int r101, String r102) {
        super(r100);
        this.f464a = new ArrayList();
        this.f463418b = 0;
        this.f463a = r102;
        this.f463417a = r101;
        m9031c();
    }

    public dw a(int r100, CharSequence r101, PendingIntent r102) {
        a(new Notification.Action(r100, r101, r102));
        return this;
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder addAction(int r100, CharSequence r101, PendingIntent r102) {
        return a(r100, r101, r102);
    }
}
