package com.ss.android.lark.player.entity;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import java.io.FileDescriptor;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes37.dex */
public class DataSource implements Serializable {
    private AssetFileDescriptor assetFileDescriptor;
    private String cacheKeyPrefix;
    private String data;
    private HashMap<String, String> extra;
    private FileDescriptor fileDescriptor;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f438649id;
    private boolean isLocal;
    private final MutableLiveData<Boolean> showPreloading;
    private String sid;
    private long size;
    private int startPos;
    private String tag;
    private String title;
    private Uri uri;

    public String toString() {
        return "data: " + this.data + ", size: " + this.size + ", uri: " + this.uri + ", fileDescriptor: " + this.fileDescriptor;
    }

    public DataSource() {
        this.cacheKeyPrefix = "";
        this.showPreloading = new MutableLiveData(Boolean.FALSE);
    }

    public AssetFileDescriptor getAssetFileDescriptor() {
        return this.assetFileDescriptor;
    }

    public String getCacheKeyPrefix() {
        return this.cacheKeyPrefix;
    }

    public String getData() {
        return this.data;
    }

    public HashMap<String, String> getExtra() {
        return this.extra;
    }

    public FileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public long getId() {
        return this.f438649id;
    }

    public MutableLiveData<Boolean> getShowPreloading() {
        return this.showPreloading;
    }

    public String getSid() {
        return this.sid;
    }

    public long getSize() {
        return this.size;
    }

    public int getStartPos() {
        return this.startPos;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean isLocal() {
        return this.isLocal;
    }

    public DataSource(String r100) {
        this.cacheKeyPrefix = "";
        this.showPreloading = new MutableLiveData(Boolean.FALSE);
        this.data = r100;
    }

    public void setAssetFileDescriptor(AssetFileDescriptor r100) {
        this.assetFileDescriptor = r100;
    }

    public void setCacheKeyPrefix(String r100) {
        this.cacheKeyPrefix = r100;
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setExtra(HashMap<String, String> r100) {
        this.extra = r100;
    }

    public void setFileDescriptor(FileDescriptor r100) {
        this.fileDescriptor = r100;
    }

    public void setId(long r100) {
        this.f438649id = r100;
    }

    public void setIsLocal(boolean r100) {
        this.isLocal = r100;
    }

    public void setSid(String r100) {
        this.sid = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public void setStartPos(int r100) {
        this.startPos = r100;
    }

    public void setTag(String r100) {
        this.tag = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setUri(Uri r100) {
        this.uri = r100;
    }

    public DataSource(String r100, String r101) {
        this.cacheKeyPrefix = "";
        this.showPreloading = new MutableLiveData(Boolean.FALSE);
        this.tag = r100;
        this.data = r101;
    }
}
