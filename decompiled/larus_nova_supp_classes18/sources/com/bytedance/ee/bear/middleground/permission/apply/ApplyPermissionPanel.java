package com.bytedance.ee.bear.middleground.permission.apply;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0016J\b\u0010(\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPanel;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "notesInputFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getNotesInputFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setNotesInputFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "clearFromXmlViewCache", "", ResourceData.KEY_TYPE, "", ResourceData.KEY_TOKEN, "", "module", "ownerId", "ownerName", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "hasSendRequest", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "sendRequest", "addWatermark", "onStart", "onDestroyView", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyPermissionPanel extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int p = 0;
    public SpaceEditText h;
    public int i;
    public String j;
    public String k;
    public String l;
    public String m;
    public final CompositeDisposable n;
    public boolean o;

    public static final class a {
        @JvmStatic
        public static void a(FragmentActivity r2, String r3, int r4, String r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r5, "ownerId");
            Intrinsics.checkNotNullParameter(r6, "ownerName");
            Intrinsics.checkNotNullParameter(r7, "module");
            Bundle r0 = new Bundle();
            r0.putString("extra_token", r3);
            r0.putInt("extra_type", r4);
            r0.putString("extra_owner_id", r5);
            r0.putString("extra_owner_name", r6);
            r0.putString("extra_module", r7);
            Fragment r8 = Fragment.instantiate(r2, ApplyPermissionPanel.class.getName(), r0);
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
            Fragment r9 = (DialogFragment) r8;
            FragmentManager r10 = r2.getSupportFragmentManager();
            String r11 = ApplyPermissionPanel.class.getName();
            if ((r9 instanceof Fragment) == false) goto L5;
            Fragment r12 = r9;
        L6:
            LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, r11, r13);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r12, r13) == true) goto L15;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            r9.show(r10, r11);
            return;
        L15:
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ ApplyPermissionPanel a;

        public b(ApplyPermissionPanel r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r9) {
            ApplyPermissionPanel r10 = this.a;
            if (r10.o == true) goto L26;
            UDEditText r0 = r10.h;
            if (r0 != null) goto L11;
            View r1 = r10.getView();
            if (r1 == null) goto L9;
            r0 = r1.findViewById(2131381012);
        L10:
            r10.h = (SpaceEditText) r0;
            goto L11
        L9:
            r0 = null;
        L11:
            Editable r11 = ((SpaceEditText) r0).getText();
            boolean r2 = false;
            if (r11 == null) goto L19;
            String r12 = r11.toString();
            if (r12 == null) goto L19;
            if (r12.length() <= 0) goto L18;
            r2 = true;
        L18:
            boolean r6 = r2;
        L20:
            ApplyPermissionPanel r13 = this.a;
            int r3 = r13.i;
            String r14 = r13.j;
            if (r14 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
            String r4 = null;
        L24:
            String[] r15 = PermissionAnalytic.a;
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter("edit", "permission");
            PermissionAnalytic.f(r3, r4, DocFeed$Value$Result.CANCEL, "edit", r6, false);
            return;
        L23:
            r4 = r14;
        L19:
            r6 = false;
            goto L20
        }
    }

    static {
    }

    public ApplyPermissionPanel() {
        this.i = sbb.e.g.b;
        this.n = new CompositeDisposable();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.n.dispose();
        this.h = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
    L7:
        Dialog r3 = getDialog();
        if (r3 == null) goto L11;
        r3.setOnCancelListener(new b(this));
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        String r0 = "";
        if (r5 == null) goto L6;
        String r6 = r5.getString("extra_token", "");
        if (r6 == null) goto L6;
    L7:
        this.j = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L10;
        int r8 = r7.getInt("extra_type", this.i);
    L11:
        this.i = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L15;
        String r10 = r9.getString("extra_owner_id", "");
        if (r10 == null) goto L15;
    L16:
        this.l = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L20;
        String r12 = r11.getString("extra_owner_name", "");
        if (r12 == null) goto L20;
    L21:
        this.m = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L27;
        String r14 = r13.getString("extra_module", "");
        if (r14 == null) goto L27;
        r0 = r14;
    L27:
        this.k = r0;
        return;
    L20:
        r12 = "";
    L15:
        r10 = "";
        goto L16
    L10:
        r8 = this.i;
    L6:
        r6 = "";
        goto L7
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r9, r10);
        StringBuilder r11 = new StringBuilder("@");
        String r0 = this.m;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ownerName");
        r0 = null;
    L5:
        r11.append(r0);
        String r12 = r11.toString();
        String r2 = xo5.a.c(getContext(), 2131888056, "owner_name", r12);
        Intrinsics.checkNotNull(r2);
        int r3 = StringsKt.indexOf$default(r2, r12, 0, false, 6, null);
        SpannableString r4 = new SpannableString(r2);
        r4.setSpan(new hi5.y(getContext(), new q(this)), r3, r12.length() + r3, 33);
        ((TextView) r9.findViewById(2131388741)).setText(r4);
        ((TextView) r9.findViewById(2131388741)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) r9.findViewById(2131388741)).setHighlightColor(0);
        ((Button) r9.findViewById(2131385898)).setOnClickListener(new r(this));
        ((CommonActionPanelLayout) r9.findViewById(2131388889)).setOnActionListener(new s(this));
        zo5.b r13 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        String r14 = this.j;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
    L9:
        r13.j(r1, this.i, getDialog());
        com.bytedance.ee.bear.middleground.permission.c.g("apply_permission");
        return;
    L8:
        r1 = r14;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558721, r3, false);
    }
}
