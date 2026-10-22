package com.bytedance.ee.bear.reminder.model;

import android.text.TextUtils;
import com.larus.nova.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f236475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f236476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f236477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f236478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f236479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f236480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EAlertTimeEvent f236481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EAlertTimeEvent f236482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<ReminderUserEntity> f236483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f236484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f236485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ReminderModel.CreateTaskSwitchBean f236486l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f236487m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f236488n;

    public List<EAlertTimeEvent> b() {
        return Arrays.asList(new EAlertTimeEvent[]{EAlertTimeEvent.noAlert, EAlertTimeEvent.onDayOfEvent, EAlertTimeEvent.oneDayBefore, EAlertTimeEvent.twoDaysBefore, EAlertTimeEvent.oneWeekBefore});
    }

    public int c() {
        return R.color.reminder_select_after;
    }

    public int d() {
        return R.color.reminder_select_before;
    }

    public int e() {
        return R.color.reminder_select_current;
    }

    public final void f() {
        this.f236475a = true;
        long r100 = System.currentTimeMillis();
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        r101.add(5, 1);
        r101.set(12, (r101.get(12) / 5) * 5);
        this.f236476b = r101.getTimeInMillis();
        this.f236477c = true;
        this.f236478d = true;
        this.f236479e = false;
        this.f236480f = false;
        this.f236481g = EAlertTimeEvent.onDayOfEvent;
        this.f236482h = EAlertTimeEvent.atTimeOfEvent;
        this.f236483i = null;
        this.f236484j = null;
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
        this.f236478d = false;
        this.f236480f = false;
        this.f236487m = 1;
        this.f236488n = null;
        f();
    }

    public a(a r100) {
        this.f236478d = false;
        this.f236480f = false;
        this.f236487m = 1;
        this.f236488n = null;
        if (r100 != null) goto L5;
        f();
        return;
    L5:
        this.f236475a = r100.f236475a;
        this.f236476b = r100.f236476b;
        this.f236477c = r100.f236477c;
        this.f236478d = r100.f236478d;
        this.f236479e = r100.f236479e;
        this.f236480f = r100.f236480f;
        this.f236481g = r100.f236481g;
        this.f236482h = r100.f236482h;
        this.f236483i = r100.f236483i;
        this.f236484j = r100.f236484j;
        this.f236485k = r100.f236485k;
        this.f236486l = r100.f236486l;
        this.f236487m = r100.f236487m;
        this.f236488n = r100.f236488n;
    }

    public final boolean equals(Object r110) {
        if (this != r110) goto L6;
        return true;
    L6:
        if ((r110 instanceof a) == true) goto L8;
        return false;
    L8:
        a r111 = (a) r110;
        if (this.f236475a == r111.f236475a) goto L12;
        return false;
    L12:
        if ((this.f236476b / 1000) == (r111.f236476b / 1000)) goto L15;
        return false;
    L15:
        if (this.f236477c == r111.f236477c) goto L18;
        return false;
    L18:
        if (this.f236478d == r111.f236478d) goto L21;
        return false;
    L21:
        if (this.f236487m == r111.f236487m) goto L24;
        return false;
    L24:
        if (TextUtils.equals(this.f236488n, r111.f236488n) == true) goto L27;
        return false;
    L27:
        if (TextUtils.equals(this.f236484j, r111.f236484j) == true) goto L29;
        return false;
    L29:
        String r100 = "";
        if (TextUtils.isEmpty(this.f236484j) == false) goto L32;
        String r101 = "";
    L34:
        if (TextUtils.isEmpty(r111.f236484j) == true) goto L38;
        r100 = r111.f236484j;
    L38:
        if (TextUtils.equals(r101, r100) == true) goto L40;
        return false;
    L40:
        List<ReminderUserEntity> r102 = this.f236483i;
        if (r102 == null) goto L50;
        List<ReminderUserEntity> r103 = r111.f236483i;
        if (r103 == null) goto L50;
        if (r102.containsAll(r103) == true) goto L48;
    L49:
        return false;
    L48:
        if (r111.f236483i.containsAll(this.f236483i) == false) goto L49;
    L55:
        if (this.f236475a == false) goto L62;
        if (this.f236482h == r111.f236482h) goto L67;
        return false;
    L67:
        return true;
    L62:
        if (this.f236481g == r111.f236481g) goto L68;
        return false;
    L68:
        return true;
    L50:
        if (r102 == null) goto L52;
    L66:
        return false;
    L52:
        if (r111.f236483i == null) goto L55;
    L32:
        r101 = this.f236484j;
        goto L34
    }
}
