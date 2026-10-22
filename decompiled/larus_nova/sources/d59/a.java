package d59;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.google.gson.annotations.SerializedName;
import com.larus.account.base.api.ILoginService;
import com.larus.dora.impl.dynamic.s1;
import com.larus.dora.impl.dynamic.t1;
import com.larus.dora.impl.util.b0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/dynamic/entity/BannerEntity;", "Lcom/larus/dora/impl/dynamic/entity/ICardProtocol;", "<init>", "()V", "title", "Lcom/larus/dora/impl/dynamic/Identifier;", "getTitle", "()Lcom/larus/dora/impl/dynamic/Identifier;", "subtitle", "getSubtitle", "imageLink", "Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "getImageLink", "()Lcom/larus/dora/impl/dynamic/ImageIdentifier;", "actionUrl", "", "getActionUrl", "()Ljava/lang/String;", "shouldVisible", "", PTYSocketStateCallback.CONNECTED, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a implements j {

    @SerializedName("action_url")
    private final String actionUrl;

    @SerializedName("image_link")
    private final t1 imageLink;

    @SerializedName("subtitle")
    private final s1 subtitle;

    @SerializedName("title")
    private final s1 title;

    public a() {
    }

    @Override // d59.j
    public final boolean a(boolean r100) {
        if (r100 == true) goto L5;
        return false;
    L5:
        String r101 = ILoginService.f286097a.getAccountInfo().f531530c;
        b0.f338123a.getClass();
        if (b0.f(r101) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
