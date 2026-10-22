package com.ss.android.lark.officesdk.api.init;

import android.content.Context;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.ss.android.lark.officesdk.api.IOfficeSDKHostSessionProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bF\b\u0086\b\u0018\u00002\u00020\u0001:\u0004fghiBÃ\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003J\t\u0010T\u001a\u00020\u0010HÆ\u0003J\t\u0010U\u001a\u00020\u0012HÆ\u0003J\t\u0010V\u001a\u00020\u0014HÆ\u0003J\t\u0010W\u001a\u00020\u0016HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010\\\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010$HÆ\u0003Jð\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\u00072\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u000bHÖ\u0001J\t\u0010e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010+R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010K¨\u0006j"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "appName", "", "isDebug", "", "appId", "hostAppVersion", "env", "", "ttEnv", "journalPaths", "", "officeSDKLifeCycle", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "tokenProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "deviceInfoProvider", "Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "languageProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;", "hostAppHeaderProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "bizConfigProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;", "requestTagBase", "enableNewTtnetLogReporter", "initStage", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;", "appBuildConfig", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "hostSessionProvider", "Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;", "userServiceInjector", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;", "<init>", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;)V", "getContext", "()Landroid/content/Context;", "getAppName", "()Ljava/lang/String;", "()Z", "getAppId", "getHostAppVersion", "getEnv", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTtEnv", "getJournalPaths", "()Ljava/util/List;", "getOfficeSDKLifeCycle", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "getTokenProvider", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "getDeviceInfoProvider", "()Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "getLanguageProvider", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;", "getHostAppHeaderProvider", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "getBizConfigProvider", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;", "getRequestTagBase", "getEnableNewTtnetLogReporter", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getInitStage", "()Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;", "getAppBuildConfig", "()Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "getHostSessionProvider", "()Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;", "getUserServiceInjector", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;)Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig;", "equals", "other", "hashCode", "toString", "Builder", "RuntimeType", "InitStageConfig", "AppBuildConfig", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKInitConfig {
    private final AppBuildConfig appBuildConfig;
    private final String appId;
    private final String appName;
    private final IOfficeSDKBizConfigProvider bizConfigProvider;
    private final Context context;
    private final IDeviceInfoProvider deviceInfoProvider;
    private final Boolean enableNewTtnetLogReporter;
    private final Integer env;
    private final IOfficeSDKHostAppHeaderProvider hostAppHeaderProvider;
    private final String hostAppVersion;
    private final IOfficeSDKHostSessionProvider hostSessionProvider;
    private final InitStageConfig initStage;
    private final boolean isDebug;
    private final List<String> journalPaths;
    private final IOfficeSdkLanguageProvider languageProvider;
    private final IOfficeSDKLifeCycle officeSDKLifeCycle;
    private final String requestTagBase;
    private final IOfficeSDKTokenProvider tokenProvider;
    private final String ttEnv;
    private final IOfficeSDKUserServiceInjector userServiceInjector;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "", "isDebug", "", "buildChannel", "", "isTestChannel", "<init>", "(ZLjava/lang/String;Z)V", "()Z", "getBuildChannel", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppBuildConfig {
        private final String buildChannel;
        private final boolean isDebug;
        private final boolean isTestChannel;

        public static /* synthetic */ AppBuildConfig copy$default(AppBuildConfig r100, boolean r101, String r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.isDebug;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.buildChannel;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.isTestChannel;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final boolean component1() {
            return this.isDebug;
        }

        public final String component2() {
            return this.buildChannel;
        }

        public final boolean component3() {
            return this.isTestChannel;
        }

        public final AppBuildConfig copy(boolean r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "buildChannel");
            return new AppBuildConfig(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AppBuildConfig) == true) goto L8;
            return false;
        L8:
            AppBuildConfig r101 = (AppBuildConfig) r100;
            if (this.isDebug == r101.isDebug) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.buildChannel, r101.buildChannel) == true) goto L15;
            return false;
        L15:
            if (this.isTestChannel == r101.isTestChannel) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = 1231;
            if (this.isDebug == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = ((r101 * 31) + this.buildChannel.hashCode()) * 31;
            if (this.isTestChannel == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            return "AppBuildConfig(isDebug=" + this.isDebug + ", buildChannel=" + this.buildChannel + ", isTestChannel=" + this.isTestChannel + ')';
        }

        public final String getBuildChannel() {
            return this.buildChannel;
        }

        public final boolean isDebug() {
            return this.isDebug;
        }

        public final boolean isTestChannel() {
            return this.isTestChannel;
        }

        public AppBuildConfig(boolean r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "buildChannel");
            this.isDebug = r100;
            this.buildChannel = r101;
            this.isTestChannel = r102;
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007J\u0015\u0010.\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u0014\u00101\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0013J\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u00106\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u001bJ\u000e\u00108\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u00109\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010:\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u0015\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010?\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010@\u001a\u00020\u00002\u0006\u00107\u001a\u00020&J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020(J\u0006\u0010C\u001a\u00020DR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$Builder;", "", "<init>", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "appName", "", "isDebug", "", "appId", "hostAppVersion", "env", "", "Ljava/lang/Integer;", "ttEnv", "journalPaths", "", "officeSDKLifeCycle", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "tokenProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "deviceInfoProvider", "Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "languageProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;", "hostAppHeaderProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "bizConfigProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;", "requestTagBase", "enableNewTtnetLogReporter", "Ljava/lang/Boolean;", "initStage", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;", "appBuildConfig", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "hostSessionProvider", "Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;", "userServiceInjector", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;", "setContext", "setAppName", "setDebug", "setAppId", "setHostAppVersion", "setEnv", "(Ljava/lang/Integer;)Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$Builder;", "setTTEnv", "setJournalPaths", "setLifeCycle", "lifeCycle", "setTokenProvider", "setDeviceInfoProvider", "setHostAppHeaderProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "setLanguageProvider", "setBizConfigProvider", "setRequestTagBase", "setEnableNewTtnetLogReporter", "enable", "(Ljava/lang/Boolean;)Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$Builder;", "setInitStage", "setAppBuildConfig", "setHostSessionProvider", "setUserServiceInjector", "injector", "build", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private AppBuildConfig appBuildConfig;
        private String appId;
        private String appName;
        private IOfficeSDKBizConfigProvider bizConfigProvider;
        private Context context;
        private IDeviceInfoProvider deviceInfoProvider;
        private Boolean enableNewTtnetLogReporter;
        private Integer env;
        private IOfficeSDKHostAppHeaderProvider hostAppHeaderProvider;
        private String hostAppVersion;
        private IOfficeSDKHostSessionProvider hostSessionProvider;
        private InitStageConfig initStage;
        private boolean isDebug;
        private List<String> journalPaths;
        private IOfficeSdkLanguageProvider languageProvider;
        private IOfficeSDKLifeCycle officeSDKLifeCycle;
        private String requestTagBase;
        private IOfficeSDKTokenProvider tokenProvider;
        private String ttEnv;
        private IOfficeSDKUserServiceInjector userServiceInjector;

        public final OfficeSDKInitConfig build() {
            boolean r100 = true;
            if (this.appName.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L43;
            if (this.appId.length() <= 0) goto L10;
            boolean r102 = true;
        L11:
            if (r102 == false) goto L41;
            if (this.hostAppVersion.length() > 0) goto L16;
            r100 = false;
        L16:
            if (r100 == false) goto L39;
            if (this.officeSDKLifeCycle == null) goto L37;
            if (this.tokenProvider == null) goto L35;
            if (this.deviceInfoProvider == null) goto L33;
            Context r103 = this.context;
            if (r103 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
            r103 = null;
        L26:
            Context r104 = r103;
            String r105 = this.appName;
            boolean r106 = this.isDebug;
            String r107 = this.appId;
            String r108 = this.hostAppVersion;
            Integer r109 = this.env;
            String r110 = this.ttEnv;
            List<String> r111 = this.journalPaths;
            IOfficeSDKLifeCycle r112 = this.officeSDKLifeCycle;
            Intrinsics.checkNotNull(r112);
            IOfficeSDKTokenProvider r113 = this.tokenProvider;
            Intrinsics.checkNotNull(r113);
            IDeviceInfoProvider r114 = this.deviceInfoProvider;
            Intrinsics.checkNotNull(r114);
            IOfficeSdkLanguageProvider r115 = this.languageProvider;
            if (r115 == null) goto L31;
            return new OfficeSDKInitConfig(r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, this.hostAppHeaderProvider, this.bizConfigProvider, this.requestTagBase, this.enableNewTtnetLogReporter, this.initStage, this.appBuildConfig, this.hostSessionProvider, this.userServiceInjector, null);
        L31:
            throw new IllegalArgumentException("Required value was null.".toString());
        L33:
            throw new IllegalArgumentException("DeviceInfoProvider required".toString());
        L35:
            throw new IllegalArgumentException("TokenProvider required".toString());
        L37:
            throw new IllegalArgumentException("LifeCycle required".toString());
        L39:
            throw new IllegalArgumentException("HostAppVersion required".toString());
        L41:
            throw new IllegalArgumentException("AppId required".toString());
        L10:
            r102 = false;
            goto L11
        L43:
            throw new IllegalArgumentException("AppName required".toString());
        L5:
            r101 = false;
            goto L6
        }

        public Builder() {
            this.appName = "";
            this.appId = "";
            this.hostAppVersion = "";
            this.journalPaths = CollectionsKt.emptyList();
        }

        public final Builder setAppBuildConfig(AppBuildConfig r100) {
            this.appBuildConfig = r100;
            return this;
        }

        public final Builder setAppId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            this.appId = r100;
            return this;
        }

        public final Builder setAppName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appName");
            this.appName = r100;
            return this;
        }

        public final Builder setBizConfigProvider(IOfficeSDKBizConfigProvider r100) {
            Intrinsics.checkNotNullParameter(r100, "bizConfigProvider");
            this.bizConfigProvider = r100;
            return this;
        }

        public final Builder setContext(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
            return this;
        }

        public final Builder setDebug(boolean r100) {
            this.isDebug = r100;
            return this;
        }

        public final Builder setDeviceInfoProvider(IDeviceInfoProvider r100) {
            Intrinsics.checkNotNullParameter(r100, "deviceInfoProvider");
            this.deviceInfoProvider = r100;
            return this;
        }

        public final Builder setEnableNewTtnetLogReporter(Boolean r100) {
            this.enableNewTtnetLogReporter = r100;
            return this;
        }

        public final Builder setEnv(Integer r100) {
            this.env = r100;
            return this;
        }

        public final Builder setHostAppHeaderProvider(IOfficeSDKHostAppHeaderProvider r100) {
            this.hostAppHeaderProvider = r100;
            return this;
        }

        public final Builder setHostAppVersion(String r100) {
            Intrinsics.checkNotNullParameter(r100, "hostAppVersion");
            this.hostAppVersion = r100;
            return this;
        }

        public final Builder setHostSessionProvider(IOfficeSDKHostSessionProvider r100) {
            Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.hostSessionProvider = r100;
            return this;
        }

        public final Builder setInitStage(InitStageConfig r100) {
            this.initStage = r100;
            return this;
        }

        public final Builder setJournalPaths(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "journalPaths");
            this.journalPaths = r100;
            return this;
        }

        public final Builder setLanguageProvider(IOfficeSdkLanguageProvider r100) {
            Intrinsics.checkNotNullParameter(r100, "languageProvider");
            this.languageProvider = r100;
            return this;
        }

        public final Builder setLifeCycle(IOfficeSDKLifeCycle r100) {
            Intrinsics.checkNotNullParameter(r100, "lifeCycle");
            this.officeSDKLifeCycle = r100;
            return this;
        }

        public final Builder setRequestTagBase(String r100) {
            this.requestTagBase = r100;
            return this;
        }

        public final Builder setTTEnv(String r100) {
            this.ttEnv = r100;
            return this;
        }

        public final Builder setTokenProvider(IOfficeSDKTokenProvider r100) {
            Intrinsics.checkNotNullParameter(r100, "tokenProvider");
            this.tokenProvider = r100;
            return this;
        }

        public final Builder setUserServiceInjector(IOfficeSDKUserServiceInjector r100) {
            Intrinsics.checkNotNullParameter(r100, "injector");
            this.userServiceInjector = r100;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;", "", "runtimeType", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;", "<init>", "(Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;)V", "getRuntimeType", "()Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InitStageConfig {
        private final RuntimeType runtimeType;

        public static /* synthetic */ InitStageConfig copy$default(InitStageConfig r100, RuntimeType r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.runtimeType;
        L6:
            return r100.copy(r101);
        }

        public final RuntimeType component1() {
            return this.runtimeType;
        }

        public final InitStageConfig copy(RuntimeType r100) {
            return new InitStageConfig(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof InitStageConfig) == true) goto L9;
            return false;
        L9:
            if (this.runtimeType == ((InitStageConfig) r100).runtimeType) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            RuntimeType r100 = this.runtimeType;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "InitStageConfig(runtimeType=" + this.runtimeType + ')';
        }

        public final RuntimeType getRuntimeType() {
            return this.runtimeType;
        }

        public InitStageConfig(RuntimeType r100) {
            this.runtimeType = r100;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;", "", "<init>", "(Ljava/lang/String;I)V", BridgeSyncType.ASYNC, BridgeSyncType.SYNC, "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RuntimeType extends Enum<RuntimeType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ RuntimeType[] $VALUES = null;
        public static final RuntimeType ASYNC = null;
        public static final RuntimeType SYNC = null;

        private static final /* synthetic */ RuntimeType[] $values() {
            return new RuntimeType[]{ASYNC, SYNC};
        }

        public static EnumEntries<RuntimeType> getEntries() {
            return $ENTRIES;
        }

        static {
            ASYNC = new RuntimeType(BridgeSyncType.ASYNC, 0);
            SYNC = new RuntimeType(BridgeSyncType.SYNC, 1);
            RuntimeType[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static RuntimeType[] values() {
            return (RuntimeType[]) $VALUES.clone();
        }

        public static RuntimeType valueOf(String r100) {
            return (RuntimeType) a.a(RuntimeType.class, r100);
        }

        private RuntimeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ OfficeSDKInitConfig(Context r100, String r101, boolean r102, String r103, String r104, Integer r105, String r106, List r107, IOfficeSDKLifeCycle r108, IOfficeSDKTokenProvider r110, IDeviceInfoProvider r111, IOfficeSdkLanguageProvider r112, IOfficeSDKHostAppHeaderProvider r113, IOfficeSDKBizConfigProvider r114, String r115, Boolean r116, InitStageConfig r117, AppBuildConfig r118, IOfficeSDKHostSessionProvider r119, IOfficeSDKUserServiceInjector r210, DefaultConstructorMarker r211) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSDKInitConfig copy$default(OfficeSDKInitConfig r110, Context r111, String r112, boolean r210, String r211, String r212, Integer r213, String r214, List r215, IOfficeSDKLifeCycle r216, IOfficeSDKTokenProvider r217, IDeviceInfoProvider r218, IOfficeSdkLanguageProvider r219, IOfficeSDKHostAppHeaderProvider r310, IOfficeSDKBizConfigProvider r311, String r312, Boolean r313, InitStageConfig r314, AppBuildConfig r315, IOfficeSDKHostSessionProvider r316, IOfficeSDKUserServiceInjector r317, int r318, Object r319) {
        if ((r318 & 1) == 0) goto L5;
        Context r100 = r110.context;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = r110.appName;
    L11:
        if ((r318 & 4) == 0) goto L13;
        boolean r102 = r110.isDebug;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = r110.appId;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = r110.hostAppVersion;
    L23:
        if ((r318 & 32) == 0) goto L25;
        Integer r105 = r110.env;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = r110.ttEnv;
    L31:
        if ((r318 & 128) == 0) goto L33;
        List r107 = r110.journalPaths;
    L35:
        if ((r318 & 256) == 0) goto L37;
        IOfficeSDKLifeCycle r113 = r110.officeSDKLifeCycle;
    L39:
        if ((r318 & 512) == 0) goto L41;
        IOfficeSDKTokenProvider r114 = r110.tokenProvider;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        IDeviceInfoProvider r115 = r110.deviceInfoProvider;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        IOfficeSdkLanguageProvider r116 = r110.languageProvider;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        IOfficeSDKHostAppHeaderProvider r117 = r110.hostAppHeaderProvider;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        IOfficeSDKBizConfigProvider r118 = r110.bizConfigProvider;
    L58:
        IOfficeSDKBizConfigProvider r320 = r118;
        if ((r318 & 16384) == 0) goto L61;
        String r119 = r110.requestTagBase;
    L62:
        String r321 = r119;
        if ((r318 & 32768) == 0) goto L65;
        Boolean r120 = r110.enableNewTtnetLogReporter;
    L66:
        Boolean r322 = r120;
        if ((r318 & 65536) == 0) goto L69;
        InitStageConfig r121 = r110.initStage;
    L70:
        InitStageConfig r323 = r121;
        if ((r318 & 131072) == 0) goto L73;
        AppBuildConfig r122 = r110.appBuildConfig;
    L74:
        AppBuildConfig r324 = r122;
        if ((r318 & 262144) == 0) goto L77;
        IOfficeSDKHostSessionProvider r123 = r110.hostSessionProvider;
    L79:
        if ((r318 & 524288) == 0) goto L81;
        IOfficeSDKUserServiceInjector r108 = r110.userServiceInjector;
    L83:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r123, r108);
    L81:
        r108 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Context component1() {
        return this.context;
    }

    public final IOfficeSDKTokenProvider component10() {
        return this.tokenProvider;
    }

    public final IDeviceInfoProvider component11() {
        return this.deviceInfoProvider;
    }

    public final IOfficeSdkLanguageProvider component12() {
        return this.languageProvider;
    }

    public final IOfficeSDKHostAppHeaderProvider component13() {
        return this.hostAppHeaderProvider;
    }

    public final IOfficeSDKBizConfigProvider component14() {
        return this.bizConfigProvider;
    }

    public final String component15() {
        return this.requestTagBase;
    }

    public final Boolean component16() {
        return this.enableNewTtnetLogReporter;
    }

    public final InitStageConfig component17() {
        return this.initStage;
    }

    public final AppBuildConfig component18() {
        return this.appBuildConfig;
    }

    public final IOfficeSDKHostSessionProvider component19() {
        return this.hostSessionProvider;
    }

    public final String component2() {
        return this.appName;
    }

    public final IOfficeSDKUserServiceInjector component20() {
        return this.userServiceInjector;
    }

    public final boolean component3() {
        return this.isDebug;
    }

    public final String component4() {
        return this.appId;
    }

    public final String component5() {
        return this.hostAppVersion;
    }

    public final Integer component6() {
        return this.env;
    }

    public final String component7() {
        return this.ttEnv;
    }

    public final List<String> component8() {
        return this.journalPaths;
    }

    public final IOfficeSDKLifeCycle component9() {
        return this.officeSDKLifeCycle;
    }

    public final OfficeSDKInitConfig copy(Context r210, String r211, boolean r212, String r213, String r214, Integer r215, String r310, List<String> r311, IOfficeSDKLifeCycle r312, IOfficeSDKTokenProvider r313, IDeviceInfoProvider r314, IOfficeSdkLanguageProvider r315, IOfficeSDKHostAppHeaderProvider r316, IOfficeSDKBizConfigProvider r317, String r318, Boolean r319, InitStageConfig r410, AppBuildConfig r411, IOfficeSDKHostSessionProvider r412, IOfficeSDKUserServiceInjector r413) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "appName");
        Intrinsics.checkNotNullParameter(r213, "appId");
        Intrinsics.checkNotNullParameter(r214, "hostAppVersion");
        Intrinsics.checkNotNullParameter(r311, "journalPaths");
        Intrinsics.checkNotNullParameter(r312, "officeSDKLifeCycle");
        Intrinsics.checkNotNullParameter(r313, "tokenProvider");
        Intrinsics.checkNotNullParameter(r314, "deviceInfoProvider");
        Intrinsics.checkNotNullParameter(r315, "languageProvider");
        return new OfficeSDKInitConfig(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSDKInitConfig) == true) goto L8;
        return false;
    L8:
        OfficeSDKInitConfig r101 = (OfficeSDKInitConfig) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L15;
        return false;
    L15:
        if (this.isDebug == r101.isDebug) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hostAppVersion, r101.hostAppVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.env, r101.env) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ttEnv, r101.ttEnv) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.journalPaths, r101.journalPaths) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.officeSDKLifeCycle, r101.officeSDKLifeCycle) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tokenProvider, r101.tokenProvider) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.deviceInfoProvider, r101.deviceInfoProvider) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.languageProvider, r101.languageProvider) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.hostAppHeaderProvider, r101.hostAppHeaderProvider) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.bizConfigProvider, r101.bizConfigProvider) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.requestTagBase, r101.requestTagBase) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.enableNewTtnetLogReporter, r101.enableNewTtnetLogReporter) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.initStage, r101.initStage) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.appBuildConfig, r101.appBuildConfig) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.hostSessionProvider, r101.hostSessionProvider) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.userServiceInjector, r101.userServiceInjector) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.context.hashCode() * 31) + this.appName.hashCode()) * 31;
        if (this.isDebug == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((((r100 + r101) * 31) + this.appId.hashCode()) * 31) + this.hostAppVersion.hashCode()) * 31;
        Integer r103 = this.env;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.ttEnv;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((((((((r106 + r108) * 31) + this.journalPaths.hashCode()) * 31) + this.officeSDKLifeCycle.hashCode()) * 31) + this.tokenProvider.hashCode()) * 31) + this.deviceInfoProvider.hashCode()) * 31) + this.languageProvider.hashCode()) * 31;
        IOfficeSDKHostAppHeaderProvider r110 = this.hostAppHeaderProvider;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        IOfficeSDKBizConfigProvider r113 = this.bizConfigProvider;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.requestTagBase;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.enableNewTtnetLogReporter;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        InitStageConfig r122 = this.initStage;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        AppBuildConfig r125 = this.appBuildConfig;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        IOfficeSDKHostSessionProvider r128 = this.hostSessionProvider;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        IOfficeSDKUserServiceInjector r131 = this.userServiceInjector;
        if (r131 == null) goto L47;
        r104 = r131.hashCode();
    L47:
        return r130 + r104;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OfficeSDKInitConfig(context=" + this.context + ", appName=" + this.appName + ", isDebug=" + this.isDebug + ", appId=" + this.appId + ", hostAppVersion=" + this.hostAppVersion + ", env=" + this.env + ", ttEnv=" + this.ttEnv + ", journalPaths=" + this.journalPaths + ", officeSDKLifeCycle=" + this.officeSDKLifeCycle + ", tokenProvider=" + this.tokenProvider + ", deviceInfoProvider=" + this.deviceInfoProvider + ", languageProvider=" + this.languageProvider + ", hostAppHeaderProvider=" + this.hostAppHeaderProvider + ", bizConfigProvider=" + this.bizConfigProvider + ", requestTagBase=" + this.requestTagBase + ", enableNewTtnetLogReporter=" + this.enableNewTtnetLogReporter + ", initStage=" + this.initStage + ", appBuildConfig=" + this.appBuildConfig + ", hostSessionProvider=" + this.hostSessionProvider + ", userServiceInjector=" + this.userServiceInjector + ')';
    }

    public final AppBuildConfig getAppBuildConfig() {
        return this.appBuildConfig;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final IOfficeSDKBizConfigProvider getBizConfigProvider() {
        return this.bizConfigProvider;
    }

    public final Context getContext() {
        return this.context;
    }

    public final IDeviceInfoProvider getDeviceInfoProvider() {
        return this.deviceInfoProvider;
    }

    public final Boolean getEnableNewTtnetLogReporter() {
        return this.enableNewTtnetLogReporter;
    }

    public final Integer getEnv() {
        return this.env;
    }

    public final IOfficeSDKHostAppHeaderProvider getHostAppHeaderProvider() {
        return this.hostAppHeaderProvider;
    }

    public final String getHostAppVersion() {
        return this.hostAppVersion;
    }

    public final IOfficeSDKHostSessionProvider getHostSessionProvider() {
        return this.hostSessionProvider;
    }

    public final InitStageConfig getInitStage() {
        return this.initStage;
    }

    public final List<String> getJournalPaths() {
        return this.journalPaths;
    }

    public final IOfficeSdkLanguageProvider getLanguageProvider() {
        return this.languageProvider;
    }

    public final IOfficeSDKLifeCycle getOfficeSDKLifeCycle() {
        return this.officeSDKLifeCycle;
    }

    public final String getRequestTagBase() {
        return this.requestTagBase;
    }

    public final IOfficeSDKTokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    public final String getTtEnv() {
        return this.ttEnv;
    }

    public final IOfficeSDKUserServiceInjector getUserServiceInjector() {
        return this.userServiceInjector;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    private OfficeSDKInitConfig(Context r100, String r101, boolean r102, String r103, String r104, Integer r105, String r106, List<String> r110, IOfficeSDKLifeCycle r111, IOfficeSDKTokenProvider r112, IDeviceInfoProvider r113, IOfficeSdkLanguageProvider r114, IOfficeSDKHostAppHeaderProvider r115, IOfficeSDKBizConfigProvider r116, String r117, Boolean r118, InitStageConfig r119, AppBuildConfig r210, IOfficeSDKHostSessionProvider r211, IOfficeSDKUserServiceInjector r212) {
        this.context = r100;
        this.appName = r101;
        this.isDebug = r102;
        this.appId = r103;
        this.hostAppVersion = r104;
        this.env = r105;
        this.ttEnv = r106;
        this.journalPaths = r110;
        this.officeSDKLifeCycle = r111;
        this.tokenProvider = r112;
        this.deviceInfoProvider = r113;
        this.languageProvider = r114;
        this.hostAppHeaderProvider = r115;
        this.bizConfigProvider = r116;
        this.requestTagBase = r117;
        this.enableNewTtnetLogReporter = r118;
        this.initStage = r119;
        this.appBuildConfig = r210;
        this.hostSessionProvider = r211;
        this.userServiceInjector = r212;
    }
}
