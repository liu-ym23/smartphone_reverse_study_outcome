package com.bytedance.crypto.utils;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.keymanager.KeyManagerResult;
import com.aiassistant.security.platformkey.PlatformKeyManager;
import com.aiassistant.security.rot_provision.RotProvisionManager;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class FrameworkSecurityCompat {
    private static final String AIASSISTANT_SECRET_DATA_MANAGER = "com.aiassistant.security.secretdata.SecretDataManager";
    private static final String OBric_SECRET_DATA_MANAGER = "com.obric.security.secretdata.SecretDataManager";
    private static final String TAG = "FrameworkSecurityCompat";
    private static volatile Impl sImpl;

    /* JADX INFO: renamed from: com.bytedance.crypto.utils.FrameworkSecurityCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class AiassistantImpl implements Impl {
        private AiassistantImpl() {
        }

        public /* synthetic */ AiassistantImpl(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r100, Object r101, Bundle r102) {
            if ((r101 instanceof com.aiassistant.security.secretdata.SecretData) == true) goto L5;
            return -1;
        L5:
            AddResult r103 = SecretDataManager.getInstance().addData(r100, (com.aiassistant.security.secretdata.SecretData) r101, r102);
            if (r103 != null) goto L9;
            return -1;
        L9:
            return r103.getResultCode();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "query_mode";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "challenge";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r100, String r101, Bundle r102) {
            return SecretDataManager.getInstance().deleteData(r100, r101, r102);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r100, String r101, Bundle r102) {
            return KeyManager.getInstance().deleteKey(r100, r101, r102);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r100, String r101) {
            return KeyManager.getInstance().deleteSyncKey(r100, r101);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ecc_prikey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ecc_pubkey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r100, String r101, Bundle r102) {
            return KeyManager.getInstance().generateKeyPair(r100, r101, r102);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r100, String r101, Bundle r102) {
            return new AiassistantKmResult(KeyManager.getInstance().getCertificateChain(r100, r101, r102), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r100, Bundle r101) {
            return KeyManager.getInstance().importKey(r100, r101);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r100, Bundle r101) {
            return KeyManager.getInstance().importKeyLegacy(r100, r101);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r100, String r101, byte[] r102, Bundle r103) {
            return new AiassistantKmResult(KeyManager.getInstance().keyAgreement(r100, r101, r102, r103), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "key_algorithm";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "key_alias";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r100, String r101, Bundle r102) {
            return new AiassistantKmResult(KeyManager.getInstance().keyAttestation(r100, r101, r102), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "key_length";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "key_purpose";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return new com.aiassistant.security.secretdata.SecretData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 12;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r100, int r101, byte[] r102, byte[] r110, Bundle r111) {
            return PlatformKeyManager.getInstance().decrypt(r100, r101, r102, r110, r111);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return -983038;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 32;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r100, String r101, Bundle r102) {
            return new AiassistantSdQueryResult(SecretDataManager.getInstance().queryData(r100, r101, r102), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r100, Bundle r101) {
            String r102 = RotProvisionManager.getInstance().checkState(r100, r101);
            if (r102 != null) goto L6;
            return "";
        L6:
            return r102;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r100) {
            String r101 = ((com.aiassistant.security.secretdata.SecretData) r100).extInfo;
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r100) {
            String r101 = ((com.aiassistant.security.secretdata.SecretData) r100).publicData;
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r100) {
            String r101 = ((com.aiassistant.security.secretdata.SecretData) r100).searchInfo;
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r100) {
            String r101 = ((com.aiassistant.security.secretdata.SecretData) r100).secretData;
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r100, String r101) {
            ((com.aiassistant.security.secretdata.SecretData) r100).alias = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r100, String r101) {
            ((com.aiassistant.security.secretdata.SecretData) r100).extInfo = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r100, String r101) {
            ((com.aiassistant.security.secretdata.SecretData) r100).publicData = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r100, String r101) {
            ((com.aiassistant.security.secretdata.SecretData) r100).searchInfo = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r100, String r101) {
            ((com.aiassistant.security.secretdata.SecretData) r100).secretData = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -5;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r100, Object r101, Bundle r102) {
            if ((r101 instanceof com.aiassistant.security.secretdata.SecretData) == true) goto L7;
            return -1;
        L7:
            return SecretDataManager.getInstance().updateData(r100, (com.aiassistant.security.secretdata.SecretData) r101, r102);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "wrapped_key_data";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r100, int r101, byte[] r102, Bundle r103) {
            return new AiassistantKmResult(KeyManager.getInstance().xcrypt(r100, r101, r102, r103), null);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class AiassistantKmResult implements KmResult {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final KeyManagerResult f204271m;

        private AiassistantKmResult(KeyManagerResult r100) {
            this.f204271m = r100;
        }

        public /* synthetic */ AiassistantKmResult(KeyManagerResult r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            KeyManagerResult r100 = this.f204271m;
            if (r100 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r100.getCertChain();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            KeyManagerResult r100 = this.f204271m;
            if (r100 != null) goto L6;
            return new byte[0];
        L6:
            return r100.getOutData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            KeyManagerResult r100 = this.f204271m;
            if (r100 != null) goto L6;
            return -1;
        L6:
            return r100.getResultCode();
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class AiassistantSdQueryResult implements SdQueryResult {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final QueryResult f204272m;

        private AiassistantSdQueryResult(QueryResult r100) {
            this.f204272m = r100;
        }

        public /* synthetic */ AiassistantSdQueryResult(QueryResult r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            QueryResult r100 = this.f204272m;
            if (r100 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r100.getDataList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            QueryResult r100 = this.f204272m;
            if (r100 != null) goto L6;
            return -1;
        L6:
            return r100.getResultCode();
        }
    }

    public interface Impl {
        int addData(Context r100, Object r101, Bundle r102);

        String additionalData();

        String bundleKeyQueryMode();

        String challenge();

        int deleteData(Context r100, String r101, Bundle r102);

        int deleteKey(Context r100, String r101, Bundle r102);

        int deleteSyncKey(Context r100, String r101);

        String deviceHealthStatusRequired();

        String eccPrivateKey();

        String eccPublicKey();

        int generateKeyPair(Context r100, String r101, Bundle r102);

        KmResult getCertificateChain(Context r100, String r101, Bundle r102);

        int importKey(Context r100, Bundle r101);

        int importKeyLegacy(Context r100, Bundle r101);

        KmResult keyAgreement(Context r100, String r101, byte[] r102, Bundle r103);

        String keyAlgo();

        int keyAlgorithmEcc();

        String keyAlias();

        KmResult keyAttestation(Context r100, String r101, Bundle r102);

        String keyLen();

        String keyPurpose();

        int kmSuccess();

        Object newSecretData();

        int platformIvLen();

        byte[] platformKeyDecrypt(Context r100, int r101, byte[] r102, byte[] r103, Bundle r104);

        int platformMagicNumLen();

        int platformSm8750();

        int platformVerLen();

        int preciseQueryAndDecrypt();

        int purposeAgreeKey();

        int purposeAttestKey();

        SdQueryResult queryData(Context r100, String r101, Bundle r102);

        String rotCheckState(Context r100, Bundle r101);

        String sdGetExtInfo(Object r100);

        String sdGetPublicData(Object r100);

        String sdGetSearchInfo(Object r100);

        String sdGetSecretData(Object r100);

        void sdSetAlias(Object r100, String r101);

        void sdSetExtInfo(Object r100, String r101);

        void sdSetPublicData(Object r100, String r101);

        void sdSetSearchInfo(Object r100, String r101);

        void sdSetSecretData(Object r100, String r101);

        int secretDataNotFound();

        int secretSuccess();

        int updateData(Context r100, Object r101, Bundle r102);

        String wrappedKeyData();

        KmResult xcrypt(Context r100, int r101, byte[] r102, Bundle r103);
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class KeyManagerConst {
        public KeyManagerConst() {
        }

        public static String ADDITIONAL_DATA() {
            return FrameworkSecurityCompat.access$900().additionalData();
        L4:
            return "ADDITIONAL_DATA";
        }

        public static String CHALLENGE() {
            return FrameworkSecurityCompat.access$900().challenge();
        L4:
            return "CHALLENGE";
        }

        public static String DEVICE_HEALTH_STATUS_REQUIRED() {
            return FrameworkSecurityCompat.access$900().deviceHealthStatusRequired();
        L4:
            return "DEVICE_HEALTH_STATUS_REQUIRED";
        }

        public static String ECC_PRIVATE_KEY() {
            return FrameworkSecurityCompat.access$900().eccPrivateKey();
        L4:
            return "ECC_PRIVATE_KEY";
        }

        public static String ECC_PUBLIC_KEY() {
            return FrameworkSecurityCompat.access$900().eccPublicKey();
        L4:
            return "ECC_PUBLIC_KEY";
        }

        public static String KEY_ALGO() {
            return FrameworkSecurityCompat.access$900().keyAlgo();
        L4:
            return "KEY_ALGO";
        }

        public static int KEY_ALGORITHM_ECC() {
            return FrameworkSecurityCompat.access$900().keyAlgorithmEcc();
        L4:
            return -1;
        }

        public static String KEY_ALIAS() {
            return FrameworkSecurityCompat.access$900().keyAlias();
        L4:
            return "KEY_ALIAS";
        }

        public static String KEY_LEN() {
            return FrameworkSecurityCompat.access$900().keyLen();
        L4:
            return "KEY_LEN";
        }

        public static String KEY_PURPOSE() {
            return FrameworkSecurityCompat.access$900().keyPurpose();
        L4:
            return "KEY_PURPOSE";
        }

        public static int PURPOSE_AGREE_KEY() {
            return FrameworkSecurityCompat.access$900().purposeAgreeKey();
        L4:
            return 0;
        }

        public static int PURPOSE_ATTEST_KEY() {
            return FrameworkSecurityCompat.access$900().purposeAttestKey();
        L4:
            return 0;
        }

        public static String WRAPPED_KEY_DATA() {
            return FrameworkSecurityCompat.access$900().wrappedKeyData();
        L4:
            return "WRAPPED_KEY_DATA";
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class KeyManagerErrorCode {
        public KeyManagerErrorCode() {
        }

        public static int KM_SUCCESS() {
            return FrameworkSecurityCompat.access$900().kmSuccess();
        L4:
            return 0;
        }
    }

    public interface KmResult {
        List<Certificate> getCertChain();

        byte[] getOutData();

        int getResultCode();
    }

    public static final class NoopImpl implements Impl {
        private NoopImpl() {
        }

        public /* synthetic */ NoopImpl(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r100, Object r101, Bundle r102) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "ADDITIONAL_DATA";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "BUNDLE_KEY_QUERY_MODE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "CHALLENGE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r100, String r101, Bundle r102) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r100, String r101, Bundle r102) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r100, String r101) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "DEVICE_HEALTH_STATUS_REQUIRED";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ECC_PRIVATE_KEY";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ECC_PUBLIC_KEY";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r100, String r101, Bundle r102) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r100, String r101, Bundle r102) {
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r100, Bundle r101) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r100, Bundle r101) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r100, String r101, byte[] r102, Bundle r103) {
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "KEY_ALGO";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "KEY_ALIAS";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r100, String r101, Bundle r102) {
            return new NoopKmResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "KEY_LEN";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "KEY_PURPOSE";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return null;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r100, int r101, byte[] r102, byte[] r103, Bundle r104) {
            return null;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r100, String r101, Bundle r102) {
            return new NoopSdQueryResult(null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r100, Bundle r101) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r100) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r100) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r100) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r100) {
            return "";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r100, String r101) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r100, String r101) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r100, String r101) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r100, String r101) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r100, String r101) {
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r100, Object r101, Bundle r102) {
            return -1;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "WRAPPED_KEY_DATA";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r100, int r101, byte[] r102, Bundle r103) {
            return new NoopKmResult(null);
        }
    }

    public static final class NoopKmResult implements KmResult {
        private NoopKmResult() {
        }

        public /* synthetic */ NoopKmResult(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            return new byte[0];
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            return -1;
        }
    }

    public static final class NoopSdQueryResult implements SdQueryResult {
        private NoopSdQueryResult() {
        }

        public /* synthetic */ NoopSdQueryResult(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            return -1;
        }
    }

    public static final class ObricImpl implements Impl {
        private ObricImpl() {
        }

        public /* synthetic */ ObricImpl(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int addData(Context r100, Object r101, Bundle r102) {
            if ((r101 instanceof com.obric.security.secretdata.SecretData) == true) goto L5;
            return -1;
        L5:
            com.obric.security.secretdata.AddResult r103 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r100, (com.obric.security.secretdata.SecretData) r101, r102);
            if (r103 != null) goto L9;
            return -1;
        L9:
            return r103.getResultCode();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String additionalData() {
            return "aad";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String bundleKeyQueryMode() {
            return "query_mode";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String challenge() {
            return "challenge";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteData(Context r100, String r101, Bundle r102) {
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r100, r101, r102);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteKey(Context r100, String r101, Bundle r102) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r100, r101, r102);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int deleteSyncKey(Context r100, String r101) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteSyncKey(r100, r101);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String deviceHealthStatusRequired() {
            return "device_health_status_required";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPrivateKey() {
            return "ecc_prikey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String eccPublicKey() {
            return "ecc_pubkey";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int generateKeyPair(Context r100, String r101, Bundle r102) {
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r100, r101, r102);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult getCertificateChain(Context r100, String r101, Bundle r102) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().getCertificateChain(r100, r101, r102), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKey(Context r100, Bundle r101) {
            return com.obric.security.keymanager.KeyManager.getInstance().importKey(r100, r101);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int importKeyLegacy(Context r100, Bundle r101) {
            return com.obric.security.keymanager.KeyManager.getInstance().importKeyLegacy(r100, r101);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAgreement(Context r100, String r101, byte[] r102, Bundle r103) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().keyAgreement(r100, r101, r102, r103), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlgo() {
            return "key_algorithm";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int keyAlgorithmEcc() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyAlias() {
            return "key_alias";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult keyAttestation(Context r100, String r101, Bundle r102) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r100, r101, r102), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyLen() {
            return "key_length";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String keyPurpose() {
            return "key_purpose";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int kmSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public Object newSecretData() {
            return new com.obric.security.secretdata.SecretData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformIvLen() {
            return 12;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public byte[] platformKeyDecrypt(Context r100, int r101, byte[] r102, byte[] r110, Bundle r111) {
            return com.obric.security.platformkey.PlatformKeyManager.getInstance().decrypt(r100, r101, r102, r110, r111);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformMagicNumLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformSm8750() {
            return -983038;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int platformVerLen() {
            return 4;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int preciseQueryAndDecrypt() {
            return 2;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAgreeKey() {
            return 32;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int purposeAttestKey() {
            return 64;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public SdQueryResult queryData(Context r100, String r101, Bundle r102) {
            return new ObricSdQueryResult(com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r100, r101, r102), null);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String rotCheckState(Context r100, Bundle r101) {
            String r102 = com.obric.security.rot_provision.RotProvisionManager.getInstance().checkState(r100, r101);
            if (r102 != null) goto L6;
            return "";
        L6:
            return r102;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetExtInfo(Object r100) {
            String r101 = ((com.obric.security.secretdata.SecretData) r100).extInfo;
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetPublicData(Object r100) {
            String r101 = ((com.obric.security.secretdata.SecretData) r100).publicData;
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSearchInfo(Object r100) {
            String r101 = ((com.obric.security.secretdata.SecretData) r100).searchInfo;
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String sdGetSecretData(Object r100) {
            String r101 = ((com.obric.security.secretdata.SecretData) r100).secretData;
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetAlias(Object r100, String r101) {
            ((com.obric.security.secretdata.SecretData) r100).alias = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetExtInfo(Object r100, String r101) {
            ((com.obric.security.secretdata.SecretData) r100).extInfo = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetPublicData(Object r100, String r101) {
            ((com.obric.security.secretdata.SecretData) r100).publicData = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSearchInfo(Object r100, String r101) {
            ((com.obric.security.secretdata.SecretData) r100).searchInfo = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public void sdSetSecretData(Object r100, String r101) {
            ((com.obric.security.secretdata.SecretData) r100).secretData = r101;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretDataNotFound() {
            return -5;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int secretSuccess() {
            return 0;
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public int updateData(Context r100, Object r101, Bundle r102) {
            if ((r101 instanceof com.obric.security.secretdata.SecretData) == true) goto L7;
            return -1;
        L7:
            return com.obric.security.secretdata.SecretDataManager.getInstance().updateData(r100, (com.obric.security.secretdata.SecretData) r101, r102);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public String wrappedKeyData() {
            return "wrapped_key_data";
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.Impl
        public KmResult xcrypt(Context r100, int r101, byte[] r102, Bundle r103) {
            return new ObricKmResult(com.obric.security.keymanager.KeyManager.getInstance().xcrypt(r100, r101, r102, r103), null);
        }
    }

    public static final class ObricKmResult implements KmResult {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final com.obric.security.keymanager.KeyManagerResult f204273m;

        private ObricKmResult(com.obric.security.keymanager.KeyManagerResult r100) {
            this.f204273m = r100;
        }

        public /* synthetic */ ObricKmResult(com.obric.security.keymanager.KeyManagerResult r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public List<Certificate> getCertChain() {
            com.obric.security.keymanager.KeyManagerResult r100 = this.f204273m;
            if (r100 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r100.getCertChain();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public byte[] getOutData() {
            com.obric.security.keymanager.KeyManagerResult r100 = this.f204273m;
            if (r100 != null) goto L6;
            return new byte[0];
        L6:
            return r100.getOutData();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.KmResult
        public int getResultCode() {
            com.obric.security.keymanager.KeyManagerResult r100 = this.f204273m;
            if (r100 != null) goto L6;
            return -1;
        L6:
            return r100.getResultCode();
        }
    }

    public static final class ObricSdQueryResult implements SdQueryResult {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final com.obric.security.secretdata.QueryResult f204274m;

        private ObricSdQueryResult(com.obric.security.secretdata.QueryResult r100) {
            this.f204274m = r100;
        }

        public /* synthetic */ ObricSdQueryResult(com.obric.security.secretdata.QueryResult r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public List<?> getDataList() {
            com.obric.security.secretdata.QueryResult r100 = this.f204274m;
            if (r100 != null) goto L6;
            return Collections.emptyList();
        L6:
            return r100.getDataList();
        }

        @Override // com.bytedance.crypto.utils.FrameworkSecurityCompat.SdQueryResult
        public int getResultCode() {
            com.obric.security.secretdata.QueryResult r100 = this.f204274m;
            if (r100 != null) goto L6;
            return -1;
        L6:
            return r100.getResultCode();
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class PlatformKeyConst {
        public PlatformKeyConst() {
        }

        public static int IV_LEN() {
            return FrameworkSecurityCompat.access$900().platformIvLen();
        L4:
            return 0;
        }

        public static int MAGIC_NUM_LEN() {
            return FrameworkSecurityCompat.access$900().platformMagicNumLen();
        L4:
            return 0;
        }

        public static int PLATFORM_SM8750() {
            return FrameworkSecurityCompat.access$900().platformSm8750();
        L4:
            return 0;
        }

        public static int PLATFORM_VER_LEN() {
            return FrameworkSecurityCompat.access$900().platformVerLen();
        L4:
            return 0;
        }
    }

    public static final class QueryMode {
        public QueryMode() {
        }

        public static int PRECISE_QUERY_AND_DECRYPT() {
            return FrameworkSecurityCompat.access$900().preciseQueryAndDecrypt();
        L4:
            return 0;
        }
    }

    public interface SdQueryResult {
        List<?> getDataList();

        int getResultCode();
    }

    public static final class SecretConst {
        public SecretConst() {
        }

        public static String BUNDLE_KEY_QUERY_MODE() {
            return FrameworkSecurityCompat.access$900().bundleKeyQueryMode();
        L4:
            return "BUNDLE_KEY_QUERY_MODE";
        }
    }

    public static final class SecretData {
        public SecretData() {
        }

        public static String getExtInfo(Object r100) {
            if (r100 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetExtInfo(r100);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getExtInfo failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getPublicData(Object r100) {
            if (r100 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetPublicData(r100);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getPublicData failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getSearchInfo(Object r100) {
            if (r100 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetSearchInfo(r100);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getSearchInfo failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static String getSecretData(Object r100) {
            if (r100 == null) goto L12;
            return FrameworkSecurityCompat.access$900().sdGetSecretData(r100);
        L7:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "getSecretData failed: " + th.getMessage());
            return "";
        L12:
            return "";
        }

        public static Object newInstance() {
            return FrameworkSecurityCompat.access$900().newSecretData();
        L4:
            return null;
        }

        public static void setAlias(Object r100, String r101) {
            if (r100 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetAlias(r100, r101);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setAlias failed: " + th.getMessage());
            return;
        }

        public static void setExtInfo(Object r100, String r101) {
            if (r100 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetExtInfo(r100, r101);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setExtInfo failed: " + th.getMessage());
            return;
        }

        public static void setPublicData(Object r100, String r101) {
            if (r100 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetPublicData(r100, r101);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setPublicData failed: " + th.getMessage());
            return;
        }

        public static void setSearchInfo(Object r100, String r101) {
            if (r100 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetSearchInfo(r100, r101);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setSearchInfo failed: " + th.getMessage());
            return;
        }

        public static void setSecretData(Object r100, String r101) {
            if (r100 == null) goto L10;
            FrameworkSecurityCompat.access$900().sdSetSecretData(r100, r101);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            LogUtils.e(FrameworkSecurityCompat.TAG, "setSecretData failed: " + th.getMessage());
            return;
        }
    }

    public static final class SecretErrorCode {
        public SecretErrorCode() {
        }

        public static int DATA_NOT_FOUNT() {
            return FrameworkSecurityCompat.access$900().secretDataNotFound();
        L4:
            return -1;
        }

        public static int SUCCESS() {
            return FrameworkSecurityCompat.access$900().secretSuccess();
        L4:
            return 0;
        }
    }

    private FrameworkSecurityCompat() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static /* synthetic */ Impl access$900() {
        return impl();
    }

    public static int addData(Context r100, Object r101, Bundle r102) {
        return impl().addData(r100, r101, r102);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "addData failed: " + th.getMessage());
        return -1;
    }

    public static int deleteData(Context r100, String r101, Bundle r102) {
        return impl().deleteData(r100, r101, r102);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteData failed: " + th.getMessage());
        return -1;
    }

    public static int deleteKey(Context r100, String r101, Bundle r102) {
        return impl().deleteKey(r100, r101, r102);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteKey failed: " + th.getMessage());
        return -1;
    }

    public static int deleteSyncKey(Context r100, String r101) {
        return impl().deleteSyncKey(r100, r101);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "deleteSyncKey failed: " + th.getMessage());
        return -1;
    }

    public static int generateKeyPair(Context r100, String r101, Bundle r102) {
        return impl().generateKeyPair(r100, r101, r102);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "generateKeyPair failed: " + th.getMessage());
        return -1;
    }

    public static KmResult getCertificateChain(Context r100, String r101, Bundle r102) {
        return impl().getCertificateChain(r100, r101, r102);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "getCertificateChain failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    private static boolean hasClass(String r100) {
        INVOKESTATIC_com_bytedance_crypto_utils_FrameworkSecurityCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, false, null);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        e = move-exception;
        LogUtils.e(TAG, "Class not found:" + e);
        return false;
    }

    private static Impl impl() {
        if (sImpl == null) goto L7;
        return sImpl;
    L7:
        monitor-enter(FrameworkSecurityCompat.class);
    L24:
        th = move-exception;
        throw th;
    L9:
        if (sImpl == null) goto L13;
        Impl r100 = sImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r100;
    L13:
        AnonymousClass1 r101 = null;
        if (hasClass(OBric_SECRET_DATA_MANAGER) == false) goto L17;
        sImpl = new ObricImpl(r101);     // Catch: Throwable -> L24
        String r102 = TAG;
        String r103 = "Resolved framework security package: com.obric.security";
    L19:
        LogUtils.i(r102, r103);     // Catch: Throwable -> L24
    L21:
        Impl r104 = sImpl;     // Catch: Throwable -> L24
        monitor-exit(FrameworkSecurityCompat.class);     // Catch: Throwable -> L24
        return r104;
    L17:
        if (hasClass(AIASSISTANT_SECRET_DATA_MANAGER) == false) goto L20;
        sImpl = new AiassistantImpl(r101);     // Catch: Throwable -> L24
        r102 = TAG;
        r103 = "Resolved framework security package: com.aiassistant.security";
        goto L19
    L20:
        sImpl = new NoopImpl(r101);     // Catch: Throwable -> L24
        LogUtils.w(TAG, "No framework security package found (obric/aiassistant).");     // Catch: Throwable -> L24
        goto L21
    }

    public static int importKey(Context r100, Bundle r101) {
        return impl().importKey(r100, r101);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "importKey failed: " + th.getMessage());
        return -1;
    }

    public static int importKeyLegacy(Context r100, Bundle r101) {
        return impl().importKeyLegacy(r100, r101);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "importKeyLegacy failed: " + th.getMessage());
        return -1;
    }

    public static KmResult keyAgreement(Context r100, String r101, byte[] r102, Bundle r103) {
        return impl().keyAgreement(r100, r101, r102, r103);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "keyAgreement failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    public static KmResult keyAttestation(Context r100, String r101, Bundle r102) {
        return impl().keyAttestation(r100, r101, r102);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "keyAttestation failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    public static byte[] platformKeyDecrypt(Context r100, int r101, byte[] r102, byte[] r103, Bundle r110) {
        return impl().platformKeyDecrypt(r100, r101, r102, r103, r110);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "platformKeyDecrypt failed: " + th.getMessage());
        return null;
    }

    public static SdQueryResult queryData(Context r100, String r101, Bundle r102) {
        return impl().queryData(r100, r101, r102);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "queryData failed: " + th.getMessage());
        return new NoopSdQueryResult(null);
    }

    public static String rotCheckState(Context r100, Bundle r101) {
        return impl().rotCheckState(r100, r101);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "rotCheckState failed: " + th.getMessage());
        return "";
    }

    public static int updateData(Context r100, Object r101, Bundle r102) {
        return impl().updateData(r100, r101, r102);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "updateData failed: " + th.getMessage());
        return -1;
    }

    public static KmResult xcrypt(Context r100, int r101, byte[] r102, Bundle r103) {
        return impl().xcrypt(r100, r101, r102, r103);
    L4:
        th = move-exception;
        LogUtils.e(TAG, "xcrypt failed: " + th.getMessage());
        return new NoopKmResult(null);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_crypto_utils_FrameworkSecurityCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}
