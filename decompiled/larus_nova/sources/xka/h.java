package xka;

import android.content.ContentValues;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements vka.b<Boolean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f564301f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f564302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f564305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f564306e;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentValues r101 = new ContentValues();
        r101.put("name", this.f564303b);
        r101.put("calendar_displayName", this.f564304c);
        r101.put("visible", this.f564305d);
        r101.put("sync_events", this.f564306e);
        if (r100.update(new ala.a(Long.valueOf(this.f564302a), 2), r101, null, null) <= 0) goto L5;
        boolean r102 = true;
    L7:
        return Boolean.valueOf(r102);
    L5:
        r102 = false;
        goto L7
    }

    public h(long r100, String r101, String r102, Boolean r103, Boolean r104) {
        this.f564302a = r100;
        this.f564303b = r101;
        this.f564304c = r102;
        this.f564305d = r103;
        this.f564306e = r104;
    }
}
