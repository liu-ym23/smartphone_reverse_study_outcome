package com.bytedance.android.shopping.widget.rittag.viewimpl;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.response.RitTagUI;
import com.bytedance.android.shopping.widget.rittag.RitTagPart;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends ECDraweeView implements com.bytedance.android.shopping.widget.rittag.b {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.widget.rittag.viewimpl.a$a, reason: collision with other inner class name */
    public static final class C0023a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final View i() {
        return this;
    }

    public a(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, null, 0, 6, null);
        setAdjustMode(1);
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final void l(RitTagUI.RitTagUIItem r10, RitTagPart r11) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "part");
        h0.d(this, r10.getImage(), null, null, null, null, null, 120);
    }
}
