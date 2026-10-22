package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.widgets.AnchorV4GuessULikeSDKView;
import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements com.bytedance.android.shopping.api.mall.feed.f {
    public final /* synthetic */ AnchorV4GuessULikeVH a;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.shopping.api.mall.feed.d r0 = this.a.a.u;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public d(AnchorV4GuessULikeVH r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.f
    public final void a(ECMallFeedState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        int r5 = c.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        AnchorV4GuessULikeVH r6 = this.a;
        if (r6.m == true) goto L24;
        r6.m = true;
        r6.c4();
        return;
    L24:
        return;
    L5:
        if (r5 != 4) goto L7;
    L9:
        AnchorV4GuessULikeVH r7 = this.a;
        if (r7.o == true) goto L22;
        AnchorV4GuessULikeSDKView r8 = r7.p;
        if (r8 == null) goto L15;
        ViewGroup.LayoutParams r1 = r8.getLayoutParams();
        r1.height = -1;
        r8.setLayoutParams(r1);
    L15:
        if (this.a.t.pageStatus().w == false) goto L17;
        this.a.t.setGUIState();
        this.a.t.pageStatus().w = false;
    L17:
        this.a.t.pageStatus().x = true;
        ((RecyclerView.ViewHolder) this.a).itemView.post(new a(this));
        this.a.o = true;
        return;
    L22:
        return;
    L7:
        if (r5 == 5) goto L9;
    }
}
