package com.ss.android.ugc.aweme.search.vision.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.result.abtest.PhotoSearchV2700UiExperiment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B%\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0010\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/widget/header/AppBarHeaderLevelViewContainer;", "Landroid/widget/LinearLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "channel", "b", "getSearchEntrance", "setSearchEntrance", "searchEntrance", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppBarHeaderLevelViewContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f454104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f454105b;

    public final String getChannel() {
        return this.f454104a;
    }

    public final String getSearchEntrance() {
        return this.f454105b;
    }

    public AppBarHeaderLevelViewContainer(Context r100) {
        super(r100);
        this.f454104a = "";
        this.f454105b = "";
    }

    public final void setChannel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454104a = r100;
    }

    public final void setSearchEntrance(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f454105b = r100;
    }

    public AppBarHeaderLevelViewContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f454104a = "";
        this.f454105b = "";
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getChildCount() <= 0) goto L6;
        PhotoSearchV2700UiExperiment r102 = PhotoSearchV2700UiExperiment.f453677a;
        String r103 = this.f454104a;
        String r104 = this.f454105b;
        r102.getClass();
        PhotoSearchV2700UiExperiment.a(r103, r104);
        setMinimumHeight(getChildAt(0).getMeasuredHeight());
        return;
    }

    public AppBarHeaderLevelViewContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f454104a = "";
        this.f454105b = "";
    }
}
