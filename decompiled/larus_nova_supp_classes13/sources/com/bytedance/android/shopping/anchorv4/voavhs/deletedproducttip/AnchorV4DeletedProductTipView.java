package com.bytedance.android.shopping.anchorv4.voavhs.deletedproducttip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/deletedproducttip/AnchorV4DeletedProductTipView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DeletedProductTipView extends LinearLayout {
    public Map<Integer, View> a;

    public final View a() {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = (View) ((LinkedHashMap) this.a).get(2131368802);
        if (r0 != null) goto L12;
        View r1 = findViewById(2131368802);
        if (r1 == null) goto L10;
        this.a.put(2131368802, r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public AnchorV4DeletedProductTipView(Context r2) {
        this(r2, null);
    }

    public AnchorV4DeletedProductTipView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131564601, this, true);
        setOrientation(1);
    }
}
