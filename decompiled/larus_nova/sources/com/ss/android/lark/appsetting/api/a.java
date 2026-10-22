package com.ss.android.lark.appsetting.api;

import android.app.Application;
import com.ss.android.lark.storage.kv.repo.KVRepo;

/* JADX INFO: loaded from: classes34.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.appsetting.api.a$a, reason: collision with other inner class name */
    public interface InterfaceC4749a {
    }

    String getBrand();

    Application getContext();

    InterfaceC4749a getFeatureGatingDependency();

    KVRepo getLarkRepo();

    int getType();

    String getUid();

    String getUnit();

    KVRepo getUserRepo(String r100);

    boolean isLogin();
}
