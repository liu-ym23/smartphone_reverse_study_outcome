package com.bytedance.android.window.shop.holder;

import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends no.a<a> {
    public final ECWindowViewModel b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/holder/e$a;", "", "", "actionType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "actionParams", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class a {

        @SerializedName("action_params")
        private final Map<String, Object> actionParams;

        @SerializedName("action_type")
        private final String actionType;

        public final String toString() {
            return "PageEventAction(actionType=" + this.actionType + ", actionParams=" + this.actionParams + ')';
        }

        public final Map<String, Object> a() {
            return this.actionParams;
        }

        public final String b() {
            return this.actionType;
        }
    }

    public e(ECWindowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "windowViewModel");
        super("window_page_event");
        this.b = r2;
    }

    public final Object b(String r2) {
        return (a) u0.b(r2, a.class);
    }

    public final void a(View r3, Object r4) {
        a r5 = (a) r4;
        Intrinsics.checkNotNullParameter(r3, "view");
        if (r5 == null) goto L14;
        String r6 = r5.b();
        if (r6 == null) goto L16;
        Map<String, Object> r7 = r5.a();
        if (r7 == null) goto L17;
        Function1<hp3.b, Boolean> r0 = this.b.getEventDeliverer();
        if (r0 == null) goto L15;
        Boolean r8 = (Boolean) r0.invoke(new hp3.a(r6, r7));
        return;
    L15:
        return;
    L17:
        return;
    L16:
        return;
    }
}
