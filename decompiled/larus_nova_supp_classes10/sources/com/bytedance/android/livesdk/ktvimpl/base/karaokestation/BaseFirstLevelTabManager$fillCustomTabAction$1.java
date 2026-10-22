package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.content.Context;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "firstLevelTabFragmentName", "", "firstLevelTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "context", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 5, 1})
public final class BaseFirstLevelTabManager$fillCustomTabAction$1 extends Lambda implements Function3<String, TabLayout, Context, Unit> {
    final /* synthetic */ BaseFirstLevelTabManager this$0;

    public BaseFirstLevelTabManager$fillCustomTabAction$1(BaseFirstLevelTabManager r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(String r4, TabLayout r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "firstLevelTabFragmentName");
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r4, "firstLevelTabFragmentName");
        if (r6 == null) goto L6;
        if (r5 == null) goto L6;
        CustomViewTab r0 = new CustomViewTab(r6);
        r0.setTabName(r4);
        r0.b.setTextSize(1, 15.0f);
        r0.R5(com.bytedance.android.live.ktv.common.util.f.a(r6, r0.b), "YellowDotView");
        r5.addTab(r5.newTab().setCustomView(r0), false);
    L6:
        BaseFirstLevelTabManager r7 = this.this$0;
        if (r7.e != null) goto L10;
        r7.e = r5;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((String) r1, (TabLayout) r2, (Context) r3);
        return Unit.INSTANCE;
    }
}
