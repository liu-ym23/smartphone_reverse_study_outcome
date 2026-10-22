package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DiggLayout extends FrameLayout {
    public static final HashMap<String, Drawable> f = null;
    public final Queue<ImageView> a;
    public Context b;
    public int c;
    public int d;
    public Random e;

    static {
        f = new HashMap();
    }

    private Drawable getCommonDrawable() {
        HashMap<String, Drawable> r0 = f;
        Drawable r2 = r0.get("common");
        if (r2 == null) goto L5;
        return r2;
    L5:
        Drawable r3 = ContextCompat.getDrawable(this.b, 2131231389);
        r0.put("common", r3);
        return r3;
    }

    public DiggLayout(Context r3) {
        this(r3, null, 0);
    }

    public DiggLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(float r19, float r20) {
        if (this.a.isEmpty() == false) goto L5;
        ImageView r1 = new ImageView(this.b);
    L6:
        Drawable r2 = f.get("common");
        if (r2 != null) goto L9;
        r2 = getCommonDrawable();
    L9:
        r1.setImageDrawable(r2);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(this.d, this.c);
        r3.setMargins((int) (r19 - (this.d / 2)), (int) (r20 - this.c), 0, 0);
        r1.setLayoutParams(r3);
        if (r1.getParent() != null) goto L12;
        addView(r1);
    L12:
        float r4 = this.e.nextInt(40) - 20;
        r1.setRotation(r4);
        AnimationSet r5 = new AnimationSet(false);
        ScaleAnimation r6 = new ScaleAnimation(1.6f, 1.0f, 1.6f, 1.0f, 1, 0.5f, 1, 0.5f);
        r6.setFillAfter(true);
        r6.setInterpolator(new OvershootInterpolator());
        r6.setFillBefore(true);
        r6.setDuration(300);
        AnimationSet r7 = new AnimationSet(true);
        r7.setDuration(500);
        r7.setStartOffset(500);
        r7.setFillAfter(true);
        r7.setInterpolator(new DecelerateInterpolator());
        float r13 = (this.e.nextInt(10) + 20.0f) / 10.0f;
        ScaleAnimation r8 = new ScaleAnimation(1.6f, r13, 1.6f, r13, 1, 0.5f, 1, 1.0f);
        AlphaAnimation r9 = new AlphaAnimation(1.0f, 0.0f);
        int r10 = (int) n0.a(this.b, 50.0f);
        float r11 = -(this.e.nextInt(r10) + r10);
        TranslateAnimation r12 = new TranslateAnimation(0.0f, (float) (((double) r11) * Math.tan((((double) r4) * 3.141592653589793d) / 360.0d)), 0.0f, r11);
        r7.addAnimation(r8);
        r7.addAnimation(r9);
        r7.addAnimation(r12);
        r5.addAnimation(r6);
        r5.addAnimation(r7);
        r1.startAnimation(r5);
        r5.setAnimationListener(new c(this, r1));
        return;
    L5:
        r1 = (ImageView) ((LinkedList) this.a).poll();
        goto L6
    }

    public DiggLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new LinkedList();
        this.c = -1;
        this.d = -1;
        this.b = r1;
        this.e = new Random();
        this.d = x54.a.a(72);
        this.c = x54.a.a(79);
    }
}
