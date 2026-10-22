package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.g0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.concurrent.CopyOnWriteArrayList;
import lg5.q;
import lg5.r;
import lg5.s;
import lg5.t;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocumentAuthAdapter extends BaseQuickAdapter<EmbededDocumentInfo.NodeInfo, BaseViewHolder> implements View.OnClickListener {
    public static final /* synthetic */ int d = 0;
    public final AccountService.Account a;
    public t b;
    public int c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public final int getItemCount() {
        return ((BaseQuickAdapter) this).mData.size();
    }

    public DocumentAuthAdapter() {
        super(2131558751);
        this.a = ((h0) org.koin.java.a.a(h0.class)).G2();
    }

    public final void convert(BaseViewHolder r11, Object r12) {
        EmbededDocumentInfo.NodeInfo r13 = (EmbededDocumentInfo.NodeInfo) r12;
        tt5.a.b("DocumentAuthAdapter", "DocumentAuthAdapter convert");
        if ((r11 instanceof AuthDocViewHolder) == false) goto L30;
        AuthDocViewHolder r14 = (AuthDocViewHolder) r11;
        r14.b.setOnClickListener(new q(this, r13));
        int r0 = r14.getLayoutPosition();
        Context r1 = r14.e.getContext();
        Context r4 = r14.e.getContext();
        Document r5 = new Document();
        r5.c = r13.getObject_token();
        r5.a = r13.getTitle();
        r5.y1 = r13.getObject_type();
        if (r13.isWiki() == false) goto L8;
        r5.b = 16;
    L9:
        r5.F = com.bytedance.ee.util.io.a.c(r13.getTitle());
        AccountService.Account r2 = this.a;
        if (r2 == null) goto L12;
        String r3 = r2.token;
    L13:
        String r6 = r3;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).u(new g0(r4, r5, r6, false, r14.c));
        if (TextUtils.isEmpty(r13.getTitle()) == false) goto L16;
        String r7 = ng5.a.b(r1, this.c);
        r14.d.setText(r7);
    L17:
        String r8 = xo5.a.c(r1, 2131887189, "name", r13.getOwner_name());
        r14.e.setText(r8);
        r14.d.setTextColor(r1.getResources().getColor(2131106622));
        r14.e.setTextColor(r1.getResources().getColor(2131106607));
        if (r13.isChat_has_permission() == false) goto L20;
        r14.f.setText(r1.getString(2131887187));
        r14.f.setTextColor(r1.getResources().getColor(2131106620));
    L21:
        boolean r9 = r13.isChat_has_permission();
        r14.g.setTag(r13);
        Context r10 = r14.g.getContext();
        r14.g.setTextColor(r10.getResources().getColor(2131106521));
        if (r9 == false) goto L24;
        r14.g.setText(r10.getString(2131887190));
        r14.g.setBackgroundColor(r10.getResources().getColor(2131108723));
    L25:
        r14.g.setOnClickListener(new s(this, r0, r13, r9));
        if (r13.isSenderHasSharePermission() == true) goto L29;
        Context r15 = r14.g.getContext();
        r14.g.setOnClickListener(new r(r14, r13, r15));
        r14.g.setTextColor(r15.getResources().getColor(2131106620));
        r14.g.setBackgroundColor(r15.getResources().getColor(2131100556));
        return;
    L29:
        return;
    L24:
        r14.g.setText(r10.getString(2131887186));
        r14.g.setBackgroundColor(r10.getResources().getColor(2131101111));
        goto L25
    L20:
        r14.f.setText(r1.getString(2131887188));
        r14.f.setTextColor(r1.getResources().getColor(2131106622));
        goto L21
    L16:
        r14.d.setText(r13.getTitle());
        goto L17
    L12:
        r3 = "";
        goto L13
    L8:
        r5.b = r13.getObject_type();
        goto L9
    }

    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r17, int r18) {
        lg5.a r1 = lg5.a.C0260a.a;
        Context r2 = r17.getContext();
        if (r1.a.isEmpty() == true) goto L5;
        CopyOnWriteArrayList<View> r3 = r1.a;
        View r4 = r3.remove(r3.size() - 1);
    L7:
        return new AuthDocViewHolder(r4);
    L5:
        AbsoluteLayout r5 = new SwipeMenuLayout(r2);
        r5.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, n.d(66)));
        r5.setId(2131378129);
        ConstraintLayout r6 = new ConstraintLayout(r2);
        r6.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, n.d(68)));
        r6.setBackgroundResource(2131231756);
        r6.setId(2131375720);
        AppCompatImageView r7 = new AppCompatImageView(r2);
        r7.setImageResource(kac.a.b(2131254630));
        r7.setId(2131375773);
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(n.d(40), n.d(40));
        r9.bottomToBottom = 0;
        r9.topToTop = 0;
        r9.leftToLeft = 0;
        r9.rightToLeft = 2131375808;
        r9.setMarginStart(n.d(16));
        r6.addView(r7, r9);
        TextView r8 = new TextView(r2);
        r8.setId(2131375808);
        r8.setSingleLine(true);
        r8.setEllipsize(TextUtils.TruncateAt.END);
        r8.setTextSize(16.0f);
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(n.d(0), n.d(24));
        r10.horizontalWeight = 1.0f;
        r10.leftToRight = 2131375773;
        r10.topToTop = 0;
        r10.rightToLeft = 2131363553;
        r10.setMarginStart(n.d(12));
        r10.setMarginEnd(n.d(2));
        ((ViewGroup.MarginLayoutParams) r10).topMargin = n.d(12);
        r6.addView(r8, r10);
        TextView r11 = new TextView(r2);
        r11.setId(2131368278);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        r11.setMaxLines(1);
        r11.setSingleLine();
        r11.setText(2131887926);
        r11.setTextColor(n.h(r2, 2131106620));
        r11.setTextSize(14.0f);
        ConstraintLayout.LayoutParams r15 = new ConstraintLayout.LayoutParams(n.d(0), -2);
        ((ViewGroup.MarginLayoutParams) r15).bottomMargin = n.d(12);
        r15.horizontalBias = 0.0f;
        r15.bottomToBottom = 0;
        r15.leftToRight = 2131375773;
        r15.topToBottom = 2131375808;
        r15.rightToRight = 2131375808;
        r15.setMarginStart(n.d(12));
        r6.addView(r11, r15);
        TextView r12 = new TextView(r2);
        r12.setId(2131363553);
        r12.setPadding(n.d(16), 0, n.d(16), 0);
        r12.setEllipsize(TextUtils.TruncateAt.END);
        r12.setMaxLines(1);
        r12.setGravity(17);
        r12.setSingleLine();
        r12.setText(2131887187);
        r12.setTextColor(n.h(r2, 2131106607));
        r12.setTextSize(14.0f);
        ViewGroup.LayoutParams r13 = new ConstraintLayout.LayoutParams(-2, n.d(68));
        ((ConstraintLayout.LayoutParams) r13).rightToRight = 0;
        r6.addView(r12, r13);
        r5.addView(r6);
        LinearLayout r14 = new LinearLayout(r2);
        r14.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -1));
        r14.setId(2131375803);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, n.d(68));
        r16.gravity = 17;
        TextView r19 = new TextView(r2);
        r19.setId(2131387822);
        r19.setGravity(17);
        r19.setTextSize(14.0f);
        r19.setMaxWidth((int) (((double) n.v()) * 0.6d));
        r19.setPadding(n.d(16), 0, n.d(16), 0);
        r19.setTextColor(d.c(r2, 2131106521));
        r19.setBackgroundColor(n.h(r2, 2131102093));
        r19.setLayoutParams(r16);
        r14.addView(r19);
        r5.addView(r14);
        r4 = r5;
        goto L7
    }
}
