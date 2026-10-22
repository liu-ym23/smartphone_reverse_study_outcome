package mx1;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.Question;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kx1.h;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends nx1.a<h> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, View> f516171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kx1.c f516172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f516173d;

    public static final class a implements kx1.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f516174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f516175b;

        @Override // kx1.e
        public final void a(kx1.c r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            if ((!Intrinsics.areEqual(r100, this.f516174a.f516172c)) == false) goto L9;
            kx1.c r101 = this.f516174a.f516172c;
            if (r101 == null) goto L7;
            r101.c();
        L7:
            d r102 = this.f516174a;
            r102.f516172c = r100;
            this.f516175b.b(r102);
            return;
        }

        @Override // kx1.e
        public final void b(kx1.a r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            if (Intrinsics.areEqual(this.f516174a.f516172c, r100) == false) goto L6;
            d r101 = this.f516174a;
            r101.f516172c = null;
            this.f516175b.a(r101);
            return;
        }

        public a(d r100, b r101) {
            this.f516174a = r100;
            this.f516175b = r101;
        }
    }

    @Override // nx1.a
    public lx1.b<h> getOptionFactory() {
        return new lx1.e(getContext(), this.f516173d);
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
        kx1.c r103 = this.f516172c;
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
        kx1.c r100 = this.f516172c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // nx1.a, nx1.b
    public Long getSubQuestionId() {
        kx1.c r100 = this.f516172c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSubQuestionId();
    }

    @Override // nx1.b
    public final void reset() {
        kx1.c r100 = this.f516172c;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f516172c = null;
    }

    public final View b(int r100) {
        if (this.f516171b != null) goto L5;
        this.f516171b = new LinkedHashMap();
    L5:
        View r101 = this.f516171b.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f516171b.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public d(Context r100, Question r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, r101);
        this.f516171b = new LinkedHashMap();
        this.f516173d = new a(this, r102);
        View.inflate(r100, R.layout.ttlive_layout_feedback_room_single_question, this);
        TextView r103 = (TextView) b(R.id.question_title);
        if (r103 == null) goto L5;
        r103.setText(r101.questionText);
    L5:
        GridLayout r104 = (GridLayout) b(R.id.options_container);
        if (r104 == null) goto L13;
        r104.removeAllViews();
        List<h> r105 = a();
        if (r105 == null) goto L15;
        Iterator<T> r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L16;
        r104.addView((h) r106.next());
        goto L11
    L16:
        return;
    L15:
        return;
    }
}
