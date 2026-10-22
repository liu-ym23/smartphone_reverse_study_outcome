package com.ss.android.lark.batterymonitor.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes34.dex */
public final class ConditionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f409777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f409778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f409779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f409780d;

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/batterymonitor/api/ConditionState$AppStateDef;", "", "battery-monitor-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface AppStateDef {
    }

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/batterymonitor/api/ConditionState$ChargeStateDef;", "", "battery-monitor-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ChargeStateDef {
    }

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/batterymonitor/api/ConditionState$NetworkStateDef;", "", "battery-monitor-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface NetworkStateDef {
    }

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/batterymonitor/api/ConditionState$ScreenStateDef;", "", "battery-monitor-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ScreenStateDef {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f409781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f409782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f409783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f409784d;

        public a() {
            this.f409781a = 3;
            this.f409783c = 1;
        }
    }

    public final String toString() {
        return "[appState= " + this.f409777a + ", chargeState= " + this.f409779c + ", networkState= " + this.f409780d + ", screenState= " + this.f409778b + ']';
    }

    public ConditionState(a r100) {
        this.f409777a = r100.f409781a;
        this.f409778b = r100.f409782b;
        this.f409779c = r100.f409783c;
        this.f409780d = r100.f409784d;
    }
}
