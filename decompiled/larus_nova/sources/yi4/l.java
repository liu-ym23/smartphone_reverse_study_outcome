package yi4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.creativex.mediaimport.view.internal.base.p;
import com.larus.nova.R;
import ki4.r;
import kotlin.jvm.internal.Intrinsics;
import ti4.m;

/* JADX INFO: loaded from: classes15.dex */
public final class l extends p<r> {
    @Override // com.bytedance.creativex.mediaimport.view.internal.base.p
    public final TextView e(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        TextView r101 = super.e(r100);
        if (r101 == null) goto L5;
        ci4.a.a(r101, true);
        return r101;
    L5:
        return null;
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.p
    public final ViewGroup f(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_tools_media_import_single_confirm_view, r100, true);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) r101;
    }

    public l(ViewGroup r100, LifecycleOwner r101, m<r> r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r104, "confirmText");
        super(r100, r101, r102, r103, r104);
    }
}
