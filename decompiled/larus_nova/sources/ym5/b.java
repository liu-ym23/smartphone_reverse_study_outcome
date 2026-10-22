package ym5;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.AttachmentSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.EmbedImageSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.PanoSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentType;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import iu5.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f568380a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f568381a = null;

        static {
            int[] r100 = new int[SegmentType.values().length];
            f568381a = r100;
            r100[SegmentType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f568381a[SegmentType.MENTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f568381a[SegmentType.URL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f568381a[SegmentType.EMBED_IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f568381a[SegmentType.PANO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f568381a[SegmentType.ATTACHMENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        f568380a = new GsonBuilder().registerTypeAdapter(SegmentType.class, new ym5.a()).create();
    }

    public static List<BaseSegment> a(String r100) {
        ArrayList r101 = new ArrayList();
        JsonElement r102 = JsonParser.parseString(r100);     // Catch: Exception -> L24
        if (r102.isJsonArray() == false) goto L26;
        Iterator<JsonElement> r103 = r102.getAsJsonArray().iterator();     // Catch: Exception -> L24
    L6:
        if (r103.hasNext() == false) goto L26;
        JsonElement r104 = r103.next();     // Catch: Exception -> L24
        if (r104.isJsonObject() == false) goto L6;
        JsonElement r105 = r104.getAsJsonObject().get("type");     // Catch: Exception -> L24
        if (r105 == null) goto L13;
        String r106 = r105.getAsString();     // Catch: Exception -> L24
    L14:
        SegmentType r107 = SegmentType.parseSegmentType(r106);     // Catch: Exception -> L24
        switch(a.f568381a[r107.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L6;
        };     // Catch: Exception -> L24
    L17:
        r101.add((BaseSegment) f568380a.fromJson(r104, AttachmentSegment.class));     // Catch: Exception -> L24
        goto L6
    L18:
        r101.add((BaseSegment) f568380a.fromJson(r104, PanoSegment.class));     // Catch: Exception -> L24
        goto L6
    L19:
        r101.add((BaseSegment) f568380a.fromJson(r104, EmbedImageSegment.class));     // Catch: Exception -> L24
        goto L6
    L20:
        r101.add((BaseSegment) f568380a.fromJson(r104, HyperLinkSegment.class));     // Catch: Exception -> L24
        goto L6
    L21:
        r101.add((BaseSegment) f568380a.fromJson(r104, MentionSegment.class));     // Catch: Exception -> L24
        goto L6
    L22:
        r101.add((BaseSegment) f568380a.fromJson(r104, TextSegment.class));     // Catch: Exception -> L24
        goto L6
    L13:
        r106 = null;
    L26:
        return r101;
    L24:
        e = move-exception;
        d.a("SegmentParseUtil", e);
        goto L26
    }
}
