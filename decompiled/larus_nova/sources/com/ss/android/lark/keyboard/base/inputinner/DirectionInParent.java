package com.ss.android.lark.keyboard.base.inputinner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/base/inputinner/DirectionInParent;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DirectionInParent extends Enum<DirectionInParent> {
    public static final DirectionInParent BOTTOM = null;
    public static final DirectionInParent TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DirectionInParent[] f428234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428235b = null;

    public static EnumEntries<DirectionInParent> getEntries() {
        return f428235b;
    }

    static {
        DirectionInParent r100 = new DirectionInParent("TOP", 0);
        TOP = r100;
        DirectionInParent r101 = new DirectionInParent("BOTTOM", 1);
        BOTTOM = r101;
        DirectionInParent[] r102 = {r100, r101};
        f428234a = r102;
        f428235b = EnumEntriesKt.enumEntries(r102);
    }

    public static DirectionInParent[] values() {
        return (DirectionInParent[]) f428234a.clone();
    }

    public static DirectionInParent valueOf(String r100) {
        return (DirectionInParent) a.a(DirectionInParent.class, r100);
    }

    public DirectionInParent(String r100, int r101) {
        super(r100, r101);
    }
}
