package com.bytedance.ee.bear.bitable.fieldedit.view.selection;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.check.CheckResult;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.check.CheckType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.check.ConfirmFieldTypeChangeExtra;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.BitableFieldEditViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 q2\u00020\u0001:\u0002pqB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010:\u001a\u00020\u0014H\u0002J\b\u0010;\u001a\u00020\u0014H\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0016H\u0002J\b\u0010?\u001a\u00020\u001cH\u0002JA\u0010@\u001a\u00020\u00142\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010E2\b\u0010G\u001a\u0004\u0018\u00010F2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010JJ,\u0010K\u001a\u00020\u00142\u000e\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140M2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00160OH\u0002J2\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020F2\u0006\u0010S\u001a\u00020\u00162\u000e\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140M2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J(\u0010W\u001a\u00020P2\u0006\u0010R\u001a\u00020F2\u0006\u0010X\u001a\u0002012\u0006\u0010S\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020PH\u0003J$\u0010Z\u001a\u0016\u0012\u0004\u0012\u00020P\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010M0O2\u0006\u0010R\u001a\u00020FH\u0002J\u0014\u0010[\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00160OH\u0002J6\u0010\\\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\u00162\b\u0010]\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020F2\b\u0010^\u001a\u0004\u0018\u00010\u00162\b\u0010_\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010`\u001a\u00020\u00142\u0006\u0010a\u001a\u00020bH\u0002J\u001c\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00162\n\b\u0002\u0010f\u001a\u0004\u0018\u000107H\u0002J\b\u0010g\u001a\u00020PH\u0016J\"\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020P2\u0006\u0010m\u001a\u00020kH\u0016J\b\u0010n\u001a\u00020\u0014H\u0002J\b\u0010o\u001a\u00020\u0014H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b-\u0010.¨\u0006r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/selection/BitableFieldTypeSelectionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "contentContainerFromXml", "Landroid/widget/LinearLayout;", "getContentContainerFromXml", "()Landroid/widget/LinearLayout;", "setContentContainerFromXml", "(Landroid/widget/LinearLayout;)V", "extendFieldContainerFromXml", "getExtendFieldContainerFromXml", "setExtendFieldContainerFromXml", "clearFromXmlViewCache", "", "mEditType", "", "mSceneType", "mFromFieldType", "mShowStartTime", "", "groupLayout", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceSettingGroupLayout;", "currentSelectorItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/selection/FieldEditSelectorItem;", "targetSelectorItem", "mStatusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "getMStatusBar", "()Lcom/bytedance/ee/util/statusbar/IStatusBar;", "mStatusBar$delegate", "Lkotlin/Lazy;", "mFieldEditViewModel", "Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;", "getMFieldEditViewModel", "()Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;", "mFieldEditViewModel$delegate", "mBitableAnalytic", "Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "getMBitableAnalytic", "()Lcom/bytedance/ee/bear/bitable/fieldedit/BitableFieldEditAnalytic;", "mBitableAnalytic$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initStatusBarAndTitleBar", "initDataObserver", "createFieldItemGroupTitleView", "Landroid/widget/TextView;", "groupName", "createFieldItemGroupLayout", "sortFieldItemByGroupName", "fieldItems", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "configurableFieldTypeList", "", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "currentCheckedFieldCompositeType", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;Ljava/util/List;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;)V", "showChangeTypeConfirmDialog", "changeFieldType", "Lkotlin/Function0;", "checkResult", "Lkotlin/Pair;", "", "beforeItemChecked", "fieldCompositeType", "targetFieldTitle", "afterChecked", "checkFieldTypeResult", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/selection/BitableFieldTypeSelectionFragment$ICheckFieldTypeResult;", "notifyItemChecked", "itemView", "showNewTag", "handleNewFieldGuide", "checkDenpendentTable", "onExtendFieldClicked", "fieldId", "editType", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "renderOriginFieldsGroup", "originFieldsInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExistExtendableFields;", "createNextFragment", "Landroidx/fragment/app/Fragment;", "fragmentClassName", "bundle", "onBackPressed", "onCreateAnimation", "Landroid/view/animation/Animation;", AppletNaviType.TRANSIT, "", "enter", "nextAnim", "exitFragment", "onDestroyView", "ICheckFieldTypeResult", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFieldTypeSelectionFragment extends BaseFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Map<EFieldUIType, String> f211669r = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f211670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f211671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f211672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f211673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f211674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f211675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f211676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SpaceSettingGroupLayout f211677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m f211678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m f211679n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f211680o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f211681p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f211682q;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFieldTypeSelectionFragment f211683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f211684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f211685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f211686d;

        public c(BitableFieldTypeSelectionFragment r100, String r101, Function0<Unit> r102, b r103) {
            this.f211683a = r100;
            this.f211684b = r101;
            this.f211685c = r102;
            this.f211686d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CheckResult r101 = (CheckResult) r100;
            if (Intrinsics.areEqual(r101.getType(), CheckType.ConfirmAIFieldTypeChange.getValue()) == false) goto L24;
            NonProguard r102 = r101.getExtra();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.model.jsmodel.check.ConfirmFieldTypeChangeExtra");
            Boolean r103 = ((ConfirmFieldTypeChangeExtra) r102).getCheckTypeConvert();
            if (r103 == null) goto L7;
            boolean r104 = r103.booleanValue();
        L8:
            NonProguard r105 = r101.getExtra();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.model.jsmodel.check.ConfirmFieldTypeChangeExtra");
            String r106 = ((ConfirmFieldTypeChangeExtra) r105).getAiPromptTx();
            if (r106 != null) goto L11;
            r106 = "";
        L11:
            NonProguard r107 = r101.getExtra();
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.model.jsmodel.check.ConfirmFieldTypeChangeExtra");
            Boolean r108 = ((ConfirmFieldTypeChangeExtra) r107).getSupportAIConfig();
            if (r108 == null) goto L14;
            boolean r109 = r108.booleanValue();
        L15:
            BitableFieldTypeSelectionFragment r110 = this.f211683a;
            Map<EFieldUIType, String> r111 = BitableFieldTypeSelectionFragment.f211669r;
            r110.Z90().getAiPromptTx().setValue(r106);
            this.f211683a.Z90().getShowAIConfigLayout().setValue(Boolean.valueOf(r109));
            if (r104 == false) goto L20;
            com.bytedance.ee.bear.widgets.a r112 = new com.bytedance.ee.bear.widgets.a(this.f211683a.getContext());
            r112.k(this.f211683a.getString(R.string.Bitable_BaseAI_ChangeFieldType_PopUp_Title) + UIHelper.mustacheFormat(R.string.Bitable_BaseAI_ChangeFieldType_PopUp_Desc, "fieldType", this.f211684b));
            r112.e(R.string.Bitable_BaseAI_ChangeFieldType_PopUp_ChangeButton, new com.bytedance.ee.bear.bitable.fieldedit.view.selection.c(this.f211683a, this.f211686d));
            r112.b(new com.bytedance.ee.bear.bitable.fieldedit.view.selection.d(this.f211686d));
            r112.q();
            LKUIDialog r113 = r112.f240138d;
            if (r113 == null) goto L25;
            r113.setCanceledOnTouchOutside(false);
            r112.f240138d.setCancelable(false);
            return;
        L25:
            return;
        L20:
            Function0<Unit> r114 = this.f211685c;
            if (r114 == null) goto L27;
            Unit r115 = r114.invoke();
            return;
        L27:
            return;
        L14:
            r109 = false;
            goto L15
        L7:
            r104 = false;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f211687a = null;

        static {
            f211687a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Log.e("BitableFieldTypeSelectFragment", "confirm fieldTypeChange fails", (Throwable) r100);
        }
    }

    static {
        f211669r = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EFieldUIType.BARCODE, "bitable_barcode_field_new"), TuplesKt.to(EFieldUIType.CURRENCY, "bitable_currency_field_new"), TuplesKt.to(EFieldUIType.PROGRESS, "bitable_progress_field_new"), TuplesKt.to(EFieldUIType.GROUP, "bitable_group_field_new"), TuplesKt.to(EFieldUIType.RATING, "bitable_rating_field_new"), TuplesKt.to(EFieldUIType.USER, "bitable_user_extend_address_field_new"), TuplesKt.to(EFieldUIType.CREATED_USER, "bitable_user_extend_address_field_new"), TuplesKt.to(EFieldUIType.EMAIL, "bitable_email_field_new"), TuplesKt.to(EFieldUIType.SIGNATURE, "bitable_signature_field_new")});
    }

    public final LinearLayout X90() {
        View r100 = this.f211672g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.extendFieldContainer);
    L8:
        this.f211672g = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final BitableFieldEditAnalytic Y90() {
        return (BitableFieldEditAnalytic) this.f211682q.getValue();
    }

    public final BitableFieldEditViewModel Z90() {
        return (BitableFieldEditViewModel) this.f211681p.getValue();
    }

    public BitableFieldTypeSelectionFragment() {
        this.f211680o = LazyKt.lazy(new BitableFieldTypeSelectionFragment$mStatusBar$2(this));
        this.f211681p = LazyKt.lazy(new BitableFieldTypeSelectionFragment$mFieldEditViewModel$2(this));
        this.f211682q = LazyKt.lazy(new BitableFieldTypeSelectionFragment$mBitableAnalytic$2(this));
    }

    public final void W90() {
        BitableFieldEditAnalytic r100 = Y90();
        if (r100 == null) goto L8;
        String r101 = this.f211673h;
        String r102 = this.f211674i;
        String r103 = this.f211675j;
        HashMap r104 = new HashMap();
        r104.put("click", "back");
        r104.put(PickerReporterConstants.KEY.TARGET, BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_MODIFY_VIEW);
        r104.put("edit_type", r101);
        r104.put("scene_type", r102);
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r104.put("from_field_type", r103);
    L7:
        r100.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_TYPE_MODIFY_CLICK, r104);
    L8:
        BitableFieldEditAnalytic r105 = Y90();
        if (r105 == null) goto L11;
        FieldCompositeType r106 = Z90().getCurrentEditFieldCompositeType();
        String r107 = this.f211673h;
        long r108 = System.currentTimeMillis() - this.f211676k;
        HashMap r109 = new HashMap();
        r109.put("field_type", r106.getReportValue());
        r109.put("edit_type", r107);
        r109.put("duration", Long.valueOf(r108));
        r105.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_TYPE_MODIFY_DURATION_VUEW, r109);
    L11:
        T90(R.anim.facade_slide_right_out);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        W90();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((xu5.a) this.f211680o.getValue()).resetState();
        this.f211670e = null;
        this.f211671f = null;
        this.f211672g = null;
    }

    public final TextView V90(String r100) {
        TextView r101 = new TextView(getContext());
        r101.setText(r100);
        r101.setTextSize(14.0f);
        r101.setTextColor(r101.getResources().getColor(R.color.text_placeholder));
        r101.setMaxLines(1);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setPadding(0, n.d(14), 0, n.d(4));
        return r101;
    }

    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [kotlin.jvm.functions.Function0, mwc.c] */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ((xu5.a) this.f211680o.getValue()).saveState();
        boolean r100 = true;
        ((xu5.a) this.f211680o.getValue()).b(getResources().getColor(R.color.bg_float_base), !ColorUtils.b(requireContext()));
        View r101 = this.f211670e;
        boolean r102 = false;
        if (r101 != null) goto L9;
        View r103 = getView();
        if (r103 == null) goto L7;
        r101 = r103.findViewById(R.id.titleBar);
    L8:
        this.f211670e = (BaseTitleBar) r101;
        goto L9
    L7:
        r101 = null;
    L9:
        ((BaseTitleBar) r101).setTitle(R.string.Bitable_BTModule_FieldType);
        View r104 = this.f211670e;
        if (r104 != null) goto L16;
        View r105 = getView();
        if (r105 == null) goto L14;
        r104 = r105.findViewById(R.id.titleBar);
    L15:
        this.f211670e = (BaseTitleBar) r104;
        goto L16
    L14:
        r104 = null;
    L16:
        ((BaseTitleBar) r104).setLeftClickListener(new f(this));
        Z90().getOriginFieldsInfo().observe(getViewLifecycleOwner(), new e(this));
        Z90().fetchOriginFieldsInfoIfNeed();
        FieldConfigMetaModel r106 = Z90().getFieldConfigMeta();
        if (r106 == null) goto L19;
        FieldConfigMetaModel.FieldConfigItem[] r107 = r106.getFieldItems();
    L20:
        FieldEditPanelData r108 = Z90().getPanelData().getValue();
        if (r108 == null) goto L23;
        List<FieldCompositeType> r109 = r108.getConfigurableFieldTypeList();
    L24:
        FieldCompositeType r112 = Z90().getCurrentEditFieldCompositeType();
        FieldEditPanelData r113 = Z90().getPanelData().getValue();
        if (r113 == null) goto L27;
        FieldExtendInfo r114 = r113.getFieldExtendInfo();
    L28:
        View r115 = this.f211671f;
        if (r115 != null) goto L35;
        View r116 = getView();
        if (r116 == null) goto L33;
        r115 = r116.findViewById(R.id.contentContainer);
    L34:
        this.f211671f = (LinearLayout) r115;
        goto L35
    L33:
        r115 = null;
    L35:
        LinearLayout r117 = (LinearLayout) r115;
        if (r117 == null) goto L110;
        LinkedHashMap r118 = new LinkedHashMap();
        if (r107 == null) goto L74;
        int r119 = r107.length;
        int r120 = 0;
    L41:
        if (r120 >= r119) goto L74;
        FieldConfigMetaModel.FieldConfigItem r121 = r107[r120];
        List<FieldCompositeType> r122 = r109;
        if (r122 != null) goto L45;
    L48:
        boolean r123 = true;
    L49:
        if (r123 == true) goto L65;
        List<FieldCompositeType> r124 = r109;
        if ((r124 instanceof Collection) == true) goto L53;
    L55:
        Iterator<T> r125 = r124.iterator();
    L57:
        if (r125.hasNext() == false) goto L61;
        if (Intrinsics.areEqual((FieldCompositeType) r125.next(), r121.getFieldCompositeType()) == false) goto L57;
        boolean r126 = false;
    L62:
        if (r126 == false) goto L65;
    L73:
        r120 = r120 + 1;
    L61:
        r126 = true;
        goto L62
    L53:
        if (r124.isEmpty() == false) goto L55;
    L65:
        if (TextUtils.isEmpty(r121.getGroupName()) == true) goto L73;
        List r127 = (List) r118.get(r121.getGroupName());
        if (r127 != null) goto L72;
        ArrayList r128 = new ArrayList();
        r128.add(r121);
        String r129 = r121.getGroupName();
        if (r129 == null) goto L73;
        r118.put(r129, r128);
        goto L73
    L72:
        r127.add(r121);
        goto L73
    L45:
        if (r122.isEmpty() == true) goto L48;
        r123 = false;
    L74:
        Iterator r130 = r118.entrySet().iterator();
    L76:
        if (r130.hasNext() == false) goto L110;
        Map.Entry r131 = (Map.Entry) r130.next();
        String r132 = (String) r131.getKey();
        List r133 = (List) r131.getValue();
        r117.addView(V90(r132));
        SpaceSettingGroupLayout r134 = new SpaceSettingGroupLayout(requireContext(), 0);
        r134.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f211677l = r134;
        Iterator r135 = r133.iterator();
        int r136 = 0;
        ?? r137 = r102;
    L79:
        if (r135.hasNext() == false) goto L109;
        Object r138 = r135.next();
        int r139 = r136 + 1;
        if (r136 >= 0) goto L83;
        CollectionsKt.throwIndexOverflow();
    L83:
        FieldConfigMetaModel.FieldConfigItem r140 = (FieldConfigMetaModel.FieldConfigItem) r138;
        m r141 = new m(getContext());
        FieldCompositeType r142 = r140.getFieldCompositeType();
        final sk5.c r143 = ((sk5.b) org.koin.java.a.c(sk5.b.class, r137, r137, 6)).b();
        final String r144 = f211669r.get(r142.getUiType());
        if (r144 == null) goto L89;
        boolean r145 = r143.f(r144) ^ r100;
        if (r145 == false) goto L88;
        Function0<Unit> r146 = new BitableFieldTypeSelectionFragment$handleNewFieldGuide$1$1(r143, r144);
    L90:
        Pair r147 = new Pair(Boolean.valueOf(r145), r146);
        boolean r148 = ((Boolean) r147.getFirst()).booleanValue();
        Function0 r149 = (Function0) r147.getSecond();
        if (r140.getEnable() == true) goto L93;
    L95:
        boolean r150 = false;
    L96:
        r141.setEnabled(r150);
        BitableSelectorItemView.f(r141, r140.getTitle());
        BitableSelectorItemView.c(r141, r142.getIcon(), false, 6);
        if (r114 == null) goto L99;
    L101:
        boolean r151 = false;
    L102:
        r141.setChecked(r151);
        if (r151 == false) goto L105;
        this.f211678m = r141;
    L105:
        r141.setGuideBadgeVisible(r148);
        r141.setOnItemClickListener(new l(r149, this, r142, r148, r141));
        SpaceSettingGroupLayout r152 = this.f211677l;
        if (r152 == null) goto L108;
        r152.addView(r141);
    L108:
        r136 = r139;
        r100 = true;
        r137 = 0;
        goto L79
    L99:
        if (Intrinsics.areEqual(r112, r142) == false) goto L101;
        r151 = true;
        goto L102
    L93:
        if (r142.getUiType() == EFieldUIType.NOT_SUPPORT) goto L95;
        r150 = true;
        goto L96
    L88:
        r146 = null;
        goto L90
    L89:
        r146 = null;
        r145 = false;
        goto L90
    L109:
        r117.addView(this.f211677l);
        r100 = true;
        r102 = false;
    L110:
        BitableFieldEditAnalytic r153 = Y90();
        if (r153 == null) goto L135;
        FieldCompositeType r154 = Z90().getCurrentEditFieldCompositeType();
        FieldEditPanelData r155 = Z90().getPanelData().getValue();
        if (r155 == null) goto L115;
        int r156 = r155.getFieldIndex();
    L116:
        String r157 = this.f211673h;
        String r158 = this.f211674i;
        HashMap r159 = new HashMap();
        r159.put("field_type", r154.getReportValue());
        if (r156 != 0) goto L119;
        boolean r160 = true;
    L120:
        r159.put("is_index_column", String.valueOf(r160));
        r159.put("edit_type", r157);
        r159.put("scene_type", r158);
        r153.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_TYPE_MODIFY_VIEW, r159);
        return;
    L119:
        r160 = false;
        goto L120
    L115:
        r156 = 0;
        goto L116
    L135:
        return;
    L27:
        r114 = null;
        goto L28
    L23:
        r109 = null;
        goto L24
    L19:
        r107 = null;
        goto L20
    }

    @Override // androidx.fragment.app.Fragment
    public final Animation onCreateAnimation(int r100, boolean r101, int r102) {
        Context r103 = getContext();
        if (r101 == false) goto L5;
        int r104 = R.anim.facade_slide_right_in;
    L7:
        return AnimationUtils.loadAnimation(r103, r104);
    L5:
        r104 = R.anim.facade_slide_right_out;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Bundle r103 = getArguments();
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getString("key_edit_type");
    L6:
        this.f211673h = r105;
        this.f211674i = Z90().getSceneType();
        Bundle r106 = getArguments();
        if (r106 == null) goto L9;
        r104 = r106.getString("key_from_field_type");
    L9:
        this.f211675j = r104;
        this.f211676k = System.currentTimeMillis();
        return r100.inflate(R.layout.bitable_field_type_selection_fragment, r101, false);
    L5:
        r105 = null;
        goto L6
    }

    public final void U90(FieldCompositeType r100, String r101, Function0<Unit> r102, b r103) {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.mobile.ai_field_lark") == true) goto L8;
        int r104 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("ccm.bitable.mobile.ai_field_feishu", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile.ai_field_feishu") == true) goto L8;
        Unit r105 = r102.invoke();
        return;
    L8:
        BitableFieldEditViewModel.b r106 = Z90().getDelegate();
        if (r106 == null) goto L29;
        BitableFieldEditViewModel r107 = Z90();
        String r108 = null;
        if (r107 == null) goto L17;
        MutableLiveData<FieldEditPanelData> r109 = r107.getPanelData();
        if (r109 == null) goto L17;
        FieldEditPanelData r110 = r109.getValue();
        if (r110 == null) goto L17;
        String r111 = r110.getFieldId();
    L18:
        BitableFieldEditViewModel r112 = Z90();
        if (r112 == null) goto L25;
        MutableLiveData<FieldEditPanelData> r113 = r112.getPanelData();
        if (r113 == null) goto L25;
        FieldEditPanelData r114 = r113.getValue();
        if (r114 == null) goto L25;
        r108 = r114.getTableId();
    L25:
        Observable<CheckResult> r115 = r106.i(r111, r108, r100.getUiType().getValue());
        if (r115 == null) goto L30;
        r115.subscribe(new c(this, r101, r102, r103), d.f211687a);
        return;
    L30:
        return;
    L17:
        r111 = null;
        goto L18
    }
}
