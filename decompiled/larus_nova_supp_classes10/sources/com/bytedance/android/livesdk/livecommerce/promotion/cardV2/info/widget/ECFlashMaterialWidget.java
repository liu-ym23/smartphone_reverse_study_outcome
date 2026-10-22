package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECFlashMaterialWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/a;", "", "getCurrentContentDescription", "getType", "()Ljava/lang/String;", LocationMonitorConst.TYPE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFlashMaterialWidget extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {
    public List<String> a;
    public StringBuilder b;

    public static final class a {
    }

    static {
    }

    public ECFlashMaterialWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECFlashMaterialWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "flash_material_info";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.b;
        if (r0 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r0);
    }

    public final TextView a(String r3, int r4) {
        TextView r0 = new TextView(getContext());
        StringBuilder r1 = this.b;
        if (r1 == null) goto L5;
        r1.append(r3);
    L5:
        r0.setTag("text");
        r0.setText(r3);
        r0.setMaxLines(1);
        r0.setTextSize(1, 12.0f);
        r0.setTextColor(th.a.a(r0.getContext(), 2131106227));
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -2);
        if (r4 <= 0) goto L8;
        r5.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L8:
        Unit r6 = Unit.INSTANCE;
        r0.setLayoutParams(r5);
        return r0;
    }

    public ECFlashMaterialWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(0);
        setGravity(8388611);
    }

    public /* synthetic */ ECFlashMaterialWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        int r8 = getChildCount() - 1;
    L3:
        if (r8 < 0) goto L19;
        View r9 = getChildAt(r8);
        if (r9.getVisibility() == 8) goto L12;
        if ((r9.getLeft() + r9.getMeasuredWidth()) < getMeasuredWidth()) goto L10;
        r9.layout(r4, r5, r4, r7);
        goto L12
    L10:
        if (Intrinsics.areEqual(r9.getTag(), "divider") == false) goto L13;
        r9.layout(r4, r5, r4, r7);
        return;
    L13:
        return;
    L12:
        r8 = r8 - 1;
        goto L3
    }
}
