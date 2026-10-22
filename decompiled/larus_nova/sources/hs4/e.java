package hs4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f486974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f486975c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f486976a;

        public a(e r100) {
            this.f486976a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rcb.c.h(this.f486976a.f486975c, null);     // Catch: Throwable -> L4
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
        return this.f486975c;
    }

    @Override // hs4.b
    public final View e() {
        return this.f486974b;
    }

    public e(Context r100, com.bytedance.ee.bear.bitable.filter.view.ddui.step.a r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_number_filter_value_view, null);
        this.f486974b = r103;
        EditText r104 = (EditText) r103.findViewById(R.id.input_et);
        this.f486975c = r104;
        if (r102 == false) goto L5;
        r104.setInputType(3);
    L5:
        r104.post(new a(this));
    }
}
