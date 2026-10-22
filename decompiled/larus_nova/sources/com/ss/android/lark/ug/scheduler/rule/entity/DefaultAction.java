package com.ss.android.lark.ug.scheduler.rule.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/rule/entity/DefaultAction;", "", "event", "", "metaRule", "Lcom/ss/android/lark/ug/scheduler/rule/entity/MetaRule;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/ss/android/lark/ug/scheduler/rule/entity/MetaRule;)V", "getEvent", "()Ljava/lang/String;", "getMetaRule", "()Lcom/ss/android/lark/ug/scheduler/rule/entity/MetaRule;", "CLICK_COUNT", "SHOW_COUNT", "SHOW_TIME", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DefaultAction extends Enum<DefaultAction> {
    public static final DefaultAction CLICK_COUNT = null;
    public static final DefaultAction SHOW_COUNT = null;
    public static final DefaultAction SHOW_TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DefaultAction[] f444499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444500b = null;
    private final String event;
    private final MetaRule metaRule;

    public static EnumEntries<DefaultAction> getEntries() {
        return f444500b;
    }

    static {
        MetaRule r100 = MetaRule.COUNT;
        DefaultAction r101 = new DefaultAction("CLICK_COUNT", 0, "click_count", r100);
        CLICK_COUNT = r101;
        DefaultAction r102 = new DefaultAction("SHOW_COUNT", 1, "show_count", r100);
        SHOW_COUNT = r102;
        DefaultAction r103 = new DefaultAction("SHOW_TIME", 2, "show_time", MetaRule.DURATION);
        SHOW_TIME = r103;
        DefaultAction[] r104 = {r101, r102, r103};
        f444499a = r104;
        f444500b = EnumEntriesKt.enumEntries(r104);
    }

    public static DefaultAction[] values() {
        return (DefaultAction[]) f444499a.clone();
    }

    public final String getEvent() {
        return this.event;
    }

    public final MetaRule getMetaRule() {
        return this.metaRule;
    }

    public static DefaultAction valueOf(String r100) {
        return (DefaultAction) r27.a.a(DefaultAction.class, r100);
    }

    public DefaultAction(String r100, int r101, String r102, MetaRule r103) {
        super(r100, r101);
        this.event = r102;
        this.metaRule = r103;
    }
}
