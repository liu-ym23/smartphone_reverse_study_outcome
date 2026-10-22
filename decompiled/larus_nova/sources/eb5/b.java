package eb5;

import com.bytedance.lark.pb.space.doc.v1.SegmentData;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import db5.j;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Function<List<? extends SegmentData>, db5.a> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final db5.a apply(List<? extends SegmentData> r310) {
        List<? extends SegmentData> r100 = r310;
        Intrinsics.checkNotNullParameter(r100, DBDefinition.SEGMENT_TABLE_NAME);
        StringBuilder r101 = new StringBuilder();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L20;
        SegmentData r106 = (SegmentData) r104.next();
        String r107 = r106.text;
        if (r107 == null) goto L7;
        r101.append(r107);
        int r110 = r105 + r106.text.length();
        String r108 = r106.type;
        if (Intrinsics.areEqual(r108, "mention") == false) goto L14;
        int r109 = r106.mention_type.intValue();
        String r111 = r106.token;
        String r112 = r106.link;
        String r113 = r106.text;
        String r114 = r106.name;
        String r115 = r106.en_name;
        if (r115 != null) goto L13;
        r115 = "";
    L13:
        int r311 = r110;
        r102.add(new bo4.a(r105, r110, r109, -1, r111, r112, r113, r114, r115, null, null, r106.icon_info, null, null, 0, false, null, true, false, "", "", null, null, null, 0));
    L17:
        int r116 = r311;
    L18:
        r105 = r116;
        goto L4
    L14:
        r311 = r110;
        if (Intrinsics.areEqual(r108, "url") == false) goto L17;
        r116 = r311;
        r103.add(new j(r105, r116, r106.text, r106.link));
        goto L18
    L7:
        tt5.a.h("SegmentDataToAtContent", "segmentsToAtContent error path. segment.text is null: " + r100.size() + ". " + r106.type + ' ');
        goto L4
    L20:
        return new db5.a(r101.toString(), (bo4.a[]) r102.toArray(new bo4.a[0]), (j[]) r103.toArray(new j[0]));
    }
}
