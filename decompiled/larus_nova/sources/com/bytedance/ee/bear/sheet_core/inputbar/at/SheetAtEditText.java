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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
public class SheetAtEditText extends AtEditText {
    public pn5.a P1;
    public a Q1;
    public FormulaInputStyleData S1;
    public f T1;
    public b V1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public Drawable f238463b2;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public int f238464g2;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public boolean f238465h2;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public final HashMap<String, Integer> f238466p2;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    private Drawable getCursorDrawable() {
        Drawable r100 = this.f238463b2;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L13;
        this.f238463b2 = N();
    L12:
        return this.f238463b2;
    L13:
        this.f238463b2 = getTextCursorDrawable();     // Catch: Throwable -> L9
    L9:
        this.f238463b2 = N();
        goto L12
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText
    public final void I() {
        a r100 = this.Q1;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        super.I();
    }

    public final void M() {
        if (this.f238465h2 == true) goto L5;
        return;
    L5:
        Drawable r100 = getCursorDrawable();
        if (r100 == null) goto L9;
        r100.clearColorFilter();
        this.f238465h2 = false;
        invalidate();
        return;
    }

    public final Drawable N() {
        String[] r100 = {"mCursorDrawable", "mTextCursorDrawable"};
        int r101 = 0;
    L4:
        if (r101 >= 2) goto L18;
        Field r102 = TextView.class.getDeclaredField(r100[r101]);     // Catch: Throwable -> L20
        r102.setAccessible(true);     // Catch: Throwable -> L20
        Object r103 = r102.get(this);     // Catch: Throwable -> L20
        if ((r103 instanceof Drawable) == false) goto L11;
        return (Drawable) r103;
    L11:
        if ((r103 instanceof Drawable[]) == false) goto L17;
        Drawable[] r104 = (Drawable[]) r103;     // Catch: Throwable -> L20
        if (r104.length <= 0) goto L17;
        Drawable r105 = r104[0];     // Catch: Throwable -> L20
        if (r105 == null) goto L17;
        return r105;
    L17:
        r101 = r101 + 1;
        goto L4
    L18:
        return null;
    }

    public final void P() {
        if (this.S1 != null) goto L6;
        M();
        return;
    L6:
        int r100 = getSelectionStart();
        if (r100 >= 0) goto L10;
        M();
        return;
    L10:
        List<FormulaInputStyleData.ColoredRange> r101 = this.S1.getColoredRanges();
        if (CollectionUtils.isEmpty(r101) == false) goto L14;
        M();
        return;
    L14:
        Iterator<FormulaInputStyleData.ColoredRange> r102 = r101.iterator();
        boolean r103 = false;
        int r104 = 0;
    L16:
        if (r102.hasNext() == false) goto L27;
        FormulaInputStyleData.ColoredRange r105 = r102.next();
        int r106 = r105.getStart();
        int r107 = r105.getEnd();
        if (r100 <= r106) goto L16;
        if (r100 > r107) goto L16;
        Integer r108 = this.f238466p2.get(r105.getColor());
        if (r108 != null) goto L22;
        r104 = Color.parseColor(r105.getColor());     // Catch: IllegalArgumentException -> L26
        this.f238466p2.put(r105.getColor(), Integer.valueOf(r104));     // Catch: IllegalArgumentException -> L26
    L23:
        r103 = true;
        goto L16
    L22:
        r104 = r108.intValue();
        goto L23
    L27:
        if (r103 == true) goto L29;
        M();
        return;
    L29:
        if (this.f238465h2 == true) goto L31;
    L33:
        Drawable r109 = getCursorDrawable();
        if (r109 == null) goto L50;
        r109.setColorFilter(r104, PorterDuff.Mode.SRC_IN);
        this.f238464g2 = r104;
        this.f238465h2 = true;
        invalidate();
        return;
    L50:
        return;
    L31:
        if (this.f238464g2 != r104) goto L33;
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
        i r100 = getPresenter();
        r100.p();
        return Single.just(new g((SpannableStringBuilder) r100.b().getText())).map(new xm5.f());
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getPresenter().getClass();
        f r100 = this.T1;
        if (r100 == null) goto L5;
        removeTextChangedListener(r100);
        this.T1 = null;
    L5:
        this.S1 = null;
        this.f238466p2.clear();
        this.f238463b2 = null;
        this.f238465h2 = false;
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

    public SheetAtEditText(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean A(ClipData r100) {
        boolean r101 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).m(r100, this.f240349p0, new Token("LARK-PSDA-ccm_android_sheet_at_edit_text_selection_copy"));     // Catch: Throwable -> L10
        pn5.a r102 = this.P1;     // Catch: Throwable -> L10
        if (r102 == null) goto L5;
        boolean r103 = ((j) r102).c();     // Catch: Throwable -> L10
    L6:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).j0();     // Catch: Throwable -> L10
        k.a.f499019a.d(r103, true);     // Catch: Throwable -> L10
        return r101;
    L5:
        r103 = false;
    L11:
        return super.A(r100);
    }

    public final void K(FormulaInputStyleData r100) {
        this.S1 = r100;
        this.f238466p2.clear();
        if (this.T1 != null) goto L6;
        f r101 = new f(this);
        this.T1 = r101;
        addTextChangedListener(r101);
    L6:
        Editable r102 = getText();
        if (r102 != null) goto L9;
        return;
    L9:
        L(r102, r100);
        P();
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        int r102 = r100.imeOptions;
        if ((r102 & 255) != 5) goto L5;
        r100.imeOptions = r102 & (-1073741825);
    L5:
        return r101;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r110) {
        if (r110 != 16908321) goto L5;
    L6:
        pn5.a r100 = this.P1;
        if (r100 == null) goto L55;
        j r101 = (j) r100;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        e r102 = e.a.f499003a;
        boolean r103 = false;
        if (r102.g() == false) goto L14;
        PermissionResponse r104 = r101.a(false);
        r104.getCallback().a(eu5.b.f474075a, r104);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.d(r104) == true) goto L52;
    L28:
        DocViewModel r105 = r101.f529975a;
        if (r105 == null) goto L40;
        DocumentInfo r106 = r105.getDocumentInfoData();
        BlockInfo r107 = r101.f529975a.getCurrentRefBlockInfo();
        if (r106 == null) goto L39;
        if (r107 == null) goto L39;
        if (r101.f529976b == false) goto L39;
        tt5.a.h("SheetPermDelegate", "canUserCopy use curRefBlockInfo");
        IDocUserPermission r108 = r106.getDocPermissionByToken(r107.getToken());
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (r102.g() == false) goto L38;
        boolean r109 = f35.b.b(r108).getAllow();
    L41:
        if (r109 == true) goto L51;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (r102.g() == false) goto L47;
        PermissionResponse r111 = r101.a(true);
        PermissionResponse.Companion.getClass();
        if (PermissionResponse.a.f(r111) == false) goto L47;
        r111.getCallback().a(eu5.b.f474075a, r111);
        boolean r112 = true;
    L48:
        if (r112 == true) goto L52;
        Toast.showFailureText(eu5.b.f474075a, R.string.Doc_Comment_CopyFailed);
    L47:
        r112 = false;
        goto L48
    L51:
        r103 = true;
        goto L52
    L38:
        r109 = r108.canCopy();
    L39:
        r109 = r101.f529975a.canCopy();
        goto L41
    L40:
        r109 = false;
    L52:
        if (r103 == true) goto L55;
        return true;
    L14:
        if (r101.f529975a == null) goto L22;
        gj5.b r113 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r114 = FileBizDomain.FileBizDomainCCM;
        c r115 = r113.g("CCM_CONTENT_COPY", r114, 3, r101.f529975a.getToken());
        if (r115.f481503a == false) goto L18;
    L21:
        boolean r116 = r115.f481503a;
    L23:
        if (r116 == false) goto L52;
        if (TextUtils.isEmpty(r101.b()) == true) goto L28;
        Toast.showFailureText(eu5.b.f474075a, r101.b());
        goto L52
    L18:
        if (r115.f481504b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L20;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_CONTENT_COPY", r114, 3, r101.f529975a.getToken());
        goto L21
    L20:
        Toast.showFailureText(eu5.b.f474075a, R.string.CreationMobile_ECM_AdminDisableToast);
        goto L21
    L22:
        r116 = true;
    L55:
        return super.onTextContextMenuItem(r110);
    L5:
        if (r110 != 16908320) goto L55;
        goto L6
    }

    public void setAtWindowShowCallback(a r100) {
        this.Q1 = r100;
    }

    public void setCellStyle(SegmentStyle r100) {
        i r101 = getPresenter();
        r101.f529972l = r100;
        r101.f529970j.f529965b = r100;
        r101.f529971k.f564542e = r100;
    }

    @Override // android.widget.TextView
    public void setCursorVisible(boolean r100) {
        super.setCursorVisible(r100);
        if (r100 == false) goto L6;
        P();
        return;
    }

    public void setIPermissionCopyChecker(pn5.a r100) {
        this.P1 = r100;
    }

    public void setSelectionChangeListener(b r100) {
        this.V1 = r100;
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean y(boolean r100) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == true) goto L5;
        return true;
    L5:
        if (r100 == false) goto L11;
        pn5.a r101 = this.P1;
        if (r101 != null) goto L9;
        return true;
    L9:
        if (((j) r101).a(true).getAllow() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public SheetAtEditText(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.editTextStyle);
    }

    public static void L(Editable r100, FormulaInputStyleData r101) {
        FormulaColorSpan[] r102 = (FormulaColorSpan[]) r100.getSpans(0, r100.length(), FormulaColorSpan.class);
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.removeSpan(r102[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        int r105 = r100.length();
        if (r105 != 0) goto L10;
        return;
    L10:
        List<FormulaInputStyleData.ColoredRange> r106 = r101.getColoredRanges();
        if (r106 == null) goto L21;
        Iterator<FormulaInputStyleData.ColoredRange> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L31;
        FormulaInputStyleData.ColoredRange r108 = r107.next();
        int r109 = Math.max(0, r108.getStart());
        int r110 = Math.min(r105, r108.getEnd());
        if (r110 <= r109) goto L14;
        r100.setSpan(new FormulaColorSpan(Color.parseColor(r108.getColor())), r109, r110, 33);
        goto L14
    L31:
        return;
    }

    public final void O(List<BaseSegment> r100, Consumer<? super Throwable> r101) {
        final i r102 = getPresenter();
        r102.getClass();
        Flowable.just(r100).map(new xm5.b()).map(r102.f529971k).observeOn(d.d()).subscribe(new h(r102), r101);
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText, android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        b r102 = this.V1;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        P();
    }

    public SheetAtEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f238464g2 = 0;
        this.f238465h2 = false;
        this.f238466p2 = new HashMap();
        setOnPasteListener(getPresenter());
        setFilters(new InputFilter[]{getPresenter().f529970j});
        setCopyAtMentionEnable(true);
    }
}
