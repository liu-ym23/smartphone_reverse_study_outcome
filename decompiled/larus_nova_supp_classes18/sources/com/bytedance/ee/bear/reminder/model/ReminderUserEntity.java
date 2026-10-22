package com.bytedance.ee.bear.reminder.model;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReminderUserEntity implements NonProguard {
    private String avatarUrl;
    private DisplayName displayName;
    private String enName;
    private String id;
    private String name;

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public String toString() {
        return "ReminderUserEntity{, name='" + b.g(this.name) + "', enName='" + b.g(this.enName) + "', avatarUrl='" + b.g(this.avatarUrl) + "'}";
    }

    public ReminderUserEntity() {
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public DisplayName getDisplayName() {
        return this.displayName;
    }

    public String getEnName() {
        return this.enName;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return this.id.equals(((ReminderUserEntity) r3).id);
    }

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setDisplayName(DisplayName r1) {
        this.displayName = r1;
    }

    public void setEnName(String r1) {
        this.enName = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public ReminderUserEntity(String r1, String r2, String r3, String r4) {
        this.id = r1;
        this.name = r2;
        this.enName = r3;
        this.avatarUrl = r4;
    }
}
