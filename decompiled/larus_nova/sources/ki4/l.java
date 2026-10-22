package ki4;

import android.content.res.Resources;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l {
    private static final Resources getResources() {
        return AppHost.f326268a.getApplication().getResources();
    }

    public static y a() {
        String r100 = getResources().getString(R.string.larus_videoSum_upload_tab_all);
        Intrinsics.checkNotNullParameter(r100, "name");
        return new y(r100, BuiltInMaterialType.ALL);
    }

    public static y b() {
        String r100 = getResources().getString(R.string.larus_videoSum_upload_tab_image);
        Intrinsics.checkNotNullParameter(r100, "name");
        return new y(r100, BuiltInMaterialType.IMAGE);
    }

    public static y c() {
        String r100 = getResources().getString(R.string.larus_videoSum_upload_tab_video);
        Intrinsics.checkNotNullParameter(r100, "name");
        return new y(r100, BuiltInMaterialType.VIDEO);
    }
}
