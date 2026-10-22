package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a0 {
    String a();

    Context context();

    MutableLiveData<Boolean> d();

    com.bytedance.android.livesdk.livecommerce.room.api.c e();

    MutableLiveData f();

    com.bytedance.android.livesdk.livecommerce.room.api.e g();

    LiveRoomParams h();

    com.bytedance.android.ec.adapter.api.state.a i();

    boolean isPreview();

    boolean j();

    ECContext k();

    boolean l();

    RealRoomController m();

    boolean n();

    boolean o();
}
