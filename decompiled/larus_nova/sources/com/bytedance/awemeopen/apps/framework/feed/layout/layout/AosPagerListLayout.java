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
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
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
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\u00020\u0006:\u0003VWXB\u000f\u0012\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010UJ\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0004R\"\u0010\u0019\u001a\u00020\u00128\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R2\u00109\u001a\u001202R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00008\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010=\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010D\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\"\u0010F\u001a\u00020:8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bE\u0010<\u001a\u0004\bF\u0010>\"\u0004\bG\u0010@R\"\u0010I\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010<\u001a\u0004\bI\u0010>\"\u0004\bJ\u0010@R\"\u0010Q\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006Y"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout;", ExifInterface.TAG_MODEL, "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosBaseLayout;", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DoubleBallSwipeRefreshLayout$g;", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/g;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$PullDownType;", "getPullDownType", "Landroid/os/Bundle;", "bundle", "", "setArguments", "Lb54/a;", "getSwipeChangeListener", "", "index", "setCurrentItem", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", ce.f26395j, "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", "getStatusView", "()Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;", "setStatusView", "(Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtStatusView;)V", "statusView", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/FeedSwipeRefreshLayout;", ce.f26396k, "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/FeedSwipeRefreshLayout;", "getRefreshLayout", "()Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/FeedSwipeRefreshLayout;", "setRefreshLayout", "(Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/FeedSwipeRefreshLayout;)V", "refreshLayout", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/LoadMoreFrameLayout;", "l", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/LoadMoreFrameLayout;", "getLoadMoreLayout", "()Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/LoadMoreFrameLayout;", "setLoadMoreLayout", "(Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/LoadMoreFrameLayout;)V", "loadMoreLayout", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "m", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "getViewPager", "()Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "setViewPager", "(Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;)V", "viewPager", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;", "q", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;", "getAdapter", "()Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;", "setAdapter", "(Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;)V", "adapter", "", "y", "Z", "isDataListFirstChange", "()Z", "setDataListFirstChange", "(Z)V", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getNeedRecallOnSelectIfNeed", "setNeedRecallOnSelectIfNeed", "needRecallOnSelectIfNeed", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isInitDataEmpty", "setInitDataEmpty", "B", "isFirstEnter", "setFirstEnter", "C", "I", "getNeedUpdateCount", "()I", "setNeedUpdateCount", "(I)V", "needUpdateCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "AosFeedItemAdapter", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PullDownType", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosPagerListLayout<Model, VM extends AosPagerListViewModel<Model>> extends AosBaseLayout<VM> implements DoubleBallSwipeRefreshLayout.g, com.bytedance.awemeopen.apps.framework.base.view.refresh.g {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public boolean B;
    public int C;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f194863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DmtStatusView f194864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FeedSwipeRefreshLayout f194865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LoadMoreFrameLayout f194866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VerticalViewPager f194867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f194868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DoubleColorBallAnimationView f194869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AoImageView f194870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AosPagerListLayout<Model, VM>.AosFeedItemAdapter f194871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public o f194872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public f54.a f194873s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PullDownType f194874t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f194875u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f194876v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f194877w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e f194878x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f194879y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f194880z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$AosFeedItemAdapter;", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/MultiTypePagerAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public final class AosFeedItemAdapter extends MultiTypePagerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<Model, com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model>> f194881b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AosPagerListLayout<Model, VM> f194882c;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            ListState<List<Model>> r100 = this.f194882c.getVm().getDataList().getValue();
            Intrinsics.checkNotNull(r100);
            return r100.f196927a.size();
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final List<Integer> h() {
            return this.f194882c.v();
        }

        public AosFeedItemAdapter(AosPagerListLayout r100) {
            this.f194882c = r100;
            r100.getContext();
            this.f194881b = new HashMap();
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
        public final int f(int r100) {
            AosPagerListLayout<Model, VM> r101 = this.f194882c;
            ListState<List<Model>> r102 = ((AosPagerListViewModel) r101.getVm()).getDataList().getValue();
            Intrinsics.checkNotNull(r102);
            return r101.u(r100, ListProtector.get(r102.f196927a, r100));
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final int g(View r100) {
            if (r100 == null) goto L4;
            Object r101 = r100.getTag(R.id.feed_pager_adapter_tag_type);
        L6:
            if ((r101 instanceof Integer) == true) goto L10;
            return 1;
        L10:
            return ((Number) r101).intValue();
        L4:
            r101 = null;
            goto L6
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "any");
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> r101 = l(r100);
            if (r101 == null) goto L16;
            int r102 = getCount();
            int r103 = 0;
        L5:
            if (r103 >= r102) goto L22;
            ListState<List<Model>> r104 = this.f194882c.getVm().getDataList().getValue();
            Intrinsics.checkNotNull(r104);
            Object r105 = ListProtector.get(r104.f196927a, r103);
            if (r105 == null) goto L15;
            if (this.f194882c.t((Model) r105, r101) == false) goto L15;
            AosPagerListLayout<Model, VM> r106 = this.f194882c;
            int r107 = r106.getNeedUpdateCount();
            r106.setNeedUpdateCount(r107 - 1);
            if (r107 < 0) goto L14;
            r101.m();
        L14:
            return r103;
        L15:
            r103 = r103 + 1;
            goto L5
        L22:
            return -2;
        L16:
            return -2;
        }

        public final com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> k(Model r100) {
            return this.f194881b.get(r100);
        }

        public final com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> l(Object r100) {
            if ((r100 instanceof View) == false) goto L5;
            View r101 = (View) r100;
        L6:
            if (r101 == null) goto L8;
            Object r102 = r101.getTag(R.id.feed_pager_adapter_tag_holder);
        L10:
            if ((r102 instanceof com.bytedance.awemeopen.apps.framework.framework.viewpager.g) == true) goto L12;
            return null;
        L12:
            return (com.bytedance.awemeopen.apps.framework.framework.viewpager.g) r102;
        L8:
            r102 = null;
            goto L10
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final void j(View r100, int r101) {
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> r102 = l(r100);
            HashMap<Model, com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model>> r103 = this.f194881b;
            if (r102 == null) goto L5;
            Model r104 = r102.f197059b;
        L6:
            TypeIntrinsics.asMutableMap(r103).remove(r104);
            if (r102 == null) goto L10;
            r102.k();
            return;
        L10:
            return;
        L5:
            r104 = null;
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
        public final View i(int r100, View r101, ViewGroup r102) {
            ListState<List<Model>> r103 = this.f194882c.getVm().getDataList().getValue();
            Intrinsics.checkNotNull(r103);
            Object r104 = ListProtector.get(r103.f196927a, r100);
            int r105 = f(r100);
            if (r101 == null) goto L5;
            boolean r106 = Intrinsics.areEqual(r101.getTag(R.id.feed_pager_adapter_tag_type), Integer.valueOf(r105));
        L7:
            if (h().contains(Integer.valueOf(r105)) == true) goto L12;
            if (r101 == null) goto L12;
            if (r106 == false) goto L12;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> r107 = l(r101);
            Intrinsics.checkNotNull(r107);
            View r108 = r101;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g r109 = r107;
        L13:
            this.f194881b.put(r104, r109);
            r109.c(r104, r100);
            return r108;
        L12:
            AosPagerListLayout<Model, VM> r110 = this.f194882c;
            Intrinsics.checkNotNull(r102);
            com.bytedance.awemeopen.apps.framework.framework.viewpager.g r111 = r110.s(r102, r105, r104);
            View r112 = r111.f197058a;
            r112.setTag(R.id.feed_pager_adapter_tag_type, Integer.valueOf(r105));
            r112.setTag(R.id.feed_pager_adapter_tag_holder, r111);
            r108 = r112;
            r109 = r111;
            goto L13
        L5:
            r106 = false;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout$PullDownType;", "", UserProfileEvent.POSITION_NONE, "REFRESH", "LOAD_FORWARD", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum PullDownType extends Enum<PullDownType> {
        public static final PullDownType LOAD_FORWARD = null;
        public static final PullDownType NONE = null;
        public static final PullDownType REFRESH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PullDownType[] f194883a = null;

        public static PullDownType valueOf(String r100) {
            return (PullDownType) r27.a.a(PullDownType.class, r100);
        }

        public static PullDownType[] values() {
            return (PullDownType[]) f194883a.clone();
        }

        static {
            PullDownType r100 = new PullDownType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            PullDownType r101 = new PullDownType("REFRESH", 1);
            REFRESH = r101;
            PullDownType r102 = new PullDownType("LOAD_FORWARD", 2);
            LOAD_FORWARD = r102;
            f194883a = new PullDownType[]{r100, r101, r102};
        }

        public PullDownType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f194884a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f194885b = null;

        static {
            int[] r100 = new int[ListState.State.values().length];
            r100[ListState.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L66:
            r100[ListState.State.REQUEST_LAUNCH_CONFIG_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L78:
            r100[ListState.State.REQUEST_LAUNCH_CONFIG_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L50:
            r100[ListState.State.INITIAL_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L52:
            r100[ListState.State.REFRESH_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L62:
            r100[ListState.State.INITIAL_FAIL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L72:
            r100[ListState.State.REFRESH_FAIL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L58:
            r100[ListState.State.START_LOAD_MORE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L68:
            r100[ListState.State.LOAD_MORE_SUCCESS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L34
        L70:
            r100[ListState.State.LOAD_MORE_FAIL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L35
        L46:
            r100[ListState.State.START_LOAD_FORWARD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L36
        L64:
            r100[ListState.State.LOAD_FORWARD_SUCCESS.ordinal()] = 12;     // Catch: NoSuchFieldError -> L37
        L76:
            r100[ListState.State.LOAD_FORWARD_FAIL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L38
        L44:
            r100[ListState.State.DISLIKE_CURRENT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L39
        L54:
            r100[ListState.State.DISCARD_AFTER_CURRENT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L40
        L20:
            f194884a = r100;
            int[] r101 = new int[PullDownType.values().length];
            r101[PullDownType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L48:
            r101[PullDownType.LOAD_FORWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L56:
            r101[PullDownType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L24:
            f194885b = r101;
        }
    }

    static {
    }

    private final void T() {
        AoLogger.g("AosPagerListLayout", new Object[]{"onStartRefresh"});
        this.f194875u = SystemClock.elapsedRealtime();
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

    public void F(List<Model> r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public void J() {
    }

    public void K() {
    }

    public void L(int r100) {
    }

    public void M(boolean r100) {
    }

    public void N(List<Model> r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
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
        this.f194877w = SystemClock.elapsedRealtime();
        getVm().startLoadMore(false);
    }

    public abstract com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> s(ViewGroup r100, int r101, Model r102);

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void setArguments(Bundle r100) {
    }

    public abstract boolean t(Model r100, com.bytedance.awemeopen.apps.framework.framework.viewpager.g<Model> r101);

    public abstract int u(int r100, Model r101);

    public void w(int r100, Model r101) {
    }

    public int y(List<Model> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return 0;
    }

    public boolean z() {
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void e() {
        f54.a r100 = AosExtConfig.f193138b.J0();
        this.f194873s = r100;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        setStatusView((DmtStatusView) findViewById(R.id.status_view));
        getStatusView().c();
        this.f194868n = (FrameLayout) findViewById(R.id.init_loading_fl);
        this.f194869o = (DoubleColorBallAnimationView) findViewById(R.id.init_loading_double_ball);
        this.f194870p = (AoImageView) findViewById(R.id.init_cover_from_host);
        setViewPager((VerticalViewPager) findViewById(R.id.feed_content_viewpager));
        getViewPager().setOffscreenPageLimit(1);
        getViewPager().c(new AosPagerListLayout$initViewPager$1(this));
        setAdapter(new AosFeedItemAdapter(this));
        getViewPager().setAdapter(getAdapter());
        VerticalViewPager r101 = getViewPager();
        e r102 = this.f194878x;
        if (r101.f193757c != null) goto L8;
        r101.f193757c = new ArrayList();
    L8:
        ((ArrayList) r101.f193757c).add(r102);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.fl_loading_view);
        DmtTextView r104 = (DmtTextView) findViewById(R.id.tv_pull_and_refresh);
        this.f194872r = new o((DoubleColorBallAnimationView) findViewById(R.id.loading_double_ball), r104, r103);
        setRefreshLayout((FeedSwipeRefreshLayout) findViewById(R.id.feed_content_refresh));
        getRefreshLayout().setViewPager(getViewPager());
        getRefreshLayout().setOnRefreshListener(this);
        PullDownType r105 = getPullDownType();
        this.f194874t = r105;
        int r106 = b.f194885b[r105.ordinal()];
        if (r106 != 1) goto L11;
        getRefreshLayout().setOnSwipeChangeListener(new l(this));
        getRefreshLayout().setEnabled(true);
    L18:
        getRefreshLayout().setEnabled(A());
        setLoadMoreLayout((LoadMoreFrameLayout) findViewById(R.id.feed_content_load_more));
        LoadMoreFrameLayout r107 = getLoadMoreLayout();
        VerticalViewPager r108 = getViewPager();
        FeedSwipeRefreshLayout r109 = getRefreshLayout();
        r107.f193347b = r108;
        r107.f193348c = r109;
        getLoadMoreLayout().setLabel("feed");
        getLoadMoreLayout().setLoadMoreListener(this);
        getLoadMoreLayout().setOnLoadMoreUiListener(new k(this));
        getLoadMoreLayout().setEnabled(z());
        return;
    L11:
        if (r106 != 2) goto L13;
        getRefreshLayout().setEnabled(true);
        goto L18
    L13:
        if (r106 != 3) goto L18;
        getRefreshLayout().setEnabled(false);
        goto L18
    }

    public final AosPagerListLayout<Model, VM>.AosFeedItemAdapter getAdapter() {
        AosPagerListLayout<Model, VM>.AosFeedItemAdapter r100 = this.f194871q;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final LoadMoreFrameLayout getLoadMoreLayout() {
        LoadMoreFrameLayout r100 = this.f194866l;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
        return null;
    }

    public final FeedSwipeRefreshLayout getRefreshLayout() {
        FeedSwipeRefreshLayout r100 = this.f194865k;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        return null;
    }

    public final DmtStatusView getStatusView() {
        DmtStatusView r100 = this.f194864j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        return null;
    }

    public final VerticalViewPager getViewPager() {
        VerticalViewPager r100 = this.f194867m;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.g
    public final void onRefresh() {
        int r100 = b.f194885b[this.f194874t.ordinal()];
        if (r100 != 1) goto L5;
        T();
        return;
    L5:
        if (r100 != 2) goto L11;
        AoLogger.g("AosPagerListLayout", new Object[]{"onStartLoadForward"});
        this.f194876v = SystemClock.elapsedRealtime();
        getVm().loadForward();
        return;
    }

    public List<Integer> v() {
        return new ArrayList();
    }

    public final void x() {
        FrameLayout r100 = this.f194868n;
        DoubleColorBallAnimationView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingFl");
        r100 = null;
    L5:
        x54.b.a(r100);
        DoubleColorBallAnimationView r102 = this.f194869o;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r102 = null;
    L9:
        if (r102.f193339k == false) goto L16;
        DoubleColorBallAnimationView r103 = this.f194869o;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L14:
        r101.d();
        return;
    L13:
        r101 = r103;
        goto L14
    }

    public final void B() {
        getRefreshLayout().setRefreshing(true);
        T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void G() {
        ListState<List<Model>> r100 = getVm().getDataList().getValue();
        if (r100 == null) goto L23;
        List<Model> r101 = r100.f196927a;
        if (r101 == null) goto L27;
        int r102 = getVm().getCurrentSelectedIndex();
        if (r102 >= 0) goto L10;
        return;
    L10:
        if (r102 >= r101.size()) goto L25;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g r103 = getAdapter().k(ListProtector.get(r101, r102));
        PhotoFeedViewHolder r104 = null;
        if ((r103 instanceof VideoFeedViewHolder) == false) goto L14;
        VideoFeedViewHolder r105 = (VideoFeedViewHolder) r103;
    L15:
        if (r105 == null) goto L18;
        r105.f195119e.f195163c.getLoadMoreUiShow().setValue(Boolean.FALSE);
    L18:
        if ((r103 instanceof PhotoFeedViewHolder) == false) goto L20;
        r104 = (PhotoFeedViewHolder) r103;
    L20:
        if (r104 == null) goto L26;
        r104.f195108e.f195163c.getLoadMoreUiShow().setValue(Boolean.FALSE);
        return;
    L26:
        return;
    L14:
        r105 = null;
        goto L15
    L25:
        return;
    L27:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void H() {
        ListState<List<Model>> r100 = getVm().getDataList().getValue();
        if (r100 == null) goto L23;
        List<Model> r101 = r100.f196927a;
        if (r101 == null) goto L27;
        int r102 = getVm().getCurrentSelectedIndex();
        if (r102 >= 0) goto L10;
        return;
    L10:
        if (r102 >= r101.size()) goto L25;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g r103 = getAdapter().k(ListProtector.get(r101, r102));
        PhotoFeedViewHolder r104 = null;
        if ((r103 instanceof VideoFeedViewHolder) == false) goto L14;
        VideoFeedViewHolder r105 = (VideoFeedViewHolder) r103;
    L15:
        if (r105 == null) goto L18;
        r105.f195119e.f195163c.getLoadMoreUiShow().setValue(Boolean.TRUE);
    L18:
        if ((r103 instanceof PhotoFeedViewHolder) == false) goto L20;
        r104 = (PhotoFeedViewHolder) r103;
    L20:
        if (r104 == null) goto L26;
        r104.f195108e.f195163c.getLoadMoreUiShow().setValue(Boolean.TRUE);
        return;
    L26:
        return;
    L14:
        r105 = null;
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
        AosPagerListLayout<Model, VM>.AosFeedItemAdapter r100 = getAdapter();
        Iterator<T> r101 = r100.f194881b.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.awemeopen.apps.framework.framework.viewpager.g) r101.next()).k();
        goto L4
    L6:
        r100.f194881b.clear();
        VerticalViewPager r102 = getViewPager();
        e r103 = this.f194878x;
        List<com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.b> r104 = r102.f193757c;
        if (r104 == null) goto L12;
        ((ArrayList) r104).remove(r103);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public boolean l() {
        if ((getContext() instanceof Activity) == false) goto L6;
        int r100 = w04.a.f557782a;
        return w04.a.b((Activity) getContext());
    L6:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.LifeCycleFrameLayout, com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public void onResume() {
        super.onResume();
        if (this.B == true) goto L7;
        this.C = 2;
        PagerAdapter r100 = getViewPager().getAdapter();
        if (r100 == null) goto L9;
        r100.notifyDataSetChanged();
        return;
    L9:
        return;
    L7:
        this.B = false;
    }

    public final boolean getNeedRecallOnSelectIfNeed() {
        return this.f194880z;
    }

    public final int getNeedUpdateCount() {
        return this.C;
    }

    public PullDownType getPullDownType() {
        return PullDownType.REFRESH;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.layout.layout.e] */
    public AosPagerListLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f194874t = PullDownType.REFRESH;
        this.f194878x = new e(this);
        this.f194879y = true;
        this.B = true;
        this.C = -1;
    }

    public static final void r(AosPagerListLayout r100) {
        DoubleColorBallAnimationView r101 = r100.f194869o;
        DoubleColorBallAnimationView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r101 = null;
    L5:
        r101.setVisibility(0);
        DoubleColorBallAnimationView r103 = r100.f194869o;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L9:
        r102.c();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void P(boolean r100) {
        getRefreshLayout().setRefreshing(false);
        if (r100 == false) goto L13;
        x();
        DmtStatusView.a r101 = DmtStatusView.a.a(getContext());
        DmtStatusView r102 = getStatusView();
        Intrinsics.checkNotNullParameter(r102, "statusView");
        AosDefaultNetErrorView r103 = new AosDefaultNetErrorView(r102.getContext());
        r103.findViewById(R.id.retry_btn).setOnClickListener(new i(this));
        r103.b();
        r101.d(r103);
        AosNoMoreFeedErrorView r104 = new AosNoMoreFeedErrorView(getStatusView().getContext());
        r101.f193296e = r104;
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        getStatusView().setBuilder(r101);
        ListState<List<Model>> r105 = getVm().getDataList().getValue();
        if (r105 != null) goto L7;
    L9:
        boolean r106 = false;
    L10:
        if (r106 == false) goto L12;
        DmtStatusView r107 = getStatusView();
        r107.setVisibility(0);
        r107.setStatus(3);
        goto L13
    L12:
        getStatusView().d();
        goto L13
    L7:
        if (r105.f196936j != 12100) goto L9;
        r106 = true;
    L13:
        AoLogger.g("AosPagerListLayout", new Object[]{"onRefreshFail"});
        S(r100, false, getVm().getApiType());
        M(r100);
    }

    public final void Q(boolean r100) {
        AoLogger.g("AosPagerListLayout", new Object[]{"reportLoadMoreRate showLoading:" + r100});
        AosEventReporter r101 = AosEventReporter.f194596a;
        String r102 = getVm().sceneId();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "scene");
        d14.a r103 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).a0(r102, r100, null);
    }

    public final void setAdapter(AosPagerListLayout<Model, VM>.AosFeedItemAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f194871q = r100;
    }

    public final void setCurrentItem(int r100) {
        if (getViewPager().getCurrentItem() == r100) goto L6;
        getViewPager().y(r100, false);
        return;
    }

    public final void setDataListFirstChange(boolean r100) {
        this.f194879y = r100;
    }

    public final void setFirstEnter(boolean r100) {
        this.B = r100;
    }

    public final void setInitDataEmpty(boolean r100) {
        this.A = r100;
    }

    public final void setLoadMoreLayout(LoadMoreFrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f194866l = r100;
    }

    public final void setNeedRecallOnSelectIfNeed(boolean r100) {
        this.f194880z = r100;
    }

    public final void setNeedUpdateCount(int r100) {
        this.C = r100;
    }

    public final void setRefreshLayout(FeedSwipeRefreshLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f194865k = r100;
    }

    public final void setStatusView(DmtStatusView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f194864j = r100;
    }

    public final void setViewPager(VerticalViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f194867m = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void p(final AosPagerListLayout r110, ListState r111) {
        Intrinsics.checkNotNullParameter(r110, "this$0");
        boolean r100 = true;
        if (r110.f194879y == false) goto L8;
        r110.f194879y = false;
        if (r111.f196929c == ListState.State.NEW) goto L8;
        r110.f194880z = true;
        return;
    L8:
        switch(b.f194884a[r111.f196929c.ordinal()]) {
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
        ((AosPagerListViewModel) r110.getVm()).removeDataAfterIndex();
        PagerAdapter r112 = r110.getViewPager().getAdapter();
        if (r112 == null) goto L177;
        r112.notifyDataSetChanged();
        return;
    L177:
        return;
    L13:
        PagerAdapter r113 = r110.getViewPager().getAdapter();
        if (r113 == null) goto L16;
        r113.notifyDataSetChanged();
    L16:
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) r110.getVm(), r110.getViewPager().getCurrentItem(), true, false, 4, null);
        return;
    L17:
        r110.getRefreshLayout().setRefreshing(false);
        AoLogger.g("AosPagerListLayout", new Object[]{"onLoadForwardFail"});
        String r114 = ((AosPagerListViewModel) r110.getVm()).getApiType();
        if (r110.f194876v <= 0) goto L20;
        r110.R(false, SystemClock.elapsedRealtime() - r110.f194876v, "loadForward", r114);
        r110.f194876v = 0;
    L20:
        r110.D();
        return;
    L21:
        r110.getRefreshLayout().setRefreshing(false);
        ListState<List<Model>> r115 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        if (r115 != null) goto L24;
    L26:
        boolean r116 = false;
    L27:
        if (r116 == true) goto L29;
        r110.getRefreshLayout().setEnabled(false);
    L29:
        ((AosPagerListViewModel) r110.getVm()).tempData2ListForLoadForward();
        PagerAdapter r117 = r110.getViewPager().getAdapter();
        if (r117 == null) goto L32;
        r117.notifyDataSetChanged();
    L32:
        AoLogger.g("AosPagerListLayout", new Object[]{"onLoadForwardSuccess"});
        String r118 = ((AosPagerListViewModel) r110.getVm()).getApiType();
        if (r110.f194876v <= 0) goto L35;
        r110.R(true, SystemClock.elapsedRealtime() - r110.f194876v, "loadForward", r118);
        r110.f194876v = 0;
    L35:
        ListState<List<Model>> r119 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r119);
        List<Model> r120 = r119.f196927a;
        ListState<List<Model>> r121 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        Intrinsics.checkNotNullParameter(r120, "data");
        return;
    L24:
        if (r115.f196934h != true) goto L26;
        r116 = true;
        goto L27
    L36:
        ((AosPagerListViewModel) r110.getVm()).loadForwardData(((AosPagerListViewModel) r110.getVm()).getLoadForwardCallback());
        return;
    L37:
        r110.Q(r110.f194863i);
        r110.getLoadMoreLayout().f();
        AoLogger.g("AosPagerListLayout", new Object[]{"onLoadMoreFail"});
        String r122 = ((AosPagerListViewModel) r110.getVm()).getApiType();
        if (r110.f194877w <= 0) goto L40;
        r110.R(false, SystemClock.elapsedRealtime() - r110.f194877w, DitoNode.LOAD_MORE, r122);
        r110.f194877w = 0;
    L40:
        r110.E();
        r110.f194863i = false;
        return;
    L41:
        r110.Q(r110.f194863i);
        ListState<List<Model>> r123 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        if (r123 != null) goto L44;
    L46:
        boolean r124 = false;
    L47:
        if (r124 == false) goto L49;
        r110.getLoadMoreLayout().f();
    L50:
        ((AosPagerListViewModel) r110.getVm()).tempData2ListForLoadMore();
        PagerAdapter r125 = r110.getViewPager().getAdapter();
        if (r125 == null) goto L53;
        r125.notifyDataSetChanged();
    L53:
        AoLogger.g("AosPagerListLayout", new Object[]{"onLoadMoreSuccess"});
        String r126 = ((AosPagerListViewModel) r110.getVm()).getApiType();
        if (r110.f194877w <= 0) goto L56;
        r110.R(true, SystemClock.elapsedRealtime() - r110.f194877w, DitoNode.LOAD_MORE, r126);
        r110.f194877w = 0;
    L56:
        ListState<List<Model>> r127 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r127);
        List<Model> r128 = r127.f196927a;
        ListState<List<Model>> r101 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        if (r101 != null) goto L59;
    L61:
        r100 = false;
    L62:
        r110.F(r128, r100, r110.f194863i);
        r110.f194863i = false;
        return;
    L59:
        if (r101.f196933g != true) goto L61;
    L49:
        r110.getLoadMoreLayout().g();
        goto L50
    L44:
        if (r123.f196933g != true) goto L46;
        r124 = true;
        goto L47
    L63:
        r110.P(false);
        return;
    L64:
        r110.P(true);
        return;
    L65:
        r110.x();
        r110.getRefreshLayout().setRefreshing(false);
        r110.getStatusView().c();
        ((AosPagerListViewModel) r110.getVm()).tempData2ListForRefresh();
        if (((AosPagerListViewModel) r110.getVm()).getCurrentState() != ListState.State.INITIAL_SUCCESS) goto L68;
        boolean r129 = true;
    L69:
        ListState<List<Model>> r102 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r102);
        final int r103 = r110.y(r102.f196927a);
        if (r103 <= 0) goto L75;
        r110.getViewPager().setmRestoredCurItem(r103);
        PagerAdapter r104 = r110.getViewPager().getAdapter();
        if (r104 == null) goto L74;
        r104.notifyDataSetChanged();
    L74:
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) r110.getVm(), r103, true, false, 4, null);
    L78:
        if (r129 == false) goto L88;
        ListState<List<Model>> r105 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        if (r105 == null) goto L86;
        List<Model> r106 = r105.f196927a;
        if (r106 == null) goto L86;
        if (r106.isEmpty() != true) goto L86;
        boolean r107 = true;
    L87:
        r110.A = r107;
    L86:
        r107 = false;
    L88:
        ListState<List<Model>> r108 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r108);
        ListState.State r109 = r108.f196929c;
        r110.getViewPager().post(new j(r103, r110));
        if (r110.f194874t != PullDownType.LOAD_FORWARD) goto L98;
        ListState<List<Model>> r130 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        if (r130 != null) goto L93;
    L95:
        boolean r131 = false;
    L96:
        if (r131 == true) goto L98;
        r110.getRefreshLayout().setEnabled(false);
        goto L98
    L93:
        if (r130.f196934h != true) goto L95;
        r131 = true;
    L98:
        ListState<List<Model>> r132 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        if (r132 != null) goto L101;
    L103:
        boolean r133 = false;
    L104:
        if (r133 == false) goto L106;
        r110.getLoadMoreLayout().f();
    L107:
        AoLogger.g("AosPagerListLayout", new Object[]{"onRefreshSuccess"});
        r110.S(r129, true, ((AosPagerListViewModel) r110.getVm()).getApiType());
        ListState<List<Model>> r134 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        Intrinsics.checkNotNull(r134);
        List<Model> r135 = r134.f196927a;
        ListState<List<Model>> r136 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        if (r136 != null) goto L110;
    L112:
        boolean r137 = false;
    L113:
        ListState<List<Model>> r138 = ((AosPagerListViewModel) r110.getVm()).getDataList().getValue();
        if (r138 != null) goto L116;
    L118:
        r100 = false;
    L119:
        r110.N(r135, r137, r100);
        return;
    L116:
        if (r138.f196933g != true) goto L118;
    L110:
        if (r136.f196934h != true) goto L112;
        r137 = true;
        goto L113
    L106:
        r110.getLoadMoreLayout().g();
        goto L107
    L101:
        if (r132.f196933g != true) goto L103;
        r133 = true;
        goto L104
    L75:
        PagerAdapter r139 = r110.getViewPager().getAdapter();
        if (r139 == null) goto L78;
        r139.notifyDataSetChanged();
        goto L78
    L68:
        r129 = false;
        goto L69
    L120:
        r110.P(true);
        return;
    L121:
        r110.C();
        return;
    L122:
        r110.getStatusView().c();
        FrameLayout r140 = r110.f194868n;
        DoubleColorBallAnimationView r141 = null;
        if (r140 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingFl");
        r140 = null;
    L125:
        x54.b.d(r140);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.j r142 = ((AosPagerListViewModel) r110.getVm()).getHostCoverParams();
        if (r142 == null) goto L155;
        String r143 = r142.f195143a;
        if (r143 == null) goto L155;
        int r144 = r142.f195144b;
        int r145 = r142.f195145c;
        int r146 = r142.f195146d;
        AoImageView r147 = r110.f194870p;
        if (r147 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r147 = null;
    L132:
        int r148 = r147.getMeasuredWidth();
        AoImageView r149 = r110.f194870p;
        if (r149 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r149 = null;
    L135:
        int r150 = r149.getMeasuredHeight();
        if (r148 != 0) goto L138;
        r148 = d0.d(r110.getContext());
    L138:
        if (r150 != 0) goto L140;
        r150 = d0.c(r110.getContext()) - r146;
    L140:
        AoImageView r151 = r110.f194870p;
        if (r151 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r151 = null;
    L143:
        c64.b r152 = new k04.a(false, r151.getContext(), null).a(r144, r145, r148, r150);
        Size r153 = r152.f22588a;
        FrameLayout.LayoutParams r154 = new FrameLayout.LayoutParams(r153.getWidth(), r153.getHeight());
        r154.gravity = 17;
        AoImageView r155 = r110.f194870p;
        if (r155 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r155 = null;
    L146:
        r155.setLayoutParams(r154);
        AoImageView r156 = r110.f194870p;
        if (r156 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("hostCover");
        r156 = null;
    L149:
        com.bytedance.awemeopen.infra.base.image.b r157 = new com.bytedance.awemeopen.infra.base.image.b(r143);
        r157.f198632m = r152.f22589b;
        Context r158 = r110.getContext();
        if (r158 == null) goto L153;
        Drawable r159 = ContextCompat.getDrawable(r158, R.drawable.aos_feed_loading_bg);
        r157.f198629j = 0;
        r157.f198628i = r159;
    L153:
        r156.j(r157);
        AoPool.e(new AosPagerListLayout$showInitLoading$1$1$2(r110), r142.f195147e);
        r100 = false;
    L155:
        if (r100 == false) goto L164;
        DoubleColorBallAnimationView r160 = r110.f194869o;
        if (r160 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r160 = null;
    L159:
        r160.setVisibility(0);
        DoubleColorBallAnimationView r161 = r110.f194869o;
        if (r161 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L163:
        r141.c();
    L174:
        r110.getViewPager().post(new g(r110));
        return;
    L162:
        r141 = r161;
        goto L163
    L164:
        DoubleColorBallAnimationView r162 = r110.f194869o;
        if (r162 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r162 = null;
    L168:
        if (r162.f193339k == false) goto L174;
        DoubleColorBallAnimationView r163 = r110.f194869o;
        if (r163 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L173:
        r141.d();
        goto L174
    L172:
        r141 = r163;
        goto L173
    }

    public final void S(boolean r110, boolean r111, String r112) {
        if (r110 == false) goto L5;
        return;
    L5:
        if (this.f194875u <= 0) goto L8;
        R(r111, SystemClock.elapsedRealtime() - this.f194875u, "pullRefresh", r112);
        this.f194875u = 0;
        return;
    }

    public final void R(boolean r100, long r110, String r111, String r112) {
        AoLogger.g("AosPagerListLayout", new Object[]{"reportManualLoadingResult isSuccess:" + r100 + " duration:" + r110 + " loadingType:" + r111});
        AosEventReporter r101 = AosEventReporter.f194596a;
        int r102 = !r100 ? 1 : 0;
        String r103 = getVm().sceneId();
        r101.getClass();
        AosEventReporter.x(r110, r102, r103, r111, r112);
    }
}
