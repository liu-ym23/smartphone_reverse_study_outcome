package com.larus.im.internal.protocol.bean;

import af9.o;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0081\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/protocol/bean/ContentDistType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "CONTENT_DIST_TYPE_NORMAL", "CONTENT_DIST_TYPE_AWEME", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ContentDistType extends Enum<ContentDistType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContentDistType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("1")
    public static final ContentDistType CONTENT_DIST_TYPE_AWEME = null;

    @SerialName("0")
    public static final ContentDistType CONTENT_DIST_TYPE_NORMAL = null;
    public static final a Companion = null;
    public final int value;

    private static final /* synthetic */ ContentDistType[] $values() {
        return new ContentDistType[]{CONTENT_DIST_TYPE_NORMAL, CONTENT_DIST_TYPE_AWEME};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<ContentDistType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.im.internal.protocol.bean.ContentDistType$a] */
    static {
        CONTENT_DIST_TYPE_NORMAL = new ContentDistType("CONTENT_DIST_TYPE_NORMAL", 0, 0);
        CONTENT_DIST_TYPE_AWEME = new ContentDistType("CONTENT_DIST_TYPE_AWEME", 1, 1);
        ContentDistType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new o());
    }

    public static ContentDistType[] values() {
        return (ContentDistType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.ContentDistType", values(), new String[]{"0", "1"}, new Annotation[][]{null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static ContentDistType valueOf(String r100) {
        return (ContentDistType) r27.a.a(ContentDistType.class, r100);
    }

    private ContentDistType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
