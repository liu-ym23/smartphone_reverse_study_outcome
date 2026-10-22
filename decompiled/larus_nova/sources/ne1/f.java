package ne1;

import com.bytedance.android.livesdk.arch.task.l;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements ne1.a<Object> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f518876e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f518877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.arch.comp.b f518878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f518879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l.b f518880d;

    public static final class a {
    }

    static {
    }

    @Override // ne1.a
    public final Map<String, Object> getParams() {
        return this.f518877a;
    }

    public f(com.bytedance.android.livesdk.arch.comp.b r100, b r101, l.b r102) {
        this.f518878b = r100;
        this.f518879c = r101;
        this.f518880d = r102;
        this.f518877a = new LinkedHashMap();
    }
}
