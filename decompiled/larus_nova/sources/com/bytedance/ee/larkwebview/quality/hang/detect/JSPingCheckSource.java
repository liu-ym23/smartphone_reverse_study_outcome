package com.bytedance.ee.larkwebview.quality.hang.detect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/larkwebview/quality/hang/detect/JSPingCheckSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AFTER_READY", "NOT_READY_DELAY", "DOUBLE_CHECK", "UNRESPONSIVE", "lark-webview-base_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum JSPingCheckSource extends Enum<JSPingCheckSource> {
    public static final JSPingCheckSource AFTER_READY = null;
    public static final JSPingCheckSource DOUBLE_CHECK = null;
    public static final JSPingCheckSource NOT_READY_DELAY = null;
    public static final JSPingCheckSource UNRESPONSIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JSPingCheckSource[] f242905a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242906b = null;
    private final String value;

    public static EnumEntries<JSPingCheckSource> getEntries() {
        return f242906b;
    }

    static {
        JSPingCheckSource r100 = new JSPingCheckSource("AFTER_READY", 0, "afterReady");
        AFTER_READY = r100;
        JSPingCheckSource r101 = new JSPingCheckSource("NOT_READY_DELAY", 1, "notReady");
        NOT_READY_DELAY = r101;
        JSPingCheckSource r102 = new JSPingCheckSource("DOUBLE_CHECK", 2, "doubleCheck");
        DOUBLE_CHECK = r102;
        JSPingCheckSource r103 = new JSPingCheckSource("UNRESPONSIVE", 3, "unresponsive");
        UNRESPONSIVE = r103;
        JSPingCheckSource[] r104 = {r100, r101, r102, r103};
        f242905a = r104;
        f242906b = EnumEntriesKt.enumEntries(r104);
    }

    public static JSPingCheckSource[] values() {
        return (JSPingCheckSource[]) f242905a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static JSPingCheckSource valueOf(String r100) {
        return (JSPingCheckSource) a.a(JSPingCheckSource.class, r100);
    }

    public JSPingCheckSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
