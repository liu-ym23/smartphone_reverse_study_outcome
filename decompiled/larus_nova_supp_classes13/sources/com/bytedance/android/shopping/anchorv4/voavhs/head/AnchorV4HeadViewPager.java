package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.vo.CommentVideoInfo;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\nJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\nJ\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\nJ\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0006\u0010\u0019\u001a\u00020\u000fR+\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010-R\u0019\u00104\u001a\u0004\u0018\u00010/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/f;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/e;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "Ll53/b;", "collisionNegotiator", "", "setCollisionNegotiator", "", "Lkotlin/Pair;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/f;", "", "getGalleryDisplayData", "", "getLastPosition", "hub", "setActionHub", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTotalNavBlurTabCount", "getCurrentImageUri", "getTotalBottomTabCount", "item", "setCurrentItem", "getTotalBuilderCount", "Ljava/util/ArrayList;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/a;", "Lkotlin/collections/ArrayList;", "d", "Lkotlin/Lazy;", "getHeadViewHolders", "()Ljava/util/ArrayList;", "headViewHolders", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/n;", "e", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/n;", "getOnHolderIndicatorChangedListener", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/n;", "setOnHolderIndicatorChangedListener", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/head/n;)V", "onHolderIndicatorChangedListener", "", "l", "getEnableOptimize", "()Z", "enableOptimize", "Lf83/p;", "p", "Lf83/p;", "getTabLogicInterceptor", "()Lf83/p;", "tabLogicInterceptor", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadViewPager extends ViewPager implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.f, com.bytedance.android.shopping.anchorv4.voavhs.head.base.e, ActionHubAccessor, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public float a;
    public float b;
    public boolean c;
    public final Lazy d;
    public n e;
    public l53.b f;
    public HeadViewHolderBuilder g;
    public List<? extends List<Integer>> h;
    public final List<Integer> i;
    public boolean j;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a k;
    public final Lazy l;
    public float m;
    public boolean n;
    public Function1<? super HeadViewHolderBuilder, Unit> o;
    public final f83.p p;
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.d q;
    public final f83.l r;

    public static final class a implements com.bytedance.android.shopping.anchorv4.dto.business.c {
        public final /* synthetic */ Map a;
        public final /* synthetic */ Integer b;

        public final String getBlockNameStr() {
            Object r0 = this.a.get("block_name");
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final String getEnterFromStr() {
            Object r0 = this.a.get(SimilarProductParam.ENTER_FROM);
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final String getImageUriStr() {
            Object r0 = this.a.get("image_uri");
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final Integer getPageCounterInt() {
            Object r0 = this.a.get("page_counter");
            if ((r0 instanceof Integer) == true) goto L5;
            r0 = null;
        L5:
            Integer r1 = (Integer) r0;
            if (r1 == null) goto L8;
            int r2 = r1.intValue();
        L10:
            return Integer.valueOf(r2);
        L8:
            r2 = 0;
            goto L10
        }

        public final Integer getPageCursorInt() {
            Object r0 = this.a.get("page_cursor");
            if ((r0 instanceof Integer) == true) goto L5;
            r0 = null;
        L5:
            Integer r1 = (Integer) r0;
            if (r1 == null) goto L8;
            int r2 = r1.intValue();
        L10:
            return Integer.valueOf(r2);
        L8:
            r2 = 0;
            goto L10
        }

        public final String getProductIdStr() {
            Object r0 = this.a.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final String getProductNameStr() {
            Object r0 = this.a.get("product_name");
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final String getRecommendProductIdStr() {
            Object r0 = this.a.get("recommend_product_id");
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final String getSceneIdStr() {
            Object r0 = this.a.get("scene_id");
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final String getSceneProductIdStr() {
            Object r0 = this.a.get("scene_product_id");
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final String getSearchChannelStr() {
            Object r0 = this.a.get("search_channel");
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final String getSearchSourceStr() {
            Object r0 = this.a.get("search_source");
            if ((r0 instanceof String) == true) goto L6;
            r0 = null;
        L6:
            return (String) r0;
        }

        public final Integer getShownCountInt() {
            Object r0 = this.a.get("shown_count");
            if ((r0 instanceof Double) == true) goto L5;
            r0 = null;
        L5:
            Double r1 = (Double) r0;
            if (r1 == null) goto L8;
            int r2 = (int) r1.doubleValue();
        L10:
            return Integer.valueOf(r2);
        L8:
            r2 = 0;
            goto L10
        }

        public final int getTypeInt() {
            Integer r0 = this.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.intValue();
        }

        public a(Map r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public AnchorV4HeadViewPager(Context r8) {
        this(r8, null, null, null, null, 30);
    }

    public AnchorV4HeadViewPager(Context r8, AttributeSet r9) {
        this(r8, r9, null, null, null, 28);
    }

    private final boolean getEnableOptimize() {
        return ((Boolean) this.l.getValue()).booleanValue();
    }

    private final ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> getHeadViewHolders() {
        return (ArrayList) this.d.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final String getCurrentImageUri() {
        HeadViewHolderBuilder r0 = this.g;
        if (r0 == null) goto L21;
        int r2 = getCurrentItem();
        List<c> r1 = r0.b;
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.size() <= r2) goto L10;
        if (r2 < 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r1 = null;
    L14:
        if (r1 != null) goto L16;
        return null;
    L16:
        if (((c) ListProtector.get(r1, r2)).getType() != HeadViewType.PICTURE.getType()) goto L24;
        ECUrlModel r4 = ((c) ListProtector.get(r1, r2)).b;
        if (r4 != null) goto L20;
        return null;
    L20:
        return r4.getUri();
    L24:
        return null;
    L10:
        r3 = false;
        goto L11
    L21:
        return null;
    }

    public final List<ECUrlModel> getTotalBottomTabCount() {
        HeadViewHolderBuilder r0 = this.g;
        if (r0 == null) goto L51;
        List r2 = CollectionsKt.listOf(new String[]{HeadViewType.SIZE.getType(), HeadViewType.FIND_SAME.getType(), HeadViewType.COMMENT.getType()});
        ArrayList r3 = new ArrayList();
        List<c> r6 = r0.b;
        if (r6 == null) goto L37;
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L37;
        c r8 = (c) r7.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r9 = r0.e.get(r8.getType());
        if (r9 == null) goto L13;
        List<ECUrlModel> r10 = r9.l(r8);
        if (r10 == null) goto L13;
    L14:
        List r11 = r2;
        if ((r11 instanceof Collection) == true) goto L17;
    L19:
        Iterator r12 = r11.iterator();
    L21:
        if (r12.hasNext() == false) goto L25;
        if ((!Intrinsics.areEqual(r8.getType(), (String) r12.next())) == true) goto L21;
        boolean r13 = false;
    L26:
        if (r13 == false) goto L31;
        List<ECUrlModel> r14 = r10;
        if ((!r14.isEmpty()) == false) goto L31;
        r3.addAll(r14);
    L31:
        if ((!r10.isEmpty()) == true) goto L32;
        r3.add(null);
        goto L8
    L32:
        int r15 = r10.size();
        int r16 = 0;
    L33:
        if (r16 >= r15) goto L8;
        r3.add(null);
        r16 = r16 + 1;
    L25:
        r13 = true;
        goto L26
    L17:
        if (r11.isEmpty() == false) goto L19;
    L13:
        r10 = CollectionsKt.emptyList();
    L37:
        return r3;
    L51:
        return null;
    }

    public final List<ECUrlModel> getTotalNavBlurTabCount() {
        HeadViewHolderBuilder r0 = this.g;
        if (r0 == null) goto L43;
        List r2 = CollectionsKt.listOf(new String[]{HeadViewType.SIZE.getType(), HeadViewType.FIND_SAME.getType(), HeadViewType.COMMENT.getType()});
        ArrayList r3 = new ArrayList();
        List<c> r6 = r0.b;
        if (r6 == null) goto L32;
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L32;
        c r8 = (c) r7.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r9 = r0.e.get(r8.getType());
        if (r9 == null) goto L13;
        List<ECUrlModel> r10 = r9.k(r8);
        if (r10 == null) goto L13;
    L14:
        List r11 = r2;
        if ((r11 instanceof Collection) == true) goto L17;
    L19:
        Iterator r12 = r11.iterator();
    L21:
        if (r12.hasNext() == false) goto L25;
        if ((!Intrinsics.areEqual(r8.getType(), (String) r12.next())) == true) goto L21;
        boolean r13 = false;
    L26:
        if (r13 == false) goto L30;
        List<ECUrlModel> r14 = r10;
        if ((!r14.isEmpty()) == false) goto L30;
        r3.addAll(r14);
    L30:
        r3.add(null);
    L25:
        r13 = true;
        goto L26
    L17:
        if (r11.isEmpty() == false) goto L19;
    L13:
        r10 = CollectionsKt.emptyList();
    L32:
        return r3;
    L43:
        return null;
    }

    public final List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> getGalleryDisplayData() {
        ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r0 = getHeadViewHolders();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) r2.next()).f());
        goto L4
    L6:
        int r3 = r1.size();
        ArrayList r4 = new ArrayList(r3);
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L9;
        r4.add(CollectionsKt.emptyList());
        r5 = r5 + 1;
        goto L7
    L9:
        int r6 = r1.size();
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L16;
        Iterable r8 = (Iterable) ListProtector.get(r1, r7);
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        Pair r11 = (Pair) r10.next();
        r9.add(0);
        goto L13
    L15:
        ListProtector.set(r4, r7, r9);
        r7 = r7 + 1;
        goto L10
    L16:
        this.h = r4;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r1.iterator();
    L18:
        if (r13.hasNext() == false) goto L20;
        r12.addAll((List) r13.next());
        goto L18
    L20:
        return r12;
    }

    public final int getTotalBuilderCount() {
        return getHeadViewHolders().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.n == false) goto L6;
        requestLayout();
        this.n = false;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.k;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final List<Integer> getLastPosition() {
        return this.i;
    }

    public final n getOnHolderIndicatorChangedListener() {
        return this.e;
    }

    public final f83.p getTabLogicInterceptor() {
        return this.p;
    }

    public static final /* synthetic */ boolean h(AnchorV4HeadViewPager r0) {
        return r0.getEnableOptimize();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.e
    public final void d(int r2) {
        if (getCurrentItem() != r2) goto L5;
        return;
    L5:
        setCurrentItem(r2, false);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.f
    public final void e(com.bytedance.android.shopping.anchorv4.voavhs.head.base.p r3) {
        Intrinsics.checkNotNullParameter(r3, "itemViewDetail");
        HeadViewHolderBuilder r1 = this.g;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r3, "itemViewDetail");
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r0 = r1.e.get(r3.getType());
        if ((r0 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L7;
        r0 = null;
    L7:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r2 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r0;
        if (r2 == null) goto L12;
        r2.a(r3.c);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.a i(int r2) {
        return (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) CollectionsKt.getOrNull(getHeadViewHolders(), r2);
    }

    public final Pair<Integer, Integer> k(int r8) {
        int r0 = this.h.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int r4 = ((Collection) ListProtector.get(this.h, r2)).size();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L11;
        int r6 = r3 + 1;
        if (r3 == r8) goto L9;
        r5 = r5 + 1;
        r3 = r6;
        goto L5
    L9:
        return new Pair(Integer.valueOf(r2), Integer.valueOf(r5));
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return null;
    }

    public final void l(boolean r3) {
        Iterator<T> r0 = getHeadViewHolders().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) r0.next()).b2(r3);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(List<b> r18) {
        Intrinsics.checkNotNullParameter(r18, "headNodeGroupList");
        getHeadViewHolders().clear();
        if (this.g != null) goto L5;
        this.g = new HeadViewHolderBuilder(getContext(), this, r18, this.f, this.q, false);
    L5:
        HeadViewHolderBuilder r0 = this.g;
        if (r0 == null) goto L10;
        Function1<? super HeadViewHolderBuilder, Unit> r1 = this.o;
        if (r1 == null) goto L10;
        Unit r2 = (Unit) r1.invoke(r0);
    L10:
        ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r3 = getHeadViewHolders();
        HeadViewHolderBuilder r4 = this.g;
        if (r4 == null) goto L13;
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r5 = r4.b();
    L14:
        r3.addAll(r5);
        if (getAdapter() != null) goto L17;
        ArrayList r6 = new ArrayList();
        r6.addAll(getHeadViewHolders());
        Unit r7 = Unit.INSTANCE;
        setAdapter(new AnchorV4HeadViewAdapter(this, r6));
    L23:
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r18.iterator();
    L25:
        if (r9.hasNext() == false) goto L29;
        Object r10 = r9.next();
        if ((true ^ ((b) r10).d) == false) goto L25;
        r8.add(r10);
        goto L25
    L29:
        f83.p r11 = this.p;
        if (r11 == null) goto L32;
        r11.a(r8);
    L32:
        fj.d.s.getClass();
        ((LinkedHashMap) fj.d.r).clear();
        Iterator r12 = r8.iterator();
        int r13 = 0;
        int r14 = 0;
    L34:
        if (r12.hasNext() == false) goto L131;
        Object r15 = r12.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        b r17 = (b) r15;
        String r19 = r17.b;
        String r20 = a2.d(r17.e);
        if (r20 != null) goto L42;
        r20 = c.J.get(Integer.valueOf(c.a.a(r19)));
    L42:
        if (Intrinsics.areEqual(r20, "test") == false) goto L60;
        e83.a.d.getClass();
        Iterator r110 = e83.a.a().iterator();
    L45:
        if (r110.hasNext() == false) goto L49;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((c) r111).getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L45;
    L50:
        c r112 = (c) r111;
        if (r112 == null) goto L57;
        h83.a r113 = r112.B;
        if (r113 == null) goto L57;
        CommentVideoInfo r114 = r113.a;
        if (r114 == null) goto L57;
        TextWithOneIconElement r115 = r114.getMoreText();
    L58:
        if (r115 == null) goto L60;
        r20 = "more_test";
    L57:
        r115 = null;
        goto L58
    L49:
        r111 = null;
    L60:
        String r116 = r20;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r21 = this.q;
        if (r21 == null) goto L130;
        c63.d r117 = r21.t();
        if (r117 == null) goto L130;
        if (com.bytedance.android.shopping.anchorv4.experiment.d.a() == false) goto L67;
        String r22 = "shrink";
    L68:
        String r118 = r22;
        if (Intrinsics.areEqual(r19, String.valueOf(r13)) == false) goto L89;
        int r23 = ((b) ListProtector.get(r8, r14)).c.size();
        List<c> r119 = ((b) ListProtector.get(r8, r14)).c;
        if ((r119 instanceof Collection) == true) goto L73;
    L75:
        Iterator<T> r120 = r119.iterator();
        int r121 = 0;
    L77:
        if (r120.hasNext() == false) goto L83;
        if (Intrinsics.areEqual(((c) r120.next()).getType(), HeadViewType.VIDEO.getType()) == false) goto L77;
        r121 = r121 + 1;
        if (r121 >= 0) goto L77;
        CollectionsKt.throwCountOverflow();
    L83:
        if (r121 != 0) goto L85;
        String r24 = "picture";
    L88:
        String r122 = r24;
    L91:
        if (Intrinsics.areEqual(r19, String.valueOf(r13)) == false) goto L93;
    L94:
        Iterator<T> r25 = ((b) ListProtector.get(r8, r14)).c.iterator();
    L96:
        if (r25.hasNext() == false) goto L107;
        Object r123 = r25.next();
        c r124 = (c) r123;
        if (Intrinsics.areEqual(r124.getType(), HeadViewType.VIDEO.getType()) == false) goto L100;
    L103:
        boolean r26 = true;
    L104:
        if (r26 == false) goto L96;
    L108:
        c r125 = (c) r123;
        if (r125 == null) goto L113;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r27 = r125.i;
        if (r27 == null) goto L113;
        String r126 = r27.k(c.J.get(Integer.valueOf(c.a.a(r19))));
    L115:
        if (Intrinsics.areEqual(r19, String.valueOf(5)) == false) goto L128;
        Iterator<T> r28 = ((b) ListProtector.get(r8, r14)).c.iterator();
    L118:
        if (r28.hasNext() == false) goto L122;
        Object r29 = r28.next();
        if (Intrinsics.areEqual(((c) r29).getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L118;
    L123:
        c r30 = (c) r29;
        if (r30 == null) goto L128;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r31 = r30.i;
        if (r31 == null) goto L128;
        Integer r127 = r31.h();
    L129:
        r117.h(r116, r118, r122, r126, r127, Integer.valueOf(r14));
        goto L130
    L122:
        r29 = null;
    L128:
        r127 = null;
    L113:
        r126 = null;
        goto L115
    L100:
        if (Intrinsics.areEqual(r124.getType(), HeadViewType.GOOD_COMMENT.getType()) == true) goto L103;
        r26 = false;
        goto L104
    L107:
        r123 = null;
        goto L108
    L93:
        if (Intrinsics.areEqual(r19, String.valueOf(5)) == false) goto L113;
    L85:
        if (r121 != r23) goto L87;
        r24 = "video";
        goto L88
    L87:
        r24 = "picture_video";
        goto L88
    L73:
        if (r119.isEmpty() == false) goto L75;
        r121 = 0;
        goto L83
    L89:
        r122 = null;
        goto L91
    L67:
        r22 = "expansion";
    L130:
        r14 = r16;
        r13 = 0;
        goto L34
    L131:
        return;
    L17:
        PagerAdapter r32 = getAdapter();
        if ((r32 instanceof AnchorV4HeadViewAdapter) == true) goto L20;
        r32 = null;
    L20:
        AnchorV4HeadViewAdapter r33 = (AnchorV4HeadViewAdapter) r32;
        if (r33 == null) goto L23;
        ArrayList r34 = new ArrayList();
        r34.addAll(getHeadViewHolders());
        Unit r35 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r34, "viewHolder");
        r33.e = r34;
        r33.notifyDataSetChanged();
        goto L23
    L13:
        r5 = CollectionsKt.emptyList();
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r1 = r5.getAction();     // Catch: Exception -> L21
        if (r1 != 0) goto L6;
        this.a = r5.getX();     // Catch: Exception -> L21
        this.b = r5.getY();     // Catch: Exception -> L21
    L17:
        if (this.c == false) goto L19;
        super.onTouchEvent(r5);     // Catch: Exception -> L21
        boolean r6 = this.c;     // Catch: Exception -> L21
    L25:
        return r6;
    L19:
        r6 = super.onTouchEvent(r5);     // Catch: Exception -> L21
        goto L25
    L6:
        if (r1 != 2) goto L17;
        if (Math.abs(r5.getY() - this.b) > Math.abs(r5.getX() - this.a)) goto L13;
        ViewParent r2 = getParent();     // Catch: Exception -> L21
        boolean r3 = true;
        if (r2 == null) goto L14;
        r2.requestDisallowInterceptTouchEvent(true);     // Catch: Exception -> L21
    L14:
        this.c = r3;     // Catch: Exception -> L21
        goto L17
    L13:
        r3 = false;
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.k = r2;
    }

    public final void setCollisionNegotiator(l53.b r2) {
        Intrinsics.checkNotNullParameter(r2, "collisionNegotiator");
        this.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCurrentItem(int r1) {
        super.setCurrentItem(r1);
        if (ViewCompat.isAttachedToWindow(this) == true) goto L6;
        this.n = true;
        return;
    }

    public final void setOnHolderIndicatorChangedListener(n r1) {
        this.e = r1;
    }

    public final int j(int r4, int r5) {
        Collection r0 = (Collection) CollectionsKt.getOrNull(this.h, r4);
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return -1;
    L11:
        int r3 = 0;
    L12:
        if (r1 >= r4) goto L15;
        r3 = r3 + ((List) ListProtector.get(this.h, r1)).size();
        r1 = r1 + 1;
        goto L12
    L15:
        return RangesKt.coerceAtMost(r5, ((List) ListProtector.get(this.h, r4)).size()) + r3;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r2, Object r3) {
        com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r0 = this.k;
        if (r0 == null) goto L6;
        r0.l0(r2, r3);
        return;
    }

    public final void onMeasure(int r3, int r4) {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r0 = this.q;
        if (r0 != null) goto L5;
    L17:
        r4 = r3;
    L23:
        super.onMeasure(r3, r4);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (r0.i() != true) goto L17;
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == true) goto L17;
        float r1 = this.m;
        if (r1 < 0.0f) goto L15;
        if (r1 <= 1.0f) goto L23;
    L15:
        if (this.q.n() == false) goto L17;
        int r5 = View.MeasureSpec.getMode(r3);
        r4 = View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(r3) * 4) / 3, r5);
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCurrentItem(int r1, boolean r2) {
        super.setCurrentItem(r1, r2);
        if (ViewCompat.isAttachedToWindow(this) == true) goto L6;
        this.n = true;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r2, Action r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "action");
        com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r0 = this.k;
        if (r0 == null) goto L6;
        r0.O0(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.e
    public final void a(Integer r8, com.bytedance.android.shopping.anchorv4.voavhs.head.base.p r9, Boolean r10) {
        if (getHeadViewHolders().size() > 1) goto L5;
        return;
    L5:
        if (this.j == true) goto L66;
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = FindSameSource.DEFAULT;
        HeadViewHolderBuilder r2 = this.g;
        String r3 = null;
        if (r2 == null) goto L12;
        CommonFindSameElement r4 = r2.a();
        if (r4 == null) goto L12;
        Map<String, Object> r5 = r4.getRequestParams();
    L13:
        r0.element = FindSameSource.HEAD_VH;
        if (r5 != null) goto L22;
        f83.l r6 = this.r;
        if (r6 == null) goto L20;
        CommonFindSameElement r7 = r6.getFindSameElement();
        if (r7 == null) goto L20;
        r5 = r7.getRequestParams();
    L21:
        r0.element = FindSameSource.HEAD_INDICATOR;
    L20:
        r5 = null;
    L22:
        HeadViewHolderBuilder r11 = this.g;
        if (r11 == null) goto L28;
        CommonFindSameElement r12 = r11.a();
        if (r12 == null) goto L28;
        Integer r13 = r12.getType();
        if (r13 == null) goto L28;
    L34:
        boolean r14 = false;
        if (ECSettingKeys.u() == 0) goto L37;
    L39:
        boolean r15 = false;
    L40:
        f83.p r16 = this.p;
        if (r16 == null) goto L43;
        Integer r17 = Integer.valueOf(r16.d());
    L44:
        int r18 = com.bytedance.android.shopping.extensions.k.f(r17);
        if (r8 == null) goto L47;
        int r19 = r8.intValue();
    L49:
        if (((r18 - r19) - 1) > ECSettingKeys.u()) goto L51;
        r14 = true;
    L51:
        if (r9 == null) goto L53;
        r3 = r9.getType();
    L53:
        boolean r20 = Intrinsics.areEqual(r3, HeadViewType.FIND_SAME.getType());
        if (r15 == true) goto L57;
        if (r14 == true) goto L57;
        if (r20 == true) goto L57;
        return;
    L57:
        if (r5 == null) goto L65;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r21 = this.q;
        if (r21 == null) goto L61;
        r21.j(new a(r5, r13), (FindSameSource) r0.element);
    L61:
        this.j = true;
        return;
    L65:
        return;
    L47:
        r19 = 0;
        goto L49
    L43:
        r17 = null;
        goto L44
    L37:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L39;
        r15 = true;
    L28:
        f83.l r22 = this.r;
        if (r22 == null) goto L33;
        CommonFindSameElement r23 = r22.getFindSameElement();
        if (r23 == null) goto L33;
        r13 = r23.getType();
    L33:
        r13 = null;
    L12:
        r5 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.f
    public final void c(int r6, boolean r7, com.bytedance.android.shopping.anchorv4.voavhs.head.base.p r8) {
        Intrinsics.checkNotNullParameter(r8, "itemViewDetail");
        List<Integer> r1 = this.i;
        ListProtector.set(r1, 0, ListProtector.get(r1, 1));
        ListProtector.set(this.i, 1, Integer.valueOf(r6));
        HeadViewHolderBuilder r2 = this.g;
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r8, "itemViewDetail");
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r0 = r2.e.get(r8.getType());
        if ((r0 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L7;
        r0 = null;
    L7:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r3 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r0;
        if (r3 == null) goto L11;
        r3.f(r7, r8.c);
    L11:
        if (getEnableOptimize() == true) goto L15;
        f83.p r4 = this.p;
        if (r4 == null) goto L15;
        r4.b(r6, r7);
    L15:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.e.a.a(this, Integer.valueOf(r6), r8, null, 4);
        f83.p r9 = this.p;
        if (r9 == null) goto L18;
        r9.e(Integer.valueOf(r6));
    L18:
        ExtensionsKt.e(this, this);
        ExtensionsKt.b(this, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onScrollChanged(r1, r2, r3, r4);
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.e.a.a(this, null, null, Boolean.TRUE, 3);
    }

    public AnchorV4HeadViewPager(Context r3, AttributeSet r4, f83.p r5, t r6, f83.l r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L14;
        r7 = null;
    L14:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.p = r5;
        this.q = r6;
        this.r = r7;
        this.d = LazyKt.lazy(AnchorV4HeadViewPager$headViewHolders$2.INSTANCE);
        this.h = CollectionsKt.emptyList();
        this.i = CollectionsKt.mutableListOf(new Integer[]{-1, -1});
        this.l = LazyKt.lazy(AnchorV4HeadViewPager$enableOptimize$2.INSTANCE);
        this.m = -1.0f;
    }
}
