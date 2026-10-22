package com.bytedance.android.livesdk.ktvimpl.ksong.base.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.config.a51;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import ge2.b;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ksong/base/view/AbsKSongScoreFinishFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsKSongScoreFinishFragment extends LiveDialogFragment {
    public Disposable d;
    public HSImageView e;
    public TextView f;

    public abstract Disposable S90();

    public float T90() {
        return 0.0f;
    }

    public void U90(String r1) {
    }

    public AbsKSongScoreFinishFragment() {
        setNoTitleAndCancelOutside(true);
    }

    public void initViews() {
        float r0 = T90();
        Map<String, Integer> r1 = b.a;
        String r3 = null;
        Iterator r2 = ((List) h.I2.getValue(null, h.a[189(0xbd, float:2.65E-43)])).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        a51 r4 = (a51) r2.next();
        if (r0 > r4.c()) goto L4;
        if (r0 < r4.d()) goto L4;
        Pair r5 = TuplesKt.to(r4.e(), r4.f());
    L11:
        HSImageView r6 = this.e;
        if (r6 == null) goto L19;
        PipelineDraweeControllerBuilder r7 = Fresco.newDraweeControllerBuilder();
        if (r5 == null) goto L17;
        String r8 = (String) r5.getSecond();
        if (r8 == null) goto L17;
    L18:
        r6.setController(r7.setUri(UriProtector.parse(r8)).setAutoPlayAnimations(true).build());
    L17:
        r8 = "";
    L19:
        this.d = S90();
        if (r5 == null) goto L22;
        r3 = (String) r5.getFirst();
    L22:
        U90(r3);
        return;
    L10:
        r5 = null;
        goto L11
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L8;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L9;
        r6.setGravity(48);
        r6.clearFlags(DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION);
        WindowManager.LayoutParams r0 = r6.getAttributes();
        r0.width = s1.y();
        r0.height = s1.y();
        r0.y = s1.f(167.0f) - s1.A();
        Unit r1 = Unit.INSTANCE;
        r6.setAttributes(r0);
        return;
    L9:
        return;
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954698);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        initViews();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565573, r3, false);
        this.e = r5.findViewById(2131376973);
        this.f = (TextView) r5.findViewById(2131376944);
        return r5;
    }
}
