package cz9;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.list.expose.ExposureTrackerExtKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {
    public static final void a(View r100, RecyclerView.ViewHolder r101, final Function1 r102, Object r103, final Function3 r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dataOwner");
        Intrinsics.checkNotNullParameter(r102, "dataProvider");
        Intrinsics.checkNotNullParameter(r103, "reportOwner");
        Intrinsics.checkNotNullParameter(r104, "reporter");
        final WeakReference r105 = new WeakReference(r101);
        final WeakReference r106 = new WeakReference(r103);
        ExposureTrackerExtKt.a(r100, new c(r105, r102, r106, r104));
    }
}
