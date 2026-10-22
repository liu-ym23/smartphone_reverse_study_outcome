package com.bytedance.ee.bear.bitable;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/BitableAsyncRequestBiz;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Card", "Toolbar", "Stage", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableAsyncRequestBiz extends Enum<BitableAsyncRequestBiz> {
    public static final BitableAsyncRequestBiz Card = null;
    public static final a Companion = null;
    public static final BitableAsyncRequestBiz Stage = null;
    public static final BitableAsyncRequestBiz Toolbar = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableAsyncRequestBiz[] f206700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206701b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BitableAsyncRequestBiz> getEntries() {
        return f206701b;
    }

    static {
        BitableAsyncRequestBiz r100 = new BitableAsyncRequestBiz("Card", 0, "Card");
        Card = r100;
        BitableAsyncRequestBiz r101 = new BitableAsyncRequestBiz("Toolbar", 1, "Toolbar");
        Toolbar = r101;
        BitableAsyncRequestBiz r102 = new BitableAsyncRequestBiz("Stage", 2, "Stage");
        Stage = r102;
        BitableAsyncRequestBiz[] r103 = {r100, r101, r102};
        f206700a = r103;
        f206701b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static BitableAsyncRequestBiz[] values() {
        return (BitableAsyncRequestBiz[]) f206700a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BitableAsyncRequestBiz lookup(String r100) {
        Companion.getClass();
        BitableAsyncRequestBiz[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        BitableAsyncRequestBiz r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
        r103 = r103 + 1;
    L9:
        if (r104 == null) goto L11;
        return r104;
    L11:
        return Card;
    L8:
        r104 = null;
        goto L9
    }

    public static BitableAsyncRequestBiz valueOf(String r100) {
        return (BitableAsyncRequestBiz) r27.a.a(BitableAsyncRequestBiz.class, r100);
    }

    public BitableAsyncRequestBiz(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
