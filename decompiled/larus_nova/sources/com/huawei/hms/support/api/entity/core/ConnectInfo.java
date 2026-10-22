package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class ConnectInfo implements IMessageEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Packed
    private List<String> f277729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Packed
    private List<Scope> f277730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Packed
    private String f277731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Packed
    private String f277732d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f277729a;
    }

    public String getFingerprint() {
        return this.f277731c;
    }

    public List<Scope> getScopeList() {
        return this.f277730b;
    }

    public String getSubAppID() {
        return this.f277732d;
    }

    public void setApiNameList(List<String> r100) {
        this.f277729a = r100;
    }

    public void setFingerprint(String r100) {
        this.f277731c = r100;
    }

    public void setScopeList(List<Scope> r100) {
        this.f277730b = r100;
    }

    public void setSubAppID(String r100) {
        this.f277732d = r100;
    }

    public ConnectInfo(List<String> r100, List<Scope> r101, String r102, String r103) {
        this.f277729a = r100;
        this.f277730b = r101;
        this.f277731c = r102;
        this.f277732d = r103;
    }
}
