package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PublishStateChangeReason extends Enum<PublishStateChangeReason> {
    private static final /* synthetic */ PublishStateChangeReason[] $VALUES = null;
    public static final PublishStateChangeReason MULTIROOM_UNPUBLISH_FAILED = null;
    public static final PublishStateChangeReason NO_PUBLISH_PERMISSION = null;
    public static final PublishStateChangeReason OVER_STREAM_PUBLISH_LIMIT = null;
    public static final PublishStateChangeReason PUBLISH = null;
    public static final PublishStateChangeReason PUBLISH_STREAM_FAILED = null;
    public static final PublishStateChangeReason PUBLISH_STREAM_FORBIDEN = null;
    public static final PublishStateChangeReason UNPUBLISH = null;
    public static final PublishStateChangeReason USER_IN_PUBLISH = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.PublishStateChangeReason$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason = null;

        static {
            int[] r100 = new int[PublishStateChangeReason.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason = r100;
            r100[PublishStateChangeReason.PUBLISH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason[PublishStateChangeReason.UNPUBLISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason[PublishStateChangeReason.NO_PUBLISH_PERMISSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason[PublishStateChangeReason.OVER_STREAM_PUBLISH_LIMIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason[PublishStateChangeReason.MULTIROOM_UNPUBLISH_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason[PublishStateChangeReason.PUBLISH_STREAM_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason[PublishStateChangeReason.PUBLISH_STREAM_FORBIDEN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason[PublishStateChangeReason.USER_IN_PUBLISH.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        PublishStateChangeReason r100 = new PublishStateChangeReason("PUBLISH", 0, 0);
        PUBLISH = r100;
        PublishStateChangeReason r101 = new PublishStateChangeReason("UNPUBLISH", 1, 1);
        UNPUBLISH = r101;
        PublishStateChangeReason r102 = new PublishStateChangeReason("NO_PUBLISH_PERMISSION", 2, 2);
        NO_PUBLISH_PERMISSION = r102;
        PublishStateChangeReason r103 = new PublishStateChangeReason("OVER_STREAM_PUBLISH_LIMIT", 3, 3);
        OVER_STREAM_PUBLISH_LIMIT = r103;
        PublishStateChangeReason r104 = new PublishStateChangeReason("MULTIROOM_UNPUBLISH_FAILED", 4, 4);
        MULTIROOM_UNPUBLISH_FAILED = r104;
        PublishStateChangeReason r105 = new PublishStateChangeReason("PUBLISH_STREAM_FAILED", 5, 5);
        PUBLISH_STREAM_FAILED = r105;
        PublishStateChangeReason r110 = new PublishStateChangeReason("PUBLISH_STREAM_FORBIDEN", 6, 6);
        PUBLISH_STREAM_FORBIDEN = r110;
        PublishStateChangeReason r111 = new PublishStateChangeReason("USER_IN_PUBLISH", 7, 7);
        USER_IN_PUBLISH = r111;
        $VALUES = new PublishStateChangeReason[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static PublishStateChangeReason[] values() {
        return (PublishStateChangeReason[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$PublishStateChangeReason[ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kPublishStateChangeReasonUserInPublish";
    L6:
        return "kPublishStateChangeReasonPublishStreamForbidden";
    L7:
        return "kPublishStateChangeReasonPublishStreamFailed";
    L8:
        return "kPublishStateChangeReasonMultiRoomUnpublishFailed";
    L9:
        return "kPublishStateChangeReasonOverStreamPublishLimit";
    L10:
        return "kPublishStateChangeReasonNoPublishPermission";
    L11:
        return "kPublishStateChangeReasonUnpublish";
    L12:
        return "kPublishStateChangeReasonPublish";
    }

    public int value() {
        return this.value;
    }

    public static PublishStateChangeReason fromId(int r100) {
        PublishStateChangeReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        PublishStateChangeReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static PublishStateChangeReason valueOf(String r100) {
        return (PublishStateChangeReason) a.a(PublishStateChangeReason.class, r100);
    }

    private PublishStateChangeReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
