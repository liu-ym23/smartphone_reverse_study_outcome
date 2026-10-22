package i29;

import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.community.impl.viewholder.CreationVideoViewHolder;
import com.larus.community.impl.viewholder.l0;
import com.larus.community.impl.viewholder.n0;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.utils.y;
import com.larus.video.impl.sdk.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f488068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IVideoController f488069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue<WeakReference<CreationVideoViewHolder>> f488070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference<CreationVideoViewHolder> f488071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f488072f;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f488073a;

        public a(f r100) {
            this.f488073a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            CreationVideoViewHolder r102 = (CreationVideoViewHolder) ((WeakReference) r100).get();
            Integer r103 = null;
            if (r102 == null) goto L5;
            this.f488073a.getClass();
            Integer r104 = Integer.valueOf(f.b(r102));
        L6:
            CreationVideoViewHolder r105 = (CreationVideoViewHolder) ((WeakReference) r101).get();
            if (r105 == null) goto L10;
            this.f488073a.getClass();
            r103 = Integer.valueOf(f.b(r105));
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

    public final List<WeakReference<CreationVideoViewHolder>> c() {
        List r100 = CollectionsKt.sortedWith(this.f488070d, new a(this));
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        CreationVideoViewHolder r104 = (CreationVideoViewHolder) ((WeakReference) r103).get();
        if (r104 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        if (b(r104) == (-1)) goto L11;
        r105 = true;
        goto L12
    L14:
        return r101;
    }

    public final void e() {
        this.f488071e = (WeakReference) CollectionsKt.firstOrNull(c());
        if (a() == false) goto L10;
        WeakReference<CreationVideoViewHolder> r100 = this.f488071e;
        if (r100 == null) goto L10;
        CreationVideoViewHolder r101 = r100.get();
        if (r101 == null) goto L10;
        d(r101);
    L10:
        if (a() == true) goto L32;
        Iterator<WeakReference<CreationVideoViewHolder>> r102 = this.f488070d.iterator();
    L13:
        if (r102.hasNext() == false) goto L19;
        WeakReference<CreationVideoViewHolder> r103 = r102.next();
        if (Intrinsics.areEqual(r103, this.f488071e) == true) goto L13;
        final CreationVideoViewHolder r104 = r103.get();
        if (r104 == null) goto L13;
        y.c(new n0(r104));
        goto L13
    L19:
        WeakReference<CreationVideoViewHolder> r105 = this.f488071e;
        if (r105 == null) goto L33;
        CreationVideoViewHolder r106 = r105.get();
        if (r106 == null) goto L34;
        d(r106);
        return;
    L34:
        return;
    L33:
        return;
    }

    public static int b(CreationVideoViewHolder r100) {
        ViewParent r101 = r100.itemView.getParent();
        if ((r101 instanceof RecyclerView) == false) goto L5;
        RecyclerView r102 = (RecyclerView) r101;
    L6:
        if (r102 != null) goto L10;
        return -1;
    L10:
        return r102.getChildAdapterPosition(r100.itemView);
    L5:
        r102 = null;
        goto L6
    }

    public final void d(final CreationVideoViewHolder r100) {
        if (a() == true) goto L14;
        IVideoController r101 = this.f488069c;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        if (this.f488072f != r100.getAdapterPosition()) goto L14;
        return;
    L7:
        if (r101.p3() != true) goto L9;
        r102 = true;
    L14:
        WeakReference<CreationVideoViewHolder> r103 = this.f488071e;
        if (r103 == null) goto L19;
        CreationVideoViewHolder r104 = r103.get();
        if (r104 == null) goto L19;
        int r105 = r104.getAdapterPosition();
    L20:
        this.f488072f = r105;
        IVideoController r106 = this.f488069c;
        if (r106 == null) goto L23;
        r106.release();
    L23:
        IVideoController r107 = null;
        this.f488069c = null;
        Lazy r108 = q3.f365794a;
        IVideoController r109 = q3.b(this.f488067a, null, 6);
        if (r109 == null) goto L26;
        o r110 = (o) r109;
        r110.setSubTag(this.f488068b);
        r107 = r109;
    L26:
        this.f488069c = r107;
        VideoPlayView r111 = r100.f330018j;
        if (r107 != null) goto L29;
        r111.getClass();
    L35:
        boolean r112 = m29.a.f511679a;
        UserCreation r113 = r100.f330022n;
        if (r113 == null) goto L41;
        Long r114 = r113.f364999m;
        if (r114 == null) goto L41;
        String r115 = r114.toString();
        if (r115 == null) goto L41;
    L42:
        m29.a.c("onCardDisplay", r115);
        y.c(new l0(r100));
        return;
    L41:
        r115 = "";
        goto L42
    L29:
        if (r107 == r111.C) goto L31;
        r111.N();
    L31:
        r111.C = r107;
        ((o) r107).setLooping(true);
        IVideoController r116 = r111.C;
        if (r116 == null) goto L35;
        r116.C(r111.f327998s);
    L19:
        r105 = -1;
        goto L20
    }

    public f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "videoEngineTag");
        Intrinsics.checkNotNullParameter(r101, "videoEngineSubTag");
        this.f488067a = r100;
        this.f488068b = r101;
        this.f488070d = new ConcurrentLinkedQueue();
        this.f488072f = -1;
    }
}
