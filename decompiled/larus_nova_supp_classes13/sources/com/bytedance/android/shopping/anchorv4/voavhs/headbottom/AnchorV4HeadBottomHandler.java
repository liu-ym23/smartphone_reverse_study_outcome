package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import com.bytedance.android.shopping.anchorv4.vm.c;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.common.utility.UIUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV4HeadBottomHandler implements c {
    public final int a;
    public int b;
    public int c;
    public boolean d;
    public final RecyclerView e;
    public final d83.b f;

    public final void a9(boolean r1) {
    }

    public final void X8() {
        if (this.d == true) goto L34;
        RecyclerView r0 = this.e;
        LinearLayoutManager r2 = new LinearLayoutManager(r0.getContext());
        boolean r3 = false;
        r2.setOrientation(0);
        Unit r4 = Unit.INSTANCE;
        r0.setLayoutManager(r2);
        RecyclerView r5 = this.e;
        r0.setAdapter(new HeadBottomAdapter(r5, r5.getContext(), this.f));
        r0.setAdapter(r0.getAdapter());
        r0.setVisibility(0);
        d83.b r1 = this.f;
        if ((r1 instanceof s) == true) goto L8;
        r1 = null;
    L8:
        s r6 = (s) r1;
        if (r6 == null) goto L33;
        AnchorV4HeadV2VO r7 = r6.K10();
        if (r7 == null) goto L33;
        Integer r8 = r7.getBottomHeight();
        if (r8 == null) goto L33;
        if (r8.intValue() <= 0) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == true) goto L21;
        r8 = null;
    L21:
        if (r8 == null) goto L33;
        int r10 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8.intValue()));
        RecyclerView r11 = this.e;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = r10;
        r11.setLayoutParams(r12);
        RecyclerView.Adapter r13 = this.e.getAdapter();
        if ((r13 instanceof HeadBottomAdapter) == true) goto L25;
        r13 = null;
    L25:
        HeadBottomAdapter r14 = (HeadBottomAdapter) r13;
        if (r14 == null) goto L33;
        r14.h = r10;
        if (h.a() == true) goto L30;
    L32:
        r14.i = r3;
        goto L33
    L30:
        if (r7.getEnableBottomFillBlur() == false) goto L32;
        r3 = true;
        goto L32
    L17:
        r9 = false;
    L33:
        this.d = true;
    L34:
        RecyclerView.Adapter r15 = this.e.getAdapter();
        if ((r15 instanceof HeadBottomAdapter) == true) goto L37;
        r15 = null;
    L37:
        HeadBottomAdapter r16 = (HeadBottomAdapter) r15;
        if (r16 == null) goto L47;
        int r17 = r16.getItemCount();
        d83.b r18 = this.f;
        if (r18 == null) goto L45;
        List<ECUrlModel> r19 = r18.k();
        if (r19 == null) goto L45;
        if (r17 != r19.size()) goto L45;
        return;
    L45:
        r16.a = null;
        r16.notifyDataSetChanged();
        return;
    }

    public final void Y8(final int r8) {
        Function2<ViewGroup, Integer, Unit> r0 = new AnchorV4HeadBottomHandler$onHeadSpecialWidthChange$1(r8);
        int r9 = this.e.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L21;
        View r2 = this.e.getChildAt(r1);
        if ((r2 instanceof ViewGroup) == false) goto L20;
        RecyclerView.LayoutManager r3 = this.e.getLayoutManager();
        d83.b r4 = null;
        if (r3 == null) goto L9;
        Integer r5 = Integer.valueOf(r3.getPosition(r2));
    L10:
        d83.b r6 = this.f;
        if ((r6 instanceof s) == false) goto L14;
        r4 = r6;
    L14:
        s r7 = (s) r4;
        if (r7 == null) goto L20;
        if (r5 == null) goto L20;
        if (r5.intValue() >= r7.W4()) goto L20;
        r0.invoke(r2, Integer.valueOf(r1));
        goto L20
    L9:
        r5 = null;
    L20:
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4HeadBottomHandler(UnresponsiveRecyclerView r2, d83.b r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.e = r2;
        this.f = r3;
        this.a = k1.n(r2.getContext());
    }

    public final void W8(int r11, Bitmap r12) {
        Intrinsics.checkNotNullParameter(r12, "bitmap");
        RecyclerView.Adapter r1 = this.e.getAdapter();
        d83.b r3 = null;
        if ((r1 instanceof HeadBottomAdapter) == true) goto L5;
        r1 = null;
    L5:
        HeadBottomAdapter r2 = (HeadBottomAdapter) r1;
        if (r2 == null) goto L43;
        Intrinsics.checkNotNullParameter(r12, "bitmap");
        if (r2.i == false) goto L49;
        List<? extends ECUrlModel> r0 = r2.a;
        if (r0 == null) goto L13;
        ECUrlModel r4 = (ECUrlModel) CollectionsKt.getOrNull(r0, r11);
    L15:
        if (r2.B2(r11, r4) == true) goto L18;
        return;
    L18:
        if (r2.f.get(r11) != null) goto L44;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L38
        d83.b r6 = r2.l;     // Catch: Throwable -> L38
        if ((r6 instanceof s) == false) goto L23;
        r3 = r6;
    L23:
        s r7 = (s) r3;     // Catch: Throwable -> L38
        if (r7 == null) goto L45;
        AnchorV4HeadV2VO r8 = r7.K10();     // Catch: Throwable -> L38
        if (r8 == null) goto L46;
        List<HeaderContentModel> r9 = r8.getCells();     // Catch: Throwable -> L38
        if (r9 == null) goto L47;
        HeaderContentModel r10 = (HeaderContentModel) CollectionsKt.getOrNull(r9, r11);     // Catch: Throwable -> L38
        if (r10 == null) goto L48;
        float r13 = UIUtils.getScreenWidth(r2.k);     // Catch: Throwable -> L38
        Float r14 = r10.getWHScale(false);     // Catch: Throwable -> L38
        if (r14 == null) goto L35;
        float r15 = r14.floatValue();     // Catch: Throwable -> L38
    L36:
        int r16 = RangesKt.coerceAtMost((int) ((r12.getHeight() / (r13 / r15)) * r2.h), r12.getHeight());     // Catch: Throwable -> L38
        r2.f.put(r11, Bitmap.createBitmap(r12, 0, r12.getHeight() - r16, r12.getWidth(), r16, r2.c, true));     // Catch: Throwable -> L38
        r2.z2(r11, r2.f.get(r11));     // Catch: Throwable -> L38
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
        return;
    L35:
        r15 = 1.0f;
        goto L36
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L38:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L44:
        return;
    L13:
        r4 = null;
        goto L15
    L49:
        return;
    }

    public final void Z8(int r10, Bitmap r11) {
        RecyclerView.Adapter r0 = this.e.getAdapter();
        if ((r0 instanceof HeadBottomAdapter) == true) goto L5;
        r0 = null;
    L5:
        HeadBottomAdapter r1 = (HeadBottomAdapter) r0;
        if (r1 == null) goto L23;
        if (r11 == null) goto L24;
        Lazy r2 = PdpPerfOpt.a;
        if (PdpMessageOpt.b.e() == true) goto L13;
        return;
    L13:
        if (r1.A2(r10) == true) goto L16;
        return;
    L16:
        if (r1.g.get(r10) == null) goto L19;
        return;
    L19:
        if (r1.C2(r10, r11.getWidth(), r11.getHeight()) == true) goto L28;
        Bitmap r12 = Bitmap.createBitmap(r11, 0, r11.getHeight() - r1.h, r11.getWidth(), r1.h, r1.c, true);
        r1.g.put(r10, r12);
        r1.z2(r10, r12);
        return;
    L28:
        return;
    L24:
        return;
    }

    public final void b9(boolean r5, Integer r6, Integer r7, boolean r8) {
        int r0 = 0;
        if (r8 == false) goto L15;
        RecyclerView.LayoutManager r9 = this.e.getLayoutManager();
        if ((r9 instanceof LinearLayoutManager) == true) goto L7;
        r9 = null;
    L7:
        LinearLayoutManager r10 = (LinearLayoutManager) r9;
        if (r10 == null) goto L33;
        if (r6 == null) goto L11;
        int r11 = r6.intValue();
    L12:
        if (r7 == null) goto L14;
        r0 = r7.intValue();
    L14:
        r10.scrollToPositionWithOffset(r11, r0);
        return;
    L11:
        r11 = 0;
        goto L12
    L33:
        return;
    L15:
        RecyclerView r12 = this.e;
        if (r5 == false) goto L19;
        if (r6 == null) goto L25;
        int r1 = (r6.intValue() - this.b) * this.a;
    L26:
        r12.scrollBy(r1, 0);
        if (r6 == null) goto L29;
        this.b = r6.intValue();
    L29:
        if (r7 == null) goto L35;
        if (r5 == true) goto L36;
        this.c = r7.intValue();
        return;
    L36:
        return;
    L35:
        return;
    L25:
        r1 = 0;
        goto L26
    L19:
        if (r6 == null) goto L22;
        if (r7 == null) goto L22;
        int r2 = (r6.intValue() * this.a) + r7.intValue();
        int r3 = (this.b * this.a) + this.c;
    L24:
        r1 = r2 - r3;
    L22:
        if (r7 == null) goto L25;
        r2 = r7.intValue();
        r3 = this.c;
        goto L24
    }
}
