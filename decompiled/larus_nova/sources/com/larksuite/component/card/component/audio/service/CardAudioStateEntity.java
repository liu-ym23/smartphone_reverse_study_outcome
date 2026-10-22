package com.larksuite.component.card.component.audio.service;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity;", "Ljava/io/Serializable;", "state", "Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;", "position", "", "duration", "<init>", "(Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;II)V", "getState", "()Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;", "setState", "(Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;)V", "getPosition", "()I", "setPosition", "(I)V", "getDuration", "setDuration", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CardAudioStateEnum", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardAudioStateEntity implements Serializable {
    private int duration;
    private int position;
    private CardAudioStateEnum state;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;", "", "value", "", "isLocalState", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getValue", "()Ljava/lang/String;", "()Z", "STOPPED", "PREPARING", "PLAYING", "PAUSED", "ERROR", "STARTING", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CardAudioStateEnum extends Enum<CardAudioStateEnum> {
        public static final CardAudioStateEnum ERROR = null;
        public static final CardAudioStateEnum PAUSED = null;
        public static final CardAudioStateEnum PLAYING = null;
        public static final CardAudioStateEnum PREPARING = null;
        public static final CardAudioStateEnum STARTING = null;
        public static final CardAudioStateEnum STOPPED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardAudioStateEnum[] f283299a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283300b = null;
        private final boolean isLocalState;
        private final String value;

        public static EnumEntries<CardAudioStateEnum> getEntries() {
            return f283300b;
        }

        static {
            CardAudioStateEnum r100 = new CardAudioStateEnum("STOPPED", 0, "stopped", false, 2, null);
            STOPPED = r100;
            boolean r110 = false;
            int r111 = 2;
            DefaultConstructorMarker r112 = null;
            CardAudioStateEnum r101 = new CardAudioStateEnum("PREPARING", 1, "preparing", r110, r111, r112);
            PREPARING = r101;
            boolean r113 = false;
            int r210 = 2;
            DefaultConstructorMarker r211 = null;
            CardAudioStateEnum r102 = new CardAudioStateEnum("PLAYING", 2, "playing", r113, r210, r211);
            PLAYING = r102;
            CardAudioStateEnum r103 = new CardAudioStateEnum("PAUSED", 3, "paused", r110, r111, r112);
            PAUSED = r103;
            CardAudioStateEnum r104 = new CardAudioStateEnum("ERROR", 4, "error", r113, r210, r211);
            ERROR = r104;
            CardAudioStateEnum r105 = new CardAudioStateEnum("STARTING", 5, "starting", true);
            STARTING = r105;
            CardAudioStateEnum[] r106 = {r100, r101, r102, r103, r104, r105};
            f283299a = r106;
            f283300b = EnumEntriesKt.enumEntries(r106);
        }

        public static CardAudioStateEnum[] values() {
            return (CardAudioStateEnum[]) f283299a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public final boolean isLocalState() {
            return this.isLocalState;
        }

        public static CardAudioStateEnum valueOf(String r100) {
            return (CardAudioStateEnum) r27.a.a(CardAudioStateEnum.class, r100);
        }

        public CardAudioStateEnum(String r100, int r101, String r102, boolean r103) {
            super(r100, r101);
            this.value = r102;
            this.isLocalState = r103;
        }

        public /* synthetic */ CardAudioStateEnum(String r100, int r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 2) == 0) goto L5;
            r103 = false;
        L5:
            this(r100, r101, r102, r103);
        }
    }

    public CardAudioStateEntity() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ CardAudioStateEntity copy$default(CardAudioStateEntity r100, CardAudioStateEnum r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.state;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.position;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.duration;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final CardAudioStateEnum component1() {
        return this.state;
    }

    public final int component2() {
        return this.position;
    }

    public final int component3() {
        return this.duration;
    }

    public final CardAudioStateEntity copy(CardAudioStateEnum r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return new CardAudioStateEntity(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CardAudioStateEntity) == true) goto L8;
        return false;
    L8:
        CardAudioStateEntity r101 = (CardAudioStateEntity) r100;
        if (this.state == r101.state) goto L12;
        return false;
    L12:
        if (this.position == r101.position) goto L15;
        return false;
    L15:
        if (this.duration == r101.duration) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.state.hashCode() * 31) + this.position) * 31) + this.duration;
    }

    public String toString() {
        return "CardAudioStateEntity(state=" + this.state + ", position=" + this.position + ", duration=" + this.duration + ')';
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getPosition() {
        return this.position;
    }

    public final CardAudioStateEnum getState() {
        return this.state;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setState(CardAudioStateEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.state = r100;
    }

    public CardAudioStateEntity(CardAudioStateEnum r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.state = r100;
        this.position = r101;
        this.duration = r102;
    }

    public /* synthetic */ CardAudioStateEntity(CardAudioStateEnum r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CardAudioStateEnum.STOPPED;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
