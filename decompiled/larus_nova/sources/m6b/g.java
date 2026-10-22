package m6b;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.service.impl.b2;
import com.ss.android.lark.dto.draft.Draft;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes35.dex */
public interface g {
    Draft Ea(String r100);

    void M8(String r100, int r101);

    void Mb(String r100, String r101);

    Draft Na(String r100);

    Draft Pc(String r100);

    void a8(String r100);

    Draft b6(String r100);

    Draft b8(String r100);

    Executor getExecutor();

    void o5(b2.a r100, String r101, String r102, com.ss.android.lark.chat.service.impl.r.a r103);

    Map<String, Draft> se(List<String> r100);

    void tc(String r100, Draft r101, boolean r102, String r103);

    String x8(Chat r100, Draft r101, boolean r102);
}
