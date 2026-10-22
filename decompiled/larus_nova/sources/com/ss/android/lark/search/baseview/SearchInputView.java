package com.ss.android.lark.search.baseview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.utils.ExternalKeyboardUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.q0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.autofocus.AutoFocusEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000×\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u00011\u0018\u0000 z2\u00020\u0001:\nz{|}~\u007f\u0080\u0001\u0081\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u00103\u001a\u000204H\u0002J\u000e\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0014J\u000e\u00107\u001a\u0002042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010:\u001a\u0002042\u0006\u0010;\u001a\u000209J\u000e\u0010>\u001a\u0002042\u0006\u0010?\u001a\u00020=J\u000e\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020\u001eJ\u000e\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020 J\b\u0010D\u001a\u000204H\u0016J\u0006\u0010E\u001a\u000204J\u0010\u0010F\u001a\u0002042\b\b\u0002\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u000204J\u0006\u0010J\u001a\u00020\"J\u000e\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020\"J\u000e\u0010M\u001a\u0002042\u0006\u0010L\u001a\u00020\"J\u0006\u0010N\u001a\u000204J\u0006\u0010O\u001a\u000204J\u000e\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020RJ\u0010\u0010S\u001a\u0002042\b\b\u0001\u0010T\u001a\u00020RJ\u000e\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020\"J*\u0010U\u001a\u0002042\"\u0010V\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010X\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010Y\u0012\u0004\u0012\u00020H0WJ\"\u0010Z\u001a\u0002042\b\b\u0001\u0010[\u001a\u00020R2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020RJ\u0010\u0010_\u001a\u0002042\b\b\u0001\u0010`\u001a\u00020aJ\u0010\u0010b\u001a\u0002042\b\b\u0001\u0010c\u001a\u00020RJ\u000e\u0010d\u001a\u0002042\u0006\u0010e\u001a\u00020aJ\u0010\u0010f\u001a\u0002042\b\b\u0001\u0010c\u001a\u00020RJ\u0010\u0010g\u001a\u0002042\b\b\u0001\u0010h\u001a\u00020RJ\u0010\u0010i\u001a\u0002042\b\b\u0001\u0010j\u001a\u00020RJ\u001c\u0010k\u001a\u0002042\b\u0010l\u001a\u0004\u0018\u00010]2\b\b\u0001\u0010`\u001a\u00020aH\u0002J\u001c\u0010m\u001a\u0002042\b\u0010l\u001a\u0004\u0018\u00010]2\b\b\u0001\u0010c\u001a\u00020RH\u0002J\u0006\u0010n\u001a\u000204J\u000e\u0010o\u001a\u0002042\u0006\u0010p\u001a\u00020qJ\u0006\u0010r\u001a\u000204J\u000e\u0010s\u001a\u0002042\u0006\u0010t\u001a\u00020%J\u000e\u0010u\u001a\u0002042\u0006\u0010t\u001a\u00020%J\u0006\u0010v\u001a\u00020wJ\u000e\u0010x\u001a\u0002042\u0006\u0010y\u001a\u00020HR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lcom/ss/android/lark/search/baseview/SearchInputView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mSearchEdtTxt", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "mSearchClearBtn", "Landroid/view/View;", "mSearchBackgroundView", "mSearchIconIv", "Landroid/widget/ImageView;", "onTextChange", "Lcom/ss/android/lark/search/baseview/SearchInputView$IOnTextChange;", "mOnSearch", "Lcom/ss/android/lark/search/baseview/SearchInputView$IOnSearch;", "mIOnHintSearch", "Lcom/ss/android/lark/search/baseview/SearchInputView$IOnHintSearch;", "getMIOnHintSearch", "()Lcom/ss/android/lark/search/baseview/SearchInputView$IOnHintSearch;", "setMIOnHintSearch", "(Lcom/ss/android/lark/search/baseview/SearchInputView$IOnHintSearch;)V", "mSearchDebounce", "Lcom/ss/android/lark/search/baseview/SearchDebounce;", "mOnFilter", "Lcom/ss/android/lark/search/baseview/SearchInputView$IOnFilter;", "mOnClearBtnClick", "Lcom/ss/android/lark/search/baseview/SearchInputView$IOnClearBtnClick;", "mQuery", "", "onFocusChangeListeners", "", "Landroid/view/View$OnFocusChangeListener;", "mLastImeActionClickTime", "", "fgService", "Lcom/ss/android/lark/search/dto/userscope/IASLFeatureGatingService;", "getFgService", "()Lcom/ss/android/lark/search/dto/userscope/IASLFeatureGatingService;", "setFgService", "(Lcom/ss/android/lark/search/dto/userscope/IASLFeatureGatingService;)V", "requestFocusRunnable", "Ljava/lang/Runnable;", "mTextWatcher", "com/ss/android/lark/search/baseview/SearchInputView$mTextWatcher$1", "Lcom/ss/android/lark/search/baseview/SearchInputView$mTextWatcher$1;", "initView", "", "setOnSearch", "onSearch", "setOnTextChange", "mOnImeSearchAction", "Lcom/ss/android/lark/search/baseview/SearchInputView$IOnImeSearchAction;", "setOnImeSearchAction", "onImeSearchAction", "mOnQueryClear", "Lcom/ss/android/lark/search/baseview/SearchInputView$IOnQueryClear;", "setOnQueryClear", "onQueryClear", "setOnFilter", "onFilter", "setOnClearBtnClick", "onClearBtnClick", "clearFocus", "requestInputFocus", "default", "softInputPopup", "", MapMonitorConst.EVENT_DESTROY, "getQuery", "setText", "text", "setTextPurely", "clearText", "clearTextPurely", "setImeOptions", "imeOptions", "", "setHint", "hint", "setOnEditorActionListener", "listener", "Lkotlin/Function3;", "Landroid/widget/TextView;", "Landroid/view/KeyEvent;", "setHighlightAndCursor", "highlightColor", "cursorDrawable", "Landroid/graphics/drawable/Drawable;", "theme", "setSearchEditTextCornerRadius", "cornerRadius", "", "setSearchEditTextBackgroundColor", "color", "setSearchEditTextTextSizeSp", "sizeSp", "setSearchInputContainerBackgroundColor", "setSearchIconRes", "resId", "setSearchIconSize", "size", "setDrawableCornerRadius", "drawable", "setDrawableColor", "clearOpenSearchFilter", "insertOpenSearchFilter", "info", "Lcom/ss/android/lark/search/dto/info/SearchOpenSearchInfo;", "selectAll", "addOnFocusChangeListener", "onFocusChangeListener", "removeOnFocusChangeListener", "getInputEditText", "Landroid/widget/EditText;", "setAutoFocusEnabled", "enableAutoFocus", "Companion", "IOnSearch", "IOnHintSearch", "IOnFilter", "IOnQueryClear", "IOnClearBtnClick", "IOnTextChange", "IOnImeSearchAction", "search-baseview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchInputView extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f439894p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f439895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AutoFocusEditText f439896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f439897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f439898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f439899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f439900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SearchDebounce f439901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f439902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<View.OnFocusChangeListener> f439903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f439904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b4c.a f439905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j f439906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i f439907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f439908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f f439909o;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
        void onImeSearch(String r100);
    }

    public interface f {
        void onQueryClear();
    }

    public interface g {
        void onSearch(String r100);
    }

    public interface h {
    }

    public static final class i extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f439910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SearchInputView f439911b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f439912a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SearchInputView f439913b;

            public a(String r100, SearchInputView r101) {
                this.f439912a = r100;
                this.f439913b = r101;
            }

            public final void a() {
                String r100 = this.f439912a;
                if (r100 == null) goto L27;
                SearchInputView r101 = this.f439913b;
                r101.f439902h = r100;
                Log.d("LarkSearch.Common.SearchInputView", "real txt: " + r101.f439902h);
                if (r100.length() != 0) goto L7;
                boolean r102 = true;
            L8:
                View r103 = null;
                if (r102 == false) goto L16;
                View r104 = r101.f439897c;
                if (r104 != null) goto L13;
                Intrinsics.throwUninitializedPropertyAccessException("mSearchClearBtn");
                r104 = null;
            L13:
                r104.setVisibility(8);
                SearchDebounce r105 = r101.f439901g;
                r105.f439887d = null;
                r105.f439885b.removeMessages(1);
                f r106 = r101.f439909o;
                if (r106 == null) goto L28;
                r106.onQueryClear();
                return;
            L28:
                return;
            L16:
                View r107 = r101.f439897c;
                if (r107 != null) goto L19;
                Intrinsics.throwUninitializedPropertyAccessException("mSearchClearBtn");
            L20:
                r103.setVisibility(0);
                if (StringsKt.isBlank(r100) == false) goto L23;
                Log.i("LarkSearch.Common.SearchInputView", "ignore blank.");
                return;
            L23:
                g r108 = r101.f439900f;
                if (r108 == null) goto L31;
                r108.onSearch(r100);
                return;
            L31:
                return;
            L19:
                r103 = r107;
                goto L20
            L7:
                r102 = false;
                goto L8
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public i(SearchInputView r100) {
            this.f439911b = r100;
        }

        @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            AutoFocusEditText r101 = null;
            if (r100 == null) goto L7;
            com.ss.android.lark.search.baseview.a[] r102 = (com.ss.android.lark.search.baseview.a[]) r100.getSpans(0, r100.length(), com.ss.android.lark.search.baseview.a.class);
            if (r102 == null) goto L7;
            com.ss.android.lark.search.baseview.a r103 = (com.ss.android.lark.search.baseview.a) ArraysKt.firstOrNull(r102);
        L9:
            if (r103 == null) goto L22;
            this.f439910a = true;
            int r104 = r100.getSpanStart(r103);
            if (r104 <= 0) goto L24;
            AutoFocusEditText r105 = this.f439911b.f439896b;
            if (r105 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
            r105 = null;
        L15:
            r105.removeTextChangedListener(this);
            r100.replace(0, r104, "");
            AutoFocusEditText r106 = this.f439911b.f439896b;
            if (r106 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        L19:
            r101.addTextChangedListener(this);
            return;
        L18:
            r101 = r106;
        L24:
            if (r103 == null) goto L26;
            String r107 = r100.subSequence(r100.getSpanEnd(r103), r100.length()).toString();
        L29:
            SearchInputView r108 = this.f439911b;
            int r109 = SearchInputView.f439894p;
            r108.getClass();
            Log.d("LarkSearch.Common.SearchInputView", "txt: " + r107);
            SearchInputView r110 = this.f439911b;
            SearchDebounce r111 = r110.f439901g;
            a r112 = new a(r107, r110);
            r111.getClass();
            Intrinsics.checkNotNullParameter(r112, "runnable");
            r111.f439887d = null;
            r111.f439885b.removeMessages(1);
            r111.f439887d = r112;
            Log.d("LarkSearch.Common.SearchDebounce", "addDelayedMessage");
            r111.f439885b.sendEmptyMessageDelayed(1, r111.f439886c);
            return;
        L26:
            if (r100 == null) goto L28;
            r107 = r100.toString();
            goto L29
        L28:
            r107 = null;
            goto L29
        L22:
            if (this.f439910a == false) goto L24;
            this.f439910a = false;
            SearchInputView r113 = this.f439911b;
            int r114 = SearchInputView.f439894p;
            r113.getClass();
        L7:
            r103 = null;
            goto L9
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchInputView f439914a;

        public j(SearchInputView r100) {
            this.f439914a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AutoFocusEditText r100 = this.f439914a.f439896b;     // Catch: Throwable -> L7 Exception -> L13
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");     // Catch: Throwable -> L7 Exception -> L13
            r100 = null;
        L5:
            KeyboardUtils.showKeyboard(r100);     // Catch: Throwable -> L7 Exception -> L13
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        }
    }

    public static final class k implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function3 f439915a;

        public k(Function3 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f439915a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final /* synthetic */ boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            return ((Boolean) this.f439915a.invoke(r100, Integer.valueOf(r101), r102)).booleanValue();
        }
    }

    static {
    }

    public final d getMIOnHintSearch() {
        return null;
    }

    public final void setMIOnHintSearch(d r100) {
    }

    public final void setOnClearBtnClick(b r100) {
        Intrinsics.checkNotNullParameter(r100, "onClearBtnClick");
    }

    public final void setOnFilter(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onFilter");
    }

    public final void setOnTextChange(h r100) {
        Intrinsics.checkNotNullParameter(r100, "onTextChange");
    }

    public final void a() {
        AutoFocusEditText r100 = this.f439896b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r100 = null;
    L5:
        r100.setFocusable(true);
        r100.setFocusableInTouchMode(true);
        r100.requestFocus();
        postDelayed(this.f439906l, 150);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        removeCallbacks(this.f439906l);
        KeyboardUtils.hideKeyboard(this.f439895a);
        super.clearFocus();
    }

    public final EditText getInputEditText() {
        AutoFocusEditText r100 = this.f439896b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        return null;
    L6:
        return r100;
    }

    public final b4c.a getFgService() {
        return this.f439905k;
    }

    public final String getQuery() {
        return this.f439902h;
    }

    public SearchInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setAutoFocusEnabled(boolean r100) {
        AutoFocusEditText r101 = this.f439896b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r101 = null;
    L5:
        r101.setAutoFocusEnabled(r100);
    }

    public final void setFgService(b4c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f439905k = r100;
    }

    public final void setHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        AutoFocusEditText r101 = this.f439896b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r101 = null;
    L5:
        r101.setHint(r100);
    }

    public final void setImeOptions(int r100) {
        AutoFocusEditText r101 = this.f439896b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r101 = null;
    L5:
        r101.setImeOptions(r100);
    }

    public final void setOnEditorActionListener(Function3<? super TextView, ? super Integer, ? super KeyEvent, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        AutoFocusEditText r101 = this.f439896b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r101 = null;
    L5:
        r101.setOnEditorActionListener(new k(r100));
    }

    public final void setOnImeSearchAction(e r100) {
        Intrinsics.checkNotNullParameter(r100, "onImeSearchAction");
        this.f439908n = r100;
    }

    public final void setOnQueryClear(f r100) {
        Intrinsics.checkNotNullParameter(r100, "onQueryClear");
        this.f439909o = r100;
    }

    public final void setOnSearch(g r100) {
        Intrinsics.checkNotNullParameter(r100, "onSearch");
        this.f439900f = r100;
    }

    public final void setSearchEditTextBackgroundColor(int r100) {
        View r101 = this.f439898d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchBackgroundView");
        r101 = null;
    L5:
        b(r101.getBackground(), r100);
    }

    public final void setSearchEditTextCornerRadius(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        View r101 = this.f439898d;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchBackgroundView");
        r101 = null;
    L8:
        c(r101.getBackground(), r100);
    }

    public final void setSearchEditTextTextSizeSp(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        AutoFocusEditText r101 = this.f439896b;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r101 = null;
    L8:
        r101.setTextSize(2, r100);
    }

    public final void setSearchIconRes(int r100) {
        ImageView r101 = this.f439899e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchIconIv");
        r101 = null;
    L5:
        r101.setImageResource(r100);
    }

    public final void setSearchIconSize(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        ImageView r101 = this.f439899e;
        ImageView r102 = null;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchIconIv");
        r101 = null;
    L7:
        ImageView r103 = this.f439899e;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchIconIv");
    L11:
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        r104.width = r100;
        r104.height = r100;
        r101.setLayoutParams(r104);
        return;
    L10:
        r102 = r103;
        goto L11
    }

    public final void setSearchInputContainerBackgroundColor(int r100) {
        setBackgroundColor(r100);
        if (getChildCount() <= 0) goto L6;
        getChildAt(0).setBackground(null);
        return;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if ((!StringsKt.isBlank(r100)) == false) goto L17;
        AutoFocusEditText r101 = this.f439896b;
        AutoFocusEditText r102 = null;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r101 = null;
    L7:
        r101.setText(r100);
        AutoFocusEditText r103 = this.f439896b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
    L11:
        Editable r104 = r102.getText();
        if (r104 == null) goto L14;
        int r105 = r104.length();
    L15:
        r101.setSelection(r105);
        return;
    L14:
        r105 = 0;
        goto L15
    L10:
        r102 = r103;
        goto L11
    }

    public final void setTextPurely(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if ((!StringsKt.isBlank(r100)) == false) goto L19;
        AutoFocusEditText r101 = this.f439896b;
        View r102 = null;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r101 = null;
    L7:
        r101.removeTextChangedListener(this.f439907m);
        r101.setText(r100);
        AutoFocusEditText r103 = this.f439896b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r103 = null;
    L10:
        Editable r104 = r103.getText();
        if (r104 == null) goto L13;
        int r105 = r104.length();
    L14:
        r101.setSelection(r105);
        View r106 = this.f439897c;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchClearBtn");
    L18:
        r102.setVisibility(0);
        r101.addTextChangedListener(this.f439907m);
        goto L19
    L17:
        r102 = r106;
        goto L18
    L13:
        r105 = 0;
    L19:
        this.f439902h = r100;
    }

    public final void setHint(int r100) {
        AutoFocusEditText r101 = this.f439896b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r101 = null;
    L5:
        r101.setHint(r100);
    }

    public SearchInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f439901g = new SearchDebounce(SearchDebounce.Type.Input);
        this.f439902h = "";
        ArrayList r102 = new ArrayList();
        this.f439903i = r102;
        this.f439905k = (b4c.a) e0c.k.a(LarkContext.getApplication(), b4c.a.class);
        this.f439906l = new j(this);
        i r103 = new i(this);
        this.f439907m = r103;
        this.f439895a = r100;
        LayoutInflater.from(r100).inflate(R.layout.view_search_edt_text, this, true);
        this.f439896b = (AutoFocusEditText) findViewById(R.id.search_edt_txt);
        this.f439897c = findViewById(R.id.search_clear_iv);
        this.f439899e = (ImageView) findViewById(R.id.search_icon_iv);
        this.f439898d = findViewById(R.id.search_bg_view);
        AutoFocusEditText r104 = this.f439896b;
        View r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r104 = null;
    L5:
        r104.addTextChangedListener(r103);
        com.ss.android.lark.search.baseview.b r106 = new com.ss.android.lark.search.baseview.b(this, r104);
        Intrinsics.checkNotNullParameter(r106, "onFocusChangeListener");
        r106.onFocusChange(this, isFocused());
        r102.add(r106);
        r104.setOnFocusChangeListener(new com.ss.android.lark.search.baseview.c(this));
        this.f439905k.isEnable("core.picker.search_by_pinyin");
        Boolean r107 = ExternalKeyboardUtils.f285887a;
        if (ExternalKeyboardUtils.b(false) == true) goto L8;
        r104.setOnEditorActionListener(new com.ss.android.lark.search.baseview.d(this));
    L8:
        View r108 = this.f439897c;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchClearBtn");
    L12:
        r105.setOnClickListener(new com.ss.android.lark.search.baseview.e(this));
        setOnClickListener(new com.ss.android.lark.search.baseview.f(this));
        return;
    L11:
        r105 = r108;
        goto L12
    }

    public static void b(Drawable r100, int r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof GradientDrawable) == false) goto L7;
        GradientDrawable r102 = (GradientDrawable) r100;
        r102.mutate();
        r102.setColor(r101);
        return;
    L7:
        int r103 = 0;
        if ((r100 instanceof RippleDrawable) == false) goto L13;
        RippleDrawable r104 = (RippleDrawable) r100;
        r104.mutate();
        int r105 = r104.getNumberOfLayers();
    L10:
        if (r103 >= r105) goto L29;
        b(r104.getDrawable(r103), r101);
        r103 = r103 + 1;
        goto L10
    L29:
        return;
    L13:
        if ((r100 instanceof LayerDrawable) == false) goto L18;
        LayerDrawable r106 = (LayerDrawable) r100;
        r106.mutate();
        int r107 = r106.getNumberOfLayers();
    L15:
        if (r103 >= r107) goto L30;
        b(r106.getDrawable(r103), r101);
        r103 = r103 + 1;
        goto L15
    L30:
        return;
    L18:
        if ((r100 instanceof InsetDrawable) == false) goto L21;
        InsetDrawable r108 = (InsetDrawable) r100;
        r108.mutate();
        b(r108.getDrawable(), r101);
        return;
    L21:
        if ((r100 instanceof StateListDrawable) == false) goto L28;
        StateListDrawable r109 = (StateListDrawable) r100;
        r109.mutate();
        b(r109.getCurrent(), r101);
        return;
    }

    public static void c(Drawable r100, float r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof GradientDrawable) == false) goto L7;
        GradientDrawable r102 = (GradientDrawable) r100;
        r102.mutate();
        r102.setCornerRadius(r101);
        return;
    L7:
        int r103 = 0;
        if ((r100 instanceof RippleDrawable) == false) goto L13;
        RippleDrawable r104 = (RippleDrawable) r100;
        r104.mutate();
        int r105 = r104.getNumberOfLayers();
    L10:
        if (r103 >= r105) goto L29;
        c(r104.getDrawable(r103), r101);
        r103 = r103 + 1;
        goto L10
    L29:
        return;
    L13:
        if ((r100 instanceof LayerDrawable) == false) goto L18;
        LayerDrawable r106 = (LayerDrawable) r100;
        r106.mutate();
        int r107 = r106.getNumberOfLayers();
    L15:
        if (r103 >= r107) goto L30;
        c(r106.getDrawable(r103), r101);
        r103 = r103 + 1;
        goto L15
    L30:
        return;
    L18:
        if ((r100 instanceof InsetDrawable) == false) goto L21;
        InsetDrawable r108 = (InsetDrawable) r100;
        r108.mutate();
        c(r108.getDrawable(), r101);
        return;
    L21:
        if ((r100 instanceof StateListDrawable) == false) goto L28;
        StateListDrawable r109 = (StateListDrawable) r100;
        r109.mutate();
        c(r109.getCurrent(), r101);
        return;
    }
}
