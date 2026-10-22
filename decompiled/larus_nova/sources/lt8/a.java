package lt8;

import android.view.View;
import com.larus.bmhome.view.resourcebar.ResourceBarAdapter;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements BaseResourceViewHolder.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResourceBarAdapter f510712a;

    public a(ResourceBarAdapter r100) {
        this.f510712a = r100;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder.a
    public final boolean b(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        FLogger.f375446a.i("ResourceBarAdapter", "onLongClick, key:" + r100);
        BaseResourceViewHolder.a r102 = this.f510712a.f317144b;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.b(r100, r101);
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder.a
    public final void a(String r100, int r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, BaseSwitches.V);
        FLogger.f375446a.i("ResourceBarAdapter", "onClick, key:" + r100 + ", event:" + r101);
        BaseResourceViewHolder.a r103 = this.f510712a.f317144b;
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }
}
