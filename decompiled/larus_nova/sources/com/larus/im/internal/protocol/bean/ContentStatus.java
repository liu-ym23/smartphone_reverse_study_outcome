package com.larus.im.internal.protocol.bean;

import af9.p;
import com.bytedance.bdlocation.exception.BDLocationException;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0081\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/protocol/bean/ContentStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "CONTENT_STATUS_NORMAL", "CONTENT_STATUS_UPDATED", "CONTENT_STATUS_CONTENT_IN_STREAMING", "CONTENT_STATUS_SEARCHING", "CONTENT_STATUS_CONTENT_FINISH_SUG_QUESTION_IN_STREAMING", "CONTENT_STATUS_INTERRUPT", "CONTENT_STATUS_FAILED", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ContentStatus extends Enum<ContentStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ContentStatus[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName(BDLocationException.ERROR_TMAP_CLIENT)
    public static final ContentStatus CONTENT_STATUS_CONTENT_FINISH_SUG_QUESTION_IN_STREAMING = null;

    @SerialName("100")
    public static final ContentStatus CONTENT_STATUS_CONTENT_IN_STREAMING = null;

    @SerialName("500")
    public static final ContentStatus CONTENT_STATUS_FAILED = null;

    @SerialName(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO)
    public static final ContentStatus CONTENT_STATUS_INTERRUPT = null;

    @SerialName("0")
    public static final ContentStatus CONTENT_STATUS_NORMAL = null;

    @SerialName("101")
    public static final ContentStatus CONTENT_STATUS_SEARCHING = null;

    @SerialName("1")
    public static final ContentStatus CONTENT_STATUS_UPDATED = null;
    public static final a Companion = null;
    public final int value;

    private static final /* synthetic */ ContentStatus[] $values() {
        return new ContentStatus[]{CONTENT_STATUS_NORMAL, CONTENT_STATUS_UPDATED, CONTENT_STATUS_CONTENT_IN_STREAMING, CONTENT_STATUS_SEARCHING, CONTENT_STATUS_CONTENT_FINISH_SUG_QUESTION_IN_STREAMING, CONTENT_STATUS_INTERRUPT, CONTENT_STATUS_FAILED};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<ContentStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.im.internal.protocol.bean.ContentStatus$a] */
    static {
        CONTENT_STATUS_NORMAL = new ContentStatus("CONTENT_STATUS_NORMAL", 0, 0);
        CONTENT_STATUS_UPDATED = new ContentStatus("CONTENT_STATUS_UPDATED", 1, 1);
        CONTENT_STATUS_CONTENT_IN_STREAMING = new ContentStatus("CONTENT_STATUS_CONTENT_IN_STREAMING", 2, 100);
        CONTENT_STATUS_SEARCHING = new ContentStatus("CONTENT_STATUS_SEARCHING", 3, 101);
        CONTENT_STATUS_CONTENT_FINISH_SUG_QUESTION_IN_STREAMING = new ContentStatus("CONTENT_STATUS_CONTENT_FINISH_SUG_QUESTION_IN_STREAMING", 4, 110);
        CONTENT_STATUS_INTERRUPT = new ContentStatus("CONTENT_STATUS_INTERRUPT", 5, 120);
        CONTENT_STATUS_FAILED = new ContentStatus("CONTENT_STATUS_FAILED", 6, 500);
        ContentStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new p());
    }

    public static ContentStatus[] values() {
        return (ContentStatus[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.ContentStatus", values(), new String[]{"0", "1", "100", "101", BDLocationException.ERROR_TMAP_CLIENT, BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO, "500"}, new Annotation[][]{null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static ContentStatus valueOf(String r100) {
        return (ContentStatus) r27.a.a(ContentStatus.class, r100);
    }

    private ContentStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
