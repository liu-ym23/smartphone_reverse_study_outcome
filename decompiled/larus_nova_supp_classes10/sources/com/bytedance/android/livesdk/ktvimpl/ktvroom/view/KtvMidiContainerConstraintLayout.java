package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.common.utility.DeviceUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvMidiContainerConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defaultAttrStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setBackgroundColor", "", "color", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMidiContainerConstraintLayout extends ConstraintLayout {
    public KtvMidiContainerConstraintLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvMidiContainerConstraintLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(int r6) {
        String r0 = Log.getStackTraceString(new Throwable());
        Lazy r1 = KtvSettingHelper.a;
        if (((Boolean) KtvSettingHelper.t0.getValue()).booleanValue() == true) goto L5;
    L9:
        super/*android.view.ViewGroup*/.setBackgroundColor(r6);
        return;
    L5:
        if (DeviceUtils.isVivo() == false) goto L9;
        if (StringsKt.contains$default(r0, "BackgroundOptimizer", false, 2, null) == false) goto L9;
    }

    public KtvMidiContainerConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ KtvMidiContainerConstraintLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
