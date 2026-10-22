package va8;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageContentType;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public interface p extends m1a.a {
    RecyclerView Ly();

    Fragment M();

    void O5(boolean r100);

    void Py(q0 r100);

    boolean Q80(String r100);

    boolean S3(String r100, @MessageContentType int r101);

    boolean W1();

    void ZN(boolean r100);

    void aI(te8.c r100);

    void g3(wc9.e r100, Message r101, String r102, by7.e r103, boolean r104, String r105, long r106, String r107);

    List<Message> getCurrentList();

    void hy(te8.c r100);

    boolean l3(String r100, @MessageContentType Integer r101);

    Fragment me(View r100);

    void mi(String r100);

    void n2();

    void rW(Function1<? super MotionEvent, Unit> r100);

    void ud(q0 r100);

    void v60(xf8.g r100);

    com.larus.bmhome.chat.exposure.a vQ();

    boolean x7(String r100, @MessageContentType int r101);

    q0 z60(String r100);
}
