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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f240467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f240468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n.a f240469c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.a$a, reason: collision with other inner class name */
    public static final class C3448a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f240470c;

        public C3448a(a r100) {
            this.f240470c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            n.a r101 = this.f240470c.f240469c;
            if (r101 == null) goto L6;
            r101.V3();
            return;
        }
    }

    public final AppCompatImageView getWikiSelectCurrentIconFromXml() {
        KeyEvent.Callback r100 = this.f240467a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.wiki_select_current_icon);
        this.f240467a = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getWikiSelectCurrentTitleFromXml() {
        KeyEvent.Callback r100 = this.f240468b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.wiki_select_current_title);
        this.f240468b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View.inflate(r100, R.layout.wiki_root_select_current_view, this);
        AppCompatImageView r101 = getWikiSelectCurrentIconFromXml();
        if (r101 == null) goto L5;
        r101.setImageResource(kac.a.b(R.drawable.ud_icon_copy_filled));
        com.bytedance.ee.util.ui.l.c(r101, R.color.colorful_blue);
    L5:
        TextView r102 = getWikiSelectCurrentTitleFromXml();
        if (r102 == null) goto L8;
        Application r103 = eu5.b.f474075a;
        int r104 = jq5.a.f500067a;
        r102.setText(r103.getString(R.string.LarkCCM_NewCM_MakeCopies_Option));
    L8:
        setOnClickListener(new C3448a(this));
    }

    public final void setViewDelegate(n.a r100) {
        this.f240469c = r100;
    }

    public final void setWikiSelectCurrentIconFromXml(AppCompatImageView r100) {
        this.f240467a = r100;
    }

    public final void setWikiSelectCurrentTitleFromXml(TextView r100) {
        this.f240468b = r100;
    }
}
