package com.larus.video.api;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.r2;
import com.larus.platform.api.z3;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/larus/video/api/IVideoApi;", "", "getAudioPlayController", "Lcom/larus/platform/api/IAudioPlayController;", "getISdkHolderHandler", "Lcom/larus/platform/api/ISdkHolderHanlder;", "getNewInstance", "Lcom/larus/platform/api/IVideoController;", "tag", "", "enableUseSR", "", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/platform/api/IVideoController;", "clearAllCaches", "", "getAllCacheSize", "", "getExpiredCacheSize", "expireBeforeMs", "clearExpiredCaches", "isDouyinVideoActivityInStack", "getTTVideoEngineStaticService", "Lcom/larus/platform/api/ITTVideoEngineStaticService;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IVideoApi {

    /* JADX INFO: loaded from: classes17.dex */
    public static final class a {
        public static /* synthetic */ IVideoController a(IVideoApi r100, String r101) {
            return r100.f(r101, null);
        }
    }

    long a(long r100);

    long b(long r100);

    z3 c();

    long d();

    void e();

    IVideoController f(String r100, Boolean r101);

    r2 g();
}
