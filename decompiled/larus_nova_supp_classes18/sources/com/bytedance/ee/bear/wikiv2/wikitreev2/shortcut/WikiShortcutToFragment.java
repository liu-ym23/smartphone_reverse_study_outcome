package com.bytedance.ee.bear.wikiv2.wikitreev2.shortcut;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sq5.n;
import td5.d;
import wq5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/shortcut/WikiShortcutToFragment;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/WikiCreateToFragment;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/makecopy/IWikiMakeCopyDependence;", "<init>", "()V", "wikiOperateButtonFromXml", "Landroid/widget/Button;", "getWikiOperateButtonFromXml", "()Landroid/widget/Button;", "setWikiOperateButtonFromXml", "(Landroid/widget/Button;)V", "wikiTreeCtrlViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "clearFromXmlViewCache", "", "onDestroyView", "command", "Lcom/bytedance/ee/bear/list/selector/ICommand;", "initAction", "onDestroy", "finishWithIntent", "intent", "Landroid/content/Intent;", "getUserComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiShortcutToFragment extends WikiCreateToFragment implements sq5.a {
    public Button w;
    public WikiTreeCtrlView x;
    public d y;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ WikiShortcutToFragment a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SelectorType.values().length];
                r0[SelectorType.WIKI_SHORTCUT_TO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[SelectorType.SPACE_ADD_SHORTCUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public b(WikiShortcutToFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            WikiShortcutToFragment r11 = this.a;
            View r0 = r11.x;
            SelectorConfig r1 = null;
            if (r0 != null) goto L9;
            View r2 = r11.getView();
            if (r2 == null) goto L7;
            r0 = r2.findViewById(2131393267);
        L8:
            r11.x = (WikiTreeCtrlView) r0;
            goto L9
        L7:
            r0 = null;
        L9:
            String r5 = ((WikiTreeCtrlView) r0).getFocusToken();
            tt5.a.h("Wiki_WikiShortcutToFragment", "click confirm, focusToken = " + du5.b.g(r5));
            if (TextUtils.isEmpty(r5) == false) goto L12;
            return;
        L12:
            Bundle r12 = this.a.getArguments();
            if (r12 == null) goto L15;
            r1 = (SelectorConfig) r12.getParcelable("extra_config");
        L15:
            if (r1 == null) goto L36;
            WikiShortcutToFragment r13 = this.a;
            int r3 = a.a[r1.a.ordinal()];
            if (r3 != 1) goto L19;
            Bundle r7 = r13.getArguments();
            WikiTreeActivityContract r4 = r13.Y90();
            Intrinsics.checkNotNullParameter(r13, "fragment");
            Intrinsics.checkNotNullParameter(r4, "contract");
            Intrinsics.checkNotNullParameter(r5, "focusToken");
            boolean r6 = false;
            if (r7 == null) goto L25;
            boolean r8 = r7.getBoolean("src_origin_external");
        L26:
            if (r7 == null) goto L28;
            r6 = r7.getBoolean("src_is_shortcut");
        L28:
            if (r8 == false) goto L33;
            if (r6 == false) goto L33;
            if (r7 == null) goto L32;
            r7.putParcelable("extra_space_bean", n.a(r7, ""));
        L32:
            d r9 = new wq5.a(r13, r4.getSpaceId(), r5, r4.getDocumentName(), r7, r13);
        L34:
            r13.y = r9;
            r9.execute();
            return;
        L33:
            r9 = new j(r13, r4.getSpaceId(), r5, r4.getDocumentName(), r7, r13);
            WikiCreateToFragment.aa0(r13, Integer.valueOf(r4.getSrcObjType()));
            goto L34
        L25:
            r8 = false;
            goto L26
        L19:
            if (r3 != 2) goto L38;
            wq5.a r14 = new wq5.a(r13, r13.Y90().getSpaceId(), r5, r13.Y90().getDocumentName(), r13.getArguments(), r13);
            r13.y = r14;
            r14.execute();
            return;
        L38:
            return;
        }
    }

    static {
    }

    @Override // sq5.a
    public final ce5.a P50() {
        return new ce5.a(this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void initAction() {
        View r1 = this.w;
        if (r1 != null) goto L9;
        View r2 = getView();
        if (r2 == null) goto L7;
        r1 = r2.findViewById(2131393237);
    L8:
        this.w = (Button) r1;
        goto L9
    L7:
        r1 = null;
    L9:
        com.bytedance.ee.bear.wikiv2.wikitreev2.create.b r0 = new com.bytedance.ee.bear.wikiv2.wikitreev2.create.b(this, (Button) r1);
        this.j = r0;
        r0.c = false;
        r0.a(new b(this), null);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void onDestroy() {
        super.onDestroy();
        d r0 = this.y;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.w = null;
        this.x = null;
    }

    public WikiShortcutToFragment() {
    }

    @Override // sq5.a
    public final void ww(Intent r3) {
        tt5.a.h("Wiki_WikiShortcutToFragment", "finishWithIntent()...");
        if (ForsetiHelper.s(this) == false) goto L11;
        g r0 = f.b(this);
        if (r0 == null) goto L15;
        if (r3 == null) goto L9;
        Bundle r4 = r3.getExtras();
        if (r4 == null) goto L9;
    L10:
        r0.c(-1, r4);
        return;
    L9:
        r4 = new Bundle();
        goto L10
    L15:
        return;
    L11:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L17;
        r1.setResult(-1, r3);
        r1.finish();
        return;
    }
}
