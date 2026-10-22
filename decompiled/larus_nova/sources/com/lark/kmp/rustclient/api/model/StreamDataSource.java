package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.RequestPacket;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/rustclient/api/model/StreamDataSource;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "DEFAULT_SMART", "ONCE_LOCAL", "ONCE_NET", "Companion", "rust-client_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StreamDataSource extends Enum<StreamDataSource> {
    public static final a Companion = null;
    public static final StreamDataSource DEFAULT_SMART = null;
    public static final StreamDataSource ONCE_LOCAL = null;
    public static final StreamDataSource ONCE_NET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StreamDataSource[] f282463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282464b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<StreamDataSource> getEntries() {
        return f282464b;
    }

    static {
        StreamDataSource r100 = new StreamDataSource("DEFAULT_SMART", 0, 1);
        DEFAULT_SMART = r100;
        StreamDataSource r101 = new StreamDataSource("ONCE_LOCAL", 1, 2);
        ONCE_LOCAL = r101;
        StreamDataSource r102 = new StreamDataSource("ONCE_NET", 2, 3);
        ONCE_NET = r102;
        StreamDataSource[] r103 = {r100, r101, r102};
        f282463a = r103;
        f282464b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static StreamDataSource[] values() {
        return (StreamDataSource[]) f282463a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final RequestPacket.BizConfig.DataSource forNumber(int r100) {
        Companion.getClass();
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return RequestPacket.BizConfig.DataSource.DEFAULT;
    L14:
        return RequestPacket.BizConfig.DataSource.PREFERRED_ONLINE;
    L15:
        return RequestPacket.BizConfig.DataSource.LOCAL;
    L12:
        return RequestPacket.BizConfig.DataSource.DEFAULT;
    }

    @JvmStatic
    public static final StreamDataSource valueOf(int r100) {
        Companion.getClass();
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return DEFAULT_SMART;
    L14:
        return ONCE_NET;
    L15:
        return ONCE_LOCAL;
    L12:
        return DEFAULT_SMART;
    }

    public static StreamDataSource valueOf(String r100) {
        return (StreamDataSource) r27.a.a(StreamDataSource.class, r100);
    }

    public StreamDataSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
