package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.view.ViewCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.MmStringCheckUtil;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001f\u0018\u0000 D2\u00020\u0001:\u0002DEB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J(\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0015J\u001a\u0010-\u001a\u00020\u00002\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fJ$\u0010/\u001a\u00020\u00002\u001c\u0010.\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00100\u0012J\u0014\u00100\u001a\u00020\u00002\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017J\"\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u00132\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\u000fJ\u0010\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u000106J\b\u00107\u001a\u00020\u0010H\u0002J\u0006\u00108\u001a\u00020\u0010J\u001a\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\"\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\u0006\u0010B\u001a\u00020\u0010J\u0006\u0010C\u001a\u00020\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006F"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmCoveredEditTextView;", "Lcom/suite/lark/emm/design/edittext/SCAppCompatEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastText", "", "coveredTextView", "Landroid/view/View;", "editDownCallback", "Lkotlin/Function1;", "", "editErrorCallback", "Lkotlin/Function2;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/MmStringCheckUtil$StringCheckoutErrorType;", "editDownCondition", "", "sizeChangeCallBack", "Lkotlin/Function0;", "needInsertSpace", "editErrorType", "keyboardShownAfterFocus", "pendingKeyboardHideByBack", "lastShowKeyboardUptimeMs", "", "textWatcher", "com/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmCoveredEditTextView$textWatcher$1", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmCoveredEditTextView$textWatcher$1;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onSizeChanged", "w", "h", "oldw", "oldh", "coverView", "view", "need", "onEditDown", "callback", "onEditError", "onSizeChange", "editDownPredicate", "error", "predicate", "onCoveredViewClick", "text", "", "showKeyboard", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "onKeyPreIme", "keyCode", "event", "Landroid/view/KeyEvent;", "onFocusChanged", "focused", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", LiveCommonConstants.REASON_ON_DEDTROY, "onKeyboardHide", "Companion", "EnterAndLengthInputFilter", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmCoveredEditTextView extends SCAppCompatEditText {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f435641j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f435642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super String, Unit> f435643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super String, ? super MmStringCheckUtil.StringCheckoutErrorType, Unit> f435644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f435645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmStringCheckUtil.StringCheckoutErrorType f435646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f435647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f435648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f435649i;

    public static final class a {
    }

    public static final class b implements InputFilter {
        public b() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r110, int r111, int r210, Spanned r211, int r212, int r213) {
            int r100 = bwb.b.f21271a;
            MmUiLogScene r101 = MmUiLogScene.FOUNDATION;
            bwb.b.b(r101, "filter", "source=" + r110 + ", start=" + r111 + ", end=" + r210 + ", dest=" + r211 + ", dstart=" + r212 + ", dend=" + r213, null, 8);
            String r102 = "";
            if (r110 == null) goto L8;
            CharSequence r103 = r110.subSequence(r111, r210);
            if (r103 == null) goto L8;
            String r104 = r103.toString();
            if (r104 == null) goto L8;
        L9:
            if (r211 == null) goto L15;
            String r105 = r211.toString();
            if (r105 == null) goto L15;
            r102 = r105;
        L15:
            if (StringsKt.contains$default(r104, '\n', false, 2, null) == false) goto L17;
            bwb.b.b(r101, "filter", "replace enter", null, 8);
            String r106 = StringsKt.replace$default(r104, "\n", "", false, 4, null);
        L18:
            int r107 = RangesKt.coerceAtLeast(50 - RangesKt.coerceAtLeast(r102.length() - RangesKt.coerceAtLeast(r213 - r212, 0), 0), 0);
            if (r106.length() <= r107) goto L23;
            bwb.b.b(r101, "filter", "limit length", null, 8);
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a(R.string.MMWeb_G_ExceedWordCount);
            return r106.subSequence(0, r107);
        L23:
            if (Intrinsics.areEqual(r106, r104) == false) goto L26;
            return null;
        L26:
            return r106;
        L17:
            r106 = r104;
        L8:
            r104 = "";
            goto L9
        }
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmCoveredEditTextView f435650a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(MmCoveredEditTextView r100) {
            this.f435650a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (this.f435650a.f435645e == true) goto L6;
            return;
        L6:
            if (r100 == null) goto L8;
            String r101 = r100.toString();
        L10:
            if (r101 != null) goto L13;
            int r102 = bwb.b.f21271a;
            bwb.b.b(MmUiLogScene.FOUNDATION, "afterTextChanged", "data is null", null, 8);
            return;
        L13:
            int r103 = bwb.b.f21271a;
            MmUiLogScene r104 = MmUiLogScene.FOUNDATION;
            bwb.b.b(r104, "afterTextChanged", "data=".concat(r101), null, 8);
            boolean r105 = false;
            if (r101.length() != 0) goto L16;
            boolean r106 = true;
        L17:
            if (r106 == false) goto L20;
            this.f435650a.setText(" ");
            return;
        L20:
            if (StringsKt.last(r101) != ' ') goto L28;
            String r107 = StringsKt.trim(r101).toString();
            if (r107.length() <= 0) goto L24;
            r105 = true;
        L24:
            if (r105 == false) goto L29;
            bwb.b.b(r104, "afterTextChanged", "delete space", null, 8);
            this.f435650a.setText(r107);
            this.f435650a.setSelection(r107.length());
            return;
        L29:
            return;
        L28:
            return;
        L16:
            r106 = false;
            goto L17
        L8:
            r101 = null;
            goto L10
        }
    }

    static {
    }

    public MmCoveredEditTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmCoveredEditTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r100 == null) goto L10;
        int r102 = r100.imeOptions;
        int r103 = r102 & 255;
        if ((r103 & 4) == 0) goto L7;
        r100.imeOptions = (r102 ^ r103) | 4;
    L7:
        int r104 = r100.imeOptions;
        if ((1073741824 & r104) == 0) goto L10;
        r100.imeOptions = r104 & (-1073741825);
    L10:
        return r101;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int r100, KeyEvent r101) {
        if (r100 != 4) goto L13;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L13;
        this.f435648h = true;
        return true;
    L7:
        if (r101.getAction() != 1) goto L9;
        r102 = true;
    L13:
        return super.onKeyPreIme(r100, r101);
    }

    public MmCoveredEditTextView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f435646f = MmStringCheckUtil.StringCheckoutErrorType.NOT_DEFINE;
        c r103 = new c(this);
        wvb.g r104 = new wvb.g();
        View r105 = getRootView();
        Intrinsics.checkNotNullParameter(r105, "rootView");
        ViewCompat.setOnApplyWindowInsetsListener(r105, new wvb.f(r104));
        Function1<Integer, Unit> r106 = new AnonymousClass1(r100, this);
        Intrinsics.checkNotNullParameter(r106, "callback");
        r104.f561607a.f561605a = r106;
        addTextChangedListener(r103);
        setFilters(new b[]{new b()});
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        super.onFocusChanged(r100, r101, r102);
        if (r100 == true) goto L20;
        int r103 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onFocusChanged", "lost focus", null, 8);
        boolean r104 = false;
        this.f435647g = false;
        this.f435648h = false;
        String r105 = String.valueOf(getText());
        MmStringCheckUtil r106 = new MmStringCheckUtil(r105);
        if (r105.length() != 0) goto L7;
        r104 = true;
    L7:
        if (r104 == false) goto L9;
        r106.f434025a = true;
        r106.f434026b = MmStringCheckUtil.StringCheckoutErrorType.NULL_OR_EMPTY;
    L9:
        MmStringCheckUtil.StringCheckoutErrorType r107 = this.f435646f;
        Function1<String, Boolean> r108 = new C119371(this);
        Intrinsics.checkNotNullParameter(r108, "predict");
        if (r108.invoke(r105).booleanValue() == false) goto L12;
        r106.f434025a = true;
        r106.f434026b = r107;
    L12:
        Function1<String, Unit> r109 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r109, "callBack");
        if (r106.f434025a == false) goto L15;
        lvb.a.b("StringCheckUtil", "checkoutStringNotNull failed, sourceStr=".concat(r105));
    L16:
        Function2<String, MmStringCheckUtil.StringCheckoutErrorType, Unit> r110 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r110, "callBack");
        if (r106.f434025a == false) goto L21;
        r110.invoke(r105, r106.f434026b);
        return;
    L21:
        return;
    L15:
        r109.invoke(r105);
        goto L16
    }

    public /* synthetic */ MmCoveredEditTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = android.R.attr.editTextStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r103 == r101) goto L6;
        int r104 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onSizeChanged", "on size change, oldH=" + r103 + ", newH=" + r101, null, 8);
        return;
    }
}
