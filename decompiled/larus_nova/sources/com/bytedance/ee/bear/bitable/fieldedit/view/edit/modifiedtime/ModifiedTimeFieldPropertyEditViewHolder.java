package com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBindings;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.CommonActionType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.databinding.BitableFieldEditModifiedTimeViewBinding;
import com.bytedance.ee.bear.bitable.databinding.BitableFieldEditPropertyViewBinding;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.DateFieldPropertyEditViewHolder;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.BitableFieldEditViewModel;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.BitablePanelFragment;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.BitablePanelModel;
import com.bytedance.ee.bear.bitable.panel.CheckboxValue;
import com.bytedance.ee.bear.bitable.panel.GroupInfo;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.Style;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.FieldSelectModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import io.reactivex.Observable;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?2\u00020\u0001:\u0001?B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0005H\u0002J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$J\n\u0010%\u001a\u0004\u0018\u00010&H\u0014J0\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010&2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u001eH\u0014J\b\u00103\u001a\u00020\u001eH\u0016J\b\u00104\u001a\u00020\u001eH\u0016J\u0006\u00105\u001a\u00020\u001eJ\u0006\u00106\u001a\u00020\u001eJ\u0006\u00107\u001a\u00020\u001eJ\u000e\u00108\u001a\b\u0012\u0004\u0012\u0002090\u000eH\u0002J\u0006\u0010:\u001a\u00020;J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000fH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeFieldPropertyEditViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/DateFieldPropertyEditViewHolder;", "mContext", "Landroid/content/Context;", "mFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "mCommonDateTimeList", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$DateTimeFormatBean;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$DateTimeFormatBean;)V", "mCurrentWatch", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeWatch;", "mCommonFieldList", "", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldSelectModel;", "mUnSupportFieldList", "mSelectFieldList", "hasSelectedDeleteField", "", "hasSelectedUnSupportField", "hasFilterUnSupportField", "hasLoadField", "disposable", "Lio/reactivex/disposables/Disposable;", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableFieldEditModifiedTimeViewBinding;", "bindingRoot", "Lcom/bytedance/ee/bear/bitable/databinding/BitableFieldEditPropertyViewBinding;", "initView", "", "initClickEvent", "isSpecificType", "isSupportField", "fieldCompositeType", "fetchVisibleFieldList", "Lio/reactivex/Observable;", "getCurrentEditProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "injectFieldInfo", "fieldConfigItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "fieldProperty", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "notifyFieldPropertyOptionChanged", "newFieldPropertyOption", "", "updatePropertySelectorText", "onDetach", "verifyFailWhenSaveData", "updateWatchType", "showFieldTypeSelector", "showSpecifyFieldsSelector", "getVisibleFieldList", "", "getPanelModel", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelModel;", "buildBitablePanelItem", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelItem;", "fieldData", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModifiedTimeFieldPropertyEditViewHolder extends DateFieldPropertyEditViewHolder {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f211473x = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ModifiedTimeWatch f211474m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<FieldSelectModel> f211475n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<FieldSelectModel> f211476o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<FieldSelectModel> f211477p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f211478q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f211479r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f211480s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f211481t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Disposable f211482u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public BitableFieldEditModifiedTimeViewBinding f211483v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BitableFieldEditPropertyViewBinding f211484w;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f211485a = null;

        static {
            f211485a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "json");
            List r102 = (List) GsonProtectorUtils.fromJson(new Gson(), r101, new com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.a().getType());
            if (r102 == null) goto L5;
            return r102;
        L5:
            return new ArrayList();
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ModifiedTimeFieldPropertyEditViewHolder f211486a;

        public c(ModifiedTimeFieldPropertyEditViewHolder r100) {
            this.f211486a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            List r111 = (List) r110;
            Intrinsics.checkNotNullParameter(r111, "itemList");
            ArrayList r100 = new ArrayList();
            ArrayList r101 = new ArrayList();
            ModifiedTimeFieldPropertyEditViewHolder r102 = this.f211486a;
            r102.f211480s = false;
            Iterator<T> r112 = r111.iterator();
        L4:
            if (r112.hasNext() == false) goto L33;
            FilterFieldOption r103 = (FilterFieldOption) r112.next();
            String r104 = r103.getId();
            FieldEditPanelData r105 = r102.r().m();
            if (r105 == null) goto L8;
            String r106 = r105.getFieldId();
        L10:
            if (TextUtils.equals(r104, r106) == true) goto L11;
            EFieldUIType r107 = r103.getFieldCompositeType().getUiType();
            if (r107 != EFieldUIType.NOT_SUPPORT) goto L15;
        L29:
            boolean r108 = false;
        L30:
            if (r108 == true) goto L31;
            r102.f211480s = true;
            r101.add(r103);
            goto L4
        L31:
            r100.add(r103);
            goto L4
        L15:
            if (r107 == EFieldUIType.FORMULA) goto L29;
            if (r107 == EFieldUIType.LOOKUP) goto L29;
            if (r107 == EFieldUIType.BUTTON) goto L29;
            if (r107 == EFieldUIType.CREATED_USER) goto L29;
            if (r107 == EFieldUIType.MODIFIED_USER) goto L29;
            if (r107 == EFieldUIType.MODIFIED_TIME) goto L29;
            if (r107 == EFieldUIType.CREATED_TIME) goto L29;
            r108 = true;
            goto L30
        L11:
            r101.add(r103);
            goto L4
        L8:
            r106 = null;
            goto L10
        L33:
            ((ArrayList) this.f211486a.f211475n).clear();
            ((ArrayList) this.f211486a.f211476o).clear();
            List<FieldSelectModel> r113 = this.f211486a.f211475n;
            ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
            Iterator r114 = r100.iterator();
        L35:
            if (r114.hasNext() == false) goto L45;
            FilterFieldOption r115 = (FilterFieldOption) r114.next();
            String r116 = r115.getId();
            if (r116 != null) goto L39;
            String r117 = "";
        L40:
            String r118 = r115.getName();
            if (r118 != null) goto L43;
            String r119 = "";
        L44:
            r109.add(new FieldSelectModel(r117, r119, r115.getFieldCompositeType().getUiType(), false, true));
            goto L35
        L43:
            r119 = r118;
            goto L44
        L39:
            r117 = r116;
            goto L40
        L45:
            ((ArrayList) r113).addAll(r109);
            List<FieldSelectModel> r120 = this.f211486a.f211476o;
            ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator r122 = r101.iterator();
        L47:
            if (r122.hasNext() == false) goto L57;
            FilterFieldOption r123 = (FilterFieldOption) r122.next();
            String r124 = r123.getId();
            if (r124 != null) goto L51;
            String r125 = "";
        L52:
            String r126 = r123.getName();
            if (r126 != null) goto L55;
            String r127 = "";
        L56:
            r121.add(new FieldSelectModel(r125, r127, r123.getFieldCompositeType().getUiType(), true, true));
            goto L47
        L55:
            r127 = r126;
            goto L56
        L51:
            r125 = r124;
            goto L52
        L57:
            ((ArrayList) r120).addAll(r121);
            return Boolean.TRUE;
        }
    }

    public static final class d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ModifiedTimeFieldPropertyEditViewHolder f211487c;

        public d(ModifiedTimeFieldPropertyEditViewHolder r100) {
            this.f211487c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            ModifiedTimeFieldPropertyEditViewHolder r101 = this.f211487c;
            boolean r102 = r101.A();
            Context r103 = r101.f211151c.getContext();
            FragmentManager r104 = r101.r().getFragmentManager();
            BitablePanelModel r105 = new BitablePanelModel();
            r105.setTitle(r101.f211149a.getString(R.string.Bitable_DB_LastModifiedDateField_CustomizeLastModifiedByField_Title));
            ArrayList<BitablePanelItem> r106 = new ArrayList();
            BitablePanelItem r107 = new BitablePanelItem();
            r107.setId(com.bytedance.ee.bear.bitable.panel.e.e(Boolean.FALSE));
            r107.setLeftText(r101.f211149a.getString(R.string.Bitable_DB_LastModifiedDateField_AnyOfFields_Option));
            com.bytedance.ee.bear.bitable.panel.e.d(r107, !r102);
            com.bytedance.ee.bear.bitable.panel.e.a(r107);
            r106.add(r107);
            BitablePanelItem r108 = new BitablePanelItem();
            r108.setId(com.bytedance.ee.bear.bitable.panel.e.e(Boolean.TRUE));
            r108.setLeftText(r101.f211149a.getString(R.string.Bitable_DB_LastModifiedDateField_SpecifiedFields_Option));
            com.bytedance.ee.bear.bitable.panel.e.d(r108, r102);
            com.bytedance.ee.bear.bitable.panel.e.a(r108);
            r106.add(r108);
            r105.setData(r106);
            BitableFieldEditViewModel r109 = r101.f211156h;
            Integer r110 = null;
            if (r109 == null) goto L9;
            MutableLiveData<FieldEditPanelData> r111 = r109.getPanelData();
            if (r111 == null) goto L9;
            FieldEditPanelData r112 = r111.getValue();
            if (r112 == null) goto L9;
            String r113 = r112.getSrcObjToken();
        L10:
            r105.setSrcObjToken(r113);
            BitableFieldEditViewModel r114 = r101.f211156h;
            if (r114 == null) goto L17;
            MutableLiveData<FieldEditPanelData> r115 = r114.getPanelData();
            if (r115 == null) goto L17;
            FieldEditPanelData r116 = r115.getValue();
            if (r116 == null) goto L17;
            r110 = r116.getSrcObjType();
        L17:
            r105.setSrcObjType(r110);
            Unit r117 = Unit.INSTANCE;
            com.bytedance.ee.bear.bitable.panel.e.m(r103, r104, r105, new fs4.a(r101), null, 48);
            return;
        L9:
            r113 = null;
            goto L10
        }
    }

    public static final class e extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ModifiedTimeFieldPropertyEditViewHolder f211488c;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ModifiedTimeFieldPropertyEditViewHolder f211489a;

            public a(ModifiedTimeFieldPropertyEditViewHolder r100) {
                this.f211489a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Boolean r101 = (Boolean) r100;
                ModifiedTimeFieldPropertyEditViewHolder r102 = this.f211489a;
                r102.f211481t = true;
                BitablePanelFragment r103 = com.bytedance.ee.bear.bitable.panel.e.m(r102.f211151c.getContext(), r102.r().getFragmentManager(), r102.z(), null, null, 32);
                if (r103 == null) goto L5;
                r103.N = new fs4.c(r103, r102);
            L6:
                fs4.b r104 = new fs4.b(r102);
                if (r103 == null) goto L9;
                long r105 = r103.T;
            L10:
                rcb.e.a(r104, r105);
                return;
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = null;
                goto L6
            }
        }

        public e(ModifiedTimeFieldPropertyEditViewHolder r100) {
            this.f211488c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            ModifiedTimeFieldPropertyEditViewHolder r101 = this.f211488c;
            r101.f211482u = r101.y().subscribe(new a(this.f211488c));
        }
    }

    public static final class f extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ModifiedTimeFieldPropertyEditViewHolder f211490c;

        public f(ModifiedTimeFieldPropertyEditViewHolder r100) {
            this.f211490c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            ModifiedTimeFieldPropertyEditViewHolder r101 = this.f211490c;
            int r102 = ModifiedTimeFieldPropertyEditViewHolder.f211473x;
            r101.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.OPEN_SELECT, null);
            this.f211490c.r().n(null);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ModifiedTimeFieldPropertyEditViewHolder f211491a;

        public g(ModifiedTimeFieldPropertyEditViewHolder r100) {
            this.f211491a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            ModifiedTimeFieldPropertyEditViewHolder r102 = this.f211491a;
            r102.f211481t = true;
            r102.B();
        }
    }

    static {
    }

    public final boolean A() {
        ModifiedTimeWatch r100 = this.f211474m;
        if (r100 == null) goto L5;
        String r101 = r100.getType();
    L7:
        return Intrinsics.areEqual(r101, ModifiedTimeWatch.WATCH_TYPE_SPECIFIC);
    L5:
        r101 = null;
        goto L7
    }

    public final void B() {
        ((ArrayList) this.f211477p).clear();
        boolean r100 = false;
        this.f211478q = false;
        this.f211479r = false;
        if (this.f211481t == false) goto L109;
        ModifiedTimeWatch r101 = this.f211474m;
        if (r101 == null) goto L10;
        ModifiedTimeSource r102 = r101.getSource();
        if (r102 == null) goto L10;
        List<String> r103 = r102.getFields();
        if (r103 == null) goto L10;
    L11:
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L35;
        String r105 = (String) r104.next();
        Iterator<T> r106 = this.f211475n.iterator();
    L15:
        Object r107 = null;
        if (r106.hasNext() == false) goto L20;
        Object r108 = r106.next();
        if (Intrinsics.areEqual(((FieldSelectModel) r108).getFieldId(), r105) == false) goto L15;
    L21:
        FieldSelectModel r109 = (FieldSelectModel) r108;
        if (r109 != null) goto L33;
        Iterator<T> r110 = this.f211476o.iterator();
    L25:
        if (r110.hasNext() == false) goto L29;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((FieldSelectModel) r111).getFieldId(), r105) == false) goto L25;
        r107 = r111;
    L29:
        r109 = (FieldSelectModel) r107;
        if (r109 == null) goto L32;
        this.f211479r = true;
        goto L33
    L32:
        this.f211478q = true;
        r109 = new FieldSelectModel(r105, this.f211149a.getString(R.string.Bitable_DB_LastModifiedDateField_FieldDoesNotExist_Desc), EFieldUIType.NOT_SUPPORT, true, false);
    L33:
        ((ArrayList) this.f211477p).add(r109);
        goto L13
    L20:
        r108 = null;
        goto L21
    L35:
        if (A() == false) goto L72;
        BitableFieldEditPropertyViewBinding r112 = this.f211484w;
        if (r112 == null) goto L41;
        TextView r113 = r112.f210761d;
        if (r113 == null) goto L41;
        r113.setText(R.string.Bitable_DB_LastModifiedDateField_SpecifiedFields_Option);
    L41:
        BitableFieldEditModifiedTimeViewBinding r114 = this.f211483v;
        if (r114 == null) goto L46;
        LinearLayout r115 = r114.f210752b;
        if (r115 == null) goto L46;
        m.z(r115, true);
    L46:
        BitableFieldEditModifiedTimeViewBinding r116 = this.f211483v;
        if (r116 == null) goto L59;
        TextView r117 = r116.f210753c;
        if (r117 == null) goto L59;
        if (this.f211478q == false) goto L53;
    L56:
        boolean r118 = true;
    L57:
        m.z(r117, r118);
        goto L59
    L53:
        if (this.f211479r == true) goto L56;
        r118 = false;
    L59:
        if (this.f211478q == false) goto L61;
    L62:
        BitableFieldEditModifiedTimeViewBinding r119 = this.f211483v;
        if (r119 == null) goto L67;
        TextView r120 = r119.f210753c;
        if (r120 == null) goto L67;
        r120.setText(R.string.Bitable_DB_LastModifiedDateField_InvalidFieldFound_Desc);
    L67:
        BitableFieldEditModifiedTimeViewBinding r121 = this.f211483v;
        if (r121 == null) goto L92;
        MultiFieldItemView r122 = r121.f210755e;
        if (r122 == null) goto L92;
        r122.setData(this.f211477p);
    L92:
        q0.a r123 = r();
        if (A() == true) goto L95;
    L96:
        r100 = true;
    L97:
        r123.d(r100);
        return;
    L95:
        if (((ArrayList) this.f211477p).isEmpty() == true) goto L97;
    L61:
        if (this.f211479r == false) goto L67;
    L72:
        BitableFieldEditPropertyViewBinding r124 = this.f211484w;
        if (r124 == null) goto L77;
        TextView r125 = r124.f210761d;
        if (r125 == null) goto L77;
        r125.setText(R.string.Bitable_DB_LastModifiedDateField_AnyOfFields_Option);
    L77:
        BitableFieldEditModifiedTimeViewBinding r126 = this.f211483v;
        if (r126 == null) goto L82;
        LinearLayout r127 = r126.f210752b;
        if (r127 == null) goto L82;
        m.z(r127, false);
    L82:
        BitableFieldEditModifiedTimeViewBinding r128 = this.f211483v;
        if (r128 == null) goto L87;
        TextView r129 = r128.f210753c;
        if (r129 == null) goto L87;
        m.z(r129, false);
    L87:
        BitableFieldEditModifiedTimeViewBinding r130 = this.f211483v;
        if (r130 == null) goto L92;
        MultiFieldItemView r131 = r130.f210755e;
        if (r131 == null) goto L92;
        r131.setData(CollectionsKt.emptyList());
    L10:
        r103 = CollectionsKt.emptyList();
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void s() {
        BitableFieldEditPropertyViewBinding r100 = this.f211484w;
        if (r100 == null) goto L7;
        LinearLayout r101 = r100.f210760c;
        if (r101 == null) goto L7;
        r101.setOnClickListener(new d(this));
    L7:
        BitableFieldEditModifiedTimeViewBinding r102 = this.f211483v;
        if (r102 == null) goto L12;
        LinearLayout r103 = r102.f210754d;
        if (r103 == null) goto L12;
        r103.setOnClickListener(new e(this));
    L12:
        BitableFieldEditModifiedTimeViewBinding r104 = this.f211483v;
        if (r104 == null) goto L18;
        LinearLayout r105 = r104.f210756f;
        if (r105 == null) goto L19;
        r105.setOnClickListener(new f(this));
        return;
    L19:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.DateFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void t() {
        View r100 = this.f211151c;
        LayoutInflater r101 = LayoutInflater.from(this.f211149a);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r102 = (ViewGroup) r100;
        View r103 = r101.inflate(R.layout.bitable_field_edit_modified_time_view, r102, false);
        r102.addView(r103);
        int r104 = R.id.specifyFieldsContainer;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.specifyFieldsContainer);
        if (r105 == null) goto L56;
        r104 = R.id.specifyFieldsError;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.specifyFieldsError);
        if (r106 == null) goto L56;
        r104 = R.id.specifyFieldsSelector;
        LinearLayout r110 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.specifyFieldsSelector);
        if (r110 == null) goto L56;
        r104 = R.id.specifyFieldsSelectorView;
        MultiFieldItemView r111 = (MultiFieldItemView) ViewBindings.findChildViewById(r103, R.id.specifyFieldsSelectorView);
        if (r111 == null) goto L56;
        r104 = R.id.specifyFieldsTV;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.specifyFieldsTV)) == null) goto L56;
        r104 = R.id.timeFormatSelector;
        LinearLayout r112 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.timeFormatSelector);
        if (r112 == null) goto L56;
        r104 = R.id.timeFormatSelectorTV;
        TextView r113 = (TextView) ViewBindings.findChildViewById(r103, R.id.timeFormatSelectorTV);
        if (r113 == null) goto L56;
        r104 = R.id.timeFormatTV;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.timeFormatTV)) == null) goto L56;
        this.f211483v = new BitableFieldEditModifiedTimeViewBinding((LinearLayout) r103, r105, r106, r110, r111, r112, r113);
        int r107 = R.id.checkBox;
        if (((UDSwitch) ViewBindings.findChildViewById(r100, R.id.checkBox)) == null) goto L54;
        r107 = R.id.checkBoxContainer;
        FrameLayout r108 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.checkBoxContainer);
        if (r108 == null) goto L54;
        r107 = R.id.fieldPropertyChecker;
        LinearLayout r109 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.fieldPropertyChecker);
        if (r109 == null) goto L54;
        r107 = R.id.fieldPropertyCheckerTV;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.fieldPropertyCheckerTV)) == null) goto L54;
        r107 = R.id.fieldPropertyNew;
        if (((UDBadgeView) ViewBindings.findChildViewById(r100, R.id.fieldPropertyNew)) == null) goto L54;
        r107 = R.id.fieldPropertyRightArrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.fieldPropertyRightArrow)) == null) goto L54;
        LinearLayout r114 = (LinearLayout) r100;
        r107 = R.id.fieldPropertySelector;
        LinearLayout r115 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.fieldPropertySelector);
        if (r115 == null) goto L54;
        r107 = R.id.fieldPropertySelectorTV;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r100, R.id.fieldPropertySelectorTV);
        if (r116 == null) goto L54;
        r107 = R.id.fieldPropertySelectorTVDesc;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.fieldPropertySelectorTVDesc)) == null) goto L54;
        r107 = R.id.fieldPropertySelectorTip;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.fieldPropertySelectorTip)) == null) goto L54;
        r107 = R.id.fieldPropertyText;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r100, R.id.fieldPropertyText);
        if (r117 == null) goto L54;
        r107 = R.id.fieldPropertyTvLayout;
        FrameLayout r118 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.fieldPropertyTvLayout);
        if (r118 == null) goto L54;
        r107 = R.id.fieldPropertyWarning;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.fieldPropertyWarning)) == null) goto L54;
        r107 = R.id.rightSelectContainer;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.rightSelectContainer)) == null) goto L54;
        r107 = R.id.titleContainer;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.titleContainer)) == null) goto L54;
        this.f211484w = new BitableFieldEditPropertyViewBinding(r114, r108, r109, r115, r116, r117, r118);
        BaseFieldPropertyEditViewHolder.w(true, new View[]{r118, r115});
        BaseFieldPropertyEditViewHolder.w(false, new View[]{r109});
        r117.setText(R.string.Bitable_DB_LastModifiedDateField_CustomizeLastModifiedByField_Title);
        BitableFieldEditModifiedTimeViewBinding r119 = this.f211483v;
        if (r119 == null) goto L51;
        BaseFieldPropertyEditViewHolder.w(false, new View[]{r119.f210752b, r119.f210753c});
    L51:
        this.f211482u = y().subscribe(new g(this));
        return;
    L54:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r107)));
    L56:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.DateFieldPropertyEditViewHolder
    public final void x() {
        BitableFieldEditModifiedTimeViewBinding r100 = this.f211483v;
        if (r100 == null) goto L12;
        TextView r101 = r100.f210757g;
        if (r101 == null) goto L13;
        FieldConfigMetaModel.DateTimeFormatBean r102 = this.f211206l;
        if (r102 == null) goto L9;
        String r103 = r102.getText();
    L10:
        r101.setText(r103);
        return;
    L9:
        r103 = null;
        goto L10
    L13:
        return;
    }

    public final BitablePanelModel z() {
        BitablePanelModel r100 = new BitablePanelModel();
        r100.setTitle(this.f211149a.getString(R.string.Bitable_DB_LastModifiedDateField_SpecifiedFields_Option));
        ArrayList<BitablePanelItem> r101 = new ArrayList();
        ArrayList<GroupInfo> r102 = new ArrayList();
        GroupInfo r103 = new GroupInfo();
        r103.setGroupId("modified_time_group_id");
        if (this.f211480s == false) goto L5;
        r103.setBottomDesc(this.f211149a.getString(R.string.Bitable_Extension_LinkPreview_UnsupportedFieldHidden_Description));
    L5:
        r102.add(r103);
        r100.setGroupInfo(r102);
        Iterator<T> r104 = this.f211475n.iterator();
    L7:
        if (r104.hasNext() == false) goto L17;
        FieldSelectModel r105 = (FieldSelectModel) r104.next();
        BitablePanelItem r106 = new BitablePanelItem();
        r106.setId(r105.getFieldId());
        CheckboxValue r107 = new CheckboxValue();
        ModifiedTimeWatch r108 = this.f211474m;
        if (r108 == null) goto L15;
        ModifiedTimeSource r109 = r108.getSource();
        if (r109 == null) goto L15;
        List<String> r110 = r109.getFields();
        if (r110 == null) goto L15;
        boolean r111 = r110.contains(r105.getFieldId());
    L16:
        r107.setValue(r111);
        r106.setCheckbox(r107);
        r106.setLeftText(r105.getFieldName());
        r106.setLeftStyle(Style.Normal.getValue());
        Icon r112 = new Icon();
        r112.setImgRes(Integer.valueOf(r105.getFieldUIType().getIconRes()));
        r106.setLeftIcon(r112);
        r106.setLeftIconStyle(Integer.valueOf(Style.Desc.getValue()));
        r106.setGroupId("modified_time_group_id");
        r101.add(r106);
    L15:
        r111 = false;
        goto L16
    L17:
        r100.setData(r101);
        BitableFieldEditViewModel r113 = this.f211156h;
        Integer r114 = null;
        if (r113 == null) goto L24;
        MutableLiveData<FieldEditPanelData> r115 = r113.getPanelData();
        if (r115 == null) goto L24;
        FieldEditPanelData r116 = r115.getValue();
        if (r116 == null) goto L24;
        String r117 = r116.getSrcObjToken();
    L25:
        r100.setSrcObjToken(r117);
        BitableFieldEditViewModel r118 = this.f211156h;
        if (r118 == null) goto L32;
        MutableLiveData<FieldEditPanelData> r119 = r118.getPanelData();
        if (r119 == null) goto L32;
        FieldEditPanelData r120 = r119.getValue();
        if (r120 == null) goto L32;
        r114 = r120.getSrcObjType();
    L32:
        r100.setSrcObjType(r114);
        return r100;
    L24:
        r117 = null;
        goto L25
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void h() {
        if (A() == true) goto L5;
        return;
    L5:
        if (((ArrayList) this.f211477p).isEmpty() == false) goto L9;
        Toast.showText(this.f211149a, R.string.Bitable_DB_LastModifiedDateField_SpecifiedFieldRequired_Desc);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void onDetach() {
        super.onDetach();
        Disposable r100 = this.f211482u;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.DateFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final FieldProperty p() {
        FieldProperty r100 = super.p();
        r100.setWatch(this.f211474m);
        return r100;
    }

    public final Observable<Boolean> y() {
        FieldEditPanelData r100 = r().m();
        if (r100 == null) goto L5;
        String r101 = r100.getTableId();
    L6:
        q0.a r102 = r();
        CommonActionType r103 = CommonActionType.GET_FIELD_LIST;
        JSONObject r104 = new JSONObject();
        r104.put2("tableId", r101);
        Unit r105 = Unit.INSTANCE;
        Observable r106 = r102.k(r103, r104, String.class);
        if (r106 == null) goto L14;
        Observable r107 = r106.map(b.f211485a);
        if (r107 == null) goto L14;
        Observable<Boolean> r108 = r107.map(new c(this));
        if (r108 == null) goto L14;
        return r108;
    L14:
        return Observable.empty();
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.DateFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void l(Object r100) {
        if ((r100 instanceof FieldConfigMetaModel.DateTimeFormatBean) == false) goto L5;
        FieldConfigMetaModel.DateTimeFormatBean r101 = (FieldConfigMetaModel.DateTimeFormatBean) r100;
    L6:
        if (r101 == null) goto L9;
        this.f211206l = r101;
        x();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public ModifiedTimeFieldPropertyEditViewHolder(Context r100, FieldCompositeType r101, FieldConfigMetaModel.DateTimeFormatBean[] r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFieldCompositeType");
        super(r100, r101, r102);
        this.f211475n = new ArrayList();
        this.f211476o = new ArrayList();
        this.f211477p = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.DateFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void u(FieldConfigMetaModel.FieldConfigItem r100, FieldProperty r101, AllowedEditModes r102, FieldExtendInfo r103) {
        super.u(r100, r101, r102, r103);
        if (r101 == null) goto L7;
        ModifiedTimeWatch r104 = r101.getWatch();
        if (r104 == null) goto L7;
        ModifiedTimeWatch r105 = r104.clone();
    L8:
        this.f211474m = r105;
        B();
        return;
    L7:
        r105 = null;
        goto L8
    }
}
