package com.ss.lark.android.encryption.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/lark/android/encryption/utils/RustMethod;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INIT_CIPHER", "DECRYPT_URI_V2", "DECRYPT_URI", "DECRYPT_URI_FD", "DECRYPT_FILE", "ENCRYPT_FILE", "QUERY_STATUS", "CONFIG_SETTING", "security-encryption_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RustMethod extends Enum<RustMethod> {
    public static final RustMethod CONFIG_SETTING = null;
    public static final RustMethod DECRYPT_FILE = null;
    public static final RustMethod DECRYPT_URI = null;
    public static final RustMethod DECRYPT_URI_FD = null;
    public static final RustMethod DECRYPT_URI_V2 = null;
    public static final RustMethod ENCRYPT_FILE = null;
    public static final RustMethod INIT_CIPHER = null;
    public static final RustMethod QUERY_STATUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RustMethod[] f456821a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f456822b = null;
    private final String value;

    public static EnumEntries<RustMethod> getEntries() {
        return f456822b;
    }

    static {
        RustMethod r100 = new RustMethod("INIT_CIPHER", 0, "init_cipher");
        INIT_CIPHER = r100;
        RustMethod r101 = new RustMethod("DECRYPT_URI_V2", 1, "decrypt_uri_v2");
        DECRYPT_URI_V2 = r101;
        RustMethod r102 = new RustMethod("DECRYPT_URI", 2, "decrypt_uri");
        DECRYPT_URI = r102;
        RustMethod r103 = new RustMethod("DECRYPT_URI_FD", 3, "decrypt_uri_fd");
        DECRYPT_URI_FD = r103;
        RustMethod r104 = new RustMethod("DECRYPT_FILE", 4, "decrypt_file");
        DECRYPT_FILE = r104;
        RustMethod r105 = new RustMethod("ENCRYPT_FILE", 5, "encrypt_file");
        ENCRYPT_FILE = r105;
        RustMethod r110 = new RustMethod("QUERY_STATUS", 6, "query_status");
        QUERY_STATUS = r110;
        RustMethod r111 = new RustMethod("CONFIG_SETTING", 7, "config_setting");
        CONFIG_SETTING = r111;
        RustMethod[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f456821a = r112;
        f456822b = EnumEntriesKt.enumEntries(r112);
    }

    public static RustMethod[] values() {
        return (RustMethod[]) f456821a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RustMethod valueOf(String r100) {
        return (RustMethod) r27.a.a(RustMethod.class, r100);
    }

    public RustMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
