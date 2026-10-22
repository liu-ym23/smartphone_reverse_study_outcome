package com.bytedance.ee.bear.document.timepicker;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.document.timepicker.view.TimeAdapter;
import com.bytedance.ee.util.ui.l;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J2\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\tJ\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/document/timepicker/TimePickerFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "callback", "Lcom/bytedance/ee/bear/document/timepicker/TimePickerFragment$Callback;", "holder", "Lcom/bytedance/ee/bear/document/timepicker/view/TimePickerViewHolder;", "initHour", "", "Ljava/lang/Integer;", "initMinute", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "show", "fm", "Landroidx/fragment/app/FragmentManager;", "tag", "", "hour", "minute", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isSupportScreenLandscape", "", "Callback", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimePickerFragment extends BaseBottomSheetDialogFragment {
    public a k;
    public com.bytedance.ee.bear.document.timepicker.view.a l;
    public Integer m;
    public Integer n;

    public interface a {
        void a(int r1, int r2);

        void onCancel();

        void onDelete();
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TimePickerFragment a;

        public b(TimePickerFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.k;
            if (r2 == null) goto L6;
            r2.onDelete();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TimePickerFragment a;

        public c(TimePickerFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            TimePickerFragment r5 = this.a;
            a r0 = r5.k;
            if (r0 == null) goto L17;
            com.bytedance.ee.bear.document.timepicker.view.a r6 = r5.l;
            int r1 = 0;
            if (r6 == null) goto L9;
            WheelView r7 = r6.d;
            if (r7 == null) goto L9;
            int r8 = r7.getCurrentItem();
        L10:
            com.bytedance.ee.bear.document.timepicker.view.a r2 = this.a.l;
            if (r2 == null) goto L15;
            WheelView r3 = r2.e;
            if (r3 == null) goto L15;
            r1 = r3.getCurrentItem();
        L15:
            r0.a(r8, r1);
            return;
        L9:
            r8 = 0;
            goto L10
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ TimePickerFragment a;

        public d(TimePickerFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a r2 = this.a.k;
            if (r2 == null) goto L6;
            r2.onCancel();
            return;
        }
    }

    public TimePickerFragment() {
        this.m = 0;
        this.n = 0;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final void da0() {
        super.onStart();
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L11;
        BottomSheetDialog r0 = getDialog();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior r1 = r0.getBehavior();
        if (r1 == null) goto L7;
        r1.setSkipCollapsed(true);
    L7:
        BottomSheetDialog r2 = getDialog();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior r3 = r2.getBehavior();
        if (r3 == null) goto L12;
        r3.setState(3);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        da0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super.onConfigurationChanged(r3);
        com.bytedance.ee.bear.document.timepicker.view.a r4 = this.l;
        if (r4 == null) goto L24;
        cu5.c.e(getActivity());
        if (ku5.c.k(r4.a) == false) goto L7;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L17;
        WheelView r1 = r4.d;
        if (r1 == null) goto L14;
        r1.setItemVisible(5);
    L14:
        WheelView r5 = r4.e;
        if (r5 == null) goto L25;
        r5.setItemVisible(5);
        return;
    L25:
        return;
    L17:
        WheelView r2 = r4.d;
        if (r2 == null) goto L20;
        r2.setItemVisible(7);
    L20:
        WheelView r6 = r4.e;
        if (r6 == null) goto L27;
        r6.setItemVisible(7);
        return;
    L27:
        return;
    L7:
        if (cu5.c.e(r4.a) == false) goto L9;
        r0 = true;
        goto L10
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        com.bytedance.ee.bear.document.timepicker.view.a r5 = this.l;
        if (r5 == null) goto L12;
        Integer r6 = this.m;
        int r0 = 0;
        if (r6 == null) goto L7;
        int r7 = r6.intValue();
    L8:
        Integer r1 = this.n;
        if (r1 == null) goto L11;
        r0 = r1.intValue();
    L11:
        r5.update(r7, r0);
        goto L12
    L7:
        r7 = 0;
    L12:
        com.bytedance.ee.bear.document.timepicker.view.a r8 = this.l;
        if (r8 == null) goto L17;
        b r2 = new b(this);
        Intrinsics.checkNotNullParameter(r2, "l");
        UDButton r9 = r8.h;
        if (r9 == null) goto L17;
        r9.setOnClickListener(r2);
    L17:
        com.bytedance.ee.bear.document.timepicker.view.a r10 = this.l;
        if (r10 == null) goto L22;
        c r11 = new c(this);
        Intrinsics.checkNotNullParameter(r11, "l");
        TextView r12 = r10.c;
        if (r12 == null) goto L22;
        r12.setOnClickListener(r11);
    L22:
        com.bytedance.ee.bear.document.timepicker.view.a r13 = this.l;
        if (r13 == null) goto L28;
        d r14 = new d(this);
        Intrinsics.checkNotNullParameter(r14, "l");
        AppCompatImageView r16 = r13.b;
        if (r16 == null) goto L29;
        r16.setOnClickListener(r14);
        return;
    L29:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        FragmentActivity r8 = getActivity();
        WheelView r9 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        com.bytedance.ee.bear.document.timepicker.view.a r10 = new com.bytedance.ee.bear.document.timepicker.view.a(r8);
        this.l = r10;
        View r11 = LayoutInflater.from(r10.a).inflate(2131560109, null);
        r10.f = r11;
        if (r11 == null) goto L8;
        View r12 = r11.findViewById(2131368031);
    L9:
        View r0 = r10.f;
        if (r0 == null) goto L12;
        View r1 = r0.findViewById(2131368018);
    L13:
        r10.g = r1;
        if (r12 == null) goto L16;
        AppCompatImageView r2 = (AppCompatImageView) r12.findViewById(2131368967);
    L17:
        r10.b = r2;
        if (r2 == null) goto L20;
        r2.setImageDrawable(l.a(r10.a, 2131254124, 2131101926));
    L20:
        View r3 = r10.f;
        if (r3 == null) goto L23;
        UDButton r4 = (UDButton) r3.findViewById(2131388675);
    L24:
        r10.h = r4;
        if (r12 == null) goto L27;
        TextView r13 = (TextView) r12.findViewById(2131368987);
    L28:
        r10.c = r13;
        if (r13 == null) goto L31;
        r13.setVisibility(0);
    L31:
        if (r12 == null) goto L33;
        TextView r14 = (TextView) r12.findViewById(2131368988);
    L33:
        View r16 = r10.f;
        if (r16 == null) goto L36;
        WheelView r17 = (WheelView) r16.findViewById(2131368032);
    L37:
        r10.d = r17;
        if (r17 == null) goto L40;
        r17.setAdapter(new TimeAdapter(TimeAdapter.TimeType.Hours));
    L40:
        View r18 = r10.f;
        if (r18 == null) goto L43;
        r9 = (WheelView) r18.findViewById(2131368034);
    L43:
        r10.e = r9;
        if (r9 == null) goto L46;
        r9.setAdapter(new TimeAdapter(TimeAdapter.TimeType.Minutes));
    L46:
        WheelView r19 = r10.d;
        if (r19 == null) goto L49;
        r19.setDividerType(WheelView.DividerType.FILL);
    L49:
        int r20 = 5;
        boolean r21 = true;
        if (r19 != null) goto L52;
    L61:
        if (r19 == null) goto L63;
        r19.setCyclic(false);
    L63:
        WheelView r22 = r10.e;
        if (r22 == null) goto L66;
        r22.setDividerType(WheelView.DividerType.FILL);
    L66:
        if (r22 != null) goto L68;
    L77:
        if (r22 == null) goto L79;
        r22.setCyclic(false);
    L79:
        WheelView r23 = r10.d;
        if (r23 == null) goto L82;
        r23.setOnTouchListener(new d45.a(r23));
    L82:
        WheelView r24 = r10.e;
        if (r24 == null) goto L85;
        r24.setOnTouchListener(new d45.a(r24));
    L85:
        WheelView r26 = r10.d;
        if (r26 == null) goto L88;
        r26.setCurrentItem(0);
    L88:
        WheelView r27 = r10.e;
        if (r27 == null) goto L92;
        r27.setCurrentItem(0);
    L92:
        return r10.f;
    L68:
        if (ku5.c.k(r10.a) == false) goto L70;
    L72:
        r21 = false;
    L73:
        if (r21 == true) goto L76;
        r20 = 7;
    L76:
        r22.setItemVisible(r20);
        goto L77
    L70:
        if (cu5.c.e(r10.a) == false) goto L72;
    L52:
        if (ku5.c.k(r10.a) == false) goto L54;
    L56:
        boolean r28 = false;
    L57:
        if (r28 == false) goto L59;
        int r29 = 5;
    L60:
        r19.setItemVisible(r29);
        goto L61
    L59:
        r29 = 7;
        goto L60
    L54:
        if (cu5.c.e(r10.a) == false) goto L56;
        r28 = true;
        goto L57
    L36:
        r17 = null;
        goto L37
    L27:
        r13 = null;
        goto L28
    L23:
        r4 = null;
        goto L24
    L16:
        r2 = null;
        goto L17
    L12:
        r1 = null;
        goto L13
    L8:
        r12 = null;
        goto L9
    }
}
