package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class l implements BaseNotifyLayoutAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Resources f462586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462587b;

    public l() {
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f462586a.getIdentifier("push_notify", "layout", this.f462587b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        if (m.f462591d == false) goto L8;
        Resources r100 = this.f462586a;
        String r101 = "notify_icon_rom30";
    L6:
        return r100.getIdentifier(r101, "id", this.f462587b);
    L8:
        if (m.f462590c == false) goto L10;
        r100 = this.f462586a;
        r101 = "notify_icon_rom20";
        goto L6
    L10:
        r100 = this.f462586a;
        r101 = "notify_icon";
        goto L6
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int r100 = ((Integer) ah.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();     // Catch: Exception -> L4
    L6:
        if (r100 > 0) goto L8;
        boolean r101 = m.f462591d;
        if (r101 == false) goto L13;
        return -1;
    L13:
        if (m.f462590c == false) goto L18;
        if (r101 == true) goto L16;
        return -1;
    L16:
        return ColorProtector.parseColor("#ff999999");
    L18:
        return -16777216;
    L8:
        return this.f462586a.getColor(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        r100 = 0;
        goto L6
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context r100) {
        this.f462587b = r100.getPackageName();
        this.f462586a = r100.getResources();
    }
}
