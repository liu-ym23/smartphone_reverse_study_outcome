package com.bytedance.ee.bear.templates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001aJ\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\u001a\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/templates/TemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/templates/ITemplateViewHolder;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "layoutType", "Lcom/bytedance/ee/bear/templates/LayoutType;", "form", "", "type", "", "categoryName", "uniqueID", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/bytedance/ee/bear/templates/LayoutType;Ljava/lang/String;ILjava/lang/String;J)V", "getCategoryName", "()Ljava/lang/String;", "getUniqueID", "()J", "templateList", "", "Lcom/bytedance/ee/bear/templates/data/TemplateShowItemBaseData;", "templateClickListener", "Lcom/bytedance/ee/bear/templates/TemplateAdapter$TemplateClickListener;", "isConnected", "", "setOnItemClickListener", "", "setTemplateList", "templates", "updateEnable", "enable", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "getItemCount", "onBindViewHolder", "holder", "Companion", "TemplateClickListener", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TemplateAdapter extends RecyclerView.Adapter<ITemplateViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f238754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutType f238755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f238756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f238757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f238758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ao5.e> f238759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f238760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f238761h;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TemplateAdapter f238762a;

        public a(TemplateAdapter r100) {
            this.f238762a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
            if (this.f238762a.f238761h == r101.a()) goto L5;
            this.f238762a.B2(r101.a());
        L5:
            TemplateAdapter r102 = this.f238762a;
            r102.f238761h = r101.a();
        }
    }

    public static final class b {
    }

    public interface c {
        void C(String r100, TemplateV4 r101, int r102, String r103);

        void h(int r100, TemplateV4 r101, String r102);

        void w(TemplateV4 r100);
    }

    public static final class d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TemplateAdapter f238763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f238764d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ao5.e f238765e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            TemplateAdapter r101 = this.f238763c;
            c r102 = r101.f238760g;
            if (r102 == null) goto L6;
            r102.h(this.f238764d, (TemplateV4) this.f238765e, r101.f238757d);
            return;
        }

        public d(TemplateAdapter r100, int r101, ao5.e r102) {
            this.f238763c = r100;
            this.f238764d = r101;
            this.f238765e = r102;
            super(300);
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f238759f.size();
    }

    public final void A2(List<ao5.e> r100) {
        Intrinsics.checkNotNullParameter(r100, "templates");
        this.f238759f = r100;
        B2(this.f238761h);
    }

    public final void B2(boolean r100) {
        if (this.f238759f.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<ao5.e> r101 = this.f238759f.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        ao5.e r102 = r101.next();
        if ((r102 instanceof TemplateV4) == false) goto L7;
        TemplateV4 r103 = (TemplateV4) r102;
        if (r103.getEnable() == r100) goto L7;
        r103.setEnable(r100);
        goto L7
    L13:
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 >= this.f238759f.size()) goto L10;
        if (ListProtector.get(this.f238759f, r100) == null) goto L10;
        return ((ao5.e) ListProtector.get(this.f238759f, r100)).getTemplateShowType();
    L10:
        return TemplateShowCardType.SHOW_CARD_TYPE_COMMON.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((ITemplateViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100, r101);
    }

    public void y2(ITemplateViewHolder r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (r110 < this.f238759f.size()) goto L6;
        tt5.a.d("TemplateAdapter", "position = " + r110 + "  list size= " + this.f238759f.size());
        return;
    L6:
        final ao5.e r101 = (ao5.e) ListProtector.get(this.f238759f, r110);
        if ((r101 instanceof TemplateV4) == false) goto L13;
        TemplateV4 r102 = (TemplateV4) r101;
        r100.T3(r102, new AnonymousClass1(this, r101));
        String r103 = TemplateReport.f238766a;
        Integer r104 = Integer.valueOf(r102.getObjType());
        String r105 = r102.getReportName();
        String r106 = r102.getReportToken();
        boolean r107 = r102.checkToken();
        Intrinsics.checkNotNullParameter(r106, "token");
        JSONObject r108 = new JSONObject();
        r108.put("file_type", String.valueOf(r104));
        r108.put("template_name", r105);
        r108.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r106);
        TemplateReport.a().b("singletemplate_exposure", r108, r107);
        c r109 = this.f238760g;
        if (r109 == null) goto L11;
        r109.C(this.f238756c, r102, r110, this.f238757d);
    L11:
        r100.itemView.setOnClickListener(new d(this, r110, r101));
        return;
    L13:
        if ((r101 instanceof ao5.c) == false) goto L15;
        return;
    L15:
        if ((r101 instanceof ao5.d) == false) goto L17;
        r100.U3(((ao5.d) r101).f15794a);
        return;
    L17:
        tt5.a.h("TemplateAdapter", "onBindViewHolder is not when item");
    }

    public ITemplateViewHolder z2(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != TemplateShowCardType.SHOW_CARD_TYPE_BLANK.ordinal()) goto L7;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(this.f238755b.getLayBlankId(), r100, false);
        Intrinsics.checkNotNull(r102);
        return new TemplateViewBlankHolder(r102, this.f238755b);
    L7:
        if (r101 != TemplateShowCardType.SHOW_CARD_TYPE_HEAD.ordinal()) goto L11;
        View r103 = LayoutInflater.from(r100.getContext()).inflate(this.f238755b.getLayHeadId(), r100, false);
        Intrinsics.checkNotNull(r103);
        return new TemplateViewHeadHolder(r103);
    L11:
        if (r101 != TemplateShowCardType.SHOW_CARD_TYPE_EMPTY.ordinal()) goto L14;
        View r104 = LayoutInflater.from(r100.getContext()).inflate(this.f238755b.getLayEmptyId(), r100, false);
        Intrinsics.checkNotNull(r104);
        return new ITemplateViewHolder(r104);
    L14:
        View r105 = LayoutInflater.from(r100.getContext()).inflate(this.f238755b.getLayId(), r100, false);
        Intrinsics.checkNotNull(r105);
        return new TemplateViewHolder2(r105, this.f238755b);
    }

    public /* synthetic */ TemplateAdapter(LifecycleOwner r100, LayoutType r110, String r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r110, r111, 0, null, 0);
    }

    public TemplateAdapter(LifecycleOwner r100, LayoutType r101, String r102, int r103, String r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "layoutType");
        this.f238754a = r100;
        this.f238755b = r101;
        this.f238756c = r102;
        this.f238757d = r104;
        this.f238758e = r105;
        this.f238759f = new ArrayList();
        this.f238761h = true;
        com.bytedance.ee.bear.contract.j r106 = com.bytedance.ee.bear.contract.j.a.f217090a;
        this.f238761h = r106.getNetworkState().a();
        r106.a().observe(r100, new a(this));
    }
}
