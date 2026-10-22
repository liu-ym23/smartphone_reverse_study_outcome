package com.mammon.audiosdk.structures;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechFingerprintEnrollParameter {
    public static final String SID_ENROLL_ENGINE_BACKEND_FLUTE = "flute";
    public static final String SID_ENROLL_ENGINE_BACKEND_LEGACY = "legacy";
    public String app_id;
    public String appkey;
    public String business;
    public String db_path;
    public String device_did;
    public String doubao_did;
    public String doubao_uid;
    public String encKeyInfo;
    public String extra;
    public String first_kws_model_path;
    public String fw_engine_version;
    public String header;
    public String sid_auth_enc_key_info;
    public String sid_auth_model_md5;
    public String sid_auth_model_path;
    public String sid_enroll_engine_backend;
    public String sid_enroll_model_md5;
    public String sid_enroll_model_path;
    public String silence_file_path;

    /* JADX INFO: renamed from: sn, reason: collision with root package name */
    public String f384363sn;
    public String token;
    public int tokenType;
    public String uid;
    public String url;

    public SpeechFingerprintEnrollParameter() {
        this.sid_enroll_engine_backend = "legacy";
    }
}
