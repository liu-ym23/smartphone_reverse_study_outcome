package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusFeedBackView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusFeedBackView extends ConstraintLayout {
    public HSImageView a;
    public HSImageView b;
    public HSImageView c;
    public HSImageView d;
    public HSImageView e;
    public HSImageView f;
    public HSImageView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;

    public RealTimeChorusFeedBackView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RealTimeChorusFeedBackView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealTimeChorusFeedBackView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567250, this);
        this.a = findViewById(2131372215);
        this.b = findViewById(2131372221);
        this.c = findViewById(2131372228);
        this.d = findViewById(2131372218);
        this.e = findViewById(2131372217);
        this.f = findViewById(2131372225);
        this.g = findViewById(2131372223);
        this.k = (TextView) findViewById(2131372216);
        this.l = (TextView) findViewById(2131372222);
        this.m = (TextView) findViewById(2131372229);
        this.n = (TextView) findViewById(2131372227);
        this.o = (TextView) findViewById(2131372226);
        this.p = (TextView) findViewById(2131372224);
        this.h = (ImageView) findViewById(2131365686);
        this.i = (ImageView) findViewById(2131365706);
        this.j = (ImageView) findViewById(2131365713);
    }

    public /* synthetic */ RealTimeChorusFeedBackView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
