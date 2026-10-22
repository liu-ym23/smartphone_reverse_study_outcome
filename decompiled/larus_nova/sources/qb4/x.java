package qb4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReentrantLock f532393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<JSONObject> f532394b = null;

    static {
        f532393a = new ReentrantLock();
        f532394b = new LinkedList();
    }

    public static void a(long r100, float r101, float r102, int r103, float r104, float r105) {
        JSONObject r106 = new JSONObject();
        r106.put("timestamp", r100);     // Catch: JSONException -> L12
        r106.put("force", r101);     // Catch: JSONException -> L12
        r106.put("majorRadius", r102);     // Catch: JSONException -> L12
        r106.put("phase", r103);     // Catch: JSONException -> L12
        r106.put("x", r104);     // Catch: JSONException -> L12
        r106.put("y", r105);     // Catch: JSONException -> L12
        ReentrantLock r107 = f532393a;     // Catch: Throwable -> L6 InterruptedException -> L9
        r107.lockInterruptibly();     // Catch: Throwable -> L6 InterruptedException -> L9
        ((LinkedList) f532394b).add(r106);     // Catch: Throwable -> L6 InterruptedException -> L9
    L10:
        r107.unlock();
        return;
    L9:
        r107 = f532393a;
    L6:
        th = move-exception;
        f532393a.unlock();
        throw th;
    L12:
        e = move-exception;
        int r108 = n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }
}
