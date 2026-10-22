package com.bytedance.ee.bear.templates.banner;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.banner.adapter.BannerAdapter;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.NiceImageView;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 '2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002'(B\u0019\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0016J \u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0013H\u0002R\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0007¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/templates/banner/TemplateBannerAdapter;", "Lcom/bytedance/ee/bear/bizwidget/banner/adapter/BannerAdapter;", "Lcom/bytedance/ee/bear/templates/banner/BannerData;", "Lcom/bytedance/ee/bear/templates/banner/TemplateBannerAdapter$ImageHolder;", "datas", "", "<init>", "(Ljava/util/List;)V", "connectServiceContext", "Lcom/bytedance/ee/bear/contract/ConnectionService;", "kotlin.jvm.PlatformType", "getConnectServiceContext", "()Lcom/bytedance/ee/bear/contract/ConnectionService;", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "getRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "hasReportShow", "", "", "getHasReportShow", "()Ljava/util/Set;", "originDatas", "getOriginDatas", "()Ljava/util/List;", "setOriginDatas", "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindView", "", "holder", WikiFolderPushPlugin.DATA, "position", "size", "reportBannerShowOrClick", "isShow", "", "Companion", "ImageHolder", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateBannerAdapter extends BannerAdapter<BannerData, ImageHolder> {
    public final j c;
    public final h d;
    public final List<BannerData> e;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/templates/banner/TemplateBannerAdapter$ImageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ImageHolder extends RecyclerView.ViewHolder {
        public final ImageView a;

        public ImageHolder(NiceImageView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public TemplateBannerAdapter(List<BannerData> r4) {
        super(r4);
        this.c = j.a.a;
        this.d = (h) org.koin.java.a.c(h.class, null, null, 6);
        new LinkedHashSet();
        this.e = new ArrayList();
        this.e = r4;
    }

    public final void z2(boolean r10, BannerData r11) {
        if (r11.getType() != 1) goto L6;
        String r0 = "single template";
    L10:
        if (r10 == false) goto L12;
        String r12 = TemplateReport.a;
        int r13 = y2();
        String r8 = String.valueOf(r11.getBanner_id());
        Intrinsics.checkNotNullParameter(r0, "bannerType");
        JSONObject r6 = new JSONObject();
        r6.put("banner_number", String.valueOf(r13));
        r6.put("banner_type", r0);
        r6.put("banner_id", r8);
        TemplateReport.a().v("show_templateinnerbanner", r6);
        TemplateReportV2 r14 = TemplateReportV2.a;
        String r15 = String.valueOf(r11.getBanner_id());
        JSONObject r16 = new JSONObject();
        r16.put("click_type", "show_banner");
        r16.put("target", "ccm_template_center_view");
        r16.put("template_source", TemplateReportV2.c);
        r16.put("banner_id", r15);
        TemplateReportV2.a().n("ccm_template_systemcenter_view_click", r16);
        return;
    L12:
        String r17 = TemplateReport.a;
        int r18 = y2();
        String r9 = String.valueOf(r11.getBanner_id());
        Intrinsics.checkNotNullParameter(r0, "bannerType");
        JSONObject r7 = new JSONObject();
        r7.put("banner_number", String.valueOf(r18));
        r7.put("banner_type", r0);
        r7.put("banner_id", r9);
        TemplateReport.a().v("click_templateinnerbanner", r7);
        TemplateReportV2 r19 = TemplateReportV2.a;
        String r110 = String.valueOf(r11.getBanner_id());
        JSONObject r111 = new JSONObject();
        r111.put("click_type", "click_banner");
        r111.put("template_source", TemplateReportV2.c);
        r111.put("target", "ccm_template_banner_view");
        r111.put("banner_id", r110);
        TemplateReportV2.a().n(TemplateReportV2.b, r111);
        return;
    L6:
        if (r11.getType() != 2) goto L8;
        r0 = "album";
        goto L10
    L8:
        r0 = "openlink";
        goto L10
    }
}
