package com.bytedance.bdp.appbase.meta.impl.pkg;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/appbase/meta/impl/pkg/RequestType;", "", "", "intType", "I", "getIntType", "()I", "normal", "async", "preload", LiveCommonConstants.REASON_SILENCE, "bdp-appbase-meta_release"}, k = 1, mv = {1, 4, 0})
public final enum RequestType extends Enum<RequestType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestType[] f200841a = null;
    public static final RequestType async = null;
    public static final RequestType normal = null;
    public static final RequestType preload = null;
    public static final RequestType silence = null;
    private final int intType;

    static {
        RequestType r100 = new RequestType("normal", 0, 0);
        normal = r100;
        RequestType r101 = new RequestType("async", 1, 1);
        async = r101;
        RequestType r102 = new RequestType("preload", 2, 2);
        preload = r102;
        RequestType r103 = new RequestType(LiveCommonConstants.REASON_SILENCE, 3, 3);
        silence = r103;
        f200841a = new RequestType[]{r100, r101, r102, r103};
    }

    public static RequestType valueOf(String r100) {
        return (RequestType) a.a(RequestType.class, r100);
    }

    public static RequestType[] values() {
        return (RequestType[]) f200841a.clone();
    }

    public final int getIntType() {
        return this.intType;
    }

    public RequestType(String r100, int r101, int r102) {
        super(r100, r101);
        this.intType = r102;
    }
}
