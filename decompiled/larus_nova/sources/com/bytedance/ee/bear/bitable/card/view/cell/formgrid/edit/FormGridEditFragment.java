package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardOperation;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardOperationModel;
import com.bytedance.ee.bear.bitable.card.view.record.CellListUtils;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.databinding.BitableFormEditLayoutBinding;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.util.ui.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0018\u0010A\u001a\u00020?2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020CH\u0016J\b\u0010H\u001a\u00020?H\u0002R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/edit/FormGridEditFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "recordLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/STRecord;", "getRecordLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setRecordLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "buttonMode", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/edit/ButtonMode;", "getButtonMode", "setButtonMode", "cardViewModel", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/BitableCardViewModel;", "getCardViewModel", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/BitableCardViewModel;", "setCardViewModel", "(Lcom/bytedance/ee/bear/bitable/card/viewmodel/BitableCardViewModel;)V", "cardDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;", "getCardDelegate", "()Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;", "setCardDelegate", "(Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableFormEditLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableFormEditLayoutBinding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableFormEditLayoutBinding;)V", "adapter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/edit/PureFormCellAdapter;", "getAdapter", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/edit/PureFormCellAdapter;", "setAdapter", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/edit/PureFormCellAdapter;)V", "dep", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/edit/FormGridEditDep;", "getDep", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/edit/FormGridEditDep;", "setDep", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/edit/FormGridEditDep;)V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "backPressHandler", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateButton", "formGridEditNotSave", "", "handleBack", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onBackPressed", "closeFragment", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormGridEditFragment extends BaseFragment implements l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f207646m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<cp4.a> f207647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.d> f207648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BitableCardViewModel f207649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gp4.h f207650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BitableFormEditLayoutBinding f207651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.e f207652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f207653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f207654l;

    public static final class a implements sa5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormGridEditFragment f207655a;

        public a(FormGridEditFragment r100) {
            this.f207655a = r100;
        }

        @Override // sa5.d
        public final boolean onBackPressed() {
            Context r100 = this.f207655a.getContext();
            if (r100 == null) goto L5;
            FormGridEditFragment.U90(this.f207655a, r100);
            return true;
        L5:
            FormGridEditFragment r101 = this.f207655a;
            int r102 = FormGridEditFragment.f207646m;
            r101.W90();
            return true;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f207656a = null;

        static {
            f207656a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormGridEditFragment f207657a;

        public c(FormGridEditFragment r100) {
            this.f207657a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            FormGridEditFragment.U90(this.f207657a, r100.getContext());
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f207658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FormGridEditFragment f207659b;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FormGridEditFragment f207660a;

            public a(FormGridEditFragment r100) {
                this.f207660a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                if (((Boolean) r100).booleanValue() == false) goto L6;
                this.f207660a.Y90().formGridAction(ECardOperation.DELETE_FORM_GRID_RECORD, this.f207660a.Z90().L2());
                return;
            }
        }

        public d(View r100, FormGridEditFragment r101) {
            this.f207658a = r100;
            this.f207659b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Context r101 = this.f207658a.getContext();
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Observable.create(new com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.b(r101)).subscribe(new a(this.f207659b));
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormGridEditFragment f207661a;

        public e(FormGridEditFragment r100) {
            this.f207661a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            cp4.a r101 = (cp4.a) r100;
            if (r101 == null) goto L6;
            this.f207661a.X90().f210766d.j(r101);
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormGridEditFragment f207662a;

        public f(FormGridEditFragment r100) {
            this.f207662a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.d r101 = (com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.d) r100;
            FormGridEditFragment r102 = this.f207662a;
            Intrinsics.checkNotNull(r101);
            Boolean r103 = this.f207662a.Y90().formGridEditNotSave().getValue();
            if (r103 == null) goto L5;
            boolean r104 = r103.booleanValue();
        L6:
            FormGridEditFragment.V90(r102, r101, r104);
            return;
        L5:
            r104 = false;
            goto L6
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormGridEditFragment f207663a;

        public g(FormGridEditFragment r100) {
            this.f207663a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            FormGridEditFragment r102 = this.f207663a;
            MutableLiveData<com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.d> r103 = r102.f207648f;
            if (r103 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("buttonMode");
            r103 = null;
        L6:
            com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.d r104 = r103.getValue();
            if (r104 != null) goto L9;
            r104 = new com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.d(0);
        L9:
            Intrinsics.checkNotNull(r101);
            FormGridEditFragment.V90(r102, r104, r101.booleanValue());
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormGridEditFragment f207664a;

        public h(FormGridEditFragment r100) {
            this.f207664a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FormGridEditFragment r100 = this.f207664a;     // Catch: Throwable -> L4
            int r101 = FormGridEditFragment.f207646m;     // Catch: Throwable -> L4
            r100.W90();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        return false;
    }

    public final void W90() {
        gp4.h r100 = this.f207650h;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cardDelegate");
        r100 = null;
    L6:
        r100.u(this.f207654l);
        MutableLiveData<cp4.a> r101 = this.f207647e;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recordLiveData");
        r101 = null;
    L10:
        cp4.a r102 = r101.getValue();
        if (r102 == null) goto L15;
        cp4.b r103 = r102.f464634a;
        if (r103 == null) goto L15;
        r103.E = null;
    L15:
        Y90().formGridEditNotSave().setValue(Boolean.FALSE);
        Y90().setFieldValidateListener(null);
        Y90().formGridEditFragmentOpen = false;
        Y90().formGridFragmentCloseCallback = null;
        Z90().onClose();
        T90(R.anim.facade_slide_right_out);
    }

    public final BitableFormEditLayoutBinding X90() {
        BitableFormEditLayoutBinding r100 = this.f207651i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final BitableCardViewModel Y90() {
        BitableCardViewModel r100 = this.f207649g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("cardViewModel");
        return null;
    }

    public final com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.e Z90() {
        com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.e r100 = this.f207652j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dep");
        return null;
    }

    public FormGridEditFragment() {
        this.f207654l = new a(this);
    }

    public static final void U90(FormGridEditFragment r100, Context r101) {
        Boolean r102 = r100.Y90().formGridEditNotSave().getValue();
        if (r102 == null) goto L5;
        boolean r103 = r102.booleanValue();
    L6:
        if (r103 == false) goto L8;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Observable.create(new com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.a(r101)).subscribe(new com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.f(r100));
        return;
    L8:
        r100.Y90().formGridAction(ECardOperation.EXIT_FORM_GRID_RECORD_EDIT, r100.Z90().L2());
        r100.W90();
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        int r112 = R.id.back_icon;
        AppCompatImageView r100 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.back_icon);
        if (r100 == null) goto L37;
        r112 = R.id.delete_icon;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.delete_icon);
        if (r101 == null) goto L37;
        r112 = R.id.form_view;
        PureFormView r102 = (PureFormView) ViewBindings.findChildViewById(r110, R.id.form_view);
        if (r102 == null) goto L37;
        r112 = R.id.left_button;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r110, R.id.left_button);
        if (r103 == null) goto L37;
        r112 = R.id.right_button;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r110, R.id.right_button);
        if (r104 == null) goto L37;
        LinearLayout r105 = (LinearLayout) r110;
        r112 = R.id.title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r110, R.id.title);
        if (r106 == null) goto L37;
        BitableFormEditLayoutBinding r113 = new BitableFormEditLayoutBinding(r105, r100, r101, r102, r103, r104, r105, r106);
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        this.f207651i = r113;
        X90().f210769g.setPadding(0, k.e(getContext()), 0, 0);
        X90().f210769g.setOnClickListener(b.f207656a);
        X90().f210764b.setOnClickListener(new c(this));
        TextView r114 = X90().f210770h;
        String r107 = this.f207653k;
        gp4.h r108 = null;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r107 = null;
    L18:
        r114.setText(r107);
        X90().f210765c.setOnClickListener(new d(r110, this));
        PureFormView r115 = X90().f210766d;
        BitableCardViewModel r116 = Y90();
        gp4.h r109 = this.f207650h;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("cardDelegate");
        r109 = null;
    L22:
        Function0<CardOperationModel.FormRecordParams> r117 = new AnonymousClass4(this);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "cardViewModel");
        Intrinsics.checkNotNullParameter(r109, "delegate");
        Intrinsics.checkNotNullParameter(r117, "getFormRecordParams");
        LayoutInflater.from(r115.getContext()).inflate(R.layout.bitable_form_layout, r115);
        r115.f208411a = (RecyclerView) r115.findViewById(R.id.form_content_recycler);
        int r118 = CellListUtils.f208639a;
        CellListUtils.a(r115.getContext(), r115.f208411a);
        r115.f208411a.addItemDecoration(new PureFormView$init$1());
        PureFormCellAdapter r119 = new PureFormCellAdapter(r116, r109, r115.f208411a, r117);
        r115.f208412b = r119;
        r119.setHasStableIds(true);
        r115.f208411a.setAdapter(r115.f208412b);
        MutableLiveData<cp4.a> r120 = this.f207647e;
        if (r120 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("recordLiveData");
        r120 = null;
    L26:
        r120.observe(this, new e(this));
        MutableLiveData<com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.d> r121 = this.f207648f;
        if (r121 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("buttonMode");
        r121 = null;
    L30:
        r121.observe(this, new f(this));
        Y90().formGridEditNotSave().observe(this, new g(this));
        Y90().formGridFragmentCloseCallback = new h(this);
        gp4.h r122 = this.f207650h;
        if (r122 == null) goto L33;
        r108 = r122;
    L34:
        r108.K(this.f207654l);
        return;
    L33:
        Intrinsics.throwUninitializedPropertyAccessException("cardDelegate");
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r112)));
    }

    public static final void V90(FormGridEditFragment r100, com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.d r101, boolean r102) {
        r100.getClass();
        if (r101.f207675a == false) goto L17;
        TextView r103 = r100.X90().f210767e;
        Intrinsics.checkNotNull(r103);
        m.z(r103, true);
        r103.setText(R.string.Bitable_Form_TableQuestion_Save_Button);
        if (r102 == false) goto L7;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        StateListDrawable r104 = new StateListDrawable();
        r104.addState(new int[]{android.R.attr.state_pressed}, AppCompatResources.getDrawable(r103.getContext(), R.drawable.bitable_form_submit_bg_press2));
        r104.addState(new int[0], AppCompatResources.getDrawable(r103.getContext(), R.drawable.bitable_form_submit_bg_enabled2));
        r103.setBackground(r104);
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), R.color.primary_fill_default));
        r103.setOnClickListener(new com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.g(r100));
    L8:
        TextView r105 = r100.X90().f210768f;
        r105.setText(R.string.Bitable_Form_TableQuestion_SaveAndContinue_Button);
        if (r102 == true) goto L11;
    L13:
        Intrinsics.checkNotNull(r105);
        com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.c.a(r105);
        if (r101.f207676b == true) goto L16;
        r105.setOnClickListener(new i(r100));
        return;
    L16:
        r105.setOnClickListener(null);
        return;
    L11:
        if (r101.f207676b == false) goto L13;
        Intrinsics.checkNotNull(r105);
        com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.c.b(r105);
        r105.setOnClickListener(new com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.h(r100));
        return;
    L7:
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.setBackground(AppCompatResources.getDrawable(r103.getContext(), R.drawable.bitable_form_submit_bg_disabled2));
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), R.color.fill_disable));
        r103.setOnClickListener(null);
        goto L8
    L17:
        m.z(r100.X90().f210767e, false);
        TextView r106 = r100.X90().f210768f;
        r106.setText(R.string.Bitable_Form_TableQuestion_Save_Button);
        if (r102 == false) goto L20;
        Intrinsics.checkNotNull(r106);
        com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.c.b(r106);
        r106.setOnClickListener(new j(r100));
        return;
    L20:
        Intrinsics.checkNotNull(r106);
        com.bytedance.ee.bear.bitable.card.view.cell.formgrid.edit.c.a(r106);
        r106.setOnClickListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_form_edit_layout, r101, false);
    }
}
