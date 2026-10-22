package com.bytedance.ee.bear.drive.biz.comment.data;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final ArrayMap<String, Integer> a = null;
    public static final ArrayMap<Integer, String> b = null;

    static {
        ArrayMap<String, Integer> r0 = new ArrayMap(1);
        a = r0;
        ArrayMap<Integer, String> r2 = new ArrayMap(1);
        b = r2;
        r2.put(2131888387, "common.comment");
        r2.put(2131888441, "comment.quote.text");
        r2.put(2131888440, "comment.quote.page");
        r0.put("common.comment", 2131888387);
        r0.put("comment.quote.text", 2131888441);
        r0.put("comment.quote.page", 2131888440);
    }

    public static ArrayList<CommentRectF> a(ArrayList<AreaCommentFetcher.AreaComment> r3) {
        ArrayList<CommentRectF> r0 = new ArrayList();
        Iterator<AreaCommentFetcher.AreaComment> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        AreaCommentFetcher.AreaComment r1 = r4.next();
        CommentRectF r2 = CommentRectF.a(r1.getCommentId(), r1.getAreaCoordinate());
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public static String b(Context r9, String r10) {
        if (r10 != null) goto L55;
        return null;
    L55:
        CommentQuote r11 = (CommentQuote) JSON.parseObject(r10, CommentQuote.class);     // Catch: Exception -> L8
    L10:
        if (r11 != null) goto L13;
        tt5.a.d("CommentDataUtils", "decodeCommentQuote, failed to parse json to CommentQuote.");
        return null;
    L13:
        Integer r3 = (Integer) a.get(r11.getKey());
        if (r3 != null) goto L17;
        tt5.a.d("CommentDataUtils", "decodeCommentQuote, quote key resId not found, key: " + r11.getKey());
        return null;
    L17:
        String[] r12 = r11.getParams();
        int r7 = -1;
        if (r3.intValue() != 2131888441) goto L35;
        if (r12 != null) goto L21;
    L29:
        if (r12 == null) goto L32;
        r7 = r12.length;
    L32:
        tt5.a.d("CommentDataUtils", "decodeCommentQuote, quote type is text, but params invalid, paramsLength: " + r7);
        return null;
    L21:
        if (r12.length < 2) goto L29;
        HashMap r4 = new HashMap(2);
        r4.put("page", r12[0]);
        r4.put("text", r12[1]);
        return xo5.a.d(r9, r3.intValue(), r4);
    L26:
        e = move-exception;
        tt5.a.e("CommentDataUtils", "decodeCommentQuote, quote type is text, but format error: ", e, false);
        return null;
    L35:
        if (r3.intValue() != 2131888440) goto L50;
        if (r12 != null) goto L38;
    L45:
        if (r12 == null) goto L48;
        r7 = r12.length;
    L48:
        tt5.a.d("CommentDataUtils", "decodeCommentQuote, quote type is page, but params invalid, paramsLength: " + r7);
        return null;
    L38:
        if (r12.length < 1) goto L45;
        return xo5.a.c(r9, r3.intValue(), "page", r12[0]);
    L42:
        e = move-exception;
        tt5.a.e("CommentDataUtils", "decodeCommentQuote, quote type is page, but format error: ", e, false);
        return null;
    L50:
        if (r12 != null) goto L54;
        return r9.getString(r3.intValue());
    L54:
        return r9.getString(r3.intValue(), r12);
    L8:
        e = move-exception;
        tt5.a.e("CommentDataUtils", "decodeCommentQuote, error when parsing json to CommentQuote: ", e, false);
        r11 = null;
        goto L10
    }
}
