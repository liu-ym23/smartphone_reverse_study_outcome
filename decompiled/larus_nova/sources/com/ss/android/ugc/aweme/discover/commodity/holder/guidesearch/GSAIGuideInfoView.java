package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.commodity.helper.ECSearchResourceHelper;
import com.ss.android.ugc.aweme.search.ecommerce.api.srp.ECSearchBizScene;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GSAIGuideInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GSAIGuideInfoView extends ConstraintLayout {
    public GSAIGuideInfoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GSAIGuideInfoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public GSAIGuideInfoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ECSearchResourceHelper r103 = ECSearchResourceHelper.f450039b;
        r103.getClass();
        DimenExtensionsKt.b(Float.valueOf(ECSearchResourceHelper.b(r103, ECSearchResourceHelper.ECSearchTokenKey.ECSearch3XModulePaddingToken)));
        DimenExtensionsKt.b(Float.valueOf(r103.a()));
        DimenExtensionsKt.b(10);
        DimenExtensionsKt.b(7);
        DimenExtensionsKt.b(11);
        DimenExtensionsKt.b(7);
        DimenExtensionsKt.b(2);
        DimenExtensionsKt.b(27);
        DimenExtensionsKt.b(1);
        ColorProtector.parseColor("#73161823");
        ECSearchBizScene r104 = ECSearchBizScene.HYBRID_SEARCH;
        LayoutInflater.from(r100).inflate(R.layout.search_ecommerce_gs_ai_guide_info, this, true);
        ConstraintLayout r105 = (ConstraintLayout) findViewById(R.id.gs_ai_info_container);
        DmtTextView r106 = (DmtTextView) findViewById(R.id.ai_summary_text);
        DmtTextView r107 = (DmtTextView) findViewById(R.id.ai_guide_text);
        SmartImageView r108 = (SmartImageView) findViewById(R.id.ai_right_icon);
        SmartImageView r109 = (SmartImageView) findViewById(R.id.ai_left_icon);
        ConstraintLayout r110 = (ConstraintLayout) findViewById(R.id.ai_guide_wrapper);
    }

    public /* synthetic */ GSAIGuideInfoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
