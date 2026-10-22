package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.PanelStickyHeaderDecoration;
import com.larus.bmhome.chat.component.bottom.core.inputtext.m1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.o1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import com.larus.bmhome.input.api.officemention.OfficeMentionService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class MentionPanelListView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f298815v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f298816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Boolean, Unit> f298817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutInflater f298818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PanelAdapter f298819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f298820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f298821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f298822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f298823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f298824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<? extends y> f298825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<? extends y> f298826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f298827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f298828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f298829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f298830o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f298831p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f298832q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super String, ? extends gc8.c> f298833r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Interpolator f298834s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f298835t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RecyclerView f298836u;

    public final class PanelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<? extends y> f298837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f298838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f298839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MentionPanelListView f298840d;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f298837a.size();
        }

        public PanelAdapter(MentionPanelListView r100) {
            this.f298840d = r100;
            this.f298837a = CollectionsKt.emptyList();
            this.f298838b = "";
            this.f298839c = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            y r101 = (y) ListProtector.get(this.f298837a, r100);
            if ((r101 instanceof y.a) == false) goto L6;
            return 0;
        L6:
            if ((r101 instanceof y.d) == false) goto L9;
            return 1;
        L9:
            if ((r101 instanceof y.c) == false) goto L12;
            return 3;
        L12:
            if (Intrinsics.areEqual(r101, y.b.f298973a) == false) goto L16;
            return 2;
        L16:
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewRecycled(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            if ((r100 instanceof c) == false) goto L5;
            c r101 = (c) r100;
        L6:
            if (r101 == null) goto L10;
            d r102 = r101.f298844a;
            if (r102 == null) goto L10;
            OfficeMentionService.f311790b.h(r102.f298846b);
            r102.f298851g = false;
        L10:
            ExposeXTrackerExtKt.e(r100.itemView);
            super.onViewRecycled(r100);
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "holder");
            View r100 = r110.itemView;
            r100.animate().cancel();
            float r101 = 0.0f;
            r100.setTranslationY(0.0f);
            y r102 = (y) ListProtector.get(this.f298837a, r111);
            if ((r102 instanceof y.a) == false) goto L13;
            View r103 = r110.itemView;
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.TextView");
            TextView r104 = (TextView) r103;
            r104.setText(((y.a) r102).f298972a);
            if (this.f298839c == false) goto L7;
            r101 = 1.0f;
        L7:
            r104.setAlpha(r101);
            if (this.f298839c == false) goto L10;
            int r105 = 0;
        L11:
            r104.setImportantForAccessibility(r105);
            return;
        L10:
            r105 = 2;
            goto L11
        L13:
            if ((r102 instanceof y.d) == false) goto L217;
            MentionPanelListView r106 = this.f298840d;
            d r107 = ((c) r110).f298844a;
            final y.d r108 = (y.d) r102;
            String r109 = this.f298838b;
            int r112 = MentionPanelListView.f298815v;
            r106.getClass();
            View r113 = r107.f298845a;
            final String r114 = r108.f298993p;
            final Function0<Unit> r115 = r108.f298994q;
            ExposeXTrackerExtKt.e(r113);
            if (r114 == null) goto L19;
            if (r115 == null) goto L19;
            ExposeXTrackerExtKt.b(r113, new b0(r115, r114));
        L19:
            r107.f298845a.setOnClickListener(new z(r108));
            t1 r116 = r108.f298983f;
            if (r116 == null) goto L22;
            o1.a(r107.f298849e, r108.f298978a, r116.f299233b);
            o1.a(r107.f298850f, r108.f298982e, r116.f299234c);
        L26:
            TextView r117 = r107.f298850f;
            if ((!StringsKt.isBlank(r108.f298982e)) == false) goto L29;
            int r118 = 0;
        L30:
            r117.setVisibility(r118);
            String r119 = r108.f298987j;
            if (r119 != null) goto L33;
        L36:
            boolean r120 = true;
        L37:
            boolean r121 = !r120;
            com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r122 = r108.f298988k;
            if (r122 != null) goto L40;
        L48:
            boolean r123 = false;
        L49:
            String r124 = r108.f298991n;
            if (r124 != null) goto L52;
        L55:
            boolean r125 = true;
        L56:
            if (r125 == true) goto L66;
            String r126 = r108.f298992o;
            if (r126 != null) goto L60;
        L63:
            boolean r127 = true;
        L64:
            if (r127 == true) goto L66;
            boolean r128 = true;
        L67:
            com.larus.bmhome.chat.referenceicon.b r129 = r108.f298989l;
            if (r129 == null) goto L70;
            Integer r130 = r129.f308534b;
        L71:
            if (r129 == null) goto L75;
            List<String> r131 = r129.f308533a;
            if (r131 == null) goto L75;
            String r132 = (String) CollectionsKt.firstOrNull(r131);
        L76:
            String r133 = r108.f298990m;
            if (r133 == null) goto L81;
            Function1<? super String, ? extends gc8.c> r134 = r106.f298833r;
            if (r134 == null) goto L81;
            gc8.c r135 = r134.invoke(r133);
        L83:
            if (r108.f298990m == null) goto L85;
            boolean r136 = true;
        L86:
            if (r128 == false) goto L96;
            if (r130 != null) goto L96;
            if (r132 != null) goto L96;
            if (r123 == true) goto L96;
            if (r121 == true) goto L96;
            if ((r135 instanceof gc8.c.a) == true) goto L96;
            if ((r135 instanceof gc8.c.b) == true) goto L96;
            boolean r137 = true;
        L97:
            if (r137 == true) goto L99;
        L101:
            boolean r138 = false;
        L103:
            if (r138 == true) goto L105;
            OfficeMentionService.f311790b.h(r107.f298846b);
            ImageLoaderKt.u(r107.f298846b, null, "mention_panel_icon");
        L105:
            r107.f298851g = r137;
            r107.f298846b.getHierarchy().setRoundingParams(new RoundingParams());
            GenericDraweeHierarchy r139 = r107.f298846b.getHierarchy();
            ScalingUtils.ScaleType r140 = ScalingUtils.ScaleType.CENTER_INSIDE;
            r139.setActualImageScaleType(r140);
            SimpleDraweeView r141 = r107.f298846b;
            if (r128 == true) goto L110;
            if (r136 == true) goto L110;
            boolean r142 = false;
        L111:
            r141.setClipToOutline(r142);
            View r143 = r107.f298848d;
            if (r128 == false) goto L114;
        L117:
            boolean r144 = true;
        L118:
            if (r144 == false) goto L120;
            int r145 = 0;
        L121:
            r143.setVisibility(r145);
            r107.f298847c.setText(r108.f298986i);
            TextView r146 = r107.f298847c;
            if (r130 != null) goto L130;
            if (r132 != null) goto L130;
            if (r121 == true) goto L130;
            if (r123 == true) goto L130;
            if (r128 == true) goto L130;
            if (r108.f298986i == null) goto L130;
            boolean r147 = true;
        L131:
            if (r147 == false) goto L133;
            int r148 = 0;
        L134:
            r146.setVisibility(r148);
            SimpleDraweeView r149 = r107.f298846b;
            if (r107.f298847c.getVisibility() != 0) goto L137;
            boolean r150 = true;
        L139:
            if ((!r150) == false) goto L141;
            int r151 = 0;
        L142:
            r149.setVisibility(r151);
            if (r130 == null) goto L146;
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            r107.f298846b.setImageTintList(null);
            r107.f298846b.setActualImageResource(r130.intValue());
            Unit r152 = Unit.INSTANCE;
        L229:
            return;
        L146:
            if (r132 == null) goto L148;
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r107.f298846b.setImageTintList(null);
            r107.f298846b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            r107.f298846b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.b(6)));
            ImageLoaderKt.u(r107.f298846b, r132, "mention_attachment_thumbnail");
            Unit r153 = Unit.INSTANCE;
            goto L229
        L148:
            if (r123 == false) goto L168;
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            r107.f298846b.setImageTintList(null);
            ImageLoaderKt.e(r107.f298846b);
            if (r122 == null) goto L229;
            Integer r154 = Integer.valueOf(r122.f298747b);
            if (r154.intValue() == 0) goto L154;
            boolean r155 = true;
        L155:
            if (r155 == false) goto L157;
            Integer r156 = r154;
        L158:
            if (r156 != null) goto L161;
            r156 = OfficeMentionService.f311790b.m(r122.f298749d);
        L161:
            if (r156 != null) goto L163;
        L165:
            FLogger.f375446a.i("MentionPanelListView", "[ReferenceIconTrace] path=mention_panel stage=load_document_icon overload=url");
            OfficeMentionService.f311790b.e(r107.f298846b, r122.f298749d);
        L166:
            Unit r157 = Unit.INSTANCE;
            goto L229
        L163:
            if (r156.intValue() == 0) goto L165;
            MessageReferenceIconStore r158 = MessageReferenceIconStore.f308518a;
            MessageReferenceIconStore.j(r122.f298749d, r156.intValue());
            FLogger.f375446a.i("MentionPanelListView", "[ReferenceIconTrace] path=mention_panel stage=load_document_icon overload=obj_type objType=" + r156);
            OfficeMentionService.f311790b.l(r107.f298846b, r156.intValue());
            goto L166
        L157:
            r156 = null;
            goto L158
        L154:
            r155 = false;
            goto L155
        L168:
            if ((r135 instanceof gc8.c.a) == false) goto L171;
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r107.f298846b.setImageTintList(null);
            r107.f298846b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            ImageLoaderKt.e(r107.f298846b);
            r107.f298846b.setActualImageResource(((gc8.c.a) r135).f480881a);
            Unit r159 = Unit.INSTANCE;
            goto L229
        L171:
            if ((r135 instanceof gc8.c.b) == false) goto L173;
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r107.f298846b.setImageTintList(null);
            r107.f298846b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            ImageLoaderKt.u(r107.f298846b, ((gc8.c.b) r135).f480882a, "mention_panel_conversation_icon");
            Unit r160 = Unit.INSTANCE;
            goto L229
        L173:
            if (r121 == false) goto L182;
            SimpleDraweeView r161 = r107.f298846b;
            if (r136 == false) goto L177;
            ImageView.ScaleType r162 = ImageView.ScaleType.CENTER_CROP;
        L178:
            r161.setScaleType(r162);
            r107.f298846b.setImageTintList(null);
            GenericDraweeHierarchy r163 = r107.f298846b.getHierarchy();
            if (r136 == false) goto L181;
            r140 = ScalingUtils.ScaleType.CENTER_CROP;
        L181:
            r163.setActualImageScaleType(r140);
            ImageLoaderKt.u(r107.f298846b, r108.f298987j, "mention_panel_icon");
            Unit r164 = Unit.INSTANCE;
            goto L229
        L177:
            r162 = ImageView.ScaleType.CENTER_INSIDE;
            goto L178
        L182:
            if (r128 == false) goto L195;
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r107.f298846b.setImageTintList(null);
            if (r138 == true) goto L186;
            ImageLoaderKt.e(r107.f298846b);
        L186:
            OfficeMentionService r165 = OfficeMentionService.f311790b;
            SimpleDraweeView r166 = r107.f298846b;
            String r167 = r108.f298991n;
            String r168 = "";
            if (r167 != null) goto L189;
            r167 = "";
        L189:
            String r169 = r108.f298992o;
            if (r169 == null) goto L193;
            r168 = r169;
        L193:
            r165.f(r166, r167, r168);
            Unit r170 = Unit.INSTANCE;
            goto L229
        L195:
            if (Intrinsics.areEqual(r108.f298979b.f298920a, "add") == false) goto L200;
            if (r108.f298984g == null) goto L200;
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageLoaderKt.e(r107.f298846b);
            r107.f298846b.setImageResource(r108.f298984g.intValue());
            SimpleDraweeView r171 = r107.f298846b;
            Context r172 = r106.f298816a;
            r171.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(r172, v19.c.b(R.attr.larus_neutral_100, r172, R.color.larus_neutral_100))));
            Unit r173 = Unit.INSTANCE;
        L200:
            if (r108.f298985h != null) goto L202;
        L204:
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageLoaderKt.e(r107.f298846b);
            Integer r174 = r108.f298984g;
            if (r174 == null) goto L207;
            r107.f298846b.setActualImageResource(r174.intValue());
        L207:
            SimpleDraweeView r175 = r107.f298846b;
            Integer r176 = r108.f298984g;
            if (r176 != null) goto L211;
        L213:
            ColorStateList r177 = null;
        L214:
            r175.setImageTintList(r177);
            Unit r178 = Unit.INSTANCE;
            goto L229
        L211:
            if (r176.intValue() != R.drawable.larus_ic_mention_reference) goto L213;
            r177 = ContextCompat.getColorStateList(r106.f298816a, android.R.color.holo_blue_light);
            goto L214
        L202:
            if (r108.f298984g == null) goto L204;
            r107.f298846b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageLoaderKt.e(r107.f298846b);
            r107.f298846b.setImageResource(r108.f298984g.intValue());
            r107.f298846b.setImageTintList(ColorStateList.valueOf(r108.f298985h.f314261a));
            Unit r179 = Unit.INSTANCE;
            goto L229
        L141:
            r151 = 8;
            goto L142
        L137:
            r150 = false;
            goto L139
        L133:
            r148 = 8;
        L130:
            r147 = false;
            goto L131
        L120:
            r145 = 8;
            goto L121
        L114:
            if (r108.f298986i != null) goto L117;
            r144 = false;
        L110:
            r142 = true;
            goto L111
        L99:
            if (r107.f298851g == false) goto L101;
            r138 = true;
        L96:
            r137 = false;
            goto L97
        L85:
            r136 = false;
        L81:
            r135 = null;
        L75:
            r132 = null;
            goto L76
        L70:
            r130 = null;
            goto L71
        L60:
            if (StringsKt.isBlank(r126) == true) goto L63;
            r127 = false;
        L66:
            r128 = false;
            goto L67
        L52:
            if (StringsKt.isBlank(r124) == true) goto L55;
            r125 = false;
            goto L56
        L40:
            if (r122.f298747b == 0) goto L42;
        L45:
            boolean r180 = true;
        L46:
            if (r180 != true) goto L48;
            r123 = true;
            goto L49
        L42:
            if ((!StringsKt.isBlank(r122.f298749d)) == true) goto L45;
            r180 = false;
            goto L46
        L33:
            if (StringsKt.isBlank(r119) == true) goto L36;
            r120 = false;
            goto L37
        L29:
            r118 = 8;
            goto L30
        L22:
            TextView r181 = r107.f298849e;
            String r182 = r108.f298978a;
            List<String> r183 = r108.f298981d;
            if (r183 != null) goto L25;
            r183 = CollectionsKt.listOf(r109);
        L25:
            o1.b(r181, r182, r183);
            r107.f298850f.setText(r108.f298982e);
            goto L26
        L217:
            if ((r102 instanceof y.c) == false) goto L225;
            MentionPanelListView r184 = this.f298840d;
            View r185 = r110.itemView;
            Intrinsics.checkNotNull(r185, "null cannot be cast to non-null type android.widget.TextView");
            TextView r186 = (TextView) r185;
            final y.c r187 = (y.c) r102;
            int r188 = MentionPanelListView.f298815v;
            r184.getClass();
            final String r189 = r187.f298975b;
            final Function0<Unit> r190 = r187.f298976c;
            ExposeXTrackerExtKt.e(r186);
            if (r189 == null) goto L223;
            if (r190 == null) goto L223;
            ExposeXTrackerExtKt.b(r186, new b0(r190, r189));
        L223:
            r186.setOnClickListener(new a0(r187));
            return;
        L225:
            if (Intrinsics.areEqual(r102, y.b.f298973a) == false) goto L228;
            return;
        L228:
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "parent");
            if (r111 != 0) goto L5;
            MentionPanelListView r100 = this.f298840d;
            int r101 = MentionPanelListView.f298815v;
            return new e(r100.i(r110));
        L5:
            if (r111 == 2) goto L15;
            if (r111 == 3) goto L9;
            MentionPanelListView r102 = this.f298840d;
            View r103 = r102.f298818c.inflate(R.layout.larus_item_panel_row, r110, false);
            SimpleDraweeView r104 = (SimpleDraweeView) r103.findViewById(R.id.panel_row_icon);
            r104.setOutlineProvider(new d0());
            View r105 = r103.findViewById(R.id.panel_row_icon_border);
            GradientDrawable r112 = new GradientDrawable();
            r112.setShape(1);
            r112.setColor(ContextCompat.getColor(r105.getContext(), android.R.color.transparent));
            int r106 = c7.b(1);
            Context r107 = r102.f298816a;
            r112.setStroke(r106, ContextCompat.getColor(r107, v19.c.b(R.attr.larus_neutral_transparent_1, r107, R.color.larus_neutral_transparent_1)));
            r105.setBackground(r112);
            Intrinsics.checkNotNull(r103);
            Intrinsics.checkNotNull(r104);
            TextView r108 = (TextView) r103.findViewById(R.id.panel_row_icon_text);
            Intrinsics.checkNotNull(r105);
            return new c(new d(r103, r104, r108, r105, (TextView) r103.findViewById(R.id.panel_row_title), (TextView) r103.findViewById(R.id.panel_row_description)));
        L9:
            View r113 = this.f298840d.f298818c.inflate(R.layout.larus_item_panel_more, r110, false);
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.widget.TextView");
            return new e((TextView) r113);
        L15:
            return new b(m1.a(this.f298840d.f298818c, r110));
        }

        public final void y2(final List<? extends y> r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "newItems");
            Intrinsics.checkNotNullParameter(r101, "newHighlightKeyword");
            final List<? extends y> r103 = this.f298837a;
            if (Intrinsics.areEqual(this.f298838b, r101) == true) goto L5;
        L8:
            final boolean r104 = true;
        L9:
            DiffUtil.DiffResult r105 = DiffUtil.calculateDiff(new MentionPanelListView$PanelAdapter$submitItems$diff$1(r103, r100, r104));
            this.f298837a = r100;
            this.f298838b = r101;
            this.f298839c = r102;
            r105.dispatchUpdatesTo(this);
            return;
        L5:
            if (this.f298839c != r102) goto L8;
            r104 = false;
            goto L9
        }
    }

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f298844a;

        public c(d r100) {
            Intrinsics.checkNotNullParameter(r100, "views");
            super(r100.f298845a);
            this.f298844a = r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f298845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SimpleDraweeView f298846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f298847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f298848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f298849e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f298850f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f298851g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f298845a, r101.f298845a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298846b, r101.f298846b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f298847c, r101.f298847c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f298848d, r101.f298848d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f298849e, r101.f298849e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f298850f, r101.f298850f) == true) goto L27;
            return false;
        L27:
            if (this.f298851g == r101.f298851g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((this.f298845a.hashCode() * 31) + this.f298846b.hashCode()) * 31) + this.f298847c.hashCode()) * 31) + this.f298848d.hashCode()) * 31) + this.f298849e.hashCode()) * 31) + this.f298850f.hashCode()) * 31;
            if (this.f298851g == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "RowViews(root=" + this.f298845a + ", icon=" + this.f298846b + ", iconText=" + this.f298847c + ", iconBorder=" + this.f298848d + ", title=" + this.f298849e + ", description=" + this.f298850f + ", usesOfficeAvatar=" + this.f298851g + ')';
        }

        public d(View r100, SimpleDraweeView r101, TextView r102, View r103, TextView r104, TextView r105) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "icon");
            Intrinsics.checkNotNullParameter(r102, "iconText");
            Intrinsics.checkNotNullParameter(r103, "iconBorder");
            Intrinsics.checkNotNullParameter(r104, "title");
            Intrinsics.checkNotNullParameter(r105, "description");
            this.f298845a = r100;
            this.f298846b = r101;
            this.f298847c = r102;
            this.f298848d = r103;
            this.f298849e = r104;
            this.f298850f = r105;
            this.f298851g = false;
        }
    }

    public static final class e extends RecyclerView.ViewHolder {
        public e(TextView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0 f298852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f298853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f298854c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f298852a, r101.f298852a) == true) goto L12;
            return false;
        L12:
            if (this.f298853b == r101.f298853b) goto L15;
            return false;
        L15:
            if (this.f298854c == r101.f298854c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f298852a.hashCode() * 31) + this.f298853b) * 31;
            if (this.f298854c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "VisibleRowAnchor(key=" + this.f298852a + ", offsetFromListTopPx=" + this.f298853b + ", sectionHeaderAtTop=" + this.f298854c + ')';
        }

        public f(g0 r100, int r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f298852a = r100;
            this.f298853b = r101;
            this.f298854c = r102;
        }
    }

    public static final class g implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f298855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MentionPanelListView f298856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinearLayoutManager f298857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Integer f298858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ f f298859e;

        public g(int r100, MentionPanelListView r101, LinearLayoutManager r102, Integer r103, f r104) {
            this.f298855a = r100;
            this.f298856b = r101;
            this.f298857c = r102;
            this.f298858d = r103;
            this.f298859e = r104;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            if (this.f298855a != this.f298856b.f298830o) goto L12;
            View r109 = this.f298857c.findViewByPosition(this.f298858d.intValue());
            if (r109 != null) goto L7;
            this.f298856b.f298831p = null;
            this.f298857c.scrollToPositionWithOffset(0, 0);
            return;
        L7:
            int r110 = this.f298856b.f298836u.getPaddingTop() + this.f298859e.f298853b;
            int r111 = RangesKt.coerceAtLeast(this.f298857c.getDecoratedTop(r109) - r110, 0);
            if (r111 <= 0) goto L10;
            this.f298856b.j(r111);
            this.f298857c.scrollToPositionWithOffset(this.f298858d.intValue(), this.f298859e.f298853b);
            MentionPanelListView r112 = this.f298856b;
            r112.f298836u.addOnLayoutChangeListener(new h(r112, this.f298855a, this.f298858d, this.f298859e, this.f298857c));
            return;
        L10:
            MentionPanelListView.a(this.f298856b, this.f298855a, this.f298858d.intValue(), this.f298859e.f298853b, this.f298857c);
            return;
        }
    }

    public static final class h implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MentionPanelListView f298860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f298861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f298862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f298863d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LinearLayoutManager f298864e;

        public h(MentionPanelListView r100, int r101, Integer r102, f r103, LinearLayoutManager r104) {
            this.f298860a = r100;
            this.f298861b = r101;
            this.f298862c = r102;
            this.f298863d = r103;
            this.f298864e = r104;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            MentionPanelListView.a(this.f298860a, this.f298861b, this.f298862c.intValue(), this.f298863d.f298853b, this.f298864e);
        }
    }

    static {
    }

    public final List<y> e() {
        if (this.f298828m == false) goto L13;
        List<? extends y> r100 = this.f298825j;
        List<? extends y> r101 = r100;
        Integer r102 = this.f298823h;
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
    L8:
        int r104 = r103 - g(r100);
        int r105 = 0;
        int r106 = RangesKt.coerceAtLeast(r104, 0);
        int r107 = this.f298820e;
        int r108 = Math.max(2, ((r106 + r107) - 1) / r107);
        ArrayList r109 = new ArrayList(r108);
    L9:
        if (r105 >= r108) goto L15;
        r109.add(y.b.f298973a);
        r105 = r105 + 1;
        goto L9
    L15:
        return CollectionsKt.plus(r101, r109);
    L7:
        r103 = this.f298822g;
        goto L8
    L13:
        return this.f298825j;
    }

    public static final void b(MentionPanelListView r100) {
        Function0<Unit> r101 = r100.f298821f;
        if (r101 == null) goto L19;
        RecyclerView.LayoutManager r102 = r100.f298836u.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r103 = (LinearLayoutManager) r102;
    L9:
        if (r103 == null) goto L20;
        int r104 = r103.findLastVisibleItemPosition();
        if (r104 != (-1)) goto L15;
        return;
    L15:
        if (r104 < (r100.f298819d.getItemCount() - 2)) goto L18;
        r101.invoke();
        return;
    L18:
        return;
    L20:
        return;
    L8:
        r103 = null;
        goto L9
    }

    public static int h(List r100) {
        boolean r101 = true;
        if ((!r100.isEmpty()) == false) goto L17;
        List r102 = r100;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        if (Intrinsics.areEqual((y) r103.next(), y.b.f298973a) == true) goto L11;
        r101 = false;
    L15:
        if (r101 == false) goto L17;
        return 6;
    L7:
        if (r102.isEmpty() == false) goto L9;
    L17:
        return 8;
    }

    public final void c(List<? extends y> r100) {
        int r101 = c7.b(Integer.valueOf(h(r100)));
        int r102 = c7.b(6) + this.f298832q;
        if (this.f298836u.getPaddingTop() == r101) goto L5;
    L7:
        RecyclerView r103 = this.f298836u;
        r103.setPadding(r103.getPaddingLeft(), r101, this.f298836u.getPaddingRight(), r102);
        return;
    L5:
        if (this.f298836u.getPaddingBottom() != r102) goto L7;
    }

    public final void d(f r110) {
        this.f298836u.stopScroll();
        RecyclerView.LayoutManager r100 = this.f298836u.getLayoutManager();
        if ((r100 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r101 = (LinearLayoutManager) r100;
    L6:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r110 == null) goto L31;
        PanelAdapter r102 = this.f298819d;
        g0 r103 = r110.f298852a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "key");
        Iterator<? extends y> r104 = r102.f298837a.iterator();
        int r105 = 0;
    L12:
        if (r104.hasNext() == false) goto L24;
        y r106 = r104.next();
        if ((r106 instanceof y.d) == false) goto L16;
        y.d r107 = (y.d) r106;
    L17:
        if (r107 == null) goto L19;
        g0 r108 = r107.f298980c;
    L21:
        if (Intrinsics.areEqual(r108, r103) == true) goto L25;
        r105 = r105 + 1;
    L25:
        Integer r109 = Integer.valueOf(r105);
        if (r109.intValue() == (-1)) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == false) goto L31;
        Integer r112 = r109;
    L32:
        if (r112 == null) goto L41;
        if (r110 == null) goto L41;
        if (r110.f298854c == true) goto L39;
        this.f298831p = null;
        j(0);
        r101.scrollToPositionWithOffset(0, 0);
        return;
    L39:
        j(0);
        r101.scrollToPositionWithOffset(r112.intValue(), r110.f298853b);
        this.f298836u.addOnLayoutChangeListener(new g(this.f298830o, this, r101, r112, r110));
        return;
    L41:
        this.f298831p = null;
        j(0);
        r101.scrollToPositionWithOffset(0, 0);
        return;
    L28:
        r111 = false;
        goto L29
    L19:
        r108 = null;
        goto L21
    L16:
        r107 = null;
        goto L17
    L24:
        r105 = -1;
    L31:
        r112 = null;
        goto L32
    L5:
        r101 = null;
        goto L6
    }

    public final void f(boolean r100) {
        this.f298830o++;
        if (r100 == false) goto L5;
        this.f298831p = null;
    L5:
        int r101 = this.f298836u.getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        View r103 = this.f298836u.getChildAt(r102);
        r103.animate().cancel();
        r103.setTranslationY(0.0f);
        r102 = r102 + 1;
        goto L6
    }

    public final int g(List<? extends y> r100) {
        return c7.b(Integer.valueOf(h(r100) + 6)) + (r100.size() * this.f298820e);
    }

    public final TextView i(ViewGroup r100) {
        View r101 = this.f298818c.inflate(R.layout.larus_item_panel_header, r100, false);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.TextView");
        TextView r102 = (TextView) r101;
        r102.setText("");
        r102.setTypeface(Typeface.create("sans-serif-medium", 0));
        return r102;
    }

    public final void j(int r100) {
        this.f298832q = RangesKt.coerceAtLeast(r100, 0);
        c(this.f298826k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MentionPanelListView(Context r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onContentHeightChanged");
        this.f298816a = r100;
        this.f298817b = r101;
        this.f298818c = LayoutInflater.from(r100);
        PanelAdapter r102 = new PanelAdapter(this);
        this.f298819d = r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f298820e = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_40, r100, R.dimen.larus_dp_40));
        this.f298822g = c7.b(360);
        this.f298825j = CollectionsKt.emptyList();
        this.f298826k = CollectionsKt.emptyList();
        this.f298827l = "";
        this.f298829n = true;
        this.f298834s = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        int r103 = c7.b(8);
        this.f298835t = r103;
        RecyclerView r104 = new RecyclerView(r100);
        r104.setPadding(0, r103, 0, c7.b(6));
        r104.setLayoutManager(new LinearLayoutManager(r104.getContext()));
        r104.setAdapter(r102);
        r104.setItemAnimator(null);
        ExposeXTrackerExtKt.c(r104);
        r104.addItemDecoration(new PanelStickyHeaderDecoration(new MentionPanelListView$view$1$1(r102), new c0(this)));
        r104.addOnScrollListener(new MentionPanelListView$view$1$3(this));
        this.f298836u = r104;
    }

    public static final void a(MentionPanelListView r100, int r101, int r102, int r103, LinearLayoutManager r104) {
        if (r101 != r100.f298830o) goto L14;
        View r105 = r104.findViewByPosition(r102);
        if (r105 == null) goto L16;
        int r106 = (r100.f298836u.getPaddingTop() + r103) - r104.getDecoratedTop(r105);
        if (r106 == 0) goto L17;
        int r107 = r100.f298836u.getChildCount();
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L18;
        View r109 = r100.f298836u.getChildAt(r108);
        r109.setTranslationY(r106);
        r109.animate().translationY(0.0f).setDuration(250).setInterpolator(r100.f298834s).start();
        r108 = r108 + 1;
        goto L12
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
