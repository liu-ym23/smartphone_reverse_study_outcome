package com.bytedance.ee.bear.bitable.card.model.stmodel.cell;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes15.dex */
public class GroupEntity implements NonProguard, IChatterEntity {
    private String avatarKey;
    private String avatarUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f207127id;
    private String linkToken;
    private String name;

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    @JSONField(deserialize = false, serialize = false)
    public String getDescription() {
        return null;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f207127id});
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public boolean isCurrentUser() {
        return false;
    }

    public String toString() {
        return "GroupEntity{chatterId='" + this.f207127id + "', name='" + this.name + "', avatarUrl='" + this.avatarUrl + "', avatarKey='" + this.avatarKey + "'}";
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getAvatarKey() {
        return this.avatarKey;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getId() {
        return this.f207127id;
    }

    public String getLinkToken() {
        return this.linkToken;
    }

    public String getName() {
        return this.name;
    }

    @JSONField(deserialize = false, serialize = false)
    public IChatterEntity.ChatterSubType getSubType() {
        return IChatterEntity.ChatterSubType.GROUP;
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
        return this.f207127id.equals(((GroupEntity) r100).f207127id);
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getLocalName(String r100) {
        return this.name;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setLinkToken(String r100) {
        this.linkToken = r100;
    }

    @JSONCreator
    public GroupEntity(@JSONField(name = "id") String r100, @JSONField(name = "name") String r101, @JSONField(name = "avatarUrl") String r102, @JSONField(name = "avatarKey") String r103, @JSONField(name = "linkToken") String r104) {
        this.f207127id = r100;
        this.name = r101;
        this.avatarUrl = r102;
        this.avatarKey = r103;
        this.linkToken = r104;
    }
}
