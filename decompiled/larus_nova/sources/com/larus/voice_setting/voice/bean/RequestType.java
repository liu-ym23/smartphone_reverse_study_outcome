package com.larus.voice_setting.voice.bean;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voice_setting/voice/bean/RequestType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", ErrorCode.INIT, "LOAD_MORE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RequestType extends Enum<RequestType> {
    public static final RequestType INIT = null;
    public static final RequestType LOAD_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestType[] f376493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f376494b = null;
    private String type;

    public static EnumEntries<RequestType> getEntries() {
        return f376494b;
    }

    static {
        RequestType r100 = new RequestType(ErrorCode.INIT, 0, "init");
        INIT = r100;
        RequestType r101 = new RequestType("LOAD_MORE", 1, GYLFetchType.LOAD_MORE);
        LOAD_MORE = r101;
        RequestType[] r102 = {r100, r101};
        f376493a = r102;
        f376494b = EnumEntriesKt.enumEntries(r102);
    }

    public static RequestType[] values() {
        return (RequestType[]) f376493a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static RequestType valueOf(String r100) {
        return (RequestType) a.a(RequestType.class, r100);
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public RequestType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
