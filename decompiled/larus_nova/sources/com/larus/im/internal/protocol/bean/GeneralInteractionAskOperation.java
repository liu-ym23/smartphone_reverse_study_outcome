package com.larus.im.internal.protocol.bean;

import af9.m0;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/protocol/bean/GeneralInteractionAskOperation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNSPECIFIED", "UPSERT", "HIDE", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum GeneralInteractionAskOperation extends Enum<GeneralInteractionAskOperation> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ GeneralInteractionAskOperation[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("2")
    public static final GeneralInteractionAskOperation HIDE = null;

    @SerialName("0")
    public static final GeneralInteractionAskOperation UNSPECIFIED = null;

    @SerialName("1")
    public static final GeneralInteractionAskOperation UPSERT = null;
    public final int value;

    public static final class a {
        public a() {
        }

        public final d<GeneralInteractionAskOperation> serializer() {
            return (d) GeneralInteractionAskOperation.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    private static final /* synthetic */ GeneralInteractionAskOperation[] $values() {
        return new GeneralInteractionAskOperation[]{UNSPECIFIED, UPSERT, HIDE};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<GeneralInteractionAskOperation> getEntries() {
        return $ENTRIES;
    }

    static {
        UNSPECIFIED = new GeneralInteractionAskOperation("UNSPECIFIED", 0, 0);
        UPSERT = new GeneralInteractionAskOperation("UPSERT", 1, 1);
        HIDE = new GeneralInteractionAskOperation("HIDE", 2, 2);
        GeneralInteractionAskOperation[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new m0());
    }

    public static GeneralInteractionAskOperation[] values() {
        return (GeneralInteractionAskOperation[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.GeneralInteractionAskOperation", values(), new String[]{"0", "1", "2"}, new Annotation[][]{null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static GeneralInteractionAskOperation valueOf(String r100) {
        return (GeneralInteractionAskOperation) r27.a.a(GeneralInteractionAskOperation.class, r100);
    }

    private GeneralInteractionAskOperation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
