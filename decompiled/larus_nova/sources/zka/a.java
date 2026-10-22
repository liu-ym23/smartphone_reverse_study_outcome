package zka;

import androidx.core.util.Consumer;
import com.google.gson.Gson;
import com.obric.miniapp.calendar.proxy.function.AppletVersionInfo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f572709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, CopyOnWriteArraySet<Consumer<AppletVersionInfo>>> f572710b;

    /* JADX INFO: renamed from: zka.a$a, reason: collision with other inner class name */
    public static final class C8473a {
    }

    static {
    }

    public a() {
        this.f572709a = new AtomicBoolean(false);
        this.f572710b = new ConcurrentHashMap();
        new Gson();
    }
}
