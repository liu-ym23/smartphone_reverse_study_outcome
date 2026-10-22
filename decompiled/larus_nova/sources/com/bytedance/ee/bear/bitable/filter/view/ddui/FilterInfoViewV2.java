package com.bytedance.ee.bear.bitable.filter.view.ddui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.BitableAsyncRequestBiz;
import com.bytedance.ee.bear.bitable.common.model.condition.EFilterSortFieldInvalidType;
import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.ddui.model.ConditionCellModel;
import com.bytedance.ee.bear.bitable.ddui.model.ConditionItemModel;
import com.bytedance.ee.bear.bitable.ddui.model.ConjunctionModel;
import com.bytedance.ee.bear.bitable.ddui.model.FilterInfoModel;
import com.bytedance.ee.bear.bitable.ddui.model.TextWidgetModel;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0;
import com.bytedance.ee.bear.bitable.filter.condition.k;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import com.bytedance.ee.bear.bitable.filter.view.FilterConjunctionView;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u0002:\u0006\u0085\u0001\u0086\u0001\u0087\u0001B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020$H\u0002J\u0010\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u000101J\b\u00106\u001a\u00020$H\u0002J\b\u00107\u001a\u00020$H\u0002J\u0016\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bJ\u0010\u0010;\u001a\u00020$2\b\u0010<\u001a\u0004\u0018\u00010\u0018J\u001c\u0010=\u001a\u00020$2\u0014\u0010>\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020$0#J\u0015\u0010?\u001a\u00020$2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010@J\r\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020$2\b\u0010C\u001a\u0004\u0018\u00010\u0018J\u0010\u0010D\u001a\u00020$2\b\u0010E\u001a\u0004\u0018\u00010(J\u0010\u0010F\u001a\u00020$2\b\u0010G\u001a\u0004\u0018\u00010*J\u0010\u0010H\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010-J\u0010\u0010J\u001a\u00020$2\b\u0010K\u001a\u0004\u0018\u00010LJ\u0006\u0010M\u001a\u00020\u001aJ\u000e\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020PJ\u001e\u0010Q\u001a\u00020$2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010T\u001a\u00020\u001aJ\u0006\u0010U\u001a\u00020\u001aJ\u0006\u0010V\u001a\u00020\u001aJ\u001c\u0010W\u001a\u00020$2\u0014\u0010>\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020$0#J\u000e\u0010X\u001a\u00020$2\u0006\u0010>\u001a\u00020&J\u0010\u0010Y\u001a\u00020$2\b\b\u0002\u0010Z\u001a\u00020\u001aJ\u0014\u0010[\u001a\u00020$2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010]\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110^H\u0002J\u001c\u0010_\u001a\u00020$2\n\u0010`\u001a\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010a\u001a\u00020\bH\u0002J6\u0010b\u001a\n\u0012\u0004\u0012\u0002Hd\u0018\u00010c\"\u0004\b\u0000\u0010d2\u0006\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010h2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hd0jH\u0016J]\u0010k\u001a\n\u0012\u0004\u0012\u0002Hd\u0018\u00010l\"\u0004\b\u0000\u0010d2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u00182\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020r0q2!\u0010s\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(v\u0012\u0004\u0012\u0002Hd0#H\u0016J\u0010\u0010w\u001a\u00020$2\u0006\u0010a\u001a\u00020\bH\u0016J\u0010\u0010x\u001a\u00020$2\u0006\u0010y\u001a\u00020zH\u0016J7\u0010{\u001a\u00020$2\u0006\u0010|\u001a\u00020\u00182\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~2\u000b\b\u0002\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\f\b\u0002\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J\u0011\u0010\u0083\u0001\u001a\u00020$2\b\u0010G\u001a\u0004\u0018\u00010/J\t\u0010\u0084\u0001\u001a\u00020$H\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/view/ddui/FilterInfoViewV2;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/filter/condition/IFilterConditionView$IDataUpdateAbility;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mConjunctionView", "Lcom/bytedance/ee/bear/bitable/filter/view/FilterConjunctionView;", "mConditionListView", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView;", "mDisplayConditionViewList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/filter/condition/IFilterConditionView;", "Lkotlin/collections/ArrayList;", "mConditionList", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionItemConfig;", "mFilterStepPanel", "Lcom/bytedance/ee/bear/bitable/filter/step/FilterStepPanel;", "mTableId", "", "isTablePartialDenied", "", "Ljava/lang/Boolean;", "mFilterOptions", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterOptions;", "mCurrentFilterInfo", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterInfo;", "mConditionMinCount", "mConditionMaxCount", "mFilterInfoChangedListener", "Lkotlin/Function1;", "", "mFilterActionListener", "Lcom/bytedance/ee/bear/bitable/filter/view/ddui/FilterInfoViewV2$FilterActionListener;", "mWebService", "Lcom/bytedance/ee/bear/browser/Web;", "mAsyncRequestDelegate", "Lcom/bytedance/ee/bear/bitable/AsyncRequestDelegate;", "mItemClickListener", "mEventReportAgent", "Lcom/bytedance/ee/bear/bitable/filter/view/ddui/FilterInfoViewV2$EventReportAgent;", "mActionDelegate", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/IFieldPropertyEditViewHolder$ActionDelegate;", "mSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "initView", "updateView", "setSrcObjInfo", "srcObjInfo", "updateConjunctionView", "updateConditionListView", "setConditionLimitCount", "minCount", "maxCount", "setTableId", "tableId", "setOnItemClickListener", "listener", "setTablePartialDenied", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setViewId", "viewId", "injectWebAbility", "web", "injectAsyncRequestDelegate", "delegate", "setEventReportAgent", "eventReportAgent", "setFragmentManager", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "hasUnreadableCondition", "bindFilterInfo", "filterInfoModel", "Lcom/bytedance/ee/bear/bitable/ddui/model/FilterInfoModel;", "bindFilterData", "filterOptions", "filterInfo", "containsNotSupportedCondition", "containsDeletedCondition", "containsChangedCondition", "setOnFilterInfoChangedListener", "setOnFilterActionListener", "autoAddNewCondition", "autoGenerateNewConditionId", "generateNewCondition", "newConditionId", "createFilterConditionViewList", "", "showFilterStepPanel", "conditionConfig", "index", "queryData", "Lio/reactivex/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "queryType", "Lcom/bytedance/ee/bear/bitable/common/query/EQueryType;", "extraParams", "Lcom/alibaba/fastjson/JSONObject;", "resultType", "Ljava/lang/Class;", "asyncRequest", "Lio/reactivex/Single;", "biz", "Lcom/bytedance/ee/bear/bitable/BitableAsyncRequestBiz;", PrefetchTiming.ROUTER, "data", "", "", "parser", "Lkotlin/ParameterName;", "name", "value", "updateConditionByIndex", "notifyConditionValueChangedManually", "newCondition", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;", "trackFilterClickEvent", "clickEvent", "fieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", OnekeyLoginConstants.CU_KEY_OPERATOR, "Lcom/bytedance/ee/bear/bitable/filter/model/EFilterOperator;", "duration", "Lcom/bytedance/ee/bear/bitable/filter/model/EFilterDuration;", "setActionDelegate", "onDetachedFromWindow", "FilterActionListener", "EventReportAgent", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterInfoViewV2 extends LinearLayout implements k.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f212084i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FilterConjunctionView f212085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConditionListView f212086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<k<?>> f212087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<cs4.a> f212088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f212089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super FilterInfo, Unit> f212090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super String, Unit> f212091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q0.a f212092h;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    static {
    }

    public FilterInfoViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FilterInfoViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setEventReportAgent(b r100) {
    }

    public final void setOnFilterActionListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void setSrcObjInfo(mr4.a r100) {
    }

    public final void setTablePartialDenied(Boolean r100) {
    }

    public final void setViewId(String r100) {
    }

    public final boolean f() {
        Iterator<cs4.a> r100 = this.f212088d.iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        Integer r101 = r100.next().c();
        int r102 = EFilterSortFieldInvalidType.FIELD_UNREADABLE.getValue();
        if (r101 == null) goto L4;
        if (r101.intValue() != r102) goto L4;
        return true;
    L12:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<T> r100 = this.f212087c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k) r100.next()).onDetach();
        goto L4
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k.a
    public final void a(FilterCondition r100) {
        Intrinsics.checkNotNullParameter(r100, "newCondition");
        g(this, "input_click", 12);
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k.a
    public final void b(int r100) {
        ConditionListView r101 = this.f212086b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConditionListView");
        r101 = null;
    L5:
        r101.t(r100);
    }

    public final void e(FilterInfoModel r100) {
        Intrinsics.checkNotNullParameter(r100, "filterInfoModel");
        ConditionListView r101 = null;
        if (r100.getConjunction() == null) goto L54;
        FilterConjunctionView r102 = this.f212085a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mConjunctionView");
        r102 = null;
    L7:
        r102.setVisibility(0);
        ConjunctionModel r103 = r100.getConjunction();
        if (r103 == null) goto L58;
        TextWidgetModel r104 = r103.getLeft();
        if (r104 == null) goto L12;
        String r105 = r104.getText();
    L13:
        if (r105 == null) goto L58;
        TextWidgetModel r106 = r103.getRight();
        if (r106 == null) goto L17;
        String r107 = r106.getText();
    L18:
        if (r107 == null) goto L58;
        if (r103.getCenter() == null) goto L58;
        ConditionCellModel r108 = r103.getCenter();
        if (r108 == null) goto L24;
        final ConditionListView.b r109 = r108.into(getContext());
    L25:
        FilterConjunctionView r110 = this.f212085a;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mConjunctionView");
        r110 = null;
    L28:
        r110.setOnConjunctionValueClickedListener(new FilterInfoViewV2$bindFilterInfo$1$1(this, r109));
        if (r109 == null) goto L58;
        FilterConjunctionView r111 = this.f212085a;
        if (r111 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mConjunctionView");
        r111 = null;
    L33:
        TextWidgetModel r112 = r103.getLeft();
        String r113 = "";
        if (r112 == null) goto L37;
        String r114 = r112.getText();
        if (r114 == null) goto L37;
    L38:
        TextWidgetModel r115 = r103.getRight();
        if (r115 == null) goto L44;
        String r116 = r115.getText();
        if (r116 == null) goto L44;
        r113 = r116;
    L44:
        r111.getClass();
        Intrinsics.checkNotNullParameter(r114, "prefixText");
        Intrinsics.checkNotNullParameter(r109, "conditionCell");
        Intrinsics.checkNotNullParameter(r113, "postText");
        TextView r117 = r111.f212045a;
        if (r117 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("conjunctionPrefixTV");
        r117 = null;
    L47:
        r117.setText(r114);
        ConditionCellView r118 = r111.f212046b;
        if (r118 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mConjunctionValueView");
        r118 = null;
    L50:
        r118.setData(r109);
        TextView r119 = r111.f212047c;
        if (r119 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("conjunctionSuffixTV");
        r119 = null;
    L53:
        r119.setText(r113);
    L37:
        r114 = "";
        goto L38
    L24:
        r109 = null;
        goto L25
    L17:
        r107 = null;
        goto L18
    L12:
        r105 = null;
    L58:
        ArrayList<ConditionItemModel> r120 = r100.getConditions();
        if (r120 != null) goto L61;
    L64:
        boolean r121 = true;
    L66:
        if (r121 == true) goto L79;
        ConditionListView r122 = this.f212086b;
        if (r122 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mConditionListView");
        r122 = null;
    L70:
        r122.setVisibility(0);
        this.f212088d.clear();
        ArrayList r123 = new ArrayList();
        Iterator<T> r124 = r120.iterator();
    L72:
        if (r124.hasNext() == false) goto L74;
        r123.add(((ConditionItemModel) r124.next()).into(getContext()));
        goto L72
    L74:
        this.f212088d.addAll(r123);
        ConditionListView r125 = this.f212086b;
        if (r125 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mConditionListView");
    L78:
        r101.r(this.f212088d);
        return;
    L77:
        r101 = r125;
        goto L78
    L79:
        ConditionListView r126 = this.f212086b;
        if (r126 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mConditionListView");
    L83:
        r101.setVisibility(8);
        return;
    L82:
        r101 = r126;
        goto L83
    L61:
        if (r120.isEmpty() == true) goto L64;
        r121 = false;
        goto L66
    L54:
        FilterConjunctionView r127 = this.f212085a;
        if (r127 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mConjunctionView");
        r127 = null;
    L57:
        r127.setVisibility(8);
        goto L58
    }

    public final void setActionDelegate(q0.a r100) {
        this.f212092h = r100;
        FilterConjunctionView r101 = this.f212085a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConjunctionView");
        r101 = null;
    L5:
        r101.setActionDelegate(this.f212092h);
    }

    public final void setFragmentManager(FragmentManager r100) {
        FilterConjunctionView r101 = this.f212085a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConjunctionView");
        r101 = null;
    L5:
        r101.setFragmentManager(r100);
    }

    public final void setOnFilterInfoChangedListener(Function1<? super FilterInfo, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f212090f = r100;
    }

    public final void setOnItemClickListener(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f212091g = r100;
    }

    public final void setTableId(String r100) {
        this.f212089e = r100;
    }

    public FilterInfoViewV2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f212087c = new ArrayList();
        this.f212088d = new ArrayList();
        LayoutInflater.from(r100).inflate(R.layout.bitable_filter_info_view, this);
        setOrientation(1);
        FilterConjunctionView r103 = (FilterConjunctionView) findViewById(R.id.conjunction_view);
        this.f212085a = r103;
        ConditionListView r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConjunctionView");
        r103 = null;
    L5:
        r103.setOnConjunctionChangedListener(new FilterInfoViewV2$initView$1(this));
        ConditionListView r105 = (ConditionListView) findViewById(R.id.condition_list_view);
        this.f212086b = r105;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mConditionListView");
    L9:
        r104.setOnConditionListener(new d(this));
        return;
    L8:
        r104 = r105;
        goto L9
    }

    public static void g(FilterInfoViewV2 r100, String r101, int r102) {
        r100.getClass();
        HashMap r103 = new HashMap();
        r103.put("click", r101);
        r103.put(PickerReporterConstants.KEY.TARGET, "none");
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k.a
    public final Single c(BitableAsyncRequestBiz r100, Map r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter("getFieldLinkByRecordIds", PrefetchTiming.ROUTER);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "parser");
        String r103 = this.f212089e;
        if (r103 == null) goto L7;
        r101.put("tableId", r103);
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k.a
    public final <T> Observable<T> d(EQueryType r100, JSONObject r101, Class<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "queryType");
        Intrinsics.checkNotNullParameter(r102, "resultType");
        JSONObject r103 = new JSONObject();
        r103.put("tableId", this.f212089e);
        r103.putAll(r101);
        return null;
    }

    public /* synthetic */ FilterInfoViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
