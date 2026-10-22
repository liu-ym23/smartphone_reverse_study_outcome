package com.larus.bmhome.top.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\n\u001a\u00020\u000b2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/top/view/BackTopButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "icon", "Landroid/widget/ImageView;", SendEventContainerMethodParamModel.EventKinds.onClick, "", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "it", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BackTopButton extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public BackTopButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public BackTopButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ImageView r102 = new ImageView(r100);
        if (getId() != (-1)) goto L5;
        r102.setId(R.id.back_top_button_icon);
    L5:
        r102.setImageResource(c.b(R.attr.larus_ic_back_top_button, r102.getContext(), R.drawable.larus_ic_back_top_button));
        int r103 = j0.f375426a;
        r102.setContentDescription(j0.d(R.string.larus_accessibility_returnToLastReading));
        addView(r102, new FrameLayout.LayoutParams(-1, -1));
        setBackgroundResource(R.drawable.larus_fast_button_bg_shadow);
    }
}
