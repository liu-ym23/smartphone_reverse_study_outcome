package com.ss.ttvideoengine.strategrycenter;

import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class MediaInfo {
    private int mComments;
    private double mDuration;
    private String mFormat;
    private int mLikes;
    private String mMediaID;
    private List<Representation> mRepresentations;
    private int mUserComment;
    private int mUserLike;
    private int mUserShare;

    public MediaInfo() {
    }

    public int getComments() {
        return this.mComments;
    }

    public double getDuration() {
        return this.mDuration;
    }

    public String getFormat() {
        return this.mFormat;
    }

    public int getLikes() {
        return this.mLikes;
    }

    public String getMediaID() {
        return this.mMediaID;
    }

    public int getUserComment() {
        return this.mUserComment;
    }

    public int getUserLike() {
        return this.mUserLike;
    }

    public int getUserShare() {
        return this.mUserShare;
    }

    public void setComments(int r100) {
        this.mComments = r100;
    }

    public void setDuration(double r100) {
        this.mDuration = r100;
    }

    public void setFormat(String r100) {
        this.mFormat = r100;
    }

    public void setLikes(int r100) {
        this.mLikes = r100;
    }

    public void setMediaID(String r100) {
        this.mMediaID = r100;
    }

    public void setUserComment(int r100) {
        this.mUserComment = r100;
    }

    public void setUserLike(int r100) {
        this.mUserLike = r100;
    }

    public void setUserShare(int r100) {
        this.mUserShare = r100;
    }
}
