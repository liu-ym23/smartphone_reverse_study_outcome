package com.bytedance.ee.android.file.picker.lib.media;

import android.net.Uri;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes15.dex */
public abstract class BaseFileEntry implements Serializable {
    protected String name;
    protected String path;
    protected long size;
    protected Uri uri;

    public int hashCode() {
        Uri r100 = this.uri;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "BaseFileEntry{uri='" + this.uri + "', module='" + this.name + "', size=" + this.size + '}';
    }

    public BaseFileEntry() {
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public Uri getUri() {
        return this.uri;
    }

    public String path() {
        return this.path;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.uri, ((BaseFileEntry) r100).uri);
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public void setUri(Uri r100) {
        this.uri = r100;
    }
}
