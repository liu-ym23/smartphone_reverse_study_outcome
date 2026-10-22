package com.bytedance.ee.bear.middleground.permission.apply;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyAuditEscapePanel;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "notesInputFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getNotesInputFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setNotesInputFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "clearFromXmlViewCache", "", ResourceData.KEY_TYPE, "", ResourceData.KEY_TOKEN, "", "module", "ownerName", "fetcher", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyAuditEscapeFetcher;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "hasSendRequest", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "sendRequest", "addWatermark", "onStart", "onDestroyView", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyAuditEscapePanel extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int m = 0;
    public SpaceEditText h;
    public int i;
    public String j;
    public final com.bytedance.ee.bear.middleground.permission.apply.a k;
    public CompositeDisposable l;

    public static final class a {
    }

    static {
    }

    public ApplyAuditEscapePanel() {
        this.i = sbb.e.g.b;
        this.j = "";
        this.k = new com.bytedance.ee.bear.middleground.permission.apply.a();
        this.l = new CompositeDisposable();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.l.dispose();
        this.h = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
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
        if (r9 == null) goto L14;
        r9.getString("extra_module", "");
    L14:
        Bundle r10 = getArguments();
        if (r10 == null) goto L17;
        r10.getString("extra_owner_name", "");
    L17:
        this.l = new CompositeDisposable();
        return;
    L10:
        r8 = this.i;
    L6:
        r6 = "";
        goto L7
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r3, r4);
        com.bytedance.ee.bear.middleground.permission.apply.a r5 = this.k;
        Context r0 = r3.getContext();
        r5.getClass();
        Spanned r6 = com.bytedance.ee.bear.middleground.permission.apply.a.a(r0);
        ((TextView) r3.findViewById(2131388741)).setText(r6);
        ((TextView) r3.findViewById(2131388741)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) r3.findViewById(2131388741)).setHighlightColor(0);
        ((Button) r3.findViewById(2131385898)).setOnClickListener(new b(this));
        ((CommonActionPanelLayout) r3.findViewById(2131388889)).setOnActionListener(new c(this));
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.j, this.i, getDialog());
        com.bytedance.ee.bear.middleground.permission.c.g("admin_forbidden");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131558721, r3, false);
    }
}
