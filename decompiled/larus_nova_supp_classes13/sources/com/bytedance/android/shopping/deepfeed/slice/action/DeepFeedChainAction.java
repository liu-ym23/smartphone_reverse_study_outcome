package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedChainAction extends b {
    public Map<String, ? extends Object> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/action/DeepFeedChainAction$MergedAction;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "originAction", "params", "", "", "", "(Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;)V", "actions", "", "getActions", "()Ljava/util/List;", "disable", "", "getDisable", "()Z", "exposureThreshold", "", "getExposureThreshold", "()F", "getParams", "()Ljava/util/Map;", "scrollCallbackThreshold", "", "getScrollCallbackThreshold", "()J", "type", "getType", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MergedAction implements IAction {
        private final List<IAction> actions;
        private final boolean disable;
        private final float exposureThreshold;
        private final IAction originAction;
        private final Map<String, Object> params;
        private final long scrollCallbackThreshold;
        private final String type;

        public List<IAction> getActions() {
            return this.actions;
        }

        public boolean getDisable() {
            return this.disable;
        }

        public float getExposureThreshold() {
            return this.exposureThreshold;
        }

        public Map<String, Object> getParams() {
            return this.params;
        }

        public long getScrollCallbackThreshold() {
            return this.scrollCallbackThreshold;
        }

        public String getType() {
            return this.type;
        }

        public MergedAction(IAction r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r3, "originAction");
            Intrinsics.checkNotNullParameter(r4, "params");
            this.originAction = r3;
            this.params = r4;
            this.type = r3.getType();
            this.disable = r3.getDisable();
            this.exposureThreshold = r3.getExposureThreshold();
            this.scrollCallbackThreshold = r3.getScrollCallbackThreshold();
            this.actions = r3.getActions();
        }
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a, com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void b(Map r1) {
        this.d = r1;
    }

    public DeepFeedChainAction(DeepFeedSlcCardContainer r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "name");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a, com.bytedance.android.shopping.deepfeed.slice.action.v
    public final boolean m(IAction r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "targetView");
        Map<String, ? extends Object> r0 = this.d;
        if (r0 != null) goto L5;
    L10:
        v r1 = this.a;
        if (r1 != null) goto L15;
        return false;
    L15:
        return r1.m(r4, r5);
    L5:
        if ((!r0.isEmpty()) == false) goto L10;
        LinkedHashMap r2 = new LinkedHashMap();
        Map r3 = r4.getParams();
        if (r3 == null) goto L9;
        r2.putAll(r3);
    L9:
        r2.putAll(r0);
        r4 = new MergedAction(r4, r2);
        goto L10
    }
}
