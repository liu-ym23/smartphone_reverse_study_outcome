package com.bytedance.ee.bear.bitable.card.view.cell.url;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder;
import com.bytedance.ee.bear.bitable.card.view.cell.ECellEditMenuItem;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableSpaceEditText;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.utils.AtUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sa5.w;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 r2\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00012\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0001rB5\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\nH\u0014J\b\u00107\u001a\u000208H\u0014J\u001a\u00109\u001a\u0002052\u0010\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010;H\u0016J\b\u0010<\u001a\u000205H\u0014J\b\u0010=\u001a\u000205H\u0002J\b\u0010>\u001a\u000205H\u0014J\b\u0010?\u001a\u000205H\u0014J\b\u0010@\u001a\u000205H\u0014J\b\u0010A\u001a\u000205H\u0002J\b\u0010B\u001a\u000205H\u0002J\u001c\u0010C\u001a\u00020.2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010G\u001a\u000205H\u0002J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020IH\u0002J\u0010\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0002H\u0002J\b\u0010L\u001a\u00020\u0012H\u0014J\b\u0010M\u001a\u00020\u0012H\u0014J\b\u0010N\u001a\u000205H\u0002J\b\u0010O\u001a\u000205H\u0002J\b\u0010P\u001a\u000205H\u0002J\u0010\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020.H\u0002J\u0010\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u0003H\u0014J\u0010\u0010X\u001a\u0002052\u0006\u0010Y\u001a\u00020WH\u0016J\b\u0010Z\u001a\u000205H\u0002J\b\u0010[\u001a\u00020\u0012H\u0014J\u0018\u0010\\\u001a\u0002052\u0006\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020%H\u0016J\u0010\u0010_\u001a\u0002052\u0006\u0010U\u001a\u00020.H\u0002J\u0012\u0010`\u001a\u00020%2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020\u0012H\u0016J \u0010d\u001a\u0002052\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020%2\u0006\u0010h\u001a\u00020%H\u0016J\u0012\u0010i\u001a\u00020\u00122\b\u0010j\u001a\u0004\u0018\u00010kH\u0016J\u0012\u0010l\u001a\u0002052\b\u0010m\u001a\u0004\u0018\u00010nH\u0002J\b\u0010o\u001a\u000205H\u0002J\b\u0010p\u001a\u000205H\u0016J\b\u0010q\u001a\u000205H\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/url/UrlCellViewHolder;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/BaseCellViewHolder;", "Lcom/bytedance/ee/bear/function/AtContent;", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/SegmentModel;", "Lcom/bytedance/ee/bear/span/AbsSpan$ISpanClickListener;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/ICellEditPanel;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor$OnSelectionChangedListener;", "Lcom/bytedance/ee/bear/facade/common/TouchStartIntercept;", "itemView", "Landroid/view/View;", "cellTitlePresenter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/title/ICellTitlePresenter;", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;", "editPanelVisibleListener", "Lcom/bytedance/ee/bear/bitable/card/view/record/IEditPanelVisibleListener;", "isPageRecord", "", "<init>", "(Landroid/view/View;Lcom/bytedance/ee/bear/bitable/card/view/cell/title/ICellTitlePresenter;Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;Lcom/bytedance/ee/bear/bitable/card/view/record/IEditPanelVisibleListener;Z)V", "getEditPanelVisibleListener", "()Lcom/bytedance/ee/bear/bitable/card/view/record/IEditPanelVisibleListener;", "mUrlEditText", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor;", "getMUrlEditText", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableTextFieldEditor;", "mUrlEditText$delegate", "Lkotlin/Lazy;", "mUrlEditTextPresenter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/url/UrlEditTextPresenter;", "getMUrlEditTextPresenter", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/url/UrlEditTextPresenter;", "mUrlEditTextPresenter$delegate", "cellRightIconView", "Landroidx/appcompat/widget/AppCompatImageView;", "mCurrentEditMode", "", "mUrlEditPanel", "Lcom/bytedance/ee/bear/bitable/card/view/cell/url/UrlEditPanel;", "mIsFocusGrabbedByUrlEditPanel", "mCurrentAtWindowHeight", "mCustomClickActionMode", "Landroid/view/ActionMode;", "mIsExitUnconsumedSpanClickEvent", "mUnconsumedSpanClickUrl", "", "mAtWindowConfig", "Lcom/bytedance/ee/bear/at/AtWindowConfig;", "enterEditByClickMenu", "mUrlEditPanelV2", "Lcom/bytedance/ee/bear/bitable/card/view/cell/url/UrlEditPanelV2;", "limitMaxVisibleLine", "", "getContentView", "getPermissionCheckView", "Lcom/bytedance/ee/bear/bitable/card/view/IBindPermissionChecker;", "setData", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/STCell;", "enterEditModeWhenFocused", "onUrlIconClick", "enterEditMode", "exitEditMode", "updateEditableMode", "showUrlEditPanelV2", "showUrlEditPanel", "genTitle", "value", "", "inputValue", "syncDirectInputValue", "getCurrentUrlContent", "Lio/reactivex/Single;", "decorateUrlContent", "urlContent", "isSupportSystemKeyboard", "isSupportSystemKeyboardToolbar", "tryOpenAtDocFinder", "supportAtDocFinder", "forbidAtDocFinder", "onSpanClicked", "span", "Lcom/bytedance/ee/bear/span/AbsSpan;", "handleSpanClickEvent", "url", "getEditMenuItemList", "Lcom/bytedance/ee/bear/bitable/card/view/cell/ECellEditMenuItem;", "onCellEditItemClick", "cellEditMenuItem", "openUrlByClickMenu", "needEmptyAddView", "onSelectionChanged", "start", "end", RuleConditionBean.OPEN_URL_KEY, "getPanelHeight", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "needScrollCellToVisible", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "onTouchStartIntercept", "downEvent", "Landroid/view/MotionEvent;", "textChange", "text", "Landroid/text/Editable;", "destroyActionModeIfNeed", "onViewDetachedFromWindow", "onFragmentDestroy", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlCellViewHolder extends BaseCellViewHolder<db5.a, List<? extends SegmentModel>> implements un5.a.InterfaceC7903a, hp4.u, BitableTextFieldEditor.d, w {
    public static final /* synthetic */ int S = 0;
    public final jq4.k F;
    public final Lazy G;
    public final Lazy H;
    public final AppCompatImageView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f208291J;
    public n K;
    public boolean L;
    public int M;
    public ActionMode N;
    public boolean O;
    public String P;
    public boolean Q;
    public p R;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f208292a = null;

        static {
            int[] r100 = new int[ECellEditMenuItem.values().length];
            r100[ECellEditMenuItem.OPEN_URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ECellEditMenuItem.EDIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f208292a = r100;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UrlCellViewHolder f208293a;

        public c(UrlCellViewHolder r100) {
            this.f208293a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            db5.a r111 = (db5.a) r110;
            Intrinsics.checkNotNullParameter(r111, "it");
            UrlCellViewHolder r100 = this.f208293a;
            int r101 = UrlCellViewHolder.S;
            r100.getClass();
            int r102 = r111.f467804a.length();
            String r103 = StringsKt.trim(r111.f467804a).toString();
            r111.f467804a = r103;
            bo4.a[] r104 = r111.f467805b;
            if (r104.length != 0) goto L5;
            boolean r105 = true;
        L7:
            if ((!r105) == true) goto L9;
        L15:
            boolean r106 = false;
        L16:
            if (r106 == true) goto L18;
            r111.f467804a = r103;
            r111.f467805b = new bo4.a[0];
            if (r103.length() <= 0) goto L27;
            boolean r107 = true;
        L28:
            if (r107 == false) goto L57;
            bo4.a[] r108 = r111.f467805b;
            int r109 = r108.length;
            int r112 = 0;
        L30:
            String r113 = null;
            if (r112 >= r109) goto L39;
            bo4.a r114 = r108[r112];
            if (r114.f19811a != 0) goto L35;
            boolean r115 = true;
        L36:
            if (r115 == true) goto L40;
            r112 = r112 + 1;
        L40:
            db5.j[] r116 = r111.f467806c;
            int r117 = r116.length;
            int r118 = 0;
        L41:
            if (r118 >= r117) goto L49;
            db5.j r119 = r116[r118];
            if (r119.f467826a != 0) goto L45;
            boolean r120 = true;
        L46:
            if (r120 == true) goto L50;
            r118 = r118 + 1;
        L50:
            if (r114 == null) goto L52;
            r113 = r114.f19816f;
        L56:
            r111.f467806c = new r[]{new r(0, r103.length(), r103, r113)};
        L58:
            return r111;
        L52:
            if (r119 == null) goto L56;
            if ((r119 instanceof r) == false) goto L56;
            r113 = ((r) r119).f208348e;
            goto L56
        L45:
            r120 = false;
            goto L46
        L49:
            r119 = null;
            goto L50
        L35:
            r115 = false;
            goto L36
        L39:
            r114 = null;
            goto L40
        L57:
            r111.f467806c = new db5.j[0];
            goto L58
        L27:
            r107 = false;
            goto L28
        L18:
            if (r111.f467806c.length != 0) goto L20;
            boolean r121 = true;
        L22:
            if ((!r121) == false) goto L58;
            r111.f467806c = new db5.j[0];
            goto L58
        L20:
            r121 = false;
            goto L22
        L9:
            if (r104.length != 1) goto L15;
            bo4.a r122 = r104[0];
            if (r122.f19811a != 0) goto L15;
            if (r122.f19812b != r102) goto L15;
            r106 = true;
            goto L16
        L5:
            r105 = false;
            goto L7
        }
    }

    public static final class d extends ActionMode.Callback2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UrlCellViewHolder f208294a;

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            return false;
        }

        public d(UrlCellViewHolder r100) {
            this.f208294a = r100;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            UrlCellViewHolder r102 = this.f208294a;
            int r103 = UrlCellViewHolder.S;
            r102.Q4();
            if (TextUtils.isEmpty(this.f208294a.P) == true) goto L10;
            UrlCellViewHolder r104 = this.f208294a;
            String r105 = r104.P;
            if (r105 == null) goto L7;
            r104.W4(r105);
        L7:
            UrlCellViewHolder r106 = this.f208294a;
            r106.P = null;
            r106.c4();
            rcb.c.d(this.f208294a.S4());
            return false;
        L10:
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            if (r101 == null) goto L4;
            r101.clear();
        L4:
            if (r101 == null) goto L8;
            r101.add(769711401, 0, 0, this.f208294a.S4().getResources().getString(R.string.Bitable_Form_OpenLinkMobileVer));
            return true;
        L8:
            return true;
        }

        @Override // android.view.ActionMode.Callback2
        public final void onGetContentRect(ActionMode r100, View r101, Rect r102) {
            UrlCellViewHolder r103 = this.f208294a;
            int r104 = UrlCellViewHolder.S;
            int r105 = r103.S4().getSelectionStart();
            Layout r106 = this.f208294a.S4().getLayout();
            if (r106 != null) goto L5;
            return;
        L5:
            Rect r107 = new Rect();
            r106.getLineBounds(r106.getLineForOffset(r105), r107);
            int r108 = r107.top + this.f208294a.S4().getPaddingTop();
            int r109 = r107.bottom + this.f208294a.S4().getPaddingTop();
            float r110 = r106.getPrimaryHorizontal(r105) + this.f208294a.S4().getPaddingStart();
            if (r102 == null) goto L9;
            int r111 = (int) r110;
            r102.set(r111, r108, r111, r109);
            return;
        }
    }

    public static final class e implements n.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UrlCellViewHolder f208295a;

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.url.n.c
        public final void onDismiss() {
            this.f208295a.S4().setSelected(false);
            UrlCellViewHolder r100 = this.f208295a;
            if (r100.f208291J != 2) goto L6;
            r100.c4();
            return;
        }

        public e(UrlCellViewHolder r100) {
            this.f208295a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.url.n.c
        public final void a(db5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            UrlCellViewHolder r101 = this.f208295a;
            List<SegmentModel> r102 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.a(r100);
            int r103 = UrlCellViewHolder.S;
            r101.W3(r102, r100);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UrlCellViewHolder f208296a;

        public f(UrlCellViewHolder r100) {
            this.f208296a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            db5.a r100 = (db5.a) r110;
            bo4.a[] r101 = r100.f467805b;
            int r102 = 0;
            if (r101.length != 0) goto L5;
            boolean r103 = true;
        L7:
            if ((!r103) == false) goto L9;
            String r104 = r101[0].f19816f;
        L22:
            n r105 = this.f208296a.K;
            if (r105 == null) goto L48;
            String r106 = r100.f467804a;
            if (r105.f208317g == true) goto L48;
            r105.f208317g = true;
            r105.f208315e = r106;
            r105.f208316f = r104;
            View r107 = r105.f208312b;
            if (r107 == null) goto L36;
            r107.clearAnimation();
            ViewGroup r108 = r105.f208311a;
            if (r108 == null) goto L32;
            r108.removeView(r107);
        L32:
            ViewGroup r109 = r105.f208311a;
            if (r109 == null) goto L35;
            FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-1, -2);
            r111.gravity = 80;
            Unit r112 = Unit.INSTANCE;
            r109.addView(r107, r111);
        L35:
            r107.setVisibility(0);
            TranslateAnimation r113 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            r113.setDuration(200);
            r107.startAnimation(r113);
        L36:
            BitableAtEditText r114 = r105.f208314d;
            if (r114 == null) goto L39;
            r114.setText(r105.f208316f);
        L39:
            BitableAtEditText r115 = r105.f208314d;
            if (r115 == null) goto L42;
            r115.setCopySecurityEnable(false);
        L42:
            BitableSpaceEditText r116 = r105.f208313c;
            if (r116 == null) goto L48;
            r116.setText(r105.f208315e);
            String r117 = r105.f208315e;
            if (r117 == null) goto L47;
            r102 = r117.length();
        L47:
            r116.setSelection(r102);
            r116.post(new o(r116));
        L48:
            this.f208296a.S4().setSelected(true);
            return;
        L9:
            db5.j[] r118 = r100.f467806c;
            if (r118.length != 0) goto L12;
            boolean r119 = true;
        L14:
            if ((!r119) == false) goto L21;
            db5.j r120 = r118[0];
            if ((r120 instanceof r) == false) goto L20;
            r r121 = (r) r120;
            if (TextUtils.isEmpty(r121.f208348e) == true) goto L20;
            r104 = r121.f208348e;
        L20:
            r104 = r120.f467829d;
            goto L22
        L21:
            r104 = "";
            goto L22
        L12:
            r119 = false;
            goto L14
        L5:
            r103 = false;
            goto L7
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f208297a = null;

        static {
            f208297a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("UrlCellViewHolder", "parse url content failed", (Throwable) r100, false);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void b4() {
        this.f208291J = 1;
        super.b4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final List<ECellEditMenuItem> f4() {
        return CollectionsKt.listOf(new ECellEditMenuItem[]{ECellEditMenuItem.OPEN_URL, ECellEditMenuItem.EDIT});
    }

    @Override // hp4.u
    public final boolean r2() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final boolean A4() {
        return !this.C;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final boolean B4() {
        if (this.C == false) goto L6;
        return false;
    L6:
        if (this.f208291J != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final void Q4() {
        ActionMode r100 = this.N;
        if (r100 == null) goto L5;
        r100.finish();
    L5:
        this.N = null;
    }

    public final BitableTextFieldEditor S4() {
        return (BitableTextFieldEditor) this.G.getValue();
    }

    public final q T4() {
        return (q) this.H.getValue();
    }

    public final void V4() {
        if (this.C == false) goto L9;
        this.f208291J = 2;
        if (this.R != null) goto L7;
        p r100 = new p(S4().getContext(), this);
        r100.f486402f = new com.bytedance.ee.bear.bitable.card.view.cell.url.g(this);
        r100.f486401e = new h(this);
        this.R = r100;
    L7:
        R4().subscribe(new i(this), j.f208307a);
        return;
    L9:
        boolean r101 = this.f207234f;
        if (r101 == true) goto L12;
    L16:
        if (r101 == true) goto L21;
        this.f208291J = 2;
        Z3();
        X4();
        return;
    L21:
        return;
    L12:
        if (this.f208291J != 1) goto L16;
        this.f208291J = 2;
        this.L = true;
        J4(false);
        X4();
        jq4.k r102 = this.F;
        if (r102 == null) goto L19;
        r102.d(S4(), this);
        return;
    }

    public final void X4() {
        if (this.K == null) goto L5;
    L14:
        R4().subscribe(new f(this), g.f208297a);
        return;
    L5:
        if ((this.f207229a.v() instanceof ViewGroup) == false) goto L14;
        View r100 = this.f207229a.v();
        if (this.f207238j == true) goto L9;
    L13:
        Context r101 = S4().getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup");
        n r102 = new n(r101, (ViewGroup) r100, this);
        r102.f208318h = new e(this);
        this.K = r102;
        goto L14
    L9:
        if (this.f207229a.i() == null) goto L13;
        if ((this.f207229a.i() instanceof ViewGroup) == false) goto L13;
        r100 = this.f207229a.i();
        goto L13
    }

    public final void Y4() {
        if (this.C == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(S4().getText()) == true) goto L20;
        Editable r100 = S4().getText();
        if (r100 != null) goto L10;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L20;
        BitableTextFieldEditor r102 = S4();
        kn4.g r103 = r102.f239852k1;
        if (r103 == null) goto L18;
        r103.close();
    L18:
        r102.f239852k1 = null;
        return;
    L10:
        if (StringsKt.lastIndexOf$default(r100, '@', 0, false, 6, null) != 0) goto L12;
        r101 = true;
    L20:
        if (TextUtils.isEmpty(this.f207229a.getObjToken()) == false) goto L22;
        return;
    L22:
        if (S4().getAtWindow() != null) goto L28;
        BitableTextFieldEditor r104 = S4();
        this.f207229a.getActivity();
        r104.N(this.f207229a.getObjToken(), this.f207229a.getType(), this.f207241m, null, AtUtils.c(), new k(this));
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void c4() {
        if (this.f207234f == true) goto L5;
        return;
    L5:
        boolean r100 = false;
        if (this.C == true) goto L8;
    L13:
        int r101 = this.f208291J;
        if (r101 != 2) goto L20;
        if (this.L == false) goto L20;
        this.L = false;
        R4().subscribe(new l(this), m.f208310a);
        return;
    L20:
        if (r101 != 1) goto L22;
        R4().subscribe(new l(this), m.f208310a);
    L31:
        this.f208291J = 3;
        super.c4();
        jq4.k r102 = this.F;
        if (r102 == null) goto L34;
        r102.f(S4(), this);
    L34:
        S4().D();
        Q4();
        return;
    L22:
        if (r101 != 2) goto L31;
        n r103 = this.K;
        if (r103 != null) goto L26;
    L28:
        if (r100 == false) goto L31;
        if (r103 == null) goto L31;
        r103.a();
        goto L31
    L26:
        if (r103.f208317g != true) goto L28;
        r100 = true;
        goto L28
    L8:
        if (this.f208291J != 2) goto L13;
        if (this.Q == false) goto L13;
        this.Q = false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void A() {
        super.A();
        if (this.f207239k == false) goto L20;
        int r100 = 4;
        int r101 = 0;
        if (this.C == false) goto L10;
        AppCompatImageView r102 = this.I;
        if (r102 == null) goto L9;
        r102.setVisibility(8);
    L9:
        BitableTextFieldEditor.Q(S4(), 4);
        S4().setFocusable(false);
        S4().setFocusableInTouchMode(false);
        return;
    L10:
        Y3(S4(), S4().getText(), this.f207235g.f486413e);
        boolean r103 = this.f207235g.f486413e;
        if (r103 == false) goto L13;
        r100 = 3;
    L13:
        AppCompatImageView r104 = this.I;
        if (r104 == null) goto L19;
        if (r103 == true) goto L18;
        r101 = 8;
    L18:
        r104.setVisibility(r101);
    L19:
        BitableTextFieldEditor.Q(S4(), r100);
        return;
    L20:
        boolean r105 = this.f207235g.f486413e;
        BitableTextFieldEditor.Q(S4(), r105 ? 1 : 0);
    }

    public final Single<db5.a> R4() {
        return T4().r().map(new c(this));
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void Z3() {
        super.Z3();
        if (this.C == false) goto L7;
        V4();
        return;
    L7:
        if (this.f207239k == true) goto L9;
    L11:
        boolean r100 = true;
        if (this.f208291J != 1) goto L23;
        Y4();
        n r101 = this.K;
        if (r101 != null) goto L16;
    L18:
        r100 = false;
    L19:
        if (r100 == false) goto L23;
        if (r101 == null) goto L23;
        r101.a();
        goto L23
    L16:
        if (r101.f208317g != true) goto L18;
    L23:
        if (this.f207237i.getVisibleKeyboardHeight() <= 0) goto L28;
        jq4.k r102 = this.F;
        if (r102 == null) goto L29;
        r102.d(S4(), this);
        return;
    L29:
        return;
    L28:
        return;
    L9:
        if (S4().hasFocus() == true) goto L11;
        S4().requestFocus();
        rcb.c.h(S4(), null);
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void b0() {
        S4().M(10.0f);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final View getContentView() {
        return S4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final gp4.g k4() {
        return S4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        T4().v();
        if (this.f207234f == false) goto L6;
        c4();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void u() {
        super.u();
        gp4.h r100 = this.f207229a;
        if (r100 == null) goto L5;
        r100.b(this);
    L5:
        Q4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final boolean C4() {
        return this.C;
    }

    @Override // un5.a.InterfaceC7903a
    public final void B3(un5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        if (this.C == false) goto L8;
        if (this.f207235g.f486413e == false) goto L8;
        return;
    L8:
        if ((r100 instanceof un5.e) == false) goto L11;
        U4(((un5.e) r100).f550787e);
        return;
    L11:
        if ((r100 instanceof un5.h) == false) goto L15;
        U4(((un5.h) r100).f550805d);
        return;
    }

    public final void U4(String r100) {
        if (this.C == false) goto L9;
        if (y4() == true) goto L15;
        W4(r100);
        return;
    L15:
        return;
    L9:
        if (this.f207234f == true) goto L11;
    L13:
        W4(r100);
        return;
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        this.O = true;
        this.P = r100;
    }

    public final void W4(String r100) {
        if (this.C == false) goto L7;
        gp4.h r101 = this.f207229a;
        if (r101 == null) goto L10;
        r101.r(r100);
    L10:
        gp4.h r102 = this.f207229a;
        if (r102 == null) goto L16;
        BitableAnalytic r103 = r102.q0();
        if (r103 == null) goto L17;
        r103.n(h4());
        return;
    L17:
        return;
    L16:
        return;
    L7:
        gp4.h r104 = this.f207229a;
        if (r104 == null) goto L10;
        r104.h(r100);
        goto L10
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.a.InterfaceC2991a
    public final void g3(ECellEditMenuItem r100) {
        Intrinsics.checkNotNullParameter(r100, "cellEditMenuItem");
        super.g3(r100);
        int r101 = b.f208292a[r100.ordinal()];
        if (r101 != 1) goto L5;
        R4().subscribe(new com.bytedance.ee.bear.bitable.card.view.cell.url.e(this), com.bytedance.ee.bear.bitable.card.view.cell.url.f.f208303a);
        return;
    L5:
        if (r101 != 2) goto L11;
        this.Q = true;
        Z3();
        return;
    }

    @Override // hp4.u
    public final int getPanelHeight(Context r100) {
        if (this.f207234f == false) goto L20;
        int r101 = this.f207237i.getVisibleKeyboardHeight();
        int r102 = com.bytedance.ee.util.ui.k.c(this.f207229a.getActivity());
        int r103 = S4().getResources().getDimensionPixelSize(R.dimen.bitable_keyboard_toolbar_height);
        n r104 = this.K;
        if (r104 != null) goto L7;
    L11:
        int r105 = 0;
    L12:
        int r106 = this.f208291J;
        if (r106 != 1) goto L15;
        int r107 = this.M;
        return r107 + ((r101 + r102) + r103);
    L15:
        if (r106 == 2) goto L21;
        return 0;
    L21:
        return r102 + r105;
    L7:
        if (r104.f208317g == false) goto L11;
        View r108 = r104.f208312b;
        if (r108 == null) goto L11;
        r105 = r108.getHeight();
        goto L12
    L20:
        return 0;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void l2(dp4.a<db5.a> r100) {
        super.l2(r100);
        if (this.f207234f == true) goto L11;
        q r101 = T4();
        if (r100 == null) goto L8;
        db5.a r102 = r100.f469598l;
        if (r102 == null) goto L8;
    L9:
        r101.x(r102);
        return;
    L8:
        r102 = new db5.a();
        goto L9
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r100) {
        Q4();
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor.d
    public final void C(int r100, int r101) {
        if (r100 < 0) goto L7;
        if (r101 < 0) goto L7;
        if (r100 != r101) goto L7;
        boolean r102 = true;
    L9:
        if (this.C == false) goto L11;
        return;
    L11:
        if (r102 == true) goto L13;
    L17:
        if (r100 != r101) goto L25;
        if (r100 < 0) goto L26;
        ActionMode r103 = this.N;
        if (r103 == null) goto L27;
        if (r103 == null) goto L28;
        r103.invalidate();
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L13:
        if (this.O == false) goto L17;
        if (Build.VERSION.SDK_INT < 23) goto L17;
        this.O = false;
        this.N = S4().startActionMode(new d(this), 1);
        return;
    L7:
        r102 = false;
        goto L9
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
        r103.d(S4(), this);
    L9:
        if (this.f207234f == false) goto L13;
        if (r101 != 0) goto L14;
        c4();
        return;
    L14:
        return;
    }

    public UrlCellViewHolder(final View r100, aq4.a r101, gp4.h r102, jq4.j r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100, r101, r102, r104);
        this.F = r103;
        this.G = LazyKt.lazy(new UrlCellViewHolder$mUrlEditText$2(r100));
        this.H = LazyKt.lazy(new UrlCellViewHolder$mUrlEditTextPresenter$2(this));
        this.f208291J = 3;
        BitableTextFieldEditor r105 = S4();
        q r106 = T4();
        r106.f208235j = this;
        r105.setPresenter(r106);
        r105.setMovementMethod(new com.bytedance.ee.bear.bitable.card.view.cell.text.e());
        r105.addTextChangedListener(new com.bytedance.ee.bear.bitable.card.view.cell.url.c(this));
        r105.addTextChangedListener(new com.bytedance.ee.bear.bitable.card.view.cell.url.d(this));
        r105.setOnPasteListener(T4());
        r105.setOnSelectionChangedListener(this);
        r105.setIPermissionCopyChecker(this);
        r105.P(R.drawable.ud_icon_link_copy_outlined, R.color.icon_n2);
        r105.setEditorActionListener(new com.bytedance.ee.bear.bitable.card.view.cell.url.a(this));
        if (r104 == false) goto L12;
        AppCompatImageView r107 = (AppCompatImageView) r100.findViewById(R.id.cell_content_right_icon);
        this.I = r107;
        if (r107 == null) goto L7;
        r107.setImageResource(R.drawable.ud_icon_link_copy_outlined);
    L7:
        if (r107 == null) goto L10;
        r107.setOnClickListener(new com.bytedance.ee.bear.bitable.card.view.cell.url.b(this));
    L10:
        if (this.C == false) goto L12;
        S4().setHint("");
        S4().setFocusable(false);
        S4().setFocusableInTouchMode(false);
        this.f207248t.setImageResource(R.drawable.ud_icon_add_outlined);
        rcb.c.b(S4());
    L12:
        if (r102 == null) goto L15;
        r102.c(this);
        return;
    }
}
