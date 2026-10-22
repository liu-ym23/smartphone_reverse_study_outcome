package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class du extends Notification.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f463413a;

    public du a(Map<String, String> r100) {
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void mo9028a() {
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo9028a();
        return super.build();
    }

    public Context a() {
        return this.f463413a;
    }

    public du(Context r100) {
        super(r100);
        this.f463413a = r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public du mo9030a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L8:
        return this;
    L9:
        av.a(this, "setColor", new Object[]{Integer.valueOf(Color.parseColor(r100))});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e);
        goto L8
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder addExtras(Bundle r100) {
        return a(r100);
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ Notification.Builder setCustomContentView(RemoteViews r100) {
        return a(r100);
    }

    public final int a(String r100) {
        return a(a().getResources(), r100, "id", a().getPackageName());
    }

    public du a(RemoteViews r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        super.setCustomContentView(r100);
    L6:
        return this;
    L5:
        super.setContent(r100);
        goto L6
    }

    public du a(Bundle r100) {
        super.addExtras(r100);
        return this;
    }

    public int a(Resources r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return 0;
    L5:
        return r100.getIdentifier(r101, r102, r103);
    }
}
