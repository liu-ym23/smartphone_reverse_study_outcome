package com.ss.android.lark.officesdk.api.init;

import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "onInitReady", "", "officeSDKRuntime", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKRuntime;", "officeSDKGlobalApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKGlobalApi;", "onUserComponentReady", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "onLoginSuccess", "onLogoutSuccess", "userId", "", "onLoadReady", "bizType", "Lcom/ss/android/lark/officesdk/api/init/OfficeBizType;", "onLoadFailed", "onWarmupReady", "onWarmupFailed", "reason", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSDKLifeCycle extends IOfficeSDKProtocol {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onLoadFailed(IOfficeSDKLifeCycle r100, OfficeBizType r101) {
            Intrinsics.checkNotNullParameter(r101, "bizType");
        }

        public static void onLoadReady(IOfficeSDKLifeCycle r100, OfficeBizType r101) {
            Intrinsics.checkNotNullParameter(r101, "bizType");
        }

        public static void onLoginSuccess(IOfficeSDKLifeCycle r100, OfficeSDKUserApi r101) {
            Intrinsics.checkNotNullParameter(r101, "officeSDKUserApi");
        }

        public static void onLogoutSuccess(IOfficeSDKLifeCycle r100, String r101) {
        }

        public static void onUserComponentReady(IOfficeSDKLifeCycle r100, OfficeSDKUserApi r101) {
            Intrinsics.checkNotNullParameter(r101, "officeSDKUserApi");
        }

        public static void onWarmupFailed(IOfficeSDKLifeCycle r100, OfficeBizType r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "bizType");
        }

        public static void onWarmupReady(IOfficeSDKLifeCycle r100, OfficeBizType r101) {
            Intrinsics.checkNotNullParameter(r101, "bizType");
        }

        public static /* synthetic */ void onLogoutSuccess$default(IOfficeSDKLifeCycle r100, String r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.onLogoutSuccess(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLogoutSuccess");
        }

        public static /* synthetic */ void onWarmupFailed$default(IOfficeSDKLifeCycle r100, OfficeBizType r101, String r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.onWarmupFailed(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onWarmupFailed");
        }
    }

    void onInitReady(IOfficeSDKRuntime r100, OfficeSDKGlobalApi r101);

    void onLoadFailed(OfficeBizType r100);

    void onLoadReady(OfficeBizType r100);

    void onLoginSuccess(OfficeSDKUserApi r100);

    void onLogoutSuccess(String r100);

    void onUserComponentReady(OfficeSDKUserApi r100);

    void onWarmupFailed(OfficeBizType r100, String r101);

    void onWarmupReady(OfficeBizType r100);
}
