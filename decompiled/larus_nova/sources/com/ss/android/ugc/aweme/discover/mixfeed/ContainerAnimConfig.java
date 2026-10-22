package com.ss.android.ugc.aweme.discover.mixfeed;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/ContainerAnimConfig;", "Ljava/io/Serializable;", "", "displayTiming", "I", "getDisplayTiming", "()I", "animationType", "getAnimationType", "", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getHasDisplayInCurResult", "()Z", "setHasDisplayInCurResult", "(Z)V", "hasDisplayInCurResult", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class ContainerAnimConfig implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f450474a;

    @SerializedName("animation_type")
    private final int animationType;

    @SerializedName("display_timing")
    private final int displayTiming;

    @SerializedName("extra_info")
    private final Map<String, String> extraInfo;

    public ContainerAnimConfig() {
    }

    public final int getAnimationType() {
        return this.animationType;
    }

    public final int getDisplayTiming() {
        return this.displayTiming;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final boolean getHasDisplayInCurResult() {
        return this.f450474a;
    }

    public final void setHasDisplayInCurResult(boolean r100) {
        this.f450474a = r100;
    }
}
