package com.bytedance.android.shopping.verse.api;

import android.content.Context;
import com.bytedance.apm.constant.UploadTypeInf;
import dl3.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/verse/api/IVerseService;", "", "Landroid/content/Context;", "context", "", "init", UploadTypeInf.START, "stop", "", "isInitialized", "isConnected", "Ldl3/a;", "getMallDebugService", "ec-verse-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVerseService {
    a getMallDebugService();

    void init(Context r1);

    boolean isConnected();

    boolean isInitialized();

    void start(Context r1);

    void stop(Context r1);
}
