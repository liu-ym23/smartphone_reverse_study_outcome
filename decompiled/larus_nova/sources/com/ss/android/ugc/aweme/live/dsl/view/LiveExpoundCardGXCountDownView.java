package com.ss.android.ugc.aweme.live.dsl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.api.GXICustomViewBindData;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.locallife.common.utils.k;
import com.bytedance.locallife.live.experiment.f0;
import com.bytedance.locallife.live.util.c;
import com.bytedance.locallife.live.view.LiveLifeCountDownView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/live/dsl/view/LiveExpoundCardGXCountDownView;", "Lcom/bytedance/locallife/live/view/LiveLifeCountDownView;", "Lcom/alibaba/gaiax/api/GXICustomViewBindData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onBindData", "", "data", "Lorg/json/JSONObject;", "setTv", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LiveExpoundCardGXCountDownView extends LiveLifeCountDownView implements GXICustomViewBindData {
    @Override // com.bytedance.locallife.live.view.LiveLifeCountDownView
    public void setTv() {
        super.setTv();
        final Ref.LongRef r100 = new Ref.LongRef();
        long r101 = getEnd() - (System.currentTimeMillis() - getCallTime());
        r100.element = r101;
        if (r101 >= 0) goto L5;
        r100.element = 0;
    L5:
        k.d(new AnonymousClass1(this, r100));
        if (f0.a() == false) goto L12;
        if (r100.element > 0) goto L15;
        c.a(this);
        return;
    L15:
        return;
    L12:
        if (r100.element <= 0) goto L16;
        k.a(getRunnable());
        k.c(getRunnable(), 1000);
        return;
    }

    public LiveExpoundCardGXCountDownView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.alibaba.gaiax.api.GXICustomViewBindData, com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(JSONObject r110) {
        FrameLayout.LayoutParams r100 = null;
        if (r110 != null) goto L20;
        Object r111 = null;
    L7:
        if ((r111 instanceof JSONObject) == false) goto L9;
        JSONObject r112 = (JSONObject) r111;     // Catch: Exception -> L19
    L10:
        if (r112 != null) goto L12;
        return;
    L12:
        long r101 = r112.optLong("count_down_seconds", 0);     // Catch: Exception -> L19
        setTextStyle(CustomHeaderConfig.COLOR_LIGHT, r112.optString("font_size", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));     // Catch: Exception -> L19
        ViewGroup.LayoutParams r113 = getTv().getLayoutParams();     // Catch: Exception -> L19
        if ((r113 instanceof FrameLayout.LayoutParams) == false) goto L15;
        r100 = (FrameLayout.LayoutParams) r113;     // Catch: Exception -> L19
    L15:
        if (r100 == null) goto L17;
        r100.gravity = GravityCompat.START;     // Catch: Exception -> L19
    L17:
        getTv().setLayoutParams(r100);     // Catch: Exception -> L19
        startCountDown(0, ((long) 1000) * r101, false);     // Catch: Exception -> L19
        return;
    L22:
        return;
    L9:
        r112 = null;
        goto L10
    L20:
        r111 = r110.opt("value");     // Catch: Exception -> L19
        goto L7
    }

    public LiveExpoundCardGXCountDownView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public LiveExpoundCardGXCountDownView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        getTv().setMaxLines(1);
    }
}
