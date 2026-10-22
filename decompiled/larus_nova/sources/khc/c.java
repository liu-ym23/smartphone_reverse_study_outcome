package khc;

import android.content.Intent;
import android.os.Message;
import com.ss.android.ugc.route_monitor.impl.launch_info.f;
import ihc.p;

/* JADX INFO: loaded from: classes40.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f503595a = null;

    public static final class a {
        public a() {
        }
    }

    public c() {
    }

    public abstract Intent a(Message r100);

    static {
        f503595a = new a();
    }

    public final f b(Message r100) {
        Intent r101 = a(r100);
        if (r101 == null) goto L5;
        f.f454464l.getClass();
        f r102 = f.a.b(r101);
        r102.f454465a = p.f489950c;
        return r102;
    L5:
        return null;
    }
}
