package com.bytedance.ee.docsdk.impl.document.plugins.codeblock;

import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.block.codeblock.CodeBlockViewModel;
import com.bytedance.ee.docsdk.impl.utils.TintUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginViewModelProviders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\u001a\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u00102\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/bytedance/ee/docsdk/impl/document/plugins/codeblock/CodeLanguageSelectionAdapter;", "noResultsPlaceHolder", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "searchEditText", "Landroid/widget/EditText;", "textWatcher", "Landroid/text/TextWatcher;", "viewModel", "Lcom/bytedance/ee/bear/block/codeblock/CodeBlockViewModel;", "closeCodeLanguageSelectionPanel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "", "nextAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", "view", "searchKeyWord", "keyWord", "", "updateNoResultsPlaceHolder", "currentCodeLanguageList", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CodeLanguageSelectionFragment extends Fragment {
    private CodeLanguageSelectionAdapter adapter;
    private TextView noResultsPlaceHolder;
    private RecyclerView recyclerView;
    private EditText searchEditText;
    private TextWatcher textWatcher;
    private CodeBlockViewModel viewModel;

    public static /* synthetic */ void S90(CodeLanguageSelectionFragment r0, CodeLanguageData r1) {
        onViewCreated$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ void T90(CodeLanguageSelectionFragment r0, View r1) {
        onViewCreated$lambda$0(r0, r1);
    }

    public static /* synthetic */ void U90(CodeLanguageSelectionFragment r0, CodeLanguageData r1) {
        onViewCreated$lambda$2(r0, r1);
    }

    private final void closeCodeLanguageSelectionPanel() {
        CodeBlockViewModel r0 = this.viewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.isShowingCodeLanguageSelectionPanel().setValue(Boolean.FALSE);
    }

    public void onDestroy() {
        super.onDestroy();
        closeCodeLanguageSelectionPanel();
    }

    public CodeLanguageSelectionFragment() {
    }

    public static final /* synthetic */ void access$closeCodeLanguageSelectionPanel(CodeLanguageSelectionFragment r0) {
        r0.closeCodeLanguageSelectionPanel();
    }

    public static final /* synthetic */ CodeBlockViewModel access$getViewModel$p(CodeLanguageSelectionFragment r0) {
        return r0.viewModel;
    }

    private final void searchKeyWord(String r6) {
        CodeBlockViewModel r0 = this.viewModel;
        CodeLanguageSelectionAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        CodeLanguageData r2 = (CodeLanguageData) r0.getCodeLanguageData().getValue();
        if (r2 == null) goto L8;
        List<String> r3 = r2.getList();
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.isEmpty() == true) goto L34;
        ArrayList r4 = new ArrayList();
        Iterator<String> r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        String r7 = r5.next();
        if (StringsKt.contains(r7, r6, true) == false) goto L15;
        r4.add(r7);
        goto L15
    L19:
        CodeLanguageSelectionAdapter r8 = this.adapter;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r8 = null;
    L22:
        r8.setCodeLanguageList(r4);
        CodeLanguageSelectionAdapter r9 = this.adapter;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L26:
        r1.notifyDataSetChanged();
        updateNoResultsPlaceHolder(r4);
        return;
    L25:
        r1 = r9;
        goto L26
    L34:
        return;
    L8:
        r3 = null;
        goto L9
    }

    private final void updateNoResultsPlaceHolder(List<String> r2) {
        TextView r0 = this.noResultsPlaceHolder;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("noResultsPlaceHolder");
        r0 = null;
    L5:
        if (r2 != null) goto L7;
    L10:
        int r3 = 0;
    L11:
        r0.setVisibility(r3);
        return;
    L7:
        if (r2.isEmpty() == true) goto L10;
        r3 = 8;
        goto L11
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.viewModel = PluginViewModelProviders.viewModel(this, CodeBlockViewModel.class);
    }

    public static final /* synthetic */ void access$searchKeyWord(CodeLanguageSelectionFragment r0, String r1) {
        r0.searchKeyWord(r1);
    }

    private static final void onViewCreated$lambda$0(CodeLanguageSelectionFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.closeCodeLanguageSelectionPanel();
    }

    private static final void onViewCreated$lambda$2(final CodeLanguageSelectionFragment r4, final CodeLanguageData r5) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        CodeLanguageSelectionAdapter r0 = r4.adapter;
        List<String> r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        if (r5 == null) goto L7;
        List<String> r3 = r5.getList();
    L8:
        r0.setCodeLanguageList(r3);
        CodeLanguageSelectionAdapter r1 = r4.adapter;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L11:
        if (r5 == null) goto L13;
        String r6 = r5.getValue();
    L14:
        r1.setSelectedCodeLanguage(r6);
        ViewGroup r7 = r4.recyclerView;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r7 = null;
    L17:
        r7.post(new c(r4, r5));
        if (r5 == null) goto L20;
        r2 = r5.getList();
    L20:
        r4.updateNoResultsPlaceHolder(r2);
        return;
    L13:
        r6 = null;
        goto L14
    L7:
        r3 = null;
        goto L8
    }

    private static final void onViewCreated$lambda$2$lambda$1(CodeLanguageSelectionFragment r3, CodeLanguageData r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        RecyclerView r0 = r3.recyclerView;
        LinearLayoutManager r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r0 = null;
    L5:
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L8;
        r1 = (LinearLayoutManager) r2;
    L8:
        if (r1 == null) goto L16;
        if (r4 == null) goto L13;
        List<String> r5 = r4.getList();
        if (r5 == null) goto L13;
        int r6 = CollectionsKt.indexOf(r5, r4.getValue());
    L14:
        r1.scrollToPositionWithOffset(r6, r3.getResources().getDimensionPixelSize(2131165643) * 2);
        return;
    L13:
        r6 = 0;
        goto L14
    }

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        r5.findViewById(2131366997).setOnClickListener(new d(this));
        this.noResultsPlaceHolder = (TextView) r5.findViewById(2131380960);
        RecyclerView r7 = r5.findViewById(2131385786);
        this.recyclerView = r7;
        TextWatcher r1 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r7 = null;
    L5:
        r7.setLayoutManager(new LinearLayoutManager(getContext()));
        CodeLanguageSelectionAdapter r8 = new CodeLanguageSelectionAdapter();
        this.adapter = r8;
        r8.setSelectedChangeListener(new AnonymousClass2(this));
        RecyclerView r9 = this.recyclerView;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r9 = null;
    L8:
        CodeLanguageSelectionAdapter r0 = this.adapter;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L11:
        r9.setAdapter(r0);
        CodeBlockViewModel r10 = this.viewModel;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L14:
        r10.getCodeLanguageData().observe(getViewLifecycleOwner(), new e(this));
        EditText r11 = (EditText) r5.findViewById(2131385429);
        this.searchEditText = r11;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r11 = null;
    L17:
        TintUtils.updateBackgroundTint(r11, 2131108712);
        this.textWatcher = new AnonymousClass4(this);
        EditText r12 = this.searchEditText;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r12 = null;
    L20:
        TextWatcher r13 = this.textWatcher;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
    L24:
        r12.addTextChangedListener(r1);
        return;
    L23:
        r1 = r13;
        goto L24
    }

    public Animation onCreateAnimation(int r1, boolean r2, int r3) {
        Context r4 = getContext();
        if (r2 == false) goto L5;
        int r5 = 2130771982;
    L7:
        return AnimationUtils.loadAnimation(r4, r5);
    L5:
        r5 = 2130771983;
        goto L7
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559842, r3, false);
    }
}
