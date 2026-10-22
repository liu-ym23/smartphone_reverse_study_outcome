package com.bytedance.privacy.attestation;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import k67.b;
import k67.c;

/* JADX INFO: loaded from: classes6.dex */
public class IdAttestationManager {
    private static final long CACHE_ENTRY_LIFETIME_MS = 0;
    public static final String TAG = null;
    private static final Map<String, a> attestationCacheMap = null;
    private static volatile IdAttestationManager idAttestationManager;

    /* JADX INFO: loaded from: classes21.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f266681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f266682b;

        public final boolean a() {
            b.a(IdAttestationManager.TAG, "isExpired current:" + SystemClock.elapsedRealtime() + ",elapsedRealtimeMs:" + this.f266682b);
            if ((SystemClock.elapsedRealtime() - this.f266682b) < IdAttestationManager.access$000()) goto L5;
            return true;
        L5:
            return false;
        }

        public a(String r100) {
            this.f266681a = r100;
            this.f266682b = SystemClock.elapsedRealtime();
        }
    }

    public IdAttestationManager() {
    }

    static {
        TAG = "IdAttestationManager";
        attestationCacheMap = new ConcurrentHashMap();
        CACHE_ENTRY_LIFETIME_MS = TimeUnit.DAYS.toMillis(1);
    }

    private Bundle buildKeyBundle() {
        Bundle r100 = new Bundle();
        j67.a.b().o();
        j67.a.b().keyAlgorithmEcc();
        r100.putInt("key_algorithm", 2);
        j67.a.b().i();
        r100.putInt("key_length", 256);
        j67.a.b().u();
        j67.a.b().purposeAttestKey();
        r100.putInt("key_purpose", 64);
        return r100;
    }

    public static IdAttestationManager getInstance() {
        if (idAttestationManager != null) goto L15;
        monitor-enter(IdAttestationManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (idAttestationManager != null) goto L9;
        idAttestationManager = new IdAttestationManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IdAttestationManager.class);     // Catch: Throwable -> L11
    L15:
        return idAttestationManager;
    }

    private String getUDID() {
        String r100 = AccountApi.INSTANCE.getUDID();
        if (r100.length() == 64) goto L6;
        b.c(TAG, "Invalid UDID length: " + r100.length());
        return "";
    L6:
        return r100;
    }

    public static /* synthetic */ long access$000() {
        return CACHE_ENTRY_LIFETIME_MS;
    }

    private Bundle buildAttestBundle(Context r100, String r101, AttestationConfig r102) throws BdPrivacyException {
        Bundle r103 = new Bundle();
        j67.a.b().g();
        r103.putString("attest_appid", r101);
    L37:
        e = move-exception;
        throw new BdPrivacyException("PseudoManager not initialized", -13, e);
    L4:
        if (r102.isIdRequested(AttestationConfig.IdType.RPDID) == false) goto L13;
        String r104 = PrivacySdk.getPseudoManager().getPseudoDID(r100, r101);     // Catch: IllegalStateException -> L37
        if (r104 == null) goto L11;
        if (r104.isEmpty() == true) goto L11;
        j67.a.b().c();     // Catch: IllegalStateException -> L37
        r103.putString("attest_rpdid", r104);     // Catch: IllegalStateException -> L37
    L11:
        throw new BdPrivacyException("Get RPDID failed", -10);     // Catch: IllegalStateException -> L37
    L13:
        if (r102.isIdRequested(AttestationConfig.IdType.RPUID) == false) goto L22;
        String r105 = PrivacySdk.getPseudoManager().getPseudoUID(r100, r101);     // Catch: IllegalStateException -> L37
        if (r105 == null) goto L20;
        if (r105.isEmpty() == true) goto L20;
        j67.a.b().a();     // Catch: IllegalStateException -> L37
        r103.putString("attest_rpuid", r105);     // Catch: IllegalStateException -> L37
    L20:
        throw new BdPrivacyException("Get RPUID failed", -11);     // Catch: IllegalStateException -> L37
    L22:
        if (r102.isIdRequested(AttestationConfig.IdType.UDID) == false) goto L31;
        String r106 = getUDID();     // Catch: IllegalStateException -> L37
        if (r106.isEmpty() == true) goto L29;
        j67.a.b().j();     // Catch: IllegalStateException -> L37
        r103.putString("attest_udid", r106);     // Catch: IllegalStateException -> L37
        goto L31
    L29:
        throw new BdPrivacyException("Get UDID failed", -12);     // Catch: IllegalStateException -> L37
    L31:
        if (r102.isDevHealthStatusRequired() == false) goto L34;
        j67.a.b().q();     // Catch: IllegalStateException -> L37
        r103.putBoolean("device_health_status_required", true);     // Catch: IllegalStateException -> L37
    L34:
        if (r102.getCustomInfo() == null) goto L36;
        j67.a.b().d();
        r103.putString("attest_custom_info", r102.getCustomInfo());
    L36:
        return r103;
    }

