package com.ss.android.lark.chat.preview.components;

import android.graphics.RectF;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.chat.preview.components.view.FlowLayout;
import com.ss.android.lark.chat.preview.entity.component.property.TagListProperty;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a0 extends q6c.e<TagListProperty, FlowLayout, r6c.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TagListProperty f416007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r6c.a f416008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FlowLayout f416009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b0 f416010i;

    public static final class a extends FlowLayout.c {
        public a(TextView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Override // q6c.a
    public final String i() {
        return "com.larksuite.framework.ui.flowlayout.FlowLayout";
    }

    @Override // q6c.e
    public final boolean j() {
        return true;
    }

    @Override // q6c.e, s6c.b
    public final View a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        return new FlowLayout(this.f416008g.getContext());
    }

    @Override // q6c.e, s6c.b
    public final s6c.b.a d(s6c.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        this.f416009h.setAdapter(this.f416010i);
        this.f416009h.setMaxLines(this.f416007f.getNumberOfLines());
        this.f416009h.measure(View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(r100.f540895a), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(536870911, 0));
        return new s6c.b.a(h18.d.e(this.f416008g.getContext(), this.f416009h.getMeasuredWidth()), h18.d.e(this.f416008g.getContext(), this.f416009h.getMeasuredHeight()));
    }

    public void update(FlowLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Intrinsics.areEqual(r100, this.f416009h) == true) goto L5;
        r100.setMChildrenPositionList(this.f416009h.getMChildrenPositionList());
    L5:
        r100.setAdapter(this.f416010i);
        r100.setMaxLines(this.f416007f.getNumberOfLines());
    }

    @Override // q6c.e
    public /* bridge */ /* synthetic */ void update(View r100) {
        update((FlowLayout) r100);
    }

    public a0(TagListProperty r100, Style r101, vcb.d r102) {
        Intrinsics.checkNotNullParameter(r100, "prop");
        Intrinsics.checkNotNullParameter(r102, "dependence");
        super(r100, r101, r102);
        this.f416007f = r100;
        this.f416008g = r102;
        this.f416009h = new FlowLayout(r102.getContext());
        this.f416010i = new b0(this);
    }
}
