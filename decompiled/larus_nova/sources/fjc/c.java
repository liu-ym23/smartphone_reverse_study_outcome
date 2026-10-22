package fjc;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public final class c {
    public static Resolution a(String r100) {
        Resolution[] r101 = Resolution.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        Resolution r104 = r101[r103];
        if (TextUtils.equals(r100, r104.toString(VideoRef.TYPE_VIDEO)) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return Resolution.Standard;
    }

    public static SparseArray<VideoInfo> b(VideoRef r100) {
        SparseArray<VideoInfo> r101 = new SparseArray();
        if (r100 != null) goto L5;
    L22:
        return r101;
    L5:
        if (r100.getVideoInfoList() == null) goto L22;
        Iterator<VideoInfo> r102 = r100.getVideoInfoList().iterator();
    L9:
        if (r102.hasNext() == false) goto L22;
        VideoInfo r103 = r102.next();
        if (r103 != null) goto L13;
        int r104 = Resolution.Undefine.getIndex();
    L20:
        if (r104 < 0) goto L9;
        r101.put(r104, r103);
        goto L9
    L13:
        String r105 = r103.getValueStr(7);
        Resolution[] r106 = Resolution.getAllResolutions();
        int r107 = r106.length;
        int r108 = 0;
    L14:
        if (r108 >= r107) goto L19;
        Resolution r109 = r106[r108];
        if (r109.toString(VideoRef.TYPE_VIDEO).equals(r105) == true) goto L17;
        r108 = r108 + 1;
        goto L14
    L17:
        r104 = r109.getIndex();
        goto L20
    L19:
        r104 = Resolution.Undefine.getIndex();
        goto L20
    }
}
