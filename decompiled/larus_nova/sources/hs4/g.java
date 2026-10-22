package hs4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f486985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f486986c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f486987a;

        public a(g r100) {
            this.f486987a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rcb.c.h(this.f486987a.f486986c, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // hs4.b
    public final EditText d() {
        return this.f486986c;
    }

    @Override // hs4.b
    public final View e() {
        return this.f486985b;
    }

    public g(Context r100, com.bytedance.ee.bear.bitable.filter.view.ddui.step.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_text_filter_value_view, null);
        this.f486985b = r102;
        EditText r103 = (EditText) r102.findViewById(R.id.input_et);
        this.f486986c = r103;
        r103.post(new a(this));
    }
}
