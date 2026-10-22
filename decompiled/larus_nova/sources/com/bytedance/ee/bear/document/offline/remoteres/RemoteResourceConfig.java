package com.bytedance.ee.bear.document.offline.remoteres;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import l25.b;

/* JADX INFO: loaded from: classes16.dex */
public class RemoteResourceConfig implements NonProguard {
    private Set<String> fileNameSet;
    private List<String> remote_file_list;

    public RemoteResourceConfig() {
    }

    public static RemoteResourceConfig defaultResConfig() {
        RemoteResourceConfig r100 = new RemoteResourceConfig();
        r100.remote_file_list = new ArrayList();
        return r100;
    }

    public void generateFileNameSet() {
        this.fileNameSet = new HashSet();
        List<String> r100 = this.remote_file_list;
        if (r100 == null) goto L10;
        Iterator<String> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        String r102 = UriProtector.parse(r101.next()).getPath();
        if (r102 == null) goto L6;
        this.fileNameSet.add(b.a(r102));
        goto L6
    L16:
        return;
    }

    public Set<String> getFileNameSet() {
        return this.fileNameSet;
    }

    public List<String> getRemote_file_list() {
        return this.remote_file_list;
    }

    public void setFileNameSet(Set<String> r100) {
        this.fileNameSet = r100;
    }

    public void setRemote_file_list(List<String> r100) {
        this.remote_file_list = r100;
    }
}
