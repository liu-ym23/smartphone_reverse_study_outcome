package com.larus.avatar.impl.scan.model;

import com.larus.platform.service.z2;
import com.larus.uaigc.avatar.api.DigitalAvatarApi;
import com.larus.utils.logger.FLogger;
import ey9.h;
import ey9.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes23.dex */
public final class ScanCameraWerChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f291029a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avatar/impl/scan/model/ScanCameraWerChecker$WerCheckResult;", "", "<init>", "(Ljava/lang/String;I)V", "PASSED", "FAILED", "SKIP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WerCheckResult extends Enum<WerCheckResult> {
        public static final WerCheckResult FAILED = null;
        public static final WerCheckResult PASSED = null;
        public static final WerCheckResult SKIP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WerCheckResult[] f291030a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f291031b = null;

        public static EnumEntries<WerCheckResult> getEntries() {
            return f291031b;
        }

        static {
            WerCheckResult r100 = new WerCheckResult("PASSED", 0);
            PASSED = r100;
            WerCheckResult r101 = new WerCheckResult("FAILED", 1);
            FAILED = r101;
            WerCheckResult r102 = new WerCheckResult("SKIP", 2);
            SKIP = r102;
            WerCheckResult[] r103 = {r100, r101, r102};
            f291030a = r103;
            f291031b = EnumEntriesKt.enumEntries(r103);
        }

        public static WerCheckResult[] values() {
            return (WerCheckResult[]) f291030a.clone();
        }

        public static WerCheckResult valueOf(String r100) {
            return (WerCheckResult) r27.a.a(WerCheckResult.class, r100);
        }

        public WerCheckResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public ScanCameraWerChecker() {
    }

    public final Object a(String r100, Continuation<? super i> r110) {
        if ((r110 instanceof ScanCameraWerChecker$callWerCheckApi$1) == false) goto L7;
        ScanCameraWerChecker$callWerCheckApi$1 r101 = (ScanCameraWerChecker$callWerCheckApi$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L29
    L19:
        dm9.a r112 = (dm9.a) r111;     // Catch: Throwable -> L29
        if ((r112 instanceof dm9.a.b) == true) goto L22;
        FLogger.f375446a.w("ScanCameraWerChecker", "WER check API call failed");     // Catch: Throwable -> L29
        return null;
    L22:
        if (((dm9.a.b) r112).f469231a.isSuccess() == true) goto L24;
    L26:
        FLogger.f375446a.w("ScanCameraWerChecker", "WER check API returned error: code=" + ((dm9.a.b) r112).f469231a.getCode() + ", msg=" + ((dm9.a.b) r112).f469231a.getMsg());     // Catch: Throwable -> L29
        return null;
    L24:
        if (((dm9.a.b) r112).f469231a.getData() == null) goto L26;
        return (i) ((dm9.a.b) r112).f469231a.getData();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        h r113 = new h("data:audio/m4a;base64," + r100);
        DigitalAvatarApi.a r105 = DigitalAvatarApi.f370286a;     // Catch: Throwable -> L29
        ScanCameraWerChecker$callWerCheckApi$response$1 r106 = new ScanCameraWerChecker$callWerCheckApi$response$1(r113, null);     // Catch: Throwable -> L29
        r101.label = 1;     // Catch: Throwable -> L29
        r105.getClass();     // Catch: Throwable -> L29
        r111 = DigitalAvatarApi.a.a("/alice/profile/avatar/reading_text/pre_check", r106, r101);     // Catch: Throwable -> L29
        if (r111 != r103) goto L19;
        return r103;
    L29:
        th = move-exception;
        FLogger.f375446a.e("ScanCameraWerChecker", "WER check API exception: " + th);
        return null;
    L7:
        r101 = new ScanCameraWerChecker$callWerCheckApi$1(this, r110);
        goto L8
    }

    public final Object b(String r100, Continuation<? super WerCheckResult> r110) {
        if ((r110 instanceof ScanCameraWerChecker$checkRecording$1) == false) goto L7;
        ScanCameraWerChecker$checkRecording$1 r101 = (ScanCameraWerChecker$checkRecording$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L19;
        if (r104 == 1) goto L18;
        if (r104 != 2) goto L17;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L14
    L33:
        i r112 = (i) r111;     // Catch: Exception -> L14
        if (r112 != null) goto L36;
    L39:
        FLogger.f375446a.i("ScanCameraWerChecker", "WER check passed");     // Catch: Exception -> L14
        return WerCheckResult.PASSED;
    L36:
        if (Intrinsics.areEqual(r112.a(), Boxing.boxBoolean(true)) == true) goto L39;
        FLogger.f375446a.i("ScanCameraWerChecker", "WER check failed: pass=" + r112.a());     // Catch: Exception -> L14
        return WerCheckResult.FAILED;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
    L26:
        String r113 = (String) r111;
        if (r113 != null) goto L30;
        FLogger.f375446a.e("ScanCameraWerChecker", "Failed to extract audio from video");
        return WerCheckResult.PASSED;
    L30:
        r101.label = 2;     // Catch: Exception -> L14
        r111 = a(r113, r101);     // Catch: Exception -> L14
        if (r111 != r103) goto L33;
        return r103;
    L19:
        ResultKt.throwOnFailure(r111);
        if (z2.f365865a.l1() == true) goto L23;
        FLogger.f375446a.i("ScanCameraWerChecker", "WER check skipped: experiment not enabled");
        return WerCheckResult.SKIP;
    L23:
        r101.label = 1;
        r111 = BuildersKt.withContext(Dispatchers.getIO(), new ScanCameraWerChecker$extractAudioFromVideo$2(r100, null), r101);
        if (r111 != r103) goto L26;
        return r103;
    L14:
        e = move-exception;
        FLogger.f375446a.e("ScanCameraWerChecker", "WER check exception: " + e);
        return WerCheckResult.PASSED;
    L7:
        r101 = new ScanCameraWerChecker$checkRecording$1(this, r110);
        goto L8
    }
}
