package foc;

import android.content.Context;
import androidx.core.view.GravityCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends UDBaseDialogBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f478197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<goc.b.l> f478198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f478199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f478200d;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        marginInDp(36);
        maxWidth(new UDDimension.Dp(303));
        messageGravity(GravityCompat.START);
        controller(new c(r100));
        this.f478198b = new ArrayList();
        this.f478200d = UDColorUtils.getColor(r100, R.color.text_link_normal);
    }
}
