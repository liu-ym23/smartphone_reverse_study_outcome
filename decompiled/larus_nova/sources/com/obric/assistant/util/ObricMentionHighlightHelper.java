package com.obric.assistant.util;

import android.content.Context;
import android.graphics.Point;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricMentionHighlightHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f393597a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/util/ObricMentionHighlightHelper$ObricSelectedMentionForegroundColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "color", "", "skillId", "", "<init>", "(ILjava/lang/String;)V", "getSkillId", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObricSelectedMentionForegroundColorSpan extends ForegroundColorSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393598a;

        public ObricSelectedMentionForegroundColorSpan(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "skillId");
            super(r100);
            this.f393598a = r101;
        }
    }

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f393599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f393600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Boolean> f393601c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<List<paa.e>> f393602d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<String, Unit> f393603e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<String, Unit> f393604f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public a2 f393605g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f393606h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f393607i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f393608j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f393609k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public c f393610l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public View.OnKeyListener f393611m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final LinkedHashSet<String> f393612n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final t1 f393613o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final s1 f393614p;

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public final boolean d() {
            Editable r100 = this.f393599a.getText();
            if (r100 != null) goto L5;
            return false;
        L5:
            int r101 = this.f393599a.getSelectionStart();
            int r102 = this.f393599a.getSelectionEnd();
            if (r101 < 0) goto L81;
            if (r102 < 0) goto L81;
            if (r101 == r102) goto L28;
            c r103 = c(r100, Math.min(r101, r102), Math.max(r101, r102));
            if (r103 == null) goto L90;
            this.f393608j = true;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L24
            Object[] r105 = r100.getSpans(r103.f393618a, r103.f393619b, ObricSelectedMentionForegroundColorSpan.class);     // Catch: Throwable -> L24
            int r106 = r105.length;     // Catch: Throwable -> L24
            int r107 = 0;
        L16:
            if (r107 >= r106) goto L18;
            r100.removeSpan(r105[r107]);     // Catch: Throwable -> L24
            r107 = r107 + 1;     // Catch: Throwable -> L24
            goto L16
        L18:
            r100.delete(r103.f393618a, r103.f393619b);     // Catch: Throwable -> L24
            Iterator<T> r108 = r103.f393622e.iterator();     // Catch: Throwable -> L24
        L20:
            if (r108.hasNext() == false) goto L22;
            m((String) r108.next());     // Catch: Throwable -> L24
            goto L20
        L22:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            this.f393608j = false;
            return true;
        L24:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L26
        L90:
            return false;
        L28:
            Object[] r110 = r100.getSpans(0, r100.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r111 = r110.length;
            int r112 = 0;
        L30:
            if (r112 >= r111) goto L60;
            Object r113 = r110[r112];
            ObricSelectedMentionForegroundColorSpan r114 = (ObricSelectedMentionForegroundColorSpan) r113;
            Intrinsics.checkNotNull(r114);
            int r115 = r100.getSpanStart(r114);
            int r116 = r100.getSpanEnd(r114);
            if (r115 < 0) goto L56;
            if (r116 <= r115) goto L56;
            if (r101 != r116) goto L37;
            boolean r117 = true;
        L39:
            if (r101 != (r116 + 1)) goto L46;
            Character r118 = StringsKt.getOrNull(r100, r116);
            if (r118 == null) goto L46;
            if (r118.charValue() != ' ') goto L46;
            boolean r119 = true;
        L48:
            if ((r115 + 1) > r101) goto L51;
            if (r101 > r116) goto L51;
            boolean r120 = true;
        L52:
            if (r117 == true) goto L55;
            if (r119 == true) goto L55;
            if (r120 == false) goto L56;
        L55:
            boolean r121 = true;
        L57:
            if (r121 == true) goto L61;
            r112 = r112 + 1;
        L61:
            ObricSelectedMentionForegroundColorSpan r122 = (ObricSelectedMentionForegroundColorSpan) r113;
            if (r122 != null) goto L64;
            return false;
        L64:
            int r123 = r100.getSpanStart(r122);
            int r124 = r100.getSpanEnd(r122);
            if (r123 < 0) goto L81;
            if (r124 <= r123) goto L81;
            Character r125 = StringsKt.getOrNull(r100, r124);
            if (r125 != null) goto L72;
        L74:
            this.f393608j = true;
            Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L77
            r100.removeSpan(r122);     // Catch: Throwable -> L77
            r100.delete(r123, RangesKt.coerceAtMost(r124, r100.length()));     // Catch: Throwable -> L77
            m(r122.f393598a);     // Catch: Throwable -> L77
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L77
        L79:
            this.f393608j = false;
            return true;
        L77:
            th = move-exception;
            Result.Companion r127 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L79
        L72:
            if (r125.charValue() != ' ') goto L74;
            r124 = r124 + 1;
        L51:
            r120 = false;
        L46:
            r119 = false;
            goto L48
        L37:
            r117 = false;
        L56:
            r121 = false;
            goto L57
        L60:
            r113 = null;
        L81:
            return false;
        }

        public final void e() {
            a2 r100 = this.f393605g;
            if (r100 == null) goto L8;
            PopupWindow r101 = r100.f393668d;
            if (r101 == null) goto L7;
            PopupWindowLancet.handleDismissBeforeOrigin(r101);
            r101.dismiss();
        L7:
            r100.f393668d = null;
            r100.f393669e = null;
        L8:
            this.f393605g = null;
        }

        public final void a(Spannable r110) {
            if (this.f393609k == true) goto L82;
            if (r110 == null) goto L84;
            int r100 = Selection.getSelectionStart(r110);
            int r101 = Selection.getSelectionEnd(r110);
            if (r100 < 0) goto L83;
            if (r101 < 0) goto L85;
            e r102 = null;
            if (r100 != r101) goto L40;
            Object[] r103 = r110.getSpans(0, r110.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r104 = r103.length;
            int r105 = 0;
        L13:
            if (r105 >= r104) goto L22;
            Object r106 = r103[r105];
            ObricSelectedMentionForegroundColorSpan r107 = (ObricSelectedMentionForegroundColorSpan) r106;
            int r108 = r110.getSpanStart(r107);
            int r109 = r110.getSpanEnd(r107);
            if (r100 <= r108) goto L18;
            if (r100 >= r109) goto L18;
            boolean r111 = true;
        L19:
            if (r111 == true) goto L23;
            r105 = r105 + 1;
        L23:
            ObricSelectedMentionForegroundColorSpan r112 = (ObricSelectedMentionForegroundColorSpan) r106;
            if (r112 == null) goto L62;
            int r113 = r110.getSpanStart(r112);
            int r114 = r110.getSpanEnd(r112);
            if (r113 < 0) goto L62;
            if (r114 <= r113) goto L62;
            if ((r100 - r113) <= (r114 - r100)) goto L34;
            r113 = r114;
        L34:
            e r115 = new e(r113, r113);
            if (r113 == r100) goto L37;
            boolean r116 = true;
        L38:
            if (r116 == false) goto L62;
            r102 = r115;
            goto L62
        L37:
            r116 = false;
        L62:
            if (r102 != null) goto L64;
            return;
        L64:
            this.f393609k = true;
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L67
            Selection.setSelection(r110, r102.f393625a, r102.f393626b);     // Catch: Throwable -> L67
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L67
        L69:
            this.f393609k = false;
            return;
        L67:
            th = move-exception;
            Result.Companion r118 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L18:
            r111 = false;
            goto L19
        L22:
            r106 = null;
            goto L23
        L40:
            if (r100 <= r101) goto L42;
            boolean r119 = true;
        L43:
            int r120 = Math.min(r100, r101);
            int r121 = Math.max(r100, r101);
            Object[] r122 = r110.getSpans(0, r110.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r123 = r122.length;
            int r124 = 0;
            boolean r125 = false;
        L44:
            if (r124 >= r123) goto L56;
            ObricSelectedMentionForegroundColorSpan r126 = (ObricSelectedMentionForegroundColorSpan) r122[r124];
            int r127 = r110.getSpanStart(r126);
            int r128 = r110.getSpanEnd(r126);
            if (r127 < 0) goto L55;
            if (r128 <= r127) goto L55;
            if (r120 >= r128) goto L55;
            if (r121 <= r127) goto L55;
            if (r120 <= r127) goto L53;
            r120 = r127;
            r125 = true;
        L53:
            if (r121 >= r128) goto L55;
            r121 = r128;
            r125 = true;
        L55:
            r124 = r124 + 1;
            goto L44
        L56:
            if (r125 == false) goto L62;
            if (r119 == false) goto L60;
            e r129 = new e(r121, r120);
        L61:
            r102 = r129;
            goto L62
        L60:
            r129 = new e(r120, r121);
            goto L61
        L42:
            r119 = false;
            goto L43
        L85:
            return;
        L83:
            return;
        L84:
            return;
        }

        /* JADX WARN: Type inference failed for: r6v11, types: [com.obric.assistant.util.q1] */
        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r110) {
            if (this.f393607i == false) goto L5;
            return;
        L5:
            if (this.f393608j == true) goto L135;
            if (r110 == null) goto L139;
            g(r110);
            c r100 = this.f393610l;
            if (r100 == null) goto L15;
            this.f393610l = null;
            int r101 = RangesKt.coerceAtLeast(r100.f393621d - r100.f393620c, 0);
            int r102 = RangesKt.coerceIn(r100.f393618a, 0, r110.length());
            int r103 = RangesKt.coerceIn(r100.f393619b - r101, r102, r110.length());
            if (r102 == r103) goto L14;
        L16:
            this.f393608j = true;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L26
            Object[] r105 = r110.getSpans(r102, r103, ObricSelectedMentionForegroundColorSpan.class);     // Catch: Throwable -> L26
            int r106 = r105.length;     // Catch: Throwable -> L26
            int r107 = 0;
        L18:
            if (r107 >= r106) goto L20;
            r110.removeSpan(r105[r107]);     // Catch: Throwable -> L26
            r107 = r107 + 1;     // Catch: Throwable -> L26
            goto L18
        L20:
            r110.delete(r102, r103);     // Catch: Throwable -> L26
            Iterator<T> r108 = r100.f393622e.iterator();     // Catch: Throwable -> L26
        L22:
            if (r108.hasNext() == false) goto L24;
            m((String) r108.next());     // Catch: Throwable -> L26
            goto L22
        L24:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
        L28:
            this.f393608j = false;
            boolean r109 = true;
        L29:
            if (r109 == false) goto L31;
            return;
        L31:
            o(r110);
            a(r110);
            if (this.f393601c.invoke().booleanValue() == true) goto L35;
            this.f393606h = null;
            e();
            return;
        L35:
            int r111 = this.f393599a.getSelectionStart();
            if (r111 >= 0) goto L39;
            this.f393606h = null;
            e();
            return;
        L39:
            Integer r112 = h(r110, r111);
            if (r112 != null) goto L43;
            this.f393606h = null;
            e();
            return;
        L43:
            this.f393606h = r112;
            String r113 = r110.subSequence(r112.intValue() + 1, r111).toString();
            if (this.f393602d.invoke().isEmpty() == false) goto L46;
            e();
            return;
        L46:
            Object r114 = this.f393599a.getParent();
            if ((r114 instanceof View) == false) goto L49;
            View r115 = (View) r114;
        L50:
            if (r115 != null) goto L52;
            r115 = this.f393599a;
        L52:
            final a2 r116 = this.f393605g;
            if (r116 != null) goto L55;
            r116 = new a2(r115, this.f393602d, new q1(this));
            this.f393605g = r116;
        L55:
            Intrinsics.checkNotNullParameter(r113, "searchText");
            List<paa.e> r117 = r116.f393666b.invoke();
            if (r113.length() != 0) goto L58;
            boolean r118 = true;
        L59:
            if (r118 == false) goto L64;
            List<paa.e> r119 = r117;
            ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
            Iterator<T> r121 = r119.iterator();
        L62:
            if (r121.hasNext() == false) goto L88;
            paa.e r122 = (paa.e) r121.next();
            r120.add(new a2.c(r122, CollectionsKt.toSet(StringsKt.getIndices(r122.f528397b))));
        L88:
            if (r120.isEmpty() == false) goto L93;
            PopupWindow r123 = r116.f393668d;
            if (r123 == null) goto L92;
            PopupWindowLancet.handleDismissBeforeOrigin(r123);
            r123.dismiss();
        L92:
            r116.f393668d = null;
            r116.f393669e = null;
            return;
        L93:
            final PopupWindow r124 = r116.f393668d;
            if (r124 != null) goto L96;
        L104:
            Context r125 = r116.f393665a.getContext();
            LayoutInflater r126 = LayoutInflater.from(r125);
            View r127 = r116.f393665a.getRootView();
            if ((r127 instanceof ViewGroup) == false) goto L107;
            ViewGroup r128 = (ViewGroup) r127;
        L108:
            View r129 = r126.inflate(R.layout.obric_layout_mention_popup, r128, false);
            ShadowLayout r130 = (ShadowLayout) r129.findViewById(R.id.obric_mention_shadow_layout);
            if (r130 == null) goto L111;
            r130.setShadowSize(i5.h());
            r130.setShadowColor(ContextCompat.getColor(r125, R.color.obric_secondary_menu_popup_window_shadow_color));
            r130.setShadowOffset(new Point(0, i5.j0()));
            r130.setShadowRadius(i5.h());
        L111:
            final RecyclerView r131 = (RecyclerView) r129.findViewById(R.id.obric_mention_recycler_view);
            if (r131 == null) goto L114;
            r131.setItemAnimator(null);
            r131.setLayoutManager(new LinearLayoutManager(r125, 1, false));
            a2.b r132 = new a2.b(r120, ContextCompat.getColor(r125, R.color.obric_mention_item_text_color), r116.f393667c);
            r116.f393669e = r132;
            r131.setAdapter(r132);
            r131.addOnScrollListener(new ObricMentionPopupWindow$createContentView$1$2$2(r116));
            r131.post(new z1(r116, r131));
        L114:
            int r133 = com.larus.utils.m0.f375450a;
            PopupWindow r134 = new PopupWindow(r129, com.larus.utils.m0.b(r129.getContext()), -2, false);
            r134.setAnimationStyle(0);
            r134.setOutsideTouchable(false);
            int r135 = com.larus.utils.m0.b(r134.getContentView().getContext());
            ShadowLayout r136 = (ShadowLayout) r134.getContentView().findViewById(R.id.obric_mention_shadow_layout);
            int r137 = r134.getContentView().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_312, r134.getContentView().getContext(), R.dimen.larus_dp_312)) + (r136.getPaddingTop() + r136.getPaddingBottom());
            int r138 = ((-r116.f393665a.getHeight()) - r137) + com.obric.assistant.common.utils.f.a(11);
            r134.setWidth(r135);
            r134.setHeight(r137);
            View r139 = r116.f393665a;
            OverlaySource r140 = PopupWindowLancet.resolveSource(r139);
            if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r134, r139, r140) == true) goto L118;
            r134.showAsDropDown(r139, 0, r138);
            PopupWindowLancet.trackAfterShow(r134, r140, r139);
        L118:
            r116.f393668d = r134;
            return;
        L107:
            r128 = null;
            goto L108
        L96:
            if (r124.isShowing() == true) goto L99;
            r124 = null;
        L99:
            if (r124 == null) goto L104;
            a2.b r141 = r116.f393669e;
            if (r141 == null) goto L103;
            Intrinsics.checkNotNullParameter(r120, "newData");
            r141.f393672c.clear();
            r141.f393672c.addAll(r120);
            r141.notifyDataSetChanged();
        L103:
            r124.getContentView().post(new x1(r124, r116));
            return;
        L64:
            ArrayList r142 = new ArrayList();
            Iterator<T> r143 = r117.iterator();
        L66:
            if (r143.hasNext() == false) goto L86;
            paa.e r144 = (paa.e) r143.next();
            String r145 = r144.f528397b;
            ArrayList r146 = new ArrayList();
            int r147 = 0;
            int r148 = 0;
        L69:
            if (r147 >= r113.length()) goto L81;
            char r149 = r113.charAt(r147);
        L72:
            if (r148 >= r145.length()) goto L77;
            if (CharsKt.equals(r145.charAt(r148), r149, true) == true) goto L75;
            r148 = r148 + 1;
            goto L72
        L75:
            r146.add(Integer.valueOf(r148));
            r148 = r148 + 1;
            boolean r150 = true;
        L78:
            if (r150 == false) goto L79;
            r147 = r147 + 1;
            goto L69
        L79:
            r146 = null;
            goto L81
        L77:
            r150 = false;
        L81:
            if (r146 == null) goto L83;
            a2.c r151 = new a2.c(r144, CollectionsKt.toSet(r146));
        L84:
            if (r151 == null) goto L66;
            r142.add(r151);
            goto L66
        L83:
            r151 = null;
            goto L84
        L86:
            r120 = r142;
            goto L88
        L58:
            r118 = false;
            goto L59
        L49:
            r115 = null;
        L26:
            th = move-exception;
            Result.Companion r152 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L28
        L14:
            if (r100.f393622e.isEmpty() == false) goto L16;
        L15:
            r109 = false;
            goto L29
        L139:
            return;
        }

        public final boolean f(paa.e r110) {
            Editable r100 = this.f393599a.getText();
            if (r100 != null) goto L5;
            return false;
        L5:
            String r101 = "@" + r110.f528397b;
            int r102 = 0;
        L7:
            if (r102 >= r100.length()) goto L24;
            int r103 = StringsKt.indexOf$default(r100, r101, r102, false, 4, null);
            if (r103 < 0) goto L10;
            r102 = r103 + r101.length();
            Object[] r104 = r100.getSpans(r103, r102, ObricSelectedMentionForegroundColorSpan.class);
            int r105 = r104.length;
            int r106 = 0;
        L13:
            if (r106 >= r105) goto L18;
            if ((!Intrinsics.areEqual(((ObricSelectedMentionForegroundColorSpan) r104[r106]).f393598a, r110.f528396a)) == true) goto L16;
            r106 = r106 + 1;
            goto L13
        L16:
            boolean r107 = true;
        L20:
            if (ObricMentionHighlightHelper.b(r100, r103, r102) == false) goto L7;
            if (r107 == true) goto L7;
            b(r100, r103, r102, r110);
            return true;
        L18:
            r107 = false;
            goto L20
        L10:
            return false;
        L24:
            return false;
        }

        public final void g(Editable r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            int r101 = r100.getSpanStart(this.f393613o);
            int r102 = r100.getSpanEnd(this.f393613o);
            if (r101 == 0) goto L7;
        L8:
            r100.setSpan(this.f393613o, 0, r100.length(), 18);
            return;
        L7:
            if (r102 != r100.length()) goto L8;
        }

        public final boolean i(String r100) {
            Editable r101 = this.f393599a.getText();
            if (r101 != null) goto L5;
            return false;
        L5:
            Object[] r102 = r101.getSpans(0, r101.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r103 = r102.length;
            int r104 = 0;
        L6:
            if (r104 >= r103) goto L14;
            if (Intrinsics.areEqual(((ObricSelectedMentionForegroundColorSpan) r102[r104]).f393598a, r100) == true) goto L9;
            r104 = r104 + 1;
            goto L6
        L9:
            return true;
        L14:
            return false;
        }

        public final void l(final paa.e r100) {
            Intrinsics.checkNotNullParameter(r100, "obricSkillItem");
            if (i(r100.f528396a) == false) goto L5;
        L11:
            o(this.f393599a.getText());
            return;
        L5:
            if (f(r100) == true) goto L11;
            k(r100, true);
            this.f393599a.post(new p1(this, r100));
            if (i(r100.f528396a) == true) goto L13;
            f(r100);
            return;
        }

        public final void m(String r100) {
            if (this.f393612n.remove(r100) == false) goto L6;
            this.f393604f.invoke(r100);
            return;
        }

        public final boolean n(paa.e r100) {
            Intrinsics.checkNotNullParameter(r100, "obricSkillItem");
            Editable r101 = this.f393599a.getText();
            if (r101 != null) goto L5;
            return false;
        L5:
            Object[] r102 = r101.getSpans(0, r101.length(), ObricSelectedMentionForegroundColorSpan.class);
            int r103 = r102.length;
            int r104 = 0;
        L6:
            if (r104 >= r103) goto L11;
            Object r105 = r102[r104];
            if (Intrinsics.areEqual(((ObricSelectedMentionForegroundColorSpan) r105).f393598a, r100.f528396a) == true) goto L12;
            r104 = r104 + 1;
        L12:
            ObricSelectedMentionForegroundColorSpan r106 = (ObricSelectedMentionForegroundColorSpan) r105;
            if (r106 != null) goto L15;
            return false;
        L15:
            int r107 = r101.getSpanStart(r106);
            int r108 = r101.getSpanEnd(r106);
            if (r107 < 0) goto L27;
            if (r108 <= r107) goto L27;
            Character r109 = StringsKt.getOrNull(r101, r108);
            if (r109 != null) goto L23;
        L25:
            r101.removeSpan(r106);
            r101.delete(r107, RangesKt.coerceAtMost(r108, r101.length()));
            m(r100.f528396a);
            return true;
        L23:
            if (r109.charValue() != ' ') goto L25;
            r108 = r108 + 1;
        L27:
            return false;
        L11:
            r105 = null;
            goto L12
        }

        public final void o(Editable r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            int r101 = 0;
            Object[] r102 = r100.getSpans(0, r100.length(), ObricSelectedMentionForegroundColorSpan.class);
            ArrayList r103 = new ArrayList(r102.length);
            int r104 = r102.length;
        L5:
            if (r101 >= r104) goto L7;
            r103.add(((ObricSelectedMentionForegroundColorSpan) r102[r101]).f393598a);
            r101 = r101 + 1;
            goto L5
        L7:
            Set r105 = CollectionsKt.toSet(r103);
            Iterator r106 = SetsKt.minus(this.f393612n, r105).iterator();
        L9:
            if (r106.hasNext() == false) goto L11;
            m((String) r106.next());
            goto L9
        L11:
            Iterator r107 = SetsKt.minus(r105, this.f393612n).iterator();
        L13:
            if (r107.hasNext() == false) goto L17;
            String r108 = (String) r107.next();
            if (this.f393612n.add(r108) == false) goto L13;
            this.f393603e.invoke(r108);
            goto L13
        }

        public final boolean p(String r100) {
            Intrinsics.checkNotNullParameter(r100, "skillId");
            Editable r101 = this.f393599a.getText();
            if (r101 != null) goto L5;
            return false;
        L5:
            Object[] r102 = r101.getSpans(0, r101.length(), ObricSelectedMentionForegroundColorSpan.class);
            ArrayList r103 = new ArrayList();
            int r104 = r102.length;
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L12;
            Object r106 = r102[r105];
            if (Intrinsics.areEqual(((ObricSelectedMentionForegroundColorSpan) r106).f393598a, r100) == false) goto L10;
            r103.add(r106);
        L10:
            r105 = r105 + 1;
            goto L6
        L12:
            if (r103.isEmpty() == false) goto L14;
            return false;
        L14:
            Iterator r107 = r103.iterator();
        L16:
            if (r107.hasNext() == false) goto L18;
            r101.removeSpan(r107.next());
            goto L16
        L18:
            m(r100);
            this.f393599a.invalidate();
            return true;
        }

        public static Integer h(Editable r100, int r101) {
            if (r101 > 0) goto L5;
        L28:
            return null;
        L5:
            if (r101 > r100.length()) goto L28;
            boolean r102 = true;
            int r103 = r101 - 1;
        L8:
            if (r103 < 0) goto L28;
            if (CharsKt.isWhitespace(r100.charAt(r103)) == true) goto L28;
            if (r100.charAt(r103) == '@') goto L13;
            r103 = r103 - 1;
            goto L8
        L13:
            Integer r104 = Integer.valueOf(r103);
            int r105 = r104.intValue();
            if (r105 == 0) goto L24;
            Character r106 = StringsKt.getOrNull(r100, r105 - 1);
            if (r106 != null) goto L18;
        L20:
            boolean r107 = false;
        L21:
            if (r107 == true) goto L24;
            r102 = false;
            goto L24
        L18:
            if (CharsKt.isWhitespace(r106.charValue()) != true) goto L20;
            r107 = true;
        L24:
            if (r102 == true) goto L26;
            return null;
        L26:
            return r104;
        }

        public final void k(paa.e r100, boolean r110) {
            if (r110 == false) goto L5;
        L8:
            Editable r101 = this.f393599a.getText();
            if (r101 != null) goto L11;
            return;
        L11:
            int r102 = RangesKt.coerceIn(this.f393599a.getSelectionStart(), 0, r101.length());
            if (r110 == false) goto L14;
            int r103 = RangesKt.coerceAtMost(RangesKt.coerceIn(this.f393599a.getSelectionStart(), 0, r101.length()), RangesKt.coerceIn(this.f393599a.getSelectionEnd(), 0, r101.length()));
        L20:
            if (r110 == false) goto L22;
            r102 = RangesKt.coerceAtLeast(RangesKt.coerceIn(this.f393599a.getSelectionStart(), 0, r101.length()), RangesKt.coerceIn(this.f393599a.getSelectionEnd(), 0, r101.length()));
        L22:
            String r111 = "@" + r100.f528397b;
            this.f393607i = true;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L46
            e();     // Catch: Throwable -> L46
            if (r103 > 0) goto L27;
        L35:
            r101.replace(r103, r102, r111);     // Catch: Throwable -> L46
            b(r101, r103, r111.length() + r103, r100);     // Catch: Throwable -> L46
            int r105 = r103 + r111.length();     // Catch: Throwable -> L46
            Character r112 = StringsKt.getOrNull(r101, r105);     // Catch: Throwable -> L46
            if (r112 != null) goto L39;
        L40:
            r101.insert(r105, " ");     // Catch: Throwable -> L46
        L41:
            this.f393599a.setSelection(RangesKt.coerceAtMost(r105 + 1, r101.length()));     // Catch: Throwable -> L46
            this.f393606h = null;     // Catch: Throwable -> L46
            String r106 = r100.f528396a;     // Catch: Throwable -> L46
            if (this.f393612n.add(r106) == false) goto L44;
            this.f393603e.invoke(r106);     // Catch: Throwable -> L46
        L44:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
        L48:
            this.f393607i = false;
            return;
        L39:
            if (r112.charValue() == ' ') goto L41;
        L27:
            Character r107 = StringsKt.getOrNull(r101, r103 - 1);     // Catch: Throwable -> L46
            if (r107 != null) goto L30;
        L32:
            boolean r108 = false;
        L33:
            if (r108 == true) goto L35;
            r101.insert(r103, " ");     // Catch: Throwable -> L46
            r103 = r103 + 1;     // Catch: Throwable -> L46
            r102 = r102 + 1;     // Catch: Throwable -> L46
            goto L35
        L30:
            if (CharsKt.isWhitespace(r107.charValue()) != true) goto L32;
            r108 = true;
        L46:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L48
        L14:
            Integer r109 = this.f393606h;
            if (r109 != null) goto L19;
            r109 = h(r101, r102);
            if (r109 != null) goto L19;
            return;
        L19:
            r103 = r109.intValue();
            goto L20
        L5:
            if (this.f393601c.invoke().booleanValue() == true) goto L8;
            this.f393606h = null;
            e();
        }

        public static c c(Spannable r110, int r111, int r112) {
            Object[] r100 = r110.getSpans(0, r110.length(), ObricSelectedMentionForegroundColorSpan.class);
            ArrayList r101 = new ArrayList();
            int r102 = r100.length;
            int r103 = 0;
        L4:
            if (r103 >= r102) goto L32;
            Object r104 = r100[r103];
            Object r105 = (ObricSelectedMentionForegroundColorSpan) r104;
            int r106 = r110.getSpanStart(r105);
            int r107 = r110.getSpanEnd(r105);
            if (r106 < 0) goto L27;
            if (r107 <= r106) goto L27;
            boolean r108 = true;
            if (r111 >= r107) goto L13;
            if (r112 <= r106) goto L13;
            boolean r109 = true;
        L14:
            if (r111 == r107) goto L16;
        L23:
            boolean r113 = false;
        L24:
            if (r109 == true) goto L28;
            if (r113 == false) goto L27;
        L28:
            if (r108 == false) goto L30;
            r101.add(r104);
        L30:
            r103 = r103 + 1;
            goto L4
        L16:
            if (r112 != (r107 + 1)) goto L23;
            Character r114 = StringsKt.getOrNull(r110, r107);
            if (r114 == null) goto L23;
            if (r114.charValue() != ' ') goto L23;
            r113 = true;
        L13:
            r109 = false;
        L27:
            r108 = false;
            goto L28
        L32:
            if (r101.isEmpty() == false) goto L35;
            return null;
        L35:
            LinkedHashSet r115 = new LinkedHashSet();
            Iterator r116 = r101.iterator();
            int r117 = r111;
            int r118 = r112;
        L37:
            if (r116.hasNext() == false) goto L46;
            ObricSelectedMentionForegroundColorSpan r119 = (ObricSelectedMentionForegroundColorSpan) r116.next();
            int r120 = r110.getSpanStart(r119);
            int r121 = r110.getSpanEnd(r119);
            r117 = Math.min(r117, r120);
            r118 = Math.max(r118, r121);
            Character r122 = StringsKt.getOrNull(r110, r121);
            if (r122 == null) goto L44;
            if (r122.charValue() != ' ') goto L44;
            r118 = Math.max(r118, r121 + 1);
        L44:
            r115.add(r119.f393598a);
            goto L37
        L46:
            return new c(RangesKt.coerceAtLeast(r117, 0), RangesKt.coerceAtMost(r118, r110.length()), RangesKt.coerceAtLeast(r111, 0), RangesKt.coerceAtMost(r112, r110.length()), CollectionsKt.toList(r115));
        }

        public final void b(Editable r100, int r101, int r102, paa.e r103) {
            Object[] r104 = r100.getSpans(r101, r102, ObricSelectedMentionForegroundColorSpan.class);
            int r105 = r104.length;
            int r106 = 0;
        L3:
            if (r106 >= r105) goto L5;
            r100.removeSpan((ObricSelectedMentionForegroundColorSpan) r104[r106]);
            r106 = r106 + 1;
            goto L3
        L5:
            r100.setSpan(new ObricSelectedMentionForegroundColorSpan(this.f393600b, r103.f528396a), r101, r102, 33);
            this.f393599a.invalidate();
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (this.f393607i == false) goto L5;
            return;
        L5:
            if (this.f393608j == true) goto L13;
            if (r102 > r103) goto L8;
            return;
        L8:
            if ((r100 instanceof Spannable) == false) goto L15;
            this.f393610l = c((Spannable) r100, r101, r102 + r101);
            return;
        L15:
            return;
        }

        public a(EditText r100, int r101, Function0 r102, com.obric.assistant.chat.component.bottom.core.mention.b r103, Function1 r104, Function1 r105) {
            Intrinsics.checkNotNullParameter(r100, "editText");
            Intrinsics.checkNotNullParameter(r102, "isEnabled");
            Intrinsics.checkNotNullParameter(r103, "mentionItemsProvider");
            Intrinsics.checkNotNullParameter(r104, "onSelected");
            Intrinsics.checkNotNullParameter(r105, "onUnselected");
            this.f393599a = r100;
            this.f393600b = r101;
            this.f393601c = r102;
            this.f393602d = r103;
            this.f393603e = r104;
            this.f393604f = r105;
            this.f393612n = new LinkedHashSet();
            this.f393613o = new t1(this);
            this.f393614p = new s1(this);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f393615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f393616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final paa.e f393617c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f393615a == r101.f393615a) goto L12;
            return false;
        L12:
            if (this.f393616b == r101.f393616b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393617c, r101.f393617c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f393615a * 31) + this.f393616b) * 31) + this.f393617c.hashCode();
        }

        public final String toString() {
            return "MentionRange(start=" + this.f393615a + ", end=" + this.f393616b + ", item=" + this.f393617c + ')';
        }

        public b(int r100, int r101, paa.e r102) {
            Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
            this.f393615a = r100;
            this.f393616b = r101;
            this.f393617c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f393618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f393619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f393620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f393621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<String> f393622e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f393618a == r101.f393618a) goto L12;
            return false;
        L12:
            if (this.f393619b == r101.f393619b) goto L15;
            return false;
        L15:
            if (this.f393620c == r101.f393620c) goto L18;
            return false;
        L18:
            if (this.f393621d == r101.f393621d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f393622e, r101.f393622e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f393618a * 31) + this.f393619b) * 31) + this.f393620c) * 31) + this.f393621d) * 31) + this.f393622e.hashCode();
        }

        public final String toString() {
            return "PendingAtomicDelete(start=" + this.f393618a + ", end=" + this.f393619b + ", originalDeleteStart=" + this.f393620c + ", originalDeleteEnd=" + this.f393621d + ", skillIds=" + this.f393622e + ')';
        }

        public c(int r100, int r101, int r102, int r103, List<String> r104) {
            Intrinsics.checkNotNullParameter(r104, "skillIds");
            this.f393618a = r100;
            this.f393619b = r101;
            this.f393620c = r102;
            this.f393621d = r103;
            this.f393622e = r104;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f393623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f393624b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f393623a, r101.f393623a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393624b, r101.f393624b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393623a.hashCode() * 31) + this.f393624b.hashCode();
        }

        public final String toString() {
            return "RestoreDraftContent(content=" + this.f393623a + ", mentionedSkillIds=" + this.f393624b + ')';
        }

        public d(CharSequence r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "content");
            Intrinsics.checkNotNullParameter(r101, "mentionedSkillIds");
            this.f393623a = r100;
            this.f393624b = r101;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f393625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f393626b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (this.f393625a == r101.f393625a) goto L12;
            return false;
        L12:
            if (this.f393626b == r101.f393626b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393625a * 31) + this.f393626b;
        }

        public final String toString() {
            return "SelectionRange(start=" + this.f393625a + ", end=" + this.f393626b + ')';
        }

        public e(int r100, int r101) {
            this.f393625a = r100;
            this.f393626b = r101;
        }
    }

    static {
    }

    public static d a(String r110, int r111, List r112) {
        Intrinsics.checkNotNullParameter(r110, "text");
        Intrinsics.checkNotNullParameter(r112, "mentionItems");
        boolean r100 = false;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
    L55:
        List r113 = CollectionsKt.emptyList();
    L57:
        if (r110.length() != 0) goto L59;
        boolean r102 = true;
    L61:
        if (r102 == false) goto L63;
    L81:
        SpannableStringBuilder r103 = null;
    L82:
        if (r103 != null) goto L84;
        return null;
    L84:
        List r114 = r113;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r116 = r114.iterator();
    L86:
        if (r116.hasNext() == false) goto L89;
        r115.add(((b) r116.next()).f393617c.f528396a);
        goto L86
    L89:
        return new d(r103, CollectionsKt.distinct(r115));
    L63:
        if (r113.isEmpty() == true) goto L81;
        r103 = new SpannableStringBuilder(r110);
        Iterator r104 = r113.iterator();
    L67:
        if (r104.hasNext() == false) goto L69;
        b r105 = (b) r104.next();
        r103.setSpan(new ObricSelectedMentionForegroundColorSpan(r111, r105.f393617c.f528396a), r105.f393615a, r105.f393616b, 33);
        goto L67
    L69:
        b r117 = (b) CollectionsKt.lastOrNull(r113);
        if (r117 != null) goto L72;
    L74:
        if (r100 == false) goto L82;
        Character r118 = StringsKt.lastOrNull(r103);
        if (r118 != null) goto L79;
    L80:
        r103.append(' ');
        goto L82
    L79:
        if (r118.charValue() == ' ') goto L82;
    L72:
        if (r117.f393616b != r110.length()) goto L74;
        r100 = true;
        goto L74
    L59:
        r102 = false;
        goto L61
    L8:
        if (((ArrayList) r112).isEmpty() == true) goto L55;
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        Iterator r119 = r112.iterator();
    L12:
        if (r119.hasNext() == false) goto L16;
        Object r108 = r119.next();
        if ((!StringsKt.isBlank(((paa.e) r108).f528397b)) == false) goto L12;
        r107.add(r108);
        goto L12
    L16:
        HashSet r120 = new HashSet();
        ArrayList r109 = new ArrayList();
        Iterator r121 = r107.iterator();
    L18:
        if (r121.hasNext() == false) goto L22;
        Object r122 = r121.next();
        if (r120.add(((paa.e) r122).f528396a) == false) goto L18;
        r109.add(r122);
        goto L18
    L22:
        Iterator r123 = r109.iterator();
    L24:
        if (r123.hasNext() == false) goto L34;
        paa.e r124 = (paa.e) r123.next();
        String r125 = "@" + r124.f528397b;
        int r126 = 0;
    L27:
        if (r126 >= r110.length()) goto L24;
        int r127 = StringsKt.indexOf$default(r110, r125, r126, false, 4, null);
        if (r127 < 0) goto L24;
        r126 = r127 + r125.length();
        if (b(r110, r127, r126) == false) goto L27;
        r106.add(new b(r127, r126, r124));
        goto L27
    L34:
        ArrayList r128 = new ArrayList();
        Iterator r129 = CollectionsKt.sortedWith(r106, new w1(new u1())).iterator();
    L36:
        if (r129.hasNext() == false) goto L54;
        b r130 = (b) r129.next();
        if (r128.isEmpty() == true) goto L51;
        Iterator r131 = r128.iterator();
    L42:
        if (r131.hasNext() == false) goto L51;
        b r132 = (b) r131.next();
        if (r130.f393615a < r132.f393616b) goto L46;
    L48:
        boolean r133 = false;
    L49:
        if (r133 == false) goto L42;
        boolean r134 = false;
    L52:
        if (r134 == false) goto L36;
        r128.add(r130);
        goto L36
    L46:
        if (r130.f393616b <= r132.f393615a) goto L48;
        r133 = true;
    L51:
        r134 = true;
        goto L52
    L54:
        r113 = CollectionsKt.sortedWith(r128, new v1());
        goto L57
    L5:
        r101 = false;
        goto L6
    }

    public static boolean b(CharSequence r100, int r101, int r102) {
        if (r101 == 0) goto L13;
        Character r103 = StringsKt.getOrNull(r100, r101 - 1);
        if (r103 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == true) goto L13;
        boolean r105 = false;
    L15:
        if (r102 == r100.length()) goto L25;
        Character r106 = StringsKt.getOrNull(r100, r102);
        if (r106 != null) goto L19;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == true) goto L25;
        boolean r108 = false;
    L26:
        if (r105 == false) goto L30;
        if (r108 == false) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L19:
        if (CharsKt.isWhitespace(r106.charValue()) != true) goto L21;
        r107 = true;
    L25:
        r108 = true;
        goto L26
    L7:
        if (CharsKt.isWhitespace(r103.charValue()) != true) goto L9;
        r104 = true;
    L13:
        r105 = true;
        goto L15
    }
}
