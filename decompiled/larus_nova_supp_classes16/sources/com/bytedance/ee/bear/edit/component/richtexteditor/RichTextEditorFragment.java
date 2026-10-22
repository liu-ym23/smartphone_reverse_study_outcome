package com.bytedance.ee.bear.edit.component.richtexteditor;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.edit.component.RichTextEditorViewModel;
import kotlin.jvm.internal.Intrinsics;
import oa5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class RichTextEditorFragment extends WebFragment {
    public String j;

    public abstract BaseEditor.a Z90();

    public abstract BaseEditor aa0();

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final TitleBar X90() {
        tt5.a.d("RichTextEditorFragment", "onCreateTitleBar return null!");
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final o getPluginListProvider() {
        tt5.a.d("RichTextEditorFragment", "getPluginListProvider return null!");
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.webkit.WebView, com.bytedance.ee.bear.edit.component.richtexteditor.RichTextEditorWebView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final WebPluginHost W90() {
        BaseEditor r0 = aa0();
        if (r0.b != null) goto L6;
        ?? r1 = r0.a();
        r0.b = r1;
        r1.getSettings().setJavaScriptEnabled(true);
        r0.b.setWebViewClient(r0.b());
        r0.a = r0.b.getBridge();
    L6:
        return new WebPluginHost(new d(r0.b, r0.a));
    }

    public RichTextEditorFragment() {
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r3) {
        Z90();
        super.onCreate(r3);
        RichTextEditorViewModel r4 = (RichTextEditorViewModel) q.c(this.e, RichTextEditorViewModel.class, null);
        if (getArguments() != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(getArguments().getString("wiki_announce_url")) == true) goto L9;
        this.j = getArguments().getString("wiki_announce_url");
        r4.setRichTextContent(getArguments().getString("rich_text_content"));
        return;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (TextUtils.isEmpty(this.j) == true) goto L6;
        BaseEditor r3 = aa0();
        String r4 = this.j;
        r3.b.loadUrl(r4);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        ViewGroup r5 = (ViewGroup) r2.inflate(2131564285, r3, false);
        ViewGroup.LayoutParams r6 = new ConstraintLayout.LayoutParams(-1, -1);
        r5.addView(aa0().a(), 0, r6);
        at5.a r7 = aa0().a;
        oa5.a r8 = new oa5.a();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "value");
        r7.i = r8;
        return r5;
    }
}
