package com.bytedance.ee.bear.drive.biz.comment.data;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayMap<String, Integer> f222739a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayMap<Integer, String> f222740b = null;

    static {
        ArrayMap<String, Integer> r100 = new ArrayMap(1);
        f222739a = r100;
        ArrayMap<Integer, String> r101 = new ArrayMap(1);
        f222740b = r101;
        Integer r102 = Integer.valueOf(R.string.Drive_Drive_FeedComment);
        r101.put(r102, "common.comment");
        Integer r103 = Integer.valueOf(R.string.Drive_Drive_QuoteText);
        r101.put(r103, "comment.quote.text");
        Integer r104 = Integer.valueOf(R.string.Drive_Drive_QuotePage);
        r101.put(r104, "comment.quote.page");
        r100.put("common.comment", r102);
        r100.put("comment.quote.text", r103);
        r100.put("comment.quote.page", r104);
    }

    public static ArrayList<CommentRectF> a(ArrayList<AreaCommentFetcher.AreaComment> r100) {
        ArrayList<CommentRectF> r101 = new ArrayList();
        Iterator<AreaCommentFetcher.AreaComment> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        AreaCommentFetcher.AreaComment r103 = r102.next();
        CommentRectF r104 = CommentRectF.a(r103.getCommentId(), r103.getAreaCoordinate());
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L8:
        return r101;
    }

    public static String b(Context r100, String r110) {
        if (r110 != null) goto L55;
        return null;
    L55:
        CommentQuote r111 = (CommentQuote) JSON.parseObject(r110, CommentQuote.class);     // Catch: Exception -> L8
    L10:
        if (r111 != null) goto L13;
        tt5.a.d("CommentDataUtils", "decodeCommentQuote, failed to parse json to CommentQuote.");
        return null;
    L13:
        Integer r101 = f222739a.get(r111.getKey());
        if (r101 != null) goto L17;
        tt5.a.d("CommentDataUtils", "decodeCommentQuote, quote key resId not found, key: " + r111.getKey());
        return null;
    L17:
        String[] r112 = r111.getParams();
        int r102 = -1;
        if (r101.intValue() != R.string.Drive_Drive_QuoteText) goto L35;
        if (r112 != null) goto L21;
    L29:
        if (r112 == null) goto L32;
        r102 = r112.length;
    L32:
        tt5.a.d("CommentDataUtils", "decodeCommentQuote, quote type is text, but params invalid, paramsLength: " + r102);
        return null;
    L21:
        if (r112.length < 2) goto L29;
        HashMap r103 = new HashMap(2);
        r103.put("page", r112[0]);
        r103.put("text", r112[1]);
        return xo5.a.d(r100, r101.intValue(), r103);
    L26:
        e = move-exception;
        tt5.a.e("CommentDataUtils", "decodeCommentQuote, quote type is text, but format error: ", e, false);
        return null;
    L35:
        if (r101.intValue() != R.string.Drive_Drive_QuotePage) goto L50;
        if (r112 != null) goto L38;
    L45:
        if (r112 == null) goto L48;
        r102 = r112.length;
    L48:
        tt5.a.d("CommentDataUtils", "decodeCommentQuote, quote type is page, but params invalid, paramsLength: " + r102);
        return null;
    L38:
        if (r112.length < 1) goto L45;
        return xo5.a.c(r100, r101.intValue(), "page", r112[0]);
    L42:
        e = move-exception;
        tt5.a.e("CommentDataUtils", "decodeCommentQuote, quote type is page, but format error: ", e, false);
        return null;
    L50:
        if (r112 != null) goto L54;
        return r100.getString(r101.intValue());
    L54:
        return r100.getString(r101.intValue(), r112);
    L8:
        e = move-exception;
        tt5.a.e("CommentDataUtils", "decodeCommentQuote, error when parsing json to CommentQuote: ", e, false);
        r111 = null;
        goto L10
    }
}
