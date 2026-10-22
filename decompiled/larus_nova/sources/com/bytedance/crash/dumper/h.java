package com.bytedance.crash.dumper;

import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f203158a;

    public h(JSONObject r100) {
        this.f203158a = r100;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        if (r101.contains("evil_trace") == false) goto L10;
        this.f203158a.put("has_evil_trace_file", String.valueOf(true));     // Catch: Throwable -> L7
        return false;
    L10:
        return false;
    L11:
        return false;
    }
}
