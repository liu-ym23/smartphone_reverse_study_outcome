package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/NumberScrollContainer;", "Landroid/widget/LinearLayout;", "", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/customview/NumberScrollView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/List;", "getNumebers", "()Ljava/util/List;", "setNumebers", "(Ljava/util/List;)V", "numebers", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NumberScrollContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<NumberScrollView> f450205a;

    public final List<NumberScrollView> getNumebers() {
        return this.f450205a;
    }

    public NumberScrollContainer(Context r100) {
        this(r100, null);
    }

    public final void setNumebers(List<NumberScrollView> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f450205a = r100;
    }

    public NumberScrollContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f450205a = new ArrayList();
    }
}
