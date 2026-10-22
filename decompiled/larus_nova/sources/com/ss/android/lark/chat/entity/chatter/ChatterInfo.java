package com.ss.android.lark.chat.entity.chatter;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ChatterInfo implements Serializable, y28.b<ChatterInfo> {
    private String avatarKey;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415187id;
    private boolean isAnonymous;
    private String name;
    private Chatter.ChatterType type;

    public boolean isItemSame(ChatterInfo r100) {
        return true;
    }

    public ChatterInfo() {
        this.isAnonymous = false;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getId() {
        return this.f415187id;
    }

    public String getName() {
        return this.name;
    }

    public Chatter.ChatterType getType() {
        return this.type;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isContentSame(ChatterInfo r100) {
        if (TextUtils.equals(this.f415187id, r100.f415187id) == true) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.equals(this.name, r100.name) == false) goto L13;
        if (TextUtils.equals(this.avatarKey, r100.avatarKey) == false) goto L13;
        if (this.type != r100.type) goto L13;
        if (this.isAnonymous != r100.isAnonymous) goto L13;
        return true;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((ChatterInfo) r100);
    }

    public void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setId(String r100) {
        this.f415187id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setType(Chatter.ChatterType r100) {
        this.type = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((ChatterInfo) r100);
    }
}
