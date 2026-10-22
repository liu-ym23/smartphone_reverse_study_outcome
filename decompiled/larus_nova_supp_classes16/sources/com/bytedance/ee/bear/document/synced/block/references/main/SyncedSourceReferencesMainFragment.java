package com.bytedance.ee.bear.document.synced.block.references.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0002\"#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J(\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u001d\u001a\u0004\u0018\u00010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/main/SyncedSourceReferencesMainFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "callback", "Lcom/bytedance/ee/bear/document/synced/block/references/main/SyncedSourceReferencesMainFragment$Callback;", "pluginHost", "Lcom/bytedance/ee/bear/browser/WebPluginHost;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onDestroy", "show", "fm", "Landroidx/fragment/app/FragmentManager;", "tag", "", "getPluginHost", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getContext", "Landroid/content/Context;", "Companion", "Callback", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceReferencesMainFragment extends BaseBottomSheetDialogFragment implements d0c.c {
    public a k;
    public WebPluginHost l;

    public interface a {
        void o1();

        void onClose();

        void onCreate();

        void onDestory();
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SyncedSourceReferencesMainFragment a;

        public c(SyncedSourceReferencesMainFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.k;
            if (r2 == null) goto L6;
            r2.onClose();
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ SyncedSourceReferencesMainFragment a;

        public d(SyncedSourceReferencesMainFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.k;
            if (r2 == null) goto L6;
            r2.o1();
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ SyncedSourceReferencesMainFragment a;

        public e(SyncedSourceReferencesMainFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            String r2 = (String) r1;
            a r3 = this.a.k;
            if (r3 == null) goto L6;
            r3.onClose();
            return;
        }
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        this.l = null;
        a r0 = this.k;
        if (r0 == null) goto L6;
        r0.onDestory();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m272provideComponent() {
        return provideComponent();
    }

    public SyncedSourceReferencesMainFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        ImageView r13 = (ImageView) r11.findViewById(2131368967);
        if (r13 == null) goto L5;
        r13.setImageDrawable(com.bytedance.ee.util.ui.l.a(r11.getContext(), 2131254124, 2131101926));
    L5:
        ImageView r1 = (ImageView) r11.findViewById(2131368968);
        if (r1 == null) goto L8;
        r1.setImageDrawable(com.bytedance.ee.util.ui.l.a(r11.getContext(), 2131255147, 2131101926));
    L8:
        ViewPager r0 = r11.findViewById(2131387969);
        if (r0 == null) goto L11;
        r0.setAdapter(new SyncedSourceReferencesMainAdapter(getChildFragmentManager(), PassportcConvention.b(this), getArguments()));
    L11:
        TextView r14 = (TextView) r11.findViewById(2131368988);
        Bundle r2 = getArguments();
        int r3 = 0;
        if (r2 == null) goto L14;
        r3 = r2.getInt("key_references_count", 0);
    L14:
        r14.setText(StringsKt.replace$default(LarkContext.getApplication().getResources().getString(2131889298), "{num}", String.valueOf(r3), false, 4, null));
        r13.setOnClickListener(new c(this));
        r1.setOnClickListener(new d(this));
        ((SyncedSourceRefVM) new ViewModelProvider(this).get(SyncedSourceRefVM.class)).getLiveItemClick().observe(getViewLifecycleOwner(), new e(this));
        a r16 = this.k;
        if (r16 == null) goto L18;
        r16.onCreate();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560107, r3, false);
    }

    public final void da0(FragmentManager r2, String r3, a r4, WebPluginHost r5) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "callback");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == false) goto L10;
    L7:
        this.k = r4;
        this.l = r5;
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        show(r2, r3);
        goto L7
    }
}
