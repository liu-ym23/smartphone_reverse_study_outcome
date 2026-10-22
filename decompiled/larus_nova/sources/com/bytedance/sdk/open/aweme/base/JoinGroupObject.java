package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.tt.b;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class JoinGroupObject {
    private static final String TAG = "JoinGroupObject";

    @SerializedName("app_id")
    public int appId;

    @SerializedName("group_id")
    public String groupId;

    @SerializedName("group_type")
    public int groupType;

    @SerializedName("type")
    public int type;

    @SerializedName("user_open_id")
    public String userOpenId;

    public JoinGroupObject() {
    }

    public static JoinGroupObject unserialize(Bundle r100) {
        String r101 = r100.getString(b.a.f269783g, "");
        if (r101 != null) goto L10;
        return null;
    L10:
        return (JoinGroupObject) new Gson().fromJson(r101, JoinGroupObject.class);
    L7:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{"", e});
        return null;
    }

    public final void serialize(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putSerializable(b.a.f269783g, GsonProtectorUtils.toJson(new Gson(), this));
    }
}
