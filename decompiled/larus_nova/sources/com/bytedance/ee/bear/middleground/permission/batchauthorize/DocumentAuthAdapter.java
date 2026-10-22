package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.g0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import java.util.concurrent.CopyOnWriteArrayList;
import lg5.q;
import lg5.r;
import lg5.s;
import lg5.t;
import y9c.d;

/* JADX INFO: loaded from: classes18.dex */
public class DocumentAuthAdapter extends BaseQuickAdapter<EmbededDocumentInfo.NodeInfo, BaseViewHolder> implements View.OnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f233124d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccountService$Account f233125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f233126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f233127c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.mData.size();
    }

    public DocumentAuthAdapter() {
        super(R.layout.auth_list_item);
        this.f233125a = ((h0) org.koin.java.a.a(h0.class)).G2();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r110, EmbededDocumentInfo.NodeInfo r111) {
        EmbededDocumentInfo.NodeInfo r112 = r111;
        tt5.a.b("DocumentAuthAdapter", "DocumentAuthAdapter convert");
        if ((r110 instanceof AuthDocViewHolder) == false) goto L30;
        AuthDocViewHolder r113 = (AuthDocViewHolder) r110;
        r113.f233103b.setOnClickListener(new q(this, r112));
        int r100 = r113.getLayoutPosition();
        Context r101 = r113.f233106e.getContext();
        Context r102 = r113.f233106e.getContext();
        Document r103 = new Document();
        r103.f227872c = r112.getObject_token();
        r103.f227868a = r112.getTitle();
        r103.f227908y1 = r112.getObject_type();
        if (r112.isWiki() == false) goto L8;
        r103.f227869b = 16;
    L9:
        r103.F = com.bytedance.ee.util.io.a.c(r112.getTitle());
        AccountService$Account r104 = this.f233125a;
        if (r104 == null) goto L12;
        String r105 = r104.token;
    L13:
        String r106 = r105;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).u(new g0(r102, r103, r106, false, r113.f233104c));
        if (TextUtils.isEmpty(r112.getTitle()) == false) goto L16;
        String r107 = ng5.a.b(r101, this.f233127c);
        r113.f233105d.setText(r107);
    L17:
        String r108 = xo5.a.c(r101, R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Owner, "name", r112.getOwner_name());
        r113.f233106e.setText(r108);
        r113.f233105d.setTextColor(r101.getResources().getColor(R.color.text_title));
        r113.f233106e.setTextColor(r101.getResources().getColor(R.color.text_caption));
        if (r112.isChat_has_permission() == false) goto L20;
        r113.f233107f.setText(r101.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Granted));
        r113.f233107f.setTextColor(r101.getResources().getColor(R.color.text_placeholder));
    L21:
        boolean r109 = r112.isChat_has_permission();
        r113.f233108g.setTag(r112);
        Context r114 = r113.f233108g.getContext();
        r113.f233108g.setTextColor(r114.getResources().getColor(R.color.static_white));
        if (r109 == false) goto L24;
        r113.f233108g.setText(r114.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_RevokeAccess));
        r113.f233108g.setBackgroundColor(r114.getResources().getColor(R.color.ud_N500));
    L25:
        r113.f233108g.setOnClickListener(new s(this, r100, r112, r109));
        if (r112.isSenderHasSharePermission() == true) goto L29;
        Context r115 = r113.f233108g.getContext();
        r113.f233108g.setOnClickListener(new r(r113, r112, r115));
        r113.f233108g.setTextColor(r115.getResources().getColor(R.color.text_placeholder));
        r113.f233108g.setBackgroundColor(r115.getResources().getColor(R.color.bg_filler));
        return;
    L29:
        return;
    L24:
        r113.f233108g.setText(r114.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_GrantAccess));
        r113.f233108g.setBackgroundColor(r114.getResources().getColor(R.color.colorful_blue));
        goto L25
    L20:
        r113.f233107f.setText(r101.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_NotGranted));
        r113.f233107f.setTextColor(r101.getResources().getColor(R.color.text_title));
        goto L21
    L16:
        r113.f233105d.setText(r112.getTitle());
        goto L17
    L12:
        r105 = "";
        goto L13
    L8:
        r103.f227869b = r112.getObject_type();
        goto L9
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r110, int r111) {
        lg5.a r100 = lg5.a.C6693a.f509142a;
        Context r101 = r110.getContext();
        if (r100.f509141a.isEmpty() == true) goto L5;
        CopyOnWriteArrayList<View> r102 = r100.f509141a;
        View r103 = r102.remove(r102.size() - 1);
    L7:
        return new AuthDocViewHolder(r103);
    L5:
        SwipeMenuLayout r104 = new SwipeMenuLayout(r101);
        r104.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, n.d(66)));
        r104.setId(R.id.list_item);
        ConstraintLayout r105 = new ConstraintLayout(r101);
        r105.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, n.d(68)));
        r105.setBackgroundResource(R.drawable.auth_item_bg_selector);
        r105.setId(R.id.item_content);
        AppCompatImageView r106 = new AppCompatImageView(r101);
        r106.setImageResource(kac.a.b(R.drawable.ud_icon_file_round_doc_colorful));
        r106.setId(R.id.item_icon);
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(n.d(40), n.d(40));
        r107.bottomToBottom = 0;
        r107.topToTop = 0;
        r107.leftToLeft = 0;
        r107.rightToLeft = R.id.item_name;
        r107.setMarginStart(n.d(16));
        r105.addView(r106, r107);
        TextView r108 = new TextView(r101);
        r108.setId(R.id.item_name);
        r108.setSingleLine(true);
        r108.setEllipsize(TextUtils.TruncateAt.END);
        r108.setTextSize(16.0f);
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(n.d(0), n.d(24));
        r109.horizontalWeight = 1.0f;
        r109.leftToRight = R.id.item_icon;
        r109.topToTop = 0;
        r109.rightToLeft = R.id.auth_dep_tx;
        r109.setMarginStart(n.d(12));
        r109.setMarginEnd(n.d(2));
        ((ViewGroup.MarginLayoutParams) r109).topMargin = n.d(12);
        r105.addView(r108, r109);
        TextView r112 = new TextView(r101);
        r112.setId(R.id.creator_button);
        r112.setEllipsize(TextUtils.TruncateAt.END);
        r112.setMaxLines(1);
        r112.setSingleLine();
        r112.setText(R.string.Doc_List_LastUpdateWithSpace);
        r112.setTextColor(n.h(r101, R.color.text_placeholder));
        r112.setTextSize(14.0f);
        ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(n.d(0), -2);
        ((ViewGroup.MarginLayoutParams) r113).bottomMargin = n.d(12);
        r113.horizontalBias = 0.0f;
        r113.bottomToBottom = 0;
        r113.leftToRight = R.id.item_icon;
        r113.topToBottom = R.id.item_name;
        r113.rightToRight = R.id.item_name;
        r113.setMarginStart(n.d(12));
        r105.addView(r112, r113);
        TextView r114 = new TextView(r101);
        r114.setId(R.id.auth_dep_tx);
        r114.setPadding(n.d(16), 0, n.d(16), 0);
        r114.setEllipsize(TextUtils.TruncateAt.END);
        r114.setMaxLines(1);
        r114.setGravity(17);
        r114.setSingleLine();
        r114.setText(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Granted);
        r114.setTextColor(n.h(r101, R.color.text_caption));
        r114.setTextSize(14.0f);
        ConstraintLayout.LayoutParams r115 = new ConstraintLayout.LayoutParams(-2, n.d(68));
        r115.rightToRight = 0;
        r105.addView(r114, r115);
        r104.addView(r105);
        LinearLayout r116 = new LinearLayout(r101);
        r116.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -1));
        r116.setId(R.id.item_menu);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-1, n.d(68));
        r117.gravity = 17;
        TextView r118 = new TextView(r101);
        r118.setId(R.id.swipe_menu_operate);
        r118.setGravity(17);
        r118.setTextSize(14.0f);
        r118.setMaxWidth((int) (((double) n.v()) * 0.6d));
        r118.setPadding(n.d(16), 0, n.d(16), 0);
        r118.setTextColor(d.c(r101, R.color.static_white));
        r118.setBackgroundColor(n.h(r101, R.color.function_danger_fill_default));
        r118.setLayoutParams(r117);
        r116.addView(r118);
        r104.addView(r116);
        r103 = r104;
        goto L7
    }
}
