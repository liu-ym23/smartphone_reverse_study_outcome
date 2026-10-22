package mr9;

import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import yc9.l1;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final FlowResourceType a(UplinkFileEntity r100) {
        if (l1.j(r100) == true) goto L24;
        boolean r101 = false;
        if (r100 == null) goto L14;
        Integer r102 = r100.getEntityType();
        int r103 = UplinkEntityType.EntityTypeImage.getValue();
        if (r102 == null) goto L14;
        if (r102.intValue() != r103) goto L14;
        r101 = true;
    L14:
        if (r101 == false) goto L17;
        return FlowResourceType.Image;
    L17:
        if (l1.i(r100) == false) goto L20;
        return FlowResourceType.Audio;
    L20:
        if (l1.n(r100) == false) goto L23;
        return FlowResourceType.Video;
    L23:
        return FlowResourceType.Unknown;
    L24:
        return FlowResourceType.File;
    }
}
