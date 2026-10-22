package li4;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import com.bytedance.creativex.mediaimport.repository.internal.main.MediaItemInternal;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public abstract class m<DATA> implements ki4.f<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f509330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f509331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ki4.e<DATA> f509332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f509333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Cursor f509334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f509335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f509336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f509337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f509338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f509339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f509340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f509341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f509342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f509343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f509344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f509345p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function2<? super Long, ? super Long, Long> f509346q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f509347r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f509348s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f509349t;

    public abstract MediaItemInternal g(String r100, long r101);

    public final Cursor d() {
        Cursor r100 = this.f509334e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("should not access actualCursor before parseData is called".toString());
    }

    public final long e() {
        if (((Number) this.f509342m.getValue()).intValue() != (-1)) goto L5;
        long r100 = System.currentTimeMillis() / ((long) 1000);
    L7:
        if (((Number) this.f509343n.getValue()).intValue() == (-1)) goto L11;
        long r101 = d().getLong(((Number) this.f509343n.getValue()).intValue());
        if (r101 <= 0) goto L11;
    L13:
        if (this.f509347r >= this.f509348s) goto L15;
        FLogger.f375446a.d("MediaListAdapter", "addDateIndex:" + ((Number) this.f509342m.getValue()).intValue() + ", modifyDateIndex:" + ((Number) this.f509343n.getValue()).intValue() + " addDate:" + r100 + ", modifyDate:" + r101);
    L15:
        Function2<? super Long, ? super Long, Long> r102 = this.f509346q;
        if (r102 == null) goto L19;
        return r102.invoke(Long.valueOf(r100), Long.valueOf(r101)).longValue();
    L19:
        return Math.max(r100, r101);
    L11:
        r101 = r100;
        goto L13
    L5:
        r100 = d().getLong(((Number) this.f509342m.getValue()).intValue());
        goto L7
    }

    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (ri4.b.b() == true) goto L12;
        String r101 = File.separator;
        return r100.substring(((Number) this.f509349t.getValue()).intValue(), StringsKt.lastIndexOf$default(r100, r101, 0, false, 6, null)) + r101;
    L8:
        return null;
    L12:
        return d().getString(((Number) this.f509336g.getValue()).intValue());
    }

    public final Uri c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "pathBeforeQ");
        if (this.f509331b == true) goto L6;
        return null;
    L6:
        if (ri4.b.b() == false) goto L13;
        Uri r102 = this.f509333d;
        if (r102 == null) goto L11;
        return ContentUris.withAppendedId(r102, r101);
    L11:
        throw new IllegalArgumentException("Required value was null.".toString());
    L13:
        return Uri.fromFile(new PolarisFileWrapper(r100));
    }

    @Override // ki4.f
    public final Triple<List<DATA>, Integer, Boolean> a(Cursor r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "actualCursor");
    L13:
        return b(r100, r101, r102);
    L8:
        return new Triple(CollectionsKt.emptyList(), 0, Boolean.FALSE);
    L12:
        return new Triple(CollectionsKt.emptyList(), 0, Boolean.FALSE);
    L11:
        return new Triple(CollectionsKt.emptyList(), 0, Boolean.FALSE);
    }

    public final Triple<List<DATA>, Integer, Boolean> b(Cursor r110, int r111, int r112) {
        boolean r100 = false;
        if (r111 == 0) goto L5;
        this.f509334e = r110;
        List r101 = CollectionsKt.createListBuilder();
        int r102 = 0;
        boolean r103 = true;
    L8:
        if (r111 <= (-1)) goto L11;
        if (r102 < r111) goto L11;
    L12:
        r100 = r103;
    L19:
        return new Triple(CollectionsKt.build(r101), Integer.valueOf(r102), Boolean.valueOf(r100));
    L11:
        if (r110.isClosed() == true) goto L12;
        if (r110.isClosed() == true) goto L21;
        if (r110.moveToNext() == true) goto L21;
        r110.close();
    L21:
        if (ri4.b.b() == false) goto L23;
        String r104 = null;
    L25:
        if (ri4.b.b() == true) goto L34;
        if (r104 != null) goto L28;
    L31:
        boolean r105 = true;
    L32:
        if (r105 == false) goto L34;
    L28:
        if (r104.length() == 0) goto L31;
        r105 = false;
    L34:
        long r106 = r110.getLong(((Number) this.f509340k.getValue()).intValue());
        if (this.f509330a == false) goto L39;
        if (r106 <= 0) goto L8;
    L39:
        if (r104 != null) goto L41;
        r104 = "";
    L41:
        MediaItemInternal r107 = g(r104, r106);
        if (r107 == null) goto L46;
        System.currentTimeMillis();
        this.f509332c.a(r107);
        r101.add(r107);
        Unit r108 = Unit.INSTANCE;
        System.currentTimeMillis();
        if (this.f509347r >= this.f509348s) goto L46;
        FLogger.f375446a.d("MediaListAdapter", "uri:" + r107.getUri());
        this.f509347r = this.f509347r + 1;
    L46:
        r102 = r102 + 1;
        if (r110.isLast() == false) goto L8;
        r110.close();
        r103 = false;
        goto L8
    L23:
        r104 = r110.getString(((Number) this.f509336g.getValue()).intValue());
        goto L25
    L5:
        return new Triple(CollectionsKt.emptyList(), 0, Boolean.valueOf(!r110.isClosed()));
    }

    public m(MediaType r100, boolean r101, boolean r102, ki4.e<DATA> r103) {
        Intrinsics.checkNotNullParameter(r100, "mediaType");
        Intrinsics.checkNotNullParameter(r103, "cursorParseFilter");
        this.f509330a = r101;
        this.f509331b = r102;
        this.f509332c = r103;
        if (ri4.b.b() == false) goto L5;
        Uri r104 = r100.getContentUri();
    L6:
        this.f509333d = r104;
        this.f509335f = LazyKt.lazy(new a(this));
        this.f509336g = LazyKt.lazy(new f(this));
        this.f509337h = LazyKt.lazy(new g(this));
        this.f509338i = LazyKt.lazy(new h(this));
        this.f509339j = LazyKt.lazy(new i(this));
        this.f509340k = LazyKt.lazy(new j(this));
        this.f509341l = LazyKt.lazy(new k(this));
        this.f509342m = LazyKt.lazy(new l(this));
        this.f509343n = LazyKt.lazy(new b(this));
        this.f509344o = LazyKt.lazy(new c(this));
        this.f509345p = LazyKt.lazy(new d(this));
        this.f509348s = 100;
        this.f509349t = LazyKt.lazy(new e());
        return;
    L5:
        r104 = null;
        goto L6
    }
}
