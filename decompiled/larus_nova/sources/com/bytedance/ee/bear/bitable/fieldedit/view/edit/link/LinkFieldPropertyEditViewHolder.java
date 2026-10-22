package com.bytedance.ee.bear.bitable.fieldedit.view.edit.link;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.CommonActionType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldIdResult;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldQueryOptionsModel;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.BitableFieldEditViewModel;
import com.bytedance.ee.bear.bitable.filter.condition.k;
import com.bytedance.ee.bear.bitable.filter.condition.n;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.bytedance.ee.bear.bitable.filter.step.FilterStepPanel;
import com.bytedance.ee.bear.bitable.filter.view.FilterInfoView;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.BitablePanelModel;
import com.bytedance.ee.bear.bitable.panel.l;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\u00020\u0001:\u0001>B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0014J0\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\"\u0010*\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010,H\u0002J\u0012\u0010-\u001a\u00020\u001e2\b\b\u0001\u0010\u001a\u001a\u00020\u0013H\u0002J\u0012\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020\u001eH\u0002J\n\u00106\u001a\u0004\u0018\u00010%H\u0014J\b\u00107\u001a\u00020\u001eH\u0016J\b\u00108\u001a\u00020\u0017H\u0002J\u0012\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u001eH\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0017H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/link/LinkFieldPropertyEditViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BaseFieldPropertyEditViewHolder;", "mContext", "Landroid/content/Context;", "mFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "mPanelData", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData;)V", "mCurrentLinkTable", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$TableBean;", "mQueryFilterOptions", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldQueryOptionsModel;", "mDisplayRangeList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/filter/condition/IFilterConditionView;", "Lkotlin/collections/ArrayList;", "screenHeight", "", "mDisposables", "Lio/reactivex/disposables/CompositeDisposable;", "isRemoteComputeFg", "", "getString", "", "stringRes", "getColor", "colorRes", "initView", "", "initFilterInfoViewConfig", "initClickEvent", "injectFieldInfo", "fieldConfigItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "fieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "injectFieldInfoWithTable", "tableBeanList", "", "showLinkTableDataError", "notifyFieldPropertyOptionChanged", "newFieldPropertyOption", "", "updateNoPermissionLinkTable", "updateLinkTable", "needClear", "asyncFilterOptions", "updateLinkRange", "getCurrentEditProperty", "verifyFailWhenSaveData", "isPortAndDataNotFinish", "getCurrentEditPropertyAsync", "Lio/reactivex/Observable;", "onDetach", "onCheckBoxClicked", "isChecked", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkFieldPropertyEditViewHolder extends BaseFieldPropertyEditViewHolder {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f211448r = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FieldEditPanelData f211449k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FieldEditPanelData.TableBean f211450l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FieldQueryOptionsModel f211451m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<k<?>> f211452n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f211453o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CompositeDisposable f211454p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f211455q;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FieldProperty f211456a;

        public b(FieldProperty r100) {
            this.f211456a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            FieldIdResult r101 = (FieldIdResult) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            FieldProperty r102 = this.f211456a;
            if (r102 == null) goto L5;
            r102.setBackFieldId(r101.getFieldId());
            return r102;
        L5:
            return null;
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkFieldPropertyEditViewHolder f211457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f211458d;

        public static final class a implements l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LinkFieldPropertyEditViewHolder f211459a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f211460b;

            @Override // com.bytedance.ee.bear.bitable.panel.l
            public final /* synthetic */ void onExit() {
            }

            @Override // com.bytedance.ee.bear.bitable.panel.l
            public final void a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "id");
                Intrinsics.checkNotNullParameter(r100, "id");
                if (TextUtils.equals(r100, "true") == false) goto L9;
                LinkFieldPropertyEditViewHolder r101 = this.f211459a;
                int r102 = LinkFieldPropertyEditViewHolder.f211448r;
                BitableFieldEditAnalytic r103 = r101.r().q0();
                if (r103 == null) goto L7;
                LinkFieldPropertyEditViewHolder r104 = this.f211459a;
                r103.S(r104.f211150b, "all_records", "none", Boolean.valueOf(((UDSwitch) r104.f211151c.findViewById(R.id.recordChecker)).isChecked()));
            L7:
                this.f211459a.f211451m.setRangeRuleType(FieldQueryOptionsModel.RangeRuleType.RANGE_RULE_TYPE_ALL);
                this.f211459a.C();
                return;
            L9:
                LinkFieldPropertyEditViewHolder r105 = this.f211459a;
                int r106 = LinkFieldPropertyEditViewHolder.f211448r;
                BitableFieldEditAnalytic r107 = r105.r().q0();
                if (r107 == null) goto L12;
                LinkFieldPropertyEditViewHolder r108 = this.f211459a;
                r107.S(r108.f211150b, "specific_records", "ccm_bitable_duplex_relation_range_view", Boolean.valueOf(((UDSwitch) r108.f211151c.findViewById(R.id.recordChecker)).isChecked()));
            L12:
                ArrayList<FilterCondition> r109 = this.f211459a.f211451m.getConditions();
                if (r109 != null) goto L15;
            L18:
                FilterInfoView.e((FilterInfoView) this.f211460b.findViewById(R.id.filterInfoView));
                return;
            L15:
                if (r109.isEmpty() == true) goto L18;
                this.f211459a.f211451m.setRangeRuleType(FieldQueryOptionsModel.RangeRuleType.RANGE_RULE_TYPE_PORTION);
                this.f211459a.C();
            }

            public a(LinkFieldPropertyEditViewHolder r100, View r101) {
                this.f211459a = r100;
                this.f211460b = r101;
            }
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r110) {
            LinkFieldPropertyEditViewHolder r111 = this.f211457c;
            int r100 = LinkFieldPropertyEditViewHolder.f211448r;
            Integer r101 = null;
            r111.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.SELECT_DATA_RANGE, null);
            LinkFieldPropertyEditViewHolder r112 = this.f211457c;
            FieldEditPanelData.TableBean r102 = r112.f211450l;
            boolean r103 = false;
            if (r102 == null) goto L5;
            boolean r104 = true;
        L7:
            if (r112.f211455q == false) goto L13;
            if (r102 != null) goto L10;
        L11:
            UDToast.show(this.f211457c.f211149a, R.string.Bitable_DataReference_NoPermToEditReferenceConditionDueToInaccessibleReferenceField_Tooltip, R.drawable.ud_icon_warning_outlined);
            return;
        L10:
            if (Intrinsics.areEqual(r102.isPartialDenied(), Boolean.TRUE) == true) goto L11;
        L13:
            if (r104 == true) goto L16;
            LinkFieldPropertyEditViewHolder r113 = this.f211457c;
            Toast.showText(r113.f211149a, r113.z(R.string.Bitable_Relation_SelectLinkTableFirstToast_Mobile));
            return;
        L16:
            Context r105 = this.f211458d.getContext();
            FragmentManager r106 = this.f211457c.r().getFragmentManager();
            BitablePanelModel r107 = new BitablePanelModel();
            LinkFieldPropertyEditViewHolder r114 = this.f211457c;
            r107.setTitle(r114.z(R.string.Bitable_Relation_AvailableDataScope));
            ArrayList<BitablePanelItem> r108 = new ArrayList();
            FieldQueryOptionsModel.RangeRuleType.a r109 = FieldQueryOptionsModel.RangeRuleType.Companion;
            FieldQueryOptionsModel.RangeRuleType r115 = r114.f211451m.getRangeRuleType();
            r109.getClass();
            if (FieldQueryOptionsModel.RangeRuleType.RANGE_RULE_TYPE_PORTION != r115) goto L19;
            r103 = true;
        L19:
            BitablePanelItem r116 = new BitablePanelItem();
            r116.setId(com.bytedance.ee.bear.bitable.panel.e.e(Boolean.TRUE));
            r116.setLeftText(r114.z(R.string.Bitable_Relation_AllRecord));
            com.bytedance.ee.bear.bitable.panel.e.c(r116, !r103);
            com.bytedance.ee.bear.bitable.panel.e.a(r116);
            r108.add(r116);
            BitablePanelItem r117 = new BitablePanelItem();
            r117.setId(com.bytedance.ee.bear.bitable.panel.e.e(Boolean.FALSE));
            r117.setLeftText(r114.z(R.string.Bitable_Relation_SpecifiedRecord));
            com.bytedance.ee.bear.bitable.panel.e.c(r117, r103);
            com.bytedance.ee.bear.bitable.panel.e.a(r117);
            r108.add(r117);
            r107.setData(r108);
            BitableFieldEditViewModel r118 = r114.f211156h;
            if (r118 == null) goto L26;
            MutableLiveData<FieldEditPanelData> r119 = r118.getPanelData();
            if (r119 == null) goto L26;
            FieldEditPanelData r120 = r119.getValue();
            if (r120 == null) goto L26;
            String r121 = r120.getSrcObjToken();
        L27:
            r107.setSrcObjToken(r121);
            BitableFieldEditViewModel r122 = r114.f211156h;
            if (r122 == null) goto L34;
            MutableLiveData<FieldEditPanelData> r123 = r122.getPanelData();
            if (r123 == null) goto L34;
            FieldEditPanelData r124 = r123.getValue();
            if (r124 == null) goto L34;
            r101 = r124.getSrcObjType();
        L34:
            r107.setSrcObjType(r101);
            Unit r125 = Unit.INSTANCE;
            com.bytedance.ee.bear.bitable.panel.e.m(r105, r106, r107, new a(this.f211457c, this.f211458d), null, 48);
            return;
        L26:
            r121 = null;
            goto L27
        L5:
            r104 = false;
            goto L7
        }

        public c(LinkFieldPropertyEditViewHolder r100, View r101) {
            this.f211457c = r100;
            this.f211458d = r101;
        }
    }

    public static final class d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinkFieldPropertyEditViewHolder f211461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f211462d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            LinkFieldPropertyEditViewHolder r101 = this.f211461c;
            int r102 = LinkFieldPropertyEditViewHolder.f211448r;
            r101.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.ADD_NEW_FILTER_CONDITION, null);
            BitableFieldEditAnalytic r103 = this.f211461c.r().q0();
            if (r103 == null) goto L5;
            LinkFieldPropertyEditViewHolder r104 = this.f211461c;
            r103.S(r104.f211150b, "add_condition", "none", Boolean.valueOf(((UDSwitch) r104.f211151c.findViewById(R.id.recordChecker)).isChecked()));
        L5:
            ArrayList<FilterCondition> r105 = this.f211461c.f211451m.getConditions();
            if (r105 == null) goto L8;
            int r106 = r105.size();
        L10:
            if (this.f211461c.f211455q == false) goto L15;
            if (Intrinsics.areEqual(((FilterInfoView) this.f211462d.findViewById(R.id.filterInfoView)).f212062g, Boolean.TRUE) == false) goto L15;
            UDToast.show(this.f211461c.f211149a, R.string.Bitable_DataReference_NoPermToEditReferenceConditionDueToInaccessibleReferenceField_Tooltip, R.drawable.ud_icon_warning_outlined);
            return;
        L15:
            if (r106 < 5) goto L18;
            Context r107 = this.f211461c.f211149a;
            Toast.showText(r107, xo5.a.c(r107, R.string.Bitable_Relation_ConditionNumLimit, "num", "5"));
            return;
        L18:
            if (((FilterInfoView) this.f211462d.findViewById(R.id.filterInfoView)).g() == false) goto L20;
            Context r108 = this.f211461c.f211149a;
            Toast.showText(r108, xo5.a.c(r108, R.string.Bitable_Mobile_Filter_UnsupportedField, "num", "5"));
            return;
        L20:
            FilterInfoView.e((FilterInfoView) this.f211462d.findViewById(R.id.filterInfoView));
            return;
        L8:
            r106 = 1;
            goto L10
        }

        public d(LinkFieldPropertyEditViewHolder r100, View r101) {
            this.f211461c = r100;
            this.f211462d = r101;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkFieldPropertyEditViewHolder f211463a;

        public e(LinkFieldPropertyEditViewHolder r100) {
            this.f211463a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LinkFieldPropertyEditViewHolder r101 = this.f211463a;
            int r102 = LinkFieldPropertyEditViewHolder.f211448r;
            r101.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.CHECK_CHANGED, null);
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T, R> f211464a = null;

        static {
            f211464a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            List r102 = (List) GsonProtectorUtils.fromJson(new Gson(), r101, new com.bytedance.ee.bear.bitable.fieldedit.view.edit.link.a().getType());
            if (r102 == null) goto L5;
            return r102;
        L5:
            return CollectionsKt.emptyList();
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkFieldPropertyEditViewHolder f211465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FieldProperty f211466b;

        public g(LinkFieldPropertyEditViewHolder r100, FieldProperty r101) {
            this.f211465a = r100;
            this.f211466b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            LinkFieldPropertyEditViewHolder r101 = this.f211465a;
            FieldProperty r102 = this.f211466b;
            LinkFieldPropertyEditViewHolder.x(r101, r102, (List) r100);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkFieldPropertyEditViewHolder f211467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FieldProperty f211468b;

        public h(LinkFieldPropertyEditViewHolder r100, FieldProperty r101) {
            this.f211467a = r100;
            this.f211468b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("LinkFieldPropertyEditViewHolderV2", "injectFieldInfo error: " + ((Throwable) r100));
            LinkFieldPropertyEditViewHolder.x(this.f211467a, this.f211468b, null);
        }
    }

    static {
    }

    public final boolean A() {
        FieldQueryOptionsModel.RangeRuleType.a r100 = FieldQueryOptionsModel.RangeRuleType.Companion;
        FieldQueryOptionsModel.RangeRuleType r101 = this.f211451m.getRangeRuleType();
        r100.getClass();
        boolean r102 = false;
        if (FieldQueryOptionsModel.RangeRuleType.RANGE_RULE_TYPE_PORTION != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L17;
        ArrayList<FilterCondition> r104 = this.f211451m.getConditions();
        if (r104 == null) goto L17;
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L17;
        FilterCondition r106 = (FilterCondition) r105.next();
        if (com.bytedance.ee.bear.bitable.filter.model.a.a(r106.getOperator()) == true) goto L11;
        if (r106.getValue() != null) goto L11;
        r102 = true;
    L17:
        return r102;
    L5:
        r103 = false;
        goto L6
    }

    public final void C() {
        FieldQueryOptionsModel.RangeRuleType.a r100 = FieldQueryOptionsModel.RangeRuleType.Companion;
        FieldQueryOptionsModel.RangeRuleType r101 = this.f211451m.getRangeRuleType();
        r100.getClass();
        boolean r102 = true;
        if (FieldQueryOptionsModel.RangeRuleType.RANGE_RULE_TYPE_PORTION != r101) goto L5;
        boolean r103 = true;
    L6:
        BaseFieldPropertyEditViewHolder.w(r103, new View[]{this.f211151c.findViewById(R.id.addNewRangeContainer)});
        if (r103 == false) goto L9;
        int r104 = R.string.Bitable_Relation_SpecifiedRecord;
    L10:
        ((TextView) this.f211151c.findViewById(R.id.linkRangeSelectorTV)).setText(this.f211149a.getText(r104));
        if (r103 == false) goto L21;
        ArrayList<FilterCondition> r105 = this.f211451m.getConditions();
        if (r105 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L21;
        boolean r107 = true;
    L22:
        BaseFieldPropertyEditViewHolder.w(r107, new View[]{this.f211151c.findViewById(R.id.filterInfoView)});
        FilterInfo r108 = new FilterInfo();
        r108.setConjunction(this.f211451m.getConjunction());
        ArrayList<FilterCondition> r109 = this.f211451m.getConditions();
        k<?> r110 = null;
        if (r109 == null) goto L25;
        FilterCondition[] r111 = (FilterCondition[]) r109.toArray(new FilterCondition[0]);
    L26:
        r108.setConditions(r111);
        FilterInfoView r112 = (FilterInfoView) this.f211151c.findViewById(R.id.filterInfoView);
        FilterOptions r113 = r112.f212063h;
        int r114 = FilterInfoView.f212055u;
        r112.f(r113, r108);
        boolean r115 = ((FilterInfoView) this.f211151c.findViewById(R.id.filterInfoView)).g();
        ArrayList<FilterCondition> r116 = this.f211451m.getConditions();
        if (r116 == null) goto L29;
        int r117 = r116.size();
    L31:
        if (r117 >= 5) goto L34;
        if (r115 == true) goto L34;
        boolean r118 = true;
    L36:
        if (this.f211455q == false) goto L51;
        FieldEditPanelData.TableBean r119 = this.f211450l;
        if (r119 == null) goto L40;
        boolean r120 = true;
    L41:
        if (r119 == null) goto L45;
        Boolean r121 = r119.isPartialDenied();
        if (r121 == null) goto L45;
        boolean r122 = r121.booleanValue();
    L46:
        if (r118 == false) goto L50;
        if (r120 == false) goto L50;
        if (r122 == true) goto L50;
        r118 = true;
    L50:
        r118 = false;
    L45:
        r122 = false;
        goto L46
    L40:
        r120 = false;
    L51:
        int r123 = R.color.bitable_field_edit_highlight_tint;
        if (r118 == false) goto L54;
        int r124 = R.color.bitable_field_edit_highlight_tint;
    L55:
        if (r118 == true) goto L58;
        r123 = R.color.text_disable;
    L58:
        com.bytedance.ee.util.ui.l.c((ImageView) this.f211151c.findViewById(R.id.addNewRangeIcon), r124);
        ((TextView) this.f211151c.findViewById(R.id.addNewRangeTV)).setTextColor(y(r123));
        if (r103 == false) goto L79;
        Iterator<k<?>> r125 = ((FilterInfoView) this.f211151c.findViewById(R.id.filterInfoView)).f212058c.iterator();
    L62:
        if (r125.hasNext() == false) goto L74;
        k<?> r126 = r125.next();
        k<?> r127 = r126;
        if ((r127 instanceof n) == false) goto L66;
    L71:
        boolean r128 = true;
    L72:
        if (r128 == false) goto L62;
        r110 = r126;
        goto L74
    L66:
        if ((r127 instanceof com.bytedance.ee.bear.bitable.filter.condition.f) == true) goto L71;
        if ((r127 instanceof com.bytedance.ee.bear.bitable.filter.condition.h) == true) goto L71;
        r128 = false;
    L74:
        if (r110 == null) goto L76;
        boolean r129 = true;
    L77:
        if (r129 == false) goto L79;
        boolean r130 = true;
    L80:
        q0.a r131 = r();
        if (r130 == false) goto L83;
    L85:
        r102 = false;
    L86:
        r131.d(r102);
        return;
    L83:
        if (A() == true) goto L85;
    L76:
        r129 = false;
    L79:
        r130 = false;
        goto L80
    L54:
        r124 = R.color.icon_disable;
    L34:
        r118 = false;
        goto L36
    L29:
        r117 = 0;
        goto L31
    L25:
        r111 = null;
        goto L26
    L15:
        if (r105.isEmpty() == true) goto L18;
        r106 = false;
    L21:
        r107 = false;
        goto L22
    L9:
        r104 = R.string.Bitable_Relation_AllRecord;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void h() {
        if (this.f211450l == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L10;
        Toast.showText(this.f211149a, R.string.Bitable_Relation_SelectLinkTableFirstPopup_Mobile);
        return;
    L10:
        if (A() == false) goto L13;
        Toast.showText(this.f211149a, R.string.Bitable_Relation_FinishSettingsFirstPopup_Mobile);
        return;
    L13:
        return;
    L5:
        r100 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final FieldProperty p() {
        FieldProperty r100 = new FieldProperty();
        FieldEditPanelData r101 = this.f211449k;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getBaseId();
    L6:
        r100.setBaseId(r103);
        FieldEditPanelData.TableBean r104 = this.f211450l;
        if (r104 == null) goto L9;
        r102 = r104.getTableId();
    L9:
        r100.setTableId(r102);
        r100.setMultiple(Boolean.valueOf(((UDSwitch) this.f211151c.findViewById(R.id.recordChecker)).isChecked()));
        ArrayList<FilterCondition> r105 = this.f211451m.getConditions();
        int r106 = 0;
        if (r105 == null) goto L12;
        int r107 = r105.size();
    L13:
        FieldQueryOptionsModel.RangeRuleType.a r108 = FieldQueryOptionsModel.RangeRuleType.Companion;
        FieldQueryOptionsModel.RangeRuleType r109 = this.f211451m.getRangeRuleType();
        r108.getClass();
        if (FieldQueryOptionsModel.RangeRuleType.RANGE_RULE_TYPE_PORTION != r109) goto L16;
        boolean r110 = true;
    L17:
        if (r107 <= 0) goto L23;
        if (r110 == false) goto L23;
        FilterInfo r111 = new FilterInfo();
        r111.setConjunction(this.f211451m.getConjunction());
        FilterCondition[] r112 = new FilterCondition[r107];
    L20:
        if (r106 >= r107) goto L22;
        Intrinsics.checkNotNull(r105);
        r112[r106] = ListProtector.get(r105, r106);
        r106 = r106 + 1;
        goto L20
    L22:
        r111.setConditions(r112);
        r100.setFilterInfo(r111);
    L23:
        return r100;
    L16:
        r110 = false;
        goto L17
    L12:
        r107 = 0;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void t() {
        View r100 = this.f211151c;
        LayoutInflater r101 = LayoutInflater.from(this.f211149a);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        r101.inflate(R.layout.bitable_field_edit_link_operation_view, (ViewGroup) r100);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.rightSelectContainer);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.width = 0;
        r103.weight = 1.0f;
        r102.setLayoutParams(r103);
        LinearLayout r104 = (LinearLayout) r100.findViewById(R.id.titleContainer);
        ViewGroup.LayoutParams r105 = ((LinearLayout) r100.findViewById(R.id.titleContainer)).getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
        r106.width = -2;
        r106.weight = 0.0f;
        r104.setLayoutParams(r106);
        BaseFieldPropertyEditViewHolder.w(true, new View[]{r100.findViewById(R.id.fieldPropertyTvLayout), r100.findViewById(R.id.fieldPropertySelector), r100.findViewById(R.id.fieldPropertySelectorTip)});
        ((TextView) r100.findViewById(R.id.fieldPropertyText)).setText(R.string.Bitable_Field_LinkToTable);
        ((TextView) r100.findViewById(R.id.fieldPropertySelectorTV)).setText(R.string.Bitable_Field_SelectATable);
        ((UDSwitch) r100.findViewById(R.id.recordChecker)).setChecked(true);
        ((UDSwitch) r100.findViewById(R.id.recordChecker)).setOnClickListener(new e(this));
        FilterInfoView r107 = (FilterInfoView) this.f211151c.findViewById(R.id.filterInfoView);
        if (r107 == null) goto L27;
        r107.f212065j = 1;
        r107.f212066k = 5;
        vv4.k r108 = r().c();
        r107.f212069n = r108;
        FilterStepPanel r109 = r107.f212059d;
        if (r109 == null) goto L7;
        r109.a().setWebService(r108);
    L7:
        com.bytedance.ee.bear.bitable.a r110 = r().f();
        r107.f212070o = r110;
        FilterStepPanel r111 = r107.f212059d;
        if (r111 == null) goto L10;
        r111.a().setAsyncRequestDelegate(r110);
    L10:
        r107.setOnFilterInfoChangedListener(new es4.c(this));
        r107.setActionDelegate(r());
        r107.setOnFilterActionListener(new es4.d(this));
        r107.setEventReportAgent(new es4.e(this));
        BitableFieldEditViewModel r112 = this.f211156h;
        Integer r113 = null;
        if (r112 == null) goto L17;
        MutableLiveData<FieldEditPanelData> r114 = r112.getPanelData();
        if (r114 == null) goto L17;
        FieldEditPanelData r115 = r114.getValue();
        if (r115 == null) goto L17;
        String r116 = r115.getSrcObjToken();
    L18:
        BitableFieldEditViewModel r117 = this.f211156h;
        if (r117 == null) goto L25;
        MutableLiveData<FieldEditPanelData> r118 = r117.getPanelData();
        if (r118 == null) goto L25;
        FieldEditPanelData r119 = r118.getValue();
        if (r119 == null) goto L25;
        r113 = r119.getSrcObjType();
    L25:
        r107.setSrcObjInfo(new mr4.a(r116, r113));
        return;
    L17:
        r116 = null;
        goto L18
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final Observable<FieldProperty> i() {
        FieldProperty r100 = p();
        if (this.f211150b.getUiType() != EFieldUIType.DUPLEX_LINK) goto L47;
        FieldProperty r101 = this.f211153e;
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getBackFieldId();
    L8:
        boolean r104 = TextUtils.isEmpty(r103);
        FieldProperty r105 = this.f211153e;
        if (r105 == null) goto L11;
        String r106 = r105.getTableId();
    L12:
        FieldEditPanelData.TableBean r107 = this.f211450l;
        if (r107 == null) goto L15;
        String r108 = r107.getTableId();
    L16:
        boolean r109 = !TextUtils.equals(r106, r108);
        if (r104 == true) goto L28;
        if (r109 == true) goto L28;
        FieldProperty r110 = this.f211153e;
        if (r110 == null) goto L23;
        String r111 = r110.getBackFieldName();
    L24:
        r100.setBackFieldName(r111);
        FieldProperty r112 = this.f211153e;
        if (r112 == null) goto L27;
        r102 = r112.getBackFieldId();
    L27:
        r100.setBackFieldId(r102);
        goto L47
    L23:
        r111 = null;
    L28:
        FieldEditPanelData r113 = this.f211449k;
        if (r113 == null) goto L41;
        FieldEditPanelData.TableBean[] r114 = r113.getTableNameMap();
        if (r114 == null) goto L41;
        int r115 = r114.length;
        int r116 = 0;
    L33:
        if (r116 >= r115) goto L38;
        FieldEditPanelData.TableBean r117 = r114[r116];
        if (TextUtils.equals(r117.getTableId(), this.f211449k.getTableId()) == true) goto L39;
        r116 = r116 + 1;
    L39:
        if (r117 == null) goto L41;
        String r118 = r117.getTableName();
    L42:
        r100.setBackFieldName(r118 + '-' + r().o());
        Observable r119 = r().k(CommonActionType.GET_NEW_FIELD_ID, null, FieldIdResult.class);
        if (r119 != null) goto L45;
        return null;
    L45:
        return r119.map(new b(r100));
    L38:
        r117 = null;
    L41:
        r118 = null;
        goto L42
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    L7:
        r103 = null;
    L47:
        return Observable.just(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void onDetach() {
        super.onDetach();
        this.f211454p.dispose();
        Iterator<T> r100 = this.f211452n.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k) r100.next()).onDetach();
        goto L4
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void s() {
        super.s();
        View r100 = this.f211151c;
        ((LinearLayout) r100.findViewById(R.id.linkRangeSelector)).setOnClickListener(new c(this, r100));
        ((LinearLayout) r100.findViewById(R.id.addNewRangeContainer)).setOnClickListener(new d(this, r100));
    }

    public final void B(int r100) {
        View r101 = this.f211151c;
        AppCompatImageView r102 = (AppCompatImageView) r101.findViewById(R.id.fieldPropertyWarning);
        r102.setVisibility(0);
        r102.setImageResource(R.drawable.ud_icon_warning_colorful);
        r102.setImageTintList(null);
        TextView r103 = (TextView) r101.findViewById(R.id.fieldPropertySelectorTip);
        r103.setTextColor(y(R.color.text_placeholder));
        r103.setText(z(r100));
    }

    public final void D(boolean r110) {
        FieldEditPanelData.TableBean r100 = this.f211450l;
        int r101 = 0;
        if (r100 == null) goto L5;
        boolean r102 = true;
    L7:
        if (r100 == null) goto L9;
        Boolean r103 = r100.isPartialDenied();
    L10:
        View r104 = this.f211151c;
        FilterInfoView r105 = (FilterInfoView) r104.findViewById(R.id.filterInfoView);
        FieldEditPanelData r106 = this.f211449k;
        if (r106 == null) goto L13;
        String r107 = r106.getBaseId();
    L14:
        FieldEditPanelData.TableBean r108 = this.f211450l;
        if (r108 == null) goto L17;
        String r109 = r108.getTableId();
    L18:
        r105.f212060e = r107;
        r105.f212061f = r109;
        FilterStepPanel r111 = r105.f212059d;
        if (r111 == null) goto L21;
        r111.a().setRequestBaseId(r107);
    L21:
        FilterStepPanel r112 = r105.f212059d;
        if (r112 == null) goto L25;
        r112.a().setTableId(r109);
    L25:
        if (this.f211455q == false) goto L27;
        ((FilterInfoView) r104.findViewById(R.id.filterInfoView)).setTablePartialDenied(r103);
    L27:
        ((AppCompatImageView) r104.findViewById(R.id.fieldPropertyWarning)).setVisibility(8);
        TextView r113 = (TextView) r104.findViewById(R.id.fieldPropertySelectorTip);
        int r114 = R.color.text_title;
        if (r102 == false) goto L30;
        int r115 = R.color.text_title;
    L31:
        r113.setTextColor(y(r115));
        if (r102 == false) goto L37;
        FieldEditPanelData.TableBean r116 = this.f211450l;
        if (r116 == null) goto L36;
        String r117 = r116.getTableName();
    L38:
        r113.setText(r117);
        TextView r118 = (TextView) r104.findViewById(R.id.linkRangeTV);
        if (r102 == false) goto L41;
        int r119 = 0;
    L42:
        r118.setVisibility(r119);
        LinearLayout r120 = (LinearLayout) r104.findViewById(R.id.linkRangeSelector);
        if (r102 == false) goto L45;
        int r121 = 0;
    L46:
        r120.setVisibility(r121);
        TextView r122 = (TextView) r104.findViewById(R.id.linkRangeSelectorTV);
        if (r102 == false) goto L49;
        int r123 = R.color.text_title;
    L50:
        r122.setTextColor(y(r123));
        ImageView r124 = (ImageView) r104.findViewById(R.id.linkRangeSelectorIV);
        int r125 = R.color.icon_disable;
        if (r102 == false) goto L53;
        int r126 = R.color.icon_n3;
    L54:
        com.bytedance.ee.util.ui.l.c(r124, r126);
        if (this.f211455q == false) goto L83;
        AppCompatImageView r127 = (AppCompatImageView) r104.findViewById(R.id.fieldPropertyWarning);
        Boolean r128 = Boolean.TRUE;
        if (Intrinsics.areEqual(r103, r128) == false) goto L59;
        int r129 = 0;
    L60:
        r127.setVisibility(r129);
        if (Intrinsics.areEqual(r103, r128) == false) goto L63;
        int r130 = R.drawable.ud_icon_lock_filled;
    L64:
        r127.setImageResource(r130);
        if (Intrinsics.areEqual(r103, r128) == false) goto L67;
        ColorStateList r131 = AppCompatResources.getColorStateList(this.f211149a, R.color.icon_n3);
    L68:
        r127.setImageTintList(r131);
        TextView r132 = (TextView) r104.findViewById(R.id.linkRangeSelectorTV);
        if (r102 == true) goto L71;
    L73:
        r114 = R.color.text_disable;
    L74:
        r132.setTextColor(y(r114));
        ImageView r133 = (ImageView) r104.findViewById(R.id.linkRangeSelectorIV);
        if (r102 == true) goto L77;
    L79:
        com.bytedance.ee.util.ui.l.c(r133, r125);
        LinearLayout r134 = (LinearLayout) r104.findViewById(R.id.no_permission_filter_condition_layout);
        if (r102 == false) goto L82;
        r101 = 8;
    L82:
        r134.setVisibility(r101);
        goto L83
    L77:
        if (Intrinsics.areEqual(r103, r128) == true) goto L79;
        r125 = R.color.icon_n3;
        goto L79
    L71:
        if (Intrinsics.areEqual(r103, r128) == true) goto L73;
    L67:
        r131 = null;
        goto L68
    L63:
        r130 = R.drawable.ud_icon_warning_colorful;
        goto L64
    L59:
        r129 = 8;
    L83:
        String r135 = this.f211451m.getTableId();
        FieldEditPanelData.TableBean r136 = this.f211450l;
        if (r136 == null) goto L86;
        String r137 = r136.getTableId();
    L88:
        if (TextUtils.equals(r135, r137) == false) goto L90;
        C();
        return;
    L90:
        FieldQueryOptionsModel r138 = this.f211451m;
        FieldEditPanelData.TableBean r139 = this.f211450l;
        if (r139 == null) goto L93;
        String r140 = r139.getTableId();
    L94:
        r138.setTableId(r140);
        vv4.k r141 = r().c();
        if (r141 == null) goto L105;
        JSONObject r142 = new JSONObject();
        FieldEditPanelData.TableBean r143 = this.f211450l;
        if (r143 == null) goto L99;
        String r144 = r143.getTableId();
    L100:
        r142.put("tableId", r144);
        int r145 = nr4.a.f520171a;
        Disposable r146 = nr4.a.a(r141, EQueryType.GET_FILTER_OPTIONS, r142, FilterOptions.class, null).subscribe(new es4.a(this, r110), es4.b.f473770a);
        if (r146 == null) goto L106;
        this.f211454p.add(r146);
        return;
    L106:
        return;
    L99:
        r144 = null;
        goto L100
    L105:
        return;
    L93:
        r140 = null;
        goto L94
    L86:
        r137 = null;
        goto L88
    L53:
        r126 = R.color.icon_disable;
        goto L54
    L49:
        r123 = R.color.text_disable;
        goto L50
    L45:
        r121 = 8;
        goto L46
    L41:
        r119 = 8;
        goto L42
    L36:
        r117 = null;
        goto L38
    L37:
        r117 = z(R.string.Bitable_Field_Select);
        goto L38
    L30:
        r115 = R.color.text_placeholder;
        goto L31
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void l(Object r100) {
        FieldQueryOptionsModel r101 = null;
        if ((r100 instanceof FieldEditPanelData.TableBean) == false) goto L5;
        FieldEditPanelData.TableBean r102 = (FieldEditPanelData.TableBean) r100;
    L6:
        if (r102 == null) goto L13;
        this.f211450l = r102;
        boolean r103 = true;
        D(true);
        q0.a r104 = r();
        if (this.f211450l != null) goto L11;
        r103 = false;
    L11:
        r104.d(r103);
    L13:
        if ((r100 instanceof FieldQueryOptionsModel) == false) goto L15;
        r101 = (FieldQueryOptionsModel) r100;
    L15:
        if (r101 == null) goto L18;
        this.f211451m = r101;
        C();
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void v(boolean r100) {
        super.v(r100);
        BitableFieldEditAnalytic r101 = r().q0();
        if (r101 == null) goto L6;
        r101.S(this.f211150b, "allow_adding_multiple_records", "none", Boolean.valueOf(r100));
        return;
    }

    public final int y(int r100) {
        return this.f211149a.getResources().getColor(r100);
    }

    public final String z(int r100) {
        return this.f211149a.getString(r100);
    }

    public LinkFieldPropertyEditViewHolder(Context r100, FieldCompositeType r101, FieldEditPanelData r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFieldCompositeType");
        super(r100, r101);
        this.f211449k = r102;
        this.f211451m = new FieldQueryOptionsModel();
        this.f211452n = new ArrayList();
        this.f211453o = cu5.c.c();
        this.f211454p = new CompositeDisposable();
        this.f211455q = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.mobile.support_remote_compute");
    }

    public static final void x(LinkFieldPropertyEditViewHolder r100, FieldProperty r110, List r111) {
        TextView r101 = (TextView) r100.f211151c.findViewById(R.id.fieldPropertySelectorTip);
        r101.setTextColor(r100.y(R.color.text_placeholder));
        r101.setText(r100.z(R.string.Bitable_Field_Select));
        int r102 = 0;
        r100.r().d(false);
        UDSwitch r103 = (UDSwitch) r100.f211151c.findViewById(R.id.recordChecker);
        boolean r104 = true;
        if (r110 == null) goto L7;
        Boolean r105 = r110.getMultiple();
        if (r105 == null) goto L7;
        boolean r106 = r105.booleanValue();
    L8:
        r103.setChecked(r106);
        FieldEditPanelData r107 = r100.f211449k;
        if (r107 == null) goto L70;
        FieldQueryOptionsModel r108 = r100.f211451m;
        FieldEditPanelData.TableBean r109 = null;
        if (r110 == null) goto L13;
        FilterInfo r112 = r110.getFilterInfo();
    L14:
        r108.setFilterInfo(r112);
        if (r111 == null) goto L47;
        Iterator r113 = r111.iterator();
    L18:
        if (r113.hasNext() == false) goto L26;
        Object r114 = r113.next();
        String r115 = ((FieldEditPanelData.TableBean) r114).getTableId();
        if (r110 == null) goto L22;
        String r116 = r110.getTableId();
    L24:
        if (TextUtils.equals(r115, r116) == false) goto L18;
    L27:
        FieldEditPanelData.TableBean r117 = (FieldEditPanelData.TableBean) r114;
        if (r117 == null) goto L47;
        if (r117.getReadPerimission() == true) goto L47;
        if (r100.f211455q == false) goto L46;
        View r118 = r100.f211151c;
        AppCompatImageView r119 = (AppCompatImageView) r118.findViewById(R.id.fieldPropertyWarning);
        r119.setVisibility(0);
        r119.setImageResource(R.drawable.ud_icon_lock_filled);
        r119.setImageTintList(AppCompatResources.getColorStateList(r100.f211149a, R.color.icon_n3));
        TextView r120 = (TextView) r118.findViewById(R.id.fieldPropertySelectorTip);
        r120.setTextColor(r100.y(R.color.text_placeholder));
        r120.setText(r100.z(R.string.Bitable_AdvancedPermission_NotAccessibleTable));
        FieldQueryOptionsModel.RangeRuleType.a r121 = FieldQueryOptionsModel.RangeRuleType.Companion;
        FieldQueryOptionsModel.RangeRuleType r122 = r100.f211451m.getRangeRuleType();
        r121.getClass();
        if (FieldQueryOptionsModel.RangeRuleType.RANGE_RULE_TYPE_PORTION == r122) goto L37;
        r104 = false;
    L37:
        ((TextView) r118.findViewById(R.id.linkRangeTV)).setVisibility(0);
        ((LinearLayout) r118.findViewById(R.id.linkRangeSelector)).setVisibility(0);
        if (r104 == false) goto L40;
        int r123 = R.string.Bitable_Relation_SpecifiedRecord;
    L41:
        TextView r124 = (TextView) r118.findViewById(R.id.linkRangeSelectorTV);
        r124.setTextColor(r100.y(R.color.text_placeholder));
        r124.setText(r100.f211149a.getText(r123));
        com.bytedance.ee.util.ui.l.c((ImageView) r118.findViewById(R.id.linkRangeSelectorIV), R.color.icon_n3);
        LinearLayout r125 = (LinearLayout) r118.findViewById(R.id.no_permission_filter_condition_layout);
        if (r104 == true) goto L45;
        r102 = 8;
    L45:
        r125.setVisibility(r102);
        return;
    L40:
        r123 = R.string.Bitable_Relation_AllRecord;
        goto L41
    L46:
        r100.B(R.string.Bitable_SingleOption_NoPermToReferencedTableTip_Mobile);
        return;
    L22:
        r116 = null;
        goto L24
    L26:
        r114 = null;
    L47:
        FieldEditPanelData.TableBean[] r126 = r107.getTableNameMap();
        if (r126 == null) goto L59;
        int r127 = r126.length;
        int r128 = 0;
    L50:
        if (r128 >= r127) goto L59;
        FieldEditPanelData.TableBean r129 = r126[r128];
        String r130 = r129.getTableId();
        if (r110 == null) goto L54;
        String r131 = r110.getTableId();
    L56:
        if (TextUtils.equals(r130, r131) == true) goto L57;
        r128 = r128 + 1;
        goto L50
    L57:
        r109 = r129;
        goto L59
    L54:
        r131 = null;
    L59:
        if (r109 != null) goto L68;
        ArrayList<FilterCondition> r132 = r100.f211451m.getConditions();
        if (r132 != null) goto L63;
    L65:
        r104 = false;
    L66:
        if (r104 == false) goto L68;
        r100.B(R.string.Bitable_Relation_TableDeletedReselectTip_Mobile);
        return;
    L63:
        if ((!r132.isEmpty()) != true) goto L65;
    L68:
        if (r109 == null) goto L70;
        r100.f211450l = r109;
        r100.D(false);
        goto L70
    L13:
        r112 = null;
    L70:
        r100.r().l(r100.f211450l);
        return;
    L7:
        r106 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void u(FieldConfigMetaModel.FieldConfigItem r100, FieldProperty r101, AllowedEditModes r102, FieldExtendInfo r103) {
        super.u(r100, r101, r102, r103);
        Observable r104 = r().k(CommonActionType.GET_CURRENT_TABLE_LIST, new JSONObject(), String.class);
        if (r104 == null) goto L10;
        Observable r105 = r104.map(f.f211464a);
        if (r105 == null) goto L11;
        Disposable r106 = r105.subscribe(new g(this, r101), new h(this, r101));
        if (r106 == null) goto L12;
        this.f211454p.add(r106);
        return;
    L12:
        return;
    L11:
        return;
    }
}
