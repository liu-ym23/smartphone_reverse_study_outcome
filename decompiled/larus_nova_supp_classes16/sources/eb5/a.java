package eb5;

import android.text.TextUtils;
import com.bytedance.lark.pb.space.doc.v1.SegmentData;
import db5.j;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Function<db5.a, List<? extends SegmentData>> {
    public a() {
    }

    public final Object apply(Object r19) {
        db5.a r0 = (db5.a) r19;
        Intrinsics.checkNotNullParameter(r0, "atContent");
        ArrayList r1 = new ArrayList();
        String r2 = r0.a;
        bo4.a[] r3 = r0.b;
        j[] r4 = r0.c;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L4:
        if (r5 >= r3.length) goto L6;
    L12:
        j r10 = null;
        if (r5 >= r3.length) goto L15;
        bo4.a r8 = r3[r5];
    L17:
        if (r6 >= r4.length) goto L19;
        r10 = r4[r6];
    L19:
        boolean r11 = true;
        if (r10 != null) goto L22;
        boolean r12 = true;
    L23:
        if (r10 == null) goto L30;
        if (r8 == null) goto L30;
        if (r8.a < r10.a) goto L29;
        r11 = false;
    L29:
        r12 = r11;
    L30:
        if (r12 == false) goto L48;
        if (r8 == null) goto L48;
        int r13 = r8.a;
        if (r13 > r7) goto L34;
        if (r13 >= r7) goto L37;
        r5 = r5 + 1;
    L37:
        String r9 = r8.g;
        String r14 = r8.f;
        String r16 = r8.x;
        String r17 = r8.e;
        int r18 = r8.c;
        boolean r110 = r8.q;
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r17);
        String r111 = r8.i;
        String r112 = r8.j;
        String r20 = r8.m;
        j[] r113 = r4;
        SegmentData.Builder r21 = new SegmentData.Builder();
        bo4.a[] r114 = r3;
        r21.type = "mention";
        r21.text = r9;
        r21.link = r14;
        r21.token = r17;
        r21.name = r111;
        r21.en_name = r112;
        r21.category = "at-user-block";
        r21.mention_type = Integer.valueOf(r18);
        r21.mention_notify = Boolean.valueOf(r110);
        if (r16 != null) goto L40;
        r16 = "";
    L40:
        r21.icon_info = r16;
        if (r18 == 0) goto L43;
    L47:
        r1.add(r21.build());
        r5 = r5 + 1;
        r7 = r8.b;
    L56:
        r4 = r113;
        r3 = r114;
        goto L4
    L43:
        if (TextUtils.isEmpty(r14) == false) goto L47;
        if (TextUtils.isEmpty(r20) == true) goto L47;
        r21.link = r20;
        goto L47
    L34:
        Intrinsics.checkNotNull(r2);
        String r22 = r2.substring(r7, r8.a);
        SegmentData.Builder r115 = new SegmentData.Builder();
        r115.type = "text";
        r115.text = r22;
        r1.add(r115.build());
    L48:
        r113 = r4;
        r114 = r3;
        if (r10 == null) goto L56;
        int r23 = r10.a;
        if (r23 <= r7) goto L53;
        Intrinsics.checkNotNull(r2);
        String r24 = r2.substring(r7, r10.a);
        SegmentData.Builder r26 = new SegmentData.Builder();
        r26.type = "text";
        r26.text = r24;
        r1.add(r26.build());
    L55:
        String r27 = r10.c;
        String r28 = r10.d;
        SegmentData.Builder r29 = new SegmentData.Builder();
        r29.type = "url";
        r29.text = r27;
        r29.link = r28;
        r1.add(r29.build());
        r6 = r6 + 1;
        r7 = r10.b;
        goto L56
    L53:
        if (r23 >= r7) goto L55;
        r6 = r6 + 1;
        goto L56
    L22:
        r12 = false;
        goto L23
    L15:
        r8 = null;
        goto L17
    L6:
        if (r6 < r4.length) goto L12;
        if (r7 >= r2.length()) goto L11;
        Intrinsics.checkNotNull(r2);
        String r30 = r2.substring(r7);
        SegmentData.Builder r31 = new SegmentData.Builder();
        r31.type = "text";
        r31.text = r30;
        r1.add(r31.build());
    L11:
        return r1;
    }
}
