package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u001dH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerFragment;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/BasePickerFragment;", "<init>", "()V", "contentLayoutId", "", "getContentLayoutId", "()I", "resultKey", "", "getResultKey", "()Ljava/lang/String;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter;", "listener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerFragment$FontPickerListener;", "itemData", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "isFirstScroll", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "setListener", "", "updateData", "setupContentView", "view", "Landroid/view/View;", "updateUI", "Companion", "FontPickerListener", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontPickerFragment extends BasePickerFragment {
    public final int j;
    public final String k;
    public RecyclerView l;
    public FontPickerAdapter m;
    public b n;
    public ItemV2 o;
    public boolean p;
    public final Lazy q;

    public static final class a {
    }

    public interface b {
        void a(String r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ FontPickerFragment a;

        public c(FontPickerFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.ba0();
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ FontPickerFragment a;
        public final /* synthetic */ FontData b;

        public static final class a implements Runnable {
            public final /* synthetic */ FontPickerFragment a;
            public final /* synthetic */ int b;

            public a(FontPickerFragment r1, int r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView r0 = this.a.l;     // Catch: Throwable -> L11
                LinearLayoutManager r1 = null;
                if (r0 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");     // Catch: Throwable -> L11
                r0 = null;
            L5:
                RecyclerView.LayoutManager r2 = r0.getLayoutManager();     // Catch: Throwable -> L11
                if ((r2 instanceof LinearLayoutManager) == false) goto L8;
                r1 = (LinearLayoutManager) r2;     // Catch: Throwable -> L11
            L8:
                if (r1 == null) goto L14;
                r1.scrollToPositionWithOffset(this.b, 0);     // Catch: Throwable -> L11
                return;
            L14:
                return;
            L11:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L18;
                throw th;
            }
        }

        public d(FontPickerFragment r1, FontData r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            FontPickerAdapter r0 = this.a.m;
            ViewGroup r2 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r0 = null;
        L5:
            FontItem r3 = this.b.getValue();
            Iterator r4 = r0.getCurrentList().iterator();
            int r6 = 0;
        L6:
            int r8 = -1;
            if (r4.hasNext() == false) goto L16;
            String r7 = ((FontItem) r4.next()).getKey();
            if (r3 == null) goto L11;
            String r9 = r3.getKey();
        L13:
            if (Intrinsics.areEqual(r7, r9) == true) goto L17;
            r6 = r6 + 1;
        L17:
            int r5 = r0.b;
            if (r6 == r5) goto L24;
            r0.b = r6;
            if (r5 < 0) goto L22;
            r0.notifyItemChanged(r5);
        L22:
            if (r6 < 0) goto L24;
            r0.notifyItemChanged(r6);
        L24:
            FontPickerAdapter r1 = this.a.m;
            if (r1 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r1 = null;
        L27:
            List r10 = r1.getCurrentList();
            FontData r11 = this.b;
            Iterator r12 = r10.iterator();
            int r13 = 0;
        L29:
            if (r12.hasNext() == false) goto L38;
            String r14 = ((FontItem) r12.next()).getKey();
            FontItem r15 = r11.getValue();
            if (r15 == null) goto L33;
            String r16 = r15.getKey();
        L35:
            if (Intrinsics.areEqual(r14, r16) == true) goto L36;
            r13 = r13 + 1;
            goto L29
        L36:
            r8 = r13;
            goto L38
        L33:
            r16 = null;
        L38:
            if (r8 <= 0) goto L46;
            FontPickerFragment r17 = this.a;
            if (r17.p == false) goto L46;
            ViewGroup r18 = r17.l;
            if (r18 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        L45:
            r2.post(new a(this.a, r8));
            goto L46
        L44:
            r2 = r18;
        L46:
            this.a.p = false;
            return;
        L11:
            r9 = null;
            goto L13
        L16:
            r6 = -1;
            goto L17
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

    static {
    }

    public final void ga0() {
        if (this.m == null) goto L26;
        ItemV2 r0 = this.o;
        if (r0 == null) goto L27;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        String r2 = r0.getValue();     // Catch: Throwable -> L17
        ListAdapter r3 = null;
        if (r2 == null) goto L15;
        ListAdapter r4 = (FontData) ((Gson) this.q.getValue()).fromJson(r2, FontData.class);     // Catch: Throwable -> L17
        if (r4 == null) goto L15;
        FontPickerAdapter r5 = this.m;     // Catch: Throwable -> L17
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");     // Catch: Throwable -> L17
    L14:
        r3.submitList(r4.getChildren(), new d(this, r4));     // Catch: Throwable -> L17
        r3 = r4;
        goto L15
    L13:
        r3 = r5;
    L15:
        Object r6 = Result.constructor-impl(r3);     // Catch: Throwable -> L17
    L19:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L22;
        tt5.a.h("FontPickerFragment", "FontPickerFragment updateUI error " + r7);
    L22:
        Result.box-impl(r6);
        return;
    L17:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L27:
        return;
    }

    public FontPickerFragment() {
        this.j = 2131561201;
        this.k = "FONT_PICKER_EXIT";
        this.p = true;
        this.q = LazyKt.lazy(FontPickerFragment$gson$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final int ca0() {
        return this.j;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final String da0() {
        return this.k;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final void fa0(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        r5.findViewById(2131376031).setOnClickListener(new c(this));
        RecyclerView r6 = r5.findViewById(2131384951);
        this.l = r6;
        RecyclerView.Adapter r1 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r6 = null;
    L5:
        r6.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView r7 = this.l;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r7 = null;
    L8:
        r7.setItemAnimator(null);
        ViewGroup r8 = this.l;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r8 = null;
    L11:
        r8.setLayoutAnimation(null);
        this.m = new FontPickerAdapter(new FontPickerFragment$setupContentView$2(this));
        RecyclerView r9 = this.l;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r9 = null;
    L14:
        RecyclerView.Adapter r0 = this.m;
        if (r0 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L18:
        r9.setAdapter(r1);
        ga0();
        return;
    L17:
        r1 = r0;
        goto L18
    }
}
