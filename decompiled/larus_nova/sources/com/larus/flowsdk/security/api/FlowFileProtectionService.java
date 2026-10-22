package com.larus.flowsdk.security.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH'J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH'J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006H'J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH'J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/larus/flowsdk/security/api/FlowFileProtectionService;", "", "isFileEncryptionEnabled", "", "()Z", "defaultBlockTips", "", "getDefaultBlockTips", "()Ljava/lang/String;", "defaultShareBlockTips", "getDefaultShareBlockTips", "isEncrypted", "file", "Ljava/io/File;", "encryptFile", "decryptFile", "writeBackEncrypted", "decryptedPath", "openEncryptOutputStream", "Ljava/io/OutputStream;", "truncate", "openDecryptInputStream", "Ljava/io/InputStream;", "decryptUri", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FlowFileProtectionService {
    String A0();

    boolean C(File r100);

    String H0();

    boolean I0();
}
