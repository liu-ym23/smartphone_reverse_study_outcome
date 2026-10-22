package com.bytedance.ee.lark.infra.file;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@AppConfig(key = "file_system_threshold_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/TTFileHelper$TTFileCryptoConfigModel;", "", "<init>", "()V", "isEncryptDisable", "", "()Z", "setEncryptDisable", "(Z)V", "isDecryptDisable", "setDecryptDisable", "isCryptoToastDisable", "setCryptoToastDisable", "isEnableFileLog", "setEnableFileLog", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TTFileHelper$TTFileCryptoConfigModel {

    @JSONField(name = "crypto_toast_disable")
    private boolean isCryptoToastDisable;

    @JSONField(name = "decrypt_disable")
    private boolean isDecryptDisable;

    @JSONField(name = "enable_file_log")
    private boolean isEnableFileLog;

    @JSONField(name = "encrypt_disable")
    private boolean isEncryptDisable;

    public TTFileHelper$TTFileCryptoConfigModel() {
        this.isEncryptDisable = true;
        this.isDecryptDisable = true;
        this.isCryptoToastDisable = true;
        this.isEnableFileLog = true;
    }

    public final boolean isCryptoToastDisable() {
        return this.isCryptoToastDisable;
    }

    public final boolean isDecryptDisable() {
        return this.isDecryptDisable;
    }

    public final boolean isEnableFileLog() {
        return this.isEnableFileLog;
    }

    public final boolean isEncryptDisable() {
        return this.isEncryptDisable;
    }

    public final void setCryptoToastDisable(boolean r100) {
        this.isCryptoToastDisable = r100;
    }

    public final void setDecryptDisable(boolean r100) {
        this.isDecryptDisable = r100;
    }

    public final void setEnableFileLog(boolean r100) {
        this.isEnableFileLog = r100;
    }

    public final void setEncryptDisable(boolean r100) {
        this.isEncryptDisable = r100;
    }
}
