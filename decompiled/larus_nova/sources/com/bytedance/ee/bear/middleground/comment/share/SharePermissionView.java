package com.bytedance.ee.bear.middleground.comment.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes18.dex */
public class SharePermissionView extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f232146e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f232147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f232148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f232149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f232150d;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharePermissionView f232151a;

        public a(SharePermissionView r100) {
            this.f232151a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f232151a.f232149c;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public final void a() {
        tt5.a.b("Comment#SharePermissionView", "initViews ");
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.comment_share_permission, this, true);
        this.f232147a = r100;
        this.f232148b = (TextView) r100.findViewById(R.id.tv_content);
        ((TextView) this.f232147a.findViewById(R.id.tv_confirm)).setOnClickListener(new a(this));
    }

    public SharePermissionView(Context r100) {
        super(r100);
        this.f232149c = null;
        this.f232150d = null;
        a();
    }

    public void setConfirmCallback(View.OnClickListener r100) {
        this.f232149c = r100;
    }

    public void setContent(String r100) {
        this.f232148b.setText(r100);
    }

    public SharePermissionView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f232149c = null;
        this.f232150d = null;
        a();
    }

    public SharePermissionView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f232149c = null;
        this.f232150d = null;
        a();
    }
}
