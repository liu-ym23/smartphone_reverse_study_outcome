package com.bytedance.awemeopen.apps.framework.feed.ui.information.camera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import r14.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, h> {
    public ViewGroup e;
    public AoImageView f;
    public DmtTextView g;
    public DmtTextView h;
    public DmtTextView i;
    public List<w> j;
    public w k;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        h r0 = (h) this.c;
        Observer<List<w>> r1 = new d(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(getContext()).inflate(2131558606, r4, false);
    }

    public f(Context r2, g r3, h r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        Intrinsics.checkNotNullParameter(r5, "contentScene");
        super(r2, r3, r4);
    }
}
