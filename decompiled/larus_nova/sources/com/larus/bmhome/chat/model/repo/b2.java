package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.api.NotificationApi;

/* JADX INFO: loaded from: classes25.dex */
public final class b2 implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f307774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<Integer> f307775b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f307776c = null;

    public b2() {
    }

    static {
        f307774a = new b2();
        f307775b = new MutableLiveData();
        f307776c = new MutableLiveData();
    }

    public static NotificationApi c() {
        return NotificationApi.f297173a.getValue();
    }

    @Override // com.larus.bmhome.chat.model.repo.w1
    public final MutableLiveData<Integer> a() {
        return f307775b;
    }

    @Override // com.larus.bmhome.chat.model.repo.w1
    public final MutableLiveData<Boolean> b() {
        return f307776c;
    }
}
