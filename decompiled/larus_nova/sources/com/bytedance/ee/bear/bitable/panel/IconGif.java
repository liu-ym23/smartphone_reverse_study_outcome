package com.bytedance.ee.bear.bitable.panel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/IconGif;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Loading", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IconGif extends Enum<IconGif> {
    public static final IconGif Loading = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconGif[] f214834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214835b = null;
    private final int value;

    public static EnumEntries<IconGif> getEntries() {
        return f214835b;
    }

    static {
        IconGif r100 = new IconGif();
        Loading = r100;
        IconGif[] r101 = {r100};
        f214834a = r101;
        f214835b = EnumEntriesKt.enumEntries(r101);
    }

    public IconGif() {
        super("Loading", 0);
        this.value = 1;
    }

    public static IconGif[] values() {
        return (IconGif[]) f214834a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static IconGif valueOf(String r100) {
        return (IconGif) r27.a.a(IconGif.class, r100);
    }
}
