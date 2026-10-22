package com.bytedance.android.livesdk.livecommerce.playback.authorinfo;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends RelativeLayout {
    public final TextView a;
    public final ExplainPlaybackViewModel b;

    public final void setTextAndVisible(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        if (TextUtils.isEmpty(r3) == true) goto L6;
        this.a.setVisibility(0);
        this.a.setText(r3);
        return;
    }

    public c(Context r3, ExplainPlaybackViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "explainViewModel");
        super(r3, null, 0);
        this.b = r4;
        Object r5 = r3.getSystemService("layout_inflater");
        if (r5 == null) goto L7;
        ((LayoutInflater) r5).inflate(2131560699, this, true);
        this.a = (TextView) findViewById(2131381480);
        ((ImageView) findViewById(2131366999)).setOnClickListener(new b(this, r3));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
