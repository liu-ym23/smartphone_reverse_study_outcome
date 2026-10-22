package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class ClientSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Scope> f277090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f277092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f277093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SubAppInfo f277094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f277095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f277096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f277097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f277098k;

    public Activity getCpActivity() {
        WeakReference<Activity> r100 = this.f277095h;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.get();
    }

    public List<String> getApiName() {
        return this.f277092e;
    }

    public String getAppID() {
        return this.f277091d;
    }

    public String getClientClassName() {
        return this.f277089b;
    }

    public String getClientPackageName() {
        return this.f277088a;
    }

    public String getCpID() {
        return this.f277093f;
    }

    public String getInnerHmsPkg() {
        return this.f277097j;
    }

    public List<Scope> getScopes() {
        return this.f277090c;
    }

    public SubAppInfo getSubAppID() {
        return this.f277094g;
    }

    public boolean isHasActivity() {
        return this.f277096i;
    }

    public boolean isUseInnerHms() {
        return this.f277098k;
    }

    public void setApiName(List<String> r100) {
        this.f277092e = r100;
    }

    public void setAppID(String r100) {
        this.f277091d = r100;
    }

    public void setClientClassName(String r100) {
        this.f277089b = r100;
    }

    public void setClientPackageName(String r100) {
        this.f277088a = r100;
    }

    public void setCpActivity(Activity r100) {
        this.f277095h = new WeakReference(r100);
        this.f277096i = true;
    }

    public void setCpID(String r100) {
        this.f277093f = r100;
    }

    public void setInnerHmsPkg(String r100) {
        this.f277097j = r100;
    }

    public void setScopes(List<Scope> r100) {
        this.f277090c = r100;
    }

    public void setSubAppId(SubAppInfo r100) {
        this.f277094g = r100;
    }

    public void setUseInnerHms(boolean r100) {
        this.f277098k = r100;
    }

    public ClientSettings(String r100, String r101, List<Scope> r102, String r103, List<String> r104) {
        this.f277088a = r100;
        this.f277089b = r101;
        this.f277090c = r102;
        this.f277091d = r103;
        this.f277092e = r104;
    }

    public ClientSettings(String r100, String r101, List<Scope> r102, String r103, List<String> r104, SubAppInfo r105) {
        this(r100, r101, r102, r103, r104);
        this.f277094g = r105;
    }
}
