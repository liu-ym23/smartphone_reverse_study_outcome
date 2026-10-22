package com.ss.android.lark.usersetting.service.timeformat;

import aac.g;
import android.text.format.DateFormat;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f444648b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<com.ss.android.lark.usersetting.service.timeformat.a, Object> f444649a;

    public class a implements aac.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f444650a;

        public a(b r100) {
            this.f444650a = r100;
        }

        @Override // aac.b.a
        public final void a(UserSetting r100, UserSetting r101) {
            b r102 = this.f444650a;
            r102.getClass();
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r102, r101, r100));
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.usersetting.service.timeformat.b$b, reason: collision with other inner class name */
    public static class C5374b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f444651a = null;

        static {
            f444651a = new b();
        }
    }

    static {
        f444648b = new Object();
    }

    public b() {
        this.f444649a = new ConcurrentHashMap();
        a r100 = new a(this);
        g.d.f2395a.c(r100);
    }

    public static TimeFormatSetting a(TimeFormatSetting r100) {
        if (r100 != null) goto L5;
        r100 = new TimeFormatSetting();
        r100.setTimeFormat(TimeFormatSetting.TimeFormat.UNKNOWN);
    L5:
        if (r100.getTimeFormat() == TimeFormatSetting.TimeFormat.UNKNOWN) goto L7;
    L10:
        return r100;
    L7:
        if (DateFormat.is24HourFormat(LarkContext.getApplication()) == false) goto L9;
        r100.setTimeFormat(TimeFormatSetting.TimeFormat.TWENTY_FOUR_HOUR);
        goto L10
    L9:
        r100.setTimeFormat(TimeFormatSetting.TimeFormat.TWELVE_HOUR);
        goto L10
    }
}
