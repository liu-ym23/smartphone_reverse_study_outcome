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
import com.larus.nova.R;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class ExternalShareView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f216514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f216515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f216516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f216517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ShareItemAdapter f216518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ShareItemModel> f216519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f216520g;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f216521a = null;

        static {
            int[] r100 = new int[ShareType.values().length];
            f216521a = r100;
            r100[ShareType.ExportImage.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f216521a[ShareType.SlideExport.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f216521a[ShareType.More.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f216521a[ShareType.Wechat.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f216521a[ShareType.WechatMoments.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f216521a[ShareType.QQ.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f216521a[ShareType.Weibo.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public void setEditionDoc(boolean r100) {
    }

    private com.bytedance.ee.bear.bizwidget.b.a getSdkShareDependency() {
        if (com.bytedance.ee.bear.bizwidget.a.f216306a != null) goto L5;
        return null;
    L5:
        return new rb5.a();
    }

    public ExternalShareView(Context r100) {
        this(r100, null);
    }

    public final void b(List<ShareItemModel> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L11;
        Iterator<ShareItemModel> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        ShareItemModel r103 = r102.next();
        if (r103 == null) goto L7;
        r101.add(r103.copy());
    L11:
        this.f216519f = r101;
        this.f216518e.y2(r101);
        this.f216518e.notifyDataSetChanged();
    }

    public void setInterceptNotClick(boolean r100) {
        this.f216520g = r100;
    }

    public void setItemImageIconSize(int r100) {
        this.f216518e.f216524c = r100;
    }

    public void setLayoutManager(RecyclerView.LayoutManager r100) {
        this.f216517d.removeItemDecorationAt(0);
        this.f216517d.setLayoutManager(r100);
        this.f216517d.addItemDecoration(new ShareItemDecoration(getContext(), r100));
    }

    public void setOnShareItemClickListener(b r100) {
        this.f216515b = r100;
    }

    public void setTitle(int r100) {
        this.f216516c.setVisibility(0);
        this.f216516c.setText(r100);
    }

    public ExternalShareView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f216520g = true;
        this.f216514a = r100;
        setOrientation(1);
        TextView r102 = new TextView(r100);
        this.f216516c = r102;
        r102.setVisibility(8);
        addView(this.f216516c);
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) this.f216516c.getLayoutParams();
        r103.width = -1;
        r103.height = -2;
        int r104 = n.d(16);
        r103.setMarginStart(r104);
        r103.setMarginEnd(r104);
        this.f216516c.setPadding(0, n.d(12), 0, 0);
        this.f216516c.setEllipsize(TextUtils.TruncateAt.END);
        this.f216516c.setGravity(16);
        this.f216516c.setTextSize(14.0f);
        this.f216516c.setTextColor(r100.getResources().getColor(R.color.text_caption));
        View r105 = LayoutInflater.from(r100).inflate(R.layout.share_widget_share_view, this, true);
        ShareItemAdapter r106 = new ShareItemAdapter();
        this.f216518e = r106;
        r106.y2(this.f216519f);
        this.f216517d = (RecyclerView) r105.findViewById(R.id.share_recycler_view);
        LinearLayoutManager r107 = new LinearLayoutManager(getContext());
        r107.setOrientation(0);
        this.f216517d.setLayoutManager(r107);
        this.f216517d.addItemDecoration(new ShareItemDecoration(r100, r107));
        this.f216517d.setAdapter(this.f216518e);
        ShareItemAdapter r108 = this.f216518e;
        r108.f216523b = new com.bytedance.ee.bear.bizwidget.shareview.a(this);
    }

    public static void a(ExternalShareView r100, ShareItemModel r101) {
        r100.getClass();
        ShareType r102 = r101.getType();
        if (r102 == null) goto L5;
        tt5.a.h("ExternalShareView", "onClickEvent, itemId: " + r101.getItemId());
    L5:
        boolean r103 = true;
        if (r102 != null) goto L9;
    L19:
        boolean r104 = true;
    L38:
        if (r104 == false) goto L123;
        boolean r105 = false;
        if (r102 == null) goto L72;
        int r106 = a.f216521a[r102.ordinal()];
        if (r106 == 1) goto L71;
        if (r106 == 2) goto L62;
        if (r106 != 3) goto L72;
        if (r101.getState() != ShareState.ADMIN_NOT_CLICK) goto L54;
        Toast.showText(r100.f216514a, R.string.CreationMobile_ECM_AdminDisableToast);
    L84:
        boolean r107 = false;
    L85:
        if (r107 == true) goto L88;
        return;
    L88:
        if (r101.getOnClickedListener() == null) goto L106;
        b r108 = r100.f216515b;
        if (r108 == null) goto L105;
        if (r102 != null) goto L93;
    L95:
        if (r102 != null) goto L99;
        r103 = false;
    L99:
        if (r100.f216515b.rF(r101) == true) goto L102;
        return;
    L102:
        if (r100.f216515b.U10(r101) == false) goto L104;
        tt5.a.h("ExternalShareView", "onClickEvent, doShareCustom finished.");
        return;
    L104:
        r105 = r103;
        goto L105
    L93:
        if (r108.Yl(r102) == true) goto L95;
        return;
    L105:
        tt5.a.h("ExternalShareView", "onClickEvent, doShareCustom not handled.");
    L106:
        if (r102 == null) goto L108;
        b r109 = r100.f216515b;
        if (r109 == null) goto L121;
        if (r105 == false) goto L116;
    L117:
        r100.f216515b.s10(r102);
        return;
    L116:
        if (r109.Yl(r102) == true) goto L117;
        return;
    L121:
        return;
    L108:
        if (eu5.c.d() == true) goto L111;
        tt5.a.k("ExternalShareView", "onClickEvent, share type is null, itemId = " + r101.getItemId());
        return;
    L111:
        throw new IllegalStateException("A ShareItemModel without type must custom the onClickedListener and return true.");
    L54:
        if (r101.getState() != ShareState.NOT_CLICK) goto L59;
        if (r100.f216520g == false) goto L59;
        Context r110 = r100.f216514a;
        Toast.showText(r110, r110.getString(R.string.Doc_BizWidget_CannotExportImage), 0);
    L59:
        if (r101.isClickable() == true) goto L72;
        tt5.a.d("ExternalShareView", "onClickEvent, More not clickable, state: " + r101.getState());
        goto L84
    L62:
        if (r101.isClickable() == true) goto L72;
        if (r101.getState() != ShareState.ADMIN_NOT_CLICK) goto L68;
        Toast.showText(r100.f216514a, R.string.CreationMobile_ECM_AdminDisableToast);
        goto L84
    L68:
        if (r101.getState() != ShareState.NOT_CLICK) goto L84;
        Context r111 = r100.f216514a;
        Toast.showText(r111, r111.getString(R.string.Doc_BizWidget_CannotExportImage), 0);
        goto L84
    L71:
        if (r101.isClickable() == true) goto L72;
        if (r101.getState() != ShareState.ADMIN_NOT_CLICK) goto L77;
        Toast.showText(r100.f216514a, R.string.CreationMobile_ECM_AdminDisableToast);
        goto L84
    L77:
        if (r101.getState() != ShareState.NOT_CLICK) goto L80;
        Context r112 = r100.f216514a;
        Toast.showText(r112, r112.getString(R.string.Doc_BizWidget_CannotExportImage), 0);
        goto L84
    L80:
        if (r101.getState() != ShareState.CAC_NOT_CLICK) goto L84;
        b r113 = r100.f216515b;
        if (r113 == null) goto L84;
        r113.xq(ShareType.ExportImage, r101.getDocToken(), r101.getDocType());
    L72:
        r107 = true;
        goto L85
    L123:
        return;
    L9:
        if (r100.getSdkShareDependency() == null) goto L19;
        int r114 = a.f216521a[r102.ordinal()];
        if (r114 != 4) goto L14;
    L32:
        Context r115 = r100.f216514a;
        z6c.a r116 = (z6c.a) ApiUtils.getApi(z6c.a.class);
        if (r116 == null) goto L35;
        r104 = r116.d();
    L36:
        if (r104 == true) goto L38;
        Toast.showFailureText(r115, R.string.Lark_Core_UnableShareToWechat_Toast);
        goto L38
    L35:
        r104 = true;
        goto L36
    L14:
        if (r114 == 5) goto L32;
        if (r114 != 6) goto L18;
        Context r117 = r100.f216514a;
        z6c.a r118 = (z6c.a) ApiUtils.getApi(z6c.a.class);
        if (r118 == null) goto L29;
        r104 = r118.b();
    L30:
        if (r104 == true) goto L38;
        Toast.showFailureText(r117, R.string.Lark_Core_UnableShareToQQ_Toast);
        goto L38
    L29:
        r104 = true;
        goto L30
    L18:
        if (r114 != 7) goto L19;
        Context r119 = r100.f216514a;
        z6c.a r120 = (z6c.a) ApiUtils.getApi(z6c.a.class);
        if (r120 == null) goto L23;
        r104 = r120.c();
    L24:
        if (r104 == true) goto L38;
        Toast.showFailureText(r119, R.string.Lark_Core_UnableShareToWeibo_Toast);
        goto L38
    L23:
        r104 = true;
        goto L24
    }

    public ExternalShareView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101);
    }
}
