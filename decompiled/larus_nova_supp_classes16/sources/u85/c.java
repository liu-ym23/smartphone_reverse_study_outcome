package u85;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final ArrayMap<MimeTypeCategory, Boolean> a = null;

    static {
        ArrayMap<MimeTypeCategory, Boolean> r0 = new ArrayMap(6);
        a = r0;
        MimeTypeCategory r1 = MimeTypeCategory.DOCUMENT;
        Boolean r2 = Boolean.FALSE;
        r0.put(r1, r2);
        r0.put(MimeTypeCategory.VIDEO, r2);
        r0.put(MimeTypeCategory.AUDIO, r2);
        r0.put(MimeTypeCategory.IMAGE, Boolean.TRUE);
    }

    public static SpaceFileOpenEntity a(Document r3) {
        String r0 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.a(com.bytedance.ee.bear.search.b.class)).d(r3.a);
        SpaceFileOpenEntity r1 = new SpaceFileOpenEntity(r3.d, r0);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L5;
        r1.setBizScene(DriveBizScene.DriveBizScene_CCM);
        r1.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
    L5:
        r1.setFileExt(r3.F);
        r1.setUrl(r3.p);
        r1.setMountNodeToken(r3.Q);
        r1.setMountPoint(r3.R);
        r1.setHasSpaceCache(r3.w);
        if (TextUtils.isEmpty(r3.R) == false) goto L8;
        String r4 = FileInfoPuller.CALLER_EXPLORER;
    L9:
        r1.setMountPoint(r4);
        return r1;
    L8:
        r4 = r3.R;
        goto L9
    }
}
