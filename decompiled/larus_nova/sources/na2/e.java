package na2;

import android.text.Spannable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.live.richcontent.ResourceInfo;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f518439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f518440b;

    public static final class a implements qb2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f518441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f518442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter f518443c;

        @Override // qb2.e
        public final void a(ak6.g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            Intrinsics.checkNotNullParameter(r100, "rendResult");
        }

        @Override // qb2.e
        public final void b(ak6.g r100) {
            Intrinsics.checkNotNullParameter(r100, "rendResult");
            List<ResourceInfo> r101 = qb2.d.a(r100);
            if (r101 == null) goto L8;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            ALogger.e("AnchorPublicScreenConfigDialog", ((ResourceInfo) r102.next()).f255740a.toString());
        L8:
            this.f518441a.add(r100.f4074a);
            if (this.f518442b.decrementAndGet() != 0) goto L13;
            this.f518443c.onSuccess(this.f518441a);
            return;
        }

        public a(List r100, AtomicInteger r101, SingleEmitter r102) {
            this.f518441a = r100;
            this.f518442b = r101;
            this.f518443c = r102;
        }
    }

    public e(List r100, y r101) {
        this.f518439a = r100;
        this.f518440b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<List<Spannable>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        CopyOnWriteArrayList r101 = new CopyOnWriteArrayList();
        AtomicInteger r102 = new AtomicInteger(this.f518439a.size());
        qb2.g r103 = new qb2.g(true, this.f518440b.getScale(), 1);
        Iterator<T> r104 = this.f518439a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        qb2.c.b((tb2.d) r104.next(), new a(r101, r102, r100), new qb2.f(this.f518440b, r103), 24);
        goto L4
    }
}
