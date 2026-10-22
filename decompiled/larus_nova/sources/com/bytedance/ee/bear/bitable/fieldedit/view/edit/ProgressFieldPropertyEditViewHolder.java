package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.WatermarkUtils;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.fieldedit.view.widgets.ColorPreviewFlexLayout;
import com.bytedance.ee.bear.bitable.fieldedit.view.widgets.EllipsizeEditText;
import com.bytedance.ee.bear.bitable.fieldedit.view.widgets.GradientOffsetView;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.BitableFieldEditViewModel;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.BitablePanelModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020,H\u0014J0\u0010.\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001c\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u00010\r2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001c\u00109\u001a\u00020,2\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\b2\u0006\u0010<\u001a\u00020\rH\u0002J5\u0010=\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u00010\u00142\b\u0010?\u001a\u0004\u0018\u00010\u00162\b\u0010@\u001a\u0004\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u0010AJ\n\u0010B\u001a\u0004\u0018\u000102H\u0014J\b\u0010C\u001a\u00020,H\u0002J\b\u0010D\u001a\u00020,H\u0002J\b\u0010E\u001a\u00020,H\u0002J\b\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020,H\u0002J\b\u0010H\u001a\u00020,H\u0002J\b\u0010I\u001a\u00020,H\u0002J\u0017\u0010J\u001a\u0004\u0018\u00010\u00162\u0006\u0010K\u001a\u00020\rH\u0002¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\u00020,2\n\u0010N\u001a\u00060Oj\u0002`PH\u0002J\b\u0010Q\u001a\u00020,H\u0002J\u0014\u0010R\u001a\u0004\u0018\u00010$2\b\u0010S\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010T\u001a\u00020,H\u0016J!\u0010U\u001a\u00020\r2\b\u0010V\u001a\u0004\u0018\u00010\u00032\b\u0010W\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010XJ#\u0010Y\u001a\u0004\u0018\u00010\r2\b\u0010V\u001a\u0004\u0018\u00010\u00032\b\u0010Z\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010XR\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001aj\b\u0012\u0004\u0012\u00020\b`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u001c\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00070\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/ProgressFieldPropertyEditViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BaseFieldPropertyEditViewHolder;", "mContext", "Landroid/content/Context;", "mFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "mCommonColorList", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "TAG", "", "mCurFormatType", "", "Ljava/lang/Integer;", "mCurDigits", "mCurColor", "mCustomizedRange", "", "mCurRangeStart", "", "Ljava/lang/Double;", "mCurRangeEnd", "mSupportColors", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mSupportNumberFormatAndDigits", "", "Lkotlin/Pair;", "mNumberEditPanel", "Lcom/bytedance/ee/bear/bitable/card/view/cell/number/NumberEditPanel;", "mDefaultRangeStart", "mDefaultRangeEnd", "mLocale", "Ljava/util/Locale;", "getMLocale", "()Ljava/util/Locale;", "FLAG_EDIT_RANGE_NONE", "FLAG_EDIT_RANGE_START", "FLAG_EDIT_RANGE_END", "mCurEditRangeFlag", "initView", "", "initClickEvent", "injectFieldInfo", "fieldConfigItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "fieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "initFormat", "formatter", "initColor", "color", "getColorById", "id", "initRange", "isCustomize", "rangeStart", "rangeEnd", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Double;Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;)V", "getCurrentEditProperty", "updateProgressFormatTypeView", "updateDecimalFormatView", "updateRangeView", "updateProgressColorView", "createNumberEditPanelIfNeed", "enterInputMode", "exitInputMode", "parseInputRange", "input", "(Ljava/lang/String;)Ljava/lang/Double;", "handleNumberFormatException", "e", "Ljava/lang/NumberFormatException;", "Lkotlin/NumberFormatException;", "compareRangeStartAndEnd", "parseLocale", "localeTag", "verifyFailWhenSaveData", "getFormatTypeName", PerfLog.PARAM_KEY_CONTEXT_ID, "type", "(Landroid/content/Context;Ljava/lang/Integer;)Ljava/lang/String;", "getFormatDecimalDigitsName", "decimaiDigits", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProgressFieldPropertyEditViewHolder extends BaseFieldPropertyEditViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FieldConfigMetaModel.CommonColor[] f211210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f211211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f211212m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FieldConfigMetaModel.CommonColor f211213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f211214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Double f211215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Double f211216q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<FieldConfigMetaModel.CommonColor> f211217r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<Integer, Pair<Integer, Integer[]>> f211218s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.number.a f211219t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Double f211220u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Double f211221v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f211222w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f211223x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f211224y;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f211226b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.fieldedit.view.edit.ProgressFieldPropertyEditViewHolder$a$a, reason: collision with other inner class name */
        public static final class C3032a implements com.bytedance.ee.bear.bitable.panel.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211227a;

            @Override // com.bytedance.ee.bear.bitable.panel.l
            public final /* synthetic */ void onExit() {
            }

            public C3032a(ProgressFieldPropertyEditViewHolder r100) {
                this.f211227a = r100;
            }

            @Override // com.bytedance.ee.bear.bitable.panel.l
            public final void a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "id");
                ProgressFieldPropertyEditViewHolder r101 = this.f211227a;
                r101.f211211l = Integer.valueOf(CastIntegerProtector.parseInt(r100));
                ProgressFieldPropertyEditViewHolder r102 = this.f211227a;
                View r103 = r102.f211151c;
                ((TextView) r103.findViewById(R.id.formatTv)).setText(ProgressFieldPropertyEditViewHolder.A(r103.getContext(), r102.f211211l));
                ProgressFieldPropertyEditViewHolder r104 = this.f211227a;
                Map<Integer, Pair<Integer, Integer[]>> r105 = r104.f211218s;
                LinkedHashMap r106 = (LinkedHashMap) r105;
                Pair r107 = (Pair) r106.get(r104.f211211l);
                if (r107 == null) goto L5;
                Integer r108 = (Integer) r107.getFirst();
            L6:
                r104.f211212m = r108;
                this.f211227a.D();
                this.f211227a.F();
                return;
            L5:
                r108 = null;
                goto L6
            }
        }

        public a(ProgressFieldPropertyEditViewHolder r100, View r101) {
            this.f211225a = r100;
            this.f211226b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            com.bytedance.ee.bear.bitable.card.view.cell.number.a r111 = this.f211225a.f211219t;
            if (r111 != null) goto L5;
        L7:
            boolean r100 = false;
        L8:
            if (r100 == false) goto L11;
            if (r111 == null) goto L11;
            r111.c(false);
        L11:
            BitableFieldEditAnalytic r112 = this.f211225a.r().q0();
            if (r112 == null) goto L18;
            String[] r101 = new String[1];
            Integer r102 = this.f211225a.f211211l;
            if (r102 == null) goto L16;
            int r103 = r102.intValue();
        L17:
            r101[0] = yp4.i.b(Integer.valueOf(r103));
            r112.c0(BitableFieldEditAnalytic.ProgressFieldEditScene.NUMBER_FORMAT, r101);
            goto L18
        L16:
            r103 = 1;
        L18:
            Integer r104 = null;
            this.f211225a.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.SELECT_NUMBER_TYPE, null);
            Context r105 = this.f211226b.getContext();
            FragmentManager r106 = this.f211225a.r().getFragmentManager();
            BitablePanelModel r107 = new BitablePanelModel();
            View r113 = this.f211226b;
            ProgressFieldPropertyEditViewHolder r108 = this.f211225a;
            r107.setTitle(r113.getContext().getString(R.string.Bitable_Progress_NumberFormat_Title));
            ArrayList<BitablePanelItem> r109 = new ArrayList();
            Iterator r114 = ((LinkedHashMap) r108.f211218s).keySet().iterator();
        L20:
            if (r114.hasNext() == false) goto L31;
            Integer r115 = (Integer) r114.next();
            if (r115 == null) goto L20;
            int r116 = r115.intValue();
            BitablePanelItem r117 = new BitablePanelItem();
            r117.setId(r115.toString());
            r117.setLeftText(ProgressFieldPropertyEditViewHolder.A(r113.getContext(), r115));
            Integer r118 = r108.f211211l;
            if (r118 != null) goto L27;
        L29:
            boolean r119 = false;
        L30:
            com.bytedance.ee.bear.bitable.panel.e.d(r117, r119);
            com.bytedance.ee.bear.bitable.panel.e.a(r117);
            r109.add(r117);
            goto L20
        L27:
            if (r118.intValue() != r116) goto L29;
            r119 = true;
            goto L30
        L31:
            r107.setData(r109);
            BitableFieldEditViewModel r120 = r108.f211156h;
            if (r120 == null) goto L38;
            MutableLiveData<FieldEditPanelData> r121 = r120.getPanelData();
            if (r121 == null) goto L38;
            FieldEditPanelData r122 = r121.getValue();
            if (r122 == null) goto L38;
            String r123 = r122.getSrcObjToken();
        L39:
            r107.setSrcObjToken(r123);
            BitableFieldEditViewModel r124 = r108.f211156h;
            if (r124 == null) goto L46;
            MutableLiveData<FieldEditPanelData> r125 = r124.getPanelData();
            if (r125 == null) goto L46;
            FieldEditPanelData r126 = r125.getValue();
            if (r126 == null) goto L46;
            r104 = r126.getSrcObjType();
        L46:
            r107.setSrcObjType(r104);
            Unit r127 = Unit.INSTANCE;
            com.bytedance.ee.bear.bitable.panel.e.m(r105, r106, r107, new C3032a(this.f211225a), null, 48);
            return;
        L38:
            r123 = null;
            goto L39
        L5:
            if (r111.f207923c != true) goto L7;
            r100 = true;
            goto L8
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f211229b;

        public static final class a implements com.bytedance.ee.bear.bitable.panel.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211230a;

            @Override // com.bytedance.ee.bear.bitable.panel.l
            public final /* synthetic */ void onExit() {
            }

            public a(ProgressFieldPropertyEditViewHolder r100) {
                this.f211230a = r100;
            }

            @Override // com.bytedance.ee.bear.bitable.panel.l
            public final void a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "id");
                ProgressFieldPropertyEditViewHolder r101 = this.f211230a;
                r101.f211212m = Integer.valueOf(CastIntegerProtector.parseInt(r100));
                this.f211230a.D();
                this.f211230a.F();
            }
        }

        public b(ProgressFieldPropertyEditViewHolder r100, View r101) {
            this.f211228a = r100;
            this.f211229b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            BitableFieldEditAnalytic r100 = this.f211228a.r().q0();
            if (r100 == null) goto L5;
            r100.c0(BitableFieldEditAnalytic.ProgressFieldEditScene.DECIMAL_DIGITS, new String[]{yp4.i.a(this.f211228a.f211212m)});
        L5:
            com.bytedance.ee.bear.bitable.card.view.cell.number.a r101 = this.f211228a.f211219t;
            if (r101 != null) goto L8;
        L10:
            boolean r102 = false;
        L11:
            if (r102 == false) goto L14;
            if (r101 == null) goto L14;
            r101.c(false);
        L14:
            this.f211228a.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.SELECT_DECIMAL_LENGTH, null);
            Context r103 = this.f211229b.getContext();
            FragmentManager r104 = this.f211228a.r().getFragmentManager();
            BitablePanelModel r105 = new BitablePanelModel();
            View r106 = this.f211229b;
            ProgressFieldPropertyEditViewHolder r107 = this.f211228a;
            r105.setTitle(r106.getContext().getString(R.string.Bitable_Progress_DecimalPlaces_Title));
            ArrayList<BitablePanelItem> r108 = new ArrayList();
            Pair r111 = (Pair) ((LinkedHashMap) r107.f211218s).get(r107.f211211l);
            if (r111 == null) goto L31;
            Integer[] r112 = (Integer[]) r111.getSecond();
            if (r112 == null) goto L31;
            int r113 = r112.length;
            int r114 = 0;
        L19:
            if (r114 >= r113) goto L31;
            int r115 = r112[r114].intValue();
            BitablePanelItem r116 = new BitablePanelItem();
            r116.setId(String.valueOf(r115));
            r116.setLeftText(ProgressFieldPropertyEditViewHolder.z(r106.getContext(), Integer.valueOf(r115)));
            Integer r109 = r107.f211211l;
            Context r117 = r103;
            String r118 = yp4.j.g(1.0d, Integer.valueOf(r115), r107.B());
            if (FieldConfigMetaModel.NumberFormatType.PERCENT.getValue() != r109.intValue()) goto L23;
            r118 = r118 + GXTemplateKey.GAIAX_PE;
        L23:
            r116.setRightText(r118);
            Integer r119 = r107.f211212m;
            if (r119 != null) goto L27;
        L29:
            boolean r120 = false;
        L30:
            com.bytedance.ee.bear.bitable.panel.e.d(r116, r120);
            com.bytedance.ee.bear.bitable.panel.e.a(r116);
            r108.add(r116);
            r114 = r114 + 1;
            r103 = r117;
            goto L19
        L27:
            if (r119.intValue() != r115) goto L29;
            r120 = true;
        L31:
            Context r121 = r103;
            r105.setData(r108);
            BitableFieldEditViewModel r122 = r107.f211156h;
            if (r122 == null) goto L38;
            MutableLiveData<FieldEditPanelData> r123 = r122.getPanelData();
            if (r123 == null) goto L38;
            FieldEditPanelData r124 = r123.getValue();
            if (r124 == null) goto L38;
            String r125 = r124.getSrcObjToken();
        L39:
            r105.setSrcObjToken(r125);
            BitableFieldEditViewModel r126 = r107.f211156h;
            if (r126 == null) goto L46;
            MutableLiveData<FieldEditPanelData> r127 = r126.getPanelData();
            if (r127 == null) goto L46;
            FieldEditPanelData r128 = r127.getValue();
            if (r128 == null) goto L46;
            Integer r129 = r128.getSrcObjType();
        L47:
            r105.setSrcObjType(r129);
            Unit r130 = Unit.INSTANCE;
            com.bytedance.ee.bear.bitable.panel.e.m(r121, r104, r105, new a(this.f211228a), null, 48);
            return;
        L46:
            r129 = null;
        L38:
            r125 = null;
            goto L39
        L8:
            if (r101.f207923c != true) goto L10;
            r102 = true;
            goto L11
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f211232b;

        public static final class a implements com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f211233a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211234b;

            @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.d
            public final /* synthetic */ void a() {
            }

            @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.d
            public final List<FieldConfigMetaModel.CommonColor> b() {
                return this.f211234b.f211217r;
            }

            @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.d
            public final String getPanelTitle() {
                return this.f211233a.getContext().getString(R.string.Bitable_Progress_ProgressBarColor_Title);
            }

            @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.d
            public final mr4.a o() {
                BitableFieldEditViewModel r100 = this.f211234b.f211156h;
                Integer r101 = null;
                if (r100 == null) goto L9;
                MutableLiveData<FieldEditPanelData> r102 = r100.getPanelData();
                if (r102 == null) goto L9;
                FieldEditPanelData r103 = r102.getValue();
                if (r103 == null) goto L9;
                String r104 = r103.getSrcObjToken();
            L10:
                BitableFieldEditViewModel r105 = this.f211234b.f211156h;
                if (r105 == null) goto L18;
                MutableLiveData<FieldEditPanelData> r106 = r105.getPanelData();
                if (r106 == null) goto L18;
                FieldEditPanelData r107 = r106.getValue();
                if (r107 == null) goto L18;
                r101 = r107.getSrcObjType();
            L18:
                return new mr4.a(r104, r101);
            L9:
                r104 = null;
                goto L10
            }

            @Override // com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.d
            public final void c(FieldConfigMetaModel.CommonColor r100) {
                Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
                ProgressFieldPropertyEditViewHolder r101 = this.f211234b;
                r101.f211213n = r100;
                r101.E();
            }

            public a(View r100, ProgressFieldPropertyEditViewHolder r101) {
                this.f211233a = r100;
                this.f211234b = r101;
            }
        }

        public c(ProgressFieldPropertyEditViewHolder r100, View r101) {
            this.f211231a = r100;
            this.f211232b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            BitableFieldEditAnalytic r111 = this.f211231a.r().q0();
            if (r111 == null) goto L10;
            String[] r100 = new String[1];
            FieldConfigMetaModel.CommonColor r101 = this.f211231a.f211213n;
            if (r101 == null) goto L8;
            String r102 = r101.getId();
            if (r102 == null) goto L8;
        L9:
            r100[0] = r102;
            r111.c0("color", r100);
        L8:
            r102 = "";
        L10:
            com.bytedance.ee.bear.bitable.card.view.cell.number.a r112 = this.f211231a.f211219t;
            if (r112 != null) goto L13;
        L15:
            boolean r103 = false;
        L16:
            if (r103 == false) goto L19;
            if (r112 == null) goto L19;
            r112.c(false);
        L19:
            FieldConfigMetaModel.CommonColor r104 = null;
            Object r105 = null;
            this.f211231a.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.SELECT_PROGRESS_COLOR, null);
            com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a r113 = new com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a(this.f211232b.getContext(), new a(this.f211232b, this.f211231a));
            FieldConfigMetaModel.CommonColor r106 = this.f211231a.f211213n;
            if (r106 == null) goto L22;
            String r107 = r106.getId();
        L23:
            r113.f211742g = r107;
            if (r113.f211738c != null) goto L51;
            r113.f211745j = true;
            CommonActionPanelLayout r108 = new CommonActionPanelLayout(r113.f211736a);
            r108.setTitle(r113.f211737b.getPanelTitle());
            r108.setPanelBackgroundColor(R.color.bg_float_base);
            r108.setOnActionListener(new com.bytedance.ee.bear.bitable.fieldedit.view.widgets.c(r113));
            View r109 = LayoutInflater.from(r113.f211736a).inflate(R.layout.bitable_field_edit_progress_color_select_view, null);
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup r114 = (ViewGroup) r109;
            ViewGroup.MarginLayoutParams r115 = new ViewGroup.MarginLayoutParams(-1, -2);
            int r116 = r113.f211736a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
            r115.setMargins(r116, r116, r116, 0);
            r113.f211739d = (RecyclerView) r114.findViewById(R.id.colorRv);
            r113.f211741f = (ColorPreviewFlexLayout) r114.findViewById(R.id.preview_bar_Layout);
            r113.f211740e = (TextView) r114.findViewById(R.id.colorTip);
            RecyclerView r117 = r113.f211739d;
            if (r117 == null) goto L39;
            com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.C3035a r118 = new com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.C3035a(r113, r113.f211736a);
            r113.f211743h = r118;
            r118.setOrientation(0);
            com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.c r119 = new com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.c(r113, r113.f211736a);
            r113.f211744i = r119;
            List<FieldConfigMetaModel.CommonColor> r120 = r113.f211737b.b();
            Intrinsics.checkNotNullParameter(r120, "colorList");
            r119.f211750b = r120;
            r119.notifyDataSetChanged();
            r117.setLayoutManager(r113.f211743h);
            r117.addItemDecoration(new com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.b(com.bytedance.ee.util.ui.n.d(3)));
            r117.setAdapter(r113.f211744i);
            com.bytedance.ee.bear.bitable.fieldedit.view.widgets.a.C3035a r121 = r113.f211743h;
            if (r121 == null) goto L39;
            RecyclerView.State r122 = new RecyclerView.State();
            String r123 = r113.f211742g;
            if (r123 == null) goto L37;
            Iterator<T> r124 = r113.f211737b.b().iterator();
            int r125 = 0;
        L33:
            if (r124.hasNext() == false) goto L38;
            if (TextUtils.equals(r123, ((FieldConfigMetaModel.CommonColor) r124.next()).getId()) == true) goto L38;
            r125 = r125 + 1;
        L38:
            r121.smoothScrollToPosition(r117, r122, r125);
            goto L39
        L37:
            r125 = 0;
        L39:
            r108.addView(r114, r115);
            if (ku5.c.k(r113.f211736a) == false) goto L42;
            int r126 = R.style.CustomPadBottomSheetDialog;
        L43:
            Dialog r127 = new Dialog(r113.f211736a, r126);
            r127.setContentView(r108);
            Window r128 = r127.getWindow();
            if (r128 == null) goto L47;
            r108.measure(0, 0);
            WindowManager.LayoutParams r129 = r128.getAttributes();
            r129.width = -1;
            r129.height = r108.getMeasuredHeight();
            r129.gravity = 80;
            r128.setAttributes(r129);
        L47:
            if (com.bytedance.ee.bear.bitable.utils.g.b() == false) goto L49;
            int r130 = WatermarkUtils.f209802a;
            WatermarkUtils.a(r113.f211737b.o(), r127);
        L50:
            r113.f211738c = r127;
            goto L51
        L49:
            ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(r127);
            goto L50
        L42:
            r126 = R.style.CustomBottomSheetDialog;
        L51:
            List<FieldConfigMetaModel.CommonColor> r131 = r113.f211737b.b();
            if (r131 == null) goto L64;
            Iterator<T> r132 = r131.iterator();
        L55:
            if (r132.hasNext() == false) goto L63;
            Object r133 = r132.next();
            FieldConfigMetaModel.CommonColor r134 = (FieldConfigMetaModel.CommonColor) r133;
            String r135 = r113.f211742g;
            if (r134 == null) goto L59;
            String r136 = r134.getId();
        L61:
            if (TextUtils.equals(r135, r136) == false) goto L55;
            r105 = r133;
            goto L63
        L59:
            r136 = null;
        L63:
            r104 = (FieldConfigMetaModel.CommonColor) r105;
        L64:
            r113.a(r104);
            Dialog r137 = r113.f211738c;
            if (r137 != null) goto L67;
            return;
        L67:
            if (DialogLancet.shouldBlockDialogShow(r137) == false) goto L73;
            DialogLancet.handleBlockedDialogShow(r137);
            return;
        L73:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L72
        L70:
            DialogLancet.beforeDialogShow(r137);
            r137.show();
            DialogLancet.afterDialogShow(r137);
            return;
        L22:
            r107 = null;
            goto L23
        L13:
            if (r112.f207923c != true) goto L15;
            r103 = true;
            goto L16
        }
    }

    public static final class d implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211235a;

        public d(ProgressFieldPropertyEditViewHolder r100) {
            this.f211235a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L9;
            BitableFieldEditAnalytic r102 = this.f211235a.r().q0();
            if (r102 == null) goto L6;
            r102.c0(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, new String[0]);
        L6:
            this.f211235a.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.SET_PROGRESS_MIN, null);
            ProgressFieldPropertyEditViewHolder r103 = this.f211235a;
            int r104 = r103.f211224y;
            r103.getClass();
            if (r104 == 0) goto L13;
            ProgressFieldPropertyEditViewHolder r105 = this.f211235a;
            r105.getClass();
            r105.f211224y = 0;
            ProgressFieldPropertyEditViewHolder.x(this.f211235a);
            return;
        L13:
            return;
        L9:
            ProgressFieldPropertyEditViewHolder r106 = this.f211235a;
            int r107 = r106.f211224y;
            r106.getClass();
            if (r107 != 0) goto L15;
            ProgressFieldPropertyEditViewHolder.y(this.f211235a);
            return;
        }
    }

    public static final class e implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211236a;

        public e(ProgressFieldPropertyEditViewHolder r100) {
            this.f211236a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L9;
            BitableFieldEditAnalytic r102 = this.f211236a.r().q0();
            if (r102 == null) goto L6;
            r102.c0(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, new String[0]);
        L6:
            this.f211236a.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.SET_PROGRESS_MAX, null);
            ProgressFieldPropertyEditViewHolder r103 = this.f211236a;
            int r104 = r103.f211224y;
            int r105 = r103.f211223x;
            if (r104 == r105) goto L13;
            r103.f211224y = r105;
            ProgressFieldPropertyEditViewHolder.x(r103);
            return;
        L13:
            return;
        L9:
            ProgressFieldPropertyEditViewHolder r106 = this.f211236a;
            if (r106.f211224y != r106.f211223x) goto L15;
            ProgressFieldPropertyEditViewHolder.y(r106);
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211237a;

        public f(ProgressFieldPropertyEditViewHolder r100) {
            this.f211237a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ProgressFieldPropertyEditViewHolder r101 = this.f211237a;
            int r102 = r101.f211224y;
            r101.getClass();
            if (r102 == 0) goto L6;
            ProgressFieldPropertyEditViewHolder r103 = this.f211237a;
            r103.getClass();
            r103.f211224y = 0;
            ProgressFieldPropertyEditViewHolder.x(this.f211237a);
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211238a;

        public g(ProgressFieldPropertyEditViewHolder r100) {
            this.f211238a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ProgressFieldPropertyEditViewHolder r101 = this.f211238a;
            int r102 = r101.f211224y;
            int r103 = r101.f211223x;
            if (r102 == r103) goto L6;
            r101.f211224y = r103;
            ProgressFieldPropertyEditViewHolder.x(r101);
            return;
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211239a;

        public h(ProgressFieldPropertyEditViewHolder r100) {
            this.f211239a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f211239a.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.CUSTOMIZED_PROGRESS_RANGE, null);
        }
    }

    public static final class i implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProgressFieldPropertyEditViewHolder f211240a;

        public i(ProgressFieldPropertyEditViewHolder r100) {
            this.f211240a = r100;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            ProgressFieldPropertyEditViewHolder r102 = this.f211240a;
            r102.f211214o = r101;
            if (r101 == true) goto L5;
            r102.f211215p = r102.f211220u;
            r102.f211216q = r102.f211221v;
        L5:
            BitableFieldEditAnalytic r103 = r102.r().q0();
            if (r103 == null) goto L15;
            String[] r104 = new String[1];
            Boolean r105 = Boolean.valueOf(this.f211240a.f211214o);
            if (r105 != null) goto L11;
            String r106 = "";
        L14:
            r104[0] = r106;
            r103.c0(BitableFieldEditAnalytic.ProgressFieldEditScene.CUSTOMIZED_PROGRESS, r104);
            goto L15
        L11:
            if (r105.booleanValue() == false) goto L13;
            r106 = "switch_on";
            goto L14
        L13:
            r106 = "switch_off";
        L15:
            this.f211240a.F();
        }
    }

    public final Locale B() {
        BitableFieldEditViewModel r100 = this.f211156h;
        if (r100 == null) goto L9;
        MutableLiveData<FieldEditPanelData> r101 = r100.getPanelData();
        if (r101 == null) goto L9;
        FieldEditPanelData r102 = r101.getValue();
        if (r102 == null) goto L9;
        String r103 = r102.getBaseLocale();
    L11:
        if (TextUtils.isEmpty(r103) == true) goto L20;
        if (r103 == null) goto L16;
        String r104 = StringsKt.replace$default(r103, '_', '-', false, 4, null);
        if (r104 == null) goto L16;
    L17:
        Locale r105 = Locale.forLanguageTag(r104);
        if ((!TextUtils.isEmpty(r105.getLanguage())) == false) goto L20;
    L21:
        if (r105 != null) goto L26;
        Locale r106 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).c();
        if (r106 == null) goto L25;
        return r106;
    L25:
        return Locale.getDefault();
    L26:
        return r105;
    L16:
        r104 = "";
    L20:
        r105 = null;
    L9:
        r103 = null;
        goto L11
    }

    public final void D() {
        View r100 = this.f211151c;
        ((TextView) r100.findViewById(R.id.decimalTv)).setText(z(r100.getContext(), this.f211212m));
    }

    public final void E() {
        View r100 = this.f211151c;
        FieldConfigMetaModel.CommonColor r101 = this.f211213n;
        if (r101 == null) goto L17;
        TextView r102 = (TextView) r100.findViewById(R.id.colorTv);
        FieldConfigMetaModel.CommonColor r103 = this.f211213n;
        if (r103 == null) goto L7;
        String r104 = r103.getName();
    L8:
        r102.setText(r104);
        String r105 = r101.getType();
        Locale r106 = Locale.ROOT;
        if (Intrinsics.areEqual(r105, "GRADIENT".toLowerCase(r106)) == false) goto L12;
        r100.findViewById(R.id.gradientColorPreview).setVisibility(0);
        ((GradientOffsetView) r100.findViewById(R.id.defaultColorPreview)).setVisibility(8);
        yp4.j.j(r101.getColor(), r100.findViewById(R.id.gradientColorPreview));
        return;
    L12:
        if (Intrinsics.areEqual(r105, "MULTI".toLowerCase(r106)) == false) goto L14;
    L15:
        r100.findViewById(R.id.gradientColorPreview).setVisibility(8);
        ((GradientOffsetView) r100.findViewById(R.id.defaultColorPreview)).setVisibility(0);
        yp4.j.i(r101.getColor(), (GradientOffsetView) r100.findViewById(R.id.defaultColorPreview));
        return;
    L14:
        if (Intrinsics.areEqual(r105, "PURE".toLowerCase(r106)) == true) goto L15;
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void F() {
        View r100 = this.f211151c;
        ((UDSwitch) r100.findViewById(R.id.customizedRangeChecker)).setChecked(this.f211214o);
        if (((UDSwitch) r100.findViewById(R.id.customizedRangeChecker)).isChecked() == false) goto L24;
        ((LinearLayout) r100.findViewById(R.id.rangeContainer)).setVisibility(0);
        View r101 = this.f211151c;
        Double r102 = this.f211215p;
        BigDecimal r103 = null;
        if (r102 == null) goto L7;
        BigDecimal r104 = BigDecimal.valueOf(r102.doubleValue());
    L8:
        Double r105 = this.f211216q;
        if (r105 == null) goto L11;
        r103 = BigDecimal.valueOf(r105.doubleValue());
    L11:
        if (r104 == null) goto L13;
        int r106 = r104.compareTo(r103);
    L14:
        if (r106 < 0) goto L19;
        q0.a r107 = r();
        if (r107 == null) goto L18;
        r107.d(false);
    L18:
        ((TextView) r101.findViewById(R.id.rangeErrorTip)).setVisibility(0);
    L23:
        ((EllipsizeEditText) r100.findViewById(R.id.rangeStartEdt)).setText(Editable.Factory.getInstance().newEditable(yp4.j.d(this.f211211l, this.f211212m, this.f211215p, B())));
        ((EllipsizeEditText) r100.findViewById(R.id.rangeEndEdt)).setText(Editable.Factory.getInstance().newEditable(yp4.j.d(this.f211211l, this.f211212m, this.f211216q, B())));
        return;
    L19:
        q0.a r108 = r();
        if (r108 == null) goto L22;
        r108.d(true);
    L22:
        ((TextView) r101.findViewById(R.id.rangeErrorTip)).setVisibility(8);
        goto L23
    L13:
        r106 = 0;
        goto L14
    L7:
        r104 = null;
        goto L8
    L24:
        ((LinearLayout) r100.findViewById(R.id.rangeContainer)).setVisibility(8);
        ((TextView) r100.findViewById(R.id.rangeErrorTip)).setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder, com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final void h() {
        Toast.showFailureText(this.f211149a, R.string.Bitable_Progress_TagetValueShouldGreaterThanStartValue);
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final FieldProperty p() {
        FieldProperty r100 = new FieldProperty();
        Integer r101 = this.f211211l;
        Integer r102 = this.f211212m;
        Map<String, String> r103 = yp4.j.f568713a;
        StringBuilder r104 = new StringBuilder("0");
        if (r102.intValue() <= 0) goto L5;
        r104.append(".");
    L5:
        int r105 = 0;
    L7:
        if (r105 >= r102.intValue()) goto L10;
        r104.append("0");
        r105 = r105 + 1;
        goto L7
    L10:
        if (FieldConfigMetaModel.NumberFormatType.PERCENT.getValue() != r101.intValue()) goto L12;
        r104.append(GXTemplateKey.GAIAX_PE);
    L12:
        r100.setFormatter(r104.toString());
        FieldConfigMetaModel.ProgressBean r106 = new FieldConfigMetaModel.ProgressBean();
        r106.setColor(this.f211213n);
        r100.setProgress(r106);
        r100.setRangeCustomize(Boolean.valueOf(this.f211214o));
        r100.setMin(this.f211215p);
        r100.setMax(this.f211216q);
        return r100;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void s() {
        View r100 = this.f211151c;
        ((LinearLayout) r100.findViewById(R.id.formatSelectLayout)).setOnClickListener(new a(this, r100));
        ((LinearLayout) r100.findViewById(R.id.decimalSelectLayout)).setOnClickListener(new b(this, r100));
        ((LinearLayout) r100.findViewById(R.id.colorSelectLayout)).setOnClickListener(new c(this, r100));
        ((EllipsizeEditText) r100.findViewById(R.id.rangeStartEdt)).setOnFocusChangeListener(new d(this));
        ((EllipsizeEditText) r100.findViewById(R.id.rangeEndEdt)).setOnFocusChangeListener(new e(this));
        ((EllipsizeEditText) r100.findViewById(R.id.rangeStartEdt)).setOnClickListener(new f(this));
        ((EllipsizeEditText) r100.findViewById(R.id.rangeEndEdt)).setOnClickListener(new g(this));
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void t() {
        View r100 = this.f211151c;
        LayoutInflater r101 = LayoutInflater.from(this.f211149a);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        r101.inflate(R.layout.bitable_field_edit_progress_operation_view, (ViewGroup) r100);
        BaseFieldPropertyEditViewHolder.w(false, new View[]{r100.findViewById(R.id.fieldPropertyTvLayout), r100.findViewById(R.id.fieldPropertySelector), r100.findViewById(R.id.fieldPropertyChecker)});
        ((UDSwitch) r100.findViewById(R.id.customizedRangeChecker)).setOnClickListener(new h(this));
        ((UDSwitch) r100.findViewById(R.id.customizedRangeChecker)).setOnCheckedChangeListener(new i(this));
        rcb.c.b((EditText) r100.findViewById(R.id.rangeStartEdt));
        rcb.c.b((EditText) r100.findViewById(R.id.rangeEndEdt));
    }

    public static final void x(ProgressFieldPropertyEditViewHolder r100) {
        View r101 = r100.f211151c;
        int r102 = 0;
        if (r100.f211219t != null) goto L5;
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r103 = new com.bytedance.ee.bear.bitable.card.view.cell.number.a(r100.f211149a, false);
        r100.f211219t = r103;
        r103.f207926f = new r0(r100);
        r103.f207924d = new s0(r100);
    L5:
        UDEditText r104 = (UDEditText) r101.findViewById(R.id.rangeStartEdt);
        Double r105 = r100.f211215p;
        int r106 = r100.f211224y;
        if (r106 != 0) goto L9;
        r104 = (UDEditText) r101.findViewById(R.id.rangeStartEdt);
        r105 = r100.f211215p;
    L11:
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r107 = r100.f211219t;
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == false) goto L21;
        if (r107 == null) goto L21;
        ViewParent r109 = r100.f211151c.getParent().getParent();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.ViewGroup");
        r107.d((ViewGroup) r109, r104.getText());
    L21:
        if (r105 == null) goto L23;
        String r110 = BigDecimal.valueOf(r105.doubleValue()).toPlainString();
    L24:
        String r111 = yp4.j.l(r110);
        r104.setText(Editable.Factory.getInstance().newEditable(r111));
        if (r111 == null) goto L27;
        r102 = r111.length();
    L27:
        r104.setSelection(r102);
        ((TextView) r101.findViewById(R.id.rangeErrorTip)).setVisibility(8);
        r100.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.CUSTOMIZED_PROGRESS_RANGE, null);
        return;
    L23:
        r110 = null;
        goto L24
    L14:
        if (r107.f207923c == true) goto L16;
        r108 = true;
        goto L17
    L9:
        if (r106 != r100.f211223x) goto L11;
        r104 = (UDEditText) r101.findViewById(R.id.rangeEndEdt);
        r105 = r100.f211216q;
        goto L11
    }

    public static final void y(ProgressFieldPropertyEditViewHolder r100) {
        View r101 = r100.f211151c;
        int r102 = r100.f211224y;
        if (r102 != 0) goto L9;
        Double r103 = r100.C(String.valueOf(((EllipsizeEditText) r101.findViewById(R.id.rangeStartEdt)).getText()));
        if (r103 == null) goto L7;
        r100.f211215p = Double.valueOf(r103.doubleValue());
    L7:
        ((EllipsizeEditText) r101.findViewById(R.id.rangeStartEdt)).setText(Editable.Factory.getInstance().newEditable(yp4.j.d(r100.f211211l, r100.f211212m, r100.f211215p, r100.B())));
        r100.f211224y = r100.f211222w;
        ((EllipsizeEditText) r101.findViewById(R.id.rangeStartEdt)).clearFocus();
    L14:
        r100.F();
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r104 = r100.f211219t;
        if (r104 == null) goto L18;
        r104.c(false);
        return;
    L18:
        return;
    L9:
        if (r102 != r100.f211223x) goto L14;
        Double r105 = r100.C(String.valueOf(((EllipsizeEditText) r101.findViewById(R.id.rangeEndEdt)).getText()));
        if (r105 == null) goto L13;
        r100.f211216q = Double.valueOf(r105.doubleValue());
    L13:
        ((EllipsizeEditText) r101.findViewById(R.id.rangeEndEdt)).setText(Editable.Factory.getInstance().newEditable(yp4.j.d(r100.f211211l, r100.f211212m, r100.f211216q, r100.B())));
        r100.f211224y = r100.f211222w;
        ((EllipsizeEditText) r101.findViewById(R.id.rangeEndEdt)).clearFocus();
        goto L14
    }

    public final Double C(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L15;
        return Double.valueOf(CastDoubleProtector.parseDouble(r100));
    L6:
        e = move-exception;
        if (TextUtils.equals(e.getMessage(), "multiple points") == false) goto L10;
        Toast.showFailureText(this.f211149a, R.string.Doc_Block_NotSupportMultiplePoints);
        return null;
    L10:
        Toast.showFailureText(this.f211149a, R.string.Doc_Block_OnlySupportNumber);
        return null;
    L15:
        return null;
    }

    public static String A(Context r100, Integer r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        int r102 = FieldConfigMetaModel.NumberFormatType.PERCENT.getValue();
        if (r101 != null) goto L9;
    L12:
        int r103 = FieldConfigMetaModel.NumberFormatType.NUMBER.getValue();
        if (r101 != null) goto L16;
    L19:
        return "";
    L16:
        if (r103 != r101.intValue()) goto L19;
        return r100.getString(R.string.Bitable_Progress_Number_Dropdown);
    L9:
        if (r102 != r101.intValue()) goto L12;
        return r100.getString(R.string.Bitable_Progress_Percentage_Dropdown);
    }

    public static String z(Context r100, Integer r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r101 == null) goto L11;
        r101.intValue();
        if (r101.intValue() <= 0) goto L10;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(r100.getString(R.string.Bitable_Common_MultipleDecimalPlaces), Arrays.copyOf(new Object[]{r101 + ""}, 1));
    L10:
        return r100.getString(R.string.Bitable_Progress_Integer);
    L11:
        return "";
    }

    public ProgressFieldPropertyEditViewHolder(Context r100, FieldCompositeType r101, FieldConfigMetaModel.CommonColor[] r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFieldCompositeType");
        super(r100, r101);
        this.f211210k = r102;
        this.f211211l = Integer.valueOf(FieldConfigMetaModel.NumberFormatType.PERCENT.getValue());
        this.f211212m = 0;
        this.f211217r = new ArrayList();
        this.f211218s = new LinkedHashMap();
        this.f211222w = -1;
        this.f211223x = 1;
        this.f211224y = -1;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.BaseFieldPropertyEditViewHolder
    public final void u(FieldConfigMetaModel.FieldConfigItem r110, FieldProperty r111, AllowedEditModes r112, FieldExtendInfo r113) {
        super.u(r110, r111, r112, r113);
        Double r114 = null;
        if (r111 == null) goto L5;
        String r115 = r111.getFormatter();
    L6:
        boolean r100 = false;
        if (r115 != null) goto L9;
        if (r110 == null) goto L19;
        FieldConfigMetaModel.Property r116 = r110.getProperty();
        if (r116 == null) goto L19;
        FieldConfigMetaModel.ProgressFormatConfig r117 = r116.getFormatConfig();
        if (r117 == null) goto L19;
        Integer r118 = r117.getDefaultType();
    L20:
        this.f211211l = r118;
        if (r110 == null) goto L37;
        FieldConfigMetaModel.Property r119 = r110.getProperty();
        if (r119 == null) goto L37;
        FieldConfigMetaModel.ProgressFormatConfig r120 = r119.getFormatConfig();
        if (r120 == null) goto L37;
        FieldConfigMetaModel.FormatTypeConfig[] r121 = r120.getTypes();
        if (r121 == null) goto L37;
        int r101 = r121.length;
        int r102 = 0;
    L29:
        if (r102 >= r101) goto L34;
        FieldConfigMetaModel.FormatTypeConfig r103 = r121[r102];
        if (Intrinsics.areEqual(this.f211211l, r103.getType()) == true) goto L35;
        r102 = r102 + 1;
    L35:
        if (r103 == null) goto L37;
        Integer r122 = r103.getDefaultDecimalDigits();
    L38:
        this.f211212m = r122;
    L39:
        if (r110 == null) goto L47;
        FieldConfigMetaModel.Property r123 = r110.getProperty();
        if (r123 == null) goto L47;
        FieldConfigMetaModel.RangeConfig r124 = r123.getRangeConfig();
        if (r124 == null) goto L47;
        FieldConfigMetaModel.CommonRange r125 = r124.getDefaultRange();
        if (r125 == null) goto L47;
        Double r126 = r125.getMin();
    L48:
        this.f211220u = r126;
        if (r110 == null) goto L57;
        FieldConfigMetaModel.Property r127 = r110.getProperty();
        if (r127 == null) goto L57;
        FieldConfigMetaModel.RangeConfig r128 = r127.getRangeConfig();
        if (r128 == null) goto L57;
        FieldConfigMetaModel.CommonRange r129 = r128.getDefaultRange();
        if (r129 == null) goto L57;
        Double r130 = r129.getMax();
    L58:
        this.f211221v = r130;
        if (r110 == null) goto L69;
        FieldConfigMetaModel.Property r131 = r110.getProperty();
        if (r131 == null) goto L69;
        FieldConfigMetaModel.ProgressFormatConfig r132 = r131.getFormatConfig();
        if (r132 == null) goto L69;
        FieldConfigMetaModel.FormatTypeConfig[] r133 = r132.getTypes();
        if (r133 == null) goto L69;
        int r104 = r133.length;
        int r105 = 0;
    L67:
        if (r105 >= r104) goto L69;
        FieldConfigMetaModel.FormatTypeConfig r106 = r133[r105];
        this.f211218s.put(r106.getType(), new Pair(r106.getDefaultDecimalDigits(), r106.getDecimalDigits()));
        r105 = r105 + 1;
    L69:
        if (r111 == null) goto L73;
        FieldConfigMetaModel.ProgressBean r134 = r111.getProgress();
        if (r134 == null) goto L73;
        FieldConfigMetaModel.CommonColor r135 = r134.getColor();
    L74:
        if (r110 == null) goto L95;
        FieldConfigMetaModel.Property r107 = r110.getProperty();
        if (r107 == null) goto L95;
        FieldConfigMetaModel.ProgressColorConfig r108 = r107.getColorConfig();
        if (r108 == null) goto L95;
        String[] r109 = r108.getSupportColorIds();
        if (r109 == null) goto L95;
        int r136 = r109.length;
        int r137 = 0;
    L82:
        if (r137 >= r136) goto L95;
        String r138 = r109[r137];
        FieldConfigMetaModel.CommonColor[] r139 = this.f211210k;
        if (r139 == null) goto L91;
        int r140 = r139.length;
        int r141 = 0;
    L86:
        if (r141 >= r140) goto L91;
        FieldConfigMetaModel.CommonColor r142 = r139[r141];
        if (TextUtils.equals(r142.getId(), r138) == true) goto L92;
        r141 = r141 + 1;
    L92:
        if (r142 == null) goto L94;
        this.f211217r.add(r142);
    L94:
        r137 = r137 + 1;
    L91:
        r142 = null;
    L95:
        if (r135 == null) goto L97;
        this.f211213n = r135;
    L114:
        if (r111 == null) goto L116;
        Boolean r143 = r111.getRangeCustomize();
    L117:
        if (r111 == null) goto L119;
        Double r144 = r111.getMin();
    L120:
        if (r111 == null) goto L122;
        r114 = r111.getMax();
    L122:
        if (r143 == null) goto L126;
        if (r144 == null) goto L126;
        if (r114 == null) goto L126;
        this.f211214o = r143.booleanValue();
        this.f211215p = r144;
        this.f211216q = r114;
    L157:
        View r145 = this.f211151c;
        ((EllipsizeEditText) r145.findViewById(R.id.rangeStartEdt)).addTextChangedListener(new t0(this));
        ((EllipsizeEditText) r145.findViewById(R.id.rangeEndEdt)).addTextChangedListener(new u0(this));
        View r146 = this.f211151c;
        ((TextView) r146.findViewById(R.id.formatTv)).setText(A(r146.getContext(), this.f211211l));
        D();
        E();
        F();
        return;
    L126:
        if (r110 == null) goto L134;
        FieldConfigMetaModel.Property r147 = r110.getProperty();
        if (r147 == null) goto L134;
        FieldConfigMetaModel.RangeConfig r148 = r147.getRangeConfig();
        if (r148 == null) goto L134;
        FieldConfigMetaModel.CommonRange r149 = r148.getDefaultRange();
        if (r149 == null) goto L134;
        r100 = Intrinsics.areEqual(r149.getRangeCustomize(), Boolean.TRUE);
    L134:
        this.f211214o = r100;
        if (r110 == null) goto L144;
        FieldConfigMetaModel.Property r150 = r110.getProperty();
        if (r150 == null) goto L144;
        FieldConfigMetaModel.RangeConfig r151 = r150.getRangeConfig();
        if (r151 == null) goto L144;
        FieldConfigMetaModel.CommonRange r152 = r151.getDefaultRange();
        if (r152 == null) goto L144;
        Double r153 = r152.getMin();
        if (r153 == null) goto L144;
    L145:
        this.f211215p = r153;
        if (r110 == null) goto L155;
        FieldConfigMetaModel.Property r154 = r110.getProperty();
        if (r154 == null) goto L155;
        FieldConfigMetaModel.RangeConfig r155 = r154.getRangeConfig();
        if (r155 == null) goto L155;
        FieldConfigMetaModel.CommonRange r156 = r155.getDefaultRange();
        if (r156 == null) goto L155;
        Double r157 = r156.getMax();
        if (r157 == null) goto L155;
    L156:
        this.f211216q = r157;
    L155:
        r157 = Double.valueOf(100.0d);
    L144:
        r153 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        goto L145
    L119:
        r144 = null;
        goto L120
    L116:
        r143 = null;
        goto L117
    L97:
        if (r110 == null) goto L112;
        FieldConfigMetaModel.Property r158 = r110.getProperty();
        if (r158 == null) goto L112;
        FieldConfigMetaModel.ProgressColorConfig r159 = r158.getColorConfig();
        if (r159 == null) goto L112;
        String r160 = r159.getDefaultColorId();
        if (r160 == null) goto L112;
        FieldConfigMetaModel.CommonColor[] r161 = this.f211210k;
        if (r161 == null) goto L112;
        int r162 = r161.length;
        int r163 = 0;
    L107:
        if (r163 >= r162) goto L112;
        FieldConfigMetaModel.CommonColor r164 = r161[r163];
        if (TextUtils.equals(r164.getId(), r160) == true) goto L113;
        r163 = r163 + 1;
    L113:
        this.f211213n = r164;
    L112:
        r164 = null;
    L73:
        r135 = null;
    L57:
        r130 = null;
    L47:
        r126 = null;
        goto L48
    L34:
        r103 = null;
    L37:
        r122 = null;
    L19:
        r118 = null;
        goto L20
    L9:
        if (yp4.j.k(r115) == false) goto L11;
        int r165 = FieldConfigMetaModel.NumberFormatType.PERCENT.getValue();
    L12:
        this.f211211l = Integer.valueOf(r165);
        this.f211212m = Integer.valueOf(yp4.j.h(r115));
        goto L39
    L11:
        r165 = FieldConfigMetaModel.NumberFormatType.NUMBER.getValue();
        goto L12
    L5:
        r115 = null;
        goto L6
    }
}
