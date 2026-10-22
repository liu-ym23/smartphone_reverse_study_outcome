package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridRecyclerViewPerformanceMonitor;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductBannerAdapter;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductBannerIndicatorAnimator;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductOverScrollPagerSnapHelper;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductBannerVideoVH;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView;
import com.bytedance.android.shopping.deepfeed.weights.video.VideoCoverLayout;
import com.bytedance.android.shopping.feed.utils.f0;
import com.bytedance.android.shopping.infeed.data.idl.HeaderBannerItemType;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.android.shopping.inflow.cardui.product.header.indicator.ProductCardProgressIndicator;
import com.bytedance.android.shopping.inflow.cardui.product.header.layoutmanager.SmoothScrollLayoutManager;
import com.bytedance.android.shopping.widget.banner.PrimeHorizontalRecyclerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import he3.e2;
import he3.k1;
import he3.m1;
import he3.n2;
import he3.o0;
import he3.p0;
import he3.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0012\u0019B'\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u00020\u0003¢\u0006\u0004\bX\u0010YJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J0\u0010\f\u001a\u00020\n2(\u0010\u000b\u001a$\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010(\u001a\u0004\u0018\u00010#2\b\u0010\u0018\u001a\u0004\u0018\u00010#8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u0010=\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010C\u001a\u0004\u0018\u00010>2\b\u0010\u0018\u001a\u0004\u0018\u00010>8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010I\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010L\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010HR\u0017\u0010R\u001a\u00020M8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductHeaderView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/deepfeed/ui/b;", "", "getCurrentSelected", "getItemCount", "Lkotlin/Function4;", "", "", "", "", "listener", "setVideoProgressReportListener", "mute", "setMute", "Landroid/view/View;", "getMaskView", "Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "a", "Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "getRecyclerView", "()Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "recyclerView", "Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "<set-?>", "b", "Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "getProgressIndicator", "()Lcom/bytedance/android/shopping/inflow/cardui/product/header/indicator/ProductCardProgressIndicator;", "progressIndicator", "c", "Landroid/widget/FrameLayout;", "getProgressIndicatorContainer", "()Landroid/widget/FrameLayout;", "progressIndicatorContainer", "Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoCoverLayout;", "d", "Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoCoverLayout;", "getVideoProgressContainer", "()Lcom/bytedance/android/shopping/deepfeed/weights/video/VideoCoverLayout;", "videoProgressContainer", "Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;", "f", "Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;", "getBannerAdapter", "()Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;", "setBannerAdapter", "(Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;)V", "bannerAdapter", "Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductOverScrollPagerSnapHelper;", "g", "Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductOverScrollPagerSnapHelper;", "getOverScrollSnapHelper", "()Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductOverScrollPagerSnapHelper;", "overScrollSnapHelper", "i", "Z", "getIgnoreAnimCall", "()Z", "setIgnoreAnimCall", "(Z)V", "ignoreAnimCall", "Landroidx/constraintlayout/widget/ConstraintLayout;", "w", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getSearchContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "searchContainer", "Landroid/widget/ImageView;", "A", "Landroid/widget/ImageView;", "getMuteIcon", "()Landroid/widget/ImageView;", "muteIcon", "B", "getUnmuteIcon", "unmuteIcon", "Landroid/widget/TextView;", "C", "Landroid/widget/TextView;", "getAdTagView", "()Landroid/widget/TextView;", "adTagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductHeaderView extends FrameLayout implements com.bytedance.android.shopping.deepfeed.ui.b {
    public static final Set<String> H0 = null;
    public final ImageView A;
    public final ImageView B;
    public final TextView C;
    public List<e2> D;
    public List<InFeedUrlModel> E;
    public List<o0> F;
    public List<x0> G;
    public final View H;
    public com.bytedance.android.shopping.deepfeed.action.i I;
    public List<b> J;
    public com.bytedance.android.ec.core.imagex.r K;
    public final boolean L;
    public boolean M;
    public boolean N;
    public final h O;
    public Function1<? super Boolean, Unit> P;
    public final Function0<Unit> Q;
    public Function4<? super Long, ? super Long, ? super Boolean, ? super String, Unit> R;
    public long S;
    public long T;
    public boolean U;
    public String V;
    public final g W;
    public final PrimeHorizontalRecyclerView a;
    public ProductCardProgressIndicator b;
    public FrameLayout c;
    public VideoCoverLayout d;
    public final DeepFeedProductBannerIndicatorAnimator e;
    public DeepFeedProductBannerAdapter f;
    public final DeepFeedProductOverScrollPagerSnapHelper g;
    public Runnable h;
    public boolean i;
    public final OrientationHelper j;
    public int k;
    public final DeepFeedProductHeaderView$onScrollStateChangedListener$1 k0;
    public ke3.a l;
    public View.OnClickListener m;
    public Function1<? super DeepFeedCommentClickArea, Unit> n;
    public Function0<Unit> o;
    public Function2<? super Integer, ? super String, Unit> p;
    public final List<x0> p0;
    public Function2<? super Integer, ? super String, Unit> q;
    public View.OnLongClickListener r;
    public final e s;
    public final Function1<DeepFeedCommentClickArea, Unit> t;
    public final Function0<Unit> u;
    public final f v;
    public ConstraintLayout w;
    public ProductTextView x;
    public DeepFeedProductHeaderTabLayout y;
    public boolean z;

    public static final class a {
        public static void a(k1 r3, List r4) {
            if (r3 == null) goto L9;
            List<InFeedUrlModel> r5 = r3.b();
            if (r5 == null) goto L11;
            Iterator<T> r6 = r5.iterator();
        L7:
            if (r6.hasNext() == false) goto L12;
            InFeedUrlModel r0 = (InFeedUrlModel) r6.next();
            x0 r1 = new x0();
            r1.a(HeaderBannerItemType.Image);
            r1.b = r0;
            Unit r2 = Unit.INSTANCE;
            ((ArrayList) r4).add(r1);
            goto L7
        L12:
            return;
        L11:
            return;
        }

        public static void b(k1 r4, List r5) {
            if (r4.c() == null) goto L39;
            x0 r0 = new x0();
            r0.a(HeaderBannerItemType.CoverVideo);
            qe3.a r1 = new qe3.a();
            List<e2> r2 = r4.c();
            InFeedUrlModel r3 = null;
            if (r2 == null) goto L9;
            e2 r6 = (e2) CollectionsKt.firstOrNull(r2);
            if (r6 == null) goto L9;
            String r7 = r6.e();
        L10:
            r1.g(r7);
            List<e2> r8 = r4.c();
            if (r8 == null) goto L19;
            e2 r9 = (e2) CollectionsKt.firstOrNull(r8);
            if (r9 == null) goto L19;
            n2 r10 = r9.a();
            if (r10 == null) goto L19;
            List<String> r11 = r10.b();
            if (r11 == null) goto L19;
            String r12 = (String) CollectionsKt.firstOrNull(r11);
        L20:
            r1.f(r12);
            List<e2> r13 = r4.c();
            if (r13 == null) goto L25;
            e2 r14 = (e2) CollectionsKt.firstOrNull(r13);
            if (r14 == null) goto L25;
            Integer r15 = r14.f();
        L26:
            r1.h(r15);
            List<e2> r16 = r4.c();
            if (r16 == null) goto L31;
            e2 r17 = (e2) CollectionsKt.firstOrNull(r16);
            if (r17 == null) goto L31;
            Integer r18 = r17.d();
        L32:
            r1.e(r18);
            Unit r19 = Unit.INSTANCE;
            r0.c = r1;
            List<e2> r20 = r4.c();
            if (r20 == null) goto L37;
            e2 r21 = (e2) CollectionsKt.firstOrNull(r20);
            if (r21 == null) goto L37;
            r3 = r21.b();
        L37:
            r0.b = r3;
            ((ArrayList) r5).add(r0);
            return;
        L31:
            r18 = null;
        L25:
            r15 = null;
        L19:
            r12 = null;
        L9:
            r7 = null;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v12, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v13, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v9 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.util.ArrayList] */
        public static List c(InFeedProductV2 r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r13, "inFeedProductInfo");
            InFeedProductPackData r0 = r13.getPackData();
            List<e2> r2 = null;
            if (r0 == null) goto L61;
            InFeedProductPackDataElements r1 = r0.getElements();
            if (r1 == null) goto L61;
            List<p0> r3 = r1.getProducts();
            if (r3 == null) goto L61;
            p0 r4 = (p0) CollectionsKt.firstOrNull(r3);
            if (r4 == null) goto L61;
            m1 r5 = r4.i();
            if (r5 == null) goto L61;
            he3.m r6 = r5.a();
            if (r6 == null) goto L61;
            he3.s r7 = r6.c();
            if (r7 == null) goto L61;
            List<o0> r8 = r7.a();
            if (r8 == null) goto L61;
            ?? r9 = new ArrayList();
            Iterator r10 = r8.iterator();
        L20:
            if (r10.hasNext() == false) goto L62;
            Object r11 = r10.next();
            o0 r12 = (o0) r11;
            String r15 = r12.d();
            if (r15 != null) goto L24;
        L27:
            boolean r16 = true;
        L28:
            if (r16 == true) goto L58;
            List<ImageURL> r17 = r12.b();
            if (r17 != null) goto L32;
        L35:
            boolean r18 = true;
        L36:
            if (r18 == false) goto L57;
            List<e2> r19 = r12.e();
            if (r19 != null) goto L40;
        L43:
            boolean r20 = true;
        L44:
            if (r20 == false) goto L57;
            he3.h r21 = r12.a();
            if (r21 == null) goto L48;
            List<he3.g> r22 = r21.c();
        L49:
            List<he3.g> r23 = r22;
            if (r23 != null) goto L52;
        L55:
            boolean r24 = true;
        L56:
            if (r24 == true) goto L58;
        L52:
            if (r23.isEmpty() == true) goto L55;
            r24 = false;
            goto L56
        L48:
            r22 = null;
            goto L49
        L40:
            if (r19.isEmpty() == true) goto L43;
            r20 = false;
        L57:
            boolean r25 = true;
        L59:
            if (r25 == false) goto L20;
            r9.add(r11);
            goto L20
        L32:
            if (r17.isEmpty() == true) goto L35;
            r18 = false;
        L58:
            r25 = false;
            goto L59
        L24:
            if (r15.length() == 0) goto L27;
            r16 = false;
        L62:
            if (r9 != 0) goto L65;
            r9 = CollectionsKt.emptyList();
        L65:
            if ((!((Collection) r9).isEmpty()) == false) goto L129;
            ArrayList r110 = new ArrayList();
            Set<String> r111 = DeepFeedProductHeaderView.H0;
            Iterator r112 = ((Iterable) r9).iterator();
            int r26 = 0;
        L68:
            if (r112.hasNext() == false) goto L128;
            Object r27 = r112.next();
            int r28 = r26 + 1;
            if (r26 >= 0) goto L72;
            CollectionsKt.throwIndexOverflow();
        L72:
            o0 r29 = (o0) r27;
            String r30 = r29.d();
            if (r30 != null) goto L75;
            r30 = "";
        L75:
            List<ImageURL> r31 = r29.b();
            if (r31 != null) goto L78;
        L81:
            boolean r32 = true;
        L82:
            if (r32 == true) goto L87;
            List<ImageURL> r33 = r29.b();
            ?? r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
            Iterator r35 = r33.iterator();
        L85:
            if (r35.hasNext() == false) goto L88;
            ImageURL r36 = (ImageURL) r35.next();
            Set<String> r113 = DeepFeedProductHeaderView.H0;
            InFeedUrlModel r114 = new InFeedUrlModel();
            r114.setUrlList(r36.getUrlList());
            r34.add(r114);
        L88:
            List<e2> r37 = r29.e();
            if (r37 == null) goto L91;
            e2 r38 = (e2) CollectionsKt.firstOrNull(r37);
        L92:
            he3.h r39 = r29.a();
            if (r38 == null) goto L104;
            if (r110.isEmpty() == false) goto L104;
            Set<String> r40 = DeepFeedProductHeaderView.H0;
            x0 r41 = new x0();
            r41.a(HeaderBannerItemType.CoverVideo);
            qe3.a r115 = new qe3.a();
            r115.g(r38.e());
            n2 r116 = r38.a();
            if (r116 == null) goto L101;
            List<String> r117 = r116.b();
            if (r117 == null) goto L101;
            String r118 = (String) CollectionsKt.firstOrNull(r117);
        L102:
            r115.f(r118);
            r115.h(r38.f());
            r115.e(r38.d());
            Unit r119 = Unit.INSTANCE;
            r41.c = r115;
            r41.b = r38.b();
            r41.d = r26;
            r41.e = r30;
            r110.add(r41);
        L101:
            r118 = null;
        L104:
            if ((!((Collection) r34).isEmpty()) == false) goto L112;
            Set<String> r42 = DeepFeedProductHeaderView.H0;
            Iterator r43 = ((Iterable) r34).iterator();
            int r44 = 0;
        L107:
            if (r43.hasNext() == false) goto L127;
            Object r45 = r43.next();
            int r120 = r44 + 1;
            if (r44 >= 0) goto L111;
            CollectionsKt.throwIndexOverflow();
        L111:
            x0 r121 = new x0();
            r121.a(HeaderBannerItemType.Image);
            r121.b = (InFeedUrlModel) r45;
            r121.d = r26;
            r121.e = r30;
            r121.f = r44;
            r121.g = r34.size();
            Unit r46 = Unit.INSTANCE;
            r110.add(r121);
            r44 = r120;
        L127:
            r26 = r28;
            goto L68
        L112:
            if (r39 == null) goto L114;
            List<he3.g> r47 = r39.c();
        L115:
            List<he3.g> r48 = r47;
            if (r48 != null) goto L118;
        L121:
            boolean r49 = true;
        L122:
            if (r49 == true) goto L127;
            Set<String> r50 = DeepFeedProductHeaderView.H0;
            if (r39 == null) goto L127;
            x0 r51 = new x0();
            r51.a(HeaderBannerItemType.Comment);
            r51.h = r39;
            r51.d = r26;
            r51.e = r30;
            Unit r52 = Unit.INSTANCE;
            r110.add(r51);
            goto L127
        L118:
            if (r48.isEmpty() == true) goto L121;
            r49 = false;
            goto L122
        L114:
            r47 = null;
            goto L115
        L91:
            r38 = null;
            goto L92
        L87:
            r34 = CollectionsKt.emptyList();
            goto L88
        L78:
            if (r31.isEmpty() == true) goto L81;
            r32 = false;
            goto L82
        L128:
            return r110;
        L129:
            InFeedProductPackData r122 = r13.getPackData();
            if (r122 == null) goto L138;
            InFeedProductPackDataElements r123 = r122.getElements();
            if (r123 == null) goto L138;
            List<p0> r124 = r123.getProducts();
            if (r124 == null) goto L138;
            p0 r125 = (p0) CollectionsKt.firstOrNull(r124);
            if (r125 == null) goto L138;
            k1 r126 = r125.g();
        L139:
            ArrayList r53 = new ArrayList();
            if (r126 == null) goto L142;
            List<e2> r54 = r126.c();
        L143:
            if (r54 == null) goto L146;
            if (r14 == false) goto L146;
            Set<String> r127 = DeepFeedProductHeaderView.H0;
            b(r126, r53);
            a(r126, r53);
        L151:
            return r53;
        L146:
            if (r126 == null) goto L148;
            r2 = r126.c();
        L148:
            if (r2 == null) goto L150;
            Set<String> r128 = DeepFeedProductHeaderView.H0;
            b(r126, r53);
            goto L151
        L150:
            Set<String> r129 = DeepFeedProductHeaderView.H0;
            a(r126, r53);
            goto L151
        L142:
            r54 = null;
        L138:
            r126 = null;
        L61:
            r9 = 0;
            goto L62
        }
    }

    public static final class b {
        public final String a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.b;
        L5:
            r1 = 0;
            goto L7
        }

        public final String toString() {
            return "HeaderTabBinding(title=" + this.a + ", startPosition=" + this.b + ")";
        }

        public b(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DeepFeedProductHeaderView a;

        public c(DeepFeedProductHeaderView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoCoverLayout r0 = this.a.getVideoProgressContainer();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b(0.0f, true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ DeepFeedProductHeaderView a;

        public d(DeepFeedProductHeaderView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DeepFeedProductHeaderView r0 = this.a;     // Catch: Throwable -> L4
            Set<String> r1 = DeepFeedProductHeaderView.H0;     // Catch: Throwable -> L4
            r0.n(PageScrollStatus.slide);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ DeepFeedProductHeaderView a;

        public e(DeepFeedProductHeaderView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.m;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class f implements View.OnLongClickListener {
        public final /* synthetic */ DeepFeedProductHeaderView a;

        public f(DeepFeedProductHeaderView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            View.OnLongClickListener r0 = this.a.r;
            if (r0 == null) goto L7;
            r0.onLongClick(r2);
            return false;
        L7:
            return false;
        }
    }

    public static final class g implements Function1<Boolean, Unit> {
        public final /* synthetic */ DeepFeedProductHeaderView a;

        public g(DeepFeedProductHeaderView r1) {
            this.a = r1;
        }

        public final Object invoke(Object r9) {
            boolean r10 = ((Boolean) r9).booleanValue();
            if (r10 == false) goto L18;
            VideoCoverLayout r3 = this.a.getVideoProgressContainer();
            if (r3 == null) goto L18;
            if (r3.a() == false) goto L9;
            r3.k.setVisibility(4);
            r3.g.setVisibility(0);
        L10:
            r3.f.setVisibility(0);
            r3.setPlayState(true);
            if (r3.l == true) goto L18;
            r3.l = true;
            fd3.b r4 = r3.a;
            if (r4 == null) goto L15;
            r4.e();
        L15:
            fd3.b r5 = r3.a;
            if (r5 == null) goto L18;
            r5.d();
            goto L18
        L9:
            r3.k.setVisibility(0);
            ExtensionsKt.gone(r3.g);
        L18:
            Function1<? super Boolean, Unit> r6 = this.a.P;
            if (r6 == null) goto L22;
            Unit r7 = (Unit) r6.invoke(Boolean.valueOf(r10));
        L22:
            if (((ArrayList) this.a.p0).size() == 0) goto L97;
            if (r10 == true) goto L97;
            x0 r11 = (x0) CollectionsKt.getOrNull(this.a.p0, 0);
            LinearLayoutManager r8 = null;
            if (r11 == null) goto L27;
            HeaderBannerItemType r12 = r11.getType();
        L29:
            if (r12 != HeaderBannerItemType.CoverVideo) goto L97;
            DeepFeedProductHeaderView r13 = this.a;
            int r14 = r13.k;
            List<x0> r15 = CollectionsKt.toMutableList(CollectionsKt.drop(r13.p0, 1));
            ((ArrayList) r13.p0).clear();
            ((ArrayList) r13.p0).addAll(r15);
            r13.G = CollectionsKt.toList(r15);
            r13.J = DeepFeedProductHeaderView.b(r15);
            if (r15.isEmpty() == true) goto L35;
            if (r14 <= 0) goto L35;
            int r16 = RangesKt.coerceAtMost(r14 - 1, CollectionsKt.getLastIndex(r15));
        L36:
            r13.k = r16;
            DeepFeedProductBannerAdapter r17 = r13.f;
            if (r17 == null) goto L39;
            int r18 = DeepFeedProductBannerAdapter.z;
            r17.D2(r15, true);
        L39:
            r13.a();
            if (r13.h() == false) goto L51;
            DeepFeedProductHeaderTabLayout r19 = r13.y;
            if (r19 == null) goto L44;
            r19.setVisibility(0);
        L44:
            FrameLayout r20 = r13.c;
            if (r20 == null) goto L47;
            r20.setVisibility(8);
        L47:
            VideoCoverLayout r21 = r13.d;
            if (r21 == null) goto L50;
            r21.setVisibility(4);
        L50:
            r13.o(r13.k);
        L82:
            r13.a.stopScroll();
            if ((true ^ r15.isEmpty()) == false) goto L92;
            LinearLayoutManager r0 = r13.a.getLayoutManager();
            if ((r0 instanceof LinearLayoutManager) == false) goto L88;
            r8 = r0;
        L88:
            LinearLayoutManager r22 = r8;
            if (r22 == null) goto L91;
            r22.scrollToPositionWithOffset(r13.k, 0);
            goto L92
        L91:
            r13.a.scrollToPosition(r13.k);
        L92:
            r13.a.post(new com.bytedance.android.shopping.deepfeed.weights.h(r13));
            r13.i = false;
            DeepFeedProductBannerAdapter r1 = r13.f;
            if (r1 == null) goto L95;
            r1.r = false;
        L95:
            r13.g.c = false;
            r13.m();
            goto L97
        L51:
            ProductCardProgressIndicator r23 = r13.b;
            if (r23 == null) goto L54;
            r23.setup(((ArrayList) r13.p0).size());
        L54:
            VideoCoverLayout r24 = r13.d;
            if (r24 == null) goto L57;
            r24.c(HeaderBannerItemType.VideoAndImage, ((ArrayList) r13.p0).size());
        L57:
            List<x0> r25 = r13.p0;
            if ((r25 instanceof Collection) == true) goto L60;
        L62:
            Iterator r26 = ((ArrayList) r25).iterator();
        L64:
            if (r26.hasNext() == false) goto L71;
            if (((x0) r26.next()).getType() != HeaderBannerItemType.CoverVideo) goto L68;
            boolean r27 = true;
        L69:
            if (r27 == false) goto L64;
            boolean r28 = true;
        L72:
            if (r28 == true) goto L82;
            ProductCardProgressIndicator r29 = r13.b;
            if (r29 == null) goto L76;
            r29.setVisibility(0);
        L76:
            FrameLayout r30 = r13.c;
            if (r30 == null) goto L79;
            r30.setVisibility(0);
        L79:
            VideoCoverLayout r31 = r13.d;
            if (r31 == null) goto L82;
            r31.setVisibility(4);
            goto L82
        L68:
            r27 = false;
        L71:
            r28 = false;
            goto L72
        L60:
            if (((ArrayList) r25).isEmpty() == false) goto L62;
        L35:
            r16 = 0;
            goto L36
        L27:
            r12 = null;
        L97:
            return Unit.INSTANCE;
        }
    }

    public static final class h implements Function3<Long, Long, Long, Unit> {
        public final /* synthetic */ DeepFeedProductHeaderView a;

        public h(DeepFeedProductHeaderView r1) {
            this.a = r1;
        }

        public final Object invoke(Object r7, Object r8, Object r9) {
            long r0 = ((Number) r7).longValue();
            long r10 = ((Number) r8).longValue();
            long r2 = ((Number) r9).longValue();
            if (r0 == (-1)) goto L18;
            if (r10 == (-1)) goto L18;
            long r3 = r2 - r0;
            long r11 = r10 - r0;
            float r12 = r3 / r11;
            VideoCoverLayout r1 = this.a.getVideoProgressContainer();     // Catch: Exception -> L15
            if (r1 == null) goto L10;
            r1.b(r12, false);     // Catch: Exception -> L15
        L10:
            VideoCoverLayout r13 = this.a.getVideoProgressContainer();     // Catch: Exception -> L15
            if (r13 == null) goto L13;
            r13.setTotalDuration(r11);     // Catch: Exception -> L15
        L13:
            this.a.S = RangesKt.coerceAtLeast(r3, 0);     // Catch: Exception -> L15
            this.a.T = RangesKt.coerceAtLeast(r11, 0);     // Catch: Exception -> L15
        L15:
            e = move-exception;
            Logger.w("DeepFeedHeader", "video progress update error", e);
        L18:
            return Unit.INSTANCE;
        }
    }

    public DeepFeedProductHeaderView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductHeaderView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        H0 = new LinkedHashSet();
    }

    public final boolean e() {
        if (((ArrayList) this.p0).size() <= 0) goto L12;
        x0 r0 = (x0) CollectionsKt.getOrNull(this.p0, 0);
        if (r0 == null) goto L7;
        HeaderBannerItemType r1 = r0.getType();
    L9:
        if (r1 != HeaderBannerItemType.CoverVideo) goto L13;
        return true;
    L13:
        return false;
    L7:
        r1 = null;
        goto L9
    L12:
        return false;
    }

    public final boolean f() {
        if (((ArrayList) this.p0).size() <= 1) goto L12;
        x0 r0 = (x0) CollectionsKt.getOrNull(this.p0, 0);
        if (r0 == null) goto L7;
        HeaderBannerItemType r1 = r0.getType();
    L9:
        if (r1 != HeaderBannerItemType.CoverVideo) goto L13;
        return true;
    L13:
        return false;
    L7:
        r1 = null;
        goto L9
    L12:
        return false;
    }

    public final int getCurrentSelected() {
        OrientationHelper r0 = this.j;
        if (r0 == null) goto L26;
        LinearLayoutManager r3 = null;
        View r1 = f0.a(this.a, r0, null);
        if (r1 == null) goto L26;
        LinearLayoutManager r2 = this.a.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L10;
        r3 = r2;
    L10:
        LinearLayoutManager r4 = r3;
        if (r4 == null) goto L13;
        int r5 = r4.getPosition(r1);
    L14:
        DeepFeedProductBannerAdapter r6 = this.f;
        if (r6 == null) goto L17;
        int r7 = ((ArrayList) r6.b).size();
    L18:
        if (r5 >= r7) goto L20;
        return r5;
    L20:
        if (e() == false) goto L23;
        this.a.scrollToPosition(1);
        return 1;
    L23:
        this.a.scrollToPosition(0);
        return 0;
    L17:
        r7 = 0;
        goto L18
    L13:
        r5 = 0;
    L26:
        return 0;
    }

    public final int getItemCount() {
        DeepFeedProductBannerAdapter r0 = this.f;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return ((ArrayList) r0.b).size();
    }

    public final boolean h() {
        return !this.J.isEmpty();
    }

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
    public final void a() {
        if (h() == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L14;
        DeepFeedProductHeaderTabLayout r1 = this.y;
        if (r1 == null) goto L46;
        r1.setVisibility(8);
        return;
    L46:
        return;
    L14:
        DeepFeedProductHeaderTabLayout r2 = this.y;
        if (r2 == null) goto L39;
        List<b> r3 = this.J;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        r4.add(new DeepFeedProductHeaderTabLayout.b(((b) r5.next()).a));
        goto L18
    L20:
        int r6 = l(this.k);
        Function1<Integer, Unit> r7 = new DeepFeedProductHeaderView$bindHeaderTabs$2(this);
        Intrinsics.checkNotNullParameter(r4, "items");
        r2.b = r4;
        r2.removeAllViews();
        ((ArrayList) r2.a).clear();
        if (r4.isEmpty() == false) goto L23;
        r2.setVisibility(8);
        goto L39
    L23:
        r2.setVisibility(0);
        r2.b(r2.e, r4.size());
        Iterator r8 = r4.iterator();
        int r9 = 0;
    L25:
        if (r8.hasNext() == false) goto L38;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        String r12 = ((DeepFeedProductHeaderTabLayout.b) r10).a;
        View r13 = r2.d.inflate(2131564631, r2, false);
        if (r13 == null) goto L37;
        AppCompatTextView r14 = (AppCompatTextView) r13;
        r14.setText(r12);
        r14.setOnClickListener(new com.bytedance.android.shopping.deepfeed.weights.e(r9, r7));
        if (r2.a() == false) goto L34;
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, DeepFeedProductHeaderTabLayout.j);
    L35:
        r2.addView(r14, r15);
        ((ArrayList) r2.a).add(r14);
        r9 = r11;
        goto L25
    L34:
        r15 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        goto L35
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
    L38:
        r2.c(r6, null);
    L39:
        o(this.k);
        return;
    L5:
        if (this.M == false) goto L7;
        r0 = true;
        goto L9
    }

    public final boolean c() {
        boolean r1 = false;
        if (h() == true) goto L5;
        return false;
    L5:
        if (this.M == false) goto L12;
        if (this.L == false) goto L12;
        if (e() == true) goto L12;
        r1 = true;
    L12:
        return !r1;
    }

    public final void i() {
        if (h() == false) goto L8;
        if (this.M == true) goto L8;
        return;
    L8:
        if (e() == false) goto L33;
        boolean r1 = false;
        RecyclerView.ViewHolder r0 = this.a.findViewHolderForAdapterPosition(0);
        if (r0 != null) goto L12;
        return;
    L12:
        if ((r0 instanceof DeepFeedProductBannerVideoVH) == false) goto L35;
        DeepFeedProductBannerVideoVH r2 = (DeepFeedProductBannerVideoVH) r0;
        View r3 = ((RecyclerView.ViewHolder) r2).itemView;
        View r4 = null;
        if ((r3 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L16;
        r3 = null;
    L16:
        com.bytedance.android.shopping.deepfeed.weights.c r5 = (com.bytedance.android.shopping.deepfeed.weights.c) r3;
        if (r5 == null) goto L21;
        ECVideoPlayerView r6 = r5.getVideoPlayerView();
        if (r6 == null) goto L21;
        r1 = r6.h();
    L21:
        if (r1 == true) goto L36;
        View r7 = ((RecyclerView.ViewHolder) r2).itemView;
        if ((r7 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == false) goto L26;
        r4 = r7;
    L26:
        com.bytedance.android.shopping.deepfeed.weights.c r8 = (com.bytedance.android.shopping.deepfeed.weights.c) r4;
        if (r8 == null) goto L31;
        ECVideoPlayerView r9 = r8.getVideoPlayerView();
        if (r9 == null) goto L31;
        r9.n();
    L31:
        r2.V3();
        return;
    L36:
        return;
    L35:
        return;
    }

    public final void m() {
        if (c() == false) goto L7;
        this.e.c();
        return;
    L7:
        if (this.k != 0) goto L12;
        if (e() == false) goto L12;
        return;
    L12:
        if (this.i == false) goto L14;
        return;
    L14:
        if (this.k >= getItemCount()) goto L18;
        this.e.b();
        return;
    }

    public final TextView getAdTagView() {
        return this.C;
    }

    public final DeepFeedProductBannerAdapter getBannerAdapter() {
        return this.f;
    }

    public final boolean getIgnoreAnimCall() {
        return this.i;
    }

    public final View getMaskView() {
        return this.H;
    }

    public final ImageView getMuteIcon() {
        return this.A;
    }

    public final DeepFeedProductOverScrollPagerSnapHelper getOverScrollSnapHelper() {
        return this.g;
    }

    public final ProductCardProgressIndicator getProgressIndicator() {
        return this.b;
    }

    public final FrameLayout getProgressIndicatorContainer() {
        return this.c;
    }

    public final PrimeHorizontalRecyclerView getRecyclerView() {
        return this.a;
    }

    public final ConstraintLayout getSearchContainer() {
        return this.w;
    }

    public final ImageView getUnmuteIcon() {
        return this.B;
    }

    public final VideoCoverLayout getVideoProgressContainer() {
        return this.d;
    }

    public static List b(List r12) {
        ArrayList r1 = new ArrayList();
        Iterator r0 = r12.iterator();
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L36;
        Object r4 = r0.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        x0 r6 = (x0) r4;
        String r7 = r6.e;
        if (r6.d >= 0) goto L11;
    L32:
        b r8 = null;
    L33:
        if (r8 == null) goto L35;
        r1.add(r8);
    L35:
        r3 = r5;
        goto L4
    L11:
        if (r7 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L32;
        Iterator r10 = r12.iterator();
        int r11 = 0;
    L21:
        if (r10.hasNext() == false) goto L29;
        if (((x0) r10.next()).d != r6.d) goto L25;
        boolean r13 = true;
    L26:
        if (r13 == true) goto L30;
        r11 = r11 + 1;
    L30:
        if (r3 != r11) goto L32;
        r8 = new b(r7, r3);
        goto L33
    L25:
        r13 = false;
        goto L26
    L29:
        r11 = -1;
        goto L30
    L13:
        if (r7.length() == 0) goto L16;
        r9 = false;
        goto L17
    L36:
        return r1;
    }

    public final void d(boolean r3) {
        if (r3 == false) goto L5;
        this.A.setVisibility(0);
        this.B.setVisibility(4);
        return;
    L5:
        this.A.setVisibility(4);
        this.B.setVisibility(0);
    }

    public final void k(String r10) {
        Function4<? super Long, ? super Long, ? super Boolean, ? super String, Unit> r0 = this.R;
        if (r0 != null) goto L5;
        return;
    L5:
        long r7 = this.T;
        String r1 = this.V;
        if (r7 <= 0) goto L22;
        if (r1 != null) goto L9;
        return;
    L9:
        if (H0.add(r1) == false) goto L24;
        long r2 = RangesKt.coerceIn(this.S, 0, r7);
        if (this.U == false) goto L14;
    L19:
        boolean r3 = true;
    L20:
        r0.invoke(Long.valueOf(r2), Long.valueOf(r7), Boolean.valueOf(r3), r10);
        return;
    L14:
        if (r2 >= r7) goto L19;
        if (Intrinsics.areEqual(r10, "natural") == true) goto L19;
        r3 = false;
        goto L20
    L24:
        return;
    }

    public final int l(int r8) {
        x0 r9 = (x0) CollectionsKt.getOrNull(this.p0, r8);
        int r0 = -1;
        if (r9 == null) goto L5;
        int r10 = r9.d;
    L7:
        if (r10 >= 0) goto L9;
        return 0;
    L9:
        Iterator<b> r2 = this.J.iterator();
        int r3 = 0;
    L10:
        boolean r5 = true;
        if (r2.hasNext() == false) goto L21;
        b r4 = r2.next();
        x0 r6 = (x0) CollectionsKt.getOrNull(this.p0, r4.b);
        if (r6 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L19;
        r3 = r3 + 1;
        goto L10
    L19:
        r0 = r3;
        goto L21
    L15:
        if (r6.d != r10) goto L17;
        r7 = true;
    L21:
        Integer r11 = Integer.valueOf(r0);
        if (r11.intValue() >= 0) goto L25;
        r5 = false;
    L25:
        if (r5 == true) goto L28;
        r11 = null;
    L28:
        if (r11 != null) goto L30;
        return 0;
    L30:
        return r11.intValue();
    L5:
        r10 = -1;
        goto L7
    }

    public final void n(String r2) {
        if (r2 == null) goto L5;
        k(r2);
    L5:
        if (e() == false) goto L19;
        RecyclerView.ViewHolder r3 = this.a.findViewHolderForAdapterPosition(0);
        if (r3 != null) goto L9;
        return;
    L9:
        if ((r3 instanceof DeepFeedProductBannerVideoVH) == false) goto L21;
        View r4 = ((RecyclerView.ViewHolder) ((DeepFeedProductBannerVideoVH) r3)).itemView;
        if ((r4 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L13;
        r4 = null;
    L13:
        com.bytedance.android.shopping.deepfeed.weights.c r5 = (com.bytedance.android.shopping.deepfeed.weights.c) r4;
        if (r5 == null) goto L22;
        ECVideoPlayerView r6 = r5.getVideoPlayerView();
        if (r6 == null) goto L23;
        r6.x();
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void o(int r5) {
        if (h() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L13;
        DeepFeedProductHeaderTabLayout r6 = this.y;
        if (r6 == null) goto L31;
        r6.setVisibility(8);
        return;
    L31:
        return;
    L13:
        x0 r1 = (x0) CollectionsKt.getOrNull(this.p0, r5);
        if (r1 != null) goto L16;
        return;
    L16:
        int r7 = l(r5);
        if (r1.g > 1) goto L19;
    L21:
        String r2 = r1.e;
        if (r2 != null) goto L27;
        b r3 = (b) CollectionsKt.getOrNull(this.J, r7);
        if (r3 == null) goto L26;
        r2 = r3.a;
        goto L27
    L26:
        r2 = null;
    L27:
        DeepFeedProductHeaderTabLayout r4 = this.y;
        if (r4 == null) goto L32;
        r4.c(r7, r2);
        return;
    L32:
        return;
    L19:
        if (r1.f < 0) goto L21;
        r2 = r1.e + (r1.f + 1) + '/' + r1.g;
        goto L27
    L5:
        if (this.M == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void p(int r5) {
        int r1 = 8;
        if (e() == true) goto L8;
        VideoCoverLayout r6 = this.d;
        if (r6 == null) goto L26;
        r6.setVisibility(8);
        return;
    L26:
        return;
    L8:
        VideoCoverLayout r0 = this.d;
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.a() == true) goto L28;
        VideoCoverLayout r2 = this.d;
        if (r2 == null) goto L29;
        x0 r7 = (x0) CollectionsKt.getOrNull(this.p0, r5);
        if (r7 == null) goto L17;
        HeaderBannerItemType r8 = r7.getType();
    L19:
        if (r8 != HeaderBannerItemType.CoverVideo) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L24;
        r1 = 0;
    L24:
        r2.setVisibility(r1);
        return;
    L21:
        r9 = false;
        goto L22
    L17:
        r8 = null;
        goto L19
    L29:
        return;
    }

    public final void setBannerAdapter(DeepFeedProductBannerAdapter r1) {
        this.f = r1;
    }

    public final void setIgnoreAnimCall(boolean r1) {
        this.i = r1;
    }

    public final void setMute(boolean r5) {
        RecyclerView.ViewHolder r0 = this.a.findViewHolderForAdapterPosition(0);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof DeepFeedProductBannerVideoVH) == false) goto L26;
        DeepFeedProductBannerVideoVH r1 = (DeepFeedProductBannerVideoVH) r0;
        View r2 = ((RecyclerView.ViewHolder) r1).itemView;
        View r3 = null;
        if ((r2 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L9;
        r2 = null;
    L9:
        com.bytedance.android.shopping.deepfeed.weights.c r4 = (com.bytedance.android.shopping.deepfeed.weights.c) r2;
        if (r4 == null) goto L14;
        ECVideoPlayerView r6 = r4.getVideoPlayerView();
        if (r6 == null) goto L14;
        r6.k(r5);
    L14:
        if (r5 == true) goto L27;
        View r7 = ((RecyclerView.ViewHolder) r1).itemView;
        if ((r7 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == false) goto L19;
        r3 = r7;
    L19:
        com.bytedance.android.shopping.deepfeed.weights.c r8 = (com.bytedance.android.shopping.deepfeed.weights.c) r3;
        if (r8 == null) goto L28;
        ECVideoPlayerView r9 = r8.getVideoPlayerView();
        if (r9 == null) goto L29;
        r9.q();
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public final void setVideoProgressReportListener(Function4<? super Long, ? super Long, ? super Boolean, ? super String, Unit> r1) {
        this.R = r1;
    }

    public final void g(int r9, boolean r10) {
        int r0 = this.k;
        int r1 = l(r0);
        this.k = r9;
        o(r9);
        if (r9 >= 0) goto L5;
    L13:
        p(r9);
        float r5 = 0.0f;
        if (this.k == 0) goto L16;
    L27:
        String r2 = null;
        if (r0 != 0) goto L57;
        if (this.k == 0) goto L57;
        if (e() == false) goto L57;
        this.a.post(new d(this));
        if (f() == false) goto L39;
        this.i = true;
        DeepFeedProductBannerAdapter r11 = this.f;
        if (r11 == null) goto L38;
        r11.r = false;
    L38:
        this.g.c = false;
        r10 = false;
    L43:
        ProductCardProgressIndicator r3 = this.b;
        if (r3 == null) goto L46;
        r3.setFillCurrent(false);
    L46:
        ProductCardProgressIndicator r4 = this.b;
        if (r4 != null) goto L49;
    L52:
        VideoCoverLayout r6 = this.d;
        if (r6 == null) goto L55;
        r6.g.b(r9, 1.0f);
    L55:
        this.h = null;
        m();
    L70:
        if (r10 == false) goto L74;
        Runnable r12 = this.h;
        if (r12 == null) goto L74;
        r12.run();
    L74:
        ke3.a r13 = this.l;
        if (r13 == null) goto L77;
        int r7 = this.k;
        getItemCount();
        r13.a(r7, this.i);
    L77:
        int r14 = l(this.k);
        if (h() == true) goto L80;
    L82:
        boolean r8 = false;
    L83:
        if (r8 == false) goto L98;
        if (r1 == r14) goto L98;
        DeepFeedProductBannerAdapter r15 = this.f;
        if (r15 == null) goto L98;
        if (r15.r != true) goto L98;
        if (this.N == true) goto L98;
        x0 r16 = (x0) CollectionsKt.getOrNull(this.p0, this.k);
        if (r16 == null) goto L94;
        r2 = r16.e;
    L94:
        if (r2 == null) goto L98;
        Function2<? super Integer, ? super String, Unit> r17 = this.q;
        if (r17 == null) goto L98;
        Unit r18 = (Unit) r17.invoke(Integer.valueOf(r14 + 1), r2);
    L98:
        this.N = false;
        RecyclerView.ViewHolder r19 = this.a.findViewHolderForAdapterPosition(r9);
        DeepFeedProductBannerAdapter r110 = this.f;
        if (r110 == null) goto L102;
        r110.C2(r19);
        return;
    L102:
        return;
    L80:
        if (this.M == false) goto L82;
        r8 = true;
        goto L83
    L49:
        if (this.i == false) goto L51;
        r5 = 1.0f;
    L51:
        r4.b(r9, r5);
        goto L52
    L39:
        this.i = false;
        DeepFeedProductBannerAdapter r20 = this.f;
        if (r20 == null) goto L42;
        r20.r = true;
    L42:
        this.g.c = true;
    L57:
        if (this.k != 0) goto L59;
    L64:
        ProductCardProgressIndicator r21 = this.b;
        if (r21 == null) goto L70;
        if (this.i == false) goto L69;
        r5 = 1.0f;
    L69:
        r21.b(r9, r5);
        goto L70
    L59:
        if (f() == false) goto L64;
        VideoCoverLayout r111 = this.d;
        if (r111 == null) goto L63;
        r111.g.b(r9, 1.0f);
    L63:
        r10 = false;
        goto L70
    L16:
        if (e() == false) goto L27;
        if (r0 == 1) goto L19;
    L26:
        postDelayed(new c(this), 100);
        goto L27
    L19:
        if (f() == false) goto L26;
        VideoCoverLayout r22 = this.d;
        if (r22 == null) goto L23;
        r22.g.setFillCurrent(false);
    L23:
        VideoCoverLayout r23 = this.d;
        if (r23 == null) goto L26;
        r23.g.b(1, 0.0f);
        goto L26
    L5:
        if (r9 >= ((ArrayList) this.p0).size()) goto L13;
        x0 r24 = (x0) CollectionsKt.getOrNull(this.p0, r9);
        if (r24 == null) goto L13;
        HeaderBannerItemType r25 = r24.getType();
        if (r25 == null) goto L13;
        VideoCoverLayout r26 = this.d;
        if (r26 == null) goto L13;
        Intrinsics.checkNotNullParameter(r25, "type");
        r26.i = r25;
        goto L13
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.b
    public final void j(float r2, boolean r3) {
        ProductCardProgressIndicator r0 = this.b;
        if (r0 == null) goto L5;
        r0.j = r2;
        r0.invalidate();
    L5:
        if (r3 == true) goto L7;
        return;
    L7:
        if (c() == false) goto L9;
        this.e.c();
        return;
    L9:
        int r4 = this.k + 1;
        this.h = new j(this);
        this.a.smoothScrollToPosition(r4);
    }

    /* JADX WARN: Type inference failed for: r7v13, types: [com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductHeaderView$onScrollStateChangedListener$1] */
    public DeepFeedProductHeaderView(final Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.e = new DeepFeedProductBannerIndicatorAnimator(this);
        DeepFeedProductOverScrollPagerSnapHelper r8 = new DeepFeedProductOverScrollPagerSnapHelper();
        this.g = r8;
        this.s = new e(this);
        this.t = new DeepFeedProductHeaderView$innerBannerCommentClickListener$1(this);
        this.u = new DeepFeedProductHeaderView$innerBannerCommentShowListener$1(this);
        this.v = new f(this);
        this.J = CollectionsKt.emptyList();
        int r9 = tc3.f.a;
        this.L = Intrinsics.areEqual(tc3.a.a().q(), Boolean.TRUE);
        this.O = new h(this);
        this.Q = new DeepFeedProductHeaderView$videoPlayCompleteListener$1(this);
        this.W = new g(this);
        this.k0 = new DeepFeedProductHeaderView$onScrollStateChangedListener$1(this);
        this.p0 = new ArrayList();
        FrameLayout.inflate(r5, 2131564648, this);
        this.H = findViewById(2131368149);
        PrimeHorizontalRecyclerView r10 = findViewById(2131375256);
        SmoothScrollLayoutManager r0 = new SmoothScrollLayoutManager(r5);
        r0.setItemPrefetchEnabled(false);
        Resources r2 = th.a.f(r0.b);
        r0.a = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density * 0.15f;
        Unit r3 = Unit.INSTANCE;
        r10.setLayoutManager(r0);
        r8.attachToRecyclerView(r10);     // Catch: IllegalStateException -> L5
    L10:
        r10.addOnScrollListener(this.k0);
        this.j = OrientationHelper.createOrientationHelper(r10.getLayoutManager(), 0);
        r10.setItemViewCacheSize(0);
        r10.setTouchCallback(new DeepFeedProductHeaderView$$special$$inlined$apply$lambda$1(this, r5));
        Unit r11 = Unit.INSTANCE;
        this.a = r10;
        this.A = (ImageView) findViewById(2131376421);
        this.B = (ImageView) findViewById(2131376707);
        this.C = (TextView) findViewById(2131390108);
        r10.addOnScrollListener(new HybridRecyclerViewPerformanceMonitor("homepage_mall_depp_feed_horizon", new JSONObject()));
        IHybridHostService r12 = com.bytedance.android.ec.hybrid.a.h();
        if (r12 == null) goto L16;
        r12.attachDropFrameMonitorTo("ec_mall_product_deep_feed_horizon", r10);
        return;
    L16:
        return;
    L5:
        e = move-exception;
        String r13 = e.getMessage();
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        ECExceptionMonitor.c(r13);
        goto L10
    }

    public /* synthetic */ DeepFeedProductHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
