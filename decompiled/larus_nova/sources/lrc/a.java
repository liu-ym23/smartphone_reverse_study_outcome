package lrc;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;
import ee.android.framework.manis.base.BinderWrapper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends MatrixCursor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f510480b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f510481c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f510482a;

    /* JADX INFO: renamed from: lrc.a$a, reason: collision with other inner class name */
    public static final class C6731a {
        public static IBinder a(Cursor r100) {
            Bundle r101 = r100.getExtras();
            r101.setClassLoader(a.class.getClassLoader());
            BinderWrapper r102 = (BinderWrapper) r101.getParcelable("KeyBinderWrapper");
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.f472257a;
        }
    }

    static {
        f510480b = new String[]{"id"};
        f510481c = new ConcurrentHashMap();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final Bundle getExtras() {
        return this.f510482a;
    }

    public a(String[] r100, IBinder r101) {
        super(r100);
        Bundle r102 = new Bundle();
        this.f510482a = r102;
        r102.putParcelable("KeyBinderWrapper", new BinderWrapper(r101));
    }
}
