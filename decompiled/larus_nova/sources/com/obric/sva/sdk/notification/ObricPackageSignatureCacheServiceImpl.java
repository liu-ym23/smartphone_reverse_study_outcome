package com.obric.sva.sdk.notification;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.obric.assistant.IObricPackageSignatureCacheService;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/obric/sva/sdk/notification/ObricPackageSignatureCacheServiceImpl;", "Lcom/obric/assistant/IObricPackageSignatureCacheService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "getOrCompute", "", "pkgName", "refresh", "remove", "", "keyOf", "isPrivacyAgreed", "", "getAppSignatureSha256", "sha256Hex", "data", "", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPackageSignatureCacheServiceImpl implements IObricPackageSignatureCacheService {
    public static final Companion Companion = null;
    private static final String KEY_PREFIX = "pkg_sig_sha256_";
    private static final String REPO_NAME = "obric_pkg_sig_cache";
    private final Lazy keva$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/sva/sdk/notification/ObricPackageSignatureCacheServiceImpl$Companion;", "", "<init>", "()V", "REPO_NAME", "", "KEY_PREFIX", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Keva a() {
        return keva_delegate$lambda$0();
    }

    public static /* synthetic */ CharSequence b(byte r100) {
        return sha256Hex$lambda$6(r100);
    }

    private final Keva getKeva() {
        return (Keva) this.keva$delegate.getValue();
    }

    private final boolean isPrivacyAgreed() {
        if (AppHost.f326268a.isOversea() == true) goto L14;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r100 = ISecPrivacyService.a.a();
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r100.h() != true) goto L9;
        r101 = true;
        goto L10
    L14:
        return true;
    }

    private static final Keva keva_delegate$lambda$0() {
        return Keva.getRepo(REPO_NAME, 1);
    }

    public ObricPackageSignatureCacheServiceImpl() {
        this.keva$delegate = LazyKt.lazy(new b());
    }

    private final String getAppSignatureSha256(String r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L25
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L25
        if (r103 < 28) goto L6;
        PackageInfo r104 = AppHost.f326268a.getApplication().getPackageManager().getPackageInfo(r100, AMapEngineUtils.HALF_MAX_P20_WIDTH);     // Catch: Throwable -> L25
    L8:
        if (r103 < 28) goto L14;
        SigningInfo r105 = r104.signingInfo;     // Catch: Throwable -> L25
        if (r105 == null) goto L13;
        Signature[] r106 = r105.getApkContentsSigners();     // Catch: Throwable -> L25
        if (r106 == null) goto L13;
    L17:
        Signature r107 = (Signature) ArraysKt.firstOrNull(r106);     // Catch: Throwable -> L25
        if (r107 == null) goto L22;
        byte[] r108 = r107.toByteArray();     // Catch: Throwable -> L25
        if (r108 == null) goto L22;
        String r109 = sha256Hex(r108);     // Catch: Throwable -> L25
    L23:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r110) == true) goto L32;
        r101 = r110;
    L32:
        return (String) r101;
    L22:
        r109 = null;
    L13:
        r106 = new Signature[0];     // Catch: Throwable -> L25
        goto L17
    L14:
        r106 = r104.signatures;     // Catch: Throwable -> L25
        if (r106 != null) goto L17;
        r106 = new Signature[0];     // Catch: Throwable -> L25
        goto L17
    L6:
        r104 = AppHost.f326268a.getApplication().getPackageManager().getPackageInfo(r100, 64);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    private final String keyOf(String r100) {
        return KEY_PREFIX + r100;
    }

    private final String sha256Hex(byte[] r110) {
        return ArraysKt.joinToString$default(MessageDigest.getInstance("SHA-256").digest(r110), "", null, null, 0, null, new a(), 30, null);
    }

    private static final CharSequence sha256Hex$lambda$6(byte r100) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r100 & UByte.MAX_VALUE)}, 1));
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public String getOrCompute(String r100) {
        String r101 = null;
        if (isPrivacyAgreed() == true) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
    L19:
        return null;
    L7:
        if ((!StringsKt.isBlank(r100)) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L19;
        String r102 = getKeva().getString(keyOf(r100), "");
        Intrinsics.checkNotNull(r102);
        if ((!StringsKt.isBlank(r102)) == false) goto L15;
        r101 = r102;
    L15:
        if (r101 == null) goto L18;
        return r101;
    L18:
        return refresh(r100);
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public String refresh(String r100) {
        if (isPrivacyAgreed() == true) goto L5;
        return null;
    L5:
        if (r100 == null) goto L23;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r100)) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L23;
        String r102 = getAppSignatureSha256(r100);
        if (r102 != null) goto L15;
    L18:
        if (r101 == false) goto L21;
        getKeva().erase(keyOf(r100));
        return null;
    L21:
        getKeva().storeString(keyOf(r100), r102);
        return r102;
    L15:
        if (StringsKt.isBlank(r102) == true) goto L18;
        r101 = false;
    L23:
        return null;
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public void remove(String r100) {
        if (isPrivacyAgreed() == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if ((!StringsKt.isBlank(r100)) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L15;
        getKeva().erase(keyOf(r100));
        return;
    }
}
