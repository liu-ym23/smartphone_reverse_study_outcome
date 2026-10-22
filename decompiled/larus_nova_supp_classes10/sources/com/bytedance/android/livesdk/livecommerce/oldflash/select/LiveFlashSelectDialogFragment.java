package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import com.bytedance.android.livesdk.livecommerce.event.y;
import com.bytedance.android.livesdk.livecommerce.event.z;
import com.bytedance.android.livesdk.livecommerce.oldflash.q;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.ui.ec.widget.titlebar.ECTitleBar;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashSelectDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseDialogFragment;", "Lcom/bytedance/android/livesdk/livecommerce/base/ECBaseViewModel;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashSelectDialogFragment extends ECBaseDialogFragment<ECBaseViewModel> {
    public Map<Integer, View> i;
    public Function1<? super String, Unit> j;
    public List<com.bytedance.android.livesdk.livecommerce.oldflash.select.b> k;
    public String l;
    public q m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveFlashSelectDialogFragment a;

        public b(LiveFlashSelectDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RecyclerView a;
        public final /* synthetic */ LiveFlashSelectDialogFragment b;

        public c(RecyclerView r1, LiveFlashSelectDialogFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            Iterator r0 = ((ArrayList) this.b.k).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.livesdk.livecommerce.oldflash.select.b) r0.next()).b = false;
            goto L4
        L6:
            int r6 = this.a.getChildAdapterPosition(r5);
            if (r6 < 0) goto L28;
            ((com.bytedance.android.livesdk.livecommerce.oldflash.select.b) ListProtector.get(this.b.k, r6)).b = true;
            RecyclerView.Adapter r1 = this.a.getAdapter();
            if (r1 == null) goto L11;
            r1.notifyDataSetChanged();
        L11:
            LiveFlashSelectDialogFragment r2 = this.b;
            Function1<? super String, Unit> r3 = r2.j;
            if (r3 == null) goto L14;
            Unit r7 = (Unit) r3.invoke(((com.bytedance.android.livesdk.livecommerce.oldflash.select.b) ListProtector.get(r2.k, r6)).a);
        L14:
            LiveFlashSelectDialogFragment r8 = this.b;
            q r4 = r8.m;
            if (r4 == null) goto L28;
            String r9 = r8.l;
            z r10 = new z(r4.a, r4.b, r4.c);
            if (r9 != null) goto L19;
            r9 = "";
        L19:
            r10.f("attribute_name", r9);
            r10.k();
        L28:
            this.b.dismiss();     // Catch: Exception -> L23
            return;
        L23:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r11 = DialogFragmentLancet.sLastShowStack;
            if (r11 == null) goto L31;
            com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return 2131560722;
    }

    public LiveFlashSelectDialogFragment() {
        this.i = new LinkedHashMap();
        this.k = new ArrayList();
        this.l = "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r1.gravity = 80;
        return r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.i).clear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (this.i != null) goto L5;
        this.i = new LinkedHashMap();
    L5:
        View r6 = (View) ((LinkedHashMap) this.i).get(2131388807);
        if (r6 != null) goto L13;
        View r7 = getView();
        if (r7 == null) goto L12;
        r6 = r7.findViewById(2131388807);
        if (r6 == null) goto L12;
        this.i.put(2131388807, r6);
    L12:
        r6 = null;
    L13:
        ECTitleBar r8 = (ECTitleBar) r6;
        if (r8 == null) goto L16;
        r8.setTitleText(getString(2131896604, new Object[]{this.l}));
        r8.setLeftIconClickListener(new b(this));
    L16:
        View r9 = this.d;
        if (r9 == null) goto L21;
        RecyclerView r10 = r9.findViewById(2131384973);
        if (r10 == null) goto L21;
        r10.setLayoutManager(new LinearLayoutManager(getContext()));
        r10.setAdapter(new com.bytedance.android.livesdk.livecommerce.oldflash.select.c(this.k, new c(r10, this)));
    L21:
        q r11 = this.m;
        if (r11 == null) goto L28;
        String r12 = this.l;
        y r0 = new y(r11.a, r11.b, r11.c);
        if (r12 != null) goto L26;
        r12 = "";
    L26:
        r0.f("attribute_name", r12);
        r0.k();
        return;
    }
}
