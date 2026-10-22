package mv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerPlaceHolderViewHolder;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements b90.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.feed.j f515839a;

    public b(com.bytedance.android.livesdk.feed.tab.repository.l r100) {
        this.f515839a = r100;
    }

    @Override // b90.a
    public final BaseViewHolder<Object> a(ViewGroup r100, Object[] r101) {
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_feed_drawer_place_holder, r100, false);
        if (r101.length != 0) goto L5;
        boolean r103 = true;
    L7:
        if ((!r103) == false) goto L15;
        Object r104 = r101[0];
        if ((r104 instanceof l) == false) goto L15;
        if (r104 == null) goto L13;
        ((l) r104).a();
        goto L15
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L15:
        if (r101.length <= 4) goto L23;
        Object r105 = r101[4];
        if ((r105 instanceof PublishSubject) == false) goto L23;
        if (r105 == null) goto L21;
        PublishSubject r106 = (PublishSubject) r105;
        goto L23
    L21:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L23:
        return new DrawerPlaceHolderViewHolder(r102, this.f515839a);
    L5:
        r103 = false;
        goto L7
    }
}
