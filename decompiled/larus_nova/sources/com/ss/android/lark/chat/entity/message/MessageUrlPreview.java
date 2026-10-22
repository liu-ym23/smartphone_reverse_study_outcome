package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.chat.entity.image.ImageSet;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class MessageUrlPreview implements Serializable {
    private int count;
    private ImageSet coverImage;
    private String description;
    private ImageSet icon;
    private boolean isDeleted;
    private String messageId;
    private int offset;
    private PreviewVideo previewVideo;
    private int sequenceId;
    private String title;
    private String url;

    public MessageUrlPreview() {
        this.isDeleted = false;
    }

    public int getCount() {
        return this.count;
    }

    public ImageSet getCoverImage() {
        return this.coverImage;
    }

    public String getDescription() {
        return this.description;
    }

    public ImageSet getIcon() {
        return this.icon;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getOffset() {
        return this.offset;
    }

    public PreviewVideo getPreviewVideo() {
        return this.previewVideo;
    }

    public int getSequenceId() {
        return this.sequenceId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setCount(int r100) {
        this.count = r100;
    }

    public void setCoverImage(ImageSet r100) {
        this.coverImage = r100;
    }

    public void setDeleted(boolean r100) {
        this.isDeleted = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setIcon(ImageSet r100) {
        this.icon = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setOffset(int r100) {
        this.offset = r100;
    }

    public void setPreviewVideo(PreviewVideo r100) {
        this.previewVideo = r100;
    }

    public void setSequenceId(int r100) {
        this.sequenceId = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
