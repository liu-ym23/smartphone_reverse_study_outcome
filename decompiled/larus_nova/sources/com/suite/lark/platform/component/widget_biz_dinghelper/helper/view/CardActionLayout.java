package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.component.autolinearlayout.AutoLinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/CardActionLayout;", "Lcom/larksuite/component/autolinearlayout/AutoLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardActionLayout extends AutoLinearLayout {
    public CardActionLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setDividerDrawable(AppCompatResources.getDrawable(r100, R.drawable.divider_card_action_layout));
        setShowDividers(2);
    }
}
