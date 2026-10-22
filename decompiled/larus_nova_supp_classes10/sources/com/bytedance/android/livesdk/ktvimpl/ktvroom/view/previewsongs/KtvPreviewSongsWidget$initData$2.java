package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;
import pd2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvPreviewSongsWidget$initData$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public KtvPreviewSongsWidget$initData$2(KtvPreviewSongsWidget r8) {
        super(1, r8, KtvPreviewSongsWidget.class, "onKtvPreviewSongsShown", "onKtvPreviewSongsShown(Z)V", 0);
    }

    public final void invoke(boolean r7) {
        KtvPreviewSongsWidget r0 = (KtvPreviewSongsWidget) ((CallableReference) this).receiver;
        int r1 = KtvPreviewSongsWidget.k;
        r0.getClass();
        ALogger.d(KtvPreviewSongsViewModel.TAG, "onKtvPreviewSongsShown: " + r7);
        if (r7 == true) goto L5;
        ((Widget) r0).contentView.setVisibility(8);
        return;
    L5:
        if (((Widget) r0).contentView.getVisibility() == 0) goto L9;
        d.n.getClass();
        d.w(LinkMonitorData.BusinessShowColdPreview, new JSONObject());
        ((Widget) r0).contentView.setVisibility(0);
        AlphaAnimation r8 = new AlphaAnimation(0.0f, 1.0f);
        r8.setDuration((long) 271.25d);
        r8.setStartOffset((long) 250.0d);
        TranslateAnimation r2 = new TranslateAnimation(0.0f, 0.0f, s1.f(140.0f), 0.0f);
        r2.setDuration((long) 521.25d);
        AnimationSet r3 = new AnimationSet(false);
        r3.addAnimation(r8);
        r3.addAnimation(r2);
        ((Widget) r0).contentView.startAnimation(r3);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
