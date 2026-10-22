package tt0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f547517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f547518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f547519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f547520d;

    public d(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f547520d = r100;
        LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_new_profile_subscribe_view_holder, r100, true);
        this.f547517a = r100.findViewById(R.id.profile_subscribe_count_layout);
        this.f547518b = (TextView) r100.findViewById(R.id.profile_subscribe_count);
        this.f547519c = (TextView) r100.findViewById(R.id.profile_subscribe_count_suffix);
    }
}
