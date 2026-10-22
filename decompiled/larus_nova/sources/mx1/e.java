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
import kx1.f;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends nx1.a<f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, View> f516176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kx1.c f516177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f516178d;

    public static final class a implements kx1.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f516179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f516180b;

        @Override // kx1.e
        public final void a(kx1.c r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            if ((!Intrinsics.areEqual(r100, this.f516179a.f516177c)) == false) goto L9;
            kx1.c r101 = this.f516179a.f516177c;
            if (r101 == null) goto L7;
            r101.c();
        L7:
            e r102 = this.f516179a;
            r102.f516177c = r100;
            this.f516180b.b(r102);
            return;
        }

        @Override // kx1.e
        public final void b(kx1.a r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            if (Intrinsics.areEqual(this.f516179a.f516177c, r100) == false) goto L6;
            e r101 = this.f516179a;
            r101.f516177c = null;
            this.f516180b.a(r101);
            return;
        }

        public a(e r100, b r101) {
            this.f516179a = r100;
            this.f516180b = r101;
        }
    }

    @Override // nx1.a
    public lx1.b<f> getOptionFactory() {
        return new lx1.c(getContext(), this.f516178d);
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
        kx1.c r103 = this.f516177c;
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
        kx1.c r100 = this.f516177c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // nx1.a, nx1.b
    public Long getSubQuestionId() {
        kx1.c r100 = this.f516177c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSubQuestionId();
    }

    @Override // nx1.b
    public final void reset() {
        kx1.c r100 = this.f516177c;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f516177c = null;
    }

    public final View b(int r100) {
        if (this.f516176b != null) goto L5;
        this.f516176b = new LinkedHashMap();
    L5:
        View r101 = this.f516176b.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f516176b.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public e(Context r100, Question r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, r101);
        this.f516176b = new LinkedHashMap();
        this.f516178d = new a(this, r102);
        View.inflate(r100, R.layout.ttlive_layout_feedback_room_special_single_question, this);
        TextView r103 = (TextView) b(R.id.question_title);
        if (r103 == null) goto L5;
        r103.setText(r101.questionText);
    L5:
        GridLayout r104 = (GridLayout) b(R.id.options_container);
        if (r104 == null) goto L13;
        r104.removeAllViews();
        List<f> r105 = a();
        if (r105 == null) goto L15;
        Iterator<T> r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L16;
        r104.addView((f) r106.next());
        goto L11
    L16:
        return;
    L15:
        return;
    }
}
