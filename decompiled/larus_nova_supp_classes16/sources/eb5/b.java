package eb5;

import com.bytedance.lark.pb.space.doc.v1.SegmentData;
import db5.j;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Function<List<? extends SegmentData>, db5.a> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final Object apply(Object r34) {
        List r0 = (List) r34;
        Intrinsics.checkNotNullParameter(r0, "segments");
        StringBuilder r1 = new StringBuilder();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
        int r7 = 0;
    L4:
        if (r4.hasNext() == false) goto L20;
        SegmentData r6 = (SegmentData) r4.next();
        String r8 = r6.text;
        if (r8 == null) goto L7;
        r1.append(r8);
        int r16 = r7 + r6.text.length();
        String r9 = r6.type;
        if (Intrinsics.areEqual(r9, "mention") == false) goto L14;
        int r10 = r6.mention_type.intValue();
        String r11 = r6.token;
        String r12 = r6.link;
        String r13 = r6.text;
        String r14 = r6.name;
        String r17 = r6.en_name;
        if (r17 != null) goto L13;
        r17 = "";
    L13:
        int r32 = r16;
        r2.add(new bo4.a(r7, r16, r10, -1, r11, r12, r13, r14, r17, null, null, r6.icon_info, null, null, 0, false, null, true, false, "", "", null, null, null, 0));
    L17:
        int r18 = r32;
    L18:
        r7 = r18;
        goto L4
    L14:
        r32 = r16;
        if (Intrinsics.areEqual(r9, "url") == false) goto L17;
        r18 = r32;
        r3.add(new j(r7, r18, r6.text, r6.link));
        goto L18
    L7:
        tt5.a.h("SegmentDataToAtContent", "segmentsToAtContent error path. segment.text is null: " + r0.size() + ". " + r6.type + ' ');
        goto L4
    L20:
        return new db5.a(r1.toString(), (bo4.a[]) r2.toArray(new bo4.a[0]), (j[]) r3.toArray(new j[0]));
    }
}
