package com.bytedance.locallife.poi.newdetail.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiEmptyVideoDitoView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/dito/model/a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiEmptyVideoDitoView extends BaseDitoView<com.bytedance.locallife.dito.model.a> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f263059y;

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void onCreate() {
        super.onCreate();
        LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_dito_empty_video_view, this);
        setBackgroundColor(this.f263059y);
    }

    public PoiEmptyVideoDitoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263059y = ColorProtector.parseColor("#F3F3F4");
    }
}
