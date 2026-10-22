package com.bytedance.ee.bear.document.timepicker;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ TimePickerPlugin a;
    public final /* synthetic */ TimePickerPlugin.TimePickerRequestData b;
    public final /* synthetic */ m c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.timepicker.a$a, reason: collision with other inner class name */
    public static final class C0113a implements TimePickerFragment.a {
        public final /* synthetic */ m a;
        public final /* synthetic */ TimePickerPlugin.TimePickerRequestData b;
        public final /* synthetic */ TimePickerPlugin c;

        @Override // com.bytedance.ee.bear.document.timepicker.TimePickerFragment.a
        public final void onCancel() {
            tt5.a.h(TimePickerPlugin.TAG, "onCancel");
            TimePickerPlugin.access$dismissPickerIfNeed(this.c);
        }

        @Override // com.bytedance.ee.bear.document.timepicker.TimePickerFragment.a
        public final void onDelete() {
            tt5.a.h(TimePickerPlugin.TAG, "onDelete");
            m r0 = this.a;
            if (r0 == null) goto L9;
            TimePickerPlugin.TimePickerRequestData r1 = this.b;
            if (r1 == null) goto L7;
            String r2 = r1.getTimeBlockId();
        L8:
            r0.a(new TimePickerPlugin.TimePickerResponseData(0, 0, "delete", r2, 3, null));
            goto L9
        L7:
            r2 = null;
        L9:
            TimePickerPlugin.access$dismissPickerIfNeed(this.c);
        }

        @Override // com.bytedance.ee.bear.document.timepicker.TimePickerFragment.a
        public final void a(int r5, int r6) {
            tt5.a.h(TimePickerPlugin.TAG, "onSelected h=" + r5 + ", m=" + r6);
            m r0 = this.a;
            if (r0 == null) goto L9;
            TimePickerPlugin.TimePickerRequestData r2 = this.b;
            if (r2 == null) goto L7;
            String r3 = r2.getTimeBlockId();
        L8:
            r0.a(new TimePickerPlugin.TimePickerResponseData(r5, r6, "update", r3));
            goto L9
        L7:
            r3 = null;
        L9:
            TimePickerPlugin.access$dismissPickerIfNeed(this.c);
        }

        public C0113a(m r1, TimePickerPlugin.TimePickerRequestData r2, TimePickerPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public a(TimePickerPlugin r1, TimePickerPlugin.TimePickerRequestData r2, m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (TimePickerPlugin.access$isUIContainerDetached(this.a) == false) goto L5;
        return;
    L5:
        TimePickerPlugin.access$dismissPickerIfNeed(this.a);
        String r0 = TimePickerFragment.class.getName();
        TimePickerPlugin r1 = this.a;
        TimePickerFragment r2 = Fragment.instantiate(TimePickerPlugin.access$getActivity(r1), r0);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.document.timepicker.TimePickerFragment");
        TimePickerPlugin.access$setPickerFragment$p(r1, r2);
        TimePickerFragment r3 = TimePickerPlugin.access$getPickerFragment$p(this.a);
        if (r3 == null) goto L23;
        FragmentManager r4 = TimePickerPlugin.access$getFragmentManager(this.a);
        m r5 = this.c;
        TimePickerPlugin.TimePickerRequestData r6 = this.b;
        C0113a r7 = new C0113a(r5, r6, this.a);
        int r8 = 0;
        if (r6 == null) goto L10;
        int r9 = r6.getHour();
    L11:
        TimePickerPlugin.TimePickerRequestData r10 = this.b;
        if (r10 == null) goto L14;
        r8 = r10.getMinute();
    L14:
        Intrinsics.checkNotNullParameter(r4, "fm");
        Intrinsics.checkNotNullParameter(r0, "tag");
        Intrinsics.checkNotNullParameter(r7, "callback");
        r3.k = r7;
        r3.m = Integer.valueOf(r9);
        r3.n = Integer.valueOf(r8);
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, r0, r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r3, r11) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L18:
        r3.show(r4, r0);
        return;
    L24:
        return;
    L10:
        r9 = 0;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
