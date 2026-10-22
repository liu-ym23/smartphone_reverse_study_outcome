package com.larksuite.component.universe_design.datepicker.impl.header;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.datepicker.databinding.UdDatepickerDefaultHeadBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/header/MonthPickerDefaultHead;", "Landroid/widget/RelativeLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "mMonthPickerActionListener", "Lcom/larksuite/component/universe_design/datepicker/impl/header/MonthPickerDefaultHead$MonthPickerActionListener;", "viewBinding", "Lcom/larksuite/component/universe_design/datepicker/databinding/UdDatepickerDefaultHeadBinding;", "setMonthText", "", "monthText", "", "setMonthPickerActionListener", "listener", "setTypeFace", "typeFace", "Landroid/graphics/Typeface;", "setMonthTextSize", "textSize", "", "MonthPickerActionListener", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MonthPickerDefaultHead extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AttributeSet f284807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f284808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UdDatepickerDefaultHeadBinding f284809c;

    public interface a {
        void a();

        void b();
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonthPickerDefaultHead f284810a;

        public b(MonthPickerDefaultHead r100) {
            this.f284810a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f284810a.f284808b;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonthPickerDefaultHead f284811a;

        public c(MonthPickerDefaultHead r100) {
            this.f284811a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f284811a.f284808b;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public MonthPickerDefaultHead(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MonthPickerDefaultHead(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, r101, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.f284807a;
    }

    public final void setAttrs(AttributeSet r100) {
        this.f284807a = r100;
    }

    public final void setMonthPickerActionListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f284808b = r100;
        this.f284809c.f284778b.setOnClickListener(new b(this));
        this.f284809c.f284780d.setOnClickListener(new c(this));
    }

    public final void setMonthText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monthText");
        this.f284809c.f284779c.setText(r100);
    }

    public final void setMonthTextSize(float r100) {
        this.f284809c.f284779c.setTextSize(0, r100);
    }

    public final void setTypeFace(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, "typeFace");
        this.f284809c.f284779c.setTypeface(r100);
    }

    public MonthPickerDefaultHead(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
        this.f284807a = r101;
        LayoutInflater.from(getContext()).inflate(R.layout.ud_datepicker_default_head, this);
        int r103 = R.id.leftArrowImageView;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.leftArrowImageView);
        if (r104 == null) goto L11;
        r103 = R.id.monthTextView;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.monthTextView);
        if (r105 == null) goto L11;
        r103 = R.id.rightArrowImageView;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(this, R.id.rightArrowImageView);
        if (r106 == null) goto L11;
        this.f284809c = new UdDatepickerDefaultHeadBinding(this, r104, r105, r106);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ MonthPickerDefaultHead(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
