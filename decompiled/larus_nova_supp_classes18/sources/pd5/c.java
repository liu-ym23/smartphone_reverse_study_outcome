package pd5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final CopyOnWriteArrayList<View> a;

    public static class a {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public c() {
        this.a = new CopyOnWriteArrayList();
    }

    public final View a(Context r17) {
        if (this.a.isEmpty() == true) goto L6;
        CopyOnWriteArrayList<View> r1 = this.a;
        return r1.remove(r1.size() - 1);
    L6:
        SwipeMenuLayout r2 = new SwipeMenuLayout(r17);
        r2.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, n.d(66)));
        r2.setId(2131378129);
        ConstraintLayout r4 = new ConstraintLayout(r17);
        r4.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, n.d(68)));
        r4.setBackgroundResource(2131243714);
        r4.setId(2131375720);
        View r5 = new Guideline(r17);
        r5.setId(2131378136);
        ViewGroup.LayoutParams r8 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ConstraintLayout.LayoutParams) r8).orientation = 0;
        ((ConstraintLayout.LayoutParams) r8).guidePercent = 0.5f;
        r4.addView(r5, r8);
        AppCompatImageView r6 = new AppCompatImageView(r17);
        r6.setImageResource(kac.a.b(2131254630));
        r6.setId(2131375773);
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(zz7.b.g(r17, 40), zz7.b.g(r17, 40));
        r11.bottomToBottom = 0;
        r11.topToTop = 0;
        r11.leftToLeft = 0;
        r11.rightToLeft = 2131375808;
        r11.setMarginStart(n.d(16));
        r4.addView(r6, r11);
        AppCompatImageView r7 = new AppCompatImageView(r17);
        r7.setImageResource(2131256255);
        r7.setId(2131375843);
        r7.setVisibility(8);
        ViewGroup.LayoutParams r15 = new ConstraintLayout.LayoutParams(zz7.b.g(r17, 40), zz7.b.g(r17, 40));
        ((ConstraintLayout.LayoutParams) r15).bottomToBottom = 2131375773;
        ((ConstraintLayout.LayoutParams) r15).leftToLeft = 2131375773;
        r4.addView(r7, r15);
        LKUIRoundedImageView2 r9 = new SyncStateView(r17);
        r9.setVisibility(8);
        r9.setId(2131375856);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(zz7.b.g(r17, 12), zz7.b.g(r17, 12));
        r12.leftToLeft = 2131375808;
        ((ViewGroup.MarginLayoutParams) r12).topMargin = n.d(6);
        r12.topToBottom = 2131378136;
        r4.addView(r9, r12);
        View r10 = new View(r17);
        r10.setVisibility(8);
        r10.setId(2131381790);
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(zz7.b.g(r17, 4), zz7.b.g(r17, 12));
        ((ViewGroup.MarginLayoutParams) r14).topMargin = n.d(6);
        r14.leftToRight = 2131375856;
        r14.rightToLeft = 2131378144;
        r14.topToBottom = 2131378136;
        r4.addView(r10, r14);
        SpaceTagTitleView r13 = new SpaceTagTitleView(r17);
        r13.setId(2131375808);
        r13.setTitleSize(16.0f);
        ConstraintLayout.LayoutParams r16 = new ConstraintLayout.LayoutParams(n.d(0), -2);
        r16.horizontalWeight = 1.0f;
        r16.leftToRight = 2131375773;
        r16.rightToLeft = 2131378165;
        r16.bottomToTop = 2131378136;
        r16.setMarginStart(n.d(12));
        r16.setMarginEnd(n.d(16));
        r4.addView(r13, r16);
        TextView r18 = new TextView(r17);
        r18.setId(2131391910);
        r18.setEllipsize(TextUtils.TruncateAt.END);
        r18.setMaxLines(1);
        r18.setSingleLine();
        r18.setText(2131887926);
        r18.setTextColor(n.h(r17, 2131106620));
        r18.setTextSize(14.0f);
        ConstraintLayout.LayoutParams r19 = new ConstraintLayout.LayoutParams(n.d(0), -2);
        ((ViewGroup.MarginLayoutParams) r19).topMargin = n.d(2);
        r19.horizontalBias = 0.0f;
        r19.topToBottom = 2131378136;
        r19.leftToRight = 2131378141;
        r19.rightToLeft = 2131378165;
        r4.addView(r18, r19);
        TextView r20 = new TextView(r17);
        r20.setId(2131378144);
        r20.setEllipsize(TextUtils.TruncateAt.END);
        r20.setMaxLines(1);
        r20.setSingleLine();
        r20.setText(2131888012);
        r20.setTextColor(n.h(r17, 2131106620));
        r20.setTextSize(14.0f);
        r20.setVisibility(8);
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) r110).topMargin = n.d(2);
        ((ViewGroup.MarginLayoutParams) r110).rightMargin = n.d(16);
        r110.leftToRight = 2131381790;
        r110.topToBottom = 2131378136;
        r4.addView(r20, r110);
        TextView r21 = new TextView(r17);
        r21.setId(2131378141);
        r21.setEllipsize(TextUtils.TruncateAt.END);
        r21.setMaxLines(1);
        r21.setTextColor(n.h(r17, 2131106620));
        r21.setTextSize(14.0f);
        r21.setVisibility(8);
        r21.setGravity(17);
        r21.setCompoundDrawablePadding(n.d(2));
        ViewGroup.LayoutParams r22 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ConstraintLayout.LayoutParams) r22).topToBottom = 2131375808;
        ((ConstraintLayout.LayoutParams) r22).bottomToBottom = 2131391910;
        ((ConstraintLayout.LayoutParams) r22).leftToRight = 2131378144;
        r4.addView(r21, r22);
        AppCompatImageView r3 = new AppCompatImageView(r17);
        r3.setId(2131375745);
        r3.setVisibility(8);
        l.c(r3, 2131102420);
        ConstraintLayout.LayoutParams r23 = new ConstraintLayout.LayoutParams(n.d(20), n.d(20));
        r23.topToTop = 0;
        r23.bottomToBottom = 0;
        r23.rightToLeft = 2131378165;
        ((ViewGroup.MarginLayoutParams) r23).rightMargin = n.d(22);
        r4.addView(r3, r23);
        AppCompatImageView r24 = b(r17, 2131378165, 2131100548);
        r24.setVisibility(8);
        ConstraintLayout.LayoutParams r25 = new ConstraintLayout.LayoutParams(n.d(24), n.d(24));
        r25.topToTop = 0;
        r25.bottomToBottom = 0;
        r25.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r25).rightMargin = n.d(12);
        int r26 = n.d(4);
        r24.setPadding(r26, r26, r26, r26);
        r4.addView(r24, r25);
        r2.addView(r4);
        LinearLayout r27 = new LinearLayout(r17);
        r27.setLayoutParams(new ViewGroup.MarginLayoutParams(n.d(198), -1));
        r27.setId(2131375803);
        r27.addView(b(r17, 2131387821, 2131101948));
        r27.addView(b(r17, 2131387823, 2131101948));
        r27.addView(b(r17, 2131387819, 2131102093));
        r2.addView(r27);
        return r2;
    }

    public static AppCompatImageView b(Context r4, int r5, int r6) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        AppCompatImageView r1 = new AppCompatImageView(r4);
        r1.setId(r5);
        r1.setBackgroundColor(n.h(r4, r6));
        r1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r1.setLayoutParams(r0);
        return r1;
    }
}
