package com.bytedance.ee.larkwebview.quality.hang;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/larkwebview/quality/hang/HangDetectStrategy;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "UNKNOWN", "RENDER_PROCESS_CLIENT", "JS_PING", "lark-webview-base_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HangDetectStrategy extends Enum<HangDetectStrategy> {
    public static final HangDetectStrategy JS_PING = null;
    public static final HangDetectStrategy RENDER_PROCESS_CLIENT = null;
    public static final HangDetectStrategy UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HangDetectStrategy[] f242901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242902b = null;
    private final int type;

    public static EnumEntries<HangDetectStrategy> getEntries() {
        return f242902b;
    }

    static {
        HangDetectStrategy r100 = new HangDetectStrategy("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        HangDetectStrategy r101 = new HangDetectStrategy("RENDER_PROCESS_CLIENT", 1, 1);
        RENDER_PROCESS_CLIENT = r101;
        HangDetectStrategy r102 = new HangDetectStrategy("JS_PING", 2, 2);
        JS_PING = r102;
        HangDetectStrategy[] r103 = {r100, r101, r102};
        f242901a = r103;
        f242902b = EnumEntriesKt.enumEntries(r103);
    }

    public static HangDetectStrategy[] values() {
        return (HangDetectStrategy[]) f242901a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static HangDetectStrategy valueOf(String r100) {
        return (HangDetectStrategy) a.a(HangDetectStrategy.class, r100);
    }

    public HangDetectStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
