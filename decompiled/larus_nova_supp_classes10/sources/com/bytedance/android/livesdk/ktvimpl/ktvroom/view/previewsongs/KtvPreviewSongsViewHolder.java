package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/previewsongs/KtvPreviewSongsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvPreviewSongsViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int e = 0;
    public final HSImageView a;
    public final TextView b;
    public final TextView c;
    public long d;

    public static final class a {
    }

    static {
    }

    public final void T3() {
        this.c.setText(s1.B(2131918625));
        this.c.setClickable(true);
    }

    public KtvPreviewSongsViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131386548);
        this.b = (TextView) r2.findViewById(2131386980);
        this.c = (TextView) r2.findViewById(2131365679);
    }

    public final void U3(boolean r2) {
        if (r2 == false) goto L4;
        AbstractDraweeController r3 = Fresco.newDraweeControllerBuilder().setUri("asset://com.ss.android.ies.live.sdk/ttlive_ktv_singing.webp").setOldController(this.a.getController()).setAutoPlayAnimations(true).build();
        this.a.setController(r3);
        this.a.setVisibility(0);
        a1.m(this.b, s1.f(8.0f));
        this.b.setMaxWidth(s1.f(134.0f));
        return;
    L4:
        DraweeController r4 = this.a.getController();
        if (r4 == null) goto L9;
        Animatable r5 = r4.getAnimatable();
        if (r5 == null) goto L9;
        r5.stop();
    L9:
        this.a.setVisibility(8);
        a1.m(this.b, s1.f(12.0f));
        this.b.setMaxWidth(s1.f(158.0f));
    }
}
