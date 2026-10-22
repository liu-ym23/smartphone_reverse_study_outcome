package com.larus.avlink.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/model/DoraVisionBizScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "DISCOVERY", "LIVE_AI", "ENV_OBSERVE", "FPA_MEETING", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraVisionBizScene extends Enum<DoraVisionBizScene> {
    public static final a Companion = null;

    @SerialName("0")
    public static final DoraVisionBizScene DEFAULT = null;

    @SerialName("1")
    public static final DoraVisionBizScene DISCOVERY = null;

    @SerialName("3")
    public static final DoraVisionBizScene ENV_OBSERVE = null;

    @SerialName("5")
    public static final DoraVisionBizScene FPA_MEETING = null;

    @SerialName("2")
    public static final DoraVisionBizScene LIVE_AI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraVisionBizScene[] f293409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293410b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static DoraVisionBizScene a(int r100) {
            if (r100 != 5) goto L6;
            return DoraVisionBizScene.DISCOVERY;
        L6:
            if (v88.a.c(Integer.valueOf(r100)) == false) goto L9;
            return DoraVisionBizScene.LIVE_AI;
        L9:
            if (v88.a.b(Integer.valueOf(r100)) == false) goto L12;
            return DoraVisionBizScene.ENV_OBSERVE;
        L12:
            return DoraVisionBizScene.DEFAULT;
        }
    }

    public static EnumEntries<DoraVisionBizScene> getEntries() {
        return f293410b;
    }

    static {
        DoraVisionBizScene r100 = new DoraVisionBizScene("DEFAULT", 0, 0);
        DEFAULT = r100;
        DoraVisionBizScene r101 = new DoraVisionBizScene("DISCOVERY", 1, 1);
        DISCOVERY = r101;
        DoraVisionBizScene r102 = new DoraVisionBizScene("LIVE_AI", 2, 2);
        LIVE_AI = r102;
        DoraVisionBizScene r103 = new DoraVisionBizScene("ENV_OBSERVE", 3, 3);
        ENV_OBSERVE = r103;
        DoraVisionBizScene r104 = new DoraVisionBizScene("FPA_MEETING", 4, 5);
        FPA_MEETING = r104;
        DoraVisionBizScene[] r105 = {r100, r101, r102, r103, r104};
        f293409a = r105;
        f293410b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static DoraVisionBizScene[] values() {
        return (DoraVisionBizScene[]) f293409a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DoraVisionBizScene valueOf(String r100) {
        return (DoraVisionBizScene) r27.a.a(DoraVisionBizScene.class, r100);
    }

    public DoraVisionBizScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
