package wy8;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.api.params.VideoParam;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.api.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    public static final List<o> a(CameraOutputContext r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        List<OutputParam> r100 = r110.getOutputParamList();
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L60;
        OutputParam r103 = (OutputParam) r102.next();
        o r104 = null;
        if (r103 != null) goto L12;
    L58:
        if (r104 == null) goto L7;
        r101.add(r104);
        goto L7
    L12:
        if (r103.getResultType() != OutputParam.ResultType.VIDEO) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L19;
        VideoParam r106 = r103.getVideoParam();
        if (r106 == null) goto L22;
        String r107 = r106.getPath();
    L23:
        if (r107 == null) goto L58;
        if ((true ^ StringsKt.isBlank(r107)) == false) goto L27;
        String r111 = r107;
    L28:
        if (r111 == null) goto L58;
        if (r105 == false) goto L32;
        PreviewMediaType r108 = PreviewMediaType.VIDEO;
    L33:
        PreviewMediaType r112 = r108;
        if (r105 == false) goto L38;
        VideoParam r109 = r103.getVideoParam();
        if (r109 == null) goto L42;
        int r113 = r109.getWidth();
    L41:
        int r114 = r113;
    L43:
        if (r105 == false) goto L47;
        VideoParam r115 = r103.getVideoParam();
        if (r115 == null) goto L51;
        int r116 = r115.getHeight();
    L50:
        int r117 = r116;
    L52:
        if (r105 == false) goto L56;
        VideoParam r118 = r103.getVideoParam();
        if (r118 == null) goto L56;
        long r119 = r118.getDuration();
    L57:
        r104 = new o(r111, r111, r112, null, r114, r117, r119, 8);
    L56:
        r119 = 0;
    L51:
        r117 = 0;
        goto L52
    L47:
        ImageParam r120 = r103.getImageParam();
        if (r120 == null) goto L51;
        r116 = r120.getHeight();
    L42:
        r114 = 0;
        goto L43
    L38:
        ImageParam r121 = r103.getImageParam();
        if (r121 == null) goto L42;
        r113 = r121.getWidth();
        goto L41
    L32:
        r108 = PreviewMediaType.IMAGE;
        goto L33
    L27:
        r111 = null;
    L22:
        r107 = null;
        goto L23
    L19:
        ImageParam r122 = r103.getImageParam();
        if (r122 == null) goto L22;
        r107 = r122.getPath();
        goto L23
    L14:
        r105 = false;
        goto L15
    L60:
        return r101;
    }
}
