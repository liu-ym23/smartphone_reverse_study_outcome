package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import android.content.Context;
import com.larksuite.rucket.job.compat.f;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.plugins.LarkLinkPlugin$visitLink$1$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import v7b.n;

/* JADX INFO: loaded from: classes36.dex */
public class TemporaryPreviewLoader implements cab.b {
    public TemporaryPreviewLoader() {
    }

    @Override // cab.b
    public final boolean a(final n r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        return ((Boolean) LarkLinkExtend.f420024f.b(new TemporaryPreviewLoader$shouldLoadLinkPreview$1(r100))).booleanValue();
    }

    @Override // cab.b
    public void b(Context r100, final n r101, LarkLinkPlugin$visitLink$1$1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "link");
        Intrinsics.checkNotNullParameter(r102, "callback");
        f.a(new TemporaryPreviewLoader$loadLinkPreview$1(r101)).then(Dispatchers.getMain(), new TemporaryPreviewLoader$loadLinkPreview$2(r102, r100, null)).error(Dispatchers.getMain(), new TemporaryPreviewLoader$loadLinkPreview$3(r102, null));
    }
}
