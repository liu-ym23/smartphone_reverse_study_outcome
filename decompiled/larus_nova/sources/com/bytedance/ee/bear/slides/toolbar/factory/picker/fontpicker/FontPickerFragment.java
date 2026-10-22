package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u001dH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerFragment;", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/BasePickerFragment;", "<init>", "()V", "contentLayoutId", "", "getContentLayoutId", "()I", "resultKey", "", "getResultKey", "()Ljava/lang/String;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerAdapter;", "listener", "Lcom/bytedance/ee/bear/slides/toolbar/factory/picker/fontpicker/FontPickerFragment$FontPickerListener;", "itemData", "Lcom/bytedance/ee/bear/document/model/toolbar/ItemV2;", "isFirstScroll", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "setListener", "", "updateData", "setupContentView", "view", "Landroid/view/View;", "updateUI", "Companion", "FontPickerListener", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontPickerFragment extends BasePickerFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f238688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f238689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f238690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FontPickerAdapter f238691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f238692n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ItemV2 f238693o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f238694p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f238695q;

    public static final class a {
    }

    public interface b {
        void a(String r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FontPickerFragment f238696a;

        public c(FontPickerFragment r100) {
            this.f238696a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f238696a.ba0();
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FontPickerFragment f238697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FontData f238698b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FontPickerFragment f238699a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f238700b;

            public a(FontPickerFragment r100, int r101) {
                this.f238699a = r100;
                this.f238700b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView r100 = this.f238699a.f238690l;     // Catch: Throwable -> L11
                LinearLayoutManager r101 = null;
                if (r100 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");     // Catch: Throwable -> L11
                r100 = null;
            L5:
                RecyclerView.LayoutManager r102 = r100.getLayoutManager();     // Catch: Throwable -> L11
                if ((r102 instanceof LinearLayoutManager) == false) goto L8;
                r101 = (LinearLayoutManager) r102;     // Catch: Throwable -> L11
            L8:
                if (r101 == null) goto L14;
                r101.scrollToPositionWithOffset(this.f238700b, 0);     // Catch: Throwable -> L11
                return;
            L14:
                return;
            L11:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L18;
                throw th;
            }
        }

        public d(FontPickerFragment r100, FontData r101) {
            this.f238697a = r100;
            this.f238698b = r101;
        }

        public final void a() {
            FontPickerAdapter r100 = this.f238697a.f238691m;
            RecyclerView r101 = null;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r100 = null;
        L5:
            FontItem r102 = this.f238698b.getValue();
            Iterator<FontItem> r103 = r100.getCurrentList().iterator();
            int r104 = 0;
        L6:
            int r105 = -1;
            if (r103.hasNext() == false) goto L16;
            String r106 = r103.next().getKey();
            if (r102 == null) goto L11;
            String r107 = r102.getKey();
        L13:
            if (Intrinsics.areEqual(r106, r107) == true) goto L17;
            r104 = r104 + 1;
        L17:
            int r108 = r100.f238680b;
            if (r104 == r108) goto L24;
            r100.f238680b = r104;
            if (r108 < 0) goto L22;
            r100.notifyItemChanged(r108);
        L22:
            if (r104 < 0) goto L24;
            r100.notifyItemChanged(r104);
        L24:
            FontPickerAdapter r109 = this.f238697a.f238691m;
            if (r109 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r109 = null;
        L27:
            List<FontItem> r110 = r109.getCurrentList();
            FontData r111 = this.f238698b;
            Iterator<FontItem> r112 = r110.iterator();
            int r113 = 0;
        L29:
            if (r112.hasNext() == false) goto L38;
            String r114 = r112.next().getKey();
            FontItem r115 = r111.getValue();
            if (r115 == null) goto L33;
            String r116 = r115.getKey();
        L35:
            if (Intrinsics.areEqual(r114, r116) == true) goto L36;
            r113 = r113 + 1;
            goto L29
        L36:
            r105 = r113;
            goto L38
        L33:
            r116 = null;
        L38:
            if (r105 <= 0) goto L46;
            FontPickerFragment r117 = this.f238697a;
            if (r117.f238694p == false) goto L46;
            RecyclerView r118 = r117.f238690l;
            if (r118 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        L45:
            r101.post(new a(this.f238697a, r105));
            goto L46
        L44:
            r101 = r118;
        L46:
            this.f238697a.f238694p = false;
            return;
        L11:
            r107 = null;
            goto L13
        L16:
            r104 = -1;
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
        if (this.f238691m == null) goto L26;
        ItemV2 r100 = this.f238693o;
        if (r100 == null) goto L27;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        String r102 = r100.getValue();     // Catch: Throwable -> L17
        FontData r103 = null;
        FontPickerAdapter r104 = null;
        r103 = null;
        if (r102 == null) goto L15;
        FontData r105 = (FontData) ((Gson) this.f238695q.getValue()).fromJson(r102, FontData.class);     // Catch: Throwable -> L17
        if (r105 == null) goto L15;
        FontPickerAdapter r106 = this.f238691m;     // Catch: Throwable -> L17
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");     // Catch: Throwable -> L17
    L14:
        r104.submitList(r105.getChildren(), new d(this, r105));     // Catch: Throwable -> L17
        r103 = r105;
        goto L15
    L13:
        r104 = r106;
    L15:
        Object r107 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L17
    L19:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L22;
        tt5.a.h("FontPickerFragment", "FontPickerFragment updateUI error " + r108);
    L22:
        Result.m9448boximpl(r107);
        return;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L27:
        return;
    }

    public FontPickerFragment() {
        this.f238688j = R.layout.fragment_font_picker;
        this.f238689k = "FONT_PICKER_EXIT";
        this.f238694p = true;
        this.f238695q = LazyKt.lazy(FontPickerFragment$gson$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final int ca0() {
        return this.f238688j;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final String da0() {
        return this.f238689k;
    }

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.picker.BasePickerFragment
    public final void fa0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.findViewById(R.id.iv_back).setOnClickListener(new c(this));
        RecyclerView r101 = (RecyclerView) r100.findViewById(R.id.rv_font_picker);
        this.f238690l = r101;
        FontPickerAdapter r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r101 = null;
    L5:
        r101.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView r103 = this.f238690l;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r103 = null;
    L8:
        r103.setItemAnimator(null);
        RecyclerView r104 = this.f238690l;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r104 = null;
    L11:
        r104.setLayoutAnimation(null);
        this.f238691m = new FontPickerAdapter(new FontPickerFragment$setupContentView$2(this));
        RecyclerView r105 = this.f238690l;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r105 = null;
    L14:
        FontPickerAdapter r106 = this.f238691m;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L18:
        r105.setAdapter(r102);
        ga0();
        return;
    L17:
        r102 = r106;
        goto L18
    }
}
