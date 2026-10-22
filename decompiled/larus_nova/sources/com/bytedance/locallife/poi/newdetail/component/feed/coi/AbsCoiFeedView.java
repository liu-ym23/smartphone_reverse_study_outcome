package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.coi.ADInfoData;
import com.ss.android.ugc.aweme.poi.coi.RelationPoiCommonItem;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u00138\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010#\u001a\u0004\u0018\u00010\u00148$@$X¤\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010&\u001a\u00020\u00148$@$X¤\u000e¢\u0006\f\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"¨\u0006/"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/AbsCoiFeedView;", "Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/j;", "Lcom/ss/android/ugc/aweme/poi/coi/RelationPoiCommonItem;", "y", "Lcom/ss/android/ugc/aweme/poi/coi/RelationPoiCommonItem;", "getData", "()Lcom/ss/android/ugc/aweme/poi/coi/RelationPoiCommonItem;", "setData", "(Lcom/ss/android/ugc/aweme/poi/coi/RelationPoiCommonItem;)V", "data", "Lcom/ss/android/ugc/aweme/poi/model/PoiBundle;", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Lcom/ss/android/ugc/aweme/poi/model/PoiBundle;", "getPoiBundle", "()Lcom/ss/android/ugc/aweme/poi/model/PoiBundle;", "setPoiBundle", "(Lcom/ss/android/ugc/aweme/poi/model/PoiBundle;)V", "poiBundle", "Lkotlin/Function1;", "", "", "B", "Lkotlin/jvm/functions/Function1;", "getEnterDetail", "()Lkotlin/jvm/functions/Function1;", "enterDetail", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", RootDescription.ROOT_ELEMENT, "getCoiStyle", "()Ljava/lang/String;", "setCoiStyle", "(Ljava/lang/String;)V", "coiStyle", "getCardClickEventName", "setCardClickEventName", "cardClickEventName", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsCoiFeedView extends BaseDitoView<j> {
    public boolean A;
    public final Function1<String, Unit> B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RelationPoiCommonItem f263153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PoiBundle f263154z;

    public AbsCoiFeedView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsCoiFeedView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract void a0();

    public abstract String getCardClickEventName();

    public abstract String getCoiStyle();

    public abstract View getRoot();

    public abstract void setCardClickEventName(String r100);

    public abstract void setCoiStyle(String r100);

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public final void P() {
        super.P();
        j r100 = getModel();
        if (r100 == null) goto L9;
        RelationPoiCommonItem r101 = r100.c();
        if (r101 == null) goto L10;
        this.f263153y = r101;
        a0();
        return;
    L10:
        return;
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.A == true) goto L8;
        int r100 = com.bytedance.locallife.biz.mob.a.f256703c;
        int r101 = b.f263177a;
        mq6.c r102 = b.a(this.f263153y, this.f263154z, getPosition() + 1);
        String r103 = getCoiStyle();
        if (r103 == null) goto L7;
        r102.d("coi_style", r103);
    L7:
        Unit r104 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_coi_card_show", r102.f514893a);
        this.A = true;
    L8:
        c0("show");
        c0("poi_point_show");
    }

    @Override // com.bytedance.locallife.dito.core.BaseDitoView
    public void onCreate() {
        super.onCreate();
        Object r100 = getDitoViewModel().A.get("poi_bundle");
        if ((r100 instanceof PoiBundle) == false) goto L5;
        PoiBundle r101 = (PoiBundle) r100;
    L6:
        this.f263154z = r101;
        removeAllViews();
        addView(getRoot());
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final RelationPoiCommonItem getData() {
        return this.f263153y;
    }

    public final Function1<String, Unit> getEnterDetail() {
        return this.B;
    }

    public final PoiBundle getPoiBundle() {
        return this.f263154z;
    }

    public final void b0(String r100) {
        ps6.b r101 = HostServiceUtilsKt.j().a();
        if (r101 == null) goto L29;
        RelationPoiCommonItem r102 = this.f263153y;
        if (r102 == null) goto L12;
        ADInfoData r103 = r102.getAdInfo();
        if (r103 == null) goto L12;
        String r104 = r103.getCreativeId();
        if (r104 == null) goto L12;
        String r105 = r104;
    L13:
        RelationPoiCommonItem r106 = this.f263153y;
        if (r106 == null) goto L18;
        ADInfoData r107 = r106.getAdInfo();
        if (r107 == null) goto L18;
        r107.getLogExtra();
    L18:
        RelationPoiCommonItem r108 = this.f263153y;
        if (r108 == null) goto L26;
        ADInfoData r109 = r108.getAdInfo();
        if (r109 == null) goto L26;
        String r110 = r109.getAdExtra();
        if (r110 == null) goto L26;
        String r111 = r110;
    L27:
        r101.a(r100, "poi_name", r105, "", r111);
        return;
    L26:
        r111 = "";
    L12:
        r105 = "";
        goto L13
    }

    public final void c0(String r100) {
        ps6.b r101 = HostServiceUtilsKt.j().a();
        if (r101 == null) goto L29;
        RelationPoiCommonItem r102 = this.f263153y;
        if (r102 == null) goto L12;
        ADInfoData r103 = r102.getAdInfo();
        if (r103 == null) goto L12;
        String r104 = r103.getCreativeId();
        if (r104 == null) goto L12;
        String r105 = r104;
    L13:
        RelationPoiCommonItem r106 = this.f263153y;
        if (r106 == null) goto L18;
        ADInfoData r107 = r106.getAdInfo();
        if (r107 == null) goto L18;
        r107.getLogExtra();
    L18:
        RelationPoiCommonItem r108 = this.f263153y;
        if (r108 == null) goto L26;
        ADInfoData r109 = r108.getAdInfo();
        if (r109 == null) goto L26;
        String r110 = r109.getAdExtra();
        if (r110 == null) goto L26;
        String r111 = r110;
    L27:
        r101.a(r100, "poi_card", r105, "", r111);
        return;
    L26:
        r111 = "";
    L12:
        r105 = "";
        goto L13
    }

    public final void setData(RelationPoiCommonItem r100) {
        this.f263153y = r100;
    }

    public final void setPoiBundle(PoiBundle r100) {
        this.f263154z = r100;
    }

    public final void d0(Function1<? super String, Unit> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFun");
        r100.invoke(r101);
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        String r103 = getCardClickEventName();
        int r104 = b.f263177a;
        mq6.c r105 = b.a(this.f263153y, this.f263154z, getPosition() + 1);
        mq6.a r106 = mq6.c.a.f514894a;
        r105.g(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r101);
        String r107 = getCoiStyle();
        if (r107 == null) goto L5;
        r105.d("coi_style", r107);
    L5:
        Unit r108 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c(r103, r105.f514893a);
        b0("realtime_click");
        b0("poi_point_click");
    }

    public AbsCoiFeedView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.B = new AbsCoiFeedView$enterDetail$1(this, r100);
    }

    public /* synthetic */ AbsCoiFeedView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
