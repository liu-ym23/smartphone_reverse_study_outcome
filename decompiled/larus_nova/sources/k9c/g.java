package k9c;

import com.squareup.wire.Message;
import com.ss.android.lark.pb.ug_reach.MaterialBase;
import java.util.List;
import k9c.d;

/* JADX INFO: loaded from: classes38.dex */
public interface g<DATA extends Message<?, ?>, RP extends d<DATA>> {
    boolean a(String r100);

    List<RP> b();

    MaterialBase c(String r100);

    boolean d(String r100, byte[] r101);

    l9c.a e(String r100);

    void f(String r100);
}
