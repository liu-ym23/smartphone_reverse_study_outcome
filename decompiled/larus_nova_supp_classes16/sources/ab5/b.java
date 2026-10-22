package ab5;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.compress.m;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements FlowableOnSubscribe {
    public final /* synthetic */ List<Photo> a;
    public final /* synthetic */ d b;
    public final /* synthetic */ boolean c;

    public static final class a extends m {
        public final /* synthetic */ d a;
        public final /* synthetic */ Photo b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FlowableEmitter<Photo> d;
        public final /* synthetic */ long e;
        public final /* synthetic */ List<Photo> f;

        public final void a(float r3) {
            this.a.a(this.b.getId(), r3);
            if (TextUtils.isEmpty(this.b.getCompressPath()) == false) goto L6;
            this.b.setCompressPath(this.c);
            return;
        }

        public final void b(ErrorResult r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            this.a.b.decrementAndGet();
            this.a.j.put(Integer.valueOf(this.b.getId()), Float.valueOf(1.0f));
            this.d.onNext(this.b);
            Map<Long, Long> r4 = this.a.c;
            ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
            r5.remove(Long.valueOf(this.e));
            if (this.a.b.get() == 0) goto L5;
        L7:
            tt5.a.h(this.a.h, "compress video error");
            return;
        L5:
            if (this.a.a.get() != this.f.size()) goto L7;
            this.d.onComplete();
            goto L7
        }

        public final void c(VideoCompressResult r3) {
            Intrinsics.checkNotNullParameter(r3, TipCallBackData.RESULT);
            this.a.b.decrementAndGet();
            this.b.setPath(this.c);
            this.a.j.put(Integer.valueOf(this.b.getId()), Float.valueOf(1.0f));
            this.d.onNext(this.b);
            Map<Long, Long> r4 = this.a.c;
            ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
            r5.remove(Long.valueOf(this.e));
            if (this.a.b.get() == 0) goto L5;
        L7:
            tt5.a.h(this.a.h, "compress video success");
            return;
        L5:
            if (this.a.a.get() != this.f.size()) goto L7;
            this.d.onComplete();
            goto L7
        }

        public a(d r1, Photo r2, String r3, FlowableEmitter<Photo> r4, long r5, List<Photo> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
        }
    }

    public b(List<Photo> r1, d r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(FlowableEmitter<Photo> r19) {
        FlowableEmitter<Photo> r9 = r19;
        Intrinsics.checkNotNullParameter(r9, "it");
        Iterator<Photo> r10 = this.a.iterator();
    L4:
        if (r10.hasNext() == false) goto L23;
        Photo r11 = r10.next();
        this.b.j.put(Integer.valueOf(r11.getId()), Float.valueOf(0.0f));
        this.b.a.incrementAndGet();
        if (this.c == false) goto L8;
    L19:
        FlowableEmitter<Photo> r1 = r9;
        Iterator<Photo> r16 = r10;
        r1.onNext(r11);
    L20:
        r9 = r1;
    L21:
        r10 = r16;
        goto L4
    L8:
        if (r11.isVideo() == false) goto L19;
        String r2 = FileUtils.x(false, r11.getPath());
        this.b.b.incrementAndGet();
        Intrinsics.checkNotNull(r2);
        String r3 = r2.substring(0, StringsKt.lastIndexOf$default(r2, ".", 0, false, 6, null));
        VFSPath r4 = du5.c.a(this.b.g);
        if (r4 == null) goto L14;
        VFSPath r5 = r4.subPath(r3 + ".mp4");
        if (r5 == null) goto L14;
        String r6 = r5.getRealPath();
    L15:
        String r12 = r6;
        long r13 = UUID.randomUUID().hashCode();
        ((ConcurrentHashMap) this.b.c).put(Long.valueOf(r13), 0L);
        r16 = r10;
        com.ss.android.lark.videosend.compress.a r17 = new com.ss.android.lark.videosend.compress.a(r13, r11.getPath(), new a(this.b, r11, r12, r19, r13, this.a));
        r17.d = r12;
        int r7 = com.ss.android.lark.videosend.compress.d.d;     // Catch: Exception -> L18
        com.ss.android.lark.videosend.compress.d.b.a.c(r17);     // Catch: Exception -> L18
        r9 = r19;
    L18:
        this.b.b.decrementAndGet();
        r1 = r19;
        r1.onNext(r11);
        tt5.a.h(this.b.h, "compress ");
    L14:
        r6 = null;
        goto L15
    L23:
        if (this.b.b.get() == 0) goto L25;
        return;
    L25:
        if (this.b.a.get() != this.a.size()) goto L34;
        r19.onComplete();
        return;
    }
}
