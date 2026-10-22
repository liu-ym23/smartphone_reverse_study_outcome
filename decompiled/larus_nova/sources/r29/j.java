package r29;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import zp9.u;
import zp9.w;

/* JADX INFO: loaded from: classes27.dex */
public final class j extends HorizontalScrollView implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f535807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<w> f535808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Unit> f535809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Boolean> f535810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f535811e;

    @Override // zp9.u
    public int getCurrent() {
        return this.f535811e;
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LinearLayout r101 = new LinearLayout(r100);
        r101.setOrientation(0);
        r101.setGravity(16);
        this.f535807a = r101;
        this.f535808b = new ArrayList();
        this.f535811e = -1;
        setHorizontalScrollBarEnabled(false);
        addView(r101, new FrameLayout.LayoutParams(-2, -1));
    }

    @Override // zp9.u
    public final void a(Function2<? super Integer, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        this.f535809c = r100;
    }

    @Override // zp9.u
    public final void c(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
        this.f535810d = r100;
    }

    @Override // zp9.u
    public final void d(List<w> r110) {
        Intrinsics.checkNotNullParameter(r110, "list");
        w r100 = (w) CollectionsKt.getOrNull(this.f535808b, this.f535811e);
        Integer r101 = null;
        if (r100 == null) goto L5;
        Long r102 = Long.valueOf(r100.f573272a);
    L6:
        ((ArrayList) this.f535808b).clear();
        List<w> r103 = this.f535808b;
        ArrayList r104 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L8:
        if (r111.hasNext() == false) goto L12;
        Object r105 = r111.next();
        if (((w) r105).a() == true) goto L8;
        r104.add(r105);
        goto L8
    L12:
        ((ArrayList) r103).addAll(r104);
        this.f535807a.removeAllViews();
        Iterator<T> r112 = this.f535808b.iterator();
        final int r106 = 0;
    L13:
        int r107 = -1;
        if (r112.hasNext() == false) goto L29;
        Object r108 = r112.next();
        int r109 = r106 + 1;
        if (r106 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        final w r113 = (w) r108;
        LinearLayout r114 = this.f535807a;
        TextView r115 = new TextView(getContext());
        String r116 = r113.f573273b;
        if (r116 != null) goto L21;
        r116 = "";
    L21:
        r115.setText(r116);
        r115.setTextSize(16.0f);
        r115.setGravity(17);
        r115.setSingleLine(true);
        r115.setPadding(e(12), 0, e(12), 0);
        r115.setOnClickListener(new i(this, r106, r113));
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-2, -1);
        if (r106 != 0) goto L25;
        r117.setMarginStart(e(4));
    L25:
        if (r106 != CollectionsKt.getLastIndex(this.f535808b)) goto L27;
        r117.setMarginEnd(e(4));
    L27:
        Unit r118 = Unit.INSTANCE;
        r114.addView(r115, r117);
        r106 = r109;
        goto L13
    L29:
        if (((ArrayList) this.f535808b).isEmpty() == false) goto L31;
        int r119 = 8;
    L32:
        setVisibility(r119);
        Iterator r120 = ((ArrayList) this.f535808b).iterator();
        int r121 = 0;
    L34:
        if (r120.hasNext() == false) goto L45;
        long r122 = ((w) r120.next()).f573272a;
        if (r102 != null) goto L39;
    L41:
        boolean r123 = false;
    L42:
        if (r123 == true) goto L43;
        r121 = r121 + 1;
        goto L34
    L43:
        r107 = r121;
        goto L45
    L39:
        if (r122 != r102.longValue()) goto L41;
        r123 = true;
    L45:
        Integer r124 = Integer.valueOf(r107);
        if (r124.intValue() < 0) goto L48;
        boolean r125 = true;
    L49:
        if (r125 == true) goto L52;
        r124 = null;
    L52:
        if (r124 == null) goto L54;
        int r126 = r124.intValue();
    L66:
        if ((!this.f535808b.isEmpty()) == false) goto L79;
        b(r126, false);
        return;
    L79:
        return;
    L54:
        Integer r127 = Integer.valueOf(this.f535811e);
        int r128 = r127.intValue();
        if (r128 >= 0) goto L57;
    L59:
        boolean r129 = false;
    L60:
        if (r129 == false) goto L62;
        r101 = r127;
    L62:
        if (r101 == null) goto L64;
        r126 = r101.intValue();
        goto L66
    L64:
        r126 = 0;
        goto L66
    L57:
        if (r128 >= this.f535808b.size()) goto L59;
        r129 = true;
        goto L60
    L48:
        r125 = false;
        goto L49
    L31:
        r119 = 0;
        goto L32
    L5:
        r102 = null;
        goto L6
    }

    public final int e(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Function0<Boolean> r101 = this.f535810d;
        if (r101 == null) goto L5;
        boolean r102 = r101.invoke().booleanValue();
    L6:
        if (r102 == true) goto L8;
    L10:
        return false;
    L8:
        if (super.onTouchEvent(r100) == false) goto L10;
        return true;
    L5:
        r102 = true;
        goto L6
    }

    @Override // zp9.u
    public void setCurrent(int r100) {
        b(r100, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // zp9.u
    public final void b(final int r110, final boolean r111) {
        if (r110 >= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L10;
        return;
    L10:
        this.f535811e = r110;
        int r101 = this.f535807a.getChildCount();
        int r102 = 0;
    L11:
        if (r102 >= r101) goto L51;
        View r103 = this.f535807a.getChildAt(r102);
        Object r104 = null;
        if ((r103 instanceof TextView) == false) goto L15;
        TextView r105 = (TextView) r103;
    L16:
        if (r105 == 0) goto L50;
        if (r102 != r110) goto L20;
        ?? r106 = 1;
    L21:
        r105.setSelected(r106);
        r105.setTypeface(Typeface.DEFAULT, r106);
        w r107 = (w) ListProtector.get(this.f535808b, r102);
        if (r106 != 0) goto L24;
    L45:
        if (r106 == 0) goto L47;
        int r108 = R.color.larus_neutral_100;
    L48:
        int r109 = ContextCompat.getColor(getContext(), r108);
    L49:
        r105.setTextColor(r109);
        goto L50
    L47:
        r108 = R.color.larus_neutral_70;
        goto L48
    L24:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L26;
        boolean r112 = true;
    L27:
        if (r112 == false) goto L29;
        String r113 = r107.f573277f;
    L55:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L36
        if (r113 == null) goto L33;
        Integer r115 = Integer.valueOf(Color.parseColor(r113));     // Catch: Throwable -> L36
    L34:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L36
    L39:
        if (Result.m9455isFailureimpl(r116) == true) goto L42;
        r104 = r116;
    L42:
        Integer r117 = (Integer) r104;
        if (r117 == null) goto L45;
        r109 = r117.intValue();
        goto L49
    L33:
        r115 = null;
    L36:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L29:
        r113 = r107.f573276e;
        goto L55
    L26:
        r112 = false;
        goto L27
    L20:
        r106 = 0;
    L50:
        r102 = r102 + 1;
        goto L11
    L15:
        r105 = 0;
        goto L16
    L51:
        View r119 = this.f535807a.getChildAt(r110);
        if (r119 == null) goto L60;
        r119.post(new h(this, r110, r111));
        return;
    L60:
        return;
    L5:
        if (r110 >= this.f535808b.size()) goto L7;
        r100 = true;
        goto L8
    }
}
