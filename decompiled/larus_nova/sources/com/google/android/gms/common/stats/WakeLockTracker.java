package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class WakeLockTracker {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final WakeLockTracker f274602zza = null;

    static {
        f274602zza = new WakeLockTracker();
    }

    public WakeLockTracker() {
    }

    public static WakeLockTracker getInstance() {
        return f274602zza;
    }

    public void registerAcquireEvent(Context r100, Intent r101, String r102, String r103, String r104, int r105, String r106) {
    }

    public void registerDeadlineEvent(Context r100, String r101, String r102, String r103, int r104, List<String> r105, boolean r106, long r107) {
    }

    public void registerEvent(Context r100, String r101, int r102, String r103, String r104, String r105, int r106, List<String> r107) {
    }

    public void registerEvent(Context r100, String r101, int r102, String r103, String r104, String r105, int r106, List<String> r107, long r108) {
    }

    public void registerReleaseEvent(Context r100, Intent r101) {
    }
}
