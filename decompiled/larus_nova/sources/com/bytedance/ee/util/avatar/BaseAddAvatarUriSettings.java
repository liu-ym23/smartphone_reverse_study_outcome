package com.bytedance.ee.util.avatar;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@AppConfig(key = "base_add_avatar_info")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/util/avatar/BaseAddAvatarUriSettings;", "", "<init>", "()V", "cdnHosts", "", "", "getCdnHosts", "()[Ljava/lang/String;", "[Ljava/lang/String;", "avatarPath", "getAvatarPath", "()Ljava/lang/String;", "base-util_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseAddAvatarUriSettings {

    @SerializedName("fs_avatar_path")
    private final String avatarPath;

    @SerializedName("cndHost")
    private final String[] cdnHosts;

    public BaseAddAvatarUriSettings() {
    }

    public final String a() {
        return this.avatarPath;
    }

    public final String[] b() {
        return this.cdnHosts;
    }
}
