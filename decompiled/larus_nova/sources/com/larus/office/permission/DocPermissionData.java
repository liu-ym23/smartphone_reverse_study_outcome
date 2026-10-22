package com.larus.office.permission;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001e\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001e\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001e\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001e\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001e\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/larus/office/permission/DocPermissionData;", "", "<init>", "()V", "isOwner", "", "()Z", "setOwner", "(Z)V", "isManager", "setManager", "readable", "getReadable", "setReadable", "editable", "getEditable", "setEditable", "shareable", "getShareable", "setShareable", "commentable", "getCommentable", "setCommentable", "deletable", "getDeletable", "setDeletable", "exportable", "getExportable", "setExportable", "copyable", "getCopyable", "setCopyable", "createCopyAble", "getCreateCopyAble", "setCreateCopyAble", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPermissionData {

    @SerializedName("commentable")
    private boolean commentable;

    @SerializedName("copyable")
    private boolean copyable;

    @SerializedName("createCopyAble")
    private boolean createCopyAble;

    @SerializedName("deletable")
    private boolean deletable;

    @SerializedName("editable")
    private boolean editable;

    @SerializedName("exportable")
    private boolean exportable;

    @SerializedName("isManager")
    private boolean isManager;

    @SerializedName("isOwner")
    private boolean isOwner;

    @SerializedName("readable")
    private boolean readable;

    @SerializedName("shareable")
    private boolean shareable;

    public DocPermissionData() {
    }

    public String toString() {
        return "DocPermissionData(isOwner=" + this.isOwner + ", isManager=" + this.isManager + ", readable=" + this.readable + ", editable=" + this.editable + ", shareable=" + this.shareable + ", commentable=" + this.commentable + ", deletable=" + this.deletable + ", exportable=" + this.exportable + ", copyable=" + this.copyable + ", createCopyAble=" + this.createCopyAble + ')';
    }

    public final boolean getCommentable() {
        return this.commentable;
    }

    public final boolean getCopyable() {
        return this.copyable;
    }

    public final boolean getCreateCopyAble() {
        return this.createCopyAble;
    }

    public final boolean getDeletable() {
        return this.deletable;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final boolean getExportable() {
        return this.exportable;
    }

    public final boolean getReadable() {
        return this.readable;
    }

    public final boolean getShareable() {
        return this.shareable;
    }

    public final boolean isManager() {
        return this.isManager;
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public final void setCommentable(boolean r100) {
        this.commentable = r100;
    }

    public final void setCopyable(boolean r100) {
        this.copyable = r100;
    }

    public final void setCreateCopyAble(boolean r100) {
        this.createCopyAble = r100;
    }

    public final void setDeletable(boolean r100) {
        this.deletable = r100;
    }

    public final void setEditable(boolean r100) {
        this.editable = r100;
    }

    public final void setExportable(boolean r100) {
        this.exportable = r100;
    }

    public final void setManager(boolean r100) {
        this.isManager = r100;
    }

    public final void setOwner(boolean r100) {
        this.isOwner = r100;
    }

    public final void setReadable(boolean r100) {
        this.readable = r100;
    }

    public final void setShareable(boolean r100) {
        this.shareable = r100;
    }
}
