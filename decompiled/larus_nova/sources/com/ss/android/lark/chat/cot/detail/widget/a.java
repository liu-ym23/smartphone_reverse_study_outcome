package com.ss.android.lark.chat.cot.detail.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.cot.detail.CotDetailBlockType;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rkb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f415041a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Integer> f415042b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f415043c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Integer> f415044d = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.detail.widget.a$a, reason: collision with other inner class name */
    public static final class C4853a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f415045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f415046b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4853a) == true) goto L8;
            return false;
        L8:
            C4853a r101 = (C4853a) r100;
            if (this.f415045a == r101.f415045a) goto L12;
            return false;
        L12:
            if (this.f415046b == r101.f415046b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f415045a * 31) + this.f415046b;
        }

        public final String toString() {
            return "StatusStyle(iconRes=" + this.f415045a + ", colorRes=" + this.f415046b + ')';
        }

        public C4853a(int r100) {
            this.f415045a = r100;
            this.f415046b = R.color.icon_n2;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f415047a = null;

        static {
            int[] r100 = new int[CotDetailBlockType.values().length];
            r100[CotDetailBlockType.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[CotDetailBlockType.TOOLCALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[CotDetailBlockType.THINKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[CotDetailBlockType.ACTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[CotDetailBlockType.STATUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f415047a = r100;
        }
    }

    public static final class c implements g<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f415048a;

        @Override // rkb.g
        public final boolean onResourceReady(Object r100, Object r101, Target<Object> r102, DataSource r103, boolean r104) {
            return false;
        }

        public c(ImageView r100) {
            this.f415048a = r100;
        }

        @Override // rkb.g
        public final boolean onLoadFailed(Exception r100, Object r101, Target<Object> r102, boolean r103) {
            this.f415048a.setImageDrawable(null);
            this.f415048a.setVisibility(8);
            return true;
        }
    }

    public a() {
    }

    static {
        f415041a = new a();
        f415042b = new HashMap();
        f415043c = R.drawable.bg_cot_detail_thinking_dot;
        Integer r100 = Integer.valueOf(R.drawable.ud_icon_edit_outlined);
        Integer r101 = Integer.valueOf(R.drawable.ud_icon_video_outlined);
        f415044d = MapsKt.mapOf(new Pair[]{TuplesKt.to("search", Integer.valueOf(R.drawable.ud_icon_search_outlined)), TuplesKt.to("bash", Integer.valueOf(R.drawable.ud_icon_code_outlined)), TuplesKt.to("read", Integer.valueOf(R.drawable.ud_icon_openbook_outlined)), TuplesKt.to("write", r100), TuplesKt.to("edit", r100), TuplesKt.to("doc", Integer.valueOf(R.drawable.ud_icon_doc_outlined)), TuplesKt.to("calendar", Integer.valueOf(R.drawable.ud_icon_calendar_outlined)), TuplesKt.to("task", Integer.valueOf(R.drawable.ud_icon_todo_outlined)), TuplesKt.to("vc_meeting", r101), TuplesKt.to("meeting", r101)});
    }

    public static void a(ImageView r100) {
        ImageLoader.clear(r100);
        r100.setScaleType(ImageView.ScaleType.CENTER);
        ImageViewCompat.setImageTintList(r100, null);
        r100.clearColorFilter();
        r100.setImageResource(f415043c);
    }

    public static void g(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "markerView");
        ImageLoader.clear(r100);
        ImageViewCompat.setImageTintList(r100, null);
        r100.clearColorFilter();
        r100.setImageDrawable(null);
    }

    public static void c(ImageView r100, Object r101) {
        r100.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageViewCompat.setImageTintList(r100, null);
        r100.clearColorFilter();
        ImageLoader.with(r100.getContext()).load(r101).fitCenter().error(f415043c).setErrorScaleType(ImageView.ScaleType.CENTER).into(r100);
    }

    public static void d(ImageView r100, Object r101) {
        r100.setVisibility(0);
        r100.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageViewCompat.setImageTintList(r100, null);
        r100.clearColorFilter();
        ImageLoader.with(r100.getContext()).load(r101).fitCenter().listener(new c(r100)).into(r100);
    }

    public static boolean e(ImageView r100, com.ss.android.lark.chat.cot.c r101) {
        Intrinsics.checkNotNullParameter(r100, "iconView");
        Context r102 = r100.getContext();
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.a) == false) goto L9;
        Integer r103 = f415044d.get(((com.ss.android.lark.chat.cot.c.a) r101).f414793a);
        if (r103 == null) goto L7;
        b(r100, r103.intValue(), true);
    L20:
        return true;
    L7:
        return false;
    L9:
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.f) == false) goto L15;
        Intrinsics.checkNotNull(r102);
        com.ss.android.lark.chat.cot.c.f r104 = (com.ss.android.lark.chat.cot.c.f) r101;
        int r105 = i(r102, r104.f414798a);
        if (r105 != 0) goto L13;
        return false;
    L13:
        b(r100, r105, !StringsKt.endsWith(r104.f414798a, "_colorful", true));
        goto L20
    L15:
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.C4849c) == false) goto L18;
        d(r100, new PassThroughImage(((com.ss.android.lark.chat.cot.c.C4849c) r101).f414795a, null));
        goto L20
    L18:
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.d) == false) goto L22;
        d(r100, ((com.ss.android.lark.chat.cot.c.d) r101).f414796a);
        goto L20
    L22:
        if (Intrinsics.areEqual(r101, com.ss.android.lark.chat.cot.c.b.f414794a) == false) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(r101, com.ss.android.lark.chat.cot.c.e.f414797a) == true) goto L31;
        if (r101 != null) goto L28;
        return false;
    L28:
        throw new NoWhenBranchMatchedException();
    L31:
        return false;
    }

    public static void f(ImageView r100, com.ss.android.lark.chat.cot.c r101) {
        Intrinsics.checkNotNullParameter(r100, "iconView");
        Context r102 = r100.getContext();
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.a) == false) goto L9;
        Integer r103 = f415044d.get(((com.ss.android.lark.chat.cot.c.a) r101).f414793a);
        if (r103 == null) goto L7;
        b(r100, r103.intValue(), true);
        return;
    L7:
        a(r100);
        return;
    L9:
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.f) == false) goto L15;
        Intrinsics.checkNotNull(r102);
        com.ss.android.lark.chat.cot.c.f r104 = (com.ss.android.lark.chat.cot.c.f) r101;
        int r105 = i(r102, r104.f414798a);
        if (r105 == 0) goto L13;
        b(r100, r105, !StringsKt.endsWith(r104.f414798a, "_colorful", true));
        return;
    L13:
        a(r100);
        return;
    L15:
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.C4849c) == false) goto L18;
        c(r100, new PassThroughImage(((com.ss.android.lark.chat.cot.c.C4849c) r101).f414795a, null));
        return;
    L18:
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.d) == false) goto L21;
        c(r100, ((com.ss.android.lark.chat.cot.c.d) r101).f414796a);
        return;
    L21:
        if (Intrinsics.areEqual(r101, com.ss.android.lark.chat.cot.c.b.f414794a) == false) goto L23;
    L28:
        a(r100);
        return;
    L23:
        if (Intrinsics.areEqual(r101, com.ss.android.lark.chat.cot.c.e.f414797a) == true) goto L28;
        if (r101 == null) goto L28;
        throw new NoWhenBranchMatchedException();
    }

    public static boolean h(Context r100, com.ss.android.lark.chat.cot.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.a) == false) goto L6;
        return f415044d.containsKey(((com.ss.android.lark.chat.cot.c.a) r101).f414793a);
    L6:
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.f) == false) goto L11;
        if (i(r100, ((com.ss.android.lark.chat.cot.c.f) r101).f414798a) != 0) goto L24;
    L23:
        return false;
    L24:
        return true;
    L11:
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.C4849c) == true) goto L24;
        if ((r101 instanceof com.ss.android.lark.chat.cot.c.d) == true) goto L24;
        if (Intrinsics.areEqual(r101, com.ss.android.lark.chat.cot.c.b.f414794a) == true) goto L23;
        if (Intrinsics.areEqual(r101, com.ss.android.lark.chat.cot.c.e.f414797a) == true) goto L23;
        if (r101 == null) goto L23;
        throw new NoWhenBranchMatchedException();
    }

    public static int i(Context r110, String r111) {
        String r100 = r110.getPackageName() + ':' + r111;
        HashMap<String, Integer> r101 = f415042b;
        Integer r102 = r101.get(r100);
        if (r102 != null) goto L5;
        int r112 = r110.getResources().getIdentifier("ud_icon_" + StringsKt.replace$default(r111, "-", "_", false, 4, null), "drawable", r110.getPackageName());
        r101.put(r100, Integer.valueOf(r112));
        return r112;
    L5:
        return r102.intValue();
    }

    public static void b(ImageView r100, int r101, boolean r102) {
        ImageLoader.clear(r100);
        r100.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (r102 == false) goto L5;
        ImageViewCompat.setImageTintList(r100, ColorStateList.valueOf(UDColorUtils.getColor(r100.getContext(), R.color.icon_n2)));
    L6:
        r100.setImageResource(r101);
        return;
    L5:
        ImageViewCompat.setImageTintList(r100, null);
        r100.clearColorFilter();
        goto L6
    }
}
