package com.bytedance.ee.bear.templates.topic;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.facade.common.widget.NiceImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements RequestListener<Drawable> {
    public final /* synthetic */ BaseTopicView a;

    public d(BaseTopicView r1) {
        this.a = r1;
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
        this.a.c.findViewById(2131363914).setVisibility(8);
        tt5.a.e("BaseTopicView", " load iv fail", r1, false);
        return true;
    }

    public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        this.a.c.findViewById(2131363914).setVisibility(0);
        NiceImageView r6 = this.a.c.findViewById(2131363914);
        r6.setImageDrawable((Drawable) r1);
        return true;
    }
}
