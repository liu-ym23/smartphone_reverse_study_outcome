package com.bytedance.ee.bear.drive.view.preview.archive;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class ArchiveTree implements Serializable {
    public static final int TYPE_DIRECTORY = 0;
    public static final int TYPE_REGULAR_FILE = 1;
    private List<ArchiveTree> children;

    @JSONField(name = "file_type")
    private int fileType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f224707id;
    private String name;

    @JSONField(serialize = false)
    private ArchiveTree parent;

    @JSONField(serialize = false)
    private String path;
    private long size;

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.path});
    }

    public boolean isDir() {
        if (this.fileType != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "ArchiveTree{name='" + this.name + "', fileType=" + this.fileType + ", children=" + this.children + '}';
    }

    public ArchiveTree() {
        this.children = new ArrayList();
        this.path = "";
    }

    public List<ArchiveTree> getChildren() {
        return this.children;
    }

    public int getFileType() {
        return this.fileType;
    }

    public String getId() {
        return this.f224707id;
    }

    public String getName() {
        return this.name;
    }

    public ArchiveTree getParent() {
        return this.parent;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ArchiveTree) == true) goto L8;
        return false;
    L8:
        ArchiveTree r101 = (ArchiveTree) r100;
        if (Objects.equals(this.name, r101.name) == true) goto L11;
    L13:
        return false;
    L11:
        if (Objects.equals(this.path, r101.path) == false) goto L13;
        return true;
    }

    public void setChildren(List<ArchiveTree> r100) {
        this.children = r100;
    }

    public void setFileType(int r100) {
        this.fileType = r100;
    }

    public void setId(String r100) {
        this.f224707id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setParent(ArchiveTree r100) {
        this.parent = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }
}
