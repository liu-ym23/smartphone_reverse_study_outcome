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

/* JADX INFO: loaded from: classes18.dex */
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

        public static /* synthetic */ int access$000(SheetReminderData r100) {
            return r100.notifyStrategy;
        }

        public static /* synthetic */ boolean access$100(SheetReminderData r100) {
            return r100.isSetTime;
        }

        public static /* synthetic */ long access$200(SheetReminderData r100) {
            return r100.expireTime;
        }

        public static /* synthetic */ String access$300(SheetReminderData r100) {
            return r100.notifyText;
        }

        public static /* synthetic */ List access$400(SheetReminderData r100) {
            return r100.notifyUsers;
        }

        public void setExpireTime(long r100) {
            this.expireTime = r100;
        }

        public void setNotifyStrategy(int r100) {
            this.notifyStrategy = r100;
        }

        public void setNotifyText(String r100) {
            this.notifyText = r100;
        }

        public void setNotifyUsers(List<ReminderUserEntity> r100) {
            this.notifyUsers = r100;
        }

        public void setSetTime(boolean r100) {
            this.isSetTime = r100;
        }

        public void setSheetId(String r100) {
            this.sheetId = r100;
        }
    }

    public SheetReminderModel() {
    }

    static {
        HashMap r100 = new HashMap();
        notifyStrategyMap = r100;
        r100.put(EAlertTimeEvent.noAlert, -1);
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
        c r100 = new c();
        SheetReminderData r101 = this.data;
        if (r101 != null) goto L5;
        return r100;
    L5:
        r100.f236475a = SheetReminderData.access$100(r101);
        r100.f236476b = (SheetReminderData.access$200(this.data) / 1000) * 1000;
        r100.f236477c = true;
        r100.f236478d = true;
        r100.f236484j = SheetReminderData.access$300(this.data);
        r100.f236483i = SheetReminderData.access$400(this.data);
        if (SheetReminderData.access$100(this.data) == false) goto L8;
        r100.f236482h = getEAlertTimeEventById(SheetReminderData.access$000(this.data));
        r100.f236481g = EAlertTimeEvent.onDayOfEvent;
    L9:
        return r100;
    L8:
        r100.f236481g = getEAlertTimeEventById(SheetReminderData.access$000(this.data));
        r100.f236482h = EAlertTimeEvent.atTimeOfEvent;
        goto L9
    }

    public String toString() {
        return "SheetReminderModel{data=" + this.data + '}';
    }

    public SheetReminderData getData() {
        return this.data;
    }

    private static EAlertTimeEvent getEAlertTimeEventById(int r100) {
        Iterator<Map.Entry<EAlertTimeEvent, Integer>> r101 = notifyStrategyMap.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<EAlertTimeEvent, Integer> r102 = r101.next();
        if (r102.getValue().intValue() != r100) goto L4;
        return r102.getKey();
    L10:
        return EAlertTimeEvent.noAlert;
    }

    private static int getNotifyStrategyByEvent(EAlertTimeEvent r100) {
        Integer r101 = notifyStrategyMap.get(r100);
        if (r101 != null) goto L6;
        return -1;
    L6:
        return r101.intValue();
    }

    public static SheetReminderData newInstance(c r100) {
        SheetReminderData r101 = new SheetReminderData();
        r101.setExpireTime(r100.f236476b);
        r101.setSetTime(r100.f236475a);
        if (r100.f236475a == false) goto L5;
        r101.setNotifyStrategy(getNotifyStrategyByEvent(r100.f236482h));
    L7:
        if (SheetReminderData.access$000(r101) != getNotifyStrategyByEvent(EAlertTimeEvent.noAlert)) goto L9;
        r101.setNotifyUsers(null);
        r101.setNotifyText(null);
    L10:
        return r101;
    L9:
        r101.setNotifyUsers(r100.f236483i);
        r101.setNotifyText(r100.f236484j);
        goto L10
    L5:
        r101.setNotifyStrategy(getNotifyStrategyByEvent(r100.f236481g));
        goto L7
    }

    public void setData(SheetReminderData r100) {
        this.data = r100;
    }
}
