package qr1;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f534521a;

    public g(i r100) {
        this.f534521a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        if (Boolean.TRUE.equals((Boolean) r110) == false) goto L20;
        i r111 = this.f534521a;
        r111.f534528f.f534540a = true;
        APMEvent.Level r100 = APMEvent.Level.I;
        r111.c(com.bytedance.android.live.livepullstream.api.apm.a.c(r100, "init room; hashcode=" + this.f534521a.hashCode(), "timeout config=" + this.f534521a.f534527e.enterRoomTimeout));
        i r112 = this.f534521a;
        if (r112.f534527e.enterRoomTimeout <= 0) goto L7;
        WeakHandler r113 = r112.f534538p;
        r113.sendMessageDelayed(Message.obtain(r113, 2), this.f534521a.f534527e.enterRoomTimeout);
    L7:
        Bundle r114 = this.f534521a.f534529g;
        if (r114 == null) goto L21;
        String r101 = r114.getString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, "");
        this.f534521a.d("type", r101);
        this.f534521a.a(ILiveRoomPlayFragmentConstant.EXTRA_HEAD_ENTER_TYPE, r101);
        long r102 = r114.getLong(ILiveRoomPlayFragmentConstant.EXTRA_FEED_REQUEST_START_TIME);
        long r103 = r114.getLong(ILiveRoomPlayFragmentConstant.EXTRA_FEED_REQUEST_END_TIME);
        if (r103 > 0) goto L12;
    L14:
        long r104 = r114.getLong(ILiveRoomPlayFragmentConstant.EXTRA_BEGIN_START_ACTIVITY_TIME);
        long r105 = r114.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ACTIVITY_ON_CREATE_TIME);
        if (r104 > 0) goto L17;
        return;
    L17:
        if (r105 <= 0) goto L23;
        this.f534521a.c(com.bytedance.android.live.livepullstream.api.apm.a.b(r100, "activity_start_open", r104));
        this.f534521a.c(com.bytedance.android.live.livepullstream.api.apm.a.b(r100, "activity_created", r105));
        this.f534521a.e("start_activity", r105 - r104);
        return;
    L23:
        return;
    L12:
        if (r102 <= 0) goto L14;
        this.f534521a.c(com.bytedance.android.live.livepullstream.api.apm.a.b(r100, "request_feed_start", r102));
        this.f534521a.c(com.bytedance.android.live.livepullstream.api.apm.a.b(r100, "request_feed_finish", r103));
        this.f534521a.e("load_feed", r103 - r102);
        goto L14
    L21:
        return;
    }
}
