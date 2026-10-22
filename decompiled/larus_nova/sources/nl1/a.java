package nl1;

import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.PanelType;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<Boolean> f519539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BehaviorSubject<Boolean> f519540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BehaviorSubject<PanelType> f519541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BehaviorSubject<Boolean> f519542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BehaviorSubject<String> f519543e;

    public a() {
        this.f519539a = BehaviorSubject.create();
        this.f519540b = BehaviorSubject.create();
        this.f519541c = BehaviorSubject.create();
        this.f519542d = BehaviorSubject.create();
        this.f519543e = BehaviorSubject.create();
    }
}
