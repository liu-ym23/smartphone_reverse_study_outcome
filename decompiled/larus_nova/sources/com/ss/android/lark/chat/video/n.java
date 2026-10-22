package com.ss.android.lark.chat.video;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: classes35.dex */
public final class n extends v0c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f416827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f416828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f416829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f416830h;

    public class a extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f416831a;

        public a(n r100) {
            this.f416831a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            View.OnClickListener r101 = this.f416831a.f416829g;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    @Override // v0c.o
    public final void g() {
    }

    @Override // v0c.a
    public final void k() {
        q(8);
        this.f416827e.setOnClickListener(new a(this));
        this.f416827e.findViewById(R.id.error_close).setOnClickListener(new m(this));
    }

    public n(FragmentActivity r100) {
        super(r100);
    }

    @Override // v0c.a
    public final View m(Context r100) {
        ViewGroup r101 = (ViewGroup) LayoutInflater.from(r100).inflate(R.layout.online_error_cover, null);
        this.f416827e = r101;
        this.f416830h = (TextView) r101.findViewById(R.id.video_error_tv);
        return this.f416827e;
    }

    @Override // v0c.b, v0c.o
    public final void a(int r100, Bundle r101) {
        q(8);
    }

    @Override // v0c.b, v0c.o
    public final void h(int r100, Bundle r101) {
        this.f416830h.setText(R.string.Lark_Legacy_RecallMessage);
        q(0);
    }
}
