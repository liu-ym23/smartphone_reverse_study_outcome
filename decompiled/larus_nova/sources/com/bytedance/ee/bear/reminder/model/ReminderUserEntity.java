package com.bytedance.ee.bear.reminder.model;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class ReminderUserEntity implements NonProguard {
    private String avatarUrl;
    private DisplayName displayName;
    private String enName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f236474id;
    private String name;

    public int hashCode() {
        return Objects.hash(new Object[]{this.f236474id});
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
        return this.f236474id;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return this.f236474id.equals(((ReminderUserEntity) r100).f236474id);
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setDisplayName(DisplayName r100) {
        this.displayName = r100;
    }

    public void setEnName(String r100) {
        this.enName = r100;
    }

    public void setId(String r100) {
        this.f236474id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public ReminderUserEntity(String r100, String r101, String r102, String r103) {
        this.f236474id = r100;
        this.name = r101;
        this.enName = r102;
        this.avatarUrl = r103;
    }
}
