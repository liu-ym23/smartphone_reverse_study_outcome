package com.bytedance.ee.bear.reminder.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

        public static /* synthetic */ boolean access$000(CreateTaskSwitchBean r100) {
            return r100.value;
        }

        public void setShow(boolean r100) {
            this.show = r100;
        }

        public void setValue(boolean r100) {
            this.value = r100;
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

        public static /* synthetic */ List access$100(DataBean r100) {
            return r100.mentions;
        }

        public static /* synthetic */ boolean access$200(DataBean r100) {
            return r100.isWholeDay;
        }

        public static /* synthetic */ String access$300(DataBean r100) {
            return r100.notifyTime;
        }

        public void setCreateTask(boolean r100) {
            this.isCreateTask = r100;
        }

        public void setExpireTime(long r100) {
            this.expireTime = r100;
        }

        public void setMentions(List<String> r100) {
            this.mentions = r100;
        }

        public void setNotCheckboxEntry(boolean r100) {
            this.notCheckboxEntry = r100;
        }

        public void setNotifyTime(String r100) {
            this.notifyTime = r100;
        }

        public void setReminderBlockId(String r100) {
            this.reminderBlockId = r100;
        }

        public void setWholeDay(boolean r100) {
            this.isWholeDay = r100;
        }
    }

    public ReminderModel() {
    }

    public JSONObject toJSONObject() {
        JSONObject r100 = new JSONObject();
        r100.put2("data", this.data);
        r100.put2("showWholeDaySwitch", Boolean.valueOf(this.showWholeDaySwitch));
        return r100;
    }

    public a toReminderSettings() {
        a r100 = new a();
        r100.f236478d = isShowWholeDaySwitch();
        DataBean r101 = this.data;
        if (r101 != null) goto L5;
        return r100;
    L5:
        r100.f236475a = !r101.isWholeDay();
        r100.f236476b = this.data.getExpireTime() * 1000;
        r100.f236477c = !this.data.isNotCheckboxEntry();
        r100.f236485k = DataBean.access$100(this.data);
        if (DataBean.access$200(this.data) == false) goto L8;
        r100.f236481g = EAlertTimeEvent.valueOf(DataBean.access$300(this.data));
        r100.f236482h = EAlertTimeEvent.atTimeOfEvent;
    L9:
        return r100;
    L8:
        r100.f236482h = EAlertTimeEvent.valueOf(DataBean.access$300(this.data));
        r100.f236481g = EAlertTimeEvent.onDayOfEvent;
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

    public static ReminderModel newInstance(a r100) {
        ReminderModel r101 = new ReminderModel();
        DataBean r102 = new DataBean();
        r102.setExpireTime(r100.f236476b / 1000);
        r102.setWholeDay(!r100.f236475a);
        r102.setNotCheckboxEntry(!r100.f236477c);
        CreateTaskSwitchBean r103 = r100.f236486l;
        if (r103 == null) goto L5;
        r102.setCreateTask(CreateTaskSwitchBean.access$000(r103));
    L7:
        if (r100.f236475a == false) goto L9;
        r102.setNotifyTime(r100.f236482h.name());
    L10:
        r101.setData(r102);
        return r101;
    L9:
        r102.setNotifyTime(r100.f236481g.name());
        goto L10
    L5:
        r102.setCreateTask(false);
        tt5.a.h("ReminderModel", "newInstance getCreateTaskSwitchBean null");
        goto L7
    }

    public void setCreateTaskSwitch(CreateTaskSwitchBean r100) {
        this.createTaskSwitch = r100;
    }

    public void setData(DataBean r100) {
        this.data = r100;
    }

    public void setShowWholeDaySwitch(boolean r100) {
        this.showWholeDaySwitch = r100;
    }
}
