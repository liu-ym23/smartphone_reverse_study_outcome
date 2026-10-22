package tt0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f547512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f547513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f547514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f547515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f547516e;

    public c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f547516e = r100;
        LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_new_profile_gift_exhibition_view_holder, r100, true);
        this.f547512a = (TextView) r100.findViewById(R.id.profile_gift_exhibition_light);
        this.f547513b = (TextView) r100.findViewById(R.id.profile_gift_exhibition_line);
        this.f547514c = (TextView) r100.findViewById(R.id.profile_gift_exhibition_total);
        this.f547515d = (ImageView) r100.findViewById(R.id.profile_gift_exhibition_found_all_icon);
    }
}
