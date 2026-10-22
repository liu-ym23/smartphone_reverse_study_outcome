package mx1;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.Question;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kx1.f;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends nx1.a<f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, View> f516166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<kx1.c> f516167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f516168d;

    public static final class a implements kx1.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f516169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f516170b;

        @Override // kx1.e
        public final void a(kx1.c r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            this.f516169a.f516167c.add(r100);
            this.f516170b.b(this.f516169a);
        }

        @Override // kx1.e
        public final void b(kx1.a r100) {
            Intrinsics.checkNotNullParameter(r100, "option");
            this.f516169a.f516167c.remove(r100);
            Set<kx1.c> r101 = this.f516169a.f516167c;
            if (r101.size() != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L9;
            r101 = null;
        L9:
            if (r101 == null) goto L12;
            this.f516170b.a(this.f516169a);
            return;
        L12:
            return;
        L5:
            r102 = false;
            goto L6
        }

        public a(c r100, b r101) {
            this.f516169a = r100;
            this.f516170b = r101;
        }
    }

    @Override // nx1.a, nx1.b
    public Long getSubQuestionId() {
        return null;
    }

    @Override // nx1.a
    public lx1.b<f> getOptionFactory() {
        return new lx1.c(getContext(), this.f516168d);
    }

    @Override // nx1.a, nx1.b
    public String getSelectResult() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f516167c.iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        kx1.c r102 = (kx1.c) r101.next();
        StringBuilder r103 = new StringBuilder();
        String r104 = getQuestion().questionKey;
        String r105 = "";
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r103.append(r104);
        r103.append('-');
        String r106 = r102.getOptionKey();
        if (r106 == null) goto L12;
        r105 = r106;
    L12:
        r103.append(r105);
        r100.add(r103.toString());
        goto L4
    L14:
        return CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null);
    }

    @Override // nx1.a, nx1.b
    public String getSelectToast() {
        Iterator<T> r100 = this.f516167c.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        String r101 = ((kx1.c) r100.next()).a();
        if (r101 == null) goto L4;
        return r101;
    L8:
        return null;
    }

    @Override // nx1.b
    public final void reset() {
        Iterator<T> r100 = this.f516167c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((kx1.c) r100.next()).c();
        goto L4
    L6:
        this.f516167c.clear();
    }

    public final View b(int r100) {
        if (this.f516166b != null) goto L5;
        this.f516166b = new LinkedHashMap();
    L5:
        View r101 = this.f516166b.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f516166b.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public c(Context r100, Question r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, r101);
        this.f516166b = new LinkedHashMap();
        this.f516167c = new LinkedHashSet();
        this.f516168d = new a(this, r102);
        View.inflate(r100, R.layout.ttlive_layout_feedback_room_multiple_question, this);
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
