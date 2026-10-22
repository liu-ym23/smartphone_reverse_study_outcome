package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.du;
import com.xiaomi.push.ha;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ab {
    public abstract du a(Context r100, int r101, String r102, Map<String, String> r103);

    public abstract void a(ha r100, Map<String, String> r101, int r102, Notification r103);

    public abstract void a(String r100);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract boolean m9338a(Context r100, int r101, String r102, Map<String, String> r103);

    public abstract boolean a(Map<String, String> r100, int r101, Notification r102);
}
