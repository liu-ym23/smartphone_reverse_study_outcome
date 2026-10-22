package hk9;

import android.content.Context;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc8.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f485610a;

    public abstract void a();

    public abstract void b(Class<?> r100, l r101);

    public boolean getLayoutFromBottom() {
        return this.f485610a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public void setLayoutFromBottom(boolean r100) {
        this.f485610a = r100;
    }
}
