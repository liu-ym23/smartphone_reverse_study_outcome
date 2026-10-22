package com.bytedance.ee.bear.wikiv2.wikitreev2.makecopy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sq5.e;
import sq5.m;
import sq5.n;
import td5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/makecopy/WikiMakeCopyFragment;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/WikiCreateToFragment;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/makecopy/IWikiMakeCopyDependence;", "<init>", "()V", "wikiOperateButtonFromXml", "Landroid/widget/Button;", "getWikiOperateButtonFromXml", "()Landroid/widget/Button;", "setWikiOperateButtonFromXml", "(Landroid/widget/Button;)V", "wikiTreeCtrlViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "getWikiTreeCtrlViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;", "setWikiTreeCtrlViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiTreeCtrlView;)V", "clearFromXmlViewCache", "", "onDestroyView", "command", "Lcom/bytedance/ee/bear/list/selector/ICommand;", "selectorConfig", "Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "initAction", "makeCopy", "parentToken", "", "finishWithIntent", "intent", "Landroid/content/Intent;", "getUserComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiMakeCopyFragment extends WikiCreateToFragment implements sq5.a {
    public Button w;
    public WikiTreeCtrlView x;
    public d y;
    public SelectorConfig z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ WikiMakeCopyFragment a;

        public b(WikiMakeCopyFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r22) {
            WikiMakeCopyFragment r1 = this.a;
            View r2 = r1.x;
            WikiSelectorBean r3 = null;
            if (r2 != null) goto L9;
            View r4 = r1.getView();
            if (r4 == null) goto L7;
            r2 = r4.findViewById(2131393267);
        L8:
            r1.x = (WikiTreeCtrlView) r2;
            goto L9
        L7:
            r2 = null;
        L9:
            String r12 = ((WikiTreeCtrlView) r2).getFocusToken();
            tt5.a.h("Wiki_WikiMakeCopyFragment", "click confirm, focusToken = " + du5.b.g(r12));
            if (TextUtils.isEmpty(r12) == true) goto L37;
            WikiMakeCopyFragment r5 = this.a;
            WikiCreateToFragment.aa0(r5, Integer.valueOf(r5.Y90().getSrcObjType()));
            WikiMakeCopyFragment r6 = this.a;
            SelectorConfig r7 = r6.z;
            if (r7 == null) goto L14;
            SelectorType r8 = r7.a;
        L16:
            if (r8 != SelectorType.SPACE_MAKE_COPY_TO) goto L18;
            d r9 = new sq5.b(r6, r6.getArguments(), r6.Y90().getSpaceId(), r12, r6);
        L35:
            r6.y = r9;
            r9.execute();
            return;
        L18:
            Bundle r10 = r6.getArguments();
            WikiTreeActivityContract r11 = r6.Y90();
            Intrinsics.checkNotNullParameter(r6, "fragment");
            Intrinsics.checkNotNullParameter(r11, "contract");
            Intrinsics.checkNotNullParameter(r12, "parentToken");
            boolean r13 = false;
            if (r10 == null) goto L21;
            boolean r14 = r10.getBoolean("src_origin_external");
        L22:
            if (r10 == null) goto L24;
            r13 = r10.getBoolean("src_is_shortcut");
        L24:
            if (r14 == false) goto L29;
            if (r13 == false) goto L29;
            if (r10 == null) goto L28;
            r10.putParcelable("extra_space_bean", n.a(r10, ""));
        L28:
            d r15 = new sq5.b(r6, r10, r11.getSpaceId(), r12, r6);
        L34:
            r9 = r15;
        L29:
            if (r10 == null) goto L31;
            r3 = (WikiSelectorBean) r10.getParcelable("extra_wiki_bean");
        L31:
            if (r3 == null) goto L33;
            r11.setSrcToken(r3.d);
            r11.setSrcObjType(r3.j);
            r11.setSrcSpaceId(r3.a);
            r11.setSrcTitle(r3.g);
            r11.setSrcOriginWikiToken(r3.e);
            r11.setSrcOriginSpaceId(r3.c);
            r11.setSrcIsShortcut(r3.l);
        L33:
            r15 = new m(new e(r6, r10, r11.getSrcToken(), r11.getSrcObjType(), r11.getSrcSpaceId(), r11.getSrcParentToken(), r11.getSrcTitle(), r12, r11.getSpaceId(), r11.getDocumentName(), r11.getSrcOriginWikiToken(), r11.getSrcOriginSpaceId(), r11.getSrcFileSize(), r11.getSrcIsShortcut(), r6));
            goto L34
        L21:
            r14 = false;
            goto L22
        L14:
            r8 = null;
            goto L16
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

    public WikiMakeCopyFragment() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        SelectorConfig r4 = (SelectorConfig) r3.getParcelable("extra_config");
    L6:
        this.z = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // sq5.a
    public final void ww(Intent r3) {
        tt5.a.h("Wiki_WikiMakeCopyFragment", "finishWithIntent()...");
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
