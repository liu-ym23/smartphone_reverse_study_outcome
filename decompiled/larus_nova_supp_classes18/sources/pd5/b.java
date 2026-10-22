package pd5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final CopyOnWriteArrayList<View> a;

    public static class a {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public b() {
        this.a = new CopyOnWriteArrayList();
    }

    public final View a(Context r15) {
        if (this.a.isEmpty() == true) goto L6;
        CopyOnWriteArrayList<View> r16 = this.a;
        return r16.remove(r16.size() - 1);
    L6:
        ConstraintLayout r0 = new ConstraintLayout(r15);
        r0.setId(2131373901);
        ViewGroup.LayoutParams r2 = new ViewGroup.LayoutParams(-1, n.l(r15, 2131167709));
        r0.setBackgroundResource(2131243709);
        r0.setLayoutParams(r2);
        View r3 = new View(r15);
        r3.setBackgroundResource(2131243710);
        l.b(r3, 2131100548);
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(-1, -1);
        int r8 = n.d(4);
        r6.setMargins(r8, r8, r8, r8);
        r0.addView(r3, r6);
        AppCompatImageView r4 = new AppCompatImageView(r15);
        r4.setId(2131378116);
        r4.setBackgroundResource(2131243710);
        l.b(r4, 2131100548);
        r4.setImageResource(2131243712);
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(-1, -1);
        int r7 = n.d(4);
        r5.setMargins(r7, r7, r7, r7);
        r0.addView(r4, r5);
        View r9 = new View(r15);
        r9.setBackgroundColor(r15.getResources().getColor(2131103362));
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(-1, -1);
        int r11 = n.d(4);
        r10.setMargins(r11, r11, r11, r11);
        r0.addView(r9, r10);
        AppCompatImageView r12 = new AppCompatImageView(r15);
        r12.setId(2131378107);
        r12.setImageResource(kac.a.b(2131254694));
        r12.setVisibility(8);
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(n.d(48), n.d(48));
        ((ViewGroup.MarginLayoutParams) r13).topMargin = n.d(22);
        r13.leftToLeft = 0;
        r13.rightToRight = 0;
        r13.topToTop = 0;
        r0.addView(r12, r13);
        AppCompatImageView r14 = new AppCompatImageView(r15);
        r14.setId(2131378115);
        r14.setBackgroundResource(2131235937);
        r14.setImageResource(2131254138);
        l.c(r14, 2131101124);
        int r17 = n.d(3);
        r14.setPadding(r17, r17, r17, r17);
        ConstraintLayout.LayoutParams r18 = new ConstraintLayout.LayoutParams(n.d(20), n.d(20));
        ((ViewGroup.MarginLayoutParams) r18).topMargin = n.d(9);
        r18.setMarginEnd(n.d(9));
        r18.topToTop = 0;
        r18.rightToLeft = 2131378094;
        r0.addView(r14, r18);
        AppCompatImageView r19 = new AppCompatImageView(r15);
        r19.setId(2131378094);
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(n.d(20), n.d(20));
        r110.rightToRight = 0;
        r110.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r110).topMargin = n.d(9);
        r110.setMarginEnd(n.d(9));
        int r111 = n.d(2);
        r14.setPadding(r111, r111, r111, r111);
        r19.setVisibility(8);
        r19.setBackgroundResource(2131235937);
        r19.setImageResource(2131256189);
        l.c(r19, 2131102416);
        r0.addView(r19, r110);
        View r20 = new View(r15);
        r20.setBackgroundResource(2131103351);
        ViewGroup.LayoutParams r21 = new ConstraintLayout.LayoutParams(-1, n.c(0.5f));
        ((ConstraintLayout.LayoutParams) r21).bottomToTop = 2131378108;
        r0.addView(r20, r21);
        ConstraintLayout r22 = new ConstraintLayout(r15);
        r22.setId(2131378108);
        ConstraintLayout.LayoutParams r23 = new ConstraintLayout.LayoutParams(-1, n.d(60));
        int r1 = n.d(1);
        r23.setMargins(r1, r1, r1, r1);
        r23.bottomToBottom = 0;
        r22.setPadding(0, n.d(6), 0, n.d(6));
        r22.setBackgroundResource(2131243717);
        r0.addView(r22, r23);
        AppCompatImageView r24 = new AppCompatImageView(r15);
        r24.setId(2131378113);
        ConstraintLayout.LayoutParams r25 = new ConstraintLayout.LayoutParams(n.d(24), n.d(24));
        r25.setMarginStart(n.d(8));
        r25.topToTop = 0;
        r25.bottomToBottom = 0;
        r25.leftToLeft = 0;
        r24.setImageResource(kac.a.b(2131254630));
        r22.addView(r24, r25);
        AppCompatImageView r26 = new AppCompatImageView(r15);
        r26.setId(2131378109);
        r26.setVisibility(8);
        ViewGroup.LayoutParams r27 = new ConstraintLayout.LayoutParams(n.d(24), n.d(24));
        ((ConstraintLayout.LayoutParams) r27).bottomToBottom = 2131378113;
        ((ConstraintLayout.LayoutParams) r27).leftToLeft = 2131378113;
        r26.setImageResource(2131256255);
        r22.addView(r26, r27);
        LKUIRoundedImageView2 r28 = new SyncStateView(r15);
        r28.setId(2131378110);
        r28.setVisibility(8);
        ConstraintLayout.LayoutParams r29 = new ConstraintLayout.LayoutParams(n.d(14), n.d(14));
        ((ViewGroup.MarginLayoutParams) r29).bottomMargin = n.d(3);
        r29.bottomToBottom = 0;
        r29.rightToLeft = 2131378112;
        r22.addView(r28, r29);
        TextView r30 = new TextView(r15);
        r30.setId(2131378112);
        ConstraintLayout.LayoutParams r31 = new ConstraintLayout.LayoutParams(0, -2);
        r31.setMarginStart(n.d(8));
        r31.setMarginEnd(n.d(4));
        r30.setTextSize(14.0f);
        r30.setTextColor(n.h(r15, 2131106622));
        r30.setMaxLines(2);
        r30.setEllipsize(TextUtils.TruncateAt.END);
        r31.leftToRight = 2131378113;
        r31.rightToLeft = 2131378114;
        r31.topToTop = 0;
        r31.bottomToTop = 2131378111;
        r22.addView(r30, r31);
        SpaceTagTitleView r32 = new SpaceTagTitleView(r15);
        r32.setId(2131378111);
        r32.setLabelsMargin(0);
        ConstraintLayout.LayoutParams r33 = new ConstraintLayout.LayoutParams(0, -2);
        r33.setMarginStart(n.d(8));
        r33.setMarginEnd(n.d(4));
        r33.leftToRight = 2131378113;
        r33.rightToLeft = 2131378114;
        r33.topToBottom = 2131378112;
        r33.bottomToBottom = 0;
        r22.addView(r32, r33);
        AppCompatImageView r34 = new AppCompatImageView(r15);
        r34.setId(2131378114);
        ConstraintLayout.LayoutParams r112 = new ConstraintLayout.LayoutParams(n.d(24), n.d(24));
        r112.setMarginEnd(n.d(4));
        r112.rightToRight = 0;
        r112.topToTop = 0;
        r112.bottomToBottom = 0;
        r34.setImageResource(2131243711);
        l.c(r34, 2131102420);
        r22.addView(r34, r112);
        return r0;
    }
}
