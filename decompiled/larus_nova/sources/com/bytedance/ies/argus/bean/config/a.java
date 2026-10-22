package com.bytedance.ies.argus.bean.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/a;", "", "", "createTimeStamp", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "", "createTime", "Ljava/lang/String;", "getCreateTime", "()Ljava/lang/String;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f246017b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f246018a;

    @SerializedName("create_time")
    private final String createTime;

    @SerializedName("create_time_stamp")
    private final Long createTimeStamp;

    /* JADX INFO: renamed from: com.bytedance.ies.argus.bean.config.a$a, reason: collision with other inner class name */
    public static final class C3514a {
    }

    static {
    }

    public a() {
    }

    public final Long a() {
        return this.createTimeStamp;
    }
}
