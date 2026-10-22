package o93;

import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieAnimationView f522466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f522467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f522468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f522469d;

    public a(ViewGroup r100, com.bytedance.android.shopping.mall.homepage.card.loadview.a r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "retryClickListener");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ec_mall_feed_loading_layout, r100, false);
        this.f522466a = (LottieAnimationView) r102.findViewById(R.id.lv_feed_loading_slogan);
        this.f522467b = r102.findViewById(R.id.ll_feed_error_container);
        this.f522468c = r102.findViewById(R.id.ll_feed_empty_container);
        Button r103 = (Button) r102.findViewById(R.id.bt_feed_error_retry);
        if (r103 == null) goto L8;
        r103.setOnClickListener(r101);
        TextPaint r104 = r103.getPaint();
        if (r104 == null) goto L7;
        r104.setFakeBoldText(true);
    L7:
        Unit r105 = Unit.INSTANCE;
    L8:
        Unit r106 = Unit.INSTANCE;
        this.f522469d = r102;
    }
}
