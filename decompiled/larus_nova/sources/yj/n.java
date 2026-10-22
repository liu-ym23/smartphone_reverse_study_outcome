package yj;

import com.bytedance.retrofit2.Converter;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface n {
    String a(String r100);

    Map<String, String> b();

    <T> T c(String r100, Class<T> r101, Converter.Factory r102);

    Map<String, String> commonParams();

    void connect(String r100);

    <T> T create(String r100, Class<T> r101, Converter.Factory r102, Map<String, ? extends Object> r103);

    com.bytedance.android.chunkstreamprediction.network.h d();
}
