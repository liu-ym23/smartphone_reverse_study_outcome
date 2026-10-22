package com.ss.android.lark.chat.entity.media;

import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.MediaContent;

/* JADX INFO: loaded from: classes35.dex */
public class MediaImageSet extends ImageSet {
    private MediaExtra mediaExtra;

    public MediaImageSet() {
    }

    public MediaExtra getMediaExtra() {
        return this.mediaExtra;
    }

    public MediaImageSet(Message r100) {
        if (r100.getType() != Message.Type.MEDIA) goto L6;
        MediaContent r101 = (MediaContent) r100.getContent();
        ImageSet r102 = r101.getImageSet();
        this.key = r102.getKey();
        this.origin = r102.getOrigin();
        this.thumbnail = r102.getThumbnail();
        this.middle = r102.getMiddle();
        this.inlinePreview = r102.getInlinePreview();
        MediaExtra r103 = new MediaExtra();
        this.mediaExtra = r103;
        r103.setFilePath(r101.getPlayPath());
        this.mediaExtra.setKey(r101.getKey());
        this.mediaExtra.setSize(r101.getSize());
        this.mediaExtra.setMime(r101.getMime());
        this.mediaExtra.setUrl(r101.getUrl());
        this.mediaExtra.setDuration(r101.getDuration());
        setMediaExtra(this.mediaExtra);
        MessageIdentity r104 = new MessageIdentity(r100.getId(), r100.getChatId(), r100.getSourceId(), r100.getSourceType());
        r104.setSenderId(r100.getFromId());
        r104.setSenderTenantId(r100.getFromChatterTenantId());
        setMessageIdentity(r104);
        return;
    }

    public void setMediaExtra(MediaExtra r100) {
        this.mediaExtra = r100;
    }

    public MediaImageSet(ImageSet r100) {
        super(r100.getKey(), r100.getOrigin(), r100.getThumbnail(), r100.getMiddle(), r100.getInlinePreview(), r100.getMessageIdentity());
    }
}
