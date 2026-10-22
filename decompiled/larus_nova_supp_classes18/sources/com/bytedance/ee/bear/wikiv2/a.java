package com.bytedance.ee.bear.wikiv2;

import android.app.Application;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.wikiv2.selector.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends RelativeLayout {
    public AppCompatImageView a;
    public TextView b;
    public n.a c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.a$a, reason: collision with other inner class name */
    public static final class C0201a extends t {
        public final /* synthetic */ a c;

        public C0201a(a r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r1) {
            n.a r2 = this.c.c;
            if (r2 == null) goto L6;
            r2.V3();
            return;
        }
    }

    public final AppCompatImageView getWikiSelectCurrentIconFromXml() {
        AppCompatImageView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131393255);
        this.a = r0;
    L6:
        return r0;
    }

    public final TextView getWikiSelectCurrentTitleFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131393256);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        View.inflate(r3, 2131568248, this);
        AppCompatImageView r4 = getWikiSelectCurrentIconFromXml();
        if (r4 == null) goto L5;
        r4.setImageResource(kac.a.b(2131254164));
        com.bytedance.ee.util.ui.l.c(r4, 2131101111);
    L5:
        TextView r5 = getWikiSelectCurrentTitleFromXml();
        if (r5 == null) goto L8;
        Application r0 = eu5.b.a;
        int r1 = jq5.a.a;
        r5.setText(r0.getString(2131889607));
    L8:
        setOnClickListener(new C0201a(this));
    }

    public final void setViewDelegate(n.a r1) {
        this.c = r1;
    }

    public final void setWikiSelectCurrentIconFromXml(AppCompatImageView r1) {
        this.a = r1;
    }

    public final void setWikiSelectCurrentTitleFromXml(TextView r1) {
        this.b = r1;
    }
}
