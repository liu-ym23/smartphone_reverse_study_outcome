package com.obric.security.keymanager;

/* JADX INFO: loaded from: classes34.dex */
public class KeyManagerConst {
    public static final String ADDITIONAL_DATA = "aad";
    private static final int AES_DEFAULT_KEY_SIZE = 256;
    public static final String APP_SIGNATURE = "app_sign";
    public static final String ATTEST_APPID = "attest_appid";
    public static final String ATTEST_CUSTOM_INFO = "attest_custom_info";
    public static final String ATTEST_PRDID = "attest_rpdid";
    public static final String ATTEST_PRUID = "attest_rpuid";
    public static final String ATTEST_UDID = "attest_udid";
    public static final int BLOCK_MODE_CBC = 1;
    public static final int BLOCK_MODE_CTR = 2;
    public static final int BLOCK_MODE_GCM = 3;
    public static final String CHALLENGE = "challenge";
    public static final String DEVICE_HEALTH_STATUS_REQUIRED = "device_health_status_required";
    public static final int DIGEST_SHA256 = 1;
    public static final int DIGEST_SHA512 = 3;
    private static final int ECC_DEFAULT_KEY_SIZE = 256;
    public static final String ECC_PRIVATE_KEY = "ecc_prikey";
    public static final String ECC_PUBLIC_KEY = "ecc_pubkey";
    public static final int ENCRYPTION_PADDING_NONE = 0;
    public static final int ENCRYPTION_PADDING_PKCS7 = 1;
    public static final int ENCRYPTION_PADDING_RSA_OAEP = 2;
    public static final int ENCRYPTION_PADDING_RSA_PKCS1 = 3;
    private static final int HMAC_DEFAULT_KEY_SIZE = 256;
    public static final String IMPORT_PARAMS = "import_params";
    public static final String INPUT_DATA = "input_data";
    public static final String KEY_ALGO = "key_algorithm";
    public static final int KEY_ALGORITHM_AES = 1;
    public static final int KEY_ALGORITHM_ECC = 2;
    public static final int KEY_ALGORITHM_RSA = 3;
    public static final String KEY_ALIAS = "key_alias";
    public static final String KEY_EXPIRY_DATE = "key_expiry_date";
    public static final String KEY_LEN = "key_length";
    public static final String KEY_PURPOSE = "key_purpose";
    public static final int MAX_ATTESTATION_CUSTOM_INFO_LEN = 1024;
    public static final int MAX_ATTESTATION_ID_LEN = 128;
    public static final int MAX_KEY_ALIAS_LEN = 128;
    public static final String OUTPUT_DATA = "output_data";
    public static final String PKG_NAME = "pkg_name";
    public static final int PURPOSE_AGREE_KEY = 32;
    public static final int PURPOSE_ATTEST_KEY = 64;
    public static final int PURPOSE_DECRYPT = 2;
    public static final int PURPOSE_ENCRYPT = 1;
    public static final int PURPOSE_EXPORT_KEY_CERT_CHAIN = 128;
    public static final int PURPOSE_SIGN = 4;
    public static final int PURPOSE_VERIFY = 8;
    public static final int PURPOSE_WRAP_KEY = 16;
    public static final String RESULT_CODE = "result_code";
    public static final String RESULT_LIST = "result_list";
    private static final int RSA_DEFAULT_KEY_SIZE = 2048;
    public static final String WRAPPED_KEY_DATA = "wrapped_key_data";

    public KeyManagerConst() {
    }
}
