package com.larksuite.component.ui.tag;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sz7.v;

/* JADX INFO: loaded from: classes24.dex */
public final class LarkNameTag {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f284333d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<DrawableStateSet, UDTagsDrawable.a> f284334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f284335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f284336c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larksuite/component/ui/tag/LarkNameTag$BlockLabelType;", "", "<init>", "(Ljava/lang/String;I)V", "TOTAL_BLOCKED", "STRANGER", "BLOCK", UserProfileEvent.POSITION_NONE, "Companion", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BlockLabelType extends Enum<BlockLabelType> {
        public static final BlockLabelType BLOCK = null;
        public static final a Companion = null;
        public static final BlockLabelType NONE = null;
        public static final BlockLabelType STRANGER = null;
        public static final BlockLabelType TOTAL_BLOCKED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BlockLabelType[] f284337a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284338b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<BlockLabelType> getEntries() {
            return f284338b;
        }

        static {
            BlockLabelType r100 = new BlockLabelType("TOTAL_BLOCKED", 0);
            TOTAL_BLOCKED = r100;
            BlockLabelType r101 = new BlockLabelType("STRANGER", 1);
            STRANGER = r101;
            BlockLabelType r102 = new BlockLabelType("BLOCK", 2);
            BLOCK = r102;
            BlockLabelType r103 = new BlockLabelType(UserProfileEvent.POSITION_NONE, 3);
            NONE = r103;
            BlockLabelType[] r104 = {r100, r101, r102, r103};
            f284337a = r104;
            f284338b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static BlockLabelType[] values() {
            return (BlockLabelType[]) f284337a.clone();
        }

        public static BlockLabelType valueOf(String r100) {
            return (BlockLabelType) r27.a.a(BlockLabelType.class, r100);
        }

        public BlockLabelType(String r100, int r101) {
            super(r100, r101);
        }

        @JvmStatic
        public static final BlockLabelType judge(boolean r100, boolean r101) {
            Companion.getClass();
            if (r100 == true) goto L9;
            if (r101 == false) goto L8;
            return STRANGER;
        L8:
            return NONE;
        L9:
            return TOTAL_BLOCKED;
        }
    }

    public static final class a extends b {
        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public g08.a f284339l;

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }

        public void g(List r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            if (r100.isEmpty() == false) goto L5;
            g08.a r101 = null;
        L6:
            this.f284339l = r101;
            return;
        L5:
            r101 = (g08.a) ListProtector.get(r100, 0);
            goto L6
        }

