package com.bytedance.ee.bear.doc.minutes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import h18.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/doc/minutes/PlaySpeedBottomSheet;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "mDataList", "", "Lcom/bytedance/ee/bear/doc/minutes/PlaySpeedItem;", "mSelectCallback", "Lkotlin/Function1;", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "renderSpeedItems", "Landroid/widget/LinearLayout;", "isSupportScreenLandscape", "", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaySpeedBottomSheet extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public List<PlaySpeedItem> k;
    public Function1<? super PlaySpeedItem, Unit> l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PlaySpeedBottomSheet a;

        public b(PlaySpeedBottomSheet r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PlaySpeedBottomSheet a;
        public final /* synthetic */ PlaySpeedItem b;
        public final /* synthetic */ LinearLayout c;

        public c(PlaySpeedBottomSheet r1, PlaySpeedItem r2, LinearLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Iterator<T> r4 = this.a.k.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            ((PlaySpeedItem) r4.next()).setSelect(false);
            goto L4
        L6:
            this.b.setSelect(true);
            this.a.da0(this.c);
            Function1<? super PlaySpeedItem, Unit> r5 = this.a.l;
            if (r5 == null) goto L11;
            r5.invoke(this.b);
            return;
        }
    }

    static {
    }

    public PlaySpeedBottomSheet() {
        this.k = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        BottomSheetDialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L8;
        FrameLayout r1 = (FrameLayout) r0.getDelegate().findViewById(2131368870);
        if (r1 == null) goto L9;
        r1.setBackgroundColor(0);
        return;
    L9:
        return;
    }

    public final void da0(LinearLayout r8) {
        r8.removeAllViews();
        if (this.k.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<PlaySpeedItem> r0 = this.k.iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        PlaySpeedItem r1 = r0.next();
        TextView r2 = new TextView(getContext());
        r2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        r2.setGravity(17);
        r2.setText(r1.getValue());
        r2.setTextSize(14.0f);
        int r3 = e.a;
        r2.setTypeface(e.a(r2.getContext()), 1);
        Context r4 = r2.getContext();
        if (r4 == null) goto L15;
        if (r1.isSelect() == false) goto L13;
        Drawable r5 = ContextCompat.getDrawable(r4, 2131233851);
    L14:
        r2.setBackground(r5);
        r2.setTextColor(ContextCompat.getColor(r4, 2131106622));
        goto L15
    L13:
        r5 = null;
    L15:
        r2.setOnClickListener(new c(this, r1, r8));
        r8.addView(r2);
        goto L7
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        View r4 = r2.findViewById(2131376107);
        LinearLayout r5 = (LinearLayout) r2.findViewById(2131378883);
        r4.setOnClickListener(new b(this));
        Intrinsics.checkNotNull(r5);
        da0(r5);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560091, r3, false);
    }
}
