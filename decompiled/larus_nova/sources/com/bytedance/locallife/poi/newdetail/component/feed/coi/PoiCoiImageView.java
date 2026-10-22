package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import com.bytedance.lighten.core.ImagePiplinePriority;
import com.bytedance.lighten.core.ScaleType;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.model.poi.resp.SimplePoiInfoStruct;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.coi.RelationPoiCommonItem;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import df6.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/PoiCoiImageView;", "Lcom/bytedance/lighten/loader/SmartImageView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiCoiImageView extends SmartImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f263173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ColorDrawable f263174g;

    public PoiCoiImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiCoiImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void p(RelationPoiCommonItem r100) {
        Intrinsics.checkNotNullParameter("poi_coi_single_feed_image", "callerId");
        if (r100 != null) goto L5;
        return;
    L5:
        this.f263173f = "poi_coi_single_feed_image";
        SimplePoiInfoStruct r101 = r100.getPoiInfo();
        if (r101 == null) goto L14;
        PoiImageUrlModel r102 = r101.getCover();
        if (r102 == null) goto L11;
        List<String> r103 = r102.getUrlList();
    L12:
        u r104 = df6.q.c(new ef6.a(r103));
        r104.f468284j = this.f263174g;
        r104.f468277c = getContext();
        r104.b(this.f263173f);
        r104.f468294t = this;
        r104.f468291q = ImagePiplinePriority.HIGH;
        r104.f468280f = true;
        r104.f468288n = ScaleType.CENTER_CROP;
        r104.f468278d = true;
        r104.c();
        return;
    L11:
        r103 = null;
        goto L12
    }

    public PoiCoiImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263174g = new ColorDrawable(r100.getResources().getColor(R.color.BGPlaceholderDefault));
    }

    public /* synthetic */ PoiCoiImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
