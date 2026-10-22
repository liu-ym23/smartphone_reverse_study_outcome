package com.ss.android.lark.flow.chat.mediapreview;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kza.h;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class c implements h {
    @Inject
    public c() {
    }

    @Override // kza.h
    public final FlowLargeImageView a(Context r100, GallerySource r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        AttributeSet r102 = null;
        FlowLargeImageView r103 = new FlowLargeImageView(r100, r102, 6, 0);
        r103.setMSource(r101);
        return r103;
    }
}
