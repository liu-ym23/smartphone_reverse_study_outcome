package tec;

import android.content.Context;
import android.widget.GridLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.table.newrefactor.TableCellData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f545678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TableCellData> f545679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GridLayout f545680c;

    public abstract void a(Context r100, List<TableCellData> r101);

    public final Context getContext() {
        return this.f545678a;
    }

    public g(Context r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f545678a = r100;
        this.f545679b = r101;
    }
}