        public final void h(com.larksuite.component.ui.tag.a r100, g08.a r101) {
            Intrinsics.checkNotNullParameter(r100, "tagProvider");
            if (r101 == null) goto L5;
            Integer r102 = Integer.valueOf(r101.f479500b);
        L6:
            if (r102 == null) goto L11;
            if (r102.intValue() != 0) goto L11;
            return;
        L11:
            if (r102 != null) goto L14;
        L16:
            if (r102 != null) goto L19;
        L21:
            if (r102 != null) goto L24;
            return;
        L24:
            if (r102.intValue() != 3) goto L30;
            e(r100.a(r101.f479499a), true);
            return;
        L30:
            return;
        L19:
            if (r102.intValue() != 2) goto L21;
            e(r100.a(r101.f479499a), true);
            return;
        L14:
            if (r102.intValue() != 1) goto L16;
            e(r100.f284432l, true);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f284340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.larksuite.component.ui.tag.a f284341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DrawableStateSet[] f284342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinkedHashMap<DrawableStateSet, UDTagsDrawable.a> f284343d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f284344e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f284345f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f284346g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f284347h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ArrayList<HashSet<Integer>> f284348i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ArrayList<Integer> f284349j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final HashMap<DrawableStateSet, List<Pair<Integer, UDTagsDrawable.d>>> f284350k;

        public LarkNameTag f() {
            Iterator<Map.Entry<DrawableStateSet, List<Pair<Integer, UDTagsDrawable.d>>>> r100 = this.f284350k.entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L38;
            Map.Entry<DrawableStateSet, List<Pair<Integer, UDTagsDrawable.d>>> r101 = r100.next();
            DrawableStateSet r102 = r101.getKey();
            List<Pair<Integer, UDTagsDrawable.d>> r103 = r101.getValue();
            LinkedHashMap<DrawableStateSet, UDTagsDrawable.a> r104 = this.f284343d;
            UDTagsDrawable.a r105 = r104.get(r102);
            if (r105 != null) goto L8;
            r105 = new UDTagsDrawable.a(this.f284340a);
            r104.put(r102, r105);
        L8:
            UDTagsDrawable.a r106 = r105;
            if (r103.size() <= 1) goto L12;
            CollectionsKt.sortWith(r103, new com.larksuite.component.ui.tag.c());
        L12:
            if ((!r103.isEmpty()) == false) goto L18;
            if ((!this.f284349j.isEmpty()) == false) goto L18;
            Pair r107 = (Pair) CollectionsKt.first(r103);
            if (this.f284349j.contains(r107.getFirst()) == false) goto L18;
            r106.a((UDTagsDrawable.d) r107.getSecond());
        L18:
            HashSet r108 = new HashSet();
            int r109 = this.f284348i.size();
            ArrayList r110 = new ArrayList();
            Iterator<T> r111 = r103.iterator();
        L20:
            if (r111.hasNext() == false) goto L33;
            Object r112 = r111.next();
            Pair r113 = (Pair) r112;
            boolean r114 = r108.contains(r113.getFirst());
            if (r114 == true) goto L31;
            if (r109 <= 0) goto L31;
            Iterator<HashSet<Integer>> r115 = this.f284348i.iterator();
        L26:
            if (r115.hasNext() == false) goto L31;
            HashSet<Integer> r116 = r115.next();
            if (r116.contains(r113.getFirst()) == false) goto L26;
            r108.addAll(r116);
            r109 = r109 - 1;
        L31:
            if ((!r114) == false) goto L20;
            r110.add(r112);
            goto L20
        L33:
            Iterator r117 = r110.iterator();
        L35:
            if (r117.hasNext() == false) goto L4;
            r106.a((UDTagsDrawable.d) ((Pair) r117.next()).getSecond());
            goto L35
        L38:
            return new LarkNameTag(this.f284343d, this.f284346g, this.f284347h);
        }

        public final Context getContext() {
            return this.f284340a;
        }

        public c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f284340a = r100;
            this.f284341b = new com.larksuite.component.ui.tag.a();
            this.f284342c = new DrawableStateSet[]{DrawableStateSet.EMPTY};
            this.f284343d = new LinkedHashMap(2);
            this.f284348i = new ArrayList();
            this.f284349j = new ArrayList();
            new HashSet();
            this.f284350k = new HashMap();
        }

        public final /* bridge */ /* synthetic */ c b(com.larksuite.component.ui.tag.b r100, boolean r101) {
            c(r100, r101);
            return this;
        }

