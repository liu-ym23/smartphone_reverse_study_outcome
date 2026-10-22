package kc8;

import androidx.fragment.app.DialogFragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes25.dex */
public interface b0 {
    void E0(ICoreInputAbility.OnSendParams r100);

    void F5(nr9.g r100, String r101, Map<String, String> r102, Map<String, String> r103);

    Set<String> a();

    void b(Serializable r100, String r101, String r102, zs8.a r103);

    void c(DialogFragment r100);

    void d();
}
