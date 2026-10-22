package com.bytedance.ee.bear.sheet_core.inputbar.at;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.documentinfo.BlockInfo;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.bear.sheet_core.inputbar.at.span.FormulaColorSpan;
import com.bytedance.ee.bear.widget.AtEditText;
import com.bytedance.ee.bear.widget.l;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import db5.g;
import fo5.d;
import gj5.c;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jg5.e;
import jg5.k;
import pn5.f;
import pn5.h;
import pn5.i;
import pn5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetAtEditText extends AtEditText {
    public pn5.a P1;
    public a Q1;
    public FormulaInputStyleData S1;
    public f T1;
    public b V1;
    public Drawable b2;
    public int g2;
    public boolean h2;
    public final HashMap<String, Integer> p2;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable getCursorDrawable() {
        Drawable r0 = this.b2;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L13;
        this.b2 = N();
    L12:
        return this.b2;
    L13:
        this.b2 = getTextCursorDrawable();     // Catch: Throwable -> L9
    L9:
        this.b2 = N();
        goto L12
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText
    public final void I() {
        a r0 = this.Q1;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        super.I();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M() {
        if (this.h2 == true) goto L5;
        return;
    L5:
        Drawable r0 = getCursorDrawable();
        if (r0 == null) goto L9;
        r0.clearColorFilter();
        this.h2 = false;
        invalidate();
        return;
    }

    public final Drawable N() {
        String[] r0 = {"mCursorDrawable", "mTextCursorDrawable"};
        int r2 = 0;
    L4:
        if (r2 >= 2) goto L18;
        Field r3 = TextView.class.getDeclaredField(r0[r2]);     // Catch: Throwable -> L20
        r3.setAccessible(true);     // Catch: Throwable -> L20
        Object r4 = r3.get(this);     // Catch: Throwable -> L20
        if ((r4 instanceof Drawable) == false) goto L11;
        return (Drawable) r4;
    L11:
        if ((r4 instanceof Drawable[]) == false) goto L17;
        Drawable[] r5 = (Drawable[]) r4;     // Catch: Throwable -> L20
        if (r5.length <= 0) goto L17;
        Drawable r6 = r5[0];     // Catch: Throwable -> L20
        if (r6 == null) goto L17;
        return r6;
    L17:
        r2 = r2 + 1;
        goto L4
    L18:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P() {
        if (this.S1 != null) goto L6;
        M();
        return;
    L6:
        int r0 = getSelectionStart();
        if (r0 >= 0) goto L10;
        M();
        return;
    L10:
        List<FormulaInputStyleData.ColoredRange> r1 = this.S1.getColoredRanges();
        if (CollectionUtils.isEmpty(r1) == false) goto L14;
        M();
        return;
    L14:
        Iterator<FormulaInputStyleData.ColoredRange> r2 = r1.iterator();
        boolean r3 = false;
        int r4 = 0;
    L16:
        if (r2.hasNext() == false) goto L27;
        FormulaInputStyleData.ColoredRange r5 = r2.next();
        int r6 = r5.getStart();
        int r7 = r5.getEnd();
        if (r0 <= r6) goto L16;
        if (r0 > r7) goto L16;
        Integer r8 = this.p2.get(r5.getColor());
        if (r8 != null) goto L22;
        r4 = Color.parseColor(r5.getColor());     // Catch: IllegalArgumentException -> L26
        this.p2.put(r5.getColor(), Integer.valueOf(r4));     // Catch: IllegalArgumentException -> L26
    L23:
        r3 = true;
        goto L16
    L22:
        r4 = r8.intValue();
        goto L23
    L27:
        if (r3 == true) goto L29;
        M();
        return;
    L29:
        if (this.h2 == true) goto L31;
    L33:
        Drawable r9 = getCursorDrawable();
        if (r9 == null) goto L50;
        r9.setColorFilter(r4, PorterDuff.Mode.SRC_IN);
        this.g2 = r4;
        this.h2 = true;
        invalidate();
        return;
    L50:
        return;
    L31:
        if (this.g2 != r4) goto L33;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText
    public i getPresenter() {
        if (this.V0 != null) goto L6;
        this.V0 = new i(this);
    L6:
        return (i) this.V0;
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public ClipData getPrimaryClip() {
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).l(new Token("LARK-PSDA-ccm_android_sheet_at_edit_text_selection_paste"));
    }

    public Single<List<BaseSegment>> getSegments() {
        i r0 = getPresenter();
        r0.p();
        return Single.just(new g((SpannableStringBuilder) ((AtEditText) r0.b()).getText())).map(new xm5.f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.EditText*/.onDetachedFromWindow();
        getPresenter().getClass();
        f r0 = this.T1;
        if (r0 == null) goto L5;
        removeTextChangedListener(r0);
        this.T1 = null;
    L5:
        this.S1 = null;
        this.p2.clear();
        this.b2 = null;
        this.h2 = false;
    }

    public a getAtWindowShowCallback() {
        return this.Q1;
    }

    public FormulaInputStyleData getPendingFormulaStyle() {
        return this.S1;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText
    public /* bridge */ /* synthetic */ l getPresenter() {
        return getPresenter();
    }

    public SheetAtEditText(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean A(ClipData r5) {
        boolean r0 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).m(r5, this.p0, new Token("LARK-PSDA-ccm_android_sheet_at_edit_text_selection_copy"));     // Catch: Throwable -> L10
        pn5.a r1 = this.P1;     // Catch: Throwable -> L10
        if (r1 == null) goto L5;
        boolean r2 = ((j) r1).c();     // Catch: Throwable -> L10
    L6:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();     // Catch: Throwable -> L10
        k.a.a.d(r2, true);     // Catch: Throwable -> L10
        return r0;
    L5:
        r2 = false;
    L11:
        return super.A(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K(FormulaInputStyleData r2) {
        this.S1 = r2;
        this.p2.clear();
        if (this.T1 != null) goto L6;
        f r0 = new f(this);
        this.T1 = r0;
        addTextChangedListener(r0);
    L6:
        Editable r1 = getText();
        if (r1 != null) goto L9;
        return;
    L9:
        L(r1, r2);
        P();
    }

    public final InputConnection onCreateInputConnection(EditorInfo r5) {
        InputConnection r0 = super/*androidx.appcompat.widget.AppCompatEditText*/.onCreateInputConnection(r5);
        int r1 = r5.imeOptions;
        if ((r1 & 255) != 5) goto L5;
        r5.imeOptions = r1 & (-1073741825);
    L5:
        return r0;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean onTextContextMenuItem(int r11) {
        if (r11 != 16908321) goto L5;
    L6:
        pn5.a r0 = this.P1;
        if (r0 == null) goto L55;
        j r1 = (j) r0;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        e r2 = e.a.a;
        boolean r3 = false;
        if (r2.g() == false) goto L14;
        PermissionResponse r4 = r1.a(false);
        r4.getCallback().a(eu5.b.a, r4);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r4) == true) goto L52;
    L28:
        DocViewModel r5 = r1.a;
        if (r5 == null) goto L40;
        DocumentInfo r6 = r5.getDocumentInfoData();
        BlockInfo r7 = r1.a.getCurrentRefBlockInfo();
        if (r6 == null) goto L39;
        if (r7 == null) goto L39;
        if (r1.b == false) goto L39;
        tt5.a.h("SheetPermDelegate", "canUserCopy use curRefBlockInfo");
        IDocUserPermission r8 = r6.getDocPermissionByToken(r7.getToken());
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (r2.g() == false) goto L38;
        boolean r9 = f35.b.b(r8).getAllow();
    L41:
        if (r9 == true) goto L51;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (r2.g() == false) goto L47;
        PermissionResponse r10 = r1.a(true);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.f(r10) == false) goto L47;
        r10.getCallback().a(eu5.b.a, r10);
        boolean r12 = true;
    L48:
        if (r12 == true) goto L52;
        Toast.showFailureText(eu5.b.a, 2131887613);
    L47:
        r12 = false;
        goto L48
    L51:
        r3 = true;
        goto L52
    L38:
        r9 = r8.canCopy();
    L39:
        r9 = r1.a.canCopy();
        goto L41
    L40:
        r9 = false;
    L52:
        if (r3 == true) goto L55;
        return true;
    L14:
        if (r1.a == null) goto L22;
        gj5.b r13 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r14 = FileBizDomain.FileBizDomainCCM;
        c r15 = r13.g("CCM_CONTENT_COPY", r14, 3, r1.a.getToken());
        if (r15.a == false) goto L18;
    L21:
        boolean r16 = r15.a;
    L23:
        if (r16 == false) goto L52;
        if (TextUtils.isEmpty(r1.b()) == true) goto L28;
        Toast.showFailureText(eu5.b.a, r1.b());
        goto L52
    L18:
        if (r15.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L20;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_CONTENT_COPY", r14, 3, r1.a.getToken());
        goto L21
    L20:
        Toast.showFailureText(eu5.b.a, 2131887246);
        goto L21
    L22:
        r16 = true;
    L55:
        return super.onTextContextMenuItem(r11);
    L5:
        if (r11 != 16908320) goto L55;
        goto L6
    }

    public void setAtWindowShowCallback(a r1) {
        this.Q1 = r1;
    }

    public void setCellStyle(SegmentStyle r3) {
        i r0 = getPresenter();
        r0.l = r3;
        r0.j.b = r3;
        r0.k.e = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCursorVisible(boolean r1) {
        super/*android.widget.EditText*/.setCursorVisible(r1);
        if (r1 == false) goto L6;
        P();
        return;
    }

    public void setIPermissionCopyChecker(pn5.a r1) {
        this.P1 = r1;
    }

    public void setSelectionChangeListener(b r1) {
        this.V1 = r1;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean y(boolean r3) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == true) goto L5;
        return true;
    L5:
        if (r3 == false) goto L11;
        pn5.a r4 = this.P1;
        if (r4 != null) goto L9;
        return true;
    L9:
        if (((j) r4).a(true).getAllow() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public SheetAtEditText(Context r2, AttributeSet r3) {
        this(r2, r3, 2130969939);
    }

    public static void L(Editable r6, FormulaInputStyleData r7) {
        FormulaColorSpan[] r0 = (FormulaColorSpan[]) r6.getSpans(0, r6.length(), FormulaColorSpan.class);
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r6.removeSpan(r0[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        if (r7 != null) goto L7;
        return;
    L7:
        int r2 = r6.length();
        if (r2 != 0) goto L10;
        return;
    L10:
        List<FormulaInputStyleData.ColoredRange> r8 = r7.getColoredRanges();
        if (r8 == null) goto L21;
        Iterator<FormulaInputStyleData.ColoredRange> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L31;
        FormulaInputStyleData.ColoredRange r4 = r9.next();
        int r5 = Math.max(0, r4.getStart());
        int r10 = Math.min(r2, r4.getEnd());
        if (r10 <= r5) goto L14;
        r6.setSpan(new FormulaColorSpan(Color.parseColor(r4.getColor())), r5, r10, 33);
        goto L14
    L31:
        return;
    }

    public final void O(List<BaseSegment> r3, Consumer<? super Throwable> r4) {
        final i r0 = getPresenter();
        r0.getClass();
        Flowable.just(r3).map(new xm5.b()).map(r0.k).observeOn(d.d()).subscribe(new h(r0), r4);
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText
    public final void onSelectionChanged(int r1, int r2) {
        super.onSelectionChanged(r1, r2);
        b r3 = this.V1;
        if (r3 == null) goto L5;
        r3.a();
    L5:
        P();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SheetAtEditText(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.g2 = 0;
        this.h2 = false;
        this.p2 = new HashMap();
        setOnPasteListener(getPresenter());
        setFilters(new InputFilter[]{getPresenter().j});
        setCopyAtMentionEnable(true);
    }
}
