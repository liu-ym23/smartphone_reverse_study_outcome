package xk1;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public static VideoInfo a(String r100, VideoRef r101) {
        VideoInfo r102 = null;
        if (TextUtils.isEmpty(r100) == true) goto L17;
        List<VideoInfo> r103 = r101.getVideoInfoList();
        if (r103 == null) goto L17;
        if (r103.size() == 0) goto L17;
        Iterator<VideoInfo> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        VideoInfo r105 = r104.next();
        if (r100.equals(r105.mDefinition) == false) goto L12;
    L18:
        if (r105 != null) goto L37;
        if (r101 == null) goto L21;
        List<VideoInfo> r106 = r101.getValueList(5);
    L22:
        if (r106 == null) goto L30;
        Iterator<VideoInfo> r107 = r106.iterator();
    L25:
        if (r107.hasNext() == false) goto L30;
        VideoInfo r108 = r107.next();
        if (r108 == null) goto L25;
        r102 = r108;
    L30:
        return r102;
    L21:
        r106 = null;
        goto L22
    L37:
        return r105;
    L16:
        r105 = (VideoInfo) ListProtector.get(r103, 0);
    L17:
        r105 = null;
        goto L18
    }
}
