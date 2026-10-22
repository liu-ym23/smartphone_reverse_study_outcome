package ia;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface f extends c, e, h, g {

    public static abstract class a extends j {
        public Integer f(Map<String, ? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            return null;
        }

        public abstract Dialog g(Bundle r100);

        public void h() {
        }

        public void i() {
        }

        public void j(int r100) {
        }

        public void k(float r100) {
        }

        public a() {
        }
    }

    void d(a r100);

    Dialog h(Bundle r100);

    Integer i();

    void m(boolean r100);

    void o(DialogFragment r100);

    void onDismiss(DialogInterface r100);

    void onShow(DialogInterface r100);
}
