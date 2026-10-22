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
import com.larus.nova.R;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* JADX INFO: loaded from: classes14.dex */
public class DiggLayout extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<String, Drawable> f193148f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<ImageView> f193149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f193150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f193151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f193152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Random f193153e;

    static {
        f193148f = new HashMap();
    }

    private Drawable getCommonDrawable() {
        HashMap<String, Drawable> r100 = f193148f;
        Drawable r101 = r100.get("common");
        if (r101 == null) goto L5;
        return r101;
    L5:
        Drawable r102 = ContextCompat.getDrawable(this.f193150b, R.drawable.aos_business_ic_home_biglike);
        r100.put("common", r102);
        return r102;
    }

    public DiggLayout(Context r100) {
        this(r100, null, 0);
    }

    public DiggLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(float r110, float r210) {
        if (this.f193149a.isEmpty() == false) goto L5;
        ImageView r100 = new ImageView(this.f193150b);
    L6:
        Drawable r101 = f193148f.get("common");
        if (r101 != null) goto L9;
        r101 = getCommonDrawable();
    L9:
        r100.setImageDrawable(r101);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(this.f193152d, this.f193151c);
        r102.setMargins((int) (r110 - (this.f193152d / 2)), (int) (r210 - this.f193151c), 0, 0);
        r100.setLayoutParams(r102);
        if (r100.getParent() != null) goto L12;
        addView(r100);
    L12:
        float r103 = this.f193153e.nextInt(40) - 20;
        r100.setRotation(r103);
        AnimationSet r104 = new AnimationSet(false);
        ScaleAnimation r105 = new ScaleAnimation(1.6f, 1.0f, 1.6f, 1.0f, 1, 0.5f, 1, 0.5f);
        r105.setFillAfter(true);
        r105.setInterpolator(new OvershootInterpolator());
        r105.setFillBefore(true);
        r105.setDuration(300);
        AnimationSet r106 = new AnimationSet(true);
        r106.setDuration(500);
        r106.setStartOffset(500);
        r106.setFillAfter(true);
        r106.setInterpolator(new DecelerateInterpolator());
        float r111 = (this.f193153e.nextInt(10) + 20.0f) / 10.0f;
        ScaleAnimation r107 = new ScaleAnimation(1.6f, r111, 1.6f, r111, 1, 0.5f, 1, 1.0f);
        AlphaAnimation r108 = new AlphaAnimation(1.0f, 0.0f);
        int r109 = (int) n0.a(this.f193150b, 50.0f);
        float r112 = -(this.f193153e.nextInt(r109) + r109);
        TranslateAnimation r113 = new TranslateAnimation(0.0f, (float) (((double) r112) * Math.tan((((double) r103) * 3.141592653589793d) / 360.0d)), 0.0f, r112);
        r106.addAnimation(r107);
        r106.addAnimation(r108);
        r106.addAnimation(r113);
        r104.addAnimation(r105);
        r104.addAnimation(r106);
        r100.startAnimation(r104);
        r104.setAnimationListener(new c(this, r100));
        return;
    L5:
        r100 = (ImageView) ((LinkedList) this.f193149a).poll();
        goto L6
    }

    public DiggLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193149a = new LinkedList();
        this.f193151c = -1;
        this.f193152d = -1;
        this.f193150b = r100;
        this.f193153e = new Random();
        this.f193152d = x54.a.a(72);
        this.f193151c = x54.a.a(79);
    }
}
