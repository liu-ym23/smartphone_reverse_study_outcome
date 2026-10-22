package z7c;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class u extends UDBaseDialogBuilder<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f570841a;

    public interface a {
        void a(String r100);

        void b(String r100);

        void c(String r100);
    }

    public u(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        gravity(80);
    }
}
