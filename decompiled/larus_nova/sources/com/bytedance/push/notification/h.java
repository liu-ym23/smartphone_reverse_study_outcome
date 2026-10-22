package com.bytedance.push.notification;

import android.content.Context;
import com.bytedance.push.PushBody;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v67.l f266960a;

    public h(v67.l r100) {
        this.f266960a = r100;
    }

    public static List b(Context r100) {
        long r101 = TimeUnit.DAYS.toMillis(1);
        ArrayList r102 = new ArrayList();
        List<y67.c> r103 = ((LocalFrequencySettings) j77.i.a(r100, LocalFrequencySettings.class)).j();
        long r104 = ToolUtils.currentTimeMillis();
        if (r103 == null) goto L13;
        Iterator<y67.c> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L13;
        y67.c r106 = r105.next();
        if (r106 == null) goto L6;
        if ((r106.f566374c + r101) <= r104) goto L6;
        r102.add(r106);
    L13:
        return r102;
    }

    public static void a(Context r100, PushBody r101, List r102, int r103) {
        Iterator r104 = ((ArrayList) r102).iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        y67.c r105 = (y67.c) r104.next();
        if (r105 == null) goto L4;
        if (r105.f566373b != r101.f266734w) goto L4;
        return;
    L10:
        y67.c r106 = new y67.c();
        r106.f566372a = r101.f266713b;
        r106.f566373b = r101.f266734w;
        r106.f566375d = r103;
        r106.f566374c = ToolUtils.currentTimeMillis();
        ((ArrayList) r102).add(r106);
        ((LocalFrequencySettings) j77.i.a(r100, LocalFrequencySettings.class)).b0(r102);
    }
}
