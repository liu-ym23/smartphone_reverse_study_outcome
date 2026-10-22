package com.ss.ugc.effectplatform.model.net;

import com.baidu.mshield.x6.EngineImpl;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/ResourceUrl;", "", EngineImpl.KEY_OAID, "", "main_url", MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL, "url_expire", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getBackup_url", "()Ljava/lang/String;", "setBackup_url", "(Ljava/lang/String;)V", "getMain_url", "setMain_url", "getOid", "setOid", "getUrl_expire", "()Ljava/lang/Long;", "setUrl_expire", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public class ResourceUrl {
    private String backup_url;
    private String main_url;
    private String oid;
    private Long url_expire;

    public ResourceUrl() {
        this(null, null, null, null, 15, null);
    }

    public String getBackup_url() {
        return this.backup_url;
    }

    public String getMain_url() {
        return this.main_url;
    }

    public String getOid() {
        return this.oid;
    }

    public Long getUrl_expire() {
        return this.url_expire;
    }

    public void setBackup_url(String r100) {
        this.backup_url = r100;
    }

    public void setMain_url(String r100) {
        this.main_url = r100;
    }

    public void setOid(String r100) {
        this.oid = r100;
    }

    public void setUrl_expire(Long r100) {
        this.url_expire = r100;
    }

    public ResourceUrl(String r100, String r101, String r102, Long r103) {
        this.oid = r100;
        this.main_url = r101;
        this.backup_url = r102;
        this.url_expire = r103;
    }

    public /* synthetic */ ResourceUrl(String r100, String r101, String r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