        public final void c(com.larksuite.component.ui.tag.b r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "iconTag");
            if (r101 == false) goto L18;
            DrawableStateSet[] r102 = this.f284342c;
            if (r102 == null) goto L22;
            int r103 = r102.length;
            int r104 = 0;
        L7:
            if (r104 >= r103) goto L23;
            DrawableStateSet r105 = r102[r104];
            Intrinsics.checkNotNullParameter(r105, "stateSet");
            Intrinsics.checkNotNullParameter(r100, "iconTag");
            UDTagsDrawable.d.a r106 = new UDTagsDrawable.d.a(this.f284340a);
            r106.f285352b = r100.f284447c;
            Context r107 = this.f284340a;
            Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r105, "state");
            r106.f285355e = r100.f284448d.invoke(r107, r105);
            com.larksuite.component.ui.tag.b.a r108 = r100.f284445a;
            String r109 = r108.f284453e;
            if (r109 == null) goto L11;
            r106.f285353c = r109;
        L11:
            UDTagsDrawable.TagColorSet r110 = r108.f284452d;
            if (r110 == null) goto L14;
            r106.c(r110);
        L14:
            r100.f284445a.getClass();
            Function2<? super Context, ? super DrawableStateSet, ? extends Drawable> r111 = r100.f284445a.f284454f;
            if (r111 == null) goto L17;
            Drawable r112 = r111.invoke(this.f284340a, r105);
            Intrinsics.checkNotNullParameter(r112, "backgroundDrawable");
            r106.f285357g = r112;
        L17:
            a(r105, r100.f284446b, r106.b());
            r104 = r104 + 1;
            goto L7
        L23:
            return;
        L22:
            return;
        }

        public final /* bridge */ /* synthetic */ c d(com.larksuite.component.ui.tag.f r100, boolean r101) {
            e(r100, r101);
            return this;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
        /* JADX WARN: Type inference failed for: r9v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
        public final void e(com.larksuite.component.ui.tag.f r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r110, "textTag");
            if (r111 == false) goto L9;
            DrawableStateSet[] r112 = this.f284342c;
            if (r112 == null) goto L11;
            int r100 = r112.length;
            int r101 = 0;
        L7:
            if (r101 >= r100) goto L12;
            DrawableStateSet r102 = r112[r101];
            Intrinsics.checkNotNullParameter(r102, "state");
            Intrinsics.checkNotNullParameter(r110, "textTag");
            int r103 = r110.f284459b;
            UDTagsDrawable.d.a r104 = new UDTagsDrawable.d.a(this.f284340a);
            r104.f285352b = r110.f284460c;
            Context r105 = this.f284340a;
            Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
            r104.f285353c = r110.f284461d.invoke(r105);
            Context r106 = this.f284340a;
            Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "state");
            r104.f285354d = ((Number) r110.f284462e.invoke(r106, r102)).intValue();
            Context r107 = this.f284340a;
            Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "state");
            r104.a(((Number) r110.f284463f.invoke(r107, r102)).intValue());
            a(r102, r103, r104.b());
            r101 = r101 + 1;
            goto L7
        L12:
            return;
        L11:
            return;
        }

        public final void a(DrawableStateSet r100, int r101, UDTagsDrawable.d r102) {
            HashMap<DrawableStateSet, List<Pair<Integer, UDTagsDrawable.d>>> r103 = this.f284350k;
            List<Pair<Integer, UDTagsDrawable.d>> r104 = r103.get(r100);
            if (r104 != null) goto L5;
            r104 = new ArrayList();
            r103.put(r100, r104);
        L5:
            r104.add(TuplesKt.to(Integer.valueOf(r101), r102));
        }
    }

    public static final class d extends b {
        public static final List<HashSet<Integer>> D = null;
        public static final List<Integer> E = null;
        public boolean A;
        public List<g08.a> B;
        public BlockLabelType C;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f284351m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f284352n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f284353o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f284354p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f284355q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f284356r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f284357s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f284358t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f284359u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f284360v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f284361w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f284362x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f284363y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f284364z;

        public static final class a {
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f284365a = null;

            static {
                int[] r100 = new int[BlockLabelType.values().length];
                r100[BlockLabelType.TOTAL_BLOCKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[BlockLabelType.BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f284365a = r100;
            }
        }

        static {
            com.larksuite.component.ui.tag.f r100 = TagProviderKt.f284368b;
            D = CollectionsKt.listOf(new HashSet[]{SetsKt.hashSetOf(new Integer[]{Integer.valueOf(r100.f284459b), Integer.valueOf(TagProviderKt.f284369c.f284459b), Integer.valueOf(TagProviderKt.f284370d.f284459b), Integer.valueOf(TagProviderKt.f284371e.f284459b), Integer.valueOf(TagProviderKt.f284372f.f284459b), 65573}), SetsKt.hashSetOf(new Integer[]{Integer.valueOf(r100.f284459b), Integer.valueOf(TagProviderKt.f284380n.f284446b), Integer.valueOf(TagProviderKt.f284379m.f284446b)}), SetsKt.hashSetOf(new Integer[]{Integer.valueOf(TagProviderKt.f284373g.f284459b), Integer.valueOf(TagProviderKt.f284374h.f284459b)})});
            E = CollectionsKt.listOf(Integer.valueOf(TagProviderKt.f284367a.f284459b));
        }

        @Override // com.larksuite.component.ui.tag.LarkNameTag.c
        public final LarkNameTag f() {
            Iterator<T> r100 = D.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            HashSet<Integer> r101 = (HashSet) r100.next();
            Intrinsics.checkNotNullParameter(r101, "constraint");
            this.f284348i.add(r101);
            goto L4
        L6:
            List<Integer> r102 = E;
            Intrinsics.checkNotNullParameter(r102, "constraint");
            this.f284349j.addAll(r102);
            e(this.f284341b.f284428h, this.f284363y);
            e(this.f284341b.f284429i, this.A);
            if (this.f284352n == true) goto L9;
        L12:
            c(this.f284341b.f284423c, this.f284355q);
            com.larksuite.component.ui.tag.f r103 = this.f284341b.f284424d;
            if (this.f284354p == false) goto L17;
            boolean r104 = v.f544033a;
            if (v.a.a() == false) goto L17;
            boolean r105 = true;
        L18:
            e(r103, r105);
            com.larksuite.component.ui.tag.f r106 = this.f284341b.f284425e;
            if (this.f284351m == false) goto L23;
            boolean r107 = v.f544033a;
            if (v.a.a() == false) goto L23;
            boolean r108 = true;
        L24:
            e(r106, r108);
            e(this.f284341b.f284421a, this.f284356r);
            e(this.f284341b.f284422b, this.f284357s);
            e(this.f284341b.f284432l, this.f284344e);
            e(this.f284341b.f284440t, this.f284345f);
            e(this.f284341b.f284437q, this.f284360v);
            e(this.f284341b.f284434n, this.f284358t);
            e(this.f284341b.f284438r, this.f284361w);
            c(this.f284341b.f284430j, this.f284362x);
            e(this.f284341b.f284441u, this.f284364z);
            e(this.f284341b.f284435o, this.f284359u);
            e(this.f284341b.f284431k, false);
            h(this.f284341b, this.f284339l);
            BlockLabelType r109 = this.C;
            int r110 = b.f284365a[r109.ordinal()];
            if (r110 != 1) goto L27;
            e(this.f284341b.f284443w, true);
        L31:
            Iterator r111 = ((ArrayList) this.B).iterator();
        L33:
            if (r111.hasNext() == false) goto L38;
            String r112 = ((g08.a) r111.next()).f479499a;
            if (r112 == null) goto L33;
            this.f284341b.getClass();
            Intrinsics.checkNotNullParameter(r112, "text");
            com.larksuite.component.ui.tag.f r113 = TagProviderKt.f284367a;
            Intrinsics.checkNotNullParameter(r112, "labelText");
            int r114 = com.larksuite.component.ui.tag.f.f284457g;
            com.larksuite.component.ui.tag.f.a r115 = new com.larksuite.component.ui.tag.f.a();
            r115.f284464a = 65574;
            r115.f284465b = 101;
            r115.f284467d = r112;
            r115.f284468e = R.color.udtoken_tag_text_indigo;
            r115.f284470g = R.color.udtoken_tag_bg_indigo;
            d(new com.larksuite.component.ui.tag.f(r115), true);
            goto L33
        L38:
            return super.f();
        L27:
            if (r110 == 2) goto L29;
            Unit r116 = Unit.INSTANCE;
            goto L31
        L29:
            e(this.f284341b.f284443w, true);
        L23:
            r108 = false;
        L17:
            r105 = false;
            goto L18
        L9:
            if (this.f284353o == false) goto L11;
            b(this.f284341b.f284427g, true);
            goto L12
        L11:
            b(this.f284341b.f284426f, true);
            goto L12
        }

        public d(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.B = new ArrayList();
            this.C = BlockLabelType.NONE;
        }

        @Override // com.larksuite.component.ui.tag.LarkNameTag.b
        public final void g(List r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            List r101 = r100;
            ArrayList r102 = new ArrayList();
            Iterator r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L8;
            Object r104 = r103.next();
            if (g08.b.a(((g08.a) r104).f479500b) == false) goto L4;
            r102.add(r104);
            goto L4
        L8:
            super.g(r102);
            ArrayList r105 = new ArrayList();
            Iterator r106 = r101.iterator();
        L10:
            if (r106.hasNext() == false) goto L17;
            Object r107 = r106.next();
            if (((g08.a) r107).f479500b != 4) goto L14;
            boolean r108 = true;
        L15:
            if (r108 == false) goto L10;
            r105.add(r107);
            goto L10
        L14:
            r108 = false;
            goto L15
        L17:
            this.B = r105;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final List<HashSet<Integer>> f284366m;

        @Override // com.larksuite.component.ui.tag.LarkNameTag.c
        public final LarkNameTag f() {
            Iterator<T> r100 = this.f284366m.iterator();
        L4:
            if (r100.hasNext() == false) goto L7;
            HashSet<Integer> r101 = (HashSet) r100.next();
            Intrinsics.checkNotNullParameter(r101, "constraint");
            this.f284348i.add(r101);
            goto L4
        L7:
            if (this.f284345f == false) goto L10;
            e(this.f284341b.f284433m, true);
        L12:
            h(this.f284341b, this.f284339l);
            return super.f();
        L10:
            if (this.f284344e == false) goto L12;
            e(this.f284341b.f284432l, true);
            goto L12
        }

        public e(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f284366m = CollectionsKt.listOf(new HashSet[]{SetsKt.hashSetOf(new Integer[]{Integer.valueOf(TagProviderKt.f284371e.f284459b), Integer.valueOf(TagProviderKt.f284370d.f284459b), 65573}), SetsKt.hashSetOf(new Integer[]{Integer.valueOf(TagProviderKt.f284385s.f284459b), Integer.valueOf(TagProviderKt.f284382p.f284459b), Integer.valueOf(TagProviderKt.f284383q.f284459b), Integer.valueOf(TagProviderKt.f284381o.f284446b)})});
        }
    }

    public static final class f {
        @JvmStatic
        public static d a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new d(r100);
        }
    }

    public static final class g extends b {
        @Override // com.larksuite.component.ui.tag.LarkNameTag.c
        public final LarkNameTag f() {
            if (this.f284344e == false) goto L5;
            d(this.f284341b.f284432l, true);
        L5:
            h(this.f284341b, this.f284339l);
            return super.f();
        }

        public g(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }
    }

    static {
    }

    public LarkNameTag() {
        throw null;
    }

    public final com.larksuite.component.ui.tag.d b() {
        Iterator<Map.Entry<DrawableStateSet, UDTagsDrawable.a>> r100 = this.f284334a.entrySet().iterator();
        com.larksuite.component.ui.tag.d r101 = null;
    L4:
        if (r100.hasNext() == false) goto L22;
        Map.Entry<DrawableStateSet, UDTagsDrawable.a> r102 = r100.next();
        DrawableStateSet r103 = r102.getKey();
        UDTagsDrawable.a r104 = r102.getValue();
        float r105 = this.f284335b;
        boolean r106 = true;
        if (r105 != 0.0f) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L11;
        r104.f285328b = r105;
    L11:
        float r108 = this.f284336c;
        if (r108 == 0.0f) goto L15;
        r106 = false;
    L15:
        if (r106 == true) goto L17;
        r104.f285334h = r108;
    L17:
        UDTagsDrawable r109 = r104.b();
        if (r109 == null) goto L4;
        if (r101 != null) goto L21;
        r101 = new com.larksuite.component.ui.tag.d();
    L21:
        Intrinsics.checkNotNull(r101);
        r101.setBounds(r109.getBounds());
        r101.addState(r103.getStateSet(), r109);
        goto L4
    L8:
        r107 = false;
        goto L9
    L22:
        return r101;
    }

    public final int hashCode() {
        Iterator<Map.Entry<DrawableStateSet, UDTagsDrawable.a>> r100 = this.f284334a.entrySet().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L7;
        Map.Entry<DrawableStateSet, UDTagsDrawable.a> r102 = r100.next();
        DrawableStateSet r103 = r102.getKey();
        r101 = r101 + (r102.getValue().hashCode() << r103.ordinal());
        goto L4
    L7:
        return r101 + (Float.floatToIntBits(this.f284335b) + Float.floatToIntBits(this.f284336c));
    }

    public final void c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Drawable[] r101 = r100.getCompoundDrawables();
        if (a(r101[2], this.f284334a) == true) goto L6;
        r100.setCompoundDrawablePadding(15);
        r100.setCompoundDrawables(r101[0], r101[1], b(), r101[3]);
        return;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(LarkNameTag.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.ui.tag.LarkNameTag");
        LarkNameTag r102 = (LarkNameTag) r100;
        if (this.f284335b != r102.f284335b) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L19;
        return false;
    L19:
        if (this.f284336c != r102.f284336c) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == true) goto L25;
        return false;
    L25:
        if (r102.f284334a.size() != this.f284334a.size()) goto L32;
        Iterator<Map.Entry<DrawableStateSet, UDTagsDrawable.a>> r105 = this.f284334a.entrySet().iterator();
    L28:
        if (r105.hasNext() == false) goto L32;
        Map.Entry<DrawableStateSet, UDTagsDrawable.a> r106 = r105.next();
        DrawableStateSet r107 = r106.getKey();
        UDTagsDrawable.a r108 = r106.getValue();
        if (Intrinsics.areEqual(r102.f284334a.get(r107), r108) == true) goto L28;
        return false;
    L32:
        return true;
    L21:
        r104 = false;
        goto L22
    L15:
        r103 = false;
        goto L16
    L8:
        r101 = null;
        goto L10
    }

    public static boolean a(Drawable r100, HashMap r101) {
        if ((r100 instanceof com.larksuite.component.ui.tag.d) == false) goto L22;
        com.larksuite.component.ui.tag.d r102 = (com.larksuite.component.ui.tag.d) r100;
        if (r102.f284455a.size() != r101.size()) goto L22;
        Iterator r103 = r101.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        Map.Entry r104 = (Map.Entry) r103.next();
        DrawableStateSet r105 = (DrawableStateSet) r104.getKey();
        UDTagsDrawable.a r106 = (UDTagsDrawable.a) r104.getValue();
        int[] r107 = r105.getStateSet();
        if (r107 == null) goto L12;
        Drawable r108 = r102.f284455a.get(r107);
    L13:
        boolean r109 = r108 instanceof UDTagsDrawable;
        if (r109 == false) goto L15;
        if (r109 == false) goto L19;
        if (((UDTagsDrawable) r108).hashCode() == r106.hashCode()) goto L8;
    L19:
        return false;
    L15:
        return false;
    L12:
        r108 = null;
        goto L13
    L20:
        return true;
    L22:
        return false;
    }

    public LarkNameTag(HashMap r100, float r101, float r102) {
        this.f284334a = r100;
        this.f284335b = r101;
        this.f284336c = r102;
    }
}
