package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.Metadata;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010$\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010&\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\t¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/ProfileContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", CommonConstant.KEY_DISPLAY_NAME, "getDisplayName", "setDisplayName", "chatterType", "Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "getChatterType", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "setChatterType", "(Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;)V", "avatarKey", "getAvatarKey", "setAvatarKey", "description", "Lcom/ss/android/lark/chat/entity/chatter/ChatterDescription;", "getDescription", "()Lcom/ss/android/lark/chat/entity/chatter/ChatterDescription;", "setDescription", "(Lcom/ss/android/lark/chat/entity/chatter/ChatterDescription;)V", "isProfileEnable", "", "()Z", "setProfileEnable", "(Z)V", "tenantId", "getTenantId", "setTenantId", "isItemSame", "diffable", "isContentSame", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "ProfileContent")
public final class ProfileContent extends Content {
    private String avatarKey;
    private Chatter.ChatterType chatterType;
    private ChatterDescription description;
    private String displayName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415341id;
    private boolean isProfileEnable;
    private String tenantId;

    public ProfileContent() {
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final Chatter.ChatterType getChatterType() {
        return this.chatterType;
    }

    public final ChatterDescription getDescription() {
        return this.description;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.f415341id;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final boolean isProfileEnable() {
        return this.isProfileEnable;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if ((r100 instanceof ProfileContent) == true) goto L5;
        return false;
    L5:
        if (this != r100) goto L8;
        return true;
    L8:
        ProfileContent r101 = (ProfileContent) r100;
        if (y28.a.a(this.f415341id, r101.f415341id) == true) goto L11;
    L17:
        return false;
    L11:
        if (y28.a.a(this.displayName, r101.displayName) == false) goto L17;
        if (y28.a.a(this.avatarKey, r101.avatarKey) == false) goto L17;
        return super.isContentSame(r100);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Content) r100);
    }

    public final void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public final void setChatterType(Chatter.ChatterType r100) {
        this.chatterType = r100;
    }

    public final void setDescription(ChatterDescription r100) {
        this.description = r100;
    }

    public final void setDisplayName(String r100) {
        this.displayName = r100;
    }

    public final void setId(String r100) {
        this.f415341id = r100;
    }

    public final void setProfileEnable(boolean r100) {
        this.isProfileEnable = r100;
    }

    public final void setTenantId(String r100) {
        this.tenantId = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r100) {
        return super.isItemSame(r100);
    }
}
