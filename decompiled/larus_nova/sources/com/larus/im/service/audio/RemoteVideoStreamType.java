package com.larus.im.service.audio;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/service/audio/RemoteVideoStreamType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", AccountType.MAIN, "SCREEN", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum RemoteVideoStreamType extends Enum<RemoteVideoStreamType> {
    public static final a Companion = null;
    public static final RemoteVideoStreamType MAIN = null;
    public static final RemoteVideoStreamType SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<juc.d<Object>> f350673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ RemoteVideoStreamType[] f350674b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350675c = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public final juc.d<RemoteVideoStreamType> serializer() {
            return (juc.d) RemoteVideoStreamType.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<RemoteVideoStreamType> getEntries() {
        return f350675c;
    }

    static {
        RemoteVideoStreamType r100 = new RemoteVideoStreamType(AccountType.MAIN, 0, 0);
        MAIN = r100;
        RemoteVideoStreamType r101 = new RemoteVideoStreamType("SCREEN", 1, 1);
        SCREEN = r101;
        RemoteVideoStreamType[] r102 = {r100, r101};
        f350674b = r102;
        f350675c = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
        f350673a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new d1());
    }

    public static RemoteVideoStreamType[] values() {
        return (RemoteVideoStreamType[]) f350674b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f350673a;
    }

    public final int getValue() {
        return this.value;
    }

    public static RemoteVideoStreamType valueOf(String r100) {
        return (RemoteVideoStreamType) r27.a.a(RemoteVideoStreamType.class, r100);
    }

    public RemoteVideoStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
