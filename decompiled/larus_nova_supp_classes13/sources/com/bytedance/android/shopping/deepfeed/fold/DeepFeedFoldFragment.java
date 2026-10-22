package com.bytedance.android.shopping.deepfeed.fold;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.shopping.deepfeed.DeepFeedProductFragment;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedProductDataCenter;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.repo.l;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/fold/DeepFeedFoldFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedFoldFragment extends Fragment {

    public static final class a {
    }

    static {
    }

    public DeepFeedFoldFragment() {
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        String r0 = null;
        if (r5 == null) goto L5;
        String r6 = r5.getString("deep_feed_param_cache_key");
    L7:
        if (r6 == null) goto L18;
        HashMap<String, l> r2 = DeepFeedProductDataCenter.a;
        Intrinsics.checkNotNullParameter(r6, "key");
        DeepFeedQueryParam r7 = DeepFeedProductDataCenter.b.get(r6);
        if (r7 != null) goto L26;
        Bundle r8 = getArguments();
        if (r8 == null) goto L13;
        Serializable r9 = r8.getSerializable("deep_feed_query_params");
    L15:
        if ((r9 instanceof DeepFeedQueryParam) == true) goto L17;
        r9 = null;
    L17:
        r7 = (DeepFeedQueryParam) r9;
        goto L26
    L13:
        r9 = null;
    L26:
        BtmSDK r1 = BtmSDK.INSTANCE;
        if (r7 == null) goto L29;
        r0 = r7.getSourceBtmToken();
    L29:
        r1.registerBtmPageOnCreate(this, "a1.b811296.c0.d0", r0);
        return;
    L18:
        Bundle r10 = getArguments();
        if (r10 == null) goto L21;
        Serializable r11 = r10.getSerializable("deep_feed_query_params");
    L23:
        if ((r11 instanceof DeepFeedQueryParam) == true) goto L25;
        r11 = null;
    L25:
        r7 = (DeepFeedQueryParam) r11;
        goto L26
    L21:
        r11 = null;
        goto L23
    L5:
        r6 = null;
        goto L7
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        super.onViewCreated(r4, r5);
        Fragment r6 = getChildFragmentManager().findFragmentById(2131372737);
        if ((r6 instanceof DeepFeedProductFragment) == true) goto L5;
        r6 = null;
    L5:
        DeepFeedProductFragment r7 = (DeepFeedProductFragment) r6;
        if (r7 != null) goto L8;
        r7 = new DeepFeedProductFragment();
        r7.setArguments(getArguments());
    L8:
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131372737) == true) goto L12;
        r0 = r0.replace(2131372737, r7);
    L12:
        r0.commitAllowingStateLoss();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        super.onCreateView(r2, r3, r4);
        Context r5 = getContext();
        if (r5 == null) goto L7;
        Context r6 = th.a.e(r5, true);
        if (r6 == null) goto L7;
        return th.a.c(r6, 2131564646, r3, false);
    L7:
        return null;
    }
}
