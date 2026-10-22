package ot2;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public interface b {
    String a();

    String b();

    Disposable c(int r100, Function1<? super Integer, Boolean> r101);

    String d();

    String e();

    void f(IRoom r100);

    void g(int r100, String r101, String r102);

    String getTAG();

    void h(List<s> r100, Set<Integer> r101, Set<Integer> r102, boolean r103);

    int i();

    void j(s r100, String r101, boolean r102, boolean r103, boolean r104);
}
