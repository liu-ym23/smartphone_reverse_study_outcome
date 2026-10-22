package com.bytedance.ee.bear.templates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001aJ\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\u001a\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "layoutType", "Lcom/bytedance/ee/bear/templates/LayoutType;", DocumentType.BITABLE_FORM_NAME, "", ResourceData.KEY_TYPE, "", "categoryName", "uniqueID", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/bytedance/ee/bear/templates/LayoutType;Ljava/lang/String;ILjava/lang/String;J)V", "getCategoryName", "()Ljava/lang/String;", "getUniqueID", "()J", "templateList", "", "Lcom/bytedance/ee/bear/templates/data/TemplateShowItemBaseData;", "templateClickListener", "Lcom/bytedance/ee/bear/templates/TemplateAdapter$TemplateClickListener;", "isConnected", "", "setOnItemClickListener", "", "setTemplateList", "templates", "updateEnable", "enable", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "getItemCount", "onBindViewHolder", "holder", "Companion", "TemplateClickListener", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TemplateAdapter extends RecyclerView.Adapter<ITemplateViewHolder> {
    public final LifecycleOwner a;
    public final LayoutType b;
    public final String c;
    public final String d;
    public final long e;
    public List<ao5.e> f;
    public c g;
    public boolean h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ TemplateAdapter a;

        public a(TemplateAdapter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
            if (this.a.h == r4.a()) goto L5;
            this.a.B2(r4.a());
        L5:
            TemplateAdapter r0 = this.a;
            r0.h = r4.a();
        }
    }

    public static final class b {
    }

    public interface c {
        void C(String r1, TemplateV4 r2, int r3, String r4);

        void h(int r1, TemplateV4 r2, String r3);

        void w(TemplateV4 r1);
    }

    public static final class d extends t {
        public final /* synthetic */ TemplateAdapter c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ao5.e e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r4) {
            TemplateAdapter r5 = this.c;
            c r0 = r5.g;
            if (r0 == null) goto L6;
            r0.h(this.d, (TemplateV4) this.e, r5.d);
            return;
        }

        public d(TemplateAdapter r1, int r2, ao5.e r3) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            super(300);
        }
    }

    static {
    }

    public final int getItemCount() {
        return this.f.size();
    }

    public final void A2(List<ao5.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "templates");
        this.f = r2;
        B2(this.h);
    }

    public final void B2(boolean r4) {
        if (this.f.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<ao5.e> r0 = this.f.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        ao5.e r1 = r0.next();
        if ((r1 instanceof TemplateV4) == false) goto L7;
        TemplateV4 r2 = (TemplateV4) r1;
        if (r2.getEnable() == r4) goto L7;
        r2.setEnable(r4);
        goto L7
    L13:
        notifyDataSetChanged();
    }

    public final int getItemViewType(int r2) {
        if (r2 >= this.f.size()) goto L10;
        if (ListProtector.get(this.f, r2) == null) goto L10;
        return ((ao5.e) ListProtector.get(this.f, r2)).getTemplateShowType();
    L10:
        return TemplateShowCardType.SHOW_CARD_TYPE_COMMON.ordinal();
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((ITemplateViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    public void y2(ITemplateViewHolder r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        if (r10 < this.f.size()) goto L6;
        tt5.a.d("TemplateAdapter", "position = " + r10 + "  list size= " + this.f.size());
        return;
    L6:
        final ao5.e r0 = (ao5.e) ListProtector.get(this.f, r10);
        if ((r0 instanceof TemplateV4) == false) goto L13;
        TemplateV4 r1 = (TemplateV4) r0;
        r9.T3(r1, new AnonymousClass1(this, r0));
        String r2 = TemplateReport.a;
        Integer r3 = Integer.valueOf(r1.getObjType());
        String r4 = r1.getReportName();
        String r5 = r1.getReportToken();
        boolean r6 = r1.checkToken();
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        JSONObject r7 = new JSONObject();
        r7.put("file_type", String.valueOf(r3));
        r7.put("template_name", r4);
        r7.put("template_id", r5);
        TemplateReport.a().b("singletemplate_exposure", r7, r6);
        c r8 = this.g;
        if (r8 == null) goto L11;
        r8.C(this.c, r1, r10, this.d);
    L11:
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(new d(this, r10, r0));
        return;
    L13:
        if ((r0 instanceof ao5.c) == false) goto L15;
        return;
    L15:
        if ((r0 instanceof ao5.d) == false) goto L17;
        r9.U3(((ao5.d) r0).a);
        return;
    L17:
        tt5.a.h("TemplateAdapter", "onBindViewHolder is not when item");
    }

    public ITemplateViewHolder z2(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != TemplateShowCardType.SHOW_CARD_TYPE_BLANK.ordinal()) goto L7;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(this.b.getLayBlankId(), r3, false);
        Intrinsics.checkNotNull(r5);
        return new TemplateViewBlankHolder(r5, this.b);
    L7:
        if (r4 != TemplateShowCardType.SHOW_CARD_TYPE_HEAD.ordinal()) goto L11;
        View r6 = LayoutInflater.from(r3.getContext()).inflate(this.b.getLayHeadId(), r3, false);
        Intrinsics.checkNotNull(r6);
        return new TemplateViewHeadHolder(r6);
    L11:
        if (r4 != TemplateShowCardType.SHOW_CARD_TYPE_EMPTY.ordinal()) goto L14;
        View r7 = LayoutInflater.from(r3.getContext()).inflate(this.b.getLayEmptyId(), r3, false);
        Intrinsics.checkNotNull(r7);
        return new ITemplateViewHolder(r7);
    L14:
        View r8 = LayoutInflater.from(r3.getContext()).inflate(this.b.getLayId(), r3, false);
        Intrinsics.checkNotNull(r8);
        return new TemplateViewHolder2(r8, this.b);
    }

    public /* synthetic */ TemplateAdapter(LifecycleOwner r9, LayoutType r10, String r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        this(r9, r10, r11, 0, null, 0);
    }

    public TemplateAdapter(LifecycleOwner r1, LayoutType r2, String r3, int r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r1, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r2, "layoutType");
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = new ArrayList();
        this.h = true;
        com.bytedance.ee.bear.contract.j r7 = com.bytedance.ee.bear.contract.j.a.a;
        this.h = r7.getNetworkState().a();
        r7.a().observe(r1, new a(this));
    }
}
