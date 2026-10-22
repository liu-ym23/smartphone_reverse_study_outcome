package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.d;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.e;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.AnchorV4BaseInfoView$BaseInfoLayoutOnHierarchyChangeListener$onChildViewRemoved$$inlined$cacheSimpleDraweeView$1;
import com.bytedance.android.shopping.extensions.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ExtensionsKt {
    public static final HashMap<String, WeakReference<Bitmap>> a = null;

    public static final class a<T> implements y.c {
        public final /* synthetic */ View a;
        public final /* synthetic */ Background b;
        public final /* synthetic */ String c;

        public a(View r1, Background r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            this.a.post(new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.a(this, (Bitmap) r3));
        }
    }

    static {
        a = new HashMap();
    }

    public static final void a(LinearLayout r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$configAlignStrategy");
        if (r3 != 0) goto L5;
        r2.setVerticalGravity(48);
        return;
    L5:
        if (r3 != 1) goto L7;
        r2.setVerticalGravity(16);
        return;
    L7:
        if (r3 == 2) goto L9;
        r2.setVerticalGravity(48);
        return;
    L9:
        r2.setVerticalGravity(80);
    }

    public static final void b(ViewGroup r4, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$dfsDispatchPossibleShow");
        Intrinsics.checkNotNullParameter(r5, "hub");
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        View r2 = r4.getChildAt(r1);
        if ((r2 instanceof ActionHubAccessor) == true) goto L7;
        Object r3 = null;
    L8:
        ActionHubAccessor r6 = (ActionHubAccessor) r3;
        if (r6 == null) goto L12;
        r6.dispatchPossibleShow();
    L12:
        if ((r2 instanceof ViewGroup) == false) goto L14;
        b((ViewGroup) r2, r5);
    L14:
        r1 = r1 + 1;
        goto L3
    L7:
        r3 = r2;
        goto L8
    }

    public static final void e(ViewGroup r3, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$dfsTreeAndAssignHub");
        Intrinsics.checkNotNullParameter(r4, "hub");
        IntRange r0 = RangesKt.until(0, r3.getChildCount());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r3.getChildAt(r2.nextInt()));
        goto L4
    L6:
        Iterator r5 = r1.iterator();
    L8:
        if (r5.hasNext() == false) goto L19;
        View r6 = (View) r5.next();
        if ((r6 instanceof ActionHubAccessor) == true) goto L12;
        Object r7 = null;
    L13:
        ActionHubAccessor r8 = (ActionHubAccessor) r7;
        if (r8 == null) goto L17;
        r8.setActionHub(r4);
    L17:
        if ((r6 instanceof ViewGroup) == false) goto L8;
        e((ViewGroup) r6, r4);
        goto L8
    L12:
        r7 = r6;
        goto L13
    }

    public static final void f(ViewGroup r3, Function1<? super ShowEvent, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$dfsTreeAndLogShowEvent");
        Intrinsics.checkNotNullParameter(r4, "process");
        IntRange r0 = RangesKt.until(0, r3.getChildCount());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r3.getChildAt(r2.nextInt()));
        goto L4
    L6:
        Iterator r5 = r1.iterator();
    L8:
        if (r5.hasNext() == false) goto L24;
        View r6 = (View) r5.next();
        if ((r6 instanceof d) == true) goto L12;
        Object r7 = null;
    L13:
        d r8 = (d) r7;
        if (r8 == null) goto L22;
        List<ShowEvent> r9 = r8.showEvent();
        if (r9 == null) goto L22;
        Iterator<T> r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L22;
        r4.invoke((ShowEvent) r10.next());
    L22:
        if ((r6 instanceof ViewGroup) == false) goto L8;
        f((ViewGroup) r6, r4);
        goto L8
    L12:
        r7 = r6;
        goto L13
    }

    public static final View g(ViewGroup r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$dfsViewTag");
        IntRange r0 = RangesKt.until(0, r3.getChildCount());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r3.getChildAt(r2.nextInt()));
        goto L4
    L6:
        Iterator r5 = r1.iterator();
    L7:
        View r6 = null;
        if (r5.hasNext() == false) goto L29;
        View r7 = (View) r5.next();
        if ((r7 instanceof e) == true) goto L12;
        Object r8 = null;
    L13:
        e r9 = (e) r8;
        if (r9 == null) goto L16;
        String r10 = r9.getViewTag();
    L18:
        if (Intrinsics.areEqual(r10, r4) == true) goto L19;
        if ((r7 instanceof ViewGroup) == false) goto L24;
        r6 = r7;
    L24:
        ViewGroup r11 = (ViewGroup) r6;
        if (r11 == null) goto L7;
        View r12 = g(r11, r4);
        if (r12 == null) goto L7;
        return r12;
    L19:
        return r7;
    L16:
        r10 = null;
        goto L18
    L12:
        r8 = r7;
        goto L13
    L29:
        return null;
    }

    public static final void i(View r2, ImageModel r3) {
        Intrinsics.checkNotNullParameter(r2, "theView");
        LocalImage r0 = null;
        if (r3 == null) goto L5;
        ECUrlModel r1 = r3.getRemote();
    L6:
        if (r1 != null) goto L8;
    L15:
        if (r3 == null) goto L17;
        r0 = r3.getLocal();
    L17:
        if (r0 != null) goto L19;
    L26:
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r4 == null) goto L29;
        r4.width = -2;
        r4.height = -2;
        r2.setLayoutParams(r4);
        return;
    L29:
        r2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return;
    L19:
        if (r3.getLocal().getWidth() <= 0) goto L26;
        if (r3.getLocal().getHeight() <= 0) goto L26;
        ViewGroup.LayoutParams r5 = r2.getLayoutParams();
        if (r5 == null) goto L25;
        r5.width = vf4.a.b(Integer.valueOf(r3.getLocal().getWidth()));
        r5.height = vf4.a.b(Integer.valueOf(r3.getLocal().getHeight()));
        r2.setLayoutParams(r5);
        return;
    L25:
        r2.setLayoutParams(new ViewGroup.LayoutParams(vf4.a.b(Integer.valueOf(r3.getLocal().getWidth())), vf4.a.b(Integer.valueOf(r3.getLocal().getHeight()))));
        return;
    L8:
        if (r3.getRemote().getWidth() <= 0) goto L15;
        if (r3.getRemote().getHeight() <= 0) goto L15;
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        if (r6 == null) goto L14;
        r6.width = vf4.a.b(Integer.valueOf(r3.getRemote().getWidth()));
        r6.height = vf4.a.b(Integer.valueOf(r3.getRemote().getHeight()));
        r2.setLayoutParams(r6);
        return;
    L14:
        r2.setLayoutParams(new ViewGroup.LayoutParams(vf4.a.b(Integer.valueOf(r3.getRemote().getWidth())), vf4.a.b(Integer.valueOf(r3.getRemote().getHeight()))));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void j(View r5, final Background r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$setBackground");
        String r0 = null;
        if (r6 == null) goto L5;
        Padding r1 = r6.getPadding();
    L6:
        Intrinsics.checkNotNullParameter(r5, "$this$setPadding");
        if (r1 == null) goto L9;
        r5.setPadding(vf4.a.b(Integer.valueOf(r1.getLeft())), vf4.a.b(Integer.valueOf(r1.getTop())), vf4.a.b(Integer.valueOf(r1.getRight())), vf4.a.b(Integer.valueOf(r1.getBottom())));
    L9:
        if (r6 == null) goto L11;
        ImageModel r2 = r6.getBackgroundImageModel();
    L12:
        if (r2 != null) goto L14;
        r5.setBackground(com.bytedance.commerce.base.drawable.a.a(new ExtensionsKt$setBackground$3(r6)));
        return;
    L14:
        if (r6.getBackgroundImageModel().getRemote() == null) goto L30;
        List r3 = r6.getBackgroundImageModel().getRemote().getUrlList();
        if (r3 == null) goto L18;
        r0 = (String) CollectionsKt.firstOrNull(r3);
    L18:
        if (r0 != null) goto L20;
        r0 = "";
    L20:
        WeakReference<Bitmap> r4 = a.get(r0);
        if (r4 == null) goto L28;
        Bitmap r7 = r4.get();
        if (r7 == null) goto L28;
        Drawable r8 = h(r7, r5.getContext(), r6.getMaskColor());
        if (r8 == null) goto L38;
        r5.setBackground(r8);
        return;
    L38:
        return;
    L28:
        y.l(r6.getBackgroundImageModel().getRemote(), -1, -1, new a(r5, r6, r0));
        return;
    L30:
        if (r6.getBackgroundImageModel().getLocal() == null) goto L40;
        LocalImage r9 = r6.getBackgroundImageModel().getLocal();
        Context r10 = r5.getContext();
        String r11 = r6.getMaskColor();
        Intrinsics.checkNotNullParameter(r10, "context");
        if (k.c(r11) == false) goto L34;
        Drawable r12 = new LayerDrawable(new Drawable[]{ImageExtensionsKt.b(r9, r10), new ColorDrawable(com.bytedance.android.shopping.extensions.a.a(r11, 0))});
    L35:
        r5.setBackground(r12);
        return;
    L34:
        r12 = ImageExtensionsKt.b(r9, r10);
        goto L35
    L40:
        return;
    L11:
        r2 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static final View k(ViewGroup r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$trackSpecificViewWithRefId");
        Intrinsics.checkNotNullParameter(r4, "refId");
        IntRange r0 = RangesKt.until(0, r3.getChildCount());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r3.getChildAt(r2.nextInt()));
        goto L4
    L6:
        Iterator r5 = r1.iterator();
    L7:
        View r6 = null;
        if (r5.hasNext() == false) goto L21;
        View r7 = (View) r5.next();
        if (Intrinsics.areEqual(r7.getTag(), r4) == true) goto L11;
        if ((r7 instanceof ViewGroup) == false) goto L16;
        r6 = r7;
    L16:
        ViewGroup r8 = (ViewGroup) r6;
        if (r8 == null) goto L7;
        View r9 = k(r8, r4);
        if (r9 == null) goto L7;
        return r9;
    L11:
        return r7;
    L21:
        return null;
    }

    public static final void c(ViewGroup r2, List r3, AnchorV4BaseInfoView$BaseInfoLayoutOnHierarchyChangeListener$onChildViewRemoved$$inlined$cacheSimpleDraweeView$1 r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$dfsFilterOutViews");
        Intrinsics.checkNotNullParameter(r3, "result");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        Iterator r5 = com.bytedance.commerce.base.view.b.a(r2).iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        View r0 = (View) r5.next();
        if (((Boolean) r4.invoke(r0)).booleanValue() == true) goto L7;
        if ((r0 instanceof ViewGroup) == true) goto L11;
        r0 = null;
    L11:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L4;
        c(r1, r3, r4);
        goto L4
    L7:
        ((ArrayList) r3).add(r0);
        goto L4
    }

    public static final void d(ViewGroup r3, String r4, List<View> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$dfsGetViewsByTag");
        Intrinsics.checkNotNullParameter(r5, "result");
        IntRange r0 = RangesKt.until(0, r3.getChildCount());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r3.getChildAt(r2.nextInt()));
        goto L4
    L6:
        Iterator r6 = r1.iterator();
    L8:
        if (r6.hasNext() == false) goto L26;
        View r7 = (View) r6.next();
        if ((r7 instanceof e) == true) goto L12;
        Object r8 = null;
    L13:
        e r9 = (e) r8;
        if (r9 == null) goto L16;
        String r10 = r9.getViewTag();
    L18:
        if (Intrinsics.areEqual(r10, r4) == false) goto L21;
        ((ArrayList) r5).add(r7);
    L21:
        if ((r7 instanceof ViewGroup) == true) goto L23;
        r7 = null;
    L23:
        ViewGroup r11 = (ViewGroup) r7;
        if (r11 == null) goto L8;
        d(r11, r4, r5);
        goto L8
    L16:
        r10 = null;
        goto L18
    L12:
        r8 = r7;
        goto L13
    }

    public static final Drawable h(Bitmap r3, Context r4, String r5) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (k.c(r5) == false) goto L9;
        return new LayerDrawable(new Drawable[]{new BitmapDrawable(r4.getResources(), r3), new ColorDrawable(com.bytedance.android.shopping.extensions.a.a(r5, 0))});
    L9:
        return new BitmapDrawable(r4.getResources(), r3);
    }
}
