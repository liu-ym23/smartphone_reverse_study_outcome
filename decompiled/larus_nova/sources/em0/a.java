package em0;

import com.bytedance.android.live.room.api.messagewindow.list.RecordAction;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import d71.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements d<v61.a, d71.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d71.b> f473047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d71.b> f473048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PriorityQueue<d71.b> f473049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriorityQueue<d71.b> f473050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q71.d<r71.c> f473051e;

    /* JADX INFO: renamed from: em0.a$a, reason: collision with other inner class name */
    public static final class C5790a {
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f473052a = null;

        static {
            f473052a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            d71.b r102 = (d71.b) r100;
            d71.b r103 = (d71.b) r101;
            int r104 = ((v61.a) r103.f467219b).f553380k - ((v61.a) r102.f467219b).f553380k;
            if (r104 == 0) goto L5;
            return r104;
        L5:
            return (int) (r103.f467218a - r102.f467218a);
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f473053a = null;

        static {
            f473053a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            d71.b r102 = (d71.b) r100;
            d71.b r103 = (d71.b) r101;
            int r104 = ((v61.a) r103.f467219b).f553380k - ((v61.a) r102.f467219b).f553380k;
            if (r104 == 0) goto L5;
            return r104;
        L5:
            return (int) (r103.f467218a - r102.f467218a);
        }
    }

    static {
    }

    @Override // d71.d
    public final Collection<d71.b> a() {
        return CollectionsKt.toList(this.f473049c);
    }

    @Override // d71.d
    public final void b() {
        Iterator<T> r100 = this.f473047a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        d71.b r101 = (d71.b) r100.next();
        if (((v61.a) r101.f467219b).E() == true) goto L4;
        s((v61.a) r101.f467219b);
        goto L4
    L8:
        PriorityQueue<d71.b> r102 = this.f473049c;
        if (r102 == null) goto L16;
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        d71.b r104 = (d71.b) r103.next();
        if (((v61.a) r104.f467219b).E() == true) goto L12;
        t((v61.a) r104.f467219b);
    L16:
        PriorityQueue<d71.b> r105 = this.f473050d;
        if (r105 == null) goto L24;
        Iterator<T> r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L40;
        d71.b r107 = (d71.b) r106.next();
        if (((v61.a) r107.f467219b).E() == true) goto L20;
        v((v61.a) r107.f467219b);
        goto L20
    L40:
        return;
    }

    @Override // d71.d
    public final d71.b f() {
        d71.b r100 = this.f473050d.poll();
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        RecordAction r103 = RecordAction.PollWaitingRecord;
        if (r100 == null) goto L8;
        v61.a r104 = (v61.a) r100.f467219b;
        if (r104 == null) goto L8;
        Object r105 = r104.f553379j;
        if (r105 == null) goto L8;
    L9:
        r101.b(r71.c.a.a(r103, r105, null, 12));
        return r100;
    L8:
        r105 = Unit.INSTANCE;
        goto L9
    }

    @Override // d71.d
    public final String k() {
        StringBuilder r100 = new StringBuilder("\nthe pending list: ");
        ArrayList r101 = (ArrayList) this.f473047a;
        if (r101.isEmpty() == false) goto L5;
        r100.append("empty");
    L5:
        Iterator r102 = r101.iterator();
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r102.hasNext() == false) goto L12;
        Object r105 = r102.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r100.append("\n" + r104 + ' ');
        StringBuilder r107 = new StringBuilder("id:");
        r107.append(((v61.a) ((d71.b) r105).f467219b).f553379j);
        r100.append(r107.toString());
        r104 = r106;
        goto L7
    L12:
        r100.append("\nthe showing list:");
        PriorityQueue<d71.b> r108 = this.f473049c;
        if (r108.isEmpty() == false) goto L15;
        r100.append("empty");
    L15:
        Iterator<T> r109 = r108.iterator();
        int r110 = 0;
    L17:
        if (r109.hasNext() == false) goto L22;
        Object r111 = r109.next();
        int r112 = r110 + 1;
        if (r110 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        r100.append("\n" + r110 + ' ');
        StringBuilder r113 = new StringBuilder("id:");
        r113.append(((v61.a) ((d71.b) r111).f467219b).f553379j);
        r100.append(r113.toString());
        r110 = r112;
        goto L17
    L22:
        r100.append("\nthe waiting list:");
        PriorityQueue<d71.b> r114 = this.f473050d;
        if (r114.isEmpty() == false) goto L25;
        r100.append("empty");
    L25:
        Iterator<T> r115 = r114.iterator();
        int r116 = 0;
    L27:
        if (r115.hasNext() == false) goto L32;
        Object r117 = r115.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        r100.append("\n" + r116 + ' ');
        StringBuilder r119 = new StringBuilder("id:");
        r119.append(((v61.a) ((d71.b) r117).f467219b).f553379j);
        r100.append(r119.toString());
        r116 = r118;
        goto L27
    L32:
        r100.append("\nthe temporary list:");
        CopyOnWriteArrayList r120 = (CopyOnWriteArrayList) this.f473048b;
        if (r120.isEmpty() == false) goto L35;
        r100.append("empty");
    L35:
        Iterator r121 = r120.iterator();
    L37:
        if (r121.hasNext() == false) goto L43;
        Object r122 = r121.next();
        int r123 = r103 + 1;
        if (r103 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        r100.append("\n" + r103 + ' ');
        StringBuilder r124 = new StringBuilder("id:");
        r124.append(((v61.a) ((d71.b) r122).f467219b).f553379j);
        r100.append(r124.toString());
        r103 = r123;
        goto L37
    L43:
        return r100.toString();
    }

    @Override // d71.d
    public final void release() {
        q71.d<r71.c> r100 = this.f473051e;
        int r101 = r71.c.f536394b;
        PriorityQueue<d71.b> r102 = null;
        r100.b(r71.c.a.a(RecordAction.ClearAllRecords, Unit.INSTANCE, null, 12));
        ((ArrayList) this.f473047a).clear();
        this.f473049c.clear();
        PriorityQueue<d71.b> r103 = this.f473050d;
        if ((!r103.isEmpty()) == false) goto L5;
        r102 = r103;
    L5:
        if (r102 == null) goto L12;
        List r104 = CollectionsKt.toList(r102);
        if (r104 == null) goto L12;
        Iterator r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        ((d71.b) r105.next()).a();
    L12:
        this.f473050d.clear();
        ((CopyOnWriteArrayList) this.f473048b).clear();
    }

    @Override // d71.d
    public final Collection<d71.b> o() {
        return this.f473048b;
    }

    public a(q71.d<r71.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "recordState");
        this.f473051e = r100;
        this.f473047a = new ArrayList();
        this.f473048b = new CopyOnWriteArrayList();
        this.f473049c = new PriorityQueue(6, b.f473052a);
        this.f473050d = new PriorityQueue(6, c.f473053a);
    }

    @Override // d71.d
    public final boolean c(v61.c r100) {
        v61.a r101 = (v61.a) r100;
        Intrinsics.checkNotNullParameter(r101, LiveEndPageData.TAG_WINDOW);
        PriorityQueue<d71.b> r102 = this.f473049c;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<d71.b> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((v61.a) r103.next().f467219b, r101) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // d71.d
    public final /* bridge */ /* synthetic */ d71.b d(v61.a r100) {
        return s(r100);
    }

    @Override // d71.d
    public final /* bridge */ /* synthetic */ d71.b e(v61.c r100) {
        return u((v61.a) r100);
    }

    @Override // d71.d
    public final boolean g(v61.c r100) {
        v61.a r101 = (v61.a) r100;
        Intrinsics.checkNotNullParameter(r101, LiveEndPageData.TAG_WINDOW);
        List r102 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(this.f473047a, this.f473049c), this.f473050d), this.f473048b);
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((v61.a) ((d71.b) r103.next()).f467219b, r101) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // d71.d
    public final void h(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.OfferShowingRecord, r100.f553379j, r100, 4));
        PriorityQueue<d71.b> r103 = this.f473049c;
        boolean r104 = true;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator<d71.b> r105 = r103.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        if ((!Intrinsics.areEqual((v61.a) r105.next().f467219b, r100)) == true) goto L9;
        r104 = false;
    L13:
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L22;
        r103.add(new d71.b(r100));
        return;
    L22:
        return;
    L5:
        if (r103.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // d71.d
    public final void i(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.OfferPendingRecord, r100.f553379j, r100, 4));
        List<d71.b> r103 = this.f473047a;
        boolean r104 = true;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator r105 = ((ArrayList) r103).iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        if ((!Intrinsics.areEqual((v61.a) ((d71.b) r105.next()).f467219b, r100)) == true) goto L9;
        r104 = false;
    L13:
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L22;
        r103.add(new d71.b(r100));
        return;
    L22:
        return;
    L5:
        if (((ArrayList) r103).isEmpty() == false) goto L7;
        goto L7
    }

    @Override // d71.d
    public final void j(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.OfferTemporaryRecord, r100.f553379j, r100, 4));
        List<d71.b> r103 = this.f473048b;
        boolean r104 = true;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator r105 = ((CopyOnWriteArrayList) r103).iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        if ((!Intrinsics.areEqual((v61.a) ((d71.b) r105.next()).f467219b, r100)) == true) goto L9;
        r104 = false;
    L13:
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L22;
        r103.add(new d71.b(r100));
        return;
    L22:
        return;
    L5:
        if (((CopyOnWriteArrayList) r103).isEmpty() == false) goto L7;
        goto L7
    }

    @Override // d71.d
    public final d71.b l(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.OfferWaitingRecords, r100.f553379j, r100, 4));
        Iterator<d71.b> r103 = this.f473050d.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        d71.b r104 = r103.next();
        if (Intrinsics.areEqual((v61.a) r104.f467219b, r100) == false) goto L4;
    L9:
        d71.b r105 = r104;
        if (r105 != null) goto L16;
        d71.b r106 = new d71.b(r100);
        this.f473050d.add(r106);
        return r106;
    L16:
        return r105;
    L8:
        r104 = null;
        goto L9
    }

    @Override // d71.d
    public final boolean m(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        PriorityQueue<d71.b> r101 = this.f473050d;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<d71.b> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((v61.a) r102.next().f467219b, r100) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // d71.d
    public final /* bridge */ /* synthetic */ d71.b n(v61.a r100) {
        return v(r100);
    }

    @Override // d71.d
    public final void p(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.RemoveFromRecords, r100.f553379j, r100, 4));
        s(r100);
        t(r100);
        v(r100);
        u(r100);
    }

    @Override // d71.d
    public final boolean q(Object r100) {
        Intrinsics.checkNotNullParameter(r100, DownloadHelper.IDENTITY);
        PriorityQueue<d71.b> r101 = this.f473049c;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((v61.a) ((d71.b) r102.next()).f467219b).f553379j, r100) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return false;
    }

    @Override // d71.d
    public final /* bridge */ /* synthetic */ d71.b r(v61.a r100) {
        return t(r100);
    }

    public final d71.b s(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.RemovePendingRecord, r100.f553379j, r100, 4));
        Iterator r103 = ((ArrayList) this.f473047a).iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        d71.b r104 = (d71.b) r103.next();
        if (Intrinsics.areEqual((v61.a) r104.f467219b, r100) == false) goto L4;
        r103.remove();
        return r104;
    L9:
        return null;
    }

    public final d71.b t(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.RemoveShowingRecord, r100.f553379j, r100, 4));
        Iterator<d71.b> r103 = this.f473049c.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        d71.b r104 = r103.next();
        if (Intrinsics.areEqual((v61.a) r104.f467219b, r100) == false) goto L4;
        r103.remove();
        return r104;
    L9:
        return null;
    }

    public final d71.b u(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.RemoveTemporaryRecord, r100.f553379j, r100, 4));
        Iterator r103 = ((CopyOnWriteArrayList) this.f473048b).iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        d71.b r104 = (d71.b) r103.next();
        if (Intrinsics.areEqual((v61.a) r104.f467219b, r100) == false) goto L4;
        ((CopyOnWriteArrayList) this.f473048b).remove(r104);
        return r104;
    L9:
        return null;
    }

    public final d71.b v(v61.a r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        q71.d<r71.c> r101 = this.f473051e;
        int r102 = r71.c.f536394b;
        r101.b(r71.c.a.a(RecordAction.RemoveWaitingRecord, r100.f553379j, r100, 4));
        Iterator<d71.b> r103 = this.f473050d.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        d71.b r104 = r103.next();
        if (Intrinsics.areEqual((v61.a) r104.f467219b, r100) == false) goto L4;
        r104.a();
        r103.remove();
        return r104;
    L9:
        return null;
    }
}
