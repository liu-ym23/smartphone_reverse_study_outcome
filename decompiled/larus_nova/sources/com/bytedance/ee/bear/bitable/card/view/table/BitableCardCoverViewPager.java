package com.bytedance.ee.bear.bitable.card.view.table;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.SetExTypeBean;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.SetExTypeBeanResult;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.commands.TableExInfo;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.panel.BitablePanelFragment;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.BitablePanelModel;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0002ghB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0006\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010\u001aJ\b\u0010E\u001a\u00020BH\u0002J\u001a\u0010F\u001a\u00020B2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010G\u001a\u0004\u0018\u00010\u0001J\b\u0010H\u001a\u00020BH\u0002J<\u0010I\u001a\u00020B2\b\u0010J\u001a\u0004\u0018\u00010\"2\u0006\u0010K\u001a\u00020\u00102\b\u0010L\u001a\u0004\u0018\u00010\u00102\u0006\u0010M\u001a\u0002032\b\u0010N\u001a\u0004\u0018\u00010\u00102\u0006\u0010O\u001a\u00020\u0010J&\u0010P\u001a\u00020B2\u0006\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u0010J\u0010\u0010U\u001a\u00020B2\u0006\u0010V\u001a\u00020'H\u0002J\u0010\u0010W\u001a\u00020B2\u0006\u0010X\u001a\u00020\u000bH\u0002J\b\u0010Y\u001a\u00020BH\u0002J\u0006\u0010)\u001a\u00020*J\u000e\u0010Z\u001a\u00020B2\u0006\u0010[\u001a\u00020*J\u0006\u0010\\\u001a\u00020BJ\b\u0010]\u001a\u00020BH\u0002J\u0010\u0010^\u001a\u00020B2\u0006\u0010_\u001a\u00020'H\u0002J\u001a\u0010`\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010\u001a2\u0006\u0010a\u001a\u00020'H\u0002J\b\u0010b\u001a\u00020BH\u0002J\n\u0010c\u001a\u0004\u0018\u00010dH\u0002J\b\u0010e\u001a\u00020BH\u0016J\n\u0010f\u001a\u0004\u0018\u00010'H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0012\u0010,\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u00109\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006i"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/table/BitableCardCoverViewPager;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/card/view/table/IPageCoverDelegate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCoverIndexView", "Landroid/widget/TextView;", "mCoverIndexLayout", "Landroid/view/View;", "mCoverViewPager", "Landroidx/viewpager/widget/ViewPager;", "mCoverEmptyView", "mCoverImageView", "Lcom/bytedance/ee/bear/bitable/card/view/table/EmptyCoverView;", "mCoverEmptyText", "mCoverAdapter", "Lcom/bytedance/ee/bear/bitable/card/view/table/RecordPageCoverAdapter;", "mStRecords", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/STRecord;", "mStCell", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/STCell;", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "mStCellList", "", "mDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;", "mCurrentIndex", "mIndexCount", "mContainer", "mCurrentId", "", "mCurrentFieldName", "isCoverShow", "", "Ljava/lang/Boolean;", "isCoverEntryShow", "mCoverEntryView", "mMenuItemCover", "mPageRecordTitleBar", "mCurrentPanel", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelFragment;", "mCardViewModel", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/BitableCardViewModel;", "mCloseView", "mMenuMoreView", "mShareView", "mSubscribeView", "isPortraitStatus", "mPageTitleBar", "isAddType", "mCoverSetListener", "Lcom/bytedance/ee/bear/bitable/card/view/table/BitableCardCoverViewPager$ICoverSetListener;", "getMCoverSetListener", "()Lcom/bytedance/ee/bear/bitable/card/view/table/BitableCardCoverViewPager$ICoverSetListener;", "setMCoverSetListener", "(Lcom/bytedance/ee/bear/bitable/card/view/table/BitableCardCoverViewPager$ICoverSetListener;)V", "updateData", "", "setData", "stRecords", "onBindData", "onCreateView", KtvSubElement.CONTAINER, "processEmptyCoverView", "initDelegate", "delegate", "pageRecordTitleBar", "coverEntryView", "cardViewModel", "itemCover", "pageTitleBar", "setTitleBarViews", "closeView", "shareView", "menuMoreView", "subScribeView", "handleTitleBarPositionChange", "dataType", "handleTitleBarMarginTopChange", "height", "handleCoverEntryStatusChange", "notifyAppBarOffsetChange", "noOffset", "handleEntryClicked", "reportCoverItemChosen", "handlePanelItemClick", "id", "publishCoverStatusCmd", "coverId", "forceDismissPanelIfNeed", "buildBaseOpenEntity", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/AttachmentPreviewTmpData;", "onItemClick", "getToken", "ICoverSetListener", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableCardCoverViewPager extends FrameLayout implements m {
    public static final /* synthetic */ int F = 0;
    public View A;
    public Boolean B;
    public View C;
    public boolean D;
    public b E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f208769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f208770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewPager f208771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f208772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EmptyCoverView f208773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f208774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecordPageCoverAdapter f208775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public cp4.a f208776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public dp4.a<List<AttachmentEntity>> f208777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<dp4.a<List<AttachmentEntity>>> f208778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public gp4.h f208779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f208780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f208781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f208782n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f208783o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f208784p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f208785q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f208786r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f208787s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f208788t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f208789u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public BitablePanelFragment f208790v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BitableCardViewModel f208791w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f208792x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f208793y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f208794z;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c implements com.bytedance.ee.bear.bitable.panel.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableCardCoverViewPager f208795a;

        @Override // com.bytedance.ee.bear.bitable.panel.l
        public final void onExit() {
            tt5.a.h("BitableCardCoverViewPager", "on exit");
            BitableCardCoverViewPager r100 = this.f208795a;
            boolean r101 = !TextUtils.equals(r100.f208783o, "no_cover");
            gp4.h r102 = r100.f208779k;
            if (r102 == null) goto L7;
            BitableAnalytic r103 = r102.q0();
            if (r103 == null) goto L7;
            HashMap r104 = new HashMap();
            r104.put("is_cover", Boolean.valueOf(r101));
            r103.t("ccm_bitable_card_attachment_cover_setting_click", r104);
        L7:
            this.f208795a.f208790v = null;
        }

        public c(BitableCardCoverViewPager r100) {
            this.f208795a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.panel.l
        public final void a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "id");
            BitableCardCoverViewPager r100 = this.f208795a;
            int r101 = BitableCardCoverViewPager.F;
            r100.getClass();
            if (TextUtils.isEmpty(r110) == false) goto L5;
            tt5.a.h("BitableCardCoverViewPager", "no item id");
        L22:
            this.f208795a.e("use_change");
            BitableCardCoverViewPager r111 = this.f208795a;
            r111.f208790v = null;
            b r112 = r111.getMCoverSetListener();
            if (r112 == null) goto L28;
            r112.a();
            return;
        L28:
            return;
        L5:
            r100.f208783o = r110;
            if (TextUtils.equals("no_cover", r110) == false) goto L11;
            View r113 = r100.f208782n;
            if (r113 == null) goto L10;
            r113.setVisibility(8);
        L10:
            r100.g(r100.f208776h, "");
            goto L22
        L11:
            int r102 = ((ArrayList) r100.f208778j).size();
            int r103 = 0;
        L12:
            if (r103 >= r102) goto L22;
            dp4.a<List<AttachmentEntity>> r104 = (dp4.a) ListProtector.get(r100.f208778j, r103);
            fp4.g r105 = r104.f469587a;
            String r106 = r105.f478255b;
            String r107 = r105.f478256c;
            if (r106 == null) goto L18;
            boolean r108 = true;
            if (r106.equals(r110) != true) goto L18;
        L19:
            if (r108 == true) goto L20;
            r103 = r103 + 1;
            goto L12
        L20:
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.model.stmodel.cell.STCell<kotlin.collections.List<com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity>>");
            r100.f208777i = r104;
            r100.f208784p = r107;
            r100.h();
            r100.g(r100.f208776h, r106);
        L18:
            r108 = false;
            goto L19
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f208796a = null;

        static {
            f208796a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.h("BitableCardCoverViewPager", "result: " + ((SetExTypeBeanResult) r100));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f208797a = null;

        static {
            f208797a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.h("BitableCardCoverViewPager", "throw: " + ((Throwable) r100));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.m
    public final void a() {
        dp4.a<List<AttachmentEntity>> r100 = this.f208777i;
        if (r100 != null) goto L5;
    L32:
        tt5.a.h("BitableCardCoverViewPager", "attachmentEntity list is empty");
    L33:
        ip4.r r101 = null;
    L35:
        if (this.f208779k != null) goto L38;
        tt5.a.h("BitableCardCoverViewPager", "delegate is null");
        return;
    L38:
        if (r101 != null) goto L41;
        tt5.a.h("BitableCardCoverViewPager", "tmpData is null");
        return;
    L41:
        com.bytedance.ee.bear.i r102 = (com.bytedance.ee.bear.i) org.koin.java.a.c(com.bytedance.ee.bear.i.class, null, null, 6);
        gp4.h r103 = this.f208779k;
        if (r103 == null) goto L44;
        FragmentActivity r104 = r103.getActivity();
    L45:
        r102.h(r104, r101.f495295c, r101.f495293a);
        return;
    L44:
        r104 = null;
        goto L45
    L5:
        if (r100.f469598l == null) goto L32;
        gp4.h r105 = this.f208779k;
        if (r105 == null) goto L33;
        Fragment r106 = r105.getFragment();
        if (r106 == null) goto L33;
        dp4.a<List<AttachmentEntity>> r107 = this.f208777i;
        if (r107 == null) goto L33;
        List<AttachmentEntity> r108 = r107.f469598l;
        if (r108 == null) goto L33;
        ArrayList r109 = new ArrayList();
        ArrayList r110 = new ArrayList();
        int r111 = r108.size();
        int r112 = 0;
        SpaceThirdPartyOpenEntity r113 = null;
    L19:
        if (r112 >= r111) goto L31;
        AttachmentEntity r114 = (AttachmentEntity) ListProtector.get(r108, r112);
        if (r114 == null) goto L30;
        ArrayList<BaseMoreMenuAction> r115 = new ArrayList();
        r115.add(new SaveToLocalMenuV2());
        DocViewModel r116 = (DocViewModel) com.bytedance.ee.bear.browser.plugin.q.a(r106, DocViewModel.class);
        SpaceThirdPartyOpenEntity r117 = new SpaceThirdPartyOpenEntity("26", r114.getAttachmentToken(), r114.getName());
        r117.setApiExtra(r114.getExtra());
        r117.setMountPoint(r114.getMountPointType());
        r117.setMountNodeToken(r114.getMountNodeToken());
        r117.setPreviewFrom("bitable_attach");
        r117.setBusinessId("bitable_attach");
        r117.setUniqueId(r114.getAttachmentToken());
        r117.setMoreMenuActions(r115);
        if (r116 == null) goto L26;
        r117.setEncryptId(r116.getDocEncryptId());
    L26:
        r117.setOriginToken(String.valueOf(System.currentTimeMillis()));
        if (r112 != this.f208780l) goto L29;
        r113 = r117;
    L29:
        r109.add(r117);
    L30:
        r112 = r112 + 1;
        goto L19
    L31:
        r101 = new ip4.r(this.f208780l, r113, r109, r110);
        goto L35
    }

    public final void c() {
        BitablePanelModel r100 = new BitablePanelModel();
        r100.setTitle(getContext().getString(R.string.Bitable_ItemView_SetRecordCover_Title));
        List<dp4.a<List<AttachmentEntity>>> r101 = this.f208778j;
        if (r101 != null) goto L5;
    L17:
        r100.setContentExtendMode("empty_view");
        EmptyData r102 = new EmptyData();
        Icon r103 = new Icon();
        r103.setImgRes(Integer.valueOf(R.drawable.ccm_empty_neutral_no_content));
        r102.setIcon(r103);
        r102.setText(getContext().getString(R.string.Bitable_ItemView_NoAttachmentField_Desc));
        r100.setExtra(r102);
    L18:
        gp4.h r104 = this.f208779k;
        if (r104 != null) goto L21;
    L44:
        tt5.a.h("BitableCardCoverViewPager", "no delegate");
        return;
    L21:
        if (r104.getActivity() == null) goto L44;
        gp4.h r105 = this.f208779k;
        FragmentManager r106 = null;
        if (r105 == null) goto L27;
        FragmentActivity r107 = r105.getActivity();
        if (r107 == null) goto L27;
        FragmentManager r108 = r107.getSupportFragmentManager();
    L28:
        if (r108 == null) goto L44;
        Context r109 = getContext();
        gp4.h r110 = this.f208779k;
        if (r110 == null) goto L34;
        FragmentActivity r111 = r110.getActivity();
        if (r111 == null) goto L34;
        r106 = r111.getSupportFragmentManager();
    L34:
        this.f208790v = com.bytedance.ee.bear.bitable.panel.e.m(r109, r106, r100, new c(this), null, 32);
        gp4.h r112 = this.f208779k;
        if (r112 == null) goto L39;
        BitableAnalytic r113 = r112.q0();
        if (r113 == null) goto L39;
        HashMap r114 = new HashMap();
        r114.put("click", "cover");
        r114.put(PickerReporterConstants.KEY.TARGET, "ccm_bitable_card_attachment_cover_setting_view");
        r113.t(BitableAnalytic.RecordCardEvent.BITABLE_RECORD_CARD_CLICK, r114);
    L39:
        gp4.h r115 = this.f208779k;
        if (r115 == null) goto L49;
        BitableAnalytic r116 = r115.q0();
        if (r116 == null) goto L50;
        r116.t("ccm_bitable_card_attachment_cover_setting_view", new HashMap());
        return;
    L50:
        return;
    L49:
        return;
    L27:
        r108 = null;
        goto L28
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L17;
        ArrayList<BitablePanelItem> r117 = new ArrayList();
        BitablePanelItem r118 = new BitablePanelItem();
        Icon r119 = new Icon();
        r119.setImgRes(Integer.valueOf(R.drawable.ud_icon_ban_outlined));
        r118.setLeftIcon(r119);
        r118.setId("no_cover");
        r118.setLeftText(getContext().getString(R.string.Bitable_ItemView_NoCover_Option));
        if (TextUtils.equals(this.f208783o, r118.getId()) == false) goto L10;
        com.bytedance.ee.bear.bitable.panel.e.b(r118, true);
        com.bytedance.ee.bear.bitable.panel.e.d(r118, true);
    L10:
        r117.add(r118);
        int r120 = ((ArrayList) this.f208778j).size();
        int r121 = 0;
    L11:
        if (r121 >= r120) goto L16;
        fp4.g r122 = ((dp4.a) ListProtector.get(this.f208778j, r121)).f469587a;
        String r123 = r122.f478255b;
        String r124 = r122.f478256c;
        BitablePanelItem r125 = new BitablePanelItem();
        Icon r126 = new Icon();
        r126.setImgRes(Integer.valueOf(R.drawable.ud_icon_attachment_outlined));
        r125.setLeftIcon(r126);
        r125.setLeftText(r124);
        r125.setId(r123);
        r125.setGroupId("cover_group");
        if (TextUtils.equals(this.f208783o, r125.getId()) == false) goto L15;
        com.bytedance.ee.bear.bitable.panel.e.b(r125, true);
        com.bytedance.ee.bear.bitable.panel.e.d(r125, true);
    L15:
        r117.add(r125);
        r121 = r121 + 1;
        goto L11
    L16:
        r100.setData(r117);
        goto L18
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.m
    public String getToken() {
        BitableCardViewModel r100 = this.f208791w;
        if (r100 == null) goto L7;
        mr4.a r101 = r100.getSrcObjInfo();
        if (r101 == null) goto L7;
        return r101.f514980a;
    L7:
        return null;
    }

    public final void h() {
        if (this.f208787s != null) goto L6;
    L27:
        e("use_change");
        BitablePanelFragment r100 = this.f208790v;
        Drawable r101 = null;
        if (r100 == null) goto L37;
        r100.dismiss();     // Catch: Exception -> L31
    L35:
        this.f208790v = null;
    L31:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L35;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L37:
        if (Intrinsics.areEqual(this.f208785q, Boolean.FALSE) == false) goto L40;
        tt5.a.h("BitableCardCoverViewPager", "isCoverShow :" + this.f208785q);
        return;
    L40:
        if (this.f208775g != null) goto L47;
        RecordPageCoverAdapter r103 = new RecordPageCoverAdapter(getContext(), this);
        this.f208775g = r103;
        ViewPager r104 = this.f208771c;
        if (r104 == null) goto L44;
        r104.setAdapter(r103);
    L44:
        ViewPager r105 = this.f208771c;
        if (r105 == null) goto L47;
        r105.setOnPageChangeListener(new BitableCardCoverViewPager$onBindData$1(this));
    L47:
        dp4.a<List<AttachmentEntity>> r106 = this.f208777i;
        if (r106 == null) goto L50;
        List<AttachmentEntity> r107 = r106.f469598l;
    L51:
        if (r107 != null) goto L53;
    L89:
        RecordPageCoverAdapter r108 = this.f208775g;
        if (r108 == null) goto L92;
        r108.g(null);
    L92:
        View r109 = this.f208772d;
        if (r109 == null) goto L95;
        r109.setVisibility(0);
    L95:
        ViewPager r110 = this.f208771c;
        if (r110 == null) goto L98;
        r110.setVisibility(8);
    L98:
        View r111 = this.f208770b;
        if (r111 == null) goto L101;
        r111.setVisibility(8);
    L101:
        TextView r112 = this.f208774f;
        if (r112 == null) goto L104;
        r112.setText(xo5.a.c(getContext(), R.string.Bitable_ItemView_Cover_NoAttachmentsInField_Desc, "fieldName", this.f208784p));
    L104:
        cp4.a r113 = this.f208776h;
        if (r113 == null) goto L107;
        int r114 = r113.f464644k % 3;
    L108:
        int r115 = RangesKt.coerceAtLeast(r114, 0);
        View r116 = this.f208782n;
        if (r116 == null) goto L116;
        View r117 = r116.findViewById(R.id.cover_container);
        if (r117 == null) goto L116;
        EmptyCoverView r118 = this.f208773e;
        if (r118 == null) goto L115;
        r101 = r118.b(r115);
    L115:
        r117.setBackground(r101);
    L116:
        EmptyCoverView r119 = this.f208773e;
        if (r119 == null) goto L131;
        r119.setTopCircleColorByIndex(r115);
        return;
    L131:
        return;
    L107:
        r114 = 0;
        goto L108
    L53:
        if (r106 == null) goto L59;
        List<AttachmentEntity> r120 = r106.f469598l;
        if (r120 == null) goto L59;
        if (r120.isEmpty() != true) goto L59;
        boolean r121 = true;
    L60:
        if (r121 == true) goto L89;
        View r122 = this.f208772d;
        if (r122 == null) goto L65;
        r122.setVisibility(8);
    L65:
        ViewPager r123 = this.f208771c;
        if (r123 == null) goto L68;
        r123.setVisibility(0);
    L68:
        RecordPageCoverAdapter r124 = this.f208775g;
        if (r124 == null) goto L71;
        r124.g(this.f208777i);
    L71:
        dp4.a<List<AttachmentEntity>> r125 = this.f208777i;
        if (r125 == null) goto L123;
        List<AttachmentEntity> r126 = r125.f469598l;
        if (r126 == null) goto L124;
        List<AttachmentEntity> r127 = r126;
        if (r127 == null) goto L125;
        int r128 = r127.size();
        this.f208781m = r128;
        if (this.f208769a == null) goto L126;
        if (r128 <= 1) goto L86;
        View r129 = this.f208770b;
        if (r129 == null) goto L83;
        r129.setVisibility(0);
    L83:
        String r130 = String.valueOf(this.f208780l + 1) + '/' + this.f208781m;
        TextView r131 = this.f208769a;
        if (r131 == null) goto L127;
        r131.setText(r130);
        return;
    L127:
        return;
    L86:
        View r132 = this.f208770b;
        if (r132 == null) goto L129;
        r132.setVisibility(8);
        return;
    L129:
        return;
    L126:
        return;
    L125:
        return;
    L124:
        return;
    L123:
        return;
    L59:
        r121 = false;
        goto L60
    L50:
        r107 = null;
        goto L51
    L6:
        if (Intrinsics.areEqual(this.f208786r, Boolean.TRUE) == true) goto L8;
        View r133 = this.f208787s;
        if (r133 == null) goto L24;
        r133.setVisibility(8);
    L24:
        View r134 = this.f208788t;
        if (r134 == null) goto L27;
        r134.setVisibility(8);
        goto L27
    L8:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("bitable.mobile.record_subscribe.enable") == false) goto L15;
        View r135 = this.f208788t;
        if (r135 == null) goto L12;
        r135.setVisibility(0);
    L12:
        View r136 = this.f208787s;
        if (r136 == null) goto L27;
        r136.setVisibility(8);
        goto L27
    L15:
        View r137 = this.f208788t;
        if (r137 == null) goto L18;
        r137.setVisibility(8);
    L18:
        View r138 = this.f208787s;
        if (r138 == null) goto L27;
        r138.setVisibility(0);
        goto L27
    }

    public final b getMCoverSetListener() {
        return this.E;
    }

    public BitableCardCoverViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f208778j = new ArrayList();
        Boolean r101 = Boolean.FALSE;
        this.f208785q = r101;
        this.f208786r = r101;
    }

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void d(int r100) {
        View r101 = this.f208789u;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L6:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) r102)).topMargin = r100;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void e(String r100) {
        Integer r101 = null;
        if (TextUtils.equals(this.f208783o, "no_cover") == false) goto L5;
    L78:
        View r102 = this.f208782n;
        if (r102 == null) goto L81;
        r102.setVisibility(8);
    L81:
        this.f208785q = Boolean.FALSE;
        int r103 = UIHelper.dp2px(44.0f) + StatusBarUtil.getStatusBarHeight(getContext());
        if (TextUtils.equals(r100, "use_change") == false) goto L105;
        View r104 = this.f208789u;
        if (r104 == null) goto L86;
        r104.setBackgroundColor(0);
    L86:
        View r105 = this.C;
        if (r105 == null) goto L89;
        r103 = r105.getHeight();
    L89:
        d(r103);
        View r106 = this.f208792x;
        if (r106 == null) goto L92;
        r106.setBackground(null);
    L92:
        View r107 = this.f208794z;
        if (r107 == null) goto L95;
        r107.setBackground(null);
    L95:
        View r108 = this.f208793y;
        if (r108 == null) goto L98;
        r108.setBackground(null);
    L98:
        View r109 = this.f208787s;
        if (r109 == null) goto L101;
        r109.setBackground(null);
    L101:
        View r110 = this.A;
        if (r110 == null) goto L114;
        r110.setBackground(null);
        return;
    L114:
        return;
    L105:
        if (TextUtils.equals(r100, "orientation") == false) goto L116;
        View r111 = this.C;
        if (r111 == null) goto L109;
        r103 = r111.getHeight();
    L109:
        d(r103);
        return;
    L116:
        return;
    L5:
        if (TextUtils.isEmpty(this.f208783o) == true) goto L78;
        if (this.D == true) goto L78;
        gp4.h r112 = this.f208779k;
        if (r112 == null) goto L17;
        FragmentActivity r113 = r112.getActivity();
        if (r113 == null) goto L17;
        Window r114 = r113.getWindow();
        if (r114 == null) goto L17;
        View r115 = b(r114);
        if (r115 == null) goto L17;
        Integer r116 = Integer.valueOf(r115.getMeasuredWidth());
    L18:
        gp4.h r117 = this.f208779k;
        if (r117 == null) goto L27;
        FragmentActivity r118 = r117.getActivity();
        if (r118 == null) goto L27;
        Window r119 = r118.getWindow();
        if (r119 == null) goto L27;
        View r120 = b(r119);
        if (r120 == null) goto L27;
        r101 = Integer.valueOf(r120.getMeasuredHeight());
    L27:
        if (r116 == null) goto L111;
        int r121 = r116.intValue();
        if (r101 == null) goto L40;
        int r122 = r101.intValue();
        if (ku5.c.k(getContext()) == false) goto L36;
        if (Intrinsics.areEqual(this.B, Boolean.FALSE) == false) goto L36;
        int r123 = (int) (((double) r122) * 0.48d);
    L39:
        r121 = r123;
    L36:
        if (r116.intValue() > r101.intValue()) goto L38;
        r123 = r116.intValue();
        goto L39
    L38:
        r123 = r101.intValue();
    L40:
        View r124 = this.f208782n;
        if (r124 == null) goto L43;
        r124.setVisibility(0);
    L43:
        this.f208785q = Boolean.TRUE;
        if (TextUtils.equals(r100, "use_change") == false) goto L69;
        View r125 = this.f208789u;
        if (r125 == null) goto L48;
        r125.setBackground(AppCompatResources.getDrawable(eu5.b.f474075a, R.drawable.bitable_card_page_record_title_round_top));
    L48:
        View r126 = this.f208787s;
        if (r126 == null) goto L51;
        r126.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L51:
        View r127 = this.f208793y;
        if (r127 == null) goto L54;
        r127.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L54:
        View r128 = this.f208794z;
        if (r128 == null) goto L57;
        r128.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L57:
        View r129 = this.f208792x;
        if (r129 == null) goto L60;
        r129.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L60:
        View r130 = this.A;
        if (r130 == null) goto L63;
        r130.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L63:
        d(r121 - UIHelper.dp2px(12.0f));
        View r131 = this.f208782n;
        if (r131 == null) goto L75;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
        if (r132 == null) goto L75;
        r132.height = r121 + 24;
    L75:
        View r133 = this.f208782n;
        if (r133 == null) goto L112;
        r133.requestLayout();
        return;
    L112:
        return;
    L69:
        if (TextUtils.equals(r100, "orientation") == false) goto L75;
        d(r121 - UIHelper.dp2px(12.0f));
        View r134 = this.f208782n;
        if (r134 == null) goto L75;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (r135 == null) goto L75;
        r135.height = r121 + 24;
        goto L75
    L111:
        return;
    L17:
        r116 = null;
        goto L18
    }

    public final void f(boolean r100) {
        if (r100 == true) goto L4;
    L20:
        View r101 = this.f208792x;
        if (r101 == null) goto L23;
        r101.setBackground(null);
    L23:
        View r102 = this.f208794z;
        if (r102 == null) goto L26;
        r102.setBackground(null);
    L26:
        View r103 = this.f208793y;
        if (r103 == null) goto L29;
        r103.setBackground(null);
    L29:
        View r104 = this.f208787s;
        if (r104 == null) goto L32;
        r104.setBackground(null);
    L32:
        View r105 = this.A;
        if (r105 == null) goto L38;
        r105.setBackground(null);
        return;
    L38:
        return;
    L4:
        if (Intrinsics.areEqual(this.f208785q, Boolean.TRUE) == false) goto L20;
        View r106 = this.f208787s;
        if (r106 == null) goto L8;
        r106.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L8:
        View r107 = this.f208793y;
        if (r107 == null) goto L11;
        r107.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L11:
        View r108 = this.f208794z;
        if (r108 == null) goto L14;
        r108.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L14:
        View r109 = this.f208792x;
        if (r109 == null) goto L17;
        r109.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
    L17:
        View r110 = this.A;
        if (r110 == null) goto L36;
        r110.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.bitable_page_view_title_bar_button_bg));
        return;
    }

    public final void setData(cp4.a r100) {
        this.f208776h = r100;
        boolean r101 = true;
        int r102 = 0;
        if (r100 == null) goto L74;
        ((ArrayList) this.f208778j).clear();
        cp4.a r103 = this.f208776h;
        if (r103 == null) goto L7;
        List<dp4.a> r104 = r103.f464646m;
    L8:
        if (r104 != null) goto L10;
    L26:
        BitableCardViewModel r105 = this.f208791w;
        if (r105 == null) goto L36;
        cp4.b r106 = r100.f464634a;
        if (r106 == null) goto L32;
        ETableType r107 = r106.f464675s;
        if (r107 == null) goto L32;
    L34:
        if (r105.isTableAddType(r107) != true) goto L36;
        boolean r108 = true;
    L37:
        this.D = r108;
        cp4.b r109 = r100.f464634a;
        if (r109 != null) goto L40;
    L42:
        boolean r110 = false;
    L43:
        if (r110 == false) goto L60;
        if (r109 != null) goto L46;
    L48:
        boolean r111 = false;
    L49:
        if (r111 == false) goto L60;
        BitableCardViewModel r112 = this.f208791w;
        if (r112 != null) goto L53;
    L55:
        boolean r113 = false;
    L56:
        if (r113 == false) goto L60;
        if (this.D == true) goto L60;
        boolean r114 = true;
    L61:
        this.f208786r = Boolean.valueOf(r114);
        StringBuilder r115 = new StringBuilder("coverChangeAble: ");
        cp4.b r116 = r100.f464634a;
        if (r116 == null) goto L64;
        Boolean r117 = Boolean.valueOf(r116.C);
    L65:
        r115.append(r117);
        r115.append(" isProSubmit: ");
        cp4.b r118 = r100.f464634a;
        if (r118 == null) goto L68;
        Boolean r119 = Boolean.valueOf(r118.g());
    L69:
        r115.append(r119);
        r115.append(" isShowInRecord: ");
        BitableCardViewModel r120 = this.f208791w;
        if (r120 == null) goto L72;
        Boolean r121 = Boolean.valueOf(r120.isShowInRecord());
    L73:
        r115.append(r121);
        r115.append(" isAddType : ");
        r115.append(this.D);
        tt5.a.h("BitableCardCoverViewPager", r115.toString());
        goto L74
    L72:
        r121 = null;
        goto L73
    L68:
        r119 = null;
        goto L69
    L64:
        r117 = null;
        goto L65
    L53:
        if (r112.isShowInRecord() == true) goto L55;
        r113 = true;
        goto L56
    L46:
        if (r109.g() == true) goto L48;
        r111 = true;
    L60:
        r114 = false;
        goto L61
    L40:
        if (r109.C != true) goto L42;
        r110 = true;
    L32:
        r107 = ETableType.CARD;
    L36:
        r108 = false;
        goto L37
    L10:
        if ((!r104.isEmpty()) == false) goto L26;
        Iterator<dp4.a> r122 = r104.iterator();
    L13:
        if (r122.hasNext() == false) goto L26;
        dp4.a r123 = r122.next();
        if (r123 == null) goto L13;
        fp4.g r124 = r123.f469587a;
        if (r124 == null) goto L13;
        FieldCompositeType r125 = r124.f478257d;
        if (r125 == null) goto L13;
        if (r125.getType() != EFieldType.ATTACHMENT) goto L13;
        ((ArrayList) this.f208778j).add(r123);
        goto L13
    L7:
        r104 = null;
    L74:
        this.f208783o = "no_cover";
        if ((!this.f208778j.isEmpty()) == false) goto L96;
        if (r100 == null) goto L82;
        cp4.b r126 = r100.f464634a;
        if (r126 == null) goto L82;
        if (r126.g() == true) goto L82;
    L83:
        if (r101 == false) goto L96;
        int r127 = this.f208778j.size();
    L85:
        if (r102 >= r127) goto L96;
        dp4.a<List<AttachmentEntity>> r128 = (dp4.a) ListProtector.get(this.f208778j, r102);
        fp4.g r129 = r128.f469587a;
        String r130 = r129.f478255b;
        String r131 = r129.f478256c;
        if (r100 == null) goto L91;
        cp4.b r132 = r100.f464634a;
        if (r132 == null) goto L91;
        String r133 = r132.B;
    L93:
        if (TextUtils.equals(r133, r130) == true) goto L94;
        r102 = r102 + 1;
        goto L85
    L94:
        this.f208783o = r130;
        this.f208777i = r128;
        this.f208784p = r131;
    L91:
        r133 = null;
    L82:
        r101 = false;
    L96:
        h();
    }

    public final void setMCoverSetListener(b r100) {
        this.E = r100;
    }

    public BitableCardCoverViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f208778j = new ArrayList();
        Boolean r102 = Boolean.FALSE;
        this.f208785q = r102;
        this.f208786r = r102;
    }

    public final void g(cp4.a r100, String r101) {
        if (this.f208791w != null) goto L5;
        return;
    L5:
        TableExInfo r102 = new TableExInfo(r101);
        if (r100 == null) goto L10;
        cp4.b r103 = r100.f464634a;
        if (r103 == null) goto L10;
        String r104 = r103.f464660d;
    L11:
        SetExTypeBean r105 = new SetExTypeBean(r102, r104);
        BitableCardViewModel r106 = this.f208791w;
        if (r106 == null) goto L17;
        Single<SetExTypeBeanResult> r107 = r106.executeTableAttrCommands(r105);
        if (r107 == null) goto L18;
        r107.subscribe(d.f208796a, e.f208797a);
        return;
    L18:
        return;
    L17:
        return;
    L10:
        r104 = null;
        goto L11
    }

    public BitableCardCoverViewPager(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f208778j = new ArrayList();
        Boolean r103 = Boolean.FALSE;
        this.f208785q = r103;
        this.f208786r = r103;
    }
}
