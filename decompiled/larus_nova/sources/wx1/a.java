package wx1;

import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.live.base.model.ImageModel;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static User a(com.bytedance.android.livesdk.user.f r100) {
        User r101 = new User();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.setNickName(r100.b().getNickName());
        r101.setAvatarThumb(b((ImageModel) r100.b().getAvatarThumb()));
        r101.setAvatarMedium(b((ImageModel) r100.b().getAvatarMedium()));
        r101.setAvatarLarge(b((ImageModel) r100.b().getAvatarLarge()));
        r101.setIdStr(r100.n());
        r101.setId(r100.b().getUserId());
        return r101;
    }

    public static com.bytedance.android.gamecp.host_api.model.ImageModel b(ImageModel r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.gamecp.host_api.model.ImageModel r101 = new com.bytedance.android.gamecp.host_api.model.ImageModel();
        r101.setWidth(r100.getWidth());
        r101.setHeight(r100.getHeight());
        r101.setUri(r100.getUri());
        r101.setUrls(r100.getUrls());
        return r101;
    }
}
