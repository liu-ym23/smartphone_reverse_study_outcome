package ecc;

import android.content.Context;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.columns.entity.ColumnsCellData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f472166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ColumnsCellData> f472167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f472168c;

    public abstract void a(Context r100, List<ColumnsCellData> r101);

    public final Context getContext() {
        return this.f472166a;
    }

    public a(Context r100, List<ColumnsCellData> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f472166a = r100;
        this.f472167b = r101;
    }
}
