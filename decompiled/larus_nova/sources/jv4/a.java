package jv4;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.bitable.common.e;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.MenuItemView;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import eu5.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f500553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f500554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MenuItemView f500555c;

    public a(gv4.a r100, SimpleItemModel r101, MenuItemView r102) {
        this.f500553a = r100;
        this.f500554b = r101;
        this.f500555c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f500553a.a(new Action(this.f500554b.getId(), this.f500554b.getClickAction()));
        Context r101 = this.f500555c.getContext();
        int r102 = e.f209809a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        h.a(r101, 10, 50);
    }
}
