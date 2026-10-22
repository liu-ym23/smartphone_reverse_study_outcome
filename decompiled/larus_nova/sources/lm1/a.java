package lm1;

import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    void a(String r100);

    Boolean b(String r100);

    long getCacheSize();

    String getCachedVideoId(long r100);

    Map<String, Pair<String, String>> getLocalVideoPath(String r100);
}
