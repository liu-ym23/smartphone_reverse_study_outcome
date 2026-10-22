package com.larus.setting.impl.thirdpartyaccount.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/setting/impl/thirdpartyaccount/data/ThirdPartyAccountScene;", "", "scene", "", "<init>", "(Ljava/lang/String;II)V", "getScene", "()I", "MusicScene", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThirdPartyAccountScene extends Enum<ThirdPartyAccountScene> {
    public static final ThirdPartyAccountScene MusicScene = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThirdPartyAccountScene[] f368458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f368459b = null;
    private final int scene;

    public static EnumEntries<ThirdPartyAccountScene> getEntries() {
        return f368459b;
    }

    static {
        ThirdPartyAccountScene r100 = new ThirdPartyAccountScene();
        MusicScene = r100;
        ThirdPartyAccountScene[] r101 = {r100};
        f368458a = r101;
        f368459b = EnumEntriesKt.enumEntries(r101);
    }

    public ThirdPartyAccountScene() {
        super("MusicScene", 0);
        this.scene = 1;
    }

    public static ThirdPartyAccountScene[] values() {
        return (ThirdPartyAccountScene[]) f368458a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public static ThirdPartyAccountScene valueOf(String r100) {
        return (ThirdPartyAccountScene) a.a(ThirdPartyAccountScene.class, r100);
    }
}
