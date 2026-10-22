package dwa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes34.dex */
public abstract class b implements c {
    public b() {
    }

    public static void c(String r100) {
        if (j.f470380k != null) goto L6;
        return;
    L6:
        if (j.f470380k.f470387g.get(r100) != null) goto L9;
        return;
    L9:
        throw null;
    }

    @Override // dwa.c
    public final View a(Context r100, final int r101, ViewGroup r102) {
        final j r103 = (j) this;
        ConcurrentHashMap<Integer, ConcurrentLinkedQueue<View>> r104 = r103.f470386f;
        if (r104 == null) goto L7;
        ConcurrentLinkedQueue<View> r105 = r104.get(Integer.valueOf(r101));
        if (r105 == null) goto L7;
        View r106 = r105.poll();
    L8:
        if (r106 != null) goto L10;
        r103.f470382b++;
        Log.i("PreLoadAsyncInflater", "getView2 cache is null");
        r106 = LayoutInflater.from(r100).inflate(r101, r102, false);
    L13:
        r103.f470381a++;
        return r106;
    L10:
        if (r100 == null) goto L12;
        j.g(r100, r106);
    L12:
        r103.f470385e.schedule(new i(r103, r101), 1000, TimeUnit.MILLISECONDS);
    L7:
        r106 = null;
        goto L8
    }

    @Override // dwa.c
    public final View b(Context r100, int r101, ViewGroup r102) {
        return a(r100, r101, r102);
    }
}
