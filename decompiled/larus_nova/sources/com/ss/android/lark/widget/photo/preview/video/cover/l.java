package com.ss.android.lark.widget.photo.preview.video.cover;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.photo.preview.video.online.f0;

/* JADX INFO: loaded from: classes38.dex */
public final class l extends v0c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f447216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f447217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f447218g;

    public class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }

        public a() {
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f447219a;

        public b(l r100) {
            this.f447219a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f447219a.f447218g;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public interface c {
    }

    @Override // v0c.o
    public final void g() {
    }

    @Override // v0c.a
    public final void k() {
        q(8);
        this.f447216e.setOnClickListener(new a());
        this.f447216e.findViewById(R.id.error_close).setOnClickListener(new b(this));
    }

    public l(FragmentActivity r100) {
        super(r100);
    }

    @Override // v0c.a
    public final View m(Context r100) {
        ViewGroup r101 = (ViewGroup) LayoutInflater.from(r100).inflate(R.layout.online_error_cover, null);
        this.f447216e = r101;
        return r101;
    }

    @Override // v0c.b, v0c.o
    public final void a(int r100, Bundle r101) {
        q(8);
    }

    @Override // v0c.b, v0c.o
    public final void h(int r100, Bundle r101) {
        Log.i("OnlineErrorCover", "onErrorEvent:" + r100);
        if (r100 == (-88019)) goto L5;
        LKUIToast.show(getContext(), R.string.Lark_Legacy_RecallMessage);
        return;
    L5:
        String r102 = r101.getString("string_data");
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return;
    L8:
        if (r102.contains("HTTP/1.1 410 Gone") == false) goto L16;
        c r103 = this.f447217f;
        if (r103 == null) goto L12;
        final f0 r104 = ((com.ss.android.lark.widget.photo.preview.video.online.s) r103).f447382a;
        r104.getClass();
        RxScheduledExecutor.justInIO(new com.ss.android.lark.widget.photo.preview.video.online.n(r104));
    L12:
        q(0);
        return;
    }
}
