package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ColorBean;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.CommonActionType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.RandomColorResult;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import com.bytedance.ee.bear.bitable.common.model.field.OptionsType;
import com.bytedance.ee.bear.bitable.common.model.field.RichOptionItem;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0;
import com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionAdapter;
import com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionItemTouchHelperCallback;
import com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionItemView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u000245B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u001aJ\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0014J\b\u0010$\u001a\u00020\u001eH\u0003J0\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020)H\u0014J\u0010\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u000203H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001c¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/selectField/StaticPropertyEditViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BaseFieldPropertyEditViewHolder;", "mContext", "Landroid/content/Context;", "mFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "mCommonColorList", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;Landroid/view/ViewGroup;[Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;)V", "[Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/ColorBean;", "mOptionAdapter", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/selectField/StaticPropertyEditViewHolder$SelectOptionAdapter;", "mColorPickerPanel", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/OptionCreationPanel;", "mNewOptionId", "", "mHasShownKeyboardAfterAddNewOption", "", "mOptionList", "", "Lcom/bytedance/ee/bear/bitable/common/model/field/OptionItem;", "mSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "optionCanDelete", "Ljava/lang/Boolean;", "initView", "", "initOptionListRV", "setSrcObjInfo", "srcObjInfo", "updateAddNewOptionBtnVisibility", "initClickEvent", "createNewOption", "injectFieldInfo", "fieldConfigItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "fieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "showColorPicker", "optionBean", "getCurrentEditProperty", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "SelectOptionAdapter", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StaticPropertyEditViewHolder extends BaseFieldPropertyEditViewHolder {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f211557t = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f211558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ColorBean[] f211559l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SelectOptionAdapter f211560m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.select.t f211561n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f211562o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f211563p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<OptionItem> f211564q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public mr4.a f211565r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f211566s;

    public final class SelectOptionAdapter extends OptionAdapter<OptionItem> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ StaticPropertyEditViewHolder f211567c;

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/selectField/StaticPropertyEditViewHolder$SelectOptionAdapter$SelectOptionViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionAdapter$OptionViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/model/field/OptionItem;", "itemView", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemView;", "<init>", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/selectField/StaticPropertyEditViewHolder$SelectOptionAdapter;Lcom/bytedance/ee/bear/bitable/fieldedit/view/widgets/OptionItemView;)V", "mColorContainer", "Landroid/view/View;", "getMColorContainer", "()Landroid/view/View;", "mColorIV", "Landroid/widget/ImageView;", "getMColorIV", "()Landroid/widget/ImageView;", "mOptionET", "Landroid/widget/EditText;", "getMOptionET", "()Landroid/widget/EditText;", "mCurrentOptionBean", "onBindView", "", "optionBean", "onDeleteBtnClicked", "position", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class SelectOptionViewHolder extends OptionAdapter.OptionViewHolder<OptionItem> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final View f211568a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ImageView f211569b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final EditText f211570c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public OptionItem f211571d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ SelectOptionAdapter f211572e;

            public static final class a implements View.OnFocusChangeListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ StaticPropertyEditViewHolder f211573a;

                public a(SelectOptionViewHolder r100, StaticPropertyEditViewHolder r101) {
                    this.f211573a = r101;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View r100, boolean r101) {
                    StaticPropertyEditViewHolder r102 = this.f211573a;
                    if (r101 == false) goto L8;
                    int r103 = StaticPropertyEditViewHolder.f211557t;
                    r102.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.FOCUS_CHANGE, Boolean.TRUE);
                    BitableFieldEditAnalytic r104 = r102.r().q0();
                    if (r104 == null) goto L9;
                    r104.U("title", null);
                    return;
                L9:
                    return;
                }
            }

            public static final class b extends com.bytedance.ee.bear.widgets.t {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ StaticPropertyEditViewHolder f211574c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ SelectOptionViewHolder f211575d;

                @Override // com.bytedance.ee.bear.widgets.t
                public final void a(View r100) {
                    StaticPropertyEditViewHolder r101 = this.f211574c;
                    int r102 = StaticPropertyEditViewHolder.f211557t;
                    r101.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.CHANGE_OPTION_COLOR, null);
                    OptionItem r103 = this.f211575d.f211571d;
                    if (r103 == null) goto L18;
                    StaticPropertyEditViewHolder r104 = this.f211574c;
                    com.bytedance.ee.bear.bitable.card.view.cell.select.t r105 = r104.f211561n;
                    if (r105 != null) goto L7;
                    com.bytedance.ee.bear.bitable.card.view.cell.select.t r106 = new com.bytedance.ee.bear.bitable.card.view.cell.select.t(r104.f211149a, r104.f211559l, r103.getColor());
                    r106.C();
                    r106.B();
                    r106.f486406j = r104.f211565r;
                    r104.f211561n = r106;
                L8:
                    com.bytedance.ee.bear.bitable.card.view.cell.select.t r107 = r104.f211561n;
                    if (r107 == null) goto L18;
                    r107.D(r103.getName());
                    z r108 = new z(r103, r104);
                    Intrinsics.checkNotNullParameter(r108, "listener");
                    r107.f208177o = r108;
                    com.bytedance.ee.bear.bitable.card.view.cell.select.t r109 = r104.f211561n;
                    if (r109 == null) goto L13;
                    r109.show();
                L13:
                    q0.a r110 = r104.r();
                    if (r110 == null) goto L18;
                    BitableFieldEditAnalytic r111 = r110.q0();
                    if (r111 == null) goto L18;
                    r111.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_COLOR_BOARD_VIEW, new HashMap());
                    goto L18
                L7:
                    r105.f208176n = r103.getColor();
                    r105.x();
                L18:
                    BitableFieldEditAnalytic r112 = this.f211574c.r().q0();
                    if (r112 == null) goto L22;
                    r112.U(BitableAnalytic.SelectSceneClickType.CHANGE_COLOR, BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_COLOR_BOARD_VIEW);
                    return;
                }

                public b(StaticPropertyEditViewHolder r100, SelectOptionViewHolder r101) {
                    this.f211574c = r100;
                    this.f211575d = r101;
                }
            }

            public static final class c implements TextWatcher {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SelectOptionViewHolder f211576a;

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
                }

                public c(SelectOptionViewHolder r100) {
                    this.f211576a = r100;
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable r100) {
                    OptionItem r101 = this.f211576a.f211571d;
                    if (r101 == null) goto L9;
                    if (r100 == null) goto L6;
                    String r102 = r100.toString();
                L7:
                    r101.setName(r102);
                    return;
                L6:
                    r102 = null;
                    goto L7
                }
            }

            @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionAdapter.OptionViewHolder
            public final void T3(OptionItem r100) {
                OptionItem r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "optionBean");
                this.f211571d = r101;
                this.f211570c.setText(r101.getName());
                if (TextUtils.equals(this.f211572e.f211567c.f211562o, r101.getId()) == true) goto L5;
            L10:
                int r102 = r101.getColor();
                ColorBean[] r103 = this.f211572e.f211567c.f211559l;
                if (r103 == null) goto L13;
                int r104 = r103.length;
            L14:
                if (r104 <= r102) goto L22;
                if (r103 == null) goto L23;
                ColorBean r105 = r103[r102];
                if (r105 == null) goto L24;
                String r106 = r105.getColor();
                if (r106 == null) goto L25;
                this.f211569b.setBackgroundColor(ColorUtils.h(r106));
                return;
            L25:
                return;
            L24:
                return;
            L23:
                return;
            L22:
                return;
            L13:
                r104 = 0;
                goto L14
            L5:
                if (this.f211572e.f211567c.f211563p == true) goto L10;
                this.f211570c.requestFocus();
                StaticPropertyEditViewHolder r107 = this.f211572e.f211567c;
                r107.f211563p = true;
                if (r107.f211158j > 0) goto L9;
                this.f211570c.post(new u(this));
                goto L10
            L9:
                this.f211570c.post(new v(r107));
                goto L10
            }

            @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionAdapter.OptionViewHolder
            public final void U3(int r100) {
                if (Intrinsics.areEqual(this.f211572e.f211567c.f211566s, Boolean.FALSE) == false) goto L6;
                Toast.showText(this.itemView.getContext(), this.itemView.getContext().getString(R.string.Bitable_AdvancedPermissions_UnableToDeleteReferencedOption_Toast_Mob));
                return;
            L6:
                this.f211572e.f211567c.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.DELETE_OPTION, null);
                ListProtector.remove(this.f211572e.f211567c.f211564q, r100);
                this.f211572e.notifyItemRemoved(r100);
                rcb.c.c(this.f211572e.f211567c.f211149a);
                BitableFieldEditAnalytic r101 = this.f211572e.f211567c.r().q0();
                if (r101 == null) goto L10;
                r101.U("delete", null);
                return;
            }

            public SelectOptionViewHolder(SelectOptionAdapter r100, OptionItemView r101) {
                Intrinsics.checkNotNullParameter(r101, "itemView");
                this.f211572e = r100;
                super(r101);
                View r102 = r101.findViewById(R.id.color_container);
                this.f211568a = r102;
                this.f211569b = (ImageView) r101.findViewById(R.id.color_iv);
                EditText r103 = (EditText) r101.findViewById(R.id.option_et);
                this.f211570c = r103;
                r103.addTextChangedListener(new c(this));
                r103.setOnFocusChangeListener(new a(this, r100.f211567c));
                r102.setOnClickListener(new b(r100.f211567c, this));
            }
        }

        @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionAdapter
        public final List<OptionItem> y2() {
            return this.f211567c.f211564q;
        }

        public SelectOptionAdapter(StaticPropertyEditViewHolder r100) {
            this.f211567c = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            StaticPropertyEditViewHolder r102 = this.f211567c;
            int r103 = StaticPropertyEditViewHolder.f211557t;
            OptionItemView r104 = new OptionItemView(r102.f211149a, null, 6, 0);
            r104.a(R.layout.bitable_field_edit_select_item);
            return new SelectOptionViewHolder(this, r104);
        }

        @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionAdapter, com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionItemTouchHelperCallback.a
        public final void onMove(int r100, int r101) {
            super.onMove(r100, r101);
            StaticPropertyEditViewHolder r102 = this.f211567c;
            int r103 = StaticPropertyEditViewHolder.f211557t;
            r102.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.DRAG_OPTION, null);
            BitableFieldEditAnalytic r104 = this.f211567c.r().q0();
            if (r104 == null) goto L6;
            HashMap r105 = new HashMap();
            r105.put("click", "option_drag");
            r105.put(PickerReporterConstants.KEY.TARGET, "none");
            r105.put("from_option_idx", Integer.valueOf(r100));
            r105.put("to_option_idx", Integer.valueOf(r101));
            r104.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_OPTION_FIELD_MODIFY_CLICK, r105);
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.OptionAdapter
        public final void z2(int r100, int r101) {
            super.z2(r100, r101);
            ViewGroup r102 = this.f211567c.f211558k;
            if (r102 == null) goto L5;
            LKUIRoundableLayout r103 = (LKUIRoundableLayout) r102.findViewById(R.id.optionListContainer);
        L6:
            if (r103 == null) goto L12;
            if (r101 <= 0) goto L9;
            int r104 = 0;
        L10:
            r103.setVisibility(r104);
            return;
        L9:
            r104 = 8;
            goto L10
        L12:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class a {
    }

    public static final class b extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ StaticPropertyEditViewHolder f211577c;

        public b(StaticPropertyEditViewHolder r100) {
            this.f211577c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            StaticPropertyEditViewHolder r101 = this.f211577c;
            int r102 = StaticPropertyEditViewHolder.f211557t;
            q0.a r103 = r101.r();
            if (r103 == null) goto L9;
            CommonActionType r104 = CommonActionType.GET_NEW_OPTION_ID;
            JSONObject r105 = new JSONObject();
            List<OptionItem> r106 = r101.f211564q;
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
            Iterator r108 = ((ArrayList) r106).iterator();
        L6:
            if (r108.hasNext() == false) goto L8;
            r107.add(((OptionItem) r108.next()).getId());
            goto L6
        L8:
            r105.put2("optionIds", r107);
            r105.put2("total", 1);
            Unit r109 = Unit.INSTANCE;
            Observable r110 = r103.k(r104, r105, String.class);
        L10:
            q0.a r111 = r101.r();
            if (r111 == null) goto L17;
            CommonActionType r112 = CommonActionType.GET_RANDOM_COLOR;
            JSONObject r113 = new JSONObject();
            List<OptionItem> r114 = r101.f211564q;
            ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
            Iterator r116 = ((ArrayList) r114).iterator();
        L14:
            if (r116.hasNext() == false) goto L16;
            r115.add(Integer.valueOf(((OptionItem) r116.next()).getColor()));
            goto L14
        L16:
            r113.put2("colors", r115);
            Unit r117 = Unit.INSTANCE;
            Observable r118 = r111.k(r112, r113, RandomColorResult.class);
        L18:
            Observable.zip(r110, r118, new w(r101)).subscribe(new x(r101), y.f211642a);
            this.f211577c.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.CREATE_NEW_OPTION, null);
            BitableFieldEditAnalytic r119 = this.f211577c.r().q0();
            if (r119 == null) goto L24;
            r119.U("add_option", null);
            return;
        L24:
            return;
        L17:
            r118 = null;
            goto L18
        L9:
            r110 = null;
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final FieldProperty p() {
        FieldProperty r100 = new FieldProperty();
        r100.setOptionsType(OptionsType.STATIC.getValue());
        List<OptionItem> r101 = this.f211564q;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = ((ArrayList) r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        OptionItem r104 = (OptionItem) r103.next();
        RichOptionItem.Companion.getClass();
        r102.add(RichOptionItem.a.a(r104));
        goto L4
    L6:
        r100.setOptions((RichOptionItem[]) r102.toArray(new RichOptionItem[0]));
        r100.setOptionsRule(null);
        return r100;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void t() {
        ViewGroup r100 = this.f211558k;
        if (r100 == null) goto L21;
        r100.removeAllViews();
        LayoutInflater.from(this.f211149a).inflate(R.layout.bitable_field_edit_select_static_opt, this.f211558k, true);
        this.f211560m = new SelectOptionAdapter(this);
        ViewGroup r101 = this.f211558k;
        RecyclerView r102 = null;
        if (r101 == null) goto L7;
        RecyclerView r103 = (RecyclerView) r101.findViewById(R.id.optionListRV);
    L8:
        if (r103 == null) goto L10;
        r103.setLayoutManager(new LinearLayoutManager(this.f211149a));
    L10:
        ViewGroup r104 = this.f211558k;
        if (r104 == null) goto L13;
        RecyclerView r105 = (RecyclerView) r104.findViewById(R.id.optionListRV);
    L14:
        if (r105 == null) goto L16;
        r105.setAdapter(this.f211560m);
    L16:
        OptionItemTouchHelperCallback r106 = new OptionItemTouchHelperCallback();
        r106.f211732a = this.f211560m;
        ItemTouchHelper r107 = new ItemTouchHelper(r106);
        ViewGroup r108 = this.f211558k;
        if (r108 == null) goto L19;
        r102 = (RecyclerView) r108.findViewById(R.id.optionListRV);
    L19:
        r107.attachToRecyclerView(r102);
        x();
        return;
    L13:
        r105 = null;
        goto L14
    L7:
        r103 = null;
        goto L8
    }

    public final void x() {
        int r100 = 0;
        if (ku5.c.k(this.f211149a) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        ViewGroup r102 = this.f211558k;
        if (r102 == null) goto L11;
        LinearLayout r103 = (LinearLayout) r102.findViewById(R.id.addNewOptionBtn);
    L12:
        if (r103 == null) goto L17;
        if (r101 == false) goto L15;
        r100 = 8;
    L15:
        r103.setVisibility(r100);
        return;
    L17:
        return;
    L11:
        r103 = null;
        goto L12
    L5:
        if (this.f211149a.getResources().getConfiguration().orientation != 2) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void s() {
        super.s();
        ViewGroup r100 = this.f211558k;
        if (r100 == null) goto L5;
        LinearLayout r101 = (LinearLayout) r100.findViewById(R.id.addNewOptionBtn);
    L6:
        if (r101 == null) goto L9;
        r101.setOnClickListener(new b(this));
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        x();
    }

    public StaticPropertyEditViewHolder(Context r100, FieldCompositeType r101, ViewGroup r102, ColorBean[] r103) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFieldCompositeType");
        super(r100, r101);
        this.f211558k = r102;
        this.f211559l = r103;
        this.f211563p = true;
        this.f211564q = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void u(FieldConfigMetaModel.FieldConfigItem r100, FieldProperty r101, AllowedEditModes r102, FieldExtendInfo r103) {
        super.u(r100, r101, r102, r103);
        if (r101 == null) goto L12;
        RichOptionItem[] r104 = r101.getOptions();
        if (r104 == null) goto L12;
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        RichOptionItem r107 = r104[r106];
        List<OptionItem> r108 = this.f211564q;
        ArrayList r109 = (ArrayList) r108;
        r109.add(new OptionItem(r107.getId(), r107.getName(), r107.getColor()));
        r106 = r106 + 1;
        goto L7
    L9:
        SelectOptionAdapter r110 = this.f211560m;
        if (r110 == null) goto L12;
        r110.notifyDataSetChanged();
    L12:
        if (r101 == null) goto L14;
        Boolean r111 = r101.getOptionCanDelete();
    L15:
        this.f211566s = r111;
        return;
    L14:
        r111 = null;
        goto L15
    }
}
