package com.larus.mirabridge.api.pluginservice;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016¨\u0006\u001b"}, d2 = {"Lcom/larus/mirabridge/api/pluginservice/DoraPluginDefaultService;", "Lcom/larus/mirabridge/api/pluginservice/IDoraPluginService;", "<init>", "()V", "unpackFile", "", "fis", "Ljava/io/InputStream;", "unpackDir", "", "getImageUserMask", "", "albumMask", "ensureMorphoFiles", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getImageRealMask", "resultMask", "processImagePack", "Lcom/larus/mirabridge/api/pluginservice/ImagePostProcessResult;", "params", "Lcom/larus/mirabridge/api/pluginservice/ImagePostProcessParams;", "stabilizeVideoPack", "Lcom/larus/mirabridge/api/pluginservice/VideoStabilizeResult;", "Lcom/larus/mirabridge/api/pluginservice/VideoStabilizeParams;", "postProcessorVersion", "videoStabilizerVersion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraPluginDefaultService implements IDoraPluginService {
    public DoraPluginDefaultService() {
    }

    @Override // com.larus.mirabridge.api.pluginservice.IDoraPluginService
    public final void ensureMorphoFiles(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.larus.mirabridge.api.pluginservice.IDoraPluginService
    public final String getImageRealMask(int r100) {
        return "";
    }

    @Override // com.larus.mirabridge.api.pluginservice.IDoraPluginService
    public final int getImageUserMask(int r100) {
        return 0;
    }

    @Override // com.larus.mirabridge.api.pluginservice.IDoraPluginService
    public final String postProcessorVersion() {
        return "";
    }

    @Override // com.larus.mirabridge.api.pluginservice.IDoraPluginService
    public final void unpackFile(InputStream r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fis");
        Intrinsics.checkNotNullParameter(r101, "unpackDir");
    }

    @Override // com.larus.mirabridge.api.pluginservice.IDoraPluginService
    public final String videoStabilizerVersion() {
        return "";
    }

    @Override // com.larus.mirabridge.api.pluginservice.IDoraPluginService
    public final ImagePostProcessResult processImagePack(Context r110, ImagePostProcessParams r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "params");
        return new ImagePostProcessResult(false, 0, new int[0], null, 0, null, 48, null);
    }

    @Override // com.larus.mirabridge.api.pluginservice.IDoraPluginService
    public final VideoStabilizeResult stabilizeVideoPack(Context r100, VideoStabilizeParams r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        return new VideoStabilizeResult(false, 0, null, 0, 12, null);
    }
}
