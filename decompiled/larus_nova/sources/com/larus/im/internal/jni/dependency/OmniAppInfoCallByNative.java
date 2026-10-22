package com.larus.im.internal.jni.dependency;

import android.content.Context;
import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniAppInfoCallByNative;", "", "nativePtr", "", "<init>", "(J)V", "cachedOSVersion", "", "cachedDeviceModel", "initialize", "", "release", "appId", "appName", "appChannel", "updateVersionCode", "debug", "", "inHouse", "autoTestChannel", "deviceId", "userId", "userName", "isTouristMode", "isInMinorMode", "shouldDowngradeMainConversation", "currentTimeMillis", "getAppContext", "Landroid/content/Context;", "osVersion", "deviceModel", "ppeLane", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAppInfoCallByNative {
    private final String cachedDeviceModel;
    private final String cachedOSVersion;
    private final long nativePtr;

    public final void initialize() {
    }

    public final String ppeLane() {
        return "";
    }

    public final void release() {
    }

    public final String appChannel() {
        return com.larus.im.internal.delegate.c.f348197a.channel();
    }

    public final String appId() {
        return String.valueOf(com.larus.im.internal.delegate.c.f348197a.appId());
    }

    public final String appName() {
        return com.larus.im.internal.delegate.c.f348197a.appName();
    }

    public final boolean autoTestChannel() {
        return com.larus.im.internal.delegate.c.f348197a.o();
    }

    public final long currentTimeMillis() {
        return com.larus.im.internal.delegate.c.f348197a.currentTimeMillis();
    }

    public final boolean debug() {
        return com.larus.im.internal.delegate.c.f348197a.isDebug();
    }

    public final String deviceId() {
        return com.larus.im.internal.delegate.c.f348197a.e();
    }

    public final Context getAppContext() {
        return com.larus.im.internal.delegate.c.f348197a.getApplication().getApplicationContext();
    }

    public final boolean inHouse() {
        return com.larus.im.internal.delegate.c.f348197a.isTestChannel();
    }

    public final boolean isInMinorMode() {
        return com.larus.im.internal.delegate.b.f348193b.a();
    }

    public final boolean isTouristMode() {
        return com.larus.im.internal.delegate.b.f348193b.e();
    }

    public final boolean shouldDowngradeMainConversation() {
        return com.larus.im.internal.delegate.c.f348197a.n();
    }

    public final String updateVersionCode() {
        return String.valueOf(com.larus.im.internal.delegate.c.f348197a.f());
    }

    public final String userId() {
        return com.larus.im.internal.delegate.b.f348193b.getUserId();
    }

    public final String userName() {
        return com.larus.im.internal.delegate.b.f348193b.h();
    }

    public final String deviceModel() {
        return this.cachedDeviceModel;
    }

    public final String osVersion() {
        return this.cachedOSVersion;
    }

    public OmniAppInfoCallByNative(long r100) {
        this.nativePtr = r100;
        String r101 = Build.VERSION.RELEASE;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.cachedOSVersion = r101;
        String r103 = Build.MODEL;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        this.cachedDeviceModel = r102;
    }
}
