package com.bytedance.android.shopping.deepfeed.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.android.shopping.api.video.e;
import com.bytedance.android.shopping.api.video.k;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import com.bytedance.android.shopping.deepfeed.action.h;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedDefaultVH;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductBannerCommentVH;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductBannerImageVH;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductBannerVideoVH;
import com.bytedance.android.shopping.deepfeed.ui.vh.j;
import com.bytedance.android.shopping.deepfeed.ui.vh.l;
import com.bytedance.android.shopping.infeed.data.idl.HeaderBannerItemType;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.android.shopping.inflow.cardui.product.header.vh.BannerFooterVH;
import com.bytedance.android.shopping.inflow.common.utils.Contants$InflowType;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import he3.f;
import he3.g;
import he3.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/DeepFeedProductBannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductBannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int z = 0;
    public RecyclerView.ViewHolder a;
    public final List<x0> b;
    public View.OnClickListener c;
    public Function1<? super DeepFeedCommentClickArea, Unit> d;
    public Function0<Unit> e;
    public View.OnLongClickListener f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final b k;
    public final c l;
    public Function3<? super Long, ? super Long, ? super Long, Unit> m;
    public Function0<Unit> n;
    public Function1<? super Boolean, Unit> o;
    public r p;
    public h q;
    public boolean r;
    public boolean s;
    public Bitmap t;
    public Bitmap u;
    public Integer v;
    public final LifecycleOwner w;
    public final boolean x;
    public final Integer y;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DeepFeedProductBannerAdapter a;

        public b(DeepFeedProductBannerAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class c implements View.OnLongClickListener {
        public final /* synthetic */ DeepFeedProductBannerAdapter a;

        public c(DeepFeedProductBannerAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            View.OnLongClickListener r0 = this.a.f;
            if (r0 == null) goto L7;
            r0.onLongClick(r2);
            return false;
        L7:
            return false;
        }
    }

    static {
    }

    public final int getItemCount() {
        x0 r0 = (x0) CollectionsKt.firstOrNull(this.b);
        if (r0 == null) goto L5;
        HeaderBannerItemType r1 = r0.getType();
    L7:
        if (r1 != HeaderBannerItemType.Skeleton) goto L11;
        return ((ArrayList) this.b).size();
    L11:
        if (B2() == false) goto L18;
        com.bytedance.android.shopping.deepfeed.ui.view.a r2 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        com.bytedance.android.shopping.deepfeed.ui.view.a r3 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        if (r3 == null) goto L18;
        if (r3.c != true) goto L18;
        return ((ArrayList) this.b).size() + 1;
    L18:
        return ((ArrayList) this.b).size() + 2;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean y2() {
        if (((ArrayList) this.b).size() <= 0) goto L12;
        x0 r0 = (x0) CollectionsKt.getOrNull(this.b, 0);
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

    public final boolean B2() {
        boolean r1 = false;
        if (y2() == true) goto L6;
        return false;
    L6:
        if (((ArrayList) this.b).size() != 1) goto L8;
        return true;
    L8:
        List<x0> r0 = this.b;
        if ((r0 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r2 = r0.iterator();
    L15:
        if (r2.hasNext() == false) goto L26;
        x0 r3 = (x0) r2.next();
        if (r3.getType() != HeaderBannerItemType.Image) goto L19;
    L22:
        boolean r4 = true;
    L23:
        if (r4 == false) goto L15;
        r1 = true;
        goto L26
    L19:
        if (r3.getType() == HeaderBannerItemType.Comment) goto L22;
        r4 = false;
    L26:
        return !r1;
    L11:
        if (r0.isEmpty() == false) goto L13;
        goto L13
    }

    public final int A2(int r3) {
        x0 r4 = z2(r3);
        if (r4 == null) goto L5;
        HeaderBannerItemType r5 = r4.getType();
    L7:
        if (r5 != null) goto L10;
        return 1;
    L10:
        if (com.bytedance.android.shopping.deepfeed.ui.a.a[r5.ordinal()] != 1) goto L15;
        return 5;
    L15:
        return 1;
    L5:
        r5 = null;
        goto L7
    }

    public final void C2(RecyclerView.ViewHolder r6) {
        if ((!Intrinsics.areEqual(r6, this.a)) == true) goto L5;
        return;
    L5:
        if ((r6 instanceof DeepFeedProductBannerImageVH) == false) goto L7;
    L10:
        RecyclerView.ViewHolder r0 = this.a;
        RecyclerView.ViewHolder r3 = null;
        if ((r0 instanceof DeepFeedProductBannerImageVH) == true) goto L13;
        RecyclerView.ViewHolder r2 = null;
    L14:
        DeepFeedProductBannerImageVH r4 = (DeepFeedProductBannerImageVH) r2;
        if ((r0 instanceof DeepFeedProductBannerVideoVH) == true) goto L17;
        r0 = null;
    L17:
        DeepFeedProductBannerVideoVH r1 = (DeepFeedProductBannerVideoVH) r0;
        boolean r5 = false;
        if (r1 == null) goto L20;
        r1.W3(false);
    L20:
        this.a = r6;
        Integer r7 = Integer.valueOf(r6.getAdapterPosition());
        if (r7.intValue() == (-1)) goto L23;
        r5 = true;
    L23:
        if (r5 == true) goto L26;
        r7 = null;
    L26:
        if (r7 == null) goto L28;
        r7.intValue();
    L28:
        RecyclerView.ViewHolder r8 = this.a;
        if ((r8 instanceof DeepFeedProductBannerImageVH) == true) goto L31;
        RecyclerView.ViewHolder r9 = null;
    L32:
        DeepFeedProductBannerImageVH r10 = (DeepFeedProductBannerImageVH) r9;
        if ((r8 instanceof DeepFeedProductBannerVideoVH) == false) goto L36;
        r3 = r8;
    L36:
        DeepFeedProductBannerVideoVH r11 = (DeepFeedProductBannerVideoVH) r3;
        if (r11 == null) goto L42;
        r11.W3(true);
        return;
    L42:
        return;
    L31:
        r9 = r8;
        goto L32
    L13:
        r2 = r0;
        goto L14
    L7:
        if ((r6 instanceof DeepFeedProductBannerVideoVH) == true) goto L10;
        if ((r6 instanceof DeepFeedProductBannerCommentVH) == true) goto L10;
    }

    public final int getItemViewType(int r4) {
        if (((ArrayList) this.b).isEmpty() == false) goto L6;
        return -1;
    L6:
        x0 r0 = (x0) CollectionsKt.firstOrNull(this.b);
        if (r0 == null) goto L9;
        HeaderBannerItemType r1 = r0.getType();
    L11:
        if (r1 != HeaderBannerItemType.Skeleton) goto L15;
        return 4;
    L15:
        if (this.r == true) goto L17;
    L18:
        if (r4 == 1) goto L20;
    L22:
        boolean r2 = false;
    L23:
        this.s = r2;
        if (r4 == 0) goto L26;
    L28:
        if (r4 <= 0) goto L33;
        if (B2() == false) goto L33;
        return 0;
    L33:
        if (this.r == false) goto L38;
        if (r4 >= ((ArrayList) this.b).size()) goto L38;
        return A2(r4);
    L38:
        if (this.r == false) goto L40;
        return 0;
    L40:
        if (r4 < (((ArrayList) this.b).size() + 1)) goto L42;
        return 0;
    L42:
        return A2(r4);
    L26:
        if (y2() == false) goto L28;
        return 3;
    L20:
        if (B2() == false) goto L22;
    L21:
        r2 = true;
        goto L23
    L17:
        if (r4 == (getItemCount() - 1)) goto L21;
    L9:
        r1 = null;
        goto L11
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r7) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        super.onViewRecycled(r7);
        if (h33.a.a() == true) goto L5;
        return;
    L5:
        if (r7.getItemViewType() != 3) goto L225;
        View r1 = null;
        if ((r7 instanceof DeepFeedProductBannerVideoVH) == true) goto L10;
        r7 = null;
    L10:
        DeepFeedProductBannerVideoVH r8 = (DeepFeedProductBannerVideoVH) r7;
        if (r8 != null) goto L13;
        return;
    L13:
        if (h33.a.a() == false) goto L23;
        View r9 = ((RecyclerView.ViewHolder) r8).itemView;
        if ((r9 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == false) goto L18;
        r1 = r9;
    L18:
        com.bytedance.android.shopping.deepfeed.weights.c r2 = (com.bytedance.android.shopping.deepfeed.weights.c) r1;
        if (r2 == null) goto L219;
        ECVideoPlayerView r10 = r2.getVideoPlayerView();
        if (r10 == null) goto L220;
        r10.s();
        return;
    L220:
        return;
    L219:
        return;
    L23:
        int r0 = n.a;
        Object r3 = Boolean.FALSE;
        int r4 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L184
        Object r6 = d.c.get("mall_inner_feed_player_release_v2");     // Catch: Throwable -> L77
        if (r6 != null) goto L29;
    L74:
        Object r11 = null;
    L75:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L77
    L79:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L184
        if (r13 == null) goto L83;
        EnsureManager.ensureNotReachHere(r13);     // Catch: Throwable -> L184
    L83:
        if (Result.isFailure-impl(r12) == false) goto L86;
        r12 = null;
    L86:
        if ((r12 instanceof Boolean) == true) goto L88;
        r12 = null;
    L88:
        Object r14 = (Boolean) r12;     // Catch: Throwable -> L184
        if (r14 != null) goto L95;
        Object r15 = d.a.get("mall_inner_feed_player_release_v2");     // Catch: Throwable -> L184
        if ((r15 instanceof Boolean) == true) goto L94;
        r15 = null;
    L94:
        r14 = (Boolean) r15;     // Catch: Throwable -> L184
    L95:
        if (r14 != null) goto L194;
        int r16 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L184
        Object r17 = d.c.get("mall_inner_feed_player_release_v2");     // Catch: Throwable -> L150
        if (r17 != null) goto L102;
    L147:
        Object r18 = null;
    L148:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L150
    L152:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L175
        if (r20 == null) goto L156;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L175
    L156:
        if (Result.isFailure-impl(r19) == false) goto L159;
        r19 = null;
    L159:
        if ((r19 instanceof Boolean) == true) goto L161;
        r19 = null;
    L161:
        r14 = (Boolean) r19;     // Catch: Throwable -> L175
        if (r14 != null) goto L182;
        IHybridHostService r21 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L175
        if (r21 == null) goto L167;
        Object r22 = r21.getHostABValue("mall_inner_feed_player_release_v2", r3);     // Catch: Throwable -> L175
    L168:
        if (r22 != null) goto L170;
    L181:
        r14 = r3;
        goto L182
    L170:
        if ((r22 instanceof Boolean) == true) goto L172;
        r22 = null;
    L172:
        r14 = (Boolean) r22;     // Catch: Throwable -> L175
        if (r14 != null) goto L182;
    L175:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L184
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L184
        Throwable r24 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L184
        if (r24 == null) goto L180;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L184
    L180:
        if (Result.isFailure-impl(r14) == false) goto L182;
    L167:
        r22 = null;
    L182:
        d.d("mall_inner_feed_player_release_v2", r14);     // Catch: Throwable -> L184
        goto L194
    L102:
        if ((r17 instanceof Boolean) == true) goto L104;
        Object r25 = null;
    L105:
        r18 = (Boolean) r25;     // Catch: Throwable -> L150
        if (r18 != null) goto L148;
        if ((r17 instanceof Number) == false) goto L135;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L117;
        Float r26 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L150
        if ((r26 instanceof Boolean) == true) goto L115;
        r26 = null;
    L115:
        r18 = (Boolean) r26;     // Catch: Throwable -> L150
        goto L148
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L123;
        Double r27 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L150
        if ((r27 instanceof Boolean) == true) goto L121;
        r27 = null;
    L121:
        r18 = (Boolean) r27;     // Catch: Throwable -> L150
        goto L148
    L123:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L129;
        Integer r28 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L150
        if ((r28 instanceof Boolean) == true) goto L127;
        r28 = null;
    L127:
        r18 = (Boolean) r28;     // Catch: Throwable -> L150
        goto L148
    L129:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L135;
        Long r29 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L150
        if ((r29 instanceof Boolean) == true) goto L133;
        r29 = null;
    L133:
        r18 = (Boolean) r29;     // Catch: Throwable -> L150
    L135:
        if ((r17 instanceof JSONObject) == false) goto L137;
    L209:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L143
        Object r30 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Boolean.class);     // Catch: Throwable -> L143
        if ((r30 instanceof Boolean) == true) goto L141;
        r30 = null;
    L141:
        Object r31 = Result.constructor-impl((Boolean) r30);     // Catch: Throwable -> L143
    L145:
        r18 = r31;
        if (Result.isFailure-impl(r18) == false) goto L148;
    L143:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L150
        r31 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
        goto L145
    L137:
        if ((r17 instanceof JSONArray) == false) goto L147;
    L104:
        r25 = r17;
    L150:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L175
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L175
    L194:
        if (((Boolean) r14).booleanValue() == false) goto L222;
        View r34 = ((RecyclerView.ViewHolder) r8).itemView;
        if ((r34 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == false) goto L199;
        r1 = r34;
    L199:
        com.bytedance.android.shopping.deepfeed.weights.c r35 = (com.bytedance.android.shopping.deepfeed.weights.c) r1;
        if (r35 == null) goto L223;
        ECVideoPlayerView r36 = r35.getVideoPlayerView();
        if (r36 == null) goto L224;
        r36.s();
        return;
    L224:
        return;
    L223:
        return;
    L222:
        return;
    L29:
        if ((r6 instanceof Boolean) == true) goto L31;
        Object r37 = null;
    L32:
        r11 = (Boolean) r37;     // Catch: Throwable -> L77
        if (r11 != null) goto L75;
        if ((r6 instanceof Number) == false) goto L62;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L44;
        Float r38 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L77
        if ((r38 instanceof Boolean) == true) goto L42;
        r38 = null;
    L42:
        r11 = (Boolean) r38;     // Catch: Throwable -> L77
        goto L75
    L44:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L50;
        Double r39 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L77
        if ((r39 instanceof Boolean) == true) goto L48;
        r39 = null;
    L48:
        r11 = (Boolean) r39;     // Catch: Throwable -> L77
        goto L75
    L50:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L56;
        Integer r40 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L77
        if ((r40 instanceof Boolean) == true) goto L54;
        r40 = null;
    L54:
        r11 = (Boolean) r40;     // Catch: Throwable -> L77
        goto L75
    L56:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L62;
        Long r41 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L77
        if ((r41 instanceof Boolean) == true) goto L60;
        r41 = null;
    L60:
        r11 = (Boolean) r41;     // Catch: Throwable -> L77
    L62:
        if ((r6 instanceof JSONObject) == false) goto L64;
    L205:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L70
        Object r42 = SDKSettingsCacheManager.a().fromJson(r6.toString(), Boolean.class);     // Catch: Throwable -> L70
        if ((r42 instanceof Boolean) == true) goto L68;
        r42 = null;
    L68:
        Object r43 = Result.constructor-impl((Boolean) r42);     // Catch: Throwable -> L70
    L72:
        r11 = r43;
        if (Result.isFailure-impl(r11) == false) goto L75;
    L70:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L77
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L77
        goto L72
    L64:
        if ((r6 instanceof JSONArray) == false) goto L74;
    L31:
        r37 = r6;
    L77:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L184
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L184
    L184:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L189;
        EnsureManager.ensureNotReachHere(r48);
    L189:
        if (Result.isFailure-impl(r47) == true) goto L192;
        r3 = r47;
    L192:
        r14 = r3;
        goto L194
    }

    public final x0 z2(int r3) {
        HeaderBannerItemType r0 = null;
        if (r3 >= 0) goto L5;
    L21:
        return null;
    L5:
        if (((ArrayList) this.b).isEmpty() == true) goto L21;
        if (r3 >= ((ArrayList) this.b).size()) goto L12;
        return (x0) CollectionsKt.getOrNull(this.b, r3);
    L12:
        if (r3 != ((ArrayList) this.b).size()) goto L21;
        x0 r4 = (x0) CollectionsKt.firstOrNull(this.b);
        if (r4 == null) goto L17;
        r0 = r4.getType();
    L17:
        if (r0 != HeaderBannerItemType.CoverVideo) goto L20;
        return (x0) CollectionsKt.getOrNull(this.b, 1);
    L20:
        return (x0) CollectionsKt.firstOrNull(this.b);
    }

    public final void D2(List<x0> r3, boolean r4) {
        ((ArrayList) this.b).clear();
        ArrayList r0 = (ArrayList) this.b;
        r0.addAll(r3);
        this.j = false;
        if (r4 == false) goto L6;
        notifyItemRangeChanged(0, r3.size());
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r37, int r38) {
        RecyclerView.ViewHolder r2 = r37;
        Intrinsics.checkNotNullParameter(r2, "holder");
        int r0 = r37.getItemViewType();
        if (r0 != 1) goto L5;
        x0 r1 = z2(r38);
        if (r1 == null) goto L260;
        InFeedUrlModel r3 = r1.b;
    L261:
        boolean r4 = r2 instanceof DeepFeedProductBannerImageVH;
        if (r4 == true) goto L264;
        RecyclerView.ViewHolder r5 = null;
    L265:
        DeepFeedProductBannerImageVH r6 = (DeepFeedProductBannerImageVH) r5;
        if (r6 == null) goto L324;
        if (r3 == null) goto L269;
        Integer r7 = r3.getUrlType();
    L270:
        boolean r8 = this.x;
        h r9 = this.q;
        if (r6.e != 0) goto L274;
        DeepFeedFoldHelper.d();
        r6.e = k1.o();
    L274:
        if (r6.f != 0) goto L276;
        DeepFeedFoldHelper.d();
        r6.f = k1.k();
    L276:
        if (r8 == false) goto L287;
        n1.a r10 = n1.i;
        r10.getClass();
        if (n1.e != 0) goto L280;
        r10.getClass();
        n1.a.e(ECAppInfoService.e.getApplicationContext());
    L280:
        Object r11 = com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(n1.e));
        if ((r11 instanceof Float) == true) goto L283;
        r11 = null;
    L283:
        Float r12 = (Float) r11;
        if (r12 == null) goto L286;
        int r13 = (int) r12.floatValue();
    L288:
        if (r8 == false) goto L290;
        int r16 = 72;
    L292:
        if (r6.g != 0) goto L303;
        Object r14 = com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(k1.q()));
        if ((r14 instanceof Float) == true) goto L296;
        r14 = null;
    L296:
        Float r15 = (Float) r14;
        if (r15 == null) goto L299;
        int r17 = (int) r15.floatValue();
    L300:
        if (r17 <= 0) goto L302;
        r6.g = r17;
        goto L303
    L302:
        r6.g = 30;
        goto L303
    L299:
        r17 = 0;
    L303:
        if (r7 != null) goto L306;
    L310:
        float r18 = (r6.e * 4) / 3.0f;
        if (r8 == false) goto L315;
        if (r9 == null) goto L314;
        r9.k();
    L314:
        r6.d = r6.g + 44;
    L320:
        ViewGroup.LayoutParams r19 = r6.a.getLayoutParams();
        if (r19 == null) goto L324;
        r19.height = com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r18));
        goto L324
    L315:
        int r20 = r6.h;
        if (r20 != 0) goto L319;
        r20 = (int) ((((r6.f - r18) - r6.g) - 70) / 2);
        r6.h = r20;
    L319:
        r6.d = r20;
        goto L320
    L306:
        if (r7.intValue() != 1) goto L310;
        r6.d = (((r13 - r16) - 55) - r6.e) / 2;
        ViewGroup.LayoutParams r21 = r6.a.getLayoutParams();
        if (r21 == null) goto L324;
        r21.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6.e));
        goto L324
    L290:
        r16 = 70;
        goto L292
    L286:
        r13 = 700;
        goto L288
    L287:
        r13 = r6.f;
        goto L288
    L269:
        r7 = null;
    L324:
        if (this.h == false) goto L331;
        if (r4 == true) goto L327;
        RecyclerView.ViewHolder r22 = null;
    L328:
        DeepFeedProductBannerImageVH r23 = (DeepFeedProductBannerImageVH) r22;
        if (r23 == null) goto L337;
        r23.W3(this.i);
    L337:
        Integer r24 = this.v;
        if (r24 != null) goto L341;
    L343:
        Bitmap r25 = null;
    L344:
        Integer r26 = this.v;
        if (r26 != null) goto L348;
    L350:
        Bitmap r110 = null;
    L351:
        if (r4 == true) goto L353;
        RecyclerView.ViewHolder r27 = null;
    L354:
        DeepFeedProductBannerImageVH r111 = (DeepFeedProductBannerImageVH) r27;
        if (r111 == null) goto L367;
        h r28 = this.q;
        if (r38 != 0) goto L359;
        r111.a.getHierarchy().setPlaceholderImage(null);
    L359:
        if (r28 == null) goto L361;
        r28.i();
    L361:
        SimpleDraweeView r112 = r111.b;
        r111.c.setVisibility(8);
        r111.b.setVisibility(0);
        if (r38 != 0) goto L364;
        j r29 = new j(r111, r3, r38);
    L365:
        LruCache<String, Bitmap> r30 = l.a;
        InFeedUrlModel r31 = r3;
        l.b(r111.i, r31, r38, r111.a, r111.j, r29, r25);
        l.a(r111.i, r31, r38, r112, r111.j, r110);
        goto L367
    L364:
        r29 = null;
    L367:
        Integer r32 = this.v;
        if (r32 != null) goto L371;
    L373:
        InFeedUrlModel r113 = null;
    L374:
        int r33 = 1;
        if (this.g == true) goto L377;
        this.g = true;
        C2(r37);
    L377:
        r2.itemView.setOnClickListener(this.k);
        r2.itemView.setLongClickable(true);
        r2.itemView.setOnLongClickListener(this.l);
    L378:
        int r114 = 0;
    L379:
        if (r114 > r33) goto L411;
        x0 r34 = z2(r38 + r114);
        if (r34 == null) goto L410;
        if (r34.getType() != HeaderBannerItemType.Image) goto L386;
        h0.i(r34.b, this.p);
        goto L410
    L386:
        if (r34.getType() != HeaderBannerItemType.Comment) goto L410;
        he3.h r35 = r34.h;
        if (r35 == null) goto L390;
        ECUrlModel r36 = r35.c();
    L391:
        if (r36 != null) goto L393;
        r36 = CollectionsKt.emptyList();
    L393:
        Iterator<T> r39 = ((Iterable) r36).iterator();
    L395:
        if (r39.hasNext() == false) goto L401;
        ImageURL r40 = ((g) r39.next()).a();
        if (r40 == null) goto L399;
        InFeedUrlModel r41 = new InFeedUrlModel();
        r41.setUrlList(r40.getUrlList());
    L400:
        h0.i(r41, this.p);
        goto L395
    L399:
        r41 = r113;
        goto L400
    L401:
        he3.h r42 = r34.h;
        if (r42 == null) goto L408;
        f r43 = r42.b();
        if (r43 == null) goto L408;
        ImageURL r44 = r43.b();
        if (r44 == null) goto L408;
        InFeedUrlModel r45 = new InFeedUrlModel();
        r45.setUrlList(r44.getUrlList());
    L409:
        h0.i(r45, this.p);
    L408:
        r45 = r113;
        goto L409
    L390:
        r36 = r113;
    L410:
        r114 = r114 + 1;
        goto L379
    L411:
        return;
    L371:
        if (r38 != r32.intValue()) goto L373;
        r113 = null;
        this.t = null;
        this.u = null;
        this.v = null;
        goto L374
    L353:
        r27 = r2;
        goto L354
    L348:
        if (r38 != r26.intValue()) goto L350;
        r110 = this.u;
        goto L351
    L341:
        if (r38 != r24.intValue()) goto L343;
        r25 = this.t;
        goto L344
    L327:
        r22 = r2;
        goto L328
    L331:
        if (r4 == true) goto L333;
        RecyclerView.ViewHolder r46 = null;
    L334:
        DeepFeedProductBannerImageVH r47 = (DeepFeedProductBannerImageVH) r46;
        if (r47 == null) goto L337;
        r47.W3(false);
        goto L337
    L333:
        r46 = r2;
        goto L334
    L264:
        r5 = r2;
        goto L265
    L260:
        r3 = null;
        goto L261
    L5:
        if (r0 == 3) goto L57;
        if (r0 != 5) goto L9;
        Integer r48 = this.v;
        if (r48 != null) goto L20;
    L22:
        Bitmap r49 = null;
    L23:
        boolean r50 = r2 instanceof DeepFeedProductBannerCommentVH;
        if (r50 == true) goto L26;
        RecyclerView.ViewHolder r51 = null;
    L27:
        DeepFeedProductBannerCommentVH r52 = (DeepFeedProductBannerCommentVH) r51;
        if (r52 == null) goto L34;
        x0 r53 = z2(r38);
        if (r53 == null) goto L32;
        he3.h r54 = r53.h;
    L33:
        r52.W3(r54, r38, r49);
        goto L34
    L32:
        r54 = null;
    L34:
        if (r50 == true) goto L36;
        RecyclerView.ViewHolder r55 = null;
    L37:
        DeepFeedProductBannerCommentVH r56 = (DeepFeedProductBannerCommentVH) r55;
        if (r56 == null) goto L40;
        r56.o = this.d;
    L40:
        if (r50 == true) goto L42;
        RecyclerView.ViewHolder r57 = null;
    L43:
        DeepFeedProductBannerCommentVH r58 = (DeepFeedProductBannerCommentVH) r57;
        if (r58 == null) goto L46;
        r58.p = this.e;
    L46:
        Integer r59 = this.v;
        if (r59 == null) goto L53;
        if (r38 != r59.intValue()) goto L53;
        this.t = null;
        this.u = null;
        this.v = null;
    L53:
        if (this.g == true) goto L55;
        this.g = true;
        C2(r37);
    L55:
        r2.itemView.setLongClickable(true);
        r2.itemView.setOnLongClickListener(this.l);
    L256:
        r33 = 1;
        r113 = null;
        goto L378
    L42:
        r57 = r2;
        goto L43
    L36:
        r55 = r2;
        goto L37
    L26:
        r51 = r2;
        goto L27
    L20:
        if (r38 != r48.intValue()) goto L22;
        r49 = this.u;
        goto L23
    L9:
        if ((r2 instanceof DeepFeedDefaultVH) == true) goto L11;
        r2 = null;
    L11:
        DeepFeedDefaultVH r60 = (DeepFeedDefaultVH) r2;
        if (r60 == null) goto L256;
        h r61 = r60.a;
        if (r61 == null) goto L256;
        r61.i();
        goto L256
    L57:
        if ((r2 instanceof DeepFeedProductBannerVideoVH) == true) goto L59;
        RecyclerView.ViewHolder r62 = null;
    L60:
        DeepFeedProductBannerVideoVH r63 = (DeepFeedProductBannerVideoVH) r62;
        Function3<? super Long, ? super Long, ? super Long, Unit> r64 = this.m;
        if (r64 == null) goto L69;
        if (r63 == null) goto L69;
        Intrinsics.checkNotNullParameter(r64, "listener");
        View r115 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r115 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L66;
        r115 = null;
    L66:
        com.bytedance.android.shopping.deepfeed.weights.c r116 = (com.bytedance.android.shopping.deepfeed.weights.c) r115;
        if (r116 == null) goto L69;
        r116.setPlayProgressListener(r64);
    L69:
        String r65 = "";
        if (r63 == null) goto L149;
        x0 r66 = (x0) CollectionsKt.getOrNull(this.b, 0);
        boolean r117 = this.x;
        View r67 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r67 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L74;
        r67 = null;
    L74:
        com.bytedance.android.shopping.deepfeed.weights.c r68 = (com.bytedance.android.shopping.deepfeed.weights.c) r67;
        if (r68 == null) goto L149;
        if (r66 == null) goto L82;
        qe3.a r69 = r66.c;
        if (r69 == null) goto L82;
        Integer r70 = r69.d();
        if (r70 == null) goto L82;
        int r71 = r70.intValue();
    L83:
        if (r66 == null) goto L89;
        qe3.a r72 = r66.c;
        if (r72 == null) goto L89;
        Integer r73 = r72.a();
        if (r73 == null) goto L89;
        int r74 = r73.intValue();
    L91:
        if (r68.i != 0) goto L94;
        r68.i = k1.o();
    L94:
        if (r68.j != 0) goto L96;
        r68.j = k1.k();
    L96:
        if (r117 == false) goto L107;
        n1.a r75 = n1.i;
        r75.getClass();
        if (n1.e != 0) goto L100;
        r75.getClass();
        n1.a.e(ECAppInfoService.e.getApplicationContext());
    L100:
        Object r76 = com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(n1.e));
        if ((r76 instanceof Float) == true) goto L103;
        r76 = null;
    L103:
        Float r77 = (Float) r76;
        if (r77 == null) goto L106;
        int r78 = (int) r77.floatValue();
    L108:
        if (r117 == false) goto L110;
        int r118 = 72;
    L112:
        if (r68.k != 0) goto L123;
        Object r119 = com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(k1.q()));
        if ((r119 instanceof Float) == true) goto L116;
        r119 = null;
    L116:
        Float r120 = (Float) r119;
        if (r120 == null) goto L119;
        int r121 = (int) r120.floatValue();
    L120:
        if (r121 <= 0) goto L122;
        r68.k = r121;
        goto L123
    L122:
        r68.k = 30;
        goto L123
    L119:
        r121 = 0;
    L123:
        if (1 > r71) goto L142;
        if (r74 <= r71) goto L142;
        float r79 = r71;
        float r80 = (r68.i * r74) / r79;
        if ((r74 / r79) <= 1.5f) goto L129;
        r68.l = 0;
    L412:
        ViewGroup.LayoutParams r81 = r68.d.getLayoutParams();     // Catch: Exception -> L137
        if (r81 == null) goto L133;
        r81.height = com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r80));     // Catch: Exception -> L137
    L133:
        ViewGroup.LayoutParams r82 = r68.a.getLayoutParams();     // Catch: Exception -> L137
        if (r82 == null) goto L149;
        r82.height = com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r80));     // Catch: Exception -> L137
    L137:
        e = move-exception;
        String r84 = e.getMessage();
        if (r84 != null) goto L141;
        r84 = "";
    L141:
        ECExceptionMonitor.c(r84);
        goto L149
    L129:
        r68.l = r68.k + 44;
    L142:
        r68.l = (((r78 - r118) - 55) - r68.i) / 2;
        ViewGroup.LayoutParams r85 = r68.d.getLayoutParams();
        if (r85 == null) goto L145;
        r85.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r68.i));
    L145:
        ViewGroup.LayoutParams r86 = r68.a.getLayoutParams();
        if (r86 == null) goto L149;
        r86.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r68.i));
        goto L149
    L110:
        r118 = 70;
        goto L112
    L106:
        r78 = 700;
        goto L108
    L107:
        r78 = r68.j;
    L89:
        r74 = 0;
    L82:
        r71 = 0;
    L149:
        if (this.h == false) goto L157;
        if (r63 == null) goto L164;
        boolean r87 = this.i;
        View r88 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r88 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L154;
        r88 = null;
    L154:
        com.bytedance.android.shopping.deepfeed.weights.c r89 = (com.bytedance.android.shopping.deepfeed.weights.c) r88;
        if (r89 == null) goto L164;
        r89.setCloseTop(r87);
    L164:
        Function1<? super Boolean, Unit> r90 = this.o;
        if (r90 == null) goto L173;
        if (r63 == null) goto L173;
        Intrinsics.checkNotNullParameter(r90, "listener");
        View r91 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r91 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L170;
        r91 = null;
    L170:
        com.bytedance.android.shopping.deepfeed.weights.c r92 = (com.bytedance.android.shopping.deepfeed.weights.c) r91;
        if (r92 == null) goto L173;
        r92.setPlayListener(r90);
    L173:
        Function0<Unit> r94 = this.n;
        if (r94 == null) goto L182;
        if (r63 == null) goto L182;
        Intrinsics.checkNotNullParameter(r94, "listener");
        View r95 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r95 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L179;
        r95 = null;
    L179:
        com.bytedance.android.shopping.deepfeed.weights.c r96 = (com.bytedance.android.shopping.deepfeed.weights.c) r95;
        if (r96 == null) goto L182;
        r96.setPlayCompleteListener(r94);
    L182:
        if (r63 == null) goto L223;
        x0 r97 = (x0) CollectionsKt.getOrNull(this.b, 0);
        boolean r122 = com.bytedance.android.shopping.deepfeed.utlis.f.b;
        View r98 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r98 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L186;
        r98 = null;
    L186:
        com.bytedance.android.shopping.deepfeed.weights.c r99 = (com.bytedance.android.shopping.deepfeed.weights.c) r98;
        if (r99 == null) goto L223;
        if (r97 == null) goto L223;
        ECVideoPlayerView r100 = r99.b;
        if (r100 == null) goto L193;
        r100.x();
    L193:
        ECVideoPlayerView r101 = r99.b;
        if (r101 == null) goto L196;
        r101.s();
    L196:
        r99.b = new ECVideoPlayerView(r99.getContext(), null, 0, new com.bytedance.android.shopping.api.video.l(AVScene.MALL_PRODUCT_INFLOW_LIVE_REPLAY, true, true, false, null, true, true, 40));
        r99.a.removeAllViews();
        r99.a.addView(r99.b, new ViewGroup.LayoutParams(-1, -1));
        ImageView r102 = r99.e;
        r102.setVisibility(8);
        r99.a.addView(r102);
        r99.d.setVisibility(0);
        ECVideoPlayerView r103 = r99.b;
        if (r103 == null) goto L199;
        long r123 = r103.getDuration();
    L200:
        qe3.a r104 = r97.c;
        if (r104 == null) goto L204;
        String r105 = r104.c();
        if (r105 == null) goto L204;
    L205:
        qe3.a r124 = r97.c;
        if (r124 == null) goto L211;
        String r125 = r124.b();
        if (r125 == null) goto L211;
        r65 = r125;
    L211:
        ECVideoPlayerView r126 = r99.b;
        if (r126 == null) goto L214;
        r126.r(new com.bytedance.android.shopping.deepfeed.weights.d());
    L214:
        LruCache<String, Bitmap> r127 = l.a;
        l.c(r99.n, r97.b, r99.d, r99.m);
        l.a(r99.n, r97.b, 0, r99.c, r99.m, null);
        com.bytedance.android.shopping.api.video.d r106 = new com.bytedance.android.shopping.api.video.d(r122, true, (int) 0, (int) r123, false, 484);
        k r107 = new k();
        Intrinsics.checkNotNullParameter(r105, "videoKey");
        r107.a = r105;
        Intrinsics.checkNotNullParameter(r105, "key");
        r107.b = r105;
        r107.a(r65);
        com.bytedance.android.shopping.api.video.b r108 = r107.b();
        if (r108 == null) goto L223;
        Intrinsics.checkNotNullParameter(r108, "playItem");
        ArrayList r109 = new ArrayList();
        r109.add(r108);
        Intrinsics.checkNotNullParameter(r106, "options");
        Intrinsics.checkNotNullParameter(r105, "newVid");
        e r128 = new e(r105, 0, null, r109, null, r106, -1, 0.0f, null, -1, -1, null, null);
        ECVideoPlayerView r129 = r99.b;
        if (r129 == null) goto L220;
        r129.w(ScaleType.CENTER_CROP);
    L220:
        ECVideoPlayerView r130 = r99.b;
        if (r130 == null) goto L223;
        r130.b(r128);
    L204:
        r105 = "";
        goto L205
    L199:
        r123 = 0;
    L223:
        boolean r131 = true;
        if (this.g == true) goto L227;
        this.g = true;
        this.a = r2;
    L227:
        if (this.j == true) goto L255;
        if (r63 == null) goto L255;
        if (r38 != 0) goto L255;
        if (y2() == false) goto L255;
        int r132 = h33.a.c();
        if (r132 != 1) goto L235;
        View r133 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r133 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L249;
        r133 = null;
    L249:
        com.bytedance.android.shopping.deepfeed.weights.c r134 = (com.bytedance.android.shopping.deepfeed.weights.c) r133;
        if (r134 == null) goto L254;
        ECVideoPlayerView r135 = r134.getVideoPlayerView();
        if (r135 == null) goto L254;
        r135.p();
    L254:
        r131 = true;
        this.j = true;
        goto L255
    L235:
        if (r132 == 2) goto L237;
        r131 = true;
        goto L255
    L237:
        int r136 = h33.a.b();
        View r137 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r137 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L240;
        r137 = null;
    L240:
        com.bytedance.android.shopping.deepfeed.weights.c r138 = (com.bytedance.android.shopping.deepfeed.weights.c) r137;
        if (r138 == null) goto L245;
        ECVideoPlayerView r139 = r138.getVideoPlayerView();
        if (r139 == null) goto L245;
        r139.o(r136);
    L245:
        r131 = true;
        this.j = true;
    L255:
        r2.itemView.setOnClickListener(this.k);
        r2.itemView.setLongClickable(r131);
        r2.itemView.setOnLongClickListener(this.l);
        goto L256
    L157:
        if (r63 == null) goto L164;
        View r140 = ((RecyclerView.ViewHolder) r63).itemView;
        if ((r140 instanceof com.bytedance.android.shopping.deepfeed.weights.c) == true) goto L161;
        r140 = null;
    L161:
        com.bytedance.android.shopping.deepfeed.weights.c r141 = (com.bytedance.android.shopping.deepfeed.weights.c) r140;
        if (r141 == null) goto L164;
        r141.setCloseTop(false);
        goto L164
    L59:
        r62 = r2;
        goto L60
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        if (r8 != (-1)) goto L5;
    L18:
        int r9 = DeepFeedProductBannerImageVH.k;
        r r10 = this.p;
        Integer r1 = this.y;
        Intrinsics.checkNotNullParameter(r7, "parent");
        DeepFeedProductBannerImageVH r0 = new DeepFeedProductBannerImageVH(th.a.c(r7.getContext(), 2131564642, r7, false), r10);
        r0.i = r1;
        RecyclerView.ViewHolder r2 = r0;
    L20:
        return r2;
    L5:
        if (r8 == 1) goto L18;
        if (r8 != 3) goto L9;
        int r11 = DeepFeedProductBannerVideoVH.a;
        Context r12 = r7.getContext();
        r r13 = this.p;
        LifecycleOwner r3 = this.w;
        Integer r4 = this.y;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r3, "owner");
        return new DeepFeedProductBannerVideoVH(new com.bytedance.android.shopping.deepfeed.weights.c(r12, r13, r4), r3);
    L9:
        if (r8 != 4) goto L11;
        int r14 = DeepFeedDefaultVH.b;
        h r15 = this.q;
        Intrinsics.checkNotNullParameter(r7, "parent");
        r2 = new DeepFeedDefaultVH(th.a.c(r7.getContext(), 2131564629, r7, false), r15);
        goto L20
    L11:
        if (r8 == 5) goto L15;
        int r16 = BannerFooterVH.b;
        BannerFooterVH r17 = BannerFooterVH.a.a(r7);
        r17.T3(Contants$InflowType.INFEED_PRODUCT);
        if (this.s == false) goto L21;
        ((RecyclerView.ViewHolder) r17).itemView.setVisibility(8);
        ((RecyclerView.ViewHolder) r17).itemView.getLayoutParams().width = 0;
        this.s = false;
        return r17;
    L21:
        return r17;
    L15:
        int r18 = DeepFeedProductBannerCommentVH.u;
        Context r19 = r7.getContext();
        r r5 = this.p;
        Integer r6 = this.y;
        boolean r20 = this.x;
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r7, "parent");
        DeepFeedProductBannerCommentVH r21 = new DeepFeedProductBannerCommentVH(r19, th.a.c(r7.getContext(), 2131564641, r7, false), r5, r20);
        r21.n = r6;
        r2 = r21;
        goto L20
    }

    public DeepFeedProductBannerAdapter(LifecycleOwner r2, boolean r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.w = r2;
        this.x = r3;
        this.y = r4;
        this.b = new ArrayList();
        this.k = new b(this);
        this.l = new c(this);
    }
}
