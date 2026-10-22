package com.bytedance.lark.sdk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/sdk/SdkInterceptState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Init", "MakeOnline", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SdkInterceptState extends Enum<SdkInterceptState> {
    public static final SdkInterceptState Init = null;
    public static final SdkInterceptState MakeOnline = null;
    public static final SdkInterceptState None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SdkInterceptState[] f254115a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254116b = null;

    public static EnumEntries<SdkInterceptState> getEntries() {
        return f254116b;
    }

    static {
        SdkInterceptState r100 = new SdkInterceptState("None", 0);
        None = r100;
        SdkInterceptState r101 = new SdkInterceptState("Init", 1);
        Init = r101;
        SdkInterceptState r102 = new SdkInterceptState("MakeOnline", 2);
        MakeOnline = r102;
        SdkInterceptState[] r103 = {r100, r101, r102};
        f254115a = r103;
        f254116b = EnumEntriesKt.enumEntries(r103);
    }

    public static SdkInterceptState[] values() {
        return (SdkInterceptState[]) f254115a.clone();
    }

    public static SdkInterceptState valueOf(String r100) {
        return (SdkInterceptState) r27.a.a(SdkInterceptState.class, r100);
    }

    public SdkInterceptState(String r100, int r101) {
        super(r100, r101);
    }
}
