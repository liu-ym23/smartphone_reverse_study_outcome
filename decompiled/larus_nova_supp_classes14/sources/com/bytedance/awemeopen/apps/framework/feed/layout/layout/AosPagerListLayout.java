package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleColorBallAnimationView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.FeedSwipeRefreshLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.o;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.PhotoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosDefaultNetErrorView;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosNoMoreFeedErrorView;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\u00020\u0006:\u0003VWXB\u000f\u0012\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010UJ\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0004R\"\u0010\u0019\u001a\u00020\u00128\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R2\u00109\u001a\u001202R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00008\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010=\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010D\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\"\u0010F\u001a\u00020:8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bE\u0010<\u001a\u0004\bF\u0010>\"\u0004\bG\u0010@R\"\u0010I\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010<\u001a\u0004\bI\u0010>\"\u0004\bJ\u0010@R\"\u0010Q\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006Y"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout;", "Model", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosBaseLayout;", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DoubleBallSwipeRefreshLayout$g;", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/g;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$PullDownType;", "getPullDownType", "Landroid/os/Bundle;", "bundle", "", "setArguments", "Lb54/a;", "getSwipeChangeListener", "", "index", "setCurrentItem", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", "j", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", "getStatusView", "()Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", "setStatusView", "(Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;)V", "statusView", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/FeedSwipeRefreshLayout;", "k", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/FeedSwipeRefreshLayout;", "getRefreshLayout", "()Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/FeedSwipeRefreshLayout;", "setRefreshLayout", "(Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/FeedSwipeRefreshLayout;)V", "refreshLayout", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/LoadMoreFrameLayout;", "l", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/LoadMoreFrameLayout;", "getLoadMoreLayout", "()Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/LoadMoreFrameLayout;", "setLoadMoreLayout", "(Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/LoadMoreFrameLayout;)V", "loadMoreLayout", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "m", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "getViewPager", "()Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "setViewPager", "(Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;)V", "viewPager", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;", "q", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;", "getAdapter", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;", "setAdapter", "(Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;)V", "adapter", "", "y", "Z", "isDataListFirstChange", "()Z", "setDataListFirstChange", "(Z)V", "z", "getNeedRecallOnSelectIfNeed", "setNeedRecallOnSelectIfNeed", "needRecallOnSelectIfNeed", "A", "isInitDataEmpty", "setInitDataEmpty", "B", "isFirstEnter", "setFirstEnter", "C", "I", "getNeedUpdateCount", "()I", "setNeedUpdateCount", "(I)V", "needUpdateCount", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "AosFeedItemAdapter", "a", "PullDownType", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosPagerListLayout<Model, VM extends AosPagerListViewModel<Model>> extends AosBaseLayout<VM> implements DoubleBallSwipeRefreshLayout.g, com.bytedance.awemeopen.apps.framework.base.view.refresh.g {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public boolean B;
    public int C;
    public boolean i;
    public DmtStatusView j;
    public FeedSwipeRefreshLayout k;
    public LoadMoreFrameLayout l;
    public VerticalViewPager m;
    public FrameLayout n;
    public DoubleColorBallAnimationView o;
    public AoImageView p;
    public AosPagerListLayout<Model, VM>.AosFeedItemAdapter q;
    public o r;
    public f54.a s;
    public PullDownType t;
    public long u;
    public long v;
    public long w;
    public final e x;
    public boolean y;
    public boolean z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/MultiTypePagerAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public final class AosFeedItemAdapter extends MultiTypePagerAdapter {
        public final HashMap<Model, com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model>> b;
        public final /* synthetic */ AosPagerListLayout<Model, VM> c;

        public final int getCount() {
            Object r0 = this.c.getVm().getDataList().getValue();
            Intrinsics.checkNotNull(r0);
            return ((List) ((ListState) r0).a).size();
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final List<Integer> h() {
            return this.c.v();
        }

        public AosFeedItemAdapter(AosPagerListLayout r1) {
            this.c = r1;
            r1.getContext();
            this.b = new HashMap();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final int f(int r3) {
            AosPagerListLayout<Model, VM> r0 = this.c;
            Object r1 = ((AosPagerListViewModel) r0.getVm()).getDataList().getValue();
            Intrinsics.checkNotNull(r1);
            return r0.u(r3, ListProtector.get((List) ((ListState) r1).a, r3));
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final int g(View r2) {
            if (r2 == null) goto L4;
            Object r3 = r2.getTag(2131372247);
        L6:
            if ((r3 instanceof Integer) == true) goto L10;
            return 1;
        L10:
            return ((Number) r3).intValue();
        L4:
            r3 = null;
            goto L6
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final int getItemPosition(Object r5) {
            Intrinsics.checkNotNullParameter(r5, "any");
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> r6 = l(r5);
            if (r6 == null) goto L16;
            int r0 = getCount();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L22;
            Object r2 = this.c.getVm().getDataList().getValue();
            Intrinsics.checkNotNull(r2);
            Object r3 = ListProtector.get((List) ((ListState) r2).a, r1);
            if (r3 == null) goto L15;
            if (this.c.t((Model) r3, r6) == false) goto L15;
            AosPagerListLayout<Model, VM> r4 = this.c;
            int r7 = r4.getNeedUpdateCount();
            r4.setNeedUpdateCount(r7 - 1);
            if (r7 < 0) goto L14;
            r6.m();
        L14:
            return r1;
        L15:
            r1 = r1 + 1;
            goto L5
        L22:
            return -2;
        L16:
            return -2;
        }

        public final com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> k(Model r2) {
            return this.b.get(r2);
        }

        public final com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> l(Object r3) {
            if ((r3 instanceof View) == false) goto L5;
            View r4 = (View) r3;
        L6:
            if (r4 == null) goto L8;
            Object r5 = r4.getTag(2131372246);
        L10:
            if ((r5 instanceof com.bytedance.awemeopen.apps.framework.framework.viewpager.g) == true) goto L12;
            return null;
        L12:
            return (com.bytedance.awemeopen.apps.framework.framework.viewpager.g) r5;
        L8:
            r5 = null;
            goto L10
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final void j(View r2, int r3) {
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> r4 = l(r2);
            HashMap<Model, com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model>> r5 = this.b;
            if (r4 == null) goto L5;
            Model r0 = r4.b;
        L6:
            TypeIntrinsics.asMutableMap(r5).remove(r0);
            if (r4 == null) goto L10;
            r4.k();
            return;
        L10:
            return;
        L5:
            r0 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final View i(int r7, View r8, ViewGroup r9) {
            Object r0 = this.c.getVm().getDataList().getValue();
            Intrinsics.checkNotNull(r0);
            Object r1 = ListProtector.get((List) ((ListState) r0).a, r7);
            int r2 = f(r7);
            if (r8 == null) goto L5;
            boolean r3 = Intrinsics.areEqual(r8.getTag(2131372247), Integer.valueOf(r2));
        L7:
            if (h().contains(Integer.valueOf(r2)) == true) goto L12;
            if (r8 == null) goto L12;
            if (r3 == false) goto L12;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> r10 = l(r8);
            Intrinsics.checkNotNull(r10);
            View r11 = r8;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g r12 = r10;
        L13:
            this.b.put(r1, r12);
            r12.c(r1, r7);
            return r11;
        L12:
            AosPagerListLayout<Model, VM> r13 = this.c;
            Intrinsics.checkNotNull(r9);
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g r14 = r13.s(r9, r2, r1);
            View r15 = r14.a;
            r15.setTag(2131372247, Integer.valueOf(r2));
            r15.setTag(2131372246, r14);
            r11 = r15;
            r12 = r14;
            goto L13
        L5:
            r3 = false;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$PullDownType;", "", "NONE", "REFRESH", "LOAD_FORWARD", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum PullDownType extends Enum<PullDownType> {
        public static final PullDownType LOAD_FORWARD = null;
        public static final PullDownType NONE = null;
        public static final PullDownType REFRESH = null;
        public static final /* synthetic */ PullDownType[] a = null;

        public static PullDownType valueOf(String r1) {
            return (PullDownType) r27.a.a(PullDownType.class, r1);
        }

        public static PullDownType[] values() {
            return (PullDownType[]) a.clone();
        }

        static {
            PullDownType r0 = new PullDownType("NONE", 0);
            NONE = r0;
            PullDownType r1 = new PullDownType("REFRESH", 1);
            REFRESH = r1;
            PullDownType r3 = new PullDownType("LOAD_FORWARD", 2);
            LOAD_FORWARD = r3;
            a = new PullDownType[]{r0, r1, r3};
        }

        public PullDownType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ListState.State.values().length];
            r0[ListState.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L66:
            r0[ListState.State.REQUEST_LAUNCH_CONFIG_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L78:
            r0[ListState.State.REQUEST_LAUNCH_CONFIG_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L50:
            r0[ListState.State.INITIAL_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L52:
            r0[ListState.State.REFRESH_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L62:
            r0[ListState.State.INITIAL_FAIL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L72:
            r0[ListState.State.REFRESH_FAIL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L58:
            r0[ListState.State.START_LOAD_MORE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L68:
            r0[ListState.State.LOAD_MORE_SUCCESS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L34
        L70:
            r0[ListState.State.LOAD_MORE_FAIL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L35
        L46:
            r0[ListState.State.START_LOAD_FORWARD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L36
        L64:
            r0[ListState.State.LOAD_FORWARD_SUCCESS.ordinal()] = 12;     // Catch: NoSuchFieldError -> L37
        L76:
            r0[ListState.State.LOAD_FORWARD_FAIL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L38
        L44:
            r0[ListState.State.DISLIKE_CURRENT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L39
        L54:
            r0[ListState.State.DISCARD_AFTER_CURRENT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L40
        L20:
            a = r0;
            int[] r1 = new int[PullDownType.values().length];
            r1[PullDownType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L48:
            r1[PullDownType.LOAD_FORWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L56:
            r1[PullDownType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L24:
            b = r1;
        }
    }

    static {
    }

    private final void T() {
        AoLogger.g("AosPagerListLayout", new Object[]{"onStartRefresh"});
        this.u = SystemClock.elapsedRealtime();
        O();
        getVm().startRefresh();
    }

    public boolean A() {
        return true;
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
    }

    public void F(List<Model> r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    public void J() {
    }

    public void K() {
    }

    public void L(int r1) {
    }

    public void M(boolean r1) {
    }

    public void N(List<Model> r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    public void O() {
    }

    public b54.a getSwipeChangeListener() {
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void k() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.g
    public final void onLoadMore() {
        AoLogger.g("AosPagerListLayout", new Object[]{"onStartLoadMore"});
        this.w = SystemClock.elapsedRealtime();
        getVm().startLoadMore(false);
    }

    public abstract com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> s(ViewGroup r1, int r2, Model r3);

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void setArguments(Bundle r1) {
    }

    public abstract boolean t(Model r1, com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> r2);

    public abstract int u(int r1, Model r2);

    public void w(int r1, Model r2) {
    }

    public int y(List<Model> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return 0;
    }

    public boolean z() {
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void e() {
        f54.a r0 = AosExtConfig.b.J0();
        this.s = r0;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        setStatusView((DmtStatusView) findViewById(2131387318));
        getStatusView().c();
        this.n = (FrameLayout) findViewById(2131375296);
        this.o = (DoubleColorBallAnimationView) findViewById(2131375295);
        this.p = findViewById(2131375294);
        setViewPager((VerticalViewPager) findViewById(2131372236));
        getViewPager().setOffscreenPageLimit(1);
        getViewPager().c(new AosPagerListLayout$initViewPager$1(this));
        setAdapter(new AosFeedItemAdapter(this));
        getViewPager().setAdapter(getAdapter());
        VerticalViewPager r1 = getViewPager();
        e r2 = this.x;
        if (r1.c != null) goto L8;
        r1.c = new ArrayList();
    L8:
        ((ArrayList) r1.c).add(r2);
        FrameLayout r3 = (FrameLayout) findViewById(2131372774);
        DmtTextView r4 = (DmtTextView) findViewById(2131391217);
        this.r = new o((DoubleColorBallAnimationView) findViewById(2131379017), r4, r3);
        setRefreshLayout((FeedSwipeRefreshLayout) findViewById(2131372235));
        getRefreshLayout().setViewPager(getViewPager());
        getRefreshLayout().setOnRefreshListener(this);
        PullDownType r5 = getPullDownType();
        this.t = r5;
        int r6 = b.b[r5.ordinal()];
        if (r6 != 1) goto L11;
        getRefreshLayout().setOnSwipeChangeListener(new l(this));
        getRefreshLayout().setEnabled(true);
    L18:
        getRefreshLayout().setEnabled(A());
        setLoadMoreLayout((LoadMoreFrameLayout) findViewById(2131372233));
        LoadMoreFrameLayout r7 = getLoadMoreLayout();
        VerticalViewPager r8 = getViewPager();
        FeedSwipeRefreshLayout r9 = getRefreshLayout();
        r7.b = r8;
        r7.c = r9;
        getLoadMoreLayout().setLabel(AosPagerListViewModel.API_TYPE_FEED);
        getLoadMoreLayout().setLoadMoreListener(this);
        getLoadMoreLayout().setOnLoadMoreUiListener(new k(this));
        getLoadMoreLayout().setEnabled(z());
        return;
    L11:
        if (r6 != 2) goto L13;
        getRefreshLayout().setEnabled(true);
        goto L18
    L13:
        if (r6 != 3) goto L18;
        getRefreshLayout().setEnabled(false);
        goto L18
    }

    public final AosPagerListLayout<Model, VM>.AosFeedItemAdapter getAdapter() {
        AosPagerListLayout<Model, VM>.AosFeedItemAdapter r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final LoadMoreFrameLayout getLoadMoreLayout() {
        LoadMoreFrameLayout r0 = this.l;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
        return null;
    }

    public final FeedSwipeRefreshLayout getRefreshLayout() {
        FeedSwipeRefreshLayout r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        return null;
    }

    public final DmtStatusView getStatusView() {
        DmtStatusView r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        return null;
    }

    public final VerticalViewPager getViewPager() {
        VerticalViewPager r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.g
    public final void onRefresh() {
        int r0 = b.b[this.t.ordinal()];
        if (r0 != 1) goto L5;
        T();
        return;
    L5:
        if (r0 != 2) goto L11;
        AoLogger.g("AosPagerListLayout", new Object[]{"onStartLoadForward"});
        this.v = SystemClock.elapsedRealtime();
        getVm().loadForward();
        return;
    }

    public List<Integer> v() {
        return new ArrayList();
    }

    public final void x() {
        FrameLayout r0 = this.n;
        DoubleColorBallAnimationView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingFl");
        r0 = null;
    L5:
        x54.b.a(r0);
        DoubleColorBallAnimationView r2 = this.o;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r2 = null;
    L9:
        if (r2.k == false) goto L16;
        DoubleColorBallAnimationView r3 = this.o;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L14:
        r1.d();
        return;
    L13:
        r1 = r3;
        goto L14
    }

    public final void B() {
        getRefreshLayout().setRefreshing(true);
        T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void G() {
        ListState r0 = (ListState) getVm().getDataList().getValue();
        if (r0 == null) goto L23;
        List r1 = (List) r0.a;
        if (r1 == null) goto L27;
        int r2 = getVm().getCurrentSelectedIndex();
        if (r2 >= 0) goto L10;
        return;
    L10:
        if (r2 >= r1.size()) goto L25;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g r3 = getAdapter().k(ListProtector.get(r1, r2));
        PhotoFeedViewHolder r4 = null;
        if ((r3 instanceof VideoFeedViewHolder) == false) goto L14;
        VideoFeedViewHolder r5 = (VideoFeedViewHolder) r3;
    L15:
        if (r5 == null) goto L18;
        r5.e.c.getLoadMoreUiShow().setValue(Boolean.FALSE);
    L18:
        if ((r3 instanceof PhotoFeedViewHolder) == false) goto L20;
        r4 = (PhotoFeedViewHolder) r3;
    L20:
        if (r4 == null) goto L26;
        r4.e.c.getLoadMoreUiShow().setValue(Boolean.FALSE);
        return;
    L26:
        return;
    L14:
        r5 = null;
        goto L15
    L25:
        return;
    L27:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void H() {
        ListState r0 = (ListState) getVm().getDataList().getValue();
        if (r0 == null) goto L23;
        List r1 = (List) r0.a;
        if (r1 == null) goto L27;
        int r2 = getVm().getCurrentSelectedIndex();
        if (r2 >= 0) goto L10;
        return;
    L10:
        if (r2 >= r1.size()) goto L25;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g r3 = getAdapter().k(ListProtector.get(r1, r2));
        PhotoFeedViewHolder r4 = null;
        if ((r3 instanceof VideoFeedViewHolder) == false) goto L14;
        VideoFeedViewHolder r5 = (VideoFeedViewHolder) r3;
    L15:
        if (r5 == null) goto L18;
        r5.e.c.getLoadMoreUiShow().setValue(Boolean.TRUE);
    L18:
        if ((r3 instanceof PhotoFeedViewHolder) == false) goto L20;
        r4 = (PhotoFeedViewHolder) r3;
    L20:
        if (r4 == null) goto L26;
        r4.e.c.getLoadMoreUiShow().setValue(Boolean.TRUE);
        return;
    L26:
        return;
    L14:
        r5 = null;
        goto L15
    L25:
        return;
    L27:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void h() {
        getVm().getDataList().observe(this, new f(this));
        getVm().getSelectedIndex().observe(this, new d(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void i() {
        AosPagerListLayout<Model, VM>.AosFeedItemAdapter r0 = getAdapter();
        Iterator<T> r1 = r0.b.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.awemeopen.apps.framework.framework.viewpager.g) r1.next()).k();
        goto L4
    L6:
        r0.b.clear();
        VerticalViewPager r2 = getViewPager();
        e r3 = this.x;
        List<com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.b> r4 = r2.c;
        if (r4 == null) goto L12;
        ((ArrayList) r4).remove(r3);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public boolean l() {
        if ((getContext() instanceof Activity) == false) goto L6;
        int r0 = w04.a.a;
        return w04.a.b((Activity) getContext());
    L6:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public void onResume() {
        super.onResume();
        if (this.B == true) goto L7;
        this.C = 2;
        PagerAdapter r0 = getViewPager().getAdapter();
        if (r0 == null) goto L9;
        r0.notifyDataSetChanged();
        return;
    L9:
        return;
    L7:
        this.B = false;
    }

    public final boolean getNeedRecallOnSelectIfNeed() {
        return this.z;
    }

    public final int getNeedUpdateCount() {
        return this.C;
    }

    public PullDownType getPullDownType() {
        return PullDownType.REFRESH;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.layout.layout.e] */
    public AosPagerListLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.t = PullDownType.REFRESH;
        this.x = new e(this);
        this.y = true;
        this.B = true;
        this.C = -1;
    }

    public static final void r(AosPagerListLayout r4) {
        DoubleColorBallAnimationView r0 = r4.o;
        DoubleColorBallAnimationView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r0 = null;
    L5:
        r0.setVisibility(0);
        DoubleColorBallAnimationView r5 = r4.o;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L9:
        r1.c();
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void P(boolean r7) {
        getRefreshLayout().setRefreshing(false);
        if (r7 == false) goto L13;
        x();
        DmtStatusView.a r2 = DmtStatusView.a.a(getContext());
        DmtStatusView r3 = getStatusView();
        Intrinsics.checkNotNullParameter(r3, "statusView");
        AosDefaultNetErrorView r4 = new AosDefaultNetErrorView(r3.getContext());
        r4.findViewById(2131384465).setOnClickListener(new i(this));
        r4.b();
        r2.d(r4);
        AosNoMoreFeedErrorView r5 = new AosNoMoreFeedErrorView(getStatusView().getContext());
        r2.e = r5;
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        getStatusView().setBuilder(r2);
        ListState r6 = (ListState) getVm().getDataList().getValue();
        if (r6 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L12;
        DmtStatusView r9 = getStatusView();
        r9.setVisibility(0);
        r9.setStatus(3);
        goto L13
    L12:
        getStatusView().d();
        goto L13
    L7:
        if (r6.j != 12100) goto L9;
        r8 = true;
    L13:
        AoLogger.g("AosPagerListLayout", new Object[]{"onRefreshFail"});
        S(r7, false, getVm().getApiType());
        M(r7);
    }

    public final void Q(boolean r4) {
        AoLogger.g("AosPagerListLayout", new Object[]{"reportLoadMoreRate showLoading:" + r4});
        AosEventReporter r0 = AosEventReporter.a;
        String r1 = getVm().sceneId();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "scene");
        d14.a r2 = b14.a.a;
        b14.a.a(t24.a.class).a0(r1, r4, null);
    }

    public final void setAdapter(AosPagerListLayout<Model, VM>.AosFeedItemAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.q = r2;
    }

    public final void setCurrentItem(int r3) {
        if (getViewPager().getCurrentItem() == r3) goto L6;
        getViewPager().y(r3, false);
        return;
    }

    public final void setDataListFirstChange(boolean r1) {
        this.y = r1;
    }

    public final void setFirstEnter(boolean r1) {
        this.B = r1;
    }

    public final void setInitDataEmpty(boolean r1) {
        this.A = r1;
    }

    public final void setLoadMoreLayout(LoadMoreFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final void setNeedRecallOnSelectIfNeed(boolean r1) {
        this.z = r1;
    }

    public final void setNeedUpdateCount(int r1) {
        this.C = r1;
    }

    public final void setRefreshLayout(FeedSwipeRefreshLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setStatusView(DmtStatusView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public final void setViewPager(VerticalViewPager r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void p(final AosPagerListLayout r11, ListState r12) {
        Intrinsics.checkNotNullParameter(r11, "this$0");
        boolean r1 = true;
        if (r11.y == false) goto L8;
        r11.y = false;
        if (r12.c == ListState.State.NEW) goto L8;
        r11.z = true;
        return;
    L8:
        switch(b.a[r12.c.ordinal()]) {
            case 1: goto L122;
            case 2: goto L121;
            case 3: goto L120;
            case 4: goto L65;
            case 5: goto L65;
            case 6: goto L64;
            case 7: goto L63;
            case 8: goto L190;
            case 9: goto L41;
            case 10: goto L37;
            case 11: goto L36;
            case 12: goto L21;
            case 13: goto L17;
            case 14: goto L13;
            case 15: goto L10;
            default: goto L190;
        };
    L10:
        ((AosPagerListViewModel) r11.getVm()).removeDataAfterIndex();
        PagerAdapter r13 = r11.getViewPager().getAdapter();
        if (r13 == null) goto L177;
        r13.notifyDataSetChanged();
        return;
    L177:
        return;
    L13:
        PagerAdapter r14 = r11.getViewPager().getAdapter();
        if (r14 == null) goto L16;
        r14.notifyDataSetChanged();
    L16:
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) r11.getVm(), r11.getViewPager().getCurrentItem(), true, false, 4, null);
        return;
    L17:
        r11.getRefreshLayout().setRefreshing(false);
        AoLogger.g("AosPagerListLayout", new Object[]{"onLoadForwardFail"});
        String r10 = ((AosPagerListViewModel) r11.getVm()).getApiType();
        if (r11.v <= 0) goto L20;
        r11.R(false, SystemClock.elapsedRealtime() - r11.v, "loadForward", r10);
        r11.v = 0;
    L20:
        r11.D();
        return;
    L21:
        r11.getRefreshLayout().setRefreshing(false);
        ListState r15 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        if (r15 != null) goto L24;
    L26:
        boolean r16 = false;
    L27:
        if (r16 == true) goto L29;
        r11.getRefreshLayout().setEnabled(false);
    L29:
        ((AosPagerListViewModel) r11.getVm()).tempData2ListForLoadForward();
        PagerAdapter r17 = r11.getViewPager().getAdapter();
        if (r17 == null) goto L32;
        r17.notifyDataSetChanged();
    L32:
        AoLogger.g("AosPagerListLayout", new Object[]{"onLoadForwardSuccess"});
        String r18 = ((AosPagerListViewModel) r11.getVm()).getApiType();
        if (r11.v <= 0) goto L35;
        r11.R(true, SystemClock.elapsedRealtime() - r11.v, "loadForward", r18);
        r11.v = 0;
    L35:
        Object r19 = ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r19);
        List r110 = (List) ((ListState) r19).a;
        ListState r111 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        Intrinsics.checkNotNullParameter(r110, "data");
        return;
    L24:
        if (r15.h != true) goto L26;
        r16 = true;
        goto L27
    L36:
        ((AosPagerListViewModel) r11.getVm()).loadForwardData(((AosPagerListViewModel) r11.getVm()).getLoadForwardCallback());
        return;
    L37:
        r11.Q(r11.i);
        r11.getLoadMoreLayout().f();
        AoLogger.g("AosPagerListLayout", new Object[]{"onLoadMoreFail"});
        String r112 = ((AosPagerListViewModel) r11.getVm()).getApiType();
        if (r11.w <= 0) goto L40;
        r11.R(false, SystemClock.elapsedRealtime() - r11.w, "loadMore", r112);
        r11.w = 0;
    L40:
        r11.E();
        r11.i = false;
        return;
    L41:
        r11.Q(r11.i);
        ListState r113 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        if (r113 != null) goto L44;
    L46:
        boolean r114 = false;
    L47:
        if (r114 == false) goto L49;
        r11.getLoadMoreLayout().f();
    L50:
        ((AosPagerListViewModel) r11.getVm()).tempData2ListForLoadMore();
        PagerAdapter r115 = r11.getViewPager().getAdapter();
        if (r115 == null) goto L53;
        r115.notifyDataSetChanged();
    L53:
        AoLogger.g("AosPagerListLayout", new Object[]{"onLoadMoreSuccess"});
        String r116 = ((AosPagerListViewModel) r11.getVm()).getApiType();
        if (r11.w <= 0) goto L56;
        r11.R(true, SystemClock.elapsedRealtime() - r11.w, "loadMore", r116);
        r11.w = 0;
    L56:
        Object r117 = ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r117);
        List<Model> r118 = (List) ((ListState) r117).a;
        ListState r0 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        if (r0 != null) goto L59;
    L61:
        r1 = false;
    L62:
        r11.F(r118, r1, r11.i);
        r11.i = false;
        return;
    L59:
        if (r0.g != true) goto L61;
    L49:
        r11.getLoadMoreLayout().g();
        goto L50
    L44:
        if (r113.g != true) goto L46;
        r114 = true;
        goto L47
    L63:
        r11.P(false);
        return;
    L64:
        r11.P(true);
        return;
    L65:
        r11.x();
        r11.getRefreshLayout().setRefreshing(false);
        r11.getStatusView().c();
        ((AosPagerListViewModel) r11.getVm()).tempData2ListForRefresh();
        if (((AosPagerListViewModel) r11.getVm()).getCurrentState() != ListState.State.INITIAL_SUCCESS) goto L68;
        boolean r119 = true;
    L69:
        Object r3 = ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r3);
        final int r4 = r11.y((List) ((ListState) r3).a);
        if (r4 <= 0) goto L75;
        r11.getViewPager().setmRestoredCurItem(r4);
        PagerAdapter r5 = r11.getViewPager().getAdapter();
        if (r5 == null) goto L74;
        r5.notifyDataSetChanged();
    L74:
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) r11.getVm(), r4, true, false, 4, null);
    L78:
        if (r119 == false) goto L88;
        ListState r6 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        if (r6 == null) goto L86;
        List r7 = (List) r6.a;
        if (r7 == null) goto L86;
        if (r7.isEmpty() != true) goto L86;
        boolean r8 = true;
    L87:
        r11.A = r8;
    L86:
        r8 = false;
    L88:
        Object r9 = ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r9);
        ListState.State r20 = ((ListState) r9).c;
        r11.getViewPager().post(new j(r4, r11));
        if (r11.t != PullDownType.LOAD_FORWARD) goto L98;
        ListState r21 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        if (r21 != null) goto L93;
    L95:
        boolean r22 = false;
    L96:
        if (r22 == true) goto L98;
        r11.getRefreshLayout().setEnabled(false);
        goto L98
    L93:
        if (r21.h != true) goto L95;
        r22 = true;
    L98:
        ListState r23 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        if (r23 != null) goto L101;
    L103:
        boolean r24 = false;
    L104:
        if (r24 == false) goto L106;
        r11.getLoadMoreLayout().f();
    L107:
        AoLogger.g("AosPagerListLayout", new Object[]{"onRefreshSuccess"});
        r11.S(r119, true, ((AosPagerListViewModel) r11.getVm()).getApiType());
        Object r120 = ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r120);
        List<Model> r121 = (List) ((ListState) r120).a;
        ListState r2 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        if (r2 != null) goto L110;
    L112:
        boolean r25 = false;
    L113:
        ListState r26 = (ListState) ((AosPagerListViewModel) r11.getVm()).getDataList().getValue();
        if (r26 != null) goto L116;
    L118:
        r1 = false;
    L119:
        r11.N(r121, r25, r1);
        return;
    L116:
        if (r26.g != true) goto L118;
    L110:
        if (r2.h != true) goto L112;
        r25 = true;
        goto L113
    L106:
        r11.getLoadMoreLayout().g();
        goto L107
    L101:
        if (r23.g != true) goto L103;
        r24 = true;
        goto L104
    L75:
        PagerAdapter r27 = r11.getViewPager().getAdapter();
        if (r27 == null) goto L78;
        r27.notifyDataSetChanged();
        goto L78
    L68:
        r119 = false;
        goto L69
    L120:
        r11.P(true);
        return;
    L121:
        r11.C();
        return;
    L122:
        r11.getStatusView().c();
        FrameLayout r122 = r11.n;
        DoubleColorBallAnimationView r28 = null;
        if (r122 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingFl");
        r122 = null;
    L125:
        x54.b.d(r122);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.j r123 = ((AosPagerListViewModel) r11.getVm()).getHostCoverParams();
        if (r123 == null) goto L155;
        String r29 = r123.a;
        if (r29 == null) goto L155;
        int r30 = r123.b;
        int r31 = r123.c;
        int r32 = r123.d;
        ImageView r33 = r11.p;
        if (r33 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r33 = null;
    L132:
        int r34 = r33.getMeasuredWidth();
        ImageView r35 = r11.p;
        if (r35 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r35 = null;
    L135:
        int r36 = r35.getMeasuredHeight();
        if (r34 != 0) goto L138;
        r34 = d0.d(r11.getContext());
    L138:
        if (r36 != 0) goto L140;
        r36 = d0.c(r11.getContext()) - r32;
    L140:
        ImageView r37 = r11.p;
        if (r37 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r37 = null;
    L143:
        c64.b r38 = new k04.a(false, r37.getContext(), null).a(r30, r31, r34, r36);
        Size r39 = r38.a;
        FrameLayout.LayoutParams r40 = new FrameLayout.LayoutParams(r39.getWidth(), r39.getHeight());
        r40.gravity = 17;
        ImageView r41 = r11.p;
        if (r41 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r41 = null;
    L146:
        r41.setLayoutParams(r40);
        AoImageView r42 = r11.p;
        if (r42 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r42 = null;
    L149:
        com.bytedance.awemeopen.infra.base.image.b r43 = new com.bytedance.awemeopen.infra.base.image.b(r29);
        r43.m = r38.b;
        Context r44 = r11.getContext();
        if (r44 == null) goto L153;
        Drawable r45 = ContextCompat.getDrawable(r44, 2131231461);
        r43.j = 0;
        r43.i = r45;
    L153:
        r42.j(r43);
        AoPool.e(new AosPagerListLayout$showInitLoading$1$1$2(r11), r123.e);
        r1 = false;
    L155:
        if (r1 == false) goto L164;
        DoubleColorBallAnimationView r46 = r11.o;
        if (r46 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r46 = null;
    L159:
        r46.setVisibility(0);
        DoubleColorBallAnimationView r47 = r11.o;
        if (r47 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L163:
        r28.c();
    L174:
        r11.getViewPager().post(new g(r11));
        return;
    L162:
        r28 = r47;
        goto L163
    L164:
        DoubleColorBallAnimationView r48 = r11.o;
        if (r48 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r48 = null;
    L168:
        if (r48.k == false) goto L174;
        DoubleColorBallAnimationView r49 = r11.o;
        if (r49 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L173:
        r28.d();
        goto L174
    L172:
        r28 = r49;
        goto L173
    }

    public final void S(boolean r13, boolean r14, String r15) {
        if (r13 == false) goto L5;
        return;
    L5:
        if (this.u <= 0) goto L8;
        R(r14, SystemClock.elapsedRealtime() - this.u, "pullRefresh", r15);
        this.u = 0;
        return;
    }

    public final void R(boolean r9, long r10, String r12, String r13) {
        AoLogger.g("AosPagerListLayout", new Object[]{"reportManualLoadingResult isSuccess:" + r9 + " duration:" + r10 + " loadingType:" + r12});
        AosEventReporter r1 = AosEventReporter.a;
        int r4 = !r9 ? 1 : 0;
        String r5 = getVm().sceneId();
        r1.getClass();
        AosEventReporter.x(r10, r4, r5, r12, r13);
    }
}
