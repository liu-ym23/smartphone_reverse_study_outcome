package com.bytedance.lark.office_sdk_im_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/SupportFeedType;", "", "(Ljava/lang/String;I)V", "into", "Loffice_sdk_im/proto/SupportFeedType;", "intoInt", "", "DoubaoCustom", "Companion", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum SupportFeedType extends Enum<SupportFeedType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SupportFeedType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final SupportFeedType DoubaoCustom = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/SupportFeedType$Companion;", "", "()V", "fromInt", "Lcom/bytedance/lark/office_sdk_im_android/SupportFeedType;", "value", "", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final SupportFeedType fromInt(int r100) {
            if (r100 != 0) goto L6;
            return SupportFeedType.DoubaoCustom;
        L6:
            throw new RuntimeException("Unmatched primitive enum value: SupportFeedType with ");
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[SupportFeedType.values().length];
            r100[SupportFeedType.DoubaoCustom.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ SupportFeedType[] $values() {
        return new SupportFeedType[]{DoubaoCustom};
    }

    @JvmStatic
    public static final SupportFeedType fromInt(int r100) {
        return Companion.fromInt(r100);
    }

    public static EnumEntries<SupportFeedType> getEntries() {
        return $ENTRIES;
    }

    public static SupportFeedType valueOf(String r100) {
        return (SupportFeedType) a.a(SupportFeedType.class, r100);
    }

    public static SupportFeedType[] values() {
        return (SupportFeedType[]) $VALUES.clone();
    }

    static {
        DoubaoCustom = new SupportFeedType("DoubaoCustom", 0);
        SupportFeedType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public final office_sdk_im.proto.SupportFeedType into() {
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] != 1) goto L7;
        return office_sdk_im.proto.SupportFeedType.VAR_SUPPORT_FEED_TYPE_DOUBAO_CUSTOM;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final int intoInt() {
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] != 1) goto L7;
        return 0;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    private SupportFeedType(String r100, int r101) {
        super(r100, r101);
    }
}
