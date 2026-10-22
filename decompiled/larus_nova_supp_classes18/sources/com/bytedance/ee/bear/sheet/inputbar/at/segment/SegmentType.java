package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import cu5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum SegmentType extends Enum<SegmentType> implements NonProguard {
    private static final /* synthetic */ SegmentType[] $VALUES = null;

    @SerializedName("attachment")
    @JSONField(name = "attachment")
    public static final SegmentType ATTACHMENT = null;

    @SerializedName("embed-image")
    @JSONField(name = "embed-image")
    public static final SegmentType EMBED_IMAGE = null;

    @SerializedName("mention")
    @JSONField(name = "mention")
    public static final SegmentType MENTION = null;

    @SerializedName("pano")
    @JSONField(name = "pano")
    public static final SegmentType PANO = null;

    @SerializedName("text")
    @JSONField(name = "text")
    public static final SegmentType TEXT = null;

    @SerializedName(ResourceData.KEY_URL)
    @JSONField(name = ResourceData.KEY_URL)
    public static final SegmentType URL = null;

    static {
        SegmentType r0 = new SegmentType(CardAdapter.TEXT, 0);
        TEXT = r0;
        SegmentType r1 = new SegmentType("MENTION", 1);
        MENTION = r1;
        SegmentType r3 = new SegmentType("URL", 2);
        URL = r3;
        SegmentType r5 = new SegmentType("EMBED_IMAGE", 3);
        EMBED_IMAGE = r5;
        SegmentType r7 = new SegmentType("PANO", 4);
        PANO = r7;
        SegmentType r9 = new SegmentType("ATTACHMENT", 5);
        ATTACHMENT = r9;
        $VALUES = new SegmentType[]{r0, r1, r3, r5, r7, r9};
    }

    public static SegmentType[] values() {
        return (SegmentType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != EMBED_IMAGE) goto L7;
        return "embed-image";
    L7:
        return a.a(name().toLowerCase());
    }

    public static SegmentType parseSegmentType(String r2) {
        if (r2 == null) goto L45;
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -1963501277: goto L27;
            case 116079: goto L23;
            case 3433330: goto L19;
            case 3556653: goto L15;
            case 950345194: goto L11;
            case 2084357479: goto L7;
            default: goto L30;
        };
    L30:
        switch(r1) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            default: goto L45;
        };
    L33:
        return EMBED_IMAGE;
    L35:
        return MENTION;
    L37:
        return TEXT;
    L39:
        return PANO;
    L41:
        return URL;
    L43:
        return ATTACHMENT;
    L7:
        if (r2.equals("embed-image") == false) goto L30;
        r1 = 5;
        goto L30
    L11:
        if (r2.equals("mention") == false) goto L30;
        r1 = 4;
        goto L30
    L15:
        if (r2.equals("text") == false) goto L30;
        r1 = 3;
        goto L30
    L19:
        if (r2.equals("pano") == false) goto L30;
        r1 = 2;
        goto L30
    L23:
        if (r2.equals(ResourceData.KEY_URL) == false) goto L30;
        r1 = 1;
        goto L30
    L27:
        if (r2.equals("attachment") == false) goto L30;
        r1 = 0;
    L45:
        return TEXT;
    }

    public static SegmentType valueOf(String r1) {
        return (SegmentType) r27.a.a(SegmentType.class, r1);
    }

    private SegmentType(String r1, int r2) {
        super(r1, r2);
    }
}
