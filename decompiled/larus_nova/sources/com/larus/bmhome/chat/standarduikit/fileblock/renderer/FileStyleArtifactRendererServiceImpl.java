package com.larus.bmhome.chat.standarduikit.fileblock.renderer;

import android.content.Context;
import com.larus.bmhome.chat.block.base.renderer.IFileStyleArtifactRendererService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xk8.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileblock/renderer/FileStyleArtifactRendererServiceImpl;", "Lcom/larus/bmhome/chat/block/base/renderer/IFileStyleArtifactRendererService;", "<init>", "()V", "createRenderer", "Lcom/larus/bmhome/chat/block/base/renderer/IFileStyleArtifactRenderer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileStyleArtifactRendererServiceImpl implements IFileStyleArtifactRendererService {
    public FileStyleArtifactRendererServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.block.base.renderer.IFileStyleArtifactRendererService
    public final b a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new b(r100);
    }
}
