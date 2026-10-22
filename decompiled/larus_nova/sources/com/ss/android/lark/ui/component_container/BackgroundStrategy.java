package com.ss.android.lark.ui.component_container;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/ui/component_container/BackgroundStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "FORCE_SHOW", "FORCE_HIDE", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BackgroundStrategy extends Enum<BackgroundStrategy> {
    public static final a Companion = null;
    public static final BackgroundStrategy DEFAULT = null;
    public static final BackgroundStrategy FORCE_HIDE = null;
    public static final BackgroundStrategy FORCE_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundStrategy[] f444574a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444575b = null;

    public static EnumEntries<BackgroundStrategy> getEntries() {
        return f444575b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.ui.component_container.BackgroundStrategy$a] */
    static {
        BackgroundStrategy r100 = new BackgroundStrategy("DEFAULT", 0);
        DEFAULT = r100;
        BackgroundStrategy r101 = new BackgroundStrategy("FORCE_SHOW", 1);
        FORCE_SHOW = r101;
        BackgroundStrategy r102 = new BackgroundStrategy("FORCE_HIDE", 2);
        FORCE_HIDE = r102;
        BackgroundStrategy[] r103 = {r100, r101, r102};
        f444574a = r103;
        f444575b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static BackgroundStrategy[] values() {
        return (BackgroundStrategy[]) f444574a.clone();
    }

    public static BackgroundStrategy valueOf(String r100) {
        return (BackgroundStrategy) r27.a.a(BackgroundStrategy.class, r100);
    }

    public BackgroundStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
