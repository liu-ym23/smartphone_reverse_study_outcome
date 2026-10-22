package kx1;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.feedback.Option;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f506541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Option f506542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f506543c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f506544a;

        public a(b r100) {
            this.f506544a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f506544a.getListener().a(this.f506544a);
            this.f506544a.b();
        }
    }

    @Override // kx1.c
    public final String a() {
        return this.f506542b.toastText;
    }

    @Override // kx1.c
    public String getOptionKey() {
        String r100 = this.f506542b.key;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // kx1.c
    public Long getSubQuestionId() {
        return this.f506542b.question;
    }

    @Override // kx1.c
    public final void b() {
        d(R.id.grade_icon).setBackgroundResource(R.drawable.ttlive_ic_feedback_grade_select);
    }

    @Override // kx1.c
    public final void c() {
        d(R.id.grade_icon).setBackgroundResource(R.drawable.ttlive_ic_feedback_grade_unselet_trans);
    }

    public final e getListener() {
        return this.f506543c;
    }

    public final Option getOption() {
        return this.f506542b;
    }

    public final View d(int r100) {
        if (this.f506541a != null) goto L5;
        this.f506541a = new LinkedHashMap();
    L5:
        Map<Integer, View> r101 = this.f506541a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        View r103 = (View) r102.get(Integer.valueOf(R.id.grade_icon));
        if (r103 != null) goto L12;
        View r104 = findViewById(R.id.grade_icon);
        if (r104 == null) goto L10;
        this.f506541a.put(Integer.valueOf(R.id.grade_icon), r104);
        return r104;
    L10:
        return null;
    L12:
        return r103;
    }

    public b(Context r100, Option r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "option");
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, null, 0);
        this.f506542b = r101;
        this.f506543c = r102;
        this.f506541a = new LinkedHashMap();
        View.inflate(r100, R.layout.ttlive_layout_feedback_grade_option, this);
        setOnClickListener(new a(this));
    }
}
