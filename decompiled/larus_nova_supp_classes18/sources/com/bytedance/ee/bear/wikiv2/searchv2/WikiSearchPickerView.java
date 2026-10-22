package com.bytedance.ee.bear.wikiv2.searchv2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiSearchPickerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IWikiSearchView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "picker", "Lcom/ss/android/lark/picker/Picker;", "delegate", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IWikiSearchView$ViewDelegate;", "spaceId", "", "init", "", "fragment", "Landroidx/fragment/app/Fragment;", "withCancel", "", "getPickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "parseVisibleSpaceId", ResourceData.KEY_URL, "setSearchViewDelegate", "updateSpaceId", "doClickCancel", "setEndInput", "hideKeyBoard", "hide", "show", "isShow", "prepareInput", "cancelInput", "updateVisiblity", "visiblity", "", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSearchPickerView extends FrameLayout implements com.bytedance.ee.bear.wikiv2.searchv2.b {
    public static final /* synthetic */ int c = 0;
    public Picker a;
    public com.bytedance.ee.bear.wikiv2.searchv2.b.a b;

    public static final class a {
    }

    public static final class b extends BasePicker.IOnPickNotify {
        public final /* synthetic */ String a;
        public final /* synthetic */ WikiSearchPickerView b;

        public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
            Intrinsics.checkNotNullParameter(r2, "ids");
            Intrinsics.checkNotNullParameter(r3, "infoList");
        }

        public b(String r1, WikiSearchPickerView r2) {
            this.a = r1;
            this.b = r2;
        }

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
        public final void onSelected(String r10, SearchBaseInfo r11) {
            Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_ID);
            Intrinsics.checkNotNullParameter(r11, "info");
            if ((r11 instanceof SearchWikiInfo) == false) goto L61;
            String r0 = null;
            Object r1 = null;
            r0 = null;
            boolean r2 = false;
            String r3 = "";
            if (yp5.c.h() == false) goto L24;
            SearchSpaceInfo r12 = ((SearchWikiInfo) r11).getSpaceInfo();
            if (r12 == null) goto L21;
            Long r13 = r12.getSpaceId();
            if (r13 == null) goto L21;
            if (r13.longValue() <= 0) goto L13;
            boolean r4 = true;
        L14:
            if (r4 == true) goto L17;
            r13 = null;
        L17:
            if (r13 == null) goto L21;
            String r14 = r13.toString();
            if (r14 == null) goto L21;
        L27:
            com.bytedance.ee.bear.wikiv2.searchv2.b.a r5 = this.b.b;
            if (r5 == null) goto L61;
            SearchWikiInfo r15 = (SearchWikiInfo) r11;
            String r6 = r15.getToken();
            if (r6 == null) goto L33;
            r3 = r6;
        L33:
            WikiSearchPickerView r7 = this.b;
            String r16 = r15.getUrl();
            r7.getClass();
            if (yp5.c.h() == false) goto L60;
            if (r16 != null) goto L37;
        L40:
            boolean r8 = true;
        L41:
            if (r8 == true) goto L60;
            Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L53
            String r17 = UriProtector.getQueryParameter(UriProtector.parse(r16), "visible_space_id");     // Catch: Throwable -> L53
            if (r17 != null) goto L46;
        L50:
            r17 = null;
        L51:
            Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L53
        L56:
            if (Result.isFailure-impl(r18) == true) goto L59;
            r1 = r18;
        L59:
            r0 = (String) r1;
            goto L60
        L46:
            if (r17.length() <= 0) goto L48;
            r2 = true;
        L48:
            if (r2 == false) goto L50;
        L53:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r18 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L56
        L37:
            if (r16.length() == 0) goto L40;
            r8 = false;
        L60:
            r5.a(r3, r14, r0);
            goto L61
        L13:
            r4 = false;
        L21:
            r14 = this.a;
            if (r14 != null) goto L27;
        L26:
            r14 = "";
            goto L27
        L24:
            r14 = this.a;
            if (r14 != null) goto L27;
        L61:
            WikiSearchPickerView r110 = this.b;
            int r111 = WikiSearchPickerView.c;
            r110.getClass();
            rcb.c.d(r110);
        }
    }

    static {
    }

    public final void a() {
        tt5.a.h("WikiSearchPickerView", "cancel click. ");
        Picker r0 = this.a;
        if (r0 == null) goto L5;
        r0.clearFocus();
    L5:
        rcb.c.d(this);
        Picker r1 = this.a;
        if (r1 == null) goto L8;
        r1.defaultMode(false);
    L8:
        Picker r2 = this.a;
        if (r2 == null) goto L11;
        r2.enableCancelView(false);
    L11:
        com.bytedance.ee.bear.wikiv2.searchv2.b.a r3 = this.b;
        if (r3 == null) goto L15;
        r3.onExitSearch();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b
    public void setSearchViewDelegate(com.bytedance.ee.bear.wikiv2.searchv2.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.b = r2;
    }

    public WikiSearchPickerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public final PickerConfig b(FragmentActivity r5, final String r6) {
        final b r0 = new b(r6, this);
        PickerConfig r1 = new PickerConfig(new Dependency(r5, r5.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r1.searcher(new WikiSearchPickerView$getPickerConfig$pickerConfig$1$1(r6));
        r1.extra(new WikiSearchPickerView$getPickerConfig$pickerConfig$1$2(r0, this));
        r1.recommendList(new WikiSearchPickerView$getPickerConfig$pickerConfig$1$3(r6));
        return r1;
    }

    public final void d(WikiTreePanelDialog r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        FragmentActivity r5 = r3.getActivity();
        if (r5 == null) goto L8;
        Picker r0 = this.a;
        if (r0 == null) goto L9;
        r0.scene(PickerStatistics.Scene.CcmSearchInWikiTree);
        r0.init(b(r5, r4));
        r0.enableCancelView(false);
        return;
    L9:
        return;
    }

    public final void c(Fragment r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        FragmentActivity r6 = r3.getActivity();
        if (r6 == null) goto L6;
        Picker r0 = new Picker(getContext());
        r0.scene(PickerStatistics.Scene.CcmSearchInWikiTree);
        r0.init(b(r6, r4));
        this.a = r0;
        r0.enableCancelView(r5);
        addView(this.a);
        return;
    }
}
