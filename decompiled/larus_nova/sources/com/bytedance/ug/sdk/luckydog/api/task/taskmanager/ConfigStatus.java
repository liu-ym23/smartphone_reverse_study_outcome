package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/task/taskmanager/ConfigStatus;", "", "", "status", "I", "getStatus", "()I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "NotReady", "ReadyAndOpen", "ReadyButClose", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum ConfigStatus extends Enum<ConfigStatus> {
    public static final ConfigStatus NotReady = null;
    public static final ConfigStatus ReadyAndOpen = null;
    public static final ConfigStatus ReadyButClose = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConfigStatus[] f271685a = null;
    private final String desc;
    private final int status;

    static {
        ConfigStatus r100 = new ConfigStatus("NotReady", 0, -1, "not ready");
        NotReady = r100;
        ConfigStatus r101 = new ConfigStatus("ReadyAndOpen", 1, 1, "ready and open");
        ReadyAndOpen = r101;
        ConfigStatus r102 = new ConfigStatus("ReadyButClose", 2, 0, "ready but close");
        ReadyButClose = r102;
        f271685a = new ConfigStatus[]{r100, r101, r102};
    }

    public static ConfigStatus valueOf(String r100) {
        return (ConfigStatus) r27.a.a(ConfigStatus.class, r100);
    }

    public static ConfigStatus[] values() {
        return (ConfigStatus[]) f271685a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getStatus() {
        return this.status;
    }

    public ConfigStatus(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.status = r102;
        this.desc = r103;
    }
}
