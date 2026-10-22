package com.ss.android.lark.ug.banner.ui.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.ug.banner.ui.view.BaseBannerView;
import com.ss.android.lark.ug.banner.ui.view.CloseIcon;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class BannerTemplateView extends BaseBannerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f444388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f444389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f444390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f444391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CloseIcon f444392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f444393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f9c.a f444394g;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/ug/banner/ui/template/BannerTemplateView$LayoutStyle;", "", "ug-banner-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface LayoutStyle {
    }

    public static abstract class a implements TemplateItemAdapter.b {
        public a() {
        }
    }

    public static abstract class b implements TemplateItemAdapter.c<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f444395a;

        public b() {
        }

        @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.c
        public final int getStyle() {
            return this.f444395a;
        }
    }

    public static final class c implements TemplateItemAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BannerTemplateView f444396a;

        public c(BannerTemplateView r100) {
            this.f444396a = r100;
        }

        @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.a
        public final void a(View r100, String r101) {
            f9c.a r102 = this.f444396a.f444394g;
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }
    }

    public final int getStyle() {
        return this.f444388a;
    }

    private final void setupItemAdapter(RecyclerView r100) {
        TemplateItemAdapter r101 = new TemplateItemAdapter();
        c r102 = new c(this);
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.f444400a = r102;
        r100.setAdapter(r101);
    }

    private final void setupItemDecoration(RecyclerView r100) {
        int r101 = this.f444388a;
        if (r101 != 1) goto L5;
        float r102 = 8.0f;
    L9:
        int r103 = UIUtils.dp2px(getContext(), r102);
        int r104 = UIUtils.dp2px(getContext(), 12.0f);
        r100.addItemDecoration(new SpaceItemDecoration(r104, r103, r104));
        return;
    L5:
        if (r101 == 2) goto L7;
        r102 = 12.0f;
        goto L9
    L7:
        r102 = 20.0f;
        goto L9
    }

    public final void setBannerListener(f9c.a r100) {
        this.f444394g = r100;
    }

    public final void setCloseIconColor(int r100) {
        CloseIcon r101 = this.f444392e;
        if (r101 == null) goto L6;
        r101.setIconColor(r100);
        return;
    }

    public final void setCloseVisible(boolean r100) {
        CloseIcon r101 = this.f444392e;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public final void setListDataSource(b r100) {
        if (r100 != null) goto L7;
        RecyclerView r101 = this.f444393f;
        if (r101 == null) goto L15;
        r101.setVisibility(8);
        return;
    L15:
        return;
    L7:
        RecyclerView r102 = this.f444393f;
        if (r102 == null) goto L16;
        RecyclerView.Adapter r103 = r102.getAdapter();
        if (r103 != null) goto L12;
        return;
    L12:
        if ((r103 instanceof TemplateItemAdapter) == false) goto L18;
        r100.f444395a = this.f444388a;
        TemplateItemAdapter r104 = (TemplateItemAdapter) r103;
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        r104.f444401b = r100;
        r104.notifyDataSetChanged();
        return;
    L18:
        return;
    }

    public final void setSubTitle(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        TextView r102 = this.f444391d;
        if (r102 == null) goto L20;
        r102.setVisibility(8);
        return;
    L20:
        return;
    L13:
        TextView r103 = this.f444391d;
        if (r103 == null) goto L16;
        r103.setVisibility(0);
    L16:
        TextView r104 = this.f444391d;
        if (r104 == null) goto L22;
        r104.setText(r100);
        return;
    L22:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setSubTitleColor(int r100) {
        TextView r101 = this.f444391d;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setTitle(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        TextView r102 = this.f444390c;
        if (r102 == null) goto L20;
        r102.setVisibility(8);
        return;
    L20:
        return;
    L13:
        TextView r103 = this.f444390c;
        if (r103 == null) goto L16;
        r103.setVisibility(0);
    L16:
        TextView r104 = this.f444390c;
        if (r104 == null) goto L22;
        r104.setText(r100);
        return;
    L22:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setTitleColor(int r100) {
        TextView r101 = this.f444390c;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public BannerTemplateView(Context r100, @LayoutStyle int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        this.f444388a = r101;
        LayoutInflater.from(r100).inflate(R.layout.ug_banner_template, this, true);
        this.f444389b = findViewById(R.id.banner_container);
        this.f444390c = (TextView) findViewById(R.id.banner_title);
        this.f444391d = (TextView) findViewById(R.id.banner_sub_title);
        this.f444392e = (CloseIcon) findViewById(R.id.banner_close);
        RecyclerView r102 = (RecyclerView) findViewById(R.id.banner_list);
        this.f444393f = r102;
        if (r102 == null) goto L5;
        r102.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        setupItemAdapter(r102);
        setupItemDecoration(r102);
    L5:
        CloseIcon r103 = this.f444392e;
        if (r103 == null) goto L8;
        r103.setOnClickListener(new i9c.a(this));
    L8:
        addOnAttachStateChangeListener(new i9c.b(this));
    }
}
