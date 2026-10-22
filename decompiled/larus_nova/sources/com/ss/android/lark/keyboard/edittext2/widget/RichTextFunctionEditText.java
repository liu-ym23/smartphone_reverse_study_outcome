package com.ss.android.lark.keyboard.edittext2.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.content.ContextCompat;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.utils.RichTextCopyUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 E2\u00020\u0001:\u0001EB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001f\u0010\u001c\u001a\u00020\r2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001f\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0014\u0010#\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0002J'\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001f\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\rH\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001f0+H\u0014J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0007H\u0002J\n\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0007H\u0014J\b\u00102\u001a\u000203H\u0014J\b\u00104\u001a\u00020\u000fH\u0014J\u0018\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0014J*\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0014J\u0010\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020\rH\u0002J\u0016\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006F"}, d2 = {"Lcom/ss/android/lark/keyboard/edittext2/widget/RichTextFunctionEditText;", "Lcom/ss/android/lark/keyboard/edittext2/base/FunctionEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionAfterTextChanged", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "blockReselect", "", "useAnchorFilter", "getUseAnchorFilter", "()Z", "setUseAnchorFilter", "(Z)V", "setKeyListener", "keyListener", "Landroid/text/method/KeyListener;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "setFilters", "filters", "", "Landroid/text/InputFilter;", "([Landroid/text/InputFilter;)V", "setInputType", "type", "decorKeyListener", "decorInputConnection", "inputConnection", "decorFilters", "([Landroid/text/InputFilter;)[Landroid/text/InputFilter;", "updateKeyListener", "updateFilters", "prepareInputFilters", "", "onTextContextMenuItem", "id", "interceptContextMenuItem", "getClipBoardManager", "Landroid/content/ClipboardManager;", "beforeTextCopy", "prepareClipDataBeforeCopy", "Landroid/content/ClipData;", "beforeTextPaste", "onSelectionChanged", "selStart", "selEnd", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "resolveAttachedEditSpanHolderIfNeed", "changedSequence", "Landroid/text/Spanned;", "setupTextWatcherSpanNotification", "setParseAnchorEnable", "parseUrl", "showLinkIfNotParseUrl", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RichTextFunctionEditText extends FunctionEditText {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<Function0<Unit>> f429257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f429258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f429259e;

    public static final class a {
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichTextFunctionEditText f429260a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public b(RichTextFunctionEditText r100) {
            this.f429260a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            Function0<Unit> r101 = this.f429260a.f429257c.pollLast();
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    static {
    }

    public RichTextFunctionEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RichTextFunctionEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final ClipboardManager getClipBoardManager() {
        return (ClipboardManager) ContextCompat.getSystemService(getContext(), ClipboardManager.class);
    }

    public boolean f() {
        return RichTextCopyUtils.f(this);
    }

    public final void g() {
        setFilters(super.getFilters());
    }

    public final boolean getUseAnchorFilter() {
        return this.f429259e;
    }

    public boolean e(int r100) {
        RichText r101 = ((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.f429100g)).i(getSelectionStart(), getSelectionEnd());
        RichTextCopyUtils.e(r101.getInnerText(), r101);
        ClipData r102 = ClipData.newPlainText("RichTextFunctionEditText", RichTextCopyUtils.a(r101.getInnerText()));
        super.onTextContextMenuItem(r100);
        ClipboardManager r103 = getClipBoardManager();
        if (r103 != null) goto L12;
        return false;
    L12:
        qf7.a r104 = qf7.a.f532746a;     // Catch: SensitiveAPIException -> L8
        Token r105 = RichTextCopyUtils.f429244a;     // Catch: SensitiveAPIException -> L8
        r104.a(r103, r102, RichTextCopyUtils.f429244a);     // Catch: SensitiveAPIException -> L8
        return true;
    L8:
        e = move-exception;
        Log.e("RichTextFunctionEditText", "beforeTextCopy: set primary clip failed: " + e.getMessage());
        return true;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.FunctionEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "outAttrs");
        InputConnection r101 = super.onCreateInputConnection(r100);
        m r102 = null;
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r101 instanceof m) == false) goto L8;
        r102 = (m) r101;
    L8:
        if (r102 == null) goto L11;
        return r102;
    L11:
        return new m(this, r101);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        switch(r100) {
            case 16908320: goto L6;
            case 16908321: goto L6;
            case 16908322: goto L5;
            default: goto L4;
        };
    L4:
        boolean r101 = false;
    L7:
        if (r101 == false) goto L9;
    L10:
        return true;
    L9:
        if (super.onTextContextMenuItem(r100) == true) goto L10;
        return false;
    L5:
        r101 = f();
        goto L7
    L6:
        r101 = e(r100);
        goto L7
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r100) {
        if (r100 != null) goto L8;
        ArrayList r101 = new ArrayList();
        r101.add(new q());
        if (this.f429259e == false) goto L7;
        r101.add(new com.ss.android.lark.keyboard.edittext2.widget.a(this));
    L7:
        InputFilter[] r102 = (InputFilter[]) r101.toArray(new InputFilter[0]);
    L18:
        super.setFilters(r102);
        return;
    L8:
        ArrayList r103 = new ArrayList();
        int r104 = r100.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L14;
        InputFilter r106 = r100[r105];
        if ((!(r106 instanceof d)) == false) goto L13;
        r103.add(r106);
    L13:
        r105 = r105 + 1;
        goto L9
    L14:
        List r107 = CollectionsKt.toMutableList(r103);
        ArrayList r108 = new ArrayList();
        r108.add(new q());
        if (this.f429259e == false) goto L17;
        r108.add(new com.ss.android.lark.keyboard.edittext2.widget.a(this));
    L17:
        r107.addAll(0, r108);
        r102 = (InputFilter[]) r107.toArray(new InputFilter[0]);
        goto L18
    }

    @Override // android.widget.TextView
    public void setInputType(int r100) {
        super.setInputType(r100);
        setKeyListener(super.getKeyListener());
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener r100) {
        n r101 = null;
        if (r100 != null) goto L6;
    L11:
        super.setKeyListener(r101);
        return;
    L6:
        if ((r100 instanceof n) == false) goto L8;
        r101 = (n) r100;
    L8:
        if (r101 != null) goto L11;
        r101 = new n(r100);
        goto L11
    }

    public final void setUseAnchorFilter(boolean r100) {
        this.f429259e = r100;
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int r110, int r111) {
        if (this.f429258d == false) goto L5;
        return;
    L5:
        this.f429258d = true;
        h r100 = h.f429267a;
        Intrinsics.checkNotNullParameter(this, "editText");
        Editable r101 = getEditableText();
        Pair r102 = TuplesKt.to(Integer.valueOf(r110), Integer.valueOf(r111));
        if (r110 < 0) goto L16;
        if (r111 < 0) goto L16;
        Intrinsics.checkNotNull(r101);
        com.ss.android.lark.keyboard.edittext2.span.k[] r103 = (com.ss.android.lark.keyboard.edittext2.span.k[]) r101.getSpans(0, r101.length(), com.ss.android.lark.keyboard.edittext2.span.k.class);
        com.ss.android.lark.keyboard.edittext2.span.k.a r104 = new com.ss.android.lark.keyboard.edittext2.span.k.a(r110, r111);
        int r105 = r103.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L15;
        com.ss.android.lark.keyboard.edittext2.span.k.a r107 = r103[r106].e(r104.f429225a, r104.f429226b, r101);
        if (r107 == null) goto L14;
        r104 = r107;
    L14:
        r106 = r106 + 1;
        goto L10
    L15:
        r102 = TuplesKt.to(Integer.valueOf(r110), Integer.valueOf(r111));
    L16:
        int r108 = ((Number) r102.component1()).intValue();
        int r109 = ((Number) r102.component2()).intValue();
        this.f429258d = false;
        if (r108 != r110) goto L19;
        if (r109 != r111) goto L19;
    L20:
        super.onSelectionChanged(r108, r109);
        return;
    L19:
        Log.d("RichTextFunctionEditText", "onSelectionChanged: selection updated");
        goto L20
    }

    public RichTextFunctionEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f429257c = new LinkedList();
        this.f429259e = true;
        setKeyListener(super.getKeyListener());
        g();
        addTextChangedListener(new k());
        addTextChangedListener(new l());
        addTextChangedListener(new j(this));
        addTextChangedListener(new b(this));
        setMovementMethod(new o());
    }

    public /* synthetic */ RichTextFunctionEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        if (r100 != null) goto L5;
        return;
    L5:
        CharSequence r104 = r100.subSequence(r101, r103 + r101);
        if ((r104 instanceof Spanned) == false) goto L8;
        Spanned r105 = (Spanned) r104;
    L9:
        if (r105 == null) goto L15;
        final Spanned r106 = (Spanned) r104;
        LinkedList<Function0<Unit>> r107 = this.f429257c;
        if (r107 == null) goto L16;
        r107.offer(new RichTextFunctionEditText$resolveAttachedEditSpanHolderIfNeed$1(r106, this));
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r105 = null;
        goto L9
    }
}
