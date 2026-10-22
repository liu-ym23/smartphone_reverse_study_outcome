package com.bytedance.awemeopen.apps.framework.base.view.xtoast;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import ay3.a;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import z04.c;

/* JADX INFO: loaded from: classes14.dex */
public final class XToast {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f193803j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f193804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f193805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f193806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f193807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f193808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimatorSet f193809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f193810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f193811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f193812i;

    @Retention(RetentionPolicy.SOURCE)
    public @interface XAnimation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface XDuration {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface XGravity {
    }

    public final void a() {
        Activity r100 = this.f193804a.get();
        if (r100 != null) goto L6;
        return;
    L6:
        if (f193803j != 0) goto L8;
        f193803j = c.a(r100);
    L8:
        View r101 = LayoutInflater.from(r100).inflate(R.layout.aos_layout_toast_for_d, null);
        this.f193806c = r101;
        View r102 = r101.findViewById(R.id.rl_rootview);
        this.f193806c.findViewById(R.id.iv_icon).setVisibility(8);
        TextView r103 = (TextView) this.f193806c.findViewById(R.id.tv_content);
        r103.setTextColor(ContextCompat.getColor(this.f193806c.getContext(), R.color.aos_const_text_inverse));
        r103.setText(this.f193812i);
        r102.setAlpha(1.0f);
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r102.getLayoutParams();
        int r105 = (int) n0.a(this.f193806c.getContext(), 16.0f);
        r104.leftMargin = r105;
        r104.rightMargin = r105;
        if (this.f193810g != 3) goto L11;
        r102.setBackgroundResource(R.drawable.aos_uikit_bg_new_toast_bg_douyin_22);
        r104.topMargin = f193803j + ((int) n0.a(this.f193806c.getContext(), 8.0f));
        r103.setMaxWidth((int) n0.a(this.f193806c.getContext(), 210.0f));
    L12:
        r102.setLayoutParams(r104);
        return;
    L11:
        r102.setBackgroundResource(R.drawable.aos_uikit_bg_new_toast_bg_douyin_12);
        goto L12
    }

    public final void b() {
        Activity r100 = this.f193804a.get();
        if (r100 == null) goto L14;
        this.f193805b = (ViewGroup) r100.findViewById(android.R.id.content);
        int r101 = this.f193810g;
        if (r101 != 1) goto L8;
        a();
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        r102.gravity = 17;
        this.f193806c.setLayoutParams(r102);
        goto L14
    L8:
        if (r101 == 2) goto L12;
        if (r101 != 3) goto L14;
        a();
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 49;
        this.f193806c.setLayoutParams(r103);
        goto L14
    L12:
        a();
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -2);
        r104.gravity = 81;
        r104.bottomMargin = (int) n0.a(this.f193806c.getContext(), 120.0f);
        this.f193806c.setLayoutParams(r104);
        this.f193807d = 3;
        this.f193811h = 3000;
    L14:
        int r105 = this.f193807d;
        if (r105 != 0) goto L17;
        this.f193808e = a.b(this, 0);
        this.f193809f = a.a(this, 0);
    L19:
        if (this.f193811h != 0) goto L21;
        this.f193811h = 2000;
    L21:
        ay3.c r106 = ay3.c.f16745b;
        monitor-enter(ay3.c.class);
    L30:
        th = move-exception;
        throw th;
    L24:
        if (ay3.c.f16745b != null) goto L26;
        ay3.c.f16745b = new ay3.c(Looper.getMainLooper());     // Catch: Throwable -> L30
    L26:
        ay3.c r107 = ay3.c.f16745b;     // Catch: Throwable -> L30
        monitor-exit(ay3.c.class);
        ((LinkedList) r107.f16746a).offer(this);
        r107.a();
        return;
    L17:
        this.f193808e = a.b(this, r105);
        this.f193809f = a.a(this, this.f193807d);
        goto L19
    }

    public XToast(Activity r100, String r101, int r102) {
        this.f193810g = 3;
        this.f193804a = new WeakReference(r100);
        this.f193812i = r101;
        this.f193810g = r102;
    }
}
