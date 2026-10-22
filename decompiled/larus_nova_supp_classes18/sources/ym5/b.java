package ym5;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.AttachmentSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.EmbedImageSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.PanoSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentType;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import iu5.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final Gson a = null;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SegmentType.values().length];
            a = r0;
            r0[SegmentType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[SegmentType.MENTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[SegmentType.URL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[SegmentType.EMBED_IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[SegmentType.PANO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[SegmentType.ATTACHMENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        a = new GsonBuilder().registerTypeAdapter(SegmentType.class, new ym5.a()).create();
    }

    public static List<BaseSegment> a(String r4) {
        ArrayList r0 = new ArrayList();
        JsonElement r5 = JsonParser.parseString(r4);     // Catch: Exception -> L24
        if (r5.isJsonArray() == false) goto L26;
        Iterator r6 = r5.getAsJsonArray().iterator();     // Catch: Exception -> L24
    L6:
        if (r6.hasNext() == false) goto L26;
        JsonElement r1 = (JsonElement) r6.next();     // Catch: Exception -> L24
        if (r1.isJsonObject() == false) goto L6;
        JsonElement r2 = r1.getAsJsonObject().get(ResourceData.KEY_TYPE);     // Catch: Exception -> L24
        if (r2 == null) goto L13;
        String r3 = r2.getAsString();     // Catch: Exception -> L24
    L14:
        SegmentType r7 = SegmentType.parseSegmentType(r3);     // Catch: Exception -> L24
        switch(a.a[r7.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L6;
        };     // Catch: Exception -> L24
    L17:
        r0.add((BaseSegment) a.fromJson(r1, AttachmentSegment.class));     // Catch: Exception -> L24
        goto L6
    L18:
        r0.add((BaseSegment) a.fromJson(r1, PanoSegment.class));     // Catch: Exception -> L24
        goto L6
    L19:
        r0.add((BaseSegment) a.fromJson(r1, EmbedImageSegment.class));     // Catch: Exception -> L24
        goto L6
    L20:
        r0.add((BaseSegment) a.fromJson(r1, HyperLinkSegment.class));     // Catch: Exception -> L24
        goto L6
    L21:
        r0.add((BaseSegment) a.fromJson(r1, MentionSegment.class));     // Catch: Exception -> L24
        goto L6
    L22:
        r0.add((BaseSegment) a.fromJson(r1, TextSegment.class));     // Catch: Exception -> L24
        goto L6
    L13:
        r3 = null;
    L26:
        return r0;
    L24:
        e = move-exception;
        d.a("SegmentParseUtil", e);
        goto L26
    }
}
