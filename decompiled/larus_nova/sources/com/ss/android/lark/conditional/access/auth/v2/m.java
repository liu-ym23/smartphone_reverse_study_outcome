package com.ss.android.lark.conditional.access.auth.v2;

import androidx.room.util.TableInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f417833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f417834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ KVRepo f417835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f417836d;

    public m(int r100, Ref.IntRef r101, KVRepo r102, int r103) {
        this.f417833a = r100;
        this.f417834b = r101;
        this.f417835c = r102;
        this.f417836d = r103;
    }

    public final void a() {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= this.f417833a) goto L11;
        com.ss.android.lark.storage.kv.repo.a r103 = y.f417932a;
        Pair r104 = y.a(this.f417834b.element);
        if (r104 == null) goto L10;
        this.f417835c.remove(TableInfo.Index.DEFAULT_PREFIX + this.f417834b.element);
        if (r104.getSecond() == null) goto L10;
        r100.put(r104.getFirst(), r104.getSecond());
        this.f417835c.remove((String) r104.getFirst());
    L10:
        Ref.IntRef r105 = this.f417834b;
        r105.element = (r105.element + 1) % this.f417833a;
        r102 = r102 + 1;
        goto L4
    L11:
        Set r106 = r100.entrySet();
        KVRepo r107 = this.f417835c;
        int r108 = this.f417836d;
        Iterator r109 = r106.iterator();
        int r110 = 0;
    L13:
        if (r109.hasNext() == false) goto L20;
        Map.Entry r111 = (Map.Entry) r109.next();
        String r112 = TableInfo.Index.DEFAULT_PREFIX + r101;
        if (r107.a(r112, String.class) == false) goto L19;
        String r113 = r107.getString(r112, null);
        if (r113 == null) goto L19;
        r107.remove(r113);
    L19:
        r107.putJSONObject((String) r111.getKey(), r111.getValue());
        r107.putString(r112, (String) r111.getKey());
        r101 = (r101 + 1) % r108;
        r110 = Math.min(r110 + 1, r108);
        goto L13
    L20:
        y.f417935d = r101;
        y.f417937f = r110;
        y.f417936e = this.f417836d;
        this.f417835c.putInt("IM_FILE_READ_HEAD", y.f417935d);
        this.f417835c.putInt("IM_FILE_READ_COUNT", y.f417937f);
        this.f417835c.putInt("IM_FILE_READ_MAX_CAPACITY", y.f417936e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
