package in7;

import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.PermissionType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;

/* JADX INFO: loaded from: classes22.dex */
public interface h {

    public static abstract class a implements h {
        public a() {
        }

        @Override // in7.h
        public final void b(ShareChannelType r100) {
        }

        @Override // in7.h
        public final void c(PermissionType r100, ShareContent r101, String r102) {
        }

        @Override // in7.h
        public final void d(DownloadStatus r100, String r101, ShareContent r102) {
        }
    }

    void a(kn7.b r100);

    void b(ShareChannelType r100);

    void c(PermissionType r100, ShareContent r101, String r102);

    void d(DownloadStatus r100, String r101, ShareContent r102);
}
