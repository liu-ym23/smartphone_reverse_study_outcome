package com.ss.bytertc.engine.data;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MediaPlayerCustomSourceSeekWhence extends Enum<MediaPlayerCustomSourceSeekWhence> {
    private static final /* synthetic */ MediaPlayerCustomSourceSeekWhence[] $VALUES = null;
    public static final MediaPlayerCustomSourceSeekWhence CUR = null;
    public static final MediaPlayerCustomSourceSeekWhence END = null;
    public static final MediaPlayerCustomSourceSeekWhence SET = null;
    public static final MediaPlayerCustomSourceSeekWhence SIZE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.MediaPlayerCustomSourceSeekWhence$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence = null;

        static {
            int[] r100 = new int[MediaPlayerCustomSourceSeekWhence.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence = r100;
            r100[MediaPlayerCustomSourceSeekWhence.SET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence[MediaPlayerCustomSourceSeekWhence.CUR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence[MediaPlayerCustomSourceSeekWhence.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence[MediaPlayerCustomSourceSeekWhence.SIZE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        MediaPlayerCustomSourceSeekWhence r100 = new MediaPlayerCustomSourceSeekWhence("SET", 0, 0);
        SET = r100;
        MediaPlayerCustomSourceSeekWhence r101 = new MediaPlayerCustomSourceSeekWhence("CUR", 1, 1);
        CUR = r101;
        MediaPlayerCustomSourceSeekWhence r102 = new MediaPlayerCustomSourceSeekWhence(GXAnimation.STATE_END, 2, 2);
        END = r102;
        MediaPlayerCustomSourceSeekWhence r103 = new MediaPlayerCustomSourceSeekWhence("SIZE", 3, 3);
        SIZE = r103;
        $VALUES = new MediaPlayerCustomSourceSeekWhence[]{r100, r101, r102, r103};
    }

    public static MediaPlayerCustomSourceSeekWhence[] values() {
        return (MediaPlayerCustomSourceSeekWhence[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence[ordinal()];
        if (r100 != 1) goto L5;
        return "SET";
    L5:
        if (r100 != 2) goto L7;
        return "CUR";
    L7:
        if (r100 != 3) goto L9;
        return GXAnimation.STATE_END;
    L9:
        if (r100 == 4) goto L11;
        return "";
    L11:
        return "SIZE";
    }

    public int value() {
        return this.value;
    }

    public static MediaPlayerCustomSourceSeekWhence fromId(int r100) {
        MediaPlayerCustomSourceSeekWhence[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        MediaPlayerCustomSourceSeekWhence r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static MediaPlayerCustomSourceSeekWhence valueOf(String r100) {
        return (MediaPlayerCustomSourceSeekWhence) a.a(MediaPlayerCustomSourceSeekWhence.class, r100);
    }

    private MediaPlayerCustomSourceSeekWhence(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
