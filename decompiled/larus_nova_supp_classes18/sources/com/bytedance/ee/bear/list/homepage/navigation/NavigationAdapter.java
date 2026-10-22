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
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import kotlin.jvm.internal.Intrinsics;
import lc5.f;
import lc5.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NavigationAdapter extends BaseQuickAdapter<c, d> {
    public b a;
    public View b;

    public class a extends t {
        public final /* synthetic */ d c;
        public final /* synthetic */ c d;
        public final /* synthetic */ NavigationAdapter e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r13) {
            b r14 = this.e.a;
            if (r14 == null) goto L50;
            int r0 = this.c.getAdapterPosition();
            c r1 = this.d;
            NavigationFragment r15 = ((com.bytedance.ee.bear.list.homepage.navigation.b) r14).a;
            int r2 = NavigationFragment.l;
            r15.getClass();
            tt5.a.h("NavigationFragment", "onItemClick()...position = " + r0 + ", item = " + r1.a);
            StringBuilder r3 = new StringBuilder("onNavigationItemClick()...item = ");
            r3.append(r1.a);
            tt5.a.h("NavigationFragment", r3.toString());
            com.bytedance.ee.bear.contract.d r4 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
            h r5 = (h) org.koin.java.a.a(h.class);
            int r6 = r1.a;
            NavigationEnum r7 = NavigationEnum.TEMPLATE;
            if (r6 != r7.id) goto L8;
            TemplateReport.c("from_space_icon");
            t0.x(r5);
            f.a r8 = f.a;
            f.a.T(r4, "templates", null, "home", null);
            f.f(r4, "templates");
        L15:
            String r9 = NavigationFragment.U90(r1.a);
            f.a r10 = f.a;
            Intrinsics.checkNotNullParameter(r4, "analyticService");
            Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TYPE);
            JSONObject r11 = new JSONObject();
            r11.put("function_type", r9);
            if (qc5.a.h() == false) goto L18;
            String r12 = "new_format";
        L19:
            r11.put("space_version", r12);
            r4.a("icon_click", r11);
            int r16 = r1.a;
            if (r16 != NavigationEnum.WIKI.id) goto L23;
            f.j(new p("home", r15.m6(), DocumentType.WIKI_NAME, "ccm_space_wiki_page_view", r15.m6(), "ccm_space_home_page_click"));
            return;
        L23:
            if (r16 != NavigationEnum.MY_SPACE.id) goto L26;
            f.j(new p("home", r15.m6(), WikiSpaceType.PERSONAL, "ccm_space_personal_page_view", r15.m6(), "ccm_space_home_page_click"));
            return;
        L26:
            if (r16 != NavigationEnum.SHARED_SPACE.id) goto L29;
            f.j(new p("home", r15.m6(), "shared", "ccm_space_shared_page_view", r15.m6(), "ccm_space_home_page_click"));
            return;
        L29:
            if (r16 != NavigationEnum.FAVORITE.id) goto L32;
            f.j(new p("home", r15.m6(), "favorites", "ccm_space_favorites_page_view", r15.m6(), "ccm_space_home_page_click"));
            return;
        L32:
            if (r16 != NavigationEnum.MANUAL_OFFLINE.id) goto L35;
            f.j(new p("home", r15.m6(), OperationName.OPERATION_OFFLINE_AVAILABLE, "ccm_space_offline_page_view", r15.m6(), "ccm_space_home_page_click"));
            return;
        L35:
            if (r16 != r7.id) goto L38;
            f.j(new p("home", r15.m6(), "templates", "ccm_template_systemcenter_view", r15.m6(), "ccm_space_home_page_click"));
            return;
        L38:
            if (r16 != NavigationEnum.MY_DRIVE.id) goto L41;
            f.j(new p("home", r15.m6(), WikiSpaceType.PERSONAL, "ccm_space_personal_page_view", r15.m6(), "ccm_space_home_page_click"));
            return;
        L41:
            if (r16 != NavigationEnum.MY_LIBRARY.id) goto L44;
            f.j(new p("home", r15.m6(), "my_docs", "ccm_docs_page_view", r15.m6(), "ccm_space_home_page_click"));
            return;
        L44:
            if (r16 != NavigationEnum.AI.id) goto L47;
            f.j(new p("home", r15.m6(), "ai_qa", "", r15.m6(), "ccm_space_home_page_click"));
            return;
        L47:
            if (r16 != NavigationEnum.AI_NOTE.id) goto L60;
            f.j(new p("home", r15.m6(), "ai_notes", "", r15.m6(), "ccm_space_home_page_click"));
            return;
        L60:
            return;
        L18:
            r12 = "original";
            goto L19
        L8:
            if (r6 == NavigationEnum.AI.id) goto L10;
            r5.w2("/list/space/activity").j("extra_destination", r1.a).e();
            goto L15
        L10:
            if (r15.k == null) goto L15;
            if (r15.getContext() == null) goto L15;
            r15.k.d(r15.getContext());
            goto L15
        }

        public a(NavigationAdapter r1, d r2, c r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public interface b {
    }

    public NavigationAdapter() {
        super(0);
    }

    public final d z2() {
        return new d(new NavigationItemView(((BaseQuickAdapter) this).mContext, null));
    }

    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        y2((d) r1, (c) r2);
    }

    public final /* bridge */ /* synthetic */ BaseViewHolder onCreateDefViewHolder(ViewGroup r1, int r2) {
        return z2();
    }

    public final void y2(d r7, c r8) {
        r7.a.a.setImageResource(kac.a.b(r8.b));
        NavigationItemView r0 = r7.a;
        String r1 = ((BaseQuickAdapter) this).mContext.getString(r8.c);
        r0.b.setText(r1);
        Rect r2 = new Rect();
        int r5 = 0;
        r0.b.getPaint().getTextBounds(r1, 0, r1.length(), r2);
        Constraints.LayoutParams r3 = r0.d;
        ((ViewGroup.MarginLayoutParams) r3).topMargin = (r0.b.getLineHeight() / 2) - y9c.d.a(3);
        UDBadgeView r4 = r7.a.c;
        if (r8.d == true) goto L6;
        r5 = 8;
    L6:
        r4.setVisibility(r5);
        r7.a.setOnClickListener(new a(this, r7, r8));
        int r9 = r8.a;
        if (r9 != NavigationEnum.SHARED_SPACE.id) goto L10;
        TextView r6 = r7.a.b;
    L10:
        if (r9 != NavigationEnum.MY_DRIVE.id) goto L13;
        this.b = r7.a.b;
        return;
    }
}
