package com.huawei.agconnect.core;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface ServiceRegistrar {
    List<Service> getServices(Context r100);

    void initialize(Context r100);
}
