package com.larus.im.internal.rtcsdk.service;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/rtcsdk/service/AudioEncodeType;", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PCM_16", "OPUS", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioEncodeType extends Enum<AudioEncodeType> {
    public static final AudioEncodeType OPUS = null;
    public static final AudioEncodeType PCM_16 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioEncodeType[] f350063a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350064b = null;

    public static EnumEntries<AudioEncodeType> getEntries() {
        return f350064b;
    }

    static {
        AudioEncodeType r100 = new AudioEncodeType("PCM_16", 0);
        PCM_16 = r100;
        AudioEncodeType r101 = new AudioEncodeType("OPUS", 1);
        OPUS = r101;
        AudioEncodeType[] r102 = {r100, r101};
        f350063a = r102;
        f350064b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioEncodeType[] values() {
        return (AudioEncodeType[]) f350063a.clone();
    }

    public static AudioEncodeType valueOf(String r100) {
        return (AudioEncodeType) a.a(AudioEncodeType.class, r100);
    }

    public AudioEncodeType(String r100, int r101) {
        super(r100, r101);
    }
}
