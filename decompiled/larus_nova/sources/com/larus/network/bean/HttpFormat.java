package com.larus.network.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/network/bean/HttpFormat;", "", "<init>", "(Ljava/lang/String;I)V", "RAW", "JSON", "PROTOBUF", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HttpFormat extends Enum<HttpFormat> {
    public static final HttpFormat JSON = null;
    public static final HttpFormat PROTOBUF = null;
    public static final HttpFormat RAW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpFormat[] f360106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360107b = null;

    public static EnumEntries<HttpFormat> getEntries() {
        return f360107b;
    }

    static {
        HttpFormat r100 = new HttpFormat("RAW", 0);
        RAW = r100;
        HttpFormat r101 = new HttpFormat("JSON", 1);
        JSON = r101;
        HttpFormat r102 = new HttpFormat("PROTOBUF", 2);
        PROTOBUF = r102;
        HttpFormat[] r103 = {r100, r101, r102};
        f360106a = r103;
        f360107b = EnumEntriesKt.enumEntries(r103);
    }

    public static HttpFormat[] values() {
        return (HttpFormat[]) f360106a.clone();
    }

    public static HttpFormat valueOf(String r100) {
        return (HttpFormat) a.a(HttpFormat.class, r100);
    }

    public HttpFormat(String r100, int r101) {
        super(r100, r101);
    }
}
