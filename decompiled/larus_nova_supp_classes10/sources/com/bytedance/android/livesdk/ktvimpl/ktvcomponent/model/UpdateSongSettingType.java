package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/UpdateSongSettingType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "AUDIENCE_ADD_SONG", "AUDIENCE_MULTI_CHORUS", "HIDE_LYRICS_SUBTITLE_OPEN", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UpdateSongSettingType extends Enum<UpdateSongSettingType> {
    public static final UpdateSongSettingType AUDIENCE_ADD_SONG = null;
    public static final UpdateSongSettingType AUDIENCE_MULTI_CHORUS = null;
    public static final UpdateSongSettingType HIDE_LYRICS_SUBTITLE_OPEN = null;
    public static final UpdateSongSettingType UNKNOWN = null;
    public static final /* synthetic */ UpdateSongSettingType[] a = null;
    private final int value;

    static {
        UpdateSongSettingType r1 = new UpdateSongSettingType("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        UpdateSongSettingType r2 = new UpdateSongSettingType("AUDIENCE_ADD_SONG", 1, 1);
        AUDIENCE_ADD_SONG = r2;
        UpdateSongSettingType r3 = new UpdateSongSettingType("AUDIENCE_MULTI_CHORUS", 2, 2);
        AUDIENCE_MULTI_CHORUS = r3;
        UpdateSongSettingType r4 = new UpdateSongSettingType("HIDE_LYRICS_SUBTITLE_OPEN", 3, 3);
        HIDE_LYRICS_SUBTITLE_OPEN = r4;
        a = new UpdateSongSettingType[]{r1, r2, r3, r4};
    }

    public static UpdateSongSettingType valueOf(String r1) {
        return (UpdateSongSettingType) r27.a.a(UpdateSongSettingType.class, r1);
    }

    public static UpdateSongSettingType[] values() {
        return (UpdateSongSettingType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UpdateSongSettingType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
