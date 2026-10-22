package com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bean.Icon;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes15.dex */
public class SegmentModel implements NonProguard {
    public String attachmentToken;
    public String editType;
    private AttachmentEntity embedImage;

    @SerializedName("en_name")
    @JSONField(name = "en_name")
    public String enName;
    public String extra;
    public int height;
    public Icon icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f207101id;
    public String link;
    public String mentionId;
    public boolean mentionNotify;
    public int mentionType;
    public String mimeType;
    public String mountNodeToken;
    public String mountPointType;
    public String name;

    @SerializedName("not_notify")
    @JSONField(name = "not_notify")
    public boolean notNotify;
    public int realMentionType;
    public int size;
    public String text;
    public String token;
    public String type;
    public boolean visited;
    public int width;

    public SegmentModel() {
    }

    public AttachmentEntity getEmbedImage() {
        if (this.embedImage != null) goto L6;
        this.embedImage = new AttachmentEntity(0, this.attachmentToken, this.name, "", this.mountPointType, this.mountNodeToken, this.mimeType, 0, this.width, this.height, this.extra);
    L6:
        return this.embedImage;
    }

    public static SegmentModel newTextSegment(String r100) {
        SegmentModel r101 = new SegmentModel();
        r101.type = "text";
        r101.text = r100;
        return r101;
    }

    public static SegmentModel newUrlSegment(String r100, String r101) {
        SegmentModel r102 = new SegmentModel();
        r102.type = "url";
        r102.text = r100;
        r102.link = r101;
        return r102;
    }

    public static SegmentModel newMentionSegment(String r100, String r101, String r102, int r103, int r104, boolean r105, boolean r106, String r107, Icon r110, String r111, String r112, String r113, String r114) {
        SegmentModel r108 = new SegmentModel();
        r108.type = "mention";
        r108.text = r100;
        r108.link = r101;
        r108.token = r102;
        r108.mentionType = r103;
        r108.notNotify = r106;
        r108.realMentionType = r104;
        r108.f207101id = r111;
        r108.name = r112;
        if (r103 != 0) goto L12;
        r108.mentionNotify = r105;
        r108.mentionId = r107;
        if (TextUtils.isEmpty(r113) == true) goto L8;
        r108.enName = r113;
    L8:
        if (TextUtils.isEmpty(r108.link) == false) goto L12;
        if (TextUtils.isEmpty(r114) == true) goto L12;
        r108.link = r114;
    L12:
        if (r110 == null) goto L14;
        r108.icon = r110;
    L14:
        return r108;
    }
}
