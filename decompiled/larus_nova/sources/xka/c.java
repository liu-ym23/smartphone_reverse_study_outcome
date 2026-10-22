package xka;

import android.content.ContentValues;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c implements vka.b<Object> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f564282e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f564283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f564284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f564285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f564286d;

    public static final class a {
        public static c a(JsonObject r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "json");
            JsonElement r102 = r100.get("id");
            Integer r103 = null;
            if (r102 == null) goto L5;
            Long r104 = Long.valueOf(r102.getAsLong());
        L6:
            if (r101 == false) goto L11;
            if (r104 == null) goto L11;
            throw new IllegalArgumentException("add reminder with non-null id");
        L11:
            if (r101 == true) goto L16;
            if (r104 != null) goto L16;
            throw new IllegalArgumentException("update reminder with null id");
        L16:
            long r105 = r100.get(com.heytap.mcssdk.constant.b.f276361k).getAsLong();
            JsonElement r106 = r100.get(DocumentType.MINUTES_NAME);
            if (r106 == null) goto L19;
            Long r107 = Long.valueOf(r106.getAsLong());
        L20:
            JsonElement r108 = r100.get(com.alipay.sdk.m.p.e.f25671s);
            if (r108 == null) goto L24;
            r103 = Integer.valueOf(r108.getAsInt());
        L24:
            return new c(r104, r105, r107, r103);
        L19:
            r107 = null;
            goto L20
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ala.d r101 = new ala.d(this.f564283a, 2);
        ContentValues r102 = new ContentValues();
        r102.put("event_id", Long.valueOf(this.f564284b));
        r102.put(DocumentType.MINUTES_NAME, this.f564285c);
        r102.put(com.alipay.sdk.m.p.e.f25671s, this.f564286d);
        if (this.f564283a == null) goto L10;
        if (r100.update(r101, r102, null, null) <= 0) goto L7;
        boolean r103 = true;
    L11:
        return Boolean.valueOf(r103);
    L7:
        r103 = false;
        goto L11
    L10:
        return r100.insert(r101, r102);
    }

    public c(Long r100, long r101, Long r102, Integer r103) {
        this.f564283a = r100;
        this.f564284b = r101;
        this.f564285c = r102;
        this.f564286d = r103;
    }
}
