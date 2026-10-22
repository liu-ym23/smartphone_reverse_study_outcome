package fp5;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends UDBaseDialogBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f478270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f478271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f478272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f478273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f478274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f478275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f478276g;

    /* JADX INFO: renamed from: fp5.a$a, reason: collision with other inner class name */
    public static final class C5939a {
    }

    public interface b {
        void a(View r100, boolean r101);
    }

    static {
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f478271b = "";
        this.f478272c = "";
        this.f478273d = -1;
        this.f478274e = true;
        controller(new fp5.b(r100));
        marginInDp(36);
        maxWidth(new UDDimension.Dp(303));
    }

    public final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f478271b = r100;
    }

    public final void b(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "tips");
        this.f478272c = r100;
    }
}
