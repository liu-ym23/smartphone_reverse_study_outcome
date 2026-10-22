package fp5;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends UDBaseDialogBuilder<a> {
    public boolean a;
    public CharSequence b;
    public CharSequence c;
    public int d;
    public boolean e;
    public b f;
    public boolean g;

    /* JADX INFO: renamed from: fp5.a$a, reason: collision with other inner class name */
    public static final class C0232a {
    }

    public interface b {
        void a(View r1, boolean r2);
    }

    static {
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = "";
        this.c = "";
        this.d = -1;
        this.e = true;
        controller(new fp5.b(r2));
        marginInDp(36);
        maxWidth(new UDDimension.Dp(303));
    }

    public final void a(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.b = r2;
    }

    public final void b(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "tips");
        this.c = r2;
    }
}
