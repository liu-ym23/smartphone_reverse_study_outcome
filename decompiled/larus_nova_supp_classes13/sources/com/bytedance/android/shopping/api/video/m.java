package com.bytedance.android.shopping.api.video;

import com.bytedance.android.ec.model.video.BitRate;
import com.bytedance.android.ec.model.video.ECBaseVideo;
import com.bytedance.android.ec.model.video.UrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public m() {
    }

    static {
    }

    public static e b(ECBaseVideo r27, d r28) {
        Intrinsics.checkNotNullParameter(r27, "videoInfo");
        long r2 = r27.getDuration();
        ArrayList r5 = new ArrayList();
        b r0 = a(r27.getH265PlayAddr(), r2, true);
        if (r0 == null) goto L5;
        r5.add(r0);
    L5:
        b r1 = a(r27.getPlayAddr(), r2, false);
        if (r1 == null) goto L8;
        r5.add(r1);
    L8:
        ArrayList r6 = new ArrayList();
        List r3 = r27.getBitRate();
        String r7 = "";
        if (r3 == null) goto L41;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L41;
        BitRate r8 = (BitRate) r4.next();
        if (r8 == null) goto L18;
        UrlModel r9 = r8.getPlayAddr();
        if (r9 == null) goto L18;
        String r11 = r9.getUri();
        if (r11 != null) goto L22;
        String r17 = "";
    L23:
        String r12 = r9.getUrlKey();
        if (r12 != null) goto L26;
        String r18 = "";
    L27:
        int r19 = r8.getBitRate();
        if (r8.isH265() != 1) goto L30;
        CodecType r13 = CodecType.CODEC_TYPE_265;
    L31:
        CodecType r20 = r13;
        List r14 = r9.getUrlList();
        if (r14 != null) goto L34;
        r14 = CollectionsKt.emptyList();
    L34:
        List r21 = r14;
        long r22 = r9.getSize();
        int r10 = (int) r2;
        String r15 = r8.getGearName();
        if (r15 != null) goto L37;
        String r25 = "";
    L38:
        b r16 = new b(r17, r18, r19, r20, r21, r22, r10, r25, r8.getQualityType());
    L39:
        if (r16 == null) goto L12;
        r6.add(r16);
        goto L12
    L37:
        r25 = r15;
        goto L38
    L30:
        r13 = CodecType.CODEC_TYPE_264;
        goto L31
    L26:
        r18 = r12;
        goto L27
    L22:
        r17 = r11;
    L18:
        r16 = null;
    L41:
        String r23 = r27.getVideoId();
        if (r23 == null) goto L45;
        r7 = r23;
    L45:
        long r24 = r27.getDuration();
        String r26 = r27.getRatio();
        long r29 = r27.getCdnUrlExpired();
        float r110 = r27.getWidth() / r27.getHeight();
    L50:
        return new e(r7, r24, r26, r5, r6, r28, r29, r110, r27.getVideoThumbs(), r27.getHeight(), r27.getWidth(), null, null);
    L48:
        r110 = 0.0f;
        goto L50
    }

    public static b a(UrlModel r12, long r13, boolean r15) {
        if (r12 != null) goto L5;
        return null;
    L5:
        String r0 = r12.getUri();
        if (r0 != null) goto L8;
        String r2 = "";
    L9:
        String r1 = r12.getUrlKey();
        if (r1 != null) goto L12;
        String r3 = "";
    L13:
        if (r15 == false) goto L15;
        CodecType r16 = CodecType.CODEC_TYPE_265;
    L16:
        CodecType r4 = r16;
        List r17 = r12.getUrlList();
        if (r17 != null) goto L19;
        r17 = CollectionsKt.emptyList();
    L19:
        String r5 = r2;
        String r6 = r3;
        return new b(r5, r6, 0, r4, r17, r12.getSize(), (int) r13, "", 0);
    L15:
        r16 = CodecType.CODEC_TYPE_264;
        goto L16
    L12:
        r3 = r1;
        goto L13
    L8:
        r2 = r0;
        goto L9
    }
}
