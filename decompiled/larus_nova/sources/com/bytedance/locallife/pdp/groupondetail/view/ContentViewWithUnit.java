package com.bytedance.locallife.pdp.groupondetail.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import df6.q;
import df6.u;
import dx6.b;
import hf6.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/view/ContentViewWithUnit;", "Landroid/widget/LinearLayout;", "Ldx6/b;", "vo", "", "setVO", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class ContentViewWithUnit extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f261411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f261412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxTextView f261413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DuxTextView f261414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f261415e;

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentViewWithUnit f261416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f261417b;

        @Override // hf6.i
        public final void onCompleted(Bitmap r110) {
            if (r110 == null) goto L16;
            ContentViewWithUnit r100 = this.f261416a;
            b r101 = this.f261417b;
            int r102 = 0;
            if (Build.VERSION.SDK_INT < 29) goto L6;
            ImageSpan r103 = new ImageSpan(r100.getContext(), r110, 2);
        L7:
            r103.getDrawable().setBounds(0, 0, (r110.getWidth() * bx6.a.c(com.bytedance.locallife.dito.utils.e.b(16))) / r110.getHeight(), bx6.a.c(com.bytedance.locallife.dito.utils.e.b(16)));
            SpannableString r111 = new SpannableString(r101.h() + " X");
            String r104 = r101.h();
            if (r104 == null) goto L10;
            int r105 = r104.length();
        L11:
            int r106 = r105 + 1;
            String r107 = r101.h();
            if (r107 == null) goto L14;
            r102 = r107.length();
        L14:
            r111.setSpan(r103, r106, r102 + 2, 17);
            r100.f261412b.setText(r111);
            return;
        L10:
            r105 = 0;
            goto L11
        L6:
            r103 = new ImageSpan(r100.getContext(), r110, 0);
            goto L7
        }

        @Override // hf6.i
        public final void onFailed(Throwable r100) {
            this.f261416a.f261412b.setText(this.f261417b.h());
        }

        public a(ContentViewWithUnit r100, b r101) {
            this.f261416a = r100;
            this.f261417b = r101;
        }
    }

    public ContentViewWithUnit(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ContentViewWithUnit(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setVO(b r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        if (TextUtils.isEmpty(r100.g()) == false) goto L5;
        this.f261412b.setText(r100.h());
    L7:
        if (TextUtils.isEmpty(r100.i()) == false) goto L9;
        this.f261413c.setVisibility(8);
    L11:
        if (TextUtils.isEmpty(r100.f()) == false) goto L13;
        this.f261414d.setVisibility(8);
    L14:
        this.f261415e.removeAllViews();
        List<String> r101 = r100.d();
        if (r101 == null) goto L20;
        Iterator<T> r102 = r101.iterator();
    L18:
        if (r102.hasNext() == false) goto L22;
        String r103 = (String) r102.next();
        DuxTextView r104 = new DuxTextView(getContext(), null, 6, 0);
        r104.setText(r103);
        bx6.a.e(r104, 11.0f);
        r104.setTextColor(ColorProtector.parseColor("#80161823"));
        this.f261415e.addView(r104);
        goto L18
    L22:
        return;
    L20:
        return;
    L13:
        this.f261414d.setVisibility(0);
        this.f261414d.setText(r100.e() + r100.f());
        goto L14
    L9:
        this.f261413c.setVisibility(0);
        this.f261413c.setText(r100.i());
        goto L11
    L5:
        u r105 = q.d(r100.g());
        r105.f468277c = getContext();
        r105.e(new a(this, r100));
        goto L7
    }

    public ContentViewWithUnit(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.life_pdp_groupon_detail_content_view_with_unit, this, true);
        setOrientation(0);
        setGravity(48);
        View r103 = findViewById(R.id.dot);
        this.f261411a = r103;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Double r105 = Double.valueOf(3.5d);
        r104.width = bx6.a.c(com.bytedance.locallife.dito.utils.e.b(r105));
        r104.height = bx6.a.c(com.bytedance.locallife.dito.utils.e.b(r105));
        r103.setLayoutParams(r104);
        DuxTextView r106 = (DuxTextView) findViewById(R.id.title);
        this.f261412b = r106;
        bx6.a.e(r106, 13.0f);
        DuxTextView r107 = (DuxTextView) findViewById(R.id.unit);
        this.f261413c = r107;
        bx6.a.e(r107, 11.0f);
        DuxTextView r108 = (DuxTextView) findViewById(R.id.price);
        this.f261414d = r108;
        bx6.a.e(r108, 13.0f);
        this.f261415e = (LinearLayout) findViewById(R.id.desc_container);
    }

    public /* synthetic */ ContentViewWithUnit(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
