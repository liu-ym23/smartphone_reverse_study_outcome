package com.ss.android.lark.ug.banner.ui.template;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import i9c.d;
import i9c.e;
import i9c.f;
import i9c.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/ug/banner/ui/template/TemplateItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/ug/banner/ui/template/TemplateItemViewHolder;", "<init>", "()V", "itemClickListener", "Lcom/ss/android/lark/ug/banner/ui/template/TemplateItemAdapter$OnItemClickListener;", "dataSource", "Lcom/ss/android/lark/ug/banner/ui/template/TemplateItemAdapter$TemplateListDataSource;", "Lcom/ss/android/lark/ug/banner/ui/template/TemplateItemAdapter$TemplateItem;", "setDataSource", "", "setOnItemClickListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "OnItemClickListener", "TemplateListDataSource", "TemplateItem", "ug-banner-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateItemAdapter extends RecyclerView.Adapter<TemplateItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f444400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<? extends b> f444401b;

    public interface a {
        void a(View r100, String r101);
    }

    public interface b {
        String a();

        String b();

        String c();

        Integer getBackgroundColor();

        Integer getBorderColor();

        String getTitle();
    }

    public interface c<T extends b> {
        BannerTemplateView.a getItem(int r100);

        int getStyle();

        int size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        c<? extends b> r100 = this.f444401b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public TemplateItemAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        TemplateItemViewHolder r101 = (TemplateItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        c<? extends b> r102 = this.f444401b;
        if (r102 == null) goto L25;
        BannerTemplateView.a r103 = r102.getItem(r110);
        if (r103 == null) goto L26;
        r101.f444402a.setTitle(r103.getTitle());
        String r104 = r103.c();
        if (r104 == null) goto L10;
        r101.f444402a.setFrontImageUrl(r104);
    L10:
        String r105 = r103.b();
        if (r105 == null) goto L13;
        r101.f444402a.setBackImageUrl(r105);
    L13:
        i9c.c r106 = r101.f444402a;
        Integer r107 = r103.getBackgroundColor();
        int r108 = 0;
        if (r107 == null) goto L16;
        int r109 = r107.intValue();
    L17:
        Integer r111 = r103.getBorderColor();
        if (r111 == null) goto L20;
        r108 = r111.intValue();
    L20:
        View r112 = r106.f488832a;
        if (r112 == null) goto L23;
        int r113 = g9c.a.f480537a;
        Context r114 = r106.getContext();
        float r115 = UIUtils.dp2px(r114, 8.0f);
        int r116 = UIUtils.dp2px(r114, 1.0f);
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        r112.setBackground(g9c.a.C5997a.a(r115, r109, r116, r108));
    L23:
        r101.f444402a.setOnClickListener(new com.ss.android.lark.ug.banner.ui.template.a(this, r110, r103));
        return;
    L16:
        r109 = 0;
        goto L17
    L26:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        c<? extends b> r102 = this.f444401b;
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.getStyle());
    L6:
        if (r103 != null) goto L9;
    L11:
        if (r103 != null) goto L14;
    L16:
        if (r103 != null) goto L19;
    L21:
        i9c.c r104 = new d(r100.getContext());
    L23:
        return new TemplateItemViewHolder(r104);
    L19:
        if (r103.intValue() != 3) goto L21;
        r104 = new g(r100.getContext());
        goto L23
    L14:
        if (r103.intValue() != 2) goto L16;
        r104 = new f(r100.getContext());
        goto L23
    L9:
        if (r103.intValue() != 1) goto L11;
        r104 = new e(r100.getContext());
        goto L23
    L5:
        r103 = null;
        goto L6
    }
}
