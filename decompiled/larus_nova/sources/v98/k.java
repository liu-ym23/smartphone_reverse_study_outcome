package v98;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.avlink.gallery.view.w0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f553828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Boolean> f553829b;

    public final View a() {
        View r100 = LayoutInflater.from(this.f553828a).inflate(R.layout.larus_layout_custom_share_panel, null);
        ((LinearLayout) r100.findViewById(R.id.btn_delete)).setOnClickListener(new h(this));
        ((LinearLayout) r100.findViewById(R.id.btn_share)).setOnClickListener(new i(this));
        ((LinearLayout) r100.findViewById(R.id.btn_feedback)).setOnClickListener(new j(this));
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public k(FragmentActivity r100, w0 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onItemClick");
        this.f553828a = r100;
        this.f553829b = r101;
    }
}
