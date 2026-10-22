package gkc;

import android.webkit.URLUtil;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.lark.android.avatar.ui.AvatarSource;

/* JADX INFO: loaded from: classes40.dex */
public final class c {
    public static PhotoItem a(String r100, String r101, AvatarSource r102) {
        Log.i("PhotoGenerator", "getPhotoItemForAvatar, key:" + r100 + ",entityId:" + r101 + ",source:" + r102);
        if (URLUtil.isNetworkUrl(r100) == false) goto L6;
        PhotoItem r103 = new PhotoItem().setLoadModel(r100);
    L9:
        r103.setEntityId(r101);
        return r103;
    L6:
        if (r102 != AvatarSource.EDIT_ALIAS) goto L8;
        r103 = new PhotoItem().setLoadModel(new EncryptImage(r100)).setType(3);
        goto L9
    L8:
        r103 = new PhotoItem().setLoadModel(AvatarImage.Builder.obtain(r100, r101, 640, 640).build()).setType(4);
        goto L9
    }
}
