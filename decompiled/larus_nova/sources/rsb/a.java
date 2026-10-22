package rsb;

import android.graphics.Bitmap;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes36.dex */
public interface a {

    /* JADX INFO: renamed from: rsb.a$a, reason: collision with other inner class name */
    public interface InterfaceC7530a {
        void k0(int r100, List<String> r101);
    }

    @Deprecated(message = "replace with [getReactionOrEmojiBitmap]")
    Bitmap Hb(String r100, boolean r101);

    @Deprecated(message = "replace with [getReactionOrEmojiText]")
    String K9(String r100, boolean r101);

    ConcurrentHashMap<String, qsb.a> Q1();

    int U9();

    void V8(Set<? extends qsb.a> r100, int r101);

    qsb.a Yd(String r100);

    qsb.a b0(String r100);

    void c9(InterfaceC7530a r100);

    String df(String r100);

    void f3();

    void ge(String r100, boolean r101, IGetDataCallback<Boolean> r102, IGetDataCallback<Boolean> r103);

    ConcurrentHashMap<String, String> h2();

    boolean i7(String r100);

    /* JADX INFO: renamed from: if */
    boolean mo8648if(String r100);

    boolean l4(String r100);

    @Deprecated(message = "replace with [requestBitmap(String)]")
    void sb(String r100);

    String ub(String r100);

    Bitmap v1(String r100);
}
