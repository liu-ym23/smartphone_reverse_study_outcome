package com.bytedance.ee.bear.sheet.inputbar.at.segment;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.SlashMentionConfig;
import cu5.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum SegmentType extends Enum<SegmentType> implements NonProguard {
    private static final /* synthetic */ SegmentType[] $VALUES = null;

    @SerializedName(SlashMentionConfig.MENTION_CONTENT_ATTACHMENT)
    @JSONField(name = SlashMentionConfig.MENTION_CONTENT_ATTACHMENT)
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

    @SerializedName("url")
    @JSONField(name = "url")
    public static final SegmentType URL = null;

    static {
        SegmentType r100 = new SegmentType(CardAdapter.TEXT, 0);
        TEXT = r100;
        SegmentType r101 = new SegmentType("MENTION", 1);
        MENTION = r101;
        SegmentType r102 = new SegmentType("URL", 2);
        URL = r102;
        SegmentType r103 = new SegmentType("EMBED_IMAGE", 3);
        EMBED_IMAGE = r103;
        SegmentType r104 = new SegmentType("PANO", 4);
        PANO = r104;
        SegmentType r105 = new SegmentType("ATTACHMENT", 5);
        ATTACHMENT = r105;
        $VALUES = new SegmentType[]{r100, r101, r102, r103, r104, r105};
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

    public static SegmentType parseSegmentType(String r100) {
        if (r100 == null) goto L45;
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1963501277: goto L27;
            case 116079: goto L23;
            case 3433330: goto L19;
            case 3556653: goto L15;
            case 950345194: goto L11;
            case 2084357479: goto L7;
            default: goto L30;
        };
    L30:
        switch(r101) {
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
        if (r100.equals("embed-image") == false) goto L30;
        r101 = 5;
        goto L30
    L11:
        if (r100.equals("mention") == false) goto L30;
        r101 = 4;
        goto L30
    L15:
        if (r100.equals("text") == false) goto L30;
        r101 = 3;
        goto L30
    L19:
        if (r100.equals("pano") == false) goto L30;
        r101 = 2;
        goto L30
    L23:
        if (r100.equals("url") == false) goto L30;
        r101 = 1;
        goto L30
    L27:
        if (r100.equals(SlashMentionConfig.MENTION_CONTENT_ATTACHMENT) == false) goto L30;
        r101 = 0;
    L45:
        return TEXT;
    }

    public static SegmentType valueOf(String r100) {
        return (SegmentType) r27.a.a(SegmentType.class, r100);
    }

    private SegmentType(String r100, int r101) {
        super(r100, r101);
    }
}
