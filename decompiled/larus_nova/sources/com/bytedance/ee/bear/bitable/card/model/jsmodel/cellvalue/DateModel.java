package com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue;

import com.bytedance.ee.bear.bitable.card.model.enums.EReminderNotifyStrategy;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public class DateModel implements NonProguard {
    private Reminder reminder;
    private Long value;

    public static class Reminder implements NonProguard {
        private ReminderNotifyEntity notifyEntities;
        private int notifyStrategy;
        private Long notifyTime;

        public Reminder() {
        }

        public String toString() {
            return "Reminder{notifyEntities=" + this.notifyEntities + ", notifyTime=" + this.notifyTime + ", notifyStrategy=" + this.notifyStrategy + '}';
        }

        public ReminderNotifyEntity getNotifyEntities() {
            return this.notifyEntities;
        }

        public int getNotifyStrategy() {
            return this.notifyStrategy;
        }

        public Long getNotifyTime() {
            return this.notifyTime;
        }

        public EReminderNotifyStrategy getEReminderNotifyStrategy(int r100) {
            return EReminderNotifyStrategy.valueOf(r100);
        }

        public void setNotifyEntities(ReminderNotifyEntity r100) {
            this.notifyEntities = r100;
        }

        public void setNotifyStrategy(int r100) {
            this.notifyStrategy = r100;
        }

        public void setNotifyTime(Long r100) {
            this.notifyTime = r100;
        }
    }

    public static class ReminderNotifyEntity implements NonProguard {
        private String[] fields;
        private ReminderUserEntity[] users;

        public ReminderNotifyEntity() {
        }

        public String toString() {
            return "ReminderNotifyEntity{fields=" + Arrays.toString(this.fields) + ", users=" + Arrays.toString(this.users) + '}';
        }

        public String[] getFields() {
            return this.fields;
        }

        public ReminderUserEntity[] getUsers() {
            return this.users;
        }

        public void setFields(String[] r100) {
            this.fields = r100;
        }

        public void setUsers(ReminderUserEntity[] r100) {
            this.users = r100;
        }
    }

    public static class ReminderUserEntity implements NonProguard {
        private String avatarUrl;
        private String enName;
        private String name;
        private String userId;

        public ReminderUserEntity() {
        }

        public String toString() {
            return "ReminderUser{userId='" + this.userId + "', name='" + this.name + "', enName='" + this.enName + "', avatarUrl='" + this.avatarUrl + "'}";
        }

        public String getAvatarUrl() {
            return this.avatarUrl;
        }

        public String getEnName() {
            return this.enName;
        }

        public String getName() {
            return this.name;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setAvatarUrl(String r100) {
            this.avatarUrl = r100;
        }

        public void setEnName(String r100) {
            this.enName = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setUserId(String r100) {
            this.userId = r100;
        }
    }

    public boolean isReminderEnabled() {
        if (this.reminder == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "DateModel{value=" + this.value + ", reminder=" + this.reminder + '}';
    }

    public DateModel() {
    }

    public Reminder getReminder() {
        return this.reminder;
    }

    public Long getValue() {
        return this.value;
    }

    public void setReminder(Reminder r100) {
        this.reminder = r100;
    }

    public void setValue(Long r100) {
        this.value = r100;
    }

    public DateModel(Long r100, Reminder r101) {
        this.value = r100;
        this.reminder = r101;
    }
}
