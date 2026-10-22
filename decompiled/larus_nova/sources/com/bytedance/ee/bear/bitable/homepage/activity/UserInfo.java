package com.bytedance.ee.bear.bitable.homepage.activity;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u0004\u0018\u00010\u0005R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/UserInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "avatarKey", "getAvatarKey", "setAvatarKey", "name", "getName", "setName", "enName", "getEnName", "setEnName", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "userType", "", "getUserType", "()Ljava/lang/Long;", "setUserType", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", CommonConstant.KEY_DISPLAY_NAME, "Lcom/bytedance/ee/bear/common/DisplayName;", "getDisplayName", "()Lcom/bytedance/ee/bear/common/DisplayName;", "setDisplayName", "(Lcom/bytedance/ee/bear/common/DisplayName;)V", "getUserName", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserInfo implements NonProguard {
    private String avatarKey;
    private String avatarUrl;

    @JSONField(name = IGoogleService.ResponseKey.DISPLAY_NAME)
    private DisplayName displayName;
    private String enName;
    private String name;

    @JSONField(name = "userID")
    private String userId;
    private Long userType;

    public UserInfo() {
    }

    public final String getUserName() {
        if (TextUtils.equals(Locale.ENGLISH.getLanguage(), ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a()) == false) goto L6;
        return this.enName;
    L6:
        return this.name;
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final DisplayName getDisplayName() {
        return this.displayName;
    }

    public final String getEnName() {
        return this.enName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Long getUserType() {
        return this.userType;
    }

    public final void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public final void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public final void setDisplayName(DisplayName r100) {
        this.displayName = r100;
    }

    public final void setEnName(String r100) {
        this.enName = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }

    public final void setUserType(Long r100) {
        this.userType = r100;
    }
}
