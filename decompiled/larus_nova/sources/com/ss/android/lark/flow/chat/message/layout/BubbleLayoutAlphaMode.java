package com.ss.android.lark.flow.chat.message.layout;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/layout/BubbleLayoutAlphaMode;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "AVATAR_HIGHLIGHT", "EDIT_MASK", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleLayoutAlphaMode extends Enum<BubbleLayoutAlphaMode> {
    public static final BubbleLayoutAlphaMode AVATAR_HIGHLIGHT = null;
    public static final BubbleLayoutAlphaMode EDIT_MASK = null;
    public static final BubbleLayoutAlphaMode NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleLayoutAlphaMode[] f422595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f422596b = null;

    public static EnumEntries<BubbleLayoutAlphaMode> getEntries() {
        return f422596b;
    }

    static {
        BubbleLayoutAlphaMode r100 = new BubbleLayoutAlphaMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        BubbleLayoutAlphaMode r101 = new BubbleLayoutAlphaMode("AVATAR_HIGHLIGHT", 1);
        AVATAR_HIGHLIGHT = r101;
        BubbleLayoutAlphaMode r102 = new BubbleLayoutAlphaMode("EDIT_MASK", 2);
        EDIT_MASK = r102;
        BubbleLayoutAlphaMode[] r103 = {r100, r101, r102};
        f422595a = r103;
        f422596b = EnumEntriesKt.enumEntries(r103);
    }

    public static BubbleLayoutAlphaMode[] values() {
        return (BubbleLayoutAlphaMode[]) f422595a.clone();
    }

    public static BubbleLayoutAlphaMode valueOf(String r100) {
        return (BubbleLayoutAlphaMode) r27.a.a(BubbleLayoutAlphaMode.class, r100);
    }

    public BubbleLayoutAlphaMode(String r100, int r101) {
        super(r100, r101);
    }
}
