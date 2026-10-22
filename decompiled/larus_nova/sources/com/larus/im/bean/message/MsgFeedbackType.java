package com.larus.im.bean.message;

import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import yc9.k0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/im/bean/message/MsgFeedbackType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MsgFeedbackTypeDefault", "MsgFeedbackTypeLike", "MsgFeedbackTypeDislike", "MsgFeedbackTypeBetter", "MsgFeedbackTypeAlmost", "MsgFeedbackTypeBothBad", "MsgFeedbackTypeForm", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum MsgFeedbackType extends Enum<MsgFeedbackType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MsgFeedbackType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("4")
    public static final MsgFeedbackType MsgFeedbackTypeAlmost = null;

    @SerialName("3")
    public static final MsgFeedbackType MsgFeedbackTypeBetter = null;

    @SerialName("5")
    public static final MsgFeedbackType MsgFeedbackTypeBothBad = null;

    @SerialName("0")
    public static final MsgFeedbackType MsgFeedbackTypeDefault = null;

    @SerialName("2")
    public static final MsgFeedbackType MsgFeedbackTypeDislike = null;

    @SerialName("6")
    public static final MsgFeedbackType MsgFeedbackTypeForm = null;

    @SerialName("1")
    public static final MsgFeedbackType MsgFeedbackTypeLike = null;
    public final int value;

    public static final class a {
        public a() {
        }

        public final d<MsgFeedbackType> serializer() {
            return (d) MsgFeedbackType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public static MsgFeedbackType a(int r100) {
            switch(r100) {
                case 0: goto L11;
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                default: goto L3;
            };
        L3:
            return null;
        L13:
            return MsgFeedbackType.MsgFeedbackTypeForm;
        L14:
            return MsgFeedbackType.MsgFeedbackTypeBothBad;
        L15:
            return MsgFeedbackType.MsgFeedbackTypeAlmost;
        L16:
            return MsgFeedbackType.MsgFeedbackTypeBetter;
        L17:
            return MsgFeedbackType.MsgFeedbackTypeDislike;
        L18:
            return MsgFeedbackType.MsgFeedbackTypeLike;
        L11:
            return MsgFeedbackType.MsgFeedbackTypeDefault;
        }
    }

    private static final /* synthetic */ MsgFeedbackType[] $values() {
        return new MsgFeedbackType[]{MsgFeedbackTypeDefault, MsgFeedbackTypeLike, MsgFeedbackTypeDislike, MsgFeedbackTypeBetter, MsgFeedbackTypeAlmost, MsgFeedbackTypeBothBad, MsgFeedbackTypeForm};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<MsgFeedbackType> getEntries() {
        return $ENTRIES;
    }

    static {
        MsgFeedbackTypeDefault = new MsgFeedbackType("MsgFeedbackTypeDefault", 0, 0);
        MsgFeedbackTypeLike = new MsgFeedbackType("MsgFeedbackTypeLike", 1, 1);
        MsgFeedbackTypeDislike = new MsgFeedbackType("MsgFeedbackTypeDislike", 2, 2);
        MsgFeedbackTypeBetter = new MsgFeedbackType("MsgFeedbackTypeBetter", 3, 3);
        MsgFeedbackTypeAlmost = new MsgFeedbackType("MsgFeedbackTypeAlmost", 4, 4);
        MsgFeedbackTypeBothBad = new MsgFeedbackType("MsgFeedbackTypeBothBad", 5, 5);
        MsgFeedbackTypeForm = new MsgFeedbackType("MsgFeedbackTypeForm", 6, 6);
        MsgFeedbackType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new k0());
    }

    public static MsgFeedbackType[] values() {
        return (MsgFeedbackType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.bean.message.MsgFeedbackType", values(), new String[]{"0", "1", "2", "3", "4", "5", "6"}, new Annotation[][]{null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static MsgFeedbackType valueOf(String r100) {
        return (MsgFeedbackType) r27.a.a(MsgFeedbackType.class, r100);
    }

    private MsgFeedbackType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
