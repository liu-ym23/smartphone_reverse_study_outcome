package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder;
import com.bytedance.ee.bear.bitable.card.view.cell.barcode.BarCodeCellViewHolder;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.dependency.d0;
import com.bytedance.ee.bear.lark.dependency.o0;
import com.bytedance.ee.bear.lark.dependency.p0;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import hp4.u;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 \u0093\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00012\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u0093\u0001BA\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010Q\u001a\u00020RH\u0014J\b\u0010S\u001a\u00020RH\u0014J\b\u0010T\u001a\u00020RH\u0004J\b\u0010U\u001a\u00020RH\u0016J\b\u0010V\u001a\u00020\tH\u0014J\b\u0010W\u001a\u00020\u0011H\u0014J\b\u0010X\u001a\u00020\u0011H\u0014J\b\u0010Y\u001a\u00020ZH\u0014J\u0018\u0010[\u001a\u00020\u00112\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020]H\u0014J\u0018\u0010^\u001a\u00020R2\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020]H\u0016J\b\u0010_\u001a\u00020RH\u0016J\b\u0010`\u001a\u00020RH\u0014J\b\u0010a\u001a\u00020RH\u0002J\u001a\u0010b\u001a\u00020R2\u0006\u0010c\u001a\u00020\u00112\b\b\u0002\u0010d\u001a\u00020\u0011H\u0002J\b\u0010e\u001a\u00020RH\u0002J\b\u0010f\u001a\u00020\u0011H\u0014J\b\u0010g\u001a\u00020RH\u0014J\b\u0010h\u001a\u00020RH\u0014J\b\u0010i\u001a\u00020RH\u0014J\b\u0010j\u001a\u00020\u0011H\u0016J\b\u0010k\u001a\u00020\u0011H\u0004J\b\u0010l\u001a\u00020\u0011H\u0004J\b\u0010m\u001a\u00020RH\u0002J\b\u0010n\u001a\u00020RH\u0004J\u0012\u0010o\u001a\u00020R2\b\b\u0002\u0010p\u001a\u00020\u0011H\u0014J\u001c\u0010q\u001a\u00020*2\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010u\u001a\u00020R2\u0006\u0010v\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020R2\u0006\u0010y\u001a\u00020*H\u0014J \u0010z\u001a\u00020R2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u0002082\u0006\u0010~\u001a\u000208H\u0016J\b\u0010\u007f\u001a\u00020RH\u0002J\t\u0010\u0080\u0001\u001a\u00020RH\u0002J\t\u0010\u0081\u0001\u001a\u00020RH\u0002J\u0013\u0010\u0082\u0001\u001a\u00020R2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\t\u0010\u0085\u0001\u001a\u00020RH\u0002J\u0012\u0010\u0086\u0001\u001a\u0002082\u0007\u0010\u0087\u0001\u001a\u00020&H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0089\u0001\u001a\u00020\u0011H\u0014J\t\u0010\u008a\u0001\u001a\u00020RH\u0002J\t\u0010\u008b\u0001\u001a\u00020RH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020R2\u0007\u0010\u008d\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u008e\u0001\u001a\u00020RH\u0016J\t\u0010\u008f\u0001\u001a\u00020RH\u0016J\t\u0010\u0090\u0001\u001a\u00020RH\u0002J\u0012\u0010\u0091\u0001\u001a\u00020R2\u0007\u0010\u0092\u0001\u001a\u000208H\u0002R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00107\u001a\u000208X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0002X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010P¨\u0006\u0094\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/text/TextCellViewHolder;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/BaseCellViewHolder;", "Lcom/bytedance/ee/bear/function/AtContent;", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/SegmentModel;", "Lcom/bytedance/ee/bear/span/AbsSpan$ISpanClickListener;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/ICellEditPanel;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/ClickTextListener;", "itemView", "Landroid/view/View;", "cellTitlePresenter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/title/ICellTitlePresenter;", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;", "editPanelVisibleListener", "Lcom/bytedance/ee/bear/bitable/card/view/record/IEditPanelVisibleListener;", "isPageRecord", "", "mViewModel", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/BitableCardViewModel;", "<init>", "(Landroid/view/View;Lcom/bytedance/ee/bear/bitable/card/view/cell/title/ICellTitlePresenter;Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;Lcom/bytedance/ee/bear/bitable/card/view/record/IEditPanelVisibleListener;ZLcom/bytedance/ee/bear/bitable/card/viewmodel/BitableCardViewModel;)V", "getEditPanelVisibleListener", "()Lcom/bytedance/ee/bear/bitable/card/view/record/IEditPanelVisibleListener;", "getMViewModel", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/BitableCardViewModel;", "textEditor", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor;", "getTextEditor", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor;", "textEditor$delegate", "Lkotlin/Lazy;", "editTextPresenter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditTextPresenter;", "getEditTextPresenter", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditTextPresenter;", "editTextPresenter$delegate", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mCurrentViewType", "", "getMCurrentViewType", "()Ljava/lang/String;", "mBitableAnalytic", "Lcom/bytedance/ee/bear/bitable/common/analytic/BitableAnalytic;", "getMBitableAnalytic", "()Lcom/bytedance/ee/bear/bitable/common/analytic/BitableAnalytic;", "mAllowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "getMAllowedEditModes", "()Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "setMAllowedEditModes", "(Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;)V", "mCurrentEditorUIType", "", "getMCurrentEditorUIType$annotations", "()V", "mSyncDataWhenEdit", "getMSyncDataWhenEdit", "()Lcom/bytedance/ee/bear/function/AtContent;", "setMSyncDataWhenEdit", "(Lcom/bytedance/ee/bear/function/AtContent;)V", "mCurrentAtWindowHeight", "mCustomActionMode", "Landroid/view/ActionMode;", "mTouchStartIntercept", "Lcom/bytedance/ee/bear/facade/common/TouchStartIntercept;", "scanEmptyLayout", "cellRightIconView", "Landroidx/appcompat/widget/AppCompatImageView;", "getCellRightIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "setCellRightIconView", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "mSupportAiPolish", "mSupportVoiceInput", "mAiPolishEnable", "isScreenLandscape", "Ljava/lang/Boolean;", "initHotspotClick", "", "initEditor", "init", "limitMaxVisibleLine", "getContentView", "isSupportSystemKeyboard", "isSupportSystemKeyboardToolbar", "getPermissionCheckView", "Lcom/bytedance/ee/bear/bitable/card/view/IBindPermissionChecker;", "shouldInjectMentionAbility", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/STCell;", "setData", "updateIndexFieldMode", "updateTextEditorUI", "updateAiAssistUI", "setAiPolishIcon", "enable", "isFirstAppear", "setVoiceInputIcon", "shouldForbidTextOpt", "updateEditableMode", "enterEditMode", "exitEditMode", "canEdit", "enableManualEdit", "enableScan", "injectScanAbility", "openScanPage", "syncData", "editByScan", "genTitle", "value", "", "inputValue", "onSpanClicked", "span", "Lcom/bytedance/ee/bear/span/AbsSpan;", "openLink", "url", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "addTextChangeListener", "addTextAttachStateChangeListener", "setPasteRunnable", "clickNormalArea", "widget", "Landroid/widget/TextView;", "injectMentionAbility", "getPanelHeight", PerfLog.PARAM_KEY_CONTEXT_ID, "needScrollCellToVisible", "needEmptyAddView", "createCustomMenu", "destroyCustomMenu", "onConfigurationChanged", "isLandscape", "onViewDetachedFromWindow", "onFragmentDestroy", "onAiPolishClick", "onVoiceInputClick", "cursorPosition", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TextCellViewHolder extends BaseCellViewHolder<db5.a, List<? extends SegmentModel>> implements un5.a.InterfaceC7903a, u, com.bytedance.ee.bear.bitable.card.view.cell.text.d {
    public static final /* synthetic */ int V = 0;
    public final jq4.k F;
    public final BitableCardViewModel G;
    public final Lazy H;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public AllowedEditModes f208221J;
    public int K;
    public db5.a L;
    public int M;
    public ActionMode N;
    public com.bytedance.ee.bear.bitable.card.view.cell.text.j O;
    public AppCompatImageView P;
    public AppCompatImageView Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public Boolean U;

    public static final class a {
    }

    public static final class b implements fc5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f208222a = null;

        static {
            f208222a = new b();
        }

        public b() {
        }

        @Override // fc5.d
        public final boolean a(String r100) {
            t45.c r101 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
            int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.record.fix.addbaseurl.onpaste") == false) goto L17;
            if (TextUtils.isEmpty(r100) == false) goto L7;
            return false;
        L7:
            BearUrl r103 = r101.Z(r100);
            if (com.bytedance.ee.bear.bitable.utils.b.b(r103) == true) goto L15;
            if (r103 != null) goto L11;
        L13:
            boolean r104 = false;
        L14:
            if (r104 == false) goto L17;
        L11:
            if (s45.a.d(r103.f222571l) == false) goto L13;
            r104 = true;
        L15:
            return false;
        L17:
            return r101.v6(r100);
        }
    }

    public static final class c implements BitableTextFieldEditor.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextCellViewHolder f208223a;

        public c(TextCellViewHolder r100) {
            this.f208223a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor.d
        public final void C(int r100, int r101) {
            boolean r102 = false;
            if (r100 < 0) goto L6;
            if (r100 >= r101) goto L6;
            r102 = true;
        L6:
            if (r102 == true) goto L8;
            return;
        L8:
            if (r101 < this.f208223a.W4().length()) goto L10;
            return;
        L10:
            if (this.f208223a.y4() == false) goto L17;
            TextCellViewHolder r103 = this.f208223a;
            if (r103.f207234f == true) goto L18;
            r103.b4();
            return;
        L18:
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextCellViewHolder f208224a;

        public d(TextCellViewHolder r100) {
            this.f208224a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f208224a.W4().setSelected(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextCellViewHolder f208225a;

        public e(TextCellViewHolder r100) {
            this.f208225a = r100;
        }

        @Override // com.bytedance.ee.bear.lark.dependency.p0
        public final boolean a(String r100) {
            boolean r101 = TextUtils.isEmpty(r100);
            tt5.a.h("TextCellViewHolder", "openScanPage()... return: source = 1, result is empty ? " + r101);
            if (this.f208225a.R4() == false) goto L6;
            if (r101 == true) goto L6;
            this.f208225a.W4().setRichText(r100);
            this.f208225a.g5();
            this.f208225a.e5(true);
            Toast.showText(this.f208225a.U4(), R.string.Bitable_Barcode_BarcodeInforReplaced_Toast);
        L6:
            this.f208225a.T4().C(this.f208225a.V4(), !r101, true, this.f208225a.Q4());
            return true;
        }
    }

    public static final class f implements o0 {
        public f() {
        }
    }

    public static final class g extends BitableTextFieldEditor.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f208226a;

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor.b
        public final void onRightIconClick() {
            this.f208226a.invoke();
        }

        public g(Function0<Unit> r100) {
            this.f208226a = r100;
        }
    }

    public static final class h implements BitableTextFieldEditor.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f208227a;

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor.c
        public final void a() {
            this.f208227a.invoke();
        }

        public h(Function0<Unit> r100) {
            this.f208227a = r100;
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextCellViewHolder f208228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f208229b;

        public i(TextCellViewHolder r100, boolean r101) {
            this.f208228a = r100;
            this.f208229b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            db5.a r101 = (db5.a) r100;
            SpannableStringBuilder r102 = this.f208228a.S4().f208236k;
            SpannableStringBuilder r103 = this.f208228a.S4().s();
            if (TextUtils.equals(r102, r103) == true) goto L11;
            List<SegmentModel> r104 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.a(r101);
            if (this.f208229b == false) goto L10;
            Iterator<T> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            ((SegmentModel) r105.next()).editType = "scan";
        L10:
            this.f208228a.W3(r104, r101);
            this.f208228a.S4().w(r103);
        L14:
            TextCellViewHolder r106 = this.f208228a;
            gp4.h r107 = r106.f207229a;
            if (r107 == null) goto L19;
            r107.E(r106.h4(), null);
            return;
        L19:
            return;
        L11:
            TextCellViewHolder r108 = this.f208228a;
            if (r108.L == null) goto L14;
            r108.S4().x(r108.L);
            goto L14
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j<T> f208230a = null;

        static {
            f208230a = new j();
        }

        public j() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("TextCellViewHolder", "sync text failed ", (Throwable) r100, false);
        }
    }

    public static final class k implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextCellViewHolder f208231a;

        public k(TextCellViewHolder r100) {
            this.f208231a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            TextCellViewHolder r101 = this.f208231a;
            if (Build.VERSION.SDK_INT < 23) goto L17;
            if (r101.N != null) goto L17;
            int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile_fix_text_long_press") == false) goto L14;
            Object r103 = r101.W4().getParent();
            if ((r103 instanceof View) == false) goto L11;
            View r104 = (View) r103;
        L12:
            if (r104 != null) goto L15;
            r104 = r101.W4();
        L15:
            r101.N = r104.startActionMode(new com.bytedance.ee.bear.bitable.card.view.cell.text.i(r101), 1);
            goto L17
        L11:
            r104 = null;
            goto L12
        L14:
            r104 = r101.W4();
        L17:
            if (r101.O != null) goto L19;
            com.bytedance.ee.bear.bitable.card.view.cell.text.j r105 = new com.bytedance.ee.bear.bitable.card.view.cell.text.j(r101);
            r101.O = r105;
            r101.f207229a.c(r105);
        L19:
            return true;
        }
    }

    public static final class l implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f208232a = null;

        static {
            f208232a = new l();
        }

        public l() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            return false;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final boolean A4() {
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public boolean B4() {
        return !(this instanceof BarCodeCellViewHolder);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public boolean C4() {
        return true;
    }

    @Override // hp4.u
    public boolean r2() {
        return !(this instanceof BarCodeCellViewHolder);
    }

    public final com.bytedance.ee.bear.bitable.card.view.cell.text.c S4() {
        return (com.bytedance.ee.bear.bitable.card.view.cell.text.c) this.I.getValue();
    }

    public final BitableAnalytic T4() {
        return this.f207229a.q0();
    }

    public final String V4() {
        return this.f207233e.f478254a.f464664h.f464686d;
    }

    public final BitableTextFieldEditor W4() {
        return (BitableTextFieldEditor) this.H.getValue();
    }

    public final void Z4() {
        tt5.a.h("TextCellViewHolder", "openScanPage()... currentEditorUIType = " + this.K);
        W4().setSelected(true);
        com.bytedance.ee.util.ui.j.d(new d(this), 1000);
        f r100 = new f();
        ((d0) org.koin.java.a.c(d0.class, null, null, 6)).b(U4(), new int[]{0, 1}, new e(this), r100);
        T4().F(V4(), Q4());
    }

    public boolean b5() {
        AllowedEditModes r100 = this.f208221J;
        if (r100 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100.getManual(), Boolean.FALSE);
    }

    public final void f5() {
        if (this.R == false) goto L5;
    L7:
        tt5.a.h("TextCellViewHolder", "updateAiAssistUI, isInEditMode: " + this.f207234f);
        if (this.f207234f == false) goto L20;
        T4().i();
        BitableTextFieldEditor r100 = W4();
        if (this.S == false) goto L12;
        BitableTextFieldEditor r101 = W4();
        r101.P(R.drawable.ud_icon_mic_outlined, R.color.icon_n2);
        r101.setEditorActionListener(new q(this));
    L12:
        Editable r102 = r100.getText();
        if (r102 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        a5(!r103, true);
        r100.R();
        r100.f208212h2 = 5;
        r100.O();
        r100.invalidate();
        return;
    L15:
        if (r102.length() == 0) goto L18;
        r103 = false;
        goto L19
    L20:
        BitableTextFieldEditor r104 = W4();
        r104.f208216y2 = null;
        r104.F2 = null;
        r104.setEditorActionListener(null);
        r104.f208212h2 = 5;
        r104.O();
        r104.invalidate();
        return;
    L5:
        if (this.S == true) goto L7;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void A() {
        super.A();
        Y3(W4(), W4().getText(), Q4());
    }

    public final boolean Q4() {
        if (y4() == false) goto L12;
        AllowedEditModes r100 = this.f208221J;
        if (r100 == null) goto L9;
        Boolean r101 = r100.getManual();
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();
    L10:
        if (r102 == false) goto L12;
        return true;
    L9:
        r102 = true;
    L12:
        return false;
    }

    public final boolean R4() {
        if (y4() == false) goto L11;
        AllowedEditModes r100 = this.f208221J;
        if (r100 == null) goto L7;
        boolean r101 = Intrinsics.areEqual(r100.getScan(), Boolean.TRUE);
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    L11:
        return false;
    }

    public final Context U4() {
        return W4().getContext();
    }

    public void X4() {
        BitableTextFieldEditor r100 = W4();
        com.bytedance.ee.bear.bitable.card.view.cell.text.e r101 = new com.bytedance.ee.bear.bitable.card.view.cell.text.e();
        r101.f208243a = this;
        r100.setMovementMethod(r101);
        r100.E(this, b.f208222a);
        r100.setOnPasteListener(S4());
        r100.setIPermissionCopyChecker(this);
        if (this.f207239k == false) goto L5;
        int r102 = R.color.icon_n3;
    L6:
        r100.P(R.drawable.ud_icon_scan_outlined, r102);
        String r103 = U4().getString(R.string.Bitable_Barcode_ScanBarcode_Button);
        int r104 = UDColorUtils.getColor(r100.getContext(), R.color.icon_n1);
        r100.I2 = UDIconUtils.getIconDrawable(r100.getContext(), R.drawable.ud_icon_scan_outlined, r104);
        r100.J2 = r103;
        S4().f208235j = this;
        return;
    L5:
        r102 = R.color.icon_n2;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public void Z3() {
        if (Q4() == false) goto L5;
        super.Z3();
        this.L = null;
        f5();
        KeyboardUtils.showKeyboard(W4());
        if (this.f207237i.getVisibleKeyboardHeight() <= 0) goto L24;
        jq4.k r100 = this.F;
        if (r100 == null) goto L24;
        r100.d(W4(), this);
    L24:
        if (this.f207239k == false) goto L29;
        W4().L();
        return;
    L29:
        return;
    L5:
        if (this.f207237i.getVisibleKeyboardHeight() <= 0) goto L7;
        rcb.c.d(W4());
    L7:
        AppCompatImageView r101 = this.P;
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L27;
        AppCompatImageView r103 = this.P;
        if (r103 == null) goto L28;
        r103.performClick();
        return;
    L28:
        return;
    L27:
        return;
    L10:
        if (r101.getVisibility() != 0) goto L12;
        r102 = true;
        goto L13
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void b0() {
        w4();
        W4().M(10.0f);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public void c4() {
        super.c4();
        e5(false);
        W4().D();
        Editable r100 = W4().getEditableText();
        if (r100 == null) goto L5;
        Selection.removeSelection(r100);
    L5:
        f5();
        jq4.k r101 = this.F;
        if (r101 == null) goto L9;
        r101.f(W4(), this);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, hp4.v
    public final boolean canEdit() {
        return Q4();
    }

    public void g5() {
        boolean r100 = true;
        if (R4() == false) goto L15;
        boolean r101 = TextUtils.isEmpty(S4().s());
        if (this.f207239k == false) goto L7;
        int r102 = 3;
    L9:
        if (Q4() == true) goto L12;
        if (r101 == false) goto L12;
        Integer r103 = 2;
    L13:
        W4().setEditorActionListener(new n(this));
    L20:
        if (this.f207239k == true) goto L22;
    L24:
        r100 = false;
    L25:
        BitableTextFieldEditor r104 = W4();
        int r105 = 8;
        if (r100 == false) goto L28;
        int r106 = 8;
    L29:
        r104.setVisibility(r106);
        AppCompatImageView r107 = this.P;
        if (r107 == null) goto L36;
        if (r100 == false) goto L33;
        int r108 = 0;
    L34:
        r107.setVisibility(r108);
        goto L36
    L33:
        r108 = 8;
    L36:
        if (this.K == r103.intValue()) goto L43;
        this.K = r103.intValue();
        BitableTextFieldEditor.Q(W4(), r103.intValue());
        AppCompatImageView r109 = this.Q;
        if (r109 == null) goto L43;
        if (r103.intValue() != 3) goto L42;
        r105 = 0;
    L42:
        r109.setVisibility(r105);
    L43:
        boolean r110 = b5();
        W4().setFocusableAndClickable(!r110);
        if (r110 == false) goto L46;
        W4().setCursorVisible(false);
        W4().setOnLongClickListener(new k(this));
    L47:
        W4();
        w4();
        f5();
        return;
    L46:
        W4().setOnLongClickListener(l.f208232a);
        goto L47
    L28:
        r106 = 0;
        goto L29
    L22:
        if (r103.intValue() != 2) goto L24;
    L12:
        r103 = Integer.valueOf(r102);
        goto L13
    L7:
        r102 = 1;
        goto L9
    L15:
        if (this.f207239k == false) goto L17;
        r103 = 4;
    L18:
        W4().setEditorActionListener(null);
        goto L20
    L17:
        r103 = 0;
        goto L18
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final View getContentView() {
        return W4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final gp4.g k4() {
        return W4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        S4().v();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void s4() {
        super.s4();
        W4().setOnSelectionChangedListener(new c(this));
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void u() {
        super.u();
        ActionMode r100 = this.N;
        if (r100 == null) goto L5;
        r100.finish();
    L5:
        this.N = null;
        this.f207229a.b(this.O);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void O4() {
        g5();
    }

    public void B3(un5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        J4(false);
        if ((r100 instanceof un5.e) == false) goto L6;
        Y4(((un5.e) r100).f550787e);
        return;
    L6:
        if ((r100 instanceof un5.h) == false) goto L9;
        Y4(((un5.h) r100).f550805d);
        return;
    L9:
        if ((r100 instanceof un5.l) == false) goto L16;
        gp4.h r101 = this.f207229a;
        if (r101 == null) goto L17;
        r101.l(((un5.l) r100).f550815d);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.d
    public final void F1(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if (r100.isFocusableInTouchMode() == true) goto L5;
        return;
    L5:
        if (Q4() == false) goto L9;
        rcb.c.g(r100.getContext());
        J4(true);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void M2(boolean r100) {
        super.M2(r100);
        g5();
        BitableTextFieldEditor r101 = W4();
        int r102 = W4().K();
        kn4.g r103 = r101.f239852k1;
        if (r103 == null) goto L5;
        r103.e(r102);
    L5:
        int r104 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("bitable.big.screen.impro.disable", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.big.screen.impro.disable") == true) goto L16;
        Boolean r105 = this.U;
        if (r105 == null) goto L16;
        if (Intrinsics.areEqual(r105, Boolean.valueOf(r100)) == true) goto L16;
        if (this.f207234f == false) goto L16;
        c4();
        if (this.f207237i.getVisibleKeyboardHeight() <= 0) goto L16;
        rcb.c.d(W4());
    L16:
        this.U = Boolean.valueOf(r100);
    }

    public void Y4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        gp4.h r101 = this.f207229a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.C == false) goto L7;
        r101.r(r100);
    L8:
        r101.q0().n(h4());
        return;
    L7:
        r101.h(r100);
        goto L8
    }

    public boolean d5(dp4.a<db5.a> r100) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        if (en4.a.l() == false) goto L8;
        if (en4.a.k() == true) goto L8;
        return false;
    L8:
        if (r100.f469587a.f478257d.getUiType() == EFieldUIType.BARCODE) goto L11;
        return true;
    L11:
        return false;
    }

    public void e5(boolean r100) {
        S4().r().subscribe(new i(this, r100), j.f208230a);
    }

    @Override // hp4.u
    public final int getPanelHeight(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f207234f == false) goto L5;
        int r101 = this.f207237i.getVisibleKeyboardHeight();
        int r102 = r100.getResources().getDimensionPixelSize(R.dimen.bitable_keyboard_toolbar_height);
        int r103 = com.bytedance.ee.util.ui.k.c(this.f207229a.getActivity());
        return ((this.M + r102) + r101) + r103;
    L5:
        return 0;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public void l2(dp4.a<db5.a> r100) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        super.l2(r100);
        db5.a r101 = r100.f469598l;
        if (r101 == null) goto L5;
        db5.a r102 = r101;
    L7:
        if (this.f207234f == false) goto L9;
        this.L = r102;
    L10:
        this.f208221J = r100.f469587a.f478258e;
        this.R = r100.f469602p;
        this.S = r100.f469603q;
        g5();
        Y3(W4(), W4().getText(), Q4());
        if (d5(r100) == true) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(this.f207229a.getObjToken()) == false) goto L15;
        return;
    L15:
        if (W4().getAtWindow() != null) goto L24;
        BitableTextFieldEditor r103 = W4();
        gp4.h r104 = this.f207229a;
        if (r104 == null) goto L20;
        r104.getActivity();
    L20:
        r103.N(this.f207229a.getObjToken(), this.f207229a.getType(), this.f207241m, null, null, new m(this));
        return;
    L24:
        return;
    L9:
        S4().x(r102);
        goto L10
    L5:
        r102 = new db5.a();
        goto L7
    }

    public final void a5(final boolean r100, boolean r101) {
        if (this.R == false) goto L24;
        if (r101 == false) goto L6;
    L8:
        this.T = r100;
        if (r101 == false) goto L11;
        T4().i();
    L11:
        boolean r102 = !this.S;
        Function0<Unit> r103 = new TextCellViewHolder$setAiPolishIcon$aiPolishClick$1(r100, this);
        int r104 = R.color.icon_n2;
        if (r102 == false) goto L18;
        BitableTextFieldEditor r105 = W4();
        if (r100 == true) goto L17;
        r104 = R.color.icon_disabled;
    L17:
        r105.P(R.drawable.ud_icon_effects_outlined, r104);
        r105.setEditorActionListener(new g(r103));
        return;
    L18:
        BitableTextFieldEditor r106 = W4();
        if (r100 == true) goto L22;
        r104 = R.color.icon_disabled;
    L22:
        r106.F2 = UDIconUtils.getIconDrawable(r106.getContext(), R.drawable.ud_icon_effects_outlined, UDColorUtils.getColor(r106.getContext(), r104));
        r106.setSecondaryRightIconClickListener(new h(r103));
        return;
    L6:
        if (this.T != r100) goto L8;
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final String d4(Object r100, db5.a r101) {
        StringBuilder r102 = new StringBuilder();
        if ((r100 instanceof List) == false) goto L5;
        List r103 = (List) r100;
    L6:
        if (r103 == null) goto L17;
        Iterator r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        if ((r105 instanceof SegmentModel) == false) goto L13;
        SegmentModel r106 = (SegmentModel) r105;
    L14:
        if (r106 == null) goto L9;
        r102.append(r106.text);
        goto L9
    L13:
        r106 = null;
    L17:
        return r102.toString();
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "khp");
        super.onKeyboardHeightChanged(r100, r101, r102);
        if (this.f207234f == false) goto L9;
        if (r101 <= 0) goto L9;
        jq4.k r103 = this.F;
        if (r103 == null) goto L9;
        r103.d(W4(), this);
    L9:
        if (this.f207234f == false) goto L13;
        if (r101 != 0) goto L14;
        c4();
        return;
    L14:
        return;
    }

    public /* synthetic */ TextCellViewHolder(View r100, aq4.a r101, gp4.h r110, jq4.j r111, boolean r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public TextCellViewHolder(final View r100, aq4.a r101, gp4.h r102, jq4.j r103, boolean r104, BitableCardViewModel r105) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100, r101, r102, r104);
        this.F = r103;
        this.G = r105;
        this.H = LazyKt.lazy(new TextCellViewHolder$textEditor$2(r100));
        this.I = LazyKt.lazy(new TextCellViewHolder$editTextPresenter$2(this));
        X4();
        if (this.f207239k == false) goto L16;
        AppCompatImageView r106 = (AppCompatImageView) this.itemView.findViewById(R.id.cell_content_right_icon);
        this.Q = r106;
        if (r106 == null) goto L7;
        r106.setImageResource(R.drawable.ud_icon_scan_outlined);
    L7:
        AppCompatImageView r107 = this.Q;
        if (r107 == null) goto L10;
        r107.setOnClickListener(new com.bytedance.ee.bear.bitable.card.view.cell.text.k(this));
    L10:
        AppCompatImageView r108 = this.f207248t;
        this.P = r108;
        if (r108 == null) goto L13;
        r108.setImageResource(R.drawable.ud_icon_scan_outlined);
    L13:
        AppCompatImageView r109 = this.P;
        if (r109 == null) goto L16;
        r109.setOnClickListener(new com.bytedance.ee.bear.bitable.card.view.cell.text.l(this));
    L16:
        W4().addTextChangedListener(new com.bytedance.ee.bear.bitable.card.view.cell.text.h(this));
        W4().addOnAttachStateChangeListener(new com.bytedance.ee.bear.bitable.card.view.cell.text.g(this));
        com.bytedance.ee.bear.bitable.card.view.cell.text.c r110 = W4().getPresenter();
        r110.f208239n = new p(this);
    }
}
