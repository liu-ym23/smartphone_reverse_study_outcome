package com.bytedance.android.livesdk.livecommerce.iron.listheader.entry;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.c;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends LinearLayout {
    public TextView a;
    public ECDraweeView b;
    public c c;
    public ECPromotionEntry d;
    public Map<String, String> e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.iron.listheader.entry.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC0069a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ a a;

        public ViewOnAttachStateChangeListenerC0069a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            this.a.setAttached(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            this.a.setAttached(false);
        }
    }

    public static final class b {
    }

    static {
    }

    public final void setAttached(boolean r1) {
    }

    public final Map<String, String> getParams() {
        return this.e;
    }

    public a(Context r3) {
        super(r3);
        setLayoutParams(new LinearLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(44)));
        setGravity(16);
        setOrientation(0);
        o0.c(this, 16);
        addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0069a(this));
    }

    public final void setParams(Map<String, String> r1) {
        this.e = r1;
    }
}
