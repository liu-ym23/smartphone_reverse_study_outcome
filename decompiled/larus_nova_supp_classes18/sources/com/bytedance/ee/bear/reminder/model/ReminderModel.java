package com.bytedance.ee.bear.reminder.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReminderModel implements NonProguard {
    private CreateTaskSwitchBean createTaskSwitch;
    private DataBean data;
    private boolean showWholeDaySwitch;

    public static class CreateTaskSwitchBean implements NonProguard {
        private boolean show;
        private boolean value;

        public CreateTaskSwitchBean() {
        }

        public String toString() {
            return "CreateTaskSwitchBean{show=" + this.show + ", value=" + this.value + '}';
        }

        public boolean isShow() {
            return this.show;
        }

        public boolean isValue() {
            return this.value;
        }

        public static /* synthetic */ boolean access$000(CreateTaskSwitchBean r0) {
            return r0.value;
        }

        public void setShow(boolean r1) {
            this.show = r1;
        }

        public void setValue(boolean r1) {
            this.value = r1;
        }
    }

    public static class DataBean implements NonProguard {
        private long expireTime;

        @JSONField(name = "isCreateTask")
        private boolean isCreateTask;

        @JSONField(name = "isWholeDay")
        private boolean isWholeDay;
        private List<String> mentions;
        private boolean notCheckboxEntry;
        private String notifyTime;
        private String reminderBlockId;

        public DataBean() {
        }

        public String toString() {
            return "DataBean{reminderBlockId='" + this.reminderBlockId + "', isWholeDay=" + this.isWholeDay + ", expireTime=" + this.expireTime + ", notCheckboxEntry=" + this.notCheckboxEntry + ", notifyTime='" + this.notifyTime + "', mentions='" + this.mentions + "', isCreateTask='" + this.isCreateTask + "'}";
        }

        public long getExpireTime() {
            return this.expireTime;
        }

        public List<String> getMentions() {
            return this.mentions;
        }

        public String getNotifyTime() {
            return this.notifyTime;
        }

        public String getReminderBlockId() {
            return this.reminderBlockId;
        }

        public boolean isCreateTask() {
            return this.isCreateTask;
        }

        public boolean isNotCheckboxEntry() {
            return this.notCheckboxEntry;
        }

        public boolean isWholeDay() {
            return this.isWholeDay;
        }

        public static /* synthetic */ List access$100(DataBean r0) {
            return r0.mentions;
        }

        public static /* synthetic */ boolean access$200(DataBean r0) {
            return r0.isWholeDay;
        }

        public static /* synthetic */ String access$300(DataBean r0) {
            return r0.notifyTime;
        }

        public void setCreateTask(boolean r1) {
            this.isCreateTask = r1;
        }

        public void setExpireTime(long r1) {
            this.expireTime = r1;
        }

        public void setMentions(List<String> r1) {
            this.mentions = r1;
        }

        public void setNotCheckboxEntry(boolean r1) {
            this.notCheckboxEntry = r1;
        }

        public void setNotifyTime(String r1) {
            this.notifyTime = r1;
        }

        public void setReminderBlockId(String r1) {
            this.reminderBlockId = r1;
        }

        public void setWholeDay(boolean r1) {
            this.isWholeDay = r1;
        }
    }

    public ReminderModel() {
    }

    public JSONObject toJSONObject() {
        JSONObject r0 = new JSONObject();
        r0.put(WikiFolderPushPlugin.DATA, this.data);
        r0.put("showWholeDaySwitch", Boolean.valueOf(this.showWholeDaySwitch));
        return r0;
    }

    public a toReminderSettings() {
        a r0 = new a();
        r0.d = isShowWholeDaySwitch();
        DataBean r1 = this.data;
        if (r1 != null) goto L5;
        return r0;
    L5:
        r0.a = !r1.isWholeDay();
        r0.b = this.data.getExpireTime() * 1000;
        r0.c = !this.data.isNotCheckboxEntry();
        r0.k = DataBean.access$100(this.data);
        if (DataBean.access$200(this.data) == false) goto L8;
        r0.g = EAlertTimeEvent.valueOf(DataBean.access$300(this.data));
        r0.h = EAlertTimeEvent.atTimeOfEvent;
    L9:
        return r0;
    L8:
        r0.h = EAlertTimeEvent.valueOf(DataBean.access$300(this.data));
        r0.g = EAlertTimeEvent.onDayOfEvent;
        goto L9
    }

    public String toString() {
        return "ReminderModel{data=" + this.data + ", showWholeDaySwitch=" + this.showWholeDaySwitch + '}';
    }

    public CreateTaskSwitchBean getCreateTaskSwitch() {
        return this.createTaskSwitch;
    }

    public DataBean getData() {
        return this.data;
    }

    public boolean isShowWholeDaySwitch() {
        return this.showWholeDaySwitch;
    }

    public static ReminderModel newInstance(a r6) {
        ReminderModel r0 = new ReminderModel();
        DataBean r1 = new DataBean();
        r1.setExpireTime(r6.b / 1000);
        r1.setWholeDay(!r6.a);
        r1.setNotCheckboxEntry(!r6.c);
        CreateTaskSwitchBean r2 = r6.l;
        if (r2 == null) goto L5;
        r1.setCreateTask(CreateTaskSwitchBean.access$000(r2));
    L7:
        if (r6.a == false) goto L9;
        r1.setNotifyTime(r6.h.name());
    L10:
        r0.setData(r1);
        return r0;
    L9:
        r1.setNotifyTime(r6.g.name());
        goto L10
    L5:
        r1.setCreateTask(false);
        tt5.a.h("ReminderModel", "newInstance getCreateTaskSwitchBean null");
        goto L7
    }

    public void setCreateTaskSwitch(CreateTaskSwitchBean r1) {
        this.createTaskSwitch = r1;
    }

    public void setData(DataBean r1) {
        this.data = r1;
    }

    public void setShowWholeDaySwitch(boolean r1) {
        this.showWholeDaySwitch = r1;
    }
}
