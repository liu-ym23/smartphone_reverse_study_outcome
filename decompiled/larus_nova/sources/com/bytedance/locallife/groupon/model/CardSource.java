package com.bytedance.locallife.groupon.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/groupon/model/CardSource;", "", "", "getType", "type", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "MIX_SORT", "AD", "RESOURCE", "INTERACTION_CARD", "INTERACTION_UNDERTAKE_CARD", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum CardSource extends Enum<CardSource> {
    public static final CardSource AD = null;
    public static final a Companion = null;
    public static final CardSource INTERACTION_CARD = null;
    public static final CardSource INTERACTION_UNDERTAKE_CARD = null;
    public static final CardSource MIX_SORT = null;
    public static final CardSource RESOURCE = null;
    public static final CardSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardSource[] f258804a = null;
    private final int type;

    public static CardSource valueOf(String r100) {
        return (CardSource) r27.a.a(CardSource.class, r100);
    }

    public static CardSource[] values() {
        return (CardSource[]) f258804a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.locallife.groupon.model.CardSource$a] */
    static {
        CardSource r100 = new CardSource("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        CardSource r101 = new CardSource("MIX_SORT", 1, 1);
        MIX_SORT = r101;
        CardSource r102 = new CardSource("AD", 2, 2);
        AD = r102;
        CardSource r103 = new CardSource("RESOURCE", 3, 3);
        RESOURCE = r103;
        CardSource r104 = new CardSource("INTERACTION_CARD", 4, 8);
        INTERACTION_CARD = r104;
        CardSource r105 = new CardSource("INTERACTION_UNDERTAKE_CARD", 5, 9);
        INTERACTION_UNDERTAKE_CARD = r105;
        f258804a = new CardSource[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public final int getType() {
        return this.type;
    }

    public static final /* synthetic */ int access$getType$p(CardSource r100) {
        return r100.type;
    }

    public CardSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
