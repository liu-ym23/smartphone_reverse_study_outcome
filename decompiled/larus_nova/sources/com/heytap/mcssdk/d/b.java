package com.heytap.mcssdk.d;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.c;
import com.heytap.mcssdk.constant.d;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.constant.ConfigConstant;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.NotificationSortMessage;
import com.heytap.msp.push.notification.ISortListener;
import com.heytap.msp.push.notification.PushNotification;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f276393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<NotificationSortMessage> f276394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f276395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f276396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f276397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f276398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f276399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private StatusBarNotification f276400h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f276401a = null;

        static {
            f276401a = new b();
        }

        private a() {
        }

        public static /* synthetic */ b a() {
            return f276401a;
        }
    }

    public b() {
        this.f276393a = 3;
        this.f276394b = new ArrayList();
        this.f276397e = new ArrayList();
    }

    private int a(List<NotificationSortMessage> r100, int r101) {
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        if (r101 <= 0) goto L16;
        if (r102 == 0) goto L16;
        if (r102 >= r101) goto L12;
        int r103 = r101 - r102;
        r100.clear();
        return r103;
    L12:
        int r104 = 0;
    L13:
        if (r104 >= r101) goto L15;
        ListProtector.remove(r100, (r102 - 1) - r104);
        r104 = r104 + 1;
        goto L13
    L15:
        return 0;
    L16:
        return r101;
    L5:
        r102 = r100.size();
        goto L6
    }

    public static b a() {
        return a.a();
    }

    private DataMessage a(Context r100, NotificationSortMessage r101) {
        DataMessage r102 = new DataMessage(r100.getPackageName(), r101.getMessageId());
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L8
        r103.put(d.b.f276384a, "false");     // Catch: JSONException -> L8
        String r104 = r101.getStatisticData();     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r104) == true) goto L6;
        r103.put(d.b.f276385b, r104);     // Catch: JSONException -> L8
    L6:
        r102.setStatisticsExtra(r103.toString());     // Catch: JSONException -> L8
    L7:
        return r102;
    }

    private void a(int r100) {
        if (r100 != 7) goto L6;
        this.f276395c++;
        return;
    L6:
        if (r100 != 5) goto L10;
        this.f276396d++;
        return;
    }

    private void a(NotificationManager r100, Context r101, int r102) {
        a(com.heytap.mcssdk.d.a.a(r100, r101.getPackageName()), r102);
    }

    private void a(Context r100, NotificationManager r101, int r102) {
        a(this.f276394b, r102);
        a(r100, r101, this.f276394b);
    }

    private void a(Context r110, NotificationManager r111, List<NotificationSortMessage> r112) {
        if (r112 != null) goto L4;
        return;
    L4:
        if (r112.size() == 0) goto L19;
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();
        ArrayList r102 = new ArrayList();
        a(r110, r111, r101, r112, r102);
        if (r101.length() == 0) goto L12;
        r100.put(d.b.f276386c, r101);     // Catch: JSONException -> L10
        HeytapPushManager.cancelNotification(r100);     // Catch: JSONException -> L10
    L12:
        if (r102.size() == 0) goto L18;
        HashMap r113 = new HashMap();
        r113.put(c.a.f276380d, r102);
        StatisticUtils.statisticEvent(r110, r113);
        return;
    L18:
        return;
    }

    private void a(Context r100, NotificationManager r101, JSONArray r102, List<NotificationSortMessage> r103, List<DataMessage> r104) {
        Iterator<NotificationSortMessage> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        NotificationSortMessage r106 = r105.next();
        if (r106.isMcs() == true) goto L13;
        r104.add(a(r100, r106));
        this.f276397e.add(r106.getMessageId());
    L10:
        r101.cancel(r106.getNotifyId());
        goto L4
    L13:
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L12
        r107.put(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, r106.getMessageId());     // Catch: JSONException -> L12
        r107.put(ConfigConstant.NotificationSort.EXTRA_NOTIFY_ID, r106.getNotifyId());     // Catch: JSONException -> L12
        r102.put(r107);     // Catch: JSONException -> L12
        goto L10
    }

    private void a(NotificationSortMessage r100) {
        if (r100.getAutoDelete() == 1) goto L6;
        return;
    L6:
        if (this.f276394b.size() == 0) goto L16;
        int r101 = this.f276394b.size() - 1;
    L8:
        if (r101 < 0) goto L16;
        NotificationSortMessage r102 = (NotificationSortMessage) ListProtector.get(this.f276394b, r101);
        if (r100.getImportantLevel() < r102.getImportantLevel()) goto L15;
        if (r100.getPostTime() < r102.getPostTime()) goto L15;
        ListProtector.add(this.f276394b, r101 + 1, r102);
        return;
    L15:
        r101 = r101 - 1;
    L16:
        ListProtector.add(this.f276394b, 0, r100);
    }

    private void a(ISortListener r100, boolean r101, PushNotification.Builder r102) {
        if (r100 == null) goto L5;
        r100.buildCompleted(r101, r102, this.f276397e);
        return;
    }

    private void a(PushNotification.Builder r100, NotificationSortMessage r101) {
        Bundle r102 = new Bundle();
        r102.putInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, r101.getAutoDelete());
        r102.putInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, r101.getImportantLevel());
        r102.putString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, r101.getMessageId());
        r102.putLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, System.currentTimeMillis());
        r102.putBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, false);
        r102.putString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA, r101.getStatisticData());
        r100.addExtras(r102);
        r100.setGroup(r101.getGroup());
    }

    private void a(StatusBarNotification[] r110, int r210) {
        b();
        int r100 = 0;
        if (r110 == null) goto L14;
        if (r110.length == 0) goto L14;
        int r101 = r110.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L14;
        StatusBarNotification r103 = r110[r102];
        Bundle r104 = r103.getNotification().extras;
        boolean r111 = r104.getBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, true);
        long r112 = r104.getLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, r103.getPostTime());
        String r113 = r104.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
        int r105 = r104.getInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, 1);
        int r106 = r104.getInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, 5);
        String r114 = r104.getString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA);
        int r107 = r103.getId();
        if (r210 == r107) goto L10;
        NotificationSortMessage r108 = new NotificationSortMessage(r113, r106, r105, r111, r112, r107, r114);
        b(r105);
        a(r106);
        a(r108);
        r102 = r102 + 1;
        goto L7
    L10:
        this.f276400h = r103;
        return;
    L14:
        if (com.heytap.mcssdk.utils.d.g() == false) goto L19;
        com.heytap.mcssdk.utils.d.b("initParams : notDelete:" + this.f276399g + " canDelete : " + this.f276398f + "\n highSize : " + this.f276395c + " normalSize :" + this.f276396d + '\n');
        StringBuilder r109 = new StringBuilder("canDeleteList size : ");
        r109.append(this.f276394b.size());
        com.heytap.mcssdk.utils.d.b(r109.toString());
    L17:
        if (r100 >= this.f276394b.size()) goto L23;
        NotificationSortMessage r115 = (NotificationSortMessage) ListProtector.get(this.f276394b, r100);
        com.heytap.mcssdk.utils.d.b("第" + r100 + "条消息 messageId : " + r115.getMessageId() + " importanceLevel : " + r115.getImportantLevel() + " autoDelete : " + r115.getAutoDelete() + " notifyId: " + r115.getNotifyId() + " postTime:" + r115.getPostTime());
        r100 = r100 + 1;
        goto L17
    L23:
        return;
    }

    private boolean a(NotificationManager r100, Context r101, PushNotification.Builder r102, NotificationSortMessage r103) {
        if (com.heytap.mcssdk.utils.d.g() == false) goto L5;
        com.heytap.mcssdk.utils.d.b("dealCurrentMessage : deleteNumber" + (this.f276398f + this.f276399g) + " keepNumber : " + this.f276393a);
    L5:
        boolean r104 = true;
        if ((this.f276398f + this.f276399g) >= this.f276393a) goto L13;
        if (r103.getAutoDelete() != (-1)) goto L10;
        StringBuilder r105 = new StringBuilder(d.a.f276382b);
    L11:
        r105.append(r101.getPackageName());
        r103.setGroup(r105.toString());
    L24:
        if (com.heytap.mcssdk.utils.d.g() == false) goto L26;
        com.heytap.mcssdk.utils.d.b("dealCurrentMessage : needPost :" + r104);
    L26:
        if (r104 == false) goto L28;
        a(r102, r103);
    L29:
        return r104;
    L28:
        com.heytap.mcssdk.g.a.a(r101, c.a.f276379c, a(r101, r103));
        goto L29
    L10:
        r105 = new StringBuilder(d.a.f276383c);
        goto L11
    L13:
        if (r103.getAutoDelete() != (-1)) goto L22;
        r103.setGroup(d.a.f276382b + r101.getPackageName());
        int r106 = this.f276393a - this.f276399g;
        if (com.heytap.mcssdk.utils.d.g() == false) goto L17;
        com.heytap.mcssdk.utils.d.b("dealCurrentMessage : allowDelete :" + r106);
    L17:
        if (r106 <= 0) goto L19;
        a(r101, r100, r106 - 1);
        goto L24
    L19:
        Notification r107 = com.heytap.mcssdk.d.a.a(r101, r103.getGroup(), r102);
        if (r107 == null) goto L24;
        r100.notify(4096, r107);
        goto L24
    L22:
        r104 = a(r101, r100, r103);
        goto L24
    }

    private boolean a(Context r100, NotificationManager r101, NotificationSortMessage r102) {
        int r103 = this.f276399g;
        int r104 = this.f276393a;
        boolean r105 = false;
        if (r103 < r104) goto L5;
        return false;
    L5:
        int r106 = r104 - r103;
        if (com.heytap.mcssdk.utils.d.g() == false) goto L9;
        com.heytap.mcssdk.utils.d.b("judgeShowCurrentMessage : allowDelete" + r106);
    L9:
        if (r102.getImportantLevel() != 7) goto L12;
    L10:
        r105 = true;
    L19:
        if (r105 == false) goto L21;
        a(r100, r101, r106 - 1);
    L21:
        return r105;
    L12:
        if (r102.getImportantLevel() != 5) goto L17;
        if (this.f276395c >= r106) goto L19;
    L17:
        if ((this.f276395c + this.f276396d) >= r106) goto L19;
        goto L19
    }

    private boolean a(Context r100, PushNotification.Builder r101, NotificationSortMessage r102) {
        int r103 = r101.getVerifyNotifyId();
        StatusBarNotification r104 = this.f276400h;
        if (r104 != null) goto L5;
    L19:
        return false;
    L5:
        if (r103 == (-1)) goto L19;
        Notification r105 = r104.getNotification();
        if (r105 != null) goto L11;
        return false;
    L11:
        if (r102.getAutoDelete() != 1) goto L13;
        StringBuilder r106 = new StringBuilder(d.a.f276383c);
    L14:
        r106.append(r100.getPackageName());
        r102.setGroup(r106.toString());
        Bundle r107 = r105.extras;
        if (r107 != null) goto L17;
        return false;
    L17:
        String r108 = r107.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
        a(r101, r102);
        this.f276397e.add(r108);
        return true;
    L13:
        r106 = new StringBuilder(d.a.f276382b);
        goto L14
    }

    private boolean a(PushNotification.Builder r110, int r111, int r112, String r113, String r114) {
        Context r100 = PushService.getInstance().getContext();
        if (r110 == null) goto L14;
        if (r100 == null) goto L16;
        NotificationManager r101 = com.heytap.mcssdk.d.a.a(r100);
        NotificationSortMessage r115 = new NotificationSortMessage(r113, r112, r111, false, System.currentTimeMillis(), r114);
        if (a(r100, r101, r115, r110) == true) goto L9;
        return true;
    L9:
        a(r101, r100, r110.getVerifyNotifyId());
        if (a(r100, r110, r115) == false) goto L13;
        return true;
    L13:
        return a(r101, r100, r110, r115);
    L16:
        return false;
    L14:
        return false;
    }

    private void b() {
        this.f276398f = 0;
        this.f276399g = 0;
        this.f276395c = 0;
        this.f276396d = 0;
        this.f276394b.clear();
        this.f276397e.clear();
        this.f276400h = null;
    }

    private void b(int r100) {
        if (r100 != (-1)) goto L5;
        this.f276399g++;
        return;
    L5:
        if (r100 != 1) goto L9;
        this.f276398f++;
        return;
    }

    public void a(PushNotification.Builder r100, ISortListener r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        a(r101, a(r100, r100.getAutoDelete(), r100.getImportantLevel(), r100.getMessageId(), r100.getStatisticData()), r100);
    }

    public boolean a(Context r100, NotificationManager r101, NotificationSortMessage r102, PushNotification.Builder r103) {
        if (r102.getAutoDelete() != 0) goto L5;
        return false;
    L5:
        int r104 = Build.VERSION.SDK_INT;
        if (r104 >= 24) goto L8;
    L16:
        return false;
    L8:
        if (r104 >= 30) goto L16;
        if (com.heytap.mcssdk.d.a.a(r101, r100.getPackageName(), 4096) == false) goto L14;
        r102.setGroup(d.a.f276382b + r100.getPackageName());
        a(r103, r102);
        return false;
    L14:
        return true;
    }
}
