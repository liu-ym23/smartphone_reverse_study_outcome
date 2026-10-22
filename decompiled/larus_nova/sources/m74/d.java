package m74;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Long> f512347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f512348b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, List<w74.c>> f512349c = null;

    static {
        f512347a = new ConcurrentHashMap();
        f512348b = new ConcurrentHashMap();
        f512349c = new ConcurrentHashMap();
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        new SecureRandom();
    }
}
