package com.bytedance.ee.bear.lark.todoblock.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TaskAssigneeData implements NonProguard {
    private boolean editable;
    private String[] userIds;

    public TaskAssigneeData() {
    }

    public String toString() {
        return "TaskAssigneeBean{userIds=" + Arrays.toString(this.userIds) + ", editable=" + this.editable + '}';
    }

    public String[] getUserIds() {
        return this.userIds;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public void setEditable(boolean r1) {
        this.editable = r1;
    }

    public void setUserIds(String[] r1) {
        this.userIds = r1;
    }
}
