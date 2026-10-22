package com.bytedance.ug.sdk.luckycat.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/settings/c;", "", "", "path", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "dependencies", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setDependencies", "(Ljava/util/List;)V", "", "startTimeStamp", "J", "d", "()J", "setStartTimeStamp", "(J)V", "endTimeStamp", "b", "setEndTimeStamp", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("dependencies")
    private List<String> dependencies;

    @SerializedName("end_ts")
    private long endTimeStamp;

    @SerializedName("path")
    private String path;

    @SerializedName("start_ts")
    private long startTimeStamp;

    public c() {
    }

    public final List<String> a() {
        return this.dependencies;
    }

    public final long b() {
        return this.endTimeStamp;
    }

    public final String c() {
        return this.path;
    }

    public final long d() {
        return this.startTimeStamp;
    }
}
