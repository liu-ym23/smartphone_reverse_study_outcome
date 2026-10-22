package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.larus.network.http.ServiceType;
import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/mediaforward/ForwardScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT", "FAVORITE", AlarmSessionType.TODO, "Moments", "Mark", ServiceType.IM, "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForwardScene extends Enum<ForwardScene> {
    public static final ForwardScene CHAT = null;
    public static final a Companion = null;
    public static final ForwardScene FAVORITE = null;
    public static final ForwardScene Mark = null;
    public static final ForwardScene Message = null;
    public static final ForwardScene Moments = null;
    public static final ForwardScene TODO = null;
    public static final ForwardScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForwardScene[] f425362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f425363b = null;
    private final int value;

    public static EnumEntries<ForwardScene> getEntries() {
        return f425363b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.forwardv3.forward.mediaforward.ForwardScene$a] */
    static {
        ForwardScene r100 = new ForwardScene("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ForwardScene r101 = new ForwardScene("CHAT", 1, 1);
        CHAT = r101;
        ForwardScene r102 = new ForwardScene("FAVORITE", 2, 2);
        FAVORITE = r102;
        ForwardScene r103 = new ForwardScene(AlarmSessionType.TODO, 3, 3);
        TODO = r103;
        ForwardScene r104 = new ForwardScene("Moments", 4, 4);
        Moments = r104;
        ForwardScene r105 = new ForwardScene("Mark", 5, 5);
        Mark = r105;
        ForwardScene r110 = new ForwardScene(ServiceType.IM, 6, 6);
        Message = r110;
        ForwardScene[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f425362a = r111;
        f425363b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static ForwardScene[] values() {
        return (ForwardScene[]) f425362a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ForwardScene valueOf(String r100) {
        return (ForwardScene) r27.a.a(ForwardScene.class, r100);
    }

    public ForwardScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
