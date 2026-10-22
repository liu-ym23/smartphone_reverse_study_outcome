package com.bytedance.android.shopping.commentv3.uitree.list.rvkit;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.e;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.ComponentType;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.ItemViewType;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentLynxComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentNativeComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.data.interfaces.ICommentComponent;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.BaseLynxViewHolder;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.BaseNativeViewHolder;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.BaseSliceViewHolder;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.CommentMediaViewHolder;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.FilterCardViewHolder;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.SortHeadViewHolder;
import com.bytedance.android.shopping.commentv3.utils.InteractionPerfMonitor;
import com.bytedance.android.shopping.commentv3.view.CommentLynxView;
import com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/CommentAdapter;", "Lcom/bytedance/android/shopping/jedi/LoadMoreRecyclerViewAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentAdapter extends LoadMoreRecyclerViewAdapter {
    public static final /* synthetic */ int B = 0;
    public final RecyclerView A;
    public final List<ICommentComponent> u;
    public int v;
    public final Lazy w;
    public FetchFrom x;
    public boolean y;
    public final c z;

    public static final class a implements Runnable {
        public final /* synthetic */ CommentAdapter a;
        public final /* synthetic */ List b;

        public a(CommentAdapter r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            c r0 = this.a.z;
            if (r0 == null) goto L8;
            com.bytedance.android.shopping.commentv3.data.b r1 = r0.e;
            if (r1 == null) goto L8;
            if (r1.c() != true) goto L8;
        L9:
            Iterator r2 = this.b.iterator();
        L11:
            if (r2.hasNext() == false) goto L21;
            Object r3 = r2.next();
            ICommentComponent r4 = (ICommentComponent) r3;
            if (Intrinsics.areEqual(r4.getComponentType(), ComponentType.TAB_FILTER.getType()) == false) goto L15;
        L18:
            boolean r5 = true;
        L19:
            if (r5 == false) goto L11;
        L22:
            if (r3 != null) goto L30;
            ((Function1) this.a.w.getValue()).invoke(0);
            return;
        L30:
            return;
        L15:
            if (Intrinsics.areEqual(r4.getComponentType(), ComponentType.COMMENT_FILTER_SECOND.getType()) == true) goto L18;
            r5 = false;
            goto L19
        L21:
            r3 = null;
        L8:
            this.a.A2();
            goto L9
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

    public final void A2() {
        RecyclerView.LayoutManager r0 = this.A.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L5;
        r0 = null;
    L5:
        LinearLayoutManager r1 = (LinearLayoutManager) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = r1.findFirstVisibleItemPosition();
        int r3 = r1.findLastVisibleItemPosition();
        if (r2 > r3) goto L15;
    L10:
        RecyclerView.ViewHolder r4 = this.A.findViewHolderForAdapterPosition(r2);
        if ((r4 instanceof CommentMediaViewHolder) == false) goto L13;
        ((CommentMediaViewHolder) r4).Z3();
    L13:
        if (r2 == r3) goto L17;
        r2 = r2 + 1;
        goto L10
    L17:
        return;
    }

    public final int getBasicItemCount() {
        return ((ArrayList) this.u).size();
    }

    public final int getBasicItemViewType(int r7) {
        if (r7 < 0) goto L50;
        if (r7 >= ((ArrayList) this.u).size()) goto L50;
        ICommentComponent r8 = (ICommentComponent) CollectionsKt.getOrNull(this.u, r7);
        ConcurrentHashMap<String, Integer> r0 = b.a;
        if (r8 != null) goto L10;
        return 3000;
    L10:
        if ((r8 instanceof CommentSliceComponent) == false) goto L37;
        String r9 = r8.getComponentType();
        if (r9 == null) goto L55;
        ConcurrentHashMap<String, Integer> r1 = b.a;
        if (r1.containsKey(r9) == false) goto L17;
    L32:
        Integer r10 = r1.get(r9);
        if (r10 == null) goto L51;
        int r11 = r10.intValue();
    L52:
        return r11;
    L51:
        return 1000;
    L17:
        if (Intrinsics.areEqual(r9, ComponentType.TAB_FILTER.getType()) == false) goto L20;
        r1.put(r9, 1001);
        goto L32
    L20:
        if (Intrinsics.areEqual(r9, ComponentType.COMMENT_FILTER_FIRST.getType()) == false) goto L23;
        r1.put(r9, 1001);
        goto L32
    L23:
        if (Intrinsics.areEqual(r9, ComponentType.COMMENT_FILTER_SECOND.getType()) == false) goto L26;
        r1.put(r9, 1001);
        goto L32
    L26:
        if (Intrinsics.areEqual(r9, ComponentType.SORT_HEADER.getType()) == false) goto L29;
        r1.put(r9, 1002);
        goto L32
    L29:
        if (StringsKt.startsWith$default(r9, ComponentType.COMMENT_MEDIA.getType(), false, 2, null) == false) goto L31;
        r1.put(r9, 1003);
        goto L32
    L31:
        int r2 = b.b;
        b.b = r2 + 1;
        r1.put(r9, Integer.valueOf(r2 + 1000));
        goto L32
    L55:
        return 1000;
    L37:
        if ((r8 instanceof CommentLynxComponent) == false) goto L47;
        String r12 = r8.getComponentType();
        if (r12 == null) goto L56;
        ConcurrentHashMap<String, Integer> r3 = b.a;
        if (r3.containsKey(r12) == true) goto L44;
        int r4 = b.c;
        b.c = r4 + 1;
        r3.put(r12, Integer.valueOf(r4 + 2000));
    L44:
        Integer r13 = r3.get(r12);
        if (r13 == null) goto L53;
        r11 = r13.intValue();
        goto L52
    L53:
        return 2000;
    L56:
        return 2000;
    L47:
        boolean r14 = r8 instanceof CommentNativeComponent;
        return 3000;
    L50:
        return ItemViewType.NATIVE.getType();
    }

    @Override // com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewDetachedFromWindow(r5);
        c r0 = this.z;
        if (r0 == null) goto L24;
        com.bytedance.android.shopping.commentv3.data.b r1 = r0.e;
        if (r1 == null) goto L24;
        gc3.a r2 = r1.d;
        if (r2 == null) goto L24;
        CommentSliceComponent r3 = null;
        if ((r5 instanceof BaseSliceViewHolder) == true) goto L11;
        RecyclerView.ViewHolder r4 = null;
    L12:
        BaseSliceViewHolder r6 = (BaseSliceViewHolder) r4;
        if (r6 == null) goto L15;
        CommentSliceComponent r7 = r6.d;
    L17:
        if ((r7 instanceof CommentSliceComponent) == false) goto L20;
        r3 = r7;
    L20:
        if (r3 == null) goto L24;
        r2.a(r3.getHideAction(), r3);
        goto L24
    L15:
        r7 = null;
        goto L17
    L11:
        r4 = r5;
    L24:
        if ((r5 instanceof CommentMediaViewHolder) == false) goto L31;
        pc3.a r8 = ((CommentMediaViewHolder) r5).a4();
        if (r8 == null) goto L32;
        ECVideoPlayerView r9 = r8.g;
        if (r9 == null) goto L33;
        r9.x();
        return;
    L33:
        return;
    L32:
        return;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r8) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r8);
        int r0 = ec3.a.a;
        int r1 = com.bytedance.android.ec.base.settings.b.a;
        int r2 = e.a;
        Object r3 = e.a(Boolean.TRUE, Boolean.FALSE);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L170
        h.a();     // Catch: Throwable -> L170
        SDKSettingsCacheManager r5 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L170
        r5.getClass();     // Catch: Throwable -> L58
        Object r6 = SDKSettingsCacheManager.b.get("ec_comment_player_release_on_recycle");     // Catch: Throwable -> L58
        if (r6 != null) goto L10;
    L55:
        Object r7 = null;
    L56:
        Object r9 = Result.constructor-impl(r7);     // Catch: Throwable -> L58
    L60:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L170
        if (r10 == null) goto L64;
        EnsureManager.ensureNotReachHere(r10);     // Catch: Throwable -> L170
    L64:
        if (Result.isFailure-impl(r9) == false) goto L67;
        r9 = null;
    L67:
        if ((r9 instanceof Boolean) == true) goto L69;
        r9 = null;
    L69:
        Object r11 = (Boolean) r9;     // Catch: Throwable -> L170
        if (r11 != null) goto L76;
        r5.getClass();     // Catch: Throwable -> L170
        Object r12 = SDKSettingsCacheManager.a.get("ec_comment_player_release_on_recycle");     // Catch: Throwable -> L170
        if ((r12 instanceof Boolean) == true) goto L75;
        r12 = null;
    L75:
        r11 = (Boolean) r12;     // Catch: Throwable -> L170
    L76:
        if (r11 != null) goto L180;
        int r13 = g.a;     // Catch: Throwable -> L170
    L157:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L170
        Object r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L160:
        if (Result.exceptionOrNull-impl(r15) != null) goto L190;
    L167:
        r11 = r15;
    L168:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L170
        SDKSettingsCacheManager.e("ec_comment_player_release_on_recycle", r11);     // Catch: Throwable -> L170
        goto L180
    L190:
        r15 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_comment_player_release_on_recycle", Boolean.class, r3);     // Catch: Throwable -> L164
    L165:
        if (r15 != null) goto L167;
        r11 = r3;
    L164:
        r15 = r3;
        goto L165
    L198:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r16 = SDKSettingsCacheManager.b.get("ec_comment_player_release_on_recycle");     // Catch: Throwable -> L132
        if (r16 != null) goto L84;
    L129:
        Object r17 = null;
    L130:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L132
    L134:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L157
        if (r19 == null) goto L138;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L157
    L138:
        if (Result.isFailure-impl(r18) == false) goto L141;
        r18 = null;
    L141:
        if ((r18 instanceof Boolean) == true) goto L143;
        r18 = null;
    L143:
        r15 = (Boolean) r18;     // Catch: Throwable -> L157
        if (r15 != null) goto L167;
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L157
        Object r21 = jj4.a.a("ec_comment_player_release_on_recycle", Boolean.class, r3, false);     // Catch: Throwable -> L157
        if (r21 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L157
    L150:
        if ((r21 instanceof Boolean) == true) goto L152;
        r21 = null;
    L152:
        Object r22 = (Boolean) r21;     // Catch: Throwable -> L157
        if (r22 != null) goto L155;
        r22 = r3;
    L155:
        r15 = Result.constructor-impl(r22);     // Catch: Throwable -> L157
    L84:
        if ((r16 instanceof Boolean) == true) goto L86;
        Object r23 = null;
    L87:
        r17 = (Boolean) r23;     // Catch: Throwable -> L132
        if (r17 != null) goto L130;
        if ((r16 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r24 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L132
        if ((r24 instanceof Boolean) == true) goto L97;
        r24 = null;
    L97:
        r17 = (Boolean) r24;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r25 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L132
        if ((r25 instanceof Boolean) == true) goto L103;
        r25 = null;
    L103:
        r17 = (Boolean) r25;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r26 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L132
        if ((r26 instanceof Boolean) == true) goto L109;
        r26 = null;
    L109:
        r17 = (Boolean) r26;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r27 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L132
        if ((r27 instanceof Boolean) == true) goto L115;
        r27 = null;
    L115:
        r17 = (Boolean) r27;     // Catch: Throwable -> L132
    L117:
        if ((r16 instanceof JSONObject) == false) goto L119;
    L194:
        Object r28 = SDKSettingsCacheManager.a().fromJson(r16.toString(), Boolean.class);     // Catch: Throwable -> L125
        if ((r28 instanceof Boolean) == true) goto L123;
        r28 = null;
    L123:
        Object r29 = Result.constructor-impl((Boolean) r28);     // Catch: Throwable -> L125
    L127:
        r17 = r29;
        if (Result.isFailure-impl(r17) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L132
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r16 instanceof JSONArray) == false) goto L129;
    L86:
        r23 = r16;
    L132:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L157
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L180:
        if (((Boolean) r11).booleanValue() == true) goto L182;
        return;
    L182:
        if ((r8 instanceof CommentMediaViewHolder) == false) goto L205;
        pc3.a r32 = ((CommentMediaViewHolder) r8).a4();
        if (r32 == null) goto L206;
        ECVideoPlayerView r33 = r32.g;
        if (r33 == null) goto L188;
        r33.s();
    L188:
        r32.h = null;
        return;
    L206:
        return;
    L205:
        return;
    L10:
        if ((r6 instanceof Boolean) == true) goto L12;
        Object r34 = null;
    L13:
        r7 = (Boolean) r34;     // Catch: Throwable -> L58
        if (r7 != null) goto L56;
        if ((r6 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r35 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L58
        if ((r35 instanceof Boolean) == true) goto L23;
        r35 = null;
    L23:
        r7 = (Boolean) r35;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r36 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L58
        if ((r36 instanceof Boolean) == true) goto L29;
        r36 = null;
    L29:
        r7 = (Boolean) r36;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r37 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L58
        if ((r37 instanceof Boolean) == true) goto L35;
        r37 = null;
    L35:
        r7 = (Boolean) r37;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r38 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L58
        if ((r38 instanceof Boolean) == true) goto L41;
        r38 = null;
    L41:
        r7 = (Boolean) r38;     // Catch: Throwable -> L58
    L43:
        if ((r6 instanceof JSONObject) == false) goto L45;
    L196:
        Object r39 = SDKSettingsCacheManager.a().fromJson(r6.toString(), Boolean.class);     // Catch: Throwable -> L51
        if ((r39 instanceof Boolean) == true) goto L49;
        r39 = null;
    L49:
        Object r40 = Result.constructor-impl((Boolean) r39);     // Catch: Throwable -> L51
    L53:
        r7 = r40;
        if (Result.isFailure-impl(r7) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L58
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r6 instanceof JSONArray) == false) goto L55;
    L12:
        r34 = r6;
    L58:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L170
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Object r44 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r45 = Result.exceptionOrNull-impl(r44);
        if (r45 == null) goto L175;
        EnsureManager.ensureNotReachHere(r45);
    L175:
        if (Result.isFailure-impl(r44) == true) goto L178;
        r3 = r44;
    L178:
        r11 = r3;
        goto L180
    }

    public CommentAdapter(c r2, RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "listRv");
        this.z = r2;
        this.A = r3;
        this.u = new ArrayList();
        this.w = LazyKt.lazy(new CommentAdapter$filterCardHeightListener$2(this));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onBindBasicViewHolder(final RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        com.bytedance.android.shopping.commentv3.data.b r0 = null;
        ICommentComponent r1 = null;
        ICommentComponent r2 = null;
        if (r8 >= 0) goto L5;
    L7:
        ICommentComponent r3 = null;
    L9:
        if ((r7 instanceof FilterCardViewHolder) == false) goto L18;
        if ((r3 instanceof CommentSliceComponent) == false) goto L14;
        r1 = r3;
    L14:
        CommentSliceComponent r4 = (CommentSliceComponent) r1;
        if (r4 == null) goto L43;
        ((FilterCardViewHolder) r7).Z3(r4, (Function1) this.w.getValue(), this.x);
    L43:
        if (this.y == true) goto L45;
    L47:
        r7.itemView.post(new com.bytedance.android.shopping.commentv3.uitree.list.rvkit.a(this, r8, r7));
        return;
    L45:
        if (this.x != null) goto L47;
        return;
    L18:
        if ((r7 instanceof BaseSliceViewHolder) == false) goto L27;
        if ((r3 instanceof CommentSliceComponent) == false) goto L23;
        r2 = r3;
    L23:
        CommentSliceComponent r5 = (CommentSliceComponent) r2;
        if (r5 == null) goto L43;
        BaseSliceViewHolder r6 = (BaseSliceViewHolder) r7;
        Function0<Integer> r9 = new CommentAdapter$onBindBasicViewHolder$$inlined$let$lambda$1(this, r7);
        int r10 = this.A.getHeight();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "component");
        Intrinsics.checkNotNullParameter(r9, "filterCardHeightGetter");
        r6.e = r9;
        r6.f = r10;
        r6.W3(r5.getTemplate());
        r6.X3(r5);
        goto L43
    L27:
        if ((r7 instanceof BaseLynxViewHolder) == false) goto L43;
        if ((r3 instanceof CommentLynxComponent) == true) goto L31;
        r3 = null;
    L31:
        CommentLynxComponent r11 = (CommentLynxComponent) r3;
        if (r11 == null) goto L43;
        BaseLynxViewHolder r12 = (BaseLynxViewHolder) r7;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "component");
        CommentLynxView r13 = r12.a;
        if (r13 == null) goto L40;
        c r14 = r12.b;
        if (r14 == null) goto L38;
        r0 = r14.e;
    L38:
        r13.a(r11, r0);
    L40:
        if (Intrinsics.areEqual(r11.getComponentType(), ComponentType.COMMENT_NPS.getType()) == false) goto L43;
        String r15 = y53.a.a;
        q.a.e(y53.a.a, System.currentTimeMillis() + (m53.b.a("passive", 7) * 86400000));
        goto L43
    L5:
        if (r8 >= ((ArrayList) this.u).size()) goto L7;
        r3 = (ICommentComponent) CollectionsKt.getOrNull(this.u, r8);
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        ConcurrentHashMap<String, Integer> r1 = b.a;
        c r2 = this.z;
        Intrinsics.checkNotNullParameter(r8, "parent");
        boolean r3 = true;
        if (1000 > r9) goto L7;
        if (2000 <= r9) goto L7;
        boolean r4 = true;
    L9:
        if (2000 > r9) goto L13;
        if (3000 <= r9) goto L13;
        boolean r5 = true;
    L14:
        if (r9 >= 3000) goto L17;
        r3 = false;
    L17:
        if (r4 == false) goto L23;
        switch(r9) {
            case 1001: goto L32;
            case 1002: goto L31;
            case 1003: goto L20;
            default: goto L29;
        };
    L20:
        CommentMediaViewHolder r0 = new CommentMediaViewHolder(b.a(r9, r8), r2);
        Intrinsics.checkNotNullParameter(r0, "vh");
        ((ArrayList) CommentMediaViewHolder.j).add(r0);
        return r0;
    L29:
        return new BaseSliceViewHolder(b.a(r9, r8), r2);
    L31:
        return new SortHeadViewHolder(b.a(r9, r8), r2);
    L32:
        return new FilterCardViewHolder(b.a(r9, r8), r2);
    L23:
        if (r5 == false) goto L25;
        int r10 = BaseLynxViewHolder.c;
        Intrinsics.checkNotNullParameter(r8, "parent");
        return new BaseLynxViewHolder(th.a.c(r8.getContext(), 2131560414, r8, false), r2);
    L25:
        if (r3 == false) goto L28;
        return new BaseNativeViewHolder(new View(r8.getContext()));
    L28:
        return new BaseNativeViewHolder(new View(r8.getContext()));
    L13:
        r5 = false;
    L7:
        r4 = false;
        goto L9
    }

    public final void B2(List<ICommentComponent> r3, boolean r4, FetchFrom r5) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r5, "fetchFrom");
        ((ArrayList) this.u).clear();
        ArrayList r0 = (ArrayList) this.u;
        r0.addAll(r3);
        setShowFooter(r4);
        y2();
        List<CommentMediaViewHolder> r6 = CommentMediaViewHolder.j;
        CommentMediaViewHolder.a.a(false);
        notifyDataSetChanged();
        this.A.post(new a(this, r3));
        this.x = r5;
        InteractionPerfMonitor.a r7 = InteractionPerfMonitor.j;
        String r8 = r5.getPerfMobKey();
        r7.getClass();
        InteractionPerfMonitor r9 = InteractionPerfMonitor.a.a(r8);
        r9.h = System.currentTimeMillis();
    }
}
