package com.bytedance.ee.bear.sheet.reminder;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.reminder.model.EAlertTimeEvent;
import com.bytedance.ee.bear.reminder.model.ReminderUserEntity;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import fn5.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetReminderModel implements NonProguard {
    private static Map<EAlertTimeEvent, Integer> notifyStrategyMap;
    private SheetReminderData data;

    public static class SheetReminderData implements NonProguard {
        private long expireTime;

        @JSONField(name = "isSetTime")
        private boolean isSetTime;
        private int notifyStrategy;
        private String notifyText;
        private List<ReminderUserEntity> notifyUsers;
        private String sheetId;

        public String toString() {
            return "DataBean{expireTime=" + this.expireTime + ", notifyStrategy=" + this.notifyStrategy + ", notifyUsers=" + this.notifyUsers + ", notifyText='" + b.g(this.notifyText) + "', isSetTime=" + this.isSetTime + ", sheetId='" + b.g(this.sheetId) + "'}";
        }

        public SheetReminderData() {
            this.notifyStrategy = -1;
        }

        public long getExpireTime() {
            return this.expireTime;
        }

        public int getNotifyStrategy() {
            return this.notifyStrategy;
        }

        public String getNotifyText() {
            return this.notifyText;
        }

        public List<ReminderUserEntity> getNotifyUsers() {
            return this.notifyUsers;
        }

        public String getSheetId() {
            return this.sheetId;
        }

        public boolean isSetTime() {
            return this.isSetTime;
        }

        public static /* synthetic */ int access$000(SheetReminderData r0) {
            return r0.notifyStrategy;
        }

        public static /* synthetic */ boolean access$100(SheetReminderData r0) {
            return r0.isSetTime;
        }

        public static /* synthetic */ long access$200(SheetReminderData r2) {
            return r2.expireTime;
        }

        public static /* synthetic */ String access$300(SheetReminderData r0) {
            return r0.notifyText;
        }

        public static /* synthetic */ List access$400(SheetReminderData r0) {
            return r0.notifyUsers;
        }

        public void setExpireTime(long r1) {
            this.expireTime = r1;
        }

        public void setNotifyStrategy(int r1) {
            this.notifyStrategy = r1;
        }

        public void setNotifyText(String r1) {
            this.notifyText = r1;
        }

        public void setNotifyUsers(List<ReminderUserEntity> r1) {
            this.notifyUsers = r1;
        }

        public void setSetTime(boolean r1) {
            this.isSetTime = r1;
        }

        public void setSheetId(String r1) {
            this.sheetId = r1;
        }
    }

    public SheetReminderModel() {
    }

    static {
        HashMap r0 = new HashMap();
        notifyStrategyMap = r0;
        r0.put(EAlertTimeEvent.noAlert, -1);
        notifyStrategyMap.put(EAlertTimeEvent.atTimeOfEvent, 0);
        notifyStrategyMap.put(EAlertTimeEvent.before5Mins, 1);
        notifyStrategyMap.put(EAlertTimeEvent.before15Mins, 2);
        notifyStrategyMap.put(EAlertTimeEvent.before30Mins, 3);
        notifyStrategyMap.put(EAlertTimeEvent.before1Hour, 4);
        notifyStrategyMap.put(EAlertTimeEvent.before2Hours, 5);
        notifyStrategyMap.put(EAlertTimeEvent.onDayOfEvent, 6);
        notifyStrategyMap.put(EAlertTimeEvent.oneDayBefore, 7);
        notifyStrategyMap.put(EAlertTimeEvent.twoDaysBefore, 8);
        notifyStrategyMap.put(EAlertTimeEvent.oneWeekBefore, 9);
        notifyStrategyMap.put(EAlertTimeEvent.before1Day, 10);
        notifyStrategyMap.put(EAlertTimeEvent.before2Days, 11);
        notifyStrategyMap.put(EAlertTimeEvent.before1Week, 12);
    }

    public c toSheetReminderSettings() {
        c r0 = new c();
        SheetReminderData r1 = this.data;
        if (r1 != null) goto L5;
        return r0;
    L5:
        r0.a = SheetReminderData.access$100(r1);
        r0.b = (SheetReminderData.access$200(this.data) / 1000) * 1000;
        r0.c = true;
        r0.d = true;
        r0.j = SheetReminderData.access$300(this.data);
        r0.i = SheetReminderData.access$400(this.data);
        if (SheetReminderData.access$100(this.data) == false) goto L8;
        r0.h = getEAlertTimeEventById(SheetReminderData.access$000(this.data));
        r0.g = EAlertTimeEvent.onDayOfEvent;
    L9:
        return r0;
    L8:
        r0.g = getEAlertTimeEventById(SheetReminderData.access$000(this.data));
        r0.h = EAlertTimeEvent.atTimeOfEvent;
        goto L9
    }

    public String toString() {
        return "SheetReminderModel{data=" + this.data + '}';
    }

    public SheetReminderData getData() {
        return this.data;
    }

    private static EAlertTimeEvent getEAlertTimeEventById(int r3) {
        Iterator<Map.Entry<EAlertTimeEvent, Integer>> r0 = notifyStrategyMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<EAlertTimeEvent, Integer> r1 = r0.next();
        if (r1.getValue().intValue() != r3) goto L4;
        return r1.getKey();
    L10:
        return EAlertTimeEvent.noAlert;
    }

    private static int getNotifyStrategyByEvent(EAlertTimeEvent r1) {
        Integer r2 = notifyStrategyMap.get(r1);
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.intValue();
    }

    public static SheetReminderData newInstance(c r3) {
        SheetReminderData r0 = new SheetReminderData();
        r0.setExpireTime(r3.b);
        r0.setSetTime(r3.a);
        if (r3.a == false) goto L5;
        r0.setNotifyStrategy(getNotifyStrategyByEvent(r3.h));
    L7:
        if (SheetReminderData.access$000(r0) != getNotifyStrategyByEvent(EAlertTimeEvent.noAlert)) goto L9;
        r0.setNotifyUsers(null);
        r0.setNotifyText(null);
    L10:
        return r0;
    L9:
        r0.setNotifyUsers(r3.i);
        r0.setNotifyText(r3.j);
        goto L10
    L5:
        r0.setNotifyStrategy(getNotifyStrategyByEvent(r3.g));
        goto L7
    }

    public void setData(SheetReminderData r1) {
        this.data = r1;
    }
}
