package com.ss.android.ugc.route_monitor.impl.route_in.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/route_in/config/SingleConfigCondition;", "", "launchMode", "", "coldBoot", "", "referrer", "firstLaunchComponentName", "bizLaunchMode", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizLaunchMode", "()Ljava/lang/String;", "getColdBoot", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFirstLaunchComponentName", "getLaunchMode", "getReferrer", "toString", "route-monitor_release"}, k = 1, mv = {1, 1, 16})
public final class SingleConfigCondition {
    private final String bizLaunchMode;
    private final Boolean coldBoot;
    private final String firstLaunchComponentName;
    private final String launchMode;
    private final String referrer;

    public String toString() {
        return "{launchMode = " + this.launchMode + ", coldBoot = " + this.coldBoot + ", referrer = " + this.referrer + ", firstLaunchComponentName = " + this.firstLaunchComponentName + ", bizLaunchMode = " + this.bizLaunchMode + '}';
    }

    public final String getBizLaunchMode() {
        return this.bizLaunchMode;
    }

    public final Boolean getColdBoot() {
        return this.coldBoot;
    }

    public final String getFirstLaunchComponentName() {
        return this.firstLaunchComponentName;
    }

    public final String getLaunchMode() {
        return this.launchMode;
    }

    public final String getReferrer() {
        return this.referrer;
    }

    public SingleConfigCondition(String r100, Boolean r101, String r102, String r103, String r104) {
        this.launchMode = r100;
        this.coldBoot = r101;
        this.referrer = r102;
        this.firstLaunchComponentName = r103;
        this.bizLaunchMode = r104;
    }
}
