package com.obric.assistant.settings.autogui;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b1 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<a, Boolean, Unit> f391910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f391911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OCardListItem f391912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f391913d;

    public final void T3(final c.b r100) {
        Intrinsics.checkNotNullParameter(r100, SlcFlexDirection.FLEX_ROW);
        OSwitch r101 = this.f391912c.getEndSwitch();
        if (r101 == null) goto L5;
        r101.setOnCheckedChangeListener(null);
    L5:
        if (r101 == null) goto L7;
        r101.setChecked(r100.f391916b);
    L7:
        if (r101 == null) goto L10;
        r101.setOnCheckedChangeListener(new a1(this, r100));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b1(y0 r100, Function2<? super a, ? super Boolean, Unit> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "saveStoredValue");
        super(r100);
        this.f391910a = r101;
        this.f391911b = r102;
        this.f391912c = r100.f391983a;
        this.f391913d = r100.f391984b;
    }
}
