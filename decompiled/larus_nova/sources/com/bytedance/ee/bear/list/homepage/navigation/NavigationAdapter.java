package com.bytedance.ee.bear.list.homepage.navigation;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Constraints;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import kotlin.jvm.internal.Intrinsics;
import lc5.f;
import lc5.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class NavigationAdapter extends BaseQuickAdapter<c, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f228301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f228302b;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f228303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f228304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ NavigationAdapter f228305e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r110) {
            b r111 = this.f228305e.f228301a;
            if (r111 == null) goto L50;
            int r100 = this.f228303c.getAdapterPosition();
            c r101 = this.f228304d;
            NavigationFragment r112 = ((com.bytedance.ee.bear.list.homepage.navigation.b) r111).f228324a;
            int r102 = NavigationFragment.f228308l;
            r112.getClass();
            tt5.a.h("NavigationFragment", "onItemClick()...position = " + r100 + ", item = " + r101.f228325a);
            StringBuilder r103 = new StringBuilder("onNavigationItemClick()...item = ");
            r103.append(r101.f228325a);
            tt5.a.h("NavigationFragment", r103.toString());
            com.bytedance.ee.bear.contract.d r104 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
            h r105 = (h) org.koin.java.a.a(h.class);
            int r106 = r101.f228325a;
            NavigationEnum r107 = NavigationEnum.TEMPLATE;
            if (r106 != r107.f228307id) goto L8;
            TemplateReport.c("from_space_icon");
            t0.x(r105);
            f.a r108 = f.f508440a;
            f.a.T(r104, "templates", null, "home", null);
            f.f(r104, "templates");
        L15:
            String r109 = NavigationFragment.U90(r101.f228325a);
            f.a r113 = f.f508440a;
            Intrinsics.checkNotNullParameter(r104, "analyticService");
            Intrinsics.checkNotNullParameter(r109, "type");
            JSONObject r114 = new JSONObject();
            r114.put("function_type", r109);
            if (qc5.a.h() == false) goto L18;
            String r115 = "new_format";
        L19:
            r114.put("space_version", r115);
            r104.a("icon_click", r114);
            int r116 = r101.f228325a;
            if (r116 != NavigationEnum.WIKI.f228307id) goto L23;
            f.j(new p("home", r112.m6(), "wiki", "ccm_space_wiki_page_view", r112.m6(), "ccm_space_home_page_click"));
            return;
        L23:
            if (r116 != NavigationEnum.MY_SPACE.f228307id) goto L26;
            f.j(new p("home", r112.m6(), WikiSpaceType.PERSONAL, "ccm_space_personal_page_view", r112.m6(), "ccm_space_home_page_click"));
            return;
        L26:
            if (r116 != NavigationEnum.SHARED_SPACE.f228307id) goto L29;
            f.j(new p("home", r112.m6(), "shared", "ccm_space_shared_page_view", r112.m6(), "ccm_space_home_page_click"));
            return;
        L29:
            if (r116 != NavigationEnum.FAVORITE.f228307id) goto L32;
            f.j(new p("home", r112.m6(), "favorites", "ccm_space_favorites_page_view", r112.m6(), "ccm_space_home_page_click"));
            return;
        L32:
            if (r116 != NavigationEnum.MANUAL_OFFLINE.f228307id) goto L35;
            f.j(new p("home", r112.m6(), OperationName.OPERATION_OFFLINE_AVAILABLE, "ccm_space_offline_page_view", r112.m6(), "ccm_space_home_page_click"));
            return;
        L35:
            if (r116 != r107.f228307id) goto L38;
            f.j(new p("home", r112.m6(), "templates", "ccm_template_systemcenter_view", r112.m6(), "ccm_space_home_page_click"));
            return;
        L38:
            if (r116 != NavigationEnum.MY_DRIVE.f228307id) goto L41;
            f.j(new p("home", r112.m6(), WikiSpaceType.PERSONAL, "ccm_space_personal_page_view", r112.m6(), "ccm_space_home_page_click"));
            return;
        L41:
            if (r116 != NavigationEnum.MY_LIBRARY.f228307id) goto L44;
            f.j(new p("home", r112.m6(), "my_docs", "ccm_docs_page_view", r112.m6(), "ccm_space_home_page_click"));
            return;
        L44:
            if (r116 != NavigationEnum.AI.f228307id) goto L47;
            f.j(new p("home", r112.m6(), "ai_qa", "", r112.m6(), "ccm_space_home_page_click"));
            return;
        L47:
            if (r116 != NavigationEnum.AI_NOTE.f228307id) goto L60;
            f.j(new p("home", r112.m6(), "ai_notes", "", r112.m6(), "ccm_space_home_page_click"));
            return;
        L60:
            return;
        L18:
            r115 = "original";
            goto L19
        L8:
            if (r106 == NavigationEnum.AI.f228307id) goto L10;
            r105.w2("/list/space/activity").j("extra_destination", r101.f228325a).e();
            goto L15
        L10:
            if (r112.f228315k == null) goto L15;
            if (r112.getContext() == null) goto L15;
            r112.f228315k.d(r112.getContext());
            goto L15
        }

        public a(NavigationAdapter r100, d r101, c r102) {
            this.f228305e = r100;
            this.f228303c = r101;
            this.f228304d = r102;
        }
    }

    public interface b {
    }

    public NavigationAdapter() {
        super(0);
    }

    public final d z2() {
        return new d(new NavigationItemView(this.mContext, null));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, c r101) {
        y2((d) r100, r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        return z2();
    }

    public final void y2(d r100, c r101) {
        r100.f228329a.f228318a.setImageResource(kac.a.b(r101.f228326b));
        NavigationItemView r102 = r100.f228329a;
        String r103 = this.mContext.getString(r101.f228327c);
        r102.f228319b.setText(r103);
        Rect r104 = new Rect();
        int r105 = 0;
        r102.f228319b.getPaint().getTextBounds(r103, 0, r103.length(), r104);
        Constraints.LayoutParams r106 = r102.f228321d;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = (r102.f228319b.getLineHeight() / 2) - y9c.d.a(3);
        UDBadgeView r107 = r100.f228329a.f228320c;
        if (r101.f228328d == true) goto L6;
        r105 = 8;
    L6:
        r107.setVisibility(r105);
        r100.f228329a.setOnClickListener(new a(this, r100, r101));
        int r108 = r101.f228325a;
        if (r108 != NavigationEnum.SHARED_SPACE.f228307id) goto L10;
        TextView r109 = r100.f228329a.f228319b;
    L10:
        if (r108 != NavigationEnum.MY_DRIVE.f228307id) goto L13;
        this.f228302b = r100.f228329a.f228319b;
        return;
    }
}
