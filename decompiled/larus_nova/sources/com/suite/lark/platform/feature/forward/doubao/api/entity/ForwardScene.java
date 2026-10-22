package com.suite.lark.platform.feature.forward.doubao.api.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardScene;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CHAT", "forward-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForwardScene extends Enum<ForwardScene> {
    public static final ForwardScene CHAT = null;
    public static final ForwardScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForwardScene[] f461279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f461280b = null;

    public static EnumEntries<ForwardScene> getEntries() {
        return f461280b;
    }

    static {
        ForwardScene r100 = new ForwardScene("UNKNOWN", 0);
        UNKNOWN = r100;
        ForwardScene r101 = new ForwardScene("CHAT", 1);
        CHAT = r101;
        ForwardScene[] r102 = {r100, r101};
        f461279a = r102;
        f461280b = EnumEntriesKt.enumEntries(r102);
    }

    public static ForwardScene[] values() {
        return (ForwardScene[]) f461279a.clone();
    }

    public static ForwardScene valueOf(String r100) {
        return (ForwardScene) a.a(ForwardScene.class, r100);
    }

    public ForwardScene(String r100, int r101) {
        super(r100, r101);
    }
}
