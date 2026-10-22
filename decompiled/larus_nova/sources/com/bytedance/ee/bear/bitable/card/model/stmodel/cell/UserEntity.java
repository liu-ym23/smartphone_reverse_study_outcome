package com.bytedance.ee.bear.bitable.card.model.stmodel.cell;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.widgets.tagview.DisplayTagInfoV1;
import com.bytedance.ee.util.io.NonProguard;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.Objects;
import ou5.a;

/* JADX INFO: loaded from: classes15.dex */
public class UserEntity implements NonProguard, IChatterEntity {
    private String avatarUrl;
    private String department;
    private DisplayName displayName;
    private DisplayTagInfoV1 displayTag;
    private String enName;
    private String name;
    private boolean notify;
    private String userId;

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getAvatarKey() {
        return null;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId});
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public boolean isCurrentUser() {
        return TextUtils.equals("__current_user_id__", getId());
    }

    public String toString() {
        return "UserEntity{userId='" + this.userId + "', notify=" + this.notify + "', name='" + this.name + "', enName='" + this.enName + "', avatarUrl='" + this.avatarUrl + "', department='" + this.department + "', displayName='" + this.displayName + "'}";
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getDepartment() {
        return this.department;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    @JSONField(deserialize = false, serialize = false)
    public String getDescription() {
        return this.department;
    }

    public DisplayName getDisplayName() {
        return this.displayName;
    }

    public DisplayTagInfoV1 getDisplayTag() {
        return this.displayTag;
    }

    public String getEnName() {
        return this.enName;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    @JSONField(deserialize = false, serialize = false)
    public String getId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    @JSONField(deserialize = false, serialize = false)
    public IChatterEntity.ChatterSubType getSubType() {
        return IChatterEntity.ChatterSubType.USER;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isNotify() {
        return this.notify;
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
        return this.userId.equals(((UserEntity) r100).userId);
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    @JSONField(deserialize = false, serialize = false)
    public String getLocalName(String r100) {
        if (this.displayName == null) goto L9;
        if (a.e() == false) goto L9;
        return a.a(r100, this.displayName, this.name, this.enName);
    L9:
        return a.b(r100, this.name, this.enName);
    }

    public void setNotify(boolean r100) {
        this.notify = r100;
    }

    public UserEntity(String r100, String r101, String r102, String r103, String r104, DisplayName r105, DisplayTagInfoV1 r106) {
        this.userId = r100;
        this.name = r101;
        this.enName = r102;
        this.avatarUrl = r103;
        this.department = r104;
        this.displayName = r105;
        this.displayTag = r106;
    }

    @JSONCreator
    public UserEntity(@JSONField(name = "userId") String r100, @JSONField(name = "notify") boolean r101, @JSONField(name = "name") String r102, @JSONField(name = "enName") String r103, @JSONField(name = "avatarUrl") String r104, @JSONField(name = "department") String r105, @JSONField(name = CommonConstant.KEY_DISPLAY_NAME) DisplayName r106) {
        this.userId = r100;
        this.notify = r101;
        this.name = r102;
        this.enName = r103;
        this.avatarUrl = r104;
        this.department = r105;
        this.displayName = r106;
    }
}
