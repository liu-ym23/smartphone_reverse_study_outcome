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
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 '2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002'(B\u0019\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0016J \u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0013H\u0002R\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0007¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/templates/banner/TemplateBannerAdapter;", "Lcom/bytedance/ee/bear/bizwidget/banner/adapter/BannerAdapter;", "Lcom/bytedance/ee/bear/templates/banner/BannerData;", "Lcom/bytedance/ee/bear/templates/banner/TemplateBannerAdapter$ImageHolder;", "datas", "", "<init>", "(Ljava/util/List;)V", "connectServiceContext", "Lcom/bytedance/ee/bear/contract/ConnectionService;", "kotlin.jvm.PlatformType", "getConnectServiceContext", "()Lcom/bytedance/ee/bear/contract/ConnectionService;", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "getRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "hasReportShow", "", "", "getHasReportShow", "()Ljava/util/Set;", "originDatas", "getOriginDatas", "()Ljava/util/List;", "setOriginDatas", "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindView", "", "holder", "data", "position", "size", "reportBannerShowOrClick", "isShow", "", "Companion", "ImageHolder", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateBannerAdapter extends BannerAdapter<BannerData, ImageHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f238850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f238851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<BannerData> f238852e;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/templates/banner/TemplateBannerAdapter$ImageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ImageHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f238853a;

        public ImageHolder(NiceImageView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f238853a = r100;
        }
    }

    public static final class a {
    }

    static {
    }

    public TemplateBannerAdapter(List<BannerData> r100) {
        super(r100);
        this.f238850c = j.a.f217090a;
        this.f238851d = (h) org.koin.java.a.c(h.class, null, null, 6);
        new LinkedHashSet();
        this.f238852e = new ArrayList();
        this.f238852e = r100;
    }

    public final void z2(boolean r110, BannerData r111) {
        if (r111.getType() != 1) goto L6;
        String r100 = "single template";
    L10:
        if (r110 == false) goto L12;
        String r112 = TemplateReport.f238766a;
        int r113 = y2();
        String r101 = String.valueOf(r111.getBanner_id());
        Intrinsics.checkNotNullParameter(r100, "bannerType");
        JSONObject r102 = new JSONObject();
        r102.put("banner_number", String.valueOf(r113));
        r102.put("banner_type", r100);
        r102.put("banner_id", r101);
        TemplateReport.a().v("show_templateinnerbanner", r102);
        TemplateReportV2 r114 = TemplateReportV2.f238768a;
        String r115 = String.valueOf(r111.getBanner_id());
        JSONObject r116 = new JSONObject();
        r116.put2("click_type", "show_banner");
        r116.put2(PickerReporterConstants.KEY.TARGET, "ccm_template_center_view");
        r116.put2("template_source", TemplateReportV2.f238770c);
        r116.put2("banner_id", r115);
        TemplateReportV2.a().n("ccm_template_systemcenter_view_click", r116);
        return;
    L12:
        String r117 = TemplateReport.f238766a;
        int r118 = y2();
        String r103 = String.valueOf(r111.getBanner_id());
        Intrinsics.checkNotNullParameter(r100, "bannerType");
        JSONObject r104 = new JSONObject();
        r104.put("banner_number", String.valueOf(r118));
        r104.put("banner_type", r100);
        r104.put("banner_id", r103);
        TemplateReport.a().v("click_templateinnerbanner", r104);
        TemplateReportV2 r119 = TemplateReportV2.f238768a;
        String r120 = String.valueOf(r111.getBanner_id());
        JSONObject r121 = new JSONObject();
        r121.put2("click_type", "click_banner");
        r121.put2("template_source", TemplateReportV2.f238770c);
        r121.put2(PickerReporterConstants.KEY.TARGET, "ccm_template_banner_view");
        r121.put2("banner_id", r120);
        TemplateReportV2.a().n(TemplateReportV2.f238769b, r121);
        return;
    L6:
        if (r111.getType() != 2) goto L8;
        r100 = "album";
        goto L10
    L8:
        r100 = "openlink";
        goto L10
    }
}
