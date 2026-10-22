package com.ss.android.lark.todo.impl.features.detail.sections;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class OriginSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f443255c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OriginSection f443256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f443257b;

        public a(OriginSection r100, String r101) {
            this.f443256a = r100;
            this.f443257b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f443256a.f443255c.c().b(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.f2.f443695a, this.f443257b);
        }
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    public final void n() {
        ((TextView) this.f443254b.findViewById(R.id.todo_origin_view)).setVisibility(8);
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        k(e().getShowOrigin(), new OriginSection$initViewObserver$1$1(this));
    }

    public OriginSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f443254b = r100;
        this.f443255c = r101;
    }

    public final void o(String r100, int r101, int r102, String r103) {
        ((TextView) this.f443254b.findViewById(R.id.todo_origin_view)).setVisibility(0);
        if (TextUtils.isEmpty(r103) == false) goto L5;
        ((TextView) this.f443254b.findViewById(R.id.todo_origin_view)).setText(r100);
        return;
    L5:
        ((TextView) this.f443254b.findViewById(R.id.todo_origin_view)).setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString r104 = new SpannableString(r100);
        r104.setSpan(new ForegroundColorSpan(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_link_normal)), r101, r102, 33);
        ((TextView) this.f443254b.findViewById(R.id.todo_origin_view)).setText(r104);
        ((TextView) this.f443254b.findViewById(R.id.todo_origin_view)).setOnClickListener(new a(this, r103));
    }
}
