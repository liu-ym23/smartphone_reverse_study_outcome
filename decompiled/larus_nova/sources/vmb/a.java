package vmb;

import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;

/* JADX INFO: loaded from: classes36.dex */
public interface a extends IOfficeSDKCapacity {
    s M(FlowMixedFeedFragment r100);

    com.ss.android.lark.flow.feed.data.a Q();

    String t();

    s t0(ViewModelStoreOwner r100);

    l w();
}
