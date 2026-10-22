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

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayMap<MimeTypeCategory, Boolean> f549179a = null;

    static {
        ArrayMap<MimeTypeCategory, Boolean> r100 = new ArrayMap(6);
        f549179a = r100;
        MimeTypeCategory r101 = MimeTypeCategory.DOCUMENT;
        Boolean r102 = Boolean.FALSE;
        r100.put(r101, r102);
        r100.put(MimeTypeCategory.VIDEO, r102);
        r100.put(MimeTypeCategory.AUDIO, r102);
        r100.put(MimeTypeCategory.IMAGE, Boolean.TRUE);
    }

    public static SpaceFileOpenEntity a(Document r100) {
        String r101 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.a(com.bytedance.ee.bear.search.b.class)).d(r100.f227868a);
        SpaceFileOpenEntity r102 = new SpaceFileOpenEntity(r100.f227873d, r101);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L5;
        r102.setBizScene(DriveBizScene.DriveBizScene_CCM);
        r102.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
    L5:
        r102.setFileExt(r100.F);
        r102.setUrl(r100.f227891p);
        r102.setMountNodeToken(r100.Q);
        r102.setMountPoint(r100.R);
        r102.setHasSpaceCache(r100.f227903w);
        if (TextUtils.isEmpty(r100.R) == false) goto L8;
        String r103 = FileInfoPuller.CALLER_EXPLORER;
    L9:
        r102.setMountPoint(r103);
        return r102;
    L8:
        r103 = r100.R;
        goto L9
    }
}
