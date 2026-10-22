package xkc;

import androidx.collection.ArrayMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements xkc.a.f<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f564414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xkc.a f564415b;

    public class a implements xkc.a.f<wkc.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f564416a;

        public a(b r100) {
            this.f564416a = r100;
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(wkc.a r100) {
            xkc.a r101 = this.f564416a.f564415b;
            ArrayMap r102 = xkc.a.f564387o;
            r101.d(r100);
            this.f564416a.f564415b.f564390c.removeMessages(1024);
            xkc.a r103 = this.f564416a.f564415b;
            r103.f564390c.sendEmptyMessageDelayed(1024, r103.f564397j);
        }

        @Override // xkc.a.f
        public /* bridge */ /* synthetic */ void call(wkc.a r100) {
            call2(r100);
        }
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(j r100) {
        if (r100 != null) goto L4;
        r100 = new j(this.f564414a.f564419a, null);
    L4:
        i r101 = this.f564414a;
        r101.f564422d.lock();
        r101.f564421c = r100;
        r101.f564422d.unlock();
        r101.a();
        xkc.a r102 = this.f564415b;
        int r103 = r102.f564400m + 1;
        r102.f564400m = r103;
        Set<String> r104 = r102.f564396i;
        if (r104 != null) goto L7;
    L9:
        this.f564415b.getClass();
        return;
    L7:
        if (r103 != ((HashSet) r104).size()) goto L9;
        this.f564415b.c(new d(), new a(this));
        goto L9
    }

    @Override // xkc.a.f
    public /* bridge */ /* synthetic */ void call(j r100) {
        call2(r100);
    }

    public b(xkc.a r100, i r101) {
        this.f564415b = r100;
        this.f564414a = r101;
    }
}
