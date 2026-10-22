package com.bytedance.ee.bear.document.offline.remoteres;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import l25.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RemoteResourceConfig implements NonProguard {
    private Set<String> fileNameSet;
    private List<String> remote_file_list;

    public RemoteResourceConfig() {
    }

    public static RemoteResourceConfig defaultResConfig() {
        RemoteResourceConfig r0 = new RemoteResourceConfig();
        r0.remote_file_list = new ArrayList();
        return r0;
    }

    public void generateFileNameSet() {
        this.fileNameSet = new HashSet();
        List<String> r0 = this.remote_file_list;
        if (r0 == null) goto L10;
        Iterator<String> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        String r2 = UriProtector.parse(r1.next()).getPath();
        if (r2 == null) goto L6;
        this.fileNameSet.add(b.a(r2));
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

    public void setFileNameSet(Set<String> r1) {
        this.fileNameSet = r1;
    }

    public void setRemote_file_list(List<String> r1) {
        this.remote_file_list = r1;
    }
}
