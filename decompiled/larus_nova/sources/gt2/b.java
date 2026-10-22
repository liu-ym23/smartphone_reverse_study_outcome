package gt2;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.livehostapi.business.depend.share.ConversationCoreInfo;
import com.bytedance.android.livesdk.share.adapter.FansGroupAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FansGroupAdapter f482501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConversationCoreInfo f482502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FansGroupAdapter.FansGroupViewHolder f482503c;

    public b(FansGroupAdapter r100, ConversationCoreInfo r101, FansGroupAdapter.FansGroupViewHolder r102) {
        this.f482501a = r100;
        this.f482502b = r101;
        this.f482503c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ConversationCoreInfo r101 = this.f482502b;
        boolean r102 = !r101.isChosen;
        r101.isChosen = r102;
        FansGroupAdapter r103 = this.f482501a;
        FansGroupAdapter.FansGroupViewHolder r104 = this.f482503c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "holder");
        ImageView r105 = r104.f158083d;
        if (r102 == false) goto L5;
        int r106 = 0;
    L6:
        r105.setVisibility(r106);
        ConversationCoreInfo r107 = this.f482502b;
        if (r107.isChosen == false) goto L9;
        this.f482501a.f158077b.add(r107.conId);
    L10:
        FansGroupAdapter r108 = this.f482501a;
        FansGroupAdapter.b r109 = r108.f158076a;
        if (r109 == null) goto L14;
        r109.a(r108.f158077b);
        return;
    L14:
        return;
    L9:
        this.f482501a.f158077b.remove(r107.conId);
        goto L10
    L5:
        r106 = 8;
        goto L6
    }
}
