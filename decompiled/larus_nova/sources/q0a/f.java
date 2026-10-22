package q0a;

import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.impl.viewholder.CreationVideoViewHolder;
import com.larus.ugc.feed.impl.viewholder.h0;
import com.larus.ugc.feed.impl.viewholder.i0;
import com.larus.utils.y;
import com.larus.video.impl.sdk.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IVideoController f531228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<WeakReference<CreationVideoViewHolder>> f531229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<CreationVideoViewHolder> f531230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f531231d;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            CreationVideoViewHolder r102 = (CreationVideoViewHolder) ((WeakReference) r100).get();
            Integer r103 = null;
            if (r102 == null) goto L5;
            Integer r104 = Integer.valueOf(r102.getAbsoluteAdapterPosition());
        L6:
            CreationVideoViewHolder r105 = (CreationVideoViewHolder) ((WeakReference) r101).get();
            if (r105 == null) goto L10;
            r103 = Integer.valueOf(r105.getAbsoluteAdapterPosition());
        L10:
            return ComparisonsKt.compareValues(r104, r103);
        L5:
            r104 = null;
            goto L6
        }
    }

    public static boolean a() {
        return z2.f365865a.downgradeCreationFeedVideoFix();
    }

    public final List<WeakReference<CreationVideoViewHolder>> b() {
        List r100 = CollectionsKt.sortedWith(this.f531229b, new a());
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((WeakReference) r103).get() == null) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L11:
        return r101;
    }

    public f() {
        this.f531229b = new ConcurrentLinkedQueue();
        this.f531231d = -1;
    }

    public final void d() {
        this.f531230c = (WeakReference) CollectionsKt.firstOrNull(b());
        if (a() == false) goto L10;
        WeakReference<CreationVideoViewHolder> r100 = this.f531230c;
        if (r100 == null) goto L10;
        CreationVideoViewHolder r101 = r100.get();
        if (r101 == null) goto L10;
        c(r101);
    L10:
        if (a() == true) goto L32;
        Iterator<WeakReference<CreationVideoViewHolder>> r102 = this.f531229b.iterator();
    L13:
        if (r102.hasNext() == false) goto L19;
        WeakReference<CreationVideoViewHolder> r103 = r102.next();
        if (Intrinsics.areEqual(r103, this.f531230c) == true) goto L13;
        final CreationVideoViewHolder r104 = r103.get();
        if (r104 == null) goto L13;
        y.c(new i0(r104));
        goto L13
    L19:
        WeakReference<CreationVideoViewHolder> r105 = this.f531230c;
        if (r105 == null) goto L33;
        CreationVideoViewHolder r106 = r105.get();
        if (r106 == null) goto L34;
        c(r106);
        return;
    L34:
        return;
    L33:
        return;
    }

    public final void c(final CreationVideoViewHolder r100) {
        if (a() == true) goto L14;
        IVideoController r101 = this.f531228a;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        if (this.f531231d != r100.getAdapterPosition()) goto L14;
        return;
    L7:
        if (r101.p3() != true) goto L9;
        r102 = true;
    L14:
        WeakReference<CreationVideoViewHolder> r103 = this.f531230c;
        if (r103 == null) goto L19;
        CreationVideoViewHolder r104 = r103.get();
        if (r104 == null) goto L19;
        int r105 = r104.getAdapterPosition();
    L20:
        this.f531231d = r105;
        IVideoController r106 = this.f531228a;
        if (r106 == null) goto L23;
        r106.release();
    L23:
        IVideoController r107 = null;
        this.f531228a = null;
        IVideoController r108 = q3.b("ugc_video", null, 6);
        if (r108 == null) goto L26;
        ((o) r108).setSubTag("message_card");
        r107 = r108;
    L26:
        this.f531228a = r107;
        VideoPlayView r109 = r100.f374997e;
        if (r107 != null) goto L29;
        r109.getClass();
    L35:
        boolean r110 = w0a.a.f557826a;
        UserCreationKmp r111 = r100.f375001i;
        if (r111 == null) goto L41;
        Long r112 = r111.getCreateTime();
        if (r112 == null) goto L41;
        String r113 = r112.toString();
        if (r113 == null) goto L41;
    L42:
        w0a.a.c("onCardDisplay", r113);
        y.c(new h0(r100));
        return;
    L41:
        r113 = "";
        goto L42
    L29:
        if (r107 == r109.C) goto L31;
        r109.N();
    L31:
        r109.C = r107;
        ((o) r107).setLooping(true);
        IVideoController r114 = r109.C;
        if (r114 == null) goto L35;
        r114.C(r109.f327998s);
    L19:
        r105 = -1;
        goto L20
    }
}
