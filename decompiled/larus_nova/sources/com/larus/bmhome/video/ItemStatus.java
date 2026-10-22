package com.larus.bmhome.video;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/video/ItemStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", EffectConstants.NORMAL, "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemStatus extends Enum<ItemStatus> {
    public static final a Companion = null;
    public static final ItemStatus NORMAL = null;
    public static final ItemStatus UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ItemStatus[] f315173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315174b = null;
    private final int value;

    public static EnumEntries<ItemStatus> getEntries() {
        return f315174b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.video.ItemStatus$a] */
    static {
        ItemStatus r100 = new ItemStatus("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        ItemStatus r101 = new ItemStatus(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        ItemStatus[] r102 = {r100, r101};
        f315173a = r102;
        f315174b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ItemStatus[] values() {
        return (ItemStatus[]) f315173a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ItemStatus valueOf(String r100) {
        return (ItemStatus) r27.a.a(ItemStatus.class, r100);
    }

    public ItemStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
