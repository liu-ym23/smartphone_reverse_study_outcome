package com.bytedance.ee.bear.bitable.homepage.chart.container;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/container/JSContextTag;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TAG_FOR_JS_CONTEXT_HOME", "TAG_FOR_JS_CONTEXT_ADD", "TAG_FOR_JS_CONTEXT_FULLSCREEN", "TAG_FOR_JS_CONTEXT_PLAYGROUND", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum JSContextTag extends Enum<JSContextTag> {
    public static final JSContextTag TAG_FOR_JS_CONTEXT_ADD = null;
    public static final JSContextTag TAG_FOR_JS_CONTEXT_FULLSCREEN = null;
    public static final JSContextTag TAG_FOR_JS_CONTEXT_HOME = null;
    public static final JSContextTag TAG_FOR_JS_CONTEXT_PLAYGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JSContextTag[] f212436a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f212437b = null;
    private final String value;

    public static EnumEntries<JSContextTag> getEntries() {
        return f212437b;
    }

    static {
        JSContextTag r100 = new JSContextTag("TAG_FOR_JS_CONTEXT_HOME", 0, "LarkBitableForChartHome");
        TAG_FOR_JS_CONTEXT_HOME = r100;
        JSContextTag r101 = new JSContextTag("TAG_FOR_JS_CONTEXT_ADD", 1, "LarkBitableForChartAdd");
        TAG_FOR_JS_CONTEXT_ADD = r101;
        JSContextTag r102 = new JSContextTag("TAG_FOR_JS_CONTEXT_FULLSCREEN", 2, "LarkBitableForChartFullscreen");
        TAG_FOR_JS_CONTEXT_FULLSCREEN = r102;
        JSContextTag r103 = new JSContextTag("TAG_FOR_JS_CONTEXT_PLAYGROUND", 3, "LarkBitableForChartPlayground");
        TAG_FOR_JS_CONTEXT_PLAYGROUND = r103;
        JSContextTag[] r104 = {r100, r101, r102, r103};
        f212436a = r104;
        f212437b = EnumEntriesKt.enumEntries(r104);
    }

    public static JSContextTag[] values() {
        return (JSContextTag[]) f212436a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static JSContextTag valueOf(String r100) {
        return (JSContextTag) a.a(JSContextTag.class, r100);
    }

    public JSContextTag(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
