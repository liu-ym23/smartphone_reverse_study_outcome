package zc5;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends LinearLayout {
    public final TextView a;
    public final TextView b;
    public final ImageView c;

    /* JADX INFO: renamed from: zc5.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0345a implements View.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public ViewOnClickListenerC0345a(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public final TextView getLeftTitle() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setLeftTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.a.setText(r2);
        this.a.setVisibility(0);
    }

    public final void setMoreVisible(boolean r5) {
        TextView r0 = this.b;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        ImageView r2 = this.c;
        if (r5 == true) goto L10;
        r1 = 8;
    L10:
        r2.setVisibility(r1);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setRightTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.b.setText(r2);
        this.b.setVisibility(0);
    }

    public a(Context r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        int r0 = d.a(2);
        int r1 = d.a(14);
        int r3 = d.a(16);
        setOrientation(0);
        setBackgroundColor(r10.getResources().getColor(2131100548));
        TextView r5 = new TextView(r10);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        r6.setMarginStart(d.a(16));
        r6.topMargin = d.a(18);
        r6.bottomMargin = d.a(8);
        r5.setLayoutParams(r6);
        r5.setTextSize(16.0f);
        r5.setTextColor(r10.getResources().getColor(2131106622));
        r5.setTypeface(Typeface.defaultFromStyle(1));
        r5.setSingleLine();
        r5.setEllipsize(TextUtils.TruncateAt.END);
        this.a = r5;
        addView(r5);
        TextView r7 = new TextView(r10);
        r7.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r7.setTextSize(12.0f);
        r7.setTextColor(r10.getResources().getColor(2131106620));
        this.b = r7;
        ImageView r8 = new ImageView(r10);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(r1, r1);
        r9.setMarginStart(r0);
        r8.setLayoutParams(r9);
        r8.setImageResource(2131255566);
        r8.setImageTintList(AppCompatResources.getColorStateList(r10, 2131102420));
        this.c = r8;
        LinearLayout r2 = new LinearLayout(r10);
        r2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r2.setOrientation(0);
        r2.setGravity(16);
        r2.addView(r7);
        r2.addView(r8);
        FrameLayout r4 = new FrameLayout(r10);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        r4.setPadding(d.a(20), d.a(20), r3, 0);
        r4.setOnClickListener(new ViewOnClickListenerC0345a(r11));
        r4.addView(r2);
        addView(r4);
    }
}