    private String getIDAttestation(Context r110, String r111, String r112, AttestationConfig r113) throws BdPrivacyException {
        validateInput(r110, r111, r112, r113);
        String r114 = TAG;
        b.e(r114, "Entering cache check...");
        Map<String, a> r115 = attestationCacheMap;
        a r100 = r115.get(r112);
        if (r100 != null) goto L5;
    L8:
        if (r100 != null) goto L10;
        b.e(r114, "Attestation cache miss for keyAlias: " + r112);
    L11:
        b.e(r114, "Exiting cache check, moving to network flow");
        String r116 = r112.intern();
        monitor-enter(r116);
        a r101 = r115.get(r112);     // Catch: Throwable -> L40
        if (r101 != null) goto L16;
    L20:
        b.a(r114, r113.toString());     // Catch: Throwable -> L40
        Bundle r102 = buildAttestBundle(r110, r111, r113);     // Catch: Throwable -> L31
        Bundle r103 = buildKeyBundle();     // Catch: Throwable -> L31
        String r104 = AccountApi.INSTANCE.getDeviceId();     // Catch: Throwable -> L31
        if (r104.isEmpty() == true) goto L39;
        d67.a.d().getClass();     // Catch: Throwable -> L31
        d67.a.a(r110, r112);     // Catch: Throwable -> L31
        d67.a.d().getClass();     // Catch: Throwable -> L31
        List r105 = d67.a.c(r110, r111, r104, r112, r103, r102);     // Catch: Throwable -> L31
        if (r105.isEmpty() == true) goto L37;
        String r106 = k67.a.a(r105, 3);     // Catch: Throwable -> L31 Exception -> L33
        r115.put(r112, new a(r106));     // Catch: Throwable -> L31
        b.e(r114, "Successfully gen attestation and stored in cache for keyAlias: ".concat(r112));     // Catch: Throwable -> L31
        d67.a.d().getClass();     // Catch: Throwable -> L31
        d67.a.a(r110, r112);     // Catch: Throwable -> L31
        monitor-exit(r116);     // Catch: Throwable -> L31
        return r106;
    L33:
        e = move-exception;
        b.b(TAG, "certsToPemString unexpected error: " + e.getMessage());     // Catch: Throwable -> L31
        throw new BdPrivacyException(e.getMessage(), -100, e);     // Catch: Throwable -> L31
    L37:
        throw new BdPrivacyException("Get id attest cert chain failed", -9);     // Catch: Throwable -> L31
    L39:
        throw new BdPrivacyException("Get device id failed", -4);     // Catch: Throwable -> L31
    L16:
        if (r101.a() == true) goto L20;
        b.e(r114, "Cache hit after wait for keyAlias: ".concat(r112));     // Catch: Throwable -> L40
        String r107 = r101.f266681a;     // Catch: Throwable -> L40
        monitor-exit(r116);     // Catch: Throwable -> L40
        return r107;
    L31:
        th = th;
    L42:
        monitor-exit(r116);     // Catch: Throwable -> L31
        throw th;
    L40:
        th = th;
        goto L42
    L10:
        b.e(r114, "Attestation cache expired for keyAlias: " + r112);
        goto L11
    L5:
        if (r100.a() == true) goto L8;
        b.e(r114, "Cache hit, returning cert chain for keyAlias: " + r112);
        return r100.f266681a;
    }

    private void validateInput(Context r100, String r101, String r102, AttestationConfig r103) throws BdPrivacyException {
        c.b(PerfLog.PARAM_KEY_CONTEXT_ID, r100);
        c.b("config", r103);
        c.a("appId", r101, 128);
        j67.a.b().s();
        c.a("keyAlias", r102, 128);
    }

    public String getIDAttestationString(Context r110, String r111, String r112, AttestationConfig r113) throws BdPrivacyException {
        if (r110 == null) goto L5;
        String r100 = r110.getPackageName();
    L6:
        long r101 = SystemClock.elapsedRealtime();
        String r114 = getIDAttestation(r110, r111, r112, r113);     // Catch: Throwable -> L17 BdPrivacyException -> L19
        long r102 = SystemClock.elapsedRealtime() - r101;
        if (r111 == null) goto L11;
        String r103 = r111;
    L12:
        if (r113 != null) goto L15;
        r113 = new AttestationConfig.Builder().build();
    L15:
        com.bytedance.privacy.attestation.a.a(0, r100, r103, r102, r113);
        return r114;
    L11:
        r103 = "";
        goto L12
    L17:
        th = move-exception;
        long r104 = SystemClock.elapsedRealtime() - r101;
        if (r111 == null) goto L25;
        String r105 = r111;
    L26:
        if (r113 != null) goto L29;
        r113 = new AttestationConfig.Builder().build();
    L29:
        com.bytedance.privacy.attestation.a.a(0, r100, r105, r104, r113);
        throw th;
    L25:
        r105 = "";
    L19:
        e = move-exception;
        e.getErrorCode();     // Catch: Throwable -> L17
        b.c(TAG, "getIDAttestationString failed: " + e.getMessage());     // Catch: Throwable -> L17
        throw e;     // Catch: Throwable -> L17
    L5:
        r100 = "";
        goto L6
    }
}
