package com.bytedance.android.window.shop.widget;

import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class ClickSeparatedTabSelectListener implements ECTabLayout.OnTabSelectedListener {
    public final Map<ECTabLayout.Tab, Boolean> a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ClickSeparatedTabSelectListener$ActionType;", "", "SCROLL", "CLICK", "NONE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CLICK = null;
        public static final ActionType NONE = null;
        public static final ActionType SCROLL = null;
        public static final /* synthetic */ ActionType[] a = null;

        static {
            ActionType r1 = new ActionType("SCROLL", 0);
            SCROLL = r1;
            ActionType r2 = new ActionType("CLICK", 1);
            CLICK = r2;
            ActionType r3 = new ActionType("NONE", 2);
            NONE = r3;
            a = new ActionType[]{r1, r2, r3};
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        public ActionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public void a(ECTabLayout.Tab r1, ActionType r2) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
    }

    public abstract void b(ECTabLayout.Tab r1, ActionType r2);

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(ECTabLayout.Tab r1) {
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final /* synthetic */ void onTabSelected(ECTabLayout.Tab r1, boolean r2) {
        ECTabLayout.BaseOnTabSelectedListener.CC.$default$onTabSelected(this, r1, r2);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(ECTabLayout.Tab r1) {
    }

    public ClickSeparatedTabSelectListener() {
        this.a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r5) {
        Map<ECTabLayout.Tab, Boolean> r0 = this.a;
        if (r0 == null) goto L27;
        boolean r1 = Intrinsics.areEqual((Boolean) TypeIntrinsics.asMutableMap(r0).remove(r5), Boolean.TRUE);
        if (r5 == null) goto L7;
        ECTabLayout.TabView r2 = r5.view;
    L8:
        if (r2 == null) goto L10;
        Object r3 = r2.getTag();
    L12:
        if ((r3 instanceof ActionType) == true) goto L14;
        r3 = null;
    L14:
        ActionType r4 = (ActionType) r3;
        if (r4 != null) goto L19;
        if (r1 == false) goto L18;
        r4 = ActionType.CLICK;
        goto L19
    L18:
        r4 = ActionType.SCROLL;
    L19:
        if (r5 == null) goto L21;
        ECTabLayout.TabView r6 = r5.view;
    L22:
        if (r6 == null) goto L24;
        r6.setTag(null);
    L24:
        b(r5, r4);
        return;
    L21:
        r6 = null;
        goto L22
    L10:
        r3 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
