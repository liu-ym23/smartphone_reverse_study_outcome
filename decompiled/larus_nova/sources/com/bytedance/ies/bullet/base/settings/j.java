package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/j;", "", "", "", "workerJsFileMd5CheckList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setWorkerJsFileMd5CheckList", "(Ljava/util/List;)V", "", "enableBlankDetectConfig", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setEnableBlankDetectConfig", "(Ljava/util/Map;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("enable_blank_detect_config")
    private Map<String, String> enableBlankDetectConfig;

    @SerializedName("worker_js_file_md5_check_list")
    private List<String> workerJsFileMd5CheckList;

    public j() {
        this.workerJsFileMd5CheckList = CollectionsKt.listOf("84c1a41d47b9a3b566656c5d0fd24703");
        this.enableBlankDetectConfig = new LinkedHashMap();
    }

    public final Map<String, String> a() {
        return this.enableBlankDetectConfig;
    }

    public final List<String> b() {
        return this.workerJsFileMd5CheckList;
    }
}
