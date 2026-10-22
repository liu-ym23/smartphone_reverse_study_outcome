package com.bytedance.ee.bear.middleground.comment.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SharePermissionView extends FrameLayout {
    public static final /* synthetic */ int e = 0;
    public View a;
    public TextView b;
    public View.OnClickListener c;
    public Disposable d;

    public class a implements View.OnClickListener {
        public final /* synthetic */ SharePermissionView a;

        public a(SharePermissionView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public final void a() {
        tt5.a.b("Comment#SharePermissionView", "initViews ");
        View r0 = LayoutInflater.from(getContext()).inflate(2131559870, this, true);
        this.a = r0;
        this.b = (TextView) r0.findViewById(2131390392);
        ((TextView) this.a.findViewById(2131390381)).setOnClickListener(new a(this));
    }

    public SharePermissionView(Context r1) {
        super(r1);
        this.c = null;
        this.d = null;
        a();
    }

    public void setConfirmCallback(View.OnClickListener r1) {
        this.c = r1;
    }

    public void setContent(String r2) {
        this.b.setText(r2);
    }

    public SharePermissionView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = null;
        this.d = null;
        a();
    }

    public SharePermissionView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = null;
        this.d = null;
        a();
    }
}
