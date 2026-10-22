package ps6;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes21.dex */
public interface b {
    void a(String r100, String r101, String r102, String r103, String r104);

    void b();

    void c(Map r100);

    void d();

    @Deprecated(message = "已不建议继续使用AdLog", replaceWith = @ReplaceWith(expression = "logAdOpt()", imports = {}))
    void log();
}
