package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.Switch;
import com.bytedance.android.live.core.utils.s1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/SwitchFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SwitchFrameLayout extends FrameLayout {
    public SwitchFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SwitchFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent r4) {
        super.onPopulateAccessibilityEvent(r4);
        boolean r0 = false;
        View r1 = getChildAt(0);
        if ((r1 instanceof Switch) == true) goto L5;
        r1 = null;
    L5:
        Switch r2 = (Switch) r1;
        if (r2 == null) goto L8;
        r0 = r2.isChecked();
    L8:
        String r3 = s1.B(2131918342);
        String r5 = s1.B(2131918341);
        if (r0 == true) goto L12;
        r3 = r5;
    L12:
        if (r4 == null) goto L17;
        List<CharSequence> r6 = r4.getText();
        if (r6 == null) goto L18;
        r6.add(r3);
        return;
    L18:
        return;
    }

    public SwitchFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ SwitchFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
