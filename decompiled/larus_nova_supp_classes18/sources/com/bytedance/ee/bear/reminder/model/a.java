package com.bytedance.ee.bear.reminder.model;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a {
    public boolean a;
    public long b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public EAlertTimeEvent g;
    public EAlertTimeEvent h;
    public List<ReminderUserEntity> i;
    public String j;
    public List<String> k;
    public ReminderModel.CreateTaskSwitchBean l;
    public int m;
    public String n;

    public List<EAlertTimeEvent> b() {
        return Arrays.asList(new EAlertTimeEvent[]{EAlertTimeEvent.noAlert, EAlertTimeEvent.onDayOfEvent, EAlertTimeEvent.oneDayBefore, EAlertTimeEvent.twoDaysBefore, EAlertTimeEvent.oneWeekBefore});
    }

    public int c() {
        return 2131105628;
    }

    public int d() {
        return 2131105629;
    }

    public int e() {
        return 2131105630;
    }

    public final void f() {
        this.a = true;
        long r1 = System.currentTimeMillis();
        Calendar r3 = Calendar.getInstance();
        r3.setTimeInMillis(r1);
        r3.add(5, 1);
        r3.set(12, (r3.get(12) / 5) * 5);
        this.b = r3.getTimeInMillis();
        this.c = true;
        this.d = true;
        this.e = false;
        this.f = false;
        this.g = EAlertTimeEvent.onDayOfEvent;
        this.h = EAlertTimeEvent.atTimeOfEvent;
        this.i = null;
        this.j = null;
    }

    public /* synthetic */ int g() {
        return 0;
    }

    public /* synthetic */ int h() {
        return 0;
    }

    public /* synthetic */ boolean i() {
        return false;
    }

    public /* synthetic */ boolean j() {
        return false;
    }

    public List<EAlertTimeEvent> a() {
        return Arrays.asList(new EAlertTimeEvent[]{EAlertTimeEvent.noAlert, EAlertTimeEvent.atTimeOfEvent, EAlertTimeEvent.before5Mins, EAlertTimeEvent.before15Mins, EAlertTimeEvent.before30Mins, EAlertTimeEvent.before1Hour, EAlertTimeEvent.before2Hours, EAlertTimeEvent.before1Day, EAlertTimeEvent.before2Days, EAlertTimeEvent.before1Week});
    }

    public a() {
        this.d = false;
        this.f = false;
        this.m = 1;
        this.n = null;
        f();
    }

    public a(a r3) {
        this.d = false;
        this.f = false;
        this.m = 1;
        this.n = null;
        if (r3 != null) goto L5;
        f();
        return;
    L5:
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
        this.j = r3.j;
        this.k = r3.k;
        this.l = r3.l;
        this.m = r3.m;
        this.n = r3.n;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if ((this.b / 1000) == (r11.b / 1000)) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.m == r11.m) goto L24;
        return false;
    L24:
        if (TextUtils.equals(this.n, r11.n) == true) goto L27;
        return false;
    L27:
        if (TextUtils.equals(this.j, r11.j) == true) goto L29;
        return false;
    L29:
        String r3 = "";
        if (TextUtils.isEmpty(this.j) == false) goto L32;
        String r1 = "";
    L34:
        if (TextUtils.isEmpty(r11.j) == true) goto L38;
        r3 = r11.j;
    L38:
        if (TextUtils.equals(r1, r3) == true) goto L40;
        return false;
    L40:
        List<ReminderUserEntity> r2 = this.i;
        if (r2 == null) goto L50;
        List<ReminderUserEntity> r4 = r11.i;
        if (r4 == null) goto L50;
        if (r2.containsAll(r4) == true) goto L48;
    L49:
        return false;
    L48:
        if (r11.i.containsAll(this.i) == false) goto L49;
    L55:
        if (this.a == false) goto L62;
        if (this.h == r11.h) goto L67;
        return false;
    L67:
        return true;
    L62:
        if (this.g == r11.g) goto L68;
        return false;
    L68:
        return true;
    L50:
        if (r2 == null) goto L52;
    L66:
        return false;
    L52:
        if (r11.i == null) goto L55;
    L32:
        r1 = this.j;
        goto L34
    }
}
