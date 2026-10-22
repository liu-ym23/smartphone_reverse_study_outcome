package com.bytedance.creativex.mediaimport.preview.internal.pager;

import com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPagerAdapter;
import fi4.a;
import ki4.r;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012<\u0010\u0003\u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/creativex/mediaimport/preview/internal/pager/PreviewPagerAdapter;", "Lcom/bytedance/creativex/mediaimport/preview/internal/base/BasePreviewPagerAdapter;", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "pageViewProvider", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "data", "Lcom/bytedance/creativex/mediaimport/preview/internal/IPreviewPageView;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PreviewPagerAdapter extends BasePreviewPagerAdapter<r> {
    public PreviewPagerAdapter(Function2<? super Integer, ? super r, ? extends a<r>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pageViewProvider");
        super(r100);
    }
}
