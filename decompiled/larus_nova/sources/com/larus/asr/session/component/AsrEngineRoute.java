package com.larus.asr.session.component;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/asr/session/component/AsrEngineRoute;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, EffectConstants.NORMAL, "KMP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrEngineRoute extends Enum<AsrEngineRoute> {
    public static final AsrEngineRoute KMP = null;
    public static final AsrEngineRoute NONE = null;
    public static final AsrEngineRoute NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrEngineRoute[] f287656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287657b = null;

    public static EnumEntries<AsrEngineRoute> getEntries() {
        return f287657b;
    }

    static {
        AsrEngineRoute r100 = new AsrEngineRoute(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AsrEngineRoute r101 = new AsrEngineRoute(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        AsrEngineRoute r102 = new AsrEngineRoute("KMP", 2);
        KMP = r102;
        AsrEngineRoute[] r103 = {r100, r101, r102};
        f287656a = r103;
        f287657b = EnumEntriesKt.enumEntries(r103);
    }

    public static AsrEngineRoute[] values() {
        return (AsrEngineRoute[]) f287656a.clone();
    }

    public static AsrEngineRoute valueOf(String r100) {
        return (AsrEngineRoute) r27.a.a(AsrEngineRoute.class, r100);
    }

    public AsrEngineRoute(String r100, int r101) {
        super(r100, r101);
    }
}
