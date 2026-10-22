package com.larus.mirabridge.api.pluginservice;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0007H&J\b\u0010\u0018\u001a\u00020\u0007H&¨\u0006\u0019"}, d2 = {"Lcom/larus/mirabridge/api/pluginservice/IDoraPluginService;", "", "unpackFile", "", "fis", "Ljava/io/InputStream;", "unpackDir", "", "getImageUserMask", "", "albumMask", "ensureMorphoFiles", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getImageRealMask", "resultMask", "processImagePack", "Lcom/larus/mirabridge/api/pluginservice/ImagePostProcessResult;", "params", "Lcom/larus/mirabridge/api/pluginservice/ImagePostProcessParams;", "stabilizeVideoPack", "Lcom/larus/mirabridge/api/pluginservice/VideoStabilizeResult;", "Lcom/larus/mirabridge/api/pluginservice/VideoStabilizeParams;", "postProcessorVersion", "videoStabilizerVersion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraPluginService {
    void ensureMorphoFiles(Context r100);

    String getImageRealMask(int r100);

    int getImageUserMask(int r100);

    String postProcessorVersion();

    ImagePostProcessResult processImagePack(Context r100, ImagePostProcessParams r101);

    VideoStabilizeResult stabilizeVideoPack(Context r100, VideoStabilizeParams r101);

    void unpackFile(InputStream r100, String r101);

    String videoStabilizerVersion();
}
