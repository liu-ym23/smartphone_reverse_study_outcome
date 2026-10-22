package w9b;

import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.coremd.base.parse.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements z<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f558794a = null;

    static {
        f558794a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final Class<TextView> b() {
        return TextView.class;
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final Layout a(View r100) {
        TextView r101 = (TextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        return r101.getLayout();
    }

    @Override // com.ss.android.lark.coremd.base.parse.z
    public final CharSequence c(View r100) {
        TextView r101 = (TextView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        return r101.getText();
    }
}
