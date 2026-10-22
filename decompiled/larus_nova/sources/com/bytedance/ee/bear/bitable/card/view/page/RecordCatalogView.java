package com.bytedance.ee.bear.bitable.card.view.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u001b\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/RecordCatalogView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "catalogText", "Landroid/widget/TextView;", "baseName", "baseRightIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "tableName", "maxWidth", "", "baseNameMaxWidth", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/page/RecordCatalogView$ViewDelegate;", "setRecordCatalog", "", "catalogTitleVisible", "", "baseTitle", "", "tableTitle", "setBaseNameMaxWidth", "setViewDelegate", "setWeight", "view", "weight", "ViewDelegate", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordCatalogView extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f208471g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f208472h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f208473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f208474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f208475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f208476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f208477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f208478f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordCatalogView f208479a;

        public a(RecordCatalogView r100) {
            this.f208479a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            d r101 = this.f208479a.f208478f;
            if (r101 == null) goto L6;
            r101.l();
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordCatalogView f208480a;

        public b(RecordCatalogView r100) {
            this.f208480a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            d r101 = this.f208480a.f208478f;
            if (r101 == null) goto L6;
            r101.n();
            return;
        }
    }

    public static final class c {
    }

    public interface d {
        void l();

        void n();
    }

    static {
        f208471g = y9c.d.a(37);
        f208472h = y9c.d.a(28);
    }

    public RecordCatalogView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setBaseNameMaxWidth(int r100) {
        this.f208477e = r100;
    }

    public final void setViewDelegate(d r100) {
        this.f208478f = r100;
    }

    public RecordCatalogView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f208476d = com.bytedance.ee.util.ui.n.w(r100) - y9c.d.a(32);
        this.f208477e = y9c.d.a(50);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_record_catalog_layout, this, true);
        this.f208473a = (TextView) r102.findViewById(R.id.catalog_text);
        TextView r103 = (TextView) r102.findViewById(R.id.base_name);
        this.f208474b = r103;
        AppCompatImageView r104 = (AppCompatImageView) r102.findViewById(R.id.base_name_right_icon);
        TextView r105 = (TextView) r102.findViewById(R.id.table_name);
        this.f208475c = r105;
        r103.setOnClickListener(new a(this));
        r105.setOnClickListener(new b(this));
    }

    public static void b(TextView r100, int r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        r103.weight = r101;
        r100.setLayoutParams(r103);
    }

    public final void a(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "baseTitle");
        Intrinsics.checkNotNullParameter(r102, "tableTitle");
        String r103 = getContext().getString(R.string.Bitable_QuickAdd_AddTo_Text);
        this.f208473a.setText(r103);
        TextView r104 = this.f208473a;
        if (r100 == false) goto L5;
        int r105 = 0;
    L6:
        r104.setVisibility(r105);
        this.f208474b.setText(r101);
        this.f208475c.setText(r102);
        float r106 = this.f208477e + this.f208475c.getPaint().measureText(r102);
        if (r100 == false) goto L9;
        float r107 = this.f208473a.getPaint().measureText(r103) + f208471g;
    L11:
        if ((r106 + r107) <= this.f208476d) goto L13;
        b(this.f208475c, 1);
        this.f208474b.setMaxWidth(this.f208477e);
        b(this.f208474b, 0);
        return;
    L13:
        b(this.f208474b, 1);
        this.f208474b.setMaxWidth(Integer.MAX_VALUE);
        b(this.f208475c, 0);
        return;
    L9:
        r107 = f208472h;
        goto L11
    L5:
        r105 = 8;
        goto L6
    }
}
