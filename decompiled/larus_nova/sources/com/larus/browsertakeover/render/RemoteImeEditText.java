package com.larus.browsertakeover.render;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 E2\u00020\u0001:\u0002DEB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J0\u0010 \u001a\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u0007H\u0017J\u0018\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007H\u0017J\u001e\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u0011J\u000e\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u0014J\u0006\u00107\u001a\u00020\u0014J\u0006\u00108\u001a\u00020\u0014J\u0006\u00109\u001a\u00020!J\u0006\u0010:\u001a\u00020!J\u0006\u0010;\u001a\u00020!J\u0006\u0010<\u001a\u00020\u0011J\u0006\u0010=\u001a\u00020!J\b\u0010>\u001a\u00020\u0014H\u0002J\n\u0010?\u001a\u0004\u0018\u00010\u0011H\u0002J\n\u0010@\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010A\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020!H\u0002J\b\u0010C\u001a\u00020\u0011H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/larus/browsertakeover/render/RemoteImeEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/larus/browsertakeover/render/RemoteImeEditText$Listener;", "getListener", "()Lcom/larus/browsertakeover/render/RemoteImeEditText$Listener;", "setListener", "(Lcom/larus/browsertakeover/render/RemoteImeEditText$Listener;)V", "composingText", "", "remoteInputMode", "proxyMode", "", "activeInputConnection", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onKeyPreIme", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyDown", "onKeyUp", "addFocusables", "", "views", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "direction", "focusableMode", "requestRectangleOnScreen", "rectangle", "Landroid/graphics/Rect;", "immediate", "getAutofillType", "onProvideAutofillStructure", "structure", "Landroid/view/ViewStructure;", "flags", "applyRemoteInputMode", "inputMode", "isPassword", "enterKeyHint", "setProxyMode", "enabled", "canEnterProxyMode", "isProxyMode", "flushProxyComposition", "finishProxyComposition", "cancelProxyComposition", "consumePendingText", "clearPendingText", "hasLocalComposition", "currentComposingSpanText", "currentCompositionCandidate", "handleRemoteKeyEvent", "clearLocalText", "validatedLocalText", "Listener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteImeEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f319518f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f319519g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f319520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f319521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f319522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f319523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f319524e;

    public static final class a {
    }

    public interface b {
        void I10(String r100);

        void LI();

        void hQ();

        void ob();

        void y9(int r100, int r101);
    }

    public static final class c extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemoteImeEditText f319525a;

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean finishComposingText() {
            RemoteImeEditText r100 = this.f319525a;
            if (r100.f319523d == false) goto L5;
            String r101 = r100.f();
            if (r101 != null) goto L10;
            r101 = this.f319525a.f319521b;
        L10:
            if (r101 == null) goto L25;
            boolean r102 = true;
            if (r101.length() <= 0) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == true) goto L18;
            r101 = null;
        L18:
            if (r101 == null) goto L25;
            if (r101.length() <= 4096) goto L23;
            r102 = false;
        L23:
            if (r102 == false) goto L25;
        L26:
            boolean r104 = super.finishComposingText();
            RemoteImeEditText r105 = this.f319525a;
            r105.f319521b = null;
            if (r101 == null) goto L31;
            b r106 = r105.getListener();
            if (r106 == null) goto L31;
            r106.I10(r101);
        L31:
            this.f319525a.e();
            return r104;
        L14:
            r103 = false;
        L25:
            r101 = null;
            goto L26
        L5:
            return super.finishComposingText();
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            RemoteImeEditText r101 = this.f319525a;
            if (r101.f319523d == true) goto L7;
            return super.sendKeyEvent(r100);
        L7:
            if (r101.h(r100) == false) goto L10;
            return true;
        L10:
            return super.sendKeyEvent(r100);
        }

        public c(InputConnection r100, RemoteImeEditText r101) {
            this.f319525a = r101;
            super(r100, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r100, int r101) {
            if (this.f319525a.f319523d == false) goto L5;
            boolean r102 = super.commitText(r100, r101);
            Editable r103 = this.f319525a.getText();
            if (r103 == null) goto L9;
            String r104 = r103.toString();
        L10:
            String r105 = "";
            if (r104 != null) goto L13;
            r104 = "";
        L13:
            boolean r106 = true;
            if (r104.length() > 4096) goto L16;
            boolean r107 = true;
        L17:
            if (r107 == true) goto L20;
            r104 = null;
        L20:
            if (r104 == null) goto L23;
            r105 = r104;
        L23:
            this.f319525a.f319521b = null;
            if (r105.length() > 0) goto L27;
            r106 = false;
        L27:
            if (r106 == false) goto L31;
            b r108 = this.f319525a.getListener();
            if (r108 == null) goto L31;
            r108.I10(r105);
        L31:
            this.f319525a.e();
            return r102;
        L16:
            r107 = false;
            goto L17
        L9:
            r104 = null;
            goto L10
        L5:
            return super.commitText(r100, r101);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r100, int r101) {
            RemoteImeEditText r102 = this.f319525a;
            if (r102.f319523d == true) goto L7;
            return super.deleteSurroundingText(r100, r101);
        L7:
            if (r102.i() == false) goto L10;
            boolean r103 = super.deleteSurroundingText(r100, r101);
            RemoteImeEditText r104 = this.f319525a;
            r104.f319521b = RemoteImeEditText.c(r104);
            return r103;
        L10:
            b r105 = this.f319525a.getListener();
            if (r105 == null) goto L15;
            r105.y9(RangesKt.coerceIn(r100, 0, 64), RangesKt.coerceIn(r101, 0, 64));
            return true;
        L15:
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingTextInCodePoints(int r100, int r101) {
            RemoteImeEditText r102 = this.f319525a;
            if (r102.f319523d == true) goto L7;
            return super.deleteSurroundingTextInCodePoints(r100, r101);
        L7:
            if (r102.i() == false) goto L10;
            boolean r103 = super.deleteSurroundingTextInCodePoints(r100, r101);
            RemoteImeEditText r104 = this.f319525a;
            r104.f319521b = RemoteImeEditText.c(r104);
            return r103;
        L10:
            b r105 = this.f319525a.getListener();
            if (r105 == null) goto L15;
            r105.y9(RangesKt.coerceIn(r100, 0, 64), RangesKt.coerceIn(r101, 0, 64));
            return true;
        L15:
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean setComposingText(CharSequence r100, int r101) {
            if (this.f319525a.f319523d == false) goto L5;
            boolean r102 = super.setComposingText(r100, r101);
            RemoteImeEditText r103 = this.f319525a;
            r103.f319521b = RemoteImeEditText.c(r103);
            return r102;
        L5:
            return super.setComposingText(r100, r101);
        }
    }

    public RemoteImeEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RemoteImeEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public int getAutofillType() {
        return 0;
    }

    static {
        f319518f = SetsKt.setOf(new String[]{"numeric", "decimal"});
        f319519g = SetsKt.setOf(new String[]{"text", "email", "url", "tel", "numeric", "decimal", "search"});
    }

    public final void g() {
        if (this.f319523d == true) goto L6;
        return;
    L6:
        if (i() == false) goto L11;
        c r100 = this.f319524e;
        if (r100 == null) goto L12;
        r100.finishComposingText();
        return;
    L12:
        return;
    }

    public final void e() {
        Editable r100 = getText();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L14;
        Editable r102 = getText();
        if (r102 == null) goto L14;
        r102.clear();
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        setImportantForAutofill(8);
        return;
    L17:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String f() {
        Editable r100 = getText();
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = BaseInputConnection.getComposingSpanStart(r100);
        int r102 = BaseInputConnection.getComposingSpanEnd(r100);
        if (r101 < 0) goto L13;
        if (r102 <= r101) goto L13;
        if (r102 > r100.length()) goto L13;
        return r100.subSequence(r101, r102).toString();
    L13:
        return null;
    }

    public final boolean i() {
        Editable r100 = getText();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (BaseInputConnection.getComposingSpanStart(r100) < 0) goto L8;
    L17:
        return true;
    L8:
        if (BaseInputConnection.getComposingSpanEnd(r100) >= 0) goto L17;
        String r101 = this.f319521b;
        if (r101 != null) goto L12;
    L15:
        boolean r102 = true;
    L16:
        if (r102 == false) goto L17;
        return false;
    L12:
        if (r101.length() == 0) goto L15;
        r102 = false;
        goto L16
    }

    public final b getListener() {
        return this.f319520a;
    }

    public static final String c(RemoteImeEditText r100) {
        String r101 = r100.f();
        if (r101 != null) goto L20;
        Editable r102 = r100.getText();
        if (r102 == null) goto L18;
        String r103 = r102.toString();
        if (r103 == null) goto L18;
        boolean r104 = false;
        if (r103.length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
    L16:
        if (r104 == false) goto L18;
        return r103;
    L14:
        if (r103.length() > 4096) goto L16;
        r104 = true;
        goto L16
    L11:
        r105 = false;
    L18:
        return null;
    L20:
        return r101;
    }

    public final boolean h(KeyEvent r100) {
        if (i() == false) goto L6;
        return false;
    L6:
        if (r100.getAction() != 1) goto L18;
        if (r100.getKeyCode() != 67) goto L10;
    L15:
        return true;
    L10:
        if (r100.getKeyCode() == 112) goto L15;
        if (r100.getKeyCode() == 66) goto L15;
        if (r100.getKeyCode() == 61) goto L15;
        return false;
    L18:
        if (r100.getAction() == 0) goto L20;
        return false;
    L20:
        int r101 = r100.getKeyCode();
        if (r101 == 61) goto L46;
        if (r101 == 112) goto L43;
        if (r101 == 66) goto L40;
        if (r101 == 67) goto L37;
        int r102 = r100.getUnicodeChar();
        if ((Integer.MIN_VALUE & r102) == 0) goto L28;
        boolean r103 = true;
    L29:
        if (r102 <= 0) goto L52;
        if (r103 == false) goto L32;
        return false;
    L32:
        if (Character.isValidCodePoint(r102) == false) goto L54;
        b r104 = this.f319520a;
        if (r104 == null) goto L49;
        r104.I10(new String(Character.toChars(r102)));
    L49:
        return true;
    L54:
        return false;
    L52:
        return false;
    L28:
        r103 = false;
        goto L29
    L37:
        b r105 = this.f319520a;
        if (r105 == null) goto L49;
        r105.y9(1, 0);
        goto L49
    L40:
        b r106 = this.f319520a;
        if (r106 == null) goto L49;
        r106.ob();
        goto L49
    L43:
        b r107 = this.f319520a;
        if (r107 == null) goto L49;
        r107.y9(0, 1);
        goto L49
    L46:
        b r108 = this.f319520a;
        if (r108 == null) goto L49;
        r108.LI();
        goto L49
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "outAttrs");
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        r100.imeOptions = (r100.imeOptions | 268435456) | 16777216;
        c r102 = new c(r101, this);
        this.f319524e = r102;
        return r102;
    }

    public final void setListener(b r100) {
        this.f319520a = r100;
    }

    public final void setProxyMode(boolean r100) {
        boolean r101 = this.f319523d;
        if (r101 != r100) goto L5;
        return;
    L5:
        InputMethodManager r102 = null;
        if (r101 == false) goto L12;
        if (r100 == true) goto L12;
        this.f319521b = null;
        Editable r103 = getText();
        if (r103 == null) goto L11;
        BaseInputConnection.removeComposingSpans(r103);
    L11:
        e();
    L12:
        this.f319523d = r100;
        this.f319521b = null;
        Object r104 = getContext().getSystemService("input_method");
        if ((r104 instanceof InputMethodManager) == false) goto L15;
        r102 = (InputMethodManager) r104;
    L15:
        if (r102 == null) goto L18;
        r102.restartInput(this);
        return;
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        Intrinsics.checkNotNullParameter(r101, "event");
        if (this.f319523d == false) goto L9;
        if (h(r101) == false) goto L9;
        return true;
    L9:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int r100, KeyEvent r101) {
        if (r100 != 4) goto L14;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L14;
        b r103 = this.f319520a;
        if (r103 == null) goto L14;
        r103.hQ();
        goto L14
    L7:
        if (r101.getAction() != 1) goto L9;
        r102 = true;
    L14:
        return super.onKeyPreIme(r100, r101);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r100, KeyEvent r101) {
        Intrinsics.checkNotNullParameter(r101, "event");
        if (this.f319523d == false) goto L9;
        if (h(r101) == false) goto L9;
        return true;
    L9:
        return super.onKeyUp(r100, r101);
    }

    @Override // android.view.View
    public final void onProvideAutofillStructure(ViewStructure r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "structure");
        super.onProvideAutofillStructure(r100, r101);
        r100.setAutofillType(0);
        r100.setText("");
    }

    @Override // android.view.View
    public final boolean requestRectangleOnScreen(Rect r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "rectangle");
        if (this.f319523d == false) goto L6;
        return false;
    L6:
        return super.requestRectangleOnScreen(r100, r101);
    }

    public RemoteImeEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f319522c = "text";
    }

    @Override // android.view.View
    public final void addFocusables(ArrayList<View> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "views");
        if (this.f319523d == false) goto L6;
        super.addFocusables(r100, r101, r102);
        return;
    }

    public final void d(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "inputMode");
        Intrinsics.checkNotNullParameter(r102, "enterKeyHint");
        Locale r103 = Locale.US;
        String r104 = r100.toLowerCase(r103);
        InputMethodManager r105 = null;
        if (f319519g.contains(r104) == true) goto L6;
        r104 = null;
    L6:
        if (r104 != null) goto L8;
        r104 = "text";
    L8:
        int r106 = 2;
        if (r101 == true) goto L11;
    L13:
        if (r101 == false) goto L16;
        int r107 = 129;
    L31:
        String r108 = r102.toLowerCase(r103);
        int r109 = r108.hashCode();
        if (r109 == (-906336856)) goto L52;
        if (r109 == 3304) goto L49;
        if (r109 == 3089282) goto L45;
        if (r109 != 3377907) goto L54;
        if (r108.equals(TeaEventTrack.ACTION_DRAMA_NEXT) == false) goto L54;
        r106 = 5;
    L57:
        int r110 = (268435456 | r106) | 16777216;
        if (Intrinsics.areEqual(this.f319522c, r104) == true) goto L60;
    L64:
        this.f319522c = r104;
        setInputType(r107);
        setImeOptions(r110);
        Object r111 = getContext().getSystemService("input_method");
        if ((r111 instanceof InputMethodManager) == false) goto L67;
        r105 = (InputMethodManager) r111;
    L67:
        if (r105 == null) goto L70;
        r105.restartInput(this);
        return;
    L70:
        return;
    L60:
        if (getInputType() != r107) goto L64;
        if (getImeOptions() != r110) goto L64;
        return;
    L54:
        if (Intrinsics.areEqual(r104, "search") == false) goto L56;
    L55:
        r106 = 3;
        goto L57
    L56:
        r106 = 4;
        goto L57
    L45:
        if (r108.equals("done") == false) goto L54;
        r106 = 6;
        goto L57
    L49:
        if (r108.equals("go") == true) goto L57;
    L52:
        if (r108.equals("search") == true) goto L55;
    L16:
        if (Intrinsics.areEqual(r104, "email") == false) goto L19;
        r107 = 33;
        goto L31
    L19:
        if (Intrinsics.areEqual(r104, "url") == false) goto L22;
        r107 = 17;
        goto L31
    L22:
        if (Intrinsics.areEqual(r104, "tel") == false) goto L25;
        r107 = 3;
        goto L31
    L25:
        if (Intrinsics.areEqual(r104, "numeric") == false) goto L28;
        r107 = 2;
        goto L31
    L28:
        if (Intrinsics.areEqual(r104, "decimal") == false) goto L30;
        r107 = 8194;
        goto L31
    L30:
        r107 = 16385;
        goto L31
    L11:
        if (f319518f.contains(r104) == false) goto L13;
        r107 = 18;
        goto L31
    }

    public /* synthetic */ RemoteImeEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.editTextStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }
}
