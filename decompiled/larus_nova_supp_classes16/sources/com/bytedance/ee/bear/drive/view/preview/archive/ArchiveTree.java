package com.bytedance.ee.bear.drive.view.preview.archive;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ArchiveTree implements Serializable {
    public static final int TYPE_DIRECTORY = 0;
    public static final int TYPE_REGULAR_FILE = 1;
    private List<ArchiveTree> children;

    @JSONField(name = "file_type")
    private int fileType;
    private String id;
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
        return this.id;
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

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ArchiveTree) == true) goto L8;
        return false;
    L8:
        ArchiveTree r6 = (ArchiveTree) r5;
        if (Objects.equals(this.name, r6.name) == true) goto L11;
    L13:
        return false;
    L11:
        if (Objects.equals(this.path, r6.path) == false) goto L13;
        return true;
    }

    public void setChildren(List<ArchiveTree> r1) {
        this.children = r1;
    }

    public void setFileType(int r1) {
        this.fileType = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setParent(ArchiveTree r1) {
        this.parent = r1;
    }

    public void setPath(String r1) {
        this.path = r1;
    }

    public void setSize(long r1) {
        this.size = r1;
    }
}
