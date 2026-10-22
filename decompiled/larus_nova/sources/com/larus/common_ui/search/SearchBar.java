package com.larus.common_ui.search;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.utils.x1;
import com.larus.common_res.common_ui.databinding.LarusViewSearchBarBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 02\u00020\u0001:\u00010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\rJ\u0019\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0006\u0010-\u001a\u00020\u001cJ\u0006\u0010.\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020\u001cR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u00061"}, d2 = {"Lcom/larus/common_ui/search/SearchBar;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusViewSearchBarBinding;", "style", "", "customHintText", "", "lastValue", "_inputText", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "inputTextFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getInputTextFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_searchTextFlow", "searchTextFlow", "getSearchTextFlow", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "customCancelClickAction", "Lkotlin/Function0;", "", "getCustomCancelClickAction", "()Lkotlin/jvm/functions/Function0;", "setCustomCancelClickAction", "(Lkotlin/jvm/functions/Function0;)V", "clearClickListener", "getClearClickListener", "setClearClickListener", "setHint", "text", "setText", "setTextNoSearch", "initAttr", "(Landroid/util/AttributeSet;)Lkotlin/Unit;", "initView", "changeStyle", "initAction", "requestShowIme", "requestHideIme", "showBackIcon", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchBar extends RelativeLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f327804l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusViewSearchBarBinding f327805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f327806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f327807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f327808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow<String> f327809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableSharedFlow f327810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableSharedFlow<String> f327811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableSharedFlow f327812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x1 f327813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f327814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f327815k;

    public static final class a {
    }

    static {
    }

    public final void a() {
        x1 r100 = this.f327813i;
        if (r100 == null) goto L5;
        Set<String> r101 = x1.f315147d;
        r100.a(false);
    L5:
        LarusViewSearchBarBinding r102 = this.f327805a;
        if (r102 == null) goto L11;
        EditText r103 = r102.f326829f;
        if (r103 == null) goto L12;
        r103.clearFocus();
        return;
    L12:
        return;
    }

    public final void b() {
        LarusViewSearchBarBinding r100 = this.f327805a;
        if (r100 == null) goto L7;
        EditText r101 = r100.f326829f;
        if (r101 == null) goto L7;
        r101.postDelayed(new f(this), 200);
    L7:
        LarusViewSearchBarBinding r102 = this.f327805a;
        if (r102 == null) goto L13;
        EditText r103 = r102.f326829f;
        if (r103 == null) goto L14;
        r103.requestFocus();
        return;
    L14:
        return;
    }

    public final Function0<Unit> getClearClickListener() {
        return this.f327815k;
    }

    public final Function0<Unit> getCustomCancelClickAction() {
        return this.f327814j;
    }

    public final d1<String> getInputTextFlow() {
        return this.f327810f;
    }

    public final d1<String> getSearchTextFlow() {
        return this.f327812h;
    }

    public SearchBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setClearClickListener(Function0<Unit> r100) {
        this.f327815k = r100;
    }

    public final void setCustomCancelClickAction(Function0<Unit> r100) {
        this.f327814j = r100;
    }

    public final void setHint(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        LarusViewSearchBarBinding r101 = this.f327805a;
        if (r101 == null) goto L8;
        EditText r102 = r101.f326829f;
        if (r102 == null) goto L9;
        r102.setHint(r100);
        return;
    L9:
        return;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        LarusViewSearchBarBinding r101 = this.f327805a;
        if (r101 == null) goto L7;
        EditText r102 = r101.f326829f;
        if (r102 == null) goto L7;
        r102.setText(r100);
    L7:
        LarusViewSearchBarBinding r103 = this.f327805a;
        if (r103 == null) goto L13;
        EditText r104 = r103.f326829f;
        if (r104 == null) goto L14;
        r104.setSelection(r100.length());
        return;
    L14:
        return;
    }

    public final void setTextNoSearch(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f327808d = r100;
        setText(r100);
    }

    public SearchBar(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        x1 r100 = null;
        MutableSharedFlow<String> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f327809e = r101;
        this.f327810f = r101;
        MutableSharedFlow<String> r102 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f327811g = r102;
        this.f327812h = r102;
        if (r111 == null) goto L5;
        TypedArray r112 = getContext().obtainStyledAttributes(r111, new int[]{R.attr.larus_hint_text, R.attr.larus_style});
        this.f327806b = r112.getInt(1, 0);
        this.f327807c = r112.getString(0);
        r112.recycle();
        Unit r113 = Unit.INSTANCE;
    L5:
        View r114 = RelativeLayout.inflate(getContext(), R.layout.larus_view_search_bar, this);
        int r103 = R.id.search_back;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r114, R.id.search_back);
        if (r104 == null) goto L105;
        r103 = R.id.search_cancel;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r114, R.id.search_cancel);
        if (r105 == null) goto L105;
        r103 = R.id.search_clear;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r114, R.id.search_clear);
        if (r106 == null) goto L105;
        r103 = R.id.search_icon;
        AppCompatImageView r115 = (AppCompatImageView) ViewBindings.findChildViewById(r114, R.id.search_icon);
        if (r115 == null) goto L105;
        r103 = R.id.search_input;
        EditText r116 = (EditText) ViewBindings.findChildViewById(r114, R.id.search_input);
        if (r116 == null) goto L105;
        r103 = R.id.search_input_root;
        LinearLayout r107 = (LinearLayout) ViewBindings.findChildViewById(r114, R.id.search_input_root);
        if (r107 == null) goto L105;
        this.f327805a = new LarusViewSearchBarBinding((RelativeLayout) r114, r104, r105, r106, r115, r116, r107);
        e1.t(r107, c7.b(Float.valueOf(16.0f)), v19.c.b(R.attr.larus_base_2_overlay, null, R.color.larus_base_2_overlay));
        int r117 = this.f327806b;
        this.f327806b = r117;
        if (r117 == 0) goto L31;
        if (r117 != 1) goto L51;
        LarusViewSearchBarBinding r118 = this.f327805a;
        if (r118 == null) goto L26;
        TextView r119 = r118.f326826c;
        if (r119 == null) goto L26;
        r119.setVisibility(0);
    L26:
        LarusViewSearchBarBinding r120 = this.f327805a;
        if (r120 == null) goto L51;
        EditText r121 = r120.f326829f;
        if (r121 == null) goto L51;
        r121.setInputType(1);
    L51:
        String r122 = this.f327807c;
        if (r122 == null) goto L58;
        LarusViewSearchBarBinding r108 = this.f327805a;
        if (r108 == null) goto L58;
        EditText r109 = r108.f326829f;
        if (r109 == null) goto L58;
        r109.setHint(r122);
    L58:
        LarusViewSearchBarBinding r123 = this.f327805a;
        if (r123 == null) goto L63;
        AppCompatImageView r124 = r123.f326825b;
        if (r124 == null) goto L63;
        e1.d(r124, new com.larus.common_ui.search.a(this));
    L63:
        LarusViewSearchBarBinding r125 = this.f327805a;
        if (r125 == null) goto L68;
        TextView r126 = r125.f326826c;
        if (r126 == null) goto L68;
        e1.d(r126, new b(this));
    L68:
        LarusViewSearchBarBinding r127 = this.f327805a;
        if (r127 == null) goto L73;
        AppCompatImageView r128 = r127.f326827d;
        if (r128 == null) goto L73;
        e1.d(r128, new c(this));
    L73:
        LarusViewSearchBarBinding r129 = this.f327805a;
        if (r129 == null) goto L78;
        EditText r130 = r129.f326829f;
        if (r130 == null) goto L78;
        r130.setOnKeyListener(new d(this));
    L78:
        LarusViewSearchBarBinding r131 = this.f327805a;
        if (r131 == null) goto L83;
        EditText r132 = r131.f326829f;
        if (r132 == null) goto L83;
        r132.addTextChangedListener(new SearchBar$initAction$5(this));
    L83:
        View[] r133 = new View[2];
        LarusViewSearchBarBinding r134 = this.f327805a;
        if (r134 == null) goto L86;
        EditText r135 = r134.f326829f;
    L87:
        r133[0] = r135;
        if (r134 == null) goto L90;
        AppCompatImageView r136 = r134.f326828e;
    L91:
        r133[1] = r136;
        Iterator r137 = CollectionsKt.listOf(r133).iterator();
    L93:
        if (r137.hasNext() == false) goto L97;
        View r138 = (View) r137.next();
        if (r138 == null) goto L93;
        r138.setOnClickListener(new e(this));
        goto L93
    L97:
        LarusViewSearchBarBinding r139 = this.f327805a;
        if (r139 == null) goto L102;
        EditText r140 = r139.f326829f;
        if (r140 == null) goto L102;
        r100 = new x1(r140);
    L102:
        this.f327813i = r100;
        return;
    L90:
        r136 = null;
        goto L91
    L86:
        r135 = null;
        goto L87
    L31:
        LarusViewSearchBarBinding r141 = this.f327805a;
        if (r141 == null) goto L36;
        TextView r142 = r141.f326826c;
        if (r142 == null) goto L36;
        r142.setVisibility(8);
    L36:
        LarusViewSearchBarBinding r143 = this.f327805a;
        if (r143 == null) goto L41;
        EditText r144 = r143.f326829f;
        if (r144 == null) goto L41;
        r144.setInputType(0);
    L41:
        LarusViewSearchBarBinding r145 = this.f327805a;
        if (r145 == null) goto L46;
        EditText r146 = r145.f326829f;
        if (r146 == null) goto L46;
        r146.setFocusable(false);
    L46:
        LarusViewSearchBarBinding r147 = this.f327805a;
        if (r147 == null) goto L51;
        EditText r148 = r147.f326829f;
        if (r148 == null) goto L51;
        r148.setFocusableInTouchMode(false);
    L105:
        throw new NullPointerException("Missing required view with ID: ".concat(r114.getResources().getResourceName(r103)));
    }
}
