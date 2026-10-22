package com.ss.android.lark.widget.photopicker.entity;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class PhotoDirectory implements Serializable {
    private String coverPath;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f447477id;
    private String name;
    private String path;
    private List<Photo> photos;

    public int getPhotoNum() {
        if (CollectionUtils.isEmpty(this.photos) == false) goto L7;
        return 0;
    L7:
        return this.photos.size();
    }

    public List<String> getPhotoPaths() {
        ArrayList r100 = new ArrayList(this.photos.size());
        Iterator<Photo> r101 = this.photos.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(r101.next().getPath());
        goto L4
    L6:
        return r100;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.f447477id) == true) goto L5;
        int r100 = this.f447477id.hashCode();
        if (TextUtils.isEmpty(this.name) == false) goto L14;
        return r100;
    L14:
        return (r100 * 31) + this.name.hashCode();
    L5:
        if (TextUtils.isEmpty(this.name) == false) goto L9;
        return 0;
    L9:
        return this.name.hashCode();
    }

    public String toString() {
        return "PhotoDirectory{id='" + this.f447477id + "', coverPath='" + this.coverPath + "', name='" + this.name + "', photos=" + this.photos + '}';
    }

    public PhotoDirectory() {
        this.photos = new ArrayList();
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public String getId() {
        return this.f447477id;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public List<Photo> getPhotos() {
        return this.photos;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoDirectory) == true) goto L8;
        return false;
    L8:
        PhotoDirectory r101 = (PhotoDirectory) r100;
        boolean r102 = !TextUtils.isEmpty(this.f447477id);
        boolean r103 = true ^ TextUtils.isEmpty(r101.f447477id);
        if (r102 == false) goto L16;
        if (r103 == false) goto L16;
        if (TextUtils.equals(this.f447477id, r101.f447477id) == true) goto L15;
        return false;
    L15:
        return TextUtils.equals(this.name, r101.name);
    L16:
        return false;
    }

    public void setCoverPath(String r100) {
        this.coverPath = r100;
    }

    public void setId(String r100) {
        this.f447477id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public void setPhotos(List<Photo> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.size();
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r102 >= r101) goto L14;
        Photo r104 = (Photo) ListProtector.get(r100, r103);
        if (r104 != null) goto L9;
    L12:
        ListProtector.remove(r100, r103);
    L13:
        r102 = r102 + 1;
        goto L5
    L9:
        if (FileUtils.r(r104.getPath()) == false) goto L12;
        r103 = r103 + 1;
        goto L13
    L14:
        this.photos = r100;
    }

    public void addPhoto(int r100, String r101, String r102, long r103) {
        FileUtils.r(r101);
    }
}
