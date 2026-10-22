package com.larksuite.component.ui.loading;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes24.dex */
public final class LKUIStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f284244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LKUILoadingView f284245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f284246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f284247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f284248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f284249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CharSequence f284250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f284251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f284252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f284253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f284254k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUIStatus f284255a;

        @Override // java.lang.Runnable
        public final void run() {
            LKUIStatus r100 = this.f284255a;     // Catch: Throwable -> L7
            if (r100.f284252i != 3) goto L10;
            r100.e();     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }

        public a(LKUIStatus r100) {
            this.f284255a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f284256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f284257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f284258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f284259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f284260e;

        public b(ViewGroup r100) {
            this.f284256a = r100;
        }
    }

    public final void a() {
        LKUILoadingView r100 = this.f284245b;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
        this.f284245b.cancelAnimation();
    L5:
        View r101 = this.f284248e;
        if (r101 == null) goto L10;
        ViewParent r102 = r101.getParent();
        if (r102 == null) goto L10;
        ((ViewGroup) r102).removeView(this.f284248e);
    L10:
        this.f284252i = 1;
        this.f284244a.removeCallbacks(this.f284254k);
    }

    public final void b() {
        LKUILoadingView r100 = this.f284245b;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
        this.f284245b.cancelAnimation();
    L5:
        View r101 = this.f284248e;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        this.f284252i = 6;
        this.f284244a.removeCallbacks(this.f284254k);
    }

    public final void c() {
        if (this.f284248e != null) goto L10;
        View r100 = LayoutInflater.from(this.f284244a.getContext()).inflate(R.layout.lkui_loading_status_layout, null);
        this.f284248e = r100;
        View r101 = r100.findViewById(R.id.lkui_load_content_ll);
        this.f284245b = (LKUILoadingView) this.f284248e.findViewById(R.id.lkui_loading_view);
        this.f284246c = (TextView) this.f284248e.findViewById(R.id.lkui_load_status_tv);
        this.f284247d = (ImageView) this.f284248e.findViewById(R.id.lkui_load_status_iv);
        ViewGroup r102 = this.f284244a;
        float r103 = this.f284253j;
        if (Boolean.TRUE.equals(null) == false) goto L7;
        long r104 = 250;
    L8:
        r102.postDelayed(new d08.a(r101, r103), r104);
        goto L10
    L7:
        r104 = 0;
    L10:
        if (this.f284248e.getParent() != null) goto L12;
        ViewGroup.LayoutParams r105 = new ViewGroup.LayoutParams(-1, -1);
        this.f284244a.addView(this.f284248e, r105);
    L12:
        this.f284248e.setBackgroundResource(R.color.bg_body);
    }

    public final void e() {
        CharSequence r100 = this.f284249f;
        c();
        this.f284248e.setVisibility(0);
        this.f284245b.setVisibility(0);
        this.f284245b.playAnimation();
        this.f284247d.setVisibility(8);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f284246c.setVisibility(8);
    L6:
        this.f284252i = 2;
        return;
    L5:
        this.f284246c.setText(r100);
        this.f284246c.setVisibility(0);
        goto L6
    }

    public LKUIStatus(b r100) {
        this.f284252i = 1;
        this.f284253j = -1.0f;
        this.f284254k = new a(this);
        this.f284244a = r100.f284256a;
        this.f284249f = r100.f284257b;
        this.f284250g = r100.f284258c;
        this.f284251h = r100.f284259d;
        this.f284253j = r100.f284260e;
    }

    public final void d(CharSequence r100, int r101) {
        this.f284252i = 4;
        this.f284244a.removeCallbacks(this.f284254k);
        c();
        this.f284248e.setVisibility(0);
        this.f284245b.setVisibility(8);
        this.f284245b.cancelAnimation();
        this.f284247d.setVisibility(0);
        this.f284247d.setImageResource(r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f284246c.setVisibility(8);
        return;
    L5:
        this.f284246c.setText(r100);
        this.f284246c.setVisibility(0);
    }
}
