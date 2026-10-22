package eb5;

import android.text.TextUtils;
import com.bytedance.lark.pb.space.doc.v1.SegmentData;
import db5.j;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Function<db5.a, List<? extends SegmentData>> {
    public a() {
    }

    @Override // io.reactivex.functions.Function
    public final List<? extends SegmentData> apply(db5.a r110) {
        db5.a r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "atContent");
        ArrayList r101 = new ArrayList();
        String r102 = r100.f467804a;
        bo4.a[] r103 = r100.f467805b;
        j[] r104 = r100.f467806c;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L4:
        if (r105 >= r103.length) goto L6;
    L12:
        j r111 = null;
        if (r105 >= r103.length) goto L15;
        bo4.a r108 = r103[r105];
    L17:
        if (r106 >= r104.length) goto L19;
        r111 = r104[r106];
    L19:
        boolean r112 = true;
        if (r111 != null) goto L22;
        boolean r113 = true;
    L23:
        if (r111 == null) goto L30;
        if (r108 == null) goto L30;
        if (r108.f19811a < r111.f467826a) goto L29;
        r112 = false;
    L29:
        r113 = r112;
    L30:
        if (r113 == false) goto L48;
        if (r108 == null) goto L48;
        int r114 = r108.f19811a;
        if (r114 > r107) goto L34;
        if (r114 >= r107) goto L37;
        r105 = r105 + 1;
    L37:
        String r109 = r108.f19817g;
        String r115 = r108.f19816f;
        String r116 = r108.f19834x;
        String r117 = r108.f19815e;
        int r118 = r108.f19813c;
        boolean r119 = r108.f19827q;
        Intrinsics.checkNotNull(r109);
        Intrinsics.checkNotNull(r115);
        Intrinsics.checkNotNull(r117);
        String r120 = r108.f19819i;
        String r121 = r108.f19820j;
        String r122 = r108.f19823m;
        j[] r123 = r104;
        SegmentData.Builder r124 = new SegmentData.Builder();
        bo4.a[] r125 = r103;
        r124.type = "mention";
        r124.text = r109;
        r124.link = r115;
        r124.token = r117;
        r124.name = r120;
        r124.en_name = r121;
        r124.category = "at-user-block";
        r124.mention_type = Integer.valueOf(r118);
        r124.mention_notify = Boolean.valueOf(r119);
        if (r116 != null) goto L40;
        r116 = "";
    L40:
        r124.icon_info = r116;
        if (r118 == 0) goto L43;
    L47:
        r101.add(r124.build());
        r105 = r105 + 1;
        r107 = r108.f19812b;
    L56:
        r104 = r123;
        r103 = r125;
        goto L4
    L43:
        if (TextUtils.isEmpty(r115) == false) goto L47;
        if (TextUtils.isEmpty(r122) == true) goto L47;
        r124.link = r122;
        goto L47
    L34:
        Intrinsics.checkNotNull(r102);
        String r126 = r102.substring(r107, r108.f19811a);
        SegmentData.Builder r127 = new SegmentData.Builder();
        r127.type = "text";
        r127.text = r126;
        r101.add(r127.build());
    L48:
        r123 = r104;
        r125 = r103;
        if (r111 == null) goto L56;
        int r128 = r111.f467826a;
        if (r128 <= r107) goto L53;
        Intrinsics.checkNotNull(r102);
        String r129 = r102.substring(r107, r111.f467826a);
        SegmentData.Builder r130 = new SegmentData.Builder();
        r130.type = "text";
        r130.text = r129;
        r101.add(r130.build());
    L55:
        String r131 = r111.f467828c;
        String r132 = r111.f467829d;
        SegmentData.Builder r133 = new SegmentData.Builder();
        r133.type = "url";
        r133.text = r131;
        r133.link = r132;
        r101.add(r133.build());
        r106 = r106 + 1;
        r107 = r111.f467827b;
        goto L56
    L53:
        if (r128 >= r107) goto L55;
        r106 = r106 + 1;
        goto L56
    L22:
        r113 = false;
        goto L23
    L15:
        r108 = null;
        goto L17
    L6:
        if (r106 < r104.length) goto L12;
        if (r107 >= r102.length()) goto L11;
        Intrinsics.checkNotNull(r102);
        String r134 = r102.substring(r107);
        SegmentData.Builder r135 = new SegmentData.Builder();
        r135.type = "text";
        r135.text = r134;
        r101.add(r135.build());
    L11:
        return r101;
    }
}
