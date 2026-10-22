package com.bytedance.ee.bear.doc.codeblock;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00122\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\"H\u0002J \u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/doc/codeblock/CodeBlockViewModel;", "searchEditText", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "textWatcher", "Landroid/text/TextWatcher;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/bytedance/ee/bear/doc/codeblock/CodeLanguageSelectionAdapter;", "noResultsPlaceHolder", "Landroid/widget/TextView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "searchKeyWord", "keyWord", "", "updateNoResultsPlaceHolder", "currentCodeLanguageList", "", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "onBackPressed", "onDestroy", "closeCodeLanguageSelectionPanel", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeLanguageSelectionFragment extends BaseFragment implements l {
    public static final /* synthetic */ int k = 0;
    public CodeBlockViewModel e;
    public SpaceEditText f;
    public d g;
    public RecyclerView h;
    public CodeLanguageSelectionAdapter i;
    public TextView j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CodeLanguageSelectionFragment a;

        public a(CodeLanguageSelectionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CodeLanguageSelectionFragment r3 = this.a;
            int r0 = CodeLanguageSelectionFragment.k;
            r3.closeCodeLanguageSelectionPanel();
        }
    }

    public static final class b implements CodeLanguageSelectionAdapter.a {
        public final /* synthetic */ CodeLanguageSelectionFragment a;

        public b(CodeLanguageSelectionFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.doc.codeblock.CodeLanguageSelectionAdapter.a
        public final void onSelectCodeLanguage(String r2) {
            Intrinsics.checkNotNullParameter(r2, "codeLanguage");
            CodeBlockViewModel r0 = this.a.e;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L5:
            r0.getOnSelectCodeLanguage().setValue(r2);
            this.a.closeCodeLanguageSelectionPanel();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CodeLanguageSelectionFragment a;

        public c(CodeLanguageSelectionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            CodeLanguageData r6 = (CodeLanguageData) r5;
            CodeLanguageSelectionAdapter r0 = this.a.i;
            TextView r2 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r0 = null;
        L5:
            if (r6 == null) goto L7;
            List<String> r3 = r6.getList();
        L8:
            r0.a = r3;
            CodeLanguageSelectionAdapter r1 = this.a.i;
            if (r1 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r1 = null;
        L11:
            if (r6 == null) goto L13;
            String r4 = r6.getValue();
        L14:
            r1.b = r4;
            ViewGroup r7 = this.a.h;
            if (r7 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            r7 = null;
        L17:
            r7.post(new com.bytedance.ee.bear.doc.codeblock.b(this.a, r6));
            CodeLanguageSelectionFragment r8 = this.a;
            if (r6 == null) goto L20;
            List<String> r9 = r6.getList();
        L21:
            TextView r10 = r8.j;
            if (r10 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("noResultsPlaceHolder");
        L25:
            if (r9 != null) goto L27;
        L30:
            int r11 = 0;
        L31:
            r2.setVisibility(r11);
            return;
        L27:
            if (r9.isEmpty() == true) goto L30;
            r11 = 8;
            goto L31
        L24:
            r2 = r10;
            goto L25
        L20:
            r9 = null;
            goto L21
        L13:
            r4 = null;
            goto L14
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ CodeLanguageSelectionFragment a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        public d(CodeLanguageSelectionFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r7) {
            Intrinsics.checkNotNullParameter(r7, "s");
            CodeLanguageSelectionFragment r0 = this.a;
            String r8 = r7.toString();
            CodeBlockViewModel r1 = r0.e;
            TextView r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r1 = null;
        L5:
            CodeLanguageData r3 = (CodeLanguageData) r1.getCodeLanguageData().getValue();
            if (r3 == null) goto L8;
            List<String> r4 = r3.getList();
        L9:
            if (r4 != null) goto L11;
            return;
        L11:
            if (r4.isEmpty() == true) goto L41;
            ArrayList r5 = new ArrayList();
            Iterator<String> r6 = r4.iterator();
        L15:
            if (r6.hasNext() == false) goto L19;
            String r9 = r6.next();
            if (StringsKt.contains(r9, r8, true) == false) goto L15;
            r5.add(r9);
            goto L15
        L19:
            CodeLanguageSelectionAdapter r10 = r0.i;
            if (r10 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r10 = null;
        L22:
            r10.a = r5;
            CodeLanguageSelectionAdapter r11 = r0.i;
            if (r11 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r11 = null;
        L25:
            r11.notifyDataSetChanged();
            TextView r12 = r0.j;
            if (r12 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("noResultsPlaceHolder");
        L30:
            if (r5.isEmpty() == false) goto L32;
            int r13 = 0;
        L33:
            r2.setVisibility(r13);
            return;
        L32:
            r13 = 8;
            goto L33
        L28:
            r2 = r12;
            goto L30
        L41:
            return;
        L8:
            r4 = null;
            goto L9
        }
    }

    public final void closeCodeLanguageSelectionPanel() {
        CodeBlockViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.isShowingCodeLanguageSelectionPanel().setValue(Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        closeCodeLanguageSelectionPanel();
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        closeCodeLanguageSelectionPanel();
    }

    public CodeLanguageSelectionFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.e = (CodeBlockViewModel) q.a(this, CodeBlockViewModel.class);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        r5.findViewById(2131366997).setOnClickListener(new a(this));
        this.j = (TextView) r5.findViewById(2131380960);
        RecyclerView r7 = r5.findViewById(2131385786);
        this.h = r7;
        d r1 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r7 = null;
    L5:
        r7.setLayoutManager(new LinearLayoutManager(getContext()));
        CodeLanguageSelectionAdapter r8 = new CodeLanguageSelectionAdapter();
        this.i = r8;
        r8.c = new b(this);
        RecyclerView r9 = this.h;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r9 = null;
    L8:
        CodeLanguageSelectionAdapter r0 = this.i;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L11:
        r9.setAdapter(r0);
        CodeBlockViewModel r10 = this.e;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L14:
        r10.getCodeLanguageData().observe(this, new c(this));
        View r11 = (SpaceEditText) r5.findViewById(2131385429);
        this.f = r11;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r11 = null;
    L17:
        com.bytedance.ee.util.ui.l.b(r11, 2131108712);
        this.g = new d(this);
        EditText r12 = this.f;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r12 = null;
    L20:
        d r13 = this.g;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
    L24:
        r12.addTextChangedListener(r1);
        return;
    L23:
        r1 = r13;
        goto L24
    }

    public final Animation onCreateAnimation(int r1, boolean r2, int r3) {
        Context r4 = getContext();
        if (r2 == false) goto L5;
        int r5 = 2130771982;
    L7:
        return AnimationUtils.loadAnimation(r4, r5);
    L5:
        r5 = 2130771983;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559842, r3, false);
    }
}
