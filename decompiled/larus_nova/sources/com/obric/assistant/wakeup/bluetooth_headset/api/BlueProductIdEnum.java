package com.obric.assistant.wakeup.bluetooth_headset.api;

import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueProductIdEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_UNKNOWN", "GLASS_DORA_G", "HEADSET_OLA_FRIEND", "HEADSET_HW_FREEBUDS_PRO5_1", "HEADSET_HW_FREEBUDS_PRO5_2", "HEADSET_HW_FREECLIP2", "GLASS_DORA_G2", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueProductIdEnum extends Enum<BlueProductIdEnum> {
    public static final a Companion = null;
    public static final BlueProductIdEnum GLASS_DORA_G = null;
    public static final BlueProductIdEnum GLASS_DORA_G2 = null;
    public static final BlueProductIdEnum HEADSET_HW_FREEBUDS_PRO5_1 = null;
    public static final BlueProductIdEnum HEADSET_HW_FREEBUDS_PRO5_2 = null;
    public static final BlueProductIdEnum HEADSET_HW_FREECLIP2 = null;
    public static final BlueProductIdEnum HEADSET_OLA_FRIEND = null;
    public static final BlueProductIdEnum TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlueProductIdEnum[] f394396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394397b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static BlueProductIdEnum a(int r100) {
            Iterator<BlueProductIdEnum> r101 = BlueProductIdEnum.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            BlueProductIdEnum r102 = r101.next();
            if (r102.getValue() != r100) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L4;
        L12:
            BlueProductIdEnum r104 = r102;
            if (r104 == null) goto L15;
            return r104;
        L15:
            return BlueProductIdEnum.TYPE_UNKNOWN;
        L8:
            r103 = false;
            goto L9
        L11:
            r102 = null;
            goto L12
        }
    }

    public static EnumEntries<BlueProductIdEnum> getEntries() {
        return f394397b;
    }

    static {
        BlueProductIdEnum r100 = new BlueProductIdEnum("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r100;
        BlueProductIdEnum r101 = new BlueProductIdEnum("GLASS_DORA_G", 1, 4096);
        GLASS_DORA_G = r101;
        BlueProductIdEnum r102 = new BlueProductIdEnum("HEADSET_OLA_FRIEND", 2, 1);
        HEADSET_OLA_FRIEND = r102;
        BlueProductIdEnum r103 = new BlueProductIdEnum("HEADSET_HW_FREEBUDS_PRO5_1", 3, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME);
        HEADSET_HW_FREEBUDS_PRO5_1 = r103;
        BlueProductIdEnum r104 = new BlueProductIdEnum("HEADSET_HW_FREEBUDS_PRO5_2", 4, MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD);
        HEADSET_HW_FREEBUDS_PRO5_2 = r104;
        BlueProductIdEnum r105 = new BlueProductIdEnum("HEADSET_HW_FREECLIP2", 5, 359);
        HEADSET_HW_FREECLIP2 = r105;
        BlueProductIdEnum r110 = new BlueProductIdEnum("GLASS_DORA_G2", 6, 17);
        GLASS_DORA_G2 = r110;
        BlueProductIdEnum[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f394396a = r111;
        f394397b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static BlueProductIdEnum[] values() {
        return (BlueProductIdEnum[]) f394396a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BlueProductIdEnum valueOf(String r100) {
        return (BlueProductIdEnum) r27.a.a(BlueProductIdEnum.class, r100);
    }

    public BlueProductIdEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
