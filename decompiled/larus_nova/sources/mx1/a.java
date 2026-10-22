package mx1;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends nx1.a<kx1.b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, View> f516160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<? extends kx1.c> f516161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kx1.c f516162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C6868a f516163e;

    /* JADX INFO: renamed from: mx1.a$a, reason: collision with other inner class name */
    public static final class C6868a implements kx1.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f516164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f516165b;

        @Override // kx1.e
        public final void b(kx1.a r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
        }

        @Override // kx1.e
        public final void a(kx1.c r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            List<? extends kx1.c> r101 = this.f516164a.f516161c;
            if (r101 == null) goto L27;
            int r102 = r101.indexOf(r100);
            a r103 = this.f516164a;
            r103.f516162d = r100;
            List<? extends kx1.c> r104 = r103.f516161c;
            if (r104 != null) goto L7;
        L22:
            this.f516165b.b(this.f516164a);
            return;
        L7:
            if ((!r104.isEmpty()) == true) goto L10;
            r104 = null;
        L10:
            if (r104 == null) goto L22;
            Iterator<T> r105 = r104.iterator();
            int r106 = 0;
        L13:
            if (r105.hasNext() == false) goto L22;
            Object r107 = r105.next();
            int r108 = r106 + 1;
            if (r106 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            kx1.c r109 = (kx1.c) r107;
            if (r106 > r102) goto L20;
            r109.b();
        L21:
            r106 = r108;
            goto L13
        L20:
            r109.c();
            goto L21
        }

        public C6868a(a r100, b r101) {
            this.f516164a = r100;
            this.f516165b = r101;
        }
    }

    @Override // nx1.a
    public lx1.b<kx1.b> getOptionFactory() {
        return new lx1.a(getContext(), this.f516163e);
    }

    @Override // nx1.a, nx1.b
    public String getSelectResult() {
        StringBuilder r100 = new StringBuilder();
        String r101 = getQuestion().questionKey;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append('-');
        kx1.c r103 = this.f516162d;
        if (r103 == null) goto L11;
        String r104 = r103.getOptionKey();
        if (r104 == null) goto L11;
        r102 = r104;
    L11:
        r100.append(r102);
        return r100.toString();
    }

    @Override // nx1.a, nx1.b
    public String getSelectToast() {
        kx1.c r100 = this.f516162d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // nx1.a, nx1.b
    public Long getSubQuestionId() {
        kx1.c r100 = this.f516162d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSubQuestionId();
    }

    @Override // nx1.b
    public final void reset() {
        List<? extends kx1.c> r100 = this.f516161c;
        if (r100 != null) goto L5;
    L16:
        this.f516162d = null;
        return;
    L5:
        if ((!r100.isEmpty()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L16;
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L11:
        if (r101.hasNext() == false) goto L16;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        ((kx1.c) r103).c();
        r102 = r104;
        goto L11
    }

    public final View b(int r100) {
        if (this.f516160b != null) goto L5;
        this.f516160b = new LinkedHashMap();
    L5:
        View r101 = this.f516160b.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f516160b.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public a(Context r100, Question r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, r101);
        this.f516160b = new LinkedHashMap();
        this.f516163e = new C6868a(this, r102);
        View.inflate(r100, R.layout.ttlive_layout_feedback_global_grade_question, this);
        List<kx1.b> r103 = a();
        this.f516161c = r103;
        TextView r104 = (TextView) b(R.id.question_title);
        if (r104 == null) goto L5;
        r104.setText(r101.questionText);
    L5:
        GridLayout r105 = (GridLayout) b(R.id.options_container);
        if (r105 == null) goto L32;
        r105.removeAllViews();
        if (r103 == null) goto L38;
        Iterator<T> r106 = r103.iterator();
        int r107 = 0;
    L11:
        if (r106.hasNext() == false) goto L39;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        Object r110 = (kx1.c) r108;
        Object r111 = null;
        if (r107 != 0) goto L24;
        GridLayout.LayoutParams r112 = new GridLayout.LayoutParams();
        r112.width = UtilityKotlinExtentionsKt.i(32);
        r112.height = UtilityKotlinExtentionsKt.i(32);
        if ((r110 instanceof View) == false) goto L22;
        r111 = r110;
    L22:
        if (((View) r111) == null) goto L31;
        r105.addView((View) r110, r112);
    L31:
        r107 = r109;
        goto L11
    L24:
        GridLayout.LayoutParams r113 = new GridLayout.LayoutParams();
        r113.width = UtilityKotlinExtentionsKt.i(32);
        r113.height = UtilityKotlinExtentionsKt.i(32);
        r113.leftMargin = UtilityKotlinExtentionsKt.i(24);
        if ((r110 instanceof View) == false) goto L29;
        r111 = r110;
    L29:
        if (((View) r111) == null) goto L31;
        r105.addView((View) r110, r113);
        goto L31
    L39:
        return;
    L38:
        return;
    }
}
