package com.bytedance.ee.bear.bizwidget.shareview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ExternalShareView extends LinearLayout {
    public final Context a;
    public b b;
    public TextView c;
    public RecyclerView d;
    public ShareItemAdapter e;
    public List<ShareItemModel> f;
    public boolean g;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            a = r0;
            r0[ShareType.ExportImage.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[ShareType.SlideExport.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[ShareType.More.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[ShareType.Wechat.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[ShareType.WechatMoments.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[ShareType.QQ.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[ShareType.Weibo.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public void setEditionDoc(boolean r1) {
    }

    private com.bytedance.ee.bear.bizwidget.b.a getSdkShareDependency() {
        if (com.bytedance.ee.bear.bizwidget.a.a != null) goto L5;
        return null;
    L5:
        return new rb5.a();
    }

    public ExternalShareView(Context r2) {
        this(r2, null);
    }

    public final void b(List<ShareItemModel> r3) {
        ArrayList r0 = new ArrayList();
        if (r3 == null) goto L11;
        Iterator<ShareItemModel> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        ShareItemModel r1 = r4.next();
        if (r1 == null) goto L7;
        r0.add(r1.copy());
    L11:
        this.f = r0;
        this.e.y2(r0);
        this.e.notifyDataSetChanged();
    }

    public void setInterceptNotClick(boolean r1) {
        this.g = r1;
    }

    public void setItemImageIconSize(int r2) {
        this.e.c = r2;
    }

    public void setLayoutManager(RecyclerView.LayoutManager r4) {
        this.d.removeItemDecorationAt(0);
        this.d.setLayoutManager(r4);
        this.d.addItemDecoration(new ShareItemDecoration(getContext(), r4));
    }

    public void setOnShareItemClickListener(b r1) {
        this.b = r1;
    }

    public void setTitle(int r3) {
        this.c.setVisibility(0);
        this.c.setText(r3);
    }

    public ExternalShareView(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.g = true;
        this.a = r5;
        setOrientation(1);
        TextView r0 = new TextView(r5);
        this.c = r0;
        r0.setVisibility(8);
        addView(this.c);
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        r1.width = -1;
        r1.height = -2;
        int r2 = n.d(16);
        r1.setMarginStart(r2);
        r1.setMarginEnd(r2);
        this.c.setPadding(0, n.d(12), 0, 0);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setGravity(16);
        this.c.setTextSize(14.0f);
        this.c.setTextColor(r5.getResources().getColor(2131106607));
        View r7 = LayoutInflater.from(r5).inflate(2131564521, this, true);
        ShareItemAdapter r3 = new ShareItemAdapter();
        this.e = r3;
        r3.y2(this.f);
        this.d = r7.findViewById(2131386126);
        LinearLayoutManager r8 = new LinearLayoutManager(getContext());
        r8.setOrientation(0);
        this.d.setLayoutManager(r8);
        this.d.addItemDecoration(new ShareItemDecoration(r5, r8));
        this.d.setAdapter(this.e);
        ShareItemAdapter r9 = this.e;
        r9.b = new com.bytedance.ee.bear.bizwidget.shareview.a(this);
    }

    public static void a(ExternalShareView r8, ShareItemModel r9) {
        r8.getClass();
        ShareType r0 = r9.getType();
        if (r0 == null) goto L5;
        tt5.a.h("ExternalShareView", "onClickEvent, itemId: " + r9.getItemId());
    L5:
        boolean r2 = true;
        if (r0 != null) goto L9;
    L19:
        boolean r4 = true;
    L38:
        if (r4 == false) goto L123;
        boolean r3 = false;
        if (r0 == null) goto L72;
        int r5 = a.a[r0.ordinal()];
        if (r5 == 1) goto L71;
        if (r5 == 2) goto L62;
        if (r5 != 3) goto L72;
        if (r9.getState() != ShareState.ADMIN_NOT_CLICK) goto L54;
        Toast.showText(r8.a, 2131887246);
    L84:
        boolean r6 = false;
    L85:
        if (r6 == true) goto L88;
        return;
    L88:
        if (r9.getOnClickedListener() == null) goto L106;
        b r7 = r8.b;
        if (r7 == null) goto L105;
        if (r0 != null) goto L93;
    L95:
        if (r0 != null) goto L99;
        r2 = false;
    L99:
        if (r8.b.rF(r9) == true) goto L102;
        return;
    L102:
        if (r8.b.U10(r9) == false) goto L104;
        tt5.a.h("ExternalShareView", "onClickEvent, doShareCustom finished.");
        return;
    L104:
        r3 = r2;
        goto L105
    L93:
        if (r7.Yl(r0) == true) goto L95;
        return;
    L105:
        tt5.a.h("ExternalShareView", "onClickEvent, doShareCustom not handled.");
    L106:
        if (r0 == null) goto L108;
        b r10 = r8.b;
        if (r10 == null) goto L121;
        if (r3 == false) goto L116;
    L117:
        r8.b.s10(r0);
        return;
    L116:
        if (r10.Yl(r0) == true) goto L117;
        return;
    L121:
        return;
    L108:
        if (eu5.c.d() == true) goto L111;
        tt5.a.k("ExternalShareView", "onClickEvent, share type is null, itemId = " + r9.getItemId());
        return;
    L111:
        throw new IllegalStateException("A ShareItemModel without type must custom the onClickedListener and return true.");
    L54:
        if (r9.getState() != ShareState.NOT_CLICK) goto L59;
        if (r8.g == false) goto L59;
        Context r11 = r8.a;
        Toast.showText(r11, r11.getString(2131887579), 0);
    L59:
        if (r9.isClickable() == true) goto L72;
        tt5.a.d("ExternalShareView", "onClickEvent, More not clickable, state: " + r9.getState());
        goto L84
    L62:
        if (r9.isClickable() == true) goto L72;
        if (r9.getState() != ShareState.ADMIN_NOT_CLICK) goto L68;
        Toast.showText(r8.a, 2131887246);
        goto L84
    L68:
        if (r9.getState() != ShareState.NOT_CLICK) goto L84;
        Context r12 = r8.a;
        Toast.showText(r12, r12.getString(2131887579), 0);
        goto L84
    L71:
        if (r9.isClickable() == true) goto L72;
        if (r9.getState() != ShareState.ADMIN_NOT_CLICK) goto L77;
        Toast.showText(r8.a, 2131887246);
        goto L84
    L77:
        if (r9.getState() != ShareState.NOT_CLICK) goto L80;
        Context r13 = r8.a;
        Toast.showText(r13, r13.getString(2131887579), 0);
        goto L84
    L80:
        if (r9.getState() != ShareState.CAC_NOT_CLICK) goto L84;
        b r14 = r8.b;
        if (r14 == null) goto L84;
        r14.xq(ShareType.ExportImage, r9.getDocToken(), r9.getDocType());
    L72:
        r6 = true;
        goto L85
    L123:
        return;
    L9:
        if (r8.getSdkShareDependency() == null) goto L19;
        int r16 = a.a[r0.ordinal()];
        if (r16 != 4) goto L14;
    L32:
        Context r17 = r8.a;
        z6c.a r18 = (z6c.a) ApiUtils.getApi(z6c.a.class);
        if (r18 == null) goto L35;
        r4 = r18.d();
    L36:
        if (r4 == true) goto L38;
        Toast.showFailureText(r17, 2131890614);
        goto L38
    L35:
        r4 = true;
        goto L36
    L14:
        if (r16 == 5) goto L32;
        if (r16 != 6) goto L18;
        Context r19 = r8.a;
        z6c.a r20 = (z6c.a) ApiUtils.getApi(z6c.a.class);
        if (r20 == null) goto L29;
        r4 = r20.b();
    L30:
        if (r4 == true) goto L38;
        Toast.showFailureText(r19, 2131890613);
        goto L38
    L29:
        r4 = true;
        goto L30
    L18:
        if (r16 != 7) goto L19;
        Context r21 = r8.a;
        z6c.a r22 = (z6c.a) ApiUtils.getApi(z6c.a.class);
        if (r22 == null) goto L23;
        r4 = r22.c();
    L24:
        if (r4 == true) goto L38;
        Toast.showFailureText(r21, 2131890615);
        goto L38
    L23:
        r4 = true;
        goto L24
    }

    public ExternalShareView(Context r1, AttributeSet r2, int r3) {
        this(r1, r2);
    }
}
