package ww6;

import com.bytedance.locallife.dito.event.BusMutableLiveData;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes21.dex */
public interface l {
    boolean a(String r100);

    void b(i r100, String r101, String r102, HashMap<String, String> r103, Function0<? extends Map<String, String>> r104);

    BusMutableLiveData<com.bytedance.locallife.pdp.net.dynamic.c> c();

    void cancel();
}
