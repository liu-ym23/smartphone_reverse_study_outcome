package com.larus.im.internal.protocol.bean;

import af9.k0;
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

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0081\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/protocol/bean/FieldEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "FieldEnum_Unknown", "FieldEnum_Content", "FieldEnum_Ext", "FieldEnum_SuggestQuestion", "FieldEnum_SuggestQuestionV2", "FieldEnum_DROP", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum FieldEnum extends Enum<FieldEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FieldEnum[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("1")
    public static final FieldEnum FieldEnum_Content = null;

    @SerialName("5")
    public static final FieldEnum FieldEnum_DROP = null;

    @SerialName("2")
    public static final FieldEnum FieldEnum_Ext = null;

    @SerialName("3")
    public static final FieldEnum FieldEnum_SuggestQuestion = null;

    @SerialName("4")
    public static final FieldEnum FieldEnum_SuggestQuestionV2 = null;

    @SerialName("0")
    public static final FieldEnum FieldEnum_Unknown = null;
    public final int value;

    private static final /* synthetic */ FieldEnum[] $values() {
        return new FieldEnum[]{FieldEnum_Unknown, FieldEnum_Content, FieldEnum_Ext, FieldEnum_SuggestQuestion, FieldEnum_SuggestQuestionV2, FieldEnum_DROP};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<FieldEnum> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.im.internal.protocol.bean.FieldEnum$a] */
    static {
        FieldEnum_Unknown = new FieldEnum("FieldEnum_Unknown", 0, 0);
        FieldEnum_Content = new FieldEnum("FieldEnum_Content", 1, 1);
        FieldEnum_Ext = new FieldEnum("FieldEnum_Ext", 2, 2);
        FieldEnum_SuggestQuestion = new FieldEnum("FieldEnum_SuggestQuestion", 3, 3);
        FieldEnum_SuggestQuestionV2 = new FieldEnum("FieldEnum_SuggestQuestionV2", 4, 4);
        FieldEnum_DROP = new FieldEnum("FieldEnum_DROP", 5, 5);
        FieldEnum[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new k0());
    }

    public static FieldEnum[] values() {
        return (FieldEnum[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.FieldEnum", values(), new String[]{"0", "1", "2", "3", "4", "5"}, new Annotation[][]{null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static FieldEnum valueOf(String r100) {
        return (FieldEnum) r27.a.a(FieldEnum.class, r100);
    }

    private FieldEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
