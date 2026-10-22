package com.bytedance.ee.bear.bitable.jsapi.report.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/report/common/EventBiz;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FORMS", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EventBiz extends Enum<EventBiz> {
    public static final EventBiz FORMS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventBiz[] f214437a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214438b = null;
    private final String value;

    public static EnumEntries<EventBiz> getEntries() {
        return f214438b;
    }

    static {
        EventBiz r100 = new EventBiz();
        FORMS = r100;
        EventBiz[] r101 = {r100};
        f214437a = r101;
        f214438b = EnumEntriesKt.enumEntries(r101);
    }

    public EventBiz() {
        super("FORMS", 0);
        this.value = "forms";
    }

    public static EventBiz[] values() {
        return (EventBiz[]) f214437a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static EventBiz valueOf(String r100) {
        return (EventBiz) a.a(EventBiz.class, r100);
    }
}
