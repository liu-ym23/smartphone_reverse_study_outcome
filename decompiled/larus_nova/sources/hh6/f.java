package hh6;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f485223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f485224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f485225c;

    public f(String r100, String r101, long r102) {
        this.f485223a = r100;
        this.f485224b = r101;
        this.f485225c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TalkRoomBusinessFullLinkMonitor r101 = TalkRoomBusinessFullLinkMonitor.f71456a;
        String r102 = this.f485223a;
        String r103 = this.f485224b;
        long r104 = this.f485225c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "requestSource");
        Intrinsics.checkNotNullParameter(r103, "reason");
        JSONObject r105 = new JSONObject();
        r105.put("request_source", r102);
        r105.put("reason", r103);
        LinkMonitorData r106 = LinkMonitorData.LiveLinkCheckAudienceLinkers;
        long r107 = TalkRoomBusinessFullLinkMonitor.h(r104);
        TalkRoomBusinessFullLinkMonitor.Y(r106, r107, (Throwable) r100, r105);
    }
}
