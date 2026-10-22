package wka;

import ala.d;
import android.content.ContentValues;
import com.alipay.sdk.m.p.e;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import vka.f;

/* JADX INFO: loaded from: classes33.dex */
public final class c implements vka.b<Long> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f560151h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f560153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f560154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f560155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f560156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f560157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f560158g;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        f r100 = f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentValues r101 = new ContentValues();
        r101.put("event_id", Long.valueOf(this.f560154c));
        if (this.f560156e == false) goto L6;
        r101.put(DocumentType.MINUTES_NAME, this.f560155d);
    L6:
        if (this.f560158g == false) goto L9;
        r101.put(e.f25671s, this.f560157f);
    L9:
        if (this.f560153b == null) goto L14;
        if (r100.update(new d(this.f560153b, this.f560152a), r101, null, null) > 0) goto L16;
        return null;
    L16:
        return this.f560153b;
    L14:
        return r100.insert(new d(null, this.f560152a), r101);
    }

    public c(String r100, Long r101, long r102, Long r103, boolean r104, Integer r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "accountName");
        this.f560152a = r100;
        this.f560153b = r101;
        this.f560154c = r102;
        this.f560155d = r103;
        this.f560156e = r104;
        this.f560157f = r105;
        this.f560158g = r106;
    }
}
