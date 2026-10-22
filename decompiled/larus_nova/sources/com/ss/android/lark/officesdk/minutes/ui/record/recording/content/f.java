package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements UDTabLayoutCoordinator2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingContentController f436336a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436337a = null;

        static {
            int[] r100 = new int[MmRecordingUITab.values().length];
            r100[MmRecordingUITab.SUBTITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmRecordingUITab.SUMMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f436337a = r100;
        }
    }

    public f(MmRecordingContentController r100) {
        this.f436336a = r100;
    }

    @Override // com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2.a
    public final void a(int r100, com.larksuite.component.universe_design.tab.b r101) {
        Intrinsics.checkNotNullParameter(r101, "tab");
        h r102 = (h) ListProtector.get(this.f436336a.f436310l, r100);
        r101.b(r102.getTitle());
        View r103 = r101.f285296e;
        MmRecordingContentController r104 = this.f436336a;
        MmRecordingUITab r105 = r102.getTabType();
        r104.getClass();
        int r106 = MmRecordingContentController.b.f436314a[r105.ordinal()];
        if (r106 == 1) goto L8;
        if (r106 != 2) goto L7;
        int r107 = R.id.recordingSummaryTab;
    L9:
        r103.setId(r107);
        TextView r108 = r101.a();
        r108.setTypeface(Typeface.DEFAULT_BOLD);
        MmRecordingUITab r109 = r102.getTabType();
        int r110 = a.f436337a[r109.ordinal()];
        if (r110 == 1) goto L15;
        if (r110 != 2) goto L14;
        int r111 = uvb.b.f551863a;
        uvb.a.b(r108, uvb.c.f551876g);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        int r112 = uvb.b.f551863a;
        uvb.a.b(r108, uvb.c.f551875f);
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r107 = R.id.recordingSubtitleTab;
        goto L9
    }
}
