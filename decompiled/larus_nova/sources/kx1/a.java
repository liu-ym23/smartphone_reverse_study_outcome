package kx1;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.feedback.Option;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f506537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Option f506538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f506539c;

    /* JADX INFO: renamed from: kx1.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC6626a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f506540a;

        public ViewOnClickListenerC6626a(a r100) {
            this.f506540a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f506540a;
            if (r101.f506537a == false) goto L5;
            r101.c();
            this.f506540a.getListener().b(this.f506540a);
            return;
        L5:
            r101.b();
            this.f506540a.getListener().a(this.f506540a);
        }
    }

    @Override // kx1.c
    public void b() {
        this.f506537a = true;
    }

    @Override // kx1.c
    public void c() {
        this.f506537a = false;
    }

    public abstract int getLayoutId();

    @Override // kx1.c
    public final String a() {
        return this.f506538b.toastText;
    }

    @Override // kx1.c
    public String getOptionKey() {
        String r100 = this.f506538b.key;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // kx1.c
    public Long getSubQuestionId() {
        return this.f506538b.question;
    }

    public final e getListener() {
        return this.f506539c;
    }

    public final Option getOption() {
        return this.f506538b;
    }

    public a(Context r100, Option r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "option");
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, null, 0);
        this.f506538b = r101;
        this.f506539c = r102;
        setOnClickListener(new ViewOnClickListenerC6626a(this));
    }
}
