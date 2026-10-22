package ga6;

import com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.h;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    String a();

    @Deprecated(message = "废弃，仅用于历史兼容性检查", replaceWith = @ReplaceWith(expression = "getParamValue(key)", imports = {}))
    <ParamType> ParamType b(String r100, ParamType r101);

    void c(String r100, Object r101);

    Object d(String r100);

    void e(h r100);

    String f();

    <T> T getData();

    ba6.c getNode();
}
